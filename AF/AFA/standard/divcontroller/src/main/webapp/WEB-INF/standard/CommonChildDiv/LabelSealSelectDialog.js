var AFA;
(function (AFA) {
    (function (LabelSealSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new LabelSealSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new LabelSealSelectDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        LabelSealSelectDialog.ModeController = ModeController;
    })(AFA.LabelSealSelectDialog || (AFA.LabelSealSelectDialog = {}));
    var LabelSealSelectDialog = AFA.LabelSealSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (LabelSealSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new LabelSealSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        LabelSealSelectDialog.PublicProperties = PublicProperties;
    })(AFA.LabelSealSelectDialog || (AFA.LabelSealSelectDialog = {}));
    var LabelSealSelectDialog = AFA.LabelSealSelectDialog;
})(AFA || (AFA = {}));
