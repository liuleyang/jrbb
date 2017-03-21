/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA106;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA106.ShinkiTorokushaMeiboJuranSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 異動者名簿縦覧を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの異動者名簿縦覧ソースクラスを受け取ります。
 *
 * @reamsid_L AF-0010-040 xiaoj
 */
public final class ShinkiTorokushaMeiboJuranReport extends Report<ShinkiTorokushaMeiboJuranSource> {

    private final ShinkiTorokushaMeiboJuranParameter target;

    /**
     * コンストラクタです。
     *
     * @param target 新規登録者名簿縦覧のパラメータ
     */
    public ShinkiTorokushaMeiboJuranReport(ShinkiTorokushaMeiboJuranParameter target) {
        this.target = target;

    }

    /**
     * 指定の{@link ReportSourceWriter}を使用して、帳票ソースファイルの「永続化処理の定義」を行います。
     *
     * @param writer {@link ReportSourceWriter}
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinkiTorokushaMeiboJuranSource> writer) {
        if (isPrint(target)) {
            IShinkiTorokushaMeiboJuranEditor editor = new ShinkiTorokushaMeiboJuranEditor(target);
            IShinkiTorokushaMeiboJuranBuilder builder = new ShinkiTorokushaMeiboJuranBuilder(editor);
            writer.writeLine(builder);
        }
    }

    private Boolean isPrint(ShinkiTorokushaMeiboJuranParameter model) {
        Boolean flag = Boolean.TRUE;
        if (target.get帳票共通ヘッダー().get帳票ID().equals(ReportIdKeys.新規登録者名簿縦覧.value())) {
            flag = isPrintBy新規登録者名簿(model);
        }
        return flag;
    }

    private Boolean isPrintBy新規登録者名簿(ShinkiTorokushaMeiboJuranParameter model) {
        RString 事由コード = get事由コード(model, ReportIdKeys.新規登録者名簿縦覧);
        return 事由コード.equals(JiyuCode.年齢到達.getKey())
                || 事由コード.equals(JiyuCode.転入3カ月経過.getKey())
                || 事由コード.equals(JiyuCode.その他_登録.getKey());
    }

    private RString get事由コード(ShinkiTorokushaMeiboJuranParameter model, ReportIdKeys 事由) {
        if (事由.equals(ReportIdKeys.新規登録者名簿縦覧)) {
            Code 登録事由 = model.get選挙人資格の情報().getSenkyoShikakuEntity().getTorokuJiyuCode();
            return null == 登録事由 ? RString.EMPTY : 登録事由.value();
        }
        return RString.EMPTY;
    }
}
