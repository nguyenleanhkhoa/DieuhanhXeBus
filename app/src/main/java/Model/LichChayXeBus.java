package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class LichChayXeBus {
    public int maXeBus;
    public int maTx;
    public String GioChay;

    public LichChayXeBus() {
    }

    public LichChayXeBus(int maXeBus, int maTx, String gioChay) {
        this.maXeBus = maXeBus;
        this.maTx = maTx;
        GioChay = gioChay;
    }

    public int getMaXeBus() {
        return maXeBus;
    }

    public void setMaXeBus(int maXeBus) {
        this.maXeBus = maXeBus;
    }

    public int getMaTx() {
        return maTx;
    }

    public void setMaTx(int maTx) {
        this.maTx = maTx;
    }

    public String getGioChay() {
        return GioChay;
    }

    public void setGioChay(String gioChay) {
        GioChay = gioChay;
    }
}
