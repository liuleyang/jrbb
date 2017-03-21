/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.batchprm.zenjitsuprint.AFABTE504BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.IShohonSenkyoListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonSenkyoList.dgSenkyoList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoDairiShukeiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoFuzaishaChoshoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoJikanbetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoJimuShoriboDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoJuriJokyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoKanrishaChoshoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoKofuChoshoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoKofuIchiranDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoNendaibetsuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoShohonDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoSochishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoTohyoShukeiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoTorokushaListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoYukenshaListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * AFAGME5040 投票日前日関連帳票 のhandler
 *
 * @reamsid_L AF-0280-010 lit
 */
public class ZenjitsuSakuseiHandler {

    private final ZenjitsuSakuseiDiv div;

    private enum 出力対象 {

        期日前投票(new RString("1"), new RString("期日前投票")),
        不在者投票(new RString("2"), new RString("不在者投票"));

        private final RString key;
        private final RString value;

        private 出力対象(RString key, RString value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 投票日前日関連帳票Div
     */
    public ZenjitsuSakuseiHandler(ZenjitsuSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     *
     * @return Success : true || Fail : false
     */
    public boolean initialize() {
        ViewState.setメニューID(AFAMenuId.AFAMNE5040_投票日前日関連帳票.menuId());
        div.getCcdZenjitsuShohonSenkyoList().initialize(SenkyoShurui.国政選挙_地方選挙);

        if (div.getCcdZenjitsuShohonSenkyoList().getCcdShohonNameList().getShohonListSize() == 0) {
            return false;
        }

        SenkyoShurui 選挙種類 = div.getCcdZenjitsuShohonSenkyoList().getCcdShohonNameList().getSelectedSenkyoShurui();
        ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
        chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei().getCcdTohyoShukeiTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().getCcdDairiShukeiTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu().getCcdNendaibetsuTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu().getCcdJikanbetsuTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran().getCcdKofuIchiranShisetsuCode().initialize();
        chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().getCcdJimuShoriboTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho().getCcdFuzaishaChoshoTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho().getCcdKofuChoshoTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho().getCcdKanrishaChoshoTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList().getCcdTorokushaListTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList().getCcdYukenshaListTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoShohon().getCcdShohonTohyokuCode().initialize(選挙種類);
        chohyoDiv.getZenjitsuSakuseiChohyoSochisho().getCcdSochishoTohyokuCode().initialize(選挙種類);

        List<PanelPublish> list = getAllPanelPublish();
        for (PanelPublish panel : list) {
            if (!panel.isDisplayNone()) {
                setPanelProperty(panel,
                        ConfigKeysAFA.toValue(
                                new RString("帳票出力初期値_前日帳票_")
                                .concat(panel.getTitle().replace("（第25号様式）", "").replace("・", ""))));
            }
        }

        List<KeyValueDataSource> keyValueList = new ArrayList<>();
        keyValueList.add(new KeyValueDataSource(出力対象.期日前投票.key, 出力対象.期日前投票.value));
        keyValueList.add(new KeyValueDataSource(出力対象.不在者投票.key, 出力対象.不在者投票.value));
        chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().getChkDairiTohyoTaisho().setDataSource(keyValueList);
        chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().getChkJimuShoriboTaisho().setDataSource(keyValueList);
        chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().getChkDairiTohyoTaisho()
                .setSelectedItemsByKey(Arrays.asList(出力対象.期日前投票.key, 出力対象.不在者投票.key));
        chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().getChkJimuShoriboTaisho()
                .setSelectedItemsByKey(Arrays.asList(出力対象.期日前投票.key, 出力対象.不在者投票.key));

        return true;
    }

    /**
     * 条件エリアのデータを設定する。
     */
    public void changeShohonName() {
        div.getCcdZenjitsuShohonSenkyoList().initialSetting();
    }

    /**
     * 帳票印刷
     *
     * @return AFABTE504BatchParameter AFABTE504BatchParameter
     */
    public AFABTE504BatchParameter createParameter() {

        AFABTE504BatchParameter param = new AFABTE504BatchParameter();

        IShohonSenkyoListDiv 抄本選挙 = div.getCcdZenjitsuShohonSenkyoList();
        param.set抄本番号Param(抄本選挙.getCcdShohonNameList().getSelectedShohonNo());
        param.set無投票選挙出力有無(抄本選挙.無投票選挙check());
        RStringBuilder 選挙番号リスト = new RStringBuilder();
        RStringBuilder 選挙名リスト = new RStringBuilder();
        List<dgSenkyoList_Row> rowList = 抄本選挙.getSenkyoDataSource();
        if (null != rowList && !rowList.isEmpty()) {
            dgSenkyoList_Row row;
            for (int i = 0; i < rowList.size(); i++) {
                row = rowList.get(i);
                選挙名リスト.append(row.getTxtSenkyoName());
                選挙番号リスト.append(row.getTxtNo());
                if (i != rowList.size() - 1) {
                    選挙名リスト.append(",");
                    選挙番号リスト.append(",");
                }
            }
        }
        param.set選挙名リストParam(選挙名リスト.toRString());
        param.set選挙番号リストParam(選挙番号リスト.toRString());

        ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
        ZenjitsuSakuseiChohyoTohyoShukeiDiv 投票集計表 = chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei();
        param.set投票集計表投票区from(投票集計表.getCcdTohyoShukeiTohyokuCode().get投票区コードFROM());
        param.set投票集計表投票区to(投票集計表.getCcdTohyoShukeiTohyokuCode().get投票区コードTO());
        param.set投票集計表受理日from(convertRdateToFlexibleDate(投票集計表.getTxtTohyoShukeiJuriYMD().getFromValue()));
        param.set投票集計表受理日to(convertRdateToFlexibleDate(投票集計表.getTxtTohyoShukeiJuriYMD().getToValue()));
        param.set投票集計表出力有無(投票集計表.isIsPublish());

        ZenjitsuSakuseiChohyoDairiShukeiDiv 代理投票集計表 = chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei();
        param.set代理投票集計表期日前投票有無(代理投票集計表.getChkDairiTohyoTaisho().getSelectedKeys().contains(出力対象.期日前投票.key));
        param.set代理投票集計表不在者投票有無(代理投票集計表.getChkDairiTohyoTaisho().getSelectedKeys().contains(出力対象.不在者投票.key));
        param.set代理投票集計表投票区from(代理投票集計表.getCcdDairiShukeiTohyokuCode().get投票区コードFROM());
        param.set代理投票集計表投票区to(代理投票集計表.getCcdDairiShukeiTohyokuCode().get投票区コードTO());
        param.set代理投票集計表受理日from(convertRdateToFlexibleDate(代理投票集計表.getTxtDairiShukeiJuriYMD().getFromValue()));
        param.set代理投票集計表受理日to(convertRdateToFlexibleDate(代理投票集計表.getTxtDairiShukeiJuriYMD().getToValue()));
        param.set代理投票集計表出力有無(代理投票集計表.isIsPublish());

        ZenjitsuSakuseiChohyoNendaibetsuDiv 年代別投票状況 = chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu();
        param.set年代別投票状況調べ投票区from(年代別投票状況.getCcdNendaibetsuTohyokuCode().get投票区コードFROM());
        param.set年代別投票状況調べ投票区to(年代別投票状況.getCcdNendaibetsuTohyokuCode().get投票区コードTO());
        param.set年代別投票状況調べ出力有無(年代別投票状況.isIsPublish());

        ZenjitsuSakuseiChohyoJikanbetsuDiv 時間別投票状況 = chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu();
        param.set時間別投票状況表投票区from(時間別投票状況.getCcdJikanbetsuTohyokuCode().get投票区コードFROM());
        param.set時間別投票状況表投票区to(時間別投票状況.getCcdJikanbetsuTohyokuCode().get投票区コードTO());
        param.set時間別投票状況表出力有無(時間別投票状況.isIsPublish());

        ZenjitsuSakuseiChohyoJuriJokyoDiv 期日前受理状況一覧表 = chohyoDiv.getZenjitsuSakuseiChohyoJuriJokyo();
        param.set期日前受理状況一覧表受理日from(convertRdateToFlexibleDate(期日前受理状況一覧表.getTxtJuriJokyoJuriYMD().getFromValue()));
        param.set期日前受理状況一覧表受理日to(convertRdateToFlexibleDate(期日前受理状況一覧表.getTxtJuriJokyoJuriYMD().getToValue()));
        param.set期日前受理状況一覧表出力有無(期日前受理状況一覧表.isIsPublish());

        ZenjitsuSakuseiChohyoKofuIchiranDiv 施設交付一覧表 = chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran();
        param.set施設交付一覧表施設from(施設交付一覧表.getCcdKofuIchiranShisetsuCode().get施設コードFROM());
        param.set施設交付一覧表施設to(施設交付一覧表.getCcdKofuIchiranShisetsuCode().get施設コードTO());
        param.set施設交付一覧表交付日from(convertRdateToFlexibleDate(施設交付一覧表.getTxtKofuIchiranKofuYMD().getFromValue()));
        param.set施設交付一覧表交付日to(convertRdateToFlexibleDate(施設交付一覧表.getTxtKofuIchiranKofuYMD().getToValue()));
        param.set施設交付一覧表出力有無(施設交付一覧表.isIsPublish());

        ZenjitsuSakuseiChohyoJimuShoriboDiv 事務処理簿 = chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo();
        param.set事務処理簿期日前投票有無(事務処理簿.getChkJimuShoriboTaisho().getSelectedKeys().contains(出力対象.期日前投票.key));
        param.set事務処理簿不在者投票有無(事務処理簿.getChkJimuShoriboTaisho().getSelectedKeys().contains(出力対象.不在者投票.key));
        param.set事務処理簿投票区from(事務処理簿.getCcdJimuShoriboTohyokuCode().get投票区コードFROM());
        param.set事務処理簿投票区to(事務処理簿.getCcdJimuShoriboTohyokuCode().get投票区コードTO());
        param.set事務処理簿出力有無(事務処理簿.isIsPublish());

        ZenjitsuSakuseiChohyoFuzaishaChoshoDiv 不在者投票 = chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho();
        param.set不在者投票印字有無(不在者投票.getChkBikoInji().isAllSelected());
        param.set不在者投票投票区from(不在者投票.getCcdFuzaishaChoshoTohyokuCode().get投票区コードFROM());
        param.set不在者投票投票区to(不在者投票.getCcdFuzaishaChoshoTohyokuCode().get投票区コードTO());
        param.set不在者投票出力有無(不在者投票.isIsPublish());

        ZenjitsuSakuseiChohyoKofuChoshoDiv 不在者投票用紙調書 = chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho();
        param.set不在者投票用紙調書投票区from(不在者投票用紙調書.getCcdKofuChoshoTohyokuCode().get投票区コードFROM());
        param.set不在者投票用紙調書投票区to(不在者投票用紙調書.getCcdKofuChoshoTohyokuCode().get投票区コードTO());
        param.set不在者投票用紙調書出力有無(不在者投票用紙調書.isIsPublish());

        ZenjitsuSakuseiChohyoKanrishaChoshoDiv 不在者投票管理者 = chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho();
        param.set不在者投票管理者調書投票区from(不在者投票管理者.getCcdKanrishaChoshoTohyokuCode().get投票区コードFROM());
        param.set不在者投票管理者調書投票区to(不在者投票管理者.getCcdKanrishaChoshoTohyokuCode().get投票区コードTO());
        param.set不在者投票管理者調書出力有無(不在者投票管理者.isIsPublish());

        ZenjitsuSakuseiChohyoTorokushaListDiv 登録者数 = chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList();
        param.set登録者数リスト投票区from(登録者数.getCcdTorokushaListTohyokuCode().get投票区コードFROM());
        param.set登録者数リスト投票区to(登録者数.getCcdTorokushaListTohyokuCode().get投票区コードTO());
        param.set登録者数リスト作成有無(登録者数.getChkTorokushasuListFuzaishaShikaku().isAllSelected());
        param.set登録者数リスト出力有無(登録者数.isIsPublish());

        ZenjitsuSakuseiChohyoYukenshaListDiv 有権者数 = chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList();
        param.set有権者数調べ投票区from(有権者数.getCcdYukenshaListTohyokuCode().get投票区コードFROM());
        param.set有権者数調べ投票区to(有権者数.getCcdYukenshaListTohyokuCode().get投票区コードTO());
        param.set有権者数調べ出力有無(有権者数.isIsPublish());

        ZenjitsuSakuseiChohyoShohonDiv 選挙人名簿抄本 = chohyoDiv.getZenjitsuSakuseiChohyoShohon();
        param.set選挙人名簿抄本投票区from(選挙人名簿抄本.getCcdShohonTohyokuCode().get投票区コードFROM());
        param.set選挙人名簿抄本投票区to(選挙人名簿抄本.getCcdShohonTohyokuCode().get投票区コードTO());
        param.set選挙人名簿抄本出力有無(選挙人名簿抄本.isIsPublish());

        ZenjitsuSakuseiChohyoSochishoDiv 送致書 = chohyoDiv.getZenjitsuSakuseiChohyoSochisho();
        param.set送致書投票区from(送致書.getCcdSochishoTohyokuCode().get投票区コードFROM());
        param.set送致書投票区to(送致書.getCcdSochishoTohyokuCode().get投票区コードTO());
        param.set送致書人数印字有無(送致書.getChkSochishoInji().isAllSelected());
        param.set送致書出力有無(送致書.isIsPublish());

        ShohonManager 抄本Manager = ShohonManager.createInstance();
        Shohon 抄本データ = 抄本Manager.get抄本(new ShohonNo(抄本選挙.getCcdShohonNameList().getSelectedShohonNo()));
        param.set年齢到達期限日(抄本データ.get規定年齢到達年月日());

        SenkyoManager 選挙Manager = SenkyoManager.createInstance();
        Senkyo 選挙データ = 選挙Manager.get最小名簿基準年月日(new ShohonNo(抄本選挙.getCcdShohonNameList().getSelectedShohonNo()));
        param.set基準日(選挙データ.get名簿基準年月日());

        return param;
    }

    private FlexibleDate convertRdateToFlexibleDate(RDate target) {
        if (null == target) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(target.toDateString());
    }

    private List<PanelPublish> getAllPanelPublish() {
        List<PanelPublish> list = new ArrayList<>();
        ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoJuriJokyo());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoShohon());
        list.add(chohyoDiv.getZenjitsuSakuseiChohyoSochisho());
        return list;
    }

    private void setPanelProperty(PanelPublish div, ConfigKeysAFA key) {
        div.setIsPublish(InnjiFlg.印字する.value().equals(BusinessConfig.get(key, SubGyomuCode.AFA選挙本体)));
        div.setIsOpen(false);
    }
}
