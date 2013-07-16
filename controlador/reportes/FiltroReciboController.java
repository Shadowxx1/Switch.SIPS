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
import modelo.utilitario.FiltroRecibo;
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
import vista.reportes.FiltroRecibosDialog;

/**
 *
 * @author Owner
 */
public class FiltroReciboController extends DefaultDetailFrameController {

    protected ReporteController controlador;
    private Reporte reporte;
    private String estilo;
    private Map filtros;
    private String sql;
    private ArrayList<Object> paramValues;
    private ArrayList<Type> paramTypes;
    private String where;
    private Reporte repAux;

    public FiltroReciboController(String pathToDetailFrame, Reporte reporte, String estilo) {
        super(pathToDetailFrame, null, null, false);
        this.reporte = reporte;
        this.estilo = estilo;
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) {
        FiltroRecibo filtroRecibo = (FiltroRecibo) newPersistentObject;
        controlador = new ReporteController();
        paramTypes = new ArrayList<Type>();
        paramValues = new ArrayList<Object>();
        where = "";
        sql = reporte.getBaseSQL();
        filtros = new HashMap();
        boolean vacio = true;

        if (filtroRecibo.getCompania() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.compania.id=? ");
            paramValues.add(filtroRecibo.getCompania().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Compania",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Compania",
                        "=", filtroRecibo.getCompania().getNombreCorto()),
                        null
                    });

            vacio = false;
        }

        if (filtroRecibo.getRamo() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.ramoPoliza.id=? ");
            paramValues.add(filtroRecibo.getRamo().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Ramo",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Ramo",
                        "=", filtroRecibo.getRamo().getNombre()),
                        null
                    });

            vacio = false;
        }

        if (filtroRecibo.getGrupo() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.grupoPoliza.id=? ");
            paramValues.add(filtroRecibo.getGrupo().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Grupo",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Grupo",
                        "=", filtroRecibo.getGrupo().getNombre()),
                        null
                    });

            vacio = false;
        }

        if (filtroRecibo.getProductor() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.productor.id=? ");
            paramValues.add(filtroRecibo.getProductor().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Productor",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Productor",
                        "=", filtroRecibo.getProductor().getNombreCorto()),
                        null
                    });

            vacio = false;
        }

        if (filtroRecibo.getCobrador() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.cobrador2.id=? ");
            paramValues.add(filtroRecibo.getCobrador().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Cobrador",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Cobrador",
                        "=", filtroRecibo.getCobrador().getNombreCorto()),
                        null
                    });

            vacio = false;
        }

        if (filtroRecibo.getTipoZona() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.zona.id=? ");
            paramValues.add(filtroRecibo.getTipoZona().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Zona",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Zona",
                        "=", filtroRecibo.getTipoZona().getNombre()),
                        null
                    });

            vacio = false;
        }


        switch (((FiltroRecibosDialog) vista).getjTabbedPane1().getSelectedIndex()) {
            case 0:
                if (filtroRecibo.getAnoCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaCobro)=? ");
                    paramValues.add(filtroRecibo.getAnoCobro());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Cobrado", "=", filtroRecibo.getAnoCobro()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroRecibosDialog) vista).getjComboBox1().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaCobro)=? ");
                    paramValues.add(((FiltroRecibosDialog) vista).getjComboBox1().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Cobrado ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Cobrado ", "=", Mes.values()[((FiltroRecibosDialog) vista).getjComboBox1().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getAnoPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaPagoComision)=? ");
                    paramValues.add(filtroRecibo.getAnoPago());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Comision Pagada",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Comision Pagada", "=", filtroRecibo.getAnoPago()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroRecibosDialog) vista).getjComboBox2().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaPagoComision)=? ");
                    paramValues.add(((FiltroRecibosDialog) vista).getjComboBox2().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Comision Pagada ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Comision Pagada ", "=", Mes.values()[((FiltroRecibosDialog) vista).getjComboBox2().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getAnoVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.vigenciaDesde)=? ");
                    paramValues.add(filtroRecibo.getAnoVigenciaDesde());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Comienso Vigencia",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Comienso Vigencia", "=", filtroRecibo.getAnoVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroRecibosDialog) vista).getjComboBox3().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.vigenciaDesde)=? ");
                    paramValues.add(((FiltroRecibosDialog) vista).getjComboBox3().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Comienso Vigencia ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Comienso Vigencia ", "=", Mes.values()[((FiltroRecibosDialog) vista).getjComboBox3().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getAnoVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.vigenciaHasta)=? ");
                    paramValues.add(filtroRecibo.getAnoVigenciaHasta());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Finalizacion Vigencia",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Finalizacion Vigencia", "=", filtroRecibo.getAnoVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroRecibosDialog) vista).getjComboBox4().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.vigenciaHasta)=? ");
                    paramValues.add(((FiltroRecibosDialog) vista).getjComboBox4().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Finalizacion Vigencia ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Finalizacion Vigencia ", "=", Mes.values()[((FiltroRecibosDialog) vista).getjComboBox4().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                break;
            case 1:
                if (filtroRecibo.getDesdeFechaCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaCobro>=? ");
                    paramValues.add(filtroRecibo.getDesdeFechaCobro());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Cobrado", ">=", filtroRecibo.getDesdeFechaCobro()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getHastaFechaCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaCobro<=? ");
                    paramValues.add(filtroRecibo.getHastaFechaCobro());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Cobrado", "<=", filtroRecibo.getHastaFechaCobro()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getDesdeFechaPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaPagoComision>=? ");
                    paramValues.add(filtroRecibo.getDesdeFechaPago());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Pago Comision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Pago Comision", ">=", filtroRecibo.getDesdeFechaPago()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getHastaFechaPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaPagoComision<=? ");
                    paramValues.add(filtroRecibo.getHastaFechaPago());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Pago Comision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Pago Comision", "<=", filtroRecibo.getHastaFechaPago()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getDesdeVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaDesde>=? ");
                    paramValues.add(filtroRecibo.getDesdeVigenciaDesde());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Vigencia Desde",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Vigencia Desde", ">=", filtroRecibo.getDesdeVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getHastaVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaDesde<=? ");
                    paramValues.add(filtroRecibo.getHastaVigenciaDesde());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Vigencia Desde",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Vigencia Desde", "<=", filtroRecibo.getHastaVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getDesdeVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaHasta>=? ");
                    paramValues.add(filtroRecibo.getDesdeVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Vigencia Hasta",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Vigencia Hasta", ">=", filtroRecibo.getDesdeVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }

                if (filtroRecibo.getHastaVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaHasta<=? ");
                    paramValues.add(filtroRecibo.getHastaVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Vigencia Hasta",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Vigencia Hasta", "<=", filtroRecibo.getHastaVigenciaHasta()),
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
        ((FiltroRecibosDialog) vista).getMainPanel().getSaveButton().doClick();
        ((FiltroRecibosDialog) vista).getMainPanel().setMode(Consts.EDIT);
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
                    Logger.getLogger(FiltroReciboController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
        vista.dispose();
//        es.dispose();
    }
}
