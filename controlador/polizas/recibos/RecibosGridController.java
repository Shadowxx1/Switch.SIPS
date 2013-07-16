package controlador.polizas.recibos;

import controlador.util.DefaultGridFrameController;
import java.util.ArrayList;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.polizas.recibos.maestra.Distribucion;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.bean.BeanVO;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import vista.polizas.recibos.ReciboDetailFrame;
import vista.polizas.recibos.ReciboFianzaDetailFrame;
import vista.polizas.recibos.ReciboPatrimonialDetailFrame;
import vista.polizas.recibos.ReciboPersonasDetailFrame;
import vista.polizas.recibos.ReciboVehiculosDetailFrame;

/**
 *
 * @author Nelson Moncada
 */
public class RecibosGridController extends DefaultGridFrameController {

    public RecibosGridController() {
    }

    public RecibosGridController(String gridFramePath, String detailFramePath, String claseModeloFullPath, String titulo) {
        super(gridFramePath, detailFramePath, claseModeloFullPath, titulo);
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        Recibo r = (Recibo) persistentObject;
        switch (r.getPoliza().getRamoPoliza().getRamoContable()) {
            case PERSONA:
                new ReciboPersonasDetailController(ReciboPersonasDetailFrame.class.getName(), null, (BeanVO) persistentObject, true, null, false);
                break;
            case VEHICULO:
                new ReciboVehiculosDetailController(ReciboVehiculosDetailFrame.class.getName(), null, (BeanVO) persistentObject, true, null, false);
                break;
            case FIANZA:
                new ReciboFianzasDetailController(ReciboFianzaDetailFrame.class.getName(), null, (BeanVO) persistentObject, true, null, false);
                break;
            case PATRIMONIAL:
                new ReciboPatrimonialesDetailController(ReciboPatrimonialDetailFrame.class.getName(), null, (BeanVO) persistentObject, true, null, false);
                break;
            case RAMOS_GENERALES:
                new ReciboDetailController(ReciboDetailFrame.class.getName(), null, (BeanVO) persistentObject, true, null, false);
                break;
        }
    }

    @Override
    public Response deleteRecords(ArrayList persistentObjects) throws Exception {
        Session s = null;
        try {
            boolean allOk = true;
            s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            for (Object o : persistentObjects) {
                Recibo td = (Recibo) s.get(Recibo.class, ((Recibo) o).getId());
                for (Distribucion d : td.getDistribuciones()) {
                    s.delete(d);
                }
                s.delete(td);
            }
            try {
                t.commit();
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "deleteRecords", ex);
                t.rollback();
                allOk = false;
            }
            if (allOk) {
                return new VOResponse(true);
            } else {
                return new ErrorResponse("delete.constraint.violation");
            }
        } finally {
            s.close();
        }
    }
}
