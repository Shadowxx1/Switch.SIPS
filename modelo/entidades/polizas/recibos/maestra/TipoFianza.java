/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades.polizas.recibos.maestra;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author NELSON
 */
@Entity
public class TipoFianza extends BeanVO implements Auditable {

    public TipoFianza() {
    }

    public TipoFianza(String nombre, AuditoriaBasica auditoria) {
        this.nombre = nombre;
        this.auditoria = auditoria;
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
     * UK propio de la aplicacion para el control y ubicacion del tipo de cliente
     */
    @Column(updatable = false, unique = true)
//    @Size(max = 10)
    @BusinessKey
    private String idPropio;
    /**
     * Tipo de persona
     */
    @Column
//    @Size(min = 4, max = 120)
    @BusinessKey
    private String nombre;
    /**
     * El registro esta bloqueado y no puede ser modificado
     * xq es propio del sistema
     */
    @Column
    @BusinessKey
    private Boolean bloqueado;
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

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getIdPropio() {
        return idPropio;
    }

    public void setIdPropio(String idPropio) {
        this.idPropio = idPropio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }
}
