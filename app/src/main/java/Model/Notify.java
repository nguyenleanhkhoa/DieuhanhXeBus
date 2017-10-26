package Model;

/**
 * Created by ADMIN on 10/24/17.
 */

public class Notify {
    public int Notify_Id;
    public String Notify_Date;
    public String Notify_Context;
    public int Admin_Id;

    public Notify() {
    }

    public Notify(int notify_Id, String notify_Date, String notify_Context, int admin_Id) {
        Notify_Id = notify_Id;
        Notify_Date = notify_Date;
        Notify_Context = notify_Context;
        Admin_Id = admin_Id;
    }

    public int getNotify_Id() {
        return Notify_Id;
    }

    public void setNotify_Id(int notify_Id) {
        Notify_Id = notify_Id;
    }

    public String getNotify_Date() {
        return Notify_Date;
    }

    public void setNotify_Date(String notify_Date) {
        Notify_Date = notify_Date;
    }

    public String getNotify_Context() {
        return Notify_Context;
    }

    public void setNotify_Context(String notify_Context) {
        Notify_Context = notify_Context;
    }

    public int getAdmin_Id() {
        return Admin_Id;
    }

    public void setAdmin_Id(int admin_Id) {
        Admin_Id = admin_Id;
    }
}
