var AFA;
(function (AFA) {
    (function (KumiaiCodeSelect) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KumiaiCodeSelect.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KumiaiCodeSelect.ModeController = ModeController;
    })(AFA.KumiaiCodeSelect || (AFA.KumiaiCodeSelect = {}));
    var KumiaiCodeSelect = AFA.KumiaiCodeSelect;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (KumiaiCodeSelect) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KumiaiCodeSelect.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtKumiaiCode_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnKumiaiCode_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKumiaiName_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKumiaiName_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKumiaiCode_readOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtKumiaiCode_labelLText = function () {
                return this.controls.txtKumiaiCode().labelLText;
            };

            PublicProperties.prototype.settxtKumiaiCode_labelLText = function (value) {
                this.controls.txtKumiaiCode().labelLText = value;
            };

            PublicProperties.prototype.gettxtKumiaiCode_labelLWidth = function () {
                return this.controls.txtKumiaiCode().labelLWidth;
            };

            PublicProperties.prototype.settxtKumiaiCode_labelLWidth = function (value) {
                this.controls.txtKumiaiCode().labelLWidth = value;
            };

            PublicProperties.prototype.gettxtKumiaiCode_required = function () {
                return this.controls.txtKumiaiCode().required;
            };

            PublicProperties.prototype.settxtKumiaiCode_required = function (value) {
                this.controls.txtKumiaiCode().required = value;
            };

            PublicProperties.prototype.getbtnKumiaiCode_displayNone = function () {
                return this.controls.btnKumiaiCode().displayNone;
            };

            PublicProperties.prototype.setbtnKumiaiCode_displayNone = function (value) {
                this.controls.btnKumiaiCode().displayNone = value;
            };

            PublicProperties.prototype.gettxtKumiaiName_displayNone = function () {
                return this.controls.txtKumiaiName().displayNone;
            };

            PublicProperties.prototype.settxtKumiaiName_displayNone = function (value) {
                this.controls.txtKumiaiName().displayNone = value;
            };

            PublicProperties.prototype.gettxtKumiaiName_width = function () {
                return this.controls.txtKumiaiName().width;
            };

            PublicProperties.prototype.settxtKumiaiName_width = function (value) {
                this.controls.txtKumiaiName().width = value;
            };

            PublicProperties.prototype.gettxtKumiaiCode_readOnly = function () {
                return this.controls.txtKumiaiCode().readOnly;
            };

            PublicProperties.prototype.settxtKumiaiCode_readOnly = function (value) {
                this.controls.txtKumiaiCode().readOnly = value;
            };
            return PublicProperties;
        })();
        KumiaiCodeSelect.PublicProperties = PublicProperties;
    })(AFA.KumiaiCodeSelect || (AFA.KumiaiCodeSelect = {}));
    var KumiaiCodeSelect = AFA.KumiaiCodeSelect;
})(AFA || (AFA = {}));
