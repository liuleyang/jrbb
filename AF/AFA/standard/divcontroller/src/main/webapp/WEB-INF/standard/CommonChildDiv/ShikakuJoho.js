var AFA;
(function (AFA) {
    (function (ShikakuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShikakuJoho.ModeController = ModeController;
    })(AFA.ShikakuJoho || (AFA.ShikakuJoho = {}));
    var ShikakuJoho = AFA.ShikakuJoho;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (ShikakuJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtTorokuTeishiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdTorokuTeishiJiyu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtHyojiShojoYoteiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtHyojiShojoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKeikiShuryoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtTorokuTeishiYMD_displayNone = function () {
                return this.controls.txtTorokuTeishiYMD().displayNone;
            };

            PublicProperties.prototype.settxtTorokuTeishiYMD_displayNone = function (value) {
                this.controls.txtTorokuTeishiYMD().displayNone = value;
            };

            PublicProperties.prototype.getccdTorokuTeishiJiyu_displayNone = function () {
                return this.controls.ccdTorokuTeishiJiyu().Properties().displayNone;
            };

            PublicProperties.prototype.setccdTorokuTeishiJiyu_displayNone = function (value) {
                this.controls.ccdTorokuTeishiJiyu().Properties().displayNone = value;
            };

            PublicProperties.prototype.gettxtHyojiShojoYoteiYMD_displayNone = function () {
                return this.controls.txtHyojiShojoYoteiYMD().displayNone;
            };

            PublicProperties.prototype.settxtHyojiShojoYoteiYMD_displayNone = function (value) {
                this.controls.txtHyojiShojoYoteiYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtHyojiShojoYMD_displayNone = function () {
                return this.controls.txtHyojiShojoYMD().displayNone;
            };

            PublicProperties.prototype.settxtHyojiShojoYMD_displayNone = function (value) {
                this.controls.txtHyojiShojoYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtKeikiShuryoYMD_displayNone = function () {
                return this.controls.txtKeikiShuryoYMD().displayNone;
            };

            PublicProperties.prototype.settxtKeikiShuryoYMD_displayNone = function (value) {
                this.controls.txtKeikiShuryoYMD().displayNone = value;
            };
            return PublicProperties;
        })();
        ShikakuJoho.PublicProperties = PublicProperties;
    })(AFA.ShikakuJoho || (AFA.ShikakuJoho = {}));
    var ShikakuJoho = AFA.ShikakuJoho;
})(AFA || (AFA = {}));
