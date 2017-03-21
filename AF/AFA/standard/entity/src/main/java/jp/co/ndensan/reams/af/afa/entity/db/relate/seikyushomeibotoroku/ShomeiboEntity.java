/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.seikyushomeibotoroku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本と選挙情報の検索結果のクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
@lombok.Getter
@lombok.Setter
public class ShomeiboEntity {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private AfT403ShomeiboEntity afT403ShomeiboEntity;
    private int seikyuNo;
    private RString satsu;
    private int page;
    private int gyo;
    private Code shinsaKubun;
    private Code mukoJiyuCode;
    private FlexibleDate shomeiYMD;
    private ShikibetsuCode shomeishaShikibetsuCode;
    private AtenaMeisho kanjiShimei;
    private AtenaKanaMeisho kanaShimei;
    private AtenaKanaMeisho searchKanaShimei;
    private FlexibleDate seinengappiYMD;
    private RString seibetsuCode;
    private AtenaJusho jusho;
    private ShikibetsuCode daihitsushaShikibetsuCode;
    private AtenaMeisho daihitsushaKanjiShimei;
    private FlexibleDate daihitsushaSeinengappiYMD;
    private RString daihitsushaSeibetsuCode;
    private AtenaJusho daihitsushaJusho;
    private Code shikakuKubun;
    private RString tohyokuCode;
    private RString tohyokuName;
    private RString tohyojoCode;
    private RString tohyojoName;
    private ChoikiCode jutonaiChoikiCode;
    private RString jutonaiJusho;
    private int nenrei;
    private RString nendai;
    private Integer yukenshasuMan;
    private Integer yukenshasuWoman;
    private Integer yukosuMan;
    private Integer yukosuWoman;
    private Integer mukosuMan;
    private Integer mukosuWoman;
    private Integer mukoJiyu01;
    private Integer mukoJiyu02;
    private Integer mukoJiyu03;
    private Integer mukoJiyu04;
    private Integer mukoJiyu05;
    private Integer mukoJiyu06;
    private Integer mukoJiyu07;
    private Integer mukoJiyu08;
    private Integer mukoJiyu09;
    private Integer mukoJiyu10;
    private Integer mukoJiyu11;
    private Integer mukoJiyu12;
    private Integer mukoJiyu13;
    private Integer mukoJiyu14;
    private Integer mukoJiyu15;
    private Integer mukoJiyu16;
    private Integer mukoJiyu17;
    private Integer mukoJiyu18;

}
