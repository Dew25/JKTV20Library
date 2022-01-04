/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents.renderers;

import entity.Author;
import entity.Book;
import entity.Reader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 *
 * @author user
 */
public class ListBooksRenderer extends JLabel implements ListCellRenderer{
    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");
    
    public ListBooksRenderer() {
        super.setOpaque(true);
        super.setHorizontalAlignment(LEFT);
        super.setVerticalAlignment(CENTER);
        
    }

   @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        Book book = (Book) value;
        if(book == null) return this;
        StringBuilder sb = new StringBuilder();
              for (int i = 0; i < book.getAuthor().size(); i++) {
                  Author author = book.getAuthor().get(i);
                  sb.append(author.getName())
                    .append(" ")
                    .append(author.getLastname())
                    .append(". ");
              }
              if(book.getCount() > 0){
                  this.setText(String.format("%d. %s. %s %d. В наличии %d"
                          ,book.getId()
                          ,book.getCaption()
                          ,sb.toString()
                          ,book.getPublishedYear()
                          ,book.getCount()
                  ));
              }else{
                  this.setText(String.format("%d. %s. %s %d. Нет в наличии"
                          ,book.getId()
                          ,book.getCaption()
                          ,sb.toString()
                          ,book.getPublishedYear()
                          ,book.getCount()
                  ));
                  this.setForeground(Color.RED);
              }
              if(!isSelected){
                  this.setBackground(index % 2 == 0 ? background : defaultBackground);
              }

        return this;
    }
    
}
