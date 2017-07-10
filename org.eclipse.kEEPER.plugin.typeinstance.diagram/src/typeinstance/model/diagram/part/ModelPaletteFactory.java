
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
		paletteRoot.add(createNodes1Group());
	}

	/**
	* Creates "Nodes" palette tool group
	* @generated
	*/
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createAgent1CreationTool());
		paletteContainer.add(createObserver2CreationTool());
		paletteContainer.add(createGeneralType3CreationTool());
		paletteContainer.add(createInstance4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createAgent1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Agent1CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Agent_2009));
		entry.setId("createAgent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Agent_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createObserver2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Observer2CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Observer_2010));
		entry.setId("createObserver2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Observer_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGeneralType3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.GeneralType3CreationTool_title,
				Messages.GeneralType3CreationTool_desc, Collections.singletonList(ModelElementTypes.GeneralType_2011));
		entry.setId("createGeneralType3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.GeneralType_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createInstance4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Instance4CreationTool_title,
				Messages.Instance4CreationTool_desc, Collections.singletonList(ModelElementTypes.Instance_2005));
		entry.setId("createInstance4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Instance_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
