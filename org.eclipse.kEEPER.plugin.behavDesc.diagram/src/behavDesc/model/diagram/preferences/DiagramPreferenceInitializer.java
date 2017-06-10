package behavDesc.model.diagram.preferences;

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
		behavDesc.model.diagram.preferences.DiagramGeneralPreferencePage.initDefaults(store);
		behavDesc.model.diagram.preferences.DiagramAppearancePreferencePage.initDefaults(store);
		behavDesc.model.diagram.preferences.DiagramConnectionsPreferencePage.initDefaults(store);
		behavDesc.model.diagram.preferences.DiagramPrintingPreferencePage.initDefaults(store);
		behavDesc.model.diagram.preferences.DiagramRulersAndGridPreferencePage.initDefaults(store);

	}

	/**
	* @generated
	*/
	protected IPreferenceStore getPreferenceStore() {
		return behavDesc.model.diagram.part.ModelDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
