/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents.lists;

import app.GuiApp;
import app.mycomopnents.renderers.ListBooksRenderer;
import entity.Book;
import facade.BookFacade;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Melnikov
 */
public class ListBooksComponent extends JPanel{
    private JLabel caption;
    private JList<Book> list;
  

   
    public ListBooksComponent(boolean guest,String text, int widthWindow, int heightPanel, int left, int listWidth) {
        initComponents(guest, text, widthWindow, heightPanel, left, listWidth);
    }
    private void initComponents(boolean guest, String text, int widthWindow, int heightPanel, int left, int listWidth) {
      if(left == 0)left = widthWindow/3;
      this.setPreferredSize(new Dimension(widthWindow-15,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        if(guest){
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }else{
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }
//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            caption = new JLabel(text);
            caption.setPreferredSize(new Dimension(GuiApp.WITH_WINDOWS-25,30));
            caption.setMinimumSize(caption.getPreferredSize());
            caption.setMaximumSize(caption.getPreferredSize());
    //        caption.setBorder(BorderFactory.createLineBorder(Color.yellow));
            caption.setHorizontalAlignment(JLabel.LEFT);
            caption.setAlignmentY(TOP_ALIGNMENT);//setVerticalAlignment(JLabel.TOP);
            caption.setFont(new Font("Tahoma",0,12));
            this.add(caption);
            if(guest){
                this.add(Box.createRigidArea(new Dimension(0, 2)));
            }else{
                this.add(Box.createRigidArea(new Dimension(5, 0)));
            }
            list = new JList<>();
            list.setModel(getListModel());
            list.setCellRenderer(new ListBooksRenderer());
            list.setSelectionMode (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            list.setLayoutOrientation (JList.HEIGHT);
            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setPreferredSize(new Dimension(listWidth, heightPanel));
            scrollPane.setMaximumSize(scrollPane.getPreferredSize());
            scrollPane.setMinimumSize(scrollPane.getPreferredSize());
            scrollPane.setAlignmentX(LEFT_ALIGNMENT);
           // scrollPane.setAlignmentY(TOP_ALIGNMENT);
            scrollPane.setVisible(true);
            this.add(scrollPane);
//        
        
    }
    /**
     * Метод возвращает модель со списком доступных для выдачи книг
     * @return объект DefaultListModel
     */
    public ListModel<Book> getListModel(){
       return getListModel(false);
    }
    /**
     * Метод возвращает модель со списком книг из базы данных
     * @param allBooks true все книги, false - только доступные к выдаче
     * @return объект DefaultListModel
     */
    public ListModel<Book> getListModel(boolean allBooks) {
        BookFacade bookFacade = new BookFacade();
        List<Book> books=null;
        if(allBooks){
            books = bookFacade.findAll();
        }else{
            books = bookFacade.fingEnabledBook();
        }
        DefaultListModel<Book> defaultListModel = new DefaultListModel<>();
        for (Book book : books) {
            defaultListModel.addElement(book);
        }
        return defaultListModel;
    }

    public JList<Book> getJList() {
        return list;
    }
    
}
