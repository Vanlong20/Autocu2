package poly.edu.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poly.edu.Model.GioHang;
import poly.edu.Model.PhuKienOto;
import poly.edu.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;

    // Lấy giỏ hàng từ session
    @GetMapping
    public ResponseEntity<GioHang> getCart(HttpSession session) {
        GioHang cart = (GioHang) session.getAttribute("cart");
        if (cart == null) {
            cart = new GioHang();
            session.setAttribute("cart", cart);
        }
        return ResponseEntity.ok(cart);
    }

    // Thêm sản phẩm vào giỏ hàng
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam("accessoryID") String accessoryID,
                                            @RequestParam("quantity") int quantity, 
                                            HttpSession session) {
        GioHang cart = (GioHang) session.getAttribute("cart");
        if (cart == null) {
            cart = new GioHang();
            session.setAttribute("cart", cart);
        }

        cartService.addToCart(cart, accessoryID, quantity);
        return ResponseEntity.ok("Sản phẩm đã được thêm vào giỏ hàng!");
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    @PostMapping("/update")
    public ResponseEntity<String> updateCart(@RequestParam("accessoryID") String accessoryID, 
                                             @RequestParam("quantity") int quantity, 
                                             HttpSession session) {
        GioHang cart = (GioHang) session.getAttribute("cart");
        if (cart != null) {
            cartService.updateItem(cart, accessoryID, quantity);
        }
        return ResponseEntity.ok("Cập nhật số lượng thành công!");
    }

    // Xóa một sản phẩm khỏi giỏ hàng
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestParam("accessoryID") String accessoryID, 
                                                 HttpSession session) {
        GioHang cart = (GioHang) session.getAttribute("cart");
        if (cart != null) {
            cartService.removeItem(cart, accessoryID);
        }
        return ResponseEntity.ok("Sản phẩm đã được xóa khỏi giỏ hàng!");
    }

    // Xóa toàn bộ giỏ hàng
    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(HttpSession session) {
        GioHang cart = (GioHang) session.getAttribute("cart");
        if (cart != null) {
            cartService.clearCart(cart);
        }
        return ResponseEntity.ok("Giỏ hàng đã được làm sạch!");
    }
}
