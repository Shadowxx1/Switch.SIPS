package controlador.vehiculos;

import controlador.General;
import controlador.Principal;
import controlador.util.DefaultDetailFrameController;
import java.util.Date;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.vehiculos.maestra.Vehiculo;
import modelo.util.bean.BeanVO;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;
import vista.vehiculos.VehiculosDetailFrame;

public class VehiculoDetailController extends DefaultDetailFrameController {

    public VehiculoDetailController(String detailFramePath, GridControl gridControl, BeanVO beanVO, Boolean aplicarLogicaNegocio) {
        this(detailFramePath, gridControl, beanVO, aplicarLogicaNegocio, null, null);
    }

    public VehiculoDetailController(String detailFramePath, GridControl gridControl, BeanVO beanVO, Boolean aplicarLogicaNegocio, Form linkForm, String attributeName) {
        super(detailFramePath, gridControl, beanVO, aplicarLogicaNegocio);
        vista.setTitle("Vehiculo: ");
        if (beanVO != null) {
            vista.setTitle(vista.getTitle() + ((Vehiculo) beanVO).getPlaca() + " " + ((Vehiculo) beanVO).getAyo());
        }
        this.linkForm = linkForm;
        this.attributeName = attributeName;
    }

    public VehiculoDetailController(GridControl gridControl, BeanVO beanVO, String placa) {
        this(gridControl, beanVO, placa, null, null);
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        Session s = null;
        try {
            vista.saveGridsData();
            //s = HibernateUtil.getSessionFactory().openSession(AuditLogInterceptor.INSTANCE2);
            s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();

            Long l = (Long) s.createQuery("SELECT count(P) FROM modelo.entidades.vehiculos.maestra.Vehiculo as P WHERE P.placa=?")
                    .setString(0, ((Vehiculo) newPersistentObject).getPlaca())
                    .uniqueResult();

            if (l > 0) {
                return new ErrorResponse("Numero de Placa ya esta registrado.");
            }

            if (newPersistentObject instanceof Auditable) {
                AuditoriaBasica ab = new AuditoriaBasica(new Date(), General.usuario.getUserName(), true);
                ((Auditable) newPersistentObject).setAuditoria(ab);
            }
            if (aplicarLogicaNegocio) {
                Response response = logicaNegocioConCambioEnVista(newPersistentObject, false);
                if (response.isError()) {
                    return response;
                }
                newPersistentObject = (ValueObject) ((VOResponse) response).getVo();
            }
            s.save(newPersistentObject);

            if (aplicarLogicaNegocio) {
                Response response = logicaNegocioDespuesSave(newPersistentObject);
                if (response.isError()) {
                    return response;
                }
                newPersistentObject = (ValueObject) ((VOResponse) response).getVo();
            }

            t.commit();

            if (linkForm != null && attributeName != null) {
                linkForm.getVOModel().setValue(attributeName, newPersistentObject);
                linkForm.pull(attributeName);
            }

            vista.setOwnerVO((BeanVO) newPersistentObject);
            beanVO = (BeanVO) newPersistentObject;
            if (gridControl != null) {
                gridControl.reloadData();
            }
            return new VOResponse(newPersistentObject);
        } catch (Exception ex) {
            return new ErrorResponse(LoggerUtil.isInvalidStateException(this.getClass(), "insertRecord", ex));
        } finally {
            s.close();
        }
    }

    public VehiculoDetailController(GridControl gridControl, BeanVO beanVO, String placa, Form linkForm, String attributeName) {
        this.gridControl = gridControl;
        this.beanVO = beanVO;
        this.aplicarLogicaNegocio = false;
        this.linkForm = linkForm;
        this.attributeName = attributeName;
        vista = new VehiculosDetailFrame();
        vista.inicializar(this, true);
        vista.setTitle("Vehiculo: ");
        if (beanVO != null) {
            vista.setTitle(vista.getTitle() + ((Vehiculo) beanVO).getPlaca() + " " + ((Vehiculo) beanVO).getAyo());
        }
        vista.getMainPanel().setMode(Consts.INSERT);
        Vehiculo v = (Vehiculo) beanVO;
        if (v.getPlaca() != null && !v.getPlaca().trim().isEmpty()) {
            vista.getMainPanel().getVOModel().setValue("placa", placa);
            vista.getMainPanel().pull("placa");
        }
        if (v.getSerialCarroceria() != null && !v.getSerialCarroceria().trim().isEmpty()) {
            vista.getMainPanel().getVOModel().setValue("serialCarroceria", v.getSerialCarroceria());
            vista.getMainPanel().pull("serialCarroceria");
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Vehiculo p = (Vehiculo) s.get(Vehiculo.class, ((Vehiculo) beanVO).getId());
        Hibernate.initialize(p.getObservaciones());
        Hibernate.initialize(p.getDocumentos());
        s.close();
        beanVO = p;
        return new VOResponse(beanVO);
    }

    @Override
    public void createPersistentObject(ValueObject PersistentObject) throws Exception {
        PersistentObject = new Vehiculo();
        ((Vehiculo) PersistentObject).setColor(Principal.defaultData.vehiculo.getColor());
        ((Vehiculo) PersistentObject).setMarcaModelo(Principal.defaultData.vehiculo.getMarcaModelo());
        ((Vehiculo) PersistentObject).setClasificacion(Principal.defaultData.vehiculo.getClasificacionVehiculo());
        vista.getMainPanel().getVOModel().setValueObject(PersistentObject);
    }
}
