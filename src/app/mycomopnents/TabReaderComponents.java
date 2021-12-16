/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

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
public class TabReaderComponents extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private ComboBoxReadersComponent comboBoxReadersComponent;
    private TabTakeOnBooksComponents tabTakeOnBooksComponents;
    private TabReturnBooksComponents tabReturnBooksComponents;
    private ButtonComponent buttonComponent;
    private Reader reader;
    public TabReaderComponents(int widthPanel) {
        initComponents(widthPanel);
    }

    private void initComponents(int widthPanel) {
        this.setPreferredSize(new Dimension(widthPanel,450));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        JTabbedPane tabReaderTabbed = new JTabbedPane();
        tabReaderTabbed.setPreferredSize(new Dimension(widthPanel-17,450));
        tabReaderTabbed.setMinimumSize(tabReaderTabbed.getPreferredSize());
        tabReaderTabbed.setMaximumSize(tabReaderTabbed.getPreferredSize());
        tabReaderTabbed.setAlignmentX(CENTER_ALIGNMENT);
        tabTakeOnBooksComponents = new TabTakeOnBooksComponents(widthPanel);
        tabReaderTabbed.addTab("Взять книгу для чтения", tabTakeOnBooksComponents);
        tabReturnBooksComponents = new TabReturnBooksComponents(widthPanel);
        tabReaderTabbed.addTab("Возврат книги", tabReturnBooksComponents);
        this.add(tabReaderTabbed);
        tabReaderTabbed.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent ce) {
                tabTakeOnBooksComponents.addComboBoxModel();
            }
            
        });
    }
    
}
