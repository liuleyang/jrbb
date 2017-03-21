/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTF101;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipccreatedata.MochidashiPcCreateDataEnum;
import jp.co.ndensan.reams.af.afa.definition.core.doitsujinbutsuchosa.enumeratedtype.DoitsujinbutsuChosaRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.kaiku.KaikuNumberEdit;
import jp.co.ndensan.reams.af.afa.definition.kaiku.OutputKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibochoseifilesakuse.ChoseiFileMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.meibochoseifilesakuse.AFABTF101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meibochoseifilesakuse.MeiboChoseiFileSakuseiEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afabtf101.TempCsvEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 名簿調製用連携ファイル作成する。
 *
 * @reamsid_L AF-0300-020 lis
 */
public class MeiboChoseiFileSakuseiProcess extends BatchKeyBreakBase<MeiboChoseiFileSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.meibochoseifilesakuse.IChoseiFileSakuseiMapper.select有権者情報");
    private static final RString 選挙資格区分有権者 = new RString("1");
    private static final RString 選挙資格区分表示者 = new RString("2");

    private AFABTF101SelectProcessParameter processParameter;
    private ChoseiFileMybatisParameter parameter;
    private FileSpoolManager fileSpoolManager;

    private FlexibleDate 年齢計算基準日;

    private int 抽出対象年齢;
    private RString eucOutputFilePath;

    OutputParameter<Long> pageCount;

    @BatchWriter
    private CsvWriter<TempCsvEntity> 臨時CsvWriter;
    
    private List<PersonalData> 識別IdLogList;

    @Override
    protected void initialize() {
        pageCount = new OutputParameter<>();
        parameter = processParameter.toChoseiFileMybatisParameter();
        年齢計算基準日 = processParameter.get年齢計算基準日();
        抽出対象年齢 = processParameter.get抽出対象年齢();
        識別IdLogList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter);
    }

    @Override
    protected void createWriter() {
        // TODO  EUCエンティティID
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                AFAEucEntityId.名簿調製用連携ファイル作成.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(),
                processParameter.getファイル名().concat(DoitsujinbutsuChosaRStringEnum.CSV.getKey()));
        this.臨時CsvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(MochidashiPcCreateDataEnum.CSV_DELIMITER.getRString())
                .setEncode(Encode.UTF_16BE_withBOM)
                .setNewLine(NewLine.CRLF)
                .setEnclosure(new RString(""))
                .hasHeader(false)
                .canAppend(true)
                .build();
    }

    @Override
    protected void usualProcess(MeiboChoseiFileSakuseiEntity entity) {
        FlexibleDate 生年月日 = entity.get生年月日();
        int 算出した年齢 = 0;
        if (null != 生年月日 && !生年月日.isEmpty()) {
            算出した年齢 = 年齢計算基準日.minusYear(生年月日.getYearValue()).getYearValue();
        }

        if (is有権者(entity.get選挙資格区分()) && 算出した年齢 >= 抽出対象年齢) {
            TempCsvEntity csvEntity = new TempCsvEntity();
            RString 個人識別ID = null == entity.get識別コード() 
                    || KaikuNumberEdit.固定数_15.getKey() != entity.get識別コード().length() ? RString.EMPTY : entity.get識別コード();
            RString 本籍住所 = null == entity.get本籍住所() ? RString.EMPTY : entity.get本籍住所();
            RString 本籍番地 = null == entity.get本籍番地() ? RString.EMPTY : entity.get本籍番地();
            RString 氏名 = null == entity.get名称() ? RString.EMPTY : entity.get名称();
            RString 住所 = null == entity.get住所() ? RString.EMPTY : entity.get住所();
            RString 番地 = null == entity.get番地() ? RString.EMPTY : entity.get番地();
            RString 方書 = null == entity.get方書() ? RString.EMPTY : entity.get方書();
            RString 郵便番号 = null == entity.get郵便番号() ? RString.EMPTY : entity.get郵便番号();
            
            csvEntity.set個人識別ID(個人識別ID);
            csvEntity.set本籍(本籍住所.concat(本籍番地));
            csvEntity.set氏名(氏名);
            if (方書.isEmpty()) {
                csvEntity.set住所(住所.concat(番地));
            } else {
                csvEntity.set住所(住所.concat(番地).concat(OutputKeys.SPACE.getValue()).concat(方書));
            }
            csvEntity.set郵便番号(郵便番号);
            csvEntity.set生年月日(生年月日 == null ? RString.EMPTY : new RString(生年月日.toString()));
            
            臨時CsvWriter.writeLine(csvEntity);
            識別IdLogList.add(PersonalData.of(new ShikibetsuCode(個人識別ID)));
        }

    }

    private boolean is有権者(RString 選挙資格区分) {
        return 選挙資格区分有権者.equals(選挙資格区分) || 選挙資格区分表示者.equals(選挙資格区分);
    }

    @Override
    protected void keyBreakProcess(MeiboChoseiFileSakuseiEntity t) {

    }

    @Override
    protected void afterExecute() {
        AccessLogger.log(AccessLogType.更新, 識別IdLogList);
        pageCount.setValue(臨時CsvWriter.getCount());
        this.臨時CsvWriter.close();
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);

    }

}
