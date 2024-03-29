/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilitario;

import java.util.Date;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.polizas.dominio.GrupoPoliza;
import modelo.entidades.polizas.dominio.RamoPoliza;
import modelo.entidades.polizas.recibos.dominio.TipoZona;
import modelo.util.bean.BeanVO;

/**
 *
 * @author Nelson Moncada
 */
public class FiltroFinanciamiento extends BeanVO {

    private Persona compania;
    private RamoPoliza ramo;
    private GrupoPoliza grupo;
    private Persona productor;
    private Persona cobrador;
    private TipoZona tipoZona;
    private Persona financiadora;
    private Date fechaVencimientoDesde;
    private Date fechaVencimientoHasta;
    public FiltroFinanciamiento() {
        
    }

    public Persona getCobrador() {
        return cobrador;
    }

    public void setCobrador(Persona cobrador) {
        this.cobrador = cobrador;
    }

    public Persona getCompania() {
        return compania;
    }

    public void setCompania(Persona compania) {
        this.compania = compania;
    }

    public GrupoPoliza getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoPoliza grupo) {
        this.grupo = grupo;
    }

    public Persona getProductor() {
        return productor;
    }

    public void setProductor(Persona productor) {
        this.productor = productor;
    }

    public RamoPoliza getRamo() {
        return ramo;
    }

    public void setRamo(RamoPoliza ramo) {
        this.ramo = ramo;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(TipoZona tipoZona) {
        this.tipoZona = tipoZona;
    }

    public Persona getFinanciadora() {
        return financiadora;
    }

    public void setFinanciadora(Persona financiadora) {
        this.financiadora = financiadora;
    }

    public Date getFechaVencimientoDesde() {
        return fechaVencimientoDesde;
    }

    public void setFechaVencimientoDesde(Date fechaVencimientoDesde) {
        this.fechaVencimientoDesde = fechaVencimientoDesde;
    }

    public Date getFechaVencimientoHasta() {
        return fechaVencimientoHasta;
    }

    public void setFechaVencimientoHasta(Date fechaVencimientoHasta) {
        this.fechaVencimientoHasta = fechaVencimientoHasta;
    }

}
