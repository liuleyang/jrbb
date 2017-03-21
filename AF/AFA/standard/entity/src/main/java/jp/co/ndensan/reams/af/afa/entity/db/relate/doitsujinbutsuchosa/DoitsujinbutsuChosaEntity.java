/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.doitsujinbutsuchosa;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 同一人物調査Entity。
 *
 * @reamsid_L AF-0690-020 wanghj
 */
@lombok.Getter
@lombok.Setter
public class DoitsujinbutsuChosaEntity implements IDbAccessable, Serializable {

    private ShikibetsuCode 識別コード;
    private RString 名称;
    private RString 名称前;
    private RString 名称後;
    private RString カナ名称;
    private RString カナ名称前;
    private RString カナ名称後;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 住登内町域コード;
    private RString 住登内住所;
    private AtenaBanchi 住登内番地;
    private Katagaki 住登内方書;
    private BanchiCode 住登内番地コード1;
    private BanchiCode 住登内番地コード2;
    private BanchiCode 住登内番地コード3;
    private BanchiCode 住登内番地コード4;
    private ShohonNo 抄本番号;
    private RString グループコード;
    private RString 選挙人名簿投票区コード;
    private RString 冊;
    private int 頁;
    private int 行;
    private RString 選挙人名簿履歴番号;
    private boolean 投票区変更抹消フラグ;
    private int 連番;
    private int 枝番;
    private RString 選挙種類;
    private RString 選挙資格履歴番号;
    private RString 選挙資格区分;
    private RString 選挙資格投票区コード;
    private FlexibleDate 名簿登録年月日;
    private RString 登録事由コード;
    private FlexibleDate 登録停止年月日;
    private RString 登録停止事由コード;
    private FlexibleDate 表示年月日;
    private RString 表示事由コード;
    private FlexibleDate 表示消除年月日;
    private FlexibleDate 表示消除予定年月日;
    private FlexibleDate 抹消年月日;
    private RString 抹消事由コード;
    private FlexibleDate 刑期終了年月日;
    private boolean 刑持ちフラグ;
    private RString 投票資格種類;
    private RString 不在者投票資格履歴番号;
    private FlexibleDate 交付年月日;
    private RString 交付番号;
    private FlexibleDate 資格登録年月日;
    private FlexibleDate 資格満了年月日;
    private FlexibleDate 資格抹消年月日;
    private RString 資格抹消事由コード;
}
