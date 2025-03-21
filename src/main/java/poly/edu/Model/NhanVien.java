package poly.edu.Model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "NhanVien") // Tên bảng trong CSDL
public class NhanVien implements Serializable {
    @Id
    @Column(name = "StaffID")
    private String staffID;

    @Column(name = "TenNhanVien", nullable = false)
    private String tenNhanVien;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "SoDienThoai", unique = true, nullable = false)
    private Integer soDienThoai;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "VaiTro")
    private Boolean vaiTro; // True: Quản lý, False: Nhân viên bình thường

    // Constructor không tham số
    public NhanVien() {
    }

    // Getter & Setter
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
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

    public Boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
}
