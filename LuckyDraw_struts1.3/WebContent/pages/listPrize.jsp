<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="css/ui-lightness/luckyDraw.css" rel="stylesheet" />
<title>奖品列表</title>
</head>
<body>
<div class="table-area">
    <div class="col-md-8 col-center-block">
    <a href="index.jsp" class="btn add-prize">返回首页</a>
    <button type="button" class="btn add-prize" onclick="return addPrize()">
      <span class="glyphicon glyphicon-plus"></span> 添加奖品
    </button>
    <br/>
    <table class="table" border=1>
      <thead>
        <tr>
          <th>奖项</th>
          <th>奖品名称</th>
          <th>奖品数量</th>
          <th>奖品图片</th>
          <th colspan=2>操作</th>
        </tr>
      </thead>
      <tbody>
        <logic:present name="prizes" scope="request">
          <logic:iterate id="prize" name="prizes" scope="request">
            <tr>
              <td><c:out value="${prize.grade}" /></td>
              <td><c:out value="${prize.name}" /></td>
              <td><c:out value="${prize.quantity}" /></td>
              <td><img style="height:80px;" src="<%=request.getContextPath()%>${prize.picPath}"></td>
              <td><a href="PrizeAction.do?method=editPrize&id=<c:out value="${prize.id}"/>">修改</a></td>
              <td><a href="../PrizeAction.do?method=deletePrize&id=<c:out value="${prize.id}"/>">删除</a></td>
            </tr>
          </logic:iterate>
        </logic:present>
      </tbody>
    </table>
  </div>
</div>

<script>
   function addPrize() {
     location.href = 'PrizeAction.do?method=addPrize';
   // var prizeList = ${prizesJson};
   // console.log(prizeList);
  }
</script> 
</body>
</html>