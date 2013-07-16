/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.polizas.recibos.maestra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;
import modelo.Dominios.Parentesco;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.PersonaNatural;
import modelo.interfaces.GridConSubGrids;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author NELSON
 */
@Entity
public class Certificado extends BeanVO implements Serializable, Auditable, GridConSubGrids{

    public Certificado() {
        this.prima=0.0d;
    }

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.ALL)
    private Long id;

    /**
     *
     */
    @Column
    @BusinessKey
    private String numero;

    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private PersonaNatural titular;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaIngreso;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaInclusion;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaExclucion;

    /**
     *
     */
    @Column
    @BusinessKey
    private String observacion;

    /**
     *
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private Parentesco parentesco;

    /**
     *
     */
    @Column
    @BusinessKey
    private Double prima;

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

    /**
     *
     */
    @ManyToOne
    private ReciboPersonas recibo;

    /**
     *
     */
    @OneToMany(mappedBy = "certificado", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @BusinessKey(exclude = Method.ALL)
    private List<Asegurado> asegurados = new ArrayList<Asegurado>(0);

    /**
     *
     */
    @OneToMany(mappedBy = "certificado", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @BusinessKey(exclude = Method.ALL)
    private List<Beneficiario> beneficiarios = new ArrayList<Beneficiario>(0);

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

    public Date getFechaExclucion() {
        return fechaExclucion;
    }

    public void setFechaExclucion(Date fechaExclucion) {
        this.fechaExclucion = fechaExclucion;
    }

    public Date getFechaInclusion() {
        return fechaInclusion;
    }

    public void setFechaInclusion(Date fechaInclusion) {
        this.fechaInclusion = fechaInclusion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }

    public PersonaNatural getTitular() {
        return titular;
    }

    public void setTitular(PersonaNatural titular) {
        this.titular = titular;
    }

    public List<Beneficiario> getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(List<Beneficiario> beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

    public List<Asegurado> getAsegurados() {
        return asegurados;
    }

    public void setAsegurados(List<Asegurado> asegurados) {
        this.asegurados = asegurados;
    }

    public ReciboPersonas getRecibo() {
        return recibo;
    }

    public void setRecibo(ReciboPersonas recibo) {
        this.recibo = recibo;
    }



}
