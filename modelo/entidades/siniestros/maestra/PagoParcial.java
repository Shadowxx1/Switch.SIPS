/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.siniestros.maestra;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Past;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.Persona;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author NELSON
 */
@Entity
public class PagoParcial extends BeanVO implements Serializable, Auditable{

    public PagoParcial() {
        this.monto=0.0d;
    }

    /**
     *  PK autoincremtado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaPago;

    /**
     *
     */
    @Column
    @BusinessKey
    private String descripcion;

    /**
     *
     */
    @Column
    @BusinessKey
    private String numCheque;

    /**
     *
     */
    @Column
    @BusinessKey
    private Double monto;

    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private Persona banco;

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

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public Long getId() {
        return id;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria=auditoria;
    }

    public Persona getBanco() {
        return banco;
    }

    public void setBanco(Persona banco) {
        this.banco = banco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

}
