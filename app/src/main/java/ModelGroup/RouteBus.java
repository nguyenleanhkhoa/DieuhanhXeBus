package ModelGroup;

/**
 * Created by ADMIN on 10/24/17.
 */

public class RouteBus {
    public int maXeBus;
    public int soXeBus;
    public String biensoxeBus;
    public int maTx;
    public String GioChay;
    public String tuyenXe;

    public RouteBus() {
    }

    public RouteBus(int maXeBus, int soXeBus, String biensoxeBus, int maTx, String gioChay, String tuyenXe) {
        this.maXeBus = maXeBus;
        this.soXeBus = soXeBus;
        this.biensoxeBus = biensoxeBus;
        this.maTx = maTx;
        GioChay = gioChay;
        this.tuyenXe = tuyenXe;
    }

    public int getMaXeBus() {
        return maXeBus;
    }

    public void setMaXeBus(int maXeBus) {
        this.maXeBus = maXeBus;
    }

    public int getSoXeBus() {
        return soXeBus;
    }

    public void setSoXeBus(int soXeBus) {
        this.soXeBus = soXeBus;
    }

    public String getBiensoxeBus() {
        return biensoxeBus;
    }

    public void setBiensoxeBus(String biensoxeBus) {
        this.biensoxeBus = biensoxeBus;
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

    public String getTuyenXe() {
        return tuyenXe;
    }

    public void setTuyenXe(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }
}
