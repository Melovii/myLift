package windows;

import javax.swing.*;
import java.awt.*;

public class infoWindow extends JFrame
{

    infoWindow()
    {
        this.setLayout(null);
        this.setSize(520, 300);

        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Information");

        this.setVisible(true);
    }
}
