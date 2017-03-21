var AFA;
(function (AFA) {
    (function (TohyojoCodeSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtTohyojoCode = function () {
                return "onBlur_txtTohyojoCode";
            };

            Events.onOKClose_btnTohyojoCode = function () {
                return "onOKClose_btnTohyojoCode";
            };

            Events.onBeforeOpenDialog_btnTohyojoCode = function () {
                return "onBeforeOpenDialog_btnTohyojoCode";
            };
            return Events;
        })();
        TohyojoCodeSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyojoCodeSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyojoCodeSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyojoCodeSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyojoCodeSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTohyojoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyojoCode"));
            };

            Controls.prototype.btnTohyojoCode = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTohyojoCode"));
            };

            Controls.prototype.txtTohyojoName = function () {
                return new UZA.TextBox(this.convFiledName("txtTohyojoName"));
            };
            return Controls;
        })();
        TohyojoCodeSelect.Controls = Controls;
    })(AFA.TohyojoCodeSelect || (AFA.TohyojoCodeSelect = {}));
    var TohyojoCodeSelect = AFA.TohyojoCodeSelect;
})(AFA || (AFA = {}));
