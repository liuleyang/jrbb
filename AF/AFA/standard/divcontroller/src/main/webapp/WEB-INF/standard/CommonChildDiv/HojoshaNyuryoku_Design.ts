/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module HojoshaNyuryoku {

        export class Events {

            public static onClickChkDairiTohyo(): string {
                return "onClickChkDairiTohyo";
            }

            public static onClickDialog1OK(): string {
                return "onClickDialog1OK";
            }

            public static onClickDialog1(): string {
                return "onClickDialog1";
            }

            public static onClickDialog2OK(): string {
                return "onClickDialog2OK";
            }

            public static onClickDialog2(): string {
                return "onClickDialog2";
            }

            public static cancel(): string {
                return "cancel";
            }

            public static onOK(): string {
                return "onOK";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HojoshaNyuryoku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.HojoshaNyuryoku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.HojoshaNyuryoku.Controls.myType() + "_" + fieldName;
            }

            public HojoshaNyuryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public chkDairiTohyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkDairiTohyo"));
            }

            public txtHojoshaShimei1(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHojoshaShimei1"));
            }

            public btnHojosha1Search(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHojosha1Search"));
            }

            public txtHojosha1ShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtHojosha1ShikibetsuCode"));
            }

            public txtHojoshaShimei2(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtHojoshaShimei2"));
            }

            public btnHojosha2Search(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHojosha2Search"));
            }

            public txtHojosha2ShikibetsuCode(): UZA.TextBoxShikibetsuCode {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtHojosha2ShikibetsuCode"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnOK(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOK"));
            }

        }

     }

}

