var AFA;
(function (AFA) {
    (function (ShikakuJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_SenkyoShikaku = function () {
                return "onChange_SenkyoShikaku";
            };
            return Events;
        })();
        ShikakuJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShikakuJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShikakuJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdTohyokuCode = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            };

            Controls.prototype.radSenkyoShikaku = function () {
                return new UZA.RadioButton(this.convFiledName("radSenkyoShikaku"));
            };

            Controls.prototype.lblTohyoShikakuShurui = function () {
                return new UZA.Label(this.convFiledName("lblTohyoShikakuShurui"));
            };

            Controls.prototype.btnYubin = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnYubin"));
            };

            Controls.prototype.btnSenin = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSenin"));
            };

            Controls.prototype.btnNankyoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNankyoku"));
            };

            Controls.prototype.txtMeiboTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            };

            Controls.prototype.ccdMeiboTorokuJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMeiboTorokuJiyu"));
            };

            Controls.prototype.txtTorokuTeishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokuTeishiYMD"));
            };

            Controls.prototype.ccdTorokuTeishiJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdTorokuTeishiJiyu"));
            };

            Controls.prototype.txtMasshoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            };

            Controls.prototype.ccdMasshoJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            };

            Controls.prototype.txtHyojiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiYMD"));
            };

            Controls.prototype.ccdHyojiJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHyojiJiyu"));
            };

            Controls.prototype.txtHyojiShojoYoteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiShojoYoteiYMD"));
            };

            Controls.prototype.txtHyojiShojoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiShojoYMD"));
            };

            Controls.prototype.txtKeikiShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikiShuryoYMD"));
            };

            Controls.prototype.chk2keiMochi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk2keiMochi"));
            };
            return Controls;
        })();
        ShikakuJoho.Controls = Controls;
    })(AFA.ShikakuJoho || (AFA.ShikakuJoho = {}));
    var ShikakuJoho = AFA.ShikakuJoho;
})(AFA || (AFA = {}));
