var AFA;
(function (AFA) {
    (function (TohyokuCodeSelectRange) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyokuCodeSelectRange.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TohyokuCodeSelectRange.ModeController = ModeController;
    })(AFA.TohyokuCodeSelectRange || (AFA.TohyokuCodeSelectRange = {}));
    var TohyokuCodeSelectRange = AFA.TohyokuCodeSelectRange;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyokuCodeSelectRange) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyokuCodeSelectRange.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyokuCodeFrom_DisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuCodeTo_DisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);

                return editTypes;
            };

            PublicProperties.prototype.gettxtTohyokuCodeFrom_DisplayNone = function () {
                return this.controls.ccdTohyokuCodeFrom().PublicProperties().gettxtTohyokuName_displayNone();
            };

            PublicProperties.prototype.settxtTohyokuCodeFrom_DisplayNone = function (value) {
                this.controls.ccdTohyokuCodeFrom().PublicProperties().settxtTohyokuName_displayNone(value);
            };

            PublicProperties.prototype.gettxtTohyokuCodeTo_DisplayNone = function () {
                return this.controls.ccdTohyokuCodeTo().PublicProperties().gettxtTohyokuName_displayNone();
            };

            PublicProperties.prototype.settxtTohyokuCodeTo_DisplayNone = function (value) {
                this.controls.ccdTohyokuCodeTo().PublicProperties().settxtTohyokuName_displayNone(value);
            };
            return PublicProperties;
        })();
        TohyokuCodeSelectRange.PublicProperties = PublicProperties;
    })(AFA.TohyokuCodeSelectRange || (AFA.TohyokuCodeSelectRange = {}));
    var TohyokuCodeSelectRange = AFA.TohyokuCodeSelectRange;
})(AFA || (AFA = {}));
