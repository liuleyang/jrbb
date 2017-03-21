/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE8030;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsuFuzaiKubunEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.NumberEdit;
import jp.co.ndensan.reams.af.afa.definition.core.mochidashipcimportuketsukedata.enumeratedtype.MochidashiPcImportUketsukeDataRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.mochidashipcimportuketsukedata.AFABTE803SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.mochidashipcimportuketsukedata.MochidashiPcImportUketsukeDataEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当日受付データ取込バッチ処理クラスです。<br>
 * ファイルを読むには一時表を作る。
 *
 * @reamsid_L AF-0795-020 lis
 */
public class TohyoJokyoInsertOrUpdateProcess extends BatchProcessBase<MochidashiPcImportUketsukeDataEntity> {

    private AFABTE803SelectProcessParameter parameter;
    private AFABTE803SelectProcessMyBatisParameter myBatisParameter;
    private List<ShikibetsuCode> 識別コードリスト;
    @BatchWriter
    private BatchPermanentTableWriter<AfT201TohyoJokyoEntity> tableWriterTohyoJokyo;

    @Override
    protected void initialize() {
        識別コードリスト = new ArrayList<>();
        myBatisParameter = parameter.toAFABTE803SelectProcessMyBatisParameter();
        myBatisParameter.setTable(parameter.getTable());
        myBatisParameter.setTable1(parameter.getTable1());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate."
                + "mochidashipcimportuketsukedata.IMochidashiPcImportUketsukeDataMapper.select当日受付データ取込情報"), myBatisParameter);
    }

    @Override
    protected void createWriter() {
        tableWriterTohyoJokyo = new BatchPermanentTableWriter<>(AfT201TohyoJokyoEntity.class);
    }

    @Override
    protected void process(MochidashiPcImportUketsukeDataEntity entity) {
        Code 投票状況 = get投票状況(entity);
        if (entity.get投票状況抄本番号() == null) {
            tableWriterTohyoJokyo.insert(edit投票状況情報(entity));
        } else if (!投票状況.equals(entity.get投票状況())) {
            tableWriterTohyoJokyo.update(edit投票状況情報(entity));
        }
        識別コードリスト.add(new ShikibetsuCode(entity.get識別コード()));
    }

    @Override
    protected void afterExecute() {
        parameter.set識別コードリスト(識別コードリスト);
    }

    //CHECKSTYLE IGNORE CyclomaticComplexityCheck FOR NEXT 1 LINES
    private AfT201TohyoJokyoEntity edit投票状況情報(MochidashiPcImportUketsukeDataEntity entity) {
        AfT201TohyoJokyoEntity 投票状況情報 = new AfT201TohyoJokyoEntity();
        投票状況情報.setShohonNo(entity.get抄本番号());
        投票状況情報.setShikibetsuCode(entity.get識別コード() == null
                ? ShikibetsuCode.EMPTY : new ShikibetsuCode(entity.get識別コード()));
        投票状況情報.setSenkyoNo(entity.get選挙番号());
        投票状況情報.setTohyoJokyo(get投票状況(entity));
        投票状況情報.setTohyoJiyuCode(RString.isNullOrEmpty(entity.get投票事由コード())
                ? Code.EMPTY : new Code(entity.get投票事由コード()));
        投票状況情報.setSeikyuYMD(entity.get請求年月日() == null
                ? FlexibleDate.EMPTY : entity.get請求年月日());
        投票状況情報.setSeikyuHoho(RString.isNullOrEmpty(entity.get請求方法())
                ? Code.EMPTY : new Code(entity.get請求方法()));
        投票状況情報.setUketsukeNo(RString.isNullOrEmpty(entity.get受付番号()) || !isNumeric(entity.get受付番号())
                ? Integer.MIN_VALUE : Integer.parseInt(entity.get受付番号().toString()));
        投票状況情報.setKofuYMD(entity.get交付年月日() == null
                ? FlexibleDate.EMPTY : entity.get交付年月日());
        投票状況情報.setKofuTime(entity.get交付時刻());
        投票状況情報.setKofuHoho(RString.isNullOrEmpty(entity.get交付方法())
                ? Code.EMPTY : new Code(entity.get交付方法()));
        投票状況情報.setShisetsuCode(entity.get施設コード());
        投票状況情報.setUketoriYMD(FlexibleDate.EMPTY);
        投票状況情報.setJuriYMD(entity.get受理年月日() == null
                ? FlexibleDate.EMPTY : entity.get受理年月日());
        投票状況情報.setJuriTime(entity.get受理時刻());
        投票状況情報.setJuriHoho(RString.isNullOrEmpty(entity.get受理方法())
                ? Code.EMPTY : new Code(entity.get受理方法()));
        投票状況情報.setJuriShisetsuShubetsu(RString.isNullOrEmpty(entity.get受理施設種別())
                ? Code.EMPTY : new Code(entity.get受理施設種別()));
        投票状況情報.setKikenYMD(FlexibleDate.EMPTY);
        投票状況情報.setHenkanYMD(entity.get返還年月日() == null
                ? FlexibleDate.EMPTY : entity.get返還年月日());
        RString 点字 = RString.isNullOrEmpty(entity.get点字フラグ())
                ? RString.EMPTY : entity.get点字フラグ();
        if (MochidashiPcImportUketsukeDataRStringEnum.点字フラグ_0.getKey().equals(点字)) {
            投票状況情報.setTenjiFlag(Boolean.FALSE);
        } else if (MochidashiPcImportUketsukeDataRStringEnum.点字フラグ_1.getKey().equals(点字)) {
            投票状況情報.setTenjiFlag(Boolean.TRUE);
        }
        RString 代理投票 = RString.isNullOrEmpty(entity.get代理投票有フラグ())
                ? RString.EMPTY : entity.get代理投票有フラグ();
        if (MochidashiPcImportUketsukeDataRStringEnum.代理投票区分_0.getKey().equals(代理投票)) {
            投票状況情報.setDairiTohyoAriFlag(Boolean.FALSE);
        } else if (MochidashiPcImportUketsukeDataRStringEnum.代理投票区分_1.getKey().equals(代理投票)) {
            投票状況情報.setDairiTohyoAriFlag(Boolean.TRUE);
        }
        投票状況情報.setHojoshaShikibetsuCode1(ShikibetsuCode.EMPTY);
        投票状況情報.setHojoshaShimei1(RString.isNullOrEmpty(entity.get補助者氏名1())
                ? AtenaMeisho.EMPTY : new AtenaMeisho(entity.get補助者氏名1()));
        投票状況情報.setHojoshaShikibetsuCode2(ShikibetsuCode.EMPTY);
        投票状況情報.setHojoshaShimei2(RString.isNullOrEmpty(entity.get補助者氏名2())
                ? AtenaMeisho.EMPTY : new AtenaMeisho(entity.get補助者氏名2()));
        投票状況情報.setKyohiJiyu(RString.EMPTY);
        if (RString.isNullOrEmpty(entity.get証明書出力フラグ())
                || MochidashiPcImportUketsukeDataRStringEnum.証明書出力フラグ_FALSE.getKey().equals(entity.get証明書出力フラグ())) {
            投票状況情報.setShomeishoPrintFlag(Boolean.FALSE);
        } else if (MochidashiPcImportUketsukeDataRStringEnum.証明書出力フラグ_TRUE.getKey().equals(entity.get証明書出力フラグ())) {
            投票状況情報.setShomeishoPrintFlag(Boolean.TRUE);
        }
        投票状況情報.setSochiZumiFlag(Boolean.FALSE);
        投票状況情報.setKijitsuFuzaiKubun(new Code(KijitsuFuzaiKubunEnum.当日投票.getKey()));
        投票状況情報.setInsertReamsLoginId(entity.get行挿入ログインid());
        投票状況情報.setInsertTimestamp(changeToRDateTime(entity.get行挿入日時()));
        if (RString.isNullOrEmpty(entity.get論理削除行FLG())
                || MochidashiPcImportUketsukeDataRStringEnum.論理削除行FLG_TRUE.getKey().equals(entity.get論理削除行FLG())) {
            投票状況情報.setIsDeleted(Boolean.FALSE);
        } else if (MochidashiPcImportUketsukeDataRStringEnum.論理削除行FLG_TRUE.getKey().equals(entity.get論理削除行FLG())) {
            投票状況情報.setIsDeleted(Boolean.TRUE);
        }
        投票状況情報.setUpdateCount(RString.isNullOrEmpty(entity.getUpdate回数()) || !isNumeric(entity.getUpdate回数())
                ? 0 : Integer.parseInt(entity.getUpdate回数().toString()));
        投票状況情報.setLastUpdateReamsLoginId(entity.get最終Updateログインid());
        投票状況情報.setLastUpdateTimestamp(changeToRDateTime(entity.get最終Update日時()));
        return 投票状況情報;
    }

    private Code get投票状況(MochidashiPcImportUketsukeDataEntity entity) {
        RString 投票状況 = RString.EMPTY;
        RString 選挙番号 = entity.get選挙番号() == null ? RString.EMPTY : new RString(entity.get選挙番号().getColumnValue());

        if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_1.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況１();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_2.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況２();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_3.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況３();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_4.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況４();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_5.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況５();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_6.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況６();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_7.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況７();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_8.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況８();
        } else if (MochidashiPcImportUketsukeDataRStringEnum.選挙番号_9.getKey().equals(選挙番号)) {
            投票状況 = entity.get投票状況９();
        }
        if (RString.isNullOrEmpty(投票状況)) {
            return Code.EMPTY;
        }
        return new Code(投票状況);

    }

    private boolean isNumeric(RString str) {
        Pattern pattern = Pattern.compile(MochidashiPcImportUketsukeDataRStringEnum.PATTERN.getStringKey());
        return pattern.matcher(str.toString()).matches();
    }

    private RDateTime changeToRDateTime(RString formatDate) {
        if (RString.isNullOrEmpty(formatDate)) {
            return RDateTime.now();
        }
        List<RString> dateTimeList = formatDate.split(MochidashiPcImportUketsukeDataRStringEnum.切れREGEX1.getStringKey());
        if (dateTimeList == null || dateTimeList.size() < 2) {
            return RDateTime.now();
        }
        RString time = dateTimeList.get(1).substring(0, NumberEdit.固定数_８.getKey());
        return RDateTime.of(dateTimeList.get(0), time);
    }
}
