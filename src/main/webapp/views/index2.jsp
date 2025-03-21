<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <title>AutoCu</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&amp;display=swap"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Bootstrap CSS -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
	
	<!-- Font Awesome CSS -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
	    
    <style>
      .card:hover {
        transform: translateY(-5px);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
      }
      .card-img-top {
	    width: 100%;
	    height: 180px; 
	    object-fit: cover;
	  }
	  img {
		  width: 100%;
		  height: 200px;
		  object-fit: cover; /* Giữ tỷ lệ ảnh */
		}
		button:hover {
		  transition: background-color 0.3s ease;
		}
    </style>
</head>
<body class="font-roboto ">
	<jsp:include page="/common/header.jsp" />

  <!-- Main Content -->
  <div class="relative w-full bg-white">
    <div class="relative w-full h-screen flex items-center justify-center">
      <!-- Background Image -->
      <img src="/imgs/car1.avif" alt="Car" class="absolute inset-0 w-full h-full object-cover" />

      <!-- Overlay -->
      <div class="relative z-10 text-center text-white px-6 lg:px-12">
        <h1 class="text-5xl font-bold leading-tight drop-shadow-lg">
          Tìm kiếm chiếc xe yêu thích của bạn <br />
          & hãy thử nó
        </h1>
        <p class="mt-4 text-lg text-orange-300 drop-shadow-lg">
          Khách hàng tìm đến chúng tôi sẽ được đáp ứng nhu cầu đa dạng với
          các<br />

          thương hiệu xe hơi từ bình dân đến hạng sang và cả những dòng siêu
          xe thể thao.
        </p>
        <button
          class="mt-6 px-6 py-3 border border-white font-semibold rounded-lg hover:bg-white hover:text-black transition drop-shadow-lg">
          LỰA CHỌN NGAY
        </button>
      </div>

      <!-- Overlay Background -->
      <div class="absolute inset-0 bg-black opacity-50"></div>
    </div>

    <div class="mt-0 text-center border-t border-gray-300 pt-10">
      <h2 class="text-2xl font-bold text-gray-900">
        XE QUA SỬ DỤNG ĐANG BÁN
      </h2>
      <div class="flex items-center justify-center mt-2 relative w-full">
        <div class="w-1/6 h-px bg-gray-300"></div>
        <span class="mx-3 text-orange-500 text-2xl"><i class="fas fa-car"> </i></span>
        <div class="w-1/6 h-px bg-gray-300"></div>
      </div>
    </div>
  </div>
  <!--Card car-->
  <div class="container py-5">
    <div class="row g-4">
      <!-- car 1-->
      <c:forEach var="xe" items="${sanPhamList}">
        <div class="col-md-3">
          <div class="card shadow-sm rounded-lg overflow-hidden">
            <img src="/imgs/${xe.anhDaiDien}" class="card-img-top" alt="${xe.tenSanPham}"/>
            <div class="card-body">
              <h5 class="card-title font-bold text-lg">
                ${xe.tenSanPham}
              </h5>
              <p class="d-flex justify-content-between text-muted">
                <span><i class="fas fa-calendar text-green-600"> </i> <fmt:formatDate value="${xe.ngaySanXuat}" pattern="yyyy" /></span>
                <span><i class="fa fa-map-marker"></i> ${xe.diaDiemLayXe}</span>
              </p>
              <p class="d-flex justify-content-between text-muted">
                <span><i class="fas fa-oil-can text-blue-600"> </i> ${xe.nhienLieu}</span>
                <span><i class="fas fa-car-battery text-yellow-700"> </i> ${xe.truyenDong}</span>
              </p>
              <p class="text-danger fw-bold fs-5">
				    <fmt:formatNumber value="${xe.gia}" type="number" groupingUsed="true" /> VND
				</p>

              <div class="d-flex justify-content-between mt-3">
                <a href="#" class="btn btn-outline-primary" onclick="window.location.href='/car?xeID=${xe.productID}'">Chi
                  tiết</a>
                <a href="#" class="btn btn-danger">Mua ngay</a>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
      <!-- Card phu kien xe 1-->
      <div class="mt-0 text-center  pt-10">
        <h2 class="text-2xl font-bold text-gray-900">
          PHỤ KIỆN XE BÁN CHẠY
        </h2>
        <div class="flex items-center justify-center mt-2 relative w-full">
          <div class="w-1/6 h-px bg-gray-300"></div>
          <span class="mx-3 text-orange-500 text-2xl"><i class="fas fa-tools"> </i></span>
          <div class="w-1/6 h-px bg-gray-300"></div>
        </div>
      </div>
      <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5 gap-6">
        <c:forEach var="phukien" items="${phuKienOtoList}">
        <!-- Card 1 -->
        <div class="bg-white rounded-lg shadow-md p-4 w-64 relative">

          <div class="relative">
            <img src="/imgs/${phukien.anhDaiDien}" alt="${phukien.tenPhuKien}" class="rounded-lg w-full h-[200px] object-cover">
            <div class="absolute top-2 right-2 flex flex-col space-y-2">
              <button class="bg-white p-2 rounded-full shadow-md hover:bg-gray-200">
                <i class="fas fa-search text-gray-600"></i>
              </button>
              <button class="bg-white p-2 rounded-full shadow-md hover:bg-gray-200">
                <i class="far fa-heart text-gray-600"></i>
              </button>
              <button class="bg-white p-2 rounded-full shadow-md hover:bg-gray-200">
                <i class="fas fa-sync-alt text-gray-600"></i>
              </button>
            </div>
          </div>
          <h2 class="text-lg font-semibold mt-3"> ${phukien.tenPhuKien} </h2>
          <div class="flex text-yellow-500 mt-1">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="far fa-star"></i>
          </div>
          	<p class="text-danger fw-bold fs-5">
				<fmt:formatNumber value="${phukien.gia}" type="number" groupingUsed="true" /> VND
			</p>
          
            <!-- Form gửi yêu cầu thêm vào giỏ hàng -->
	        <form action="/addToCart" method="post">
	            <input type="hidden" name="productId" value="${phukien.accessoryID}" />
	            <input type="hidden" name="quantity" value="1" />
	            <button type="submit" class="w-full bg-black text-yellow-400 py-2 rounded-full font-semibold mt-3 hover:bg-gray-800">
	                ADD TO CART
	            </button>
	        </form>
        </div>
      </c:forEach>
      </div>
      <jsp:include page="/common/footer.jsp" />
</body>
</html>