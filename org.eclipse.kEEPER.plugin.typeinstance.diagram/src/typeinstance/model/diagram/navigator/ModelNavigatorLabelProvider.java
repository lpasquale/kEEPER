package typeinstance.model.diagram.navigator;

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

import typeinstance.model.diagram.edit.parts.AgentEditPart;
import typeinstance.model.diagram.edit.parts.EnvironmentEditPart;
import typeinstance.model.diagram.edit.parts.GeneralTypeEditPart;
import typeinstance.model.diagram.edit.parts.InstanceEditPart;
import typeinstance.model.diagram.edit.parts.InstanceNameEditPart;
import typeinstance.model.diagram.edit.parts.InstanceTypeEditPart;
import typeinstance.model.diagram.edit.parts.ObserverEditPart;
import typeinstance.model.diagram.edit.parts.WrappingLabel2EditPart;
import typeinstance.model.diagram.edit.parts.WrappingLabel3EditPart;
import typeinstance.model.diagram.edit.parts.WrappingLabel4EditPart;
import typeinstance.model.diagram.part.ModelDiagramEditorPlugin;
import typeinstance.model.diagram.part.ModelVisualIDRegistry;
import typeinstance.model.diagram.providers.ModelElementTypes;
import typeinstance.model.diagram.providers.ModelParserProvider;

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
		case InstanceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Instance", //$NON-NLS-1$
					ModelElementTypes.Instance_2005);
		case AgentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Agent", //$NON-NLS-1$
					ModelElementTypes.Agent_2009);
		case ObserverEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Observer", //$NON-NLS-1$
					ModelElementTypes.Observer_2010);
		case GeneralTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?GeneralType", //$NON-NLS-1$
					ModelElementTypes.GeneralType_2011);
		case InstanceTypeEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?Instance?type", //$NON-NLS-1$
					ModelElementTypes.InstanceType_4003);
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
		case InstanceEditPart.VISUAL_ID:
			return getInstance_2005Text(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2009Text(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2010Text(view);
		case GeneralTypeEditPart.VISUAL_ID:
			return getGeneralType_2011Text(view);
		case InstanceTypeEditPart.VISUAL_ID:
			return getInstanceType_4003Text(view);
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
	private String getInstance_2005Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.Instance_2005,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(InstanceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAgent_2009Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.Agent_2009,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(WrappingLabel3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserver_2010Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.Observer_2010,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(WrappingLabel4EditPart.VISUAL_ID));
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
	private String getGeneralType_2011Text(View view) {
		IParser parser = ModelParserProvider.getParser(ModelElementTypes.GeneralType_2011,
				view.getElement() != null ? view.getElement() : view,
				ModelVisualIDRegistry.getType(WrappingLabel2EditPart.VISUAL_ID));
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
	private String getInstanceType_4003Text(View view) {
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
