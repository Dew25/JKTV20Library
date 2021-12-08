/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.mycomopnents.ButtonComponent;
import app.mycomopnents.CaptionComponent;
import app.mycomopnents.EditorComponent;
import app.mycomopnents.ListAuthors;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

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
        this.setPreferredSize(new Dimension(600,400));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        CaptionComponent captionComponent = new CaptionComponent("Добавление новой книги", this.getWidth(), 80);
        this.add(captionComponent);
        EditorComponent bookNameComponent = new EditorComponent("Название книги", this.getWidth(), 31, 300);
        this.add(bookNameComponent);
        ListAuthors listAuthors = new ListAuthors("Авторы", this.getWidth(), 120, 300);
        this.add(listAuthors);
        EditorComponent publishedYearComponent = new EditorComponent("Год издания", this.getWidth(), 31, 100);
        this.add(publishedYearComponent);
        EditorComponent quantityComponent = new EditorComponent("Количество экземпляров", this.getWidth(), 31, 50);
        this.add(quantityComponent);
        ButtonComponent buttonComponent = new ButtonComponent("Добавить книгу", this.getWidth(), 31, 350, 150);
        this.add(buttonComponent);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuiApp().setVisible(true);
            }
        });
    }

}
