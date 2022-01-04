/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents.renderers;

import entity.Reader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jvm
 */
public class ComboBoxReaderRenderer  extends JLabel implements ListCellRenderer{
    
  private boolean colorSet;
    private Color selectionBackgroundColor;

    public ComboBoxReaderRenderer()
    {
        super.setOpaque(true);
        super.setHorizontalAlignment(LEFT);
        super.setVerticalAlignment(CENTER);
        colorSet = false;
        selectionBackgroundColor = Color.red; // Have to set a color, else a compiler error will occur
    }

  @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        // Check if color is set (only runs the first time)
        if(!colorSet)
        {
            // Set the list' background color to original selection background of the list
            selectionBackgroundColor = list.getSelectionBackground();
            // Do this only one time since the color will change later
            colorSet = true;
        }

        // Set the list' background color to white (white will show once selection is made)
        list.setSelectionBackground(Color.white);

        // Check which item is selected
        if(isSelected)
        {
            // Set background color of the item your cursor is hovering over to the original background color
            setBackground(selectionBackgroundColor);
        }
        else
        {
            // Set background color of all other items to white
            setBackground(Color.white);
        }
        Reader reader = (Reader) value;
        if(reader == null) return this;
        setText(String.format("%d. %s %s. %s%n"
                ,reader.getId()
                ,reader.getFirstname()
                ,reader.getLastname()
                ,reader.getPhone()
        ));
        // Do nothing about the text and font to be displayed
        setText((String)value);
        setFont(list.getFont());

        return this;
    }

}