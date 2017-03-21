/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMF1020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi.SaibaninMeiboSakuseiResult;
import jp.co.ndensan.reams.af.afa.business.core.saibanintorikomi.SaibaninTorikomiCsvResult;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.saibanintorikomi.SaibaninTorikomiEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020.SaibaninTorikomiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMF1020.SaibaninTorikomiValidationHandler;
import jp.co.ndensan.reams.af.afa.service.core.saibanintorikomi.SaibaninTorikomiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAMNF1020　裁判員候補者予定者取込 <br />
 * SaibaninTorikomiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0310-010 guancy
 */
public class SaibaninTorikomi {

    private static final RString CSV_WRITER_DELIMITER = SaibaninTorikomiEnum.カンマ.getRString();
    private static final RString ONE = SaibaninTorikomiEnum.ONE.getRString();
    private static final RString ZERO = SaibaninTorikomiEnum.ZERO.getRString();
    private static final RString 星印 = SaibaninTorikomiEnum.星印.getRString();
    private static final RString 斜線 = SaibaninTorikomiEnum.斜線.getRString();

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SaibaninTorikomiDiv
     * @return ResponseData<SaibaninTorikomiDiv>
     */
    public ResponseData<SaibaninTorikomiDiv> onLoad(SaibaninTorikomiDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * UploadPanelのdivController
     *
     * @param div UploadPanelコントロールのpostParameterPanelnamesプロパティで設定したPanel 複数指定した場合はその分第二、第三引数に指定する。
     * @param files アップロードしたファイルの情報(一時ファイル情報) postParameterPanelnamesをひとつだけ指定した場合は第二引数に設定される。
     * postParameterPanelnamesの設定が無い場合は、第一引数に設定される。
     * @return responseオブジェクトを返却
     */
    public ResponseData<SaibaninTorikomiDiv> onClick_upLoad(SaibaninTorikomiDiv div, List<FileData> files) {
        SaibaninTorikomiManager manger = SaibaninTorikomiManager.createInstance();
        ArrayList fileName = new ArrayList<>();
        ArrayList filePath = new ArrayList<>();
        ArrayList fullPath = new ArrayList<>();
        if (!ResponseHolder.isReRequest()) {
            for (FileData file : files) {
                fileName.add(file.getFileName());
                filePath.add(file.getFilePath().substring(0, file.getFilePath().lastIndexOf(斜線.toString())));
                fullPath.add(file.getFilePath());
            }
            ViewStateHolder.put(ViewStateKeys.データ取込_fileName, fileName);
            ViewStateHolder.put(ViewStateKeys.データ取込_filePath, filePath);
            ViewStateHolder.put(ViewStateKeys.データ取込_path, fullPath);
        } else {
            fileName = ViewStateHolder.get(ViewStateKeys.データ取込_fileName, ArrayList.class);
            filePath = ViewStateHolder.get(ViewStateKeys.データ取込_filePath, ArrayList.class);
            fullPath = ViewStateHolder.get(ViewStateKeys.データ取込_path, ArrayList.class);
        }

        div.setSaibaninMeiboSakuseiFlg(ZERO);
        div.setMeiboTorikomiZumiFlg(ZERO);
        div.setFileEmptyFlg(ZERO);
        div.setCountFlg(ZERO);

        List<SaibaninTorikomiCsvResult> results = readFile(div, fileName, filePath, fullPath);
        Boolean meiboTorikomiZumiFlag = true;
        SaibaninMeiboSakuseiResult result = manger.get裁判員名簿作成情報();
        if (null == result) {
            div.setSaibaninMeiboSakuseiFlg(ONE);
        } else {
            meiboTorikomiZumiFlag = result.get予定者名簿取込済フラグ();
            if (meiboTorikomiZumiFlag) {
                div.setMeiboTorikomiZumiFlg(ONE);
            }
        }

        ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validateチェック();
        if (!ResponseHolder.isReRequest() && controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        if (meiboTorikomiZumiFlag) {
            manger.裁判員候補者予定者名簿登録(manger.get裁判員候補者予定者取込データ(results), new Code(div.getRadSaibaninShinsain().getSelectedKey()));
        } else {
            manger.裁判員名簿作成情報テーブル更新(result, manger.get裁判員候補者予定者取込データ(results), new Code(div.getRadSaibaninShinsain().getSelectedKey()));
        }

        if (!ResponseHolder.getMessageCode().toString().equals(UrInformationMessages.保存終了.getMessage().getCode())) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private List<SaibaninTorikomiCsvResult> readFile(SaibaninTorikomiDiv div, ArrayList fileName, ArrayList filePath, ArrayList fullPath) {
        CsvReader csvReader;
        List<SaibaninTorikomiCsvResult> results = new ArrayList<>();
        for (int i = 0; i < fileName.size(); i++) {
            SharedFileDescriptor sharedFileDescriptor = new SharedFileDescriptor(GyomuCode.AF選挙, new FilesystemName(new RString(fileName.get(i).toString())));
            SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(星印), null, true, null);
            SharedFile.copyToSharedFile(sharedFileDescriptor, new FilesystemPath(new RString(filePath.get(i).toString())), new CopyToSharedFileOpts());

            csvReader = new CsvReader.InstanceBuilder(new RString(fullPath.get(i).toString()), SaibaninTorikomiCsvResult.class)
                    .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8)
                    .hasHeader(true).setNewLine(NewLine.CRLF).build();
            while (true) {
                SaibaninTorikomiCsvResult entity = (SaibaninTorikomiCsvResult) csvReader.readLine();
                if (entity != null) {
                    results.add(entity);
                } else {
                    break;
                }
            }
            csvReader.close();
        }

        if (results.isEmpty()) {
            div.setFileEmptyFlg(ONE);
        } else {
            for (int i = 0; i < results.size(); i++) {
                SaibaninTorikomiCsvResult csvResult = results.get(i);
                if (null == csvResult.get氏名()
                        || null == csvResult.get生年月日()
                        || null == csvResult.get郵便番号()
                        || null == csvResult.get住所()
                        || null == csvResult.get本籍()
                        || null == csvResult.get識別コード()
                        || csvResult.get氏名().isNull()
                        || csvResult.get生年月日().isNull()
                        || csvResult.get郵便番号().isNull()
                        || csvResult.get住所().isNull()
                        || csvResult.get本籍().isNull()
                        || csvResult.get識別コード().isNull()) {
                    div.setCountFlg(ONE);
                }

            }
        }
        return results;
    }

    private SaibaninTorikomiValidationHandler getValidatorHandler(SaibaninTorikomiDiv div) {
        return SaibaninTorikomiValidationHandler.of(div);
    }

}
