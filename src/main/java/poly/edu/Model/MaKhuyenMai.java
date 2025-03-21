package poly.edu.Model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "MaKhuyenMai") // Tên bảng trong CSDL
public class MaKhuyenMai implements Serializable {
    @Id
    @Column(name = "CouponID")
    private String couponID;

    @Column(name = "MaKhuyenMai", unique = true, nullable = false)
    private String maKhuyenMai;

    @Column(name = "PhanTramGiam", nullable = false)
    private Double phanTramGiam; // % giảm giá

    @Temporal(TemporalType.DATE)
    @Column(name = "HanSuDung", nullable = false)
    private Date hanSuDung;

    // Constructor không tham số
    public MaKhuyenMai() {
    }

    // Getter & Setter
    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Double getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Double phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
}
