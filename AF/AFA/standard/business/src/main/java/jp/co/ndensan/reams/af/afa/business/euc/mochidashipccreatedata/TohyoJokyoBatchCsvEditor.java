/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.mochidashipccreatedata;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipccreatedata.TohyoJokyoInfoEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.mochidashipccreatedata.TohyoJokyoCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抄本ファイル出力のバッチの処理を行うクラスです。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public class TohyoJokyoBatchCsvEditor {

    private final TohyoJokyoCsvEntity data;
    private final MochidashiPcCommonUtil common;

    /**
     * コンストラクス。
     *
     */
    public TohyoJokyoBatchCsvEditor() {
        common = MochidashiPcCommonUtil.createInstance();
        data = new TohyoJokyoCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current TohyoJokyoInfoEntity
     * @return TohyoJokyoCsvEntity
     */
    public TohyoJokyoCsvEntity usualProcess(TohyoJokyoInfoEntity current) {
        tohyoJokyoセット(current);
        return data;
    }

    /**
     * keyBreakProcessByShohonNo
     *
     * @param before TohyoJokyoInfoEntity
     * @param current TohyoJokyoInfoEntity
     * @return Boolean
     */
    public Boolean keyBreakProcessByShohonNo(TohyoJokyoInfoEntity before, TohyoJokyoInfoEntity current) {
        return isNew抄本(before, current);
    }

    /**
     * keyBreakProcessByTohyoku
     *
     * @param before TohyoJokyoInfoEntity
     * @param current TohyoJokyoInfoEntity
     * @return Boolean
     */
    public Boolean keyBreakProcessByTohyoku(TohyoJokyoInfoEntity before, TohyoJokyoInfoEntity current) {
        return isNew投票区コード(before, current);
    }

    /**
     * createLastProcess
     *
     * @return TohyoJokyoCsvEntity
     */
    public TohyoJokyoCsvEntity createLastProcess() {
        return null;
    }

    /**
     * 抄本判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew抄本(TohyoJokyoInfoEntity before, TohyoJokyoInfoEntity current) {
        if (null == before) {
            return false;
        }
        ShohonNo 抄本前 = before.get抄本Entity().getShohonNo();
        ShohonNo 抄本現 = current.get抄本Entity().getShohonNo();

        return !(null != 抄本前 && null != 抄本現 && 抄本前.equals(抄本現));

    }

    /**
     * 投票区判断。
     *
     * @param before before
     * @param current current
     * @return boolean
     */
    private boolean isNew投票区コード(TohyoJokyoInfoEntity before, TohyoJokyoInfoEntity current) {
        if (null == before) {
            return false;
        }
        RString 投票区前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区前 && null != 投票区現 && 投票区前.equals(投票区現));

    }

    private void tohyoJokyoセット(TohyoJokyoInfoEntity current) {
        data.set抄本番号(common.toRString(current.get投票状況Entity().getShohonNo()));
        data.set選挙番号(common.toRString(current.get投票状況Entity().getSenkyoNo()));
        data.setグループコード(current.get選挙人名簿Entity().getGroupCode());
        data.set投票区コード(current.get選挙人名簿Entity().getTohyokuCode());
        data.set冊(current.get選挙人名簿Entity().getSatsu());
        data.set頁(common.toRString(current.get選挙人名簿Entity().getPage()));
        data.set行(common.toRString(current.get選挙人名簿Entity().getGyo()));
        data.set住民コード(common.toRString(current.get投票状況Entity().getShikibetsuCode()));
        data.set請求年月日(common.toRString(current.get投票状況Entity().getSeikyuYMD()));
        data.set請求方法(common.toRString(current.get投票状況Entity().getSeikyuHoho()));
        data.set請求事由(common.toRString(current.get投票状況Entity().getTohyoJiyuCode()));
        data.set交付表示(common.toRString(current.get投票状況Entity().getTohyoJokyo()));
        data.set交付年月日(common.toRString(current.get投票状況Entity().getKofuYMD()));
        data.set交付時刻(common.toRString(current.get投票状況Entity().getKofuTime()));
        if (null != current.get施設Entity()) {
            data.set交付区分(common.toRString(current.get施設Entity().getShisetsuShubetsu()));
        }
        data.set交付受付番号(common.toRString(current.get投票状況Entity().getUketsukeNo()));
        data.set交付方法(common.toRString(current.get投票状況Entity().getKofuHoho()));
        data.set交付施設コード(current.get投票状況Entity().getShisetsuCode());
        data.set点字(new RString(String.valueOf(current.get投票状況Entity().getTenjiFlag())));
        data.set証明書の有無(new RString(String.valueOf(current.get投票状況Entity().getShomeishoPrintFlag())));
        data.set受理表示(common.toRString(current.get投票状況Entity().getTohyoJokyo()));
        data.set受理年月日(common.toRString(current.get投票状況Entity().getJuriYMD()));
        data.set受理時刻(common.toRString(current.get投票状況Entity().getJuriTime()));
        data.set受理方法(common.toRString(current.get投票状況Entity().getJuriHoho()));
        data.set受理施設_投票場所(common.toRString(current.get投票状況Entity().getJuriShisetsuShubetsu()));
        data.set返還年月日(common.toRString(current.get投票状況Entity().getHenkanYMD()));
        data.set返還時刻(RString.EMPTY);
        data.set代理投票区分(new RString(String.valueOf(current.get投票状況Entity().getDairiTohyoAriFlag())));
        data.set補助者1(common.convertTtoRString(common.toRString(current.get投票状況Entity().getHojoshaShimei1())));
        data.set補助者2(common.convertTtoRString(common.toRString(current.get投票状況Entity().getHojoshaShimei2())));
        data.set端末ID(RString.EMPTY);
        data.set削除フラグ(new RString(String.valueOf(current.get投票状況Entity().getIsDeleted())));
        data.set更新カウンタ(common.toRString(current.get投票状況Entity().getUpdateCount()));
        data.set作成日時(common.toRString(current.get投票状況Entity().getInsertTimestamp()));
        data.set作成ユーザ(current.get投票状況Entity().getInsertReamsLoginId());
        data.set更新日時(common.toRString(current.get投票状況Entity().getLastUpdateTimestamp()));
        data.set更新ユーザ(current.get投票状況Entity().getLastUpdateReamsLoginId());
    }

}
