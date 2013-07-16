package com.productores.caja.controlador;

import com.productores.caja.modelo.maestra.Asiento;
import com.productores.caja.modelo.maestra.Liquidacion;
import com.productores.caja.vista.AsientoDetailFrame;
import controlador.util.DefaultDetailFrameController;
import modelo.HibernateUtil;
import modelo.entidades.personas.maestra.Persona;
import modelo.util.bean.BeanVO;
import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Nelson Moncada
 */
public class AsientoDetailController extends DefaultDetailFrameController {
    
    public AsientoDetailController(
            GridControl gridControl,
            Persona productor,
            Liquidacion liquidacion,
            BeanVO beanVO) {
        this.gridControl = gridControl;
        this.beanVO = beanVO;
        this.aplicarLogicaNegocio = true;
        vista = new AsientoDetailFrame();
        vista.inicializar(this, true);
        vista.setTitle("Asiento: ");
        if (beanVO != null) {
            if (((Persona) beanVO).getNombreLargo() != null) {
                vista.setTitle(vista.getTitle() + (((Asiento) beanVO).getCuentaBancaria().getBanco().getNombreCorto()) + " - " + ((Asiento) beanVO).getCuentaBancaria().getNumero());
            }
        }
        if (beanVO != null) {
//            rif = ((Persona) beanVO).getRif();
//            ((PersonaDetailFrame) vista).setTipoPersonas(rif.getTipoCedula().getTipoPersona());
            vista.getMainPanel().reload();
            vista.getMainPanel().setMode(Consts.READONLY);
        } else {
//            ((PersonaDetailFrame) vista).setTipoPersonas(rif.getTipoCedula().getTipoPersona());
            vista.getMainPanel().setMode(Consts.INSERT);
        }
        if (productor != null) {
            vista.getMainPanel().getVOModel().setValue("productor", productor);
            vista.getMainPanel().pull("productor");
            ((AsientoDetailFrame)vista).getLookupCuentaBancaria().setBeanVO(productor);
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Asiento l = (Asiento) s.get(Asiento.class, ((Asiento) beanVO).getId());
        Hibernate.initialize(l.getObservaciones());
        Hibernate.initialize(l.getDocumentos());
        s.close();
        beanVO = l;
        return new VOResponse(beanVO);
    }

    @Override
    public Response logicaNegocio(ValueObject persistentObject) {

//        if (adicional != null && adicional.length > 0) {
//            Session s = null;
//            try {
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            } finally {
//                s.close();
//            }
//        }
        return new VOResponse(persistentObject);

    }
}
