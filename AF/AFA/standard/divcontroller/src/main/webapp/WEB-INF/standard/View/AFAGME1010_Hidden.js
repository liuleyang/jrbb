$(document).on("click", "#btnUpdate", function() {

    var $targetElement = $("#ccdKijitsumaeSenkyoninTohyoJokyo");
    var validateMessages = [];
    $targetElement.find(".JSControl:visible").each(function(index, element) {
        var control = Uz.JSControlUtil.getJSControl($(element).attr("id"));
        var validateMessage = control.validateControl();
        for (var i = 0; i < validateMessage.length; i++) {
            if ("controlId" in validateMessage[i]) {
                validateMessages.push(validateMessage[i]);
            } else {
                for (var j = 0; j < validateMessage[i].length; j++) {
                    if ("controlId" in validateMessage[i][j]) {
                        validateMessages.push(validateMessage[i][j]);
                    }
                }
            }
        }
    });
    if (validateMessages.length !== 0) {
        Uz._Message.removeAllErrorUl();
        Uz._Message.showValidateErrorMessage_Client(validateMessages);
        return;
    }

    $("#hiddenPrintButtonDialogFlg > span").text("continue");
    setTimeout("checkDialog()",500);

});

function checkDialog()
{
    if ($("#hiddenPrintButtonDialogFlg > span").text() !== "continue") {

        if ($("#hiddenPrintButtonDialogFlg > span").text() === "open") {
            $("#hiddenPrintButtonDialog > span").click();
        }
    } else {
        setTimeout("checkDialog()",500);
    }
}

$(document).on("click", ".ui-dialog-buttonset button", function(event1) {
    var $span1 = $(event1.target);
    if ($span1.text() === "はい" && $(".ui-dialog-title").text() === "エラー" && $("#hiddenPrintButtonDialogFlg > span").text() === "continue") {
        $("#hiddenPrintButtonDialogFlg > span").text("close");
    }
    if ($span1.text() === "キャンセル" && $("#hiddenPrintButtonDialogFlg > span").text() === "continue") {
        $("#hiddenPrintButtonDialogFlg > span").text("close");
    }

});

var BarCode = $("#ccdKijitsumaeBarCode_txtBarCode_core");
BarCode.on("keyup", function() {
    var length = $("#ccdKijitsumaeBarCode_length > span").text();
    if (length <= BarCode.val().length) {
        BarCode.blur();
    }
});