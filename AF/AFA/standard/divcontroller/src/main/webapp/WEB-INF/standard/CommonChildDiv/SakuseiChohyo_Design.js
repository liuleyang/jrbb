var AFA;
(function (AFA) {
    (function (SakuseiChohyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onOpen_SakuseiChohyoEikyuSenkyoninMeibo = function () {
                return "onOpen_SakuseiChohyoEikyuSenkyoninMeibo";
            };

            Events.onClose_SakuseiChohyoEikyuSenkyoninMeibo = function () {
                return "onClose_SakuseiChohyoEikyuSenkyoninMeibo";
            };

            Events.onChange_RadEikyuMeiboShoriKubun = function () {
                return "onChange_RadEikyuMeiboShoriKubun";
            };

            Events.onOpen_SakuseiChohyoTorokushasuList = function () {
                return "onOpen_SakuseiChohyoTorokushasuList";
            };

            Events.onClose_SakuseiChohyoTorokushasuList = function () {
                return "onClose_SakuseiChohyoTorokushasuList";
            };

            Events.onOpen_SakuseiChohyoNijuTorokuTsuchi = function () {
                return "onOpen_SakuseiChohyoNijuTorokuTsuchi";
            };

            Events.onClose_SakuseiChohyoNijuTorokuTsuchi = function () {
                return "onClose_SakuseiChohyoNijuTorokuTsuchi";
            };

            Events.onOpen_SakuseiChohyoNijuChosahyo = function () {
                return "onOpen_SakuseiChohyoNijuChosahyo";
            };

            Events.onClose_SakuseiChohyoNijuChosahyo = function () {
                return "onClose_SakuseiChohyoNijuChosahyo";
            };

            Events.onOpen_SakuseiChohyoIdoTorokushaMeibo = function () {
                return "onOpen_SakuseiChohyoIdoTorokushaMeibo";
            };

            Events.onClose_SakuseiChohyoIdoTorokushaMeibo = function () {
                return "onClose_SakuseiChohyoIdoTorokushaMeibo";
            };

            Events.onOpen_SakuseiChohyoIdoKikaMeibo = function () {
                return "onOpen_SakuseiChohyoIdoKikaMeibo";
            };

            Events.onClose_SakuseiChohyoIdoKikaMeibo = function () {
                return "onClose_SakuseiChohyoIdoKikaMeibo";
            };

            Events.onOpen_SakuseiChohyoIdoMasshoshaMeibo = function () {
                return "onOpen_SakuseiChohyoIdoMasshoshaMeibo";
            };

            Events.onClose_SakuseiChohyoIdoMasshoshaMeibo = function () {
                return "onClose_SakuseiChohyoIdoMasshoshaMeibo";
            };

            Events.onOpen_SakuseiChohyoIdo19saishaMeibo = function () {
                return "onOpen_SakuseiChohyoIdo19saishaMeibo";
            };

            Events.onClose_SakuseiChohyoIdo19saishaMeibo = function () {
                return "onClose_SakuseiChohyoIdo19saishaMeibo";
            };
            return Events;
        })();
        SakuseiChohyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SakuseiChohyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SakuseiChohyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SakuseiChohyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SakuseiChohyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SakuseiChohyoSenkyoninMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoSenkyoninMeiboShohon"));
            };

            Controls.prototype.ccdTohyokuCodeRange = function () {
                return new AFA.TohyokuCodeSelectRange.ModeController(this.convFiledName("ccdTohyokuCodeRange"));
            };

            Controls.prototype.SakuseiChohyoEikyuSenkyoninMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoEikyuSenkyoninMeibo"));
            };

            Controls.prototype.radEikyuMeiboShoriKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radEikyuMeiboShoriKubun"));
            };

            Controls.prototype.txtEikyuMeiboShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtEikyuMeiboShikibetsuCode"));
            };

            Controls.prototype.txtEikyuMeiboShiteiYmdRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtEikyuMeiboShiteiYmdRange"));
            };

            Controls.prototype.ddlEikyuMeiboIdoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlEikyuMeiboIdoJiyu"));
            };

            Controls.prototype.SakuseiChohyoSenkyoninMeiboSakuinbo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoSenkyoninMeiboSakuinbo"));
            };

            Controls.prototype.SakuseiChohyoTorokushasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoTorokushasuList"));
            };

            Controls.prototype.txtTorokushasuListKijunYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            };

            Controls.prototype.lblTorokushasuListKijunYmd = function () {
                return new UZA.Label(this.convFiledName("lblTorokushasuListKijunYmd"));
            };

            Controls.prototype.chkTorokuListFuzaishabun = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokuListFuzaishabun"));
            };

            Controls.prototype.chkFuzaiTohyoMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaiTohyoMeibo"));
            };

            Controls.prototype.SakuseiChohyoYukenshasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoYukenshasuList"));
            };

            Controls.prototype.SakuseiChohyoNijuTorokuTsuchi = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoNijuTorokuTsuchi"));
            };

            Controls.prototype.ccdPrintNaiyoNijuTsuchi = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoNijuTsuchi"));
            };

            Controls.prototype.txtTennyuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTennyuKikan"));
            };

            Controls.prototype.chkSealNijuTsuchi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealNijuTsuchi"));
            };

            Controls.prototype.chkNijuTsuchiIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNijuTsuchiIchiran"));
            };

            Controls.prototype.SakuseiChohyoNijuChosahyo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoNijuChosahyo"));
            };

            Controls.prototype.ccdPrintNaiyoNijuChosa = function () {
                return new AFA.SakuseiChohyoPrintNaiyo.ModeController(this.convFiledName("ccdPrintNaiyoNijuChosa"));
            };

            Controls.prototype.txtTenshutsuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTenshutsuKikan"));
            };

            Controls.prototype.chkSealNijuChosahyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealNijuChosahyo"));
            };

            Controls.prototype.chkNijuChosahyoIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNijuChosahyoIchiran"));
            };

            Controls.prototype.SakuseiChohyoIdoTorokushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTorokushaMeibo"));
            };

            Controls.prototype.chkTorokushaMeiboJuran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeiboJuran"));
            };

            Controls.prototype.chkSealTorokushaMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSealTorokushaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoKikaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoKikaMeibo"));
            };

            Controls.prototype.txtKikaKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKikaKikan"));
            };

            Controls.prototype.SakuseiChohyoIdoMasshoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMasshoshaMeibo"));
            };

            Controls.prototype.chkMasshoshaMeiboJuran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMasshoshaMeiboJuran"));
            };

            Controls.prototype.SakuseiChohyoIdoGakuseiMasshoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoGakuseiMasshoshaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoMasshoYoteishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMasshoYoteishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoShikkenshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoShikkenshaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoHyojishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoHyojiShojoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojiShojoshaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoHyojiShojoYoteishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoHyojiShojoYoteishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdo19saishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdo19saishaMeibo"));
            };

            Controls.prototype.chkSeal19saishaMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSeal19saishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoMiseinenshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoMiseinenshaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoSaiTennyushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoSaiTennyushaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoTeiseishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTeiseishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoTenshutsushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTenshutsushaMeibo"));
            };

            Controls.prototype.SakuseiChohyoIdoTeishishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoIdoTeishishaMeibo"));
            };

            Controls.prototype.SakuseiChohyoZaigai = function () {
                return new UZA.Panel(this.convFiledName("SakuseiChohyoZaigai"));
            };

            Controls.prototype.SakuseiChohyoZaigaiSenkyoninMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiSenkyoninMeiboShohon"));
            };

            Controls.prototype.SakuseiChohyoZaigaiShikakushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiShikakushaMeibo"));
            };

            Controls.prototype.SakuseiChohyoZaigaiTohyoKanrihyo = function () {
                return new UZA.PanelPublish(this.convFiledName("SakuseiChohyoZaigaiTohyoKanrihyo"));
            };
            return Controls;
        })();
        SakuseiChohyo.Controls = Controls;
    })(AFA.SakuseiChohyo || (AFA.SakuseiChohyo = {}));
    var SakuseiChohyo = AFA.SakuseiChohyo;
})(AFA || (AFA = {}));
