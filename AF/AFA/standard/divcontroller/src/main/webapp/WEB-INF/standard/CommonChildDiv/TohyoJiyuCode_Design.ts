/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module TohyoJiyuCode {

        export class Events {

            public static onChange_txtTohyoJiyuCode(): string {
                return "onChange_txtTohyoJiyuCode";
            }

            public static onBlur_txtTohyoJiyuCode(): string {
                return "onBlur_txtTohyoJiyuCode";
            }

            public static onChange_ddlTohyoJiyu(): string {
                return "onChange_ddlTohyoJiyu";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "TohyoJiyuCode";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.TohyoJiyuCode.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.TohyoJiyuCode.Controls.myType() + "_" + fieldName;
            }

            public TohyoJiyuCode(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public txtTohyoJiyuCode(): UZA.TextBoxCode {
                return new UZA.TextBoxCode(this.convFiledName("txtTohyoJiyuCode"));
            }

            public ddlTohyoJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlTohyoJiyu"));
            }

        }

     }

}

