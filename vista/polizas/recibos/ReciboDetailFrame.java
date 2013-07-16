package vista.polizas.recibos;

import controlador.General;
import controlador.polizas.PolizaLookupController;
import controlador.polizas.recibos.ReciboDetailController;
import controlador.util.DefaultDocumentosAnexosGridController;
import controlador.util.DefaultGridInternalController;
import controlador.documentosAnexos.TipoDocumentoLookupController;
import controlador.personas.PersonaLookupController;
import controlador.personas.PersonaLookupControllerPorNombre;
import controlador.personas.PersonasDetailController;
import controlador.polizas.PolizaDetailController;
import controlador.polizas.financiamiento.FinanciamientoDetailController;
import controlador.polizas.financiamiento.FinanciamientoLookupController;
import controlador.polizas.recibos.DevolucionesGridInternalController;
import controlador.polizas.recibos.DistribucionGridInternalFrame2;
import controlador.polizas.recibos.RamoCoberturaLookupController;
import controlador.polizas.recibos.cobertura.mant.CoberturasReciboGridInternalController;
import controlador.util.DefaultGridInternalController2;
import controlador.util.DefaultLookupController;
import controlador.util.DefaultLookupControllerPorNombre;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import modelo.Dominios;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.personas.maestra.Rif;
import modelo.entidades.polizas.recibos.cobertura.Cobertura;
import modelo.entidades.polizas.recibos.cobertura.CoberturasRecibo;
import modelo.entidades.polizas.recibos.devolucion.maestra.Devolucion;
import modelo.entidades.polizas.recibos.dominio.TipoDistribucion;
import modelo.entidades.polizas.recibos.dominio.TipoZona;
import modelo.entidades.polizas.recibos.maestra.Distribucion;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.entidades.polizas.recibos.maestra.ReciboPersonas;
import modelo.util.bean.BeanVO;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.java.Consts;
import vista.personas.RifDialog;
import vista.polizas.PolizaDetailFrame;
import vista.polizas.financiamiento.FinanciamientoDetailFrame;
import vista.util.DefaultDetailFrame;

/**
 *
 * @author Nelson Moncada
 */
public class ReciboDetailFrame extends DefaultDetailFrame {

    private DefaultDocumentosAnexosGridController controllerDocumentos;
    private DefaultGridInternalController controllerObservaciones;
//    private DefaultGridInternalController controllerBeneficiarios;
    private DefaultGridInternalController controllerDevoluciones;
    private DefaultGridInternalController controllerCoberturas;
    //private DefaultGridInternalController controllerCoberturas;
    private DefaultGridInternalController2 controllerDistribuciones;

    public ReciboDetailFrame() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        form1 = new org.openswing.swing.form.client.Form();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        labelControl18 = new org.openswing.swing.client.LabelControl();
        textControl17 = new org.openswing.swing.client.TextControl();
        textControl18 = new org.openswing.swing.client.TextControl();
        jPanel5 = new javax.swing.JPanel();
        labelControl20 = new org.openswing.swing.client.LabelControl();
        labelControl21 = new org.openswing.swing.client.LabelControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        textControl6 = new org.openswing.swing.client.TextControl();
        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        currencyControl4 = new org.openswing.swing.client.CurrencyControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        currencyControl5 = new org.openswing.swing.client.CurrencyControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        currencyControl1 = new org.openswing.swing.client.CurrencyControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        currencyControl2 = new org.openswing.swing.client.CurrencyControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        currencyControl3 = new org.openswing.swing.client.CurrencyControl();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        textControl8 = new org.openswing.swing.client.TextControl();
        labelControl19 = new org.openswing.swing.client.LabelControl();
        codLookupControl5 = new org.openswing.swing.client.CodLookupControl();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        currencyControl6 = new org.openswing.swing.client.CurrencyControl();
        labelControl26 = new org.openswing.swing.client.LabelControl();
        codLookupControl6 = new org.openswing.swing.client.CodLookupControl();
        labelControl38 = new org.openswing.swing.client.LabelControl();
        textControl16 = new org.openswing.swing.client.TextControl();
        labelControl39 = new org.openswing.swing.client.LabelControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        codLookupControl7 = new org.openswing.swing.client.CodLookupControl();
        labelControl41 = new org.openswing.swing.client.LabelControl();
        jPanel19 = new javax.swing.JPanel();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        checkBoxControl2 = new org.openswing.swing.client.CheckBoxControl();
        dateControl3 = new org.openswing.swing.client.DateControl();
        dateControl4 = new org.openswing.swing.client.DateControl();
        dateControl5 = new org.openswing.swing.client.DateControl();
        dateControl6 = new org.openswing.swing.client.DateControl();
        dateControl7 = new org.openswing.swing.client.DateControl();
        labelControl27 = new org.openswing.swing.client.LabelControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        textControl9 = new org.openswing.swing.client.TextControl();
        comboBoxControl4 = new org.openswing.swing.client.ComboBoxControl();
        labelControl29 = new org.openswing.swing.client.LabelControl();
        textControl12 = new org.openswing.swing.client.TextControl();
        comboBoxControl2 = new org.openswing.swing.client.ComboBoxControl();
        labelControl40 = new org.openswing.swing.client.LabelControl();
        jPanel23 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jPanel12 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        gridControl8 = new org.openswing.swing.client.GridControl();
        decimalColumn16 = new org.openswing.swing.table.columns.client.DecimalColumn();
        codLookupColumn6 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        dateColumn12 = new org.openswing.swing.table.columns.client.DateColumn();
        dateColumn13 = new org.openswing.swing.table.columns.client.DateColumn();
        decimalColumn17 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn22 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn23 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn24 = new org.openswing.swing.table.columns.client.DecimalColumn();
        textColumn13 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanel36 = new javax.swing.JPanel();
        insertButton13 = new org.openswing.swing.client.InsertButton();
        editButton13 = new org.openswing.swing.client.EditButton();
        deleteButton13 = new org.openswing.swing.client.DeleteButton();
        saveButton13 = new org.openswing.swing.client.SaveButton();
        reloadButton13 = new org.openswing.swing.client.ReloadButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        labelControl16 = new org.openswing.swing.client.LabelControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        labelControl22 = new org.openswing.swing.client.LabelControl();
        codLookupControl3 = new org.openswing.swing.client.CodLookupControl();
        labelControl17 = new org.openswing.swing.client.LabelControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        jPanel26 = new javax.swing.JPanel();
        labelControl25 = new org.openswing.swing.client.LabelControl();
        currencyControl7 = new org.openswing.swing.client.CurrencyControl();
        dateControl9 = new org.openswing.swing.client.DateControl();
        labelControl24 = new org.openswing.swing.client.LabelControl();
        checkBoxControl3 = new org.openswing.swing.client.CheckBoxControl();
        dateControl10 = new org.openswing.swing.client.DateControl();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        gridControl2 = new org.openswing.swing.client.GridControl();
        decimalColumn8 = new org.openswing.swing.table.columns.client.DecimalColumn();
        codLookupColumn2 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        percentageColumn1 = new org.openswing.swing.table.columns.client.PercentageColumn();
        percentageColumn2 = new org.openswing.swing.table.columns.client.PercentageColumn();
        percentageColumn3 = new org.openswing.swing.table.columns.client.PercentageColumn();
        jPanel29 = new javax.swing.JPanel();
        insertButton10 = new org.openswing.swing.client.InsertButton();
        editButton10 = new org.openswing.swing.client.EditButton();
        deleteButton10 = new org.openswing.swing.client.DeleteButton();
        saveButton10 = new org.openswing.swing.client.SaveButton();
        reloadButton10 = new org.openswing.swing.client.ReloadButton();
        jPanel30 = new javax.swing.JPanel();
        labelControl23 = new org.openswing.swing.client.LabelControl();
        codLookupControl4 = new org.openswing.swing.client.CodLookupControl();
        jPanel32 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        labelControl42 = new org.openswing.swing.client.LabelControl();
        currencyControl8 = new org.openswing.swing.client.CurrencyControl();
        jPanel38 = new javax.swing.JPanel();
        currencyControl9 = new org.openswing.swing.client.CurrencyControl();
        labelControl43 = new org.openswing.swing.client.LabelControl();
        labelControl44 = new org.openswing.swing.client.LabelControl();
        currencyControl10 = new org.openswing.swing.client.CurrencyControl();
        jPanel13 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        gridControl6 = new org.openswing.swing.client.GridControl();
        decimalColumn7 = new org.openswing.swing.table.columns.client.DecimalColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn3 = new org.openswing.swing.table.columns.client.DateColumn();
        comboColumn2 = new org.openswing.swing.table.columns.client.ComboColumn();
        currencyColumn2 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        currencyColumn3 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        currencyColumn4 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        currencyColumn5 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        currencyColumn6 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        currencyColumn7 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        jPanel22 = new javax.swing.JPanel();
        insertButton9 = new org.openswing.swing.client.InsertButton();
        editButton9 = new org.openswing.swing.client.EditButton();
        deleteButton9 = new org.openswing.swing.client.DeleteButton();
        saveButton9 = new org.openswing.swing.client.SaveButton();
        reloadButton9 = new org.openswing.swing.client.ReloadButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        insertButton7 = new org.openswing.swing.client.InsertButton();
        deleteButton7 = new org.openswing.swing.client.DeleteButton();
        saveButton7 = new org.openswing.swing.client.SaveButton();
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
        dateColumn4 = new org.openswing.swing.table.columns.client.DateColumn();
        jPanel1 = new javax.swing.JPanel();
        editButton1 = new org.openswing.swing.client.EditButton();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        jButton1 = new javax.swing.JButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        copyButton1 = new org.openswing.swing.client.CopyButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Recibo");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        form1.setVOClassName(Recibo.class.getName());
        form1.setCopyButton(copyButton1);
        form1.setEditButton(editButton1);
        form1.setReloadButton(reloadButton1);
        form1.setSaveButton(saveButton1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Poliza"));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        labelControl15.setLabel("compania");

        labelControl18.setLabel("contratante");

        textControl17.setAttributeName("poliza.compania.nombreLargo");
        textControl17.setEnabledOnEdit(false);
        textControl17.setEnabledOnInsert(false);

        textControl18.setAttributeName("poliza.contratante.nombreLargo");
        textControl18.setEnabledOnEdit(false);
        textControl18.setEnabledOnInsert(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textControl17, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textControl18, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl15, labelControl18});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelControl18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textControl17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textControl18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelControl15, labelControl18});

        jPanel2.add(jPanel4);

        labelControl20.setLabel("numeroPoliza");

        labelControl21.setLabel("ramoPoliza");

        codLookupControl1.setAttributeName("poliza.numero");
        codLookupControl1.setLinkLabel(labelControl20);
        codLookupControl1.setMaxCharacters(21);
        codLookupControl1.setRequired(true);

        textControl6.setAttributeName("poliza.ramoPoliza.nombre");
        textControl6.setEnabledOnEdit(false);
        textControl6.setEnabledOnInsert(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelControl20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelControl21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl20, labelControl21});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl1, labelControl20, labelControl21, textControl6});

        jPanel2.add(jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Recibo"));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        labelControl2.setLabel("sumaAsegurada");

        currencyControl4.setAttributeName("sumaAsegurada");
        currencyControl4.setDecimals(2);

        labelControl3.setLabel("primaTotal");

        currencyControl5.setAttributeName("primaTotal");
        currencyControl5.setDecimals(2);
        currencyControl5.setLinkLabel(labelControl3);
        currencyControl5.setRequired(true);
        currencyControl5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                currencyControl5FocusGained(evt);
            }
        });

        labelControl4.setLabel("primaRecibo");

        currencyControl1.setAttributeName("primaRecibo");
        currencyControl1.setDecimals(2);
        currencyControl1.setRequired(true);

        labelControl5.setLabel("bono1");

        currencyControl2.setAttributeName("bono1");
        currencyControl2.setDecimals(2);
        currencyControl2.setRequired(true);

        labelControl6.setLabel("bono2");

        currencyControl3.setAttributeName("bono2");
        currencyControl3.setDecimals(2);
        currencyControl3.setRequired(true);

        labelControl13.setLabel("zona");

        codLookupControl2.setAttributeName("zona.nombre");
        codLookupControl2.setControllerMethodName("getTipoZona");
        codLookupControl2.setEnableCodBox(false);

        labelControl1.setLabel("recibo.numero");

        textControl8.setAttributeName("numero");
        textControl8.setLinkLabel(labelControl1);
        textControl8.setRequired(true);
        textControl8.setTrimText(true);
        textControl8.setUpperCase(true);

        labelControl19.setLabel("asegurado");

        codLookupControl5.setAttributeName("asegurado.rif.cedulaCompleta");
        codLookupControl5.setControllerMethodName("getPersonaNueva");
        codLookupControl5.setMaxCharacters(24);
        codLookupControl5.setRequired(true);

        labelControl14.setLabel("recibo.comisionTotal");

        currencyControl6.setAttributeName("comision");
        currencyControl6.setDecimals(2);
        currencyControl6.setLinkLabel(labelControl3);
        currencyControl6.setRequired(true);

        labelControl26.setLabel("recibo.cobrador");

        codLookupControl6.setAttributeName("cobrador2.nombreCorto");
        codLookupControl6.setAutoCompletitionWaitTime(1000L);
        codLookupControl6.setControllerMethodName("getPersonaNueva");
        codLookupControl6.setMaxCharacters(24);
        codLookupControl6.setRequired(true);

        labelControl38.setLabel("recibo.porcComiCob");

        textControl16.setAttributeName("certificado");
        textControl16.setLinkLabel(labelControl1);
        textControl16.setTrimText(true);
        textControl16.setUpperCase(true);

        labelControl39.setLabel("recibo.certificado");

        numericControl1.setAttributeName("porcComiCob");
        numericControl1.setDecimals(2);
        numericControl1.setRequired(true);
        numericControl1.setToolTipText("% de la comision total que le corresponde al Cobrador");

        codLookupControl7.setAttributeName("ejecutivo.nombreCorto");
        codLookupControl7.setControllerMethodName("getPersonaNueva");
        codLookupControl7.setMaxCharacters(24);
        codLookupControl7.setRequired(true);

        labelControl41.setLabel("ejecutivo");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(labelControl19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(labelControl26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelControl39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelControl1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(textControl16, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currencyControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(currencyControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(labelControl14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(labelControl38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelControl41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelControl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelControl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelControl13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codLookupControl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(currencyControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(currencyControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(codLookupControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl1, labelControl13, labelControl14, labelControl19, labelControl2, labelControl26, labelControl3, labelControl38, labelControl39, labelControl4, labelControl5, labelControl6});

        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textControl16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codLookupControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl2, codLookupControl5, codLookupControl6, currencyControl1, currencyControl2, currencyControl3, currencyControl4, currencyControl5, currencyControl6, labelControl1, labelControl13, labelControl14, labelControl19, labelControl2, labelControl26, labelControl3, labelControl38, labelControl39, labelControl4, labelControl5, labelControl6, textControl16, textControl8});

        jPanel3.add(jPanel18);

        labelControl7.setLabel("fechaRecepcion");

        dateControl1.setAttributeName("fechaRecepcion");

        labelControl8.setLabel("fechaEmision");

        dateControl2.setAttributeName("fechaEmision");

        labelControl9.setLabel("vigenciaDesde");

        labelControl10.setLabel("vigenciaHasta");

        labelControl11.setLabel("fechaCobro");

        labelControl12.setLabel("fechaPagoComision");

        checkBoxControl2.setText("anulado");
        checkBoxControl2.setAttributeName("anulado");
        checkBoxControl2.setEnabledOnInsert(false);
        checkBoxControl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxControl2ActionPerformed(evt);
            }
        });

        dateControl3.setAttributeName("vigenciaDesde");
        dateControl3.setLinkLabel(labelControl9);
        dateControl3.setRequired(true);

        dateControl4.setAttributeName("vigenciaHasta");
        dateControl4.setLinkLabel(labelControl10);
        dateControl4.setRequired(true);
        dateControl4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateControl4FocusGained(evt);
            }
        });

        dateControl5.setAttributeName("fechaCobro");

        dateControl6.setAttributeName("fechaPagoComision");

        dateControl7.setAttributeName("fechaAnulacion");
        dateControl7.setEnabledOnEdit(false);
        dateControl7.setEnabledOnInsert(false);

        labelControl27.setLabel("estatus");

        comboBoxControl1.setAttributeName("estatus");
        comboBoxControl1.setDomainId(Dominios.EstatusRecibo().getDomainId());
        comboBoxControl1.setEnabledOnEdit(false);
        comboBoxControl1.setEnabledOnInsert(false);

        textControl9.setAttributeName("asegurado.nombreLargo");
        textControl9.setEnabledOnEdit(false);
        textControl9.setEnabledOnInsert(false);

        comboBoxControl4.setAttributeName("tipoRecibo");
        comboBoxControl4.setDomainId(Dominios.TipoRecibo().getDomainId());

        labelControl29.setLabel("tipoRecibo");

        textControl12.setAttributeName("cobrador2.nombreLargo");
        textControl12.setEnabledOnEdit(false);
        textControl12.setEnabledOnInsert(false);

        comboBoxControl2.setAttributeName("tipoVigencia");
        comboBoxControl2.setDomainId(Dominios.TipoVigencia().getDomainId());

        labelControl40.setLabel("recibo.tipoVigencia");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textControl12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(textControl9, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelControl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkBoxControl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelControl40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(dateControl7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(comboBoxControl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(labelControl29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkBoxControl2, labelControl10, labelControl11, labelControl12, labelControl27, labelControl29, labelControl7, labelControl8, labelControl9});

        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(textControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textControl12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel19Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkBoxControl2, comboBoxControl1, comboBoxControl4, dateControl1, dateControl2, dateControl3, dateControl4, dateControl5, dateControl6, dateControl7, labelControl10, labelControl11, labelControl12, labelControl27, labelControl29, labelControl7, labelControl8, labelControl9});

        jPanel3.add(jPanel19);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
                .addContainerGap())
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Especificos", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));

        textAreaControl1.setAttributeName("bienAseguradoDescrip");
        textAreaControl1.setMaxCharacters(2048);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textAreaControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bien Asegurado", jPanel23);

        gridControl8.setDeleteButton(deleteButton13);
        gridControl8.setEditButton(editButton13);
        gridControl8.setFunctionId("reciboAsegurados");
        gridControl8.setInsertButton(insertButton13);
        gridControl8.setMaxNumberOfRowsOnInsert(99);
        gridControl8.setReloadButton(reloadButton13);
        gridControl8.setSaveButton(saveButton13);
        gridControl8.setShowFilterPanelOnGrid(true);
        gridControl8.setValueObjectClassName(CoberturasRecibo.class.getName());

        decimalColumn16.setColumnName("id");
        decimalColumn16.setColumnRequired(false);
        decimalColumn16.setColumnSortable(true);
        decimalColumn16.setPreferredWidth(40);
        gridControl8.getColumnContainer().add(decimalColumn16);

        codLookupColumn6.setColumnFilterable(true);
        codLookupColumn6.setColumnName("cobertura.nombre");
        codLookupColumn6.setColumnSortable(true);
        codLookupColumn6.setControllerMethodName("getRamosCoberturas");
        codLookupColumn6.setEditableOnEdit(true);
        codLookupColumn6.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(codLookupColumn6);

        dateColumn12.setColumnName("fechaDesda");
        dateColumn12.setColumnRequired(false);
        dateColumn12.setEditableOnEdit(true);
        dateColumn12.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(dateColumn12);

        dateColumn13.setColumnName("fechaHasta");
        dateColumn13.setColumnRequired(false);
        dateColumn13.setEditableOnEdit(true);
        dateColumn13.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(dateColumn13);

        decimalColumn17.setColumnName("sumaAsegurada");
        decimalColumn17.setDecimals(2);
        decimalColumn17.setEditableOnEdit(true);
        decimalColumn17.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(decimalColumn17);

        decimalColumn22.setColumnName("prima");
        decimalColumn22.setDecimals(2);
        decimalColumn22.setEditableOnEdit(true);
        decimalColumn22.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(decimalColumn22);

        decimalColumn23.setColumnName("deducible");
        decimalColumn23.setDecimals(2);
        decimalColumn23.setEditableOnEdit(true);
        decimalColumn23.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(decimalColumn23);

        decimalColumn24.setColumnName("tasa");
        decimalColumn24.setDecimals(2);
        decimalColumn24.setEditableOnEdit(true);
        decimalColumn24.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(decimalColumn24);

        textColumn13.setColumnName("observacion");
        textColumn13.setColumnRequired(false);
        textColumn13.setEditableOnEdit(true);
        textColumn13.setEditableOnInsert(true);
        gridControl8.getColumnContainer().add(textColumn13);

        jPanel36.setLayout(new java.awt.GridLayout(3, 2, 2, 2));
        jPanel36.add(insertButton13);
        jPanel36.add(editButton13);
        jPanel36.add(deleteButton13);
        jPanel36.add(saveButton13);
        jPanel36.add(reloadButton13);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gridControl8, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Coberturas", jPanel12);

        jPanel31.setLayout(new java.awt.GridLayout(1, 2));

        labelControl16.setLabel("financiadora");

        textControl2.setAttributeName("financiamiento.financiadora.nombreLargo");
        textControl2.setEnabledOnEdit(false);
        textControl2.setEnabledOnInsert(false);

        labelControl22.setLabel("numeroFF");

        codLookupControl3.setAttributeName("financiamiento.numeroFF");
        codLookupControl3.setLinkLabel(labelControl22);
        codLookupControl3.setMaxCharacters(20);

        labelControl17.setLabel("pagador");

        textControl3.setAttributeName("financiamiento.pagador.nombreLargo");
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(labelControl22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(textControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl16, labelControl17, labelControl22});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codLookupControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl3, labelControl16, labelControl17, labelControl22, textControl2, textControl3});

        jPanel31.add(jPanel25);

        labelControl25.setLabel("inicialFinanciamiento");

        currencyControl7.setAttributeName("financiamiento.inicialFinanciamiento");
        currencyControl7.setDecimals(2);
        currencyControl7.setEnabledOnEdit(false);
        currencyControl7.setEnabledOnInsert(false);

        dateControl9.setAttributeName("financiamiento.fechaPagoInicial");
        dateControl9.setEnabledOnEdit(false);
        dateControl9.setEnabledOnInsert(false);

        labelControl24.setLabel("fechaPagoInicial");

        checkBoxControl3.setText("anulado");
        checkBoxControl3.setAttributeName("financiamiento.anuladoF");
        checkBoxControl3.setEnabledOnEdit(false);
        checkBoxControl3.setEnabledOnInsert(false);

        dateControl10.setAttributeName("financiamiento.fechaAnulacionF");
        dateControl10.setEnabledOnEdit(false);
        dateControl10.setEnabledOnInsert(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateControl9, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(dateControl10, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(currencyControl7, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkBoxControl3, labelControl24, labelControl25});

        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkBoxControl3, currencyControl7, dateControl10, dateControl9, labelControl24, labelControl25});

        jPanel31.add(jPanel26);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Financiamiento", jPanel24);

        gridControl2.setDeleteButton(deleteButton10);
        gridControl2.setEditButton(editButton10);
        gridControl2.setInsertButton(insertButton10);
        gridControl2.setMaxNumberOfRowsOnInsert(9);
        gridControl2.setReloadButton(reloadButton10);
        gridControl2.setSaveButton(saveButton10);
        gridControl2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridControl2.setValueObjectClassName(Distribucion.class.getName());

        decimalColumn8.setColumnName("id");
        decimalColumn8.setColumnRequired(false);
        decimalColumn8.setPreferredWidth(40);
        gridControl2.getColumnContainer().add(decimalColumn8);

        codLookupColumn2.setColumnFilterable(true);
        codLookupColumn2.setColumnName("cobrador.rif.cedulaCompleta");
        codLookupColumn2.setColumnSortable(true);
        codLookupColumn2.setControllerMethodName("getPersonaNueva");
        codLookupColumn2.setEditableOnEdit(true);
        codLookupColumn2.setEditableOnInsert(true);
        codLookupColumn2.setHeaderColumnName("rif.cedulaCompleta");
        gridControl2.getColumnContainer().add(codLookupColumn2);

        textColumn6.setColumnName("cobrador.nombreLargo");
        textColumn6.setHeaderColumnName("cobrador");
        textColumn6.setPreferredWidth(160);
        gridControl2.getColumnContainer().add(textColumn6);

        percentageColumn1.setColumnName("porComision");
        percentageColumn1.setDecimals(3);
        percentageColumn1.setEditableOnEdit(true);
        percentageColumn1.setEditableOnInsert(true);
        percentageColumn1.setPreferredWidth(80);
        gridControl2.getColumnContainer().add(percentageColumn1);

        percentageColumn2.setColumnName("porBono1");
        percentageColumn2.setDecimals(3);
        percentageColumn2.setEditableOnEdit(true);
        percentageColumn2.setEditableOnInsert(true);
        percentageColumn2.setPreferredWidth(80);
        gridControl2.getColumnContainer().add(percentageColumn2);

        percentageColumn3.setColumnName("porBono2");
        percentageColumn3.setDecimals(3);
        percentageColumn3.setEditableOnEdit(true);
        percentageColumn3.setEditableOnInsert(true);
        percentageColumn3.setPreferredWidth(80);
        gridControl2.getColumnContainer().add(percentageColumn3);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(insertButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(insertButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(editButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(deleteButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saveButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(reloadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        labelControl23.setLabel("Tipo de Distribucion");

        codLookupControl4.setAttributeName("tipoDistribucionNombre");
        codLookupControl4.setEnabledOnInsert(false);
        codLookupControl4.setMaxCharacters(20);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelControl23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codLookupControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codLookupControl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupControl4, labelControl23});

        jPanel32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel32.setLayout(new java.awt.GridLayout(1, 0));

        labelControl42.setLabel("comisionPagada");

        currencyControl8.setAttributeName("comisionPagada");
        currencyControl8.setDecimals(2);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelControl42, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currencyControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel32.add(jPanel37);

        currencyControl9.setAttributeName("bonoPagado");
        currencyControl9.setDecimals(2);

        labelControl43.setLabel("bonoPagado");

        labelControl44.setLabel("totalPagado");

        currencyControl10.setAttributeName("totalPagado");
        currencyControl10.setDecimals(2);
        currencyControl10.setEnabledOnEdit(false);
        currencyControl10.setEnabledOnInsert(false);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addComponent(labelControl43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl9, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                        .addComponent(labelControl44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyControl10, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel32.add(jPanel38);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(gridControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(gridControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Distribucion de Comision", jPanel27);

        gridControl6.setDeleteButton(deleteButton9);
        gridControl6.setEditButton(editButton9);
        gridControl6.setEditOnSingleRow(true);
        gridControl6.setInsertButton(insertButton9);
        gridControl6.setMaxNumberOfRowsOnInsert(4);
        gridControl6.setReloadButton(reloadButton9);
        gridControl6.setSaveButton(saveButton9);
        gridControl6.setValueObjectClassName(Devolucion.class.getName());

        decimalColumn7.setColumnName("id");
        decimalColumn7.setColumnRequired(false);
        decimalColumn7.setPreferredWidth(40);
        gridControl6.getColumnContainer().add(decimalColumn7);

        textColumn5.setColumnFilterable(true);
        textColumn5.setColumnName("numero");
        textColumn5.setColumnSortable(true);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(textColumn5);

        dateColumn3.setColumnFilterable(true);
        dateColumn3.setColumnName("fecha");
        dateColumn3.setColumnSortable(true);
        dateColumn3.setEditableOnEdit(true);
        dateColumn3.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(dateColumn3);

        comboColumn2.setColumnFilterable(true);
        comboColumn2.setColumnName("tipo");
        comboColumn2.setColumnSortable(true);
        comboColumn2.setDomainId(Dominios.TipoDevolucion().getDomainId());
        comboColumn2.setEditableOnEdit(true);
        comboColumn2.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(comboColumn2);

        currencyColumn2.setColumnFilterable(true);
        currencyColumn2.setColumnName("primaDevuelta");
        currencyColumn2.setColumnSortable(true);
        currencyColumn2.setDecimals(2);
        currencyColumn2.setEditableOnEdit(true);
        currencyColumn2.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(currencyColumn2);

        currencyColumn3.setColumnFilterable(true);
        currencyColumn3.setColumnName("montoDevuelto");
        currencyColumn3.setColumnSortable(true);
        currencyColumn3.setDecimals(2);
        currencyColumn3.setEditableOnEdit(true);
        currencyColumn3.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(currencyColumn3);

        currencyColumn4.setColumnFilterable(true);
        currencyColumn4.setColumnName("extornoComision");
        currencyColumn4.setColumnSortable(true);
        currencyColumn4.setDecimals(2);
        currencyColumn4.setEditableOnEdit(true);
        currencyColumn4.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(currencyColumn4);

        currencyColumn5.setColumnFilterable(true);
        currencyColumn5.setColumnName("extornoCobrador");
        currencyColumn5.setColumnSortable(true);
        currencyColumn5.setDecimals(2);
        currencyColumn5.setEditableOnEdit(true);
        currencyColumn5.setEditableOnInsert(true);
        gridControl6.getColumnContainer().add(currencyColumn5);

        currencyColumn6.setColumnFilterable(true);
        currencyColumn6.setColumnName("extornoBono1");
        currencyColumn6.setColumnSortable(true);
        currencyColumn6.setDecimals(2);
        currencyColumn6.setEditableOnEdit(true);
        currencyColumn6.setEditableOnInsert(true);
        currencyColumn6.setHeaderColumnName("devolucion.extornoBono1");
        gridControl6.getColumnContainer().add(currencyColumn6);
        currencyColumn6.getAccessibleContext().setAccessibleName("devolucion.extornoBono1");

        currencyColumn7.setColumnFilterable(true);
        currencyColumn7.setColumnName("extornoBono2");
        currencyColumn7.setColumnSortable(true);
        currencyColumn7.setDecimals(2);
        currencyColumn7.setEditableOnEdit(true);
        currencyColumn7.setEditableOnInsert(true);
        currencyColumn7.setHeaderColumnName("devolucion.extornoBono2");
        gridControl6.getColumnContainer().add(currencyColumn7);
        currencyColumn7.getAccessibleContext().setAccessibleName("devolucion.extornoBono2");

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
                    .addComponent(gridControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl6, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Devoluciones", jPanel13);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        jPanel16.setLayout(new java.awt.GridLayout(3, 2, 2, 2));
        jPanel16.add(insertButton7);
        jPanel16.add(deleteButton7);
        jPanel16.add(saveButton7);
        jPanel16.add(reloadButton7);

        gridControl5.setDeleteButton(deleteButton7);
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
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos Anexos"));

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

        dateColumn4.setColumnName("fechaVencimiento");
        dateColumn4.setColumnRequired(false);
        dateColumn4.setEditableOnEdit(true);
        dateColumn4.setEditableOnInsert(true);
        gridControl4.getColumnContainer().add(dateColumn4);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(453, Short.MAX_VALUE))
            .addComponent(gridControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl4, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Generales", jPanel9);

        jButton1.setText("Datos de Financiamiento");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/36.png"))); // NOI18N
        jButton2.setToolTipText("Enviar SMS al Asegurado");
        jButton2.setPreferredSize(new java.awt.Dimension(33, 33));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        jButton3.setToolTipText("Enviar Email al Contratante");
        jButton3.setPreferredSize(new java.awt.Dimension(33, 33));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(saveButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(reloadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxControl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxControl2ActionPerformed
        setActivo(dateControl7, (Boolean) checkBoxControl2.getValue(), (Boolean) checkBoxControl2.getValue());
    }//GEN-LAST:event_checkBoxControl2ActionPerformed

    public void setVisiblePaneles(boolean bo) {

        if(bo)
        {
            jTabbedPane1.remove(jPanel24);

            jTabbedPane1.remove(jPanel27);

            jTabbedPane1.remove(jPanel13);

            jTabbedPane1.remove(jPanel9);
//            jTabbedPane1.remove(jPanel32);
            jTabbedPane1.remove(jPanel36);
        }else{
            jTabbedPane1.add(jPanel24);
            jTabbedPane1.add(jPanel27);
            jTabbedPane1.add(jPanel13);
            jTabbedPane1.add(jPanel9);
//            jTabbedPane1.add(jPanel32);
            jTabbedPane1.remove(jPanel36);
        }
    }

    private void dateControl4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateControl4FocusGained
        if (dateControl4.getValue() == null && dateControl3.getValue() != null) {
            Date d = (Date) dateControl3.getValue();
            d.setYear(d.getYear() + 1);
            dateControl4.setValue(d);
        }
    }//GEN-LAST:event_dateControl4FocusGained

    private void currencyControl5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_currencyControl5FocusGained
        if (currencyControl5.getValue() == null && currencyControl1.getValue() != null) {
            currencyControl5.setValue(currencyControl1.getValue());
        }
    }//GEN-LAST:event_currencyControl5FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 6) {
//            textAreaControl2.setVisible(false);
//            SuperusuarioLoginDialog s = new SuperusuarioLoginDialog(textAreaControl2);
//            ClientUtils.centerDialog(MDIFrame.getInstance(), s);
//            s.setVisible(true);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    @Override
    public void inicializar(FormController formController, boolean addToMDIFrame) {
        inicializar((ReciboDetailController) formController, addToMDIFrame);
    }

    public void inicializar(ReciboDetailController formController, boolean addToMDIFrame) {
        initComponents();

        if (!General.usuario.getSuperusuario()) {
           // System.out.println("removido");
            jTabbedPane1.remove(jPanel27);
        }

//        jPanel8.setVisible(false);
        copyButton1.setVisible(false);

        form1.addLinkedPanel(jPanel7);
//        form1.addLinkedPanel(jPanel8);
        form1.addLinkedPanel(jPanel30);
        form1.addLinkedPanel(jPanel31);
        form1.addLinkedPanel(jPanel32);

        DefaultLookupControllerPorNombre lookupTipoDistrib = new DefaultLookupControllerPorNombre(
                TipoDistribucion.class.getName());
        lookupTipoDistrib.addLookup2ParentLink("tipoDistribucion");
        codLookupControl4.setLookupController(lookupTipoDistrib);

        DefaultLookupController lookupGrupoPoliza = new DefaultLookupController(
                TipoZona.class.getName());
        lookupGrupoPoliza.addLookup2ParentLink("zona");
        codLookupControl2.setLookupController(lookupGrupoPoliza);

        PersonaLookupController lookupAsegurado = new PersonaLookupController("ASE");
        lookupAsegurado.addLookup2ParentLink("asegurado");
        codLookupControl5.setLookupController(lookupAsegurado);
        codLookupControl5.setOpenDetail("asegurado", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
        codLookupControl5.setNewDetail("asegurado", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{form1, "asegurado", new Object[]{"ASE"}}, 0);

        PersonaLookupControllerPorNombre lookupCobrador = new PersonaLookupControllerPorNombre("COB");
        lookupCobrador.addLookup2ParentLink("cobrador2");
        lookupCobrador.addLookup2ParentLink("nombreCorto", "cobrador2.nombreCorto");
        codLookupControl6.setLookupController(lookupCobrador);
        codLookupControl6.setOpenDetail("cobrador2", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
        codLookupControl6.setNewDetail("cobrador2", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{form1, "cobrador2", new Object[]{"COB"}}, 0);

        PersonaLookupController lookupEjecutivo =
                new PersonaLookupController("EJE");
        lookupEjecutivo.addLookup2ParentLink("ejecutivo");
        codLookupControl7.setLookupController(lookupEjecutivo);
        codLookupControl7.setOpenDetail("ejecutivo", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
        codLookupControl7.setNewDetail("ejecutivo", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{form1, "ejecutivo", new Object[]{"EJE"}}, 0);

//        PersonaLookupControllerPorNombre lookupCompania = new PersonaLookupControllerPorNombre("SEG");
//        lookupCompania.addLookup2ParentLink("poliza.compania");
//        codLookupControl7.setLookupController(lookupCompania);
//        codLookupControl7.setOpenDetail("poliza.compania", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
//
//        PersonaLookupController lookupContratante = new PersonaLookupController("CON");
//        lookupContratante.addLookup2ParentLink("poliza.contratante");
//        codLookupControl9.setLookupController(lookupContratante);
//        codLookupControl9.setOpenDetail("poliza.contratante", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);

//        DefaultLookupController lookupVehiculo = new VehiculoLookupController();
//        codLookupControl8.setLookupController(lookupVehiculo);
//        codLookupControl8.setOpenDetail("vehiculo", VehiculoDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class}, new Object[]{VehiculosDetailFrame.class.getName(), null, null, false}, 2);
//        codLookupControl8.setNewDetail("vehiculo", NuevoVehiculoDialog.class.getName(), new Class[]{Form.class, String.class}, new Object[]{null, null}, 0);

        RamoCoberturaLookupController coberturasLoock = new RamoCoberturaLookupController();
        coberturasLoock.addLookup2ParentLink("cobertura");
            codLookupColumn6.setLookupController(coberturasLoock);

        PolizaLookupController lookupPoliza = new PolizaLookupController();
        lookupPoliza.addLookup2ParentLink("poliza");
        codLookupControl1.setLookupController(lookupPoliza);
        codLookupControl1.setOpenDetail("poliza", PolizaDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class, Boolean.class},
                new Object[]{PolizaDetailFrame.class.getName(), null, null, true, false}, 2);

        FinanciamientoLookupController lookupFinanciamiento = new FinanciamientoLookupController();
        lookupFinanciamiento.addLookup2ParentLink("financiamiento");
        codLookupControl3.setLookupController(lookupFinanciamiento);
        codLookupControl3.setOpenDetail("financiamiento", FinanciamientoDetailController.class.getName(), new Class[]{String.class, GridControl.class, BeanVO.class, Boolean.class, Recibo.class, Boolean.class}, new Object[]{FinanciamientoDetailFrame.class.getName(), null, null, true, null, false}, 2);

        controlador.documentosAnexos.TipoDocumentoLookupController lookupDocumentoAnexo2 =
                new TipoDocumentoLookupController(Dominios.Modulos.RECIBOS);
        lookupDocumentoAnexo2.addLookup2ParentLink("tipoDocumento");
        codLookupColumn3.setLookupController(lookupDocumentoAnexo2);

        org.openswing.swing.table.columns.client.PictureCaptureColumn pcc = new org.openswing.swing.table.columns.client.PictureCaptureColumn();
        pcc.setColumnName("file");
        pcc.setEditableOnInsert(true);
        pcc.setEditableOnEdit(false);
        pcc.setFileNameAttributeName("fileName");
        pcc.setPreferredWidth(220);
        gridControl4.getColumnContainer().add(pcc);
        controllerDocumentos = new DefaultDocumentosAnexosGridController(Recibo.class, gridControl4);
        buttonColumn2.addActionListener(controllerDocumentos);
        gridControl4.setController(controllerDocumentos);
        gridControl4.setGridDataLocator(controllerDocumentos);

        controllerDistribuciones =
                new DistribucionGridInternalFrame2(Recibo.class.getName(), "getDistribuciones", gridControl2, null);
        gridControl2.setGridDataLocator(controllerDistribuciones);
        gridControl2.setController(controllerDistribuciones);

//        controllerBeneficiarios =
//                new BeneficiarioGridInternalController(Recibo.class.getName(), "getBeneficiarios2", gridControl1, null);
//        gridControl1.setGridDataLocator(controllerBeneficiarios);
//        gridControl1.setController(controllerBeneficiarios);

        controllerDevoluciones =
                new DevolucionesGridInternalController(Recibo.class.getName(), "getDevoluciones", gridControl6, null);
        gridControl6.setGridDataLocator(controllerDevoluciones);
        gridControl6.setController(controllerDevoluciones);

        controllerObservaciones =
                new DefaultGridInternalController(Recibo.class.getName(), "getObservaciones", gridControl5, null);
        gridControl5.setGridDataLocator(controllerObservaciones);
        gridControl5.setController(controllerObservaciones);

        controllerCoberturas =
                new CoberturasReciboGridInternalController(ReciboPersonas.class.getName(), "getCoberturas", gridControl8, null);
        gridControl8.setGridDataLocator(controllerCoberturas);
        gridControl8.setController(controllerCoberturas);

//        controllerCoberturas =
//                new CoberturasReciboGridInternalController(Recibo.class.getName(), "getCoberturas", gridCobertura, null);
//        gridCobertura.setGridDataLocator(controllerCoberturas);
//        gridCobertura.setController(controllerCoberturas);

        jButton1.addActionListener(formController);
        jButton2.addActionListener(formController);
        jButton3.addActionListener(formController);

        PersonaLookupController cobradorDistrib = new PersonaLookupController("COB");
        cobradorDistrib.addLookup2ParentLink("cobrador");
        codLookupColumn2.setLookupController(cobradorDistrib);

//        PersonaLookupController plc = new PersonaLookupController("BEN");
//        plc.addLookup2ParentLink("beneficiario");
//        codLookupColumn1.setLookupController(plc);

        //de sucursal
//        DefaultLookupController lookupcobertura = new DefaultLookupController(
//                CoberturasRecibo.class.getName());
//        lookupcobertura.addLookup2ParentLink("cobertura");
//        codLookupColumn8.setLookupController(lookupcobertura);

        form1.setFormController(formController);
        form1.setCreateInnerVO(false);
        if (addToMDIFrame) {
            pack();
        } else {
            setBounds(0, 0, 0, 0);
        }
        MDIFrame.add(this);
    }

    @Override
    public void saveGridsData() {
//        gridControl1.getSaveButton().doClick();
        gridControl5.getSaveButton().doClick();
        gridControl4.getSaveButton().doClick();
        gridControl6.getSaveButton().doClick();
        gridControl2.getSaveButton().doClick();
        gridControl8.getSaveButton().doClick();
//        gridCobertura.getSaveButton().doClick();
    }

    @Override
    public void reloadGridsData() {
//        gridControl1.reloadData();
        gridControl5.reloadData();
        gridControl4.reloadData();
        gridControl6.reloadData();
        gridControl2.reloadData();
        gridControl8.reloadData();
//        gridCobertura.reloadData();
    }

    @Override
    public void clearGridsData() {
//        gridControl1.clearData();
        gridControl5.clearData();
        gridControl4.clearData();
        gridControl6.clearData();
        gridControl2.clearData();
        gridControl8.clearData();
//        gridCobertura.clearData();
    }

    @Override
    public void setOwnerVO(BeanVO beanVO) {
        controllerObservaciones.setBeanVO(beanVO);
//        controllerBeneficiarios.setBeanVO(beanVO);
        controllerDevoluciones.setBeanVO(beanVO);
        controllerDistribuciones.setBeanVO(beanVO);
        controllerCoberturas.setBeanVO(beanVO);
//        controllerCoberturas.setBeanVO(beanVO);
        Long id = null;
        if (beanVO != null) {
            id = ((Recibo) beanVO).getId();
        }
        controllerDocumentos.setBeanVO(beanVO, id);
        if (((Recibo) beanVO).getFinanciado()) {
            jButton1.setBackground(Color.GREEN);
            jButton1.setText("Datos de Financiamiento");
        } else {
            jButton1.setText("Nuevo Financiamiento");
        }

//        boolean v = (((Recibo) beanVO).getPoliza().getRamoPoliza().getRamoContable().equals(Dominios.RamoContable.VEHICULO));
//        jPanel8.setVisible(v);

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
            //setVisiblePaneles(false);
        } else {
            setEnableGridInternalButtons(true);
        }
    }

    private void setEnableGridInternalButtons(boolean enabled) {
        jPanel14.setVisible(enabled);
        jPanel16.setVisible(enabled);
//        jPanel20.setVisible(enabled);
        jPanel22.setVisible(enabled);
        jPanel29.setVisible(enabled);
        jButton1.setEnabled(enabled);
        jPanel36.setVisible(enabled);
    }

//    public void setVisibleVehiculo(boolean visible) {
//        jPanel8.setVisible(visible);
//        if (form1.getMode() != 0) {
//            setActivo(codLookupControl8, visible, visible);
//        }
//        codLookupControl8.setRequired(visible);
////        if (!visible) {
////            setActivo(textControl11, visible, visible);
////            setActivo(textControl10, visible, visible);
////            setActivo(numericControl3, visible, visible);
////        }
//    }

//    public void setVisibleBeneficiarios(boolean visible) {
//        jPanel8.setVisible(!visible);
//        jPanel10.setVisible(visible);
//        pack();
//    }

    public DistribucionGridInternalFrame2 getGridDistribucionController() {
        return (DistribucionGridInternalFrame2) controllerDistribuciones;
    }

    public JButton getFinanciamientoButton() {
        return jButton1;
    }

    public JButton getSMSButton() {
        return jButton2;
    }

    public JButton getEmailButton() {
        return jButton3;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ButtonColumn buttonColumn2;
    private org.openswing.swing.client.CheckBoxControl checkBoxControl2;
    private org.openswing.swing.client.CheckBoxControl checkBoxControl3;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn2;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn3;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn6;
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.CodLookupControl codLookupControl3;
    private org.openswing.swing.client.CodLookupControl codLookupControl4;
    private org.openswing.swing.client.CodLookupControl codLookupControl5;
    private org.openswing.swing.client.CodLookupControl codLookupControl6;
    private org.openswing.swing.client.CodLookupControl codLookupControl7;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl2;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl4;
    private org.openswing.swing.table.columns.client.ComboColumn comboColumn2;
    private org.openswing.swing.client.CopyButton copyButton1;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn2;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn3;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn4;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn5;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn6;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn7;
    private org.openswing.swing.client.CurrencyControl currencyControl1;
    private org.openswing.swing.client.CurrencyControl currencyControl10;
    private org.openswing.swing.client.CurrencyControl currencyControl2;
    private org.openswing.swing.client.CurrencyControl currencyControl3;
    private org.openswing.swing.client.CurrencyControl currencyControl4;
    private org.openswing.swing.client.CurrencyControl currencyControl5;
    private org.openswing.swing.client.CurrencyControl currencyControl6;
    private org.openswing.swing.client.CurrencyControl currencyControl7;
    private org.openswing.swing.client.CurrencyControl currencyControl8;
    private org.openswing.swing.client.CurrencyControl currencyControl9;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn12;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn13;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn3;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn4;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl10;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.client.DateControl dateControl3;
    private org.openswing.swing.client.DateControl dateControl4;
    private org.openswing.swing.client.DateControl dateControl5;
    private org.openswing.swing.client.DateControl dateControl6;
    private org.openswing.swing.client.DateControl dateControl7;
    private org.openswing.swing.client.DateControl dateControl9;
    private org.openswing.swing.table.columns.client.DateTimeColumn dateTimeColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn16;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn17;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn22;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn23;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn24;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn7;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn8;
    private org.openswing.swing.client.DeleteButton deleteButton10;
    private org.openswing.swing.client.DeleteButton deleteButton13;
    private org.openswing.swing.client.DeleteButton deleteButton6;
    private org.openswing.swing.client.DeleteButton deleteButton7;
    private org.openswing.swing.client.DeleteButton deleteButton9;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.client.EditButton editButton10;
    private org.openswing.swing.client.EditButton editButton13;
    private org.openswing.swing.client.EditButton editButton6;
    private org.openswing.swing.client.EditButton editButton9;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl2;
    private org.openswing.swing.client.GridControl gridControl4;
    private org.openswing.swing.client.GridControl gridControl5;
    private org.openswing.swing.client.GridControl gridControl6;
    private org.openswing.swing.client.GridControl gridControl8;
    private org.openswing.swing.client.InsertButton insertButton10;
    private org.openswing.swing.client.InsertButton insertButton13;
    private org.openswing.swing.client.InsertButton insertButton6;
    private org.openswing.swing.client.InsertButton insertButton7;
    private org.openswing.swing.client.InsertButton insertButton9;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl12;
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
    private org.openswing.swing.client.LabelControl labelControl24;
    private org.openswing.swing.client.LabelControl labelControl25;
    private org.openswing.swing.client.LabelControl labelControl26;
    private org.openswing.swing.client.LabelControl labelControl27;
    private org.openswing.swing.client.LabelControl labelControl29;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl38;
    private org.openswing.swing.client.LabelControl labelControl39;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl40;
    private org.openswing.swing.client.LabelControl labelControl41;
    private org.openswing.swing.client.LabelControl labelControl42;
    private org.openswing.swing.client.LabelControl labelControl43;
    private org.openswing.swing.client.LabelControl labelControl44;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.table.columns.client.PercentageColumn percentageColumn1;
    private org.openswing.swing.table.columns.client.PercentageColumn percentageColumn2;
    private org.openswing.swing.table.columns.client.PercentageColumn percentageColumn3;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.client.ReloadButton reloadButton10;
    private org.openswing.swing.client.ReloadButton reloadButton13;
    private org.openswing.swing.client.ReloadButton reloadButton6;
    private org.openswing.swing.client.ReloadButton reloadButton7;
    private org.openswing.swing.client.ReloadButton reloadButton9;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.SaveButton saveButton10;
    private org.openswing.swing.client.SaveButton saveButton13;
    private org.openswing.swing.client.SaveButton saveButton6;
    private org.openswing.swing.client.SaveButton saveButton7;
    private org.openswing.swing.client.SaveButton saveButton9;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn13;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.client.TextControl textControl12;
    private org.openswing.swing.client.TextControl textControl16;
    private org.openswing.swing.client.TextControl textControl17;
    private org.openswing.swing.client.TextControl textControl18;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl6;
    private org.openswing.swing.client.TextControl textControl8;
    private org.openswing.swing.client.TextControl textControl9;
    // End of variables declaration//GEN-END:variables
}
