/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilitario;

import antlr.collections.List;
import controlador.General;
import java.util.ArrayList;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.openswing.swing.logger.server.Logger;

/**
 *
 * @author NELSON
 */
public class SQLUtilidades {

    public static String getSql(String SQL, ArrayList<String> nomParametro, ArrayList<String> operador, ArrayList<String> valores) {
        try {
            SQL = " " + SQL.replace('\n', ' ').replace('\r', ' ') + " ";
            String lowerSQL = SQL.toLowerCase();
            int s1 = lowerSQL.indexOf("select "); // may be "" or null for a base SQL written for JPA/ORM layer
            int f1 = lowerSQL.indexOf(" from ");
            int w1 = lowerSQL.indexOf(" where ");
            int g1 = lowerSQL.indexOf(" group by ");
            int h1 = lowerSQL.indexOf(" having ");
            int o1 = lowerSQL.indexOf(" order by ");
            int s2, f2, w2, g2, h2, o2;

            if (o1 == -1) {
                o1 = SQL.length() - 1;
                o2 = o1;
            } else {
                o2 = o1 + 10;
            }
            if (h1 == -1) {
                h1 = o1;
                h2 = h1;
            } else {
                h2 = h1 + 8;
            }
            if (g1 == -1) {
                g1 = h1;
                g2 = g1;
            } else {
                g2 = g1 + 10;
            }
            if (w1 == -1) {
                w1 = g1;
                w2 = w1;
            } else {
                w2 = w1 + 7;
            }
            f2 = f1 + 6;
            if (s1 == -1) {
                s1 = f1;
                s2 = s1;
            } else {
                s2 = s1 + 7;
            }

            String select = SQL.substring(s2, f1).trim(); // select
            String from = SQL.substring(f2, w1).trim(); // from

            String baseSQL = "";
            if (select != null && select.trim().length() > 0) {
                baseSQL += "SELECT " + select;
            }
            baseSQL += " FROM " + from;

            String where = baseSQL.substring(w2, g1).trim(); // where

            if (where != null && !where.trim().equals("")) {
                baseSQL += " WHERE " + where;
            }

            if (nomParametro.size() > 0) {
                if (where != null && !where.trim().equals("")) {
                    baseSQL += " AND ";
                } else {
                    baseSQL += " WHERE ";
                }

                for (int i = 0; i < nomParametro.size(); i++) {
                    baseSQL += nomParametro.get(i) + operador.get(i);
                    if (valores.get(i) != null) {
                        baseSQL += valores.get(i);
                    }
                    baseSQL += " AND ";
                }
                baseSQL += baseSQL.substring(0, baseSQL.length() - " AND ".length());
            }

            String group = baseSQL.substring(g2, h1).trim(); // group by
            String having = baseSQL.substring(h2, o1).trim(); // having
            String order = baseSQL.substring(o2).trim(); // order by

            if (group != null && !group.trim().equals("")) {
                baseSQL += " GROUP BY " + group;
            }
            if (having != null && !having.trim().equals("")) {
                baseSQL += " HAVING " + having;
            }
            if (order != null && !order.trim().equals("")) {
                baseSQL += " ORDER BY " + order;
            }


        } catch (Throwable ex) {
            Logger.error(
                    General.usuario.getUserName(),
                    SQLUtilidades.class.getName(),
                    "getSql",
                    "Error al momenot de componer SQL:\n" + ex.getMessage(),
                    ex);
        }

        return SQL;
    }

    public static List getObjects(Query sql) {
        Session s = null;
        List l = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            Query SQL = s.createQuery(sql.getQueryString());
//            sql.setp
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return l;
    }

    public static Object getOneObject(String sql) {
        Session s = null;
        Object o = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            o = s.createQuery(sql).uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return o;
    }
}
