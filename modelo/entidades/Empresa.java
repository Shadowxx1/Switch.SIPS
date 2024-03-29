package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import modelo.entidades.personas.transac.CuentaBancariaPersona;
import modelo.util.bean.BeanVO;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author Orlando Becerra
 */
@Entity
@Table(name = "SYST_Empresa")
public class Empresa extends BeanVO implements Serializable {

    /**
     *
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
    @BusinessKey
    private String rif2;
    /**
     */
    @Column
    @Size(min = 2, max = 240)
    @BusinessKey
    private String nombre;
    /**
     */
    @Column
    @BusinessKey
    private String smsUsuario;
    /**
     */
    @Column
    @BusinessKey
    private String URLSms;
    /**
     */
    @Column
    @BusinessKey
    private String smsClave;
    /**
     */
    @Column
    @BusinessKey
    private String telefonos;
    /**
     */
    @Column
    @BusinessKey
    private String direccion;
    /**
     * Email de la persona
     */
    @Column
    @Email
    @BusinessKey
    private String email;
    /**
     *
     */
    @Column
    @BusinessKey
    private String web;
    /**
     *
     */
    @Column
    @Email
    @NotNull
    @BusinessKey
    private String emailEmpresaSoporte;
    /**
     *
     */
    @Column
    @Email
    @NotNull
    @BusinessKey
    private String emailSistemaSoporte;
    /**
     *
     */
    @Column
    @Size(min = 1)
    @BusinessKey
    private String rutaDocDigitales;
    /**
     *
     */
    @Column
    @Size(min = 1)
    @BusinessKey
    private String rutaReportes;
    /*
     *
     */
    @Column
    @BusinessKey
    private Boolean fileGridProfileManager;
    /*
     *
     */
    @Column
    @BusinessKey
    private Boolean textoMayuscula;

    /**
     * Pregunta si la liquidacion se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     */
    @Column
    @BusinessKey
    private Boolean smsBienvenida;

    /**
     * Pregunta si la liquidacion se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     */
    @Column
    @BusinessKey
    private Boolean liquidarEnOrden;
    /**
     * Pregunta si el calculo se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     */
    @Column
    @BusinessKey
    private Boolean sustraendoEnOrden;
    /**
     *
     */
    @Column
    private Integer usosDisponibles;
    /**
     * Encabesado de los Reportes
     */
    @ManyToOne
    private Encabezado encabezado;
    /**
     * Coleccion de cuentas bancarias de la empresa
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BusinessKey(exclude = Method.ALL)
    private Set<CuentaBancariaPersona> cuentasBancarias = new HashSet<CuentaBancariaPersona>(0);
    /**
     *
     */
    @Version
    @Column
    private Integer optLock;

    public Empresa() {
        textoMayuscula = false;
        fileGridProfileManager = false;
        liquidarEnOrden = true;

    }

    public Empresa(String rif2, String nombre, String emailEmpresaSoporte, String emailSistemaSoporte, String rutaDocDigitales, String rutaReportes) {
        this.rif2 = rif2;
        this.nombre = nombre;
        this.emailEmpresaSoporte = emailEmpresaSoporte;
        this.emailSistemaSoporte = emailSistemaSoporte;
        this.rutaDocDigitales = rutaDocDigitales;
        this.rutaReportes = rutaReportes;
        textoMayuscula = false;
        fileGridProfileManager = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailEmpresaSoporte() {
        return emailEmpresaSoporte;
    }

    public void setEmailEmpresaSoporte(String emailEmpresaSoporte) {
        this.emailEmpresaSoporte = emailEmpresaSoporte;
    }

    public String getEmailSistemaSoporte() {
        return emailSistemaSoporte;
    }

    public void setEmailSistemaSoporte(String emailSistemaSoporte) {
        this.emailSistemaSoporte = emailSistemaSoporte;
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

    public String getRutaDocDigitales() {
        return rutaDocDigitales;
    }

    public void setRutaDocDigitales(String rutaDocDigitales) {
        this.rutaDocDigitales = rutaDocDigitales;
    }

    public String getRutaReportes() {
        return rutaReportes;
    }

    public void setRutaReportes(String rutaReportes) {
        this.rutaReportes = rutaReportes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Boolean getTextoMayuscula() {
        return textoMayuscula;
    }

    public void setTextoMayuscula(Boolean textoMayuscula) {
        this.textoMayuscula = textoMayuscula;
    }

    public String getRif2() {
        return rif2;
    }

    public void setRif2(String rif2) {
        this.rif2 = rif2;
    }

    public Boolean getFileGridProfileManager() {
        return fileGridProfileManager;
    }

    public void setFileGridProfileManager(Boolean fileGridProfileManager) {
        this.fileGridProfileManager = fileGridProfileManager;
    }

    public Integer getUsosDisponibles() {
        return usosDisponibles;
    }

    public void setUsosDisponibles(Integer usosDisponibles) {
        this.usosDisponibles = usosDisponibles;
    }

    /**
     * Encabesado de los Reportes
     * @return the encabezado
     */
    public Encabezado getEncabezado() {
        return encabezado;
    }

    /**
     * Encabesado de los Reportes
     * @param encabezado the encabezado to set
     */
    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    /**
     * Coleccion de cuentas bancarias de la empresa
     * @return the cuentasBancarias
     */
    public Set<CuentaBancariaPersona> getCuentasBancarias() {
        return cuentasBancarias;
    }

    /**
     * Coleccion de cuentas bancarias de la empresa
     * @param cuentasBancarias the cuentasBancarias to set
     */
    public void setCuentasBancarias(Set<CuentaBancariaPersona> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    /**
     * Pregunta si la liquidacion se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     * @return the liquidarEnOrden
     */
    public Boolean getLiquidarEnOrden() {
        return liquidarEnOrden;
    }

    /**
     * Pregunta si la liquidacion se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     * @param liquidarEnOrden the liquidarEnOrden to set
     */
    public void setLiquidarEnOrden(Boolean liquidarEnOrden) {
        this.liquidarEnOrden = liquidarEnOrden;
    }

    /**
     * Pregunta si el calculo se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     * @return the sustraendoEnOrden
     */
    public Boolean getSustraendoEnOrden() {
        return sustraendoEnOrden;
    }

    /**
     * Pregunta si el calculo se efectuara en la orden de pago o al
     * liquidar el detalle de siniestro
     * @param sustraendoEnOrden the sustraendoEnOrden to set
     */
    public void setSustraendoEnOrden(Boolean sustraendoEnOrden) {
        this.sustraendoEnOrden = sustraendoEnOrden;
    }

    public String getSmsClave() {
        return smsClave;
    }

    public void setSmsClave(String smsClave) {
        this.smsClave = smsClave;
    }

    public String getSmsUsuario() {
        return smsUsuario;
    }

    public void setSmsUsuario(String smsUsuario) {
        this.smsUsuario = smsUsuario;
    }

    public String getURLSms() {
        return URLSms;
    }

    public void setURLSms(String URLSms) {
        this.URLSms = URLSms;
    }

    public Boolean getSmsBienvenida() {
        return smsBienvenida;
    }

    public void setSmsBienvenida(Boolean smsBienvenida) {
        this.smsBienvenida = smsBienvenida;
    }

}
