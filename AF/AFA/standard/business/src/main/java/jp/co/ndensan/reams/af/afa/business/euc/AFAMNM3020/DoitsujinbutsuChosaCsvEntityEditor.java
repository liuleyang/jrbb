/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.euc.afamnm3020;

import jp.co.ndensan.reams.af.afa.definition.core.doitsujinbutsuchosa.enumeratedtype.DoitsujinbutsuChosaRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.entity.db.relate.doitsujinbutsuchosa.DoitsujinbutsuChosaEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afabtm107.DoitsujinbutsuChosaCsvEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 同一人物調査の出力該当CSV対応作成クラスです。
 *
 * @reamsid_L AF-0690-020 wanghj
 */
public final class DoitsujinbutsuChosaCsvEntityEditor {

    private final DoitsujinbutsuChosaCsvEntity csvEntity;

    /**
     * コンストラクス。
     *
     */
    public DoitsujinbutsuChosaCsvEntityEditor() {
        this.csvEntity = new DoitsujinbutsuChosaCsvEntity();
    }

    /**
     * usualProcessCount
     *
     * @param current TohyoJokyoInfoEntity
     * @return TohyoJokyoCsvEntity
     */
    public DoitsujinbutsuChosaCsvEntity usualProcess(DoitsujinbutsuChosaEntity current) {
        createEntity(current);
        return csvEntity;
    }

    /**
     * 年代別投票率集計表CSVクラスを編集する。
     *
     * @param current DoitsujinbutsuChosaEntity
     * @return DoitsujinbutsuChosaCsvEntity 年代別投票率集計表CSVクラス
     */
    public DoitsujinbutsuChosaCsvEntity createEntity(DoitsujinbutsuChosaEntity current) {
        csvEntity.set抄本番号(new RString(current.get抄本番号().getColumnValue()));
        csvEntity.set識別コード(null == current.get識別コード() ? RString.EMPTY : current.get識別コード().getColumnValue());
        csvEntity.set氏名(current.get名称());
        csvEntity.setカナ氏名(current.getカナ名称());
        csvEntity.set生年月日(create年月日(current.get生年月日()));
        csvEntity.set性別(current.get性別コード());
        if (DoitsujinbutsuChosaRStringEnum.性別コード_男.getKey().equals(current.get性別コード())) {
            csvEntity.set性別名称(DoitsujinbutsuChosaRStringEnum.性別_男.getKey());
        } else if (DoitsujinbutsuChosaRStringEnum.性別コード_女.getKey().equals(current.get性別コード())) {
            csvEntity.set性別名称(DoitsujinbutsuChosaRStringEnum.性別_女.getKey());
        }
        csvEntity.set全国住所コード(current.get住登内町域コード());
        csvEntity.set住所(current.get住登内住所());
        csvEntity.set番地(null == current.get住登内番地() ? RString.EMPTY : current.get住登内番地().getColumnValue());
        csvEntity.set方書(null == current.get住登内方書() ? RString.EMPTY : current.get住登内方書().getColumnValue());
        csvEntity.set番地コード1(null == current.get住登内番地コード1() ? RString.EMPTY : current.get住登内番地コード1().getColumnValue());
        csvEntity.set番地コード2(null == current.get住登内番地コード2() ? RString.EMPTY : current.get住登内番地コード2().getColumnValue());
        csvEntity.set番地コード3(null == current.get住登内番地コード3() ? RString.EMPTY : current.get住登内番地コード3().getColumnValue());
        csvEntity.set番地コード4(null == current.get住登内番地コード4() ? RString.EMPTY : current.get住登内番地コード4().getColumnValue());
        csvEntity.setグループコード(current.getグループコード());
        csvEntity.set選挙人名簿投票区コード(current.get選挙人名簿投票区コード());
        csvEntity.set冊(current.get冊());
        csvEntity.set頁(new RString(current.get頁()));
        csvEntity.set行(new RString(current.get行()));
        csvEntity.set選挙人名簿履歴番号(current.get選挙人名簿履歴番号());
        if (current.is投票区変更抹消フラグ()) {
            csvEntity.set投票区変更抹消フラグ(DoitsujinbutsuChosaRStringEnum.フラグ_True.getKey());
        } else {
            csvEntity.set投票区変更抹消フラグ(DoitsujinbutsuChosaRStringEnum.フラグ_False.getKey());
        }
        csvEntity.set連番(new RString(current.get連番()));
        csvEntity.set枝番(new RString(current.get枝番()));
        csvEntity.set選挙種類(current.get選挙種類());
        csvEntity.set選挙種類名称(new RString(SennkyoSikakuShurui.toValue(current.get選挙種類()).toString()));

        csvEntity.set選挙資格履歴番号(current.get選挙資格履歴番号());
        csvEntity.set選挙資格区分(current.get選挙資格区分());
        if (SennkyoSikakuShurui.憲法改正国民投票.value().equals(current.get選挙種類())) {
            csvEntity.set選挙資格区分名称(createCodeMaster名称(current.get選挙資格区分(),
                    DoitsujinbutsuChosaRStringEnum.選挙資格区分_憲法改正国民投票の場合_コード種別.getKey()));
            csvEntity.set表示事由名称(createCodeMaster名称(current.get表示事由コード(),
                    DoitsujinbutsuChosaRStringEnum.表示事由コード区分_憲法改正国民投票の場合_コード種別.getKey()));
            csvEntity.set登録事由名称(createCodeMaster名称(current.get登録事由コード(),
                    DoitsujinbutsuChosaRStringEnum.登録事由コード区分_憲法改正国民投票の場合_コード種別.getKey()));
            csvEntity.set抹消事由名称(createCodeMaster名称(current.get抹消事由コード(),
                    DoitsujinbutsuChosaRStringEnum.抹消事由コード区分_憲法改正国民投票の場合_コード種別.getKey()));
        } else {
            csvEntity.set選挙資格区分名称(createCodeMaster名称(current.get選挙資格区分(),
                    DoitsujinbutsuChosaRStringEnum.選挙資格区分_憲法改正国民投票以外の場合_コード種別.getKey()));
            csvEntity.set表示事由名称(createCodeMaster名称(current.get表示事由コード(),
                    DoitsujinbutsuChosaRStringEnum.表示事由コード区分_憲法改正国民投票以外の場合_コード種別.getKey()));
            csvEntity.set登録事由名称(createCodeMaster名称(current.get登録事由コード(),
                    DoitsujinbutsuChosaRStringEnum.登録事由コード区分_憲法改正国民投票以外の場合_コード種別.getKey()));
            csvEntity.set抹消事由名称(createCodeMaster名称(current.get抹消事由コード(),
                    DoitsujinbutsuChosaRStringEnum.抹消事由コード区分_憲法改正国民投票以外の場合_コード種別.getKey()));
        }
        csvEntity.set選挙資格投票区コード(current.get選挙資格投票区コード());
        csvEntity.set名簿登録年月日(create年月日(current.get名簿登録年月日()));
        csvEntity.set登録事由コード(current.get登録事由コード());
        csvEntity.set登録停止年月日(create年月日(current.get登録停止年月日()));
        csvEntity.set登録停止事由コード(current.get登録停止事由コード());
        csvEntity.set登録停止事由名称(createCodeMaster名称(current.get登録停止事由コード(),
                DoitsujinbutsuChosaRStringEnum.登録停止事由_コード種別.getKey()));
        csvEntity.set表示年月日(create年月日(current.get表示年月日()));
        csvEntity.set表示事由コード(current.get表示事由コード());
        csvEntity.set表示消除年月日(create年月日(current.get表示消除年月日()));
        csvEntity.set表示消除予定年月日(create年月日(current.get表示消除予定年月日()));
        csvEntity.set抹消年月日(create年月日(current.get抹消年月日()));
        csvEntity.set抹消事由コード(current.get抹消事由コード());
        if (current.is刑持ちフラグ()) {
            csvEntity.set刑持ちフラグ(DoitsujinbutsuChosaRStringEnum.フラグ_True.getKey());
        } else {
            csvEntity.set刑持ちフラグ(DoitsujinbutsuChosaRStringEnum.フラグ_False.getKey());
        }
        csvEntity.set投票資格種類(current.get投票資格種類());
        csvEntity.set投票資格種類名称(createCodeMaster名称(current.get投票資格種類(),
                DoitsujinbutsuChosaRStringEnum.投票資格種類_コード種別.getKey()));
        csvEntity.set不在者投票資格履歴番号(current.get不在者投票資格履歴番号());
        csvEntity.set交付年月日(create年月日(current.get交付年月日()));
        csvEntity.set交付番号(current.get交付番号());
        csvEntity.set資格登録年月日(create年月日(current.get資格登録年月日()));
        csvEntity.set資格満了年月日(create年月日(current.get資格満了年月日()));
        csvEntity.set資格抹消年月日(create年月日(current.get資格抹消年月日()));
        csvEntity.set資格抹消事由コード(current.get資格抹消事由コード());
        csvEntity.set資格抹消事由名称(createCodeMaster名称(current.get資格抹消事由コード(),
                DoitsujinbutsuChosaRStringEnum.資格抹消事由_コード種別.getKey()));
        AccessLogger.log(AccessLogType.照会, PersonalData.of(current.get識別コード()));
        return csvEntity;
    }

    private RString createCodeMaster名称(RString 事由コード, RString コード種別) {
        if (null != 事由コード && !事由コード.isEmpty()) {
            return CodeMaster.getCode(SubGyomuCode.AFA選挙本体,
                    new CodeShubetsu(コード種別),
                    new Code(事由コード)).getコード名称();
        }
        return RString.EMPTY;
    }

    private RString create年月日(FlexibleDate 年月日) {
        if (null != 年月日) {
            return 年月日.wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
}
