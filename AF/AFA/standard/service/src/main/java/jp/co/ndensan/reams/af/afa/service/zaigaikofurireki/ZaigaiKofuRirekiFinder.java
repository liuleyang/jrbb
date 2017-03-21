/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.zaigaikofurireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.zaigaikofurireki.ZaigaikofurirekiResult;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zaigaikofurirekidialog.ZaigaiKofuRirekiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zaigaikofurireki.IZaigaiKofuRirekiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 在外交付履歴ダイアログクラス
 *
 * @reamsid_L AF-0320-014 xul
 */
public class ZaigaiKofuRirekiFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ZaigaiKofuRirekiFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    ZaigaiKofuRirekiFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ZaigaiKofuRirekiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ZaigaiKofuRirekiFinder}のインスタンス
     */
    public static ZaigaiKofuRirekiFinder createInstance() {
        return InstanceProvider.create(ZaigaiKofuRirekiFinder.class);
    }

    /**
     * 郵便等投票資格情報を取得する
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return 交付履歴情報 ZaigaikofurirekiResult
     */
    @Transaction
    public List<ZaigaikofurirekiResult> get交付履歴情報(ShikibetsuCode shikibetsuCode) {
        List<ZaigaikofurirekiResult> 交付履歴情報 = new ArrayList<>();
        IZaigaiKofuRirekiMapper mapper = mapperProvider.create(IZaigaiKofuRirekiMapper.class);
        List<ZaigaiKofuRirekiEntity> 交付履歴情報リスト = mapper.select交付履歴情報(shikibetsuCode);
        for (ZaigaiKofuRirekiEntity 交付履歴情報entity : 交付履歴情報リスト) {
            交付履歴情報.add(new ZaigaikofurirekiResult(交付履歴情報entity));
        }
        return 交付履歴情報;
    }
}
