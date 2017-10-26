package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class TicketSold {
    public String ngayNhapVe;
    public int maLoaiVe;
    public int maNQL;
    public long soLuongVe;
    public int maXeBus;

    public TicketSold() {
    }

    public TicketSold(String ngayNhapVe, int maLoaiVe, int maNQL, long soLuongVe, int maXeBus) {
        this.ngayNhapVe = ngayNhapVe;
        this.maLoaiVe = maLoaiVe;
        this.maNQL = maNQL;
        this.soLuongVe = soLuongVe;
        this.maXeBus = maXeBus;
    }

    public String getNgayNhapVe() {
        return ngayNhapVe;
    }

    public void setNgayNhapVe(String ngayNhapVe) {
        this.ngayNhapVe = ngayNhapVe;
    }

    public int getMaLoaiVe() {
        return maLoaiVe;
    }

    public void setMaLoaiVe(int maLoaiVe) {
        this.maLoaiVe = maLoaiVe;
    }

    public int getMaNQL() {
        return maNQL;
    }

    public void setMaNQL(int maNQL) {
        this.maNQL = maNQL;
    }

    public long getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(long soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public int getMaXeBus() {
        return maXeBus;
    }

    public void setMaXeBus(int maXeBus) {
        this.maXeBus = maXeBus;
    }
}
