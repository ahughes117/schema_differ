package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import schema_differ.Library;

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
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        schema1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("First Schema"));

        uri1Cmb.setEditable(true);

        uri1Lbl.setText("URI:");

        user1Lbl.setText("Username:");

        pass1Lbl.setText("Password:");

        check1Btn.setText("Check");

        save1Btn.setText("Save");

        del1Btn.setText("Delete");

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

        uri2Lbl.setText("URI:");

        user2Lbl.setText("Username:");

        pass2Lbl.setText("Password:");

        del2Btn.setText("Delete");

        save2Btn.setText("Save");

        check2Btn.setText("Check");

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
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user2Lbl)
                    .addComponent(user2F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(check2Btn)
                        .addComponent(save2Btn)
                        .addComponent(del2Btn)))
                .addGap(18, 18, 18)
                .addGroup(schema2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass2Lbl)
                    .addComponent(pass2F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        quitBtn.setText("<Quit");

        compareBtn.setText("Compare");

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton check1Btn;
    private javax.swing.JButton check2Btn;
    private javax.swing.JButton compareBtn;
    private javax.swing.JButton del1Btn;
    private javax.swing.JButton del2Btn;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField2;
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