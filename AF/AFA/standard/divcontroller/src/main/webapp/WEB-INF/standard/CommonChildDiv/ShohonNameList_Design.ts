/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module ShohonNameList {

        export class Events {

            public static onChange_ddlShohon(): string {
                return "onChange_ddlShohon";
            }

            public static onclick_chkKakoShohon(): string {
                return "onclick_chkKakoShohon";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShohonNameList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.ShohonNameList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.ShohonNameList.Controls.myType() + "_" + fieldName;
            }

            public ShohonNameList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlShohon(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShohon"));
            }

            public chkKakoShohon(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKakoShohon"));
            }

        }

     }

}

