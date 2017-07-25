package initial.model.diagram.providers;

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

import initial.model.diagram.edit.parts.ContextRelationEditPart;
import initial.model.diagram.edit.parts.ContextRelationNameEditPart;
import initial.model.diagram.edit.parts.InstanceEditPart;
import initial.model.diagram.edit.parts.InstanceNameEditPart;
import initial.model.diagram.parsers.InitiallyLabelExpressionLabelParser;
import initial.model.diagram.parsers.InstanceExpressionLabelParser;
import initial.model.diagram.parsers.MessageFormatParser;
import initial.model.diagram.part.ModelVisualIDRegistry;
import model.ModelPackage;

/**
 * @generated
 */
public class ModelParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser contextRelation_3003Parser;

	/**
	* @generated
	*/
	private IParser getContextRelation_3003Parser() {
		if (contextRelation_3003Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getContextRelation_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			contextRelation_3003Parser = parser;
		}
		return contextRelation_3003Parser;
	}

	/**
	* @generated
	*/
	private IParser instance_3002Parser;

	/**
	* @generated
	*/
	private IParser getInstance_3002Parser() {
		if (instance_3002Parser == null) {
			EAttribute[] features = new EAttribute[] { ModelPackage.eINSTANCE.getInstance_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			instance_3002Parser = parser;
		}
		return instance_3002Parser;
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ContextRelationEditPart.VISUAL_ID:
			return getContextRelation_3003Parser();
		case InstanceEditPart.VISUAL_ID:
			return getInstance_3002Parser();
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
