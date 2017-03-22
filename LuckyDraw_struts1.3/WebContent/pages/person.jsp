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
      <label>人员照片 ：</label>
      <input id="lefile" type="file" name="person_photo" style="display:none"> 
		<div> 
		<input class="file-input" id="picName" type="text" disabled="disabled" value="<c:out value="${person.person_photo}" />"> 
		<a class="btn" onclick="$('input[id=lefile]').click();">选择图片文件</a> 
		<button type="submit" class="btn btn-primary right-btn">上传图片</button>
        </div> 
   	</form>
   <br/>
   <br/>
   <form role="form" method="POST" action='PersonAction.do?method=cuPerson'>
     <input type="hidden" name="person_id" value="<c:out value="${person.person_id}" />" />
     <br/>
     <br/>
     <label>人员姓名 :</label>
     <input class="form-control" type="text" name="person_name" value="<c:out value="${person.person_name}" />" />
     <br/>
     <br/>
     <input type="hidden" name="image" value="<c:out value="${person.person_photo}" />"/>
     <div align="center">
       <button type="submit" id="submit" class="btn btn-primary center-btn"></button>
     </div>
    </form>
    <iframe style="display:none;" name="uploadFrame"></iframe>
    </div>
</div>
    <script>
        $(function() {
        	var url = window.location.href;
        	if(url.indexOf("edit") > 0) {
        		$("title").html('更新人员');
        	    $('#submit').text('更新人员');
        	} else if(url.indexOf("insert") > 0) {
        		$("title").html('添加人员');
                $('#submit').text('添加人员');
        	}
        });
        
        function saveName() {
        	var path = $('input[name=person_photo]').val();
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