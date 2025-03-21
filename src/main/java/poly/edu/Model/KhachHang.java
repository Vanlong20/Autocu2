package poly.edu.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "KhachHang") // Tên bảng trong CSDL
public class KhachHang implements Serializable {
    @Id
    @Column(name = "UserID")
    private String userID;

    @Column(name = "TenKhachHang", nullable = false)
    private String tenKhachHang;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "SoDienThoai", unique = true)
    private Integer soDienThoai;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;
    
    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Column(name = "VaiTro")
    private Boolean vaiTro;

    // Quan hệ với bảng DonHang
    @OneToMany(mappedBy = "khachHang")
    private List<DonHang> donHangs;

    // Quan hệ với bảng GioHang
    @OneToOne(mappedBy = "khachHang")
    private GioHang gioHang;

    // Constructor không tham số
    public KhachHang() {
    }

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(Integer soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Boolean getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(Boolean vaiTro) {
		this.vaiTro = vaiTro;
	}

	public List<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

    
}
