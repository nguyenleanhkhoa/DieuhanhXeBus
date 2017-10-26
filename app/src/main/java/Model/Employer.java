package Model;

/**
 * Created by ADMIN on 10/18/17.
 */

public class Employer {
    public int Eml_Id;
    public String Eml_Name;
    public String Eml_Password;
    public String Eml_Birthday;
    public String Eml_Phone;
    public String Eml_Email;
    public String Eml_Address;
    public int Department_Id;
    public int Admin_Id;

    public Employer() {
    }

    public Employer(int eml_Id, String eml_Name, String eml_Password, String eml_Birthday, String eml_Phone, String eml_Email, String eml_Address, int department_Id, int admin_Id) {
        Eml_Id = eml_Id;
        Eml_Name = eml_Name;
        Eml_Password = eml_Password;
        Eml_Birthday = eml_Birthday;
        Eml_Phone = eml_Phone;
        Eml_Email = eml_Email;
        Eml_Address = eml_Address;
        Department_Id = department_Id;
        Admin_Id = admin_Id;
    }

    public int getEml_Id() {
        return Eml_Id;
    }

    public void setEml_Id(int eml_Id) {
        Eml_Id = eml_Id;
    }

    public String getEml_Name() {
        return Eml_Name;
    }

    public void setEml_Name(String eml_Name) {
        Eml_Name = eml_Name;
    }

    public String getEml_Password() {
        return Eml_Password;
    }

    public void setEml_Password(String eml_Password) {
        Eml_Password = eml_Password;
    }

    public String getEml_Birthday() {
        return Eml_Birthday;
    }

    public void setEml_Birthday(String eml_Birthday) {
        Eml_Birthday = eml_Birthday;
    }

    public String getEml_Phone() {
        return Eml_Phone;
    }

    public void setEml_Phone(String eml_Phone) {
        Eml_Phone = eml_Phone;
    }

    public String getEml_Email() {
        return Eml_Email;
    }

    public void setEml_Email(String eml_Email) {
        Eml_Email = eml_Email;
    }

    public String getEml_Address() {
        return Eml_Address;
    }

    public void setEml_Address(String eml_Address) {
        Eml_Address = eml_Address;
    }

    public int getDepartment_Id() {
        return Department_Id;
    }

    public void setDepartment_Id(int department_Id) {
        Department_Id = department_Id;
    }

    public int getAdmin_Id() {
        return Admin_Id;
    }

    public void setAdmin_Id(int admin_Id) {
        Admin_Id = admin_Id;
    }

    @Override
    public String toString() {
        return
                "Eml_Id=" + Eml_Id + "\n" +
                "Eml_Name='" + Eml_Name + "\n" +
                "Eml_Password='" + Eml_Password + "\n" +
                "Eml_Birthday='" + Eml_Birthday + "\n" +
                "Eml_Phone='" + Eml_Phone + "\n" +
                "Eml_Email='" + Eml_Email + "\n" +
                "Eml_Address='" + Eml_Address + "\n" +
                "Department_Id=" + Department_Id +
                "Admin_Id=" + Admin_Id + "\n";
    }
}
