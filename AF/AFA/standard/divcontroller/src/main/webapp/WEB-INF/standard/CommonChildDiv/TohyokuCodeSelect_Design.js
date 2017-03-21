var AFA;
(function (AFA) {
    (function (TohyokuCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtTohyokuCode = function () {
                return "onBlur_txtTohyokuCode";
            };

            Events.onOkClose_txtTohyokuCode = function () {
                return "onOkClose_txtTohyokuCode";
            };

            Events.onBeforeOpenDialog_btnTohyokuCode = function () {
                return "onBeforeOpenDialog_btnTohyokuCode";
            };
            return Events;
        })();
        TohyokuCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyokuCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyokuCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyokuCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyokuCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTohyokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyokuCode"));
            };

            Controls.prototype.btnTohyokuCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTohyokuCode"));
            };

            Controls.prototype.txtTohyokuName = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyokuName"));
            };

            Controls.prototype.txtTohyokuCodeDomain = function () {
                return new UZA.TextBoxTohyokuCode(this.convFiledName("txtTohyokuCodeDomain"));
            };
            return Controls;
        })();
        TohyokuCodeSelect.Controls = Controls;
    })(AFA.TohyokuCodeSelect || (AFA.TohyokuCodeSelect = {}));
    var TohyokuCodeSelect = AFA.TohyokuCodeSelect;
})(AFA || (AFA = {}));
