/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module AtenaSealLayout {

        export class Events {

            public static onChange_ddlJusho(): string {
                return "onChange_ddlJusho";
            }

            public static onChange_ddlAtena(): string {
                return "onChange_ddlAtena";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "AtenaSealLayout";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.AtenaSealLayout.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.AtenaSealLayout.Controls.myType() + "_" + fieldName;
            }

            public AtenaSealLayout(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public lblYubinNo(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblYubinNo"));
            }

            public ddlRightUp(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlRightUp"));
            }

            public ddlJusho(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJusho"));
            }

            public txtJusho1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJusho1"));
            }

            public txtJusho2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJusho2"));
            }

            public txtJusho3(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJusho3"));
            }

            public ddlAtena(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlAtena"));
            }

            public txtAtena1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAtena1"));
            }

            public ddlKeisho1(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKeisho1"));
            }

            public txtAtena2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtAtena2"));
            }

            public ddlKeisho2(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKeisho2"));
            }

            public ddlLeftDown(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlLeftDown"));
            }

            public ddlRightDown(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlRightDown"));
            }

        }

     }

}

