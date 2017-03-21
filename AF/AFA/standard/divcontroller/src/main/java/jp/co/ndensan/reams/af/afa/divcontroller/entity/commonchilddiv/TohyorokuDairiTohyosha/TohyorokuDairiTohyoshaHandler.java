/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuDairiTohyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyojokyoDairishaSerachResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TohyorokuDairiTohyoshaDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyorokuDairiTohyoshaDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0130-011 lit
 */
public class TohyorokuDairiTohyoshaHandler {

    private final TohyorokuDairiTohyoshaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票録代理投票者共有子DIV
     */
    public TohyorokuDairiTohyoshaHandler(TohyorokuDairiTohyoshaDiv div) {
        this.div = div;
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     */
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況) {

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));
        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();

        TohyojokyoMapperParameter parameter
                = TohyojokyoMapperParameter.createParam(抄本番号, 選挙番号, 報告年月日, 施設コード,
                        投票区コード, 投票状況, key.getPSM検索キー());

        List<TohyojokyoDairishaSerachResult> 代理投票者リスト = manager.get代理投票者状況一覧(parameter);

        List<dgTohyorokuDairiTohyosha_Row> rowList = new ArrayList<>();
        AtenaMeisho 氏名;
        for (TohyojokyoDairishaSerachResult 代理投票者 : 代理投票者リスト) {
            dgTohyorokuDairiTohyosha_Row row = new dgTohyorokuDairiTohyosha_Row();
            氏名 = 代理投票者.getKanjiShimei();
            row.setTxtShimei(null != 氏名 ? 氏名.value() : RString.EMPTY);
            氏名 = 代理投票者.getHojoshaShimei1();
            row.setTxtHojosha1(null != 氏名 ? 氏名.value() : RString.EMPTY);
            氏名 = 代理投票者.getHojoshaShimei2();
            row.setTxtHojosha2(null != 氏名 ? 氏名.value() : RString.EMPTY);
            rowList.add(row);
        }
        div.getDgTohyorokuDairiTohyosha().setDataSource(rowList);
    }
}
