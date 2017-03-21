/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.IdouSenkyoninIchiran;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.IchigoShikakuTorokuTsuchiListSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.data.ReportDataInfoLoader;

/**
 * {@link IchigoShikakuTorokuTsuchiListSource}を編集します。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListEditor implements IIchigoShikakuTorokuTsuchiListEditor {

    private final IchigoShikakuTorokuTsuchiListParameter target;
    private final TeijiCommonJohoItem 帳票共通ヘッダー;
    private static final RString 全角スペース = new RString("　");
    private final IShikibetsuTaisho 宛名識別対象;
    private final IdouSenkyoninIchiran 異動選挙人一覧 = new IdouSenkyoninIchiran();

    /**
     * テスト用のコンストラクタです。
     *
     * @param target {@link IchigoShikakuTorokuTsuchiListParameter}
     * @param 帳票共通ヘッダー TeijiCommonJohoItem
     */
    public IchigoShikakuTorokuTsuchiListEditor(IchigoShikakuTorokuTsuchiListParameter target, TeijiCommonJohoItem 帳票共通ヘッダー) {
        this.target = target;
        this.帳票共通ヘッダー = 帳票共通ヘッダー;
        宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(target.get選挙人資格の情報().getShikibetsuTaishoEntity());
    }

    @Override
    public IchigoShikakuTorokuTsuchiListSource edit(IchigoShikakuTorokuTsuchiListSource source) {

        setヘッダ(source);
        source.title = new RString("1号資格登録通知一覧表");
        source.headJushoName = new RString("転出元住所");
        source.headYmdName = new RString("転入年月日");
        if (target.is出力区分_空白行()) {
            source.listMeisai_4 = RString.EMPTY;
            if (target.is出力区分_集計行()) {
                source.listMeisai_4 = target.get集計();
            }
        } else {
            set氏名(source);
            source.listMeisai_2 = get生年月日();
            source.listMeisai_3 = get性別();
            set住所(source);
            set日付(source);
            editログの出力(source);
        }
        return source;
    }

    private void setヘッダ(IchigoShikakuTorokuTsuchiListSource source) {

        source.shichosonCode = 帳票共通ヘッダー.get市町村コード();
        source.shichosonMei = 帳票共通ヘッダー.get市町村名();
        source.sakuseiYmdTime = 帳票共通ヘッダー.get作成日時().concat("作成");
        RStringBuilder 選挙名称 = new RStringBuilder();
        選挙名称.append(target.get選挙人資格の情報().getSenkyoEntity().getSenkyoName());
        if (target.getSenkyoCount() > 1) {
            選挙名称.append(RString.FULL_SPACE)
                    .append("他");
        }
        source.senkyoMei = 選挙名称.toRString();

    }

    private void editログの出力(IchigoShikakuTorokuTsuchiListSource source) {
        source.識別コード = target.get選挙人資格の情報().getSenkyoninMeiboEntity().getShikibetsuCode();
    }

    private void set氏名(IchigoShikakuTorokuTsuchiListSource source) {
        RString 文字列 = 宛名識別対象.to個人().get名称().getName().value();
        source.listMeisai_1 = 文字列;
    }

    private RString get性別() {
        return 宛名識別対象.to個人().get性別().getCommonName();
    }

    private RString get生年月日() {
        FlexibleDate 生年月日 = 宛名識別対象.to個人().get生年月日().toFlexibleDate();
        RString 住民種別コード = 宛名識別対象.get住民種別().getCode();
        return 異動選挙人一覧.get生年月日(住民種別コード, 生年月日);
    }

    private void set住所(IchigoShikakuTorokuTsuchiListSource source) {
        int 当住所１最大文字数 = ReportDataInfoLoader.getMaxLength(IchigoShikakuTorokuTsuchiListSource.class, new RString("listMeisai_4"));
        RString 転入前住所 = 宛名識別対象.to個人().get転入前().get住所();
        RString 転入前番地 = 宛名識別対象.to個人().get転入前().get番地().getBanchi().value().trimStart();
        RString 転入前方書 = 宛名識別対象.to個人().get転入前().get方書().value();
        RStringBuilder 住所 = new RStringBuilder();
        if (転入前住所 != null) {
            住所.append(転入前住所);
        }
        if (転入前番地 != null) {
            住所.append(転入前番地);
        }
        住所.replace(RString.FULL_SPACE, RString.EMPTY);
        住所.replace(RString.HALF_SPACE, RString.EMPTY);
        RString 住所文字列 = 住所.toRString().concat(全角スペース).concat(転入前方書);
        List<RString> 名称List = 異動選挙人一覧.文字列分割(住所文字列, 当住所１最大文字数);
        source.listMeisai_4 = 名称List.get(0);
    }

    private void set日付(IchigoShikakuTorokuTsuchiListSource source) {
        if (target.is登録年月日検索基準_登録届出年月日()) {
            source.listMeisai_5 = 宛名識別対象.to個人().get登録届出年月日().wareki().toDateString();
        } else if (target.is登録年月日検索基準_登録異動年月日()) {
            source.listMeisai_5 = 宛名識別対象.to個人().get登録異動年月日().wareki().toDateString();
        }
    }
}
