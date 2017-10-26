package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class TuyenXe {
    public int maTx;
    public String tuyenXe;

    public TuyenXe() {
    }

    public TuyenXe(int maTx, String tuyenXe) {
        this.maTx = maTx;
        this.tuyenXe = tuyenXe;
    }

    public int getMaTx() {
        return maTx;
    }

    public void setMaTx(int maTx) {
        this.maTx = maTx;
    }

    public String getTuyenXe() {
        return tuyenXe;
    }

    public void setTuyenXe(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }
}
