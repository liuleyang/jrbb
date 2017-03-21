/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UDT022CodeTable;

/**
 * コードマスタからデータを取得するためのクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public final class CodeMasterHelper {

    private CodeMasterHelper() {
    }

    /**
     * 引数のコード種別でコードマスタを取得します。
     *
     * @param codeShubetsu コード種別
     * @return 空行のないリスト
     */
    public static List<KeyValueDataSource> createDataSource(CodeShubetsu codeShubetsu) {
        return createDataSource(codeShubetsu, Boolean.FALSE);
    }

    /**
     * 引数のコード種別と空行作成有無でコードマスタを取得します。
     *
     * @param codeShubetsu コード種別
     * @param isAddEmptyRow 空行作成有無（True：作成する　False：作成しない）
     * @return 正式名称でのリスト
     */
    public static List<KeyValueDataSource> createDataSource(CodeShubetsu codeShubetsu, boolean isAddEmptyRow) {
        //コードマスタからデータを取得して、データソースにセット。
//        List<UDT022CodeTable> entities = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, codeShubetsu);
//        if (entities == null) {
//            return Collections.EMPTY_LIST;
//        }
//
//        List<KeyValueDataSource> source = new ArrayList<>();
//        if (isAddEmptyRow) {
//            KeyValueDataSource row = new KeyValueDataSource(RString.EMPTY, RString.EMPTY);
//            source.add(row);
//        }
        List<KeyValueDataSource> source = createNewSource(isAddEmptyRow);
        for (UDT022CodeTable item : getCodeMaster(codeShubetsu)) {
            KeyValueDataSource row = new KeyValueDataSource(item.getコード().getColumnValue(), item.getコード名称());
            source.add(row);
        }
        return source;
    }

    /**
     * 引数のコード種別と空行作成有無でコードマスタを取得します。
     *
     * @param codeShubetsu コード種別
     * @param isAddEmptyRow 空行作成有無（True：作成する　False：作成しない）
     * @return 略称名でのリスト
     */
    public static List<KeyValueDataSource> createDataSourceRyakusho(CodeShubetsu codeShubetsu, boolean isAddEmptyRow) {
        List<KeyValueDataSource> source = createNewSource(isAddEmptyRow);
        for (UDT022CodeTable item : getCodeMaster(codeShubetsu)) {
            KeyValueDataSource row = new KeyValueDataSource(item.getコード().getColumnValue(), item.getコード略称());
            source.add(row);
        }
        return source;
    }

    private static List<UDT022CodeTable> getCodeMaster(CodeShubetsu codeShubetsu) {
        List<UDT022CodeTable> entities = CodeMasterNoOption.getCode(SubGyomuCode.AFA選挙本体, codeShubetsu);
        if (entities == null) {
            return Collections.EMPTY_LIST;
        }
        return entities;
    }

    private static List<KeyValueDataSource> createNewSource(boolean isAddEmptyRow) {
        List<KeyValueDataSource> source = new ArrayList<>();
        if (isAddEmptyRow) {
            KeyValueDataSource row = new KeyValueDataSource(RString.EMPTY, RString.EMPTY);
            source.add(row);
        }
        return source;
    }
}
