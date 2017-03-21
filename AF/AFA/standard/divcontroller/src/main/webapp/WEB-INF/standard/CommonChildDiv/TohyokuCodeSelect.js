var AFA;
(function (AFA) {
    (function (TohyokuCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyokuCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            ModeController.prototype.PublicProperties = function () {
                return new AFA.TohyokuCodeSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TohyokuCodeSelect.ModeController = ModeController;
    })(AFA.TohyokuCodeSelect || (AFA.TohyokuCodeSelect = {}));
    var TohyokuCodeSelect = AFA.TohyokuCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyokuCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TohyokuCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyokuCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnTohyokuCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyokuCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyokuCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtTohyokuCode_labelLText = function () {
                return this.controls.txtTohyokuCode().labelLText;
            };

            PublicProperties.prototype.settxtTohyokuCode_labelLText = function (value) {
                this.controls.txtTohyokuCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtTohyokuCode_labelLWidth = function () {
                return this.controls.txtTohyokuCode().labelLWidth;
            };

            PublicProperties.prototype.settxtTohyokuCode_labelLWidth = function (value) {
                this.controls.txtTohyokuCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtTohyokuCode_required = function () {
                return this.controls.txtTohyokuCode().required;
            };

            PublicProperties.prototype.settxtTohyokuCode_required = function (value) {
                this.controls.txtTohyokuCode().required = value;
            };

            PublicProperties.prototype.getbtnTohyokuCode_displayNone = function () {
                return this.controls.btnTohyokuCode().displayNone;
            };

            PublicProperties.prototype.setbtnTohyokuCode_displayNone = function (value) {
                this.controls.btnTohyokuCode().displayNone = value;
            };

            PublicProperties.prototype.gettxtTohyokuName_displayNone = function () {
                return this.controls.txtTohyokuName().displayNone;
            };

            PublicProperties.prototype.settxtTohyokuName_displayNone = function (value) {
                this.controls.txtTohyokuName().displayNone = value;
            };

            PublicProperties.prototype.gettxtTohyokuName_width = function () {
                return this.controls.txtTohyokuName().width;
            };

            PublicProperties.prototype.settxtTohyokuName_width = function (value) {
                this.controls.txtTohyokuName().width = value;
            };

            PublicProperties.prototype.gettxtTohyokuCode_readOnly = function () {
                return this.controls.txtTohyokuCode().readOnly;
            };

            PublicProperties.prototype.settxtTohyokuCode_readOnly = function (value) {
                this.controls.txtTohyokuCode().readOnly = value;
            };

            PublicProperties.prototype.gettxtTohyokuCode_labelLAlign = function () {
                return this.controls.txtTohyokuCode().labelLAlign;
            };

            PublicProperties.prototype.settxtTohyokuCode_labelLAlign = function (value) {
                this.controls.txtTohyokuCode().labelLAlign = value;
            };
            return PublicProperties;
        })();
        TohyokuCodeSelect.PublicProperties = PublicProperties;
    })(AFA.TohyokuCodeSelect || (AFA.TohyokuCodeSelect = {}));
    var TohyokuCodeSelect = AFA.TohyokuCodeSelect;
})(AFA || (AFA = {}));
