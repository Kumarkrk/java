import javax.swing.*;
import java.awt.*;
public class helloworld {
    public static void main(String[] args) {
        JFrame f=new JFrame("my first window");
        f.setSize(400,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           f.setLayout(new FlowLayout());   
        JButton K=new JButton("sUBMIT");
        f.add(K);
        K.addActionListener(e->
        System.out.println("button clicked"));
        JLabel j=new JLabel("hello welcome to gui",SwingConstants.CENTER);
        f.add(j);
        f.setVisible(true);
    }
}
