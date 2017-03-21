var AFA;
(function (AFA) {
    (function (KokuminSakuseiChohyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KokuminSakuseiChohyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KokuminSakuseiChohyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KokuminSakuseiChohyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KokuminSakuseiChohyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KokuminSakuseiChohyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KokuminSakuseiChohyoMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoMeiboShohon"));
            };

            Controls.prototype.KokuminSakuseiChohyoTorokushasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoTorokushasuList"));
            };

            Controls.prototype.txtTorokushasuListKijunYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            };

            Controls.prototype.lblTorokushasuList = function () {
                return new UZA.Label(this.convFiledName("lblTorokushasuList"));
            };

            Controls.prototype.chkTorokuListFuzaishabun = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokuListFuzaishabun"));
            };

            Controls.prototype.chkFuzaiTohyoMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaiTohyoMeibo"));
            };

            Controls.prototype.KokuminSakuseiChohyo1goShikakuTsuchi = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo1goShikakuTsuchi"));
            };

            Controls.prototype.ccdPrintNaiyo1goTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyo1goTsuchi"));
            };

            Controls.prototype.chkSeal1goTsuchi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal1goTsuchi"));
            };

            Controls.prototype.chk1goTsuchiIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk1goTsuchiIchiran"));
            };

            Controls.prototype.KokuminSakuseiChohyo2goShikakuChosahyo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo2goShikakuChosahyo"));
            };

            Controls.prototype.ccdPrintNaiyo2goChosahyo = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyo2goChosahyo"));
            };

            Controls.prototype.chkSeal2goChosahyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal2goChosahyo"));
            };

            Controls.prototype.chk2goChosaIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk2goChosaIchiran"));
            };

            Controls.prototype.KokuminSakuseiChohyo2goKohoList = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyo2goKohoList"));
            };

            Controls.prototype.KokuminSakuseiChohyoIdoTorokushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoTorokushaMeibo"));
            };

            Controls.prototype.chkTorokushaMeiboJuran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeiboJuran"));
            };

            Controls.prototype.chkSealTorokushaMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealTorokushaMeibo"));
            };

            Controls.prototype.KokuminSakuseiChohyoIdoMasshoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoMasshoshaMeibo"));
            };

            Controls.prototype.txtMasshoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMasshoYMD"));
            };

            Controls.prototype.lblMasshoshaMeibo = function () {
                return new UZA.Label(this.convFiledName("lblMasshoshaMeibo"));
            };

            Controls.prototype.chkMasshoshaMeiboJuran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoshaMeiboJuran"));
            };

            Controls.prototype.KokuminSakuseiChohyoIdoTeiseishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoIdoTeiseishaMeibo"));
            };

            Controls.prototype.KokuminSakuseiChohyoMasshoTsuchi = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoMasshoTsuchi"));
            };

            Controls.prototype.ccdPrintNaiyoMasshoTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoMasshoTsuchi"));
            };

            Controls.prototype.chkSealMasshoTsuchi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealMasshoTsuchi"));
            };

            Controls.prototype.chkMasshoTsuchiIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoTsuchiIchiran"));
            };

            Controls.prototype.KokuminSakuseiChohyoKokunaiChosahyo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoKokunaiChosahyo"));
            };

            Controls.prototype.ccdPrintNaiyoKokunaiChosa = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoKokunaiChosa"));
            };

            Controls.prototype.chkSealKokunaiChosa = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealKokunaiChosa"));
            };

            Controls.prototype.chkKokunaiChosaIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKokunaiChosaIchiran"));
            };

            Controls.prototype.KokuminSakuseiChohyoKokugaiChosahyo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoKokugaiChosahyo"));
            };

            Controls.prototype.ccdPrintNaiyoKokugaiChosa = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoKokugaiChosa"));
            };

            Controls.prototype.chkSealKokugaiChosa = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealKokugaiChosa"));
            };

            Controls.prototype.chkKokugaiChosaIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKokugaiChosaIchiran"));
            };

            Controls.prototype.KokuminSakuseiChohyoZaigai = function () {
                return new UZA.Panel(this.convFiledName("KokuminSakuseiChohyoZaigai"));
            };

            Controls.prototype.KokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiSenkyoninMeiboShohon"));
            };

            Controls.prototype.KokuminSakuseiChohyoZaigaiShikakushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiShikakushaMeibo"));
            };

            Controls.prototype.KokuminSakuseiChohyoZaigaiTohyoKanrihyo = function () {
                return new UZA.PanelPublish(this.convFiledName("KokuminSakuseiChohyoZaigaiTohyoKanrihyo"));
            };
            return Controls;
        })();
        KokuminSakuseiChohyo.Controls = Controls;
    })(AFA.KokuminSakuseiChohyo || (AFA.KokuminSakuseiChohyo = {}));
    var KokuminSakuseiChohyo = AFA.KokuminSakuseiChohyo;
})(AFA || (AFA = {}));
