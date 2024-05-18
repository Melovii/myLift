package windows;

import javax.swing.*;
import java.awt.*;

public class viewWorkoutsWindow extends JFrame
{
    JButton returnB;

    viewWorkoutsWindow()
    {
        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 600);

        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------


        // ---  ---  BUTTON ACTIONS  ---  ---
        returnB = new JButton("<-");
        returnB.setBounds(10, 510, 40, 40);
        this.add(returnB);
        // ----------------------------------
    }
}