var AFA;
(function (AFA) {
    (function (TaishoShohonJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnHdnChangeShohon = function () {
                return "onClick_btnHdnChangeShohon";
            };
            return Events;
        })();
        TaishoShohonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TaishoShohonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TaishoShohonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TaishoShohonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TaishoShohonJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.txtShohonName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            };

            Controls.prototype.txtKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.txtMeiboTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            };

            Controls.prototype.txtNenreiTotatsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            };

            Controls.prototype.txtTenshutsuKigenYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTenshutsuKigenYMD"));
            };

            Controls.prototype.txtTennyuKigenYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTennyuKigenYMD"));
            };

            Controls.prototype.btnHdnChangeShohon = function () {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            };
            return Controls;
        })();
        TaishoShohonJoho.Controls = Controls;
    })(AFA.TaishoShohonJoho || (AFA.TaishoShohonJoho = {}));
    var TaishoShohonJoho = AFA.TaishoShohonJoho;
})(AFA || (AFA = {}));
