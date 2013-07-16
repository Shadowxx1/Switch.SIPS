/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades.polizas.recibos.cobertura;

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
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Nelson Moncada
 */
@Entity
public class CoberturasRecibo extends BeanVO implements Serializable, Auditable {

    public CoberturasRecibo() {
        this.prima = 0.0d;
        this.sumaAsegurada = 0.0d;
        this.deducible = 0.0d;
        this.tasa=0.0d;
    }
    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     *
     */
    @Version
    @Column
    private Integer optLock;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaDesda;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double sumaAsegurada;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double prima;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double deducible;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double tasa;
    /**
     *
     */
    @ManyToOne
    private Recibo recibo;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @BusinessKey
    private Date fechaHasta;
    /**
     *
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;
    /**
     *
     */
    @ManyToOne
    private Cobertura cobertura;
    /**
     *
     */
    @Column
    @BusinessKey
    private String observacion;

    public Long getId() {
        return id;
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

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    public Date getFechaDesda() {
        return fechaDesda;
    }

    public void setFechaDesda(Date fechaDesda) {
        this.fechaDesda = fechaDesda;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }

    public Double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Double sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Double getDeducible() {
        return deducible;
    }

    public void setDeducible(Double deducible) {
        this.deducible = deducible;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }
    
}
