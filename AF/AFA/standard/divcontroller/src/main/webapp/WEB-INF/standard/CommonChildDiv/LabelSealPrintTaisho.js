var AFA;
(function (AFA) {
    (function (LabelSealPrintTaisho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new LabelSealPrintTaisho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new LabelSealPrintTaisho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        LabelSealPrintTaisho.ModeController = ModeController;
    })(AFA.LabelSealPrintTaisho || (AFA.LabelSealPrintTaisho = {}));
    var LabelSealPrintTaisho = AFA.LabelSealPrintTaisho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (LabelSealPrintTaisho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new LabelSealPrintTaisho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        LabelSealPrintTaisho.PublicProperties = PublicProperties;
    })(AFA.LabelSealPrintTaisho || (AFA.LabelSealPrintTaisho = {}));
    var LabelSealPrintTaisho = AFA.LabelSealPrintTaisho;
})(AFA || (AFA = {}));
