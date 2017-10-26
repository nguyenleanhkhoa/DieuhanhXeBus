package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class LoaiVe {
    public int maLoaiVe;
    public String loaiVe;

    public LoaiVe() {
    }

    public LoaiVe(int maLoaiVe, String loaiVe) {
        this.maLoaiVe = maLoaiVe;
        this.loaiVe = loaiVe;
    }

    public int getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(int maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }
}
