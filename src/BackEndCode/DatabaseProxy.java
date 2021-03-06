package BackEndCode;

import javafx.application.Platform;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseProxy implements Database {

    Database db = new RealDatabase();
    private static List<String> bannedusers;

    static {
        bannedusers = new ArrayList<>();
        bannedusers.add("Hacker");
        bannedusers.add("crackhead");
        bannedusers.add("hack 123");
        bannedusers.add("hacker");
        bannedusers.add("hack");
    }

    @Override
    public void authentication(String username, String password) throws Exception {

        if (bannedusers.contains(username) ){
            JOptionPane.showMessageDialog(null, "This kind of names are banned");
            Platform.exit();
        }
        else
      db.authentication(username, password);
}

    @Override
    public String returnuser() {
        return db.returnuser();
    }

    @Override
    public String returnpass() {
        return  db.returnpass();
    }

    @Override
    public void registeruserdetail(String fn, String ln, String Phonenumber, String email, String cnic) {
        db.registeruserdetail(fn, ln, Phonenumber, email, cnic);
    }

    @Override
    public void signupuser(String username, String Email, String Password) throws SQLException, ClassNotFoundException {

        if (bannedusers.contains(username.toLowerCase())){
            JOptionPane.showMessageDialog(null, "The name which you entered is invalid.");

        }
        else
        db.signupuser(username, Email, Password);

    }

}
