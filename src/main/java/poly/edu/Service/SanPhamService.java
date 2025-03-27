package poly.edu.Service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.DAO.SanPhamDAO;
import poly.edu.Model.SanPham;
import poly.edu.Repository.SanPhamRepository;

@Service
public class SanPhamService {
    
    @Autowired
    private SanPhamRepository sanPhamRepository; // Inject repository

    public List<SanPham> getSanPhamTuongTu(String categoryID, String productId) {
        return sanPhamRepository.findByDanhMuc_CategoryIDAndProductIDNot(categoryID, productId);
    }
}

