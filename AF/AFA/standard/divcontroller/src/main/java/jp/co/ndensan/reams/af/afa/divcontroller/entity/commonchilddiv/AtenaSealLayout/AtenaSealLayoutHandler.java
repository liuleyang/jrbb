/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AtenaHenshuSeal;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AtenaHenshuSealShisetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JushoHenshuAtenaSeal;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.Keisho;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YosumiKomokuSenkyonin;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeShiyoUmu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 宛名シールレイアウト共有子DIVに対するコントローラです。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public class AtenaSealLayoutHandler {

    private final AtenaSealLayoutDiv div;
    private final RString 転出先の住所_番地_方書 = new RString("転出先の住所　番地　方書");
    private final RString 施設住所 = new RString("施設住所");
    private final RString アパート = new RString("△△アパート");
    private final RString 大字_１２３番地 = new RString("大字○○１２３番地");
    private final RString 大字_行政区_１２３番地 = new RString("大字○○(行政区)１２３番地");
    private final RString 大字_１２３番地_行政区 = new RString("大字○○１２３番地(行政区)");
    private final RString 行政区 = new RString("(行政区)");
    private final RString 行政区１２３番地 = new RString("行政区１２３番地");
    private final RString 空文字_行政区 = new RString("　　　　　(行政区)");
    private final RString 名字_本人氏名 = new RString("名字　本人氏名");
    private final RString ﾐｮｳｼﾞ_ﾎﾝﾆﾝｼﾒｲ = new RString("ﾐｮｳｼﾞ ﾎﾝﾆﾝｼﾒｲ");
    private final RString 名字_世帯主 = new RString("名字　世帯主");
    private final RString 転出者氏名 = new RString("転出者氏名");
    private final RString テスト施設名 = new RString("テスト施設名");
    private final RString テスト施設院長 = new RString("テスト施設院長");
    private final RString コード = new RString("コード");

    /**
     * コンストラクタです。
     *
     * @param div 宛名シールレイアウト共有子DIV
     */
    public AtenaSealLayoutHandler(AtenaSealLayoutDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     */
    public void initialize() {
        RString menuID = ResponseHolder.getMenuID();
        初期化処理_表示制御(menuID);
        初期化処理_四隅項目右上隅(menuID);
        初期化処理_住所(menuID);
        初期化処理_宛名(menuID);
        初期化処理_世帯主敬称(menuID);
        初期化処理_本人敬称();
    }

    /**
     * 住所のonChangeのイベントメソッドです。
     *
     */
    public void onChange_ddlJusho() {
        RString menuID = ResponseHolder.getMenuID();

        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            if (JushoHenshuAtenaSeal.住所_番地_方書.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(大字_１２３番地);
                div.getTxtJusho2().setValue(アパート);
                div.getTxtJusho3().setValue(RString.EMPTY);
            } else if (JushoHenshuAtenaSeal.住所_行政区_番地_方書.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(大字_行政区_１２３番地);
                div.getTxtJusho2().setValue(アパート);
                div.getTxtJusho3().setValue(RString.EMPTY);
            } else if (JushoHenshuAtenaSeal.住所_番地_行政区_方書.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(大字_１２３番地_行政区);
                div.getTxtJusho2().setValue(アパート);
                div.getTxtJusho3().setValue(RString.EMPTY);
            } else if (JushoHenshuAtenaSeal.行政区_住所_番地_方書.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(行政区);
                div.getTxtJusho2().setValue(大字_１２３番地);
                div.getTxtJusho3().setValue(アパート);
            } else if (JushoHenshuAtenaSeal.住所_番地_方書_行政区.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(大字_１２３番地);
                div.getTxtJusho2().setValue(アパート);
                div.getTxtJusho3().setValue(空文字_行政区);
            } else if (JushoHenshuAtenaSeal.行政区_番地_方書.getKey().equals(div.getDdlJusho().getSelectedKey())) {
                div.getTxtJusho1().setValue(行政区１２３番地);
                div.getTxtJusho2().setValue(アパート);
                div.getTxtJusho3().setValue(RString.EMPTY);
            }
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getTxtJusho1().setValue(転出先の住所_番地_方書);
            div.getTxtJusho2().setValue(RString.EMPTY);
            div.getTxtJusho3().setValue(RString.EMPTY);
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            div.getTxtJusho1().setValue(施設住所);
            div.getTxtJusho2().setValue(RString.EMPTY);
            div.getTxtJusho3().setValue(RString.EMPTY);
        }
    }

    /**
     * 宛名のonChangeのイベントメソッドです。
     *
     */
    public void onChange_ddlAtena() {
        RString menuID = ResponseHolder.getMenuID();
        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            if (AtenaHenshuSeal.本人.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(RString.EMPTY);
                div.getTxtAtena2().setValue(名字_本人氏名);
                div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.TRUE);
                div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            } else if (AtenaHenshuSeal.フリガナと本人.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(ﾐｮｳｼﾞ_ﾎﾝﾆﾝｼﾒｲ);
                div.getTxtAtena2().setValue(名字_本人氏名);
                div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.TRUE);
                div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            } else if (AtenaHenshuSeal.世帯主と本人.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(名字_世帯主);
                div.getTxtAtena2().setValue(名字_本人氏名);
                div.getDdlKeisho1().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.FALSE);
                div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            }
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getTxtAtena1().setValue(転出者氏名);
            div.getTxtAtena2().setValue(RString.EMPTY);
            div.getDdlKeisho1().setDisplayNone(Boolean.TRUE);
            div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
            div.getDdlKeisho2().setDisabled(Boolean.FALSE);
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            if (AtenaHenshuSealShisetsu.施設名.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(RString.EMPTY);
                div.getTxtAtena2().setValue(テスト施設名);
                div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.TRUE);
                div.getDdlKeisho2().setSelectedKey(Keisho.御中.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            } else if (AtenaHenshuSealShisetsu.施設宛名.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(RString.EMPTY);
                div.getTxtAtena2().setValue(テスト施設院長);
                div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.TRUE);
                div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            } else if (AtenaHenshuSealShisetsu.施設名と施設宛名.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getTxtAtena1().setValue(テスト施設名);
                div.getTxtAtena2().setValue(テスト施設院長);
                div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
                div.getDdlKeisho1().setDisabled(Boolean.FALSE);
                div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
                div.getDdlKeisho2().setDisabled(Boolean.FALSE);
            }
        }
    }

    private void 初期化処理_表示制御(RString menuID) {

        div.getDdlRightUp().setDisabled(Boolean.FALSE);
        div.getDdlLeftDown().setDisabled(Boolean.FALSE);
        div.getDdlRightDown().setDisabled(Boolean.FALSE);
        div.getTxtJusho1().setDisabled(Boolean.TRUE);
        div.getTxtJusho2().setDisabled(Boolean.TRUE);
        div.getTxtJusho3().setDisabled(Boolean.TRUE);
        div.getTxtAtena1().setDisabled(Boolean.TRUE);
        div.getTxtAtena2().setDisabled(Boolean.TRUE);
        div.getDdlKeisho2().setDisabled(Boolean.FALSE);

        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            div.getDdlJusho().setDisabled(Boolean.FALSE);
            div.getDdlAtena().setDisabled(Boolean.FALSE);
            div.getDdlKeisho1().setDisabled(Boolean.FALSE);
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getDdlJusho().setDisplayNone(Boolean.TRUE);
            div.getDdlAtena().setDisplayNone(Boolean.TRUE);
            div.getDdlKeisho1().setDisplayNone(Boolean.TRUE);
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            div.getDdlJusho().setDisplayNone(Boolean.TRUE);
            div.getDdlAtena().setDisabled(Boolean.FALSE);
            if (AtenaHenshuSeal.世帯主と本人.getKey().equals(div.getDdlAtena().getSelectedKey())) {
                div.getDdlKeisho1().setDisabled(Boolean.TRUE);
            } else {
                div.getDdlKeisho1().setDisabled(Boolean.FALSE);
            }
        }

    }

    private void 初期化処理_四隅項目右上隅(RString menuID) {
        List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.四隅項目_選挙人用
                .getCodeShubetsu());

        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            if (Boolean.valueOf(BusinessConfig.get(ConfigKeysCodeShiyoUmu.コード使用有無_地区の分類１コード,
                    SubGyomuCode.URZ業務共通_共通系).toString())) {
                RString 地区1 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類１,
                        SubGyomuCode.URZ業務共通_共通系);
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区1コード.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区1.concat(コード));
                    }

                    if (YosumiKomokuSenkyonin.地区1.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区1);
                    }
                }
            } else {
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区1コード.getKey().equals(source.get(i).getKey())
                            || YosumiKomokuSenkyonin.地区1.getKey().equals(source.get(i).getKey())) {
                        source.remove(i);
                    }
                }
            }

            if (Boolean.valueOf(BusinessConfig.get(ConfigKeysCodeShiyoUmu.コード使用有無_地区の分類２コード,
                    SubGyomuCode.URZ業務共通_共通系).toString())) {
                RString 地区2 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類２,
                        SubGyomuCode.URZ業務共通_共通系);
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区2コード.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区2.concat(コード));
                    }

                    if (YosumiKomokuSenkyonin.地区2.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区2);
                    }
                }
            } else {
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区2コード.getKey().equals(source.get(i).getKey())
                            || YosumiKomokuSenkyonin.地区2.getKey().equals(source.get(i).getKey())) {
                        source.remove(i);
                    }
                }
            }

            if (Boolean.valueOf(BusinessConfig.get(ConfigKeysCodeShiyoUmu.コード使用有無_地区の分類３コード,
                    SubGyomuCode.URZ業務共通_共通系).toString())) {
                RString 地区3 = BusinessConfig.get(ConfigKeysCodeName.コード名称_地区の分類３,
                        SubGyomuCode.URZ業務共通_共通系);
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区3コード.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区3.concat(コード));
                    }

                    if (YosumiKomokuSenkyonin.地区3.getKey().equals(source.get(i).getKey())) {
                        source.get(i).setValue(地区3);
                    }
                }
            } else {
                for (int i = 0; i < source.size(); i++) {
                    if (YosumiKomokuSenkyonin.地区3コード.getKey().equals(source.get(i).getKey())
                            || YosumiKomokuSenkyonin.地区3.getKey().equals(source.get(i).getKey())) {
                        source.remove(i);
                    }
                }
            }

            div.getDdlRightUp().setDataSource(source);
            div.getDdlRightUp().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlLeftDown().setDataSource(source);
            div.getDdlLeftDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlRightDown().setDataSource(source);
            div.getDdlRightDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getDdlRightUp().setDataSource(source);
            div.getDdlRightUp().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlLeftDown().setDataSource(source);
            div.getDdlLeftDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlRightDown().setDataSource(source);
            div.getDdlRightDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            div.getDdlRightUp().setDataSource(source);
            div.getDdlRightUp().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlLeftDown().setDataSource(source);
            div.getDdlLeftDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
            div.getDdlRightDown().setDataSource(source);
            div.getDdlRightDown().setSelectedKey(YosumiKomokuSenkyonin.印字しない.getKey());
        }
    }

    private void 初期化処理_住所(RString menuID) {

        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.住所編集区分_宛名シール
                    .getCodeShubetsu());
            div.getDdlJusho().setDataSource(source);
            div.getDdlJusho().setSelectedKey(JushoHenshuAtenaSeal.住所_番地_方書.getKey());
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getDdlJusho().setDisplayNone(Boolean.TRUE);
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            div.getDdlJusho().setDisplayNone(Boolean.TRUE);
        }
        onChange_ddlJusho();
    }

    private void 初期化処理_宛名(RString menuID) {

        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())) {
            List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.宛名編集区分_選挙人宛名シール
                    .getCodeShubetsu());
            div.getDdlAtena().setDataSource(source);
            div.getDdlAtena().setSelectedKey(AtenaHenshuSeal.本人.getKey());
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getDdlAtena().setDisplayNone(Boolean.TRUE);
        } else if (menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.宛名編集区分_施設宛名シール
                    .getCodeShubetsu());
            div.getDdlAtena().setDataSource(source);
            div.getDdlAtena().setSelectedKey(AtenaHenshuSealShisetsu.施設名と施設宛名.getKey());
        }
        onChange_ddlAtena();
    }

    private void 初期化処理_世帯主敬称(RString menuID) {
        if (menuID.equals(AFAMenuId.AFAMNE6010_選挙人宛名シール.menuId())
                || menuID.equals(AFAMenuId.AFAMNE6030_施設宛名シール.menuId())) {
            List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.敬称.getCodeShubetsu());
            div.getDdlKeisho1().setDataSource(source);
            div.getDdlKeisho1().setSelectedKey(Keisho.印字しない.getKey());
        } else if (menuID.equals(AFAMenuId.AFAMNE6020_転出者宛名シール.menuId())) {
            div.getDdlKeisho1().setDisplayNone(Boolean.TRUE);
        }
    }

    private void 初期化処理_本人敬称() {
        List<KeyValueDataSource> source = CodeMasterHelper.createDataSource(AFACodeShubetsu.敬称.getCodeShubetsu());
        div.getDdlKeisho2().setDataSource(source);
        div.getDdlKeisho2().setSelectedKey(Keisho.様.getKey());
    }

}
