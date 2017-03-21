/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 施設送付書発行バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTE205SelectProcessMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 住基連動氏名;
    private RString 施設コード開始;
    private RString 施設コード終了;
    private FlexibleDate 交付日開始;
    private boolean isUsing交付日開始;
    private FlexibleDate 交付日終了;
    private boolean isUsing交付日終了;
    private FlexibleDate 基準年月日;
    private FlexibleDate 処理年月日;
    private ShohonNo 抄本番号;
    private Boolean 無投票選挙フラグ;
    private RString order順;
    private RString 期日前不在者区分;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 住基連動氏名 RString
     * @param 施設コード開始 RString
     * @param 施設コード終了 RString
     * @param 交付日開始 FlexibleDate
     * @param 交付日終了 FlexibleDate
     * @param 抄本番号 ShohonNo
     * @param 無投票選挙フラグ Boolean
     */
    public AFABTE205SelectProcessMyBatisParameter(IShikibetsuTaishoPSMSearchKey key,
            RString 施設コード開始,
            RString 施設コード終了,
            FlexibleDate 交付日開始,
            FlexibleDate 交付日終了,
            ShohonNo 抄本番号,
            RString 住基連動氏名,
            Boolean 無投票選挙フラグ) {
        super(key);
        this.住基連動氏名 = 住基連動氏名;
        this.施設コード開始 = 施設コード開始;
        this.施設コード終了 = 施設コード終了;
        this.交付日開始 = 交付日開始;
        this.isUsing交付日開始 = isUsing日付(交付日開始);
        this.交付日終了 = 交付日終了;
        this.isUsing交付日終了 = isUsing日付(交付日終了);
        this.抄本番号 = 抄本番号;
        this.無投票選挙フラグ = 無投票選挙フラグ;
    }

    private static boolean isUsing日付(FlexibleDate 日付) {
        return 日付 != null && !FlexibleDate.EMPTY.equals(日付);
    }
}
