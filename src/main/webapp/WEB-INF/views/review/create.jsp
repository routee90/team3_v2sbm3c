<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>http://localhost:9091/review/create.do</title>
 
<link href="/css/style.css" rel="Stylesheet" type="text/css">
 <link href="/css/review.css" rel="Stylesheet" type="text/css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Bootstrap -->
<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-gothic-coding.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">

</script>
 
</head> 
 
<body>
<jsp:include page="../menu/top.jsp" flush='false' />
<div class="min-vh-100 gradient-custom-3">
 
 <br><br><br>
<div class="container">


  <FORM name='frm' method=POST action='./create.do' class="form-horizontal"
             enctype="multipart/form-data">
  
   <DIV class='title_line'>
   <label class="control-label col-md-3"></label>
   
  <strong class="form-horizontal">${reviewVO.storeno }(매장명칭)</strong><!-- 매장 명칭 -->
   </DIV>

    <div align="center">
    <div class="form-group">
       <label class="display-1"></label>
       <div class="col-md-6">
         <textarea name='contents' required="required" class="form-control" rows="12" style='resize: none;'>
         
         </textarea>
       </div>
    </div>
    </div>
       
        
       <div class="form-group">
        
        <br>
       <div class="col-md-3">
         <input type='file' class="form-control" name='file1MF' id='file1MF' 
                    value='' placeholder="">
        </div>
        </div>   
    <br>
    <div align="center">
    <div class="form-group">
    
      <button type="submit" class="btn btn-primary">등록</button>
      <button type="button" onclick="location.href='./list.do'" class="btn btn-primary">목록</button>
    </div>
    </div>
    
    <!-- 별점 -->
 <label class="rating-label" >
  <input
    style='background-color: transparent;'
    class="rating rating--nojs"
    max="5"
    step="1"
    type="range"
    value="1">
</label>
  
       
  </FORM>
  
  </div>
</body>

</html>