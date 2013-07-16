package com.productores.caja.controlador;

import controlador.util.DefaultLookupController;
import controlador.util.DefaultLookupDataLocator;
import controlador.util.DefaultLookupGridController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logger.LoggerUtil;
import modelo.HibernateUtil;
import modelo.entidades.personas.transac.CuentaBancariaPersona;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;
import org.openswing.swing.message.receive.java.ErrorResponse;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOListResponse;
import org.openswing.swing.util.java.Consts;
import org.openswing.swing.util.server.HibernateUtils;

/**
 *
 * @author Nelson Moncada
 */
public class CuentaBancariaLookupController extends DefaultLookupController {

    public CuentaBancariaLookupController(String idPropio) {
        this.setLookupDataLocator(new CuentaBancariaLookupDataLocator(CuentaBancariaPersona.class.getName(), idPropio));
        this.setLookupGridController(new DefaultLookupGridController());
        setLookupValueObjectClassName(CuentaBancariaPersona.class.getName());
        setAllColumnVisible(false);
        setVisibleColumn("id", true);
        setVisibleColumn("banco.nombreCorto", true);
        setVisibleColumn("cuenta", true);
        setPreferredWidthColumn("id", 40);
        setPreferredWidthColumn("banco.nombreCorto", 100);
        setPreferredWidthColumn("cuenta", 200);
        setSortableColumn("id", true);
        setSortedColumn("id", Consts.DESC_SORTED, 0);
        setSortableColumn("banco.nombreCorto", true);
        setSortableColumn("cuenta", true);
        setFilterableColumn("banco.nombreCorto", true);
        setFilterableColumn("cuenta", true);
        setFramePreferedSize(new java.awt.Dimension(380, 340));
        setCodeSelectionWindow(GRID_FRAME);
        setOnInvalidCode(ON_INVALID_CODE_RESTORE_FOCUS);

    }

    class CuentaBancariaLookupDataLocator extends DefaultLookupDataLocator {

        String idPropio;

        public CuentaBancariaLookupDataLocator(String classFullName, String idPropio) {
            super(classFullName);
            this.idPropio = idPropio;
        }

        @Override
        public Response loadData(int action,
                int startIndex,
                Map filteredColumns,
                ArrayList currentSortedColumns,
                ArrayList currentSortedVersusColumns,
                Class valueObjectType) {
            Session s = null;
            try {
                String sql = "SELECT FROM " + CuentaBancariaPersona.class.getName()
//                        + " C LEFT JOIN C.tiposPersona T "
                        + " C WHERE C.auditoria.activo=?";
                SessionFactory sf = HibernateUtil.getSessionFactory();
                s = sf.openSession();
                //Map de=new HashMap(0);
                //de.put("rif.cedulaCompleta", "C.rif.cedulaCompleta");
                Response res = HibernateUtils.getAllFromQuery(
                   //     de,
                        filteredColumns,
                        currentSortedColumns,
                        currentSortedVersusColumns,
                        valueObjectType,
                        sql,
                        new Object[]{new Boolean(true)},
                        new Type[]{new BooleanType()},
                        "C",
                        sf,
                        s);
                //System.out.println("*************");
                //System.out.println(((VOListResponse)res).getRows().size());
                return res;
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "loadData", ex);
                return new ErrorResponse(ex.getMessage());
            } finally {
                s.close();
            }
        }

        @Override
        public Response validateCode(String code) {
            Session s = null;
            try {
                String sql = "SELECT FROM " + CuentaBancariaPersona.class.getName()
//                        + " C LEFT JOIN C.tiposPersona T "
                        + " C WHEREC.auditoria.activo=? ";
                s = HibernateUtil.getSessionFactory().openSession();
                Transaction t = s.beginTransaction();
                List list = s.createQuery(sql).
                        setBoolean(0, true).list();
                t.commit();
                return new VOListResponse(list, false, list.size());
            } catch (Exception ex) {
                LoggerUtil.error(this.getClass(), "validateCode", ex);
                return new ErrorResponse(ex.getMessage());
            } finally {
                s.close();
            }
        }
    }
}
