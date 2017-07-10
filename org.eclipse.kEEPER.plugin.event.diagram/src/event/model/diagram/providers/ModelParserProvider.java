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

import event.model.diagram.edit.parts.AgentReferenceTypeNameEditPart;
import event.model.diagram.edit.parts.ComplexEventNameEditPart;
import event.model.diagram.edit.parts.GeneralTypeReferenceTypeNameEditPart;
import event.model.diagram.edit.parts.ObserverReferenceTypeNameEditPart;
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
	private IParser primitiveEventName_5010Parser;

	/**
	* @generated
	*/
	private IParser getPrimitiveEventName_5010Parser() {
		if (primitiveEventName_5010Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			primitiveEventName_5010Parser = parser;
		}
		return primitiveEventName_5010Parser;
	}

	/**
	* @generated
	*/
	private IParser agentReferenceTypeName_5012Parser;

	/**
	* @generated
	*/
	private IParser getAgentReferenceTypeName_5012Parser() {
		if (agentReferenceTypeName_5012Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getAgentReference_TypeName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			agentReferenceTypeName_5012Parser = parser;
		}
		return agentReferenceTypeName_5012Parser;
	}

	/**
	* @generated
	*/
	private IParser observerReferenceTypeName_5013Parser;

	/**
	* @generated
	*/
	private IParser getObserverReferenceTypeName_5013Parser() {
		if (observerReferenceTypeName_5013Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getObserverReference_TypeName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			observerReferenceTypeName_5013Parser = parser;
		}
		return observerReferenceTypeName_5013Parser;
	}

	/**
	* @generated
	*/
	private IParser generalTypeReferenceTypeName_5014Parser;

	/**
	* @generated
	*/
	private IParser getGeneralTypeReferenceTypeName_5014Parser() {
		if (generalTypeReferenceTypeName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getGeneralTypeReference_TypeName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			generalTypeReferenceTypeName_5014Parser = parser;
		}
		return generalTypeReferenceTypeName_5014Parser;
	}

	/**
	* @generated
	*/
	private IParser complexEventName_5011Parser;

	/**
	* @generated
	*/
	private IParser getComplexEventName_5011Parser() {
		if (complexEventName_5011Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getEvent_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			complexEventName_5011Parser = parser;
		}
		return complexEventName_5011Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case PrimitiveEventNameEditPart.VISUAL_ID:
			return getPrimitiveEventName_5010Parser();
		case AgentReferenceTypeNameEditPart.VISUAL_ID:
			return getAgentReferenceTypeName_5012Parser();
		case ObserverReferenceTypeNameEditPart.VISUAL_ID:
			return getObserverReferenceTypeName_5013Parser();
		case GeneralTypeReferenceTypeNameEditPart.VISUAL_ID:
			return getGeneralTypeReferenceTypeName_5014Parser();
		case ComplexEventNameEditPart.VISUAL_ID:
			return getComplexEventName_5011Parser();
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
