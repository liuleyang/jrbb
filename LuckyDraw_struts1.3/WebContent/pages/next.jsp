<%@page import="actionForm.PersonForm"%>
<%@ page language="java" import="java.util.*,dao.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <script type="text/javascript" src="js/index.js"></script>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/rightMouse.css">
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>联迪抽奖软件</title>
</head>
<body>
	<%List<PersonForm> l = (List<PersonForm>)request.getAttribute("person");	%>
	
  <div class="back"><img src="image/img4.jpg"></div>

  <div class="title">联迪信息系统股份有限公司年会抽奖</div>

  <marquee class="colee" onmouseover="stop()" onmouseout="start()"> 一路同行  感谢有你</marquee>
  <div class="container1">
   
     <marquee class="colee1" direction=up> 

    
     <p>一等奖</p>
     <% for(int i=0; i<l.size(); i++){ 
      	  if(l.get(i).getAward()==1){  
     	 %>
     	
     	 	<%=l.get(i).getPerson_name()%>
     	 	
     	
     	 <%  }
     }%><br>
      <p>二等奖</p>
     <% for(int i=0; i<l.size(); i++){ 
      	  if(l.get(i).getAward()==2){  
     	 %>
     	
     	 	<%=l.get(i).getPerson_name()%>
     	 
     
     	 <%  }
     }%>
     <br>
      <p>三等奖</p>
     <% for(int i=0; i<l.size(); i++){ 
      	  if(l.get(i).getAward()==3){  
     	 %>
     	 <%=l.get(i).getPerson_name()%>
     	 	
     	 <%  }
     }%>
   
    </marquee> 
  
  </div>
  <div style=""> 
   <a href="index.jsp" class="showbutton">返回首页</a>
   </div>
   <!-- 右键设置 -->
  <div id="div1">
      <ul>
           <li onclick="managerPage()">管理页面</li>
           <li onclick="javascript:location.reload();">刷新</li>
           <li onclick="requestFullScreen()">全屏</li>
           <li onclick="exitFullscreen()" >退出全屏</li>
     </ul>
  </div>
  
  
  <p style="position:fixed;right:20px;bottom:20px;color:white;font-size:20px" id="time"></p>
 
</body>
</html>