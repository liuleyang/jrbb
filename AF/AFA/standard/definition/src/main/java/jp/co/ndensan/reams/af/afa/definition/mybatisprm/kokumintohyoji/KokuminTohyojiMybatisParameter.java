/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TodofukenType;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import lombok.Getter;
import lombok.Setter;

/**
 * 国民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0360-020 xiaoj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KokuminTohyojiMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private static final RString SORT_ORDER = new RString("order by");
    private static final RString SORT_SEPARATOR = new RString(" , ");

    private final FlexibleDate 年齢到達日;
    private FlexibleDate 基準日;
    private final ShohonNo 抄本番号;
    private final FlexibleDate 抹消日;
    private final FlexibleDate 投票日;
    private final FlexibleDate 特定期限日;
    private final FlexibleDate 特定期間開始日;
    private RString sort;
    private final FlexibleDate 名簿登録年月日;
    private final FlexibleDate 生年月日;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;
    private final RString 登録事由コード;
    private final RString 住民状態コード;
    private final RString order順;
    private RString riyoKubun;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;
    private RString 都道府区分;
    private RString 消除事由コード_死亡;
    private RString 消除事由コード_国籍喪失;
    private RString table;
    private FlexibleDate ageForSelect;
    private RString 登録年月日検索基準;
    private List<RString> idoJiyuCodeList;
    private RString 在外国外分類コード;

    /**
     * コンストラクタです。
     *
     * @param 年齢到達日 年齢到達日
     * @param 基準日 基準日
     * @param 抄本番号 抄本番号
     * @param 抹消日 抹消日
     * @param 投票日 投票日
     * @param 特定期限日 特定期限日
     * @param 特定期間開始日 特定期間開始日
     * @param sort sort
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 名簿登録年月日 名簿登録年月日
     * @param 生年月日 生年月日
     * @param keyForAll IShikibetsuTaishoPSMSearchKey
     * @param table テーブル名
     * @param ageForSelect FlexibleDate
     * @param order順 RString
     */
    public KokuminTohyojiMybatisParameter(FlexibleDate 年齢到達日, FlexibleDate 基準日,
            ShohonNo 抄本番号, FlexibleDate 抹消日,
            FlexibleDate 投票日, FlexibleDate 特定期限日, FlexibleDate 特定期間開始日,
            RString sort, IShikibetsuTaishoPSMSearchKey searchKey, IShikibetsuTaishoPSMSearchKey keyForAll,
            FlexibleDate 名簿登録年月日, FlexibleDate 生年月日, RString table, FlexibleDate ageForSelect, RString order順) {
        super(searchKey);
        if (keyForAll != null) {
            shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(keyForAll);
        } else {
            shikibetsutaishoParam = null;
        }
        this.年齢到達日 = 年齢到達日;
        this.基準日 = 基準日;
        this.抄本番号 = 抄本番号;
        this.抹消日 = 抹消日;
        this.投票日 = 投票日;
        this.特定期限日 = 特定期限日;
        this.特定期間開始日 = 特定期間開始日;
        this.sort = sort;
        this.名簿登録年月日 = 名簿登録年月日;
        this.生年月日 = 生年月日;
        // TODO 指摘 自機能の変数、共有方法に設定不要。
        this.登録事由コード = JukiIdoJiyu.転入.get異動事由コード();
        this.消除事由コード_死亡 = JukiIdoJiyu.死亡.get異動事由コード();
        this.消除事由コード_国籍喪失 = JukiIdoJiyu.国籍喪失.get異動事由コード();
        this.住民状態コード = JuminJotai.住民.コード();
        this.都道府区分 = TodofukenType.国外.value();
        this.登録年月日検索基準 = BusinessConfig.get(ConfigKeysAFA.登録年月日検索基準, SubGyomuCode.AFA選挙本体);
        this.table = table;
        this.ageForSelect = ageForSelect;
        this.order順 = order順;
    }

    /**
     * 出力順の追加です。
     *
     * @param sort RString
     */
    public void addSortAfter(RString sort) {
        if (RString.isNullOrEmpty(this.sort)) {
            this.sort = SORT_ORDER.concat(RString.HALF_SPACE).concat(sort);
        } else {
            this.sort = this.sort.concat(SORT_SEPARATOR).concat(sort);
        }
    }

    /**
     * 出力順の追加です。
     *
     * @param sort RString
     */
    public void addSortBefore(RString sort) {
        if (RString.isNullOrEmpty(this.sort)) {
            this.sort = SORT_ORDER.concat(RString.HALF_SPACE).concat(sort);
        } else {
            this.sort = this.sort.replace(SORT_ORDER, SORT_ORDER.concat(RString.HALF_SPACE).concat(sort).concat(SORT_SEPARATOR));
        }
    }
}
