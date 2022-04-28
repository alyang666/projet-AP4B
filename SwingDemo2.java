import javax.swing.*;
import java.lang.*;
/**
 * @author Kendrick Liu
 * @create 2021-01-9:58
 */
public class SwingDemo2 {
    private static void createGUI(){
        MyFrame2 frame = new MyFrame2("Game Start Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Container contentPane = frame.getContentPane();
//        contentPane.setLayout(new FlowLayout());

//        contentPane.add(new JLabel("Hello World"));
//        contentPane.add((new JButton("测试")));
//
        frame.setSize(1000,750);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }


}


