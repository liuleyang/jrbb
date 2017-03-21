var AFA;
(function (AFA) {
    (function (SearchShikaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchShikaku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SearchShikaku.ModeController = ModeController;
    })(AFA.SearchShikaku || (AFA.SearchShikaku = {}));
    var SearchShikaku = AFA.SearchShikaku;
})(AFA || (AFA = {}));

var AFA;
(function (AFA) {
    (function (SearchShikaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SearchShikaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSearchTeishiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ccdSearchTeishiJiyu_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchShojoYoteiYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchShojoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSearchKeikiShuryoYMD_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikakuShosai_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("chkSearchTohyoShikaku_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikaku_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("SearchShikaku_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("SearchShikaku_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtSearchTeishiYMD_displayNone = function () {
                return this.controls.txtSearchTeishiYMD().displayNone;
            };

            PublicProperties.prototype.settxtSearchTeishiYMD_displayNone = function (value) {
                this.controls.txtSearchTeishiYMD().displayNone = value;
            };

            PublicProperties.prototype.getccdSearchTeishiJiyu_displayNone = function () {
                return this.controls.ccdSearchTeishiJiyu().Properties().displayNone;
            };

            PublicProperties.prototype.setccdSearchTeishiJiyu_displayNone = function (value) {
                this.controls.ccdSearchTeishiJiyu().Properties().displayNone = value;
            };

            PublicProperties.prototype.gettxtSearchShojoYoteiYMD_displayNone = function () {
                return this.controls.txtSearchShojoYoteiYMD().displayNone;
            };

            PublicProperties.prototype.settxtSearchShojoYoteiYMD_displayNone = function (value) {
                this.controls.txtSearchShojoYoteiYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtSearchShojoYMD_displayNone = function () {
                return this.controls.txtSearchShojoYMD().displayNone;
            };

            PublicProperties.prototype.settxtSearchShojoYMD_displayNone = function (value) {
                this.controls.txtSearchShojoYMD().displayNone = value;
            };

            PublicProperties.prototype.gettxtSearchKeikiShuryoYMD_displayNone = function () {
                return this.controls.txtSearchKeikiShuryoYMD().displayNone;
            };

            PublicProperties.prototype.settxtSearchKeikiShuryoYMD_displayNone = function (value) {
                this.controls.txtSearchKeikiShuryoYMD().displayNone = value;
            };

            PublicProperties.prototype.getSearchShikakuShosai_displayNone = function () {
                return this.controls.SearchShikakuShosai().displayNone;
            };

            PublicProperties.prototype.setSearchShikakuShosai_displayNone = function (value) {
                this.controls.SearchShikakuShosai().displayNone = value;
            };

            PublicProperties.prototype.getchkSearchTohyoShikaku_displayNone = function () {
                return this.controls.chkSearchTohyoShikaku().displayNone;
            };

            PublicProperties.prototype.setchkSearchTohyoShikaku_displayNone = function (value) {
                this.controls.chkSearchTohyoShikaku().displayNone = value;
            };

            PublicProperties.prototype.getSearchShikaku_title = function () {
                return this.controls.SearchShikaku().title;
            };

            PublicProperties.prototype.setSearchShikaku_title = function (value) {
                this.controls.SearchShikaku().title = value;
            };

            PublicProperties.prototype.getSearchShikaku_eraseBorder = function () {
                return this.controls.SearchShikaku().eraseBorder;
            };

            PublicProperties.prototype.setSearchShikaku_eraseBorder = function (value) {
                this.controls.SearchShikaku().eraseBorder = value;
            };

            PublicProperties.prototype.getSearchShikaku_width = function () {
                return this.controls.SearchShikaku().width;
            };

            PublicProperties.prototype.setSearchShikaku_width = function (value) {
                this.controls.SearchShikaku().width = value;
            };
            return PublicProperties;
        })();
        SearchShikaku.PublicProperties = PublicProperties;
    })(AFA.SearchShikaku || (AFA.SearchShikaku = {}));
    var SearchShikaku = AFA.SearchShikaku;
})(AFA || (AFA = {}));
