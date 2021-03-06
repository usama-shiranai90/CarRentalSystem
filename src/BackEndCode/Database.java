package BackEndCode;

import java.sql.SQLException;

public interface Database {

    String databaseURL = "jdbc:mysql://localhost:3306/SDAProject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String sqluser = "root";
    String sqlpassword = "";
    String driversql = "com.mysql.cj.jdbc.Driver";


    public void authentication(String username, String password) throws Exception;  // login

    public String returnuser();

    public String returnpass();

    public void registeruserdetail(String fn, String ln, String Phonenumber, String email, String cnic);

    public void signupuser(String username, String Email, String Password) throws ClassNotFoundException, SQLException;

}
