
package behavDesc.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

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
		PaletteGroup paletteContainer = new PaletteGroup(behavDesc.model.diagram.part.Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createBehaviouralDescription1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createBehaviouralDescription1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				behavDesc.model.diagram.part.Messages.BehaviouralDescription1CreationTool_title, null,
				Collections.singletonList(
						behavDesc.model.diagram.providers.ModelElementTypes.BehaviouralDescription_2001));
		entry.setId("createBehaviouralDescription1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(behavDesc.model.diagram.providers.ModelElementTypes
				.getImageDescriptor(behavDesc.model.diagram.providers.ModelElementTypes.BehaviouralDescription_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
