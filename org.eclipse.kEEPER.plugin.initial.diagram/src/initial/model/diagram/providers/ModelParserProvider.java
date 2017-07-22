package initial.model.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
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

import initial.model.diagram.edit.parts.WrappingLabel2EditPart;
import initial.model.diagram.edit.parts.WrappingLabel3EditPart;
import initial.model.diagram.parsers.InitiallyInstancesLabelExpressionLabelParser;
import initial.model.diagram.parsers.InitiallyNameLabelExpressionLabelParser;
import initial.model.diagram.part.ModelVisualIDRegistry;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private InitiallyNameLabelExpressionLabelParser initiallyLabel_5002Parser;

	/**
	* @generated
	*/
	private IParser getInitiallyLabel_5002Parser() {
		if (initiallyLabel_5002Parser == null) {
			initiallyLabel_5002Parser = new InitiallyNameLabelExpressionLabelParser();
		}
		return initiallyLabel_5002Parser;
	}

	/**
	* @generated
	*/
	private InitiallyInstancesLabelExpressionLabelParser initiallyLabel_5003Parser;

	/**
	* @generated
	*/
	private IParser getInitiallyLabel_5003Parser() {
		if (initiallyLabel_5003Parser == null) {
			initiallyLabel_5003Parser = new InitiallyInstancesLabelExpressionLabelParser();
		}
		return initiallyLabel_5003Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case WrappingLabel2EditPart.VISUAL_ID:
			return getInitiallyLabel_5002Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getInitiallyLabel_5003Parser();
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
