var AFA;
(function (AFA) {
    (function (SearchSimpleTojitsuDialog) {
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

            Events.onSelect_dgSearchKekkaList = function () {
                return "onSelect_dgSearchKekkaList";
            };

            Events.onClick_btnReSearch = function () {
                return "onClick_btnReSearch";
            };
            return Events;
        })();
        SearchSimpleTojitsuDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchSimpleTojitsuDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.SearchSimpleTojitsuDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.SearchSimpleTojitsuDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchSimpleTojitsuDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SearchTojitsuJoken = function () {
                return new UZA.Panel(this.convFiledName("SearchTojitsuJoken"));
            };

            Controls.prototype.ccdShohon = function () {
                return new AFA.ShohonNameList.ModeController(this.convFiledName("ccdShohon"));
            };

            Controls.prototype.lin3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin3"));
            };

            Controls.prototype.txtMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtMeisho"));
            };

            Controls.prototype.ddlMeishoKensaku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlMeishoKensaku"));
            };

            Controls.prototype.txtSeinengappi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSeinengappi"));
            };

            Controls.prototype.txtSeibetsu = function () {
                return new UZA.DropDownList(this.convFiledName("txtSeibetsu"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.ccdTohyokuCode = function () {
                return new AFA.TohyokuCodeSelect.ModeController(this.convFiledName("ccdTohyokuCode"));
            };

            Controls.prototype.ccdMeiboBango = function () {
                return new AFA.MeiboBango.ModeController(this.convFiledName("ccdMeiboBango"));
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

            Controls.prototype.ccdSearchTojitsuSaikinShoriTaisho = function () {
                return new URZ.SaikinShorishaRireki.ModeController(this.convFiledName("ccdSearchTojitsuSaikinShoriTaisho"));
            };

            Controls.prototype.SearchTojitsuKekkaList = function () {
                return new UZA.Panel(this.convFiledName("SearchTojitsuKekkaList"));
            };

            Controls.prototype.dgSearchTojitsuKekkaList = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchTojitsuKekkaList"));
            };

            Controls.prototype.btnCancel2 = function () {
                return new UZA.Button(this.convFiledName("btnCancel2"));
            };

            Controls.prototype.btnReSearch = function () {
                return new UZA.Button(this.convFiledName("btnReSearch"));
            };
            return Controls;
        })();
        SearchSimpleTojitsuDialog.Controls = Controls;
    })(AFA.SearchSimpleTojitsuDialog || (AFA.SearchSimpleTojitsuDialog = {}));
    var SearchSimpleTojitsuDialog = AFA.SearchSimpleTojitsuDialog;
})(AFA || (AFA = {}));
