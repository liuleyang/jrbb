/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.FuzaishaKanribetsuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 不在者投票管理者別の調書帳票出力のキーブレイクの処理を行うクラスです。
 *
 * @reamsid_L AF-0280-035 lit
 */
public class FuzaishaKanribetsuChoshoBreakCore {

    private Decimal 属する市町村数 = Decimal.ZERO;
    private Decimal 業務地又は旅行地数 = Decimal.ZERO;
    private Decimal 船長数 = Decimal.ZERO;
    private Decimal 施設数 = Decimal.ZERO;
    private Decimal 監獄数 = Decimal.ZERO;
    private Decimal 少年院数 = Decimal.ZERO;
    private Decimal 特定国外数 = Decimal.ZERO;
    private List<FuzaishaKanribetsuChoshoParam> dataList = new ArrayList<>();
    private final ZenjitsuCommonJohoItem 帳票共通ヘッダー;
    private final AFABTE504SelectProcessParameter parameter;

    /**
     * コンストラクス。
     *
     * @param parameter AFABTE504SelectProcessParameter
     */
    public FuzaishaKanribetsuChoshoBreakCore(AFABTE504SelectProcessParameter parameter) {
        帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        this.parameter = parameter;
    }

    /**
     * usualProcess
     *
     * @param current current
     */
    public void usualProcess(ZenjitsuPrintEntity current) {
        if (null == current) {
            return;
        }

        Code 施設種別 = current.get施設Entity().getShisetsuShubetsu();
        if (ShisetsuShubetsu.一般_本庁.getCode().equals(施設種別.value())
                || ShisetsuShubetsu.一般_支所.getCode().equals(施設種別.value())
                || ShisetsuShubetsu.郵便.getCode().equals(施設種別.value())) {
            属する市町村数 = 属する市町村数.add(Decimal.ONE);

        } else if (ShisetsuShubetsu.住民投票.getCode().equals(施設種別.value())) {
            業務地又は旅行地数 = 業務地又は旅行地数.add(Decimal.ONE);
        } else if (ShisetsuShubetsu.船舶.getCode().equals(施設種別.value())) {
            船長数 = 船長数.add(Decimal.ONE);
        } else if (ShisetsuShubetsu.病院.getCode().equals(施設種別.value())
                || ShisetsuShubetsu.施設.getCode().equals(施設種別.value())
                || ShisetsuShubetsu.他施設.getCode().equals(施設種別.value())) {
            施設数 = 施設数.add(Decimal.ONE);
        } else if (ShisetsuShubetsu.刑事施設等.getCode().equals(施設種別.value())) {
            監獄数 = 監獄数.add(Decimal.ONE);
        } else if (ShisetsuShubetsu.少年院等.getCode().equals(施設種別.value())) {
            少年院数 = 少年院数.add(Decimal.ONE);
        } else if (ShisetsuShubetsu.特定国外派遣組織.getCode().equals(施設種別.value())) {
            特定国外数 = 特定国外数.add(Decimal.ONE);
        }
    }

    /**
     * keyBreakProcess
     *
     * @param before before
     * @param current current
     * @return FuzaishaKanribetsuChoshoParam FuzaishaKanribetsuChoshoParam
     */
    public List<FuzaishaKanribetsuChoshoParam> keyBreakProcess(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {
        List<FuzaishaKanribetsuChoshoParam> resultList = new ArrayList<>();
        FuzaishaKanribetsuChoshoParam data;
        if (isNewPage(before, current)) {
            data = createData(before);
            dataList.add(data);
            dataList.add(get合計(before));
            for (FuzaishaKanribetsuChoshoParam target : dataList) {
                resultList.add(target);
            }
            clearCount();
            clearDataList();
        } else if (isNewData(before, current)) {
            data = createData(before);
            dataList.add(data);
            clearCount();
        }

        return resultList;
    }

    private FuzaishaKanribetsuChoshoParam get合計(ZenjitsuPrintEntity entity) {
        FuzaishaKanribetsuChoshoParam 合計 = new FuzaishaKanribetsuChoshoParam();
        for (FuzaishaKanribetsuChoshoParam data : dataList) {
            合計.set投票区コード(new RString("計"));
            合計.set属する市町村数(合計.get属する市町村数().add(data.get属する市町村数()));
            合計.set業務地又は旅行地数(合計.get業務地又は旅行地数().add(data.get業務地又は旅行地数()));
            合計.set船長数(合計.get船長数().add(data.get船長数()));
            合計.set施設数(合計.get施設数().add(data.get施設数()));
            合計.set監獄数(合計.get監獄数().add(data.get監獄数()));
            合計.set少年院数(合計.get少年院数().add(data.get少年院数()));
            合計.set特定国外数(合計.get特定国外数().add(data.get特定国外数()));
            合計.setCommonHeader(帳票共通ヘッダー);
            合計.setEntity(entity);
            合計.setParam(parameter);
        }
        return 合計;
    }

    private void clearCount() {
        属する市町村数 = Decimal.ZERO;
        業務地又は旅行地数 = Decimal.ZERO;
        船長数 = Decimal.ZERO;
        施設数 = Decimal.ZERO;
        監獄数 = Decimal.ZERO;
        少年院数 = Decimal.ZERO;
        特定国外数 = Decimal.ZERO;
    }

    private void clearDataList() {
        dataList = new ArrayList<>();
    }

    private FuzaishaKanribetsuChoshoParam createData(ZenjitsuPrintEntity entity) {
        FuzaishaKanribetsuChoshoParam data = new FuzaishaKanribetsuChoshoParam();
        data.set投票区コード(entity.get選挙人名簿Entity().getTohyokuCode());
        data.set属する市町村数(属する市町村数);
        data.set業務地又は旅行地数(業務地又は旅行地数);
        data.set船長数(船長数);
        data.set施設数(施設数);
        data.set監獄数(監獄数);
        data.set少年院数(少年院数);
        data.set特定国外数(特定国外数);
        data.setCommonHeader(帳票共通ヘッダー);
        data.setEntity(entity);
        data.setParam(parameter);
        return data;
    }

    /**
     * NewDataかどうか。
     *
     * @param before before
     * @param current current
     * @return NewDataかどうか
     */
    protected boolean isNewData(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        if (null == current) {
            return true;
        }

        RString 投票区コード前 = before.get選挙人名簿Entity().getTohyokuCode();
        RString 投票区コード現 = current.get選挙人名簿Entity().getTohyokuCode();

        return !(null != 投票区コード前 && null != 投票区コード現 && 投票区コード前.equals(投票区コード現));
    }

    /**
     * NewPageかどうか。
     *
     * @param before before
     * @param current current
     * @return New合計かどうか
     */
    protected boolean isNewPage(ZenjitsuPrintEntity before, ZenjitsuPrintEntity current) {

        if (null == current) {
            return true;
        }

        SenkyoNo 選挙番号前 = before.get選挙Entity().getSenkyoNo();
        SenkyoNo 選挙番号現 = current.get選挙Entity().getSenkyoNo();

        return !(null != 選挙番号前 && null != 選挙番号現 && 選挙番号前.equals(選挙番号現));
    }
}
