package poly.edu.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "TonKho")
public class TonKho implements Serializable {
    @Id
    @Column(name = "InventoryID")
    private String inventoryID;

    @ManyToOne
    @JoinColumn(name = "AccessoryID", nullable = true) // Liên kết với phụ kiện ô tô
    private PhuKienOto phuKienOTo;

    @ManyToOne
    @JoinColumn(name = "StaffID", nullable = true) // Nhân viên phụ trách kho
    private NhanVien nhanVien;

    @Column(name = "ViTriKho", nullable = false)
    private String viTriKho;

    @Column(name = "SoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "NgayCapNhat", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayCapNhat;

	public TonKho(String inventoryID, PhuKienOto phuKienOTo, NhanVien nhanVien, String viTriKho, Integer soLuong,
			Date ngayCapNhat) {
		super();
		this.inventoryID = inventoryID;
		this.phuKienOTo = phuKienOTo;
		this.nhanVien = nhanVien;
		this.viTriKho = viTriKho;
		this.soLuong = soLuong;
		this.ngayCapNhat = ngayCapNhat;
	}

	public TonKho() {
		super();
	}

	public String getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public PhuKienOto getPhuKienOTo() {
		return phuKienOTo;
	}

	public void setPhuKienOTo(PhuKienOto phuKienOTo) {
		this.phuKienOTo = phuKienOTo;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getViTriKho() {
		return viTriKho;
	}

	public void setViTriKho(String viTriKho) {
		this.viTriKho = viTriKho;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}
    
    
}
