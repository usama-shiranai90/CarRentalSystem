package BackEndCode;

import java.util.ArrayList;

public class CustomerProfile {

    private static String username;
    private static String fullname;
    private static String password;
    private static String email;
    private static String phone;
    private static String CNIC;

  public   ArrayList<CustomerProfile> profiles = new ArrayList<>();

    public static String getCNIC() {
        return CNIC;
    }

    public static void setCNIC(String CNIC) {
        CustomerProfile.CNIC = CNIC;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CustomerProfile.username = username;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        CustomerProfile.fullname = fullname;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CustomerProfile.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CustomerProfile.email = email;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        CustomerProfile.phone = phone;
    }
}
