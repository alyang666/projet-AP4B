import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Kendrick Liu
 * @create 2021-01-10:08
 */
public class MyFrame2 extends MyFrame {
    JLabel a1 = new ColorfulLabel("Ticket to UTBM", new Color(131,175,155));
    JButton button = new JButton("Your Name");


    public MyFrame2(String title, ArrayList<Student> students, int i){
        super(title);
        this.students = students;
        this.index = i;

        //content pane
        Container root = this.getContentPane();
        LayoutManager layoutManager = new SimpleLayout();
        root.setLayout(layoutManager);

        button.setPreferredSize(new Dimension(500,100));
        button.setFont(new Font("Comic sans MS",1,30));
        //add to content pane
        root.add(a1);
        root.add(button);

        //actionListener for button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int j = 0; j <= index; j++) {
                    enterName(j);
                    System.out.println(students.get(j).getId());
                }
                System.out.println("Enter name finished!");
                setVisible(false);
                Main m = new Main("Chose Action",students,index);
            }
        });

    }

    //enter name for each student
    public void enterName(int i){
        String input = JOptionPane.showInputDialog(
                this,
                "Enter your name please!",
                "John"
        );

        //System.out.println(index);
        //System.out.println(students);



            if (input != null) {

                students.get(i).setName(input);
                System.out.println("Student "+ i +" "+"Your name is: " + input);
            }



    }

    // label with colorful background
    private static class ColorfulLabel extends JLabel{
        public ColorfulLabel(String text, Color color) {
            super(text);
            setOpaque(true);
            setBackground(color);
            setPreferredSize(new Dimension(1000,100));
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(new Font("Lucida Calligraphy",1,40));

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


            if(button.isVisible()){
                Dimension size = button.getPreferredSize();
                int x = (w - size.width) / 2;
                int y = (h - size.height) / 2;


                button.setBounds(x, y, size.width, size.height);

            }

        }
    }


    
}

