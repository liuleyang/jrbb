<%@ page language="java" import="java.util.*,actionForm.*,action.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <link type="text/css" href="css/ui-lightness/luckyDraw.css" rel="stylesheet" />
    <%@page import="java.util.*"%>
<%@page import="dao.PersonDao"%>
<%@page import="actionForm.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script type="text/javascript" src="js/index.js"></script>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/rightMouse.css">
  <link rel="stylesheet" type="text/css" href="css/begin.css">
  <link rel="stylesheet" href="./css/draw/btn.css" type="text/css" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>联迪抽奖软件</title>

<script type="text/javascript">
     var timer;
     var personList = ${person};
 	
 	var len = personList.length;
 	alert("len");
 	
function getArrayItems(arr, num) {
	
	var a;
	var b;
	var d;	
	
    //新建一个数组,将传入的数组复制过来,用于运算,而不要直接操作传入的数组;
    var temp_array = new Array();
    for (var index in arr) {
        temp_array.push(arr[index].person_name);
    }
    //取出的数值项,保存在此数组
    var return_array = new Array();
    for (var i = 0; i<num; i++) {
        //判断如果数组还有可以取出的元素,以防下标越界
        if (temp_array.length>0) {
            //在数组中产生一个随机索引         
            a=temp_array[Math.floor(Math.random()*temp_array.length)];
			document.getElementById('oknum'+i).innerHTML=a;
        } else {
            //数组中数据项取完后,退出循环,比如数组本来只有10项,但要求取出20项.
            break;
        }
    }
    return return_array;
}
$(document).ready(function(){
	$(".dian").click(function(){
		alert("ok")
		document.getElementById('btnOK').setAttribute('disabled','true');
		document.getElementById('stop').removeAttribute('disabled'); 
		clearInterval(timer); 
		timer = setInterval('getArrayItems(personList,6)',1);
	});
});
function start(){ 	
document.getElementById('btnOK').setAttribute('disabled','true');
document.getElementById('stop').removeAttribute('disabled'); 
clearInterval(timer); 
timer = setInterval('getArrayItems(personList,6)',1); //随机数据变换速度，越小变换的越快 
}  
function ok(){ 
clearInterval(timer); 
} 
function GetRnd(min,max){ 
return parseInt(Math.random()*(max-min)); 
} 
function reload(){
window.location.href='index.jsp';
}
</script> 
</head>
<body>
  <div class="back"><img src="image/img4.jpg"></div>

  <div class="title">联迪信息系统股份有限公司年会抽奖</div>

  <marquee class="colee" onmouseover="stop()" onmouseout="start()"> 一路同行  感谢有你</marquee>
  <div class="container1" style="color:white;font-size:27px">
 
<p> 
   
          <c:out value="${prize.grade }"/>
            <c:out value="${prize.name }"/>
            <c:out value="${prize.quantity}"/>名
      
 </p>
 <img src="${pageContext.request.contextPath}/image/${prize.picPath}" style="width:20%;height:auto"/>   
  </div>
   
  <!-- 鼠标右键设定 -->
  <div id="div1">
      <ul>
           <li onclick="managerPage()">管理页面</li>
           <li onclick="javascript:location.reload();">刷新</li>
           <li onclick="requestFullScreen()">全屏</li>
           <li onclick="exitFullscreen()" >退出全屏</li>
     </ul>
  </div>
  <div >	
		<div id="oknum">
		<table id="div3">
			<tr>
			<td>		
        	<div id="oknum0" name="oknum0">请单击开始抽奖</div>
        	<div id="oknum1" name="oknum1"> </div> 
        	<div id="oknum2" name="oknum2"> </div>
        	<div id="oknum3" name="oknum3"> </div> 
        	<div id="oknum4" name="oknum4"> </div>
        	
        	<div id="oknum8" name="oknum8"></div>
        	<div id="oknum9" name="oknum9"> </div> 
        	<div id="oknum5" name="oknum5"> </div>
        	<div id="oknum6" name="oknum6"> </div> 
        	<div id="oknum7" name="oknum7"> </div>
        	</td>
        	</tr> 
        </table>        	 
       </div> 	 	
    </div>
    <div id="div4">	
    <button id="btnOK" class="dian" >点我</button>
		<%-- <a href="PersonAction.do?method=Prize&prize=<%=a%>&quantity=<%=prize.get(0).getQuantity()%>">
		<button onclick="start()" id="btnOK" accesskey="s" name="oknum"  class="button button-pill button-raised button-primary">
			开始(<U>S</U>)
		</button></a> --%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="ok()" id="stop" disabled="disabled" accesskey="o" name="oknum"  class="button button-pill button-raised button-primary">
			停止(<U>O</U>)	
		</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
		<button onclick="reload()" class="button button-pill button-raised button-primary" >下一项(<U>N</U>)</button>									
	</div>
        <p style="position:fixed;right:20px;bottom:20px;color:white;font-size:20px" id="time"></p>
</body>
</html>