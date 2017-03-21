var AFA;
(function (AFA) {
    (function (TohyojoCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyojoCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TohyojoCodeSelect.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TohyojoCodeSelect.ModeController = ModeController;
    })(AFA.TohyojoCodeSelect || (AFA.TohyojoCodeSelect = {}));
    var TohyojoCodeSelect = AFA.TohyojoCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (TohyojoCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TohyojoCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTohyojoCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnTohyojoCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtTohyojoCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtTohyojoCode_labelLAlign", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtTohyojoCode_labelLText = function () {
                return this.controls.txtTohyojoCode().labelLText;
            };

            PublicProperties.prototype.settxtTohyojoCode_labelLText = function (value) {
                this.controls.txtTohyojoCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtTohyojoCode_labelLWidth = function () {
                return this.controls.txtTohyojoCode().labelLWidth;
            };

            PublicProperties.prototype.settxtTohyojoCode_labelLWidth = function (value) {
                this.controls.txtTohyojoCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtTohyojoCode_required = function () {
                return this.controls.txtTohyojoCode().required;
            };

            PublicProperties.prototype.settxtTohyojoCode_required = function (value) {
                this.controls.txtTohyojoCode().required = value;
            };

            PublicProperties.prototype.getbtnTohyojoCode_displayNone = function () {
                return this.controls.btnTohyojoCode().displayNone;
            };

            PublicProperties.prototype.setbtnTohyojoCode_displayNone = function (value) {
                this.controls.btnTohyojoCode().displayNone = value;
            };

            PublicProperties.prototype.gettxtTohyojoName_displayNone = function () {
                return this.controls.txtTohyojoName().displayNone;
            };

            PublicProperties.prototype.settxtTohyojoName_displayNone = function (value) {
                this.controls.txtTohyojoName().displayNone = value;
            };

            PublicProperties.prototype.gettxtTohyojoName_width = function () {
                return this.controls.txtTohyojoName().width;
            };

            PublicProperties.prototype.settxtTohyojoName_width = function (value) {
                this.controls.txtTohyojoName().width = value;
            };

            PublicProperties.prototype.gettxtTohyojoCode_readOnly = function () {
                return this.controls.txtTohyojoCode().readOnly;
            };

            PublicProperties.prototype.settxtTohyojoCode_readOnly = function (value) {
                this.controls.txtTohyojoCode().readOnly = value;
            };

            PublicProperties.prototype.gettxtTohyojoCode_labelLAlign = function () {
                return this.controls.txtTohyojoCode().labelLAlign;
            };

            PublicProperties.prototype.settxtTohyojoCode_labelLAlign = function (value) {
                this.controls.txtTohyojoCode().labelLAlign = value;
            };
            return PublicProperties;
        })();
        TohyojoCodeSelect.PublicProperties = PublicProperties;
    })(AFA.TohyojoCodeSelect || (AFA.TohyojoCodeSelect = {}));
    var TohyojoCodeSelect = AFA.TohyojoCodeSelect;
})(AFA || (AFA = {}));
