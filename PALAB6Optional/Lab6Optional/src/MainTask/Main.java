package MainTask;

import ToDo.ConfigPanel;
import ToDo.ControlPanel;
import ToDo.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public ConfigPanel configPanel;
    public ControlPanel controlPanel;
    public DrawingPanel drawingPanel;

    public Main() {
        super("My Window");
        init();
    }
    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(drawingPanel,BorderLayout.CENTER);
        this.setSize(900,200);
       /* pack();*/
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }

}
