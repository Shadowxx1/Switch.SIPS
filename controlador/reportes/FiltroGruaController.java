package controlador.reportes;

import controlador.util.DefaultDetailFrameController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Dominios.Mes;
import modelo.HibernateUtil;
import modelo.entidades.ParametroReporte;
import modelo.entidades.Reporte;
import modelo.entidades.polizas.financiamiento.Giro;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.utilitario.FiltroAsesor;
import modelo.utilitario.ReportesUtil;
import modelo.utilitario.UtilidadesSQL;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;
import org.openswing.swing.util.server.HibernateUtils;
import vista.reportes.EsperaDialog;
import vista.reportes.FiltroAsesorDialog;

/**
 *
 * @author Owner
 */
public class FiltroGruaController extends DefaultDetailFrameController {

    protected ReporteController controlador;
    private Reporte reporte;
    private String estilo;
    private Map filtros;
    private String sql;
    private ArrayList<Object> paramValues;
    private ArrayList<Type> paramTypes;
    private String where;
    private Reporte repAux;

    public FiltroGruaController(String pathToDetailFrame, Reporte reporte, String estilo) {
        super(pathToDetailFrame, null, null, false);
        this.reporte = reporte;
        this.estilo = estilo;
    }

    @Override
    public Response insertRecord(ValueObject newPersistentObject) {
        FiltroAsesor filtroAsesor = (FiltroAsesor) newPersistentObject;
        controlador = new ReporteController();
        paramTypes = new ArrayList<Type>();
        paramValues = new ArrayList<Object>();
        where = "";
        sql = reporte.getBaseSQL();
        filtros = new HashMap();
        boolean vacio = true;

//        if (filtroAsesor.getProducto() != null) {
//            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
//                    "P.poliza.producto.id=? ");
//            paramValues.add(filtroAsesor.getProducto().getId());
//            paramTypes.add(new LongType());
//
//            filtros.put(
//                    "Producto",
//                    new FilterWhereClause[]{
//                        new FilterWhereClause("Producto",
//                        "=", filtroAsesor.getProducto().getNombre()),
//                        null
//                    });
//
//            vacio = false;
//        }

        if (filtroAsesor.getGrupo() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.grupoPoliza.id=? ");
            paramValues.add(filtroAsesor.getGrupo().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Grupo",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Grupo",
                        "=", filtroAsesor.getGrupo().getNombre()),
                        null
                    });

            vacio = false;
        }

        if (filtroAsesor.getAsesor() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.poliza.asesor.asesor.id=? ");
            paramValues.add(filtroAsesor.getAsesor().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Asesor",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Asesor",
                        "=", filtroAsesor.getAsesor().getNombreCorto()),
                        null
                    });

            vacio = false;
        }

        if (filtroAsesor.getTipoZona() != null) {
            sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND,
                    "P.zona.id=? ");
            paramValues.add(filtroAsesor.getTipoZona().getId());
            paramTypes.add(new LongType());

            filtros.put(
                    "Asesor",
                    new FilterWhereClause[]{
                        new FilterWhereClause("Asesor",
                        "=", filtroAsesor.getTipoZona().getNombre()),
                        null
                    });

            vacio = false;
        }

        switch (((FiltroAsesorDialog) vista).getjTabbedPane1().getSelectedIndex()) {
            case 0:
                if (filtroAsesor.getAnoCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaCobro)=? ");
                    paramValues.add(filtroAsesor.getAnoCobro());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Cobrado", "=", filtroAsesor.getAnoCobro()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroAsesorDialog) vista).getjComboBox1().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaCobro)=? ");
                    paramValues.add(((FiltroAsesorDialog) vista).getjComboBox1().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Cobrado ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Cobrado ", "=", Mes.values()[((FiltroAsesorDialog) vista).getjComboBox1().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getAnoPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.fechaPagoComision)=? ");
                    paramValues.add(filtroAsesor.getAnoPago());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Comision Pagada",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Comision Pagada", "=", filtroAsesor.getAnoPago()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroAsesorDialog) vista).getjComboBox2().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.fechaPagoComision)=? ");
                    paramValues.add(((FiltroAsesorDialog) vista).getjComboBox2().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Comision Pagada ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Comision Pagada ", "=", Mes.values()[((FiltroAsesorDialog) vista).getjComboBox2().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getAnoVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.vigenciaDesde)=? ");
                    paramValues.add(filtroAsesor.getAnoVigenciaDesde());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Comienso Vigencia",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Comienso Vigencia", "=", filtroAsesor.getAnoVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroAsesorDialog) vista).getjComboBox3().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.vigenciaDesde)=? ");
                    paramValues.add(((FiltroAsesorDialog) vista).getjComboBox3().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Comienso Vigencia ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Comienso Vigencia ", "=", Mes.values()[((FiltroAsesorDialog) vista).getjComboBox3().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getAnoVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " year(P.vigenciaHasta)=? ");
                    paramValues.add(filtroAsesor.getAnoVigenciaHasta());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            "Año de Finalizacion Vigencia",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Año de Finalizacion Vigencia", "=", filtroAsesor.getAnoVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }

                if (((FiltroAsesorDialog) vista).getjComboBox4().getSelectedIndex() != 0) {
                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " month(P.vigenciaHasta)=? ");
                    paramValues.add(((FiltroAsesorDialog) vista).getjComboBox4().getSelectedIndex());
                    paramTypes.add(new IntegerType());

                    filtros.put(
                            " Mes de Finalizacion Vigencia ",
                            new FilterWhereClause[]{
                                new FilterWhereClause(" Mes de Finalizacion Vigencia ", "=", Mes.values()[((FiltroAsesorDialog) vista).getjComboBox4().getSelectedIndex() - 1]),
                                null
                            });

                    vacio = false;
                }

                break;
            case 1:
                if (filtroAsesor.getDesdeFechaCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaCobro>=? ");
                    paramValues.add(filtroAsesor.getDesdeFechaCobro());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Cobrado", ">=", filtroAsesor.getDesdeFechaCobro()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getHastaFechaCobro() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaCobro<=? ");
                    paramValues.add(filtroAsesor.getHastaFechaCobro());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Cobrado",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Cobrado", "<=", filtroAsesor.getHastaFechaCobro()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getDesdeFechaPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaPagoComision>=? ");
                    paramValues.add(filtroAsesor.getDesdeFechaPago());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Pago Comision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Pago Comision", ">=", filtroAsesor.getDesdeFechaPago()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getHastaFechaPago() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.fechaPagoComision<=? ");
                    paramValues.add(filtroAsesor.getHastaFechaPago());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Pago Comision",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Pago Comision", "<=", filtroAsesor.getHastaFechaPago()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getDesdeVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaDesde>=? ");
                    paramValues.add(filtroAsesor.getDesdeVigenciaDesde());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Vigencia Desde",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Vigencia Desde", ">=", filtroAsesor.getDesdeVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getHastaVigenciaDesde() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaDesde<=? ");
                    paramValues.add(filtroAsesor.getHastaVigenciaDesde());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Vigencia Desde",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Vigencia Desde", "<=", filtroAsesor.getHastaVigenciaDesde()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getDesdeVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaHasta>=? ");
                    paramValues.add(filtroAsesor.getDesdeVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Inicio de Fecha de Vigencia Hasta",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Inicio de Fecha de Vigencia Hasta", ">=", filtroAsesor.getDesdeVigenciaHasta()),
                                null
                            });

                    vacio = false;
                }

                if (filtroAsesor.getHastaVigenciaHasta() != null) {

                    sql = UtilidadesSQL.addWhere(sql, UtilidadesSQL.Where.AND, " P.vigenciaHasta<=? ");
                    paramValues.add(filtroAsesor.getHastaVigenciaHasta());
                    paramTypes.add(new DateType());

                    filtros.put(
                            "Finalizacion de Fecha de Vigencia Hasta",
                            new FilterWhereClause[]{
                                new FilterWhereClause("Finalizacion de Fecha de Vigencia Hasta", "<=", filtroAsesor.getHastaVigenciaHasta()),
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
        ((FiltroAsesorDialog) vista).getMainPanel().getSaveButton().doClick();
        ((FiltroAsesorDialog) vista).getMainPanel().setMode(Consts.EDIT);
    }

    private void mostrarReporte() {
        final EsperaDialog es = new EsperaDialog(null, false);
        ClientUtils.centerDialog(MDIFrame.getInstance(), es);
        new Thread() {

            @Override
            public void run() {
                Session s = null;
                try {
                    es.setVisible(true);

                    SessionFactory sf = HibernateUtil.getSessionFactory();
                    s = sf.openSession();
                    Type arraytype[] = new Type[paramTypes.size()];
                    paramTypes.toArray(arraytype);

                    Response res = HibernateUtils.getAllFromQuery(
                            new HashMap(0),
                            new ArrayList(0),
                            new ArrayList(0),
                            Reporte.class,
                            sql,
                            paramValues.toArray(),
                            arraytype,
                            "P",
                            sf,
                            s);

                    List dataSource = ((VOListResponse) res).getRows();

                    for (Recibo recibo : ((ArrayList<Recibo>) dataSource)) {

                        int numGirosVencidos = 0;
                        if (recibo.getFinanciamiento() != null) {

                            if (recibo.getFinanciamiento().getFechaAnulacionF() != null) {
                                dataSource.remove(recibo);
                                continue;
                            }

                            if (recibo.getFinanciamiento().getFechaPagoInicial() == null) {
                                recibo.setMensaje("INI");
                            } else {
                                for (Giro giro : recibo.getFinanciamiento().getGiros()) {
                                    if ((ReportesUtil.diferenciaEnDias(giro.getFechaVencimiento(), new Date()) > 0) && giro.getFechaCobro() == null) {
                                        numGirosVencidos++;
                                        recibo.setMensaje("G " + numGirosVencidos + "/" + recibo.getFinanciamiento().getGiros().size());
                                    }
                                }

                                if (numGirosVencidos == 0) {
                                    recibo.setMensaje("PAG");
                                }
                            }

                        } else {
                            if (recibo.getFechaAnulacion() != null) {
                                dataSource.remove(recibo);
                                continue;
                            }

                            if (recibo.getFechaCobro() == null) {
                                recibo.setMensaje("PEN");
                            } else {
                                recibo.setMensaje("PAG");
                            }
                        }
                    }

                    controlador.mostrarReporte(dataSource, new ArrayList<ParametroReporte>(), reporte.getFile(), reporte.getTitulo(), estilo, s);

                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(FiltroAsesorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FiltroGruaController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (s != null && s.isOpen()) {
                        s.close();
                    }
                    es.dispose();
                }
            }
        }.start();
        vista.dispose();
//        es.dispose();
    }
}
