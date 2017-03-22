//右键设定
document.oncontextmenu = function (ev)
{
var oEvent=ev||event;
var oDiv=document.getElementById('div1');   
oDiv.style.display='block';
oDiv.style.left=oEvent.clientX+'px';
oDiv.style.top=oEvent.clientY+'px';   
return false;
};
document.onclick=function ()
{
var oDiv=document.getElementById('div1');   
oDiv.style.display='none';
};


//进入全屏
function requestFullScreen() {
	     var de = document.documentElement;
	     if (de.requestFullscreen) {
	        de.requestFullscreen();
	     } else if (de.mozRequestFullScreen) {
	         de.mozRequestFullScreen();
	     } else if (de.webkitRequestFullScreen) {
	        de.webkitRequestFullScreen();
	     }
	 }
	 //退出全屏
function exitFullscreen() {
	     var de = document;
	     if (de.exitFullscreen) {
	         de.exitFullscreen();
	     } else if (de.mozCancelFullScreen) {
         de.mozCancelFullScreen();
	     } else if (de.webkitCancelFullScreen) {
	        de.webkitCancelFullScreen();
	    }
  }
//时间设置
window.onload = function(){
    showTime();
  }
 
  function showTime(){
    var myDate = new Date();
    var hours = myDate.getHours();
    var minutes = formatTime(myDate.getMinutes());
    var seconds = formatTime(myDate.getSeconds());
 
    var systemTime = document.getElementById("time");
    systemTime.innerHTML = " " + hours + ":" + minutes + ":" + seconds;
    setTimeout("showTime()",500);
  }
 
  //格式化时间：分秒。
  function formatTime (i){
    if(i < 10){
      i = "0" + i;
    }
    return i;
  }
  function managerPage() {
		location.href = '/LuckyDraw_struts1.3/pages/manager.jsp';
	}
