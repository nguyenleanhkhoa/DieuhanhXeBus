package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class lichLamNV {
    public int maNv;
    public int maXeBus;
    public String date;

    public lichLamNV() {
    }

    public lichLamNV(int maNv, int maXeBus, String date) {
        this.maNv = maNv;
        this.maXeBus = maXeBus;
        this.date = date;
    }

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public int getMaXeBus() {
        return maXeBus;
    }

    public void setMaXeBus(int maXeBus) {
        this.maXeBus = maXeBus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
