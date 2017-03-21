/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1000;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.IdoSearchJuminShikakuDiv;
import jp.co.ndensan.reams.ua.uax.definition.core.KensakuYoShikibetsuCode;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索（資格）のSpecです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public enum IdoSearchJuminShikakuSpec implements IPredicate<IdoSearchJuminShikakuDiv> {

    /**
     * 検索条件入力チェック。
     */
    検索条件入力チェック {
                @Override
                public boolean apply(IdoSearchJuminShikakuDiv div) {
                    IShikibetsuTaishoPSMSearchKey psmSearchKey = div.getIdoSearchJoken()
                    .getCcdIdoSearchJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
                    RString 氏名 = psmSearchKey.get氏名();
                    if (氏名 != null && !氏名.isEmpty()) {
                        return true;
                    }
                    FlexibleDate 生年月日 = psmSearchKey.get生年月日();
                    if (生年月日 != null && !生年月日.isEmpty()) {
                        return true;
                    }
                    AtenaJusho 住所 = psmSearchKey.get町域();
                    if (住所 != null && !住所.isEmpty()) {
                        return true;
                    }
                    if (!psmSearchKey.get世帯コード().isEmpty() && psmSearchKey.get世帯コード() != null) {
                        return true;
                    }
                    KensakuYoShikibetsuCode 識別コード = psmSearchKey.get識別コード();
                    if (識別コード != null && !識別コード.isEmpty()) {
                        return true;
                    }

                    RString 投票区コード = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().getCcdTohyokuCode().get投票区コード();
                    if (投票区コード != null && !投票区コード.isEmpty()) {
                        return true;
                    }

                    List 選挙資格 = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get選挙資格リスト();
                    if (選挙資格 != null && !選挙資格.isEmpty()) {
                        return true;
                    }

                    List 投票資格 = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().get投票資格リスト();

                    return 投票資格 != null && !投票資格.isEmpty();
                }
            },
    /**
     * 住基情報検索条件入力チェック
     */
    住基情報検索条件入力チェック {
                @Override
                public boolean apply(IdoSearchJuminShikakuDiv div) {
                    IShikibetsuTaishoPSMSearchKey psmSearchKey = div.getIdoSearchJoken()
                    .getCcdIdoSearchJukiJoho().makeShikibetsuTaishoSearchKey().getPSMSearchKey();
                    RString 氏名 = psmSearchKey.get氏名();
                    if (氏名 != null && !氏名.isEmpty()) {
                        return true;
                    }
                    RString 氏名分割１ = psmSearchKey.get氏名分割１();
                    if (氏名分割１ != null && !氏名分割１.isEmpty()) {
                        return true;
                    }
                    RString 氏名分割２ = psmSearchKey.get氏名分割２();
                    if (氏名分割２ != null && !氏名分割２.isEmpty()) {
                        return true;
                    }
                    RString 氏名分割３ = psmSearchKey.get氏名分割３();
                    if (氏名分割３ != null && !氏名分割３.isEmpty()) {
                        return true;
                    }
                    FlexibleDate 生年月日 = psmSearchKey.get生年月日();
                    if (生年月日 != null && !生年月日.isEmpty()) {
                        return true;
                    }
                    KensakuYoShikibetsuCode 識別コード = psmSearchKey.get識別コード();
                    if (識別コード != null && !識別コード.isEmpty()) {
                        return true;
                    }
                    if (!psmSearchKey.get世帯コード().isEmpty() && psmSearchKey.get世帯コード() != null) {
                        return true;
                    }
                    RString 投票区コード = div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().getCcdTohyokuCode().get投票区コード();
                    if (投票区コード != null && !投票区コード.isEmpty()) {
                        return true;
                    }
                    return false;
                }
            }

}
