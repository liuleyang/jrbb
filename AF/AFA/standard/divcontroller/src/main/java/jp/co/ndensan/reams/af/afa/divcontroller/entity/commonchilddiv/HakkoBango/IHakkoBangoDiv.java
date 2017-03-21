package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.HakkoBango;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IHakkoBangoDiv extends ICommonChildDivBaseProperties {

    /**
     * 発行番号_第を返します。
     *
     * @return 発行番号_第
     */
    RString get発行番号_第();

    /**
     * 発行番号_番号を返します。
     *
     * @return 発行番号_番号
     */
    RString get発行番号_番号();

    /**
     * 発行番号_号を返します。
     *
     * @return 発行番号_号
     */
    RString get発行番号_号();

    /**
     * この共有子Divを初期化します。
     *
     * @param chohyoID 帳票ID
     */
    void initialize(RString chohyoID);

    /**
     * この共有子Divに初期値を設定します。
     */
    void initialize();

    /**
     * この共有子Divに設定されているデータを全てクリアします。
     */
    void clear();

}
