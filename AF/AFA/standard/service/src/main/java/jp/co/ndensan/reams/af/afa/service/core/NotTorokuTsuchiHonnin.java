/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KyakkaJiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShichosonKubun;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT510RyojikanDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 登録を行わなかった旨の通知（本人）
 *
 * @reamsid_L AF-0320-021 zhanggs
 */
public class NotTorokuTsuchiHonnin {

    private static final int 発行番号_右詰桁数 = 10;
    private static final int インデックス_通知元市町村名１ = 0;
    private static final int インデックス_通知元市町村名２ = 1;
    private static final int インデックス_委員長名１ = 0;
    private static final int インデックス_委員長名２ = 1;
    private static final int インデックス_本人氏名１ = 0;
    private static final int インデックス_本人氏名２ = 1;
    private static final int インデックス_氏名 = 0;
    private static final int インデックス_氏名１ = 1;
    private static final int インデックス_氏名２ = 2;
    private static final int インデックス_通知先市町村１ = 0;
    private static final int インデックス_通知先市町村２ = 1;
    private static final int インデックス_領事官 = 0;
    private static final int インデックス_領事官1 = 1;
    private static final int インデックス_領事官2 = 2;
    private static final int インデックス_理由１ = 0;
    private static final int インデックス_理由２ = 1;
    private static final int インデックス_理由３ = 2;
    private static final int インデックス_理由４ = 3;
    private static final int インデックス_理由５ = 4;
    private static final int インデックス_理由６ = 5;
    private static final int インデックス_理由７ = 6;
    private static final int インデックス_理由８ = 7;
    private static final int インデックス_理由９ = 8;
    private static final int インデックス_本文１ = 0;
    private static final int インデックス_本文２ = 1;
    private static final int インデックス_本文３ = 2;
    private static final int インデックス_本文４ = 3;
    private static final int インデックス_本文５ = 4;
    private static final int インデックス_本文６ = 5;
    private static final int インデックス_連絡先住所１ = 0;
    private static final int インデックス_連絡先住所２ = 1;
    private static final int インデックス_連絡先タイトル１ = 0;
    private static final int インデックス_連絡先１ = 1;
    private static final int インデックス_連絡先タイトル２ = 2;
    private static final int インデックス_連絡先２ = 3;
    private static final int インデックス_連絡先タイトル３ = 4;
    private static final int インデックス_連絡先３ = 5;
    private static final int 文本倍数_２倍 = 2;
    private static final int 文本倍数_３倍 = 3;
    private static final int 文本倍数_４倍 = 4;
    private static final int 文本倍数_５倍 = 5;
    private static final RString コード_０１ = new RString("01");
    private static final RString コード_０２ = new RString("02");
    private static final RString 連絡先_０１ = new RString("01");
    private static final RString 連絡先_０２ = new RString("02");
    private static final RString 連絡先_０３ = new RString("03");
    private static final RString 却下事由コード_丸印 = new RString("○");
    private static final RString 委員長 = new RString("委員長");
    private static final RString 全角スペース = new RString("　");
    private static final RString 漢字氏名_殿 = new RString("殿");
    private static final int メニューID_前7桁 = 7;
    private static final RString パラメータ１ = new RString("%1");
    private static final RString パラメータ２ = new RString("%2");
    private static final RString パラメータ３ = new RString("%3");
    private static final RString パラメータ４ = new RString("%4");
    private static final RString パラメータ５ = new RString("%5");
    private static final RString 半角空白 = new RString(" ");
    private static final char 空白 = ' ';

    private final AfT510RyojikanDac dac;

    /**
     * コンストラクタです。
     */
    public NotTorokuTsuchiHonnin() {
        dac = InstanceProvider.create(AfT510RyojikanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT510RyojikanDac}
     */
    NotTorokuTsuchiHonnin(AfT510RyojikanDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NotTorokuTsuchiHonnin}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NotTorokuTsuchiHonnin}のインスタンス
     */
    public static NotTorokuTsuchiHonnin createInstance() {
        return InstanceProvider.create(NotTorokuTsuchiHonnin.class);
    }

    /**
     * パラメータより、発行番号を取得する。
     *
     * @param 発行番号_第 RString
     * @param 発行番号_号 RString
     * @param 画面入力発行番号 RString
     * @return 発行番号 RString
     */
    public RString get発行番号(RString 発行番号_第, RString 発行番号_号, RString 画面入力発行番号) {
        発行番号_第 = changeNullToEmpty(発行番号_第);
        発行番号_号 = changeNullToEmpty(発行番号_号);
        画面入力発行番号 = changeNullToEmpty(画面入力発行番号);
        return 発行番号_第.concat(画面入力発行番号.padLeft(発行番号_右詰桁数)).concat(発行番号_号);
    }

    /**
     * 通知元市町村１～２を取得する。
     *
     * @param 長さ_通知元市町村名１ int
     * @param 長さ_通知元市町村名２ int
     * @return 通知元市町村名リスト List<RString>{通知元市町村名１,通知元市町村名２}
     */
    public List<RString> get通知元市町村１_２(int 長さ_通知元市町村名１, int 長さ_通知元市町村名２) {
        List<RString> 通知元市町村名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_通知元市町村名２; i++) {
            通知元市町村名リスト.add(RString.EMPTY);
        }
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        if (null != 地方公共団体情報) {
            RString 通知元市町村名 = changeNullToEmpty(地方公共団体情報.get都道府県名())
                    .concat(changeNullToEmpty(地方公共団体情報.get郡名()))
                    .concat(changeNullToEmpty(地方公共団体情報.get市町村名()));
            if (長さ_通知元市町村名１ >= 通知元市町村名.length()) {
                通知元市町村名リスト.set(インデックス_通知元市町村名１, 通知元市町村名);
            }
            if (長さ_通知元市町村名１ < 通知元市町村名.length() && 長さ_通知元市町村名２ >= 通知元市町村名.length()) {
                通知元市町村名リスト.set(インデックス_通知元市町村名２, 通知元市町村名);
            }
            if (長さ_通知元市町村名２ < 通知元市町村名.length()) {
                通知元市町村名リスト.set(インデックス_通知元市町村名１, 通知元市町村名.substring(長さ_通知元市町村名２));
                通知元市町村名リスト.set(インデックス_通知元市町村名２, 通知元市町村名.substring(0, 長さ_通知元市町村名２));
            }
        }
        return 通知元市町村名リスト;
    }

    /**
     * パラメータより、委員長名１～２を取得する。
     *
     * @param 画面入力委員長名 RString
     * @param 長さ_委員長名１ int
     * @return 委員長名リスト List<RString>{委員長名１,委員長名２}
     */
    public List<RString> get委員長名１_２(RString 画面入力委員長名, int 長さ_委員長名１) {
        List<RString> 委員長名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_委員長名２; i++) {
            委員長名リスト.add(RString.EMPTY);
        }
        画面入力委員長名 = 委員長.concat(全角スペース).concat(changeNullToEmpty(画面入力委員長名));
        if (長さ_委員長名１ >= 画面入力委員長名.length()) {
            委員長名リスト.set(インデックス_委員長名１, 画面入力委員長名);
        } else {
            委員長名リスト.set(インデックス_委員長名１, 画面入力委員長名.substring(0, 長さ_委員長名１));
            委員長名リスト.set(インデックス_委員長名２, 画面入力委員長名.substring(長さ_委員長名１));
        }
        return 委員長名リスト;
    }

    /**
     * パラメータより、本人氏名１～2を取得する。
     *
     * @param 漢字氏名 RString
     * @param 長さ_本人氏名１ int
     * @return 本人氏名リスト List<RString>{本人氏名１,本人氏名２}
     */
    public List<RString> get本人氏名１_２(RString 漢字氏名, int 長さ_本人氏名１) {
        List<RString> 本人氏名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_本人氏名２; i++) {
            本人氏名リスト.add(RString.EMPTY);
        }
        漢字氏名 = changeNullToEmpty(漢字氏名).concat(全角スペース).concat(漢字氏名_殿);
        if (長さ_本人氏名１ >= 漢字氏名.length()) {
            本人氏名リスト.set(インデックス_本人氏名１, 漢字氏名);
        } else {
            本人氏名リスト.set(インデックス_本人氏名１, 漢字氏名.substring(0, 長さ_本人氏名１));
            本人氏名リスト.set(インデックス_本人氏名２, 漢字氏名.substring(長さ_本人氏名１));
        }
        return 本人氏名リスト;
    }

    /**
     * パラメータより、氏名と氏名１～２を取得する。
     *
     * @param 漢字氏名 RString
     * @param 長さ_氏名１ int
     * @return 氏名リスト List<RString>{氏名１,氏名２}
     */
    public List<RString> get氏名と氏名１_２(RString 漢字氏名, int 長さ_氏名１) {
        List<RString> 氏名リスト = new ArrayList();
        for (int i = 0; i <= インデックス_氏名２; i++) {
            氏名リスト.add(RString.EMPTY);
        }
        漢字氏名 = changeNullToEmpty(漢字氏名);
        if (長さ_氏名１ >= 漢字氏名.length()) {
            氏名リスト.set(インデックス_氏名, 漢字氏名);
        } else {
            氏名リスト.set(インデックス_氏名１, 漢字氏名.substring(0, 長さ_氏名１));
            氏名リスト.set(インデックス_氏名２, 漢字氏名.substring(長さ_氏名１));
        }
        return 氏名リスト;
    }

    /**
     * パラメータより、領事官名称を取得する。
     *
     * @param 領事官コード RString
     * @return 領事官名称 RString
     */
    public RString get領事官名称(RString 領事官コード) {
        AfT510RyojikanEntity entity = dac.select(領事官コード);
        return null == entity ? RString.EMPTY : entity.getRyojikanName();
    }

    /**
     * パラメータより、領事官と領事官１～２取得。
     *
     * @param 領事官名称 RString
     * @param 長さ_領事官 int
     * @param 長さ_領事官1 int
     * @return List<RString>{領事官,領事官1,領事官2}
     */
    public List<RString> get領事官と領事官１_２(RString 領事官名称, int 長さ_領事官, int 長さ_領事官1) {
        List<RString> 領事官リスト = new ArrayList();
        for (int i = 0; i < インデックス_領事官2; i++) {
            領事官リスト.add(RString.EMPTY);
        }
        領事官名称 = changeNullToEmpty(領事官名称);
        if (長さ_領事官 >= 領事官名称.length()) {
            領事官リスト.add(インデックス_領事官, 領事官名称);
        } else if (長さ_領事官1 >= 領事官名称.length()) {
            領事官リスト.add(インデックス_領事官1, 領事官名称);
        } else {
            領事官リスト.add(インデックス_領事官1, 領事官名称.substring(0, 長さ_領事官1));
            領事官リスト.add(インデックス_領事官2, 領事官名称.substring(長さ_領事官1));

        }
        return 領事官リスト;
    }

    /**
     * 市区町村区分を取得する。
     *
     * @return 市区町村区分 RString
     */
    public RString get市区町村区分() {
        RString 市区町村区分 = RString.EMPTY;
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        if (ShichosonKubun.区.getKey() == 地方公共団体情報.get市町村区分().getColumnValue()) {
            市区町村区分 = ShichosonKubun.区.getValue();
        }
        if (ShichosonKubun.市.getKey() == 地方公共団体情報.get市町村区分().getColumnValue()) {
            市区町村区分 = ShichosonKubun.市.getValue();
        }
        if (ShichosonKubun.町.getKey() == 地方公共団体情報.get市町村区分().getColumnValue()) {
            市区町村区分 = ShichosonKubun.町.getValue();
        }
        if (ShichosonKubun.村.getKey() == 地方公共団体情報.get市町村区分().getColumnValue()) {
            市区町村区分 = ShichosonKubun.村.getValue();
        }
        return 市区町村区分;
    }

    /**
     * パラメータより、領事官１～２を取得する。
     *
     * @param 領事官名称 RString
     * @param 長さ_通知先市町村１ int
     * @return 通知先市町村リスト List<RString>{通知先市町村１,通知先市町村２}
     */
    public List<RString> get領事官１_２(RString 領事官名称, int 長さ_通知先市町村１) {
        List<RString> 通知先市町村リスト = new ArrayList();
        for (int i = 0; i <= インデックス_通知先市町村２; i++) {
            通知先市町村リスト.add(RString.EMPTY);
        }
        領事官名称 = changeNullToEmpty(領事官名称);

        if (長さ_通知先市町村１ >= 領事官名称.length()) {
            通知先市町村リスト.set(インデックス_通知先市町村１, 領事官名称);
        } else {
            通知先市町村リスト.set(インデックス_通知先市町村２, 領事官名称);
        }
        return 通知先市町村リスト;
    }

    /**
     * パラメータより、理由１～９を取得する。
     *
     * @param 却下事由コード RString
     * @return 理由リスト List<RString>{理由１,理由２,理由３,理由４,理由５,理由６,理由７,理由８,理由９}
     */
    public List<RString> get理由１_９(RString 却下事由コード) {
        List<RString> 理由リスト = new ArrayList();
        for (int i = 0; i <= インデックス_理由９; i++) {
            理由リスト.add(RString.EMPTY);
        }
        if (KyakkaJiyuCode.本人確認.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由１, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.同居家族等確認.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由２, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.登録済.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由３, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.年齢要件.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由４, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.国籍.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由５, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.公民権停止.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由６, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.居住要件.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由７, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.申請先誤り.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由８, 却下事由コード_丸印);
        }
        if (KyakkaJiyuCode.その他.getKey().equals(却下事由コード)) {
            理由リスト.set(インデックス_理由９, 却下事由コード_丸印);
        }
        return 理由リスト;
    }

    /**
     * メニューIDより、選挙種類を取得する。
     *
     * @return 選挙種類名称 RString
     */
    public RString get選挙種類() {
        RString 選挙種類コード = RString.EMPTY;
        RString menuID = ResponseHolder.getMenuID();
        if (!RString.isNullOrEmpty(menuID)) {
            if (menuID.startsWith(AFAMenuId.AFAMNB3010_名簿登録.menuId().substring(0, メニューID_前7桁))) {
                選挙種類コード = SenkyoShurui.国政選挙_地方選挙.getCode();
            }
            if (menuID.startsWith(AFAMenuId.AFAMNG3010_名簿登録.menuId().substring(0, メニューID_前7桁))) {
                選挙種類コード = SenkyoShurui.憲法改正国民投票.getCode();
            }
        }
        return CodeMaster.getOption1(AFACodeShubetsu.選挙種類.getCodeShubetsu(), new Code(選挙種類コード));
    }

    /**
     * パラメータより、本文を取得する。
     *
     * @param コード種別 CodeShubetsu
     * @param 長さ_本文１ int
     * @param 長さ_本文２ int
     * @param 長さ_本文３ int
     * @param 長さ_本文４ int
     * @param 長さ_本文５ int
     * @param 申請日 RDate
     * @param 領事官コード RString
     * @return 本文リスト List<RString>{本文１、本文２、本文３、本文４、本文５、本文６}
     */
    public List<RString> get本文(CodeShubetsu コード種別, int 長さ_本文１, int 長さ_本文２, int 長さ_本文３, int 長さ_本文４,
            int 長さ_本文５, FlexibleDate 申請日, RString 領事官コード) {
        List<RString> 本文リスト = new ArrayList();
        for (int i = 0; i <= インデックス_本文６; i++) {
            本文リスト.add(RString.EMPTY);
        }
        List<UzT0007CodeEntity> codeEntityList = CodeMaster.getCode(SubGyomuCode.AFA選挙本体, コード種別);
        if (null == codeEntityList || codeEntityList.isEmpty()) {
            return 本文リスト;
        }
        RString 編集本文１ = RString.EMPTY;
        RString 編集本文２ = RString.EMPTY;
        for (UzT0007CodeEntity codeEntity : codeEntityList) {
            if (コード_０１.equals(codeEntity.getコード().getColumnValue())) {
                編集本文１ = codeEntity.getコード名称();
            }
            if (コード_０２.equals(codeEntity.getコード().getColumnValue())) {
                編集本文２ = codeEntity.getコード名称();
            }
        }
        if (AFACodeShubetsu.固定文_登録した旨の通知.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_登録した旨の通知(本文リスト, 編集本文１, 長さ_本文１);
        }
        if (AFACodeShubetsu.固定文_登録を行わなかった旨の通知_本人.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_登録を行わなかった旨の通知_本人(本文リスト, 編集本文１, 長さ_本文１, 長さ_本文２, 申請日, 領事官コード);
        }
        if (AFACodeShubetsu.固定文_登録を行わなかった旨の通知_領事官.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_登録を行わなかった旨の通知_領事官(本文リスト, 編集本文１, 編集本文２, 長さ_本文１, 申請日, 領事官コード);
        }
        if (AFACodeShubetsu.固定文_記載事項変更通知_本人.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_記載事項変更通知_本人(本文リスト, 編集本文１, 編集本文２, 長さ_本文１, 申請日, 領事官コード);
        }
        if (AFACodeShubetsu.固定文_記載事項変更通知_領事官.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_記載事項変更通知_領事官(本文リスト, 編集本文１, 長さ_本文１, 長さ_本文２);
        }
        if (AFACodeShubetsu.固定文_再交付通知.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_再交付通知(本文リスト, 編集本文１, 長さ_本文１, 長さ_本文２, 長さ_本文３, 長さ_本文４, 長さ_本文５, 領事官コード);
        }
        if (AFACodeShubetsu.固定文_抹消通知_本籍地.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_抹消通知_本籍地(本文リスト, 編集本文１, 長さ_本文１);
        }
        if (AFACodeShubetsu.固定文_抹消通知_領事官.getCodeShubetsu().equals(コード種別)) {
            本文リスト = edit固定文_抹消通知_領事官(本文リスト, 編集本文１, 長さ_本文１, 長さ_本文２);
        }
        return 本文リスト;
    }

    private List<RString> edit固定文_登録した旨の通知(List<RString> 登録した旨の通知_本文リスト,
            RString 登録した旨の通知編集本文１, int 長さ_本文１) {
        登録した旨の通知編集本文１ = replace文字列(登録した旨の通知編集本文１, パラメータ１, get市区町村区分());
        登録した旨の通知編集本文１ = replace文字列(登録した旨の通知編集本文１, パラメータ２, get選挙種類());
        登録した旨の通知編集本文１ = changeNullToEmpty(登録した旨の通知編集本文１);
        if (長さ_本文１ >= 登録した旨の通知編集本文１.length()) {
            登録した旨の通知_本文リスト.set(インデックス_本文１, 登録した旨の通知編集本文１);
        } else {
            登録した旨の通知_本文リスト.set(インデックス_本文１, 登録した旨の通知編集本文１.substring(0, 長さ_本文１));
            登録した旨の通知_本文リスト.set(インデックス_本文２, 登録した旨の通知編集本文１.substring(長さ_本文１));
        }
        return 登録した旨の通知_本文リスト;
    }

    private List<RString> edit固定文_登録を行わなかった旨の通知_本人(List<RString> 登録を行わなかった旨の通知_本人_本文リスト,
            RString 編集本文１, int 長さ_本文１, int 長さ_本文２, FlexibleDate 申請日, RString 領事官コード) {
        編集本文１ = replace文字列(編集本文１, パラメータ１, get日付編集(申請日));
        編集本文１ = replace文字列(編集本文１, パラメータ２, get領事官名称(領事官コード));
        編集本文１ = replace文字列(編集本文１, パラメータ３, get選挙種類());
        編集本文１ = changeNullToEmpty(編集本文１);
        if (長さ_本文１ >= 編集本文１.length()) {
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文１, 編集本文１);
        } else if ((長さ_本文１ + 長さ_本文２) >= 編集本文１.length()) {
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１));
        } else {
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１, 長さ_本文１ + 長さ_本文２));
            登録を行わなかった旨の通知_本人_本文リスト.set(インデックス_本文３, 編集本文１.substring(長さ_本文１ + 長さ_本文２));
        }
        return 登録を行わなかった旨の通知_本人_本文リスト;
    }

    private List<RString> edit固定文_登録を行わなかった旨の通知_領事官(List<RString> 登録を行わなかった旨の通知_領事官_本文リスト,
            RString 編集本文１, RString 編集本文２, int 長さ_本文１, FlexibleDate 申請日, RString 領事官コード) {
        編集本文１ = replace文字列(編集本文１, パラメータ１, get日付編集(申請日));
        編集本文１ = replace文字列(編集本文１, パラメータ２, get領事官名称(領事官コード));
        編集本文１ = replace文字列(編集本文１, パラメータ３, get選挙種類());
        編集本文１ = changeNullToEmpty(編集本文１);
        if (長さ_本文１ >= 編集本文１.length()) {
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文１, 編集本文１);
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文２, 編集本文２);
        } else if (長さ_本文１ * 文本倍数_２倍 >= 編集本文１.length()) {
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文３, 編集本文２);
        } else if (長さ_本文１ * 文本倍数_３倍 >= 編集本文１.length()) {
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文３, 編集本文１.substring(長さ_本文１ * 文本倍数_２倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文４, 編集本文２);
        } else if (長さ_本文１ * 文本倍数_４倍 >= 編集本文１.length()) {
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文３, 編集本文１.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文４, 編集本文１.substring(長さ_本文１ * 文本倍数_３倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文５, 編集本文２);
        } else if (長さ_本文１ * 文本倍数_５倍 >= 編集本文１.length()) {
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文１, 編集本文１.substring(0, 長さ_本文１));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文２, 編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文３, 編集本文１.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文４, 編集本文１.substring(長さ_本文１ * 文本倍数_３倍, 長さ_本文１ * 文本倍数_４倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文５, 編集本文１.substring(長さ_本文１ * 文本倍数_４倍));
            登録を行わなかった旨の通知_領事官_本文リスト.set(インデックス_本文６, 編集本文２);
        }
        return 登録を行わなかった旨の通知_領事官_本文リスト;
    }

    private List<RString> edit固定文_記載事項変更通知_本人(List<RString> 記載事項変更通知_本人_本文リスト,
            RString 記載事項変更通知編集本文１, RString 記載事項変更通知編集本文２, int 長さ_本文１, FlexibleDate 申請日, RString 領事官コード) {
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ１, get日付編集(申請日));
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ２, get領事官名称(領事官コード));
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ３, get市区町村区分());
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ４, get選挙種類());
        記載事項変更通知編集本文１ = changeNullToEmpty(記載事項変更通知編集本文１);
        記載事項変更通知編集本文２ = changeNullToEmpty(記載事項変更通知編集本文２);
        記載事項変更通知編集本文２ = 記載事項変更通知編集本文２.padRight(半角空白, 長さ_本文１ * 文本倍数_５倍);
        if (長さ_本文１ >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_本人_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１);
            記載事項変更通知_本人_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文２.substring(0, 長さ_本文１).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文２.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文４, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文５, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_３倍, 長さ_本文１ * 文本倍数_４倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文６, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_４倍, 長さ_本文１ * 文本倍数_５倍).trimEnd(空白));
        } else if (長さ_本文１ * 文本倍数_２倍 >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_本人_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文２.substring(0, 長さ_本文１).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文４, 記載事項変更通知編集本文２.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文５, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文６, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_３倍, 長さ_本文１ * 文本倍数_４倍).trimEnd(空白));
        } else if (長さ_本文１ * 文本倍数_３倍 >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_本人_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_２倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文４, 記載事項変更通知編集本文２.substring(0, 長さ_本文１).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文５, 記載事項変更通知編集本文２.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文６, 記載事項変更通知編集本文２.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍).trimEnd(空白));
        } else if (長さ_本文１ * 文本倍数_４倍 >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_本人_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文４, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_３倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文５, 記載事項変更通知編集本文２.substring(0, 長さ_本文１).trimEnd(空白));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文６, 記載事項変更通知編集本文２.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍).trimEnd(空白));
        } else if (長さ_本文１ * 文本倍数_５倍 >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_本人_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１, 長さ_本文１ * 文本倍数_２倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_２倍, 長さ_本文１ * 文本倍数_３倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文４, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_３倍, 長さ_本文１ * 文本倍数_４倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文５, 記載事項変更通知編集本文１.substring(長さ_本文１ * 文本倍数_４倍));
            記載事項変更通知_本人_本文リスト.set(インデックス_本文６, 記載事項変更通知編集本文２.substring(0, 長さ_本文１).trimEnd(空白));
        }
        return 記載事項変更通知_本人_本文リスト;
    }

    private List<RString> edit固定文_記載事項変更通知_領事官(List<RString> 記載事項変更通知_領事官_本文リスト,
            RString 記載事項変更通知編集本文１, int 長さ_本文１, int 長さ_本文２) {
        RString 選挙種類 = get選挙種類();
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ１, 選挙種類);
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ２, get市区町村区分());
        記載事項変更通知編集本文１ = replace文字列(記載事項変更通知編集本文１, パラメータ３, 選挙種類);
        記載事項変更通知編集本文１ = changeNullToEmpty(記載事項変更通知編集本文１);
        if (長さ_本文１ >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１);
        } else if ((長さ_本文１ + 長さ_本文２) >= 記載事項変更通知編集本文１.length()) {
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１));
        } else {
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文１, 記載事項変更通知編集本文１.substring(0, 長さ_本文１));
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文２, 記載事項変更通知編集本文１.substring(長さ_本文１, 長さ_本文１ + 長さ_本文２));
            記載事項変更通知_領事官_本文リスト.set(インデックス_本文３, 記載事項変更通知編集本文１.substring(長さ_本文１ + 長さ_本文２));
        }
        return 記載事項変更通知_領事官_本文リスト;
    }

    private List<RString> edit固定文_再交付通知(List<RString> 再交付通知_本文リスト,
            RString 再交付通知編集本文１, int 長さ_本文１, int 長さ_本文２, int 長さ_本文３, int 長さ_本文４, int 長さ_本文５, RString 領事官コード) {
        RString 市区町村区分 = get市区町村区分();
        RString 選挙種類 = get選挙種類();
        再交付通知編集本文１ = replace文字列(再交付通知編集本文１, パラメータ１, 市区町村区分);
        再交付通知編集本文１ = replace文字列(再交付通知編集本文１, パラメータ２, 選挙種類);
        再交付通知編集本文１ = replace文字列(再交付通知編集本文１, パラメータ３, get領事官名称(領事官コード));
        再交付通知編集本文１ = replace文字列(再交付通知編集本文１, パラメータ４, 市区町村区分);
        再交付通知編集本文１ = replace文字列(再交付通知編集本文１, パラメータ５, 選挙種類);
        再交付通知編集本文１ = changeNullToEmpty(再交付通知編集本文１);
        再交付通知編集本文１ = 再交付通知編集本文１.padRight(半角空白, 長さ_本文１ + 長さ_本文２ + 長さ_本文３ + 長さ_本文４ + 長さ_本文５);
        再交付通知_本文リスト.set(インデックス_本文１, 再交付通知編集本文１.substring(0, 長さ_本文１).trimEnd(空白));
        再交付通知_本文リスト.set(インデックス_本文２, 再交付通知編集本文１.substring(長さ_本文１, 長さ_本文１ + 長さ_本文２).trimEnd(空白));
        再交付通知_本文リスト.set(インデックス_本文３, 再交付通知編集本文１.substring(長さ_本文１ + 長さ_本文２,
                長さ_本文１ + 長さ_本文２ + 長さ_本文３).trimEnd(空白));
        再交付通知_本文リスト.set(インデックス_本文４, 再交付通知編集本文１.substring(長さ_本文１ + 長さ_本文２ + 長さ_本文３,
                長さ_本文１ + 長さ_本文２ + 長さ_本文３ + 長さ_本文４).trimEnd(空白));
        再交付通知_本文リスト.set(インデックス_本文５, 再交付通知編集本文１.substring(長さ_本文１ + 長さ_本文２ + 長さ_本文３ + 長さ_本文４,
                長さ_本文１ + 長さ_本文２ + 長さ_本文３ + 長さ_本文４ + 長さ_本文５).trimEnd(空白));
        再交付通知_本文リスト.set(インデックス_本文６, 再交付通知編集本文１.substring(長さ_本文１ + 長さ_本文２ + 長さ_本文３ + 長さ_本文４ + 長さ_本文５).trimEnd(空白));
        return 再交付通知_本文リスト;
    }

    private List<RString> edit固定文_抹消通知_本籍地(List<RString> 抹消通知_本籍地_本文リスト,
            RString 抹消通知編集本文１, int 長さ_本文１) {
        抹消通知編集本文１ = replace文字列(抹消通知編集本文１, パラメータ１, get市区町村区分());
        抹消通知編集本文１ = replace文字列(抹消通知編集本文１, パラメータ２, get選挙種類());
        抹消通知編集本文１ = changeNullToEmpty(抹消通知編集本文１);
        if (長さ_本文１ >= 抹消通知編集本文１.length()) {
            抹消通知_本籍地_本文リスト.set(インデックス_本文１, 抹消通知編集本文１);
        } else {
            抹消通知_本籍地_本文リスト.set(インデックス_本文１, 抹消通知編集本文１.substring(0, 長さ_本文１));
            抹消通知_本籍地_本文リスト.set(インデックス_本文２, 抹消通知編集本文１.substring(長さ_本文１));
        }
        return 抹消通知_本籍地_本文リスト;
    }

    private List<RString> edit固定文_抹消通知_領事官(List<RString> 抹消通知_領事官_本文リスト,
            RString 抹消通知編集本文１, int 長さ_本文１, int 長さ_本文２) {
        RString 選挙種類 = get選挙種類();
        抹消通知編集本文１ = replace文字列(抹消通知編集本文１, パラメータ１, 選挙種類);
        抹消通知編集本文１ = replace文字列(抹消通知編集本文１, パラメータ２, get市区町村区分());
        抹消通知編集本文１ = replace文字列(抹消通知編集本文１, パラメータ３, 選挙種類);
        抹消通知編集本文１ = changeNullToEmpty(抹消通知編集本文１);
        if (長さ_本文１ >= 抹消通知編集本文１.length()) {
            抹消通知_領事官_本文リスト.set(インデックス_本文１, 抹消通知編集本文１);
        } else if ((長さ_本文１ + 長さ_本文２) >= 抹消通知編集本文１.length()) {
            抹消通知_領事官_本文リスト.set(インデックス_本文１, 抹消通知編集本文１.substring(0, 長さ_本文１));
            抹消通知_領事官_本文リスト.set(インデックス_本文２, 抹消通知編集本文１.substring(長さ_本文１));
        } else {
            抹消通知_領事官_本文リスト.set(インデックス_本文１, 抹消通知編集本文１.substring(0, 長さ_本文１));
            抹消通知_領事官_本文リスト.set(インデックス_本文２, 抹消通知編集本文１.substring(長さ_本文１, 長さ_本文１ + 長さ_本文２));
            抹消通知_領事官_本文リスト.set(インデックス_本文３, 抹消通知編集本文１.substring(長さ_本文１ + 長さ_本文２));
        }
        return 抹消通知_領事官_本文リスト;
    }

    /**
     * 事務局名を取得する。
     *
     * @return 事務局名 RString
     */
    public RString get事務局名() {
        RString 事務局名 = RString.EMPTY;
        ShichosonAtesaki 市町村宛先 = get市町村宛先情報();
        if (null != 市町村宛先) {
            事務局名 = 市町村宛先.get名称();
        }
        return 事務局名;
    }

    /**
     * 郵便番号を取得する。
     *
     * @return 郵便番号 RString
     */
    public RString get郵便番号() {
        RString 郵便番号 = RString.EMPTY;
        ShichosonAtesaki 市町村宛先 = get市町村宛先情報();
        if (null != 市町村宛先) {
            郵便番号 = 市町村宛先.get郵便番号().value();
        }
        return 郵便番号;
    }

    /**
     * 連絡先住所１～２を取得する。
     *
     * @param 長さ_連絡先住所１ int
     * @return 連絡先住所リスト List<RString>{連絡先住所１、連絡先住所２}
     */
    public List<RString> get連絡先住所１_２(int 長さ_連絡先住所１) {
        List<RString> 連絡先住所リスト = new ArrayList();
        for (int i = 0; i <= インデックス_連絡先住所２; i++) {
            連絡先住所リスト.add(RString.EMPTY);
        }
        ShichosonAtesaki 市町村宛先 = get市町村宛先情報();
        if (null != 市町村宛先) {
            RString 所在地 = changeNullToEmpty(市町村宛先.get住所());
            if (長さ_連絡先住所１ >= 所在地.length()) {
                連絡先住所リスト.set(インデックス_連絡先住所１, 所在地);
            } else {
                連絡先住所リスト.set(インデックス_連絡先住所１, 所在地.substring(0, 長さ_連絡先住所１));
                連絡先住所リスト.set(インデックス_連絡先住所２, 所在地.substring(長さ_連絡先住所１));
            }
        }
        return 連絡先住所リスト;
    }

    /**
     * 連絡先1～３を取得する。
     *
     * @return 連絡先リスト List<RString>{連絡先タイトル１、連絡先１、連絡先タイトル２、連絡先２、連絡先タイトル３、連絡先３}
     */
    public List<RString> get連絡先１_３() {
        List<RString> 連絡先リスト = new ArrayList<>();
        for (int i = 0; i <= インデックス_連絡先３; i++) {
            連絡先リスト.add(RString.EMPTY);
        }
        List<UzT0007CodeEntity> codeEntityList = CodeMaster.getCode(AFACodeShubetsu.連絡先_在外帳票の選挙管理委員会.getCodeShubetsu());
        if (null != codeEntityList && !codeEntityList.isEmpty()) {
            for (UzT0007CodeEntity entity : codeEntityList) {
                if (連絡先_０１.equals(entity.getコード().getColumnValue())) {
                    連絡先リスト.set(インデックス_連絡先タイトル１, entity.getコード名称());
                    連絡先リスト.set(インデックス_連絡先１, entity.getコード略称());
                }
                if (連絡先_０２.equals(entity.getコード().getColumnValue())) {
                    連絡先リスト.set(インデックス_連絡先タイトル２, entity.getコード名称());
                    連絡先リスト.set(インデックス_連絡先２, entity.getコード略称());
                }
                if (連絡先_０３.equals(entity.getコード().getColumnValue())) {
                    連絡先リスト.set(インデックス_連絡先タイトル３, entity.getコード名称());
                    連絡先リスト.set(インデックス_連絡先３, entity.getコード略称());
                }
            }
        }
        return 連絡先リスト;
    }

    /**
     * パラメータより、性別を取得する。
     *
     * @param 性別コード RString
     * @return 性別 RString
     */
    public RString get性別(RString 性別コード) {
        return null == Gender.toValue(性別コード) ? RString.EMPTY : changeNullToEmpty(Gender.toValue(性別コード).getCommonName());
    }

    /**
     * パラメータより、日付編集する。
     *
     * @param 日付_編集前 RDate
     * @return 日付_編集後 RString
     */
    public RString get日付編集(FlexibleDate 日付_編集前) {
        RString 日付_編集後 = RString.EMPTY;
        if (null != 日付_編集前) {
            日付_編集後 = 日付_編集前.wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK)
                    .toDateString();
        }
        return 日付_編集後;
    }

    private static ShichosonAtesaki get市町村宛先情報() {
        ShichosonAtesaki 市町村宛先 = null;
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        if (null != 地方公共団体情報) {
            ICityAtesakiFinder cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
            市町村宛先 = cityAtesakiFinder.get市町村宛先(
                    地方公共団体情報.get地方公共団体コード(), SofusakiGroup.選挙人情報関連.getCode());
        }
        return 市町村宛先;
    }

    private static RString changeNullToEmpty(RString 文字列) {
        return RString.isNullOrEmpty(文字列) ? RString.EMPTY : 文字列;
    }

    private static RString replace文字列(RString 文字列, RString oldStr, RString newStr) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列.replace(oldStr, newStr);
    }
}
