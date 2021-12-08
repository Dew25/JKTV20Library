/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.mycomopnents.ButtonComponent;
import app.mycomopnents.CaptionComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.EditorComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.ListAuthors;
import entity.Author;
import entity.Book;
import facade.BookFacade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Melnikov
 */
public class GuiApp extends JFrame implements ActionListener{
    private BookFacade bookFacade;
    private InfoComponent infoComponent;
    private EditorComponent  bookNameComponent;
    private EditorComponent publishedYearComponent;
    private EditorComponent quantityComponent;
    private ListAuthors listAuthorsComponent;
    private ButtonComponent buttonComponent;
    public GuiApp() {
        initComponents();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setTitle("JPTV20 Library");
        this.setPreferredSize(new Dimension(600,400));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,18)));
        CaptionComponent captionComponent = new CaptionComponent("Добавление новой книги", this.getWidth(), 27);
        this.add(captionComponent);
        infoComponent = new InfoComponent("", this.getWidth(),27);
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,15)));
//        infoComponent = new InfoComponent("Новая книга добалвена", this.getWidth(), 40);
//        this.add(captionComponent);
        bookNameComponent = new EditorComponent("Название книги", this.getWidth(), 31, 300);
        this.add(bookNameComponent);
        listAuthorsComponent = new ListAuthors("Авторы", this.getWidth(), 120, 300);
        this.add(listAuthorsComponent);
        publishedYearComponent = new EditorComponent("Год издания", this.getWidth(), 31, 100);
        this.add(publishedYearComponent);
        quantityComponent = new EditorComponent("Количество экземпляров", this.getWidth(), 31, 50);
        this.add(quantityComponent);
        buttonComponent = new ButtonComponent("Добавить книгу", this.getWidth(), 31, 350, 150);
        this.add(buttonComponent);
        buttonComponent.getButton().addActionListener(this);
        
    }
    

  @Override
  public void actionPerformed(ActionEvent e) {
    Book book = new Book();
    bookFacade = new BookFacade(Book.class);
    if(getBookNameComponent().getEditor().getText().isEmpty()){
      getInfoComponent().getInfo().setForeground(Color.RED);
      getInfoComponent().getInfo().setText("Введите название книги");
      return;
    }
    book.setCaption(getBookNameComponent().getEditor().getText());
    try {
      book.setPublishedYear(Integer.parseInt(getPublishedYearComponent().getEditor().getText()));
    } catch (NumberFormatException ex) {
      getInfoComponent().getInfo().setForeground(Color.RED);
      getInfoComponent().getInfo().setText("Год введите цифрами,например: 2020");
      return;
    }
    try {
      book.setQuantity(Integer.parseInt(getQuantityComponent().getEditor().getText()));
      book.setCount(book.getQuantity());
    } catch (NumberFormatException ex) {
      getInfoComponent().getInfo().setForeground(Color.RED);
      getInfoComponent().getInfo().setText("Количество экземпляров введите цифрами");
      return;
    }
    List<Author>bookAuthors = this.listAuthorsComponent.getAuthors();
    if(bookAuthors.isEmpty()){
      getInfoComponent().getInfo().setForeground(Color.RED);
      getInfoComponent().getInfo().setText("Выберите автора или автроров книги");
      return;
    }
    book.setAuthor(bookAuthors);
    try {
      bookFacade.create(book);
      getBookNameComponent().getEditor().setText("");
      getPublishedYearComponent().getEditor().setText("");
      getQuantityComponent().getEditor().setText("");
      getListAuthorsComponent().getJList().clearSelection();
      getInfoComponent().getInfo().setForeground(Color.CYAN);
      getInfoComponent().getInfo().setText("Книга успешно добавлена в базу");
      
    } catch (Exception ex) {
      getInfoComponent().getInfo().setForeground(Color.RED);
      getInfoComponent().getInfo().setText("Книгу добавить не удалось");
    }
    
  }

  public InfoComponent getInfoComponent() {
    return infoComponent;
  }


  public EditorComponent getBookNameComponent() {
    return bookNameComponent;
  }

  public EditorComponent getPublishedYearComponent() {
    return publishedYearComponent;
  }

  public EditorComponent getQuantityComponent() {
    return quantityComponent;
  }

  public ListAuthors getListAuthorsComponent() {
    return listAuthorsComponent;
  }

  public ButtonComponent getButtonComponent() {
    return buttonComponent;
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
