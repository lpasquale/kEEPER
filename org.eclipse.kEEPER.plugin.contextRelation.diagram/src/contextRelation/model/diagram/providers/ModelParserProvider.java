package contextRelation.model.diagram.providers;

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

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser contextRelationName_5002Parser;

	/**
	* @generated
	*/
	private IParser getContextRelationName_5002Parser() {
		if (contextRelationName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getContextRelation_Name() };
			contextRelation.model.diagram.parsers.MessageFormatParser parser = new contextRelation.model.diagram.parsers.MessageFormatParser(
					features);
			contextRelationName_5002Parser = parser;
		}
		return contextRelationName_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser contextRelationTypeNames_5003Parser;

	/**
	* @generated
	*/
	private IParser getContextRelationTypeNames_5003Parser() {
		if (contextRelationTypeNames_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getContextRelation_TypeNames() };
			contextRelation.model.diagram.parsers.MessageFormatParser parser = new contextRelation.model.diagram.parsers.MessageFormatParser(
					features);
			contextRelationTypeNames_5003Parser = parser;
		}
		return contextRelationTypeNames_5003Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case contextRelation.model.diagram.edit.parts.ContextRelationName2EditPart.VISUAL_ID:
			return getContextRelationName_5002Parser();
		case contextRelation.model.diagram.edit.parts.ContextRelationTypeNamesEditPart.VISUAL_ID:
			return getContextRelationTypeNames_5003Parser();
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
			return getParser(contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (contextRelation.model.diagram.providers.ModelElementTypes.getElement(hint) == null) {
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
