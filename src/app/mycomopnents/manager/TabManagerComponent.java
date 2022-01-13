/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents.manager;

import app.mycomopnents.reader.*;
import app.mycomopnents.ButtonComponent;
import app.mycomopnents.CaptionComponent;
import app.mycomopnents.ComboBoxReadersComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.reader.TabReturnBooksComponents;
import app.mycomopnents.reader.TabTakeOnBooksComponents;
import entity.Reader;
import facade.ReaderFacade;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Melnikov
 */
public class TabManagerComponent extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private TabAddBookComponent tabAddBookComponent;
    private TabEditBookComponent tabEditBookComponent;
    private TabAddAuthorComponent tabAddAuthorComponent;
    private TabEditAuthorComponent tabEditAuthorComponent;
    private ButtonComponent buttonComponent;
    public TabManagerComponent(int widthPanel) {
        initComponents(widthPanel);
    }

    private void initComponents(int widthPanel) {
        this.setPreferredSize(new Dimension(widthPanel,450));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        JTabbedPane tabManagerTabbed = new JTabbedPane();
        tabManagerTabbed.setPreferredSize(new Dimension(widthPanel-17,450));
        tabManagerTabbed.setMinimumSize(tabManagerTabbed.getPreferredSize());
        tabManagerTabbed.setMaximumSize(tabManagerTabbed.getPreferredSize());
        tabManagerTabbed.setAlignmentX(CENTER_ALIGNMENT);
        tabAddBookComponent = new TabAddBookComponent(widthPanel);
        tabManagerTabbed.addTab("Добавить новую книгу", tabAddBookComponent);
        tabEditBookComponent = new TabEditBookComponent(widthPanel);
        tabManagerTabbed.addTab("Редактировать книгу", tabEditBookComponent);
        tabAddAuthorComponent = new TabAddAuthorComponent(widthPanel);
        tabManagerTabbed.addTab("Добавить автора", tabAddAuthorComponent);
        tabEditAuthorComponent = new TabEditAuthorComponent(widthPanel);
        tabManagerTabbed.addTab("Редактировать автора", tabEditAuthorComponent);
        this.add(tabManagerTabbed);
        tabManagerTabbed.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                infoComponent.getInfo().setText("");
            }
        });
    }
    
}
