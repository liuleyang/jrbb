var AFA;
(function (AFA) {
    (function (SakuseiChohyoPrintNaiyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SakuseiChohyoPrintNaiyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SakuseiChohyoPrintNaiyo.ModeController = ModeController;
    })(AFA.SakuseiChohyoPrintNaiyo || (AFA.SakuseiChohyoPrintNaiyo = {}));
    var SakuseiChohyoPrintNaiyo = AFA.SakuseiChohyoPrintNaiyo;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SakuseiChohyoPrintNaiyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SakuseiChohyoPrintNaiyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtIinchoName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtIinchoName_displayNone = function () {
                return this.controls.txtIinchoName().displayNone;
            };

            PublicProperties.prototype.settxtIinchoName_displayNone = function (value) {
                this.controls.txtIinchoName().displayNone = value;
            };
            return PublicProperties;
        })();
        SakuseiChohyoPrintNaiyo.PublicProperties = PublicProperties;
    })(AFA.SakuseiChohyoPrintNaiyo || (AFA.SakuseiChohyoPrintNaiyo = {}));
    var SakuseiChohyoPrintNaiyo = AFA.SakuseiChohyoPrintNaiyo;
})(AFA || (AFA = {}));
