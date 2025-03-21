package poly.edu.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "TicketHoTro")
public class TicketHoTro implements Serializable {
    @Id
    @Column(name = "TicketID")
    private String ticketID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false) // Liên kết với khách hàng
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "StaffID", nullable = true) // Nhân viên hỗ trợ
    private NhanVien nhanVien;

    @Column(name = "MoTaVanDe", nullable = false, length = 1000)
    private String moTaVanDe;

    @Column(name = "TrangThai", nullable = false)
    private String trangThai; // (Pending, In Progress, Resolved, Closed)

    @Column(name = "NgayTao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @Column(name = "NgayCapNhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat;

	public TicketHoTro(String ticketID, KhachHang khachHang, NhanVien nhanVien, String moTaVanDe, String trangThai,
			Date ngayTao, Date ngayCapNhat) {
		super();
		this.ticketID = ticketID;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.moTaVanDe = moTaVanDe;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
		this.ngayCapNhat = ngayCapNhat;
	}

	public TicketHoTro() {
		super();
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getMoTaVanDe() {
		return moTaVanDe;
	}

	public void setMoTaVanDe(String moTaVanDe) {
		this.moTaVanDe = moTaVanDe;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}
    
    
}

