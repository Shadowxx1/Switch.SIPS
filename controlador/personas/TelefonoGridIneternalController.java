package controlador.personas;

import controlador.General;
import controlador.Principal;
import controlador.sms.EnviarSMS;
import controlador.util.DefaultGridInternalController;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import logger.LoggerUtil;
import modelo.Dominios.EstatusSMS;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.personas.transac.TelefonoPersona;
import modelo.entidades.sms.SMS;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author Nelson Moncada
 */
public class TelefonoGridIneternalController extends DefaultGridInternalController {

    public TelefonoGridIneternalController(String classNameModelFullPath, String getMethodName, GridControl miGrid, ArrayList<DefaultGridInternalController> listSubGrids) {
        super(classNameModelFullPath, getMethodName, miGrid, listSubGrids);
    }

    @Override
    public void createValueObject(ValueObject valueObject) throws Exception {
        int rowToSel = miGrid.getVOListTableModel().getRowCount() - 1;
        miGrid.getVOListTableModel().setField(rowToSel, "tipoTelefono", General.defaultPersona.getTelefono());
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
                String n = "" + ((TelefonoPersona) o).getCodigoArea().getNumero() + ((TelefonoPersona) o).getNumeroS();
                ((TelefonoPersona) o).setNumeroCompleto(n);
                getSet().add(o);
                if (((TelefonoPersona) o).getNotificar() && General.empresa.getSmsBienvenida()) {
                    String msj = Principal.defaultData.smsBienvenida;
                    String prod = General.empresa.getNombre();
                    msj = msj.replaceAll(":nombre", ((Persona) beanVO).getNombreCorto());
                    msj = msj.replaceAll(":nombreLargo", ((Persona) beanVO).getNombreLargo());
                    SMS sms = new SMS(((Persona) beanVO).getNombreCorto(), prod, "0" + n, "BIENVENIDA", msj, new Date(), ab);
                    EstatusSMS estatus = EnviarSMS.enviarSMS(sms);
                    sms.setEstatus(estatus);
                    s.save(sms);
                    JOptionPane.showMessageDialog(MDIFrame.getInstance(), estatus);
                }
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
                String n = "" + ((TelefonoPersona) o).getCodigoArea().getNumero() + ((TelefonoPersona) o).getNumeroS();
                ((TelefonoPersona) o).setNumeroCompleto(n);
                s.update(o);
            }
            t.commit();
            return new VOListResponse(persistentObjects, false, persistentObjects.size());
        } catch (Exception ex) {
            return new ErrorResponse(LoggerUtil.isInvalidStateException(this.getClass(), "insertRecords", ex));
        } finally {
            s.close();
        }
    }
}
