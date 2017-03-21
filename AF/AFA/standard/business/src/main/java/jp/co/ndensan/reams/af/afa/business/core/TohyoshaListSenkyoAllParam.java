/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票者一覧表
 *
 * @reamsid_L AF-0270-034 wangl
 */
public class TohyoshaListSenkyoAllParam {

    private TohyoJokyoEntity 投票状況Entity;
    private GamenInfo 画面Info;
    private RString 投票場所;
    private RString 合計エリア１;
    private RString 合計エリア２;
    private List<RString> 改頁リスト;
    private List<RString> 選挙略称List;

    /**
     * コンストラクタです。
     *
     * @param 投票状況Entity TohyoJokyoEntity
     * @param 画面Info GamenInfo
     */
    public TohyoshaListSenkyoAllParam(
            TohyoJokyoEntity 投票状況Entity,
            GamenInfo 画面Info) {
        this.投票状況Entity = 投票状況Entity;
        this.画面Info = 画面Info;
    }

    /**
     * 投票状況Lstを返します。
     *
     * @return 投票状況Entity TohyoJokyoEntity
     */
    public TohyoJokyoEntity get投票状況Entity() {
        return 投票状況Entity;
    }

    /**
     * 画面Infoを返します。
     *
     * @return 画面Info GamenInfo
     */
    public GamenInfo get画面Info() {
        return 画面Info;
    }

    /**
     * 投票場所を返します。
     *
     * @return 投票場所 RString
     */
    public RString get投票場所() {
        return 投票場所;
    }

    /**
     * 集計_男を返します。
     *
     * @return 集計_男 RString
     */
    public RString get合計エリア１() {
        return 合計エリア１;
    }

    /**
     * 合計エリア２を返します。
     *
     * @return 合計エリア２ RString
     */
    public RString get合計エリア２() {
        return 合計エリア２;
    }

    /**
     * 改頁リストを返します。
     *
     * @return 改頁リスト List<RString>
     */
    public List<RString> get改頁リスト() {
        return 改頁リスト;
    }

    /**
     * 選挙略称Listを返します。
     *
     * @return 選挙略称List List<RString>
     */
    public List<RString> get選挙略称List() {
        return 選挙略称List;
    }

    /**
     * 投票状況Entityを設定します。
     *
     * @param 投票状況Entity 投票状況EntityTohyoJokyoEntity
     */
    public void set投票状況Entity(TohyoJokyoEntity 投票状況Entity) {
        this.投票状況Entity = 投票状況Entity;
    }

    /**
     * 画面Infoを設定します。
     *
     * @param 画面Info GamenInfo
     */
    public void set画面Info(GamenInfo 画面Info) {
        this.画面Info = 画面Info;
    }

    /**
     * 投票場所を設定します。
     *
     * @param 投票場所 RString
     */
    public void set投票場所(RString 投票場所) {
        this.投票場所 = 投票場所;
    }

    /**
     * 合計エリア１を設定します。
     *
     * @param 合計エリア１ RString
     */
    public void set合計エリア１(RString 合計エリア１) {
        this.合計エリア１ = 合計エリア１;
    }

    /**
     * 合計エリア２を設定します。
     *
     * @param 合計エリア２ RString
     */
    public void set合計エリア２(RString 合計エリア２) {
        this.合計エリア２ = 合計エリア２;
    }

    /**
     * 改頁リストを設定します。
     *
     * @param 改頁リスト List<RString>
     */
    public void set改頁リスト(List<RString> 改頁リスト) {
        this.改頁リスト = 改頁リスト;
    }

    /**
     * 選挙略称Listを設定します。
     *
     * @param 選挙略称List List<RString>
     */
    public void set選挙略称List(List<RString> 選挙略称List) {
        this.選挙略称List = 選挙略称List;
    }

}
