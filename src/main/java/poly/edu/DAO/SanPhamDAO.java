package poly.edu.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import poly.edu.Model.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham, String> {
    
    // Tìm sản phẩm theo hãng xe
    List<SanPham> findByHangXe(String hangXe);
    
    // Tìm sản phẩm theo tên xe
    List<SanPham> findByTenSanPham(String tenSanPham);
    
    // Tìm sản phẩm theo ID
    @Query("SELECT d FROM SanPham d WHERE d.productID = :ProductID")
    List<SanPham> findByProductId(@Param("ProductID") String ProductID);

    // Tìm sản phẩm tương tự theo danh mục (ngoại trừ sản phẩm hiện tại)
    @Query("SELECT sp FROM SanPham sp WHERE sp.danhMuc.categoryID = :categoryID AND sp.productID <> :productID")
    List<SanPham> findSanPhamTuongTu(@Param("categoryID") String categoryID, @Param("productID") String productID);


}
