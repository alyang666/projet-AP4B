import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author YANG_Anlu
 * @create 2021-01-23:15
 * choose action page
 */

public class Main extends JFrame implements ActionListener  {
    JFrame f;
    JLabel jlb;
    JButton jbutton, jbutton2, jbutton3;
    ArrayList<Student> students = new ArrayList<>();
    int index;
    int round = 0;

    public Main(String title, ArrayList<Student> students, int i) {
        super(title);
        this.students = students;
        index = i;
//        System.out.println(index);
        System.out.println(students);


        //set frame
        f = new JFrame();
        f.setTitle("Choose your action");
        f.setSize(1000, 750);
        f.setLocation(0, 0);
        Container root = f.getContentPane();

        //set layout
        LayoutManager layoutManager = new SimpleLayout();
        root.setLayout(layoutManager);

        jlb = new JLabel("Choose one of the following three options:");    //Title
        jlb.setFont(new Font("Times New Roman",1,25));
        f.add(jlb);

        /*Creation of three choices*/
        jbutton = new JButton("Finish the coures");
        jbutton2 = new JButton("Get class card");
        jbutton3 = new JButton("Get destination card");
        f.add(jbutton);
        f.add(jbutton2);
        f.add(jbutton3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        /*Setup ActionListener of three choices(buttons)*/
        jbutton.addActionListener(this);
        jbutton.setActionCommand("1");
        jbutton2.addActionListener(this);
        jbutton2.setActionCommand("2");
        jbutton3.addActionListener(this);
        jbutton3.setActionCommand("3");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1")) {         //Finish the coures

        }
        else if (e.getActionCommand().equals("2")) {    //class card

        }
        else if (e.getActionCommand().equals("3")) {    //destination card
            round++;
//            System.out.println(round);
//            System.out.println(index);
            int studentNumber = round % (index + 1);              //to indicate which student is choosing
            if(studentNumber == 0){
                studentNumber = index + 1;
            }
//            System.out.println(studentNumber);
            DestinationCard destination_card = new DestinationCard("Destination Card", students, studentNumber);


            if(round > 4){
                f.setVisible(false);
                destination_card.setVisible(false);
                CalScore calScore = new CalScore("Game Over",students,index);
                calScore.setVisible(true);
            }
        }

    }


    /*Set the position of button and label*/
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

            /*The title of this link at the top of windows */
            if(jlb.isVisible()){
                Dimension size = jlb.getPreferredSize();

                int x = (w - size.width) / 2;
                int y =  h/5;
                jlb.setBounds(x, y, size.width, size.height);
            }

            /*First choice :  choose and finish a course*/
            if(jbutton.isVisible()){
                Dimension size = jbutton.getPreferredSize();
                size.width *= 3;
                int x = (w - size.width) / 2;
                int y = (2 * h)/5;
                jbutton.setBounds(x, y, size.width, size.height);
            }

            /*Second choice : draw the class card*/
            if(jbutton2.isVisible()){
                Dimension size = jbutton2.getPreferredSize();
                size.width *= 3;
                int x = (w - size.width) / 2;
                int y = (3 * h)/5;
                jbutton2.setBounds(x, y, size.width, size.height);
            }

           /*Third choice : choose a destination card*/
            if(jbutton3.isVisible()){
                Dimension size = jbutton3.getPreferredSize();
                size.width *= 3;
                int x = (w - size.width) / 2;
                int y = (4 * h)/5;
                jbutton3.setBounds(x, y, size.width, size.height);
            }
        }
    }
}



