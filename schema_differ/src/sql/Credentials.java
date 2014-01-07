
package sql;

import java.io.Serializable;

/**
 * The Credentials Entity Class
 * 
 * @author ahughes
 */
public class Credentials implements Serializable {
    
    private String url;
    private String user;
    private volatile String pass;
    
    public Credentials(String aUrl, String aUser, String aPass) {
        url = aUrl;
        user = aUser;
        pass = aPass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
