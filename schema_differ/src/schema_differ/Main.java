package schema_differ;

import util.Library;
import gui.EntryFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Main Class for the Application
 *
 * @author ahughes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library lib;

        if (args.length == 6) {
            new CommandLine(args);
        } else {
            try {
                lib = Library.loadLibrary();
            } catch (IOException ex) {
                lib = new Library();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                lib = new Library();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            new EntryFrame(lib);
        }
    }

}
