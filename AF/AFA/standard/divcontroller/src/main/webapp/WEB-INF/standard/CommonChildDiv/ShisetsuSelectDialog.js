var AFA;
(function (AFA) {
    (function (ShisetsuSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShisetsuSelectDialog.ModeController = ModeController;
    })(AFA.ShisetsuSelectDialog || (AFA.ShisetsuSelectDialog = {}));
    var ShisetsuSelectDialog = AFA.ShisetsuSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShisetsuSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuSelectDialog.PublicProperties = PublicProperties;
    })(AFA.ShisetsuSelectDialog || (AFA.ShisetsuSelectDialog = {}));
    var ShisetsuSelectDialog = AFA.ShisetsuSelectDialog;
})(AFA || (AFA = {}));
