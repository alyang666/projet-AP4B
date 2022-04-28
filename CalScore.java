import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author YANG Anlu
 * @create 2021-01-07 00:56
 */
public class CalScore extends JFrame {
    JFrame jf;
    JLabel jl;
    JLabel jl2;
    JLabel jl3;


    public CalScore(String title, ArrayList<Student> students, int index) {
        super(title);

        jf = new JFrame();
        jf.setTitle("Score Calculation");
        jf.setSize(800, 500);
        jf.setLocation(0, 0);
        Container root = jf.getContentPane();
        LayoutManager layoutManager = new SimpleLayout();
        root.setLayout(layoutManager);
        System.out.println(index);
        int[] score = new int[index + 1];
        for (int j = 0; j < index + 1; j++) {
            score[j] = students.get(j).getScore();
        }
        String allScore = new String();
        for (int i = 0; i < index +1; i++) {
            allScore += students.get(i) + " ";
        }


        /*Jlabel for display all the students (name and score)*/
        jl = new JLabel(allScore);
        /*Compare the score of all the students and record the winner*/
        int winner = 0;
        for (int i = 0; i < index ; i++) {
            if (score[i + 1] >= score[i]){
                winner = i + 1;

            }
            //有分数相同的情况有点点复杂，要改变Jtextfield里面的语句 我写不太出来所以只好先这样了
        }


        /*Display the winner*/
        jl2 = new JLabel();
        jl2.setText("The winner is "+ students.get(winner) );
        jl2.setFont(new Font("Consolas",1,30));
        jl3 = new JLabel();
        jl3.setText("Congratulations!");
        jl3.setFont(new Font("Vladimir Script",1,40));
        jl3.setBackground(new Color(251,200,47));
        jl.setFont(new Font("Consolas",1,20));
        jf.add(jl);
        jf.add(jl2);
        jf.add(jl3);
        jf.setSize(1000,750);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

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


            if (jl.isVisible()) {
                Dimension size = jl.getPreferredSize();
                int x = (w - size.width) / 5;
                int y = h / 3;
                jl.setBounds(x, y, size.width, size.height);
            }


            if (jl2.isVisible()) {
                Dimension size = jl2.getPreferredSize();
                int x = (w - size.width) / 2 ;
                int y = (h - size.height) / 2 ;
                jl2.setBounds(x, y, size.width, size.height);
            }
            if (jl3.isVisible()) {
                Dimension size = jl3.getPreferredSize();
                int x = (w - size.width) / 2 ;
                int y = (h - size.height) / 2 + 50;
                jl3.setBounds(x, y, size.width, size.height);
            }

        }
    }

}
