/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

import app.GuiApp;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Melnikov
 */
public class GuestComponent extends JPanel{
    private ListBooksComponent listBooksComponent;
    private GuestButtonsComponent guestButtonsComponent;
    public GuestComponent() {
        setPreferredSize(new Dimension(GuiApp.WITH_WINDOWS,GuiApp.HEIGHT_WINDOWS));
        setMinimumSize(getPreferredSize());
        setMaximumSize(getPreferredSize());
        initComponents();
    }

    private void initComponents() {
        listBooksComponent = new ListBooksComponent(true,"Книги", GuiApp.WITH_WINDOWS,GuiApp.HEIGHT_WINDOWS,GuiApp.WITH_WINDOWS);
        this.add(listBooksComponent);
        guestButtonsComponent = new GuestButtonsComponent("Войти", "Зарегистрироваться", GuiApp.WITH_WINDOWS, 50,200,10,250);
        this.add(guestButtonsComponent);
    }
    
}
