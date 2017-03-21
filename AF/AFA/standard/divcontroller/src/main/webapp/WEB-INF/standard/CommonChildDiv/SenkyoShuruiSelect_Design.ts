/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module SenkyoShuruiSelect {

        export class Events {

            public static onChange_ddlSenkyoShurui(): string {
                return "onChange_ddlSenkyoShurui";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SenkyoShuruiSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.SenkyoShuruiSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.SenkyoShuruiSelect.Controls.myType() + "_" + fieldName;
            }

            public SenkyoShuruiSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlSenkyoShurui(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlSenkyoShurui"));
            }

        }

     }

}

