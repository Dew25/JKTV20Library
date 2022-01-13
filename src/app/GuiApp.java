/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.mycomopnents.ButtonComponent;
import app.mycomopnents.CaptionComponent;
import app.mycomopnents.EditorComponent;
import app.mycomopnents.GuestButtonsComponent;
import app.mycomopnents.GuestComponent;
import app.mycomopnents.InfoComponent;
import app.mycomopnents.director.TabAddReaderComponents;
import app.mycomopnents.director.TabDirectorComponent;
import app.mycomopnents.manager.TabManagerComponent;
import app.mycomopnents.reader.TabReaderComponent;
import entity.Reader;
import entity.Role;
import entity.User;
import entity.UserRoles;
import facade.ReaderFacade;
import facade.RoleFacade;
import facade.UserFacade;
import facade.UserRolesFacade;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Melnikov
 */
public class GuiApp extends JFrame{
    public static final int WITH_WINDOWS = 600;
    public static final int HEIGHT_WINDOWS = 450;
    public static User user;
    public static String role;
    private InfoComponent infoTopComponent;
    private GuestComponent guestComponent;
    private GuestButtonsComponent guestButtonsComponent;
    private TabAddReaderComponents tabAddReaderComponents;
    private TabReaderComponent tabReaderComponent;
    private TabManagerComponent tabManagerComponent;
    private TabDirectorComponent tabDirectorComponent;
    private  GuiApp guiApp = this;
    private UserFacade userFacade = new UserFacade();
    private ReaderFacade readerFacade = new ReaderFacade();
    private RoleFacade roleFacade = new RoleFacade();
    private UserRolesFacade userRolesFacade = new UserRolesFacade();
    
    public GuiApp() {
        List<User> users = userFacade.findAll();
        if(users.isEmpty()){
            User user = new User();
            user.setLogin("admin");
            user.setPassword("12345");
            Reader reader = new Reader();
            reader.setFirstname("admin");
            reader.setLastname("admin");
            reader.setPhone("565456545");
            readerFacade.create(reader);
            user.setReader(reader);
            userFacade.create(user);
            Role role = new Role();
            role.setRoleName("ADMINISTRATOR");
            roleFacade.create(role);
            UserRoles userRoles = new UserRoles();
            userRoles.setUser(user);
            userRoles.setRole(role);
            userRolesFacade.create(userRoles);
            role = new Role();
            role.setRoleName("MANAGER");
            roleFacade.create(role);
            userRoles = new UserRoles();
            userRoles.setUser(user);
            userRoles.setRole(role);
            userRolesFacade.create(userRoles);
            role = new Role();
            role.setRoleName("READER");
            roleFacade.create(role);
            userRoles = new UserRoles();
            userRoles.setUser(user);
            userRoles.setRole(role);
            userRolesFacade.create(userRoles);
            
        }
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setTitle("JPTV20 Library");
        this.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        infoTopComponent = new InfoComponent("", WITH_WINDOWS, 27);
        this.add(infoTopComponent);
        guestComponent = new GuestComponent();
        guestButtonsComponent = new GuestButtonsComponent("Войти", "Зарегистрироваться", GuiApp.WITH_WINDOWS, 50,100,10,200);
        this.add(guestButtonsComponent);
        guestButtonsComponent.getButton1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int widthWindows = 350;
                int heightWindows = 260;
                JDialog dialogLogin = new JDialog(guiApp,"Введите логи и пароль",Dialog.ModalityType.DOCUMENT_MODAL);
                dialogLogin.setPreferredSize(new Dimension(widthWindows,heightWindows));
                dialogLogin.setMaximumSize(dialogLogin.getPreferredSize());
                dialogLogin.setMinimumSize(dialogLogin.getPreferredSize());
                dialogLogin.getContentPane().setLayout(new BoxLayout(dialogLogin.getContentPane(), BoxLayout.Y_AXIS));
                dialogLogin.setLocationRelativeTo(null);
                CaptionComponent captionComponent = new CaptionComponent("Введите логин и пароль", widthWindows, 27);
                InfoComponent infoComponent = new InfoComponent("", widthWindows, 27);
                EditorComponent loginComponent = new EditorComponent("Логин", widthWindows, 27,80, 200);
                EditorComponent passwordComponent = new EditorComponent("Пароль", widthWindows, 27,80, 200);
                ButtonComponent enterComponent = new ButtonComponent("Войти", widthWindows, 27, 185, 100);
                dialogLogin.getContentPane().add(Box.createRigidArea(new Dimension(0,10)));
                dialogLogin.getContentPane().add(captionComponent);
                dialogLogin.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
                dialogLogin.getContentPane().add(infoComponent);
                dialogLogin.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
                dialogLogin.getContentPane().add(loginComponent);
                dialogLogin.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));
                dialogLogin.getContentPane().add(passwordComponent);
                dialogLogin.getContentPane().add(Box.createRigidArea(new Dimension(0,15)));
                dialogLogin.getContentPane().add(enterComponent);
                enterComponent.getButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //Аутентификация - узнать есть ли такой пользователь
                        User user = userFacade.find(loginComponent.getEditor().getText().trim());
                        if(user == null){
                            infoComponent.getInfo().setText("Нет такого пользователя");
                            return;
                        }
                        //Авторизация - он ли это пользователь и какие у него права.
                        if(!user.getPassword().equals(passwordComponent.getEditor().getText().trim())){
                            infoComponent.getInfo().setText("Нет такого пользователя, или неверный пароль");
                            return;
                        }
                        GuiApp.user = user;
                        //Пользователь тот за кого себя выдает, устанавливаем разрешения.
                        String role = userRolesFacade.topRole(user);
                        GuiApp.role = role;
                        infoTopComponent.getInfo().setText("Hello "+user.getReader().getFirstname());
                        guiApp.getContentPane().remove(guestComponent);
                        guiApp.getContentPane().remove(guestButtonsComponent);
                        JTabbedPane jTabbedPane = new JTabbedPane();
                        jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
                        jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
                        jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
                        if("READER".equals(GuiApp.role)){
                            tabReaderComponent = new TabReaderComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Читатель", tabReaderComponent);
                        }else if("MANAGER".equals(GuiApp.role)){
                            tabReaderComponent = new TabReaderComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Читатель", tabReaderComponent);
                            tabManagerComponent = new TabManagerComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Библиотекарь", tabManagerComponent);
                        }else if("ADMINISTRATOR".equals(GuiApp.role)){
                            tabReaderComponent = new TabReaderComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Читатель", tabReaderComponent);
                            tabManagerComponent = new TabManagerComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Библиотекарь", tabManagerComponent);
                            tabDirectorComponent = new TabDirectorComponent(GuiApp.WITH_WINDOWS);
                            jTabbedPane.addTab("Директор", tabDirectorComponent);
                        }
                        guiApp.getContentPane().add(jTabbedPane);
                        guiApp.repaint();
                        guiApp.revalidate();
                        dialogLogin.setVisible(false);
                        dialogLogin.dispose();
                    }
                });
                dialogLogin.pack();
                dialogLogin.setVisible(true);
                
            }
        });
        guestButtonsComponent.getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                guiApp.getContentPane().remove(guestComponent);
                tabAddReaderComponents = new TabAddReaderComponents(GuiApp.WITH_WINDOWS);
                guiApp.getContentPane().add(tabAddReaderComponents);
                guiApp.repaint();
                guiApp.revalidate();
            }
        });
        if(GuiApp.user == null){
           this.add(guestComponent);
            
        }
        
//        
//        JTabbedPane jTabbedPane = new JTabbedPane();
//        jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
//        jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
//        jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
//        TabReaderComponent tabReaderComponents = new TabReaderComponent(this.getWidth());
//        jTabbedPane.addTab("Читатель", tabReaderComponents);
//        TabManagerComponent tabManagerComponent = new TabManagerComponent(this.getWidth());
//        jTabbedPane.addTab("Библиотекарь", tabManagerComponent);
//        this.getContentPane().add(jTabbedPane);
//        TabDirectorComponent tabDirectorComponent = new TabDirectorComponent(this.getWidth());
//        jTabbedPane.addTab("Директор", tabDirectorComponent);
        
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
