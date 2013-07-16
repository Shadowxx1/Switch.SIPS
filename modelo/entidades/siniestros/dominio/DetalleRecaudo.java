package modelo.entidades.siniestros.dominio;

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
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import modelo.entidades.personas.maestra.Persona;

/**
 *
 * @author Nelson Moncada
 */
@Entity
public class DetalleRecaudo extends BeanVO implements Serializable, Auditable {

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
    @Size(min = 2, max = 120)
    @BusinessKey
    private String nombre;

    /**
     *
     */
    @Column
    @BusinessKey
    private Double monto;

    /**
     *
     */
    @Column
    @BusinessKey
    private Integer cantidad;

    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private Persona ejecutivo;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaLimiteEntrega;

    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaRecibido;

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

    public DetalleRecaudo() {
        this.monto=0.0d;
        this.cantidad=0;
    }

    public DetalleRecaudo(String nombre, AuditoriaBasica auditoria) {
        this.nombre = nombre;
        this.auditoria = auditoria;
        this.monto=0.0d;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Persona getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Persona ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public Date getFechaLimiteEntrega() {
        return fechaLimiteEntrega;
    }

    public void setFechaLimiteEntrega(Date fechaLimiteEntrega) {
        this.fechaLimiteEntrega = fechaLimiteEntrega;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
