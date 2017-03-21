package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuSakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 海区作成帳票共有子DIV
 *
 * @reamsid_L AF-0460-011 liuyj
 */
public interface IKaikuSakuseiChohyoDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数のコードから、海区作成帳票共有子DIV初期表示を行う。
     *
     */
    void initialize();

    /**
     * この共有子Divに時点日を設定します。<br />
     *
     * @param 名簿基準年月日 RDate
     */
    void set時点日(RDate 名簿基準年月日);

    /**
     * この共有子Div情報を取得する。
     *
     * @return KaikuSakuseiChohyoDiv
     */
    KaikuSakuseiChohyoDiv get海区作成帳票情報();

    /**
     * 選挙人名簿最新化の海区作成帳票情報を編集する。
     *
     * @param 選挙時登録フラグ Boolean
     */
    void edit選挙人名簿最新化(Boolean 選挙時登録フラグ);
}
