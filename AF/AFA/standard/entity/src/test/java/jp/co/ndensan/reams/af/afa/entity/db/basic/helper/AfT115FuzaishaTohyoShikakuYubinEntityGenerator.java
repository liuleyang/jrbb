/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.basic.helper;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT115FuzaishaTohyoShikakuYubinEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 郵便投票資格付随情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n1823 有澤礼恵
 */
public final class AfT115FuzaishaTohyoShikakuYubinEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード9991 = new ShikibetsuCode("999999999900001");
    public static final ShikibetsuCode DEFAULT_識別コード9992 = new ShikibetsuCode("999999999900002");
    public static final ShikibetsuCode DEFAULT_識別コード9993 = new ShikibetsuCode("999999999900003");
    public static final boolean DEFAULT_身体障害者手帳有フラグ = Boolean.TRUE;
    public static final boolean DEFAULT_戦傷病者手帳有フラグ = Boolean.FALSE;
    public static final boolean DEFAULT_介護保険被保険者証有フラグ = Boolean.FALSE;
    public static final Code DEFAULT_代理記載者入力区分 = new Code("0");
    public static final ShikibetsuCode DEFAULT_代理記載者識別コード = ShikibetsuCode.EMPTY;
    public static final AtenaMeisho DEFAULT_代理記載者漢字氏名 = AtenaMeisho.EMPTY;
    public static final AtenaKanaMeisho DEFAULT_代理記載者カナ氏名 = AtenaKanaMeisho.EMPTY;
    public static final FlexibleDate DEFAULT_代理記載者生年月日 = FlexibleDate.EMPTY;
    public static final RString DEFAULT_代理記載者性別コード = RString.EMPTY;
    public static final YubinNo DEFAULT_代理記載者郵便番号 = YubinNo.EMPTY;
    public static final AtenaJusho DEFAULT_代理記載者住所 = new AtenaJusho("テスト郵便投票資格付随情報");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private AfT115FuzaishaTohyoShikakuYubinEntityGenerator() {
    }

    public static AfT115FuzaishaTohyoShikakuYubinEntity createAfT115FuzaishaTohyoShikakuYubinEntity() {
        return createAfT115FuzaishaTohyoShikakuYubinEntity(DEFAULT_識別コード9991);
    }

    public static AfT115FuzaishaTohyoShikakuYubinEntity createAfT115FuzaishaTohyoShikakuYubinEntity(ShikibetsuCode shikibetsuCode) {
        AfT115FuzaishaTohyoShikakuYubinEntity entity = new AfT115FuzaishaTohyoShikakuYubinEntity();
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShogaiTechoAriFlag(DEFAULT_身体障害者手帳有フラグ);
        entity.setSenshoTechoAriFlag(DEFAULT_戦傷病者手帳有フラグ);
        entity.setKaigoHokenshoAriFlag(DEFAULT_介護保険被保険者証有フラグ);
        entity.setDairiInputKubun(DEFAULT_代理記載者入力区分);
        entity.setDairiShikibetsuCode(DEFAULT_代理記載者識別コード);
        entity.setDairiKanjiShimei(DEFAULT_代理記載者漢字氏名);
        entity.setDairiKanaShimei(DEFAULT_代理記載者カナ氏名);
        entity.setDairiSeinengappiYMD(DEFAULT_代理記載者生年月日);
        entity.setDairiSeibetsuCode(DEFAULT_代理記載者性別コード);
        entity.setDairiYubinNo(DEFAULT_代理記載者郵便番号);
        entity.setDairiJusho(new AtenaJusho(DEFAULT_代理記載者住所.toString() + shikibetsuCode.toString()));
        return entity;
    }
}
