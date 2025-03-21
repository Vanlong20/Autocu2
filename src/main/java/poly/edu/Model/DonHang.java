package poly.edu.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "DonHang") // Tên bảng trong CSDL
public class DonHang implements Serializable {
    @Id
    @Column(name = "OrderID")
    private String orderID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false) // Liên kết với bảng KhachHang
    private KhachHang khachHang;

    @Temporal(TemporalType.DATE)
    @Column(name = "NgayDatHang", nullable = false)
    private Date ngayDatHang;

    @Column(name = "TrangThaiDon", nullable = false)
    private String trangThaiDon; // Ví dụ: "Chờ xử lý", "Đang giao", "Hoàn thành"

    @Column(name = "TongGiaTri", nullable = false)
    private Double tongGiaTri;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangs;

    // Constructor không tham số
    public DonHang() {
    }

    // Getter & Setter
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getTrangThaiDon() {
        return trangThaiDon;
    }

    public void setTrangThaiDon(String trangThaiDon) {
        this.trangThaiDon = trangThaiDon;
    }

    public Double getTongGiaTri() {
        return tongGiaTri;
    }

    public void setTongGiaTri(Double tongGiaTri) {
        this.tongGiaTri = tongGiaTri;
    }

    public List<ChiTietDonHang> getChiTietDonHangs() {
        return chiTietDonHangs;
    }

    public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
        this.chiTietDonHangs = chiTietDonHangs;
    }
}
