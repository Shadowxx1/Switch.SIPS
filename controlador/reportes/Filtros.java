package controlador.reportes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entidades.Reporte;
import vista.personas.Personas2GridFrame;
import vista.polizas.financiamiento.FinanciamientosGridFrame;
import vista.polizas.recibos.RecibosGridFrame;
import vista.polizas.recibos.distribucion.DistribucionGridFrame;
import vista.reportes.FiltroDistribucionDialog;
import vista.reportes.FiltroFinanciamientoSencilloDialog;
import vista.reportes.FiltroRecibosDialog;
import vista.reportes.FiltroRenovacionesDialog;
import vista.reportes.FiltroResumenRecibosDialog;
import vista.reportes.FiltroSiniestroDialog;
import vista.util.DefaultGridFrame;

/**
 *
 * @author orlandobcrra
 */
public class Filtros {

    public DefaultGridFrame mostrarFiltro(Reporte reporte, boolean sencillo) {
        if (reporte.getFiltroObligado()) {
            levantarVista(reporte);
        } else {
            if (!sencillo) {
                switch (reporte.getCategoria()) {

                    case PERSONAS: {
                        return new Personas2GridFrame();
                    }
                    case COMISIONES: {
                        return new RecibosGridFrame();
                    }
                    case RECIBOS: {
                        return new RecibosGridFrame();
                    }
                    case DISTRIBUCION: {
                        return new DistribucionGridFrame();
                    }
                    case RENOVACIONES: {
                        return new RecibosGridFrame();
                    }
                    case FINANCIAMIENTOS: {
                        return new FinanciamientosGridFrame();
                    }
                    case SUPERINTENDENDENCIA: {
                        return new RecibosGridFrame();
                    }
                    default: {
                        System.out.println("Opcion invalida");
                        throw new UnsupportedOperationException("Not yet implemented");
                    }
                }
            } else {
                switch (reporte.getCategoria()) {
                    case RENOVACIONES: {
                        new FiltroRenovacionesDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    }
                    case COMISIONES: {
                        new FiltroRecibosDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    }
                    case RECIBOS: {
                        new FiltroRecibosDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    }
                    case DEVOLUCIONES:
                        new FiltroRecibosDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    case SUPERINTENDENDENCIA:
                        new FiltroRecibosDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    case DISTRIBUCION:
                        new FiltroDistribucionDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    case SINIESTROS:
                        new FiltroSiniestroDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    case RESUMEN:
                        new FiltroResumenRecibosDialog(reporte, "Estilo3.jrtx").setVisible(true);
                        break;
                    case FINANCIAMIENTOS:
                        new FiltroFinanciamientoSencilloDialog(reporte, "Estilo3.jrtx").setVisible(true);
                    default: {
                        throw new UnsupportedOperationException("Not yet implemented");

                    }
                }
            }
        }
        return null;
    }

    private void levantarVista(Reporte reporte) {
        {
            Constructor construc = null;
            try {
                Class openConstructorClass[] = new Class[]{String.class, Reporte.class, String.class};
                Object valueConstructorClass[] = new Object[]{reporte.getVistaFiltro(), reporte, "Estilo3.jrtx"};
                Class clase = Class.forName(reporte.getControllerFiltro());
                construc = clase.getConstructor(openConstructorClass);
                construc.newInstance(valueConstructorClass);
            } catch (InstantiationException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
