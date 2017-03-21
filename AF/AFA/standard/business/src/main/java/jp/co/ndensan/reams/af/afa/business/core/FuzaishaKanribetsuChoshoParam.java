/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 不在者投票管理者別の調書帳票出力の帳票用対象クラスです。
 *
 * @reamsid_L AF-0280-035 lit
 */
@lombok.Setter
@lombok.Getter
public class FuzaishaKanribetsuChoshoParam {

    private RString 投票区コード = RString.EMPTY;
    private Decimal 属する市町村数 = Decimal.ZERO;
    private Decimal 業務地又は旅行地数 = Decimal.ZERO;
    private Decimal 船長数 = Decimal.ZERO;
    private Decimal 施設数 = Decimal.ZERO;
    private Decimal 監獄数 = Decimal.ZERO;
    private Decimal 少年院数 = Decimal.ZERO;
    private Decimal 特定国外数 = Decimal.ZERO;
    private ZenjitsuCommonJohoItem commonHeader;
    private ZenjitsuPrintEntity entity;
    private AFABTE504SelectProcessParameter param;

    /**
     * 合計を返す。
     *
     * @return 合計
     */
    public Decimal get合計() {
        return 属する市町村数
                .add(業務地又は旅行地数)
                .add(船長数)
                .add(施設数)
                .add(監獄数)
                .add(少年院数)
                .add(特定国外数);
    }

    /**
     * 変数の設定です。
     *
     */
    public void setHensu() {
        if (投票区コード.isNullOrEmpty()) {
            属する市町村数 = Decimal.ZERO;
        }
        if (commonHeader == null) {
            属する市町村数 = Decimal.ZERO;
        }
        if (entity == null) {
            属する市町村数 = Decimal.ZERO;
        }
        if (param == null) {
            属する市町村数 = Decimal.ZERO;
        }
    }
}
