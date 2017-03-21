/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyojokyoDairishaSerachResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo.TohyoJokyoManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TohyorokuKyohiNyuryokuDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してTohyorokuKyohiNyuryokuDivの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0130-012 lit
 */
public class TohyorokuKyohiNyuryokuHandler {

    private final TohyorokuKyohiNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 投票録拒否入力Div
     */
    public TohyorokuKyohiNyuryokuHandler(TohyorokuKyohiNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 指定行数分の空行を作成する。
     *
     * @param 行数
     */
    public void load(int 行数) {
        List<dgTohyorokuKyohiNyuryoku_Row> dataSource = new ArrayList<>();

        for (int i = 1; i <= 行数; i++) {
            dgTohyorokuKyohiNyuryoku_Row row = new dgTohyorokuKyohiNyuryoku_Row();
            row.setTxtShimei(RString.EMPTY);
            row.setTxtJiyu(RString.EMPTY);
            row.setChkKariTohyo(Boolean.FALSE);
            dataSource.add(row);
        }
        div.getDgTohyorokuKyohiNyuryoku().setDataSource(dataSource);
    }

    /**
     * 項目クリアのメソッドです。
     *
     */
    public void clearDataSource() {
        List<dgTohyorokuKyohiNyuryoku_Row> dataSource = div.getDgTohyorokuKyohiNyuryoku().getDataSource();

        for (dgTohyorokuKyohiNyuryoku_Row row : dataSource) {
            row.setTxtShimei(RString.EMPTY);
            row.setTxtJiyu(RString.EMPTY);
            row.setChkKariTohyo(Boolean.FALSE);
        }
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param item
     */
    public void initialize(HashMap item) {
        List<dgTohyorokuKyohiNyuryoku_Row> dataSource = div.getDgTohyorokuKyohiNyuryoku().getDataSource();

        for (dgTohyorokuKyohiNyuryoku_Row row : dataSource) {
            row.setTxtShimei(YamlLoader.getTextBoxText(item, "氏名").getValue());
            row.setTxtJiyu(YamlLoader.getTextBoxText(item, "事由").getValue());
            row.setChkKariTohyo(YamlLoader.getBooleanText(item, "仮投票フラグ"));
            break;
        }
    }

    /**
     * 引数のデータから、この共有子Divの初期表示を行います。
     *
     * @param 抄本番号 抄本番号
     * @param 選挙番号 選挙番号
     * @param 報告年月日 報告年月日
     * @param 代理投票有フラグ 代理投票有フラグ
     * @param 施設コード 施設コード
     * @param 投票区コード 投票区コード
     * @param 投票状況 投票状況（期日前　or　当日）
     */
    public void initialize(
            ShohonNo 抄本番号,
            SenkyoNo 選挙番号,
            FlexibleDate 報告年月日,
            boolean 代理投票有フラグ,
            RString 施設コード,
            RString 投票区コード,
            RString 投票状況) {

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));
        TohyoJokyoManager manager = TohyoJokyoManager.createInstance();
        TohyojokyoMapperParameter parameter
                = TohyojokyoMapperParameter.createParam(抄本番号, 選挙番号, 報告年月日, 施設コード,
                        投票区コード, 投票状況, key.getPSM検索キー());
        parameter.set代理投票有フラグ(代理投票有フラグ);

        List<TohyojokyoDairishaSerachResult> 投票拒否者リスト = manager.get投票拒否者状況一覧(parameter);

        List<dgTohyorokuKyohiNyuryoku_Row> rowList = new ArrayList<>();
        AtenaMeisho 氏名;
        Code 投票状況値;
        for (TohyojokyoDairishaSerachResult 投票拒否者 : 投票拒否者リスト) {
            dgTohyorokuKyohiNyuryoku_Row row = new dgTohyorokuKyohiNyuryoku_Row();
            氏名 = 投票拒否者.getKanjiShimei();
            row.setTxtShimei(null != 氏名 ? 氏名.value() : RString.EMPTY);
            row.setTxtJiyu(投票拒否者.getKyohiJiyu());
            投票状況値 = 投票拒否者.getTohyoJokyo();
            if (null != 投票状況値) {
                row.setChkKariTohyo(投票状況値.value().equals(TohyoJokyo.仮投票.getCode()));
            }
            rowList.add(row);
        }
        div.getDgTohyorokuKyohiNyuryoku().setDataSource(rowList);
    }
}
