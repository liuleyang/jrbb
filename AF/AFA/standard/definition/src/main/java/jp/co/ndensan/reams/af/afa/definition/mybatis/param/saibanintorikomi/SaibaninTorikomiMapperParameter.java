/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種マスタデータ出力を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L AF-0670-010 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class SaibaninTorikomiMapperParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 氏名;
    private RString 生年月日;
    private RString 郵便番号;
    private RString 住所;
    private RString 本籍;
    private RString 識別コード;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public SaibaninTorikomiMapperParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
    }

    /**
     * 氏名のgetメソッドです。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * 氏名のsetメソッドです。
     *
     * @param 氏名 氏名
     */
    public void set氏名(RString 氏名) {
        this.氏名 = 氏名;
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return 生年月日;
    }

    /**
     * 生年月日のsetメソッドです。
     *
     * @param 生年月日 生年月日
     */
    public void set生年月日(RString 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return 郵便番号;
    }

    /**
     * 郵便番号のsetメソッドです。
     *
     * @param 郵便番号 郵便番号
     */
    public void set郵便番号(RString 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 住所のsetメソッドです。
     *
     * @param 住所 住所
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

    /**
     * 本籍のgetメソッドです。
     *
     * @return 本籍
     */
    public RString get本籍() {
        return 本籍;
    }

    /**
     * 本籍のsetメソッドです。
     *
     * @param 本籍 本籍
     */
    public void set本籍(RString 本籍) {
        this.本籍 = 本籍;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

}
