/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.business.core.senkyonin.senkyoninmeibo.SenkyoninMeibo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.senkyoninmeibo.SenkyoninMeiboManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public enum KaikuIdoShikakuIdoShoriSpec implements IPredicate<KaikuIdoShikakuIdoShoriDiv> {

    /**
     * 選択された識別コードでデータの存在チェック
     */
    選択された識別コードでデータの存在チェック {

                @Override
                public boolean apply(KaikuIdoShikakuIdoShoriDiv div) {
                    boolean チェック結果 = true;
                    RString 識別コード = ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class);
                    ShohonNo shohonNo = new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo());
                    SenkyoninMeibo senkyoninMeibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(shohonNo, new ShikibetsuCode(識別コード));
                    if (senkyoninMeibo != null) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }

            },
    /**
     * 選択した抄本内で_選択された識別コードでデータの存在チェック
     */
    選択した抄本内で_選択された識別コードでデータの存在チェック {

                @Override
                public boolean apply(KaikuIdoShikakuIdoShoriDiv div) {
                    boolean チェック結果 = true;
                    ShohonNo shohonNo = new ShohonNo(div.getKaikuIdoShikakuJoho().getCcdKaikuIdoKaikuFuzuiJoho().get海区付随資格情報().getCcdShohonNameList().getSelectedShohonNo());
                    RString 識別コード = ViewStateHolder.get(ViewStateKeys.住民検索_資格_識別コード, RString.class);
                    SenkyoninMeibo senkyoninMeibo = SenkyoninMeiboManager.createInstance().getSenkyoninMeiboList(shohonNo, new ShikibetsuCode(識別コード));
                    if (senkyoninMeibo == null) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }

            };
}
