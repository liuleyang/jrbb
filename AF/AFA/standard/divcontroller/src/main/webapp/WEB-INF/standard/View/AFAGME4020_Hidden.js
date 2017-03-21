var BarCode = $("#ccdNyujokenBarCode_txtBarCode_core");
BarCode.on("keyup", function() {
    var length = $("#ccdNyujokenBarCode_length > span").text();
    if (length <= BarCode.val().length) {
        BarCode.blur();
    }
});