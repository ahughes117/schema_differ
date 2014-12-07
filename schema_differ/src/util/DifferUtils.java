package util;

import entities.Diff;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JList;

/**
 * Utilities
 *
 * @author ahughes
 */
public class DifferUtils {

    /**
     * Receives a Diff List and a JList and populates the latter with the first.
     *
     * @param aDiffL
     * @param aList
     */
    public static void fillList(ArrayList<Diff> aDiffL, JList aList) {
        ArrayList<String> items = new ArrayList();
        String[] itemArray = new String[aDiffL.size()];

        //iterating and converting the diff objects to their string representation
        for (Diff d : aDiffL) {
            items.add(d.toString());
        }

        //converting the ArrayList to a String Array
        for (int i = 0; i < items.size(); i++) {
            itemArray[i] = items.get(i);
        }

        //finally removing and then adding the items to the list
        aList.removeAll();
        aList.setListData(itemArray);
    }

    /**
     * This function takes a String with some content and a String which is the
     * filename, writes the content to the file using UTF-8 encoding and finally
     * closes the file.
     *
     * @param aContent
     * @param aFileName
     * @throws IOException
     */
    public static void writeFile(String aContent, String aFileName) throws IOException {
        BufferedWriter fr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFileName), "UTF8"));
        fr.write(aContent);
        fr.close();
    }
}
