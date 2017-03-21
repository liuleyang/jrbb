/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenkobetsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.processprm.nyujokenikkatsu.AFABTB202SelectProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 入場券発行（個別）バッチパラメータクラスです。
 *
 * @reamsid_L AF-0170-030 guyq
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AFABTB202BatchParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_SHOHON = "抄本番号";
    private static final String KEY_SENKYOSHURUI = "選挙種類";
    private static final String KEY_SHOHONNAME = "抄本名";
    private static final String KEY_TOUHYOBI = "投票日";
    private static final String KEY_SAKUINLIST = "選挙リスト";
    private static final String KEY_NYUJOKENNAME1 = "入場券名1";
    private static final String KEY_NYUJOKENNAME2 = "入場券名2";
    private static final String KEY_NYUJOKENNAME3 = "入場券名3";
    private static final String KEY_SAKUINMEILIST = "選挙人一覧リスト";
    private static final String KEY_INSAKUTYPE = "印刷タイプ";
    private static final String KEY_ISETAIINJININZUU = "世帯印字人数";
    private static final String KEY_TAISHOUSHAWOKOKONIKU = "対象者を個々に作成する有無";
    private static final String KEY_TAISHOUSHAWOSETAINIKUSHA = "対象者の世帯で作成する有無";
    private static final String KEY_SAMPLEBUNJI = "サンプル文字";

    @BatchParameter(key = KEY_SHOHON, name = "抄本番号", order = 1)
    private RString 抄本番号;
    @BatchParameter(key = KEY_SENKYOSHURUI, name = "選挙種類", order = 2)
    private RString 選挙種類;
    @BatchParameter(key = KEY_SHOHONNAME, name = "抄本名", order = 3)
    private RString 抄本名;
    @BatchParameter(key = KEY_TOUHYOBI, name = "投票日", order = 4)
    private FlexibleDate 投票日;
    @BatchParameter(key = KEY_SAKUINLIST, name = "選挙リスト", order = 5)
    private List<Senkyomeishou> 選挙リスト;
    @BatchParameter(key = KEY_NYUJOKENNAME1, name = "入場券名1", order = 6)
    private RString 入場券名1;
    @BatchParameter(key = KEY_NYUJOKENNAME2, name = "入場券名2", order = 7)
    private RString 入場券名2;
    @BatchParameter(key = KEY_NYUJOKENNAME3, name = "入場券名3", order = 8)
    private RString 入場券名3;
    @BatchParameter(key = KEY_SAKUINMEILIST, name = "選挙人一覧リスト", order = 9)
    private List<SenkyoninIrain> 選挙人一覧リスト;
    @BatchParameter(key = KEY_INSAKUTYPE, name = "印刷タイプ", order = 10)
    private RString 印刷タイプ;
    @BatchParameter(key = KEY_ISETAIINJININZUU, name = "世帯印字人数", order = 11)
    private RString 世帯印字人数;
    @BatchParameter(key = KEY_TAISHOUSHAWOKOKONIKU, name = "対象者を個々に作成する有無", order = 12)
    private Boolean 対象者を個々に作成する有無;
    @BatchParameter(key = KEY_TAISHOUSHAWOSETAINIKUSHA, name = "対象者の世帯で作成する有無", order = 13)
    private Boolean 対象者の世帯で作成する有無;
    @BatchParameter(key = KEY_SAMPLEBUNJI, name = "サンプル文字", order = 14)
    private RString サンプル文字;

    /**
     * AFABTB202SelectProcessParameterの変換のメソッドです。
     *
     * @return AFABTB202SelectProcessParameter
     */
    public AFABTB202SelectProcessParameter toAFABTB202SelectProcessParameter() {

        return new AFABTB202SelectProcessParameter(new ShohonNo(抄本番号),
                抄本名,
                選挙種類,
                投票日,
                選挙リスト,
                入場券名1,
                入場券名2,
                入場券名3,
                選挙人一覧リスト,
                印刷タイプ,
                世帯印字人数,
                対象者を個々に作成する有無,
                対象者の世帯で作成する有無,
                サンプル文字, null, null);
    }

}
