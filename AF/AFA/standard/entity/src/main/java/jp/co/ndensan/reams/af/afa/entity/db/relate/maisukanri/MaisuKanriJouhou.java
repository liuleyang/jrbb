/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.maisukanri;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT251TohyoYoshiMaisuKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票用紙枚数管理情報
 *
 * @reamsid_L AF-0660-010 zhanggs
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MaisuKanriJouhou implements Serializable {

    private static final long serialVersionUID = 351900586803745749L;

    private ShohonNo 抄本番号;
    private RString 選挙種類;
    private SenkyoNo 選挙番号;
    private RString 投票区コード;
    private int 投票用紙枚数;
    private int 点字投票用紙枚数;
    private int 仮投票用封筒枚数;
    private AfT251TohyoYoshiMaisuKanriEntity afT251Entity;

}
