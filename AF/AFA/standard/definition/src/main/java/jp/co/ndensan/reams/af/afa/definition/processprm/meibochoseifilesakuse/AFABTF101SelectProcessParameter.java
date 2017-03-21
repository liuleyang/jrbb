/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.processprm.meibochoseifilesakuse;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.meibochoseifilesakuse.ChoseiFileMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住民投票時登録バッチパラメータクラスです。
 *
 * @reamsid_L AF-0450-020 lis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AFABTF101SelectProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey key;
    private ShohonNo 抄本番号;
    private RString 保存先;
    private RString ファイル名;
    private int 抽出対象年齢;
    private FlexibleDate 年齢計算基準日;
    private RString 実行結果;

    /**
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @param 抄本番号 RString
     * @param 保存先 RString
     * @param ファイル名 RString
     * @param 抽出対象年齢 RString
     * @param 年齢計算基準日 RString
     * @param 実行結果 RString
     */
    public AFABTF101SelectProcessParameter(IShikibetsuTaishoPSMSearchKey key, ShohonNo 抄本番号, RString 保存先, RString ファイル名,
            int 抽出対象年齢, FlexibleDate 年齢計算基準日, RString 実行結果) {
        this.key = key;
        this.抄本番号 = 抄本番号;
        this.保存先 = 保存先;
        this.ファイル名 = ファイル名;
        this.抽出対象年齢 = 抽出対象年齢;
        this.年齢計算基準日 = 年齢計算基準日;
        this.実行結果 = 実行結果;
    }

    /**
     * 名簿調製用連携ファイル作成バッチのパラメータクラス。
     *
     * @return JuminTohyojiMybatisParameter
     */
    public ChoseiFileMybatisParameter toChoseiFileMybatisParameter() {
        return new ChoseiFileMybatisParameter(抄本番号, key);
    }

}
