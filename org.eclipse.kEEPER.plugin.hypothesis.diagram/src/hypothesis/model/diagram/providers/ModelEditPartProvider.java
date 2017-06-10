package hypothesis.model.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import hypothesis.model.diagram.edit.parts.EnvironmentEditPart;
import hypothesis.model.diagram.edit.parts.ModelEditPartFactory;
import hypothesis.model.diagram.part.ModelVisualIDRegistry;

/**
 * @generated
 */
public class ModelEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public ModelEditPartProvider() {
		super(new ModelEditPartFactory(), ModelVisualIDRegistry.TYPED_INSTANCE, EnvironmentEditPart.MODEL_ID);
	}

}
