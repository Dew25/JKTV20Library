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
import app.mycomopnents.GuestComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.lists.ListBooksComponent;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Melnikov
 */
public class TabReaderTakeOnBooksComponents extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private ComboBoxReadersComponent comboBoxReadersComponent;
    private GuestComponent guestComponent;
    private ButtonComponent buttonComponent;
    private ComboBoxModel<Reader> comboBoxModel;
    private Reader reader;
    private HistoryFacade historyFacade = new HistoryFacade();
    private BookFacade bookFacade = new BookFacade();
    
    public TabReaderTakeOnBooksComponents() {
        super.setPreferredSize(new Dimension(GuiApp.WITH_WINDOWS-5,GuiApp.HEIGHT_WINDOWS));
        super.setMinimumSize(getPreferredSize());
        super.setMaximumSize(getPreferredSize());
        
        setComboBoxModel();
        initComponents();
    }
    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        this.add(Box.createRigidArea(new Dimension(0,10)));
        captionComponent = new CaptionComponent("Выбор книги", GuiApp.WITH_WINDOWS, 31);
        captionComponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(captionComponent); 
        infoComponent = new InfoComponent("", GuiApp.WITH_WINDOWS, 31);
        infoComponent.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,5)));

        JCheckBox checkBoxAllBooks = new JCheckBox("Показать все книги");
        this.add(checkBoxAllBooks);
        checkBoxAllBooks.setBorder(BorderFactory.createLineBorder(Color.yellow));
        checkBoxAllBooks.setBorderPainted(true);
        guestComponent = new GuestComponent();
        guestComponent.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        this.add(guestComponent);
        checkBoxAllBooks.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    guestComponent.getListBooksComponent().getJList().setModel(guestComponent.getListBooksComponent().getListModel(true));
                    buttonComponent.getButton().setEnabled(false);
                    guestComponent.getListBooksComponent().getJList().setEnabled(false);
                }else{
                    guestComponent.getListBooksComponent().getJList().setModel(guestComponent.getListBooksComponent().getListModel(false));
                    buttonComponent.getButton().setEnabled(true);
                    guestComponent.getListBooksComponent().getJList().setEnabled(true);
                }
            }
        });
        this.add(Box.createRigidArea(new Dimension(0,10)));
        buttonComponent = new ButtonComponent("Взять книгу для чтения", GuiApp.WITH_WINDOWS, 35, 120, 300);
        this.add(buttonComponent);
        buttonComponent.getButton().addActionListener(clickToButtonTakeOnBook());
    }
    private ActionListener clickToButtonTakeOnBook(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(comboBoxReadersComponent.getComboBox().getSelectedIndex() == -1){
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Выберите читателя");
                    return;
                }
                List<Book> books = guestComponent.getListBooksComponent().getJList().getSelectedValuesList();
                if(books.isEmpty()){
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Выберите книги");
                    return;
                }
                try {
                    for (Book book : books) {
                        History history = new History();
                        book.setCount(book.getCount()-1);
                        bookFacade.edit(book);
                        history.setBook(book);
                        history.setReader(reader);
                        Calendar c = new GregorianCalendar();
                        history.setGivenDate(c.getTime());
                        historyFacade.create(history);
                        infoComponent.getInfo().setForeground(Color.BLUE);
                        infoComponent.getInfo().setText("Выбранные книги выданы");
                        comboBoxReadersComponent.getComboBox().setSelectedIndex(-1);
                        guestComponent.getListBooksComponent().getJList().setModel(guestComponent.getListBooksComponent().getListModel(false));
                        guestComponent.getListBooksComponent().getJList().clearSelection();
                    }
                } catch (Exception e) {
                    infoComponent.getInfo().setForeground(Color.RED);
                    infoComponent.getInfo().setText("Выбранные книги выдать не удалось");
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
