var AFA;
(function (AFA) {
    (function (KaikuTaishoShohonJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShori = function () {
                return "onChange_radShori";
            };
            return Events;
        })();
        KaikuTaishoShohonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaikuTaishoShohonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KaikuTaishoShohonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KaikuTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaikuTaishoShohonJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShiyoShohon = function () {
                return new UZA.TextBox(this.convFiledName("txtShiyoShohon"));
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

            Controls.prototype.txtSenkyoName = function () {
                return new UZA.TextBox(this.convFiledName("txtSenkyoName"));
            };

            Controls.prototype.txtKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijunYMD"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.txtTohyoUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoUketsukeYMD"));
            };

            Controls.prototype.chkMutohyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMutohyo"));
            };
            return Controls;
        })();
        KaikuTaishoShohonJoho.Controls = Controls;
    })(AFA.KaikuTaishoShohonJoho || (AFA.KaikuTaishoShohonJoho = {}));
    var KaikuTaishoShohonJoho = AFA.KaikuTaishoShohonJoho;
})(AFA || (AFA = {}));
