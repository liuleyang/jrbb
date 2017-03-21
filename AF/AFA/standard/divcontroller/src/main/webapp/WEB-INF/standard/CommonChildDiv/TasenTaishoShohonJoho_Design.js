var AFA;
(function (AFA) {
    (function (TasenTaishoShohonJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radShori = function () {
                return "onClick_radShori";
            };
            return Events;
        })();
        TasenTaishoShohonJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TasenTaishoShohonJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TasenTaishoShohonJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TasenTaishoShohonJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TasenTaishoShohonJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdSenkyoShurui = function () {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
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

            Controls.prototype.ccdSenkyokuCode = function () {
                return new AFA.SenkyokuCodeSelect.ModeController(this.convFiledName("ccdSenkyokuCode"));
            };
            return Controls;
        })();
        TasenTaishoShohonJoho.Controls = Controls;
    })(AFA.TasenTaishoShohonJoho || (AFA.TasenTaishoShohonJoho = {}));
    var TasenTaishoShohonJoho = AFA.TasenTaishoShohonJoho;
})(AFA || (AFA = {}));
