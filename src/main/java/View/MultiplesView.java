package main.java.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import main.java.Adapter.HeartAdapter;
import main.java.Adapter.SccAdapter;
import main.java.Class.BeatBar;
import main.java.Controller.BeatController;
import main.java.Controller.ControllerInterface;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;
import main.java.Model.HeartModel;
import main.java.Model.SccModel;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class MultiplesView extends DJView {
	private final JComboBox cmbEleccion = new JComboBox();
    private final MultiplesView estaView = this;
    JMenuBar strategy;
    JMenu modelo;
    JMenuItem beat;
    JMenuItem heart;
    JMenuItem scc;
    
    

    public MultiplesView(ControllerInterface controller, BeatModelInterface model) {
        super(controller, model);
    }
    public MultiplesView(){
    	super();
    }

    public void createView() 
    {
    	
    	strategy = new JMenuBar();
		modelo = new JMenu("Modelo");
		beat = new JMenuItem("Beat");
		heart= new JMenuItem("Heart");
		scc = new JMenuItem("Scc");
		
		
	       // viewFrame.add(strategy);
	        strategy.add(modelo);
	        modelo.add(beat);
	        modelo.add(heart);
	        modelo.add(scc);
    	
    	
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("Vista");
        viewFrame.setJMenuBar(strategy);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("Apagado", SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(3, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        
        
        beat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	BeatModel beat = new BeatModel();
                BeatController beatController = new BeatController(beat, estaView);
                setController(beatController);
                setModel(beat);
            }
        });

        heart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	HeartController heartController = new HeartController(estaView);
                setController(heartController);
                setModel(new HeartAdapter(HeartModel.getInstancia()));
            }
        });
        
        scc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	SccModel scc = new SccModel();
                SccController carController = new SccController(scc, estaView);
                setController(carController);
                setModel((new SccAdapter(scc)));
            }
        });
        
        
        
       /* cmbEleccion.setModel(new DefaultComboBoxModel(new String[]{"Seleccionar", "HeartModel", "BeatModel", "SccModel"}));
        cmbEleccion.setSelectedIndex(0);
        cmbEleccion.setToolTipText("");
        cmbEleccion.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e) 
            {
                if (e.getStateChange() == ItemEvent.SELECTED) 
                {
                    if (controller != null) 
                            controller.stop();
                    switch (e.getItem().toString())
                    {
                        case "HeartModel":
                        	HeartController heartController = new HeartController(estaView);
                            setController(heartController);
                            setModel(new HeartAdapter(HeartModel.getInstancia()));
                            break;
                        case "BeatModel":
                        	BeatModel beat = new BeatModel();
                            BeatController beatController = new BeatController(beat, estaView);
                            setController(beatController);
                            setModel(beat);
                            break;
                        case "SccModel":
                        	SccModel scc = new SccModel();
                            SccController carController = new SccController(scc, estaView);
                            setController(carController);
                            setModel((new SccAdapter(scc)));
                            break;
                    }
                }
            }
        });*/
        //bpmPanel.add(cmbEleccion);
    }

    public void setModel(BeatModelInterface model) 
    {
        this.model = model;
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    public void setController(ControllerInterface controller) 
    {
        this.controller = controller;
    }
}