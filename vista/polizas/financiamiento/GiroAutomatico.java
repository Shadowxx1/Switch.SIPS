/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.polizas.financiamiento;

import java.util.Date;
import modelo.entidades.personas.transac.CuentaBancariaPersona;
import modelo.util.bean.BeanVO;

/**
 *
 * @author NELSON
 */
public class GiroAutomatico extends BeanVO {

    private Integer numGiros;
    private Double montoGiro;
    private Date fechaPrimerGiro;
    private Boolean domiciliado;
    private CuentaBancariaPersona cuentaBancariaPersona;

    public GiroAutomatico() {
    }

    public CuentaBancariaPersona getCuentaBancariaPersona() {
        return cuentaBancariaPersona;
    }

    public void setCuentaBancariaPersona(CuentaBancariaPersona cuentaBancariaPersona) {
        this.cuentaBancariaPersona = cuentaBancariaPersona;
    }

    public Boolean getDomiciliado() {
        return domiciliado;
    }

    public void setDomiciliado(Boolean domiciliado) {
        this.domiciliado = domiciliado;
    }

    public Date getFechaPrimerGiro() {
        return fechaPrimerGiro;
    }

    public void setFechaPrimerGiro(Date fechaPrimerGiro) {
        this.fechaPrimerGiro = fechaPrimerGiro;
    }

    public Double getMontoGiro() {
        return montoGiro;
    }

    public void setMontoGiro(Double montoGiro) {
        this.montoGiro = montoGiro;
    }

    public Integer getNumGiros() {
        return numGiros;
    }

    public void setNumGiros(Integer numGiros) {
        this.numGiros = numGiros;
    }
}
