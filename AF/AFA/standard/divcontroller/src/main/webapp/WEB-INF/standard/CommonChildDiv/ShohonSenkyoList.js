var AFA;
(function (AFA) {
    (function (ShohonSenkyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new ShohonSenkyoList.Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onChange_ddlShohon", function () {
                    (_this.controls.btnHdnChangeShohon()._control).fireEvent("onClick_btnHdnChangeShohon");
                });
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShohonSenkyoList.ModeController = ModeController;
    })(AFA.ShohonSenkyoList || (AFA.ShohonSenkyoList = {}));
    var ShohonSenkyoList = AFA.ShohonSenkyoList;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShohonSenkyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShohonSenkyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShohonSenkyoList.PublicProperties = PublicProperties;
    })(AFA.ShohonSenkyoList || (AFA.ShohonSenkyoList = {}));
    var ShohonSenkyoList = AFA.ShohonSenkyoList;
})(AFA || (AFA = {}));
