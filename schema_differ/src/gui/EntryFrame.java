package gui;

import entities.Diff;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import schema_differ.DBLayer;
import sql.*;
import util.Library;
import util.MesDial;

/**
 * The Entry Frame where the user inserts the credentials for the databases he
 * wants to execute the diff
 *
 * @author ahughes
 */
public class EntryFrame extends GUI {

    private Library lib;

    public EntryFrame(Library aLibrary) {
        lib = aLibrary;

        initComponents();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        loadCombos(true);

        super.setFrameLocationCenter();
        this.setVisible(true);
    }

    /**
     * Closes all connections, saves library and exits
     */
    private void exit() {
        try {
            c1.closeConnection();
            c2.closeConnection();
            Library.saveLibrary(lib);
        } catch (SQLException ex) {
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }

    /**
     * Parses and returns the credentials of a Connection
     *
     * @param aConnection
     * @return
     */
    private Credentials parseCredentials(int aConnection) {
        Credentials cre = null;
        String password, user, uri;

        //preprocessing and fetching the data
        if (aConnection == 1) {
            password = new String(pass1F.getPassword());
            user = user1F.getText();
            uri = (String) uri1Cmb.getSelectedItem();
        } else {
            password = new String(pass2F.getPassword());
            user = user2F.getText();
            uri = (String) uri2Cmb.getSelectedItem();
        }
        //creating the credentials
        cre = new Credentials(uri, user, password);
        return cre;
    }

    /**
     * Checks the validity of a pair of credentials
     *
     * @param aConnection
     */
    private void checkConnection(int aConnection) {
        Credentials cre = null;
        Connector c;

        try {
            if (aConnection == 1) {
                cre = parseCredentials(1);
            } else if (aConnection == 2) {
                cre = parseCredentials(2);
            }
            //opening and closing a connection
            c = new Connector(cre);
            c.closeConnection();
            MesDial.conSuccess(this);
        } catch (SQLException ex) {
            MesDial.conError(this);
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            MesDial.programError(this);
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Saves the credentials of a connection
     *
     * @param aConnection
     */
    private void saveCredentials(int aConnection) {

        lib.addCredentials(parseCredentials(aConnection));
        try {
            Library.saveLibrary(lib);
            loadCombos(false);
            MesDial.fileSuccess(this);
        } catch (IOException ex) {
            MesDial.conError(this);
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Deletes the credentials of a connection
     *
     * @param aConnection
     */
    private void deleteCredentials(int aConnection) {

        lib.deleteCredentials(parseCredentials(aConnection));
        try {
            Library.saveLibrary(lib);
            loadCombos(false);
            MesDial.fileSuccess(this);
        } catch (IOException ex) {
            MesDial.fileError(this);
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Loads the two combo boxes with the uris
     */
    private void loadCombos(boolean initialisation) {
        //cleaning combos first
        uri1Cmb.removeAllItems();
        uri2Cmb.removeAllItems();

        //fetching the objects and filling the combos
        ArrayList<Credentials> credentials = lib.getCredentials();
        for (Credentials c : credentials) {
            uri1Cmb.addItem(c.getUri());
            uri2Cmb.addItem(c.getUri());
        }

        //if this is the first time the combo boxes are initialised, clean the indexes
        if (initialisation) {
            uri1Cmb.setSelectedIndex(-1);
            uri2Cmb.setSelectedIndex(-1);
        }
    }

    private void compare() {
        try {
            Credentials cre1 = parseCredentials(1);
            c1 = new Connector(cre1);

            Credentials cre2 = parseCredentials(2);
            c2 = new Connector(cre2);

            new ResultFrame(this, c1, c2);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        schema1Panel = new javax.swing.JPanel();
        uri1Cmb = new javax.swing.JComboBox();
        uri1Lbl = new javax.swing.JLabel();
        user1Lbl = new javax.swing.JLabel();
        user1F = new javax.swing.JTextField();
        pass1Lbl = new javax.swing.JLabel();
        pass1F = new javax.swing.JPasswordField();
        check1Btn = new javax.swing.JButton();
        save1Btn = new javax.swing.JButton();
        del1Btn = new javax.swing.JButton();
        footerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        schema2Panel = new javax.swing.JPanel();
        uri2Cmb = new javax.swing.JComboBox();
        uri2Lbl = new javax.swing.JLabel();
        user2Lbl = new javax.swing.JLabel();
        user2F = new javax.swing.JTextField();
        pass2Lbl = new javax.swing.JLabel();
        pass2F = new javax.swing.JPasswordField();
        del2Btn = new javax.swing.JButton();
        save2Btn = new javax.swing.JButton();
        check2Btn = new javax.swing.JButton();
        btnPanel = new javax.swing.JPanel();
        quitBtn = new javax.swing.JButton();
        compareBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        schema1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("First Schema"));

        uri1Cmb.setEditable(true);
        uri1Cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uri1CmbItemStateChanged(evt);
            }
        });

        uri1Lbl.setText("URI:");

        user1Lbl.setText("Username:");

        pass1Lbl.setText("Password:");

        check1Btn.setText("Check");
        check1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1BtnActionPerformed(evt);
            }
        });

        save1Btn.setText("Save");
        save1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1BtnActionPerformed(evt);
            }
        });

        del1Btn.setText("Delete");
        del1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del1BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout schema1PanelLayout = new javax.swing.GroupLayout(schema1Panel);
        schema1Panel.setLayout(schema1PanelLayout);
        schema1PanelLayout.setHorizontalGroup(
            schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schema1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass1Lbl)
                    .addComponent(user1Lbl)
                    .addComponent(uri1Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schema1PanelLayout.createSequentialGroup()
                        .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user1F)
                            .addComponent(pass1F, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(check1Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save1Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(del1Btn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(uri1Cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        schema1PanelLayout.setVerticalGroup(
            schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schema1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uri1Cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uri1Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user1Lbl)
                    .addComponent(user1F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check1Btn)
                    .addComponent(save1Btn)
                    .addComponent(del1Btn))
                .addGap(18, 18, 18)
                .addGroup(schema1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass1Lbl)
                    .addComponent(pass1F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        footerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Schema Differ. Developed by Alex Hughes <ahughes@ahughes.org>");

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        schema2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Second Schema"));

        uri2Cmb.setEditable(true);
        uri2Cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                uri2CmbItemStateChanged(evt);
            }
        });

        uri2Lbl.setText("URI:");

        user2Lbl.setText("Username:");

        pass2Lbl.setText("Password:");

        del2Btn.setText("Delete");
        del2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del2BtnActionPerformed(evt);
            }
        });

        save2Btn.setText("Save");
        save2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2BtnActionPerformed(evt);
            }
        });

        check2Btn.setText("Check");
        check2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout schema2PanelLayout = new javax.swing.GroupLayout(schema2Panel);
        schema2Panel.setLayout(schema2PanelLayout);
        schema2PanelLayout.setHorizontalGroup(
            schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schema2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass2Lbl)
                    .addComponent(user2Lbl)
                    .addComponent(uri2Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schema2PanelLayout.createSequentialGroup()
                        .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user2F)
                            .addComponent(pass2F, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(check2Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save2Btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(del2Btn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(uri2Cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        schema2PanelLayout.setVerticalGroup(
            schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schema2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uri2Cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uri2Lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(check2Btn)
                        .addComponent(save2Btn)
                        .addComponent(del2Btn))
                    .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(user2Lbl)
                        .addComponent(user2F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass2Lbl)
                    .addComponent(pass2F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        quitBtn.setText("<Quit");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });

        compareBtn.setText("Compare");
        compareBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(compareBtn)
                .addContainerGap())
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitBtn)
                    .addComponent(compareBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem4.setText("Import");
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Export");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Disconnect");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem5.setText("How to use Schema Differ");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("About");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schema1Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(schema2Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schema1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schema2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1BtnActionPerformed
        checkConnection(1);
    }//GEN-LAST:event_check1BtnActionPerformed

    private void check2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2BtnActionPerformed
        checkConnection(2);
    }//GEN-LAST:event_check2BtnActionPerformed

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        exit();
    }//GEN-LAST:event_quitBtnActionPerformed

    private void save1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1BtnActionPerformed
        saveCredentials(1);
    }//GEN-LAST:event_save1BtnActionPerformed

    private void uri1CmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uri1CmbItemStateChanged
        String eventItem = (String) evt.getItem();
        String comboItem = (String) uri1Cmb.getSelectedItem();

        if (comboItem != null && !comboItem.equals(eventItem)) {
            String uri = (String) uri1Cmb.getSelectedItem();
            Credentials cre = lib.searchCredentials(uri);
            user1F.setText(cre.getUser());
            System.out.println("Combo1 state changed");
        }

    }//GEN-LAST:event_uri1CmbItemStateChanged

    private void uri2CmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_uri2CmbItemStateChanged
        String eventItem = (String) evt.getItem();
        String comboItem = (String) uri2Cmb.getSelectedItem();

        if (comboItem != null && !comboItem.equals(eventItem)) {
            String uri = (String) uri2Cmb.getSelectedItem();
            Credentials cre = lib.searchCredentials(uri);
            user2F.setText(cre.getUser());
            System.out.println("Combo2 state changed");
        }
    }//GEN-LAST:event_uri2CmbItemStateChanged

    private void compareBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareBtnActionPerformed
        compare();
    }//GEN-LAST:event_compareBtnActionPerformed

    private void save2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2BtnActionPerformed
        saveCredentials(2);
    }//GEN-LAST:event_save2BtnActionPerformed

    private void del1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del1BtnActionPerformed
        deleteCredentials(1);
    }//GEN-LAST:event_del1BtnActionPerformed

    private void del2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del2BtnActionPerformed
        deleteCredentials(2);
    }//GEN-LAST:event_del2BtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton check1Btn;
    private javax.swing.JButton check2Btn;
    private javax.swing.JButton compareBtn;
    private javax.swing.JButton del1Btn;
    private javax.swing.JButton del2Btn;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPasswordField pass1F;
    private javax.swing.JLabel pass1Lbl;
    private javax.swing.JPasswordField pass2F;
    private javax.swing.JLabel pass2Lbl;
    private javax.swing.JButton quitBtn;
    private javax.swing.JButton save1Btn;
    private javax.swing.JButton save2Btn;
    private javax.swing.JPanel schema1Panel;
    private javax.swing.JPanel schema2Panel;
    private javax.swing.JComboBox uri1Cmb;
    private javax.swing.JLabel uri1Lbl;
    private javax.swing.JComboBox uri2Cmb;
    private javax.swing.JLabel uri2Lbl;
    private javax.swing.JTextField user1F;
    private javax.swing.JLabel user1Lbl;
    private javax.swing.JTextField user2F;
    private javax.swing.JLabel user2Lbl;
    // End of variables declaration//GEN-END:variables
}
