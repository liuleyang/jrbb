var AFA;
(function (AFA) {
    (function (ZaigaiSakuseiChohyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ZaigaiSakuseiChohyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ZaigaiSakuseiChohyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ZaigaiSakuseiChohyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ZaigaiSakuseiChohyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ZaigaiSakuseiChohyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHonsekichiShokaiKaitoTsuchi"));
            };

            Controls.prototype.ccdPrintNaiyoHonsekichiShokaiKaitoTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHonsekichiShokaiKaitoTsuchi"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoTorikeshiHonnin = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoTorikeshiHonnin"));
            };

            Controls.prototype.ccdPrintNaiyoTorikeshiHonnin = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorikeshiHonnin"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoTorikeshiRyojikan = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoTorikeshiRyojikan"));
            };

            Controls.prototype.ccdPrintNaiyoTorikeshiRyojikan = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorikeshiRyojikan"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoToroku = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoToroku"));
            };

            Controls.prototype.ccdPrintNaiyoTorokuTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoTorokuTsuchi"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoHenkoHonnin = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHenkoHonnin"));
            };

            Controls.prototype.ccdPrintNaiyoHenkoHonnin = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHenkoHonnin"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoHenkoRyojikan = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoHenkoRyojikan"));
            };

            Controls.prototype.ccdPrintNaiyoHenkoRyojikan = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoHenkoRyojikan"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoSaiKofu = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoSaiKofu"));
            };

            Controls.prototype.ccdPrintNaiyoSaiKofuTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoSaiKofuTsuchi"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoMasshoHonsekichi = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoMasshoHonsekichi"));
            };

            Controls.prototype.ccdPrintNaiyoMasshoHonsekichi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoHonsekichi"));
            };

            Controls.prototype.ZaigaiSakuseiChohyoMasshoRyojikan = function () {
                return new UZA.PanelPublish(this.convFiledName("ZaigaiSakuseiChohyoMasshoRyojikan"));
            };

            Controls.prototype.ccdPrintNaiyoMasshoRyojikan = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoRyojikan"));
            };
            return Controls;
        })();
        ZaigaiSakuseiChohyo.Controls = Controls;
    })(AFA.ZaigaiSakuseiChohyo || (AFA.ZaigaiSakuseiChohyo = {}));
    var ZaigaiSakuseiChohyo = AFA.ZaigaiSakuseiChohyo;
})(AFA || (AFA = {}));
