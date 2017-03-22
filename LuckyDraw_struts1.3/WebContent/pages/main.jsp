<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/index.js"></script>
 <link rel="stylesheet" type="text/css" href="css/index.css">
 <link rel="stylesheet" type="text/css" href="css/rightMouse.css">
<link type="text/css" href="css/ui-lightness/luckyDraw.css" rel="stylesheet" />
<title>年会奖品</title>
</head>
<body>
<div class="back"><img src="image/img4.jpg"></div>
<div class="title">联迪信息系统股份有限公司年会抽奖</div>

  <marquee class="colee" onmouseover="stop()" onmouseout="start()"> 一路同行  感谢有你</marquee>
<div>
    <div align="center">
    <table><tr>
     <logic:present name="prizes" scope="request">
          <logic:iterate id="prize" name="prizes" scope="request">
            <td><p class="prize" align="center"> <c:out value="${prize.grade}" />
              <c:out value="${prize.name}" />
              <c:out value="${prize.quantity}" /></p>
              <a href="PrizeAction.do?method=selectPrize&id=<c:out value="${prize.id}"/>"><img class="imgsize" src="<%=request.getContextPath()%>${prize.picPath}"></a>
            </td>
             <%--  <a href="PrizeAction.do?action=jump&id=<c:out value="${prize.id}"/>">
              <button class="btn btn-primary center-btn" style="height:80px; font-size:16pt">进入抽奖</button></a> --%>
          </logic:iterate>
      </logic:present>  </tr>
    <tr> <td colspan="">
   <a class="showbutton" href='/LuckyDraw_struts1.3/PrizeAction.do?method=showPrizesbyaward'>中奖结果</a> 
   </td></tr>
   </table>
    <!-- <button type="button" class="btn btn-lg btn-danger center-btn" href="/PrizeController?action=show">
           抽奖结果
    </button> -->
  </div>
</div>
<!-- 右键设置 -->
<div id="div1">
      <ul>
           <li onclick="managerPage()">管理页面<hr/></li>
           <li onclick="javascript:location.reload();">刷新<hr/></li>
           <li onclick="requestFullScreen()">全屏</li>
           <li onclick="exitFullscreen()" >退出全屏</li>
     </ul>
  </div>
<p style="position:fixed;right:20px;bottom:20px;color:white;font-size:20px" id="time"></p>
</body>
</html>