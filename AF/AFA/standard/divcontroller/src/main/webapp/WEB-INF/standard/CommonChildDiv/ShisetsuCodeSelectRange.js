var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelectRange) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuCodeSelectRange.Controls(fieldName);
                this.registerEvents();
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            ModeController.prototype.registerEvents = function () {
                var _this = this;
                var fromText = Uz.JSControlUtil.getJSControl("ccdShisetsuCodeFrom_txtShisetsuCode");
                fromText.onChange = "onChange_txtShisetsuCodeFrom";

                Uz.GyomuJSHelper.registOriginalEvent("onChange_txtShisetsuCodeFrom", function () {
                    (_this.controls.btnHiddenFrom()._control).fireEvent("onClick_txtShisetsuCodeFrom");
                });

                var toText = Uz.JSControlUtil.getJSControl("ccdShisetsuCodeTo_txtShisetsuCode");
                toText.onChange = "onChange_txtShisetsuCodeTo";

                Uz.GyomuJSHelper.registOriginalEvent("onChange_txtShisetsuCodeTo", function () {
                    (_this.controls.btnHiddenTo()._control).fireEvent("onClick_txtShisetsuCodeTo");
                });

                var fromBtnShisetsuCode = Uz.JSControlUtil.getJSControl("ccdShisetsuCodeFrom_btnShisetsuCode");
                fromBtnShisetsuCode.onOkClose = "onOKClose_btnShisetsuCodeFrom";

                Uz.GyomuJSHelper.registOriginalEvent("onOKClose_btnShisetsuCodeFrom", function () {
                    (_this.controls.btnHiddenOKCloseFrom()._control).fireEvent("onClick_OKCloseFrom");
                });

                var toBtnShisetsuCode = Uz.JSControlUtil.getJSControl("ccdShisetsuCodeTo_btnShisetsuCode");
                toBtnShisetsuCode.onOkClose = "onOKClose_btnShisetsuCodeTo";

                Uz.GyomuJSHelper.registOriginalEvent("onOKClose_btnShisetsuCodeTo", function () {
                    (_this.controls.btnHiddenOKCloseTo()._control).fireEvent("onClick_OKCloseTo");
                });
            };
            return ModeController;
        })();
        ShisetsuCodeSelectRange.ModeController = ModeController;
    })(AFA.ShisetsuCodeSelectRange || (AFA.ShisetsuCodeSelectRange = {}));
    var ShisetsuCodeSelectRange = AFA.ShisetsuCodeSelectRange;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShisetsuCodeSelectRange) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuCodeSelectRange.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuCodeSelectRange.PublicProperties = PublicProperties;
    })(AFA.ShisetsuCodeSelectRange || (AFA.ShisetsuCodeSelectRange = {}));
    var ShisetsuCodeSelectRange = AFA.ShisetsuCodeSelectRange;
})(AFA || (AFA = {}));
