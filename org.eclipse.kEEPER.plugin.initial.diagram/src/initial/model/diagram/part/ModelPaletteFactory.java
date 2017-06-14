
package initial.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import initial.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
	}

	/**
	* Creates "Nodes" palette tool group
	* @generated
	*/
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createInitial1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createInitial1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Initial1CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Initially_2001));
		entry.setId("createInitial1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Initially_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
