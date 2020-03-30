package ToDo;

import MainTask.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final Main frame;
    private Graphics2D graphics2D;
    String [] colours = {"red","yellow","green","blue","pink","red","yellow","green","blue","pink"};
    int sides = 4;
    private int size;
    private String NameOfShape = "Polygon";
    final static int W = 800, H = 600;
    BufferedImage image;
    private List<Shapes> shapes = new ArrayList<>();

    public DrawingPanel(Main frame){
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    public int getSides () {
        return this.sides;
    }
    public void setSides(int sides) {
        if (sides != 0){
            this.sides = sides;
        }
        System.out.println("Number of sides : " + sides );
    }
    public void setNameOfShape(String nameOfShape){
        this.NameOfShape = nameOfShape;
    }
    public void setSize (int size) {
        this.size = size;
    }
    private  void createOffscreenImage ()
    {
        image = new BufferedImage(W , H , BufferedImage.TYPE_INT_ARGB);
        graphics2D = image.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
    private void drawShape( int x , int y){
        Random random = new Random();
        int RandomColor = random.nextInt(9);
        Color cul = new Color(255);

        switch (colours[RandomColor].toLowerCase()){
            case "red" : cul = Color.RED; break;
            case "yellow" : cul = Color.YELLOW; break;
            case "green" : cul = Color.GREEN; break;
            case "blue" : cul = Color.BLUE; break;
            case "pink" : cul = Color.pink; break;
        }
        graphics2D.setColor(cul);
        if (NameOfShape.equals("Polygon")) {
            RegularPolygon regularPolygon = new RegularPolygon(x,y,size,getSides());
            shapes.add(regularPolygon);
            graphics2D.fill(regularPolygon);

        }
        else if (NameOfShape.equals("Sfera")) {
            NodeShape nodeShape = new NodeShape(x,y,size);
            shapes.add(nodeShape);
            graphics2D.fill(nodeShape);
        }
    }
    public void load() {
        try {
            image = ImageIO.read(new File("E:/Desktop/test.png"));
            repaint();
        }catch (Exception e) {
            System.err.println(e);
        }
    }
    public void LoadFile(){
        JFileChooser fc= new JFileChooser();
        int i=fc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f=fc.getSelectedFile();
            String filepath=f.getPath();
            try {
                image = ImageIO.read(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            revalidate();
            repaint();
        }
    }
    public void SaveFile () {
        JFileChooser fc= new JFileChooser();
        int i=fc.showSaveDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(image,"PNG" , fc.getSelectedFile());
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image ,0,0,this);
    }
    @Override
    public void update(Graphics g) {
        createOffscreenImage();
        repaint();
    }
}
