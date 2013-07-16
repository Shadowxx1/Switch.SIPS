package com.productores.caja.vista;

import com.productores.caja.modelo.dominio.TipoIngresoCaja;
import com.productores.caja.modelo.dominio.TipoMovimiento;
import com.productores.caja.modelo.maestra.Asiento;
import controlador.documentosAnexos.TipoDocumentoLookupController;
import controlador.personas.CuentaBancariaLookupController;
import controlador.util.DefaultDocumentosAnexosGridController;
import controlador.util.DefaultGridInternalController;
import controlador.util.DefaultLookupController;
import modelo.Dominios;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.util.bean.BeanVO;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.java.Consts;
import vista.util.DefaultDetailFrame;

/**
 *
 * @author Nelson Moncada
 */
public class AsientoDetailFrame extends DefaultDetailFrame {

    private DefaultGridInternalController controllerObservaciones;
    private CuentaBancariaLookupController lookupCuentaBancaria;
    private DefaultDocumentosAnexosGridController controllerDocumentosAnexosX;
    private String titulo;

    public AsientoDetailFrame() {
    }

    public AsientoDetailFrame(String titulo) {
        this.titulo = titulo;
        setTitle(titulo);
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
        codLookupCuentaBancaria = new org.openswing.swing.client.CodLookupControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        textControlNumero = new org.openswing.swing.client.TextControl();
        comboBoxControl1 = new org.openswing.swing.client.ComboBoxControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        jPanel5 = new javax.swing.JPanel();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        dateControlFecha = new org.openswing.swing.client.DateControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        numericControlMonto = new org.openswing.swing.client.NumericControl();
        textControlReferencia = new org.openswing.swing.client.TextControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        codLookupTipoMovimiento = new org.openswing.swing.client.CodLookupControl();
        jPanel3 = new javax.swing.JPanel();
        textAreaControlDescripcion = new org.openswing.swing.client.TextAreaControl();
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

        setTitle("Asiento");

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

        form1.setVOClassName(Asiento.class.getName());
        form1.setEditButton(editButton3);
        form1.setReloadButton(reloadButton3);
        form1.setSaveButton(saveButton3);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        labelControl2.setLabel("cuentaBancaria");

        codLookupCuentaBancaria.setAttributeName("cuentaBancaria.banco.nombreLargo");
        codLookupCuentaBancaria.setAutoCompletitionWaitTime(1000L);
        codLookupCuentaBancaria.setControllerMethodName("getPersonaNueva");
        codLookupCuentaBancaria.setLinkLabel(labelControl2);
        codLookupCuentaBancaria.setMaxCharacters(10);

        labelControl8.setLabel("tipoDocumentoPago");

        labelControl7.setLabel("asiento.numero");

        textControlNumero.setAttributeName("numero");
        textControlNumero.setLinkLabel(labelControl7);
        textControlNumero.setRequired(true);
        textControlNumero.setTrimText(true);
        textControlNumero.setUpperCase(true);

        comboBoxControl1.setAttributeName("tipoDocumentoPago");
        comboBoxControl1.setDomainId(Dominios.TipoDocumentoPago().getDomainId());

        textControl3.setAttributeName("cuentaBancaria.numero");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxControl1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(textControlNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codLookupCuentaBancaria, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl2, labelControl7, labelControl8});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textControlNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codLookupCuentaBancaria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textControl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelControl2, labelControl7, labelControl8, textControlNumero});

        jPanel8.add(jPanel4);

        labelControl4.setLabel("monto");

        labelControl10.setLabel("fecha");

        dateControlFecha.setAttributeName("fecha");
        dateControlFecha.setLinkLabel(labelControl10);

        labelControl6.setLabel("referencia");

        numericControlMonto.setAttributeName("monto");
        numericControlMonto.setDecimals(2);

        textControlReferencia.setAttributeName("referencia");

        labelControl5.setLabel("tipoMovimiento");

        codLookupTipoMovimiento.setAttributeName("tipoMovimiento.nombre");
        codLookupTipoMovimiento.setControllerMethodName("getTipoMovimiento");
        codLookupTipoMovimiento.setLinkLabel(labelControl5);
        codLookupTipoMovimiento.setMaxCharacters(10);
        codLookupTipoMovimiento.setRequired(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelControl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelControl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelControl10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codLookupTipoMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(numericControlMonto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(dateControlFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(textControlReferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelControl10, labelControl4, labelControl5, labelControl6});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelControl10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labelControl4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelControl6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(numericControlMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textControlReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codLookupTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelControl5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateControlFecha, labelControl10, labelControl4, labelControl6});

        jPanel8.add(jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));

        textAreaControlDescripcion.setAttributeName("descripcion");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textAreaControlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(textAreaControlDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Asiento", jPanel2);

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
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(gridControl5, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
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
            .addComponent(gridControl3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("Datos Generales", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
      
    @Override
    public void inicializar(FormController formController, boolean addToMDIFrame) {
        initComponents();

        lookupCuentaBancaria = new CuentaBancariaLookupController();
        getLookupCuentaBancaria().addLookup2ParentLink("cuentaBancaria");
        getLookupCuentaBancaria().addLookup2ParentLink("banco.nombreLargo", "cuentaBancaria.banco.nombreLargo");
//        getLookupCuentaBancaria().addLookup2ParentLink("nombreLargo", "cuentaBancaria.banco.nombreLargo");
        codLookupCuentaBancaria.setLookupController(getLookupCuentaBancaria());
        
//        codLookupCuentaBancaria.setOpenDetail("productor", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
//        codLookupCuentaBancaria.setNewDetail("productor", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{null, null, new Object[]{"PRD"}}, 0);

        DefaultLookupController lookupTipoMovimiento = new DefaultLookupController(TipoIngresoCaja.class.getName());
        lookupTipoMovimiento.addLookup2ParentLink("tipoIngresoCaja");
        lookupTipoMovimiento.addLookup2ParentLink("nombre", "tipoIngresoCaja.nombre");
        codLookupTipoMovimiento.setLookupController(lookupTipoMovimiento);

//        PersonaLookupControllerPorNombre lookupCobrador = new PersonaLookupControllerPorNombre("COB");
//        lookupCobrador.addLookup2ParentLink("cobrador");
//        lookupCobrador.addLookup2ParentLink("nombreCorto", "cobrador.nombreCorto");
//        codLookupCobrador.setLookupController(lookupCobrador);
//        codLookupCobrador.setOpenDetail("cobrador", PersonasDetailController.class.getName(), new Class[]{GridControl.class, BeanVO.class, Rif.class}, new Object[]{null, null, null}, 1);
//        codLookupCobrador.setNewDetail("cobrador", RifDialog.class.getName(), new Class[]{Form.class, String.class, Object[].class}, new Object[]{null, null, new Object[]{"COB"}}, 0);

        org.openswing.swing.table.columns.client.PictureCaptureColumn pcc = new org.openswing.swing.table.columns.client.PictureCaptureColumn();
        pcc.setColumnName("file");
        pcc.setEditableOnInsert(true);
        pcc.setEditableOnEdit(false);
        pcc.setFileNameAttributeName("fileName");
        pcc.setPreferredWidth(220);

        DefaultLookupController LookupTipoMovimiento = new DefaultLookupController(TipoMovimiento.class.getName());
        LookupTipoMovimiento.addLookup2ParentLink("tipoMovimiento");
        codLookupTipoMovimiento.setLookupController(LookupTipoMovimiento);

//        controllerAsien = new AsientoGridInternalController(Liquidacion.class.getName(), "getMovimientos", gridMovimientos, null);
//        gridMovimientos.setGridDataLocator(controllerAsien);
//        gridMovimientos.setController(controllerAsien);

//        gridControl4.getColumnContainer().add(pcc);
//        controllerDocumentos = new DefaultDocumentosAnexosGridController(Poliza.class, gridControl4);
//        buttonColumn2.addActionListener(controllerDocumentos);
//        gridControl4.setController(controllerDocumentos);
//        gridControl4.setGridDataLocator(controllerDocumentos);
//
        gridControl3.getColumnContainer().add(pcc);
        controllerDocumentosAnexosX = new DefaultDocumentosAnexosGridController(Asiento.class, gridControl3);
        buttonColumn1.addActionListener(controllerDocumentosAnexosX);
        gridControl3.setController(controllerDocumentosAnexosX);
        gridControl3.setGridDataLocator(controllerDocumentosAnexosX);

        controllerObservaciones =
                new DefaultGridInternalController(Asiento.class.getName(), "getObservaciones", gridControl5, null);
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
            id = ((Asiento) beanVO).getId();            
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
//        jPanel13.setVisible(enabled);
        jPanel16.setVisible(enabled);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.table.columns.client.ButtonColumn buttonColumn1;
    private org.openswing.swing.table.columns.client.CodLookupColumn codLookupColumn2;
    private org.openswing.swing.client.CodLookupControl codLookupCuentaBancaria;
    private org.openswing.swing.client.CodLookupControl codLookupTipoMovimiento;
    private org.openswing.swing.client.ComboBoxControl comboBoxControl1;
    private org.openswing.swing.table.columns.client.DateColumn dateColumn2;
    private org.openswing.swing.client.DateControl dateControlFecha;
    private org.openswing.swing.table.columns.client.DateTimeColumn dateTimeColumn3;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn5;
    private org.openswing.swing.client.DeleteButton deleteButton5;
    private org.openswing.swing.client.DeleteButton deleteButton7;
    private org.openswing.swing.client.EditButton editButton3;
    private org.openswing.swing.client.EditButton editButton5;
    private org.openswing.swing.client.EditButton editButton7;
    private org.openswing.swing.client.FilterButton filterButton5;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl3;
    private org.openswing.swing.client.GridControl gridControl5;
    private org.openswing.swing.client.InsertButton insertButton5;
    private org.openswing.swing.client.InsertButton insertButton7;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.NumericControl numericControlMonto;
    private org.openswing.swing.client.ReloadButton reloadButton3;
    private org.openswing.swing.client.ReloadButton reloadButton5;
    private org.openswing.swing.client.ReloadButton reloadButton7;
    private org.openswing.swing.client.SaveButton saveButton3;
    private org.openswing.swing.client.SaveButton saveButton5;
    private org.openswing.swing.client.SaveButton saveButton7;
    private org.openswing.swing.client.TextAreaControl textAreaControlDescripcion;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn8;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControlNumero;
    private org.openswing.swing.client.TextControl textControlReferencia;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the lookupCuentaBancaria
     */
    public CuentaBancariaLookupController getLookupCuentaBancaria() {
        return lookupCuentaBancaria;
    }
}
