/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.siniestros.maestra;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import modelo.entidades.polizas.recibos.maestra.Certificado;
import modelo.entidades.polizas.recibos.maestra.ReciboPersonas;

/**
 *
 * @author NELSON
 */
public class SiniestroPersona extends Siniestro{

    public SiniestroPersona() {
    }

    /**
     *
     */
    @ManyToOne
    @NotNull
    private ReciboPersonas reciboPersonas;
    
    /**
     *
     */
    @ManyToOne
    private Certificado certificado;

    public ReciboPersonas getReciboPersonas() {
        return reciboPersonas;
    }

    public void setReciboPersonas(ReciboPersonas reciboPersonas) {
        this.reciboPersonas = reciboPersonas;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

}
