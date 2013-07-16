package controlador.polizas.recibos.cobertura.mant;

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
import modelo.entidades.polizas.recibos.cobertura.CoberturasRecibo;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author Nelson Moncada
 */
public class CoberturasReciboGridInternalController extends DefaultGridInternalController {

    public CoberturasReciboGridInternalController(String classNameModelFullPath, String getMethodName, GridControl miGrid, ArrayList<DefaultGridInternalController> listSubGrids) {
        super(classNameModelFullPath, getMethodName, miGrid, listSubGrids);
    }

    @Override
    public void createValueObject(ValueObject valueObject) throws Exception {
        if (beanVO != null) {
            ((CoberturasRecibo) valueObject).setFechaDesda(((Recibo) beanVO).getVigenciaDesde());
            ((CoberturasRecibo) valueObject).setFechaHasta(((Recibo) beanVO).getVigenciaHasta());
        }
    }

    public Response loadData(int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {
        ArrayList al;
        Collection s = getSet();
        if (s != null) {
            al = new ArrayList(s);
        } else {
            al = new ArrayList(0);
        }
        return new VOListResponse(al, false, al.size());
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        List al;
//        if (beanVO != null) {
//            al = s.createQuery("FROM " + Cobertura.class.getName() + " WHERE ramo.id=:ramoId").
//                    setLong("ramoId", ((Recibo) beanVO).getPoliza().getRamoPoliza().getId()).list();
//        } else {
//            al = new ArrayList<Cobertura>(0);
//        }
//        return new VOListResponse(al, false, al.size());
    }

    @Override
    public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
        Session s = null;
        if (getSet() != null) {

            try {
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                for (Object object : newValueObjects) {
                    ValueObject o = (ValueObject) object;
                    AuditoriaBasica ab = new AuditoriaBasica(new Date(), General.usuario.getUserName(), true);
                    if (o instanceof Auditable) {
                        ((Auditable) o).setAuditoria(ab);
                    }
                    getSet().add(o);
                    //getSet().add(o);
                    ((CoberturasRecibo) o).setRecibo(((Recibo) beanVO));
                }
                //s.update(super.beanVO);
//                s.save(o);
                s.update(beanVO);
//                selectedCell(0, 0, null, o);
                t.commit();
                return new VOListResponse(newValueObjects, false, newValueObjects.size());
            } catch (Exception ex) {
                for (Object object : newValueObjects) {
                    getSet().remove(object);
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
    public Response updateRecords(int[] rowNumbers, ArrayList oldPersistentObjects, ArrayList persistentObjects) throws Exception {
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            for (Object object : persistentObjects) {
                ValueObject o = (ValueObject) object;
                //ValueObject o = (ValueObject) persistentObjects.get(0);
                if (o instanceof Auditable) {
                    AuditoriaBasica ab = ((Auditable) o).getAuditoria();
                    ab.setFechaUpdate(new Date());
                    ab.setUsuarioUpdate(General.usuario.getUserName());
                }
                s.update(o);
//                getSet().remove(oldPersistentObjects);
//                getSet().add(o);
            }
            t.commit();
            return new VOListResponse(persistentObjects, false, persistentObjects.size());
        } catch (Exception ex) {
            return new ErrorResponse(LoggerUtil.isInvalidStateException(this.getClass(), "insertRecords", ex));
        } finally {
            s.close();
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
                    s.delete(o);
                }
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
