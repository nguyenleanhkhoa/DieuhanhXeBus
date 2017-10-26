package Model;

/**
 * Created by ADMIN on 10/18/17.
 */

public class Admin {
    public int Admin_Id;
    public String Admin_Password;
    public String Admin_Name;
    public String Admin_Address;
    public String Admin_Phone;
    public String Admin_Email;

    public Admin() {
    }

    public Admin(int admin_Id, String admin_Password, String admin_Name, String admin_Address, String admin_Phone, String admin_Email) {
        Admin_Id = admin_Id;
        Admin_Password = admin_Password;
        Admin_Name = admin_Name;
        Admin_Address = admin_Address;
        Admin_Phone = admin_Phone;
        Admin_Email = admin_Email;
    }

    public int getAdmin_Id() {
        return Admin_Id;
    }

    public void setAdmin_Id(int admin_Id) {
        Admin_Id = admin_Id;
    }

    public String getAdmin_Password() {
        return Admin_Password;
    }

    public void setAdmin_Password(String admin_Password) {
        Admin_Password = admin_Password;
    }

    public String getAdmin_Name() {
        return Admin_Name;
    }

    public void setAdmin_Name(String admin_Name) {
        Admin_Name = admin_Name;
    }

    public String getAdmin_Address() {
        return Admin_Address;
    }

    public void setAdmin_Address(String admin_Address) {
        Admin_Address = admin_Address;
    }

    public String getAdmin_Phone() {
        return Admin_Phone;
    }

    public void setAdmin_Phone(String admin_Phone) {
        Admin_Phone = admin_Phone;
    }

    public String getAdmin_Email() {
        return Admin_Email;
    }

    public void setAdmin_Email(String admin_Email) {
        Admin_Email = admin_Email;
    }
}
