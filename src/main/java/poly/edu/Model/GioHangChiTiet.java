package poly.edu.Model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet") // Tên bảng trong CSDL
public class GioHangChiTiet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // Hoặc GenerationType.IDENTITY nếu dùng số nguyên
	@Column(name = "CartItemID", updatable = false, nullable = false)
	private String cartItemID;


    @ManyToOne
    @JoinColumn(name = "CartID") // Liên kết với bảng Giỏ Hàng
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "AccessoryID") // Liên kết với bảng Sản Phẩm
    private PhuKienOto phuKienOto;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GioHangChiTiet that = (GioHangChiTiet) o;
        return cartItemID != null && cartItemID.equals(that.cartItemID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "GioHangChiTiet{" +
                "cartItemID=" + cartItemID +
                ", gioHangID=" + (gioHang != null ? gioHang.getCartID() : "null") +
                ", phuKienID=" + (phuKienOto != null ? phuKienOto.getAccessoryID() : "null") +
                ", soLuong=" + soLuong +
                '}';
    }



    // Constructor không tham số
    public GioHangChiTiet() {
    }
    

    public GioHangChiTiet(GioHang gioHang, PhuKienOto phuKienOto, Integer soLuong) {
        this.gioHang = gioHang;
        this.phuKienOto = phuKienOto;
        this.soLuong = soLuong;
    }


	// Getter & Setter
    public String getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(String cartItemID) {
        this.cartItemID = cartItemID;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }


    public PhuKienOto getPhuKienOto() {
		return phuKienOto;
	}

	public void setPhuKienOto(PhuKienOto phuKienOto) {
		this.phuKienOto = phuKienOto;
	}

	public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
