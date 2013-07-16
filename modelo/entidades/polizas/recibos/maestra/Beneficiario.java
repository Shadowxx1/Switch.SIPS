package modelo.entidades.polizas.recibos.maestra;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Version;
import modelo.Dominios.Parentesco;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.personas.maestra.PersonaNatural;
import modelo.interfaces.GridConSubGrids;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 * @author Nelson Moncada
 */
@Entity
public class Beneficiario extends BeanVO implements Serializable, Auditable, GridConSubGrids {

    public Beneficiario() {
        this.porcPrima=0.0d;
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
    private PersonaNatural beneficiario;

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
    private Double porcPrima;

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
    private Certificado certificado;

    public Long getId() {
        return id;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria=auditoria;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
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

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public Double getPorcPrima() {
        return porcPrima;
    }

    public void setPorcPrima(Double porcPrima) {
        this.porcPrima = porcPrima;
    }

    public PersonaNatural getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(PersonaNatural beneficiario) {
        this.beneficiario = beneficiario;
    }

    
}
