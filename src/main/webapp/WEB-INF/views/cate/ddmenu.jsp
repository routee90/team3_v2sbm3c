<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
    content="user-scalable=yes, initial-scale=1.0, minimum-scale=1.0,
                                 maximum-scale=5.0, width=device-width" />
<title>http://localhost:9091/</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c579d9f33d9ed56b400411961b5eacbc"></script><!-- 가장 중요한 부분 -->

<!-- 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
 -->
<link href="/css/style.css" rel="stylesheet">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
<!-- <link rel="stylesheet" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/core.min.css"> -->


<!-- <link rel='stylesheet' id='roboto-subset.css-css'  href='https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/mdb5/fonts/roboto-subset.css?ver=3.9.0-update.5' type='text/css' media='all' /> -->


<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
*{font-family: "NanumGothic", "SpoqaHanSans", "Noto Sans SC", "APPLE SD Gothic NEO", "sans-serif";}


.container {
  position: relative;
  width: 50%;
  float: left; 
  width: 30%; 
  padding:10px;
}

.image {
  opacity: 1;
  display: block;
  width: 100%;
  height: auto;
  transition: .5s ease;
  backface-visibility: hidden;
}

.middle {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

.container:hover .image {
  opacity: 0.3;
}

.container:hover .middle {
  opacity: 1;
}

.text {
  background-color: #04AA6D;
  color: white;
  font-size: 16px;
  padding: 16px 32px;
}
</style>


</head>
<body>
<jsp:include page="../menu/top.jsp" flush='false' />

    <DIV class="gradient-custom-3">
    <form action="/search/result" method="GET" class="search">
    <br><br><br><br>
        <input type="text" id="searchWord" name="searchWord"
            placeholder="지역, 점포명을 입력 해 주세요" maxlength="50" size="60">
        <!-- <input id="searchButton" type="image" src="" style="width:25px; height:25px;" alt="Submit Form"/> -->
        <button class="searchButton">검색</button>
    </form>
<br>
<br><br>
<!-- Carousel wrapper -->

<DIV class='content_body'>
  <DIV class='menu_line'></DIV>
  
  <table class="table table-striped" style='width: 100%;'>
    <colgroup>
      <col style="width: 1%;"></col>
      <col style="width: 99%;"></col>
    </colgroup>
    <%-- table 컬럼 --%>
<!--     <thead>
      <tr>
        <th style='text-align: center;'>파일</th>
        <th style='text-align: center;'>상품명</th>
        <th style='text-align: center;'>정가, 할인률, 판매가, 포인트</th>
        <th style='text-align: center;'>기타</th>
      </tr>
    
    </thead> -->
    
    <%-- table 내용 --%>
    <tbody>
      <c:forEach var="cateVO" items="${list }">
        <c:set var="cateno" value="${cateVO.cateno }" />
        <c:set var="title" value="${cateVO.title }" />
        <c:set var="rdate" value="${cateVO.sysdate }" />
        
        
        <tr> 
          <td style='vertical-align: middle; text-align: center;'>
            <c:choose>
<%--               <c:when test="${thumb1.endsWith('jpg') || thumb1.endsWith('png') || thumb1.endsWith('gif')}">
                /static/contents/storage/
                <a href="./read.do?contentsno=${contentsno}&now_page=${param.now_page }"><IMG src="/contents/storage/${thumb1 }" style="width: 120px; height: 80px;"></a> 
              </c:when> --%>
              <c:otherwise> <!-- 기본 이미지 출력 -->
                <IMG src="/cate/images/none01.jpg" style="width: 300px; height: 200px;">
              </c:otherwise>
            </c:choose>
          </td>  
          
          
           <td style='text-align: left;'>
                <a href='#' style='text-decoration:none; color:black;'><h4>학술적연구소</h4></a> 
                    <div style='color:gray;'>
                       서울 특별시 뭐뭐구 뭐뭐동 뭐뭐빌라 1층
                    </div>
                    <div class="si">
                    오늘의 리이이이뷰 꺄륵깨륵 깔랑룽DDDDDDDDDDDDDDDD<BR>
                    DDDDDDDDDDDDDDDDDDDD
                    </div>
           </td>
        </tr>
          </table>
          
        <table class="table table-striped" style='width: 100%;'>
          <DIV class='menu_line'></DIV>
        
           <tr> 
          <td style='vertical-align: middle; text-align: center;'>
            <c:choose>
<%--               <c:when test="${thumb1.endsWith('jpg') || thumb1.endsWith('png') || thumb1.endsWith('gif')}">
                /static/contents/storage/
                <a href="./read.do?contentsno=${contentsno}&now_page=${param.now_page }"><IMG src="/contents/storage/${thumb1 }" style="width: 120px; height: 80px;"></a> 
              </c:when> --%>
              <c:otherwise> <!-- 기본 이미지 출력 -->
                <IMG src="/cate/images/none01.jpg" style="width: 300px; height: 200px;">
              </c:otherwise>
            </c:choose>
          </td>  
          
           <td style='text-align: left;'>
                <a href='#' style='text-decoration:none; color:black;'><h4>복덕방</h4></a> 
                    <div style='color:gray;'>
                       서울 특별시 뭐뭐구 뭐뭐동 뭐뭐빌라 1층
                    </div>
                    <div class="si">
                    오늘의 리이이이뷰 꺄륵깨륵 깔랑룽DDDDDDDDDDDDDDDD<BR>
                    DDDDDDDDDDDDDDDDDDDD
                    </div>
           </td>
        </tr>
        </table>
        
     <table class="table table-striped" style='width: 100%;'>
               <DIV class='menu_line'></DIV>
     
         <tr> 
          <td style='vertical-align: middle; text-align: center;'>
            <c:choose>
<%--               <c:when test="${thumb1.endsWith('jpg') || thumb1.endsWith('png') || thumb1.endsWith('gif')}">
                /static/contents/storage/
                <a href="./read.do?contentsno=${contentsno}&now_page=${param.now_page }"><IMG src="/contents/storage/${thumb1 }" style="width: 120px; height: 80px;"></a> 
              </c:when> --%>
              <c:otherwise> <!-- 기본 이미지 출력 -->
                <IMG src="/cate/images/none01.jpg" style="width: 300px; height: 200px;">
              </c:otherwise>
            </c:choose>
          </td>  
          
           <td style='text-align: left;'>
                <a href='#' style='text-decoration:none; color:black;'><h4>산울림1992</h4></a> 
                    <div style='color:gray;'>
                       서울 특별시 뭐뭐구 뭐뭐동 뭐뭐빌라 1층
                    </div>
                    <div class="si">
                    오늘의 리이이이뷰 꺄륵깨륵 깔랑룽DDDDDDDDDDDDDDDD<BR>
                    DDDDDDDDDDDDDDDDDDDD
                    </div>
           </td>
        </tr>
        </table>
        
      </c:forEach>
    </tbody>

  
  <!-- 페이지 목록 출력 부분 시작 -->
  <DIV class='bottom_menu'>${paging }</DIV> <%-- 페이지 리스트 --%>
  <!-- 페이지 목록 출력 부분 종료 -->
  
</DIV>
</DIV>

<div style='width:500px; height:500px; float:left;'>

<div id="map" style="width:500px;height:500px; float:left;"></div>  <!-- div= 지도 넣는 곳  / 크기 조절은 width,height) -->


<script type="text/javascript">
 var mapContainer = document.getElementById('map');   /* mapContainer 변수에 map값 넣음 */
    mapOption = {                                                       /* mapOption에 어떤 지도를 불러 올지 정함 */
       center: new kakao.maps.LatLng(37.602829, 127.039508), //지도의 위도, 경도    /* 이 경우엔 카카오 지도에서 가져옴 */
        level: 3 // 지도의 확대 레벨
    };
var map = new kakao.maps.Map(mapContainer, mapOption); 
 var markerPosition  = new kakao.maps.LatLng(37.602829, 127.039508);   //마커의 위도, 경도

var marker = new kakao.maps.Marker({
 position: markerPosition
});
marker.setMap(map); 
 
</script>

<div style=''></div>

</div>

</body>
</html>
