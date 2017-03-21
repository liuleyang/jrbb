/// <reference path='ShisetsuCodeSelectRange_Design.ts' />
module AFA
{
    export module ShisetsuCodeSelectRange
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
                this.registerEvents();
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }
            private registerEvents(): void {
                var fromText = <Uz._TextBox>Uz.JSControlUtil.getJSControl("ccdShisetsuCodeFrom_txtShisetsuCode");                
                fromText.onChange = "onChange_txtShisetsuCodeFrom";
                //onChange_txtShisetsuCodeFromのイベントを検知し、隠しボタンのbtnHiddenFromのclickイベントを発火する
                Uz.GyomuJSHelper.registOriginalEvent("onChange_txtShisetsuCodeFrom", () => {
                    (<any>this.controls.btnHiddenFrom()._control).fireEvent("onClick_txtShisetsuCodeFrom");
                });

                var toText = <Uz._TextBox>Uz.JSControlUtil.getJSControl("ccdShisetsuCodeTo_txtShisetsuCode");
                toText.onChange = "onChange_txtShisetsuCodeTo";
                //onChange_txtShisetsuCodeToのイベントを検知し、隠しボタンのbtnHiddenToのclickイベントを発火する
                Uz.GyomuJSHelper.registOriginalEvent("onChange_txtShisetsuCodeTo", () => {
                    (<any>this.controls.btnHiddenTo()._control).fireEvent("onClick_txtShisetsuCodeTo");
                });

                var fromBtnShisetsuCode = <Uz._ButtonDialog>Uz.JSControlUtil.getJSControl("ccdShisetsuCodeFrom_btnShisetsuCode");
                fromBtnShisetsuCode.onOkClose = "onOKClose_btnShisetsuCodeFrom";
                //onOKClose_btnShisetsuCodeFromのイベントを検知し、隠しボタンのbtnHiddenOKCloseFromのclickイベントを発火する
                Uz.GyomuJSHelper.registOriginalEvent("onOKClose_btnShisetsuCodeFrom", () => {
                    (<any>this.controls.btnHiddenOKCloseFrom()._control).fireEvent("onClick_OKCloseFrom");
                });

                var toBtnShisetsuCode = <Uz._ButtonDialog>Uz.JSControlUtil.getJSControl("ccdShisetsuCodeTo_btnShisetsuCode");
                toBtnShisetsuCode.onOkClose = "onOKClose_btnShisetsuCodeTo";
                //onOKClose_btnShisetsuCodeToのイベントを検知し、隠しボタンのbtnHiddenOKCloseToのclickイベントを発火する
                Uz.GyomuJSHelper.registOriginalEvent("onOKClose_btnShisetsuCodeTo", () => {
                    (<any>this.controls.btnHiddenOKCloseTo()._control).fireEvent("onClick_OKCloseTo");
                });
            }
        }
    }
}



module AFA {

    export module ShisetsuCodeSelectRange {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}




