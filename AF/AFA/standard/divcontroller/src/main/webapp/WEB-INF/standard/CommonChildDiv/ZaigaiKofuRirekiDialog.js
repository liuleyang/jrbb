var AFA;
(function (AFA) {
    (function (ZaigaiKofuRirekiDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZaigaiKofuRirekiDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ZaigaiKofuRirekiDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ZaigaiKofuRirekiDialog.ModeController = ModeController;
    })(AFA.ZaigaiKofuRirekiDialog || (AFA.ZaigaiKofuRirekiDialog = {}));
    var ZaigaiKofuRirekiDialog = AFA.ZaigaiKofuRirekiDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ZaigaiKofuRirekiDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZaigaiKofuRirekiDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZaigaiKofuRirekiDialog.PublicProperties = PublicProperties;
    })(AFA.ZaigaiKofuRirekiDialog || (AFA.ZaigaiKofuRirekiDialog = {}));
    var ZaigaiKofuRirekiDialog = AFA.ZaigaiKofuRirekiDialog;
})(AFA || (AFA = {}));
