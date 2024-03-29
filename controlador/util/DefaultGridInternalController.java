package controlador.util;

import controlador.General;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.interfaces.GridConSubGrids;
import modelo.util.bean.BeanVO;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.client.OptionPane;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 *
 * @author Nelson Moncada
 */
public class DefaultGridInternalController extends GridController implements GridDataLocator {

    protected Method getMethod;
    protected BeanVO beanVO;
    protected final ArrayList<DefaultGridInternalController> listSubGrids;
    protected final GridControl miGrid;
    protected Class t;

    public DefaultGridInternalController(String classNameModelFullPath, String getMethodName, GridControl miGrid, ArrayList<DefaultGridInternalController> listSubGrids) {
        this.miGrid = miGrid;
        this.listSubGrids = listSubGrids;
        try {
            t = Class.forName(classNameModelFullPath);
            getMethod = t.getMethod(getMethodName, new Class[0]);
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "new", ex);
        }
    }

    public void setBeanVO(BeanVO beanVO) {
        this.beanVO = beanVO;
    }

    public Collection getSet() {
        if (beanVO != null) {
            try {
                return (Collection) getMethod.invoke(beanVO);
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "getSet", ex);
            }
        }
        return null;
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

    public boolean insertRecord(BeanVO o) {
        ArrayList al = new ArrayList(0);
        al.add(o);
        try {
            Response r = insertRecords(null, al);
            if (!r.isError()) {
                miGrid.reloadData();
                return true;
            } else {
                OptionPane.showMessageDialog(
                        MDIFrame.getInstance(),
                        r.getErrorMessage(),
                        "Error Guardando",
                        JOptionPane.ERROR_MESSAGE);
            }
            return false;
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "insertRecord", ex);
            return false;
        }
    }

    @Override
    public void selectedCell(int rowNumber, int columnIndex, String attributedName, ValueObject persistentObject) {
        if (listSubGrids != null) {
            if (persistentObject instanceof GridConSubGrids && ((GridConSubGrids) persistentObject).getId() != null) {
                for (DefaultGridInternalController gridInternalController : listSubGrids) {
                    gridInternalController.setBeanVO((BeanVO) persistentObject);
                    gridInternalController.reloadData();
                }
            }
        }
    }

    public void reloadData() {
        miGrid.getReloadButton().doClick();
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
    }
}
