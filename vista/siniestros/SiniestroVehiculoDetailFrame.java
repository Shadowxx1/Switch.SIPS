package vista.siniestros;

import controlador.polizas.recibos.ReciboLookupController;
import controlador.siniestros.CausaLookupController;
import controlador.util.DefaultDocumentosAnexosGridController;
import controlador.util.DefaultGridInternalController;
import controlador.documentosAnexos.TipoDocumentoLookupController;
import controlador.personas.PersonaLookupController;
import controlador.personas.PersonaLookupControllerPorNombre;
import controlador.personas.PersonasDetailController;
import controlador.polizas.PolizaDetailController;
import controlador.polizas.PolizaLookupController;
import controlador.polizas.recibos.ReciboDetailController;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Dominios;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.personas.maestra.Rif;
import modelo.entidades.polizas.maestra.Poliza;
import modelo.entidades.siniestros.dominio.DetalleRecaudo;
import modelo.entidades.siniestros.maestra.PagoParcial;
import modelo.entidades.siniestros.maestra.Siniestro;
import modelo.util.bean.BeanVO;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.form.model.client.VOModel;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.java.Consts;
import vista.polizas.PolizaDetailFrame;
import vista.polizas.recibos.ReciboDetailFrame;
import vista.util.DefaultDetailFrame;

/**
 *
 * @author Nelson Moncada
 */
public class SiniestroVehiculoDetailFrame extends DefaultDetailFrame {

    private DefaultDocumentosAnexosGridController controllerDocumentos;
    private DefaultGridInternalController controllerObservaciones;
    private DefaultGridInternalController controllerPagosParciales;
    private DefaultGridInternalController controllerRecaudos;
//    private DetalleDañoGridInternalController controllerDano;

    public SiniestroVehiculoDetailFrame() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        editButton1 = new org.openswing.swing.client.EditButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        form1 = new org.openswing.swing.form.client.Form();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        labelControl17 = new org.openswing.swing.client.LabelControl();
        labelControl18 = new org.openswing.swing.client.LabelControl();
        labelControl19 = new org.openswing.swing.client.LabelControl();
        codLookupControl4 = new org.openswing.swing.client.CodLookupControl();
        codLookupControl6 = new org.openswing.swing.client.CodLookupControl();
        codLookupControl7 = new org.openswing.swing.client.CodLookupControl();
        codLookupControl8 = new org.openswing.swing.client.CodLookupControl();
        labelControl22 = new org.openswing.swing.client.LabelControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        jPanel9 = new javax.swing.JPanel();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        dateControl6 = new org.openswing.swing.client.DateControl();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        dateControl7 = new org.openswing.swing.client.DateControl();
        labelControl21 = new org.openswing.swing.client.LabelControl();
        textControl7 = new org.openswing.swing.client.TextControl();
        labelControl20 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        jPanel11 = new javax.swing.JPanel();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        textControl1 = new org.openswing.swing.client.TextControl();
        currencyControl1 = new org.openswing.swing.client.CurrencyControl();
        currencyControl2 = new org.openswing.swing.client.CurrencyControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        labelControl27 = new org.openswing.swing.client.LabelControl();
        labelControl16 = new org.openswing.swing.client.LabelControl();
        currencyControl3 = new org.openswing.swing.client.CurrencyControl();
        jPanel7 = new javax.swing.JPanel();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        checkBoxControl1 = new org.openswing.swing.client.CheckBoxControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        dateControl3 = new org.openswing.swing.client.DateControl();
        dateControl4 = new org.openswing.swing.client.DateControl();
        dateControl5 = new org.openswing.swing.client.DateControl();
        comboBoxControl3 = new org.openswing.swing.client.ComboBoxControl();
        labelControl23 = new org.openswing.swing.client.LabelControl();
        jPanel12 = new javax.swing.JPanel();
        insertButton10 = new org.openswing.swing.client.InsertButton();
        editButton10 = new org.openswing.swing.client.EditButton();
        deleteButton10 = new org.openswing.swing.client.DeleteButton();
        saveButton10 = new org.openswing.swing.client.SaveButton();
        reloadButton10 = new org.openswing.swing.client.ReloadButton();
        gridControl7 = new org.openswing.swing.client.GridControl();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        textColumn9 = new org.openswing.swing.table.columns.client.TextColumn();
        integerColumn2 = new org.openswing.swing.table.columns.client.IntegerColumn();
        dateColumn4 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn6 = new org.openswing.swing.table.columns.client.DateColumn();
        codLookupColumn2 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        jPanel2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        gridControl6 = new org.openswing.swing.client.GridControl();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        dateColumn3 = new org.openswing.swing.table.columns.client.DateColumn();
        textColumn7 = new org.openswing.swing.table.columns.client.TextColumn();
        codLookupColumn1 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        currencyColumn2 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        jPanel22 = new javax.swing.JPanel();
        insertButton9 = new org.openswing.swing.client.InsertButton();
        editButton9 = new org.openswing.swing.client.EditButton();
        deleteButton9 = new org.openswing.swing.client.DeleteButton();
        saveButton9 = new org.openswing.swing.client.SaveButton();
        reloadButton9 = new org.openswing.swing.client.ReloadButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        insertButton7 = new org.openswing.swing.client.InsertButton();
        saveButton7 = new org.openswing.swing.client.SaveButton();
        deleteButton7 = new org.openswing.swing.client.DeleteButton();
        reloadButton7 = new org.openswing.swing.client.ReloadButton();
        gridControl5 = new org.openswing.swing.client.GridControl();
        decimalColumn5 = new org.openswing.swing.table.columns.client.DecimalColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        dateTimeColumn1 = new org.openswing.swing.table.columns.client.DateTimeColumn();
        jPanel17 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        insertButton6 = new org.openswing.swing.client.InsertButton();
        editButton6 = new org.openswing.swing.client.EditButton();
        deleteButton6 = new org.openswing.swing.client.DeleteButton();
        saveButton6 = new org.openswing.swing.client.SaveButton();
        reloadButton6 = new org.openswing.swing.client.ReloadButton();
        gridControl4 = new org.openswing.swing.client.GridControl();
        buttonColumn2 = new org.openswing.swing.table.columns.client.ButtonColumn();
        integerColumn3 = new org.openswing.swing.table.columns.client.IntegerColumn();
        codLookupColumn3 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn1 = new org.openswing.swing.table.columns.client.DateColumn();

        setTitle("Siniestro");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/36.png"))); // NOI18N
        jButton2.setToolTipText("Enviar SMS al Asegurado");
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        jButton3.setToolTipText("Enviar Email al Contratante");
        jButton3.setPreferredSize(new java.awt.Dimension(33, 33));

        jButton1.setToolTipText("");

        jButton11.setText("Ver historial");
        jButton11.setToolTipText("Muestra el HIstorial del asegurado");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        jButton4.setToolTipText("Enviar SMS al Asegurado");
        jButton4.setPreferredSize(new java.awt.Dimension(33, 33));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reloadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        form1.setVOClassName(Siniestro.class.getName());
        form1.setEditButton(editButton1);
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Poliza - Recibo"));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        labelControl15.setLabel("compania");

        labelControl17.setLabel("cobrador");

        labelControl18.setLabel("contratante");

        labelControl19.setLabel("asegurado");

        codLookupControl4.setAttributeName("recibo.poliza.compania.nombreLargo");
        codLookupControl4.setEnabledOnEdit(false);
        codLookupControl4.setEnabledOnInsert(false);
        codLookupControl4.setLookupButtonVisible(false);

        codLookupControl6.setAttributeName("recibo.poliza.cobrador.nombreLargo");
        codLookupControl6.setEnabledOnEdit(false);
        codLookupControl6.setEnabledOnInsert(false);
        codLookupControl6.setLookupButtonVisible(false);

        codLookupControl7.setAttributeName("recibo.poliza.contratante.nombreLargo");
        codLookupControl7.setEnabledOnEdit(false);
        codLookupControl7.setEnabledOnInsert(false);
        codLookupControl7.setLookupButtonVisible(false);

        codLookupControl8.setAttributeName("recibo.asegurado.nombreLargo");
        codLookupControl8.setEnabledOnEdit(false);
        codLookupControl8.setEnabledOnInsert(false);
        codLookupControl8.setLookupButtonVisible(false);

        labelControl22.setLabel("numeroRecibo");

        codLookupControl2.setAttributeName("recibo.numero");
        codLookupControl2.setLookupButtonVisible(false);
        codLookupControl2.setMaxCharacters(25);
        codLookupControl2.setRequired(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(labelControl15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(labelControl17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(labelControl18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codLookupControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(codLookupControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl15, labelControl17, labelControl18, labelControl19, labelControl22});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codLookupControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl4, codLookupControl6, codLookupControl7, codLookupControl8, labelControl15, labelControl17, labelControl18, labelControl19});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl2, labelControl22});

        jPanel4.add(jPanel8);

        labelControl13.setLabel("vigenciaDesde");

        dateControl6.setAttributeName("recibo.vigenciaDesde");
        dateControl6.setEnabledOnEdit(false);
        dateControl6.setEnabledOnInsert(false);

        labelControl14.setLabel("vigenciaHasta");

        dateControl7.setAttributeName("recibo.vigenciaHasta");
        dateControl7.setEnabledOnEdit(false);
        dateControl7.setEnabledOnInsert(false);

        labelControl21.setLabel("ramoPoliza");

        textControl7.setAttributeName("recibo.poliza.ramoPoliza.nombre");
        textControl7.setEnabledOnEdit(false);
        textControl7.setEnabledOnInsert(false);

        labelControl20.setLabel("numeroPoliza");

        codLookupControl3.setAttributeName("recibo.poliza.numero");
        codLookupControl3.setEnabledOnEdit(false);
        codLookupControl3.setEnabledOnInsert(false);
        codLookupControl3.setLookupButtonVisible(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(labelControl13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(dateControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(codLookupControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl13, labelControl14, labelControl20, labelControl21});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion del Siniestro"));

        textAreaControl1.setAttributeName("descripcion");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textAreaControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Siniestro"));
        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        labelControl1.setLabel("id");

        labelControl2.setLabel("siniestro.numero");

        labelControl3.setText("Monto Estimado");

        labelControl4.setLabel("montoLiquidado");

        labelControl5.setLabel("porcentajePenalizacion");

        numericControl1.setAttributeName("id");
        numericControl1.setEnabledOnEdit(false);
        numericControl1.setEnabledOnInsert(false);

        textControl1.setAttributeName("numero");

        currencyControl1.setAttributeName("montoCobertura");
        currencyControl1.setDecimals(2);
        currencyControl1.setRequired(true);

        currencyControl2.setAttributeName("montoLiquidado");
        currencyControl2.setDecimals(2);

        labelControl11.setLabel("causa");

        codLookupControl1.setCodBoxVisible(false);
        codLookupControl1.setControllerMethodName("getCausaSiniestro");

        numericControl2.setAttributeName("porcentajePenalizacion");

        textControl12.setAttributeName("detalleCausa.nombreCompleto");
        textControl12.setEnabledOnEdit(false);
        textControl12.setEnabledOnInsert(false);
        textControl12.setRequired(true);

        textControl2.setAttributeName("numeroNotificacion");

        labelControl27.setLabel("siniestro.numeroNotificacion");

        labelControl16.setText("montoDeducible");

        currencyControl3.setAttributeName("montoLiquidado");
        currencyControl3.setDecimals(2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelControl27, 0, 0, Short.MAX_VALUE)
                                .addComponent(labelControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(textControl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(currencyControl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(labelControl16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelControl11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textControl12, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numericControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl1, labelControl11, labelControl16, labelControl2, labelControl3, labelControl4, labelControl5});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numericControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl1, currencyControl1, currencyControl2, labelControl1, labelControl11, labelControl2, labelControl27, labelControl3, labelControl4, labelControl5, numericControl1, numericControl2, textControl1});

        jPanel5.add(jPanel6);

        labelControl6.setLabel("estatus");

        labelControl7.setLabel("fechaEstatus");

        labelControl8.setLabel("fechaOcurrencia");

        labelControl9.setLabel("fechaNotificacion");

        labelControl10.setLabel("fechaNotificacionCompania");

        checkBoxControl1.setText("anulado");
        checkBoxControl1.setAttributeName("anulado");
        checkBoxControl1.setEnabledOnInsert(false);

        comboBoxControl1.setAttributeName("estatus");
        comboBoxControl1.setDomainId(Dominios.EstatusSiniestro().getDomainId());
        comboBoxControl1.setNullAsDefaultValue(true);
        comboBoxControl1.setRequired(true);

        dateControl1.setAttributeName("fechaEstatus");
        dateControl1.setRequired(true);

        dateControl2.setAttributeName("fechaOcurrencia");
        dateControl2.setRequired(true);

        dateControl3.setAttributeName("fechaNotificacion");
        dateControl3.setRequired(true);

        dateControl4.setAttributeName("fechaAnulacion");

        dateControl5.setAttributeName("fechaNotificacionCompania");

        comboBoxControl3.setAttributeName("tipoNotificacion");
        comboBoxControl3.setDomainId(Dominios.TipoNotificacion().getDomainId());
        comboBoxControl3.setNullAsDefaultValue(true);

        labelControl23.setLabel("tipoNotificacion");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(dateControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(dateControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(dateControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelControl23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(dateControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkBoxControl1, labelControl10, labelControl23, labelControl6, labelControl7, labelControl8, labelControl9});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkBoxControl1, labelControl10, labelControl6, labelControl7, labelControl8, labelControl9});

        jPanel5.add(jPanel7);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(form1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Especificos", jPanel1);

        gridControl7.setDeleteButton(deleteButton10);
        gridControl7.setEditButton(editButton10);
        gridControl7.setEditOnSingleRow(true);
        gridControl7.setInsertButton(insertButton10);
        gridControl7.setMaxNumberOfRowsOnInsert(4);
        gridControl7.setReloadButton(reloadButton10);
        gridControl7.setSaveButton(saveButton10);
        gridControl7.setValueObjectClassName(DetalleRecaudo.class.getName());

        decimalColumn8.setColumnName("id");
        decimalColumn8.setColumnRequired(false);
        decimalColumn8.setPreferredWidth(40);
        gridControl7.getColumnContainer().add(decimalColumn8);

        textColumn9.setColumnFilterable(true);
        textColumn9.setColumnName("nombre");
        textColumn9.setColumnSortable(true);
        textColumn9.setEditableOnEdit(true);
        textColumn9.setEditableOnInsert(true);
        gridControl7.getColumnContainer().add(textColumn9);

        integerColumn2.setColumnName("cantidad");
        integerColumn2.setColumnSortable(true);
        integerColumn2.setEditableOnEdit(true);
        integerColumn2.setEditableOnInsert(true);
        gridControl7.getColumnContainer().add(integerColumn2);

        dateColumn4.setColumnFilterable(true);
        dateColumn4.setColumnName("fechaRecibido");
        dateColumn4.setColumnRequired(false);
        dateColumn4.setColumnSortable(true);
        dateColumn4.setEditableOnEdit(true);
        dateColumn4.setEditableOnInsert(true);
        gridControl7.getColumnContainer().add(dateColumn4);

        dateColumn6.setColumnFilterable(true);
        dateColumn6.setColumnName("fechaLimiteEntrega");
        dateColumn6.setColumnRequired(false);
        dateColumn6.setColumnSortable(true);
        dateColumn6.setEditableOnEdit(true);
        dateColumn6.setEditableOnInsert(true);
        gridControl7.getColumnContainer().add(dateColumn6);

        codLookupColumn2.setColumnFilterable(true);
        codLookupColumn2.setColumnName("ejecutivo.nombreLargo");
        codLookupColumn2.setColumnRequired(false);
        codLookupColumn2.setColumnSortable(true);
        codLookupColumn2.setControllerMethodName("getPersonaNueva");
        codLookupColumn2.setEditableOnEdit(true);
        codLookupColumn2.setEditableOnInsert(true);
        codLookupColumn2.setHeaderColumnName("rif.cedulaCompleta");
        gridControl7.getColumnContainer().add(codLookupColumn2);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gridControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reloadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(598, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                    .addContainerGap(58, Short.MAX_VALUE)
                    .addComponent(gridControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Recaudos", jPanel12);

        gridControl6.setDeleteButton(deleteButton9);
        gridControl6.setEditButton(editButton9);
        gridControl6.setEditOnSingleRow(true);
        gridControl6.setInsertButton(insertButton9);
        gridControl6.setMaxNumberOfRowsOnInsert(4);
        gridControl6.setReloadButton(reloadButton9);
        gridControl6.setSaveButton(saveButton9);
        gridControl6.setValueObjectClassName(PagoParcial.class.getName());

        decimalColumn7.setColumnName("id");
        decimalColumn7.setColumnRequired(false);
        decimalColumn7.setPreferredWidth(40);
        gridControl6.getColumnContainer().add(decimalColumn7);

        dateColumn3.setColumnFilterable(true);
        dateColumn3.setColumnName("fechaPago");
        dateColumn3.setColumnSortable(true);
        dateColumn3.setEditableOnEdit(true);
        dateColumn3.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(dateColumn3);

        textColumn7.setColumnFilterable(true);
        textColumn7.setColumnName("descripcion");
        textColumn7.setColumnSortable(true);
        textColumn7.setEditableOnEdit(true);
        textColumn7.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(textColumn7);

        codLookupColumn1.setColumnFilterable(true);
        codLookupColumn1.setColumnName("banco.nombreLargo");
        codLookupColumn1.setColumnSortable(true);
        codLookupColumn1.setControllerMethodName("getPersonaNueva");
        codLookupColumn1.setEditableOnEdit(true);
        codLookupColumn1.setEditableOnInsert(true);
        codLookupColumn1.setHeaderColumnName("rif.cedulaCompleta");
        gridControl6.getColumnContainer().add(codLookupColumn1);

        textColumn5.setColumnFilterable(true);
        textColumn5.setColumnName("numCheque");
        textColumn5.setColumnSortable(true);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(textColumn5);

        currencyColumn2.setColumnFilterable(true);
        currencyColumn2.setColumnName("monto");
        currencyColumn2.setColumnSortable(true);
        currencyColumn2.setDecimals(2);
        currencyColumn2.setEditableOnEdit(true);
        currencyColumn2.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(currencyColumn2);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(insertButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(insertButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(editButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(deleteButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(reloadButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gridControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pagos Parciales", jPanel2);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));
        jPanel15.setPreferredSize(new java.awt.Dimension(568, 270));

        jPanel16.setLayout(new java.awt.GridLayout(3, 2, 2, 2));
        jPanel16.add(insertButton7);
        jPanel16.add(saveButton7);
        jPanel16.add(deleteButton7);
        jPanel16.add(reloadButton7);

        gridControl5.setDeleteButton(deleteButton7);
        gridControl5.setFunctionId("obsServ");
        gridControl5.setInsertButton(insertButton7);
        gridControl5.setMaxNumberOfRowsOnInsert(4);
        gridControl5.setReloadButton(reloadButton7);
        gridControl5.setSaveButton(saveButton7);
        gridControl5.setValueObjectClassName(Observacion.class.getName());

        decimalColumn5.setColumnName("id");
        decimalColumn5.setColumnRequired(false);
        decimalColumn5.setPreferredWidth(40);
        gridControl5.getColumnContainer().add(decimalColumn5);

        textColumn2.setColumnName("observacion");
        textColumn2.setEditableOnEdit(true);
        textColumn2.setEditableOnInsert(true);
        textColumn2.setMaxCharacters(1024);
        textColumn2.setPreferredWidth(350);
        gridControl5.getColumnContainer().add(textColumn2);

        textColumn8.setColumnName("auditoria.usuarioInsert");
        textColumn8.setColumnRequired(false);
        gridControl5.getColumnContainer().add(textColumn8);

        dateTimeColumn1.setColumnName("auditoria.fechaInsert");
        dateTimeColumn1.setColumnRequired(false);
        gridControl5.getColumnContainer().add(dateTimeColumn1);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos Anexos"));
        jPanel17.setPreferredSize(new java.awt.Dimension(568, 270));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(insertButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(insertButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(editButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(deleteButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(reloadButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridControl4.setDeleteButton(deleteButton6);
        gridControl4.setEditButton(editButton6);
        gridControl4.setFunctionId("anexoSini");
        gridControl4.setInsertButton(insertButton6);
        gridControl4.setMaxNumberOfRowsOnInsert(4);
        gridControl4.setReloadButton(reloadButton6);
        gridControl4.setSaveButton(saveButton6);
        gridControl4.setValueObjectClassName(Documento.class.getName());

        buttonColumn2.setColumnName("button");
        buttonColumn2.setEditableOnEdit(true);
        buttonColumn2.setEnableInReadOnlyMode(true);
        buttonColumn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view.png"))); // NOI18N
        buttonColumn2.setPreferredWidth(20);
        buttonColumn2.setText("");
        gridControl4.getColumnContainer().add(buttonColumn2);

        integerColumn3.setColumnName("id");
        integerColumn3.setColumnRequired(false);
        integerColumn3.setPreferredWidth(40);
        gridControl4.getColumnContainer().add(integerColumn3);

        codLookupColumn3.setColumnName("tipoDocumento.nombre");
        codLookupColumn3.setControllerMethodName("getTipoDocAnex");
        codLookupColumn3.setEditableOnEdit(true);
        codLookupColumn3.setEditableOnInsert(true);
        gridControl4.getColumnContainer().add(codLookupColumn3);

        textColumn4.setColumnName("observacion");
        textColumn4.setColumnRequired(false);
        textColumn4.setEditableOnEdit(true);
        textColumn4.setEditableOnInsert(true);
        gridControl4.getColumnContainer().add(textColumn4);

        dateColumn1.setColumnName("fechaVencimiento");
        dateColumn1.setColumnRequired(false);
        dateColumn1.setEditableOnEdit(true);
        dateColumn1.setEditableOnInsert(true);
        gridControl4.getColumnContainer().add(dateColumn1);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(392, Short.MAX_VALUE))
            .addComponent(gridControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Generales", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public VOModel getVOModel() {
        return form1.getVOModel();
    }

    public JButton getReporteButoon() {
        return jButton4;
    }

    public JButton getHistorialButoon() {
        return jButton11;
    }

//    public JButton getNuevoDañoVehiculo() {
//        return insertButton8;
//    }

    @Override
    public void inicializar(FormController formController, boolean addToMDIFrame) {
        initComponents();

        jButton1.setVisible(false);
        jButton11.setVisible(false);

        PolizaLookupController lookupPoliza = new PolizaLookupController();
        lookupPoliza.addLookup2ParentLink("recibo.poliza");
        codLookupControl3.setLookupController(lookupPoliza);
        codLookupControl3.setOpenDetail("recibo.poliza", PolizaDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class, Boolean.class},
                new Object[]{PolizaDetailFrame.class.getName(), null, null, true, false}, 2);

        ReciboLookupController reciboLookupController = new ReciboLookupController();
        reciboLookupController.addLookup2ParentLink("numero", "recibo.numero");
        codLookupControl2.setLookupController(reciboLookupController);
        codLookupControl2.setOpenDetail("recibo", ReciboDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class, Poliza.class, Boolean.class}, new Object[]{ReciboDetailFrame.class.getName(), null, null, true, null, false}, 2);

        PersonaLookupController lookupCompania = new PersonaLookupController("SEG");
        lookupCompania.addLookup2ParentLink("recibo.poliza.compania");
        codLookupControl4.setLookupController(lookupCompania);
        codLookupControl4.setOpenDetail("recibo.poliza.compania", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

//        PersonaLookupController lookupProductor = new PersonaLookupController("PRO");
//        lookupProductor.addLookup2ParentLink("recibo.poliza.productor");
//        codLookupControl5.setLookupController(lookupProductor);
//        codLookupControl5.setOpenDetail("recibo.poliza.productor", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

        PersonaLookupController lookupCobrador = new PersonaLookupController("COB");
        lookupCobrador.addLookup2ParentLink("recibo.poliza.cobrador");
        codLookupControl6.setLookupController(lookupCobrador);
        codLookupControl6.setOpenDetail("recibo.poliza.cobrador", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

        PersonaLookupController lookupContratante = new PersonaLookupController("CON");
        lookupContratante.addLookup2ParentLink("recibo.poliza.contratante");
        codLookupControl7.setLookupController(lookupContratante);
        codLookupControl7.setOpenDetail("recibo.poliza.contratante", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

        PersonaLookupController lookupAsegurado = new PersonaLookupController("CON");
        lookupAsegurado.addLookup2ParentLink("recibo.asegurado");
        codLookupControl8.setLookupController(lookupAsegurado);
        codLookupControl8.setOpenDetail("recibo.asegurado", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

//        DefaultLookupController d = new DefaultLookupController(DanoVehiculo.class.getName());
//        d.addLookup2ParentLink("dano");
//        codLookupColumn4.setLookupController(d);

        CausaLookupController causaLookupController = new CausaLookupController();
        codLookupControl1.setLookupController(causaLookupController);

        TipoDocumentoLookupController lookupDocumentoAnexo2 =
                new TipoDocumentoLookupController(Dominios.Modulos.SINIESTROS);
        lookupDocumentoAnexo2.addLookup2ParentLink("tipoDocumento");
        codLookupColumn3.setLookupController(lookupDocumentoAnexo2);

        org.openswing.swing.table.columns.client.PictureCaptureColumn pcc = new org.openswing.swing.table.columns.client.PictureCaptureColumn();
        pcc.setColumnName("file");
        pcc.setEditableOnInsert(true);
        pcc.setEditableOnEdit(false);
        pcc.setFileNameAttributeName("fileName");
        pcc.setPreferredWidth(220);
        gridControl4.getColumnContainer().add(pcc);
        controllerDocumentos = new DefaultDocumentosAnexosGridController(Siniestro.class, gridControl4);
        buttonColumn2.addActionListener(controllerDocumentos);
        gridControl4.setController(controllerDocumentos);
        gridControl4.setGridDataLocator(controllerDocumentos);

        controllerObservaciones =
                new DefaultGridInternalController(Siniestro.class.getName(), "getObservaciones", gridControl5, null);
        gridControl5.setGridDataLocator(controllerObservaciones);
        gridControl5.setController(controllerObservaciones);

        controllerPagosParciales =
                new DefaultGridInternalController(Siniestro.class.getName(), "getPagosParciales", gridControl6, null);
        gridControl6.setGridDataLocator(controllerPagosParciales);
        gridControl6.setController(controllerPagosParciales);

        controllerRecaudos =
                new DefaultGridInternalController(Siniestro.class.getName(), "getRecaudos", gridControl7, null);
        gridControl7.setGridDataLocator(controllerRecaudos);
        gridControl7.setController(controllerRecaudos);

        PersonaLookupControllerPorNombre lookupPersonaPagoParcial =
                new PersonaLookupControllerPorNombre("BAN");
        lookupPersonaPagoParcial.addLookup2ParentLink("banco");
        codLookupColumn1.setLookupController(lookupPersonaPagoParcial);

        PersonaLookupControllerPorNombre lookupEjecutivo =
                new PersonaLookupControllerPorNombre("EJE");
        lookupEjecutivo.addLookup2ParentLink("ejecutivo");
        codLookupColumn2.setLookupController(lookupEjecutivo);

//        controllerDano = new DetalleDañoGridInternalController(Siniestro.class.getName(), "getDetalleDano", gridControl6, null);
//        gridControl6.setGridDataLocator(controllerDano);
//        gridControl6.setController(controllerDano);
        
        jButton2.addActionListener((ActionListener) formController);
        jButton3.addActionListener((ActionListener) formController);
        jButton1.addActionListener((ActionListener) formController);
        jButton4.addActionListener((ActionListener) formController);
        jButton11.addActionListener((ActionListener) formController);

        form1.setFormController(formController);
        form1.setCreateInnerVO(false);
        if (addToMDIFrame) {
            pack();
        } else {
            setBounds(0, 0, 0, 0);
        }
        MDIFrame.add(this);
    }

    public void validarEstatus(Dominios.EstadoSiniestro estatus) {
        if (estatus != Dominios.EstadoSiniestro.ABIERTO) {
            form1.setEditButton(null);
            form1.setSaveButton(null);

            gridControl4.setSaveButton(null);
            gridControl4.setDeleteButton(null);
            gridControl4.setEditButton(null);

            gridControl5.setSaveButton(null);
            gridControl5.setDeleteButton(null);
            gridControl5.setEditButton(null);

//            gridControl6.setSaveButton(null);
//            gridControl6.setDeleteButton(null);
//            gridControl6.setEditButton(null);

            editButton1.setEnabled(false);
            editButton6.setEnabled(false);
//            editButton7.setEnabled(false);
//            editButton8.setEnabled(false);

            saveButton1.setEnabled(false);
            saveButton6.setEnabled(false);
            saveButton7.setEnabled(false);
//            saveButton8.setEnabled(false);

            insertButton6.setEnabled(false);
            insertButton7.setEnabled(false);
//            insertButton8.setEnabled(false);

            deleteButton6.setEnabled(false);
            deleteButton7.setEnabled(false);
//            deleteButton8.setEnabled(false);

        } else {
            form1.setEditButton(editButton1);
            form1.setSaveButton(saveButton1);

            gridControl4.setSaveButton(saveButton6);
            gridControl4.setDeleteButton(deleteButton6);
            gridControl4.setEditButton(editButton6);

            gridControl5.setSaveButton(saveButton7);
            gridControl5.setDeleteButton(deleteButton7);
//            gridControl5.setEditButton(editButton7);

//            gridControl6.setSaveButton(saveButton8);
//            gridControl6.setDeleteButton(deleteButton8);
//            gridControl6.setEditButton(editButton8);

            editButton1.setEnabled(true);
            editButton6.setEnabled(true);
//            editButton7.setEnabled(true);
//            editButton8.setEnabled(true);

            if (form1.getMode() == Consts.INSERT) {
                saveButton1.setEnabled(true);
            }

            saveButton6.setEnabled(true);
            saveButton7.setEnabled(true);
//            saveButton8.setEnabled(true);

            insertButton6.setEnabled(true);
            insertButton7.setEnabled(true);
//            insertButton8.setEnabled(true);

            deleteButton6.setEnabled(true);
            deleteButton7.setEnabled(true);
//            deleteButton8.setEnabled(true);
        }
    }

    @Override
    public void saveGridsData() {
        gridControl5.getSaveButton().doClick();
        gridControl4.getSaveButton().doClick();
        gridControl6.getSaveButton().doClick();
        gridControl7.getSaveButton().doClick();
    }

    @Override
    public void reloadGridsData() {
        gridControl5.reloadData();
        gridControl4.reloadData();
        gridControl6.reloadData();
        gridControl7.reloadData();
    }

    @Override
    public void clearGridsData() {
        gridControl5.clearData();
        gridControl4.clearData();
        gridControl6.clearData();
        gridControl7.clearData();
    }

    public void validarEstado(Siniestro sini) {
        switch (sini.getEstado()) {
            case ABIERTO:
                jButton1.setVisible(true);
                jButton1.setBackground(Color.GREEN);
                jButton1.setText("CERRAR");
                jButton1.setToolTipText("Cerrar el Siniestro");
                break;
            case CERRADO:
                jButton1.setVisible(true);
                jButton1.setBackground(Color.RED);
                jButton1.setText("ABRIR");
                jButton1.setToolTipText("Abrir el Siniestro");
                break;
        }
    }

    @Override
    public void setOwnerVO(BeanVO beanVO) {
        controllerObservaciones.setBeanVO(beanVO);
        Long id = null;
        if (beanVO != null) {
            id = ((Siniestro) beanVO).getId();
        }

        controllerDocumentos.setBeanVO(beanVO, id);
//        controllerDano.setBeanVO(beanVO);
        controllerPagosParciales.setBeanVO(beanVO);
        controllerRecaudos.setBeanVO(beanVO);
        validarEstado((Siniestro) beanVO);
    }

    @Override
    public Form getMainPanel() {
        return form1;
    }

    @Override
    public void modeChanged(int currentMode) {
        if (currentMode == Consts.INSERT) {
            clearGridsData();
        }
        if (currentMode == Consts.INSERT) {
            setEnableGridInternalButtons(false);
        } else {
            setEnableGridInternalButtons(true);
        }
    }

    private void setEnableGridInternalButtons(boolean enabled) {
        jPanel14.setVisible(enabled);
        jPanel16.setVisible(enabled);
        jButton11.setVisible(enabled);
    }

    public JButton getEmailButton() {
        return jButton3;
    }

    public JButton getSMSButton() {
        return jButton2;
    }

    public JButton getEstadoButton() {
        return jButton1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ButtonColumn buttonColumn2;
    private org.openswing.swing.client.CheckBoxControl checkBoxControl1;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn1;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn2;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn3;
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.client.CodLookupControl codLookupControl4;
    private org.openswing.swing.client.CodLookupControl codLookupControl6;
    private org.openswing.swing.client.CodLookupControl codLookupControl7;
    private org.openswing.swing.client.CodLookupControl codLookupControl8;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl3;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn2;
    private org.openswing.swing.client.CurrencyControl currencyControl1;
    private org.openswing.swing.client.CurrencyControl currencyControl2;
    private org.openswing.swing.client.CurrencyControl currencyControl3;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn1;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn3;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn4;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn6;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.client.DateControl dateControl3;
    private org.openswing.swing.client.DateControl dateControl4;
    private org.openswing.swing.client.DateControl dateControl5;
    private org.openswing.swing.client.DateControl dateControl6;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.table.columns.client.DateTimeColumn dateTimeColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.client.DeleteButton deleteButton10;
    private org.openswing.swing.client.DeleteButton deleteButton6;
    private org.openswing.swing.client.DeleteButton deleteButton7;
    private org.openswing.swing.client.DeleteButton deleteButton9;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton10;
    private org.openswing.swing.client.EditButton editButton6;
    private org.openswing.swing.client.EditButton editButton9;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl4;
    private org.openswing.swing.client.GridControl gridControl5;
    private org.openswing.swing.client.GridControl gridControl6;
    private org.openswing.swing.client.GridControl gridControl7;
    private org.openswing.swing.client.InsertButton insertButton10;
    private org.openswing.swing.client.InsertButton insertButton6;
    private org.openswing.swing.client.InsertButton insertButton7;
    private org.openswing.swing.client.InsertButton insertButton9;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn2;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl13;
    private org.openswing.swing.client.LabelControl labelControl14;
    private org.openswing.swing.client.LabelControl labelControl15;
    private org.openswing.swing.client.LabelControl labelControl16;
    private org.openswing.swing.client.LabelControl labelControl17;
    private org.openswing.swing.client.LabelControl labelControl18;
    private org.openswing.swing.client.LabelControl labelControl19;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl20;
    private org.openswing.swing.client.LabelControl labelControl21;
    private org.openswing.swing.client.LabelControl labelControl22;
    private org.openswing.swing.client.LabelControl labelControl23;
    private org.openswing.swing.client.LabelControl labelControl27;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton10;
    private org.openswing.swing.client.ReloadButton reloadButton6;
    private org.openswing.swing.client.ReloadButton reloadButton7;
    private org.openswing.swing.client.ReloadButton reloadButton9;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton10;
    private org.openswing.swing.client.SaveButton saveButton6;
    private org.openswing.swing.client.SaveButton saveButton7;
    private org.openswing.swing.client.SaveButton saveButton9;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.table.columns.client.TextColumn textColumn9;
    private org.openswing.swing.client.TextControl textControl1;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl7;
    // End of variables declaration//GEN-END:variables
}
