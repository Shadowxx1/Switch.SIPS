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
import modelo.utilitario.FiltroGiros;
import modelo.utilitario.UtilidadesSQL;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;
import vista.reportes.EsperaDialog;
import vista.reportes.FiltroGirosDialog;

/**
 *
 * @author Owner
 */
public class FiltroGirosController extends DefaultDetailFrameController {

    protected ReporteController controlador;
    private Reporte reporte;
    private String estilo;
    private Map filtros;
    private String sql;
    private ArrayList<Object> paramValues;
    private ArrayList<Type> paramTypes;
    private String where;
    private Reporte repAux;

    public FiltroGirosController(String pathToDetailFrame, Reporte reporte, String estilo) {
        super(pathToDetailFrame, null, null, false);
        this.reporte = reporte;
        this.estilo = estilo;
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) {
        FiltroGiros filtroAsesor = (FiltroGiros) newPersistentObject;
        controlador = new ReporteController();
        paramTypes = new ArrayList<Type>();
        paramValues = new ArrayList<Object>();
        where = "";
        sql = reporte.getBaseSQL();
        filtros = new HashMap();
        boolean vacio = true;

//        if (filtroAsesor.getProducto() != null) {
//            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
//                    "R.poliza.producto.id=? ");
//            paramValues.add(filtroAsesor.getProducto().getId());
//            paramTypes.add(new LongType());
//
//            filtros.put(
//                    " Producto",
//                    new FilterWhereClause[]{
//                        new FilterWhereClause("Producto",
//                        "", filtroAsesor.getProducto().getNombre()),
//                        null
//                    });
//
//            vacio = false;
//        }

        if (filtroAsesor.getGrupo() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "R.poliza.grupoPoliza.id=? ");
            paramValues.add(filtroAsesor.getGrupo().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    " Grupo",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Grupo",
                        "", filtroAsesor.getGrupo().getNombre()),
                        null
                    });

            vacio = false;
        }

        if (filtroAsesor.getAsesor() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "R.poliza.asesor.asesor.id=? ");
            paramValues.add(filtroAsesor.getAsesor().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    " Asesor",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Asesor",
                        "", filtroAsesor.getAsesor().getNombreCorto()),
                        null
                    });

            vacio = false;
        }

        if (filtroAsesor.getTipoZona() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "R.zona.id=? ");
            paramValues.add(filtroAsesor.getTipoZona().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    " Zona",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Zona",
                        "", filtroAsesor.getTipoZona().getNombre()),
                        null
                    });

            vacio = false;
        }

        switch (((FiltroGirosDialog) vista).getjTabbedPane1().getSelectedIndex()) {
            case 0:

                if (((FiltroGirosDialog) vista).getjComboBox4().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaVencimiento)=? ");
                    paramValues.add(((FiltroGirosDialog) vista).getjComboBox4().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Vencimiento ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Vencimiento ", "", Mes.values()[((FiltroGirosDialog) vista).getjComboBox4().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }
                
                if (filtroAsesor.getAnoVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaVencimiento)=? ");
                    paramValues.add(filtroAsesor.getAnoVigenciaHasta());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Vencimiento",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Año de Vencimiento", "", filtroAsesor.getAnoVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }               

                break;
            case 1:
                if (filtroAsesor.getDesdeVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaVencimiento>=? ");
                    paramValues.add(filtroAsesor.getDesdeVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Vencimiento",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Vencimiento", "", filtroAsesor.getDesdeVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getHastaVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaVencimiento<=? ");
                    paramValues.add(filtroAsesor.getHastaVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Vencimiento",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Vencimiento", "", filtroAsesor.getHastaVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }                

                break;
        }

        if (vacio) {
            switch (JOptionPane.showConfirmDialog(MDIFrame.getInstance(), "No ha colocado ningún parametro.\n ¿Desea ejecutar el reporte sin filtros?",
                    "Filtro Remesa", JOptionPane.YES_NO_OPTION)) {
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
        ((FiltroGirosDialog) vista).getMainPanel().getSaveButton().doClick();
        ((FiltroGirosDialog) vista).getMainPanel().setMode(Consts.EDIT);
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
