/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.modelo.maestra;

import modelo.entidades.auditoria.Auditable;
import com.productores.caja.modelo.dominio.TipoIngresoCaja;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Past;
import modelo.Dominios.EstatusLiquidacion;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Nelson Moncada
 */
@Entity
public class Liquidacion extends BeanVO implements Serializable, Auditable {

    public Liquidacion() {
        this.debitos=0.00d;
        this.creditos=0.00d;
        this.diferencia=0.00d;
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
     * Coleccion de documentos anexos de la persona
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<Documento> documentos = new HashSet<Documento>(0);    
    /**
     * Coleccion de observaciones de la persona
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    @OrderBy(value = "auditoria.fechaInsert")
    private List<Observacion> observaciones = new ArrayList<Observacion>(0);    
    /**
     * Recibos asociados a la Liquidacion 
     */
//    @OneToMany(mappedBy = "liquidacion", fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<Recibo> recibos = new HashSet<Recibo>(0);
    /**
     * Número Liquidación de Caja
     * Generado por Sistema:  AAMM-XXXXX
     */
    @Column
    @BusinessKey
    private String numero;
    /**
     * Total de debidos
     */
    @Column
    @BusinessKey
    private Double debitos;
    /**
     * Total en Creditos
     */
    @Column
    @BusinessKey
    private Double creditos;
    /**
     * Diferencia entre Debitos y Creditos
     */
    @Column
    @BusinessKey
    private Double diferencia;
    /**
     * Estatus en que se encuentra la liquidacion
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private EstatusLiquidacion estatusLiquidacion;
    /**
     * Productor al cual se le hace la liquidacion
     */
    @ManyToOne()
    @BusinessKey
    private Persona productor;
    /**
     * Cobrador que recibe el dinero
     */
    @ManyToOne()
    @BusinessKey
    private Persona cobrador;
    /**
     * Fecha de ingreso en caja
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaIngreso;
    /**
     * Fecha en que se anulo la liquidacion
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaAnulacion;    
    /**
     * Tipo de Ingreso en caja
     */
    @Column
    @BusinessKey
    private TipoIngresoCaja tipoIngresoCaja; 
    /**
     * Movimientos que contiene la liquidacion
     */
    @OneToMany(mappedBy = "liquidacion", fetch = FetchType.LAZY)
    @BusinessKey
    private Set<Asiento> movimientos;    
    /**
     * Campo para uso de hibernate
     */
    @Version
    @Column
    private Integer optLock;
    /**
     * Campo para el control de cada registro de auditoria
     */
    @Embedded
    @BusinessKey
    private AuditoriaBasica auditoria;

    /**
     * Pk autogenerado
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Recibos asociados a la Liquidacion
     * @return the recibos
     */
    public Set<Recibo> getRecibos() {
        return recibos;
    }

    /**
     * Recibos asociados a la Liquidacion
     * @param recibos the recibos to set
     */
    public void setRecibos(Set<Recibo> recibos) {
        this.recibos = recibos;
    }

    /**
     * Número Liquidación de Caja
     * Generado por Sistema:  AAMM-XXXXX
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número Liquidación de Caja
     * Generado por Sistema:  AAMM-XXXXX
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Total de debidos
     * @return the debitos
     */
    public Double getDebitos() {
        return debitos;
    }

    /**
     * Total de debidos
     * @param debitos the debitos to set
     */
    public void setDebitos(Double debitos) {
        this.debitos = debitos;
    }

    /**
     * Total en Creditos
     * @return the creditos
     */
    public Double getCreditos() {
        return creditos;
    }

    /**
     * Total en Creditos
     * @param creditos the creditos to set
     */
    public void setCreditos(Double creditos) {
        this.creditos = creditos;
    }

    /**
     * Diferencia entre Debitos y Creditos
     * @return the diferencia
     */
    public Double getDiferencia() {
        return diferencia;
    }

    /**
     * Diferencia entre Debitos y Creditos
     * @param diferencia the diferencia to set
     */
    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    /**
     * Estatus en que se encuentra la liquidacion
     * @return the estatusLiquidacion
     */
    public EstatusLiquidacion getEstatusLiquidacion() {
        return estatusLiquidacion;
    }

    /**
     * Estatus en que se encuentra la liquidacion
     * @param estatusLiquidacion the estatusLiquidacion to set
     */
    public void setEstatusLiquidacion(EstatusLiquidacion estatusLiquidacion) {
        this.estatusLiquidacion = estatusLiquidacion;
    }

    /**
     * Campo para uso de hibernate
     * @return the optLock
     */
    public Integer getOptLock() {
        return optLock;
    }

    /**
     * Campo para uso de hibernate
     * @param optLock the optLock to set
     */
    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    /**
     * Campo para el control de cada registro de auditoria
     * @return the auditoria
     */
    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    /**
     * Campo para el control de cada registro de auditoria
     * @param auditoria the auditoria to set
     */
    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    /**
     * Tipo de Ingreso en caja
     * @return the tipoIngresoCaja
     */
    public TipoIngresoCaja getTipoIngresoCaja() {
        return tipoIngresoCaja;
    }

    /**
     * Tipo de Ingreso en caja
     * @param tipoIngresoCaja the tipoIngresoCaja to set
     */
    public void setTipoIngresoCaja(TipoIngresoCaja tipoIngresoCaja) {
        this.tipoIngresoCaja = tipoIngresoCaja;
    }

    /**
     * Movimientos que contiene la liquidacion
     * @return the movimientos
     */
    public Set<Asiento> getMovimientos() {
        return movimientos;
    }

    /**
     * Movimientos que contiene la liquidacion
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(Set<Asiento> movimientos) {
        this.movimientos = movimientos;
    }

    /**
     * Productor al cual se le hace la liquidacion
     * @return the productor
     */
    public Persona getProductor() {
        return productor;
    }

    /**
     * Productor al cual se le hace la liquidacion
     * @param productor the productor to set
     */
    public void setProductor(Persona productor) {
        this.productor = productor;
    }

    /**
     * Cobrador que recibe el dinero
     * @return the cobrador
     */
    public Persona getCobrador() {
        return cobrador;
    }

    /**
     * Cobrador que recibe el dinero
     * @param cobrador the cobrador to set
     */
    public void setCobrador(Persona cobrador) {
        this.cobrador = cobrador;
    }

    /**
     * Fecha de ingreso en caja
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Fecha de ingreso en caja
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Fecha en que se anulo la liquidacion
     * @return the fechaAnulacion
     */
    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    /**
     * Fecha en que se anulo la liquidacion
     * @param fechaAnulacion the fechaAnulacion to set
     */
    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    /**
     * Coleccion de documentos anexos de la persona
     * @return the documentos
     */
    public Set<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Coleccion de documentos anexos de la persona
     * @param documentos the documentos to set
     */
    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * Coleccion de observaciones de la persona
     * @return the observaciones
     */
    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    /**
     * Coleccion de observaciones de la persona
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Pk autogenerado
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
