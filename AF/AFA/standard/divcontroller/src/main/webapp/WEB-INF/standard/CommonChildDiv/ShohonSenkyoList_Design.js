var AFA;
(function (AFA) {
    (function (ShohonSenkyoList) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_checkbox = function () {
                return "onChange_checkbox";
            };

            Events.onClick_btnHdnChangeShohon = function () {
                return "onClick_btnHdnChangeShohon";
            };
            return Events;
        })();
        ShohonSenkyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShohonSenkyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.ShohonSenkyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.ShohonSenkyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShohonSenkyoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.chkMutohyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMutohyo"));
            };

            Controls.prototype.btnHdnChangeShohon = function () {
                return new UZA.Button(this.convFiledName("btnHdnChangeShohon"));
            };

            Controls.prototype.dgSenkyoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgSenkyoList"));
            };
            return Controls;
        })();
        ShohonSenkyoList.Controls = Controls;
    })(AFA.ShohonSenkyoList || (AFA.ShohonSenkyoList = {}));
    var ShohonSenkyoList = AFA.ShohonSenkyoList;
})(AFA || (AFA = {}));
