var AFA;
(function (AFA) {
    (function (TohyokuCodeSelectRange) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TohyokuCodeSelectRange.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyokuCodeSelectRange";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyokuCodeSelectRange.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyokuCodeSelectRange.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyokuCodeSelectRange = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdTohyokuCodeFrom = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCodeFrom"));
            };

            Controls.prototype.ccdTohyokuCodeTo = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCodeTo"));
            };
            return Controls;
        })();
        TohyokuCodeSelectRange.Controls = Controls;
    })(AFA.TohyokuCodeSelectRange || (AFA.TohyokuCodeSelectRange = {}));
    var TohyokuCodeSelectRange = AFA.TohyokuCodeSelectRange;
})(AFA || (AFA = {}));
