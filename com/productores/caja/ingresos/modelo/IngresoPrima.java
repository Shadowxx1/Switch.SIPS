/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.ingresos.modelo;

import com.productores.caja.modelo.maestra.Asiento;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.ehts.BusinessKey;

/**
 *
 * @author Owner
 */
@Entity
public class IngresoPrima extends Asiento {

    /**
     * recibos asociados a un movimiento
     */
    @OneToMany()
    @BusinessKey
    private Set<Recibo> recibos;

    /**
     * recibos asociados a un movimiento
     * @return the recibos
     */
    public Set<Recibo> getRecibos() {
        return recibos;
    }

    /**
     * recibos asociados a un movimiento
     * @param recibos the recibos to set
     */
    public void setRecibos(Set<Recibo> recibos) {
        this.recibos = recibos;
    }
}
