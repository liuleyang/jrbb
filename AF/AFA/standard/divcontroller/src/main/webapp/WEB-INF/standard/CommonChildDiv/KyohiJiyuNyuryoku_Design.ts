/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module KyohiJiyuNyuryoku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KyohiJiyuNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.KyohiJiyuNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.KyohiJiyuNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public KyohiJiyuNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ddlKyohiJiyu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyohiJiyu"));
            }

            public txtKyohiJiyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKyohiJiyu"));
            }

        }

     }

}

