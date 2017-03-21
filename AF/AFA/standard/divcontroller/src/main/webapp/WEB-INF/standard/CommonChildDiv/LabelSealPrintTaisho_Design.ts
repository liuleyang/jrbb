/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

module AFA {

     export module LabelSealPrintTaisho {

        export class Events {

            public static onChange_chkLabelSenseisho(): string {
                return "onChange_chkLabelSenseisho";
            }

            public static onChange_chkLabelFuto(): string {
                return "onChange_chkLabelFuto";
            }

            public static onChange_chkLabelShohon(): string {
                return "onChange_chkLabelShohon";
            }

            public static onChange_chkLabelNyujoken(): string {
                return "onChange_chkLabelNyujoken";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "LabelSealPrintTaisho";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + AFA.LabelSealPrintTaisho.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + AFA.LabelSealPrintTaisho.Controls.myType() + "_" + fieldName;
            }

            public LabelSealPrintTaisho(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public chkFuzaishaTohyoShomeisho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzaishaTohyoShomeisho"));
            }

            public chkSenseisho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSenseisho"));
            }

            public lblLabelSeal(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblLabelSeal"));
            }

            public chkLabelSenseisho(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelSenseisho"));
            }

            public txtMaisuSenseisho(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuSenseisho"));
            }

            public chkLabelFuto(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelFuto"));
            }

            public txtMaisuFuto(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuFuto"));
            }

            public chkSenkyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSenkyo"));
            }

            public chkLabelShohon(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelShohon"));
            }

            public txtMaisuShohon(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuShohon"));
            }

            public chkLabelNyujoken(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkLabelNyujoken"));
            }

            public txtMaisuNyujoken(): UZA.TextBoxNum {
                return new UZA.TextBoxNum(this.convFiledName("txtMaisuNyujoken"));
            }

        }

     }

}

