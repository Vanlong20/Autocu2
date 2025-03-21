package poly.edu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.edu.DAO.GioHangChiTietDAO;
import poly.edu.DAO.GioHangDAO;
import poly.edu.DAO.KhachHangDAO;
import poly.edu.DAO.PhuKienOtoDAO;
import poly.edu.Model.GioHang;
import poly.edu.Model.GioHangChiTiet;
import poly.edu.Model.KhachHang;
import poly.edu.Model.PhuKienOto;
import poly.edu.Repository.PhuKienOtoRepository;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private GioHangDAO gioHangRepository;

    @Autowired
    private GioHangChiTietDAO gioHangChiTietRepository;

    @Autowired
    private PhuKienOtoDAO phuKienOtoRepository;

    @Autowired
    private KhachHangDAO khachHangRepository;
    /**
     * Lấy giỏ hàng của khách hàng
     */
    public GioHang getCartByUserId(String userId) {
        Optional<KhachHang> khachHangOpt = khachHangRepository.findById(userId);
        
        if (khachHangOpt.isPresent()) {
            return gioHangRepository.findByKhachHang(khachHangOpt.get()).orElseGet(() -> {
                GioHang newCart = new GioHang();
                newCart.setKhachHang(khachHangOpt.get()); // Gán khách hàng vào giỏ hàng
                return gioHangRepository.save(newCart);
            });
        } else {
            throw new RuntimeException("Không tìm thấy khách hàng với ID: " + userId);
        }
    }

    /**
     * Thêm sản phẩm vào giỏ hàng
     */
    @Transactional
    public void addToCart(String userId, String accessoryID, int quantity) {
        GioHang cart = getCartByUserId(userId);
        Optional<PhuKienOto> productOpt = phuKienOtoRepository.findByID(accessoryID);

        if (productOpt.isPresent()) {
            PhuKienOto product = productOpt.get();
            Optional<GioHangChiTiet> existingItem = gioHangChiTietRepository.findByGioHangAndPhuKienOto(cart, product);

            if (existingItem.isPresent()) {
                // Nếu sản phẩm đã có trong giỏ hàng, cập nhật số lượng
                GioHangChiTiet gioHangChiTiet = existingItem.get();
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + quantity);
            } else {
                // Nếu chưa có, tạo mới
                GioHangChiTiet newItem = new GioHangChiTiet();
                newItem.setGioHang(cart);
                newItem.setPhuKienOto(product);
                newItem.setSoLuong(quantity);
                gioHangChiTietRepository.save(newItem);
            }

            gioHangRepository.save(cart); // Cập nhật giỏ hàng
        }
    }

    /**
     * Cập nhật số lượng sản phẩm trong giỏ hàng
     */
    @Transactional
    public void updateItem(String userId, String accessoryID, int quantity) {
        GioHang cart = getCartByUserId(userId);
        Optional<PhuKienOto> productOpt = phuKienOtoRepository.findById(accessoryID);

        if (productOpt.isPresent()) {
            PhuKienOto product = productOpt.get();
            Optional<GioHangChiTiet> existingItem = gioHangChiTietRepository.findByGioHangAndPhuKienOto(cart, product);

            if (existingItem.isPresent()) {
                GioHangChiTiet gioHangChiTiet = existingItem.get();
                gioHangChiTiet.setSoLuong(quantity);
                gioHangChiTietRepository.save(gioHangChiTiet);
            }
        }
    }

    /**
     * Xóa sản phẩm khỏi giỏ hàng
     */
    @Transactional
    public void removeItem(String userId, String accessoryID) {
        GioHang cart = getCartByUserId(userId);
        Optional<PhuKienOto> productOpt = phuKienOtoRepository.findById(accessoryID);

        if (productOpt.isPresent()) {
            PhuKienOto product = productOpt.get();
            gioHangChiTietRepository.deleteByGioHangAndPhuKienOto(cart, product);
        }
    }

    /**
     * Xóa toàn bộ giỏ hàng
     */
    @Transactional
    public void clearCart(String userId) {
        GioHang cart = getCartByUserId(userId);
        gioHangChiTietRepository.deleteAllByGioHang(cart);
        gioHangRepository.delete(cart);
    }
}
