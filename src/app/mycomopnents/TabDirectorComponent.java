/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

import entity.Author;
import entity.Book;
import entity.Reader;
import facade.BookFacade;
import facade.ReaderFacade;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Melnikov
 */
public class TabDirectorComponent extends JPanel{
    private CaptionComponent captionComponent;
    private InfoComponent infoComponent;
    private EditorComponent nameComponent;
    private EditorComponent lastNameComponent;
    private EditorComponent phoneComponent;
    private ButtonComponent buttonComponent;
    public TabDirectorComponent(int widthWindow) {
        initComponents(widthWindow);
    }

    private void initComponents(int widthWindow) {
        this.setPreferredSize(new Dimension(widthWindow,450));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(0,15)));
        captionComponent = new CaptionComponent("Добавление новой читателя", widthWindow, 31);
        this.add(captionComponent);
        infoComponent = new InfoComponent("", widthWindow, 31);
        this.add(infoComponent);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        nameComponent = new EditorComponent("Имя", widthWindow, 31, 300);
        this.add(nameComponent);
        lastNameComponent = new EditorComponent("Фамилия", widthWindow, 31, 300);
        this.add(lastNameComponent);
        phoneComponent = new EditorComponent("Телефон", widthWindow, 31, 200);
        this.add(phoneComponent);
        buttonComponent = new ButtonComponent("Добавить читателя", widthWindow, 31, 350, 150);
        this.add(buttonComponent);
        buttonComponent.getButton().addActionListener(clickToButtonAddReader());
    }
    private ActionListener clickToButtonAddReader(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                /**
                 * Создать объект book
                 * Инициировать поля книги используя элементы компотентов
                 * Добавить книгу в базу данных
                 * Сообзить пользователю о результате 
                 * если true очистить редакторы компонентов
                 */
                Reader reader = new Reader();
                if(nameComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setText("Введите имя");
                    return;
                }
                reader.setFirstname(nameComponent.getEditor().getText());
                if(lastNameComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setText("Введите фамилию");
                    return;
                }
                reader.setLastname(lastNameComponent.getEditor().getText());
                
                if(phoneComponent.getEditor().getText().isEmpty()){
                    infoComponent.getInfo().setText("Введите телефон");
                    return;
                } 
                reader.setPhone(phoneComponent.getEditor().getText());
                
                ReaderFacade readerFacade = new ReaderFacade(Reader.class);
                
                try {
                    readerFacade.create(reader);
                    infoComponent.getInfo().setText("Читатель успешно добавлен");
                    phoneComponent.getEditor().setText("");
                    lastNameComponent.getEditor().setText("");
                    nameComponent.getEditor().setText("");
                } catch (Exception e) {
                    infoComponent.getInfo().setText("Читателя добавить не удалось");
                }
            }
        };
    }
}
