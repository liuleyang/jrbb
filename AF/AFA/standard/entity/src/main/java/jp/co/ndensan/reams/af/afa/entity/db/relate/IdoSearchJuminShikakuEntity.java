package jp.co.ndensan.reams.af.afa.entity.db.relate;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索（資格）結果用Entityクラスです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoSearchJuminShikakuEntity {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private List<AfT114FuzaishaTohyoShikakuEntity> fuzaishaTohyoShikakuEntity;

    private RString satsu; //冊

    private int page; //頁

    private int gyo; //行

    private Code senkyoShurui; //選挙種類

    private Code shikakuKubun; //選挙資格区分

    private RString tohyokuCode; //投票区コード

    private FlexibleDate meiboTorokuYMD; //登録日

    private Code torokuJiyuCode; //登録事由コード

    private FlexibleDate torokuTeishiYMD; //登録停止日

    private Code torokuTeishiJiyuCode; //登録停止事由コード

    private FlexibleDate hyojiYMD; //表示年月日

    private Code hyojiJiyuCode; //表示事由コード

    private FlexibleDate hyojiShojoYoteiYMD; //消除予定日

    private FlexibleDate hyojiShojoYMD; //表示消除日

    private FlexibleDate masshoYMD; //抹消年月日

    private Code masshoJiyuCode; //抹消事由コード

    private FlexibleDate keikiShuryoYMD; //刑期終了日

    private boolean nikeimochiFlag; //2刑持ちフラグ

    private int shinseiNo; //申請番号

}
