package Model;

/**
 * Created by BRUCE on 10/23/2017.
 */

public class EmployerSchedule {
    private int soXeBuyt;
    private String date;

    public EmployerSchedule() {
    }

    public EmployerSchedule(int soXeBuyt, String date) {
        this.soXeBuyt = soXeBuyt;
        this.date = date;
    }

    public int getSoXeBuyt() {
        return soXeBuyt;
    }

    public void setSoXeBuyt(int soXeBuyt) {
        this.soXeBuyt = soXeBuyt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
