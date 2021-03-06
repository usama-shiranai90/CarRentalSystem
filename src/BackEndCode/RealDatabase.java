package BackEndCode;

import com.jfoenix.controls.JFXTextField;

import java.sql.*;

public class RealDatabase implements Database {

    private static String user = "";
    private static String pass = "";

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public void authentication(String username, String password) throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection(databaseURL, sqluser, sqlpassword);
        Class.forName(driversql);

        if (connection != null) {
            System.out.println("Connection successfull");
        }

        connection.createStatement();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("select username,password from customer");
        boolean flag = true;
        ResultSet resultset = preparedStatement.executeQuery();

        while ((resultset.next()) && flag) {
            user = resultset.getString("username");

            pass = resultset.getString("password");

            /*if (username.equals(user) && password.equals(pass)) {
                flag = false;
            }*/
            if (username.hashCode()== user.hashCode() && password.hashCode()== pass.hashCode()){
                flag = false;
            }
        }
    }

    @Override
    public String returnuser() {
        return getUser();
    }

    @Override
    public String returnpass() {
        return getPass();
    }

    @Override
    public void registeruserdetail(String firstname, String lastname, String phonenumber, String email, String Cnic) {

        try {

//            Database  connection = new DatabaseProxy();
            Connection connection = DriverManager.getConnection(databaseURL, sqluser, sqlpassword);
            Class.forName(driversql);

            String query1 = "UPDATE customer set FirstName=? where username=?";
            String query2 = "UPDATE customer set LastName=? where username=?";
            String query3 = "UPDATE customer set Email=? where username=?";
            String query4 = "UPDATE customer set phone=? where username=?";
            String query5 = "UPDATE customer set CNIC=? where username=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            preparedStatement = getPreparedStatement(connection, query2, query3, preparedStatement, firstname, lastname);
            preparedStatement = getPreparedStatement(connection, query4, query5, preparedStatement, email, phonenumber);
            preparedStatement.setString(1, Cnic);
            preparedStatement.setString(2, user);
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    private PreparedStatement getPreparedStatement(Connection connection, String query4, String query5, PreparedStatement preparedStatement,
                                                   String email, String phonenumber) throws SQLException {
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, user);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement(query4);
        preparedStatement.setString(1, phonenumber);
        preparedStatement.setString(2, user);
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement(query5);
        return preparedStatement;
    }

    @Override
    public void signupuser(String username, String Email, String Password) throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection(databaseURL, sqluser, sqlpassword);
        Class.forName(driversql);

        String query1 = "INSERT INTO customer(username,Email,password) values (?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(query1);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, Email);
        preparedStatement.setString(3, Password);

        preparedStatement.executeUpdate();
        System.out.println("Successfully created a new user account...");

    }

}
