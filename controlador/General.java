

package controlador;


import java.util.HashMap;
import modelo.entidades.Empresa;
import modelo.entidades.Licencia;
import modelo.entidades.Oficina;
import modelo.entidades.Usuario;
import modelo.entidades.defaultData.DefaultPersona;
import modelo.entidades.menu.MenuByRol;


/**
 *
 * @author Nelson Moncada
 */
public class General {

    public static Usuario usuario = new Usuario();
    public static Empresa empresa = new Empresa();
    public static Licencia licencia = new Licencia();
    public static Oficina oficina = new Oficina();
    public static String version = "";
    public static String edition = "";
    public static String splashLine2 = "";
    public static DefaultPersona defaultPersona;
    public static HashMap<String,MenuByRol> permisologiaModulo=new HashMap<String,MenuByRol>(0);

//    public static Usuario usuario = new Usuario();
    public static String usuarioOS = "";
    public static String IP = "";
//    public static Empresa empresa = new Empresa();
//    public static Licencia licencia = new Licencia();
//    public static Oficina oficina = new Oficina();
//    public static String version = "";
//    public static String edition = "";
//    public static String copyRight = "";
//    public static String contacto = "";
//    public static String splashLine2 = "";
//    public static DefaultPersona defaultPersona;
//    public static HashMap<String,ConfiguracionesGenerales> parametros=new HashMap<String,ConfiguracionesGenerales>();
//    public static HashMap<String,MenuByRol> permisologiaModulo=new HashMap<String,MenuByRol>();
    
}
