package windows;

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class infoWindow extends JFrame
{

    Color BackgroundC = new Color(0xFF2B2D30);
    Color LabelC = new Color(0x73fbfd);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x363A3D);
    Color ShadowC = new Color(0x191C1D);

    JTextArea infoTextArea;

    infoWindow()
    {
        // --- --- WINDOW PROPERTIES --- ---
        this.setLayout(new BorderLayout());
        this.setSize(780, 580);

        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Information");

        this.setVisible(true);
        // ---------------------------------

        infoTextArea = new JTextArea();
        infoTextArea.setForeground(new Color(10, 10, 10));
        infoTextArea.setPreferredSize(new Dimension(300, 200));
        infoTextArea.setFont(new Font("Times New Roman", Font.BOLD, 21));
        infoTextArea.setLineWrap(true);
        infoTextArea.setFocusable(false);
        infoTextArea.setEditable(false);
        infoTextArea.setBorder(BorderFactory.createLineBorder(new Color(44, 43, 64), 40));

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

//        JScrollPane scrollPane = new JScrollPane(infoTextArea);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//        this.add(scrollPane, BorderLayout.CENTER);
    }
}
