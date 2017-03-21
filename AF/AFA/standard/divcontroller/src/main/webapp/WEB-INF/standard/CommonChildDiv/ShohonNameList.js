var AFA;
(function (AFA) {
    (function (ShohonNameList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShohonNameList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new AFA.ShohonNameList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.KakoHyojiCheckBoxSelected = function () {
                return new Modes.KakoHyojiCheckBoxSelected(this.controls);
            };
            return ModeController;
        })();
        ShohonNameList.ModeController = ModeController;

        (function (Modes) {
            var KakoHyojiCheckBoxSelected = (function () {
                function KakoHyojiCheckBoxSelected(controls) {
                    this.controls = controls;
                }
                KakoHyojiCheckBoxSelected.prototype.選択する = function () {
                    this.controls.chkKakoShohon().selectedItem = "key0";
                };

                KakoHyojiCheckBoxSelected.prototype.選択しない = function () {
                    this.controls.chkKakoShohon().selectedItem = "";
                };
                return KakoHyojiCheckBoxSelected;
            })();
            Modes.KakoHyojiCheckBoxSelected = KakoHyojiCheckBoxSelected;
        })(ShohonNameList.Modes || (ShohonNameList.Modes = {}));
        var Modes = ShohonNameList.Modes;
    })(AFA.ShohonNameList || (AFA.ShohonNameList = {}));
    var ShohonNameList = AFA.ShohonNameList;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShohonNameList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShohonNameList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ddlShohon_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlShohon_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlShohon_labelText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlShohon_labelWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlShohon_width", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("chkKakoShohon_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);

                return editTypes;
            };

            PublicProperties.prototype.getddlShohon_disabled = function () {
                return this.controls.ddlShohon().disabled;
            };

            PublicProperties.prototype.setddlShohon_disabled = function (value) {
                this.controls.ddlShohon().disabled = value;
            };

            PublicProperties.prototype.getddlShohon_required = function () {
                return this.controls.ddlShohon().required;
            };

            PublicProperties.prototype.setddlShohon_required = function (value) {
                this.controls.ddlShohon().required = value;
            };

            PublicProperties.prototype.getddlShohon_labelText = function () {
                return this.controls.ddlShohon().labelLText;
            };

            PublicProperties.prototype.setddlShohon_labelText = function (value) {
                this.controls.ddlShohon().labelLText = value;
            };

            PublicProperties.prototype.getddlShohon_labelWidth = function () {
                return this.controls.ddlShohon().labelLWidth;
            };

            PublicProperties.prototype.setddlShohon_labelWidth = function (value) {
                this.controls.ddlShohon().labelLWidth = value;
            };

            PublicProperties.prototype.getddlShohon_width = function () {
                return this.controls.ddlShohon().width;
            };

            PublicProperties.prototype.setddlShohon_width = function (value) {
                this.controls.ddlShohon().width = value;
            };

            PublicProperties.prototype.getchkKakoShohon_displayNone = function () {
                return this.controls.chkKakoShohon().displayNone;
            };

            PublicProperties.prototype.setchkKakoShohon_displayNone = function (value) {
                this.controls.chkKakoShohon().displayNone = value;
            };
            return PublicProperties;
        })();
        ShohonNameList.PublicProperties = PublicProperties;
    })(AFA.ShohonNameList || (AFA.ShohonNameList = {}));
    var ShohonNameList = AFA.ShohonNameList;
})(AFA || (AFA = {}));
