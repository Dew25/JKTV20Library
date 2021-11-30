/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3;

import entity.Reader;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author jvm
 */
class JManagerPanel extends JPanel{

  public JManagerPanel() {
    this.add(getPanelCaption());
  }

  public JPanel getPanelCaption() {
    JPanel panelCaption = new JPanel();
    panelCaption.setPreferredSize(new Dimension(480,290));
    panelCaption.setMaximumSize(panelCaption.getPreferredSize());
    
    JLabel labelCaption = new JLabel("Название книги",SwingConstants.RIGHT);
    labelCaption.setPreferredSize(new Dimension(120,27));
    labelCaption.setMaximumSize(labelCaption.getPreferredSize());
    panelCaption.add(labelCaption);
    
    JTextField jTextField = new JTextField();
    jTextField.setPreferredSize(new Dimension(300,27));
    jTextField.setMaximumSize(jTextField.getPreferredSize());
    panelCaption.add(jTextField);
    return panelCaption;
  }

  
  
}
