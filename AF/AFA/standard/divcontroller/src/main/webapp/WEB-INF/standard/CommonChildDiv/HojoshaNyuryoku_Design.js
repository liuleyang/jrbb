var AFA;
(function (AFA) {
    (function (HojoshaNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            Events.onClickChkDairiTohyo = function () {
                return "onClickChkDairiTohyo";
            };

            Events.onClickDialog1OK = function () {
                return "onClickDialog1OK";
            };

            Events.onClickDialog1 = function () {
                return "onClickDialog1";
            };

            Events.onClickDialog2OK = function () {
                return "onClickDialog2OK";
            };

            Events.onClickDialog2 = function () {
                return "onClickDialog2";
            };

            Events.cancel = function () {
                return "cancel";
            };

            Events.onOK = function () {
                return "onOK";
            };
            return Events;
        })();
        HojoshaNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HojoshaNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.HojoshaNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.HojoshaNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HojoshaNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.chkDairiTohyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkDairiTohyo"));
            };

            Controls.prototype.txtHojoshaShimei1 = function () {
                return new UZA.TextBox(this.convFiledName("txtHojoshaShimei1"));
            };

            Controls.prototype.btnHojosha1Search = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHojosha1Search"));
            };

            Controls.prototype.txtHojosha1ShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtHojosha1ShikibetsuCode"));
            };

            Controls.prototype.txtHojoshaShimei2 = function () {
                return new UZA.TextBox(this.convFiledName("txtHojoshaShimei2"));
            };

            Controls.prototype.btnHojosha2Search = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHojosha2Search"));
            };

            Controls.prototype.txtHojosha2ShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtHojosha2ShikibetsuCode"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnOK = function () {
                return new UZA.Button(this.convFiledName("btnOK"));
            };
            return Controls;
        })();
        HojoshaNyuryoku.Controls = Controls;
    })(AFA.HojoshaNyuryoku || (AFA.HojoshaNyuryoku = {}));
    var HojoshaNyuryoku = AFA.HojoshaNyuryoku;
})(AFA || (AFA = {}));
