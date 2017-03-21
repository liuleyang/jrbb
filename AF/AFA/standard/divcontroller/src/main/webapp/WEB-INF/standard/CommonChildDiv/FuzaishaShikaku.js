var AFA;
(function (AFA) {
    (function (FuzaishaShikaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FuzaishaShikaku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        FuzaishaShikaku.ModeController = ModeController;
    })(AFA.FuzaishaShikaku || (AFA.FuzaishaShikaku = {}));
    var FuzaishaShikaku = AFA.FuzaishaShikaku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (FuzaishaShikaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new FuzaishaShikaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("FuzaishaShikaku_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtManryoYMD_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radShikakuKubun_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("FuzaishaShikaku_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnCancel_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getFuzaishaShikaku_title = function () {
                return this.controls.FuzaishaShikaku().title;
            };

            PublicProperties.prototype.setFuzaishaShikaku_title = function (value) {
                this.controls.FuzaishaShikaku().title = value;
            };

            PublicProperties.prototype.gettxtManryoYMD_labelText = function () {
                return this.controls.txtManryoYMD().labelLText;
            };

            PublicProperties.prototype.settxtManryoYMD_labelText = function (value) {
                this.controls.txtManryoYMD().labelLText = value;
            };

            PublicProperties.prototype.getradShikakuKubun_required = function () {
                return this.controls.radShikakuKubun().required;
            };

            PublicProperties.prototype.setradShikakuKubun_required = function (value) {
                this.controls.radShikakuKubun().required = value;
            };

            PublicProperties.prototype.getFuzaishaShikaku_width = function () {
                return this.controls.FuzaishaShikaku().width;
            };

            PublicProperties.prototype.setFuzaishaShikaku_width = function (value) {
                this.controls.FuzaishaShikaku().width = value;
            };

            PublicProperties.prototype.getbtnCancel_displayNone = function () {
                return this.controls.btnCancel().displayNone;
            };

            PublicProperties.prototype.setbtnCancel_displayNone = function (value) {
                this.controls.btnCancel().displayNone = value;
            };
            return PublicProperties;
        })();
        FuzaishaShikaku.PublicProperties = PublicProperties;
    })(AFA.FuzaishaShikaku || (AFA.FuzaishaShikaku = {}));
    var FuzaishaShikaku = AFA.FuzaishaShikaku;
})(AFA || (AFA = {}));
