package ToDo;

import MainTask.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ConfigPanel extends JPanel {
    final Main frame;
    private  int contor = 0;
    JComboBox jComboBox = new JComboBox();
    JButton jButton = new JButton();
    JSpinner jSpinner = new JSpinner();
    JLabel jLabel = new JLabel();
    JLabel jLabelSides = null;
    JSpinner jSpinnerSides = null;
    JMenuBar jMenuBar = null;
    JMenuItem jMenuItem = null;
    JMenuItem jMenuItem1 = null;
    JMenu file = null;

    public ConfigPanel (Main frame){
        this.frame = frame;
        init();
    }
    private void init () {

        jMenuBar = new JMenuBar();
        add(jMenuBar);

        file=new JMenu("File");
        jMenuBar.add(file);

        jMenuItem = new JMenuItem("Load File");
        jMenuItem1 = new JMenuItem("Save File");
        file.add(jMenuItem);
        file.add(jMenuItem1);
        jMenuItem.addActionListener(this::LoadFile);
        jMenuItem1.addActionListener(this::SaveFile);

        jLabel = new JLabel("Dimension for allShapesTypes");
        String ShapeType [] = {"Polygon" , "Sfera"};
        jComboBox = new JComboBox(ShapeType);
        jButton = new JButton("Make changing");
        jButton.addActionListener(this::Changing);
        jSpinner = new JSpinner(new SpinnerNumberModel(20,10,110,5));

        add(jComboBox);
        add(jLabel);
        add(jSpinner);
        add(jButton);
    }
    private void Changing(ActionEvent event) {
        String polygon = new String("Polygon");
        String Sfera = new String("Sfera");
        if (frame.configPanel.jComboBox.getSelectedItem().toString().equals(polygon) && contor==0){
            frame.drawingPanel.setNameOfShape(frame.configPanel.jComboBox.getSelectedItem().toString());
            contor = 1;
            jLabelSides = new JLabel("Number of sides");
            jSpinnerSides = new JSpinner(new SpinnerNumberModel(0,0,100,1));
           /* frame.drawingPanel.setSides((int)jSpinnerSides.getValue());*/

            add(jLabelSides);
            add(jSpinnerSides);

            revalidate();
            repaint();
        }
        if (frame.configPanel.jComboBox.getSelectedItem().toString().equals(Sfera) && contor==1){
            frame.drawingPanel.setNameOfShape(frame.configPanel.jComboBox.getSelectedItem().toString());
            contor = 0;
            remove(jLabelSides);
            remove(jSpinnerSides);

            revalidate();
            repaint();
        }
        frame.drawingPanel.setSides((int)jSpinnerSides.getValue());
        int value =(Integer) frame.configPanel.jSpinner.getValue();
        frame.drawingPanel.setSize(value);
    }
    public void LoadFile (ActionEvent event) {
        frame.drawingPanel.LoadFile();
    }
    public void SaveFile (ActionEvent event) {
        frame.drawingPanel.SaveFile();
    }
}
