/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 2号資格候補者一覧表を格納するクラスです。
 *
 * @reamsid_L AF-0360-063 fulc
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NigoShikakuKohoshaListEntity {

    private int senkyoCount;
    private RString senkyoName;
    private RString 集計;
    private boolean 出力区分_集計行;
    private boolean 出力区分_空白行;
    private AfT100ShohonEntity shohonEntity;
    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoEntity;
}
