/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.mycomopnents.GuestButtonsComponent;
import app.mycomopnents.GuestComponent;
import app.mycomopnents.director.TabAddReaderComponents;
import app.mycomopnents.director.TabDirectorComponent;
import app.mycomopnents.manager.TabManagerComponent;
import app.mycomopnents.reader.TabReaderComponents;
import app.mycomopnents.security.LoginFrame;
import entity.Reader;
import entity.Role;
import entity.User;
import entity.UserRoles;
import facade.ReaderFacade;
import facade.RoleFacade;
import facade.UserFacade;
import facade.UserRolesFacade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Melnikov
 */
public class GuiApp extends JFrame{
    public static final int WITH_WINDOWS = 600;
    public static final int HEIGHT_WINDOWS = 450;
    public static User user = null;
    public static String role = null;
    private GuestComponent guestComponent;
    private GuestButtonsComponent guestButtonsComponent;
    private TabAddReaderComponents tabAddReaderComponents;
    private GuiApp guiApp = this;
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
        guestComponent = new GuestComponent();
        guestButtonsComponent = new GuestButtonsComponent("Войти", "Зарегистрироваться", GuiApp.WITH_WINDOWS, 50,100,10,200);
        this.add(guestButtonsComponent);
        guestButtonsComponent.getButton1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               new LoginFrame();
               JTabbedPane jTabbedPane = new JTabbedPane();
               if(GuiApp.user == null){
                 guestButtonsComponent.getInfoComponent().getInfo().setText("Авторизация не удалась");
                 return;
               }
               guiApp.getContentPane().removeAll();
               switch(GuiApp.role){
                 case "ADMINISTRATOR":
                    jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
                    jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
                    jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
                    TabReaderComponents tabReaderComponents = new TabReaderComponents();
                    jTabbedPane.addTab("Читатель", tabReaderComponents);
                    jTabbedPane.setForegroundAt(0, Color.BLUE);
                    TabManagerComponent tabManagerComponent = new TabManagerComponent(guiApp.getWidth());
                    jTabbedPane.addTab("Библиотекарь", tabManagerComponent);
                    jTabbedPane.setForegroundAt(1, Color.BLUE);
                    TabDirectorComponent tabDirectorComponent = new TabDirectorComponent(guiApp.getWidth());
                    jTabbedPane.addTab("Директор", tabDirectorComponent);
                    jTabbedPane.setForegroundAt(2, Color.BLUE);
                   break;
                 case "MANAGER":
                  jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
                  jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
                  jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
                  tabReaderComponents = new TabReaderComponents();
                  jTabbedPane.addTab("Читатель", tabReaderComponents);
                  jTabbedPane.setForegroundAt(1, Color.BLUE);
                  tabManagerComponent = new TabManagerComponent(guiApp.getWidth());
                  jTabbedPane.addTab("Библиотекарь", tabManagerComponent);
                  jTabbedPane.setForegroundAt(0, Color.BLUE);
                   break;
                 case "READER":
                  jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
                  jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
                  jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
                  tabReaderComponents = new TabReaderComponents();
                  jTabbedPane.addTab("Читатель", tabReaderComponents);
                  jTabbedPane.setForegroundAt(0, Color.BLUE);
                   break;
               }
               guiApp.getContentPane().add(jTabbedPane);
               guiApp.repaint();
               guiApp.revalidate();
                 
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
        this.add(guestComponent);
        
//        
//        JTabbedPane jTabbedPane = new JTabbedPane();
//        jTabbedPane.setPreferredSize(new Dimension(WITH_WINDOWS,HEIGHT_WINDOWS));
//        jTabbedPane.setMinimumSize(jTabbedPane.getPreferredSize());
//        jTabbedPane.setMaximumSize(jTabbedPane.getPreferredSize());
//        TabReaderComponents tabReaderComponents = new TabReaderComponents(this.getWidth());
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
