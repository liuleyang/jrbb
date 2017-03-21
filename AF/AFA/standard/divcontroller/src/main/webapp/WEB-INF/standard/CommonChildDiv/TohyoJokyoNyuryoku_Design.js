var AFA;
(function (AFA) {
    (function (TohyoJokyoNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radTohyoJokyo = function () {
                return "onClick_radTohyoJokyo";
            };
            return Events;
        })();
        TohyoJokyoNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyoJokyoNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyoJokyoNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyoJokyoNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyoJokyoNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TohyoJokyoSelect = function () {
                return new UZA.Panel(this.convFiledName("TohyoJokyoSelect"));
            };

            Controls.prototype.radTohyoJokyo = function () {
                return new UZA.RadioButton(this.convFiledName("radTohyoJokyo"));
            };

            Controls.prototype.dgTohyoJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyoJokyo"));
            };

            Controls.prototype.radSeikyusha = function () {
                return new UZA.RadioButton(this.convFiledName("radSeikyusha"));
            };

            Controls.prototype.txtTohyoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTohyoYMD"));
            };

            Controls.prototype.txtTohyoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtTohyoTime"));
            };

            Controls.prototype.ccdTohyoJiyu = function () {
                return new AFA.TohyoJiyuCode.ModeController(this.convFiledName("ccdTohyoJiyu"));
            };

            Controls.prototype.chkTenjiYoshi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTenjiYoshi"));
            };

            Controls.prototype.ccdKofuShisetsu = function () {
                return new AFA.ShisetsuCodeSelect.ModeController(this.convFiledName("ccdKofuShisetsu"));
            };

            Controls.prototype.ccdDairiTohyo = function () {
                return new AFA.HojoshaNyuryoku.ModeController(this.convFiledName("ccdDairiTohyo"));
            };

            Controls.prototype.ccdKyohiJiyuNyuryoku = function () {
                return new AFA.KyohiJiyuNyuryoku.ModeController(this.convFiledName("ccdKyohiJiyuNyuryoku"));
            };

            Controls.prototype.chkKariTohyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKariTohyo"));
            };
            return Controls;
        })();
        TohyoJokyoNyuryoku.Controls = Controls;
    })(AFA.TohyoJokyoNyuryoku || (AFA.TohyoJokyoNyuryoku = {}));
    var TohyoJokyoNyuryoku = AFA.TohyoJokyoNyuryoku;
})(AFA || (AFA = {}));
