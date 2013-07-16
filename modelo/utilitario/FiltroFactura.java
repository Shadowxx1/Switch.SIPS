/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilitario;

import java.util.Date;
import modelo.util.bean.BeanVO;

/**
 *
 * @author Nelson
 */
public class FiltroFactura extends BeanVO {

    private Long numeroDesde1;
    private Long numeroHasta1;

    private Long numeroDesde2;
    private Long numeroHasta2;

    private String numeroControlDesde1;
    private String numeroControlHasta1;

    private String numeroControlDesde2;
    private String numeroControlHasta2;

    private Integer anoEmision;
    private Integer anoPago;

    private Date desdeFechaEmision;
    private Date hastaFechaEmision;

    private Date desdeFechaPago;
    private Date hastaFechaPago;
    
    public FiltroFactura() {
    }

    public Date getDesdeFechaEmision() {
        return desdeFechaEmision;
    }

    public void setDesdeFechaEmision(Date desdeFechaEmision) {
        this.desdeFechaEmision = desdeFechaEmision;
    }

    public Date getDesdeFechaPago() {
        return desdeFechaPago;
    }

    public void setDesdeFechaPago(Date desdeFechaPago) {
        this.desdeFechaPago = desdeFechaPago;
    }

    public Date getHastaFechaEmision() {
        return hastaFechaEmision;
    }

    public void setHastaFechaEmision(Date hastaFechaEmision) {
        this.hastaFechaEmision = hastaFechaEmision;
    }

    public Date getHastaFechaPago() {
        return hastaFechaPago;
    }

    public void setHastaFechaPago(Date hastaFechaPago) {
        this.hastaFechaPago = hastaFechaPago;
    }

    public Integer getAnoEmision() {
        return anoEmision;
    }

    public void setAnoEmision(Integer anoEmision) {
        this.anoEmision = anoEmision;
    }

    public Integer getAnoPago() {
        return anoPago;
    }

    public void setAnoPago(Integer anoPago) {
        this.anoPago = anoPago;
    }

    public Long getNumeroDesde1() {
        return numeroDesde1;
    }

    public void setNumeroDesde1(Long numeroDesde1) {
        this.numeroDesde1 = numeroDesde1;
    }

    public Long getNumeroDesde2() {
        return numeroDesde2;
    }

    public void setNumeroDesde2(Long numeroDesde2) {
        this.numeroDesde2 = numeroDesde2;
    }

    public Long getNumeroHasta1() {
        return numeroHasta1;
    }

    public void setNumeroHasta1(Long numeroHasta1) {
        this.numeroHasta1 = numeroHasta1;
    }

    public Long getNumeroHasta2() {
        return numeroHasta2;
    }

    public void setNumeroHasta2(Long numeroHasta2) {
        this.numeroHasta2 = numeroHasta2;
    }

    public String getNumeroControlDesde1() {
        return numeroControlDesde1;
    }

    public void setNumeroControlDesde1(String numeroControlDesde1) {
        this.numeroControlDesde1 = numeroControlDesde1;
    }

    public String getNumeroControlDesde2() {
        return numeroControlDesde2;
    }

    public void setNumeroControlDesde2(String numeroControlDesde2) {
        this.numeroControlDesde2 = numeroControlDesde2;
    }

    public String getNumeroControlHasta1() {
        return numeroControlHasta1;
    }

    public void setNumeroControlHasta1(String numeroControlHasta1) {
        this.numeroControlHasta1 = numeroControlHasta1;
    }

    public String getNumeroControlHasta2() {
        return numeroControlHasta2;
    }

    public void setNumeroControlHasta2(String numeroControlHasta2) {
        this.numeroControlHasta2 = numeroControlHasta2;
    }


}
