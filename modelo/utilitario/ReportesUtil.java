package modelo.utilitario;

import controlador.General;
import controlador.reportes.ReporteController;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.Dominios.Sexo;
import modelo.HibernateUtil;
import modelo.entidades.Documento;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.personas.maestra.PersonaNatural;
import modelo.entidades.polizas.financiamiento.Financiamiento;
import modelo.entidades.polizas.maestra.Poliza;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.classic.Session;

/**
 *
 * @author Adrian
 */
public class ReportesUtil {

    /**
     * direccion donde se guardan los documentos adjuntos 
     * o ubicacion del servidor de archivos
     */
    private static String server = General.empresa.getRutaDocDigitales();

    /**
     * round Double whit two decimals 
     * @param numero 
     * @return 
     */
    public static String dosDecimales(Double numero) {
        DecimalFormat d = new DecimalFormat("#,##0.00");
        return d.format(numero);
    }

    /**
     * PATHER TO DATE (EEEEE dd de MMMM de YYYY)
     * @param fecha
     * @return 
     */
    public static String fechaCompleta(Date fecha) {
        SimpleDateFormat f = new SimpleDateFormat("EEEEE dd");
        SimpleDateFormat m = new SimpleDateFormat("MMMM");
        SimpleDateFormat y = new SimpleDateFormat("yyyy");

        return f.format(fecha) + " de " + m.format(fecha) + " de " + y.format(fecha);
    }

    /**
     * obtiene la imagen de nombre de tipo documento FOTO para un objeto especifico
     * @param object
     * @return 
     */
    public static Image getImageFOTO(Auditable object) {
        Image i = null;
        Sexo sexo = Sexo.MASCULINO;
        i = getImage(object, "FOTO");
        if (i == null) {
            if (object instanceof Recibo) {
                if((((Recibo) object).getAsegurado()) instanceof PersonaNatural)
                    sexo = ((PersonaNatural)((Recibo) object).getAsegurado()).getSexo();
            }
            if (object instanceof Poliza) {
                if((((Poliza) object).getContratante()) instanceof PersonaNatural)
                    sexo = ((PersonaNatural)((Poliza) object).getContratante()).getSexo();
            }

//            if (object instanceof AsesorPorcentaje) {
//                if((((AsesorPorcentaje) object).getAsesor()) instanceof PersonaNatural)
//                    sexo = ((PersonaNatural)((AsesorPorcentaje) object).getAsesor()).getSexo();
//            }

            if (object instanceof Financiamiento) {
                if((((Financiamiento) object).getPagador()) instanceof PersonaNatural)
                    sexo = ((PersonaNatural)((Financiamiento) object).getPagador()).getSexo();
            }

            if (object instanceof PersonaNatural) {
                sexo = ((PersonaNatural) object).getSexo();
            }
            if (sexo.equals(Sexo.FEMENINO)) {
                i = ReporteController.getIcon("female");
            } else {
                i = ReporteController.getIcon("male");;
            }
        }

        return i;
    }

    /**
     * Retorna la imagen del documento especifico para la clase especifica
     * @param object
     * @param tipoDocumento
     * @return 
     */
    public static Image getImage(Auditable object, String tipoDocumento) {
        String path = server + "\\" + object.getClass().getSimpleName() + "\\" + object.getId() + "\\";
        Image i = null;
        Session s = null;
        List<Documento> doc = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            doc = s.createQuery("SELECT D FROM "
                    + object.getClass().getName() + " C "
                    + " JOIN C.documentos D WHERE  C.id =?").setLong(0, object.getId()).list();
            s.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            doc = new ArrayList<Documento>(0);
        }
        for (Documento documento : doc) {
            if (documento.getTipoDocumento().getNombre().
                    compareToIgnoreCase(tipoDocumento) == 0) {
                try {
                    i = Toolkit.getDefaultToolkit().createImage(JRLoader.loadBytes(
                            new File(path + documento.getFileName())));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (i != null) {
            MediaTracker traker = new MediaTracker(new Panel());
            traker.addImage(i, 0);
            try {
                traker.waitForID(0);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return i;
    }

    /***
     * Retorna la diferencia en dias entre dos fechas
     * @param date1
     * @param date2
     * @return 
     */
    public static int diferenciaEnDias(Date date1, Date date2) {
        java.util.GregorianCalendar dateA = (java.util.GregorianCalendar) Calendar.getInstance();
        java.util.GregorianCalendar dateB = (java.util.GregorianCalendar) Calendar.getInstance();
        dateA.setTime(date1);
        dateB.setTime(date2);
        long difms = dateB.getTimeInMillis() - dateA.getTimeInMillis();
        int difd = (int) (difms / 1000 / 60 / 60 / 24);
        return difd;
    }
    
}
