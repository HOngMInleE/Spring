<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="resources/css/main.css" rel="stylesheet">

<div class="clear"></div>
<!-- css : .clear{clear:both;} -->

<!-- 메인 화면 -->
<!-- 이미지 슬라이드 -->
<div class="w-auto mb-5">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel" style="height: 450px;">
		<!-- 하단 버튼 -->
		<div class="carousel-indicators w-75">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active bg-danger" aria-current="true"
				aria-label="Slide 1" value="보드게임 이름">
				<!-- 보드게임 이름 -->
			</button>
			<button type="button" class="bg-danger"
				data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
				aria-label="Slide 2"></button>
			<button type="button" class="bg-danger"
				data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
				aria-label="Slide 3"></button>
			<button type="button" class="bg-danger"
				data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
				aria-label="Slide 4"></button>
		</div>
		<!-- 내용(이미지) -->
		<div class="carousel-inner w-75 mx-auto">
			<div class="carousel-item active">
				<a href="#"> <img class="d-block w-75 mx-auto"
					src="resources/images/LOGO.png" alt="Logo" width="70%" height="400">
				</a>
			</div>
			<div class="carousel-item">
				<a href="#"> <img class="d-block w-75 mx-auto"
					src="resources/images/LOGO.png" alt="Logo" width="70%" height="400">
				</a>
			</div>
			<div class="carousel-item">
				<a href="#"> <img class="d-block w-75 mx-auto"
					src="resources/images/LOGO.png" alt="Logo" width="70%" height="400">
				</a>
			</div>
			<div class="carousel-item">
				<a href="#"> <img class="d-block w-75 mx-auto"
					src="resources/images/LOGO.png" alt="Logo" width="70%" height="400">
				</a>
			</div>
		</div>
		<!-- 좌우 버튼 -->
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"
				style="background-color: red;"></span> <span class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"
				style="background-color: red;"></span> <span class="visually-hidden">Next</span>
		</button>
	</div>
</div>

<!-- 테이블 메뉴 -->
<div class="container" style="width: 80%;">
	<table class="w-100 text-white">
		<tr class="row w-80 mx-auto" style="height: 200px;">
			<td class="col-md-6 col-sm-6"
				style="background-color: rgba(255, 130, 0, 0.8);">Promotion or
				SNS</td>
			<td id="carouselExampleControls"
				class="carousel slide col-md-6 col-sm-6 px-0"
				data-bs-ride="carousel">
				<div class="carousel-inner position-absolute">
					<div class="carousel-item active row">
						<div class="col-md-6 col-sm-6 d-table-cell"
							style="background-color: rgba(80, 80, 255, 0.8); height: 200px;">커뮤니티
							카테고리</div>
						<div class="col-md-6 col-sm-6 d-table-cell"
							style="background-color: rgba(10, 110, 205, 0.8);">해당 카테고리
							인기 게시글</div>
					</div>
					<div class="carousel-item row" style="width: 100%;">
						<div class="col-md-6 col-sm-6 d-table-cell"
							style="background-color: rgba(80, 80, 255, 0.8); height: 200px;">커뮤니티
							카테고리</div>
						<div class="col-md-6 col-sm-6 d-table-cell"
							style="background-color: rgba(10, 110, 205, 0.8);">해당 카테고리
							인기 게시글</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"
						style="background-color: rgba(0, 0, 0, 0.5);"></span> <span
						class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"
						style="background-color: rgba(0, 0, 0, 0.5);"></span> <span
						class="visually-hidden">Next</span>
				</button>
			</td>
		</tr>
		<tr class="row w-80 mx-auto" style="height: 200px;">
			<td class="col-md-3 col-sm-3"
				style="background-color: rgba(50, 150, 50, 0.8);">오시는 길</td>
			<td class="col-md-3 col-sm-3"
				style="background-color: rgba(255, 50, 50, 0.8);">Best 제품</td>
			<td class="col-md-6 col-sm-6"
				style="background-color: rgba(144, 109, 59, 0.8);">(필독)공지사항</td>
		</tr>
	</table>

	<!-- 베스트 상품 -->
	<div class="clear"></div>

	<div class="album py-5">
		<h2>베스트 게임</h2>
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-2">
			<div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%"
						height="225" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder: Thumbnail"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

					<div class="card-body"></div>
				</div>
			</div>
			<div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%"
						height="225" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder: Thumbnail"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

					<div class="card-body">
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<div class="d-flex justify-content-between align-items-center">
							<div class="btn-group">
								<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
							</div>
							<small class="text-muted">9 mins</small>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%"
						height="225" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder: Thumbnail"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

					<div class="card-body">
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<div class="d-flex justify-content-between align-items-center">
							<div class="btn-group">
								<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
							</div>
							<small class="text-muted">9 mins</small>
						</div>
					</div>
				</div>
			</div>

			<div class="col">
				<div class="card shadow-sm">
					<svg class="bd-placeholder-img card-img-top" width="100%"
						height="225" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder: Thumbnail"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c" />
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

					<div class="card-body">
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<div class="d-flex justify-content-between align-items-center">
							<div class="btn-group">
								<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
								<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
							</div>
							<small class="text-muted">9 mins</small>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>


</div>
<!-- container -->

<%@ include file="../footer.jsp"%>