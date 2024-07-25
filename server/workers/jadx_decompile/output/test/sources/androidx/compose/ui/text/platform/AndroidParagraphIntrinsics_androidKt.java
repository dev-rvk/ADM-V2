package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraphIntrinsics.android.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a+\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u001a\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"hasEmojiCompat", "", "Landroidx/compose/ui/text/TextStyle;", "getHasEmojiCompat", "(Landroidx/compose/ui/text/TextStyle;)Z", "ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-9GRLPo0", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0$default, reason: not valid java name */
    public static /* synthetic */ int m4956resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            textDirection = null;
        }
        if ((i & 2) != 0) {
            localeList = null;
        }
        return m4955resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        if (r0 == null) goto L22;
     */
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int m4955resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection r6, androidx.compose.ui.text.intl.LocaleList r7) {
        /*
            if (r6 == 0) goto L7
            int r0 = r6.getValue()
            goto Ld
        L7:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r0 = r0.m5103getContents_7Xco()
        Ld:
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r1 = r1.m5104getContentOrLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5099equalsimpl0(r0, r1)
            r2 = 2
            if (r1 == 0) goto L1b
            goto L7e
        L1b:
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r1 = r1.m5105getContentOrRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5099equalsimpl0(r0, r1)
            r3 = 3
            if (r1 == 0) goto L2a
            r2 = r3
            goto L7e
        L2a:
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r1 = r1.m5106getLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5099equalsimpl0(r0, r1)
            r4 = 0
            if (r1 == 0) goto L39
            r2 = r4
            goto L7e
        L39:
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r1 = r1.m5107getRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5099equalsimpl0(r0, r1)
            if (r1 == 0) goto L47
            r2 = 1
            goto L7e
        L47:
            androidx.compose.ui.text.style.TextDirection$Companion r1 = androidx.compose.ui.text.style.TextDirection.INSTANCE
            int r1 = r1.m5103getContents_7Xco()
            boolean r0 = androidx.compose.ui.text.style.TextDirection.m5099equalsimpl0(r0, r1)
            if (r0 == 0) goto L7f
            if (r7 == 0) goto L6d
            r0 = r7
            r1 = 0
            androidx.compose.ui.text.intl.Locale r4 = r0.get(r4)
            androidx.compose.ui.text.intl.PlatformLocale r4 = r4.getPlatformLocale()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)
            androidx.compose.ui.text.intl.AndroidLocale r4 = (androidx.compose.ui.text.intl.AndroidLocale) r4
            java.util.Locale r0 = r4.getJavaLocale()
            if (r0 != 0) goto L71
        L6d:
            java.util.Locale r0 = java.util.Locale.getDefault()
        L71:
            int r1 = androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(r0)
            switch(r1) {
                case 0: goto L7d;
                case 1: goto L7b;
                default: goto L7a;
            }
        L7a:
            goto L7e
        L7b:
            r2 = r3
            goto L7e
        L7d:
        L7e:
            return r2
        L7f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Invalid TextDirection."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt.m4955resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection, androidx.compose.ui.text.intl.LocaleList):int");
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String text, TextStyle style, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle $this$hasEmojiCompat) {
        PlatformParagraphStyle paragraphSyle;
        PlatformTextStyle platformStyle = $this$hasEmojiCompat.getPlatformStyle();
        return !(((platformStyle == null || (paragraphSyle = platformStyle.getParagraphSyle()) == null) ? null : EmojiSupportMatch.m4602boximpl(paragraphSyle.getEmojiSupportMatch())) == null ? false : EmojiSupportMatch.m4605equalsimpl0(r0.getValue(), EmojiSupportMatch.INSTANCE.m4610getNone_3YsG6Y()));
    }
}
