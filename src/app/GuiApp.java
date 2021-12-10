/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.mycomopnents.TabDirectorComponent;
import app.mycomopnents.TabManagerComponent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Melnikov
 */
public class GuiApp extends JFrame{
    
    public GuiApp() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setTitle("JPTV20 Library");
        this.setPreferredSize(new Dimension(600,450));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setPreferredSize(new Dimension(600,450));
        jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
        jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
        TabManagerComponent tabReaderComponent = new TabManagerComponent(this.getWidth());
        jTabbedPane.addTab("Библиотекарь", tabReaderComponent);
        this.getContentPane().add(jTabbedPane);
        TabDirectorComponent tabDirectorComponent = new TabDirectorComponent(this.getWidth());
        jTabbedPane.addTab("Директор", tabDirectorComponent);
        
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }

}
