package androidx.compose.ui.text;

import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bj\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016B(\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0019JJ\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\rH\u0002J+\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010f\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0018\u0010h\u001a\u00020(2\u0006\u0010e\u001a\u00020\r2\u0006\u0010i\u001a\u00020\u000fH\u0016J\u0015\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0015\u0010p\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bqJ\u0018\u0010r\u001a\u00020\r2\u0006\u0010k\u001a\u00020\r2\u0006\u0010s\u001a\u00020\u000fH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020(H\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010y\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010z\u001a\u00020\r2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010{\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010|\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u001f\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\u007fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u001c\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\rH\u0016J\"\u0010M\u001a\u00020]2\u0006\u0010e\u001a\u00020\rH\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\rH\u0016J\u0013\u0010\u008a\u0001\u001a\u00020[2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0002Jc\u0010\u008a\u0001\u001a\u00020[2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020(2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001JD\u0010\u008a\u0001\u001a\u00020[2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001JZ\u0010\u008a\u0001\u001a\u00020[2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001b\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010¡\u0001*\u000200H\u0002¢\u0006\u0003\u0010£\u0001R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0081\u0004¢\u0006\f\u0012\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0081\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010N\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBaseline$ui_text_release", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidParagraph implements Paragraph {
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    private final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;

    /* renamed from: wordBoundary$delegate, reason: from kotlin metadata */
    private final Lazy wordBoundary;

    /* compiled from: AndroidParagraph.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i, z, j);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i, boolean z, long j, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i, z, j, resolver, density);
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    private AndroidParagraph(AndroidParagraphIntrinsics paragraphIntrinsics, int maxLines, boolean ellipsis, long constraints) {
        CharSequence charSequence;
        TextUtils.TruncateAt ellipsize;
        int i;
        List<Rect> list;
        Object[] $this$mapTo$iv$iv;
        int $i$f$mapTo;
        int i2;
        Rect rect;
        float horizontalPosition;
        float lineBaseline;
        TextLayout textLayout;
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        this.paragraphIntrinsics = paragraphIntrinsics;
        this.maxLines = maxLines;
        this.ellipsis = ellipsis;
        this.constraints = constraints;
        if (!(Constraints.m5175getMinHeightimpl(this.constraints) == 0 && Constraints.m5176getMinWidthimpl(this.constraints) == 0)) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        if (!(this.maxLines >= 1)) {
            throw new IllegalArgumentException("maxLines should be greater than 0".toString());
        }
        TextStyle style = this.paragraphIntrinsics.getStyle();
        if (AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(style, this.ellipsis)) {
            charSequence = AndroidParagraph_androidKt.access$attachIndentationFixSpan(this.paragraphIntrinsics.getCharSequence());
        } else {
            charSequence = this.paragraphIntrinsics.getCharSequence();
        }
        this.charSequence = charSequence;
        int alignment = AndroidParagraph_androidKt.m4591access$toLayoutAlignAMY3VfE(style.m4755getTextAlignbuA522U());
        TextAlign m4755getTextAlignbuA522U = style.m4755getTextAlignbuA522U();
        int justificationMode = m4755getTextAlignbuA522U == null ? false : TextAlign.m5086equalsimpl0(m4755getTextAlignbuA522U.getValue(), TextAlign.INSTANCE.m5092getJustifye0LSkKk()) ? 1 : 0;
        int hyphens = AndroidParagraph_androidKt.m4593access$toLayoutHyphenationFrequency0_XeFpE(style.getParagraphStyle().getHyphens());
        LineBreak m4753getLineBreakLgCVezo = style.m4753getLineBreakLgCVezo();
        int breakStrategy = AndroidParagraph_androidKt.m4592access$toLayoutBreakStrategyu6PBz3U(m4753getLineBreakLgCVezo != null ? LineBreak.Strategy.m5027boximpl(LineBreak.m5018getStrategyfcGXIks(m4753getLineBreakLgCVezo.getMask())) : null);
        LineBreak m4753getLineBreakLgCVezo2 = style.m4753getLineBreakLgCVezo();
        int lineBreakStyle = AndroidParagraph_androidKt.m4594access$toLayoutLineBreakStyle4a2g8L8(m4753getLineBreakLgCVezo2 != null ? LineBreak.Strictness.m5037boximpl(LineBreak.m5019getStrictnessusljTpc(m4753getLineBreakLgCVezo2.getMask())) : null);
        LineBreak m4753getLineBreakLgCVezo3 = style.m4753getLineBreakLgCVezo();
        int lineBreakWordStyle = AndroidParagraph_androidKt.m4595access$toLayoutLineBreakWordStylegvcdTPQ(m4753getLineBreakLgCVezo3 != null ? LineBreak.WordBreak.m5048boximpl(LineBreak.m5020getWordBreakjp8hJ3c(m4753getLineBreakLgCVezo3.getMask())) : null);
        if (this.ellipsis) {
            ellipsize = TextUtils.TruncateAt.END;
        } else {
            ellipsize = null;
        }
        TextLayout firstLayout = constructTextLayout(alignment, justificationMode, ellipsize, this.maxLines, hyphens, breakStrategy, lineBreakStyle, lineBreakWordStyle);
        if (!this.ellipsis || firstLayout.getHeight() <= Constraints.m5173getMaxHeightimpl(this.constraints) || this.maxLines <= 1) {
            i = 0;
            this.layout = firstLayout;
        } else {
            int calculatedMaxLines = AndroidParagraph_androidKt.access$numberOfLinesThatFitMaxHeight(firstLayout, Constraints.m5173getMaxHeightimpl(this.constraints));
            if (calculatedMaxLines < 0 || calculatedMaxLines == this.maxLines) {
                i = 0;
                textLayout = firstLayout;
            } else {
                i = 0;
                textLayout = constructTextLayout(alignment, justificationMode, ellipsize, RangesKt.coerceAtLeast(calculatedMaxLines, 1), hyphens, breakStrategy, lineBreakStyle, lineBreakWordStyle);
            }
            this.layout = textLayout;
        }
        getTextPaint$ui_text_release().m4963setBrush12SF9DM(style.getBrush(), SizeKt.Size(getWidth(), getHeight()), style.getAlpha());
        ShaderBrushSpan[] shaderBrushSpans = getShaderBrushSpans(this.layout);
        int length = shaderBrushSpans.length;
        for (int i3 = i; i3 < length; i3++) {
            shaderBrushSpans[i3].m4982setSizeuvyYCjk(SizeKt.Size(getWidth(), getHeight()));
        }
        CharSequence $this$placeholderRects_u24lambda_u246 = this.charSequence;
        int i4 = 0;
        if ($this$placeholderRects_u24lambda_u246 instanceof Spanned) {
            Object[] $this$map$iv = ((Spanned) $this$placeholderRects_u24lambda_u246).getSpans(i, $this$placeholderRects_u24lambda_u246.length(), PlaceholderSpan.class);
            Intrinsics.checkNotNullExpressionValue($this$map$iv, "getSpans(0, length, PlaceholderSpan::class.java)");
            int $i$f$map = 0;
            Collection destination$iv$iv = new ArrayList($this$map$iv.length);
            Object[] $this$mapTo$iv$iv2 = $this$map$iv;
            int $i$f$mapTo2 = 0;
            int length2 = $this$mapTo$iv$iv2.length;
            int i5 = i;
            while (i5 < length2) {
                Object item$iv$iv = $this$mapTo$iv$iv2[i5];
                PlaceholderSpan span = (PlaceholderSpan) item$iv$iv;
                int start = ((Spanned) $this$placeholderRects_u24lambda_u246).getSpanStart(span);
                int end = ((Spanned) $this$placeholderRects_u24lambda_u246).getSpanEnd(span);
                CharSequence $this$placeholderRects_u24lambda_u2462 = $this$placeholderRects_u24lambda_u246;
                int line = this.layout.getLineForOffset(start);
                int i6 = i4;
                boolean exceedsMaxLines = line >= this.maxLines;
                Object[] $this$map$iv2 = $this$map$iv;
                boolean isPlaceholderSpanEllipsized = this.layout.getLineEllipsisCount(line) > 0 && end > this.layout.getLineEllipsisOffset(line);
                int $i$f$map2 = $i$f$map;
                boolean isPlaceholderSpanTruncated = end > this.layout.getLineEnd(line);
                if (isPlaceholderSpanEllipsized || isPlaceholderSpanTruncated) {
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $i$f$mapTo = $i$f$mapTo2;
                    i2 = length2;
                } else if (exceedsMaxLines) {
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $i$f$mapTo = $i$f$mapTo2;
                    i2 = length2;
                } else {
                    ResolvedTextDirection direction = getBidiRunDirection(start);
                    switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
                        case 1:
                            horizontalPosition = getHorizontalPosition(start, true);
                            break;
                        case 2:
                            horizontalPosition = getHorizontalPosition(start, true) - span.getWidthPx();
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    float left = horizontalPosition;
                    float right = span.getWidthPx() + left;
                    TextLayout $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244 = this.layout;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    switch (span.getVerticalAlign()) {
                        case 0:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBaseline(line) - span.getHeightPx();
                            break;
                        case 1:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineTop(line);
                            break;
                        case 2:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBottom(line) - span.getHeightPx();
                            break;
                        case 3:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = (($this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineTop(line) + $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBottom(line)) - span.getHeightPx()) / 2;
                            break;
                        case 4:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBaseline(line) + span.getFontMetrics().ascent;
                            break;
                        case 5:
                            $i$f$mapTo = $i$f$mapTo2;
                            i2 = length2;
                            lineBaseline = (span.getFontMetrics().descent + $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBaseline(line)) - span.getHeightPx();
                            break;
                        case 6:
                            Paint.FontMetricsInt $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244_u24lambda_u243 = span.getFontMetrics();
                            $i$f$mapTo = $i$f$mapTo2;
                            int $i$f$mapTo3 = $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244_u24lambda_u243.ascent;
                            i2 = length2;
                            lineBaseline = ((($i$f$mapTo3 + $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244_u24lambda_u243.descent) - span.getHeightPx()) / 2) + $this$placeholderRects_u24lambda_u246_u24lambda_u245_u24lambda_u244.getLineBaseline(line);
                            break;
                        default:
                            throw new IllegalStateException("unexpected verticalAlignment");
                    }
                    float top = lineBaseline;
                    float bottom = span.getHeightPx() + top;
                    rect = new Rect(left, top, right, bottom);
                    destination$iv$iv.add(rect);
                    i5++;
                    $this$placeholderRects_u24lambda_u246 = $this$placeholderRects_u24lambda_u2462;
                    i4 = i6;
                    $this$map$iv = $this$map$iv2;
                    $i$f$map = $i$f$map2;
                    $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    $i$f$mapTo2 = $i$f$mapTo;
                    length2 = i2;
                }
                rect = null;
                destination$iv$iv.add(rect);
                i5++;
                $this$placeholderRects_u24lambda_u246 = $this$placeholderRects_u24lambda_u2462;
                i4 = i6;
                $this$map$iv = $this$map$iv2;
                $i$f$map = $i$f$map2;
                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                $i$f$mapTo2 = $i$f$mapTo;
                length2 = i2;
            }
            list = (List) destination$iv$iv;
        } else {
            list = CollectionsKt.emptyList();
        }
        this.placeholderRects = list;
        this.wordBoundary = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<WordBoundary>() { // from class: androidx.compose.ui.text.AndroidParagraph$wordBoundary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WordBoundary invoke() {
                TextLayout textLayout2;
                Locale textLocale$ui_text_release = AndroidParagraph.this.getTextLocale$ui_text_release();
                textLayout2 = AndroidParagraph.this.layout;
                return new WordBoundary(textLocale$ui_text_release, textLayout2.getText());
            }
        });
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    /* renamed from: getConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getConstraints() {
        return this.constraints;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private AndroidParagraph(String text, TextStyle style, List<AnnotatedString.Range<SpanStyle>> spanStyles, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean ellipsis, long constraints, FontFamily.Resolver fontFamilyResolver, Density density) {
        this(new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density), maxLines, ellipsis, constraints, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "density");
    }

    /* renamed from: getCharSequence$ui_text_release, reason: from getter */
    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getWidth() {
        return Constraints.m5174getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLastBaseline() {
        return getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineCount() {
        return this.layout.getLineCount();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForVerticalPosition(float vertical) {
        return this.layout.getLineForVertical((int) vertical);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public int mo4586getOffsetForPositionk4lQ0M(long position) {
        int line = this.layout.getLineForVertical((int) Offset.m2711getYimpl(position));
        return this.layout.getOffsetForHorizontal(line, Offset.m2710getXimpl(position));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getBoundingBox(int offset) {
        RectF rectF = this.layout.getBoundingBox(offset);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final void m4584fillBoundingBoxes8ffj60Q(long range, float[] array, int arrayStart) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.layout.fillBoundingBoxes(TextRange.m4724getMinimpl(range), TextRange.m4723getMaximpl(range), array, arrayStart);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Path getPathForRange(int start, int end) {
        boolean z = false;
        if (start >= 0 && start <= end) {
            z = true;
        }
        if (!z || end > this.charSequence.length()) {
            throw new AssertionError("Start(" + start + ") or End(" + end + ") is out of Range(0.." + this.charSequence.length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(start, end, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public Rect getCursorRect(int offset) {
        if (offset >= 0 && offset <= this.charSequence.length()) {
            float horizontal = TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null);
            int line = this.layout.getLineForOffset(offset);
            return new Rect(horizontal, this.layout.getLineTop(line), horizontal, this.layout.getLineBottom(line));
        }
        throw new AssertionError("offset(" + offset + ") is out of bounds (0," + this.charSequence.length());
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary.getValue();
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public long mo4587getWordBoundaryjx7JFs(int offset) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(offset), getWordBoundary().getWordEnd(offset));
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineLeft(int lineIndex) {
        return this.layout.getLineLeft(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineRight(int lineIndex) {
        return this.layout.getLineRight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineTop(int lineIndex) {
        return this.layout.getLineTop(lineIndex);
    }

    public final float getLineAscent$ui_text_release(int lineIndex) {
        return this.layout.getLineAscent(lineIndex);
    }

    public final float getLineBaseline$ui_text_release(int lineIndex) {
        return this.layout.getLineBaseline(lineIndex);
    }

    public final float getLineDescent$ui_text_release(int lineIndex) {
        return this.layout.getLineDescent(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineBottom(int lineIndex) {
        return this.layout.getLineBottom(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineHeight(int lineIndex) {
        return this.layout.getLineHeight(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getLineWidth(int lineIndex) {
        return this.layout.getLineWidth(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineStart(int lineIndex) {
        return this.layout.getLineStart(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineEnd(int lineIndex, boolean visibleEnd) {
        if (visibleEnd) {
            return this.layout.getLineVisibleEnd(lineIndex);
        }
        return this.layout.getLineEnd(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public boolean isLineEllipsized(int lineIndex) {
        return this.layout.isLineEllipsized(lineIndex);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public int getLineForOffset(int offset) {
        return this.layout.getLineForOffset(offset);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        return usePrimaryDirection ? TextLayout.getPrimaryHorizontal$default(this.layout, offset, false, 2, null) : TextLayout.getSecondaryHorizontal$default(this.layout, offset, false, 2, null);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getParagraphDirection(int offset) {
        int lineIndex = this.layout.getLineForOffset(offset);
        int direction = this.layout.getParagraphDirection(lineIndex);
        return direction == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public ResolvedTextDirection getBidiRunDirection(int offset) {
        if (this.layout.isRtlCharAt(offset)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout $this$getShaderBrushSpans) {
        if ($this$getShaderBrushSpans.getText() instanceof Spanned) {
            CharSequence text = $this$getShaderBrushSpans.getText();
            Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
            ShaderBrushSpan[] brushSpans = (ShaderBrushSpan[]) ((Spanned) text).getSpans(0, $this$getShaderBrushSpans.getText().length(), ShaderBrushSpan.class);
            Intrinsics.checkNotNullExpressionValue(brushSpans, "brushSpans");
            if (!(brushSpans.length == 0)) {
                return brushSpans;
            }
            return new ShaderBrushSpan[0];
        }
        return new ShaderBrushSpan[0];
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public void mo4589paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint $this$paint_RPmYEkk_u24lambda_u248 = getTextPaint$ui_text_release();
        $this$paint_RPmYEkk_u24lambda_u248.m4964setColor8_81llA(color);
        $this$paint_RPmYEkk_u24lambda_u248.setShadow(shadow);
        $this$paint_RPmYEkk_u24lambda_u248.setTextDecoration(textDecoration);
        paint(canvas);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI, reason: not valid java name */
    public void mo4588paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int currBlendMode = getTextPaint$ui_text_release().m4961getBlendMode0nO6VwU();
        AndroidTextPaint $this$paint_LG529CI_u24lambda_u249 = getTextPaint$ui_text_release();
        $this$paint_LG529CI_u24lambda_u249.m4964setColor8_81llA(color);
        $this$paint_LG529CI_u24lambda_u249.setShadow(shadow);
        $this$paint_LG529CI_u24lambda_u249.setTextDecoration(textDecoration);
        $this$paint_LG529CI_u24lambda_u249.setDrawStyle(drawStyle);
        $this$paint_LG529CI_u24lambda_u249.m4962setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m4962setBlendModes9anfk8(currBlendMode);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public void mo4590painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        int currBlendMode = getTextPaint$ui_text_release().m4961getBlendMode0nO6VwU();
        AndroidTextPaint $this$paint_hn5TExg_u24lambda_u2410 = getTextPaint$ui_text_release();
        $this$paint_hn5TExg_u24lambda_u2410.m4963setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), alpha);
        $this$paint_hn5TExg_u24lambda_u2410.setShadow(shadow);
        $this$paint_hn5TExg_u24lambda_u2410.setTextDecoration(textDecoration);
        $this$paint_hn5TExg_u24lambda_u2410.setDrawStyle(drawStyle);
        $this$paint_hn5TExg_u24lambda_u2410.m4962setBlendModes9anfk8(blendMode);
        paint(canvas);
        getTextPaint$ui_text_release().m4962setBlendModes9anfk8(currBlendMode);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private final TextLayout constructTextLayout(int alignment, int justificationMode, TextUtils.TruncateAt ellipsize, int maxLines, int hyphens, int breakStrategy, int lineBreakStyle, int lineBreakWordStyle) {
        CharSequence charSequence = this.charSequence;
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        return new TextLayout(charSequence, width, textPaint$ui_text_release, alignment, ellipsize, this.paragraphIntrinsics.getTextDirectionHeuristic(), 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, maxLines, breakStrategy, lineBreakStyle, lineBreakWordStyle, hyphens, justificationMode, null, null, this.paragraphIntrinsics.getLayoutIntrinsics(), 196736, null);
    }
}
