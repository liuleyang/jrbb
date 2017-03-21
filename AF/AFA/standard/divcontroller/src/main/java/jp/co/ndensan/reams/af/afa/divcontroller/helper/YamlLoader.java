/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets._IServletControlData;
import org.yaml.snakeyaml.Yaml;

/**
 * YamlLoaderクラスです。
 *
 * @author N1823 有澤 礼恵
 */
public final class YamlLoader {

    private static final RString ROOT_PATH = new RString("demodata/demodata/af/");

    private YamlLoader() {
    }

    /**
     * YAMLファイルを読み込みます。<br />
     * デモ用のデータ読み込みに使用するクラスです。<br />
     * このメソッドで読み込むYAMLはハッシュのリスト形式で記述されている必要があります。<br />
     * ファイルはWEB-INF/demodata/以下に配置される必要があります。<br />
     *
     * @param fileName Yamlファイル名
     * @return Yamlをパースしたリスト
     */
    public static List<HashMap> loadAsList(RString fileName) {
        return toList(initialize(fileName));
    }

    /**
     * YAMLファイルを読み込みます。<br />
     * デモ用のデータ読み込みに使用するクラスです。<br />
     * このメソッドで読み込むYAMLはハッシュ形式で記述されている必要があります。<br />
     * ハッシュの中身は任意の型が許されます。使う側で適宜型変換を行う必要があります。<br />
     * ファイルはWEB-INF/demodata/以下に配置される必要があります。<br />
     *
     * @param fileName Yamlファイル名
     * @return Yamlをパースしたリスト
     */
    public static Map loadAsMap(RString fileName) {
        return toHashMap(initialize(fileName));
    }

    /**
     * YAMLファイルを読み込みます。<br />
     * デモ用のデータ読み込みに使用するクラスです。<br />
     * このメソッドで読み込むYAMLはハッシュのリスト形式で記述されている必要があります。<br />
     * ドロップダウンリストのdataSourceで使用できる形にします。<br />
     * ファイルはWEB-INF/demodata/以下に配置される必要があります。<br />
     *
     * @param fileName Yamlファイル名
     * @param isAddEmptyRow Trueの時、空行を追加する
     * @return KeyValueDataSource型のリスト
     */
    public static List<KeyValueDataSource> loadAsKeyValueDataSource(RString fileName, Boolean isAddEmptyRow) {
        return toKeyValueDataSource(loadAsList(fileName), isAddEmptyRow);
    }

    private static Object initialize(RString fileName) {
        InputStream input = null;
        RString urlHeader = new RString(((_IServletControlData) _ControlDataHolder
                .getControlData()).getUrlHeader());
        try {
            URL url = new URL(urlHeader.toString().concat(ROOT_PATH.toString()).concat(fileName.toString()));
            input = url.openStream();
        } catch (FileNotFoundException ex) {
            throw new SystemException("yamlが見つかりません。:" + fileName.toString(), ex);
        } catch (MalformedURLException ex) {
            throw new SystemException("urlが不適切です。: " + ex.getLocalizedMessage(), ex);
        } catch (IOException ex) {
            throw new SystemException("yamlがloadできません。:" + fileName.toString(), ex);
        }
        Yaml yaml = new Yaml();
        return yaml.load(input);
    }

    private static List toList(Object target) {
        return (List) target;
    }

    private static HashMap toHashMap(Object target) {
        return (HashMap) target;
    }

    private static List<KeyValueDataSource> toKeyValueDataSource(List<HashMap> targetList, Boolean isAddEmptyRow) {
        List<KeyValueDataSource> keyValueList = new ArrayList<>();

        if (isAddEmptyRow) {
            keyValueList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        }

        for (HashMap row : targetList) {
            keyValueList.add(new KeyValueDataSource(
                    new RString(row.get("key").toString()), new RString(row.get("value").toString())));
        }

        return keyValueList;
    }

    /**
     * 取得したデータをTextBox型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return TextBox
     */
    public static TextBox getTextBoxText(HashMap item, String keyName) {
        TextBox text = new TextBox();
        text.setValue(new RString(item.get(keyName).toString()));
        return text;
    }

    /**
     * 取得したデータをTextBoxDate型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return TextBoxDate
     */
    public static TextBoxDate getTextBoxDateText(HashMap item, String keyName) {
        TextBoxDate text = new TextBoxDate();
        text.setValue(new RDate(item.get(keyName).toString()));
        return text;
    }

    /**
     * 取得したデータをBoolean型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return Boolean
     */
    public static Boolean getBooleanText(HashMap item, String keyName) {
        return Boolean.valueOf(item.get(keyName).toString());
    }

    /**
     * 取得したデータをDropDownList型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return DropDownList
     */
    public static DropDownList getDropDownListText(HashMap item, String keyName) {
        DropDownList text = new DropDownList();
        text.setSelectedKey(new RString(item.get(keyName).toString()));
        return text;
    }

    /**
     * 取得したデータをRString型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return RString
     */
    public static RString getStringText(HashMap item, String keyName) {
        return new RString(item.get(keyName).toString());
    }

    /**
     * 取得したデータをDecimal型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return Decimal
     */
    public static Decimal getDecimalText(HashMap item, String keyName) {
        return new Decimal(item.get(keyName).toString());
    }

    /**
     * 取得したデータをTextBoxTime型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return TextBoxDate
     */
    public static TextBoxTime getTextBoxTimeText(HashMap item, String keyName) {
        TextBoxTime text = new TextBoxTime();
        if (item.get(keyName).toString().isEmpty()) {
            return text;
        }
        text.setValue(RTime.parse(item.get(keyName).toString()));
        return text;
    }

    /**
     * 取得したデータをTextBoxNum型に変換します。
     *
     * @param item HashMap
     * @param keyName String
     * @return TextBoxNum
     */
    public static TextBoxNum getTextBoxNum(HashMap item, String keyName) {
        TextBoxNum text = new TextBoxNum();
        text.setValue(getDecimalText(item, keyName));
        return text;
    }

}
