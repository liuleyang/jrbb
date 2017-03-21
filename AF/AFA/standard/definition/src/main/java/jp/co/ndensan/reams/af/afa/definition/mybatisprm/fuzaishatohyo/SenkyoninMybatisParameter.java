/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 選挙人パラメータクラスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SenkyoninMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final boolean 受理フラグ;
    private final ShohonNo 抄本番号;
    private final RString 施設コード;
    private final List<ShikibetsuCode> 識別コードリスト;

    /**
     * コンストラクタです。
     *
     * @param 受理フラグ boolean
     * @param 抄本番号 ShohonNo
     * @param 施設コード RString
     * @param 識別コードリスト List<ShikibetsuCode>
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public SenkyoninMybatisParameter(boolean 受理フラグ, ShohonNo 抄本番号,
            RString 施設コード, List<ShikibetsuCode> 識別コードリスト,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.受理フラグ = 受理フラグ;
        this.抄本番号 = 抄本番号;
        this.施設コード = 施設コード;
        this.識別コードリスト = 識別コードリスト;
    }

    /**
     * コンストラクタです。
     *
     * @param 受理フラグ boolean
     * @param 抄本番号 ShohonNo
     * @param 施設コード RString
     * @param 識別コードリスト List<ShikibetsuCode>
     * @param key IShikibetsuTaishoPSMSearchKey
     */
    public SenkyoninMybatisParameter(boolean 受理フラグ, ShohonNo 抄本番号,
            List<RString> 識別コードリスト, RString 施設コード,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        this.受理フラグ = 受理フラグ;
        this.抄本番号 = 抄本番号;
        this.施設コード = 施設コード;
        this.識別コードリスト = new ArrayList<>();
        for (RString 識別コード : 識別コードリスト) {
            this.識別コードリスト.add(new ShikibetsuCode(識別コード));
        }
    }
}
