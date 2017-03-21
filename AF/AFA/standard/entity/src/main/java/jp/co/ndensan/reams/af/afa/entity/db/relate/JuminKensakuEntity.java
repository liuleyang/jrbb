/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索結果用Entityクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuminKensakuEntity {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;

    private RString satsu; //冊

    private int page; //頁

    private int gyo; //行

    private Code senkyoShurui; //選挙種類

    private Code shikakuKubun; //選挙資格区分

    private RString tohyokuCode; //投票区コード

    private FlexibleDate meiboTorokuYMD; //名簿登録年月日

    private FlexibleDate hyojiYMD; //表示年月日

    private Code hyojiJiyuCode; //表示事由コード

    private FlexibleDate masshoYMD; //抹消年月日

    private Code masshoJiyuCode; //抹消事由コード

    private int shinseiNo; //申請番号

    private Code tohyoShikakuShurui; //投票資格種類
}
