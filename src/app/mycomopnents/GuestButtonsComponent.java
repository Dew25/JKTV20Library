/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mycomopnents;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Melnikov
 */
public class GuestButtonsComponent extends JPanel{
    private JLabel caption;
    private InfoComponent infoComponent;
    private JButton button1;
    private JButton button2;
    /**
     * Компонент кнопки
     * @param text текст в кнопке
     * @param widthWindow ширина панели в которой находится кнопка
     * @param heightPanel высота панели в которой находится кнопка
     * @param left отступ слева от кнопки
     * @param buttonWidth ширина кнопки
     */
    public GuestButtonsComponent(String text1,String text2, int widthWindow,int heightPanel,int left, int between,int buttonWidth) {
        initComponents(text1, text2, widthWindow, heightPanel,left,between, buttonWidth);
    }

    private void initComponents(String text1, String text2, int widthWindow, int heightPanel, int left, int between, int buttonWidth) {
        this.setPreferredSize(new Dimension(widthWindow,heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(Box.createRigidArea(new Dimension(left, 27)));
        button1 = new JButton(text1);
        button1.setPreferredSize(new Dimension(buttonWidth, 27));
        button1.setMaximumSize(button1.getPreferredSize());
        button1.setMinimumSize(button1.getPreferredSize());
        this.add(button1);
        this.add(Box.createRigidArea(new Dimension(between, 27)));
        button2 = new JButton(text2);
        button2.setPreferredSize(new Dimension(buttonWidth, 27));
        button2.setMaximumSize(button2.getPreferredSize());
        button2.setMinimumSize(button2.getPreferredSize());
        this.add(button2);
        infoComponent = new InfoComponent("", widthWindow, 27);
        this.add(infoComponent);
    }

    public JButton getButton1() {
        return button1;
    }
    public JButton getButton2() {
        return button2;
    }
    public InfoComponent getInfoComponent(){
        return infoComponent;
    }
}
