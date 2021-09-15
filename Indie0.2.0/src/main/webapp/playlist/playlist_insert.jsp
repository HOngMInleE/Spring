<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findZipNum</title>
<style type="text/css">
	body{   
	   background-color:#f6f6f6;
	   font-family: Verdana;
	}
	#popup{   
	   padding: 0 10px;
	}
	
	table#zipcode {
	    border-collapse:collapse;    /* border 사이의 간격 없앰 */   
	    border-top: 3px solid black;  
	    border-bottom: 3px solid black;
	    width: 100%;  
	    margin-top: 15px; 
	}
	table#zipcode th, table#zipcode td{   
	   text-align: center;
	   border-bottom: 1px dotted #black;  
	}
	table th, td{
	  padding: 10px;
	}
	table#zipcode  a{
	   display:block; 
	    height:20px;
	    text-decoration:none;
	    padding: 10px;
	}
	table#zipcode a:hover{
	    color: #F90;
	    font-weight: bold;
	}
</style>
<script type="text/javascript">
	function result(pl_title) {
	   opener.document.formm.pl_title.value=pl_title;
	  /*  // opener.document.formm.addr1.value=sido+" "+gugun+" "+dong; */
	   self.close();
	};
</script>
</head>
<body>
	<div id="popup">
		<form method="post" name="formm" action="IndieServlet?command=Playlist_InsertAction">
			플레이리스트 이름 : <input type="text" name="pl_title">
					<input type="submit" value="확인" class="submit">
		</form>
		<table id="zipcode">
			<tr>
				<th>플레이리스트 명</th>
			</tr>
			<c:forEach items="${my_playlist}" var="my_playlist">
				<tr>
					<td>
						<a href="#" onclick="return result('${my_playlist.pl_title}')">
							${my_playlist.pl_title}
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>