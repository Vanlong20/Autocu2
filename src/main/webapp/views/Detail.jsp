<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-title { font-weight: bold; }
        .product-price { font-size: 24px; font-weight: bold; color: blue; }
        .small-img { width: 70px; cursor: pointer; }
        .btn-cart { background-color: #ffcc00; border: none; }
        .nav-tabs .nav-link.active { background-color: #f8f9fa; }
    </style>
</head>
<body>
<h3>Sản phẩm tương tự</h3>
<div class="row">
    <c:choose>
        <c:when test="${not empty sanPhamTuongTu}">
            <c:forEach var="sp" items="${sanPhamTuongTu}">
            
                <div class="col-md-3">
                    <div class="card">
                            <img src="<c:url value='/imgs/${sp.anhDaiDien}' />" class="img-fluid"  alt="Ảnh sản phẩm">
                        <div class="card-body">
                            <h5 class="card-title">${sp.tenSanPham}</h5>
                            <p class="card-text">
                                <fmt:formatNumber value="${sp.gia}" type="currency" currencySymbol="VNĐ"/>
                            </p>
                            <a href="/details/${sp.productID}" class="btn btn-primary">Xem chi tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p class="text-muted">Không có sản phẩm tương tự.</p>
        </c:otherwise>
    </c:choose>
</div>

    <div class="container mt-4">
        <!-- Thông tin sản phẩm -->
        <div class="row">
            <div class="col-md-5">
                <img src="<c:url value='/imgs/${details[0].anhDaiDien}' />" class="img-fluid" alt="${details[0].tenSanPham}">
                <div class="d-flex mt-2">
                    <c:forEach var="image" items="${details}">
                        <img src="<c:url value='/imgs/${image.anhDaiDien}' />" class="small-img me-2" alt="Ảnh sản phẩm">
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-7">
                <h3 class="product-title">${details[0].tenSanPham}</h3>
                <p class="product-price"><fmt:formatNumber value="${details[0].gia}" type="currency" currencySymbol="VNĐ" /></p>
                <p><i class="bi bi-check-circle text-success"></i> ${details[0].soLuongTrongKho} còn trong kho</p>
                <p><strong>Hãng xe:</strong> ${details[0].hangXe}</p>
                <p><strong>Động cơ:</strong> ${details[0].truyenDong}</p>
                <p><strong>Nhiên liệu:</strong> ${details[0].nhienLieu}</p>
                <div class="d-flex align-items-center">
                    <span class="me-2">Số lượng:</span>
                    <button class="btn btn-light">-</button>
                    <input type="text" value="1" class="form-control text-center mx-2" style="width: 50px;">
                    <button class="btn btn-light">+</button>
                </div>
                <button class="btn btn-cart mt-3 px-4 py-2">Thêm vào giỏ hàng</button>
            </div>
        </div>

        <!-- Tabs: Mô tả, thông số kỹ thuật, đánh giá -->
        <ul class="nav nav-tabs mt-4" id="productTabs">
            <li class="nav-item">
                <a class="nav-link active" data-bs-toggle="tab" href="#description">Mô tả</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-bs-toggle="tab" href="#specs">Thông số kỹ thuật</a>
            </li>

        </ul>

        <div class="tab-content mt-3">
            <!-- Mô tả sản phẩm -->
            <div class="tab-pane fade show active" id="description">
                <p>${details[0].baoHanh}</p>
            </div>

            <!-- Thông số kỹ thuật -->
            <div class="tab-pane fade" id="specs">
                <ul>
                    <li><strong>Truyền động:</strong> ${details[0].truyenDong}</li>
                    <li><strong>Số ghế:</strong> ${details[0].soGhe}</li>
                    <li><strong>Địa điểm lấy xe:</strong> ${details[0].diaDiemLayXe}</li>
                    <li><strong>Nhiên liệu:</strong> ${details[0].nhienLieu}</li>
                </ul>
            </div>

            <!-- Đánh giá -->
            <div class="tab-pane fade" id="reviews">
                <p>Hiện chưa có đánh giá nào cho sản phẩm này.</p>
            </div>
        </div>


    </div>
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
