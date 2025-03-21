package poly.edu.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
	@Table(name = "PhuKienOto") // Tên bảng trong CSDL
	public class PhuKienOto implements Serializable {

	    @Id
	    @Column(name = "AccessoryID")
	    private String accessoryID;

	    @Column(name = "TenPhuKien", nullable = false)
	    private String tenPhuKien;

	    @Column(name = "MoTa")
	    private String moTa; // Mô tả chi tiết phụ kiện

	    @Column(name = "Gia", nullable = false)
	    private Double gia;
	    
	    @Column(name = "SoLuong", nullable = false)
	    private Integer soLuong;

	    @Column(name = "HangSanXuat", nullable = false)
	    private String hangSanXuat;
	    
	    @Column(name = "AnhDaiDien", nullable = false)
	    private String anhDaiDien;

	    @ManyToOne
	    @JoinColumn(name = "CategoryID", nullable = false) // Liên kết với bảng danh mục
	    private DanhMuc danhMuc;

		public String getAccessoryID() {
			return accessoryID;
		}

		public void setAccessoryID(String accessoryID) {
			this.accessoryID = accessoryID;
		}

		public String getTenPhuKien() {
			return tenPhuKien;
		}

		public void setTenPhuKien(String tenPhuKien) {
			this.tenPhuKien = tenPhuKien;
		}

		public String getMoTa() {
			return moTa;
		}

		public void setMoTa(String moTa) {
			this.moTa = moTa;
		}

		public Double getGia() {
			return gia;
		}

		public void setGia(Double gia) {
			this.gia = gia;
		}

		public Integer getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(Integer soLuong) {
			this.soLuong = soLuong;
		}

		public String getHangSanXuat() {
			return hangSanXuat;
		}

		public void setHangSanXuat(String hangSanXuat) {
			this.hangSanXuat = hangSanXuat;
		}

		public String getAnhDaiDien() {
			return anhDaiDien;
		}

		public void setAnhDaiDien(String anhDaiDien) {
			this.anhDaiDien = anhDaiDien;
		}

		public DanhMuc getDanhMuc() {
			return danhMuc;
		}

		public void setDanhMuc(DanhMuc danhMuc) {
			this.danhMuc = danhMuc;
		}

		public PhuKienOto(String accessoryID, String tenPhuKien, String moTa, Double gia, Integer soLuong,
				String hangSanXuat, String anhDaiDien, DanhMuc danhMuc) {
			super();
			this.accessoryID = accessoryID;
			this.tenPhuKien = tenPhuKien;
			this.moTa = moTa;
			this.gia = gia;
			this.soLuong = soLuong;
			this.hangSanXuat = hangSanXuat;
			this.anhDaiDien = anhDaiDien;
			this.danhMuc = danhMuc;
		}

		public PhuKienOto() {
			super();
		}

	    
	}

