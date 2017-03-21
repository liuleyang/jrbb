var AFA;
(function (AFA) {
    (function (TohyojoSelectDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton_closeOK = function () {
                return "onSelectBySelectButton_closeOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        TohyojoSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyojoSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyojoSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyojoSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyojoSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTohyojoSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyojoSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        TohyojoSelectDialog.Controls = Controls;
    })(AFA.TohyojoSelectDialog || (AFA.TohyojoSelectDialog = {}));
    var TohyojoSelectDialog = AFA.TohyojoSelectDialog;
})(AFA || (AFA = {}));
