/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.ingresos.modelo;

import modelo.entidades.auditoria.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Owner
 */
@Entity
public class TipoDetalleIngreso extends BeanVO implements Serializable, Auditable {

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;

    /**
     * identificador propio
     */
    @Column
    @BusinessKey
    private String idPropio;    
    
    /**
     * nombre del Tipo Detalle
     */
    @Column
    @BusinessKey
    private String nombre;
    
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
     * Total que me reporta la compania
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Total que me reporta la compania
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * identificador propio
     * @return the idPropio
     */
    public String getIdPropio() {
        return idPropio;
    }

    /**
     * identificador propio
     * @param idPropio the idPropio to set
     */
    public void setIdPropio(String idPropio) {
        this.idPropio = idPropio;
    }

}
