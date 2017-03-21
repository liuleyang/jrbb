var AFA;
(function (AFA) {
    (function (SearchShikaku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SearchShikaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchShikaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SearchShikaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SearchShikaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchShikaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdTohyokuCode = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            };

            Controls.prototype.chkSearchSenkyoShikaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchSenkyoShikaku"));
            };

            Controls.prototype.chkSearchTohyoShikaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchTohyoShikaku"));
            };

            Controls.prototype.SearchShikakuShosai = function () {
                return new UZA.Panel(this.convFiledName("SearchShikakuShosai"));
            };

            Controls.prototype.txtSearchTorokuYmd = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchTorokuYmd"));
            };

            Controls.prototype.ccdSearchTorokuJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchTorokuJiyu"));
            };

            Controls.prototype.txtSearchTeishiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchTeishiYMD"));
            };

            Controls.prototype.ccdSearchTeishiJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchTeishiJiyu"));
            };

            Controls.prototype.txtSearchMasshoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchMasshoYMD"));
            };

            Controls.prototype.ccdSearchMasshoJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchMasshoJiyu"));
            };

            Controls.prototype.txtSearchHyojiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchHyojiYMD"));
            };

            Controls.prototype.ccdSearchHyojiJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdSearchHyojiJiyu"));
            };

            Controls.prototype.txtSearchShojoYoteiYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchShojoYoteiYMD"));
            };

            Controls.prototype.txtSearchShojoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchShojoYMD"));
            };

            Controls.prototype.txtSearchKeikiShuryoYMD = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchKeikiShuryoYMD"));
            };

            Controls.prototype.chk2keiMochi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk2keiMochi"));
            };
            return Controls;
        })();
        SearchShikaku.Controls = Controls;
    })(AFA.SearchShikaku || (AFA.SearchShikaku = {}));
    var SearchShikaku = AFA.SearchShikaku;
})(AFA || (AFA = {}));
