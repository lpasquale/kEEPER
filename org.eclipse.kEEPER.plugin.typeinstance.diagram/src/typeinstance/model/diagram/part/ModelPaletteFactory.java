
package typeinstance.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import typeinstance.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createModel1Group());
	}

	/**
	* Creates "model" palette tool group
	* @generated
	*/
	private PaletteContainer createModel1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Model1Group_title);
		paletteContainer.setId("createModel1Group"); //$NON-NLS-1$
		paletteContainer.add(createType1CreationTool());
		paletteContainer.add(createInstance2CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createType1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Type1CreationTool_title,
				Messages.Type1CreationTool_desc, Collections.singletonList(ModelElementTypes.Type_2006));
		entry.setId("createType1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Type_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInstance2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Instance2CreationTool_title,
				Messages.Instance2CreationTool_desc, Collections.singletonList(ModelElementTypes.Instance_2005));
		entry.setId("createInstance2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Instance_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
