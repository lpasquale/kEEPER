package event.model.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import event.model.diagram.edit.parts.AgentReferenceEditPart;
import event.model.diagram.edit.parts.AgentReferenceTypeNameEditPart;
import event.model.diagram.edit.parts.ComplexEventAgentEditPart;
import event.model.diagram.edit.parts.ComplexEventEditPart;
import event.model.diagram.edit.parts.ComplexEventNameEditPart;
import event.model.diagram.edit.parts.EnvironmentEditPart;
import event.model.diagram.edit.parts.EventTypesEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceTypeNameEditPart;
import event.model.diagram.edit.parts.ObserverReferenceEditPart;
import event.model.diagram.edit.parts.ObserverReferenceTypeNameEditPart;
import event.model.diagram.edit.parts.PrimitiveEventAgentEditPart;
import event.model.diagram.edit.parts.PrimitiveEventEditPart;
import event.model.diagram.edit.parts.PrimitiveEventNameEditPart;
import event.model.diagram.edit.parts.PrimitiveEventObserverEditPart;
import event.model.diagram.part.ModelDiagramEditorPlugin;
import event.model.diagram.part.ModelVisualIDRegistry;
import event.model.diagram.providers.ModelElementTypes;
import event.model.diagram.providers.ModelParserProvider;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		ModelDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		ModelDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ModelNavigatorItem && !isOwnView(((ModelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof ModelNavigatorGroup) {
			ModelNavigatorGroup group = (ModelNavigatorGroup) element;
			return ModelDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof ModelNavigatorItem) {
			ModelNavigatorItem navigatorItem = (ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case EnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?https://github.com/mlatona/minorityReportPlugin?Environment", //$NON-NLS-1$
					ModelElementTypes.Environment_1000);
		case PrimitiveEventEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?PrimitiveEvent", //$NON-NLS-1$
					ModelElementTypes.PrimitiveEvent_2011);
		case ComplexEventEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?ComplexEvent", //$NON-NLS-1$
					ModelElementTypes.ComplexEvent_2012);
		case AgentReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?AgentReference", //$NON-NLS-1$
					ModelElementTypes.AgentReference_2016);
		case ObserverReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?ObserverReference", //$NON-NLS-1$
					ModelElementTypes.ObserverReference_2017);
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?GeneralTypeReference", //$NON-NLS-1$
					ModelElementTypes.GeneralTypeReference_2018);
		case PrimitiveEventAgentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?PrimitiveEvent?agent", //$NON-NLS-1$
					ModelElementTypes.PrimitiveEventAgent_4001);
		case PrimitiveEventObserverEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?PrimitiveEvent?observer", //$NON-NLS-1$
					ModelElementTypes.PrimitiveEventObserver_4002);
		case ComplexEventAgentEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?ComplexEvent?agent", //$NON-NLS-1$
					ModelElementTypes.ComplexEventAgent_4004);
		case EventTypesEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?Event?types", //$NON-NLS-1$
					ModelElementTypes.EventTypes_4005);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ModelDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && ModelElementTypes.isKnownElementType(elementType)) {
			image = ModelElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof ModelNavigatorGroup) {
			ModelNavigatorGroup group = (ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ModelNavigatorItem) {
			ModelNavigatorItem navigatorItem = (ModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ModelVisualIDRegistry.getVisualID(view)) {
		case EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000Text(view);
		case PrimitiveEventEditPart.VISUAL_ID:
			return getPrimitiveEvent_2011Text(view);
		case ComplexEventEditPart.VISUAL_ID:
			return getComplexEvent_2012Text(view);
		case AgentReferenceEditPart.VISUAL_ID:
			return getAgentReference_2016Text(view);
		case ObserverReferenceEditPart.VISUAL_ID:
			return getObserverReference_2017Text(view);
		case GeneralTypeReferenceEditPart.VISUAL_ID:
			return getGeneralTypeReference_2018Text(view);
		case PrimitiveEventAgentEditPart.VISUAL_ID:
			return getPrimitiveEventAgent_4001Text(view);
		case PrimitiveEventObserverEditPart.VISUAL_ID:
			return getPrimitiveEventObserver_4002Text(view);
		case ComplexEventAgentEditPart.VISUAL_ID:
			return getComplexEventAgent_4004Text(view);
		case EventTypesEditPart.VISUAL_ID:
			return getEventTypes_4005Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getEnvironment_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getPrimitiveEvent_2011Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.PrimitiveEvent_2011,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(PrimitiveEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getComplexEvent_2012Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.ComplexEvent_2012,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(ComplexEventNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAgentReference_2016Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.AgentReference_2016,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(AgentReferenceTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserverReference_2017Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.ObserverReference_2017,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(ObserverReferenceTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGeneralTypeReference_2018Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.GeneralTypeReference_2018,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(GeneralTypeReferenceTypeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPrimitiveEventAgent_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getPrimitiveEventObserver_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getComplexEventAgent_4004Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getEventTypes_4005Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return EnvironmentEditPart.MODEL_ID.equals(ModelVisualIDRegistry.getModelID(view));
	}

}
