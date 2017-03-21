/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.taishodatecommon;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 「転出日」に関して,共通設定する
 *
 * @reamsid_L AF-0160-020 lishang
 */
public class TaishoDateCommon {

    /**
     * コンストラクタ
     *
     */
    public TaishoDateCommon() {
    }

    /**
     * 転出日の設定する
     *
     * @param 宛名PSM情報 宛名PSM情報
     * @return 転出日
     */
    public FlexibleDate get共通化对象日付(UaFt200FindShikibetsuTaishoEntity 宛名PSM情報) {
        FlexibleDate 共通化对象日付 = FlexibleDate.MIN;
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.消除年月日検索基準, SubGyomuCode.AFA選挙本体);
        FlexibleDate 消除届出年月日 = FlexibleDate.EMPTY;
        FlexibleDate 消除異動年月日 = FlexibleDate.EMPTY;
        if (宛名PSM情報 != null) {
            消除届出年月日 = 宛名PSM情報.getShojoTodokedeYMD();
            消除異動年月日 = 宛名PSM情報.getShojoIdoYMD();
        }
        if (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準)) {
            if (消除届出年月日 != null
                    && !消除届出年月日.isEmpty()) {
                共通化对象日付 = 消除届出年月日;
            } else if (消除異動年月日 != null
                    && !消除異動年月日.isEmpty()) {
                共通化对象日付 = 消除異動年月日;
            } else {
                共通化对象日付 = FlexibleDate.MIN;
            }

        } else if (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準)) {
            if (消除異動年月日 != null
                    && !消除異動年月日.isEmpty()) {
                共通化对象日付 = 消除異動年月日;
            } else if (消除届出年月日 != null
                    && !消除届出年月日.isEmpty()) {
                共通化对象日付 = 消除届出年月日;
            } else {
                共通化对象日付 = FlexibleDate.MIN;
            }
        }
        return 共通化对象日付;
    }

}
