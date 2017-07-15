package behavDesc.model.diagram.navigator;

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

import model.Agent;
import model.AgentParam;
import model.BehaviouralDescription;
import model.GeneralParam;
import model.GeneralType;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Observer;
import model.ObserverParam;

/**
 * @generated
 */
public class ModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorItem
				&& !isOwnView(((behavDesc.model.diagram.navigator.ModelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorGroup) {
			behavDesc.model.diagram.navigator.ModelNavigatorGroup group = (behavDesc.model.diagram.navigator.ModelNavigatorGroup) element;
			return behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorItem) {
			behavDesc.model.diagram.navigator.ModelNavigatorItem navigatorItem = (behavDesc.model.diagram.navigator.ModelNavigatorItem) element;
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
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?https://github.com/mlatona/minorityReportPlugin?Environment", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.Environment_1000);
		case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?BehaviouralDescription", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.BehaviouralDescription_2001);
		case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Happens", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.Happens_2002);
		case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?HoldsAt", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.HoldsAt_2003);
		case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?HoldsAtBetween", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.HoldsAtBetween_2004);
		case behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?AgentParam", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.AgentParam_2005);
		case behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?ObserverParam", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.ObserverParam_2006);
		case behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?GeneralParam", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.GeneralParam_2007);
		case behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Agent", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.Agent_2008);
		case behavDesc.model.diagram.edit.parts.GeneralTypeEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?GeneralType", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.GeneralType_2009);
		case behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Observer", //$NON-NLS-1$
					behavDesc.model.diagram.providers.ModelElementTypes.Observer_2010);
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& behavDesc.model.diagram.providers.ModelElementTypes.isKnownElementType(elementType)) {
			image = behavDesc.model.diagram.providers.ModelElementTypes.getImage(elementType);
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
		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorGroup) {
			behavDesc.model.diagram.navigator.ModelNavigatorGroup group = (behavDesc.model.diagram.navigator.ModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorItem) {
			behavDesc.model.diagram.navigator.ModelNavigatorItem navigatorItem = (behavDesc.model.diagram.navigator.ModelNavigatorItem) element;
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
		switch (behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(view)) {
		case behavDesc.model.diagram.edit.parts.EnvironmentEditPart.VISUAL_ID:
			return getEnvironment_1000Text(view);
		case behavDesc.model.diagram.edit.parts.BehaviouralDescriptionEditPart.VISUAL_ID:
			return getBehaviouralDescription_2001Text(view);
		case behavDesc.model.diagram.edit.parts.HappensEditPart.VISUAL_ID:
			return getHappens_2002Text(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003Text(view);
		case behavDesc.model.diagram.edit.parts.HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004Text(view);
		case behavDesc.model.diagram.edit.parts.AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005Text(view);
		case behavDesc.model.diagram.edit.parts.ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2006Text(view);
		case behavDesc.model.diagram.edit.parts.GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2007Text(view);
		case behavDesc.model.diagram.edit.parts.AgentEditPart.VISUAL_ID:
			return getAgent_2008Text(view);
		case behavDesc.model.diagram.edit.parts.GeneralTypeEditPart.VISUAL_ID:
			return getGeneralType_2009Text(view);
		case behavDesc.model.diagram.edit.parts.ObserverEditPart.VISUAL_ID:
			return getObserver_2010Text(view);
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
	private String getBehaviouralDescription_2001Text(View view) {
		BehaviouralDescription domainModelElement = (BehaviouralDescription) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getHappens_2002Text(View view) {
		Happens domainModelElement = (Happens) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getTime());
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getHoldsAt_2003Text(View view) {
		HoldsAt domainModelElement = (HoldsAt) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getTime());
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getHoldsAtBetween_2004Text(View view) {
		HoldsAtBetween domainModelElement = (HoldsAtBetween) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getInitialTime());
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAgentParam_2005Text(View view) {
		AgentParam domainModelElement = (AgentParam) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserverParam_2006Text(View view) {
		ObserverParam domainModelElement = (ObserverParam) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGeneralParam_2007Text(View view) {
		GeneralParam domainModelElement = (GeneralParam) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getAgent_2008Text(View view) {
		Agent domainModelElement = (Agent) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGeneralType_2009Text(View view) {
		GeneralType domainModelElement = (GeneralType) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserver_2010Text(View view) {
		Observer domainModelElement = (Observer) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.logError("No domain element for view with visualID = " + 2010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
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
		return behavDesc.model.diagram.edit.parts.EnvironmentEditPart.MODEL_ID
				.equals(behavDesc.model.diagram.part.ModelVisualIDRegistry.getModelID(view));
	}

}
