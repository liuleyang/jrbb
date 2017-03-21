/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.meibosaishinkakokumin;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 投票人名簿最新化バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0390-030 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTG105SelectProcessMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private ShohonNo 抄本番号;
    private FlexibleDate 年齢期限日;
    private RString 選挙種類;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     * @param 年齢期限日 FlexibleDate
     * @param 選挙種類 RString
     *
     */
    public AFABTG105SelectProcessMyBatisParameter(
            IShikibetsuTaishoPSMSearchKey key,
            ShohonNo 抄本番号,
            FlexibleDate 年齢期限日,
            RString 選挙種類) {
        super(key);
        this.抄本番号 = 抄本番号;
        this.年齢期限日 = 年齢期限日;
        this.選挙種類 = 選挙種類;
    }

}
