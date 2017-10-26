package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class TroCap {
    public int maTroCap;
    public float tienTroCap;
    public int maChucVu;

    public TroCap() {
    }

    public TroCap(int maTroCap, float tienTroCap, int maChucVu) {
        this.maTroCap = maTroCap;
        this.tienTroCap = tienTroCap;
        this.maChucVu = maChucVu;
    }

    public int getMaTroCap() {
        return maTroCap;
    }

    public void setMaTroCap(int maTroCap) {
        this.maTroCap = maTroCap;
    }

    public float getTienTroCap() {
        return tienTroCap;
    }

    public void setTienTroCap(float tienTroCap) {
        this.tienTroCap = tienTroCap;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }
}
