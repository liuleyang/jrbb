/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.zaigaisenkyoninjoho;

import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaisenkyoninjoho.IZaigaiSenkyoninJohoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外選挙人情報共有子DIVクラス
 *
 * @reamsid_L AF-0320-011 lis
 */
public class ZaigaiSenkyoninJohoFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ZaigaiSenkyoninJohoFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    ZaigaiSenkyoninJohoFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiSenkyoninJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiSenkyoninJohoFinder}のインスタンス
     */
    public static ZaigaiSenkyoninJohoFinder createInstance() {
        return InstanceProvider.create(ZaigaiSenkyoninJohoFinder.class);
    }

    /**
     * 在外選挙資格件数を取得する
     *
     * @param 交付番号 RString
     * @return int
     */
    @Transaction
    public int get在外選挙資格件数By交付番号(RString 交付番号) {

        IZaigaiSenkyoninJohoMapper mapper = mapperProvider.create(IZaigaiSenkyoninJohoMapper.class);

        return mapper.selectAfT122ZaigaiSenkyoShikakuCountByKofuNo(交付番号);
    }
}
