var AFA;
(function (AFA) {
    (function (KokuminShohonSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgIdoSearchKekkaList = function () {
                return "onSelect_dgIdoSearchKekkaList";
            };
            return Events;
        })();
        KokuminShohonSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KokuminShohonSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.KokuminShohonSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.KokuminShohonSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KokuminShohonSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKokuminShohon = function () {
                return new UZA.DataGrid(this.convFiledName("dgKokuminShohon"));
            };
            return Controls;
        })();
        KokuminShohonSelect.Controls = Controls;
    })(AFA.KokuminShohonSelect || (AFA.KokuminShohonSelect = {}));
    var KokuminShohonSelect = AFA.KokuminShohonSelect;
})(AFA || (AFA = {}));
