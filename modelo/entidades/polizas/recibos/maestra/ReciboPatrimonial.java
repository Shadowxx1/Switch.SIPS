/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.polizas.recibos.maestra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import modelo.entidades.polizas.recibos.dominio.TipoBienAsegurado;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author NELSON
 */
@Entity
public class ReciboPatrimonial extends Recibo{

    public ReciboPatrimonial() {
    }

    /**
     *
     */
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @BusinessKey(exclude = Method.ALL)
    private List<Patrimonial> bienesPatrimoniales = new ArrayList<Patrimonial>(0);

    public List<Patrimonial> getBienesPatrimoniales() {
        return bienesPatrimoniales;
    }

    public void setBienesPatrimoniales(List<Patrimonial> bienesPatrimoniales) {
        this.bienesPatrimoniales = bienesPatrimoniales;
    }

    
}
