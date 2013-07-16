package controlador.util;

import java.awt.Dimension;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.util.java.Consts;
/**
 *
 * @author Nelson Moncada
 */
public class DefaultLookupController extends LookupController {

    public DefaultLookupController() {
    }

    public DefaultLookupController(
            String classFullName) {
        this.setLookupDataLocator(new DefaultLookupDataLocatorPorNombre(classFullName));
        this.setLookupGridController(new DefaultLookupGridController());
        setLookupValueObjectClassName(classFullName);
        defaultModel();
    }


    public void defaultModel() {
        setCodeSelectionWindow(GRID_FRAME);
        setOnInvalidCode(ON_INVALID_CODE_RESTORE_LAST_VALID_CODE);
        setAllColumnVisible(false);

        setGridInsertButton(true);
        setColumnEditableOnInsert("nombre", true);

        setGridEditButton(true);
        setColumnEditableOnInsert("nombre", true);

        setAllColumnRequired(false);
        setColumnRequired("nombre", true);

        setVisibleColumn("id", true);
        setVisibleColumn("nombre", true);

        setPreferredWidthColumn("id", 50);
        setPreferredWidthColumn("nombre", 200);

        setFilterableColumn("nombre", true);

        setSortableColumn("id", true);
        setSortedColumn("id", Consts.DESC_SORTED, 0);
        setSortableColumn("nombre", true);

        setFramePreferedSize(new Dimension(300, 330));
    }
}
