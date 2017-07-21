package hypothesis.model.diagram.navigator;

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

import hypothesis.model.diagram.edit.parts.AgentEditPart;
import hypothesis.model.diagram.edit.parts.AgentParamEditPart;
import hypothesis.model.diagram.edit.parts.EnvironmentEditPart;
import hypothesis.model.diagram.edit.parts.GeneralParamEditPart;
import hypothesis.model.diagram.edit.parts.HappensEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtBetweenEditPart;
import hypothesis.model.diagram.edit.parts.HoldsAtEditPart;
import hypothesis.model.diagram.edit.parts.HypothesisEditPart;
import hypothesis.model.diagram.edit.parts.ObserverEditPart;
import hypothesis.model.diagram.edit.parts.ObserverParamEditPart;
import hypothesis.model.diagram.part.ModelDiagramEditorPlugin;
import hypothesis.model.diagram.part.ModelVisualIDRegistry;
import hypothesis.model.diagram.providers.ModelElementTypes;
import model.Agent;
import model.AgentParam;
import model.GeneralParam;
import model.Happens;
import model.HoldsAt;
import model.HoldsAtBetween;
import model.Hypothesis;
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
		case HypothesisEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Hypothesis", //$NON-NLS-1$
					ModelElementTypes.Hypothesis_2001);
		case HappensEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Happens", //$NON-NLS-1$
					ModelElementTypes.Happens_2002);
		case HoldsAtEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?HoldsAt", //$NON-NLS-1$
					ModelElementTypes.HoldsAt_2003);
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?HoldsAtBetween", //$NON-NLS-1$
					ModelElementTypes.HoldsAtBetween_2004);
		case AgentParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?AgentParam", //$NON-NLS-1$
					ModelElementTypes.AgentParam_2005);
		case GeneralParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?GeneralParam", //$NON-NLS-1$
					ModelElementTypes.GeneralParam_2006);
		case ObserverParamEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?ObserverParam", //$NON-NLS-1$
					ModelElementTypes.ObserverParam_2007);
		case AgentEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Agent", //$NON-NLS-1$
					ModelElementTypes.Agent_2008);
		case ObserverEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?https://github.com/mlatona/minorityReportPlugin?Observer", //$NON-NLS-1$
					ModelElementTypes.Observer_2009);
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
		case HypothesisEditPart.VISUAL_ID:
			return getHypothesis_2001Text(view);
		case HappensEditPart.VISUAL_ID:
			return getHappens_2002Text(view);
		case HoldsAtEditPart.VISUAL_ID:
			return getHoldsAt_2003Text(view);
		case HoldsAtBetweenEditPart.VISUAL_ID:
			return getHoldsAtBetween_2004Text(view);
		case AgentParamEditPart.VISUAL_ID:
			return getAgentParam_2005Text(view);
		case GeneralParamEditPart.VISUAL_ID:
			return getGeneralParam_2006Text(view);
		case ObserverParamEditPart.VISUAL_ID:
			return getObserverParam_2007Text(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_2008Text(view);
		case ObserverEditPart.VISUAL_ID:
			return getObserver_2009Text(view);
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
	private String getHypothesis_2001Text(View view) {
		Hypothesis domainModelElement = (Hypothesis) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
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
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2002); //$NON-NLS-1$
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
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2003); //$NON-NLS-1$
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
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2004); //$NON-NLS-1$
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
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getGeneralParam_2006Text(View view) {
		GeneralParam domainModelElement = (GeneralParam) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserverParam_2007Text(View view) {
		ObserverParam domainModelElement = (ObserverParam) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2007); //$NON-NLS-1$
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
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getObserver_2009Text(View view) {
		Observer domainModelElement = (Observer) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ModelDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2009); //$NON-NLS-1$
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
		return EnvironmentEditPart.MODEL_ID.equals(ModelVisualIDRegistry.getModelID(view));
	}

}
