package util;

import java.io.*;
import java.util.ArrayList;
import sql.Credentials;

/**
 * The Library Class contains the functionality for loading/saving used urls
 *
 * @author ahughes
 */
public class Library implements Serializable {

    private ArrayList<Credentials> credentialsL;

    public Library(ArrayList<Credentials> aCredentialsL) {
        credentialsL = aCredentialsL;
    }

    public Library() {
        credentialsL = new ArrayList();
    }

    /**
     * Adds a credential object to the list
     *
     * @param aCredentials
     */
    public void addCredentials(Credentials aCredentials) {
        if (!credentialsL.contains(aCredentials)) {
            credentialsL.add(aCredentials);
        }
    }

    /**
     * Removes a credential object from the list
     * 
     * @param aCredentials 
     */
    public void deleteCredentials(Credentials aCredentials) {
        credentialsL.remove(aCredentials);
    }

    /**
     * Looks for a particular URI and returns full details (URI, user) Returns
     * NULL if URI not found
     *
     * @param aUri
     * @return
     */
    public Credentials searchCredentials(String aUri) {
        int index = credentialsL.indexOf(new Credentials(aUri));

        //if the URI was not found, return null
        if (index == -1) {
            return null;
        } else {
            return credentialsL.get(index);
        }
    }

    /**
     * Saves a Library Object along with the credentials ArrayList it contains
     *
     * @param aLibrary
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveLibrary(Library aLibrary) throws FileNotFoundException, IOException {
        //creating the streams
        try (FileOutputStream fileOut = new FileOutputStream("history.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            //writing the objects to file
            out.writeObject(aLibrary);
            out.close();
        }
    }

    /**
     * Loads a Library Object along with the credentials ArrayList it contains
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Library loadLibrary() throws FileNotFoundException, IOException, ClassNotFoundException {
        Library lib = null;

        //creating the streams
        FileInputStream fileIn = new FileInputStream("history.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        //reading the object
        Object o = in.readObject();

        if (o instanceof Library) {
            lib = (Library) o;
        }
        return lib;
    }

    public ArrayList<Credentials> getCredentials() {
        return credentialsL;
    }
}
