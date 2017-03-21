var AFA;
(function (AFA) {
    (function (AtenaSealLayout) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new AtenaSealLayout.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new AtenaSealLayout.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        AtenaSealLayout.ModeController = ModeController;
    })(AFA.AtenaSealLayout || (AFA.AtenaSealLayout = {}));
    var AtenaSealLayout = AFA.AtenaSealLayout;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (AtenaSealLayout) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new AtenaSealLayout.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        AtenaSealLayout.PublicProperties = PublicProperties;
    })(AFA.AtenaSealLayout || (AFA.AtenaSealLayout = {}));
    var AtenaSealLayout = AFA.AtenaSealLayout;
})(AFA || (AFA = {}));
