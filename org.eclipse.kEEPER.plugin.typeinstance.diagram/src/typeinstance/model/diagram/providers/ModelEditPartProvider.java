package typeinstance.model.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import typeinstance.model.diagram.edit.parts.EnvironmentEditPart;
import typeinstance.model.diagram.edit.parts.ModelEditPartFactory;
import typeinstance.model.diagram.part.ModelVisualIDRegistry;

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
