/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.productores.caja.controlador;

import controlador.util.DefaultGridInternalController;
import java.util.ArrayList;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author Owner
 */
public class AsientoGridInternalController extends DefaultGridInternalController {

    public AsientoGridInternalController(String classNameModelFullPath, String getMethodName, GridControl miGrid, ArrayList<DefaultGridInternalController> listSubGrids) {
        super(classNameModelFullPath, getMethodName, miGrid, listSubGrids);
    }

    @Override
    public void doubleClick(int rowNumber, ValueObject persistentObject) {
//        PersonaNatural p = ((Beneficiario)persistentObject).getBeneficiario();
//        new PersonasDetailController(null, p, null);
    }     

}
