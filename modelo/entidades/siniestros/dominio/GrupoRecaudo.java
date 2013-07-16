package modelo.entidades.siniestros.dominio;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Version;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import modelo.Dominios.RamoContable;

/**
 *
 * @author Nelson Moncada
 */
@Entity
public class GrupoRecaudo extends BeanVO implements Serializable, Auditable {

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
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private RamoContable ramoContable;

    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recaudo")
    @BusinessKey(exclude = Method.ALL)
    private List<Recaudo> detalleRecaudos = new ArrayList<Recaudo>(0);

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

    public GrupoRecaudo() {
        this.ramoContable=RamoContable.RAMOS_GENERALES;
    }

    public GrupoRecaudo(String nombre, AuditoriaBasica auditoria) {
        this.nombre = nombre;
        this.auditoria = auditoria;
        this.ramoContable=RamoContable.RAMOS_GENERALES;
    }

    public GrupoRecaudo(String nombre, RamoContable ramoContable, AuditoriaBasica auditoria) {
        this.nombre = nombre;
        this.ramoContable = ramoContable;
        this.auditoria = auditoria;
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

    public List<Recaudo> getDetalleRecaudos() {
        return detalleRecaudos;
    }

    public void setDetalleRecaudos(List<Recaudo> detalleRecaudos) {
        this.detalleRecaudos = detalleRecaudos;
    }

    public RamoContable getRamoContable() {
        return ramoContable;
    }

    public void setRamoContable(RamoContable ramoContable) {
        this.ramoContable = ramoContable;
    }
    
}
