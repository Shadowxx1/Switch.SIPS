package com.productores.caja.controlador;

import com.productores.caja.modelo.maestra.Liquidacion;
import com.productores.caja.vista.LiquidacionDetailFrame;
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
public class LiquidacionDetailController extends DefaultDetailFrameController {

    public LiquidacionDetailController(
            GridControl gridControl,
            BeanVO beanVO) {
        this.gridControl = gridControl;
        this.beanVO = beanVO;
        this.aplicarLogicaNegocio = true;
        vista = new LiquidacionDetailFrame();
        vista.inicializar(this, true);
        vista.setTitle("Liquidacion: ");
        if (beanVO != null) {
            if (((Persona) beanVO).getNombreLargo() != null) {
                vista.setTitle(vista.getTitle() + ((Liquidacion) beanVO).getCobrador().getNombreLargo());
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
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Liquidacion l = (Liquidacion) s.get(Liquidacion.class, ((Liquidacion) beanVO).getId());
        Hibernate.initialize(l.getObservaciones());
        Hibernate.initialize(l.getDocumentos());
        Hibernate.initialize(l.getRecibos());
        Hibernate.initialize(l.getMovimientos());
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
