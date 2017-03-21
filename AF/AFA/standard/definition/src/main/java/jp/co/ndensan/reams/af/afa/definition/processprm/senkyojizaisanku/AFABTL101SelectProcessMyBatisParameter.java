/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.senkyojizaisanku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 財産区議会議員選挙時登録バッチデータ取得パラメータクラスです。
 *
 * @reamsid_L AF-0600-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTL101SelectProcessMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private RString 処理種別;
    private ShohonNo 抄本番号;
    private RString 選挙番号;
    private FlexibleDate 年齢期限日;
    private RString 出力順;
    private List<RString> 投票区コードリスト;
    private List<RString> 町域コードリスト;
    private RString riyoKubun;
    private RString table;
    private RString chushutsuKubun;
    private RDateTime zenkaiChushutsu;
    private RDateTime konkaiChushutsu;
    private RString chuiShuruiCode;
    private RString yukoKigenKubun;
    private List<ShohonNo> 抄本番号List;

    /**
     * コンストラクタです。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 処理種別 RString
     * @param 年齢期限日 FlexibleDate
     * @param 出力順 RString
     * @param 投票区コードリスト List<RString>
     * @param 町域コードリスト List<RString>
     * @param 抄本番号 RString
     * @param 抄本番号List List<ShohonNo>
     *
     */
    public AFABTL101SelectProcessMyBatisParameter(
            IShikibetsuTaishoPSMSearchKey key,
            RString 処理種別,
            ShohonNo 抄本番号,
            FlexibleDate 年齢期限日,
            RString 出力順,
            List<RString> 投票区コードリスト,
            List<RString> 町域コードリスト,
            List<ShohonNo> 抄本番号List) {
        super(key);
        this.処理種別 = 処理種別;
        this.抄本番号 = 抄本番号;
        this.年齢期限日 = 年齢期限日;
        this.出力順 = 出力順;
        this.投票区コードリスト = 投票区コードリスト;
        this.町域コードリスト = 町域コードリスト;
        this.抄本番号List = 抄本番号List;
    }

}
