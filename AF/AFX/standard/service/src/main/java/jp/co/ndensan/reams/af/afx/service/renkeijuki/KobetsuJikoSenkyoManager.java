/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.renkeijuki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afx.business.renkeijuki.KobetsuJikoSenkyo;
import jp.co.ndensan.reams.af.afx.definition.core.enumeratedtype.SenkyoShikaku;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;
import jp.co.ndensan.reams.af.afx.entity.renkeijuki.KobetsuJikoSenkyoEntity;
import jp.co.ndensan.reams.af.afx.persistence.renkeijuki.KobetsuJikoSenkyoDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 個別事項検索用のManagerクラスです
 *
 * @author
 */
public class KobetsuJikoSenkyoManager implements IKobetsuJikoSenkyoFinder {

    private final KobetsuJikoSenkyoDac dac;
    private final RString SHIKAKU_ARI = new RString("有");

    /**
     * インスタンスを生成します。
     */
    public KobetsuJikoSenkyoManager() {
        this.dac = InstanceProvider.create(KobetsuJikoSenkyoDac.class);
    }

    KobetsuJikoSenkyoManager(KobetsuJikoSenkyoDac dac) {
        this.dac = dac;
    }

    @Override
    public List<KobetsuJikoSenkyo> select(KobetsuJikoSenkyoFinderParameter param) {
        List<KobetsuJikoSenkyoEntity> resultEntities = dac.select(param);
        List<KobetsuJikoSenkyo> result = new ArrayList<>();
        for (KobetsuJikoSenkyoEntity entity : resultEntities) {
            result.add(convertKobetsuJikoSenkyoEntity(entity, param));
        }
        return result;
    }

    private KobetsuJikoSenkyo convertKobetsuJikoSenkyoEntity(KobetsuJikoSenkyoEntity entity, KobetsuJikoSenkyoFinderParameter param) {
        KobetsuJikoSenkyo senkyo = new KobetsuJikoSenkyo();
        senkyo.setShikibetsuCode(entity.getShikibetsuCode());
        senkyo.setSenkyoShikaku(RString.FULL_SPACE);
        if (SenkyoShikaku.有権者.getコード().equals(entity.getShikakuKubun().getKey())) {
            senkyo.setSenkyoShikaku(SHIKAKU_ARI);
        }
        if (SenkyoShikaku.表示者.getコード().equals(entity.getShikakuKubun().getKey())) {
            senkyo.setSenkyoShikaku(SHIKAKU_ARI);
        }
        if (SenkyoShikaku.抹消者.getコード().equals(entity.getShikakuKubun().getKey())) {
            senkyo.setSenkyoShikaku(RString.FULL_SPACE);
        }
        if (SenkyoShikaku.公民権停止者.getコード().equals(entity.getShikakuKubun().getKey())) {
            senkyo.setSenkyoShikaku(SHIKAKU_ARI);
        }
        return senkyo;
    }
}
