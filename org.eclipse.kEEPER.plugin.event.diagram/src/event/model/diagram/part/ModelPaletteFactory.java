
package event.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import event.model.diagram.providers.ModelElementTypes;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createEvents1Group());
		paletteRoot.add(createParameters2Group());
	}

	/**
	* Creates "Events" palette tool group
	* @generated
	*/
	private PaletteContainer createEvents1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Events1Group_title);
		paletteContainer.setId("createEvents1Group"); //$NON-NLS-1$
		paletteContainer.add(createPrimitiveEvent1CreationTool());
		paletteContainer.add(createComplexEvent2CreationTool());
		return paletteContainer;
	}

	/**
	* Creates "Parameters" palette tool group
	* @generated
	*/
	private PaletteContainer createParameters2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Parameters2Group_title);
		paletteContainer.setId("createParameters2Group"); //$NON-NLS-1$
		paletteContainer.add(createAgent1CreationTool());
		paletteContainer.add(createObserver2CreationTool());
		paletteContainer.add(createGenericParameter3CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createPrimitiveEvent1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PrimitiveEvent1CreationTool_title,
				Messages.PrimitiveEvent1CreationTool_desc,
				Collections.singletonList(ModelElementTypes.PrimitiveEvent_2011));
		entry.setId("createPrimitiveEvent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.PrimitiveEvent_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createComplexEvent2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ComplexEvent2CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.ComplexEvent_2012));
		entry.setId("createComplexEvent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.ComplexEvent_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAgent1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Agent1CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.AgentReference_2016));
		entry.setId("createAgent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.AgentReference_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createObserver2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Observer2CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.ObserverReference_2017));
		entry.setId("createObserver2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.ObserverReference_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGenericParameter3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.GenericParameter3CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.GeneralTypeReference_2018));
		entry.setId("createGenericParameter3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.GeneralTypeReference_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
