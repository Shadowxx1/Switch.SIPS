/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.siniestros.maestra;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import modelo.Dominios.GradoLicencia;
import modelo.Dominios.MotivoPerdida;
import modelo.Dominios.Parentesco;
import modelo.Dominios.TipoPerdida;
import modelo.entidades.personas.maestra.PersonaNatural;
import modelo.entidades.polizas.recibos.maestra.ReciboVehiculos;
import modelo.util.ehts.BusinessKey;

/**
 *
 * @author NELSON
 */
public class SiniestroVehiculo extends Siniestro{

    public SiniestroVehiculo() {
    }

    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private PersonaNatural conductor;
    /**
     * Abierto, Cerrado
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private Parentesco parentesco;

    /**
     *  ninguna, total, parcial
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private GradoLicencia gradoLicencia;

    /**
     *  ninguna, total, parcial
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private TipoPerdida tipoPerdida;

    /**
     *  ninguna, total, parcial
     */
    @Column
    @Enumerated(EnumType.STRING)
    @BusinessKey
    private MotivoPerdida motivoPerdida;

    /**
     *
     */
    @ManyToOne
    @NotNull
    private ReciboVehiculos reciboVehiculos;

    public ReciboVehiculos getReciboVehiculos() {
        return reciboVehiculos;
    }

    public void setReciboVehiculos(ReciboVehiculos reciboVehiculos) {
        this.reciboVehiculos = reciboVehiculos;
    }

    public TipoPerdida getTipoPerdida() {
        return tipoPerdida;
    }

    public void setTipoPerdida(TipoPerdida tipoPerdida) {
        this.tipoPerdida = tipoPerdida;
    }

    public PersonaNatural getConductor() {
        return conductor;
    }

    public void setConductor(PersonaNatural conductor) {
        this.conductor = conductor;
    }

    public GradoLicencia getGradoLicencia() {
        return gradoLicencia;
    }

    public void setGradoLicencia(GradoLicencia gradoLicencia) {
        this.gradoLicencia = gradoLicencia;
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public MotivoPerdida getMotivoPerdida() {
        return motivoPerdida;
    }

    public void setMotivoPerdida(MotivoPerdida motivoPerdida) {
        this.motivoPerdida = motivoPerdida;
    }

}
