/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.persistence.mapper;

import java.util.List;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;
import jp.co.ndensan.reams.af.afx.entity.renkeijuki.KobetsuJikoSenkyoEntity;

/**
 * 個別記載事項情報を検索するMapperI/Fです
 *
 * @author
 */
public interface IKobetsuJikoSenkyoMapper {

    /**
     * パラメータに合致する個別事項選挙のリストを取得します。
     *
     * @param param 個別事項選挙検索パラメータ
     * @return KobetsuJikoSenkyoEntityの{@code list}
     */
    List<KobetsuJikoSenkyoEntity> select(KobetsuJikoSenkyoFinderParameter param);

}
