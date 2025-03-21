package poly.edu.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.persistence.*;

@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CartID", updatable = false, nullable = false)
    private String cartID;

    @OneToOne
    @JoinColumn(name = "UserID")
    private KhachHang khachHang;

    @Column(name = "TongGiaTri")
    private Double tongGiaTri;

    @ManyToOne
    @JoinColumn(name = "CouponID", nullable = true)
    private MaKhuyenMai maKhuyenMai;

    @OneToMany(mappedBy = "gioHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GioHangChiTiet> gioHangChiTiets = new ArrayList<>();

    // Constructor không tham số
    public GioHang() {
    }

   

    // toString() để debug
	/*
	 * @Override public String toString() { return "GioHang{" + "cartID='" + cartID
	 * + '\'' + ", tongGiaTri=" + getTongGiaTri() + ", khachHang=" + (khachHang !=
	 * null ? khachHang.getUserID() : "null") + ", maKhuyenMai=" + (maKhuyenMai !=
	 * null ? maKhuyenMai.getCouponID() : "null") + ", gioHangChiTiets=" +
	 * (gioHangChiTiets != null ? gioHangChiTiets.size() : 0) + '}'; }
	 */

    // Getter & Setter
    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public MaKhuyenMai getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(MaKhuyenMai maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return gioHangChiTiets;
    }

    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        this.gioHangChiTiets = gioHangChiTiets;
    }
}
