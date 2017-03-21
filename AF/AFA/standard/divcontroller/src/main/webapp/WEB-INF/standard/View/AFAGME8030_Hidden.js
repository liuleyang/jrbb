$(document).on("click", "#btnFileUploadAndExecute", function() {
    
    $("#hiddenBatchExecuteFlg > span").text("continue");
    setTimeout("checkDialog()",500);

});

function checkDialog()
{
    if ($("#hiddenBatchExecuteFlg > span").text() !== "continue") {

        if ($("#hiddenBatchExecuteFlg > span").text() === "open") {
            $("#hiddenBatchExecuteFlg > span").text("continue");                    
            setTimeout("checkDialog()",500);
            setTimeout("btnExecuteByCSVClick()",3000);
        }
    } else {
        
        setTimeout("checkDialog()",500);
    }
}

function btnExecuteByCSVClick()
{
    var closeFlg = 0;
    $("button").find("span").each(function(){
        
        if ($(this).text() === "閉じる") { 
            closeFlg = 1;
            $(this).parent().click();
            $("#btnExecuteByCSV").click();
            return false;
        }
    });
    
    if (closeFlg === 0) {
        $("#btnExecuteByCSV").click();
    }
}
