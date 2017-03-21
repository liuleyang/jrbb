package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboBango;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IMeiboBangoDiv extends ICommonChildDivBaseProperties {

    /**
     * 名簿番号・冊を返します。
     *
     * @return 冊
     */
    RString get冊();

    /**
     * 名簿番号・頁を返します。
     *
     * @return 頁
     */
    Decimal get頁();

    /**
     * 名簿番号・行を返します。
     *
     * @return 行
     */
    Decimal get行();

    /**
     * この共有子Divを初期化します。
     * @param satsu 冊
     * @param page ページ
     * @param gyo 行
     */
    void initialize(RString satsu, Decimal page, Decimal gyo);

    /**
     * この共有子Divに初期値を設定します。
     */
    void initialize();

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

}
