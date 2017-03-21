/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.seikyushomeibotoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT403ShomeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.seikyushomeibotoroku.ShomeiboEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * AFAGMH1030_署名簿登録のクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class Aft403ShomeiboResult implements Serializable {

    private final ShomeiboEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public Aft403ShomeiboResult(ShomeiboEntity entity) {
        this.entity = entity;

    }

    /**
     * コンストラクタです。
     *
     */
    public Aft403ShomeiboResult() {
        entity = new ShomeiboEntity();

    }

    /**
     * 直接請求番号のgetメソッドです。
     *
     * @return 直接請求番号
     */
    public int getSeikyuNo() {
        return entity.getAfT403ShomeiboEntity().getSeikyuNo();
    }

    /**
     * 冊のgetメソッドです。
     *
     * @return 冊
     */
    public RString getSatsu() {
        return entity.getAfT403ShomeiboEntity().getSatsu();
    }

    /**
     * 頁のgetメソッドです。
     *
     * @return 頁
     */
    public int getPage() {
        return entity.getAfT403ShomeiboEntity().getPage();
    }

    /**
     * 行のgetメソッドです。
     *
     * @return 行
     */
    public int getGyo() {
        return entity.getAfT403ShomeiboEntity().getGyo();
    }

    /**
     * 審査区分のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分
     */
    public Code getShinsaKubun() {
        return entity.getAfT403ShomeiboEntity().getShinsaKubun();
    }

    /**
     * 審査区分の名称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の名称
     */
    public RString getShinsaKubunMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(),
                entity.getAfT403ShomeiboEntity().getShinsaKubun());
    }

    /**
     * 審査区分の略称のgetメソッドです。
     * <br/>
     * <br/>審査した結果を入力 ""：署名なし 0：無効 1：有効
     *
     * @return 審査区分の略称
     */
    public RString getShinsaKubunRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.審査区分.getCodeShubetsu(),
                entity.getAfT403ShomeiboEntity().getShinsaKubun());
    }

    /**
     * 無効事由コードのgetメソッドです。
     *
     * @return 無効事由コード
     */
    public Code getMukoJiyuCode() {
        return entity.getAfT403ShomeiboEntity().getMukoJiyuCode();
    }

    /**
     * 無効事由コードの名称のgetメソッドです。
     *
     * @return 無効事由コードの名称
     */
    public RString getMukoJiyuCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.AFA選挙本体, AFACodeShubetsu.無効事由コード.getCodeShubetsu(),
                entity.getAfT403ShomeiboEntity().getMukoJiyuCode());
    }

    /**
     * 署名年月日のgetメソッドです。
     * <br/>
     * <br/>署名人が記入した日付を入力するため、暦上日とは限らない
     *
     * @return 署名年月日
     */
    public FlexibleDate getShomeiYMD() {
        return entity.getAfT403ShomeiboEntity().getShomeiYMD();
    }

    /**
     * 署名年月日のgetメソッドです。
     *
     * @return 署名年月日
     */
    public RString get署名年月日和暦() {
        FlexibleDate 署名年月日 = entity.getAfT403ShomeiboEntity().getShomeiYMD();
        return 署名年月日 == null ? RString.EMPTY : to和暦(署名年月日);
    }

    /**
     * 署名者識別コードのgetメソッドです。
     *
     * @return 署名者識別コード
     */
    public ShikibetsuCode getShomeishaShikibetsuCode() {
        return entity.getAfT403ShomeiboEntity().getShomeishaShikibetsuCode();
    }

    /**
     * 漢字氏名のgetメソッドです。
     *
     * @return 漢字氏名
     */
    public RString getKanjiShimei() {
        AtenaMeisho kanjiShimei = entity.getAfT403ShomeiboEntity().getKanjiShimei();
        return null == kanjiShimei ? RString.EMPTY : kanjiShimei.getColumnValue();
    }

    /**
     * カナ氏名のgetメソッドです。
     *
     * @return カナ氏名
     */
    public RString getKanaShimei() {
        AtenaKanaMeisho kanaShimei = entity.getAfT403ShomeiboEntity().getKanaShimei();
        return null == kanaShimei ? RString.EMPTY
                : kanaShimei.getColumnValue();
    }

    /**
     * 検索用カナ氏名のgetメソッドです。
     *
     * @return 検索用カナ氏名
     */
    public RString getSearchKanaShimei() {
        AtenaKanaMeisho searchKanaShimei = entity.getAfT403ShomeiboEntity().getKanaShimei();
        return null == searchKanaShimei ? RString.EMPTY
                : searchKanaShimei.getColumnValue();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public FlexibleDate getSeinengappiYMD() {
        return entity.getAfT403ShomeiboEntity().getSeinengappiYMD();
    }

    /**
     * 生年月日のgetメソッドです。
     *
     * @return 生年月日
     */
    public RString get生年月日和暦() {
        FlexibleDate 生年月日 = entity.getAfT403ShomeiboEntity().getSeinengappiYMD();
        return 生年月日 == null ? RString.EMPTY : to和暦(生年月日);
    }

    /**
     * 性別コードのgetメソッドです。
     *
     * @return 性別コード
     */
    public RString getSeibetsuCode() {
        return entity.getAfT403ShomeiboEntity().getSeibetsuCode();
    }

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    public RString getJusho() {
        AtenaJusho jusho = entity.getAfT403ShomeiboEntity().getJusho();
        return null == jusho ? RString.EMPTY
                : jusho.getColumnValue();
    }

    /**
     * 代筆者識別コードのgetメソッドです。
     *
     * @return 代筆者識別コード
     */
    public ShikibetsuCode getDaihitsushaShikibetsuCode() {
        return entity.getAfT403ShomeiboEntity().getDaihitsushaShikibetsuCode();
    }

    /**
     * 代筆者漢字氏名のgetメソッドです。
     *
     * @return 代筆者漢字氏名
     */
    public RString getDaihitsushaKanjiShimei() {
        AtenaMeisho daihitsushaKanjiShimei = entity.getAfT403ShomeiboEntity().getDaihitsushaKanjiShimei();
        return null == daihitsushaKanjiShimei
                ? RString.EMPTY : daihitsushaKanjiShimei.getColumnValue();
    }

    /**
     * 代筆者生年月日のgetメソッドです。
     *
     * @return 代筆者生年月日
     */
    public FlexibleDate getDaihitsushaSeinengappiYMD() {
        return entity.getAfT403ShomeiboEntity().getDaihitsushaSeinengappiYMD();
    }

    /**
     * 代筆者生年月日のgetメソッドです。
     *
     * @return 代筆者生年月日
     */
    public RString get代筆者生年月日和暦() {
        FlexibleDate 代筆者生年月日 = entity.getAfT403ShomeiboEntity().getDaihitsushaSeinengappiYMD();
        return 代筆者生年月日 == null ? RString.EMPTY : to和暦(代筆者生年月日);
    }

    /**
     * 代筆者性別コードのgetメソッドです。
     *
     * @return 代筆者性別コード
     */
    public RString getDaihitsushaSeibetsuCode() {
        return entity.getAfT403ShomeiboEntity().getDaihitsushaSeibetsuCode();
    }

    /**
     * 代筆者住所のgetメソッドです。
     *
     * @return 代筆者住所
     */
    public RString getDaihitsushaJusho() {
        AtenaJusho daihitsushaJusho = entity.getAfT403ShomeiboEntity().getDaihitsushaJusho();
        return null == daihitsushaJusho ? RString.EMPTY
                : daihitsushaJusho.getColumnValue();
    }

    /**
     * 選挙資格区分のgetメソッドです。
     *
     * @return 選挙資格区分
     */
    public Code get選挙資格区分() {
        return entity.getShikakuKubun();
    }

    /**
     * AfT403ShomeiboEntityを返します。
     *
     * @return AfT403ShomeiboEntity
     */
    public ShomeiboEntity getEntity() {
        return entity;
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 AfT403ShomeiboEntity
     */
    public AfT403ShomeiboEntity getAfT403ShomeiboEntity() {
        return entity.getAfT403ShomeiboEntity();
    }

    /**
     * 投票状況を返します。
     *
     *
     */
    public void setAfT403ShomeiboEntity() {
        entity.setAfT403ShomeiboEntity(new AfT403ShomeiboEntity());
    }

    private RString to和暦(FlexibleDate 日付) {
        return 日付.wareki().toDateString();
    }

}
