import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Problem05 extends JFrame {

    ArrayList<Shape> shapes = new ArrayList<Shape>();
    Problem05(){
        setTitle("Graph Editor");
        setLocationRelativeTo(null);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        var mJPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (var t : shapes) {
                    if(Shape.SelectedShape == t){
                        t.draw(g);
                    }
                    t.fill(g);
                }
            }
        };
        var sJPanel = new JPanel();
        mJPanel.setBackground( Color.WHITE);
        add(mJPanel,BorderLayout.CENTER);
        add(sJPanel,BorderLayout.SOUTH);

        Random rand = new Random();
        JButton rectButton = new JButton();
        rectButton.setText("Rect");
        rectButton.addActionListener(e->{shapes.add(new Rectangle(rand.nextInt(100, mJPanel.getWidth()-100),rand.nextInt(100, mJPanel.getHeight()-100),rand.nextInt(1,100),rand.nextInt(1,100)));mJPanel.repaint(); mJPanel.setFocusable(true);});
        JButton circleButton = new JButton();
        circleButton.addActionListener(e->{shapes.add(new Circle(rand.nextInt(100,mJPanel.getWidth()-100),rand.nextInt(100,mJPanel.getHeight()-100),rand.nextInt(1,100)));mJPanel.repaint(); mJPanel.setFocusable(true);});
        circleButton.setText("Circle");
        JButton crossButton = new JButton();
        crossButton.addActionListener(e->{
            int x = rand.nextInt(100,mJPanel.getWidth()-100);
            int y = rand.nextInt(100,mJPanel.getHeight()-100);
            int nWidth = rand.nextInt(1,100);
            int nHeight = rand.nextInt(1,100);
            int fX = rand.nextInt(0,x);
            int fY = rand.nextInt(0,y);
            int fWidth = rand.nextInt(x-fX+1,x-fX+101);
            int fHeight = rand.nextInt(y+1-fY,y-fY+101);
            var first = new Rectangle(x,y,nWidth,nHeight);
            var second = new Rectangle(fX,fY,fWidth,fHeight);
            shapes.add(new Cross(x,y,Math.min(fX+fWidth-x,first.getWidth()),Math.min(fY+fHeight-y,first.getHeight()),first,second));
            repaint();
            mJPanel.setFocusable(true);
        });
        crossButton.setText("Cross");

        sJPanel.add(rectButton);
        sJPanel.add(circleButton);
        sJPanel.add(crossButton);

        mJPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    for(var shape : shapes){
                        if(shape.contains(e.getX(),e.getY())){
                            Shape.SelectedShape = shape;
                            mJPanel.setFocusable(true);
                            repaint();
                            break;
                        }
                    }
                }
                else{
                    for(var shape : shapes){
                        if(shape.contains(e.getX(),e.getY())){
                            Shape.SelectedShape = shape;
                            JFrame msg = new JFrame();
                            JOptionPane.showMessageDialog(msg,shape);
                            mJPanel.setFocusable(true);

                            repaint();
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        mJPanel.addMouseMotionListener(new MouseMotionAdapter(){
                @Override
                public void mouseDragged(MouseEvent e) {

                    if(Shape.SelectedShape!=null){
                        Shape.SelectedShape.moveShape(e.getX(),e.getY(),mJPanel.getWidth(),mJPanel.getHeight());
                        mJPanel.setFocusable(true);
                        repaint();
                    }

                }
            }
        );

        mJPanel.setFocusable(true);
        rectButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==KeyEvent.VK_DELETE && Shape.SelectedShape != null){
                    super.keyPressed(e);
                    shapes.remove(Shape.SelectedShape);
                    Shape.SelectedShape = null;
                    repaint();
                }
            }
        });
        circleButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==KeyEvent.VK_DELETE && Shape.SelectedShape != null){
                    super.keyPressed(e);
                    shapes.remove(Shape.SelectedShape);
                    Shape.SelectedShape = null;
                    repaint();
                }
            }
        });
        crossButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if(e.getKeyCode()==KeyEvent.VK_DELETE && Shape.SelectedShape != null){
                    super.keyPressed(e);
                    shapes.remove(Shape.SelectedShape);
                    Shape.SelectedShape = null;
                    repaint();
                }
            }
        });



        setVisible(true);

    }

    public static void main(String args[]){
        Problem05 curr  = new Problem05();
    }
}
