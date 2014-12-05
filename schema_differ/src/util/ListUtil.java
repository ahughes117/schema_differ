package util;

import entities.Diff;
import java.util.ArrayList;
import javax.swing.JList;

/**
 * JList Utilities
 *
 * @author ahughes
 */
public class ListUtil {

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
}
