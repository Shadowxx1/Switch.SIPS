package modelo.entidades.polizas.recibos.maestra;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.polizas.recibos.dominio.TipoBienAsegurado;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

@Entity
public class Patrimonial extends BeanVO implements Serializable, Auditable {

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    /**
     * Tipo de telefono
     */
    @Column
    @BusinessKey
    private String nombre;
    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private TipoBienAsegurado tipoBienAsegurado;
    /**
     * Tipo de telefono
     */
    @Column
    @BusinessKey
    private String descripcion;
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

    public Patrimonial() {
    }

    public Patrimonial(String nombre, String descripcion, AuditoriaBasica auditoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoBienAsegurado getTipoBienAsegurado() {
        return tipoBienAsegurado;
    }

    public void setTipoBienAsegurado(TipoBienAsegurado tipoBienAsegurado) {
        this.tipoBienAsegurado = tipoBienAsegurado;
    }

}
