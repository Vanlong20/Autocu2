package poly.edu.Model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "DanhMuc") // Tên bảng trong CSDL
public class DanhMuc implements Serializable {
    @Id
    @Column(name = "CategoryID")
    private String categoryID;

    @Column(name = "TenDanhMuc", nullable = false)
    private String tenDanhMuc;

    @Column(name = "MoTa")
    private String moTa; // Thuộc tính tùy chọn

    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL)
    private List<SanPham> sanPhams; // Một danh mục có nhiều sản phẩm
    
    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL)
    private List<PhuKienOto> phuKienOtos;

    // Constructor không tham số
    public DanhMuc() {
    }

    // Getter & Setter
    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
