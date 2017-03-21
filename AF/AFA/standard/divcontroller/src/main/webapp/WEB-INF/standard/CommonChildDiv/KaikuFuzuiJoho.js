var AFA;
(function (AFA) {
    (function (KaikuFuzuiJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaikuFuzuiJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaikuFuzuiJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaikuFuzuiJoho.ModeController = ModeController;
    })(AFA.KaikuFuzuiJoho || (AFA.KaikuFuzuiJoho = {}));
    var KaikuFuzuiJoho = AFA.KaikuFuzuiJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KaikuFuzuiJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaikuFuzuiJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaikuFuzuiJoho.PublicProperties = PublicProperties;
    })(AFA.KaikuFuzuiJoho || (AFA.KaikuFuzuiJoho = {}));
    var KaikuFuzuiJoho = AFA.KaikuFuzuiJoho;
})(AFA || (AFA = {}));
