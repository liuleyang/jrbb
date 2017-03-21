/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.afapre520;

import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuData;
import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuListData;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afapre520.NenreibetsuTohyoritsuCsvEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 年齢別投票率集計表の出力該当CSV対応作成クラスです。
 *
 * @reamsid_L AF-0290-036 lit
 */
public final class NenreibetsuTohyoritsuCsvEntityEditor {

    private final TohyoritsuData data;
    private static final int 計算用_除法の百 = 100;

    private NenreibetsuTohyoritsuCsvEntityEditor(TohyoritsuData data) {
        this.data = data;
    }

    /**
     * 年代別投票率集計表CSV編集クラスを作成します。
     *
     * @param data 投票率集計表帳票出力のページ用対象クラス
     * @return NenreibetsuTohyoritsuCsvEntityEditor
     */
    public static NenreibetsuTohyoritsuCsvEntityEditor createInstance(TohyoritsuData data) {
        return new NenreibetsuTohyoritsuCsvEntityEditor(data);
    }

    /**
     * 年代別投票率集計表CSVクラスを編集する。
     *
     * @return NenreibetsuTohyoritsuCsvEntity 年代別投票率集計表CSVクラス
     */
    public NenreibetsuTohyoritsuCsvEntity createEntity() {
        NenreibetsuTohyoritsuCsvEntity csvEntity = new NenreibetsuTohyoritsuCsvEntity();

        TohyoritsuListData 年齢Data = data.get年代Data();
        TohyoritsuListData 当日分Data = data.get当日分Data();
        TohyoritsuListData 期日前不在者分Data = data.get期日前不在者分Data();
        TohyokekkaPrintEntity entity = data.getEntity();
        AFABTE505SelectProcessParameter param = data.getParam();
        IShikibetsuTaisho 宛名対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(entity.get宛名情報Entity());

        csvEntity.set抄本番号(new RString(String.valueOf(param.get抄本番号().value())));
        csvEntity.set抄本名称(entity.get抄本Entity().getShohonName());
        if (null != entity.get選挙Entity()) {
            csvEntity.set選挙番号(new RString(String.valueOf(entity.get選挙Entity().getSenkyoNo().value())));
            csvEntity.set選挙名称(entity.get選挙Entity().getSenkyoName());
        }
        if (null != entity.get選挙人名簿Entity()) {
            csvEntity.set投票区コード(entity.get選挙人名簿Entity().getTohyokuCode());
        }
        if (null != entity.get投票所Entity()) {
            csvEntity.set投票所名(entity.get投票所Entity().getTohyojoName());
        }
        if (null != 宛名対象 && null != 宛名対象.get行政区画()) {
            csvEntity.set行政区コード(宛名対象.get行政区画().getGyoseiku().getコード().value());
            csvEntity.set行政区名(宛名対象.get行政区画().getGyoseiku().get名称());
        }
        csvEntity.set年齢(年齢Data.getラベル());
        csvEntity.set有権者男(new RString(年齢Data.get有権者男数().toString()));
        csvEntity.set有権者女(new RString(年齢Data.get有権者女数().toString()));
        csvEntity.set有権者計(new RString(年齢Data.get有権者数().toString()));
        csvEntity.set投票者男(new RString(年齢Data.get投票者男数().toString()));
        csvEntity.set投票者女(new RString(年齢Data.get投票者女数().toString()));
        csvEntity.set投票者計(new RString(年齢Data.get投票者数().toString()));
        csvEntity.set投票率男(getFormatDivide(年齢Data.get投票者男数(), 年齢Data.get有権者男数()));
        csvEntity.set投票率女(getFormatDivide(年齢Data.get投票者女数(), 年齢Data.get有権者女数()));
        csvEntity.set投票率計(getFormatDivide(年齢Data.get投票者数(), 年齢Data.get有権者数()));
        csvEntity.set当日投票男(new RString(当日分Data.get投票者男数().toString()));
        csvEntity.set当日投票女(new RString(当日分Data.get投票者女数().toString()));
        csvEntity.set当日投票計(new RString(当日分Data.get投票者数().toString()));
        csvEntity.set期日前投票男(new RString(期日前不在者分Data.get期日前投票男().toString()));
        csvEntity.set期日前投票女(new RString(期日前不在者分Data.get期日前投票女().toString()));
        csvEntity.set期日前投票計(new RString(期日前不在者分Data.get期日前投票数().toString()));
        csvEntity.set不在投票者男(new RString(期日前不在者分Data.get不在投票者男().toString()));
        csvEntity.set不在投票者女(new RString(期日前不在者分Data.get不在投票者女().toString()));
        csvEntity.set不在投票者計(new RString(期日前不在者分Data.get不在投票者数().toString()));
        csvEntity.set交付男(new RString(期日前不在者分Data.get交付男().toString()));
        csvEntity.set交付女(new RString(期日前不在者分Data.get交付女().toString()));
        csvEntity.set交付計(new RString(期日前不在者分Data.get交付数().toString()));

        csvEntity.set行政区有権者男数(new RString(data.get行政区別有権者男数().toString()));
        csvEntity.set行政区有権者女数(new RString(data.get行政区別有権者女数().toString()));
        csvEntity.set行政区有権者数(new RString(data.get行政区別有権者数().toString()));
        csvEntity.set投票区有権者男数(new RString(data.get投票区別有権者男数().toString()));
        csvEntity.set投票区有権者女数(new RString(data.get投票区別有権者女数().toString()));
        csvEntity.set投票区有権者数(new RString(data.get投票区別有権者数().toString()));
        csvEntity.set全有権者男数(new RString(data.get選挙別有権者男数().toString()));
        csvEntity.set全有権者女数(new RString(data.get選挙別有権者女数().toString()));
        csvEntity.set全有権者数(new RString(data.get選挙別有権者数().toString()));
        return csvEntity;
    }

    private RString getFormatDivide(Decimal target1, Decimal target2) {
        if (null == target1 || null == target2 || target2.equals(Decimal.ZERO)) {
            return new RString("0.00");
        }
        return new RString(target1.multiply(new Decimal(計算用_除法の百)).divide(target2).roundHalfUpTo(2).toString());
    }
}
