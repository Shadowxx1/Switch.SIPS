package modelo.entidades.siniestros.maestra;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.Version;
import modelo.entidades.Documento;
import modelo.entidades.Observacion;
import modelo.entidades.auditoria.Auditable;
import modelo.entidades.auditoria.AuditoriaBasica;
import modelo.entidades.polizas.recibos.maestra.Recibo;
import modelo.entidades.siniestros.dominio.DetalleCausaSiniestro;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import javax.validation.constraints.Past;
import modelo.Dominios.EstadoSiniestro;
import modelo.Dominios.EstatusSiniestro;
import modelo.Dominios.TipoNotificacion;
import modelo.Dominios.TipoSiniestro;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.recibos.maestra.Certificado;
import modelo.entidades.siniestros.dominio.DetalleRecaudo;

/**
 *
 * @author Nelson Moncada
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Siniestro extends BeanVO implements Serializable, Auditable {

    public Siniestro() {
        this.estado = EstadoSiniestro.ABIERTO;
        montoCobertura=0.0;
        montoDeducible=0.0;
        montoLiquidado=0.0;
        porcentajePenalizacion=0.0;      
        estatus=EstatusSiniestro.PENDIENTE_RECAUDOS;
    }
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
    @ManyToOne
    private Recibo recibo;
    /**
     *
     */
    @ManyToOne()
    @BusinessKey
    private DetalleCausaSiniestro detalleCausa;
    /**
     * Descripcion del siniestro
     */
    @Column
    @Size(max = 2500)
    @BusinessKey
    private String descripcion;
    /**
     * Descripcion del siniestro
     */
    @Column
    @Size(max = 2500)
    @BusinessKey
    private String lugar;
    /**
     *
     */
    @Column
    @Size(max = 50)
    @BusinessKey
    private String numero;
    /**
     *
     */
    @Column
    @Size(max = 50)
    @BusinessKey
    private String numeroNotificacion;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaOcurrencia;
    /**
     * Descripcion del siniestro
     */
    @Column
    @Size(max = 2500)
    @BusinessKey
    private String danosOcacionados;

    /**
     *
     */
    @ManyToOne
    private Certificado certificadoRecibo;

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
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaNotificacion;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaNotificacionCompania;
    /**
     * Pendiente Recaudos, Pendiente Analisis, Pendiente Liquidacion, Anulado, Rechazado, Pagado Normal, Pagodo Gracia
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private EstatusSiniestro estatus;
    /**
     * Abierto, Cerrado
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private EstadoSiniestro estado;
    /**
     * Abierto, Cerrado
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoNotificacion tipoNotificacion;
    /**
     * Abierto, Cerrado
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoSiniestro tipoSiniestro;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @BusinessKey
    private Date fechaEstatus;
    /**
     * 
     */
    @Column
    @BusinessKey
    private Double montoCobertura;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double montoLiquidado;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double montoDeducible;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double porcentajePenalizacion;
    /**
     *
     */
    @Column
    @BusinessKey
    private Boolean anulado;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @BusinessKey
    private Date fechaAnulacion;

    /**
     *
     */
    @Column
    @BusinessKey
    private Double monto;

    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<Documento> documentos = new HashSet<Documento>(0);
    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    @OrderBy(value = "auditoria.fechaInsert")
    private List<Observacion> observaciones = new ArrayList<Observacion>(0);

    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    @OrderBy(value = "nombre")
    private List<DetalleRecaudo> recaudos = new ArrayList<DetalleRecaudo>(0);

    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    @OrderBy(value = "fechaPago")
    private List<PagoParcial> pagosParciales = new ArrayList<PagoParcial>(0);

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

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Set<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    public EstatusSiniestro getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusSiniestro estatus) {
        this.estatus = estatus;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Date getFechaEstatus() {
        return fechaEstatus;
    }

    public void setFechaEstatus(Date fechaEstatus) {
        this.fechaEstatus = fechaEstatus;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaNotificacionCompania() {
        return fechaNotificacionCompania;
    }

    public void setFechaNotificacionCompania(Date fechaNotificacionCompania) {
        this.fechaNotificacionCompania = fechaNotificacionCompania;
    }

    public Date getFechaOcurrencia() {
        return fechaOcurrencia;
    }

    public void setFechaOcurrencia(Date fechaOcurrencia) {
        this.fechaOcurrencia = fechaOcurrencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontoCobertura() {
        return montoCobertura;
    }

    public void setMontoCobertura(Double montoCobertura) {
        this.montoCobertura = montoCobertura;
    }

    public Double getMontoLiquidado() {
        return montoLiquidado;
    }

    public void setMontoLiquidado(Double montoLiquidado) {
        this.montoLiquidado = montoLiquidado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getOptLock() {
        return optLock;
    }

    public void setOptLock(Integer optLock) {
        this.optLock = optLock;
    }

    public Double getPorcentajePenalizacion() {
        return porcentajePenalizacion;
    }

    public void setPorcentajePenalizacion(Double porcentajePenalizacion) {
        this.porcentajePenalizacion = porcentajePenalizacion;
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public DetalleCausaSiniestro getDetalleCausa() {
        return detalleCausa;
    }

    public void setDetalleCausa(DetalleCausaSiniestro detalleCausa) {
        this.detalleCausa = detalleCausa;
    }

    public String getNumeroNotificacion() {
        return numeroNotificacion;
    }

    public void setNumeroNotificacion(String numeroNotificacion) {
        this.numeroNotificacion = numeroNotificacion;
    }

    public EstadoSiniestro getEstado() {
        return estado;
    }

    public void setEstado(EstadoSiniestro estado) {
        this.estado = estado;
    }

    /**
     * Descripcion del siniestro
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Descripcion del siniestro
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDanosOcacionados() {
        return danosOcacionados;
    }

    public void setDanosOcacionados(String danosOcacionados) {
        this.danosOcacionados = danosOcacionados;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Double getMontoDeducible() {
        return montoDeducible;
    }

    public void setMontoDeducible(Double montoDeducible) {
        this.montoDeducible = montoDeducible;
    }

    public List<PagoParcial> getPagosParciales() {
        return pagosParciales;
    }

    public void setPagosParciales(List<PagoParcial> pagosParciales) {
        this.pagosParciales = pagosParciales;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public List<DetalleRecaudo> getRecaudos() {
        return recaudos;
    }

    public void setRecaudos(List<DetalleRecaudo> recaudos) {
        this.recaudos = recaudos;
    }

    public Persona getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Persona ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public TipoSiniestro getTipoSiniestro() {
        return tipoSiniestro;
    }

    public void setTipoSiniestro(TipoSiniestro tipoSiniestro) {
        this.tipoSiniestro = tipoSiniestro;
    }

    public Certificado getCertificadoRecibo() {
        return certificadoRecibo;
    }

    public void setCertificadoRecibo(Certificado certificadoRecibo) {
        this.certificadoRecibo = certificadoRecibo;
    }
    
}
