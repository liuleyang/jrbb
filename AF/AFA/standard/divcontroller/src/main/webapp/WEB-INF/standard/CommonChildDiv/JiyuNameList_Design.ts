/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module JiyuNameList {

        export class Events {

            public static onChange_ddlJiyuName(): string {
                return "onChange_ddlJiyuName";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "JiyuNameList";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.JiyuNameList.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.JiyuNameList.Controls.myType() + "_" + fieldName;
            }

            public JiyuNameList(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlJiyuName(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlJiyuName"));
            }

        }

     }

}

