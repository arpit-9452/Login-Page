import java.util.HashMap;

public class IDandPassword {
    HashMap<String,String> logininfo = new HashMap<String,String>();
    IDandPassword(){
        logininfo.put("Bro","Pizza");
        logininfo.put("Arpit","Passwords");
        logininfo.put("Chauhan","pusu30398");
    }
    protected HashMap getLogininfo(){
        return logininfo;
    }
}

//Stops at 27:37s
