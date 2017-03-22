<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="css/ui-lightness/luckyDraw.css" rel="stylesheet" />
<title>人员名单</title>
</head>
<body>
<div class="table-area">
    <div class="col-md-8 col-center-block">
    <a href="index.jsp" class="btn add-prize">返回首页</a>
    <button type="button" class="btn add-prize" onclick="return addPerson()">
      <span class="glyphicon glyphicon-plus"></span> 添加人员
    </button>
    <br/>
    <table class="table" border=1>
        <thead>
            <tr>
                <th>人员名称</th>
                <th>人员照片</th>
                <th colspan=2>操作</th>
            </tr>
        </thead>
        <tbody >
            <c:forEach items="${person}" var="person">
 
                <tr>
                    <td><c:out value="${person.person_name}" /></td>
                    <td><img style="height:80px;" src="<%=request.getContextPath()%>${person.person_photo}"></td>
                    <td><a href="PersonAction.do?method=editPerson&id=<c:out value="${person.person_id}"/>">修改</a></td>
                    <td><a href="PersonAction.do?method=deletePerson&id=<c:out value="${person.person_id}"/>">删除</a></td>
                </tr>
   
            </c:forEach>
        </tbody>
    </table>
  </div>
</div>
<script>
function addPerson() {
    location.href = 'PersonAction.do?method=addPerson';
  // var prizeList = ${prizesJson};
  // console.log(prizeList);
 }
</script> 
</body>
</html>