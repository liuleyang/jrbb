/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.AfCodeCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.AfConfigCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.HojoshaCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.KumiaiCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.RyojikanCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.SenkyokuCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.ShisetsuCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyojoCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyokuAFCsvResult;
import jp.co.ndensan.reams.af.afa.business.core.mastercsvoutput.TohyokuUrCsvResult;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.mastercsvoutput.MasterCsvOutputEnum;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * MasterCsvOutputDivに対応するHandlerクラスです。
 *
 * @reamsid_L AF-0670-010 lis
 */
public class MasterCsvOutputHandler {

    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;
    private static final RString CSV_DELIMITER = MasterCsvOutputEnum.カンマ.getRString();

    /**
     * コンストラクタです。
     *
     */
    public MasterCsvOutputHandler() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param メニューID RString
     */
    public void onLoad(RString メニューID) {
    }

    /**
     * 投票区ファイル書込みする。
     *
     * @param 投票区 List<TohyokuAFCsvResult>
     */
    public void af投票区ファイル書込み(List<TohyokuAFCsvResult> 投票区) {
        if (投票区.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.投票区マスタ);
        try (CsvWriter<TohyokuAFCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 投票区.size(); i++) {
                csvWriter.writeLine(投票区.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 投票区ファイル書込みする。
     *
     * @param 投票区 List<TohyokuUrCsvResult>
     */
    public void ur投票区ファイル書込み(List<TohyokuUrCsvResult> 投票区) {
        if (投票区.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.投票区マスタ);
        try (CsvWriter<TohyokuUrCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 投票区.size(); i++) {
                csvWriter.writeLine(投票区.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 投票所ファイル書込みする。
     *
     * @param 投票所 List<TohyojoCsvResult>
     */
    public void 投票所ファイル書込み(List<TohyojoCsvResult> 投票所) {
        if (投票所.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.投票所マスタ);
        try (CsvWriter<TohyojoCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 投票所.size(); i++) {
                csvWriter.writeLine(投票所.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 選挙区ファイル書込みする。
     *
     * @param 選挙区 List<SenkyokuCsvResult>
     */
    public void 選挙区ファイル書込み(List<SenkyokuCsvResult> 選挙区) {
        if (選挙区.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.選挙区マスタ);
        try (CsvWriter<SenkyokuCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 選挙区.size(); i++) {
                csvWriter.writeLine(選挙区.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 施設ファイル書込みする。
     *
     * @param 施設 List<ShisetsuCsvResult>
     */
    public void 施設ファイル書込み(List<ShisetsuCsvResult> 施設) {
        if (施設.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.施設マスタ);
        try (CsvWriter<ShisetsuCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 施設.size(); i++) {
                csvWriter.writeLine(施設.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 補助者ファイル書込みする。
     *
     * @param 補助者 List<HojoshaCsvResult>
     */
    public void 補助者ファイル書込み(List<HojoshaCsvResult> 補助者) {
        if (補助者.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.補助者マスタ);
        try (CsvWriter<HojoshaCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 補助者.size(); i++) {
                csvWriter.writeLine(補助者.get(i));
                AccessLogger.log(AccessLogType.照会, PersonalData.of(new ShikibetsuCode(補助者.get(i).get識別コード())));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 組合ファイル書込みする。
     *
     * @param 組合 List<KumiaiCsvResult>
     */
    public void 組合ファイル書込み(List<KumiaiCsvResult> 組合) {
        if (組合.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.組合マスタ);
        try (CsvWriter<KumiaiCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 組合.size(); i++) {
                csvWriter.writeLine(組合.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * 領事官ファイル書込みする。
     *
     * @param 領事官 List<TohyokuUrCsvResult>
     */
    public void 領事官ファイル書込み(List<RyojikanCsvResult> 領事官) {
        if (領事官.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.領事官マスタ);
        try (CsvWriter<RyojikanCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < 領事官.size(); i++) {
                csvWriter.writeLine(領事官.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * コードファイル書込みする。
     *
     * @param コード List<AfCodeCsvResult>
     */
    public void コードファイル書込み(List<AfCodeCsvResult> コード) {
        if (コード.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.コードマスタ);
        try (CsvWriter<AfCodeCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < コード.size(); i++) {
                csvWriter.writeLine(コード.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    /**
     * コンフィグァイル書込みする。
     *
     * @param コンフィグ List<AfConfigCsvResult>
     */
    public void コンフィグファイル書込み(List<AfConfigCsvResult> コンフィグ) {
        if (コンフィグ.isEmpty()) {
            return;
        }
        beforeWriter(AFAEucEntityId.コンフィグ);
        try (CsvWriter<AfConfigCsvResult> csvWriter = new CsvWriter.InstanceBuilder(this.eucOutputFilePath)
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build()) {
            for (int i = 0; i < コンフィグ.size(); i++) {
                csvWriter.writeLine(コンフィグ.get(i));
            }
            csvWriter.close();
        }
        this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
    }

    private void beforeWriter(AFAEucEntityId aFAEucEntityId) {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.Euc,
                aFAEucEntityId.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), aFAEucEntityId.getFileName());

    }

}
