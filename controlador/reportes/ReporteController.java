package controlador.reportes;

import controlador.General;
import controlador.util.DefaultGridFrameController;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.Encabezado;
import modelo.entidades.ParametroReporte;
import modelo.entidades.Reporte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.type.Type;
import org.openswing.swing.client.FilterButton;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.util.java.Consts;
import vista.personas.Personas2GridFrame;
import vista.util.DefaultGridFrame;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class ReporteController extends DefaultGridFrameController {

    private Reporte reporte;
    private String estilo;
    private Encabezado encabezado;
    private boolean isFiltroActivo;
    private ArrayList objects = new ArrayList(0);
    private ArrayList<Type> types = new ArrayList<Type>(0);
    static private Map<String, Image> icons = new HashMap<String, Image>();
    private Date consultaInicio;

    public ReporteController() {
    }

    public void mostrarReporte(List dataSource, ArrayList<ParametroReporte> parametrosFiltro,
            Reporte reporte, String estilo2) {
        mostrarReporte(dataSource, parametrosFiltro, reporte, estilo2, new HashMap());

    }

    public void mostrarReporte(List dataSource, ArrayList<ParametroReporte> parametrosFiltro,
            Reporte reporte, String estilo2, Map parameters) {
        if (reporte.getEnviarData() && (dataSource == null || dataSource.isEmpty())) {
            JOptionPane.showMessageDialog(MDIFrame.getInstance(), "El documento no tiene paginas.");
        } else {
            for (ParametroReporte parametro : parametrosFiltro) {
                if (parametro.getOperador().compareToIgnoreCase("like") == 0) {
                    parametro.setValor(parametro.getValor().replaceAll("%", ""));
                }
                parametro.setAtributo(ClientSettings.getInstance().getResources().getResource(parametro.getAtributo()));
                parametro.setOperador(ClientSettings.getInstance().getResources().getResource(parametro.getOperador()));
            }
            try {
                String rutaReporte = General.empresa.getRutaReportes() + "/" + reporte.getFile() + ".jasper";
                //Map parameters = new HashMap();
                parameters.put("reporteSQL", reporte.getBaseSQL());
                parameters.put(JRParameter.REPORT_LOCALE, Locale.getDefault());
                parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, java.util.ResourceBundle.getBundle("Spanish"));
                parameters.put("datosSistema",
                        new String[]{
                            General.edition + " "});
                parameters.put("reporteTitulo", reporte.getTitulo());
                parameters.put("reporteFile", reporte.getFile());
                parameters.put("reporteEstilo", estilo2);
                parameters.put("datosSistema", new String[]{
                            General.version,
                            "Nelson Moncada. 0426-1773440, 0277-2916179; nelsonj.moncada@gmail.com"});
//                parameters.put("draco", getIcon("draco_Report"));
                parameters.put("reporteParametros", parametrosFiltro);
                parameters.put("usuario", General.usuario.getUserName());
                parameters.put("oficina", General.oficina.getNombre());
                parameters.put("responsable", General.oficina.getResponsable());
                if (encabezado == null) {
                    parameters.put("empresaNombre", General.empresa.getNombre());
                    parameters.put("empresaRif", General.empresa.getRif2());
                    parameters.put("empresaTelefono", General.empresa.getTelefonos());
                    parameters.put("empresaLogo", getIcon(null));
                    parameters.put("empresaObservacion", "");
                } else {
                    parameters.put("empresaNombre", encabezado.getNombre());
                    parameters.put("empresaRif", encabezado.getRif2());
                    parameters.put("empresaLogo", getIcon(encabezado.getImagen()));
                    parameters.put("empresaObservacion", encabezado.getObservacion());

                }
                JasperPrint jasperPrint = null;

                Date consulta = new Date();

                if (reporte.getEnviarData()) {
                    jasperPrint = JasperFillManager.fillReport(
                            rutaReporte,
                            parameters,
                            new JRBeanCollectionDataSource(dataSource, reporte.getUseFieldDescription()));
                } else if (reporte.getHql()) {
                    Session s = null;
                    Transaction transaction = null;
                    try {
                        s = HibernateUtil.getSessionFactory().openSession();
                        transaction = s.beginTransaction();
                        parameters.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, s);
                        //parameters.put("HIBERNATE_SESSION", s);
                        jasperPrint = JasperFillManager.fillReport(
                                rutaReporte, parameters);
                    } finally {
                        transaction.rollback();
                        s.close();
                    }
                } else if (!reporte.getHql()) {
                    Session s = null;
                    try {
                        s = HibernateUtil.getSessionFactory().openSession();
                        jasperPrint = JasperFillManager.fillReport(
                                rutaReporte, parameters,
                                s.connection());
                    } finally {
                        s.close();
                    }
                }

                JasperViewer frame = new JasperViewer(jasperPrint, false);
                frame.setState(JFrame.MAXIMIZED_BOTH);
                frame.setAlwaysOnTop(true);
                //x.toFront();
                frame.setVisible(true);
                // System.out.println("Vista levantada");
                System.out.println("Tiempo de Llenado de Reporte: " + (new Date().getTime() - consulta.getTime()) + " (" + (new Date().getTime() - consulta.getTime()) / 1000.0 / 60.0 + ")");
                if (consultaInicio != null) {
                    System.out.println("Tiempo de Llenado de Reporte: " + (new Date().getTime() - consultaInicio.getTime()) + " (" + (new Date().getTime() - consultaInicio.getTime()) / 1000.0 / 60.0 + ")");
                }

//                para mostrar reporte en pdf en la web
//                OutputStream ouputStream = new FileOutputStream(new File("reporteListo.pdf"));
//                dataSource=new ArrayList(0);
//
//                Data clasex=new Data();
//                clasex.setNombre("nombreX1111");
//                //clasex.setFecha((Date)request.getParameter("directo"));
//
//                dataSource.add(clasex);
//                byte[] bytes = JasperRunManager.runReportToPdf(rutaReporte, parameters, new JRBeanCollectionDataSource(dataSource));
//                System.out.println(bytes.length);
//                System.out.println(bytes);
//                ouputStream.write(bytes, 0, bytes.length);
//                ouputStream.flush();
//                ouputStream.close();


            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "mostrarReporte", ex);
            }
        }
    }

    public void mostrarReporte(
            List dataSource,
            ArrayList<ParametroReporte> parametrosFiltro,
            String archivo,
            String titulo,
            String estilo2,
            Session session) {

        if (!dataSource.isEmpty()) {
            for (ParametroReporte parametro : parametrosFiltro) {
                if (parametro.getOperador().compareToIgnoreCase("like") == 0) {
                    parametro.setValor(parametro.getValor().substring(1, parametro.getValor().length()
                            - 1));
                }
                parametro.setAtributo(ClientSettings.getInstance().getResources().getResource(parametro.getAtributo()));
                parametro.setOperador(ClientSettings.getInstance().getResources().getResource(parametro.getOperador()));
            }
            try {
                String rutaReporte = General.empresa.getRutaReportes() + "/" + archivo + ".jasper";
                Map parameters = new HashMap();
                parameters.put(JRParameter.REPORT_LOCALE, Locale.getDefault());
                parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, java.util.ResourceBundle.getBundle("Spanish"));
                parameters.put("datosSistema",
                        new String[]{
                            General.edition,
                            "Nelson Moncada. 0426-1773440; nelsonj.moncada@gmail.com"});
                parameters.put("reporteTitulo", titulo);
                parameters.put("reporteFile", archivo);
                parameters.put("reporteEstilo", estilo2);
                parameters.put("reporteParametros", parametrosFiltro);
                parameters.put("usuario", General.usuario.getUserName());
                parameters.put("oficina", General.oficina.getNombre());
                parameters.put("responsable", General.oficina.getResponsable());
                parameters.put("oficinaObject", General.oficina);
                parameters.put("empresaObject", General.empresa);
                parameters.put("nume", "numeroxxxxxxxx");

                if (encabezado == null) {
                    parameters.put("empresaNombre", General.empresa.getNombre());
                    parameters.put("empresaRif", General.empresa.getRif2());
                    parameters.put("empresaTelefono", General.empresa.getTelefonos());
                    parameters.put("empresaLogo", getIcon(null));
                    parameters.put("empresaObservacion", "");
                } else {
                    parameters.put("empresaNombre", encabezado.getNombre());
                    parameters.put("empresaRif", encabezado.getRif2());
                    parameters.put("empresaLogo", getIcon(encabezado.getImagen()));
                    parameters.put("empresaObservacion", encabezado.getObservacion());
                }
                parameters.put("HIBERNATE_SESSION", session);

                JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporte, parameters, new JRBeanCollectionDataSource(
                        dataSource));
                JasperViewer.viewReport(jasperPrint, false);

                session.close();

//                OutputStream ouputStream = new FileOutputStream(new File("reporteListo.pdf"));
//
//                dataSource=new ArrayList(0);
//
//                Data clasex=new Data();
//                clasex.setNombre("nombreX1111");
//                //clasex.setFecha((Date)request.getParameter("directo"));
//
//                dataSource.add(clasex);
//                byte[] bytes = JasperRunManager.runReportToPdf(rutaReporte, parameters, new JRBeanCollectionDataSource(dataSource));
//                System.out.println(bytes.length);
//                System.out.println(bytes);
//                ouputStream.write(bytes, 0, bytes.length);
//                ouputStream.flush();
//                ouputStream.close();


            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "mostrarReporte", ex);
            }
        } else {
            JOptionPane.showMessageDialog(MDIFrame.getInstance(), "El documento no tiene paginas.");
        }
    }
//    public void mostrarReporte(List dataSource, ArrayList<ParametroReporte> parametrosFiltro, String archivo, String titulo, String estilo2) {
//        if (!dataSource.isEmpty()) {
//            for (ParametroReporte parametro : parametrosFiltro) {
//                if (parametro.getOperador().compareToIgnoreCase("like") == 0) {
//                    parametro.setValor(parametro.getValor().substring(1, parametro.getValor().length() - 1));
//                }
//                parametro.setAtributo(ClientSettings.getInstance().getResources().getResource(parametro.getAtributo()));
//                parametro.setOperador(ClientSettings.getInstance().getResources().getResource(parametro.getOperador()));
//            }
//            try {
//                String rutaReporte = General.empresa.getRutaReportes() + "/" + archivo + ".jasper";
//                Map parameters = new HashMap();
//                parameters.put(JRParameter.REPORT_LOCALE, Locale.getDefault());
//                parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, java.util.ResourceBundle.getBundle("Spanish"));
//                parameters.put("datosSistema", new String[]{
//                            General.version,
//                            "Nelson Moncada - Nelson Moncada. 0416-6762389; 0414-3765465; 0424-7040614; jsipolee@gmail.com"});
//                parameters.put("reporteTitulo", titulo);
//                parameters.put("reporteFile", archivo);
//                parameters.put("reporteEstilo", estilo2);
//                parameters.put("reporteParametros", parametrosFiltro);
//                parameters.put("usuario", General.usuario.getUserName());
//                parameters.put("oficina", General.oficina.getNombre());
//                parameters.put("responsable", General.oficina.getResponsable());
//
//                if (encabezado == null) {
//                    parameters.put("empresaNombre", General.empresa.getNombre());
//                    parameters.put("empresaRif", General.empresa.getRif2());
//                    parameters.put("empresaTelefono", General.empresa.getTelefonos());
//                    parameters.put("empresaLogo", getIcon(null));
//                    parameters.put("empresaObservacion", "");
//                    parameters.put("empresaDireccion", General.empresa.getDireccion());
////                    parameters.put("empresaSuperintendencia", General.empresa.getSuperintendencia());
//                    parameters.put("empresaPagina", General.empresa.getWeb());
//                    parameters.put("empresaEmail", General.empresa.getEmail());
//                } else {
//                    parameters.put("empresaNombre", encabezado.getNombre());
//                    parameters.put("empresaRif", encabezado.getRif2());
//                    parameters.put("empresaTelefono", encabezado.getTelefonos());
//                    parameters.put("empresaLogo", getIcon(encabezado.getImagen()));
//                    parameters.put("empresaObservacion", encabezado.getObservacion());
//                    parameters.put("empresaDireccion", encabezado.getDireccion());
//                    parameters.put("empresaSuperintendencia", encabezado.getSuperintendencia());
//                    parameters.put("empresaPagina", encabezado.getWeb());
//                    parameters.put("empresaEmail", encabezado.getEmail());
//                }
//                JasperPrint jasperPrint = JasperFillManager.fillReport(rutaReporte, parameters, new JRBeanCollectionDataSource(dataSource, false));
//                JasperViewer.viewReport(jasperPrint, false);
//
//
////                OutputStream ouputStream = new FileOutputStream(new File("reporteListo.pdf"));
////
////                dataSource=new ArrayList(0);
////
////                Data clasex=new Data();
////                clasex.setNombre("nombreX1111");
////                //clasex.setFecha((Date)request.getParameter("directo"));
////
////                dataSource.add(clasex);
////                byte[] bytes = JasperRunManager.runReportToPdf(rutaReporte, parameters, new JRBeanCollectionDataSource(dataSource));
////                System.out.println(bytes.length);
////                System.out.println(bytes);
////                ouputStream.write(bytes, 0, bytes.length);
////                ouputStream.flush();
////                ouputStream.close();
//
//
//            } catch (Exception ex) {
//                LoggerUtil.error(this.getClass(), "mostrarReporte", ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(MDIFrame.getInstance(), "El documento no tiene paginas.");
//        }
//    }
    protected DefaultGridFrame gridF;

    public void showReport(Reporte reporte, boolean isFiltroObligadoActivo, String estilo, Encabezado encabezado) {
        this.reporte = reporte;
        this.estilo = estilo;
        this.isFiltroActivo = isFiltroObligadoActivo;
        //System.out.println(estilo);
        this.encabezado = encabezado;
        //System.out.println("showReport");
        //System.out.println(isFiltroActivo);
        if (isFiltroObligadoActivo) {
            //System.out.println("filtro");
            gridF = null;

            gridF = new Filtros().mostrarFiltro(reporte, false);

//            if (gridF != null) {
//                gridF.inicializar(this, this, null, null, false);
//                gridF.getGridControl().setAutoLoadData(false);
//                FilterButton botonFiltro = gridF.getGridControl().getFilterButton();
//                botonFiltro.setEnabled(true);
//                botonFiltro.doClick();
//                try {
//                    gridF.closeFrame();
//                } catch (PropertyVetoException ex) {
//                    LoggerUtil.error(this.getClass(), "showReport", ex);
//                }
//            }
        } else {
            //System.out.println("else");
            Session s = null;
            try {
                s = HibernateUtil.getSessionFactory().openSession();
                List dataSource = s.createQuery(reporte.getBaseSQL()).list();
                mostrarReporte(dataSource, new ArrayList<ParametroReporte>(0), reporte, estilo);
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "showReport", ex);
            } finally {
                s.close();
            }
        }
    }

    public Response loadData(Reporte reporte, String estilo, int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        this.reporte = reporte;
        this.estilo = estilo;
        return loadData(action, startIndex, filteredColumns, currentSortedColumns, currentSortedVersusColumns, valueObjectType, otherGridParams);
    }

    public Response loadData(
            ArrayList<Object> paramValues,
            ArrayList<Type> paramTypes,
            Reporte reporte,
            String estilo,
            int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {

        this.reporte = reporte;
        this.estilo = estilo;
        return loadData(paramValues, paramTypes, action, startIndex, filteredColumns, currentSortedColumns,
                currentSortedVersusColumns, valueObjectType, otherGridParams);
    }

    public Response loadData(
            ArrayList<Object> paramValues,
            ArrayList<Type> paramTypes,
            int action,
            int startIndex,
            Map filteredColumns,
            ArrayList currentSortedColumns,
            ArrayList currentSortedVersusColumns,
            Class valueObjectType,
            Map otherGridParams) {

        if (isFiltroActivo && filteredColumns.isEmpty()) {
            return new VOListResponse(new ArrayList(0), false, 0);
        }
        Session s = null;
        try {
            String sql = reporte.getBaseSQL();
            SessionFactory sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            Type arraytype[] = new Type[paramTypes.size()];
            paramTypes.toArray(arraytype);
            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    valueObjectType,
                    sql,
                    paramValues.toArray(),
                    arraytype,
                    "P",
                    sf,
                    s);

            if (res.isError() || res instanceof ErrorResponse) {
                return res;
            } else {
                List dataSource = ((VOListResponse) res).getRows();
                ArrayList<ParametroReporte> parametros = new ArrayList<ParametroReporte>(0);
                if (filteredColumns == null || filteredColumns.isEmpty()) {
                    filteredColumns = otherGridParams;
                }
                for (Object os : filteredColumns.values().toArray()) {
                    FilterWhereClause[] fwcS =
                            (org.openswing.swing.message.send.java.FilterWhereClause[]) os;
                    for (FilterWhereClause fwc : fwcS) {
                        if (fwc != null) {
                            String valor = fwc.getValue().toString();
                            if (fwc.getValue() instanceof Date) {
                                Date d = (Date) fwc.getValue();
                                String mask = null;
                                if (d.getMinutes() != 0) {
                                    mask = ClientSettings.getInstance().getResources().getDateMask(
                                            Consts.TYPE_DATE_TIME);
                                } else {
                                    mask = ClientSettings.getInstance().getResources().getDateMask(ClientSettings.getInstance().getResources().getDateFormat());
                                }
                                valor = new SimpleDateFormat(mask).format(fwc.getValue());
                            }
                            parametros.add(new ParametroReporte(fwc.getAttributeName(), fwc.getOperator(), valor));
                        }
                    }
                }
                mostrarReporte(dataSource, parametros, reporte, estilo);
                return new VOListResponse(new ArrayList(0), false, 0);
            }
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "loadData", ex);
            return new ErrorResponse(ex.getMessage());
        } finally {
            s.close();
        }
    }

    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        if (isFiltroActivo && filteredColumns.isEmpty()) {
            return new VOListResponse(new ArrayList(0), false, 0);
        }
        Session s = null;
        try {
            String sql = reporte.getBaseSQL();
            SessionFactory sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    valueObjectType,
                    sql,
                    objects.toArray(),
                    types.toArray(new Type[0]),
                    "P",
                    sf,
                    s);
            if (res.isError() || res instanceof ErrorResponse) {
                return res;
            } else {
                List dataSource = ((VOListResponse) res).getRows();
                ArrayList<ParametroReporte> parametros = new ArrayList<ParametroReporte>(0);
                for (Object os : filteredColumns.values().toArray()) {
                    FilterWhereClause[] fwcS = (org.openswing.swing.message.send.java.FilterWhereClause[]) os;
                    for (FilterWhereClause fwc : fwcS) {
                        if (fwc != null) {
                            String valor = fwc.getValue().toString();
                            if (fwc.getValue() instanceof Date) {
                                Date d = (Date) fwc.getValue();
                                String mask = null;
                                if (d.getMinutes() != 0) {
                                    mask = ClientSettings.getInstance().getResources().getDateMask(Consts.TYPE_DATE_TIME);
                                } else {
                                    mask = ClientSettings.getInstance().getResources().getDateMask(ClientSettings.getInstance().getResources().getDateFormat());
                                }
                                valor = new SimpleDateFormat(mask).format(fwc.getValue());
                            }
                            parametros.add(new ParametroReporte(fwc.getAttributeName(), fwc.getOperator(), valor));
                        }
                    }
                }
                mostrarReporte(dataSource, parametros, reporte, estilo);
                return new VOListResponse(new ArrayList(0), false, 0);
            }
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "loadData", ex);
            return new ErrorResponse(ex.getMessage());
        } finally {
            s.close();
        }
    }

    public static Image getIcon(String img) {
        Image i = icons.get(img);
        if (i == null) {
            try {
                if (img == null) {
                    i = Toolkit.getDefaultToolkit().createImage(JRLoader.loadBytes(ReporteController.class.getResource("/images/companyIcon.png")));
                } else {
                    i = Toolkit.getDefaultToolkit().createImage(JRLoader.loadBytes(ReporteController.class.getResource("/images/" + img + ".png")));
                }
                MediaTracker traker = new MediaTracker(new Panel());
                traker.addImage(i, 0);
                try {
                    traker.waitForID(0);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                icons.put(img, i);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
        List<String> list = new ArrayList<String>();
        Collections.sort(list);


        return i;
    }

    @Override
    public void loadDataCompleted(boolean error) {
    }

    public ArrayList getObjects() {
        return objects;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }
}
