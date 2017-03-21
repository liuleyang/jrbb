var AFA;
(function (AFA) {
    (function (TohyorokuKyohiNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TohyorokuKyohiNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyorokuKyohiNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyorokuKyohiNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyorokuKyohiNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyorokuKyohiNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTohyorokuKyohiNyuryoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyorokuKyohiNyuryoku"));
            };
            return Controls;
        })();
        TohyorokuKyohiNyuryoku.Controls = Controls;
    })(AFA.TohyorokuKyohiNyuryoku || (AFA.TohyorokuKyohiNyuryoku = {}));
    var TohyorokuKyohiNyuryoku = AFA.TohyorokuKyohiNyuryoku;
})(AFA || (AFA = {}));
