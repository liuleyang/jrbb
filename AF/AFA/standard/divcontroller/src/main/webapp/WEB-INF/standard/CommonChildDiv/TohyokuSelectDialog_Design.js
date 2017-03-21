var AFA;
(function (AFA) {
    (function (TohyokuSelectDialog) {
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
        TohyokuSelectDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TohyokuSelectDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.TohyokuSelectDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.TohyokuSelectDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TohyokuSelectDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdSenkyoShurui = function () {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
            };

            Controls.prototype.dgTohyokuSelect = function () {
                return new UZA.DataGrid(this.convFiledName("dgTohyokuSelect"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        TohyokuSelectDialog.Controls = Controls;
    })(AFA.TohyokuSelectDialog || (AFA.TohyokuSelectDialog = {}));
    var TohyokuSelectDialog = AFA.TohyokuSelectDialog;
})(AFA || (AFA = {}));
