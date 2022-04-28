import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * @author Kendrick Liu
 * @create 2021-01-10:08
 * start Page
 */
public class MyFrame extends JFrame {
    //Initialize label
    JLabel a1 = new ColorfulLabel("Ticket to UTBM", new Color(131,175,155));
    JLabel a2 = new JLabel("Number of Players");
    //for the selecting of player number
    JComboBox<String> options = new JComboBox<>();


    //list to store students
    ArrayList<Student> students = new ArrayList<>();

    //index of choice
    int index;



    public MyFrame(String title){
        super(title);
        //content pane
        Container root = this.getContentPane();
        LayoutManager layoutManager = new SimpleLayout();
        root.setLayout(layoutManager);
        // 2~4 player
        options.addItem("Please Choose");
        options.addItem("2");
        options.addItem("3");
        options.addItem("4");

        options.setFont(new Font("Calibri",0,20));
        options.setPreferredSize(new Dimension(500,70));

        // set front for a2
        a2.setFont(new Font("Kristen ITC",1,30));


        //add to content pane
        root.add(a1);
        root.add(a2);
        root.add(options);

        //action select
        options.addItemListener(new ItemListener() {
            //create student
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    index = options.getSelectedIndex();
//                    System.out.println(index);
                    if(index == 1){
                        students.add(new Student(1001));
                        students.add(new Student(1002));
                    }else if(index == 2){
                        students.add(new Student(1001));
                        students.add(new Student(1002));
                        students.add(new Student(1003));
                    }else if(index == 3){
                        students.add(new Student(1001));
                        students.add(new Student(1002));
                        students.add(new Student(1003));
                        students.add(new Student(1004));
                    }
                    //System.out.println(students);
                    setVisible(false);
                    MyFrame2 frame2 = new MyFrame2("Enter Name",students,index);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(1000,750);
                    frame2.setVisible(true);
                }

            }

        });

        //System.out.println(students);
    }


    // label with color
    private static class ColorfulLabel extends JLabel{
        public ColorfulLabel(String text, Color color) {
            super(text);
            setOpaque(true);
            setBackground(color);
            setPreferredSize(new Dimension(1000,100));
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(new Font("Lucida Calligraphy",1,40));  //set front for "Ticket to UTBM"
        }


    }

    //set layout
    private class SimpleLayout implements LayoutManager{

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int w = parent.getWidth();   //frame width
            int h = parent.getHeight();   //frame height


            //a1 on top
            if(a1.isVisible()){
                Dimension size = a1.getPreferredSize();
                int x = (w - size.width) / 2;
                int y = 0;


                a1.setBounds(x, y, size.width, size.height);

            }

            if(a2.isVisible()){
                Dimension size = a2.getPreferredSize();
                int x = (w - size.width) / 2;
                int y = 280;


                a2.setBounds(x, y, size.width, size.height);

            }

            //options in middle
            if(options.isVisible()){
                Dimension size = options.getPreferredSize();
                int x = (w - size.width) / 2;
                int y = (h - size.height) / 2;


                options.setBounds(x, y, size.width, size.height);

            }

        }
    }



}

