package presentation.userPanel.Repository;

import javax.swing.JPanel;

import presentation.components.PanelContent;

public class RepositoryStorage {
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	private PanelContent panel = new PanelContent("入库");
	
	public RepositoryStorage() {
		init();
	}
	
	private void init() {
		panel.setLayout(null);
		panel.add(pbp.getPanel());
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
