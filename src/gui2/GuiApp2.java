/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import entity.Author;
import entity.Book;
import entity.Reader;
import interfaces.Keeping;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.event.ListDataListener;
import keeper.BaseKeeper;

/**
 *
 * @author jvm
 */
public class GuiApp2 extends javax.swing.JFrame {
  private Keeping keeper = new BaseKeeper();
  private List<Book> books;
  private List<Reader> readers;
  private JPanelReader jPanelReader;
  
  /**
   * Creates new form GuiApp2
   */
  public GuiApp2() {
    books = keeper.loadBooks();
    readers = keeper.loadReaders();
    ComboBoxModel readersListModel= getReadersListModel();
    if(readersListModel.getSize()!= 0){
      jComboBoxReaders.setModel(readersListModel);
      jComboBoxReaders.setRenderer(createListReadersRenderer());
      jComboBoxReaders.addItemListener(itemListener);
    }
    ListModel booksListModel = getBooksListModel();
    if(booksListModel.getSize() != 0){
      //jListBooks.setModel(getBooksListModel());
     // jListBooks.setCellRenderer(createListBooksRenderer());
    }

    initComponents();
    setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list3 = new java.awt.List();
        jPanelGeneral = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        labelReaders = new java.awt.Label();
        btnReader = new javax.swing.JButton();
        btnManager = new javax.swing.JButton();
        btnDirctor = new javax.swing.JButton();
        jComboBoxReaders = new javax.swing.JComboBox<>();
        panelCardMain = new java.awt.Panel();
        cardDirector = new java.awt.Panel();
        labelManager = new java.awt.Label();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelFirstName = new javax.swing.JLabel();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jButtonAddReader = new javax.swing.JButton();
        cardReader = new java.awt.Panel();
        jLabelBooks = new javax.swing.JLabel();
        jButtonTakeOutBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBooks = new javax.swing.JList<>();
        cardManager = new java.awt.Panel();
        jButtonAddBook = new javax.swing.JButton();
        JTextFieldBookName = new javax.swing.JTextField();
        jLabelBookName = new javax.swing.JLabel();
        jLabelPublishedYear = new javax.swing.JLabel();
        JTextFieldPublishedYear = new javax.swing.JTextField();
        jLabelQuantity = new javax.swing.JLabel();
        JTextFieldQuantity = new javax.swing.JTextField();
        jLabelAuthors = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(480, 290));
        setMinimumSize(new java.awt.Dimension(480, 290));

        jPanelGeneral.setMaximumSize(new java.awt.Dimension(480, 290));
        jPanelGeneral.setMinimumSize(new java.awt.Dimension(480, 290));
        jPanelGeneral.setPreferredSize(new java.awt.Dimension(480, 290));

        jLabelTitle.setText("Выберите свою роль");

        labelReaders.setText("Выберите себя");

        btnReader.setText("Читатель");
        btnReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReaderActionPerformed(evt);
            }
        });

        btnManager.setText("Библиотекарь");
        btnManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerActionPerformed(evt);
            }
        });

        btnDirctor.setText("Директор");
        btnDirctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirctorActionPerformed(evt);
            }
        });

        panelCardMain.setMaximumSize(new java.awt.Dimension(480, 290));
        panelCardMain.setPreferredSize(new java.awt.Dimension(480, 290));
        panelCardMain.setLayout(new java.awt.CardLayout());

        cardDirector.setMaximumSize(new java.awt.Dimension(480, 290));
        cardDirector.setMinimumSize(new java.awt.Dimension(480, 90));
        cardDirector.setPreferredSize(new java.awt.Dimension(480, 290));

        labelManager.setText("Заполните форму");

        jLabelFirstName.setText("Имя");
        jLabelFirstName.setName("Имя"); // NOI18N

        jLabelLastName.setText("Фамилия");

        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });

        jLabelPhone.setText("Телефон");

        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });

        jButtonAddReader.setText("Добавить читателя");
        jButtonAddReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddReaderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardDirectorLayout = new javax.swing.GroupLayout(cardDirector);
        cardDirector.setLayout(cardDirectorLayout);
        cardDirectorLayout.setHorizontalGroup(
            cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDirectorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardDirectorLayout.createSequentialGroup()
                        .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cardDirectorLayout.createSequentialGroup()
                                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAddReader, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardDirectorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        cardDirectorLayout.setVerticalGroup(
            cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDirectorLayout.createSequentialGroup()
                .addComponent(labelManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardDirectorLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardDirectorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLastName)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddReader)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        labelManager.getAccessibleContext().setAccessibleName("Выберите библиотекаря");
        jLabelFirstName.getAccessibleContext().setAccessibleName("");

        panelCardMain.add(cardDirector, "cardDirector");

        jLabelBooks.setText("Выбери книгу для чтения");

        jButtonTakeOutBook.setText("Нажми, чтобы взять книгу");
        jButtonTakeOutBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTakeOutBookActionPerformed(evt);
            }
        });

        jListBooks.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListBooks);

        javax.swing.GroupLayout cardReaderLayout = new javax.swing.GroupLayout(cardReader);
        cardReader.setLayout(cardReaderLayout);
        cardReaderLayout.setHorizontalGroup(
            cardReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardReaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonTakeOutBook)
                .addGap(25, 25, 25))
            .addGroup(cardReaderLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(cardReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBooks)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        cardReaderLayout.setVerticalGroup(
            cardReaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardReaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTakeOutBook)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCardMain.add(cardReader, "cardReader");

        jButtonAddBook.setText("Добавить книгу");
        jButtonAddBook.setActionCommand("");

        JTextFieldBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldBookNameActionPerformed(evt);
            }
        });

        jLabelBookName.setText("Название книги");

        jLabelPublishedYear.setText("Название книги");

        JTextFieldPublishedYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldPublishedYearActionPerformed(evt);
            }
        });

        jLabelQuantity.setText("Название книги");

        JTextFieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldQuantityActionPerformed(evt);
            }
        });

        jLabelAuthors.setText("Авторы");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout cardManagerLayout = new javax.swing.GroupLayout(cardManager);
        cardManager.setLayout(cardManagerLayout);
        cardManagerLayout.setHorizontalGroup(
            cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardManagerLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardManagerLayout.createSequentialGroup()
                        .addComponent(jLabelPublishedYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldPublishedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardManagerLayout.createSequentialGroup()
                        .addComponent(jLabelBookName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardManagerLayout.createSequentialGroup()
                        .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelQuantity)
                            .addComponent(jLabelAuthors))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTextFieldQuantity)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        cardManagerLayout.setVerticalGroup(
            cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBookName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldPublishedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPublishedYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAuthors)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelCardMain.add(cardManager, "cardManager");

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabelTitle))
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelReaders, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManager)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDirctor))
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxReaders, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addGap(481, 481, 481)
                .addComponent(panelCardMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addGap(10, 10, 10)
                .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReader)
                    .addComponent(btnManager)
                    .addComponent(btnDirctor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelReaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxReaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(panelCardMain, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        labelReaders.getAccessibleContext().setAccessibleName("Читатель");
        panelCardMain.getAccessibleContext().setAccessibleName("cardMain");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btnReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReaderActionPerformed
    CardLayout card = (CardLayout) panelCardMain.getLayout();
    card.show(panelCardMain, "card2");
//    if(jPanelReader == null){
//      jPanelReader = new JPanelReader();
//    }
//    this.setContentPane(jPanelReader);
//    jPanelReader.setVisible(true);
  }//GEN-LAST:event_btnReaderActionPerformed

  private void btnManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerActionPerformed
    CardLayout card = (CardLayout) panelCardMain.getLayout();
    card.show(panelCardMain, "card3");
  }//GEN-LAST:event_btnManagerActionPerformed

  private void btnDirctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirctorActionPerformed
    CardLayout card = (CardLayout) panelCardMain.getLayout();
    card.show(panelCardMain, "card4");
  }//GEN-LAST:event_btnDirctorActionPerformed

  private void jButtonTakeOutBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTakeOutBookActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButtonTakeOutBookActionPerformed

  private void JTextFieldBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldBookNameActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_JTextFieldBookNameActionPerformed

  private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextFieldLastNameActionPerformed

  private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

  private void jButtonAddReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddReaderActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButtonAddReaderActionPerformed

  private void JTextFieldPublishedYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldPublishedYearActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_JTextFieldPublishedYearActionPerformed

  private void JTextFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldQuantityActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_JTextFieldQuantityActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(GuiApp2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(GuiApp2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(GuiApp2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GuiApp2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GuiApp2().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldBookName;
    private javax.swing.JTextField JTextFieldPublishedYear;
    private javax.swing.JTextField JTextFieldQuantity;
    private javax.swing.JButton btnDirctor;
    private javax.swing.JButton btnManager;
    private javax.swing.JButton btnReader;
    private java.awt.Panel cardDirector;
    private java.awt.Panel cardManager;
    private java.awt.Panel cardReader;
    private javax.swing.JButton jButtonAddBook;
    private javax.swing.JButton jButtonAddReader;
    private javax.swing.JButton jButtonTakeOutBook;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<Reader> jComboBoxReaders;
    private javax.swing.JLabel jLabelAuthors;
    private javax.swing.JLabel jLabelBookName;
    private javax.swing.JLabel jLabelBooks;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelPublishedYear;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListBooks;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPhone;
    private java.awt.Label labelManager;
    private java.awt.Label labelReaders;
    private java.awt.List list3;
    private java.awt.Panel panelCardMain;
    // End of variables declaration//GEN-END:variables
  private ListCellRenderer<? super Reader> createListReadersRenderer(){
      return new DefaultListCellRenderer(){
          private final Color background = new Color(0, 100, 255, 15);
          private final Color defaultBackground = (Color) UIManager.get("List.background");
          @Override
          public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
              Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
              if (component instanceof JLabel) {
                  JLabel label = (JLabel) component;
                  Reader reader = (Reader) value;
                  label.setText(String.format("%d. %s. %s. Телефон: %s%n"
                          ,reader.getId()
                          ,reader.getFirstname()
                          ,reader.getLastname()
                          ,reader.getPhone()
                  ));
                  if (!isSelected) {
                      label.setBackground(index % 2 == 0 ? background : defaultBackground);
                  }
              }
              return component;
          }
      };
  }
  
  ItemListener itemListener = new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        ItemSelectable is = itemEvent.getItemSelectable();
        
      }

        
  };
  private ListModel<Book> getBooksListModel(){
    DefaultListModel<Book> models = new DefaultListModel<>();
    for(Book book: books){
      models.addElement(book);
    }
    return models;
  } 
  private ComboBoxModel<Reader> getReadersListModel(){
    DefaultComboBoxModel<Reader> models = new DefaultComboBoxModel<Reader>();
    for(Reader reader:readers){
      models.addElement(reader);
    }
    return models;
  }
  private ListCellRenderer<? super Book> createListBooksRenderer() {
    return new DefaultListCellRenderer(){
        private final Color background = new Color(0, 100, 255, 15);
        private final Color defaultBackground = (Color) UIManager.get("List.background");

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                Book book = (Book) value;
                label.setText(String.format("%d. %s. %s %d. В наличии: %d%n"
                        ,book.getId()
                        ,book.getCaption()
                        ,listStringAuthors(book.getAuthor())
                        ,book.getPublishedYear()
                        ,book.getCount()
                ));
                if (!isSelected) {
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
            }
            return component;
        }
        private String listStringAuthors(List<Author> authors){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < authors.size(); i++) {
                sb.append(authors.get(i).getName())
                  .append(" ")
                  .append(authors.get(i).getLastname())
                  .append(". ");
            }
            return sb.toString();
        }
    };
  }
}
