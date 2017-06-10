package contextRelation.model.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	* @generated
	*/
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		contextRelation.model.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		contextRelation.model.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		contextRelation.model.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		contextRelation.model.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		contextRelation.model.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	* @generated
	*/
	protected IPreferenceStore getPreferenceStore() {
		return contextRelation.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
