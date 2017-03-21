/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票日前日関連帳票出力の帳票用対象クラスです。
 *
 * @reamsid_L AF-0280-025 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TohyoShukeiData {

    private int 期日前投票男数 = 0;
    private int 期日前投票女数 = 0;
    private int 不在者投票男数 = 0;
    private int 不在者投票女数 = 0;
    private RString 地区名称 = RString.EMPTY;
    private RString 明細タイトル = RString.EMPTY;
    private int pageCount = 0;

    private AFABTE504SelectProcessParameter param;
    private ZenjitsuCommonJohoItem commonHeader;
    private ZenjitsuPrintEntity entity;
    private int dataType;

}
