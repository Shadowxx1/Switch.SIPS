package controlador.reportes;

import vista.reportes.EsperaDialog;
import controlador.util.DefaultGridFrameController;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JDialog;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.Reporte;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.type.Type;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import vista.reportes.ReportesGridFrame;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class ReportesGridController extends DefaultGridFrameController {

    //ReporteController filtro;
    public ReportesGridController(String gridFramePath, String detailFramePath, String claseModeloFullPath, String titulo) {
        super(gridFramePath, detailFramePath, claseModeloFullPath, titulo);
        //filtro=new ReporteController();
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        ReportesGridFrame frame = (ReportesGridFrame) gridFrame;
        Session s = null;
        try {
            String sql = "FROM " + claseModeloFullPath + " C ";
            boolean sw = false;
            if (frame.getCategoria() != null) {
                sql += " WHERE C.categoria='" + frame.getCategoria() + "' ";
                sw = true;
            }
            if (frame.getTipo() != -1) {
                if (sw) {
                    sql += " AND ";
                } else {
                    sql += " WHERE ";
                }
                sql += " C.tipo=" + frame.getTipo() + " ";
            }
            SessionFactory sf = HibernateUtil.getSessionFactory();
            s = sf.openSession();
            Response res = HibernateUtils.getAllFromQuery(
                    filteredColumns,
                    currentSortedColumns,
                    currentSortedVersusColumns,
                    valueObjectType,
                    sql,
                    new Object[0],
                    new Type[0],
                    "C",
                    sf,
                    s);
            return res;
        } catch (Exception ex) {
            LoggerUtil.error(this.getClass(), "loadData", ex);
            return new ErrorResponse(ex.getMessage());
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
        final Reporte reporte = (Reporte) persistentObject;
        final ReportesGridFrame frame = (ReportesGridFrame) gridFrame;
        final JDialog d = new EsperaDialog(null, false);
        //filtro.showReport(r, frame.isFiltroActivo(),frame.getMensaje());

        if (frame.isFiltroSencilloActivo()) {
            new Filtros().mostrarFiltro(reporte, true);
        } else {
            ClientUtils.centerDialog(MDIFrame.getInstance(), d);
            d.setVisible(true);
            frame.getMensaje().setVisible(true);
            new Thread() {

                @Override
                public void run() {
                    new ReporteController().showReport(reporte, reporte.getFiltroObligado(), frame.getEstilo(), frame.getEncabezado());
                    d.setVisible(false);
                    frame.getMensaje().setVisible(false);
                }
            }.start();
        }
    }
}
