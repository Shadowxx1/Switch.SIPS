package controlador.reportes;

import controlador.util.DefaultDetailFrameController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Dominios.Mes;
import modelo.entidades.Reporte;
import modelo.utilitario.FiltroFactura;
import modelo.utilitario.UtilidadesSQL;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;
import vista.reportes.EsperaDialog;
import vista.reportes.FiltroFacturaDialog;

/**
 *
 * @author Owner
 */
public class FiltroFacturaController extends DefaultDetailFrameController {

    protected ReporteController controlador;
    private Reporte reporte;
    private String estilo;
    private Map filtros;
    private String sql;
    private ArrayList<Object> paramValues;
    private ArrayList<Type> paramTypes;
    private String where;
    private Reporte repAux;

    public FiltroFacturaController(String pathToDetailFrame, Reporte reporte, String estilo) {
        super(pathToDetailFrame, null, null, false);
        this.reporte = reporte;
        this.estilo = estilo;
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) {
        FiltroFactura filtroAsesor = (FiltroFactura) newPersistentObject;
        controlador = new ReporteController();
        paramTypes = new ArrayList<Type>();
        paramValues = new ArrayList<Object>();
        where = "";
        sql = reporte.getBaseSQL();
        filtros = new HashMap();
        boolean vacio = true;

        switch (((FiltroFacturaDialog) vista).getjTabbedPane1().getSelectedIndex()) {
            case 0:
                if (filtroAsesor.getAnoEmision() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaEmision)=? ");
                    paramValues.add(filtroAsesor.getAnoEmision());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Emision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Emision", "=", filtroAsesor.getAnoEmision()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroFacturaDialog) vista).getjComboBox1().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaEmision)=? ");
                    paramValues.add(((FiltroFacturaDialog) vista).getjComboBox1().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Emision ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Emision ", "=", Mes.values()[((FiltroFacturaDialog) vista).getjComboBox1().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }
                               
            case 1:
                if (filtroAsesor.getDesdeFechaEmision() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaEmision>=? ");
                    paramValues.add(filtroAsesor.getDesdeFechaEmision());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Emision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Emision", ">=", filtroAsesor.getDesdeFechaEmision()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getDesdeFechaEmision() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaEmision<=? ");
                    paramValues.add(filtroAsesor.getDesdeFechaEmision());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Emision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Emision", "<=", filtroAsesor.getDesdeFechaEmision()),
                                null
                            });

                    vacio = false;
                }
 
        }

        if (vacio) {
            switch (JOptionPane.showConfirmDialog(MDIFrame.getInstance(), "No ha colocado ningún parametro.\n ¿Desea ejecutar el reporte sin filtros?",
                    "Filtro Facturas", JOptionPane.YES_NO_OPTION)) {
                case JOptionPane.YES_OPTION:
                    mostrarReporte();
                    break;
            }
        } else {
            mostrarReporte();
        }

        return new VOResponse(newPersistentObject);
    }

    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return insertRecord(persistentObject);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((FiltroFacturaDialog) vista).getMainPanel().getSaveButton().doClick();
        ((FiltroFacturaDialog) vista).getMainPanel().setMode(Consts.EDIT);
    }

    private void mostrarReporte() {
        final EsperaDialog es = new EsperaDialog(null, false);
        ClientUtils.centerDialog(MDIFrame.getInstance(), es);
        new Thread() {

            @Override
            public void run() {
                try {
                    repAux = (Reporte) reporte.clone();
                    repAux.setBaseSQL(sql);
                    es.setVisible(true);
                    controlador.loadData(paramValues, paramTypes, repAux, estilo, 1, 0, new HashMap(0), new ArrayList(0), new ArrayList(0), Reporte.class, filtros);
                    es.dispose();

                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(FiltroAsesorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        vista.dispose();
//        es.dispose();
    }
}
