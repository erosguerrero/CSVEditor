package editor.view;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class ControlPanel extends JPanel{
        

    /**
     * 
     */
    private static final long serialVersionUID = -8270084646397289800L;

    private boolean _stopped; //Parado
    private JButton open, exit, physics, stop, run,bang;//Botones
    private JToolBar toolbar;
    private JSpinner spinner, bangspinner;
    private JTextField deltaField;

    public ControlPanel() { //Constructor
        _stopped = true;
        initGUI();
    }
    
  
    private void initGUI( ) {
        // TODO build the tool bar by adding buttons, etc.
        this.setLayout(new BorderLayout());
        toolbar = new JToolBar();
        this.add(toolbar,BorderLayout.PAGE_START);
        //Creación de botones;
        
        //OPEN
        open = new JButton();
        open.setToolTipText("Open button");
        open.setBounds (20, 20, 5, 5);
        open.setIcon(loadImage("resources/icons/open.png"));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //PREGUNTAR
            	OpenFun();
            }
        });
        
        toolbar.add(open);
        toolbar.addSeparator();
  
       





      
       
      
        
       
        
        
    
        
        //EXIT
        exit = new JButton();
        exit.setToolTipText("exit button");
        exit.setBounds (20, 20, 5, 5);
        exit.setIcon(loadImage("resources/icons/exit.png"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ExitFun();
            }
        });
        toolbar.add(exit);
       
        //JSPINNER
       
        this.setSize(200, 100);
        this.setVisible(true);
    }
    

    
    protected Icon loadImage(String string) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(string));
	}

    private void OpenFun() {
        
        // Botón OPEN
        JFileChooser FileFinder = new JFileChooser("./resources/examples");
        //accion de abrir
        int Value = FileFinder.showOpenDialog(FileFinder);
        if (Value == JFileChooser.APPROVE_OPTION) {
            String path = FileFinder.getSelectedFile().getAbsolutePath();
                    try {
                        File f = new File(path);
                        InputStream in = new FileInputStream(f);
                      //  _ctrl.loadBodies(new FileInputStream(f));
                        
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
        }
    }
    
    private void ExitFun() {
    	  //PREGUNTAR
        int opt = JOptionPane.showConfirmDialog(null, "Are sure you want to quit?");
        if (opt == 0) System.exit(0);
    }
    


    
    
    
    
    private void EnableAllButtons() {
    	exit.setEnabled(true);
    	open.setEnabled(true);
    	physics.setEnabled(true);
    	run.setEnabled(true);
    	stop.setEnabled(true);
        deltaField.setEnabled(true);
        spinner.setEnabled(true);
        bang.setEnabled(true);
    }
    
    
    private void run_sim(int n) {
        if ( n>0 && !_stopped ) {
            try {
            } catch (Exception e) {
                // TODO show the error in a dialog box
            	JOptionPane.showMessageDialog(null, "Error");
                // TODO enable all buttons
            	EnableAllButtons();
                _stopped = true;
                return;
            }

            SwingUtilities.invokeLater( new Runnable() {
                @Override
                public void run() {
                    run_sim(n-1);
                }
            });
        } else {
            _stopped = true;
            //TODO enable all buttons
            EnableAllButtons();
        }
    }
    
    
  



}
