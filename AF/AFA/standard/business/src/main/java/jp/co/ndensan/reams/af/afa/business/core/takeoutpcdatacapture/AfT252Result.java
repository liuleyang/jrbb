/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.takeoutpcdatacapture;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.takeoutpcdatacapture.AfT252Entity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端末用データを管理するクラスです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public class AfT252Result {

    private final AfT252Entity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link BarCodeJuriEntity}より{@link BarCodeTojitsuResult}を生成します。
     *
     * @param entity DBより取得した{@link BarCodeJuriEntity}
     */
    public AfT252Result(AfT252Entity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 投票区名称を返します。
     *
     * @return 投票区名称
     */
    public RString get投票区名称() {
        return this.entity.getTohyokuName();
    }

    /**
     * 投票所名称を返します。
     *
     * @return 投票所名称
     */
    public RString get投票所名称() {
        return this.entity.getTohyojoName();
    }

    /**
     * 投票区コードを返します。
     *
     * @return 投票区コード
     */
    public RString get投票区コード() {
        return this.entity.getTohyokuCode();
    }

    /**
     * データ作成区分を返します。
     *
     * @return データ作成区分
     */
    public Code getデータ作成区分() {
        return this.entity.getDataCreateKubun();
    }

    /**
     * 作成日時を返します。
     *
     * @return 作成日時
     */
    public YMDHMS get作成日時() {
        return this.entity.getDataCreateYMD();
    }

    /**
     * AP受渡区分を返します。
     *
     * @return AP受渡区分
     */
    public Code getAP受渡区分() {
        return this.entity.getSystemSendKubun();
    }

    /**
     * AP受渡日時を返します。
     *
     * @return AP受渡日時
     */
    public YMDHMS getAP受渡日時() {
        return this.entity.getSystemSendYMD();
    }

    /**
     * データ受渡区分を返します。
     *
     * @return データ受渡区分
     */
    public Code getデータ受渡区分() {
        return this.entity.getDataSendKubun();
    }

    /**
     * データ受渡日時を返します。
     *
     * @return データ受渡日時
     */
    public YMDHMS getデータ受渡日時() {
        return this.entity.getDataSendYMD();
    }

    /**
     * データ取込区分を返します。
     *
     * @return データ取込区分
     */
    public Code getデータ取込区分() {
        return this.entity.getDataImportKubun();
    }

    /**
     * 取込日時を返します。
     *
     * @return 取込日時
     */
    public YMDHMS get取込日時() {
        return this.entity.getDataImportYMD();
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日
     */
    public FlexibleDate get投票年月日() {
        return this.entity.getTohyoYMD();
    }
}
