/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilitario;

import java.util.Date;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.dominio.GrupoPoliza;
import modelo.entidades.polizas.recibos.dominio.TipoZona;
import modelo.util.bean.BeanVO;

/**
 *
 * @author Nelson
 */
public class FiltroAsesor extends BeanVO {

//    private Producto producto;
    private GrupoPoliza grupo;
    private Persona asesor;
    private TipoZona tipoZona;
    private Integer anoCobro;
    private Integer anoPago;
    private Integer anoVigenciaDesde;
    private Integer anoVigenciaHasta;
    private Date desdeFechaCobro;
    private Date hastaFechaCobro;
    private Date desdeFechaPago;
    private Date hastaFechaPago;
    private Date desdeVigenciaDesde;
    private Date hastaVigenciaDesde;
    private Date desdeVigenciaHasta;
    private Date hastaVigenciaHasta;

    public FiltroAsesor() {
    }

    public GrupoPoliza getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPoliza grupo) {
        this.grupo = grupo;
    }

    public Persona getAsesor() {
        return asesor;
    }

    public void setAsesor(Persona asesor) {
        this.asesor = asesor;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(TipoZona tipoZona) {
        this.tipoZona = tipoZona;
    }
//
//    public Producto getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Producto producto) {
//        this.producto = producto;
//    }

    public Integer getAnoCobro() {
        return anoCobro;
    }

    public void setAnoCobro(Integer anoCobro) {
        this.anoCobro = anoCobro;
    }

    public Integer getAnoPago() {
        return anoPago;
    }

    public void setAnoPago(Integer anoPago) {
        this.anoPago = anoPago;
    }

    public Integer getAnoVigenciaDesde() {
        return anoVigenciaDesde;
    }

    public void setAnoVigenciaDesde(Integer anoVigenciaDesde) {
        this.anoVigenciaDesde = anoVigenciaDesde;
    }

    public Integer getAnoVigenciaHasta() {
        return anoVigenciaHasta;
    }

    public void setAnoVigenciaHasta(Integer anoVigenciaHasta) {
        this.anoVigenciaHasta = anoVigenciaHasta;
    }

    public Date getDesdeFechaCobro() {
        return desdeFechaCobro;
    }

    public void setDesdeFechaCobro(Date desdeFechaCobro) {
        this.desdeFechaCobro = desdeFechaCobro;
    }

    public Date getDesdeFechaPago() {
        return desdeFechaPago;
    }

    public void setDesdeFechaPago(Date desdeFechaPago) {
        this.desdeFechaPago = desdeFechaPago;
    }

    public Date getDesdeVigenciaDesde() {
        return desdeVigenciaDesde;
    }

    public void setDesdeVigenciaDesde(Date desdeVigenciaDesde) {
        this.desdeVigenciaDesde = desdeVigenciaDesde;
    }

    public Date getDesdeVigenciaHasta() {
        return desdeVigenciaHasta;
    }

    public void setDesdeVigenciaHasta(Date desdeVigenciaHasta) {
        this.desdeVigenciaHasta = desdeVigenciaHasta;
    }

    public Date getHastaFechaCobro() {
        return hastaFechaCobro;
    }

    public void setHastaFechaCobro(Date hastaFechaCobro) {
        this.hastaFechaCobro = hastaFechaCobro;
    }

    public Date getHastaFechaPago() {
        return hastaFechaPago;
    }

    public void setHastaFechaPago(Date hastaFechaPago) {
        this.hastaFechaPago = hastaFechaPago;
    }

    public Date getHastaVigenciaDesde() {
        return hastaVigenciaDesde;
    }

    public void setHastaVigenciaDesde(Date hastaVigenciaDesde) {
        this.hastaVigenciaDesde = hastaVigenciaDesde;
    }

    public Date getHastaVigenciaHasta() {
        return hastaVigenciaHasta;
    }

    public void setHastaVigenciaHasta(Date hastaVigenciaHasta) {
        this.hastaVigenciaHasta = hastaVigenciaHasta;
    }
    
}
