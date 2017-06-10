
package hypothesis.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import hypothesis.model.diagram.providers.ModelElementTypes;

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
		paletteContainer.add(createHypothesis1CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createHypothesis1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Hypothesis1CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Hypothesis_2001));
		entry.setId("createHypothesis1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Hypothesis_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
