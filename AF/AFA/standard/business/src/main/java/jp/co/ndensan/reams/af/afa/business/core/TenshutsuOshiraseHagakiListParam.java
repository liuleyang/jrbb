/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出者お知らせハガキ作成対象者一覧表
 *
 * @reamsid_L AF-0160-030 jihb
 */
public class TenshutsuOshiraseHagakiListParam {

    private TohyoJokyoJoho 投票所入場券情報;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private RString 入場券名;
    private RString 抄本名;
    private RString 名簿番号;
    private RString 生年月日;
    private boolean 合計Flag;
    private RString 合計出力内容;

    /**
     * 抄本名
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
    }

    /**
     * 抄本名
     *
     * @return RString
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 合計Flag
     *
     * @param 合計Flag boolean
     */
    public void set合計Flag(boolean 合計Flag) {
        this.合計Flag = 合計Flag;
    }

    /**
     * 合計Flag
     *
     * @return 合計Flag boolean
     */
    public boolean is合計Flag() {
        return 合計Flag;
    }

    /**
     * 投票所入場券情報を設定します。
     *
     * @param 投票所入場券情報 TohyoJokyoJoho
     */
    public void set投票所入場券情報(TohyoJokyoJoho 投票所入場券情報) {
        this.投票所入場券情報 = 投票所入場券情報;
    }

    /**
     * 帳票共通ヘッダーを設定します。
     *
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public void set帳票共通ヘッダー(TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
    }

    /**
     * 入場券名を設定します。
     *
     * @param 入場券名 RString
     */
    public void set入場券名(RString 入場券名) {
        this.入場券名 = 入場券名;
    }

    /**
     * 名簿番号を設定します。
     *
     * @param 名簿番号 RString
     */
    public void set名簿番号(RString 名簿番号) {
        this.名簿番号 = 名簿番号;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 RString
     */
    public void set生年月日(RString 生年月日) {
        this.生年月日 = 生年月日;
    }

    /**
     * 合計出力内容を設定します。
     *
     * @param 合計出力内容 RString
     */
    public void set合計出力内容(RString 合計出力内容) {
        this.合計出力内容 = 合計出力内容;
    }

    /**
     * 投票所入場券情報を返します。
     *
     * @return 投票所入場券情報 s
     */
    public TohyoJokyoJoho get投票所入場券情報() {
        return this.投票所入場券情報;
    }

    /**
     * 帳票共通ヘッダーを返します。
     *
     * @return 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public TeijiCommonJohoItem get帳票共通ヘッダー() {
        return this.帳票共通ヘッダー;
    }

    /**
     * 入場券名を返します。
     *
     * @return 入場券名 RString
     */
    public RString get入場券名() {
        return this.入場券名;
    }

    /**
     * 名簿番号を返します。
     *
     * @return 名簿番号 RString
     */
    public RString get名簿番号() {
        return this.名簿番号;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日 RString
     */
    public RString get生年月日() {
        return this.生年月日;
    }

    /**
     * 合計出力内容を返します。
     *
     * @return 合計出力内容 RString
     */
    public RString get合計出力内容() {
        return this.合計出力内容;
    }

}
