
import controlador.Principal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nelson Moncada
 */
public class Run {
//    private static Session s;

    public static void main(String[] args) throws IOException {

        BufferedReader b =null;
        b= new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("hostname").getInputStream()));
        String hostname=b.readLine();
        System.getProperties().put("COMPUTERNAME", hostname);
        System.getProperties().put("valido", "si");
        if (args == null || args.length == 0) {
            new Principal();
            Principal.splah.dispose();
        }

//        if (args == null || args.length == 0) {
//            Principal p=new Principal();
//            //Principal.getSplah().setVisible(true);
//        }
    }
}
