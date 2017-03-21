/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KojinJoho;

import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaShokaiSimple.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個人情報共有子divのHandlerクラスです。
 *
 * @reamsid_L AF-0180-014 liuyj
 */
public class KojinJohoHandler {

    private final KojinJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KojinJohoDiv
     */
    public KojinJohoHandler(KojinJohoDiv div) {
        this.div = div;
    }

    /**
     * initializeメソッドです。
     *
     * @param 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード) {
        div.getCcdKojinJohoUR().onChangeDisplayMode二行タイプ();
        IAtesakiGyomuHanteiKey gyomuHanteiKey = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.AF選挙);
        AtenaSearchKeyBuilder builder = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登内優先, gyomuHanteiKey);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set識別コード(識別コード);
        builder.set住所編集方法(JushoKannaiEditPattern.町域番地space方書);
        div.getCcdKojinJohoUR().setNenreiHantei(AgeArrivalDay.前日.code());
        IAtenaSearchKey 検索キー = builder.build();
        div.getCcdKojinJohoUR().load(検索キー);
    }

    /**
     * カナ名称を返します。
     *
     * @return RString カナ名称
     */
    public RString getカナ名称() {
        return ((AtenaShokaiSimpleDiv) div.getCcdKojinJohoUR()).getCcdMeishoHyoji().getカナ名称();
    }

    /**
     * 漢字名称を返します。
     *
     * @return RString 漢字名称
     */
    public RString get漢字名称() {
        return ((AtenaShokaiSimpleDiv) div.getCcdKojinJohoUR()).getCcdMeishoHyoji().get漢字名称();
    }
}
