var AFA;
(function (AFA) {
    (function (KaikuFuzuiJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaikuFuzuiJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaikuFuzuiJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KaikuFuzuiJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KaikuFuzuiJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaikuFuzuiJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.txtGyogyoshaBango = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoshaBango"));
            };

            Controls.prototype.ccdGyogyoKumiaiCode = function () {
                return new AFA.KumiaiCodeSelect.ModeController(this.convFiledName("ccdGyogyoKumiaiCode"));
            };

            Controls.prototype.lblGyogyoNissu = function () {
                return new UZA.Label(this.convFiledName("lblGyogyoNissu"));
            };

            Controls.prototype.txtGyogyoshaNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoshaNissu"));
            };

            Controls.prototype.txtGyogyoJujishaNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGyogyoJujishaNissu"));
            };

            Controls.prototype.ccdGyogyoShurui = function () {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdGyogyoShurui"));
            };

            Controls.prototype.ccdGyosenShubetsu = function () {
                return new URZ.CodeInput.ModeController(this.convFiledName("ccdGyosenShubetsu"));
            };

            Controls.prototype.txtSenmei = function () {
                return new UZA.TextBox(this.convFiledName("txtSenmei"));
            };

            Controls.prototype.txtTorokuBango = function () {
                return new UZA.TextBox(this.convFiledName("txtTorokuBango"));
            };
            return Controls;
        })();
        KaikuFuzuiJoho.Controls = Controls;
    })(AFA.KaikuFuzuiJoho || (AFA.KaikuFuzuiJoho = {}));
    var KaikuFuzuiJoho = AFA.KaikuFuzuiJoho;
})(AFA || (AFA = {}));
