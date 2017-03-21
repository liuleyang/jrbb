var AFA;
(function (AFA) {
    (function (YubinShikaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YubinShikaku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        YubinShikaku.ModeController = ModeController;
    })(AFA.YubinShikaku || (AFA.YubinShikaku = {}));
    var YubinShikaku = AFA.YubinShikaku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (YubinShikaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new YubinShikaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("radShikakuKubun_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("chkShikakuJoken_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSearchSimple_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnDirectInput_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnClear_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaiban_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnCancel_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getradShikakuKubun_required = function () {
                return this.controls.radShikakuKubun().required;
            };

            PublicProperties.prototype.setradShikakuKubun_required = function (value) {
                this.controls.radShikakuKubun().required = value;
            };

            PublicProperties.prototype.getchkShikakuJoken_required = function () {
                return this.controls.chkShikakuJoken().required;
            };

            PublicProperties.prototype.setchkShikakuJoken_required = function (value) {
                this.controls.chkShikakuJoken().required = value;
            };

            PublicProperties.prototype.getbtnSearchSimple_displayNone = function () {
                return this.controls.btnSearchSimple().displayNone;
            };

            PublicProperties.prototype.setbtnSearchSimple_displayNone = function (value) {
                this.controls.btnSearchSimple().displayNone = value;
            };

            PublicProperties.prototype.getbtnDirectInput_displayNone = function () {
                return this.controls.btnDirectInput().displayNone;
            };

            PublicProperties.prototype.setbtnDirectInput_displayNone = function (value) {
                this.controls.btnDirectInput().displayNone = value;
            };

            PublicProperties.prototype.getbtnClear_displayNone = function () {
                return this.controls.btnClear().displayNone;
            };

            PublicProperties.prototype.setbtnClear_displayNone = function (value) {
                this.controls.btnClear().displayNone = value;
            };

            PublicProperties.prototype.getbtnSaiban_displayNone = function () {
                return this.controls.btnSaiban().displayNone;
            };

            PublicProperties.prototype.setbtnSaiban_displayNone = function (value) {
                this.controls.btnSaiban().displayNone = value;
            };

            PublicProperties.prototype.getbtnCancel_displayNone = function () {
                return this.controls.btnCancel().displayNone;
            };

            PublicProperties.prototype.setbtnCancel_displayNone = function (value) {
                this.controls.btnCancel().displayNone = value;
            };
            return PublicProperties;
        })();
        YubinShikaku.PublicProperties = PublicProperties;
    })(AFA.YubinShikaku || (AFA.YubinShikaku = {}));
    var YubinShikaku = AFA.YubinShikaku;
})(AFA || (AFA = {}));
