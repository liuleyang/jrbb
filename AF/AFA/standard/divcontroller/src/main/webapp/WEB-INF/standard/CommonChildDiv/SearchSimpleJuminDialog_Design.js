var AFA;
(function (AFA) {
    (function (SearchSimpleJuminDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseCancel = function () {
                return "CloseCancel";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_btnSearch = function () {
                return "onClick_btnSearch";
            };

            Events.onSelectByDbClick_dgSearchKekkaList = function () {
                return "onSelectByDbClick_dgSearchKekkaList";
            };

            Events.onSelect_dgSearchKekkaList = function () {
                return "onSelect_dgSearchKekkaList";
            };

            Events.closeOK = function () {
                return "closeOK";
            };

            Events.onClick_btnReSearch = function () {
                return "onClick_btnReSearch";
            };
            return Events;
        })();
        SearchSimpleJuminDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchSimpleJuminDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SearchSimpleJuminDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SearchSimpleJuminDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchSimpleJuminDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SearchSimpleJoken = function () {
                return new UZA.Panel(this.convFiledName("SearchSimpleJoken"));
            };

            Controls.prototype.ccdShohonNameList = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohonNameList"));
            };

            Controls.prototype.ccdSearchSimpleJukiJoho = function () {
                return new UAX.AtenaFinder.ModeController(this.convFiledName("ccdSearchSimpleJukiJoho"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.ccdTohyokuCode = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            };

            Controls.prototype.chkSearchSenkyoShikaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchSenkyoShikaku"));
            };

            Controls.prototype.chkSearchTohyoShikaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSearchTohyoShikaku"));
            };

            Controls.prototype.lin2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin2"));
            };

            Controls.prototype.txtMaxDisplayCount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxDisplayCount"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnSearch = function () {
                return new UZA.Button(this.convFiledName("btnSearch"));
            };

            Controls.prototype.ccdSearchSimpleSaikinShoriTaisho = function () {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("ccdSearchSimpleSaikinShoriTaisho"));
            };

            Controls.prototype.SearchSimpleKekkaList = function () {
                return new UZA.Panel(this.convFiledName("SearchSimpleKekkaList"));
            };

            Controls.prototype.dgSearchSimpleKekkaList = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchSimpleKekkaList"));
            };

            Controls.prototype.btnSelect = function () {
                return new UZA.Button(this.convFiledName("btnSelect"));
            };

            Controls.prototype.btnReSearch = function () {
                return new UZA.Button(this.convFiledName("btnReSearch"));
            };

            Controls.prototype.btnCancel2 = function () {
                return new UZA.Button(this.convFiledName("btnCancel2"));
            };
            return Controls;
        })();
        SearchSimpleJuminDialog.Controls = Controls;
    })(AFA.SearchSimpleJuminDialog || (AFA.SearchSimpleJuminDialog = {}));
    var SearchSimpleJuminDialog = AFA.SearchSimpleJuminDialog;
})(AFA || (AFA = {}));
