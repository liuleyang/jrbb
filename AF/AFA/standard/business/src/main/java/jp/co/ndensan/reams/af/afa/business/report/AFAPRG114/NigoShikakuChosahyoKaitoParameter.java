/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG114;

import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * AFAPRG114_2goShikakuChosahyoKaito_2号資格調査票（回答）（様式2-2）のパラメタです。
 *
 * @reamsid_L AF-0360-062 fulc
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NigoShikakuChosahyoKaitoParameter {

    private final MitorokushaMasshoTsuchiListEntity entity;
    private final RString 転入先郵便番号;
    private final RString 転入先市区町村名;
    private final RString 転入先市区町村区分名称;
    private final RString 転入前市区町村名区分名称;
    private final RString 転入前市区町村名;
    private final RString 発行番号の号;
    private final RString 発行番号の番号;
    private final RString 発行番号の第;
    private final FlexibleDate 発行日;

    /**
     * コンストラクタです。
     *
     * @param entity MitorokushaMasshoTsuchiListEntity
     * @param 転入先郵便番号 RString
     * @param 転入先市区町村名 RString
     * @param 転入先市区町村区分名称 RString
     * @param 発行番号の号 RString
     * @param 発行番号の番号 RString
     * @param 発行番号の第 RString
     * @param 転入前市区町村名区分名称 RString
     * @param 転入前市区町村名 RString
     * @param 発行日 FlexibleDate
     */
    public NigoShikakuChosahyoKaitoParameter(MitorokushaMasshoTsuchiListEntity entity,
            RString 転入先郵便番号,
            RString 転入先市区町村名,
            RString 転入先市区町村区分名称,
            RString 発行番号の号,
            RString 発行番号の番号,
            RString 発行番号の第,
            RString 転入前市区町村名区分名称,
            RString 転入前市区町村名,
            FlexibleDate 発行日) {
        this.entity = entity;
        this.転入先郵便番号 = 転入先郵便番号;
        this.転入先市区町村名 = 転入先市区町村名;
        this.転入先市区町村区分名称 = 転入先市区町村区分名称;
        this.発行番号の号 = 発行番号の号;
        this.発行番号の番号 = 発行番号の番号;
        this.発行番号の第 = 発行番号の第;
        this.転入前市区町村名区分名称 = 転入前市区町村名区分名称;
        this.転入前市区町村名 = 転入前市区町村名;
        this.発行日 = 発行日;

    }
}
