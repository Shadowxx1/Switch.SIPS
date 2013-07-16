package modelo.entidades.polizas.recibos.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import modelo.Dominios.TipoCobrador;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.personas.maestra.Persona;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import org.hibernate.validator.constraints.Range;

/**
 * @author Nelson Moncada
 */
@Entity
public class DistribucionModelo extends BeanVO implements Serializable, Auditable {

    /**
     *  PK autoincremtado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * Productor, Vendedor(Cobrador)
     */
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoCobrador tipoCobrador;
    /**
     *
     */
    @ManyToOne()
    //@BusinessKey
    private Persona cobrador;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porComision;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porComision2;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porBono1;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porBono2;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porBono3;
    /**
     *
     */
    @Column
    @Range(min = 0, max = 100)
    @BusinessKey
    private Double porBono4;
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

    public DistribucionModelo() {
        this.porComision = 0.0;
        this.porComision2 = 0.0;
        this.porBono1 = 0.0;
        this.porBono2 = 0.0;
        this.porBono3 = 0.0;
        this.porBono4 = 0.0;
    }

    public DistribucionModelo(Persona cobrador, Double porComision, Double porComision2, Double porBono1, Double porBono2, Double porBono3, Double porBono4) {
        this.cobrador = cobrador;
        this.porComision = porComision;
        this.porComision2 = porComision2;
        this.porBono1 = porBono1;
        this.porBono2 = porBono2;
        this.porBono3 = porBono3;
        this.porBono4 = porBono4;
    }

    public DistribucionModelo(Persona cobrador, Double porComision, AuditoriaBasica auditoria) {
        this.cobrador = cobrador;
        this.porComision = porComision;
        this.auditoria = auditoria;
        this.porComision2 = 0.0;
        this.porBono1 = 0.0;
        this.porBono2 = 0.0;
        this.porBono3 = 0.0;
        this.porBono4 = 0.0;
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

    public Persona getCobrador() {
        return cobrador;
    }

    public void setCobrador(Persona cobrador) {
        this.cobrador = cobrador;
    }

    public Double getPorBono1() {
        return porBono1;
    }

    public void setPorBono1(Double porBono1) {
        this.porBono1 = porBono1;
    }

    public Double getPorBono2() {
        return porBono2;
    }

    public void setPorBono2(Double porBono2) {
        this.porBono2 = porBono2;
    }

    public Double getPorBono3() {
        return porBono3;
    }

    public void setPorBono3(Double porBono3) {
        this.porBono3 = porBono3;
    }

    public Double getPorBono4() {
        return porBono4;
    }

    public void setPorBono4(Double porBono4) {
        this.porBono4 = porBono4;
    }

    public Double getPorComision() {
        return porComision;
    }

    public void setPorComision(Double porComision) {
        this.porComision = porComision;
    }

    public Double getPorComision2() {
        return porComision2;
    }

    public void setPorComision2(Double porComision2) {
        this.porComision2 = porComision2;
    }

    public TipoCobrador getTipoCobrador() {
        return tipoCobrador;
    }

    public void setTipoCobrador(TipoCobrador tipoCobrador) {
        this.tipoCobrador = tipoCobrador;
    }
}
