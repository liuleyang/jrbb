/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.mutohyonyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Mybatisパラメータクラスです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MutohyoNyuryokuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo shohonNo;

    private final RString groupCode;

    private final RString tohyokuCode;

    private final RString satsu;

    private final Decimal page;

    /**
     * コンストラクタ作成します。
     *
     * @param shohonNo 抄本番号
     * @param groupCode グループコード
     * @param tohyokuCode 投票区コード
     * @param satsu 冊
     * @param page 頁
     * @param searchKey PSM検索キー
     */
    public MutohyoNyuryokuMybatisParameter(ShohonNo shohonNo, RString groupCode, RString tohyokuCode, RString satsu, Decimal page,
            IShikibetsuTaishoPSMSearchKey searchKey) {

        super(searchKey);
        this.shohonNo = shohonNo;
        this.groupCode = groupCode;
        this.tohyokuCode = tohyokuCode;
        this.satsu = satsu;
        this.page = page;

    }

}
