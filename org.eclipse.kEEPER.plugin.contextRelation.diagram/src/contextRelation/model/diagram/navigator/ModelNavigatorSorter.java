package contextRelation.model.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof contextRelation.model.diagram.navigator.ModelNavigatorItem) {
			contextRelation.model.diagram.navigator.ModelNavigatorItem item = (contextRelation.model.diagram.navigator.ModelNavigatorItem) element;
			return contextRelation.model.diagram.part.ModelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
