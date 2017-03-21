/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.kaikunewmeibosenkyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Mapper <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaikuNewMeiBoSenkyoMapperParam implements Serializable {

    private ShohonNo 抄本番号;
    private RString 抄本名;
    private FlexibleDate 規定年齢到達年月日;
    private FlexibleDate 投票年月日;
    private FlexibleDate 処理年月日;
    private FlexibleDate 名簿基準年月日;
    private FlexibleDate 名簿確定年月日;
    private RYear 年度;
    private FlexibleDate 名簿最新化年月日;
    private boolean 選挙時登録フラグ;

}
