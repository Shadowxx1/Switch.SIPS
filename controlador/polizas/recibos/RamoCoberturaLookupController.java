package controlador.polizas.recibos;

import controlador.General;
import controlador.util.DefaultLookupController;
import controlador.util.DefaultLookupDataLocator;
import controlador.util.DefaultLookupGridController;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.polizas.dominio.RamoPoliza;
import modelo.entidades.polizas.dominio.RamoPoliza;
import modelo.entidades.polizas.recibos.cobertura.Cobertura;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.send.java.FilterWhereClause;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import org.openswing.swing.util.java.Consts;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class RamoCoberturaLookupController extends DefaultLookupController {

    private RamoPoliza ramoPoliza;

    public RamoCoberturaLookupController() {
        this.setLookupDataLocator(new RamoCoberturaLookupDataLocator(RamoPoliza.class.getName(), this));
        this.setLookupGridController(new RamoCoberturaLookupGridController(this));
        this.setFramePreferedSize(new Dimension(800, 400));
        
        this.setCodeSelectionWindow(RamoCoberturaLookupController.TREE_GRID_FRAME);
        this.getLookupDataLocator().setNodeNameAttribute("nombre");
        this.setLookupValueObjectClassName(Cobertura.class.getName());
        this.addLookup2ParentLink("cobertura");
        this.setAllColumnVisible(false);

        this.setGridInsertButton(true);
        this.setColumnEditableOnInsert("nombre", true);
        this.setColumnEditableOnInsert("nombreCorto", true);
        this.setColumnEditableOnInsert("descripcion", true);

        this.setGridEditButton(true);
        this.setColumnEditableOnEdit("nombre", true);
        this.setColumnEditableOnEdit("nombreCorto", true);
        this.setColumnEditableOnEdit("descripcion", true);

        this.setAllColumnRequired(false);
        this.setColumnRequired("nombre", true);
        this.setColumnRequired("nombreCorto", true);
        this.setColumnRequired("descripcion", true);

        this.setVisibleColumn("id", true);
        this.setVisibleColumn("nombre", true);
        this.setVisibleColumn("nombreCorto", true);
        this.setVisibleColumn("descripcion", true);

        this.setPreferredWidthColumn("id", 50);
        this.setPreferredWidthColumn("nombre", 200);
        this.setPreferredWidthColumn("nombreCorto", 150);
        this.setPreferredWidthColumn("descripcion", 150);

        this.setFilterableColumn("nombre", true);
        //this.setFilterableColumn("marca.nombre", true);

        //this.setSortableColumn("marca.nombre", true);
        this.setSortableColumn("nombre", true);
        this.setSortedColumn("nombre", Consts.ASC_SORTED);

    }

    class RamoCoberturaLookupDataLocator extends DefaultLookupDataLocator {

        private RamoCoberturaLookupController ramoCoberturaLookupController;

        public RamoCoberturaLookupDataLocator(String classFullName, RamoCoberturaLookupController ramoCoberturaLookupController) {
            super(classFullName);
            this.ramoCoberturaLookupController = ramoCoberturaLookupController;
        }

        @Override
        public Response loadData(int action,
                int startIndex,
                Map filteredColumns,
                ArrayList currentSortedColumns,
                ArrayList currentSortedVersusColumns,
                Class valueObjectType) {
            try {
                Map map = getLookupFrameParams();
                if (map.get(Consts.TREE_FILTER) != null) {
                    RamoPoliza ramo = (RamoPoliza) map.get(Consts.TREE_FILTER);
                    if (ramo.getId() != -1) {
                        filteredColumns.put(
                                "ramo.id",
                                new FilterWhereClause[]{
                                    new FilterWhereClause("ramo.id", "=", ramo.getId()),
                                    null
                                });
                        //return new VOListResponse(new ArrayList(marca.getModelos()), false, marca.getModelos().size());
                        Session s = null;
                        try {
                            String sql = "FROM " + Cobertura.class.getName() + " C ";
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
                            filteredColumns = new HashMap(0);

                            ramoPoliza = ramo;

                            return res;
                        } catch (Exception ex) {
                            LoggerUtil.error(this.getClass(), "loadData", ex);
                            return new ErrorResponse(ex.getMessage());
                        } finally {
                            s.close();
                        }
                    } else {
                        return new VOListResponse(new ArrayList(0), false, 0);
                    }
                }
                return new VOListResponse(new ArrayList(0), false, 0);
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "loadData", ex);
                return new ErrorResponse(ex.getMessage());
            }
        }

        @Override
        public Response getTreeModel(JTree tree) {
            Session s = null;
            try {
                RamoPoliza vo = null;
                vo = new RamoPoliza();
                vo.setId(new Long(-1));
                vo.setNombre("Ramos");
                DefaultMutableTreeNode root = new OpenSwingTreeNode(vo);
                s = HibernateUtil.getSessionFactory().openSession();
                List ramos = s.createQuery("FROM " + RamoPoliza.class.getName() + " M ORDER BY M.nombre").list();
                for (Object ramo : ramos) {
                    root.add(new OpenSwingTreeNode(ramo));
                }
                return new VOResponse(new DefaultTreeModel(root));
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "getTreeModel", ex);
                return new VOResponse(new DefaultTreeModel(new OpenSwingTreeNode()));
            } finally {
                s.close();
            }
        }
    }

    class RamoCoberturaLookupGridController extends DefaultLookupGridController {

        private RamoCoberturaLookupController ramoCoberturaLookupController;

        public RamoCoberturaLookupGridController(RamoCoberturaLookupController ramoCoberturaLookupController) {
            this.ramoCoberturaLookupController = ramoCoberturaLookupController;
        }

        @Override
        public Response deleteRecords(ArrayList persistentObjects) throws Exception {
            Session s = null;
            try {
                boolean allOk = true;
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                for (Object o : persistentObjects) {
                    if (o instanceof Auditable) {
                        AuditoriaBasica a = ((Auditable) o).getAuditoria();
                        if (a != null && a.getBorrable() != null && !a.getBorrable()) {
                            return new ErrorResponse("El registro no es borrable!!!");
                        } else {
                            s.delete(o);
                        }
                    } else {
                        s.delete(o);
                    }
                }
                try {
                    t.commit();
//                System.out.println("Borrraaaaaa");
                } catch (Exception ex) {
                    LoggerUtil.error(this.getClass(), "deleteRecords", ex);
                    t.rollback();
                    allOk = false;
                }
                if (allOk) {
                    return new VOResponse(true);
                } else {
                    return new ErrorResponse("delete.constraint.violation");
                }
            } finally {
                s.close();
            }
        }

        @Override
        public Response insertRecords(int[] rowNumbers, ArrayList newValueObjects) throws Exception {
            Session s = null;
            try {
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                AuditoriaBasica ab = new AuditoriaBasica(new Date(), General.usuario.getUserName(), true);
                for (Object o : newValueObjects) {
                    if (o instanceof Auditable) {
                        ((Auditable) o).setAuditoria(ab);
                    }

                    if (ramoPoliza != null) {
                        RamoPoliza r = (RamoPoliza) s.get(RamoPoliza.class, ramoPoliza.getId());
                        Hibernate.initialize(r.getCoberturas());
                        r.getCoberturas().add((Cobertura) o);
                        ((Cobertura) o).setRamo(r);
                        s.update(r);
                    } else {
                        s.save(o);
                    }

                }
                t.commit();
                return new VOListResponse(newValueObjects, false, newValueObjects.size());
            } catch (Exception ex) {
                return new ErrorResponse(LoggerUtil.isInvalidStateException(this.getClass(), "insertRecords", ex));
            } finally {
                s.close();
            }
        }
    }
}
