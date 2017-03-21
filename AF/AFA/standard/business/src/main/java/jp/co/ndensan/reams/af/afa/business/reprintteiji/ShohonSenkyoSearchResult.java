/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.reprintteiji;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.reprintteiji.shohonsenkyo.ShohonSenkyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本と選挙情報の検索結果のクラスです。
 *
 * @reamsid_L AF-0020-020 gaoya
 */
public class ShohonSenkyoSearchResult {

    private final ShohonSenkyoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShohonSenkyoEntity
     */
    public ShohonSenkyoSearchResult(ShohonSenkyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 抄本番号を取得します。
     *
     * @return 抄本番号
     */
    public ShohonNo get抄本番号() {
        return entity.getShohonNo();
    }

    /**
     * 抄本名称を取得します。
     *
     * @return 抄本名称
     */
    public RString get抄本名称() {
        return entity.getShohonName();
    }

    /**
     * 選挙種類を取得します。
     *
     * @return 選挙種類
     */
    public Code get選挙種類() {
        return entity.getSenkyoShurui();
    }

    /**
     * 投票年月日を取得します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return entity.getTohyoYMD();
    }

    /**
     * 規定年齢到達年月日を取得します。
     *
     * @return 規定年齢到達年月日
     */
    public FlexibleDate get規定年齢到達年月日() {
        return entity.getKiteiNenreiTotatsuYMD();
    }

    /**
     * 処理年月日を取得します。
     *
     * @return 処理年月日
     */
    public FlexibleDate get処理年月日() {
        return entity.getShoriYMD();
    }

    /**
     * 名簿基準年月日を取得します。
     *
     * @return 名簿基準年月日
     */
    public FlexibleDate get名簿基準年月日() {
        return entity.getKijunYMD();
    }

    /**
     * 名簿登録年月日を取得します。
     *
     * @return 名簿登録年月日
     */
    public FlexibleDate get名簿登録年月日() {
        return entity.getMeiboTorokuYMD();
    }

    /**
     * 転出期限年月日を取得します。
     *
     * @return 転出期限年月日
     */
    public FlexibleDate get転出期限年月日() {
        return entity.getTenshutsuKigenYMD();
    }

    /**
     * 転入期限年月日を取得します。
     *
     * @return 転入期限年月日
     */
    public FlexibleDate get転入期限年月日() {
        return entity.getTennyuKigenYMD();
    }
}
