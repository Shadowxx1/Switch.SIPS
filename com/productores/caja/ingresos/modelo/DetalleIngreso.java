/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.ingresos.modelo;

import com.productores.caja.modelo.maestra.Asiento;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import modelo.util.ehts.BusinessKey;

/**
 *
 * @author Owner
 */
@Entity
public class DetalleIngreso extends Asiento {
    
    /**
     * Total que me reporta la compania
     */
    @ManyToOne()
    @BusinessKey
    private TipoDetalleIngreso tipoDetalleIngreso;        
    /**
     * total que calcula el sistema
     */
    @Column
    @BusinessKey
    private Double totalSistema;
    /**
     * diferencia entre totales
     */
    @Column
    @BusinessKey
    private Double diferencia;   

    /**
     * total que calcula el sistema
     * @return the totalSistema
     */
    public Double getTotalSistema() {
        return totalSistema;
    }

    /**
     * total que calcula el sistema
     * @param totalSistema the totalSistema to set
     */
    public void setTotalSistema(Double totalSistema) {
        this.totalSistema = totalSistema;
    }

    /**
     * diferencia entre totales
     * @return the diferencia
     */
    public Double getDiferencia() {
        return diferencia;
    }

    /**
     * diferencia entre totales
     * @param diferencia the diferencia to set
     */
    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    /**
     * Total que me reporta la compania
     * @return the tipoDetalleIngreso
     */
    public TipoDetalleIngreso getTipoDetalleIngreso() {
        return tipoDetalleIngreso;
    }

    /**
     * Total que me reporta la compania
     * @param tipoDetalleIngreso the tipoDetalleIngreso to set
     */
    public void setTipoDetalleIngreso(TipoDetalleIngreso tipoDetalleIngreso) {
        this.tipoDetalleIngreso = tipoDetalleIngreso;
    }
    
}
