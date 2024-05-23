package windows;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class infoWindow extends JFrame
{

    Color BackgroundC = new Color(0xFF2B2D30);
    Color WhiteC = new Color(0xfbffff);

    JTextArea infoTextArea;

    ImageIcon icon = new ImageIcon("src/resources/images/icon.png");

    infoWindow()
    {
        // --- --- WINDOW PROPERTIES --- ---
        this.setLayout(null);
        this.setSize(new Dimension(780, 580));
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("About myLift");
        this.setIconImage(icon.getImage());

        this.setVisible(true);
        // ---------------------------------

        infoTextArea = new JTextArea();
        infoTextArea.setBounds(0,0,780,580);
        infoTextArea.setOpaque(false);
        infoTextArea.setBackground(BackgroundC);
        infoTextArea.setPreferredSize(new Dimension(300, 200));
        infoTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        infoTextArea.setLineWrap(true);
        infoTextArea.setFocusable(false);
        infoTextArea.setEditable(false);
        infoTextArea.setForeground(WhiteC);
        infoTextArea.setBorder(BorderFactory.createLineBorder(BackgroundC, 40));

        //  SET LABEL TO FILE CONTENTS

        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/resources/info.txt"));
            StringBuffer fileContent = new StringBuffer();
            String line;
            while ((line = bf.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
            bf.close();
            infoTextArea.setText(fileContent.toString());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        this.add(infoTextArea, BorderLayout.CENTER);

        // ---------------------------------

    }
}
