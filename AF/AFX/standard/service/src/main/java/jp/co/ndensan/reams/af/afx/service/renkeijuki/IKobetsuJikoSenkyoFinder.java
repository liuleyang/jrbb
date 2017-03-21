/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afx.service.renkeijuki;

import java.util.List;
import jp.co.ndensan.reams.af.afx.business.renkeijuki.KobetsuJikoSenkyo;
import jp.co.ndensan.reams.af.afx.definition.mybatis.KobetsuJikoSenkyoFinderParameter;

/**
 * 個別記載事項検索処理のInterfaceです。
 *
 * @author
 */
public interface IKobetsuJikoSenkyoFinder {

    List<KobetsuJikoSenkyo> select(KobetsuJikoSenkyoFinderParameter param);
}
