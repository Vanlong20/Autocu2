<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="poly.edu.Model.PhuKienOto" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="styles.css"> <!-- Thêm file CSS nếu có -->
</head>
<body>
	<jsp:include page="/common/header.jsp" />
    <div class="container">
        <h2>Giỏ hàng của bạn</h2>

        <%
            List<PhuKienOto> cart = (List<PhuKienOto>) session.getAttribute("cart");
            double total = 0;
            NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        %>

        <% if (cart == null || cart.isEmpty()) { %>
            <p>Giỏ hàng của bạn đang trống.</p>
        <% } else { %>
            <table border="1" width="100%">
                <thead>
                    <tr>
                        <th>Ảnh</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (PhuKienOto item : cart) { 
                        double subtotal = item.getGia() * item.getSoLuong();
                        total += subtotal;
                    %>
                        <tr>
                            <td><img src="<%= item.getAnhDaiDien() %>" alt="<%= item.getTenPhuKien() %>" width="80"></td>
                            <td><%= item.getTenPhuKien() %></td>
                            <td><%= currencyFormat.format(item.getGia()) %> VND</td>
                            <td>
                                <form action="updateCart" method="post">
                                    <input type="hidden" name="accessoryID" value="<%= item.getAccessoryID() %>">
                                    <input type="number" name="quantity" value="<%= item.getSoLuong() %>" min="1">
                                    <button type="submit">Cập nhật</button>
                                </form>
                            </td>
                            <td><%= currencyFormat.format(subtotal) %> VND</td>
                            <td>
                                <a href="removeFromCart?accessoryID=<%= item.getAccessoryID() %>" class="btn btn-danger">
                                    Xóa
                                </a>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>

            <h3>Tổng tiền: <%= currencyFormat.format(total) %> VND</h3>

            <div class="actions">
                <a href="checkout" class="btn btn-success">Thanh toán</a>
                <a href="index.jsp" class="btn btn-primary">Tiếp tục mua hàng</a>
            </div>
        <% } %>
    </div>
    <jsp:include page="/common/footer.jsp" />
</body>
</html>
