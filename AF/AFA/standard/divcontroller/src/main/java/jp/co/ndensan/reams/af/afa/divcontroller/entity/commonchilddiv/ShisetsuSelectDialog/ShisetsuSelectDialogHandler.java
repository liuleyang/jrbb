/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuSelectDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shisetsu.Shisetsu;
import jp.co.ndensan.reams.af.afa.business.shisetsucodeselect.ShisetsuCodeSelectModel;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShisetsuShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.af.afa.service.core.shisetsu.ShisetsuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UDT022CodeTable;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設選択ダイアログに対するハンドラークラスです。
 *
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuSelectDialogHandler {

    private static final RString 施設種類_ALL_CODE = new RString("00");
    private static final RString 施設種類_ALL_NAME = new RString("すべて");
    private final ShisetsuManager Manager;
    private final ShisetsuSelectDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設選択ダイアログのdiv
     */
    public ShisetsuSelectDialogHandler(ShisetsuSelectDialogDiv div) {
        this.div = div;
        Manager = InstanceProvider.create(ShisetsuManager.class);
    }

    /**
     * ShisetsuShubetsuの初期化メソッドです。
     *
     * @param is本庁支所 boolean
     * @param model ShisetsuCodeSelectModel
     */
    public void setIntialShisetsuShubetsu(boolean is本庁支所, ShisetsuCodeSelectModel model) {

        List<KeyValueDataSource> source = new ArrayList<>();
        if (!is本庁支所) {
            source.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
            source.add(new KeyValueDataSource(施設種類_ALL_CODE, 施設種類_ALL_NAME));
            source.addAll(CodeMasterHelper.createDataSource(AFACodeShubetsu.施設種別.getCodeShubetsu()));
            div.getDdlShisetsuShubetsu().setDataSource(source);
            div.getDdlShisetsuShubetsu().setSelectedKey(RString.isNullOrEmpty(model.get施設コード())
                    ? RString.EMPTY : get施設種別キー(model.get施設コード()));
            if (model.isUsing施設種別()) {
                div.getDdlShisetsuShubetsu().setSelectedKey(RString.isNullOrEmpty(model.get施設種別コード())
                        ? RString.EMPTY : model.get施設種別コード());
            }
        } else {
            List<UDT022CodeTable> codes = CodeMasterNoOption.getCode(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu());
            for (UDT022CodeTable code : codes) {
                if (ShisetsuShubetsu.一般_本庁.getCode().equals(code.getコード().value())
                        || ShisetsuShubetsu.一般_支所.getCode().equals(code.getコード().value())) {
                    source.add(new KeyValueDataSource(code.getコード().value(), code.getコード名称()));
                }
            }
            div.getDdlShisetsuShubetsu().setDataSource(source);
            div.getDdlShisetsuShubetsu().setSelectedKey(RString.isNullOrEmpty(model.get施設コード())
                    ? ShisetsuShubetsu.一般_本庁.getCode() : get施設種別キー(model.get施設コード()));
        }

        if (div.getDdlShisetsuShubetsu().getSelectedKey() == null
                || div.getDdlShisetsuShubetsu().getSelectedKey().equals(RString.EMPTY)) {
            div.getDdlShisetsuShubetsu().setDisabled(Boolean.FALSE);
        } else {
            div.getDdlShisetsuShubetsu().setDisabled(Boolean.TRUE);
        }
    }

    private RString get施設種別キー(RString 施設コード) {
        Shisetsu 施設 = Manager.get施設By施設コード(施設コード);
        return 施設 == null ? RString.EMPTY : 施設.get施設種別().getColumnValue();
    }

    /**
     * データグリッド一覧の表示メソッドです。
     *
     * @param 施設種別コード RString
     * @return List<dgShisetsuSelect_Row>
     */
    public List<dgShisetsuSelect_Row> setDataSourceToDataGrid(RString 施設種別コード) {
        List<dgShisetsuSelect_Row> rowList = new ArrayList<>();
        List<Shisetsu> 施設リスト = 施設種別コード.equals(施設種類_ALL_CODE) ? Manager.get施設全件() : Manager.get施設By施設種別コードリスト(施設種別コード);
        if (施設リスト != null && !施設リスト.isEmpty()) {
            for (Shisetsu 施設 : 施設リスト) {
                dgShisetsuSelect_Row row = new dgShisetsuSelect_Row();
                row.setTxtShisetsuCode(施設.get施設コード());
                row.setTxtShisetsuName(施設.get施設名称());
                row.setTxtKanaShisetsuName(施設.getカナ施設名称());
                row.setTxtShisetsuShubetsu(get施設種別名称Fromコードマスタ(施設.get施設種別()));
                rowList.add(row);
            }
        }
        return rowList;
    }

    private RString get施設種別名称Fromコードマスタ(Code 施設種別コード) {
        return CodeMasterNoOption.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.施設種別.getCodeShubetsu(), 施設種別コード);
    }
}
