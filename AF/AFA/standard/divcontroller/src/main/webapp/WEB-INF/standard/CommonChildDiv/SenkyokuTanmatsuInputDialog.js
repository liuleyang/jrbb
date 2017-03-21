var AFA;
(function (AFA) {
    (function (SenkyokuTanmatsuInputDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SenkyokuTanmatsuInputDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SenkyokuTanmatsuInputDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SenkyokuTanmatsuInputDialog.ModeController = ModeController;
    })(AFA.SenkyokuTanmatsuInputDialog || (AFA.SenkyokuTanmatsuInputDialog = {}));
    var SenkyokuTanmatsuInputDialog = AFA.SenkyokuTanmatsuInputDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SenkyokuTanmatsuInputDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SenkyokuTanmatsuInputDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SenkyokuTanmatsuInputDialog.PublicProperties = PublicProperties;
    })(AFA.SenkyokuTanmatsuInputDialog || (AFA.SenkyokuTanmatsuInputDialog = {}));
    var SenkyokuTanmatsuInputDialog = AFA.SenkyokuTanmatsuInputDialog;
})(AFA || (AFA = {}));
