package poly.edu.Model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietDonHang") // Tên bảng trong CSDL
public class ChiTietDonHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID nếu cần
    @Column(name = "OrderItemID")
    private Long orderItemID;

    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false) // Liên kết với bảng DonHang
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false) // Liên kết với bảng SanPham
    private SanPham sanPham;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    // Constructor không tham số
    public ChiTietDonHang() {
    }

    // Getter & Setter
    public Long getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(Long orderItemID) {
        this.orderItemID = orderItemID;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
