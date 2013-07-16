/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.polizas.recibos.maestra;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import modelo.entidades.personas.maestra.Persona;
import modelo.entidades.personas.transac.DireccionPersona;
import modelo.util.ehts.BusinessKey;

/**
 *
 * @author NELSON
 */
@Entity
public class ReciboFianzas extends Recibo{

    public ReciboFianzas() {
    }

    @ManyToOne()
    @BusinessKey
    private Persona razonSocial;

    @ManyToOne()
    @BusinessKey
    private TipoFianza tipoFianza;

    @ManyToOne()
    @BusinessKey
    private DireccionPersona direccionCobro;


    @ManyToOne()
    @BusinessKey
    private DireccionPersona direccionRiesgo;

    public DireccionPersona getDireccionCobro() {
        return direccionCobro;
    }

    public void setDireccionCobro(DireccionPersona direccionCobro) {
        this.direccionCobro = direccionCobro;
    }

    public DireccionPersona getDireccionRiesgo() {
        return direccionRiesgo;
    }

    public void setDireccionRiesgo(DireccionPersona direccionRiesgo) {
        this.direccionRiesgo = direccionRiesgo;
    }

    public Persona getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(Persona razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoFianza getTipoFianza() {
        return tipoFianza;
    }

    public void setTipoFianza(TipoFianza tipoFianza) {
        this.tipoFianza = tipoFianza;
    }

}
