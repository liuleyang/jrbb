var BarCode = $("#ccdJuriBarCode_txtBarCode_core");
BarCode.on("keyup", function() {
    if (20 <= BarCode.val().length) {
        BarCode.blur();
    }
});