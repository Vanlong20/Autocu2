package poly.edu.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.edu.Model.KhachHang;

public interface KhachHangDAO extends JpaRepository<KhachHang, String>{

    // Ví dụ: tìm xe theo tên xe
    List<KhachHang> findByTenKhachHang(String tenKhachHang);
    List<KhachHang> findBySoDienThoai(Integer soDienThoai);
    List<KhachHang> findByEmail(String email);
    List<KhachHang> findByUserID(String userID);
    
}
