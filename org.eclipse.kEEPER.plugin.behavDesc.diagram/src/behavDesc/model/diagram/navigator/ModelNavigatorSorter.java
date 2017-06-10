package behavDesc.model.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class ModelNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 2006;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof behavDesc.model.diagram.navigator.ModelNavigatorItem) {
			behavDesc.model.diagram.navigator.ModelNavigatorItem item = (behavDesc.model.diagram.navigator.ModelNavigatorItem) element;
			return behavDesc.model.diagram.part.ModelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
