package com.productores.caja.modelo.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.auditoria.Auditable;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import modelo.Dominios.TipoAsiento;

/**
 * Clase Dominio para los tipos de actividad
 * economica que podria tener una persona
 * @version 1.0 22/05/2009
 * @since JDK 1.5
 * @author Nelson Moncada
 * @author Nelson Moncada
 */
@Entity
public class TipoMovimiento extends BeanVO implements Serializable, Auditable {

    /**
     *  PK autoincremtado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * Nombre del tipo de Liquidación
     */
    @Column
    @Size(min = 4, max = 14)
    @BusinessKey
    private String idPropio;
    /**
     * Nombre Largo
     */
    @Column
    @Size(min = 4, max = 50)
    @BusinessKey
    private String nombre;
    /**
     * Cuenta Contable
     */
    @Column
    @BusinessKey
    private String cuentaContable;    
    /**
     * Tipo de asiento DEBITO, CREDITO o NEUTRO
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoAsiento tipoAsiento;    
    /**
     * Si True=Visible False=No Visible
     */
    @Column
    @BusinessKey
    private Boolean visible;
    /**
     */
    @Version
    @Column
    private Integer optLock;
    /**
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;

    public TipoMovimiento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdPropio() {
        return idPropio;
    }

    public void setIdPropio(String idPropio) {
        this.idPropio = idPropio;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Tipo de asiento DEBITO, CREDITO o NEUTRO
     * @return the tipoAsiento
     */
    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    /**
     * Tipo de asiento DEBITO, CREDITO o NEUTRO
     * @param tipoAsiento the tipoAsiento to set
     */
    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    /**
     * Cuenta Contable
     * @return the cuentaContable
     */
    public String getCuentaContable() {
        return cuentaContable;
    }

    /**
     * Cuenta Contable
     * @param cuentaContable the cuentaContable to set
     */
    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }
}
