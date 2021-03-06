<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dev.mvc.login.LoginType" %>

<nav class="navbar fixed-top navbar-expand-md navbar-light bg-light">
  <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
        </ul>
    </div>
    <div class="mx-auto order-0">
        <ul class="navbar-nav me-auto">
        <li class="nav-item">
            <img src="/images/tmp_logo.png" width="25" height="25">
        </li>
        <li class="nav-item">
            <a class="navbar-brand mx-auto" href="/">&nbsp;Team3</a>
        </li>
        </ul>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item dropdown">
                <form class="d-flex">
                  <a class="nav-link active" aria-current="page" href="/notice/list_search_paging.do">공지사항</a>
                  <a class="nav-link active" aria-current="page" href="/recom/recom.do">맛집&nbsp;추천</a>
                  <a class="nav-link active" aria-current="page" href="/chatbot.do">챗봇</a>
                  <c:choose>
                    <c:when test="${sessionScope.type == null}">
                        <a class="nav-link active" href="/login.do">로그인</a>
                    </c:when>
                    <c:when test="${sessionScope.type ==  LoginType.NORMAL}">
                        <!-- <a class="nav-link active" href="/logout.do">로그아웃</a> -->
                        <div class="dropdown">
                            <button class="dropdown_btn"><img class="profile" src="/images/user_logo.png" title="사용자명 : ${sessionScope.name }"></button>
                            <div class="dropdown_content">
                                <span>${sessionScope.name }</span>
                                <a href="/mypage.do">마이페이지</a>
                                <a href="/favorite.do">즐겨찾기</a>
                                <a href="/logout.do">로그아웃</a>
                            </div>
                        </div>
                        <%-- <a href="/mypage.do"><img class="profile" src="/images/user_logo.png" title="사용자명 : ${sessionScope.name }"></a> --%>
                    </c:when>
                    <c:when test="${sessionScope.type ==  LoginType.ADMIN}">
                        <!-- <a class="nav-link active" href="/logout.do">로그아웃</a> -->
                        <div class="dropdown">
                            <button class="dropdown_btn"><img class="profile" src="/images/user_logo.png" title="사용자명 : ${sessionScope.name }"></button>
                            <div class="dropdown_content">
                                <span>${sessionScope.name }</span>
                                <a href="/users/list.do">유저 목록</a>
                                <a href="/store/list.do">매장 목록</a>
                                <a href="/logout.do">로그아웃</a>
                            </div>
                        </div>
                    </c:when>
                  </c:choose>
                  
                </form>
            </li>
      </ul>
    </div>
</nav>