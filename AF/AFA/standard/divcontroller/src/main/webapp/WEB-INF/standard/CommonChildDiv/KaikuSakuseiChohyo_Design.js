var AFA;
(function (AFA) {
    (function (KaikuSakuseiChohyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaikuSakuseiChohyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaikuSakuseiChohyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KaikuSakuseiChohyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KaikuSakuseiChohyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaikuSakuseiChohyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KaikuSakuseiChohyoMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoMeiboShohon"));
            };

            Controls.prototype.KaikuSakuseiChohyoTorokushasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoTorokushasuList"));
            };

            Controls.prototype.txtTorokushasuListKijunYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTorokushasuListKijunYmd"));
            };

            Controls.prototype.lblTorokusha = function () {
                return new UZA.Label(this.convFiledName("lblTorokusha"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoTorokushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoTorokushaMeibo"));
            };

            Controls.prototype.chkTorokushaMeibo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTorokushaMeibo"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoMasshoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoMasshoshaMeibo"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoShikkenshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoShikkenshaMeibo"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoHyojishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoHyojishaMeibo"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoTeiseishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoTeiseishaMeibo"));
            };

            Controls.prototype.KaikuSakuseiChohyoIdoJukiIdoshaList = function () {
                return new UZA.PanelPublish(this.convFiledName("KaikuSakuseiChohyoIdoJukiIdoshaList"));
            };
            return Controls;
        })();
        KaikuSakuseiChohyo.Controls = Controls;
    })(AFA.KaikuSakuseiChohyo || (AFA.KaikuSakuseiChohyo = {}));
    var KaikuSakuseiChohyo = AFA.KaikuSakuseiChohyo;
})(AFA || (AFA = {}));
