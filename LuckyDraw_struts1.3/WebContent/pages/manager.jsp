<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抽奖系统</title>
<link type="text/css" href="../css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/ui-lightness/luckyDraw.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.8.18.custom.min.js"></script>
<script>
$(function() {
    $("#showPrize").click(function() {
    	location.href = '../PrizeAction.do?method=showPrizes';
    });
    $("#showPerson").click(function() {
       // $("#main").load("index1.jsp");
    	location.href = '../PersonAction.do?method=showPerson';
    });
});
</script>
</head>
<body>
<button id="showPrize" class="btn first">奖品设置</button>
<button id="showPerson" class="btn first">人员名单</button>
<div id="main">
</div>
</body>
</html>