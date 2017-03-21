var AFA;
(function (AFA) {
    (function (SakuseiChohyoPrintNaiyo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SakuseiChohyoPrintNaiyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SakuseiChohyoPrintNaiyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SakuseiChohyoPrintNaiyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SakuseiChohyoPrintNaiyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SakuseiChohyoPrintNaiyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHakkoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoYMD"));
            };

            Controls.prototype.ccdHakkoBango = function () {
                return new AFA.HakkoBango.ModeController(this.convFiledName("ccdHakkoBango"));
            };

            Controls.prototype.txtIinchoName = function () {
                return new UZA.TextBox(this.convFiledName("txtIinchoName"));
            };
            return Controls;
        })();
        SakuseiChohyoPrintNaiyo.Controls = Controls;
    })(AFA.SakuseiChohyoPrintNaiyo || (AFA.SakuseiChohyoPrintNaiyo = {}));
    var SakuseiChohyoPrintNaiyo = AFA.SakuseiChohyoPrintNaiyo;
})(AFA || (AFA = {}));
