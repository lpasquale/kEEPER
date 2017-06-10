package behavDesc.model.diagram.providers;

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
		ElementInitializers cached = behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
