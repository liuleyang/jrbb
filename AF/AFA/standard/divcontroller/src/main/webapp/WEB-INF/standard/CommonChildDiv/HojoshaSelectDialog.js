var AFA;
(function (AFA) {
    (function (HojoshaSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HojoshaSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HojoshaSelectDialog.ModeController = ModeController;
    })(AFA.HojoshaSelectDialog || (AFA.HojoshaSelectDialog = {}));
    var HojoshaSelectDialog = AFA.HojoshaSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (HojoshaSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HojoshaSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HojoshaSelectDialog.PublicProperties = PublicProperties;
    })(AFA.HojoshaSelectDialog || (AFA.HojoshaSelectDialog = {}));
    var HojoshaSelectDialog = AFA.HojoshaSelectDialog;
})(AFA || (AFA = {}));
