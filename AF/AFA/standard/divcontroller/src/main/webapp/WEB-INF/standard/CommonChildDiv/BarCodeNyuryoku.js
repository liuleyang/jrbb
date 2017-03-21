var AFA;
(function (AFA) {
    (function (BarCodeNyuryoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new BarCodeNyuryoku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        BarCodeNyuryoku.ModeController = ModeController;
    })(AFA.BarCodeNyuryoku || (AFA.BarCodeNyuryoku = {}));
    var BarCodeNyuryoku = AFA.BarCodeNyuryoku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (BarCodeNyuryoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new BarCodeNyuryoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtBarCode_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_labelWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtBarCode_helpMessageID", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtBarCode_labelText = function () {
                return this.controls.txtBarCode().labelLText;
            };

            PublicProperties.prototype.settxtBarCode_labelText = function (value) {
                this.controls.txtBarCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtBarCode_labelWidth = function () {
                return this.controls.txtBarCode().labelLWidth;
            };

            PublicProperties.prototype.settxtBarCode_labelWidth = function (value) {
                this.controls.txtBarCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtBarCode_width = function () {
                return this.controls.txtBarCode().width;
            };

            PublicProperties.prototype.settxtBarCode_width = function (value) {
                this.controls.txtBarCode().width = value;
            };

            PublicProperties.prototype.gettxtBarCode_helpMessageID = function () {
                return this.controls.txtBarCode().helpMessageID;
            };

            PublicProperties.prototype.settxtBarCode_helpMessageID = function (value) {
                this.controls.txtBarCode().helpMessageID = value;
            };
            return PublicProperties;
        })();
        BarCodeNyuryoku.PublicProperties = PublicProperties;
    })(AFA.BarCodeNyuryoku || (AFA.BarCodeNyuryoku = {}));
    var BarCodeNyuryoku = AFA.BarCodeNyuryoku;
})(AFA || (AFA = {}));
