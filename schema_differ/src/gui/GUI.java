
package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import sql.Connector;

/**
 * The abstract GUI class for the frames.
 * 
 * @author Alex Hughes
 */
public abstract class GUI extends JFrame {
    
    protected GUI pFrame;
    protected Connector c1;
    protected Connector c2;
    protected static final int NIL = -1;
    
    public GUI() {
        
    }
    
    public GUI(GUI aPreviousFrame, Connector aConnector1, Connector aConnector2) {
        pFrame = aPreviousFrame;
        c1 = aConnector1;
        c2 = aConnector2;
    }
    

    public void setFrameLocationCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = this.getSize();

        int windowX = Math.max(0, (screenSize.width - windowSize.width) / 2);
        int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);

        this.setLocation(windowX, windowY);
    }
    
    protected void shutdown() {
        pFrame.setVisible(true);
        this.dispose();
    }
    
 public void popupMenuField(JTextField aTf) {

        JPopupMenu popupMenu = new JPopupMenu();
        ActionListener actionListener = new PopupActionListener(aTf);
        // Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);
        // Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);
        // Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        popupMenu.add(pasteMenuItem);

        aTf.setComponentPopupMenu(popupMenu);
        
    }

    public void popupMenuArea(JTextArea aTa) {

        JPopupMenu popupMenu = new JPopupMenu();
        ActionListener actionListener = new PopupActionListener(aTa);
        // Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);
        // Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);
        // Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        popupMenu.add(pasteMenuItem);

        aTa.setComponentPopupMenu(popupMenu);
    }
}
class PopupActionListener implements ActionListener {

    private JTextField tf;
    private JTextArea ta;

    public PopupActionListener(JTextField Tf) {
        tf = Tf;
    }

    public PopupActionListener(JTextArea Ta) {
        ta = Ta;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Cut")) {
            if (tf != null) {
                tf.cut();
            } else {
                ta.cut();
            }
        }
        if (actionEvent.getActionCommand().equals("Copy")) {
            if (tf != null) {
                tf.copy();
            } else {
                ta.copy();
            }
        }
        if (actionEvent.getActionCommand().equals("Paste")) {
            if (tf != null) {
                tf.paste();
            } else {
                ta.paste();
            }
        }
    }
}

