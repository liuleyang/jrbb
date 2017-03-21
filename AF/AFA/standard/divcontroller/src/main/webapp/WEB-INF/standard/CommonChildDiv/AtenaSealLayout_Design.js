var AFA;
(function (AFA) {
    (function (AtenaSealLayout) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlJusho = function () {
                return "onChange_ddlJusho";
            };

            Events.onChange_ddlAtena = function () {
                return "onChange_ddlAtena";
            };
            return Events;
        })();
        AtenaSealLayout.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "AtenaSealLayout";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + AFA.AtenaSealLayout.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + AFA.AtenaSealLayout.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.AtenaSealLayout = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblYubinNo = function () {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
            };

            Controls.prototype.ddlRightUp = function () {
                return new UZA.DropDownList(this.convFiledName("ddlRightUp"));
            };

            Controls.prototype.ddlJusho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJusho"));
            };

            Controls.prototype.txtJusho1 = function () {
                return new UZA.TextBox(this.convFiledName("txtJusho1"));
            };

            Controls.prototype.txtJusho2 = function () {
                return new UZA.TextBox(this.convFiledName("txtJusho2"));
            };

            Controls.prototype.txtJusho3 = function () {
                return new UZA.TextBox(this.convFiledName("txtJusho3"));
            };

            Controls.prototype.ddlAtena = function () {
                return new UZA.DropDownList(this.convFiledName("ddlAtena"));
            };

            Controls.prototype.txtAtena1 = function () {
                return new UZA.TextBox(this.convFiledName("txtAtena1"));
            };

            Controls.prototype.ddlKeisho1 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKeisho1"));
            };

            Controls.prototype.txtAtena2 = function () {
                return new UZA.TextBox(this.convFiledName("txtAtena2"));
            };

            Controls.prototype.ddlKeisho2 = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKeisho2"));
            };

            Controls.prototype.ddlLeftDown = function () {
                return new UZA.DropDownList(this.convFiledName("ddlLeftDown"));
            };

            Controls.prototype.ddlRightDown = function () {
                return new UZA.DropDownList(this.convFiledName("ddlRightDown"));
            };
            return Controls;
        })();
        AtenaSealLayout.Controls = Controls;
    })(AFA.AtenaSealLayout || (AFA.AtenaSealLayout = {}));
    var AtenaSealLayout = AFA.AtenaSealLayout;
})(AFA || (AFA = {}));
