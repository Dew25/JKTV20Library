/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents.reader;

import app.GuiApp;
import app.mycomopnents.ButtonComponent;
import app.mycomopnents.CaptionComponent;
import app.mycomopnents.ComboBoxReadersComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.ListHistoriesComponent;
import entity.Book;
import entity.History;
import entity.Reader;
import facade.BookFacade;
import facade.HistoryFacade;
import facade.ReaderFacade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;
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
public class TabReturnBooksComponents extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private ComboBoxReadersComponent comboBoxReadersComponent;
    private ListHistoriesComponent listHistoriesComponent;
    private ButtonComponent buttonComponent;
    private ComboBoxModel comboBoxModel;
    private Reader reader;
    private BookFacade bookFacade = new BookFacade();
    private HistoryFacade historyFacade = new HistoryFacade();
    public TabReturnBooksComponents(int widthPanel) {
        setPreferredSize(new Dimension(GuiApp.WITH_WINDOWS-5,GuiApp.HEIGHT_WINDOWS));
        setMinimumSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        setComboBoxModel();
        initComponents(widthPanel);
    }
    private void initComponents(int widthPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,15)));
        captionComponent = new CaptionComponent("Возврат книги", widthPanel, 31);
        this.add(captionComponent); 
        infoComponent = new InfoComponent("", widthPanel, 31);
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        listHistoriesComponent = new ListHistoriesComponent("Читаемые книги", widthPanel, 120, 300);
        comboBoxReadersComponent = new ComboBoxReadersComponent("Читатели", widthPanel, 30, 300);
        comboBoxReadersComponent.getComboBox().setModel(comboBoxModel);
        comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
        comboBoxReadersComponent.getComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                reader=(Reader) ie.getItem();
                listHistoriesComponent.getJList().setModel(listHistoriesComponent.getListModel(reader));
            }
        });
        this.add(comboBoxReadersComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(listHistoriesComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        buttonComponent = new ButtonComponent("Вернуть книги", widthPanel, 35, widthPanel/3+5, 300);
        this.add(buttonComponent);
        buttonComponent.getButton().addActionListener(clickToButtonReturnBooks());
    }
    private ActionListener clickToButtonReturnBooks(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(comboBoxReadersComponent.getComboBox().getSelectedIndex() == -1){
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Выберите читателя");
                    return;
                }
                List<History> histories = listHistoriesComponent.getJList().getSelectedValuesList();
                if(histories.isEmpty()){
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Выберите возвращаемые книги");
                    return;
                }
                for (History history : histories) {
                    Book book = history.getBook();
                    book.setCount(book.getCount() + 1);
                    bookFacade.edit(book);
                    history.setReturnDate(new GregorianCalendar().getTime());
                    historyFacade.edit(history);
                    comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
                    listHistoriesComponent.getJList().setModel(listHistoriesComponent.getListModel());
                    infoComponent.getInfo().setForeground(Color.BLUE);
                    infoComponent.getInfo().setText("Выберанные книги возвращены");
                }
            }
        };
    }

    private void setComboBoxModel(){
        ReaderFacade readerFacade = new ReaderFacade();
        List<Reader> readers = readerFacade.findAll();
        DefaultComboBoxModel<Reader> defaultComboBoxModel = new DefaultComboBoxModel<>();
        for (Reader reader : readers) {
            defaultComboBoxModel.addElement(reader);
        }
        comboBoxModel=defaultComboBoxModel;
    }
    public void addComboBoxModel() {
        infoComponent.getInfo().setText("");
        setComboBoxModel();
        comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
    }
    
    
}
