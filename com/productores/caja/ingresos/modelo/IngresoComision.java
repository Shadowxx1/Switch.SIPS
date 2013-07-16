/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.ingresos.modelo;

import modelo.entidades.auditoria.Auditable;
import com.productores.caja.modelo.maestra.Asiento;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Past;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Owner
 */
@Entity
public class IngresoComision extends BeanVO implements Serializable, Auditable{

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * recibos asociados a un movimiento
     */
    @OneToMany()
    @BusinessKey
    private Set<Recibo> recibos;   
    
    /**
     * compania que paga las comisiones
     */
    @ManyToOne()
    @BusinessKey
    private Persona compania;           
    /**
     * ingreso asociado al pago de comisiones
     */
    @ManyToOne()
    @BusinessKey
    private Asiento ingreso;      
    
    /**
     * Fecha desde del filtrado de recibos
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaDesde;
    
    /**
     * Fecha hasta del filtrado de recibos
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaHasta;    
    
    /**
     * numeor de orden
     */
    @Column
    @BusinessKey
    private String numOrden;      
        
    /**
     * Totales relacionados al ingreso de comision
     */
    @OneToMany()
    @BusinessKey
    private Set<DetalleIngreso> totales; 
    
    /**
     * Campo para uso de hibernate
     */
    @Version
    @Column
    private Integer optLock;
    /**
     * Campo para el control de cada registro de auditoria
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;

    /**
     * Pk autogenerado
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Campo para uso de hibernate
     * @return the optLock
     */
    public Integer getOptLock() {
        return optLock;
    }

    /**
     * Campo para uso de hibernate
     * @param optLock the optLock to set
     */
    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    /**
     * Campo para el control de cada registro de auditoria
     * @return the auditoria
     */
    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    /**
     * Campo para el control de cada registro de auditoria
     * @param auditoria the auditoria to set
     */
    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

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
        this.setRecibos(recibos);
    }

    /**
     * Totales relacionados al ingreso de comision
     * @return the totales
     */
    public Set<DetalleIngreso> getTotales() {
        return totales;
    }

    /**
     * Totales relacionados al ingreso de comision
     * @param totales the totales to set
     */
    public void setTotales(Set<DetalleIngreso> totales) {
        this.setTotales(totales);
    }

    /**
     * compania que paga las comisiones
     * @return the compania
     */
    public Persona getCompania() {
        return compania;
    }

    /**
     * compania que paga las comisiones
     * @param compania the compania to set
     */
    public void setCompania(Persona compania) {
        this.compania = compania;
    }

    /**
     * ingreso asociado al pago de comisiones
     * @return the ingreso
     */
    public Asiento getIngreso() {
        return ingreso;
    }

    /**
     * ingreso asociado al pago de comisiones
     * @param ingreso the ingreso to set
     */
    public void setIngreso(Asiento ingreso) {
        this.ingreso = ingreso;
    }

    /**
     * Fecha desde del filtrado de recibos
     * @return the fechaDesde
     */
    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Fecha desde del filtrado de recibos
     * @param fechaDesde the fechaDesde to set
     */
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * Fecha hasta del filtrado de recibos
     * @return the fechaHasta
     */
    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Fecha hasta del filtrado de recibos
     * @param fechaHasta the fechaHasta to set
     */
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    /**
     * numeor de orden
     * @return the numOrden
     */
    public String getNumOrden() {
        return numOrden;
    }

    /**
     * numeor de orden
     * @param numOrden the numOrden to set
     */
    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

}
