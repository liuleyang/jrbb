/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.atenasealsakusei.JushoIchiranMeisai;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.atenasealsakusei.AtenaSealSakuseiMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成のバッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0620-020 guanyq
 */
public class AFABTE601SelectProcessParameter implements IBatchProcessParameter {

    private RString order順;

    private RString 起動画面ID;

    private RString 抄本番号;

    private RString 抄本名;

    private RString 住所条件;

    private List<JushoIchiranMeisai> 住所一覧リスト;

    private SenkyoNo 対象選挙;
    private RString 選挙レベル;
    private RString 対象選挙名称;
    private RDate 対象期間FROM;

    private RDate 対象期間TO;

    private RString 施設種別;

    private RString 施設種別名称;

    private RString 施設コードFROM;

    private RString 施設名称FROM;

    private RString 施設コードTO;

    private RString 施設名称TO;

    private RString 四隅項目コード_右上隅;

    private RString 四隅項目_右上隅;

    private RString 住所コード;

    private RString 住所コード名称;

    private RString 住所表示;

    private RString 宛名コード;

    private RString 宛名コード名称;

    private RString 名称_上段;

    private RString 名称_下段;

    private RString 世帯主敬称コード;

    private RString 世帯主敬称;

    private RString 本人敬称コード;

    private RString 本人敬称;

    private RString 四隅項目コード_左下隅;

    private RString 四隅項目_左下隅;

    private RString 四隅項目コード_右下隅;

    private RString 四隅項目_右下隅;

    private RString 住所の前に市町村名を付加;

    private Boolean 世帯主のみ印刷対象とする有無;

    private RString 開始印字位置番号;

    private RString 帳票ID;
    private IShikibetsuTaishoPSMSearchKey shikibetsutaishoParam;
    private FlexibleDate 年齢到達期限日;
    private FlexibleDate 投票年月日;
    private FlexibleDate 前回基準日;

    /**
     * コンストラクタ作成します。
     *
     *
     * @param 起動画面ID RString
     * @param 抄本番号 RString
     * @param 抄本名 RString
     * @param 住所条件 RString
     * @param 住所一覧リスト List<JushoIchiranMeisai>
     * @param 対象選挙 SenkyoNo
     * @param 選挙レベル RString
     * @param 対象選挙名称 RString
     * @param 対象期間FROM RString
     * @param 対象期間TO RDate
     * @param 施設種別 RDate
     * @param 施設種別名称 RString
     * @param 施設コードFROM RString
     * @param 施設名称FROM RString
     * @param 施設コードTO RString
     * @param 施設名称TO RString
     * @param 住所の前に市町村名を付加 RString
     * @param 四隅項目_右上隅 RString
     * @param 住所コード RString
     * @param 住所コード名称 RString
     * @param 住所表示 RString
     * @param 宛名コード RString
     * @param 四隅項目コード_右上隅 RString
     * @param 名称_上段 RString
     * @param 名称_下段 RString
     * @param 世帯主敬称コード RString
     * @param 世帯主敬称 RString
     * @param 世帯主のみ印刷対象とする有無 RString
     * @param 本人敬称 RString
     * @param 四隅項目コード_左下隅 RString
     * @param 四隅項目_左下隅 RString
     * @param 四隅項目コード_右下隅 RString
     * @param 四隅項目_右下隅 RString
     * @param 宛名コード名称 RString
     * @param 本人敬称コード RString
     * @param 開始印字位置番号 RString
     */
    public AFABTE601SelectProcessParameter(
            RString 起動画面ID,
            RString 抄本番号,
            RString 抄本名,
            RString 住所条件,
            List<JushoIchiranMeisai> 住所一覧リスト,
            SenkyoNo 対象選挙,
            RString 選挙レベル,
            RString 対象選挙名称,
            RDate 対象期間FROM,
            RDate 対象期間TO,
            RString 施設種別,
            RString 施設種別名称,
            RString 施設コードFROM,
            RString 施設名称FROM,
            RString 施設コードTO,
            RString 施設名称TO,
            RString 四隅項目コード_右上隅,
            RString 四隅項目_右上隅,
            RString 住所コード,
            RString 住所コード名称,
            RString 住所表示,
            RString 宛名コード,
            RString 宛名コード名称,
            RString 名称_上段,
            RString 名称_下段,
            RString 世帯主敬称コード,
            RString 世帯主敬称,
            RString 本人敬称コード,
            RString 本人敬称,
            RString 四隅項目コード_左下隅,
            RString 四隅項目_左下隅,
            RString 四隅項目コード_右下隅,
            RString 四隅項目_右下隅,
            RString 住所の前に市町村名を付加,
            Boolean 世帯主のみ印刷対象とする有無,
            RString 開始印字位置番号) {
        this.起動画面ID = 起動画面ID;
        this.抄本番号 = 抄本番号;
        this.抄本名 = 抄本名;
        this.住所条件 = 住所条件;
        this.住所一覧リスト = 住所一覧リスト;
        this.対象選挙 = 対象選挙;
        this.選挙レベル = 選挙レベル;
        this.対象選挙名称 = 対象選挙名称;
        this.対象期間FROM = 対象期間FROM;
        this.対象期間TO = 対象期間TO;
        this.施設種別 = 施設種別;
        this.施設種別名称 = 施設種別名称;
        this.施設コードFROM = 施設コードFROM;
        this.施設名称FROM = 施設名称FROM;
        this.施設コードTO = 施設コードTO;
        this.施設名称TO = 施設名称TO;
        this.四隅項目コード_右上隅 = 四隅項目コード_右上隅;
        this.四隅項目_右上隅 = 四隅項目_右上隅;
        this.住所コード = 住所コード;
        this.住所コード名称 = 住所コード名称;
        this.住所表示 = 住所表示;
        this.宛名コード = 宛名コード;
        this.宛名コード名称 = 宛名コード名称;
        this.名称_上段 = 名称_上段;
        this.名称_下段 = 名称_下段;
        this.世帯主敬称コード = 世帯主敬称コード;
        this.世帯主敬称 = 世帯主敬称;
        this.本人敬称コード = 本人敬称コード;
        this.本人敬称 = 本人敬称;
        this.四隅項目コード_左下隅 = 四隅項目コード_左下隅;
        this.四隅項目_左下隅 = 四隅項目_左下隅;
        this.四隅項目コード_右下隅 = 四隅項目コード_右下隅;
        this.四隅項目_右下隅 = 四隅項目_右下隅;
        this.住所の前に市町村名を付加 = 住所の前に市町村名を付加;
        this.世帯主のみ印刷対象とする有無 = 世帯主のみ印刷対象とする有無;
        this.開始印字位置番号 = 開始印字位置番号;
    }

    /**
     * コンストラクタ作成します。
     *
     *
     * @return AtenaSealSakuseiMybatisParameter
     */
    public AtenaSealSakuseiMybatisParameter toAtenaSealSakuseiMybatisParameter() {
        List<RString> 住所一覧コードリスト = new ArrayList<>();
        if (住所一覧リスト != null && !住所一覧リスト.isEmpty()) {
            for (JushoIchiranMeisai 住所 : 住所一覧リスト) {
                住所一覧コードリスト.add(住所.getコード());
            }
        }
        return new AtenaSealSakuseiMybatisParameter(
                shikibetsutaishoParam,
                施設コードFROM,
                施設コードTO,
                RString.isNullOrEmpty(施設種別) ? Code.EMPTY : new Code(施設種別),
                null,
                住所条件,
                住所一覧コードリスト,
                世帯主のみ印刷対象とする有無,
                対象選挙,
                対象期間FROM == null ? FlexibleDate.EMPTY : new FlexibleDate(対象期間FROM.toDateString()),
                対象期間TO == null ? FlexibleDate.EMPTY : new FlexibleDate(対象期間TO.toDateString()),
                RString.isNullOrEmpty(抄本番号) ? new ShohonNo(0) : new ShohonNo(抄本番号));
    }

    /**
     * order順を返します。
     *
     * @return order順 RString
     */
    public RString getOrder順() {
        return this.order順;
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID RString
     */
    public RString get帳票ID() {
        return this.帳票ID;
    }

    /**
     * order順を設定します。
     *
     * @param order順 RString
     */
    public void setOrder順(RString order順) {
        this.order順 = order順;
    }

    /**
     * 帳票IDを設定します。
     *
     * @param 帳票ID RString
     */
    public void set帳票ID(RString 帳票ID) {
        this.帳票ID = 帳票ID;
    }

    /**
     * 起動画面IDを返します。
     *
     * @return 起動画面ID RString
     */
    public RString get起動画面ID() {
        return 起動画面ID;
    }

    /**
     * 抄本番号を返します。
     *
     * @return 抄本番号 RString
     */
    public RString get抄本番号() {
        return 抄本番号;
    }

    /**
     * 住所条件を返します。
     *
     * @return 住所条件 RString
     */
    public RString get住所条件() {
        return 住所条件;
    }

    /**
     * 住所一覧リストを返します。
     *
     * @return 住所一覧リスト List<JushoIchiranMeisai>
     */
    public List<JushoIchiranMeisai> get住所一覧リスト() {
        return 住所一覧リスト;
    }

    /**
     * 対象選挙を返します。
     *
     * @return 対象選挙 RString
     */
    public SenkyoNo get対象選挙() {
        return 対象選挙;
    }

    /**
     * 対象選挙名称を返します。
     *
     * @return 対象選挙名称 RString
     */
    public RString get対象選挙名称() {
        return 対象選挙名称;
    }

    /**
     * 対象期間FROMを返します。
     *
     * @return 対象期間FROM RString
     */
    public RDate get対象期間FROM() {
        return 対象期間FROM;
    }

    /**
     * 対象期間TOを返します。
     *
     * @return 対象期間TO RString
     */
    public RDate get対象期間TO() {
        return 対象期間TO;
    }

    /**
     * 施設種別を返します。
     *
     * @return 施設種別 RString
     */
    public RString get施設種別() {
        return 施設種別;
    }

    /**
     * 施設種別名称を返します。
     *
     * @return 施設種別名称 RString
     */
    public RString get施設種別名称() {
        return 施設種別名称;
    }

    /**
     * 施設コードFROMを返します。
     *
     * @return 施設コードFROM RString
     */
    public RString get施設コードFROM() {
        return 施設コードFROM;
    }

    /**
     * 施設名称FROMを返します。
     *
     * @return 施設名称FROM RString
     */
    public RString get施設名称FROM() {
        return 施設名称FROM;
    }

    /**
     * 施設コードTOを返します。
     *
     * @return 施設コードTO RString
     */
    public RString get施設コードTO() {
        return 施設コードTO;
    }

    /**
     * 施設名称TOを返します。
     *
     * @return 施設名称TO RString
     */
    public RString get施設名称TO() {
        return 施設名称TO;
    }

    /**
     * 四隅項目コード_右上隅を返します。
     *
     * @return 四隅項目コード_右上隅 RString
     */
    public RString get四隅項目コード_右上隅() {
        return 四隅項目コード_右上隅;
    }

    /**
     * 四隅項目_右上隅を返します。
     *
     * @return 四隅項目_右上隅 RString
     */
    public RString get四隅項目_右上隅() {
        return 四隅項目_右上隅;
    }

    /**
     * 住所コードを返します。
     *
     * @return 住所コード RString
     */
    public RString get住所コード() {
        return 住所コード;
    }

    /**
     * 住所コード名称を返します。
     *
     * @return 住所コード名称 RString
     */
    public RString get住所コード名称() {
        return 住所コード名称;
    }

    /**
     * 住所表示を返します。
     *
     * @return 住所表示 RString
     */
    public RString get住所表示() {
        return 住所表示;
    }

    /**
     * 宛名コードを返します。
     *
     * @return 宛名コード RString
     */
    public RString get宛名コード() {
        return 宛名コード;
    }

    /**
     * 宛名コード名称を返します。
     *
     * @return 宛名コード名称 RString
     */
    public RString get宛名コード名称() {
        return 宛名コード名称;
    }

    /**
     * 名称_上段を返します。
     *
     * @return 名称_上段 RString
     */
    public RString get名称_上段() {
        return 名称_上段;
    }

    /**
     * 名称_下段を返します。
     *
     * @return 名称_下段 RString
     */
    public RString get名称_下段() {
        return 名称_下段;
    }

    /**
     * 世帯主敬称コードを返します。
     *
     * @return 世帯主敬称コード RString
     */
    public RString get世帯主敬称コード() {
        return 世帯主敬称コード;
    }

    /**
     * 世帯主敬称を返します。
     *
     * @return 世帯主敬称 RString
     */
    public RString get世帯主敬称() {
        return 世帯主敬称;
    }

    /**
     * 本人敬称コードを返します。
     *
     * @return 本人敬称コード RString
     */
    public RString get本人敬称コード() {
        return 本人敬称コード;
    }

    /**
     * 本人敬称を返します。
     *
     * @return 本人敬称 RString
     */
    public RString get本人敬称() {
        return 本人敬称;
    }

    /**
     * 四隅項目コード_左下隅を返します。
     *
     * @return 四隅項目コード_左下隅 RString
     */
    public RString get四隅項目コード_左下隅() {
        return 四隅項目コード_左下隅;
    }

    /**
     * 四隅項目_左下隅を返します。
     *
     * @return 四隅項目_左下隅 RString
     */
    public RString get四隅項目_左下隅() {
        return 四隅項目_左下隅;
    }

    /**
     * 四隅項目コード_右下隅を返します。
     *
     * @return 四隅項目コード_右下隅 RString
     */
    public RString get四隅項目コード_右下隅() {
        return 四隅項目コード_右下隅;
    }

    /**
     * 四隅項目_右下隅を返します。
     *
     * @return 四隅項目_右下隅 RString
     */
    public RString get四隅項目_右下隅() {
        return 四隅項目_右下隅;
    }

    /**
     * 住所の前に市町村名を付加を返します。
     *
     * @return 住所の前に市町村名を付加 RString
     */
    public RString get住所の前に市町村名を付加() {
        return 住所の前に市町村名を付加;
    }

    /**
     * 世帯主のみ印刷対象とする有無を返します。
     *
     * @return 世帯主のみ印刷対象とする有無 RString
     */
    public Boolean is世帯主のみ印刷対象とする有無() {
        return 世帯主のみ印刷対象とする有無;
    }

    /**
     * 開始印字位置番号を返します。
     *
     * @return 開始印字位置番号 RString
     */
    public RString get開始印字位置番号() {
        return 開始印字位置番号;
    }

    /**
     * 抄本名を返します。
     *
     * @return 抄本名 RString
     */
    public RString get抄本名() {
        return 抄本名;
    }

    /**
     * 年齢到達期限日を返します。
     *
     * @return 年齢到達期限日 RString
     */
    public FlexibleDate get年齢到達期限日() {
        return 年齢到達期限日;
    }

    /**
     * 投票年月日を返します。
     *
     * @return 投票年月日 RString
     */
    public FlexibleDate get投票年月日() {
        return 投票年月日;
    }

    /**
     * 前回基準日を返します。
     *
     * @return 前回基準日 RString
     */
    public FlexibleDate get前回基準日() {
        return 前回基準日;
    }

    /**
     * 起動画面IDを設定します。
     *
     * @param 起動画面ID RString
     */
    public void set起動画面ID(RString 起動画面ID) {
        this.起動画面ID = 起動画面ID;
    }

    /**
     * 抄本番号を設定します。
     *
     * @param 抄本番号 RString
     */
    public void set抄本番号(RString 抄本番号) {
        this.抄本番号 = 抄本番号;
    }

    /**
     * 抄本名を設定します。
     *
     * @param 抄本名 RString
     */
    public void set抄本名(RString 抄本名) {
        this.抄本名 = 抄本名;
    }

    /**
     * 住所条件を設定します。
     *
     * @param 住所条件 RString
     */
    public void set住所条件(RString 住所条件) {
        this.住所条件 = 住所条件;
    }

    /**
     * List<JushoIchiranMeisai>を設定します。
     *
     * @param 住所一覧リスト List<JushoIchiranMeisai>
     */
    public void set住所一覧リスト(List<JushoIchiranMeisai> 住所一覧リスト) {
        this.住所一覧リスト = 住所一覧リスト;
    }

    /**
     * 対象選挙を設定します。
     *
     * @param 対象選挙 RString
     */
    public void set対象選挙(SenkyoNo 対象選挙) {
        this.対象選挙 = 対象選挙;
    }

    /**
     * 対象選挙名称を設定します。
     *
     * @param 対象選挙名称 RString
     */
    public void set対象選挙名称(RString 対象選挙名称) {
        this.対象選挙名称 = 対象選挙名称;
    }

    /**
     * 対象期間FROMを設定します。
     *
     * @param 対象期間FROM RDate
     */
    public void set対象期間FROM(RDate 対象期間FROM) {
        this.対象期間FROM = 対象期間FROM;
    }

    /**
     * 対象期間TOを設定します。
     *
     * @param 対象期間TO RDate
     */
    public void set対象期間TO(RDate 対象期間TO) {
        this.対象期間TO = 対象期間TO;
    }

    /**
     * 施設種別を設定します。
     *
     * @param 施設種別 RString
     */
    public void set施設種別(RString 施設種別) {
        this.施設種別 = 施設種別;
    }

    /**
     * 施設種別名称を設定します。
     *
     * @param 施設種別名称 RString
     */
    public void set施設種別名称(RString 施設種別名称) {
        this.施設種別名称 = 施設種別名称;
    }

    /**
     * 施設コードFROMを設定します。
     *
     * @param 施設コードFROM RString
     */
    public void set施設コードFROM(RString 施設コードFROM) {
        this.施設コードFROM = 施設コードFROM;
    }

    /**
     * 施設名称FROMを設定します。
     *
     * @param 施設名称FROM RString
     */
    public void set施設名称FROM(RString 施設名称FROM) {
        this.施設名称FROM = 施設名称FROM;
    }

    /**
     * 施設コードTOを設定します。
     *
     * @param 施設コードTO RString
     */
    public void set施設コードTO(RString 施設コードTO) {
        this.施設コードTO = 施設コードTO;
    }

    /**
     * 施設名称TOを設定します。
     *
     * @param 施設名称TO RString
     */
    public void set施設名称TO(RString 施設名称TO) {
        this.施設名称TO = 施設名称TO;
    }

    /**
     * 四隅項目コード_右上隅を設定します。
     *
     * @param 四隅項目コード_右上隅 RString
     */
    public void set四隅項目コード_右上隅(RString 四隅項目コード_右上隅) {
        this.四隅項目コード_右上隅 = 四隅項目コード_右上隅;
    }

    /**
     * 四隅項目_右上隅を設定します。
     *
     * @param 四隅項目_右上隅 RString
     */
    public void set四隅項目_右上隅(RString 四隅項目_右上隅) {
        this.四隅項目_右上隅 = 四隅項目_右上隅;
    }

    /**
     * 住所コードを設定します。
     *
     * @param 住所コード RString
     */
    public void set住所コード(RString 住所コード) {
        this.住所コード = 住所コード;
    }

    /**
     * 住所コード名称を設定します。
     *
     * @param 住所コード名称 RString
     */
    public void set住所コード名称(RString 住所コード名称) {
        this.住所コード名称 = 住所コード名称;
    }

    /**
     * 住所表示を設定します。
     *
     * @param 住所表示 RString
     */
    public void set住所表示(RString 住所表示) {
        this.住所表示 = 住所表示;
    }

    /**
     * 宛名コードを設定します。
     *
     * @param 宛名コード RString
     */
    public void set宛名コード(RString 宛名コード) {
        this.宛名コード = 宛名コード;
    }

    /**
     * 宛名コード名称を設定します。
     *
     * @param 宛名コード名称 RString
     */
    public void set宛名コード名称(RString 宛名コード名称) {
        this.宛名コード名称 = 宛名コード名称;
    }

    /**
     * 名称_上段を設定します。
     *
     * @param 名称_上段 RString
     */
    public void set名称_上段(RString 名称_上段) {
        this.名称_上段 = 名称_上段;
    }

    /**
     * 名称_下段を設定します。
     *
     * @param 名称_下段 RString
     */
    public void set名称_下段(RString 名称_下段) {
        this.名称_下段 = 名称_下段;
    }

    /**
     * 世帯主敬称コードを設定します。
     *
     * @param 世帯主敬称コード RString
     */
    public void set世帯主敬称コード(RString 世帯主敬称コード) {
        this.世帯主敬称コード = 世帯主敬称コード;
    }

    /**
     * 世帯主敬称を設定します。
     *
     * @param 世帯主敬称 RString
     */
    public void set世帯主敬称(RString 世帯主敬称) {
        this.世帯主敬称 = 世帯主敬称;
    }

    /**
     * 本人敬称コードを設定します。
     *
     * @param 本人敬称コード RString
     */
    public void set本人敬称コード(RString 本人敬称コード) {
        this.本人敬称コード = 本人敬称コード;
    }

    /**
     * 本人敬称を設定します。
     *
     * @param 本人敬称 RString
     */
    public void set本人敬称(RString 本人敬称) {
        this.本人敬称 = 本人敬称;
    }

    /**
     * 四隅項目コード_左下隅を設定します。
     *
     * @param 四隅項目コード_左下隅 RString
     */
    public void set四隅項目コード_左下隅(RString 四隅項目コード_左下隅) {
        this.四隅項目コード_左下隅 = 四隅項目コード_左下隅;
    }

    /**
     * 四隅項目_左下隅を設定します。
     *
     * @param 四隅項目_左下隅 RString
     */
    public void set四隅項目_左下隅(RString 四隅項目_左下隅) {
        this.四隅項目_左下隅 = 四隅項目_左下隅;
    }

    /**
     * 四隅項目コード_右下隅を設定します。
     *
     * @param 四隅項目コード_右下隅 RString
     */
    public void set四隅項目コード_右下隅(RString 四隅項目コード_右下隅) {
        this.四隅項目コード_右下隅 = 四隅項目コード_右下隅;
    }

    /**
     * 四隅項目_右下隅を設定します。
     *
     * @param 四隅項目_右下隅 RString
     */
    public void set四隅項目_右下隅(RString 四隅項目_右下隅) {
        this.四隅項目_右下隅 = 四隅項目_右下隅;
    }

    /**
     * 住所の前に市町村名を付加を設定します。
     *
     * @param 住所の前に市町村名を付加 RString
     */
    public void set住所の前に市町村名を付加(RString 住所の前に市町村名を付加) {
        this.住所の前に市町村名を付加 = 住所の前に市町村名を付加;
    }

    /**
     * 世帯主のみ印刷対象とする有無を設定します。
     *
     * @param 世帯主のみ印刷対象とする有無 Boolean
     */
    public void set世帯主のみ印刷対象とする有無(Boolean 世帯主のみ印刷対象とする有無) {
        this.世帯主のみ印刷対象とする有無 = 世帯主のみ印刷対象とする有無;
    }

    /**
     * 開始印字位置番号を設定します。
     *
     * @param 開始印字位置番号 RString
     */
    public void set開始印字位置番号(RString 開始印字位置番号) {
        this.開始印字位置番号 = 開始印字位置番号;
    }

    /**
     * shikibetsutaishoParamを付加を返します。
     *
     * @return shikibetsutaishoParam IShikibetsuTaishoPSMSearchKey
     */
    public IShikibetsuTaishoPSMSearchKey getShikibetsutaishoParam() {
        return shikibetsutaishoParam;
    }

    /**
     * shikibetsutaishoParamを設定します。
     *
     * @param shikibetsutaishoParam IShikibetsuTaishoPSMSearchKey
     */
    public void setShikibetsutaishoParam(IShikibetsuTaishoPSMSearchKey shikibetsutaishoParam) {
        this.shikibetsutaishoParam = shikibetsutaishoParam;
    }

    /**
     * 選挙レベルを付加を返します。
     *
     * @return 選挙レベル RString
     */
    public RString get選挙レベル() {
        return 選挙レベル;
    }

    /**
     * 選挙レベルを設定します。
     *
     * @param 選挙レベル RString
     */
    public void set選挙レベル(RString 選挙レベル) {
        this.選挙レベル = 選挙レベル;
    }

    /**
     * 年齢到達期限日を設定します。
     *
     * @param 年齢到達期限日 FlexibleDate
     */
    public void set年齢到達期限日(FlexibleDate 年齢到達期限日) {
        this.年齢到達期限日 = 年齢到達期限日;
    }

    /**
     * 投票年月日を設定します。
     *
     * @param 投票年月日 FlexibleDate
     */
    public void set投票年月日(FlexibleDate 投票年月日) {
        this.投票年月日 = 投票年月日;
    }

    /**
     * 前回基準日を設定します。
     *
     * @param 前回基準日 FlexibleDate
     */
    public void set前回基準日(FlexibleDate 前回基準日) {
        this.前回基準日 = 前回基準日;
    }

}
