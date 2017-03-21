/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 転出転入日を格納するEntityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TenshutsuTennyuYmdEntity implements Serializable {

    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate tenshutsuYmd;
    private FlexibleDate tennyuYmd;

    /**
     * 転出日と転入日を返します。
     *
     * @return List<FlexibleDate> 転出日と転入日のList
     */
    public List<FlexibleDate> get転出転入日() {
        return Arrays.asList(tenshutsuYmd, tennyuYmd);
    }
}
