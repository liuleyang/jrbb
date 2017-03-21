var AFA;
(function (AFA) {
    (function (ShohonSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new ShohonSelect.Controls(fieldName);

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
        ShohonSelect.ModeController = ModeController;
    })(AFA.ShohonSelect || (AFA.ShohonSelect = {}));
    var ShohonSelect = AFA.ShohonSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShohonSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShohonSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShohonSelect.PublicProperties = PublicProperties;
    })(AFA.ShohonSelect || (AFA.ShohonSelect = {}));
    var ShohonSelect = AFA.ShohonSelect;
})(AFA || (AFA = {}));
