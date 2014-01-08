package sql;

import java.io.Serializable;

/**
 * The Credentials Entity Class
 *
 * @author ahughes
 */
public class Credentials implements Serializable, Comparable {

    private String uri;
    private String user;
    private volatile String pass;

    public Credentials(String aUri, String aUser, String aPass) {
        uri = aUri;
        user = aUser;
        pass = aPass;
    }

    @Override
    public String toString() {
        return uri;
    }

    @Override
    public boolean equals(Object o) {
        Credentials credE = (Credentials) o;

        //comparing agains URI and username at the same time
        if (credE.getUri().equals(this.getUri())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        Credentials credE = (Credentials) o;

        //comparing against the URI as well as the username, case sensitively.
        int result;
        result = credE.getUri().compareTo(this.getUri());
        
        return result;
    }

    public String getUri() {
        return uri;
    }

    public void setUrl(String uri) {
        this.uri = uri;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
