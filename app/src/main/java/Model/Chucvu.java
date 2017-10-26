package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class Chucvu {
    public int maChucvu;
    public String chucVu;
    public float luongCoBan;

    public Chucvu() {
    }

    public Chucvu(int maChucvu, String chucVu, float luongCoBan) {
        this.maChucvu = maChucvu;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
    }

    public int getMaChucvu() {
        return maChucvu;
    }

    public void setMaChucvu(int maChucvu) {
        this.maChucvu = maChucvu;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
}
