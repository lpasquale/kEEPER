
package event.model.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
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
		paletteRoot.add(createNodes1Group());
	}

	/**
	* Creates "Nodes" palette tool group
	* @generated
	*/
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createAgentPrimitiveEvent1CreationTool());
		paletteContainer.add(createObserverPrimitiveEvent2CreationTool());
		paletteContainer.add(createGenericparameterPrimitiveEvent3CreationTool());
		paletteContainer.add(createPrimitiveEvent4CreationTool());
		paletteContainer.add(createComplexEvent5CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createAgentPrimitiveEvent1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.AgentPrimitiveEvent1CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Agent_2007));
		entry.setId("createAgentPrimitiveEvent1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.minorityReportPlugin.event.diagram/icons/obj16/agent.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createObserverPrimitiveEvent2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ObserverPrimitiveEvent2CreationTool_title,
				Messages.ObserverPrimitiveEvent2CreationTool_desc,
				Collections.singletonList(ModelElementTypes.Observer_2008));
		entry.setId("createObserverPrimitiveEvent2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelDiagramEditorPlugin
				.findImageDescriptor("/org.eclipse.minorityReportPlugin.event.diagram/icons/obj16/observer.ico")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createGenericparameterPrimitiveEvent3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.GenericparameterPrimitiveEvent3CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.Parameter_2009));
		entry.setId("createGenericparameterPrimitiveEvent3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.Parameter_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPrimitiveEvent4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.PrimitiveEvent4CreationTool_title,
				Messages.PrimitiveEvent4CreationTool_desc,
				Collections.singletonList(ModelElementTypes.PrimitiveEvent_2005));
		entry.setId("createPrimitiveEvent4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.PrimitiveEvent_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createComplexEvent5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.ComplexEvent5CreationTool_title, null,
				Collections.singletonList(ModelElementTypes.ComplexEvent_2010));
		entry.setId("createComplexEvent5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ModelElementTypes.getImageDescriptor(ModelElementTypes.ComplexEvent_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
