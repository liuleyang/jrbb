var AFA;
(function (AFA) {
    (function (RyojikanSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RyojikanSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RyojikanSelectDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RyojikanSelectDialog.ModeController = ModeController;
    })(AFA.RyojikanSelectDialog || (AFA.RyojikanSelectDialog = {}));
    var RyojikanSelectDialog = AFA.RyojikanSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (RyojikanSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RyojikanSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RyojikanSelectDialog.PublicProperties = PublicProperties;
    })(AFA.RyojikanSelectDialog || (AFA.RyojikanSelectDialog = {}));
    var RyojikanSelectDialog = AFA.RyojikanSelectDialog;
})(AFA || (AFA = {}));
