/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.polizas.recibos;

import controlador.util.DefaultGridControllerWhitSQL;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.bean.BeanVO;
import org.hibernate.type.Type;
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
public class ReciboGridControllerWhitSQL extends DefaultGridControllerWhitSQL {

    public ReciboGridControllerWhitSQL(String gridFramePath, String detailFramePath, String claseModeloFullPath, String titulo, String sql, Object[] values, Type[] valueType) {
        super(gridFramePath, detailFramePath, claseModeloFullPath, titulo, sql, values, valueType);
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
}
