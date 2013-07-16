/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilitario;

/**
 * Clase con utilidades para las consultas SQL
 * @author Nelson Moncada
 * 
 */
public class UtilidadesSQL {

    /**
     * Tipo de clausulas que se le pueden agregar
     */
    public static enum Where {
        AND,
        OR
    }

    /**
     * Agrega a la sentencia where una condicion mas
     * @param sql Consulta HQL
     * @param clausula Clausula where a agregar 
     * @param sentencia Sentencia where a agregar
     */
    public static String addWhere(String sql, Where clausula, String sentencia) {
        String where;
        String from;
        String select;
        String orderBy;
        String groupBy;
        String having;

        sql = " " + sql.replace('\n', ' ').replace('\r', ' ') + " ";
        String lowerSQL = sql.toLowerCase();
        int s1 = lowerSQL.indexOf("select "); // may be "" or null for a base SQL written for JPA/ORM layer
        int f1 = lowerSQL.indexOf(" from ");
        int w1 = lowerSQL.indexOf(" where ");
        int g1 = lowerSQL.indexOf(" group by ");
        int h1 = lowerSQL.indexOf(" having ");
        int o1 = lowerSQL.indexOf(" order by ");
        int s2, f2, w2, g2, h2, o2;

        if (o1 == -1) {
            o1 = sql.length() - 1;
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

        select = sql.substring(s2, f1).trim(); // select
        from = sql.substring(f2, w1).trim(); // from
        where = sql.substring(w2, g1).trim(); // where
        groupBy = sql.substring(g2, h1).trim(); // group by
        having = sql.substring(h2, o1).trim(); // having
        orderBy = sql.substring(o2).trim(); // order by        

        String baseSQL = "";
        if (select != null && select.trim().length() > 0) {
            baseSQL += "SELECT " + select;
        }

        baseSQL += " FROM " + from;

        if (where != null && !where.trim().equals("")) {
            baseSQL += " WHERE " + where;
        }
        if (where != null && !where.trim().equals("")) {
            baseSQL += " "+clausula.name()+" ";
        } else {
            baseSQL += " WHERE ";
        }

        baseSQL += sentencia;

        if (groupBy != null && !groupBy.trim().equals("")) {
            baseSQL += " GROUP BY " + groupBy;
        }
        if (having != null && !having.trim().equals("")) {
            baseSQL += " HAVING " + having;
        }
        if (orderBy != null && !orderBy.trim().equals("")) {
            baseSQL += " ORDER BY " + orderBy;
        }
        
        return baseSQL;
    }
  
    public static String addWhere(String sql, String sentencia) {
        String where;
        String from;
        String select;
        String orderBy;
        String groupBy;
        String having;

        sql = " " + sql.replace('\n', ' ').replace('\r', ' ') + " ";
        String lowerSQL = sql.toLowerCase();
        int s1 = lowerSQL.indexOf("select "); // may be "" or null for a base SQL written for JPA/ORM layer
        int f1 = lowerSQL.indexOf(" from ");
        int w1 = lowerSQL.indexOf(" where ");
        int g1 = lowerSQL.indexOf(" group by ");
        int h1 = lowerSQL.indexOf(" having ");
        int o1 = lowerSQL.indexOf(" order by ");
        int s2, f2, w2, g2, h2, o2;

        if (o1 == -1) {
            o1 = sql.length() - 1;
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

        select = sql.substring(s2, f1).trim(); // select
        from = sql.substring(f2, w1).trim(); // from
        where = sql.substring(w2, g1).trim(); // where
        groupBy = sql.substring(g2, h1).trim(); // group by
        having = sql.substring(h2, o1).trim(); // having
        orderBy = sql.substring(o2).trim(); // order by        

        String baseSQL = "";
        if (select != null && select.trim().length() > 0) {
            baseSQL += "SELECT " + select;
        }

        baseSQL += " FROM " + from;

        if (where != null && !where.trim().equals("")) {
            baseSQL += " WHERE " + where;
        }
        if (where != null && !where.trim().equals("")) {
            baseSQL += "";
        } else {
            baseSQL += " WHERE ";
        }

        baseSQL += sentencia;

        if (groupBy != null && !groupBy.trim().equals("")) {
            baseSQL += " GROUP BY " + groupBy;
        }
        if (having != null && !having.trim().equals("")) {
            baseSQL += " HAVING " + having;
        }
        if (orderBy != null && !orderBy.trim().equals("")) {
            baseSQL += " ORDER BY " + orderBy;
        }
        
        return baseSQL;
    }    
    
}
