/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiKofuRirekiDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.zaigaikofurireki.ZaigaikofurirekiResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 在外交付履歴ダイアログのクラスです。
 *
 * @reamsid_L AF-0320-014 xul
 */
public class ZaigaiKofuRirekiDialog {

    private final RString 性別コード_1 = new RString("1");
    private final RString 性別コード_2 = new RString("2");
    private final RString 性別_男 = new RString("男");
    private final RString 性別_女 = new RString("女");

    /**
     * 在外交付履歴ダイアログの初期表示を行います。
     *
     * @param div ZaigaiKofuRirekiDialogDiv
     * @return ResponseData
     */
    public ResponseData<ZaigaiKofuRirekiDialogDiv> onLoad(ZaigaiKofuRirekiDialogDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        ZaigaiKofuRirekiDialogHandler handler = ZaigaiKofuRirekiDialogHandler.of(div);
        List<ZaigaikofurirekiResult> 交付履歴情報list = handler.get_交付履歴情報(識別コード);
        if (null != 交付履歴情報list && !交付履歴情報list.isEmpty()) {
            List<dgKofuRireki_Row> list = new ArrayList();
            for (ZaigaikofurirekiResult 交付履歴情報 : 交付履歴情報list) {
                FlexibleDate 交付日 = null == 交付履歴情報.get在外選挙資格()
                        ? FlexibleDate.EMPTY : 交付履歴情報.get在外選挙資格().getKofuYMD();
                FlexibleDate 修正日 = null == 交付履歴情報.get在外選挙資格()
                        ? FlexibleDate.EMPTY : 交付履歴情報.get在外選挙資格().getShuseiYMD();
                Code 修正区分 = null == 交付履歴情報.get在外選挙資格()
                        ? Code.EMPTY : 交付履歴情報.get在外選挙資格().getShuseiKubun();
                AtenaMeisho 申請者氏名 = null == 交付履歴情報.get在外選挙人申請情報()
                        ? AtenaMeisho.EMPTY : 交付履歴情報.get在外選挙人申請情報().getShinseishaShimei();
                FlexibleDate 生年月日 = null == 交付履歴情報.get在外選挙人申請情報()
                        ? FlexibleDate.EMPTY : 交付履歴情報.get在外選挙人申請情報().getSeinengappiYMD();
                RString 性別コード = null == 交付履歴情報.get在外選挙人申請情報()
                        ? RString.EMPTY : 交付履歴情報.get在外選挙人申請情報().getSeibetsuCode();
                AtenaJusho 住所 = null == 交付履歴情報.get在外選挙人住所情報()
                        ? AtenaJusho.EMPTY : 交付履歴情報.get在外選挙人住所情報().getJusho();
                dgKofuRireki_Row row = new dgKofuRireki_Row();
                row.setTxtKofuNo(null == 交付履歴情報.get在外選挙資格().getKofuNo()
                        ? RString.EMPTY : 交付履歴情報.get在外選挙資格().getKofuNo());
                if (null == 交付日 || 交付日.isEmpty()) {
                    row.setTxtKofuYMD(null);
                } else {
                    row.getTxtKofuYMD().setValue(交付日);
                }
                if (null == 修正日 || 修正日.isEmpty()) {
                    row.setTxtShuseiYMD(null);
                } else {
                    row.getTxtShuseiYMD().setValue(修正日);
                }
                RString 修正code = (null == 修正区分
                        ? RString.EMPTY : new RString(修正区分.toString()));
                row.setTxtShuseiKubun(set修正理由(修正code));
                row.setTxtShimei(null == 申請者氏名
                        ? RString.EMPTY : new RString(申請者氏名.toString()));
                if (null == 生年月日 || 生年月日.isEmpty()) {
                    row.setTxtSeinengappi(null);
                } else {
                    row.getTxtSeinengappi().setValue(生年月日);
                }
                row.setTxtSeibetsu(set性別(性別コード));
                row.setTxtJusho(null == 住所
                        ? RString.EMPTY : new RString(住所.toString()));
                list.add(row);
            }
            div.getDgKofuRireki().setDataSource(list);
        }
        return ResponseData.of(div).respond();
    }

    private RString set性別(RString 性別コード) {
        if (性別コード_1.equals(性別コード)) {
            return 性別_男;
        } else if (性別コード_2.equals(性別コード)) {
            return 性別_女;
        }
        return RString.EMPTY;
    }

    private RString set修正理由(RString 修正code) {
        if (null != 修正code) {
            UzT0007CodeEntity codeItem = CodeMaster.getCode(AFACodeShubetsu.修正区分.getCodeShubetsu(), new Code(修正code));
            if (codeItem != null) {
                return codeItem.getコード名称();
            } else {
                return RString.EMPTY;
            }
        }
        return RString.EMPTY;
    }
}
