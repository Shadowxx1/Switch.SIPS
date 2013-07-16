package controlador.polizas;

import controlador.util.DefaultLookupController;
import controlador.util.DefaultLookupDataLocatorPorNombre;
import controlador.util.DefaultLookupGridController;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;
import logger.LoggerUtil;
import modelo.Dominios.RamoContable;
import modelo.Dominios.TipoRamo;
import modelo.HibernateUtil;
import modelo.entidades.polizas.dominio.RamoPoliza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class RamoLookupController extends DefaultLookupController {

    private TipoRamo tipoRamo;
    private RamoContable ramoContable;

    public RamoLookupController() {
        setLookupGridController(new DefaultLookupGridController());

        addLookup2ParentLink("nombre", "ramoPoliza.nombre");
        addLookup2ParentLink("ramoPoliza");

        setCodeSelectionWindow(GRID_FRAME);
        setOnInvalidCode(ON_INVALID_CODE_RESTORE_LAST_VALID_CODE);
        setLookupValueObjectClassName(RamoPoliza.class.getName());

        setAllColumnVisible(false);
        setVisibleColumn("nombre", true);
        setVisibleColumn("nombreCorto", true);
        setVisibleColumn("ramoContable", true);
        setVisibleColumn("tipoRamo", true);
        setPreferredWidthColumn("nombre", 230);
        setFilterableColumn("nombre", true);
        setSortableColumn("nombre", true);
        setFramePreferedSize(new Dimension(570, 400));
        setLookupDataLocator(new RamoLookupDataLocator(RamoPoliza.class.getName()));
    }

    public RamoLookupController(TipoRamo tipoRamo, RamoContable ramoContable) {
        this();
        this.tipoRamo = tipoRamo;
        this.ramoContable = ramoContable;

    }

    public void setRamoContable(RamoContable ramoContable) {
        this.ramoContable = ramoContable;
    }

    public void setTipoRamo(TipoRamo tipoRamo) {
        this.tipoRamo = tipoRamo;
    }

    class RamoLookupDataLocator extends DefaultLookupDataLocatorPorNombre {

        public RamoLookupDataLocator(String classFullName) {
            super(classFullName);
        }

        @Override
        public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType) {
            Session s = null;
            try {
                String sql = "FROM " + classFullName + " AS C ";
                boolean where = false;

                if (tipoRamo != null) {
                    sql += " WHERE C.tipoRamo='" + tipoRamo.name() + "'";
                    where = true;
                }

                if (ramoContable != null) {
                    if (where) {
                        sql += " AND C.ramoContable='" + ramoContable.name() + "'";
                    } else {
                        sql += " WHERE C.ramoContable='" + ramoContable.name() + "'";
                    }
                }

                filteredColumns.put(
                        "auditoria.activo",
                        new FilterWhereClause[]{
                            new FilterWhereClause("auditoria.activo", "=", true),
                            null
                        });

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
//        @Override
//        public Response validateCode(String code) {
//            Session s = null;
//            try {
//                String sql = "FROM " + classFullName + " C " + ""
//                        + "WHERE C.auditoria.activo=? AND C.nombreCorto=?";
//                s = HibernateUtil.getSessionFactory().openSession();
//                Transaction t = s.beginTransaction();
//                List list = s.createQuery(sql).
//                        setBoolean(0, true).
//                        setString(1, code.toUpperCase().trim()).list();
//                t.commit();
//                return new VOListResponse(list, false, list.size());
//            } catch (Exception ex) {
//                LoggerUtil.error(this.getClass(), "validateCode", ex);
//                return new ErrorResponse(ex.getMessage());
//            } finally {
//                s.close();
//            }
//        }
    }
}
