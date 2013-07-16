package vista.polizas.recibos;

import controlador.General;
import controlador.polizas.recibos.CertificadosGridInternalFrame;
import controlador.polizas.recibos.CopiarCertificadosLookupController;
import controlador.polizas.recibos.ReciboDetailController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.polizas.maestra.Poliza;
import modelo.entidades.polizas.recibos.maestra.Asegurado;
import modelo.entidades.polizas.recibos.maestra.Beneficiario;
import modelo.entidades.polizas.recibos.maestra.Certificado;
import modelo.entidades.polizas.recibos.maestra.CopiarCertificado;
import modelo.entidades.polizas.recibos.maestra.ReciboPersonas;
import modelo.util.bean.BeanVO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Nelson Moncada
 */
public class CopiarCertificadosDialog extends javax.swing.JDialog {

    private CopiarCertificado recibo;
    private ReciboPersonasDetailFrame idPoliza;

    public CopiarCertificadosDialog(ReciboPersonasDetailFrame reciboPersona, Long idPoliza) {
        super(MDIFrame.getInstance(), true);
        this.idPoliza = reciboPersona;
        initComponents();
        saveButton1.setIcon(jButton1.getIcon());
        jButton1.setVisible(false);
        this.getRootPane().setDefaultButton(saveButton1);

        CopiarCertificadosLookupController cc = new CopiarCertificadosLookupController(idPoliza);
        cc.addLookup2ParentLink("numero", "recibo.numero");
        codLookupControl1.setLookupController(cc);
        codLookupControl1.setOpenDetail("recibo", ReciboDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class, Poliza.class, Boolean.class}, new Object[]{ReciboDetailFrame.class.getName(), null, null, true, null, false}, 2);

        form1.setFormController(new CopiarCertificadosDialogController());
        form1.setMode(Consts.INSERT);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) d.getWidth() - this.getWidth()) / 2, ((int) d.getHeight() - this.getHeight()) / 2);

        pack();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        form1 = new org.openswing.swing.form.client.Form();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        saveButton1 = new org.openswing.swing.client.SaveButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Vehiculo");
        setResizable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel2.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check1.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(33, 33));

        form1.setVOClassName(CopiarCertificado.class.getName());
        form1.setSaveButton(saveButton1);

        labelControl2.setLabel("numeroRecibo");
        labelControl2.setToolTipText("Numero de Placa del Vehiculo");

        codLookupControl1.setAttributeName("recibo.numero");
        codLookupControl1.setMaxCharacters(10);
        codLookupControl1.setRequired(true);
        codLookupControl1.setToolTipText("Numero de recibo del que se copiaran certifiados");

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codLookupControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codLookupControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.SaveButton saveButton1;
    // End of variables declaration//GEN-END:variables

    class CopiarCertificadosDialogController extends FormController {

        @Override
        public Response insertRecord(ValueObject newPersistentObject) throws Exception {
            recibo = (CopiarCertificado) newPersistentObject;
            ReciboPersonas r = recibo.getRecibo();
            Session s = null;
            try {
                s = HibernateUtil.getSessionFactory().openSession();

                Query q = s.createQuery("SELECT P FROM " + Certificado.class.getName()
                        + " as P LEFT JOIN P.asegurados LEFT JOIN P.beneficiarios WHERE P.recibo.id=?").
                        setLong(0, r.getId());

                List<Certificado> certificadosCopiar = q.list();
                List<Certificado> certificadosNuevos = new ArrayList<Certificado>(0);

                AuditoriaBasica ab = new AuditoriaBasica(new Date(), General.usuario.getUserName(), true);

                for (Certificado certificado : certificadosCopiar) {
                    List<Asegurado> aseguradosNuevos = new ArrayList<Asegurado>(0);
                    List<Beneficiario> beneficiariosNuevos = new ArrayList<Beneficiario>(0);

                    Certificado c = new Certificado();
                    c.setAsegurados(aseguradosNuevos);
//                    c.setAuditoria(ab);
                    c.setBeneficiarios(beneficiariosNuevos);
                    c.setFechaExclucion(certificado.getFechaExclucion());
                    c.setFechaInclusion(certificado.getFechaInclusion());
                    c.setFechaIngreso(certificado.getFechaIngreso());
                    c.setNumero(certificado.getNumero());
                    c.setObservacion("");
                    c.setParentesco(certificado.getParentesco());
                    c.setPrima(certificado.getPrima());

                    for (Asegurado asegurado : certificado.getAsegurados()) {
                        Asegurado a = new Asegurado();
                        a.setAsegurado(asegurado.getAsegurado());
//                        a.setAuditoria(ab);
                        a.setFechaExclucion(asegurado.getFechaExclucion());
                        a.setFechaInclusion(asegurado.getFechaInclusion());
                        a.setFechaIngreso(asegurado.getFechaIngreso());
                        a.setNumero(asegurado.getNumero());
                        a.setObservacion("");
                        a.setParentesco(asegurado.getParentesco());
                        a.setPrimaAporte(asegurado.getPrimaAporte());
                        a.setPrimaAsegurado(asegurado.getPrimaAsegurado());
                        a.setPrimaTotal(asegurado.getPrimaTotal());
                        //aseguradosNuevos.add(a);
                        c.getAsegurados().add(a);
                    }

                    for (Beneficiario beneficiario : certificado.getBeneficiarios()) {
                        Beneficiario b = new Beneficiario();
//                        b.setAuditoria(ab);
                        b.setBeneficiario(beneficiario.getBeneficiario());
                        b.setFechaExclucion(beneficiario.getFechaExclucion());
                        b.setFechaInclusion(beneficiario.getFechaInclusion());
                        b.setFechaIngreso(beneficiario.getFechaIngreso());
                        b.setNumero(beneficiario.getNumero());
                        b.setObservacion("");
                        b.setParentesco(beneficiario.getParentesco());
                        b.setPorcPrima(beneficiario.getPorcPrima());
//                        beneficiariosNuevos.add(b);
                        c.getBeneficiarios().add(b);
                    }
                    
                }

                ((CertificadosGridInternalFrame) idPoliza.getGridCertificados().getController()).deleteRecords((ArrayList<Certificado>) certificadosCopiar);

                ((CertificadosGridInternalFrame) idPoliza.getGridCertificados().getController()).insertRecords(null, (ArrayList<Certificado>) certificadosNuevos);
//
//                for (Certificado certificado : certificadosNuevos) {
//                    ((AseguradosGridInternalFrame) reciboPersona.getGridAsegurados().getController())
//                            .insertRecords(null, (ArrayList<Asegurado>) certificadosNuevos);
//                }

//            for (int i = 0; i < girosAut.getNumGiros(); i++) {
//                Calendar fecha = Calendar.getInstance();
//                fecha.setTime(girosAut.getFechaPrimerGiro());
//                fecha.add(Calendar.MONTH, i);
//                if (girosAut.getDomiciliado()) {
//                    giros.add(new Giro(fecha.getTime(), girosAut.getMontoGiro(), girosAut.getDomiciliado(), (i + 1), girosAut.getCuentaBancariaPersona()));
//                } else {
//                    giros.add(new Giro(fecha.getTime(), girosAut.getMontoGiro(), (i + 1)));
//                }
//            }
//
//            try {
//                ((Financiamiento) financiamientoDetailFrame.getMainPanel().getVOModel().getValueObject()).setGiros(new ArrayList<Giro>(0));
//                financiamientoDetailFrame.getGridGiros().getController().insertRecords(null, new ArrayList(giros));
//                financiamientoDetailFrame.getGridGiros().reloadData();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }

            } catch (Exception ex) {
//                ok = false;
                ex.printStackTrace();
                return new ErrorResponse(ex.getMessage());
            } finally {
                s.close();
            }
            return null;
        }
    }
}
