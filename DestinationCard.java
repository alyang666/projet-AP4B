import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author YANG Anlu
 * @create 2021-01-19:07
 */
public class DestinationCard extends JFrame implements ActionListener {


    private int award;
    private boolean accomplished;
    JFrame fd ;
    JTextField jtfd ;
    JButton jbuttond ;
    JButton jbuttond2 ;
    int studentNumber;
    ArrayList<Student> students = new ArrayList<>();

    public DestinationCard(String title, ArrayList<Student> students, int i) {
        super(title);
        this.students = students;
        studentNumber = i - 1;
//        System.out.println(studentNumber);
       if(detect())                //If the route isn't occupied, then display the card
       {
           fd = new JFrame();
           fd.setTitle("DestinationCard");
           fd.setSize(800, 500);
           fd.setLocation(0, 0);
           Container root = fd.getContentPane();
           LayoutManager layoutManager = new SimpleLayout();
           root.setLayout(layoutManager);

           jtfd = new JTextField(80);

           /*Description of the card*/
           jtfd.setText("  Obiectif: Connection between+Route.getUVA()+ and + Route.getuvB() +Award:  + getAward()  + Accomplished:+getAccomplished()");
           jtfd.setFont(new Font("Times New Roman", 1, 15));
           fd.add(jtfd);

           jbuttond = new JButton("Choose");         //Choose this destination card
           jbuttond2 = new JButton("Next/Cancel");   //Display next card
           fd.add(jbuttond);
           fd.add(jbuttond2);

           fd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           fd.setVisible(true);

           /*Set up the ActionListener*/
           jbuttond.addActionListener(this);
           jbuttond.setActionCommand("1");
           jbuttond2.addActionListener(this);
           jbuttond2.setActionCommand("2");
       }
    }
    public int getAward(){           //The award of the card = double length of the route
        int a = 0;
        //a = Route.getlength();
        award = a * 2;
        return award;
    }

    public void setAccomplished() {
        accomplished = true;
    }

    public boolean getAccomplished(){
        return  accomplished;
    }

    public boolean detect(){           //Detect if the route is occupied
       /* if(Route.isFerry()==true)
            return true;
          else
            return false;*/
        return true;
    }


    @Override
    public String toString() {
        return "DestinationCard{" +
                "award=" + award +
                ", accomplished=" + accomplished +
                '}';
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("1")) {   //点击choose选项，选择这张卡则将该卡片添加至玩家手中（student里 add操作）
//            System.out.println(studentNumber);
            students.get(studentNumber).cardList1.add(this);
            System.out.println(students.get(studentNumber).getName()+
                    " : Your Desctination Card List:" + students.get(studentNumber).cardList1);
            fd.setVisible(false);
//            if(students.get(0).cardList1.size() >= 0){   // number of Class Card for any one of players < 2, one more round
//                fd.setVisible(false);                    //then end
//            }

        }/*
        else if(e.getActionCommand().equals("2")){   //点击Next/Cancel,显示下一张destination卡，如果已经是第三张再次点击退出选择

      }
        else{
        //退出

        }*/

    }

    /*Set the position of button and textField*/
    private class SimpleLayout implements LayoutManager {

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
            int w = parent.getWidth();        //frame width
            int h = parent.getHeight();       //frame height

            /*Description in the above*/
            if(jtfd.isVisible()){
                Dimension size = jtfd.getPreferredSize();
                int x = (w - size.width) / 2;
                int y = h / 5;
                jtfd.setBounds(x, y, size.width, size.height);
            }

            /*The choice : Choose on the lower left*/
            if(jbuttond.isVisible()){
                Dimension size = jbuttond.getPreferredSize();
                int x = (w - size.width) / 2 - 150;
                int y = (3 * h)/5;
                jbuttond.setBounds(x, y, size.width, size.height);
            }

            /*The choice : Next or Cancel on the lower right*/
            if(jbuttond2.isVisible()){
                Dimension size = jbuttond2.getPreferredSize();
                int x = (w - size.width) / 2 + 150;
                int y = (3 * h)/5;
                jbuttond2.setBounds(x, y, size.width, size.height);

            }

        }
    }
}