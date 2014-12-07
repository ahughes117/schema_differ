package schema_differ;

import entities.Diff;
import java.util.ArrayList;
import sql.Connector;
import sql.Credentials;

/**
 * The Class that operates schema differ via command line
 *
 * @author ahughes
 */
public class CommandLine {

    private String[] args;
    private Credentials cre1;
    private Credentials cre2;
    private Connector c1;
    private Connector c2;
    private DBLayer db;
    private ArrayList<Diff> diffs;

    public CommandLine(String[] anArgArray) {
        args = anArgArray;

        boolean isSuccessful = true;

        //parsing the credentials from the args first
        try {
            cre1 = fetchCredentials(1);
            cre2 = fetchCredentials(2);
            System.out.println("Credentials parsed successfully");
        } catch (Exception x) {
            System.err.println(x.getMessage());
            isSuccessful = false;
        }

        //then creating the connectors
        if (isSuccessful) {
            try {
                c1 = new Connector(cre1);
                c2 = new Connector(cre2);
            } catch (Exception x) {
                x.printStackTrace();
                System.err.println("Error while attempting to connect to databases");
                isSuccessful = false;
            }
        } else {
            System.exit(1);
        }

        //if the connection was successful, carry on comparing
        if (isSuccessful) {
            try {
                db = new DBLayer(c1, c2);
                diffs = db.compare();
            } catch (Exception x) {
                x.printStackTrace();
                System.err.println("Error while comparing the schemas");
                isSuccessful = false;
            }
        } else {
            System.exit(1);
        }

        //finally printing the results in the result.txt file
        if (isSuccessful) {
            try {
                db.printReport(diffs);
            } catch (Exception x) {
                x.printStackTrace();
                System.err.println("Error while attempting to create the report");
                isSuccessful = false;
            }
        } else {
            System.exit(1);
        }

        //finally exiting
        if (isSuccessful) {
            System.out.println("Finished");
            try {
                c1.closeConnection();
                c2.closeConnection();
            } catch (Exception x) {
                System.err.println("Error while terminating connections, nevermind, exiting");
            }
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

    /**
     * Creates a credential object from the command line params
     *
     * @param aSchema
     * @return
     * @throws Exception
     */
    private Credentials fetchCredentials(int aSchema) throws Exception {
        Credentials cre;

        if (aSchema == 1) {
            cre = new Credentials(args[0], args[1], args[2]);
        } else if (aSchema == 2) {
            cre = new Credentials(args[3], args[4], args[5]);
        } else {
            throw new Exception("Invalid fetchCredentials use");
        }
        return cre;
    }

}
