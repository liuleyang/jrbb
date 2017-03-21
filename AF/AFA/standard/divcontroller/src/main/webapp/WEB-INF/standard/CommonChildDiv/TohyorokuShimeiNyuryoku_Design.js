var AFA;
(function (AFA) {
    (function (TohyorokuShimeiNyuryoku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TohyorokuShimeiNyuryoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyorokuShimeiNyuryoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyorokuShimeiNyuryoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyorokuShimeiNyuryoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyorokuShimeiNyuryoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTohyorokuShimeiNyuryoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyorokuShimeiNyuryoku"));
            };
            return Controls;
        })();
        TohyorokuShimeiNyuryoku.Controls = Controls;
    })(AFA.TohyorokuShimeiNyuryoku || (AFA.TohyorokuShimeiNyuryoku = {}));
    var TohyorokuShimeiNyuryoku = AFA.TohyorokuShimeiNyuryoku;
})(AFA || (AFA = {}));
