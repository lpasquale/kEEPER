package contextRelation.model.diagram.providers;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	* @generated
	*/
	public static ElementInitializers getInstance() {
		ElementInitializers cached = contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
