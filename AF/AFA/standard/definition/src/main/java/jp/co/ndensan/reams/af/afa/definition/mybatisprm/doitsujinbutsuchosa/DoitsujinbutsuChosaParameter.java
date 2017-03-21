/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatisprm.doitsujinbutsuchosa;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * 同一人物調査バッチパラメータクラスです。
 *
 * @reamsid_L AF-0690-020 wanghj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class DoitsujinbutsuChosaParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final ShohonNo 抄本番号;
    private final boolean 氏名;
    private final boolean 氏;
    private final boolean 名;
    private final boolean カナ;
    private final boolean 漢字;
    private final boolean 生年月日;
    private final boolean 性別;
    private final boolean 住所;
    private final boolean 住所コード;
    private final boolean 番地コード;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 ShohonNo
     * @param 氏名 boolean
     * @param 氏 boolean
     * @param 名 boolean
     * @param カナ boolean
     * @param 漢字 boolean
     * @param 生年月日 boolean
     * @param 性別 boolean
     * @param 住所 boolean
     * @param 住所コード boolean
     * @param 番地コード boolean
     */
    public DoitsujinbutsuChosaParameter(IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号, boolean 氏名, boolean 氏, boolean 名,
            boolean カナ, boolean 漢字, boolean 生年月日, boolean 性別, boolean 住所, boolean 住所コード, boolean 番地コード) {
        super(key);
        this.抄本番号 = 抄本番号;
        this.氏名 = 氏名;
        this.氏 = 氏;
        this.名 = 名;
        this.カナ = カナ;
        this.漢字 = 漢字;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.住所 = 住所;
        this.住所コード = 住所コード;
        this.番地コード = 番地コード;
    }

}
