package compress_decompress;

import comp_pack.Compressor;
import comp_pack.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(80,30,300,30);
        compressButton.addActionListener(this);

        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(80,80,300,30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);

        this.setSize(400,300);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton)
        {
            JFileChooser filechooser=new JFileChooser();
            int response= filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION)
            {
              File file=new File(filechooser.getSelectedFile().getAbsolutePath());
              System.out.print(file);
              try
              {
                  Compressor.method(file);
              }
              catch(Exception ee){
                  JOptionPane.showMessageDialog(null,ee.toString());
              }
            }
        }
        if(e.getSource()==decompressButton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
