package editor.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import editor.view.ControlPanel;

import java.awt.Color;


public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8877948025931264431L;

	public MainWindow() {
		super("CSV EDITOR");

		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBackground(new Color(244, 164, 96));
		this.setLocation(500, 5); //posicion donde aparece el main window al ejecutar el programa
		
		setContentPane(mainPanel);
		
		//ContentPanel
		JPanel contentPanel = new JPanel();
    	contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		this.setMinimumSize(new Dimension(300, 300));
		
		Label label = new Label("CSV EDITOR WITH A SPECIFIC FORMAT");
		label.setBackground(new Color(218, 112, 214));
		label.setAlignment(Label.CENTER);
		this.add(label, BorderLayout.CENTER);
		
		//Control Panel
		ControlPanel controlPanel = new ControlPanel(); //toolbar
		controlPanel.setPreferredSize(new Dimension(700, 50)); //tamaño del control panel
		this.add(controlPanel, BorderLayout.PAGE_START);


		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				new MainWindow();
			}
		});
	}
	
}
