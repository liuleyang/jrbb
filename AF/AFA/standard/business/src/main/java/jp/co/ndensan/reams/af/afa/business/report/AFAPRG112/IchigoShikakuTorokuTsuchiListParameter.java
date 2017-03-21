/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import static jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler.getNullToRString;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.IchigoShikakuTorokuTsuchiListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 1号資格登録通知一覧表のパラメータクラスです。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IchigoShikakuTorokuTsuchiListParameter {

    private static final int 転入前全国住所コード上5桁 = 5;

    private IchigoShikakuTorokuTsuchiListEntity 選挙人資格の情報;
    private RString page;
    private final Association 導入団体;
    private ZenkokuJushoItem 全国住所;
    private final boolean 登録年月日検索基準_登録届出年月日;
    private final boolean 登録年月日検索基準_登録異動年月日;
    private RString 集計;
    private int senkyoCount;
    private boolean 出力区分_集計行;
    private boolean 出力区分_空白行;

    /**
     * コンストラクタ
     *
     * @param 選挙人資格の情報 SenkyoMeiboShohonEntity
     * @param page RString
     * @param 導入団体 Association
     * @param 全国住所 ZenkokuJushoItem
     * @param 登録年月日検索基準_登録届出年月日 Boolean
     * @param 登録年月日検索基準_登録異動年月日 Boolean
     * @param 集計 RString
     * @param senkyoCount int
     * @param 出力区分_集計行 boolean
     * @param 出力区分_空白行 boolean
     */
    public IchigoShikakuTorokuTsuchiListParameter(IchigoShikakuTorokuTsuchiListEntity 選挙人資格の情報,
            RString page,
            Association 導入団体,
            ZenkokuJushoItem 全国住所,
            Boolean 登録年月日検索基準_登録届出年月日,
            Boolean 登録年月日検索基準_登録異動年月日,
            RString 集計,
            int senkyoCount,
            boolean 出力区分_集計行,
            boolean 出力区分_空白行) {
        this.選挙人資格の情報 = 選挙人資格の情報;
        this.page = page;
        this.導入団体 = 導入団体;
        this.全国住所 = 全国住所;
        this.登録年月日検索基準_登録届出年月日 = 登録年月日検索基準_登録届出年月日;
        this.登録年月日検索基準_登録異動年月日 = 登録年月日検索基準_登録異動年月日;
        this.集計 = 集計;
        this.senkyoCount = senkyoCount;
        this.出力区分_集計行 = 出力区分_集計行;
        this.出力区分_空白行 = 出力区分_空白行;
    }

    /**
     * 転入前全国住所コード上5桁を取得します。。
     *
     * @param entity SenkyoMeiboShohonEntity
     * @return 転入前全国住所コード上5桁
     */
    public RString get転入前全国住所コード上5桁(SenkyoMeiboShohonEntity entity) {
        RString 転入前全国住所コード = getNullToRString(entity.getAtenaPSMEntity().getTennyumaeZenkokuJushoCode());
        if (転入前全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転入前全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }
}
