package typeinstance.model.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import model.ModelPackage;
import typeinstance.model.diagram.edit.parts.AgentNameEditPart;
import typeinstance.model.diagram.edit.parts.GeneralTypeNameEditPart;
import typeinstance.model.diagram.edit.parts.ObserverNameEditPart;
import typeinstance.model.diagram.edit.parts.WrappingLabelEditPart;
import typeinstance.model.diagram.parsers.MessageFormatParser;
import typeinstance.model.diagram.part.ModelVisualIDRegistry;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser instanceName_5003Parser;

	/**
	* @generated
	*/
	private IParser getInstanceName_5003Parser() {
		if (instanceName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getInstance_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			instanceName_5003Parser = parser;
		}
		return instanceName_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser generalTypeName_5014Parser;

	/**
	* @generated
	*/
	private IParser getGeneralTypeName_5014Parser() {
		if (generalTypeName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getType_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			generalTypeName_5014Parser = parser;
		}
		return generalTypeName_5014Parser;
	}

	/**
	* @generated
	*/
	private IParser agentName_5010Parser;

	/**
	* @generated
	*/
	private IParser getAgentName_5010Parser() {
		if (agentName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getType_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			agentName_5010Parser = parser;
		}
		return agentName_5010Parser;
	}

	/**
	* @generated
	*/
	private IParser observerName_5012Parser;

	/**
	* @generated
	*/
	private IParser getObserverName_5012Parser() {
		if (observerName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getType_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			observerName_5012Parser = parser;
		}
		return observerName_5012Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabelEditPart.VISUAL_ID:
			return getInstanceName_5003Parser();
		case GeneralTypeNameEditPart.VISUAL_ID:
			return getGeneralTypeName_5014Parser();
		case AgentNameEditPart.VISUAL_ID:
			return getAgentName_5010Parser();
		case ObserverNameEditPart.VISUAL_ID:
			return getObserverName_5012Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ModelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ModelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ModelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
