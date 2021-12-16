/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

import entity.Reader;
import facade.ReaderFacade;
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

/**
 *
 * @author Melnikov
 */
public class TabReaderComponents extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private ComboBoxReadersComponent comboBoxReadersComponent;
    private ListBooksComponent listBooksComponent;
    private ButtonComponent buttonComponent;
    private Reader reader;
    public TabReaderComponents(int widthPanel) {
        initComponents(widthPanel);
    }

    private void initComponents(int widthPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,15)));
        captionComponent = new CaptionComponent("Выбор книги", widthPanel, 31);
        this.add(captionComponent); 
        infoComponent = new InfoComponent("", widthPanel, 31);
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        comboBoxReadersComponent = new ComboBoxReadersComponent("Читатели", widthPanel, 30, 300);
//        comboBoxReadersComponent.getComboBox().setModel(comboBoxModel);
        comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
        comboBoxReadersComponent.getComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                reader=(Reader) ie.getItem();
            }
        });
        this.add(comboBoxReadersComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        listBooksComponent = new ListBooksComponent("Книги", widthPanel, 120, 300);
        this.add(listBooksComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        buttonComponent = new ButtonComponent("Взять книгу для чтения", widthPanel, 35, widthPanel/3+5, 300);
        this.add(buttonComponent);
        buttonComponent.getButton().addActionListener(clickToButtonEditReader());
    }
    private ActionListener clickToButtonEditReader(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        };
    }

    public void addComboBoxModel() {
        infoComponent.getInfo().setText("");
        ReaderFacade readerFacade = new ReaderFacade(Reader.class);
        List<Reader> readers = readerFacade.findAll();
        DefaultComboBoxModel<Reader> defaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Reader reader : readers) {
            defaultComboBoxModel.addElement(reader);
        }
        comboBoxReadersComponent.getComboBox().setModel(defaultComboBoxModel);
        comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
        
    }
    
    
}
