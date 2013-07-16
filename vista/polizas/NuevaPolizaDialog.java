package vista.polizas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import modelo.Dominios;
import modelo.entidades.polizas.dominio.RamoPoliza;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.java.Consts;
import vista.polizas.NumeroPolizaDialog;

/**
 *
 * @author Nelson Moncada
 */
public class NuevaPolizaDialog extends JDialog {

    private RamoPoliza ramo;
    private boolean ok;
    private boolean nuevo;
    private Form linkForm;
    private String linkAttName;

    public NuevaPolizaDialog(Form linkForm, String linkAttName) {
        super(MDIFrame.getInstance(), false);
        this.linkForm = linkForm;
        this.linkAttName = linkAttName;
        initComponents();
        saveButton1.setIcon(jButton1.getIcon());
        this.getRootPane().setDefaultButton(jButton1);

        form1.setFormController(new NuevaPolizaDialogController(this));
        form1.setMode(Consts.INSERT);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) d.getWidth() - this.getWidth()) / 2, ((int) d.getHeight() - this.getHeight()) / 2);

        pack();
    }

    public NuevaPolizaDialog() {
        this(null, null);
    }

    public RamoPoliza getRamo() {
        return ramo;
    }

    public boolean isOk() {
        return ok;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton1 = new org.openswing.swing.client.SaveButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        form1 = new org.openswing.swing.form.client.Form();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        comboBoxControl5 = new org.openswing.swing.client.ComboBoxControl();

        setTitle("Nueva Poliza");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel2.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check1.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(33, 33));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        form1.setVOClassName(RamoPoliza.class.getName());
        form1.setSaveButton(saveButton1);

        labelControl2.setLabel("bienAsegurado");
        labelControl2.setToolTipText("Numero de Placa del Vehiculo");

        comboBoxControl4.setAttributeName("ramoContable");
        comboBoxControl4.setDomainId(Dominios.RamoContable().getDomainId());

        labelControl3.setText("tipoPoliza");
        labelControl3.setToolTipText("Numero de Placa del Vehiculo");

        comboBoxControl5.setAttributeName("tipoRamo");
        comboBoxControl5.setDomainId(Dominios.TipoRamo().getDomainId());

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addGroup(form1Layout.createSequentialGroup()
                        .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );

        form1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl2, labelControl3});

        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        form1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBoxControl4, comboBoxControl5, labelControl2, labelControl3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ramo=(RamoPoliza) form1.getVOModel().getValueObject();
        form1.getSaveButton().doClick();
        new NumeroPolizaDialog(MDIFrame.getInstance(), ramo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl5;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.SaveButton saveButton1;
    // End of variables declaration//GEN-END:variables

    class NuevaPolizaDialogController extends FormController {

        private NuevaPolizaDialog nuevaPoliza;

        public NuevaPolizaDialogController(NuevaPolizaDialog nuevaPoliza) {
            this.nuevaPoliza = nuevaPoliza;
        }

        @Override
        public Response insertRecord(ValueObject newPersistentObject) throws Exception {
            ramo = (RamoPoliza) newPersistentObject;
            return new VOResponse(newPersistentObject);
        }
    }
}
