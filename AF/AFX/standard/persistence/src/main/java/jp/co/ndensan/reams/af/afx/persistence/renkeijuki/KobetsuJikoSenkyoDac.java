/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.persistence.renkeijuki;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;
import jp.co.ndensan.reams.af.afx.entity.renkeijuki.KobetsuJikoSenkyoEntity;
import jp.co.ndensan.reams.af.afx.persistence.mapper.IKobetsuJikoSenkyoMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 個別記載事項情報を検索するDACクラスです。
 *
 * @author
 */
public class KobetsuJikoSenkyoDac {

    @InjectSession
    private SqlSession session;

    private IKobetsuJikoSenkyoMapper mapper;

    /**
     * デフォルトコンストラクタです。 Dacの作成にはInstanceProviderを使用してください。
     */
    public KobetsuJikoSenkyoDac() {
    }

    /**
     * 指定したパラメータに該当する検索結果用データすべて取得します（個人）。
     *
     * @param param KobetsuJikoSenkyoFinderParameter
     * @return {@link KobetsuJikoSenkyoEntity}のインスタンス
     */
    @Transaction
    public List<KobetsuJikoSenkyoEntity> select(KobetsuJikoSenkyoFinderParameter param) {
        requireNonNull(param.getKijunbi(), UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        requireNonNull(param.getShikibetsuCodes(), UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.mapper = session.getMapper(IKobetsuJikoSenkyoMapper.class);
        List<KobetsuJikoSenkyoEntity> result = mapper.select(param);
        return result == null || result.isEmpty() ? Collections.EMPTY_LIST : result;
    }

}
