package event.model.diagram.providers;

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

import event.model.diagram.edit.parts.AgentNameEditPart;
import event.model.diagram.edit.parts.ComplexEventNameEditPart;
import event.model.diagram.edit.parts.ObserverNameEditPart;
import event.model.diagram.edit.parts.ParameterNameEditPart;
import event.model.diagram.edit.parts.PrimitiveEventNameEditPart;
import event.model.diagram.parsers.MessageFormatParser;
import event.model.diagram.part.ModelVisualIDRegistry;
import model.ModelPackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser primitiveEventName_5003Parser;

	/**
	* @generated
	*/
	private IParser getPrimitiveEventName_5003Parser() {
		if (primitiveEventName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveEventName_5003Parser = parser;
		}
		return primitiveEventName_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser agentName_5005Parser;

	/**
	* @generated
	*/
	private IParser getAgentName_5005Parser() {
		if (agentName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			agentName_5005Parser = parser;
		}
		return agentName_5005Parser;
	}

	/**
	* @generated
	*/
	private IParser observerName_5008Parser;

	/**
	* @generated
	*/
	private IParser getObserverName_5008Parser() {
		if (observerName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			observerName_5008Parser = parser;
		}
		return observerName_5008Parser;
	}

	/**
	* @generated
	*/
	private IParser parameterName_5007Parser;

	/**
	* @generated
	*/
	private IParser getParameterName_5007Parser() {
		if (parameterName_5007Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getParameter_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parameterName_5007Parser = parser;
		}
		return parameterName_5007Parser;
	}

	/**
	* @generated
	*/
	private IParser complexEventName_5009Parser;

	/**
	* @generated
	*/
	private IParser getComplexEventName_5009Parser() {
		if (complexEventName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			complexEventName_5009Parser = parser;
		}
		return complexEventName_5009Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PrimitiveEventNameEditPart.VISUAL_ID:
			return getPrimitiveEventName_5003Parser();
		case AgentNameEditPart.VISUAL_ID:
			return getAgentName_5005Parser();
		case ObserverNameEditPart.VISUAL_ID:
			return getObserverName_5008Parser();
		case ParameterNameEditPart.VISUAL_ID:
			return getParameterName_5007Parser();
		case ComplexEventNameEditPart.VISUAL_ID:
			return getComplexEventName_5009Parser();
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
