/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

import entity.Author;
import entity.Book;
import entity.Reader;
import facade.BookFacade;
import facade.ReaderFacade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Melnikov
 */
public class TabDirectorComponent extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private EditorComponent nameComponent;
    private EditorComponent lastNameComponent;
    private EditorComponent phoneComponent;
    private ButtonComponent buttonComponent;
    public TabDirectorComponent(int widthWindow) {
        initComponents(widthWindow);
    }

    private void initComponents(int widthPanel) {
        this.setPreferredSize(new Dimension(widthPanel,450));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        JTabbedPane tabDirector = new JTabbedPane();
        TabAddReaderComponents tabAddReaderComponents = new TabAddReaderComponents(widthPanel);
        tabDirector.addTab("Добавить читателя", tabAddReaderComponents);
        TabEditReaderComponents tabEditReaderComponents = new TabEditReaderComponents(widthPanel);
        tabDirector.addTab("Изменить читателя", tabEditReaderComponents);
        this.add(tabDirector);
    }  
}
