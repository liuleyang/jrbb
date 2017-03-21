/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ラベルシール（宛名シール用紙21面）
 *
 * @reamsid_L AF-0620-031 wangh
 */
public class LabelSealAtenaPartParam {

    private final SenkyoninTohyoJokyoEntity 選挙人資格情報;
    private final RString 期日前不在者区分;
    private final List<RString> 選挙マークリスト;
    private final RString シール種別;
    private final List<RString> 施設種別コード名称リスト;
    private final List<RString> 施設名称リスト;
    private final int 選挙Index;

    /**
     * コンストラクタです
     *
     * @param 選挙人資格情報 SenkyoninTohyoJokyoEntity
     * @param 期日前不在者区分 RString
     * @param 選挙マークリスト List<RString>
     * @param シール種別 RString
     * @param 施設種別コード名称リスト List<RString>
     * @param 施設名称リスト List<RString>
     * @param 選挙Index int
     */
    public LabelSealAtenaPartParam(SenkyoninTohyoJokyoEntity 選挙人資格情報,
            RString 期日前不在者区分, List<RString> 選挙マークリスト, RString シール種別, List<RString> 施設種別コード名称リスト, List<RString> 施設名称リスト, int 選挙Index) {
        this.選挙人資格情報 = 選挙人資格情報;
        this.期日前不在者区分 = 期日前不在者区分;
        this.選挙マークリスト = 選挙マークリスト;
        this.シール種別 = シール種別;
        this.施設種別コード名称リスト = 施設種別コード名称リスト;
        this.施設名称リスト = 施設名称リスト;
        this.選挙Index = 選挙Index;
    }

    /**
     * 選挙人資格情報を返します。
     *
     * @return 選挙人資格情報 SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity get選挙人資格情報() {
        return this.選挙人資格情報;
    }

    /**
     * 期日前不在者区分を返します。
     *
     * @return 期日前不在者区分 RString
     */
    public RString get期日前不在者区分() {
        return this.期日前不在者区分;
    }

    /**
     * 選挙マークリストを返します。
     *
     * @return 選挙マークリスト List<RString>
     */
    public List<RString> get選挙マークリスト() {
        return this.選挙マークリスト;
    }

    /**
     * シール種別を返します。
     *
     * @return シール種別 RString
     */
    public RString getシール種別() {
        return this.シール種別;
    }

    /**
     * 施設種別コード名称リストを返します。
     *
     * @return 施設種別コード名称リスト List<RString>
     */
    public List<RString> get施設種別コード名称リスト() {
        return this.施設種別コード名称リスト;
    }

    /**
     * 施設名称リストを返します。
     *
     * @return 施設名称リスト List<RString>
     */
    public List<RString> get施設名称リスト() {
        return this.施設名称リスト;
    }

    /**
     * 選挙Indexを返します。
     *
     * @return 選挙Index int
     */
    public int get選挙Index() {
        return this.選挙Index;
    }

}
