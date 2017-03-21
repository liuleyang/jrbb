var AFA;
(function (AFA) {
    (function (TohyorokuDairiTohyosha) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TohyorokuDairiTohyosha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyorokuDairiTohyosha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyorokuDairiTohyosha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyorokuDairiTohyosha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyorokuDairiTohyosha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTohyorokuDairiTohyosha = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyorokuDairiTohyosha"));
            };
            return Controls;
        })();
        TohyorokuDairiTohyosha.Controls = Controls;
    })(AFA.TohyorokuDairiTohyosha || (AFA.TohyorokuDairiTohyosha = {}));
    var TohyorokuDairiTohyosha = AFA.TohyorokuDairiTohyosha;
})(AFA || (AFA = {}));
