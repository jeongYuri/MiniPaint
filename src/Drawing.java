import javax.management.JMX;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JFrame {
    private JPanel contentPane;
    private Mycanvas mycanvas;
    int select;
    int x,y;
    int X,Y;
    int xx, yy;
    boolean a,c;
    Shape ss,sh,copy;
    protected ArrayList vc;
    protected Frame frame;
    protected boolean flag;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    Drawing frame = new Drawing();
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public Drawing(){
        setTitle("\uADF8\uB9BC\uD310");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,800,600);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("경로");
        setIconImage(img);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        JMenuItem mntmNewMenuItem = new JMenuItem("New");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mycanvas.clear();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);
        JMenuItem mntmNewMenuItem_6 = new JMenuItem("open");
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog Load = new FileDialog(frame, "open", FileDialog.LOAD);
                Load.setVisible(true);
                String data = Load.getDirectory() + Load.getFile();
                for (int q = 0; q < mycanvas.s.size(); ) {
                    mycanvas.s.remove(q);
                }
                Graphics g = (Graphics) mycanvas.getGraphics();
                int i = 0;
                JFileChooser jfc = new JFileChooser("경로");
                jfc.showDialog(null, "확인");
                File file = jfc.getSelectedFile();
                try {
                    FileInputStream f = new FileInputStream(file);
                    ObjectInputStream of = new ObjectInputStream(f);
                    Color c = (Color) of.readObject();
                    mycanvas.setBackground(c);
                    Shape li = (Shape) of.readObject();
                    while (li != null) {
                        mycanvas.s.add(i,li);
                        li = (Shape) of.readObject();
                    }
                    of.close();
                } catch (IOException e1) {
                    for (int a = 0; a < mycanvas.s.size(); a++) {
                        mycanvas.paint(g);
                    }
                    return;
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem_6);
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog save = new FileDialog(frame,"저장",FileDialog.SAVE);
                if(flag==false){
                    save.setVisible(true);
                    try{
                        String resultStr;
                        resultStr = JOptionPane.showInputDialog(null,"저장할 파일의 이름을 지정하세요.\r\n","저장",JOptionPane.INFORMATION_MESSAGE);
                        String a = resultStr;
                        FileOutputStream f = new FileOutputStream(a);
                        ObjectOutputStream of = new ObjectOutputStream(f);
                        Color c = mycanvas.getBackground();
                        of.writeObject(c);
                        for(int i=0;i<mycanvas.s.size();i++){
                            Shape s = mycanvas.s.get(i);
                            of.writeObject(s);
                        }
                        of.close();
                    }catch (IOException e1){
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);
        JMenuItem mntmNewMenuuItem_2 = new JMenuItem("Delete");
        mntmNewMenuuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnNewMenu.add(mntmNewMenuuItem_2);
        JMenu mnNewMenu_1 = new JMenu("Edit");
        menuBar.add(mnNewMenu_1);
        JMenuItem mnNewMenuItem_3 = new JMenuItem("copy");
        mnNewMenuItem_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select =5;
                c=true;
            }
        });
        mnNewMenu_1.add(mnNewMenuItem_3);
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("paste");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select =6;
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_4);
        JMenu mnNewMenu_2 = new JMenu("Help");
        menuBar.add(mnNewMenu_2);
        JMenuItem mntmNewItem_5 = new JMenuItem("Information");
        mntmNewItem_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        mnNewMenu_2.add(mntmNewItem_5);
        contentPane= new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(new LineBorder((new Color(0,0,0))));
        panel.setForeground(Color.white);
        contentPane.add(panel,BorderLayout.WEST);
        Box verticalBox = Box.createVerticalBox();
        panel.add(verticalBox);
        JButton btnNewButton = new JButton("");
        btnNewButton.addMouseListener(new MouseAdapter() {
        });
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               select =1;}
        });
        btnNewButton.setIcon(new ImageIcon("이미지 경로"));
        verticalBox.add(btnNewButton);
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select =2;
            }
        });
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        });
        btnNewButton_1.setIcon(new ImageIcon("경로"));
        verticalBox.add(btnNewButton_1);
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setIcon(new ImageIcon("경로"));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select =4;
            }
        });
        verticalBox.add(btnNewButton_4);
        JButton btnNewButton_3 = new JButton("\r\n");
        btnNewButton_3.setIcon(new ImageIcon("경로"));
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                select =3;
            }
        });
        verticalBox.add(btnNewButton_3);

        mycanvas = new Mycanvas();
        mycanvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = mycanvas.getGraphics();
                g.setXORMode(Color.WHITE);
                if (select == 2) {
                    g.drawRect(x, y, e.getX() - x, e.getY() - y);
                    g.drawRect(x, y, X - x, Y - y);
                } else if (select == 1) {
                    g.drawOval(x, y, e.getX() - x, e.getY() - y);
                    g.drawOval(x, y, X - x, Y - y);
                } else if (select == 3) {
                    if (a) {
                        x = e.getX() - xx;
                        y = e.getY() - yy;
                        ss.moveTo(x, y);
                        repaint();

                    } else if (select == 4) {
                        g.drawLine(x, y, X, Y);
                        g.drawLine(x, y, X, Y);
                    }
                }
                X = e.getX();
                Y = e.getY();
            }

        });
        mycanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(select ==5){
                copy = mycanvas.select(x,y);
            }else if(select ==6){
                if(copy.pick ==1){
                    mycanvas.add(new Circle(e.getX(),e.getY(),copy.X,copy.Y));
                }else if(copy.pick==2){
                    mycanvas.add(new Rect(e.getX(),e.getY(),copy.X,copy.Y));
                }
            }}
            @Override
            public void mousePressed(MouseEvent e){
                x=X=e.getX();
                y=Y=e.getY();
                if (select==3){
                    ss = mycanvas.select(x,y);
                    if(ss!=null){
                        xx = e.getX()-ss.x;
                        yy = e.getY()-ss.y;
                        a= true;
                    }
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                int X,Y;
                X = e.getX();
                Y = e.getY();
                if (select ==2){
                    mycanvas.add(new Rect(x,y,X-x,Y-y));
                }else if(select ==1){
                    mycanvas.add(new Circle(x,y,X-x,Y-y));
                }else if(select ==3){
                    a=false;
                }else if(select ==4){
                    mycanvas.add(new Line(x,y,X,Y));
                }
            }
        });
        contentPane.add(mycanvas,BorderLayout.CENTER);
    }public Mycanvas getMycanvas(){
        return mycanvas;
    }
}
