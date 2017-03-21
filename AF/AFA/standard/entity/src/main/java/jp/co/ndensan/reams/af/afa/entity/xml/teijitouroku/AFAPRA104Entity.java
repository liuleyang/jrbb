/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 有権者数調べ用entityクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFAPRA104Entity {

    /**
     * コンストラクタです。
     */
    public AFAPRA104Entity() {
    }

    /**
     * entityのcopy
     *
     * @return AFAPRA104Entity
     */
    public AFAPRA104Entity copy() {
        AFAPRA104Entity copy = new AFAPRA104Entity();
        copy.set選挙番号(this.get選挙番号());
        copy.set合計ページ(this.is合計ページ());
        copy.set投票区コード(this.get投票区コード());
        copy.set投票区名称(this.get投票区名称());
        copy.set地区コード(this.get地区コード());
        copy.set地区名称(this.get地区名称());
        copy.set登録者_男(this.get登録者_男());
        copy.set登録者_女(this.get登録者_女());
        copy.set追加登録者_男(this.get追加登録者_男());
        copy.set追加登録者_女(this.get追加登録者_女());
        copy.set死亡_男(this.get死亡_男());
        copy.set死亡_女(this.get死亡_女());
        copy.set四ヶ月抹消_男(this.get四ヶ月抹消_男());
        copy.set四ヶ月抹消_女(this.get四ヶ月抹消_女());
        copy.set当日四ヶ月抹消_男(this.get当日四ヶ月抹消_男());
        copy.set当日四ヶ月抹消_女(this.get当日四ヶ月抹消_女());
        copy.set誤載_男(this.get誤載_男());
        copy.set誤載_女(this.get誤載_女());
        copy.set国籍喪失_男(this.get国籍喪失_男());
        copy.set国籍喪失_女(this.get国籍喪失_女());
        copy.setその他抹消_男(this.getその他抹消_男());
        copy.setその他抹消_女(this.getその他抹消_女());
        copy.set法11条関連_男(this.get法11条関連_男());
        copy.set法11条関連_女(this.get法11条関連_女());
        copy.set二重登録_男(this.get二重登録_男());
        copy.set二重登録_女(this.get二重登録_女());
        copy.set抹消者総_男(this.get抹消者総_男());
        copy.set抹消者総_女(this.get抹消者総_女());
        copy.set失権失格者_男(this.get失権失格者_男());
        copy.set失権失格者_女(this.get失権失格者_女());
        copy.set選挙期日登録者_男(this.get選挙期日登録者_男());
        copy.set選挙期日登録者_女(this.get選挙期日登録者_女());
        copy.setN内転出者_男(this.getN内転出者_男());
        copy.setN内転出者_女(this.getN内転出者_女());
        copy.setN外転出者_男(this.getN外転出者_男());
        copy.setN外転出者_女(this.getN外転出者_女());
        copy.set国外転出者_男(this.get国外転出者_男());
        copy.set国外転出者_女(this.get国外転出者_女());
        copy.set職権削除者_男(this.get職権削除者_男());
        copy.set職権削除者_女(this.get職権削除者_女());
        copy.set加算有権者_抹消者_男(this.get加算有権者_抹消者_男());
        copy.set加算有権者_抹消者_女(this.get加算有権者_抹消者_女());
        copy.set加算有権者_失権者_男(this.get加算有権者_失権者_男());
        copy.set加算有権者_失権者_女(this.get加算有権者_失権者_女());
        copy.set加算有権者_計_男(this.get加算有権者_計_男());
        copy.set加算有権者_計_女(this.get加算有権者_計_女());
        copy.set当日有権者_男(this.get当日有権者_男());
        copy.set当日有権者_女(this.get当日有権者_女());
        copy.set名簿基準年月日(this.get名簿基準年月日());
        copy.set投票年月日(this.get投票年月日());
        copy.set選挙種類(this.get選挙種類());
        copy.set選挙名称(this.get選挙名称());
        return copy;
    }

    /**
     * entityのadd
     *
     * @param trgt AFAPRA104Entity
     */
    public void add(AFAPRA104Entity trgt) {

        this.登録者_男 = this.登録者_男.add(trgt.get登録者_男());
        this.登録者_女 = this.登録者_女.add(trgt.get登録者_女());
        this.追加登録者_男 = this.追加登録者_男.add(trgt.get追加登録者_男());
        this.追加登録者_女 = this.追加登録者_女.add(trgt.get追加登録者_女());
        this.死亡_男 = this.死亡_男.add(trgt.get死亡_男());
        this.死亡_女 = this.死亡_女.add(trgt.get死亡_女());
        this.四ヶ月抹消_男 = this.四ヶ月抹消_男.add(trgt.get四ヶ月抹消_男());
        this.四ヶ月抹消_女 = this.四ヶ月抹消_女.add(trgt.get四ヶ月抹消_女());
        this.当日四ヶ月抹消_男 = this.当日四ヶ月抹消_男.add(trgt.get当日四ヶ月抹消_男());
        this.当日四ヶ月抹消_女 = this.当日四ヶ月抹消_女.add(trgt.get当日四ヶ月抹消_女());
        this.誤載_男 = this.誤載_男.add(trgt.get誤載_男());
        this.誤載_女 = this.誤載_女.add(trgt.get誤載_女());
        this.国籍喪失_男 = this.国籍喪失_男.add(trgt.get国籍喪失_男());
        this.国籍喪失_女 = this.国籍喪失_女.add(trgt.get国籍喪失_女());
        this.その他抹消_男 = this.その他抹消_男.add(trgt.getその他抹消_男());
        this.その他抹消_女 = this.その他抹消_女.add(trgt.getその他抹消_女());
        this.法11条関連_男 = this.法11条関連_男.add(trgt.get法11条関連_男());
        this.法11条関連_女 = this.法11条関連_女.add(trgt.get法11条関連_女());
        this.二重登録_男 = this.二重登録_男.add(trgt.get二重登録_男());
        this.二重登録_女 = this.二重登録_女.add(trgt.get二重登録_女());
        this.抹消者総_男 = this.抹消者総_男.add(trgt.get抹消者総_男());
        this.抹消者総_女 = this.抹消者総_女.add(trgt.get抹消者総_女());
        this.失権失格者_男 = this.失権失格者_男.add(trgt.get失権失格者_男());
        this.失権失格者_女 = this.失権失格者_女.add(trgt.get失権失格者_女());
        this.選挙期日登録者_男 = this.選挙期日登録者_男.add(trgt.get選挙期日登録者_男());
        this.選挙期日登録者_女 = this.選挙期日登録者_女.add(trgt.get選挙期日登録者_女());
        this.n内転出者_男 = this.n内転出者_男.add(trgt.getN内転出者_男());
        this.n内転出者_女 = this.n内転出者_女.add(trgt.getN内転出者_女());
        this.n外転出者_男 = this.n外転出者_男.add(trgt.getN外転出者_男());
        this.n外転出者_女 = this.n外転出者_女.add(trgt.getN外転出者_女());
        this.国外転出者_男 = this.国外転出者_男.add(trgt.get国外転出者_男());
        this.国外転出者_女 = this.国外転出者_女.add(trgt.get国外転出者_女());
        this.職権削除者_男 = this.職権削除者_男.add(trgt.get職権削除者_男());
        this.職権削除者_女 = this.職権削除者_女.add(trgt.get職権削除者_女());
        this.加算有権者_抹消者_男 = this.加算有権者_抹消者_男.add(trgt.get加算有権者_抹消者_男());
        this.加算有権者_抹消者_女 = this.加算有権者_抹消者_女.add(trgt.get加算有権者_抹消者_女());
        this.加算有権者_失権者_男 = this.加算有権者_失権者_男.add(trgt.get加算有権者_失権者_男());
        this.加算有権者_失権者_女 = this.加算有権者_失権者_女.add(trgt.get加算有権者_失権者_女());
        this.加算有権者_計_男 = this.加算有権者_計_男.add(trgt.get加算有権者_計_男());
        this.加算有権者_計_女 = this.加算有権者_計_女.add(trgt.get加算有権者_計_女());
        this.当日有権者_男 = this.当日有権者_男.add(trgt.get当日有権者_男());
        this.当日有権者_女 = this.当日有権者_女.add(trgt.get当日有権者_女());

    }

    private RString 選挙番号;
    private boolean 合計ページ;
    private RString 投票区コード;
    private RString 投票区名称;
    private RString 地区コード;
    private RString 地区名称;
    private Decimal 登録者_男;
    private Decimal 登録者_女;
    private Decimal 追加登録者_男;
    private Decimal 追加登録者_女;
    private Decimal 死亡_男;
    private Decimal 死亡_女;
    private Decimal 四ヶ月抹消_男;
    private Decimal 四ヶ月抹消_女;
    private Decimal 当日四ヶ月抹消_男;
    private Decimal 当日四ヶ月抹消_女;
    private Decimal 誤載_男;
    private Decimal 誤載_女;
    private Decimal 国籍喪失_男;
    private Decimal 国籍喪失_女;
    private Decimal その他抹消_男;
    private Decimal その他抹消_女;
    private Decimal 法11条関連_男;
    private Decimal 法11条関連_女;
    private Decimal 二重登録_男;
    private Decimal 二重登録_女;
    private Decimal 抹消者総_男;
    private Decimal 抹消者総_女;
    private Decimal 失権失格者_男;
    private Decimal 失権失格者_女;
    private Decimal 選挙期日登録者_男;
    private Decimal 選挙期日登録者_女;
    private Decimal n内転出者_男;
    private Decimal n内転出者_女;
    private Decimal n外転出者_男;
    private Decimal n外転出者_女;
    private Decimal 国外転出者_男;
    private Decimal 国外転出者_女;
    private Decimal 職権削除者_男;
    private Decimal 職権削除者_女;
    private Decimal 加算有権者_抹消者_男;
    private Decimal 加算有権者_抹消者_女;
    private Decimal 加算有権者_失権者_男;
    private Decimal 加算有権者_失権者_女;
    private Decimal 加算有権者_計_男;
    private Decimal 加算有権者_計_女;
    private Decimal 当日有権者_男;
    private Decimal 当日有権者_女;
    private FlexibleDate 名簿基準年月日;
    private FlexibleDate 投票年月日;
    private RString 選挙種類;
    private RString 選挙名称;
}
