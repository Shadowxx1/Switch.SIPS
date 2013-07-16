package com.productores.caja.vista;

import com.productores.caja.controlador.AsientoDetailController;
import com.productores.caja.controlador.AsientoGridInternalController;
import com.productores.caja.modelo.dominio.TipoIngresoCaja;
import com.productores.caja.modelo.dominio.TipoMovimiento;
import com.productores.caja.modelo.maestra.Asiento;
import com.productores.caja.modelo.maestra.Liquidacion;
import controlador.documentosAnexos.TipoDocumentoLookupController;
import controlador.personas.PersonaLookupControllerPorNombre;
import controlador.personas.PersonasDetailController;
import controlador.util.DefaultDocumentosAnexosGridController;
import controlador.util.DefaultGridInternalController;
import controlador.util.DefaultLookupController;
import modelo.Dominios;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.personas.maestra.Rif;
import modelo.util.bean.BeanVO;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.client.InsertButton;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.java.Consts;
import vista.personas.RifDialog;
import vista.util.DefaultDetailFrame;

/**
 *
 * @author Nelson Moncada
 */
public class LiquidacionDetailFrame extends DefaultDetailFrame {

    private DefaultGridInternalController controllerObservaciones;
    private DefaultDocumentosAnexosGridController controllerDocumentosAnexosX;
    private DefaultGridInternalController controllerAsientos;
    private String titulo;

    public LiquidacionDetailFrame() {
    }

    public LiquidacionDetailFrame(String titulo) {
        this.titulo = titulo;
        setTitle(titulo);
    }

    public InsertButton getInsertMovimiento() {
        return insertMovimiento;
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        editButton3 = new org.openswing.swing.client.EditButton();
        saveButton3 = new org.openswing.swing.client.SaveButton();
        reloadButton3 = new org.openswing.swing.client.ReloadButton();
        form1 = new org.openswing.swing.form.client.Form();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        codLookupProductor = new org.openswing.swing.client.CodLookupControl();
        codLookupTipoIngreso = new org.openswing.swing.client.CodLookupControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        codLookupCobrador = new org.openswing.swing.client.CodLookupControl();
        jPanel5 = new javax.swing.JPanel();
        checkBoxControl1 = new org.openswing.swing.client.CheckBoxControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        numericControl3 = new org.openswing.swing.client.NumericControl();
        jPanel12 = new javax.swing.JPanel();
        gridMovimientos = new org.openswing.swing.client.GridControl();
        integerColumn3 = new org.openswing.swing.table.columns.client.IntegerColumn();
        codLookupTipoMovimiento = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        currencyColumn1 = new org.openswing.swing.table.columns.client.CurrencyColumn();
        jPanel13 = new javax.swing.JPanel();
        insertMovimiento = new org.openswing.swing.client.InsertButton();
        editButton6 = new org.openswing.swing.client.EditButton();
        deleteButton6 = new org.openswing.swing.client.DeleteButton();
        saveButton6 = new org.openswing.swing.client.SaveButton();
        reloadButton6 = new org.openswing.swing.client.ReloadButton();
        filterButton6 = new org.openswing.swing.client.FilterButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        insertButton7 = new org.openswing.swing.client.InsertButton();
        editButton7 = new org.openswing.swing.client.EditButton();
        deleteButton7 = new org.openswing.swing.client.DeleteButton();
        saveButton7 = new org.openswing.swing.client.SaveButton();
        reloadButton7 = new org.openswing.swing.client.ReloadButton();
        gridControl5 = new org.openswing.swing.client.GridControl();
        decimalColumn5 = new org.openswing.swing.table.columns.client.DecimalColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn8 = new org.openswing.swing.table.columns.client.TextColumn();
        dateTimeColumn3 = new org.openswing.swing.table.columns.client.DateTimeColumn();
        jPanel10 = new javax.swing.JPanel();
        gridControl3 = new org.openswing.swing.client.GridControl();
        buttonColumn1 = new org.openswing.swing.table.columns.client.ButtonColumn();
        integerColumn2 = new org.openswing.swing.table.columns.client.IntegerColumn();
        codLookupColumn2 = new org.openswing.swing.table.columns.client.CodLookupColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        dateColumn2 = new org.openswing.swing.table.columns.client.DateColumn();
        jPanel11 = new javax.swing.JPanel();
        insertButton5 = new org.openswing.swing.client.InsertButton();
        editButton5 = new org.openswing.swing.client.EditButton();
        deleteButton5 = new org.openswing.swing.client.DeleteButton();
        saveButton5 = new org.openswing.swing.client.SaveButton();
        reloadButton5 = new org.openswing.swing.client.ReloadButton();
        filterButton5 = new org.openswing.swing.client.FilterButton();

        setTitle("Liquidacion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reloadButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reloadButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        form1.setVOClassName(Liquidacion.class.getName());
        form1.setEditButton(editButton3);
        form1.setReloadButton(reloadButton3);
        form1.setSaveButton(saveButton3);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        labelControl2.setLabel("productor");

        labelControl3.setLabel("cobrador");

        labelControl5.setLabel("tipoIngreso");

        codLookupProductor.setAttributeName("productor.nombreCorto");
        codLookupProductor.setAutoCompletitionWaitTime(1000L);
        codLookupProductor.setControllerMethodName("getPersonaNueva");
        codLookupProductor.setLinkLabel(labelControl2);
        codLookupProductor.setMaxCharacters(10);
        codLookupProductor.setRequired(true);

        codLookupTipoIngreso.setAttributeName("tipoIngresoCaja.nombre");
        codLookupTipoIngreso.setControllerMethodName("getTipoIngreso");
        codLookupTipoIngreso.setLinkLabel(labelControl5);
        codLookupTipoIngreso.setMaxCharacters(10);
        codLookupTipoIngreso.setRequired(true);

        labelControl8.setLabel("liquidacion.estatus");

        labelControl7.setLabel("liquidacion.numero");

        textControl2.setAttributeName("numero");
        textControl2.setLinkLabel(labelControl7);
        textControl2.setRequired(true);
        textControl2.setTrimText(true);
        textControl2.setUpperCase(true);

        comboBoxControl1.setDomainId(Dominios.EstatusLiquidacion().getDomainId());

        codLookupCobrador.setAttributeName("cobrador.nombreCorto");
        codLookupCobrador.setControllerMethodName("getPersonaNueva");
        codLookupCobrador.setRequired(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(textControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupProductor, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupCobrador, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupTipoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl2, labelControl3, labelControl5, labelControl7, labelControl8});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupTipoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {codLookupProductor, codLookupTipoIngreso});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelControl2, labelControl3, labelControl5, labelControl7, labelControl8, textControl2});

        jPanel8.add(jPanel4);

        checkBoxControl1.setText("anulado");
        checkBoxControl1.setAttributeName("anulado");
        checkBoxControl1.setEnabledOnInsert(false);
        checkBoxControl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxControl1ActionPerformed(evt);
            }
        });

        dateControl2.setAttributeName("fechaAnulacion");
        dateControl2.setEnabledOnEdit(false);
        dateControl2.setEnabledOnInsert(false);

        labelControl4.setLabel("montoDebito");

        labelControl10.setLabel("fechaLiquidacion");

        dateControl1.setAttributeName("fechaIngreso");
        dateControl1.setLinkLabel(labelControl10);

        labelControl6.setLabel("montoCredito");

        labelControl9.setLabel("montoDiferencia");

        numericControl1.setAttributeName("debitos");
        numericControl1.setDecimals(2);

        numericControl2.setAttributeName("creditos");
        numericControl2.setDecimals(2);

        numericControl3.setAttributeName("diferencia");
        numericControl3.setDecimals(2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelControl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelControl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numericControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(dateControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(numericControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(labelControl9, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateControl2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(numericControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkBoxControl1, labelControl10, labelControl4, labelControl6, labelControl9});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(numericControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numericControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelControl9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numericControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {checkBoxControl1, dateControl1, dateControl2, labelControl10, labelControl4, labelControl6, labelControl9});

        jPanel8.add(jPanel5);

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos"));

        gridMovimientos.setDeleteButton(deleteButton6);
        gridMovimientos.setEditButton(editButton6);
        gridMovimientos.setFunctionId("liqMovimientos");
        gridMovimientos.setMaxNumberOfRowsOnInsert(4);
        gridMovimientos.setReloadButton(reloadButton6);
        gridMovimientos.setSaveButton(saveButton6);
        gridMovimientos.setValueObjectClassName(Asiento.class.getName());
        gridMovimientos.setVisibleStatusPanel(false);

        integerColumn3.setColumnName("id");
        integerColumn3.setColumnRequired(false);
        integerColumn3.setPreferredWidth(40);
        gridMovimientos.getColumnContainer().add(integerColumn3);

        codLookupTipoMovimiento.setColumnName("tipoMovimiento.nombre");
        codLookupTipoMovimiento.setEditableOnEdit(true);
        codLookupTipoMovimiento.setEditableOnInsert(true);
        gridMovimientos.getColumnContainer().add(codLookupTipoMovimiento);

        textColumn5.setColumnName("descripcion");
        textColumn5.setColumnRequired(false);
        textColumn5.setEditableOnEdit(true);
        textColumn5.setEditableOnInsert(true);
        gridMovimientos.getColumnContainer().add(textColumn5);

        currencyColumn1.setColumnName("monto");
        gridMovimientos.getColumnContainer().add(currencyColumn1);

        jPanel13.setLayout(new java.awt.GridLayout(3, 2, 2, 2));

        insertMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMovimientoActionPerformed(evt);
            }
        });
        jPanel13.add(insertMovimiento);
        jPanel13.add(editButton6);
        jPanel13.add(deleteButton6);
        jPanel13.add(saveButton6);
        jPanel13.add(reloadButton6);
        jPanel13.add(filterButton6);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(gridMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addComponent(form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Liquidacion", jPanel2);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        jPanel16.setLayout(new java.awt.GridLayout(3, 2, 2, 2));
        jPanel16.add(insertButton7);

        editButton7.setEnabled(false);
        jPanel16.add(editButton7);
        jPanel16.add(deleteButton7);
        jPanel16.add(saveButton7);
        jPanel16.add(reloadButton7);

        gridControl5.setDeleteButton(deleteButton7);
        gridControl5.setEditButton(editButton7);
        gridControl5.setFunctionId("Obser");
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

        dateTimeColumn3.setColumnName("auditoria.fechaInsert");
        dateTimeColumn3.setColumnRequired(false);
        gridControl5.getColumnContainer().add(dateTimeColumn3);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
            .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos Anexos"));

        gridControl3.setDeleteButton(deleteButton5);
        gridControl3.setEditButton(editButton5);
        gridControl3.setFunctionId("docAnex");
        gridControl3.setInsertButton(insertButton5);
        gridControl3.setMaxNumberOfRowsOnInsert(4);
        gridControl3.setReloadButton(reloadButton5);
        gridControl3.setSaveButton(saveButton5);
        gridControl3.setValueObjectClassName(Documento.class.getName());
        gridControl3.setVisibleStatusPanel(false);

        buttonColumn1.setColumnName("button");
        buttonColumn1.setEditableOnEdit(true);
        buttonColumn1.setEnableInReadOnlyMode(true);
        buttonColumn1.setPreferredWidth(20);
        buttonColumn1.setText("");
        gridControl3.getColumnContainer().add(buttonColumn1);

        integerColumn2.setColumnName("id");
        integerColumn2.setColumnRequired(false);
        integerColumn2.setPreferredWidth(40);
        gridControl3.getColumnContainer().add(integerColumn2);

        codLookupColumn2.setColumnName("tipoDocumento.nombre");
        codLookupColumn2.setControllerMethodName("getTipoDocAnex");
        codLookupColumn2.setEditableOnEdit(true);
        codLookupColumn2.setEditableOnInsert(true);
        gridControl3.getColumnContainer().add(codLookupColumn2);

        textColumn4.setColumnName("observacion");
        textColumn4.setColumnRequired(false);
        textColumn4.setEditableOnEdit(true);
        textColumn4.setEditableOnInsert(true);
        gridControl3.getColumnContainer().add(textColumn4);

        dateColumn2.setColumnName("fechaVencimiento");
        dateColumn2.setColumnRequired(false);
        dateColumn2.setEditableOnEdit(true);
        dateColumn2.setEditableOnInsert(true);
        gridControl3.getColumnContainer().add(dateColumn2);

        jPanel11.setLayout(new java.awt.GridLayout(3, 2, 2, 2));
        jPanel11.add(insertButton5);
        jPanel11.add(editButton5);
        jPanel11.add(deleteButton5);
        jPanel11.add(saveButton5);
        jPanel11.add(reloadButton5);
        jPanel11.add(filterButton5);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(gridControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Datos Generales", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void checkBoxControl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxControl1ActionPerformed
    setActivo(dateControl2, (Boolean) checkBoxControl1.getValue(), (Boolean) checkBoxControl1.getValue());
}//GEN-LAST:event_checkBoxControl1ActionPerformed

private void insertMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMovimientoActionPerformed
          new AsientoDetailController(null, ((Liquidacion)form1.getVOModel().getValueObject()).getProductor(),((Liquidacion)form1.getVOModel().getValueObject()) ,null);
}//GEN-LAST:event_insertMovimientoActionPerformed

    @Override
    public void inicializar(FormController formController, boolean addToMDIFrame) {
        initComponents();

        PersonaLookupControllerPorNombre lookupCompania = new PersonaLookupControllerPorNombre("PRD");
        lookupCompania.addLookup2ParentLink("productor");
        lookupCompania.addLookup2ParentLink("nombreCorto", "productor.nombreCorto");
        codLookupProductor.setLookupController(lookupCompania);
        codLookupProductor.setOpenDetail("productor", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
        codLookupProductor.setNewDetail("productor", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{null, null, new Object[]{"PRD"}}, 0);

        DefaultLookupController lookupTipoIngreso = new DefaultLookupController(TipoIngresoCaja.class.getName());
        lookupTipoIngreso.addLookup2ParentLink("tipoIngresoCaja");
        lookupTipoIngreso.addLookup2ParentLink("nombre", "tipoIngresoCaja.nombre");
        codLookupTipoIngreso.setLookupController(lookupTipoIngreso);

        PersonaLookupControllerPorNombre lookupCobrador = new PersonaLookupControllerPorNombre("COB");
        lookupCobrador.addLookup2ParentLink("cobrador");
        lookupCobrador.addLookup2ParentLink("nombreCorto", "cobrador.nombreCorto");
        codLookupCobrador.setLookupController(lookupCobrador);
        codLookupCobrador.setOpenDetail("cobrador", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
        codLookupCobrador.setNewDetail("cobrador", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{null, null, new Object[]{"COB"}}, 0);

        org.openswing.swing.table.columns.client.PictureCaptureColumn pcc = new org.openswing.swing.table.columns.client.PictureCaptureColumn();
        pcc.setColumnName("file");
        pcc.setEditableOnInsert(true);
        pcc.setEditableOnEdit(false);
        pcc.setFileNameAttributeName("fileName");
        pcc.setPreferredWidth(220);

        DefaultLookupController LookupTipoMovimiento = new DefaultLookupController(TipoMovimiento.class.getName());
        LookupTipoMovimiento.addLookup2ParentLink("tipoMovimiento");
        codLookupTipoMovimiento.setLookupController(LookupTipoMovimiento);

        controllerAsientos = new AsientoGridInternalController(Liquidacion.class.getName(), "getMovimientos", gridMovimientos, null);
        gridMovimientos.setGridDataLocator(controllerAsientos);
        gridMovimientos.setController(controllerAsientos);
        
        gridControl3.getColumnContainer().add(pcc);
        controllerDocumentosAnexosX = new DefaultDocumentosAnexosGridController(Liquidacion.class, gridControl3);
        buttonColumn1.addActionListener(controllerDocumentosAnexosX);
        gridControl3.setController(controllerDocumentosAnexosX);
        gridControl3.setGridDataLocator(controllerDocumentosAnexosX);

        controllerObservaciones =
                new DefaultGridInternalController(Liquidacion.class.getName(), "getObservaciones", gridControl5, null);
        gridControl5.setGridDataLocator(controllerObservaciones);
        gridControl5.setController(controllerObservaciones);

        controlador.documentosAnexos.TipoDocumentoLookupController lookupDocumentoAnexo2 =
                new TipoDocumentoLookupController(Dominios.Modulos.LIQUIDACION);
        lookupDocumentoAnexo2.addLookup2ParentLink("tipoDocumento");
        codLookupColumn2.setLookupController(lookupDocumentoAnexo2);

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
        gridControl5.getSaveButton().doClick();
        gridControl3.getSaveButton().doClick();
//        gridControl4.getSaveButton().doClick();
    }

    @Override
    public void reloadGridsData() {
        gridControl5.reloadData();
        gridControl3.reloadData();
//        gridControl4.reloadData();
    }

    @Override
    public void clearGridsData() {
        gridControl5.clearData();
        gridControl3.clearData();
//        gridControl4.clearData();
    }

    @Override
    public void setOwnerVO(BeanVO beanVO) {
        controllerObservaciones.setBeanVO(beanVO);
        Long id = null;
        if (beanVO != null) {
            id = ((Liquidacion) beanVO).getId();
        }
        controllerDocumentosAnexosX.setBeanVO(beanVO, id);
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
//        jPanel14.setVisible(enabled);
        jPanel11.setVisible(enabled);
        jPanel13.setVisible(enabled);
        jPanel16.setVisible(enabled);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ButtonColumn buttonColumn1;
    private org.openswing.swing.client.CheckBoxControl checkBoxControl1;
    private org.openswing.swing.client.CodLookupControl codLookupCobrador;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn2;
    private org.openswing.swing.client.CodLookupControl codLookupProductor;
    private org.openswing.swing.client.CodLookupControl codLookupTipoIngreso;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupTipoMovimiento;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.table.columns.client.CurrencyColumn currencyColumn1;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn2;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.table.columns.client.DateTimeColumn dateTimeColumn3;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.client.DeleteButton deleteButton5;
    private org.openswing.swing.client.DeleteButton deleteButton6;
    private org.openswing.swing.client.DeleteButton deleteButton7;
    private org.openswing.swing.client.EditButton editButton3;
    private org.openswing.swing.client.EditButton editButton5;
    private org.openswing.swing.client.EditButton editButton6;
    private org.openswing.swing.client.EditButton editButton7;
    private org.openswing.swing.client.FilterButton filterButton5;
    private org.openswing.swing.client.FilterButton filterButton6;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl3;
    private org.openswing.swing.client.GridControl gridControl5;
    private org.openswing.swing.client.GridControl gridMovimientos;
    private org.openswing.swing.client.InsertButton insertButton5;
    private org.openswing.swing.client.InsertButton insertButton7;
    private org.openswing.swing.client.InsertButton insertMovimiento;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn2;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.NumericControl numericControl3;
    private org.openswing.swing.client.ReloadButton reloadButton3;
    private org.openswing.swing.client.ReloadButton reloadButton5;
    private org.openswing.swing.client.ReloadButton reloadButton6;
    private org.openswing.swing.client.ReloadButton reloadButton7;
    private org.openswing.swing.client.SaveButton saveButton3;
    private org.openswing.swing.client.SaveButton saveButton5;
    private org.openswing.swing.client.SaveButton saveButton6;
    private org.openswing.swing.client.SaveButton saveButton7;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.client.TextControl textControl2;
    // End of variables declaration//GEN-END:variables
}
