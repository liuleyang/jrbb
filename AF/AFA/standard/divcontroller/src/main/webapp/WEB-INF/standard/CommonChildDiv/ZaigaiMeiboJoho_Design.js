var AFA;
(function (AFA) {
    (function (ZaigaiMeiboJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ZaigaiMeiboJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ZaigaiMeiboJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ZaigaiMeiboJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ZaigaiMeiboJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZaigaiMeiboJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.radZaigaiShikaku = function () {
                return new UZA.RadioButton(this.convFiledName("radZaigaiShikaku"));
            };

            Controls.prototype.ccdTohyokuCode = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            };

            Controls.prototype.txtTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokuYMD"));
            };

            Controls.prototype.txtHyojiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiYMD"));
            };

            Controls.prototype.ccdHyojiJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdHyojiJiyu"));
            };

            Controls.prototype.lblJusho = function () {
                return new UZA.Label(this.convFiledName("lblJusho"));
            };

            Controls.prototype.ccdKokunaiTennyuJusho = function () {
                return new URZ.ZenkokuJushoInput.ModeController(this.convFiledName("ccdKokunaiTennyuJusho"));
            };

            Controls.prototype.ccdKokunaiTennyuBanchi = function () {
                return new URA.BanchiInput.ModeController(this.convFiledName("ccdKokunaiTennyuBanchi"));
            };

            Controls.prototype.ccdKokunaiTennyuKatagaki = function () {
                return new URA.KatagakiInput.ModeController(this.convFiledName("ccdKokunaiTennyuKatagaki"));
            };

            Controls.prototype.txtKokunaiTennyuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKokunaiTennyuYMD"));
            };

            Controls.prototype.txtMasshoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            };

            Controls.prototype.ccdMasshoJiyu = function () {
                return new AFA.JiyuNameList.ModeController(this.convFiledName("ccdMasshoJiyu"));
            };

            Controls.prototype.txtShuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShuseiYMD"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            };
            return Controls;
        })();
        ZaigaiMeiboJoho.Controls = Controls;
    })(AFA.ZaigaiMeiboJoho || (AFA.ZaigaiMeiboJoho = {}));
    var ZaigaiMeiboJoho = AFA.ZaigaiMeiboJoho;
})(AFA || (AFA = {}));
