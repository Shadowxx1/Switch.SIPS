/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.polizas.recibos.maestra;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import modelo.entidades.vehiculos.maestra.Vehiculo;
import modelo.util.ehts.BusinessKey;

/**
 *
 * @author NELSON
 */
@Entity
public class ReciboVehiculos extends Recibo{

    public ReciboVehiculos() {
    }

    /**
     *
     */
    @ManyToOne
    @BusinessKey
    private Vehiculo vehiculo;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
