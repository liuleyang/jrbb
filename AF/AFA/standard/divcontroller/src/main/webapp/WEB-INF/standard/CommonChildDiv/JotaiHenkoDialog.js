var AFA;
(function (AFA) {
    (function (JotaiHenkoDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JotaiHenkoDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JotaiHenkoDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JotaiHenkoDialog.ModeController = ModeController;
    })(AFA.JotaiHenkoDialog || (AFA.JotaiHenkoDialog = {}));
    var JotaiHenkoDialog = AFA.JotaiHenkoDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (JotaiHenkoDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JotaiHenkoDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JotaiHenkoDialog.PublicProperties = PublicProperties;
    })(AFA.JotaiHenkoDialog || (AFA.JotaiHenkoDialog = {}));
    var JotaiHenkoDialog = AFA.JotaiHenkoDialog;
})(AFA || (AFA = {}));
