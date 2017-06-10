package contextRelation.model.diagram.navigator;

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

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorItem
				&& !isOwnView(((contextRelation.model.diagram.navigator.ModelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorGroup) {
			contextRelation.model.diagram.navigator.ModelNavigatorGroup group = (contextRelation.model.diagram.navigator.ModelNavigatorGroup) element;
			return contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorItem) {
			contextRelation.model.diagram.navigator.ModelNavigatorItem navigatorItem = (contextRelation.model.diagram.navigator.ModelNavigatorItem) element;
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
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?https://github.com/mlatona/minorityReportPlugin?Environment", //$NON-NLS-1$
					contextRelation.model.diagram.providers.ModelElementTypes.Environment_1000);
		case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?ContextRelation", //$NON-NLS-1$
					contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001);
		case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Parameter", //$NON-NLS-1$
					contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002);
		case contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart.VISUAL_ID:
			return getImage("Navigator?Link?https://github.com/mlatona/minorityReportPlugin?ContextRelation?parameters", //$NON-NLS-1$
					contextRelation.model.diagram.providers.ModelElementTypes.ContextRelationParameters_4001);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& contextRelation.model.diagram.providers.ModelElementTypes.isKnownElementType(elementType)) {
			image = contextRelation.model.diagram.providers.ModelElementTypes.getImage(elementType);
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
		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorGroup) {
			contextRelation.model.diagram.navigator.ModelNavigatorGroup group = (contextRelation.model.diagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorItem) {
			contextRelation.model.diagram.navigator.ModelNavigatorItem navigatorItem = (contextRelation.model.diagram.navigator.ModelNavigatorItem) element;
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
		switch (contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case contextRelation.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000Text(view);
		case contextRelation.model.diagram.edit.parts.ContextRelationEditPart.VISUAL_ID:
			return getContextRelation_2001Text(view);
		case contextRelation.model.diagram.edit.parts.ParameterEditPart.VISUAL_ID:
			return getParameter_2002Text(view);
		case contextRelation.model.diagram.edit.parts.ContextRelationParametersEditPart.VISUAL_ID:
			return getContextRelationParameters_4001Text(view);
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
	private String getContextRelation_2001Text(View view) {
		IParser parser = contextRelation.model.diagram.providers.ModelParserProvider.getParser(
				contextRelation.model.diagram.providers.ModelElementTypes.ContextRelation_2001,
				view.getElement() != null ? view.getElement() : view,
				contextRelation.model.diagram.part.ModelVisualIDRegistry
						.getType(contextRelation.model.diagram.edit.parts.ContextRelationNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getParameter_2002Text(View view) {
		IParser parser = contextRelation.model.diagram.providers.ModelParserProvider.getParser(
				contextRelation.model.diagram.providers.ModelElementTypes.Parameter_2002,
				view.getElement() != null ? view.getElement() : view,
				contextRelation.model.diagram.part.ModelVisualIDRegistry
						.getType(contextRelation.model.diagram.edit.parts.ParameterNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getContextRelationParameters_4001Text(View view) {
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
		return contextRelation.model.diagram.edit.parts.EnvironmentEditPart.MODEL_ID
				.equals(contextRelation.model.diagram.part.ModelVisualIDRegistry.getModelID(view));
	}

}
