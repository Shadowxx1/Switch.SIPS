/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.modelo.maestra;

import com.productores.caja.modelo.dominio.TipoMovimiento;
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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import modelo.Dominios.TipoDocumentoPago;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.personas.transac.CuentaBancariaPersona;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Owner
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Asiento extends BeanVO implements Serializable, Auditable{

    /**
     * Pk autogenerado
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @BusinessKey(include = Method.TO_STRING)
    private Long id;
    
    
    
    /**
     * Coleccion de documentos anexos al asiento
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<Documento> documentos = new HashSet<Documento>(0);
    /**
     * Coleccion de observaciones al asiento
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    @OrderBy(value = "auditoria.fechaInsert")
    private List<Observacion> observaciones = new ArrayList<Observacion>(0);       
    /**
     * Número de Movimiento
     * Generado por Sistema:  AAMM-XXXXX
     */
    @Column
    @BusinessKey
    private String numero;
    /**
     * Descripcion del movimiento
     */
    @Column
    @BusinessKey
    private String descripcion;
    /**
     * Fecha del asiento
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fecha;    
    /**
     * Monto del movimiento
     */
    @Column
    @BusinessKey
    private Double monto;
    /**
     * Liquidacion a la cual esta asosiado el asiento
     */
    @ManyToOne
    @NotNull
    //@BusinessKey
    private Liquidacion liquidacion;    
    /**
     * Productor de donde se extraera la cuenta bancaria
     */
    @Transient
    private Persona productor;
    /**
     * Cuenta bancaria asociado al movimiento
     */
    @ManyToOne()
    @BusinessKey         
    private CuentaBancariaPersona cuentaBancaria;
    /**
     * CHEQUE, TRANSFERENCIA, RETIRO, DEPOSITO, EFECTIVO, TARJETADEBITO, TARJETACREDITO, OTRO
     */
    @Column
    @BusinessKey
    private TipoDocumentoPago tipoDocumentoPago;
    /**
     * Referencia del monto (numero de deposito, cheque, entre otros)
     */    
    @Column
    @BusinessKey
    private String referencia;      
    /**
     * Tipo de movimiento en caja
     */
    @Column
    @BusinessKey
    private TipoMovimiento tipoMovimiento;    
    
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
     * Número de Movimiento
     * Generado por Sistema:  AAMM-XXXXX
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Número de Movimiento
     * Generado por Sistema:  AAMM-XXXXX
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Descripcion del movimiento
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Descripcion del movimiento
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Monto del movimiento
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Monto del movimiento
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Tipo de movimiento en caja
     * @return the tipoMovimiento
     */
    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Tipo de movimiento en caja
     * @param tipoMovimiento the tipoMovimiento to set
     */
    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }


    /**
     * Referencia del monto (numero de deposito, cheque, entre otros)
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Referencia del monto (numero de deposito, cheque, entre otros)
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * CHEQUE, TRANSFERENCIA, RETIRO, DEPOSITO, EFECTIVO, TARJETADEBITO, TARJETACREDITO, OTRO
     * @return the tipoDocumentoPago
     */
    public TipoDocumentoPago getTipoDocumentoPago() {
        return tipoDocumentoPago;
    }

    /**
     * CHEQUE, TRANSFERENCIA, RETIRO, DEPOSITO, EFECTIVO, TARJETADEBITO, TARJETACREDITO, OTRO
     * @param tipoDocumentoPago the tipoDocumentoPago to set
     */
    public void setTipoDocumentoPago(TipoDocumentoPago tipoDocumentoPago) {
        this.tipoDocumentoPago = tipoDocumentoPago;
    }

    /**
     * Fecha del asiento
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Fecha del asiento
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Cuenta bancaria asociado al movimiento
     * @return the cuentaBancaria
     */
    public CuentaBancariaPersona getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Cuenta bancaria asociado al movimiento
     * @param cuentaBancaria the cuentaBancaria to set
     */
    public void setCuentaBancaria(CuentaBancariaPersona cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * Coleccion de documentos anexos al asiento
     * @return the documentos
     */
    public Set<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Coleccion de documentos anexos al asiento
     * @param documentos the documentos to set
     */
    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * Coleccion de observaciones al asiento
     * @return the observaciones
     */
    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    /**
     * Coleccion de observaciones al asiento
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Productor de donde se extraera la cuenta bancaria
     * @return the productor
     */
    public Persona getProductor() {
        return productor;
    }

    /**
     * Productor de donde se extraera la cuenta bancaria
     * @param productor the productor to set
     */
    public void setProductor(Persona productor) {
        this.productor = productor;
    }

    /**
     * Liquidacion a la cual esta asosiado el asiento
     * @return the liquidacion
     */
    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    /**
     * Liquidacion a la cual esta asosiado el asiento
     * @param liquidacion the liquidacion to set
     */
    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }
        
}
