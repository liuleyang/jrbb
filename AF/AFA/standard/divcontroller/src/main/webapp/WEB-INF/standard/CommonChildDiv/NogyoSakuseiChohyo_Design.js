var AFA;
(function (AFA) {
    (function (NogyoSakuseiChohyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NogyoSakuseiChohyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NogyoSakuseiChohyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.NogyoSakuseiChohyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.NogyoSakuseiChohyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NogyoSakuseiChohyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.NogyoSakuseiChohyoCheckList = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoCheckList"));
            };

            Controls.prototype.NogyoSakuseiChohyoMeiboShohon = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoMeiboShohon"));
            };

            Controls.prototype.NogyoSakuseiChohyoTorokushasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoTorokushasuList"));
            };

            Controls.prototype.NogyoSakuseiChohyoYukenshasuList = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoYukenshasuList"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoTorokushaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoTorokushaMeibo"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoMasshoshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoMasshoshaMeibo"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoShikkenshaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoShikkenshaMeibo"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoHyojishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoHyojishaMeibo"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoTeiseishaMeibo = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoTeiseishaMeibo"));
            };

            Controls.prototype.NogyoSakuseiChohyoIdoJukiIdoshaList = function () {
                return new UZA.PanelPublish(this.convFiledName("NogyoSakuseiChohyoIdoJukiIdoshaList"));
            };
            return Controls;
        })();
        NogyoSakuseiChohyo.Controls = Controls;
    })(AFA.NogyoSakuseiChohyo || (AFA.NogyoSakuseiChohyo = {}));
    var NogyoSakuseiChohyo = AFA.NogyoSakuseiChohyo;
})(AFA || (AFA = {}));
