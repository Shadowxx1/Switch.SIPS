/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.entidades.polizas.recibos.maestra;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import modelo.util.ehts.BusinessKey;
import modelo.util.ehts.Method;

/**
 *
 * @author NELSON
 */
@Entity
public class ReciboPersonas extends Recibo{

    public ReciboPersonas() {
    }

    /**
     *
     */
    @OneToMany(mappedBy = "recibo", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @BusinessKey(exclude = Method.ALL)
    private List<Certificado> certificados = new ArrayList<Certificado>(0);

    public List<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    
}
