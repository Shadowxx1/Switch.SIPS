package vista.polizas.financiamiento;

import controlador.personas.CuentaBancariaLookupController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.financiamiento.Financiamiento;
import modelo.entidades.polizas.financiamiento.Giro;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Nelson Moncada
 */
public class GirosAutomaticosDialog extends InternalFrame {

    private List<Giro> giros;
    private boolean ok;
    private FinanciamientoDetailFrame financiamientoDetailFrame;
    private Persona persona;

    public GirosAutomaticosDialog(Component owner, FinanciamientoDetailFrame financiamientoDetailFrame) {
        initComponents();

        this.financiamientoDetailFrame = financiamientoDetailFrame;
        this.persona = ((Financiamiento) financiamientoDetailFrame.getMainPanel().getVOModel().getValueObject()).getPagador();
        this.getRootPane().setDefaultButton(jButton2);

        CuentaBancariaLookupController loockUpControllerCuentaBancaria = new CuentaBancariaLookupController();
        loockUpControllerCuentaBancaria.setBeanVO(persona);
        loockUpControllerCuentaBancaria.addLookup2ParentLink("cuentaBancariaPersona");
        codLookupControl1.setLookupController(loockUpControllerCuentaBancaria);

//        jButton1.addActionListener(new GirosAutomaticos());
        form1.setFormController(new GirosAutomaticos());
        form1.setMode(Consts.INSERT);

        if (owner == null) {
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(((int) d.getWidth() - this.getWidth()) / 2, ((int) d.getHeight() - this.getHeight()) / 2);
        } else {
            owner.getSize();
            setLocation((owner.getWidth() - this.getWidth()) / 2 + (int) owner.getLocationOnScreen().getX(), (owner.getHeight() - this.getHeight()) / 2 + (int) owner.getLocationOnScreen().getY());
        }
        MDIFrame.add(this);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton1 = new org.openswing.swing.client.SaveButton();
        form1 = new org.openswing.swing.form.client.Form();
        jLabel1 = new javax.swing.JLabel();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        jLabel2 = new javax.swing.JLabel();
        currencyControl1 = new org.openswing.swing.client.CurrencyControl();
        jLabel3 = new javax.swing.JLabel();
        dateControl1 = new org.openswing.swing.client.DateControl();
        checkBoxControl1 = new org.openswing.swing.client.CheckBoxControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Giros");

        form1.setVOClassName(GiroAutomatico.class.getName());
        form1.setSaveButton(saveButton1);

        jLabel1.setText("Nº Giros");

        numericControl1.setAttributeName("numGiros");
        numericControl1.setMaxValue(30.0);
        numericControl1.setRequired(true);

        jLabel2.setText("Monto");

        currencyControl1.setAttributeName("montoGiro");
        currencyControl1.setDecimals(2);
        currencyControl1.setMinValue(1.0);
        currencyControl1.setRequired(true);

        jLabel3.setText("Fecha");
        jLabel3.setToolTipText("Fecha de vencimiento del primer giro");

        dateControl1.setAttributeName("fechaPrimerGiro");
        dateControl1.setRequired(true);

        checkBoxControl1.setText("domiciliado");
        checkBoxControl1.setAttributeName("domiciliado");
        checkBoxControl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxControl1ActionPerformed(evt);
            }
        });

        codLookupControl1.setAttributeName("cuentaBancariaPersona.numero");
        codLookupControl1.setEnabled(false);
        codLookupControl1.setEnabledOnEdit(false);
        codLookupControl1.setEnabledOnInsert(false);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );

        form1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        form1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {currencyControl1, dateControl1, jLabel1, jLabel2, jLabel3});

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check1.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        form1.getSaveButton().doClick();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void checkBoxControl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxControl1ActionPerformed
        codLookupControl1.setEnabled(checkBoxControl1.isSelected());
    }//GEN-LAST:event_checkBoxControl1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CheckBoxControl checkBoxControl1;
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.client.CurrencyControl currencyControl1;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.SaveButton saveButton1;
    // End of variables declaration//GEN-END:variables

    public List<Giro> getGiros() {
        return giros;
    }

    public boolean isOk() {
        return ok;
    }

    class GirosAutomaticos extends FormController {

        @Override
        public Response loadData(Class valueObjectClass) {
            return new VOResponse(null);
        }

        @Override
        public Response insertRecord(ValueObject newPersistentObject) throws Exception {
            GiroAutomatico girosAut = (GiroAutomatico) newPersistentObject;
            giros = new ArrayList<Giro>(girosAut.getNumGiros());
            for (int i = 0; i < girosAut.getNumGiros(); i++) {
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(girosAut.getFechaPrimerGiro());
                fecha.add(Calendar.MONTH, i);
                if (girosAut.getDomiciliado()) {
                    if (girosAut.getCuentaBancariaPersona() == null || girosAut.getCuentaBancariaPersona().getId() == null) {
                        giros.add(new Giro(fecha.getTime(), girosAut.getMontoGiro(), girosAut.getDomiciliado(), (i + 1), null));
                    } else {
                        giros.add(new Giro(fecha.getTime(), girosAut.getMontoGiro(), girosAut.getDomiciliado(), (i + 1), girosAut.getCuentaBancariaPersona()));
                    }
                } else {
                    giros.add(new Giro(fecha.getTime(), girosAut.getMontoGiro(), (i + 1)));
                }
            }

            try {
                ((Financiamiento) financiamientoDetailFrame.getMainPanel().getVOModel().getValueObject()).setGiros(new ArrayList<Giro>(0));
                financiamientoDetailFrame.getGridGiros().getController().insertRecords(null, new ArrayList(giros));
                financiamientoDetailFrame.getGridGiros().reloadData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            financiamientoDetailFrame.reloadGridsData();

            return new VOResponse(newPersistentObject);
        }
    }
}
