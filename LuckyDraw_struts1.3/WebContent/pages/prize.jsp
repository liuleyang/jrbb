<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="css/ui-lightness/luckyDraw.css" rel="stylesheet" />
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>添加奖品</title>
</head>
<body>
<div class="container">
    <div class="col-md-5 col-center-block">
    <a href="index.jsp" class="btn add-prize">返回首页</a>
    <form role="form" method="POST" action='UploadController' role="form" name="imageUpload" target="uploadFrame" enctype="multipart/form-data">
      <label>奖品图片 ：</label>
      <input id="lefile" type="file" name="picture" style="display:none" /> 
		<div> 
		<input class="file-input" id="picName" type="text" disabled="disabled" value="<c:out value="${prize.picPath}" />"/> 
		<a class="btn" onclick="$('input[id=lefile]').click();">选择图片文件</a> 
		<button type="submit" class="btn btn-primary right-btn">上传图片</button>
        </div> 
   </form>
   <br/>
   <br/>
   <form role="form" method="POST" action='PrizeAction.do?method=cuPrize'>
     <input type="hidden" name="id" value="<c:out value="${prize.id}" />" />
     <label>奖项 :</label>
       <select class="form-control" name="grade">
         <option>一等奖
         <option>二等奖
         <option>三等奖
         <option>四等奖
       </select>
     <br/>
     <br/>
     <label>奖品名称 :</label>
     <input class="form-control" type="text" name="name" value="<c:out value="${prize.name}" />" required />
     <br/>
     <br/>
     <label>奖品数量 :</label>
     <input class="form-control" type="text" name="quantity" value="<c:out value="${prize.quantity}" />" required />
     <br/>
     <br/>
     <input type="hidden" name="image" value="<c:out value="${prize.picPath}" />" />
     <button type="submit" id="submit" class="btn btn-primary center-btn"></button>
    </form>
    <iframe style="display:none;" name="uploadFrame"></iframe>
    </div>
</div>
    <script>
        $(function() {
        	var url = window.location.href;
        	if(url.indexOf("edit") > 0) {
        		$("title").html('更新奖品');
        	    $('#submit').text('更新奖品'); 
        	} else if(url.indexOf("add") > 0) {
        		$("title").html('添加奖品');
                $('#submit').text('添加奖品');
        	}
        });
        
        function saveName() {
        	var path = $('input[name=picture]').val();
        	var name = path.split("\\");
        	$('input[name=image]').val(name[name.length-1]);
        }
        
        $('input[id=lefile]').change(function() {
            var path = $(this).val()
            var name = path.split("\\");
            $('input[name=image]').val(name[name.length-1]);
            $('#picName').val(name[name.length-1]);
        });
    </script>
</body>
</html>