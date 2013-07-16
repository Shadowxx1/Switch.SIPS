/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FiltroRenovacionesDialog.java
 *
 * Created on 16/09/2010, 03:38:46 PM
 */
package vista.reportes;

import controlador.reportes.ReporteController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.entidades.Reporte;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.utilitario.FiltroFinanciamiento;
import org.hibernate.type.DateType;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.client.ClientUtils;

/**
 *
 * @author Nelson Moncada
 */
public class FiltroFinanciamientoSencilloDialog extends InternalFrame {

    private Reporte reporte;
    private String estilo;
    private FiltroFinanciamiento financiadora;
    private EsperaDialog es;
    private ReporteController controlador;
    private Map filtros = new HashMap(0);

    /** Creates new form FiltroRenovacionesDialog */
    public FiltroFinanciamientoSencilloDialog(Reporte reporte, String estilo) {
        initComponents();

        //jFormattedTextField1.setText(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        this.getRootPane().setDefaultButton(jButton1);
        this.reporte = reporte;
        this.estilo = estilo;


        jButton1.addActionListener(new FiltroRecibos());

        MDIFrame.add(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        form1 = new org.openswing.swing.form.client.Form();
        dateControl1 = new org.openswing.swing.client.DateControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtro de Recibos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione el rango de fechas"));
        jPanel2.setLayout(new java.awt.GridLayout());

        form1.setVOClassName(FiltroFinanciamiento.class.getName());

        dateControl1.setAttributeName("fechaVencimientoDesde");

        dateControl2.setAttributeName("fechaVencimientoHasta");

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta:");

        jLabel11.setText("Fecha de Vencimiento de Giros:");

        javax.swing.GroupLayout form1Layout = new javax.swing.GroupLayout(form1);
        form1.setLayout(form1Layout);
        form1Layout.setHorizontalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, form1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        form1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dateControl1, dateControl2});

        form1Layout.setVerticalGroup(
            form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateControl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateControl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.add(form1);

        jTabbedPane1.addTab("Rango de Fechas", jPanel2);

        jButton1.setText("Filtrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(503, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.form.client.Form form1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    class FiltroRecibos extends FormController implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            financiadora = ((FiltroFinanciamiento) FiltroFinanciamientoSencilloDialog.this.form1.getVOModel().getValueObject());
            controlador = new ReporteController();

            String sql = reporte.getBaseSQL();
            int xx = sql.indexOf("and Q.fechaVencimiento between ? AND ?");
            if (xx != -1) {
                sql = sql.substring(0, xx - 1);
            }
            boolean vacio = true;
            if (financiadora.getFechaVencimientoDesde() != null
                    && financiadora.getFechaVencimientoHasta() != null) {
                vacio = false;
                sql += " and Q.fechaVencimiento between ? AND ?";
                controlador.getTypes().add(new DateType());
                controlador.getTypes().add(new DateType());
                controlador.getObjects().add(financiadora.getFechaVencimientoDesde());
                controlador.getObjects().add(financiadora.getFechaVencimientoHasta());
                vacio = false;
            }
            reporte.setBaseSQL(sql);
            System.out.println(filtros);


            if (vacio) {
                switch (JOptionPane.showConfirmDialog(MDIFrame.getInstance(), "NO ha colocado ningun parametro.\n ¿Desea realizar un Reporte de todos los recibos cargados?")) {
                    case JOptionPane.YES_OPTION:
                        mostrarReporte();
                        break;
                    case JOptionPane.NO_OPTION:
                        //controlador.loadData(reporte, estilo, 1, 0, filtros, new ArrayList(0), new ArrayList(0), Recibo.class, new HashMap(0));
                        break;
                    case JOptionPane.CANCEL_OPTION:

                        break;
                }
            } else {
                mostrarReporte();
            }
        }

        private void mostrarReporte() {
            es = new EsperaDialog(null, false);
            ClientUtils.centerDialog(MDIFrame.getInstance(), es);
            new Thread() {

                @Override
                public void run() {
                    es.setVisible(true);
                    controlador.loadData(
                            reporte, estilo, 1, 0, filtros,
                            new ArrayList(0),
                            new ArrayList(0), Recibo.class, new HashMap(0));
                    es.dispose();
                }
            }.start();
            FiltroFinanciamientoSencilloDialog.this.dispose();
        }
    }
}
