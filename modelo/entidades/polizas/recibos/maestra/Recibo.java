package modelo.entidades.polizas.recibos.maestra;

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
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.financiamiento.Financiamiento;
import modelo.entidades.polizas.maestra.Poliza;
import modelo.entidades.polizas.recibos.devolucion.maestra.Devolucion;
import modelo.entidades.polizas.recibos.dominio.TipoZona;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import modelo.Dominios.EstatusRecibo;
import modelo.Dominios.TipoRecibo;
import modelo.Dominios.TipoVigencia;
import modelo.entidades.polizas.recibos.cobertura.CoberturasRecibo;
import modelo.entidades.polizas.recibos.dominio.TipoDistribucion;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Recibo extends BeanVO implements Serializable, Auditable {

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
    @ManyToOne
    @NotNull
    //@BusinessKey
    private Poliza poliza;
    /**
     *
     */
    @ManyToOne
    private Financiamiento financiamiento;
//    /**
//     * Liquidacion a la cual esta asociado el recibo
//     */
//    @ManyToOne
//    private Liquidacion liquidacion;
//    /**
//     *
//     */
//    @ManyToOne
//    private OrdenDePago orden;
    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private Persona asegurado;
    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private Persona ejecutivo;
    /**
     *
     */
    @ManyToOne()
    @BusinessKey
    private Persona cobrador2;
    /**
     *
     */
    @ManyToOne
    //@BusinessKey
    private transient TipoDistribucion tipoDistribucion;

    private transient String mensaje;

    /**
     *
     */
    @Column
    @BusinessKey
    private String tipoDistribucionNombre;
    /**
     *
     */
    @Column
    @BusinessKey
//    @Size(min = 2, max = 5000)
    private String privado;
    /**
     *
     */
    @Column
//    @Size(min = 2, max = 50)
//    @Index(name = "numeroReciboIndex")
    @BusinessKey
    private String numero;
//    /**
//     *
//     */
//    @Column
//    @BusinessKey
//    private String certificado;
    /**
     *  ANUAL, SEMESTRAL, TRIMESTRAL, MENSUAL
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoVigencia tipoVigencia;
    /**
     * Pendiente, Cobrado, Anulado
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private EstatusRecibo estatus;
    /**
     * Primer Año, Renovacion, Prorata, Modificacion
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoRecibo tipoRecibo;
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
    private Double bonoPagado;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double comisionPagada;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double totalPagado;
    /**
     *
     */
    @Column
    @Min(1)
    @BusinessKey
    private Double primaTotal;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double primaRecibo;
    /**
     *
     */
    @Column
    @Min(0)
    @BusinessKey
    private Double comision;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double bono1;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double bono2;
    /**
     *
     */
    @Column
    @BusinessKey
    private Double porcComiCob;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Past
    @BusinessKey
    private Date fechaRecepcion;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @BusinessKey
    private Date fechaEmision;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    //@Past
    @BusinessKey
    private Date vigenciaDesde;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    //@Future
    @BusinessKey
    private Date vigenciaHasta;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Past
    @BusinessKey
    private Date fechaCobro;
    /**
     *
     */
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Past
    @BusinessKey
    private Date fechaPagoComision;
    /**
     *
     */
    @Column
    @BusinessKey
    private Boolean financiado;
//    /**
//     *
//     */
//    @Column
//    @BusinessKey
//    private Boolean devolucion;
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
    @ManyToOne
    @BusinessKey
    private TipoZona zona;
//    /**
//     *
//     */
//    @ManyToOne
//    @BusinessKey
//    private Vehiculo vehiculo;
    /**
     *
     */
    @Column
    @Size(min = 0, max = 2048)
    @BusinessKey
    private String bienAseguradoDescrip;
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
//    /*
//     *
//     */
//    @Deprecated
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @BusinessKey(exclude = Method.ALL)
//    private Set<Persona> beneficiarios = new HashSet<Persona>(0);
    /*
     *
     */
    @OneToMany(mappedBy = "recibo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private List<CoberturasRecibo> coberturas = new ArrayList<CoberturasRecibo>(0);
//    /*
//     *
//     */
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @BusinessKey(exclude = Method.ALL)
//    private Set<Beneficiario> beneficiarios2 = new HashSet<Beneficiario>(0);
    /**
     *
     */
    @OneToMany(mappedBy = "recibo", fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private List<Distribucion> distribuciones = new ArrayList<Distribucion>(0);
    /**
     *
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<Devolucion> devoluciones = new HashSet<Devolucion>(0);
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

    public Recibo() {
        bono1 = 0.0;
        bono2 = 0.0;
        porcComiCob = 100.0;
        totalPagado=0.0;
        bonoPagado=0.0;
        comisionPagada=0.0;
    }

    public AuditoriaBasica getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaBasica auditoria) {
        this.auditoria = auditoria;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Set<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    public EstatusRecibo getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusRecibo estatus) {
        this.estatus = estatus;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPagoComision() {
        return fechaPagoComision;
    }

    public void setFechaPagoComision(Date fechaPagoComision) {
        this.fechaPagoComision = fechaPagoComision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public Double getPorcentajeComisionCobrador() {
        return porcComiCob;
    }

    public void setPorcentajeComisionCobrador(Double porcComiCob) {
        this.porcComiCob = porcComiCob;
    }

    public Double getPrimaRecibo() {
        return primaRecibo;
    }

    public void setPrimaRecibo(Double primaRecibo) {
        this.primaRecibo = primaRecibo;
    }

    public Double getPrimaTotal() {
        return primaTotal;
    }

    public void setPrimaTotal(Double primaTotal) {
        this.primaTotal = primaTotal;
    }

    public TipoRecibo getTipoRecibo() {
        return tipoRecibo;
    }

    public void setTipoRecibo(TipoRecibo tipoRecibo) {
        this.tipoRecibo = tipoRecibo;
    }

    public Date getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(Date vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public Date getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(Date vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public Double getPorcComiCob() {
        return porcComiCob;
    }

    public void setPorcComiCob(Double porcComiCob) {
        this.porcComiCob = porcComiCob;
    }

    public Double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Double sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getFinanciado() {
        return financiado;
    }

    public void setFinanciado(Boolean financiado) {
        this.financiado = financiado;
    }

    public TipoZona getZona() {
        return zona;
    }

    public void setZona(TipoZona zona) {
        this.zona = zona;
    }

    public Double getBono1() {
        return bono1;
    }

    public void setBono1(Double bono1) {
        this.bono1 = bono1;
    }

    public Double getBono2() {
        return bono2;
    }

    public void setBono2(Double bono2) {
        this.bono2 = bono2;
    }

    public String getBienAseguradoDescrip() {
        return bienAseguradoDescrip;
    }

    public void setBienAseguradoDescrip(String bienAseguradoDescrip) {
        this.bienAseguradoDescrip = bienAseguradoDescrip;
    }

    public Persona getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Persona asegurado) {
        this.asegurado = asegurado;
    }

    public Financiamiento getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(Financiamiento financiamiento) {
        this.financiamiento = financiamiento;
    }

    public List<Distribucion> getDistribuciones() {
        return distribuciones;
    }

    public void setDistribuciones(List<Distribucion> distribuciones) {
        this.distribuciones = distribuciones;
    }

    public Set<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(Set<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public TipoDistribucion getTipoDistribucion() {
        return tipoDistribucion;
    }

    public void setTipoDistribucion(TipoDistribucion tipoDistribucion) {
        this.tipoDistribucion = tipoDistribucion;
    }

    public Persona getCobrador2() {
        return cobrador2;
    }

    public void setCobrador2(Persona cobrador2) {
        this.cobrador2 = cobrador2;
    }

    public String getTipoDistribucionNombre() {
        return tipoDistribucionNombre;
    }

    public void setTipoDistribucionNombre(String tipoDistribucionNombre) {
        this.tipoDistribucionNombre = tipoDistribucionNombre;
    }

    public String getPrivado() {
        return privado;
    }

    public void setPrivado(String privado) {
        this.privado = privado;
    }

    public List<CoberturasRecibo> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<CoberturasRecibo> coberturas) {
        this.coberturas = coberturas;
    }

    public TipoVigencia getTipoVigencia() {
        return tipoVigencia;
    }

    public void setTipoVigencia(TipoVigencia tipoVigencia) {
        this.tipoVigencia = tipoVigencia;
    }

    public Persona getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Persona ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public Double getBonoPagado() {
        return bonoPagado;
    }

    public void setBonoPagado(Double bonoPagado) {
        this.bonoPagado = bonoPagado;
    }

    public Double getComisionPagada() {
        return comisionPagada;
    }

    public void setComisionPagada(Double comisionPagada) {
        this.comisionPagada = comisionPagada;
    }

    public Double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(Double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
