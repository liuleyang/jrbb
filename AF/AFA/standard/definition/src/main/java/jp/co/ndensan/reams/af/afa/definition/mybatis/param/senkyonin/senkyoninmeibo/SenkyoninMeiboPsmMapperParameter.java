/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙人名簿を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public final class SenkyoninMeiboPsmMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 性別コード;
    private final ShohonNo 抄本番号;
    private final RString 投票区コード;

    /**
     * コンストラクタです。
     *
     * @param 抄本番号 ShohonNo
     * @param 投票区コード RString
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    private SenkyoninMeiboPsmMapperParameter(ShohonNo 抄本番号, RString 投票区コード, IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.抄本番号 = 抄本番号;
        this.投票区コード = 投票区コード;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 抄本番号 ShohonNo
     * @param 投票区コード RString
     * @param key IShikibetsuTaishoPSMSearchKey
     * @return SenkyoninMeiboPsmMapperParameter
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public static SenkyoninMeiboPsmMapperParameter createParam(ShohonNo 抄本番号, RString 投票区コード, IShikibetsuTaishoPSMSearchKey key) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        return new SenkyoninMeiboPsmMapperParameter(抄本番号, 投票区コード, key);
    }
}
