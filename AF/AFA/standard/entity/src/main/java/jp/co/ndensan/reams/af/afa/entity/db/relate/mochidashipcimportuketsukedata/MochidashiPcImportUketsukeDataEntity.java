/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipcimportuketsukedata;

import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 当日受付データ取込情報Entityクラスです。
 *
 * @reamsid_L AF-0795-020 chenh
 */
@lombok.Getter
@lombok.Setter
public class MochidashiPcImportUketsukeDataEntity {

    private RString 投票状況１;
    private RString 投票状況２;
    private RString 投票状況３;
    private RString 投票状況４;
    private RString 投票状況５;
    private RString 投票状況６;
    private RString 投票状況７;
    private RString 投票状況８;
    private RString 投票状況９;
    private SenkyoNo 選挙番号;
    private RString 識別コード;
    private ShohonNo 抄本番号;
    private RString 投票事由コード;
    private FlexibleDate 請求年月日;
    private RString 請求方法;
    private RString 受付番号;
    private FlexibleDate 交付年月日;
    private RTime 交付時刻;
    private RString 交付方法;
    private RString 施設コード;
    private FlexibleDate 受理年月日;
    private RTime 受理時刻;
    private RString 受理方法;
    private RString 受理施設種別;
    private FlexibleDate 返還年月日;
    private RString 点字フラグ;
    private RString 代理投票有フラグ;
    private RString 補助者氏名1;
    private RString 補助者氏名2;
    private RString 証明書出力フラグ;
    private RString 論理削除行FLG;
    private RString update回数;
    private RString 行挿入日時;
    private RString 行挿入ログインid;
    private RString 最終Update日時;
    private RString 最終Updateログインid;
    private ShohonNo 投票状況抄本番号;
    private Code 投票状況;
}
