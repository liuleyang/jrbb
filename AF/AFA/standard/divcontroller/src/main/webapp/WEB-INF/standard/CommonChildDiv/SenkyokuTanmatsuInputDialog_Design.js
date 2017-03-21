var AFA;
(function (AFA) {
    (function (SenkyokuTanmatsuInputDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddTanmatsu = function () {
                return "onClick_btnAddTanmatsu";
            };

            Events.onClick_btnSakujo = function () {
                return "onClick_btnSakujo";
            };

            Events.onClick_btnKoshi = function () {
                return "onClick_btnKoshi";
            };

            Events.onClick_btnTorikeshi = function () {
                return "onClick_btnTorikeshi";
            };
            return Events;
        })();
        SenkyokuTanmatsuInputDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SenkyokuTanmatsuInputDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SenkyokuTanmatsuInputDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SenkyokuTanmatsuInputDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SenkyokuTanmatsuInputDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdSenkyoShurui = function () {
                return new AFA.SenkyoShuruiSelect.ModeController(this.convFiledName("ccdSenkyoShurui"));
            };

            Controls.prototype.ccdSenkyokuCode = function () {
                return new AFA.SenkyokuCodeSelect.ModeController(this.convFiledName("ccdSenkyokuCode"));
            };

            Controls.prototype.btnAddRow = function () {
                return new UZA.Button(this.convFiledName("btnAddRow"));
            };

            Controls.prototype.dgSenkyokuTanmatsuInput = function () {
                return new UZA.DataGrid(this.convFiledName("dgSenkyokuTanmatsuInput"));
            };

            Controls.prototype.btnUpdate = function () {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        SenkyokuTanmatsuInputDialog.Controls = Controls;
    })(AFA.SenkyokuTanmatsuInputDialog || (AFA.SenkyokuTanmatsuInputDialog = {}));
    var SenkyokuTanmatsuInputDialog = AFA.SenkyokuTanmatsuInputDialog;
})(AFA || (AFA = {}));
