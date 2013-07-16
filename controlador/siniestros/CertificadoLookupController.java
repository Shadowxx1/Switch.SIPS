package controlador.siniestros;

import controlador.util.DefaultLookupController;
import controlador.util.DefaultLookupDataLocator;
import controlador.util.DefaultLookupGridController;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.polizas.recibos.maestra.Certificado;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class CertificadoLookupController extends DefaultLookupController {

    private Long idRecibo;

    public Long getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Long idRecibo) {
        this.idRecibo = idRecibo;
        ((CertificadoDataLocator)getLookupDataLocator()).setIdRecibo(idRecibo);
    }

    public CertificadoLookupController() {
        setLookupGridController(new DefaultLookupGridController());
        setLookupDataLocator(new CertificadoDataLocator(Certificado.class.getName()));
        setFramePreferedSize(new Dimension(690, 360));
        setCodeSelectionWindow(GRID_FRAME);
        setOnInvalidCode(ON_INVALID_CODE_RESTORE_FOCUS);
        setLookupValueObjectClassName(Certificado.class.getName());
        addLookup2ParentLink("certificadoRecibo");
        setMaxSortedColumns(2);
        setAllColumnVisible(false);

        setVisibleColumn("numero", true);
        setVisibleColumn("titular.nombreLargo", true);
        setVisibleColumn("fechaIngreso", true);
        setVisibleColumn("fechaInclusion", true);
        setVisibleColumn("fechaExclucion", true);
        setVisibleColumn("parentesco", true);

        setHeaderColumnName("titular.nombreLargo", "titular");

        setPreferredWidthColumn("poliza.compania.nombreCorto", 150);
        setPreferredWidthColumn("poliza.contratante.nombreLargo", 150);
        setPreferredWidthColumn("asegurado.nombreLargo", 150);

        setFilterableColumn("numero", true);
        setFilterableColumn("titular.nombreLargo", true);
        setFilterableColumn("fechaIngreso", true);
        setFilterableColumn("fechaInclusion", true);
        setFilterableColumn("fechaExclucion", true);
        setFilterableColumn("parentesco", true);

        setSortableColumn("numero", true);
        setSortableColumn("titular.nombreLargo", true);
        setSortableColumn("fechaIngreso", true);
        setSortableColumn("fechaInclusion", true);
        setSortableColumn("fechaExclucion", true);
        setSortableColumn("parentesco", true);
    }

    class CertificadoDataLocator extends DefaultLookupDataLocator {

        private Long idRecibo;

        public Long getIdRecibo() {
            return idRecibo;
        }

        public void setIdRecibo(Long idRecibo) {
            this.idRecibo = idRecibo;
        }

        public CertificadoDataLocator(String classFullName) {
            super(classFullName);
        }

        public CertificadoDataLocator(String classFullName, Long idRecibo) {
            super(classFullName);
            this.idRecibo = idRecibo;
        }

        @Override
        public Response loadData(
                int action,
                int startIndex,
                Map filteredColumns,
                ArrayList currentSortedColumns,
                ArrayList currentSortedVersusColumns,
                Class valueObjectType) {
            Session s = null;
            try {
                String sql = "FROM " + Certificado.class.getName() + " C WHERE fechaExclucion IS NULL ";
                filteredColumns.put(
                        "auditoria.activo",
                        new FilterWhereClause[]{
                            new FilterWhereClause("auditoria.activo", "=", true),
                            null
                        });

                if (idRecibo != null) {
                    filteredColumns.put(
                            "recibo.id",
                            new FilterWhereClause[]{
                                new FilterWhereClause("recibo.id", "=", idRecibo),
                                null
                            });
                }

                SessionFactory sf = HibernateUtil.getSessionFactory();
                s = sf.openSession();
                Response res = HibernateUtils.getAllFromQuery(
                        filteredColumns,
                        currentSortedColumns,
                        currentSortedVersusColumns,
                        valueObjectType,
                        sql,
                        new Object[0],
                        new Type[0],
                        "C",
                        sf,
                        s);
                return res;
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "loadData", ex);
                return new ErrorResponse(ex.getMessage());
            } finally {
                s.close();
            }
        }

        @Override
        public Response validateCode(String code) {
            Session s = null;
            try {
                String sql = "FROM " + Certificado.class.getName() + " C "
                        + "WHERE C.auditoria.activo=? AND upper(C.numero)=? ";
                if (idRecibo != null) {
                    sql += "AND C.recibo.id=?";
                }
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                List list;
                if (idRecibo != null) {
                    list = s.createQuery(sql).
                            setBoolean(0, true).
                            setString(1, code.toUpperCase().trim()).
                            setLong(2, idRecibo).
                            list();
                } else {
                    list = s.createQuery(sql).
                            setBoolean(0, true).
                            setString(1, code.toUpperCase().trim()).
                            list();
                }
                t.commit();
                return new VOListResponse(list, false, list.size());
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "validateCode", ex);
                return new ErrorResponse(ex.getMessage());
            } finally {
                s.close();
            }
        }
    }
}
