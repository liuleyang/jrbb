/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMD2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.meiboshokai.MeiboShokaiSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.ShohonShokaiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD2010.dgShokaiTohyoJokyo_Row;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.af.afa.service.meiboshokai.MeiboShokaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * ShohonShokaiDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public class ShohonShokaiHandler {

    private final ShohonShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShohonShokaiDiv
     */
    public ShohonShokaiHandler(ShohonShokaiDiv div) {
        this.div = div;
    }

    /**
     * 抄本番号と識別コードから、投票状況情報をセットする。
     *
     * @param shohonNo RString
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoShurui SenkyoShurui
     */
    public void setData(RString shohonNo, ShikibetsuCode shikibetsuCode, SenkyoShurui senkyoShurui) {

        MeiboShokaiFinder finder = MeiboShokaiFinder.createInstance();

        List<MeiboShokaiSearchResult> results = finder.get投票状況一覧(new ShohonNo(shohonNo), shikibetsuCode).records();
        if (!results.isEmpty()) {
            List<dgShokaiTohyoJokyo_Row> rowList = new ArrayList<>();
            for (MeiboShokaiSearchResult result : results) {
                dgShokaiTohyoJokyo_Row row = new dgShokaiTohyoJokyo_Row();
                row.setTxtSenkyoNo(result.get選挙番号());
                row.setTxtSenkyoRyakusho(result.get選挙略称());
                row.setTxtTohyoJokyo(result.get投票状況());
                row.setTxtTohyoJiyu(get投票事由名称(result.get投票事由コード(), senkyoShurui));
                row.setTxtJuriYMD(result.get受理年月日());
                row.getTxtJuriTime().setValue(new RTime(result.get受理時刻()));
                row.setTxtShisetsu(get受付施設名称(result.get施設コード()));
                row.setTxtUketsukeNo(result.get受付番号());
                row.setTxtSeikyuHoho(result.get請求方法());
                row.setTxtSeikyuYMD(result.get請求年月日());
                row.setTxtKofuYMD(result.get交付年月日());
                row.setTxtKofuHoho(result.get交付方法());
                row.setTxtUketoriYMD(result.get受取年月日());
                row.setTxtJuriHoho(result.get受理方法());
                row.setTxtShisetsuShubetsu(result.get受理施設種別());
                row.setChkSochiZumiFlag(result.is送致済フラグ());
                row.setChkTenjiFlag(result.is点字フラグ());
                row.setChkDairiFlag(result.is代理投票有フラグ());
                row.setTxtHojoshaShimei1(result.get補助者氏名1());
                row.setTxtHojoshaShimei2(result.get補助者氏名2());
                row.setTxtHenkanYMD(result.get返還年月日());
                row.setTxtKikenYMD(result.get棄権年月日());
                row.setTxtKyohijiyu(result.get拒否事由());
                rowList.add(row);
            }
            div.getShokaiTohyoJokyo().getDgShokaiTohyoJokyo().setDataSource(rowList);
        }

    }

    private static RString get投票事由名称(Code tohyoJiyuCode, SenkyoShurui senkyoShurui) {
        if (tohyoJiyuCode.isEmpty()) {
            return RString.EMPTY;
        } else {
            if (senkyoShurui.equals(SenkyoShurui.憲法改正国民投票)) {
                return CodeMaster.getCodeMeisho(AFACodeShubetsu.投票事由コード_国民.getCodeShubetsu(), tohyoJiyuCode);
            } else {
                return CodeMaster.getCodeMeisho(AFACodeShubetsu.投票事由コード.getCodeShubetsu(), tohyoJiyuCode);
            }
        }
    }

    private static RString get受付施設名称(RString 施設コード) {
        Shisetsu 施設 = ShisetsuManager.createInstance().get施設By施設コード(施設コード);
        return 施設 == null ? RString.EMPTY : 施設.get施設名称();
    }
}
