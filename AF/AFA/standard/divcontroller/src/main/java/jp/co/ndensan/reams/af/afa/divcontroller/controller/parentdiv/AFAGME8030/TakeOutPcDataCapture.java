/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME8030;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture.AfT252Result;
import jp.co.ndensan.reams.af.afa.definition.batchprm.mochidashipcimportuketsukedata.AFABTE803BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.HOSHI;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.処理可能な;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.AFAGME8030TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.TakeOutPcDataCaptureDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.dgShohonSenkyo_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030.TakeOutPcDataCaptureHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030.TakeOutPcDataCaptureValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.takeoutpcdatacapture.TakeOutPcDataCaptureManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * AFAGME8030　持出端末用データ作成 <br />
 * TakeOutPcDataCaptureDivに対応するコントローラです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class TakeOutPcDataCapture {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @return ResponseData<TakeOutPcDataCaptureDiv>
     */
    public ResponseData<TakeOutPcDataCaptureDiv> onLoad(TakeOutPcDataCaptureDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME8030TransitionEventName.メニューへ戻る).respond();
        }
        ViewState.setメニューID(ResponseHolder.getMenuID());
        List<AfT252Result> 投票日List = getManager().get投票日();
        if (!ResponseHolder.isReRequest() && (null == 投票日List || 投票日List.isEmpty())) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし_データ内容.getMessage()
                    .replace(処理可能な.getKey().toString())).respond();
        }
        getHandler(div).画面設定_投票日ドロップダウン(投票日List);
        div.setHdnTohyoYMD(div.getDdlTohyoYmd().getSelectedKey());
        getHandler(div).画面設定_抄本選挙一覧(getManager().get端末用データ(new FlexibleDate(div.getHdnTohyoYMD())));
        getHandler(div).画面設定_取込一覧(getManager().get取込データ(get抄本番号(div.getDgShohonSenkyo().getDataSource())));
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnExecuteByCSV"), true);

        return ResponseData.of(div).respond();
    }

    private List<ShohonNo> get抄本番号(List<dgShohonSenkyo_Row> dataSource) {
        List<ShohonNo> 抄本番号list = new ArrayList<>();
        for (dgShohonSenkyo_Row row : dataSource) {
            抄本番号list.add(new ShohonNo(row.getTxtShohonNo()));
        }
        return 抄本番号list;
    }

    /**
     * 投票日ロップダウンリストonChange時のイベントメソッドです。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @return ResponseData<TakeOutPcDataCaptureDiv>
     */
    public ResponseData<TakeOutPcDataCaptureDiv> onChange_ddlTohyoYmd(TakeOutPcDataCaptureDiv div) {
        div.setHdnTohyoYMD(div.getDdlTohyoYmd().getSelectedKey());
        getHandler(div).画面設定_抄本選挙一覧(getManager().get端末用データ(new FlexibleDate(div.getHdnTohyoYMD())));
        getHandler(div).画面設定_取込一覧(getManager().get取込データ(get抄本番号(div.getDgShohonSenkyo().getDataSource())));

        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンのイベントメソッドです。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @return response
     */
    public ResponseData<TakeOutPcDataCaptureDiv> onSelectBySelectButton(TakeOutPcDataCaptureDiv div) {
        div.setHdnTohyokuCode(div.getDgResult().getClickedItem().getTxtTohyokuCode());
        div.setHdnDataImportKubunCode(div.getDgResult().getClickedItem().getTxtDataImportKubunCode());
        return ResponseData.of(div).respond();

    }

    /**
     * Uploadイベントです。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @param files FileData
     * @return ResponseData<TakeOutPcDataCaptureDiv>
     */
    public ResponseData<TakeOutPcDataCaptureDiv> onClick_btnUpload(TakeOutPcDataCaptureDiv div, List<FileData> files) {
        if (!ResponseHolder.isReRequest()) {
            List<RString> ファイルname = new ArrayList<>();
            ArrayList fileName = new ArrayList<>();
            ArrayList filePath = new ArrayList<>();
            for (FileData file : files) {
                ファイルname.add((file.getFileName()));
                fileName.add(file.getFileName());
                int lastIndex = file.getFilePath().lastIndexOf("/");
                RString filepath = file.getFilePath().substring(0, lastIndex);
                filePath.add(filepath);
            }
            ViewStateHolder.put(ViewStateKeys.共有ファイル, (Serializable) ファイルname);
            ViewStateHolder.put(ViewStateKeys.持出端末データ取込_fileName, fileName);
            ViewStateHolder.put(ViewStateKeys.持出端末データ取込_filePath, filePath);
            div.setHdnUpLoad(new RString(Arrays.toString(files.toArray())));

            ValidationMessageControlPairs controlErrorPairs = getValidatorHandler(div).validate();
            if (controlErrorPairs.existsError()) {
                div.getHiddenBatchExecuteFlg().setText(new RString("close"));
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }
            if (div.getHdnDataImportKubunCode().equals(new RString("3"))) {
                return ResponseData.of(div).addMessage(AfWarningMessages.ファイル再登録確認.getMessage()).respond();
            }
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getHiddenBatchExecuteFlg().setText(new RString("close"));
            return ResponseData.of(div).respond();
        }
        div.getHiddenBatchExecuteFlg().setText(new RString("open"));
        return ResponseData.of(div).respond();
    }

    private SharedFileEntryDescriptor uploadファイルを登録する(FileData data) {
        SharedFileDescriptor sharedFileDescriptor = new SharedFileDescriptor(GyomuCode.AF選挙, new FilesystemName(data.getFileName()));
        SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(HOSHI.getKey()), null, true, null);

        return SharedFile.copyToSharedFile(sharedFileDescriptor, new FilesystemPath(data.getFilePath()), new CopyToSharedFileOpts());

    }

    /**
     * 「実行する」ボタンclick時のチェックです。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @return ResponseData<TakeOutPcDataCaptureDiv>
     */
    public ResponseData<TakeOutPcDataCaptureDiv> onClick_btnBeforeBatchExecuteByCSV(TakeOutPcDataCaptureDiv div) {
        int fileNameListSize = ViewStateHolder.get(ViewStateKeys.持出端末データ取込_fileName, ArrayList.class).size();

        ArrayList fileId = new ArrayList<>();
        FileData files = new FileData();
        for (int i = 0; i < fileNameListSize; i++) {
            files.setFileName(new RString(ViewStateHolder.get(ViewStateKeys.持出端末データ取込_fileName, ArrayList.class).get(i).toString()));
            files.setFilePath(new RString(ViewStateHolder.get(ViewStateKeys.持出端末データ取込_filePath, ArrayList.class).get(i).toString()));
            SharedFileEntryDescriptor descriptor = uploadファイルを登録する(files);
            fileId.add(descriptor.getSharedFileId());
        }
        ViewStateHolder.put(ViewStateKeys.持出端末データ取込_fileId, fileId);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンclick時の実行です。
     *
     * @param div TakeOutPcDataCaptureDiv
     * @return ResponseData<TakeOutPcDataCaptureDiv>
     */
    public ResponseData<AFABTE803BatchParameter> onClick_btnBatchExecuteByCSV(TakeOutPcDataCaptureDiv div) {
        ArrayList filename = ViewStateHolder.get(ViewStateKeys.持出端末データ取込_fileName, ArrayList.class);
        ArrayList fileid = ViewStateHolder.get(ViewStateKeys.持出端末データ取込_fileId, ArrayList.class);
        return ResponseData.of(getHandler(div).setBatchParameter(filename, fileid)).respond();

    }

    private TakeOutPcDataCaptureHandler getHandler(TakeOutPcDataCaptureDiv div) {
        return new TakeOutPcDataCaptureHandler(div);
    }

    private TakeOutPcDataCaptureManager getManager() {
        return TakeOutPcDataCaptureManager.createInstance();
    }

    private TakeOutPcDataCaptureValidationHandler getValidatorHandler(TakeOutPcDataCaptureDiv div) {
        return new TakeOutPcDataCaptureValidationHandler(div);
    }
}
