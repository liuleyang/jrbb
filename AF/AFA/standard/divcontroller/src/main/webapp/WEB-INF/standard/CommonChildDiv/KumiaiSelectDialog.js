var AFA;
(function (AFA) {
    (function (KumiaiSelectDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KumiaiSelectDialog.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KumiaiSelectDialog.ModeController = ModeController;
    })(AFA.KumiaiSelectDialog || (AFA.KumiaiSelectDialog = {}));
    var KumiaiSelectDialog = AFA.KumiaiSelectDialog;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KumiaiSelectDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KumiaiSelectDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KumiaiSelectDialog.PublicProperties = PublicProperties;
    })(AFA.KumiaiSelectDialog || (AFA.KumiaiSelectDialog = {}));
    var KumiaiSelectDialog = AFA.KumiaiSelectDialog;
})(AFA || (AFA = {}));
