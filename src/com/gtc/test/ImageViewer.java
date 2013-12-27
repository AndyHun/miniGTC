package com.gtc.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * description
 * author AndHun
 * Date: 12/10/13 3:07 PM
 * version 1.0
 */
public class ImageViewer extends JFrame  implements ActionListener
{
    private JLabel label;
    public ImageViewer()
    {
        setTitle("ImageViewer");
        setSize(300,400);

        JMenuBar mBar=new JMenuBar();
        JMenu m=new JMenu("File");
        JMenuItem m1=new JMenuItem("Open");
        m1.addActionListener(this);
        m.add(m1);

        JMenuItem m2=new JMenuItem("Exit");
        m2.addActionListener(this);
        m.add(m2);
        mBar.add(m);

        setJMenuBar(mBar);

        label=new JLabel();

        Container contentPane= getContentPane();
        contentPane.add(label, "Center");


    }
    public void actionPerformed(ActionEvent evt)
    {
        String arg=evt.getActionCommand();
        if(arg.equals("Open"))
        {
            System.out.println("aaaaaaa");
            JFileChooser chooser=new JFileChooser();
            System.out.println("aaaaaaa");
            chooser.setCurrentDirectory(new File("."));

            chooser.setFileFilter(new
                                          javax.swing.filechooser.FileFilter()
                                          {
                                              public boolean accept(File f)
                                              {
                                                  return f.getName().toLowerCase().endsWith(".gif");
                                              }
                                              public String getDescription()
                                              {
                                                  return "GIF Images";
                                              }
                                          });
            System.out.println("aaaaaaa");
            int r=chooser.showOpenDialog(this);
            if(r==JFileChooser.APPROVE_OPTION)
            {
                String name=chooser.getSelectedFile().getName();
                label.setIcon(new ImageIcon(name));
            }
        }
        else if(arg.equals("Exit"))
            System.exit(0);
    }
    public static void main(String[] args)
    {
        JFrame frame=new ImageViewer();
        frame.show();
    }
}
