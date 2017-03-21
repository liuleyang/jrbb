/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuNewMeiboSaishinkaEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikunewmeibosenkyo.KaikuNewMeiBoSenkyoMapperParam;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.dgKaikuShohonSelect_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Handler <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class KaikuNewMeiboSaishinkaHandler {

    private final KaikuNewMeiboSaishinkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 海区漁業調整委員会委員選挙人名簿最新化Div
     */
    public KaikuNewMeiboSaishinkaHandler(KaikuNewMeiboSaishinkaDiv div) {
        this.div = div;
    }

    /**
     * 対象抄本Gridをセットする。
     *
     * @param 対象抄本情報リスト List<KaikuNewMeiBoSenkyoMapperParam>
     */
    public void edit対象抄本Grid(List<KaikuNewMeiBoSenkyoMapperParam> 対象抄本情報リスト) {
        List<dgKaikuShohonSelect_Row> 対象抄本リスト = new ArrayList<>();
        dgKaikuShohonSelect_Row 画面_対象抄本情報;
        for (int i = 0; i < 対象抄本情報リスト.size(); i++) {
            画面_対象抄本情報 = new dgKaikuShohonSelect_Row();
            KaikuNewMeiBoSenkyoMapperParam 対象抄本情報 = 対象抄本情報リスト.get(i);
            画面_対象抄本情報.setTxtShohonNo(new RString(対象抄本情報.get抄本番号().toString()));
            画面_対象抄本情報.setTxtShohonName(対象抄本情報.get抄本名());
            if (!対象抄本情報.get名簿基準年月日().isEmpty()) {
                画面_対象抄本情報.getTxtKijunYMD().setValue(new RDate(対象抄本情報.get名簿基準年月日().toString()));
            }
            if (!対象抄本情報.get名簿確定年月日().isEmpty()) {
                画面_対象抄本情報.getTxtMeiboKakuteiYMD().setValue(new RDate(対象抄本情報.get名簿確定年月日().toString()));
            }
            if (!対象抄本情報.get規定年齢到達年月日().isEmpty()) {
                画面_対象抄本情報.getTxtNenreiTotatsuYMD().setValue(new RDate(対象抄本情報.get規定年齢到達年月日().toString()));
            }
            if (!対象抄本情報.get投票年月日().isEmpty()) {
                画面_対象抄本情報.getTxtTohyoYMD().setValue(new RDate(対象抄本情報.get投票年月日().toString()));
            }
            if (null != 対象抄本情報.get年度()) {
                画面_対象抄本情報.setTxtNendo(対象抄本情報.get年度().wareki().toDateString());
                画面_対象抄本情報.setTxtNendoSeireki(対象抄本情報.get年度().toDateString());
            }
            if (対象抄本情報.is選挙時登録フラグ()) {
                画面_対象抄本情報.setTxtShohonShurui(KaikuNewMeiboSaishinkaEnum.選挙時.getValue());
            } else {
                画面_対象抄本情報.setTxtShohonShurui(KaikuNewMeiboSaishinkaEnum.当初登録.getValue());
            }
            画面_対象抄本情報.getTxtSaishinkaYMD().setValue(対象抄本情報.get名簿最新化年月日());
            if (!対象抄本情報.get処理年月日().isEmpty()) {
                画面_対象抄本情報.getTxtShoriYMD().setValue(new RDate(対象抄本情報.get処理年月日().toString()));
            }
            対象抄本リスト.add(画面_対象抄本情報);
        }
        div.getDgKaikuShohonSelect().setDataSource(対象抄本リスト);
    }
}
