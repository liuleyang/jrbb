/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.searchsimplejumindialog;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索（簡易版）ダイアログ用モデルです。
 *
 * @reamsid_L AF-0170-020 lis
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SearchSimpleJuminModel implements Serializable {

    private ShohonNo 抄本番号;

    private SenkyoShurui 選挙種類;

    private FlexibleDate 基準年月日;

    private List<ShikibetsuCode> 識別コードリスト;

    private List<FindShikibetsuTaishos> 宛名リスト;

    private List<TohyokuCode> 投票区コードリスト;
    
    private List<RString> 選挙資格リスト;  
}
