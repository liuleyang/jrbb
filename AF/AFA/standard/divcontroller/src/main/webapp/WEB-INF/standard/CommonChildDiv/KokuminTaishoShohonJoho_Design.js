var AFA;
(function (AFA) {
    (function (KokuminTaishoShohonJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radShori = function () {
                return "onClick_radShori";
            };

            Events.onBlur_txtTohyoYMD = function () {
                return "onBlur_txtTohyoYMD";
            };

            Events.onClick_btnSetYmd = function () {
                return "onClick_btnSetYmd";
            };

            Events.onClick_btnSetChohyoYmd = function () {
                return "onClick_btnSetChohyoYmd";
            };

            Events.onClick_btnHdnChangeShohon = function () {
                return "onClick_btnHdnChangeShohon";
            };
            return Events;
        })();
        KokuminTaishoShohonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KokuminTaishoShohonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KokuminTaishoShohonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KokuminTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KokuminTaishoShohonJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShori = function () {
                return new UZA.RadioButton(this.convFiledName("radShori"));
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.txtShohonName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohonName"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.btnSetYmd = function () {
                return new UZA.Button(this.convFiledName("btnSetYmd"));
            };

            Controls.prototype.txtKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            };

            Controls.prototype.txtMeiboTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMeiboTorokuYMD"));
            };

            Controls.prototype.txtNenreiTotatsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiTotatsuYMD"));
            };

            Controls.prototype.txtTokuteiKigenYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTokuteiKigenYMD"));
            };

            Controls.prototype.txtTohyoUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoUketsukeYMD"));
            };

            Controls.prototype.btnSetChohyoYmd = function () {
                return new UZA.Button(this.convFiledName("btnSetChohyoYmd"));
            };

            Controls.prototype.btnHdnChangeShohon = function () {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            };
            return Controls;
        })();
        KokuminTaishoShohonJoho.Controls = Controls;
    })(AFA.KokuminTaishoShohonJoho || (AFA.KokuminTaishoShohonJoho = {}));
    var KokuminTaishoShohonJoho = AFA.KokuminTaishoShohonJoho;
})(AFA || (AFA = {}));
