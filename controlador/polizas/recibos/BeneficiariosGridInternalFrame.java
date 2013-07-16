package controlador.polizas.recibos;

import controlador.General;
import controlador.util.DefaultGridInternalController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.polizas.recibos.maestra.Beneficiario;
import modelo.entidades.polizas.recibos.maestra.Certificado;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.type.Type;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class BeneficiariosGridInternalFrame extends DefaultGridInternalController {

    public BeneficiariosGridInternalFrame(String classNameModelFullPath, String getMethodName, GridControl miGrid, ArrayList<DefaultGridInternalController> listSubGrids) {
        super(classNameModelFullPath, getMethodName, miGrid, listSubGrids);
    }

    public Response loadData(int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {

        ArrayList al = null;
        Collection s = getSet();
        Session ss = null;

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();

            String sql = "FROM " + Beneficiario.class.getName() + " AS C ";

            if (beanVO != null && ((Certificado) beanVO).getId() != null) {
                sql += " WHERE certificado.id=" + ((Certificado) beanVO).getId();
                Response res = HibernateUtils.getBlockFromQuery(
                        action,
                        startIndex,
                        99999999,
                        filteredColumns,
                        currentSortedColumns,
                        currentSortedVersusColumns,
                        valueObjectType,
                        sql,
                        new Object[0],
                        new Type[0],
                        "C",
                        sf,
                        ss);
                al = new ArrayList(((VOListResponse) res).getRows());
            } else {
                if (s != null) {
                    al = new ArrayList(s);
                } else {
                    al = new ArrayList(0);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ss.close();
        }
        return new VOListResponse(al, false, al.size());
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        Session s = null;
        if (getSet() != null) {
            for (Object object : newValueObjects) {
                ValueObject o = (ValueObject) object;
                AuditoriaBasica ab = new AuditoriaBasica(new Date(), General.usuario.getUserName(), true);
                if (o instanceof Auditable) {
                    ((Auditable) o).setAuditoria(ab);
                }
                getSet().add(o);
            }
            try {
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                for (Object o : newValueObjects) {
                    ((Beneficiario) o).setCertificado((Certificado) beanVO);
//                    s.save(o);
                }
                s.update(beanVO);
                selectedCell(0, 0, null, (ValueObject) newValueObjects.get(0));
                t.commit();
                return new VOListResponse(newValueObjects, false, newValueObjects.size());
            } catch (Exception ex) {
                for (Object o : newValueObjects) {
                    getSet().remove(o);
                }
                return new ErrorResponse(LoggerUtil.isInvalidStateException(this.getClass(), "insertRecords", ex));
            } finally {
                s.close();
            }
        } else {
            return new ErrorResponse("Primero tienes que guardar el Registro Principal");
        }
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();

            Transaction t = s.beginTransaction();
            for (Object o : persistentObjects) {
                if (getSet() != null) {
                    getSet().remove(o);
                }
                s.delete(o);
            }
            s.update(beanVO);
            t.commit();
            return new VOResponse(true);
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "deleteRecords", ex);
            return new ErrorResponse(ex.getMessage());
        } finally {
            s.close();
        }
    }
}
