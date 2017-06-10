
package contextRelation.model.diagram.part;

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
		PaletteGroup paletteContainer = new PaletteGroup(contextRelation.model.diagram.part.Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createContextRelation1CreationTool());
		paletteContainer.add(createParameter2CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createContextRelation1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				contextRelation.model.diagram.part.Messages.ContextRelation1CreationTool_title, null, Collections
						.singletonList(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001));
		entry.setId("createContextRelation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(contextRelation.model.diagram.providers.ModelElementTypes
				.getImageDescriptor(contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createParameter2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				contextRelation.model.diagram.part.Messages.Parameter2CreationTool_title, null,
				Collections.singletonList(contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002));
		entry.setId("createParameter2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(contextRelation.model.diagram.providers.ModelElementTypes
				.getImageDescriptor(contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
