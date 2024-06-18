package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDrawKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MultiParagraph.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nBY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017BY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aB\\\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001dB,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010B\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010L\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010M\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010P\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u001b\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020Sø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u000e\u0010V\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005J\u001e\u0010[\u001a\u00020\\2\u0006\u0010?\u001a\u00020\u0005ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u000e\u0010_\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005J[\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\b\b\u0002\u0010f\u001a\u00020\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l2\b\b\u0002\u0010m\u001a\u00020nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ?\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010q\u001a\u00020r2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJS\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010q\u001a\u00020r2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l2\b\b\u0002\u0010m\u001a\u00020nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u0010\u0010w\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010x\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010y\u001a\u00020a2\u0006\u0010E\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u00103\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u0010&R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006z"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "maxLines", "", "ellipsis", "", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i, z);
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j, i, z);
    }

    private MultiParagraph(MultiParagraphIntrinsics intrinsics, long constraints, int maxLines, boolean ellipsis) {
        List list;
        int currentLineCount;
        ParagraphInfo $this$lambda_u244_u24lambda_u243;
        Rect it;
        int m5173getMaxHeightimpl;
        Intrinsics.checkNotNullParameter(intrinsics, "intrinsics");
        this.intrinsics = intrinsics;
        this.maxLines = maxLines;
        int i = 0;
        if (!(Constraints.m5176getMinWidthimpl(constraints) == 0 && Constraints.m5175getMinHeightimpl(constraints) == 0)) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        float currentHeight = 0.0f;
        int currentLineCount2 = 0;
        boolean didExceedMaxLines = false;
        List paragraphInfoList = new ArrayList();
        List infoList = this.intrinsics.getInfoList$ui_text_release();
        int index = 0;
        int size = infoList.size();
        while (index < size) {
            ParagraphIntrinsicInfo paragraphInfo = infoList.get(index);
            ParagraphIntrinsics intrinsics2 = paragraphInfo.getIntrinsics();
            int m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(constraints);
            if (Constraints.m5169getHasBoundedHeightimpl(constraints)) {
                m5173getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m5173getMaxHeightimpl(constraints) - ParagraphKt.ceilToInt(currentHeight), i);
            } else {
                m5173getMaxHeightimpl = Constraints.m5173getMaxHeightimpl(constraints);
            }
            Paragraph paragraph = ParagraphKt.m4626Paragraph_EkL_Y(intrinsics2, ConstraintsKt.Constraints$default(0, m5174getMaxWidthimpl, 0, m5173getMaxHeightimpl, 5, null), this.maxLines - currentLineCount2, ellipsis);
            float paragraphTop = currentHeight;
            float paragraphBottom = currentHeight + paragraph.getHeight();
            currentHeight = paragraphBottom;
            int startLineIndex = currentLineCount2;
            int endLineIndex = startLineIndex + paragraph.getLineCount();
            currentLineCount2 = endLineIndex;
            paragraphInfoList.add(new ParagraphInfo(paragraph, paragraphInfo.getStartIndex(), paragraphInfo.getEndIndex(), startLineIndex, endLineIndex, paragraphTop, paragraphBottom));
            if (!paragraph.getDidExceedMaxLines() && (endLineIndex != this.maxLines || index == CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                index++;
                i = 0;
            }
            didExceedMaxLines = true;
            break;
        }
        this.height = currentHeight;
        this.lineCount = currentLineCount2;
        this.didExceedMaxLines = didExceedMaxLines;
        this.paragraphInfoList = paragraphInfoList;
        this.width = Constraints.m5174getMaxWidthimpl(constraints);
        List $this$fastFlatMap$iv = paragraphInfoList;
        List target$iv = new ArrayList($this$fastFlatMap$iv.size());
        int index$iv$iv = 0;
        int size2 = $this$fastFlatMap$iv.size();
        while (index$iv$iv < size2) {
            Object item$iv$iv = $this$fastFlatMap$iv.get(index$iv$iv);
            ParagraphInfo $this$lambda_u244_u24lambda_u2432 = (ParagraphInfo) item$iv$iv;
            List $this$fastMap$iv = $this$lambda_u244_u24lambda_u2432.getParagraph().getPlaceholderRects();
            Iterable target$iv2 = new ArrayList($this$fastMap$iv.size());
            int size3 = $this$fastMap$iv.size();
            float currentHeight2 = currentHeight;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < size3) {
                Object item$iv$iv2 = $this$fastMap$iv.get(index$iv$iv2);
                int i2 = size3;
                ArrayList arrayList = (Collection) target$iv2;
                List $this$fastFlatMap$iv2 = $this$fastFlatMap$iv;
                Rect it2 = (Rect) item$iv$iv2;
                if (it2 != null) {
                    currentLineCount = currentLineCount2;
                    $this$lambda_u244_u24lambda_u243 = $this$lambda_u244_u24lambda_u2432;
                    it = $this$lambda_u244_u24lambda_u243.toGlobal(it2);
                } else {
                    currentLineCount = currentLineCount2;
                    $this$lambda_u244_u24lambda_u243 = $this$lambda_u244_u24lambda_u2432;
                    it = null;
                }
                arrayList.add(it);
                index$iv$iv2++;
                $this$lambda_u244_u24lambda_u2432 = $this$lambda_u244_u24lambda_u243;
                size3 = i2;
                $this$fastFlatMap$iv = $this$fastFlatMap$iv2;
                currentLineCount2 = currentLineCount;
            }
            Iterable list$iv = (List) target$iv2;
            CollectionsKt.addAll(target$iv, list$iv);
            index$iv$iv++;
            currentHeight = currentHeight2;
            currentLineCount2 = currentLineCount2;
        }
        List it3 = target$iv;
        if (it3.size() < this.intrinsics.getPlaceholders().size()) {
            List list2 = it3;
            int size4 = this.intrinsics.getPlaceholders().size() - it3.size();
            ArrayList arrayList2 = new ArrayList(size4);
            for (int i3 = 0; i3 < size4; i3++) {
                arrayList2.add(null);
            }
            list = CollectionsKt.plus((Collection) list2, (Iterable) arrayList2);
        } else {
            list = it3;
        }
        this.placeholderRects = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.MultiParagraphIntrinsics r8, long r9, int r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 4
            if (r14 == 0) goto L9
            r11 = 2147483647(0x7fffffff, float:NaN)
            r4 = r11
            goto La
        L9:
            r4 = r11
        La:
            r11 = r13 & 8
            if (r11 == 0) goto L11
            r12 = 0
            r5 = r12
            goto L12
        L11:
            r5 = r12
        L12:
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.MultiParagraphIntrinsics, long, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i, boolean z, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i2 & 2) != 0 ? Integer.MAX_VALUE : i, (i2 & 4) != 0 ? false : z, f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(MultiParagraphIntrinsics intrinsics, int maxLines, boolean ellipsis, float width) {
        this(intrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), 0, 0, 13, null), maxLines, ellipsis, null);
        Intrinsics.checkNotNullParameter(intrinsics, "intrinsics");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, float f, Density density, Font.ResourceLoader resourceLoader, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 4) != 0 ? CollectionsKt.emptyList() : list), (i2 & 8) != 0 ? Integer.MAX_VALUE : i, (i2 & 16) != 0 ? false : z, f, density, resourceLoader);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public MultiParagraph(AnnotatedString annotatedString, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean ellipsis, float width, Density density, Font.ResourceLoader resourceLoader) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader)), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), 0, 0, 13, null), maxLines, ellipsis, null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, float f, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, f, density, resolver, (List<AnnotatedString.Range<Placeholder>>) ((i2 & 32) != 0 ? CollectionsKt.emptyList() : list), (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(AnnotatedString annotatedString, TextStyle style, float width, Density density, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(width), 0, 0, 13, null), maxLines, ellipsis, null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
    }

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j, Density density, FontFamily.Resolver resolver, List list, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j, density, resolver, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? Integer.MAX_VALUE : i, (i2 & 128) != 0 ? false : z, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private MultiParagraph(AnnotatedString annotatedString, TextStyle style, long constraints, Density density, FontFamily.Resolver fontFamilyResolver, List<AnnotatedString.Range<Placeholder>> placeholders, int maxLines, boolean ellipsis) {
        this(new MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver), constraints, maxLines, ellipsis, null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo $this$_get_lastBaseline__u24lambda_u240 = (ParagraphInfo) CollectionsKt.last((List) this.paragraphInfoList);
        return $this$_get_lastBaseline__u24lambda_u240.toGlobalYPosition($this$_get_lastBaseline__u24lambda_u240.getParagraph().getLastBaseline());
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the new paint function that takes canvas as the only required parameter.")
    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    public final /* synthetic */ void m4617paintRPmYEkk(Canvas canvas, long color, Shadow shadow, TextDecoration decoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        List $this$fastForEach$iv = this.paragraphInfoList;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ParagraphInfo it = (ParagraphInfo) item$iv;
            it.getParagraph().mo4589paintRPmYEkk(canvas, color, shadow, decoration);
            canvas.translate(0.0f, it.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-LG529CI, reason: not valid java name */
    public final void m4616paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        List $this$fastForEach$iv = this.paragraphInfoList;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            ParagraphInfo it = (ParagraphInfo) item$iv;
            it.getParagraph().mo4588paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, it.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m4618painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidMultiParagraphDrawKt.m4951drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    public final Path getPathForRange(int start, int end) {
        if (!((start >= 0 && start <= end) && end <= getAnnotatedString().getText().length())) {
            throw new IllegalArgumentException(("Start(" + start + ") or End(" + end + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
        }
        if (start == end) {
            return AndroidPath_androidKt.Path();
        }
        int paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, start);
        Path path = AndroidPath_androidKt.Path();
        int size = this.paragraphInfoList.size();
        for (int i = paragraphIndex; i < size; i++) {
            ParagraphInfo p = this.paragraphInfoList.get(i);
            if (p.getStartIndex() >= end) {
                break;
            }
            if (p.getStartIndex() != p.getEndIndex()) {
                Path.m3213addPathUv8p0NA$default(path, p.toGlobal(p.getParagraph().getPathForRange(p.toLocalIndex(start), p.toLocalIndex(end))), 0L, 2, null);
            }
        }
        return path;
    }

    public final int getLineForVerticalPosition(float vertical) {
        int paragraphIndex;
        if (vertical <= 0.0f) {
            paragraphIndex = 0;
        } else {
            paragraphIndex = vertical >= this.height ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical);
        }
        ParagraphInfo $this$getLineForVerticalPosition_u24lambda_u2411 = this.paragraphInfoList.get(paragraphIndex);
        if ($this$getLineForVerticalPosition_u24lambda_u2411.getLength() == 0) {
            return Math.max(0, $this$getLineForVerticalPosition_u24lambda_u2411.getStartIndex() - 1);
        }
        return $this$getLineForVerticalPosition_u24lambda_u2411.toGlobalLineIndex($this$getLineForVerticalPosition_u24lambda_u2411.getParagraph().getLineForVerticalPosition($this$getLineForVerticalPosition_u24lambda_u2411.toLocalYPosition(vertical)));
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m4614getOffsetForPositionk4lQ0M(long position) {
        int paragraphIndex;
        if (Offset.m2711getYimpl(position) <= 0.0f) {
            paragraphIndex = 0;
        } else {
            paragraphIndex = Offset.m2711getYimpl(position) >= this.height ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m2711getYimpl(position));
        }
        ParagraphInfo $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412 = this.paragraphInfoList.get(paragraphIndex);
        if ($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getLength() == 0) {
            return Math.max(0, $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getStartIndex() - 1);
        }
        return $this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.toGlobalIndex($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.getParagraph().mo4586getOffsetForPositionk4lQ0M($this$getOffsetForPosition_k_4lQ0M_u24lambda_u2412.m4623toLocalMKHz9U(position)));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        int paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        ParagraphInfo $this$getBoundingBox_u24lambda_u2413 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getBoundingBox_u24lambda_u2413.toGlobal($this$getBoundingBox_u24lambda_u2413.getParagraph().getBoundingBox($this$getBoundingBox_u24lambda_u2413.toLocalIndex(offset)));
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getHorizontalPosition_u24lambda_u2414 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getHorizontalPosition_u24lambda_u2414.getParagraph().getHorizontalPosition($this$getHorizontalPosition_u24lambda_u2414.toLocalIndex(offset), usePrimaryDirection);
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getParagraphDirection_u24lambda_u2415 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getParagraphDirection_u24lambda_u2415.getParagraph().getParagraphDirection($this$getParagraphDirection_u24lambda_u2415.toLocalIndex(offset));
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getBidiRunDirection_u24lambda_u2416 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getBidiRunDirection_u24lambda_u2416.getParagraph().getBidiRunDirection($this$getBidiRunDirection_u24lambda_u2416.toLocalIndex(offset));
    }

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m4615getWordBoundaryjx7JFs(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getWordBoundary__jx7JFs_u24lambda_u2417 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getWordBoundary__jx7JFs_u24lambda_u2417.m4622toGlobalGEjPoXI($this$getWordBoundary__jx7JFs_u24lambda_u2417.getParagraph().mo4587getWordBoundaryjx7JFs($this$getWordBoundary__jx7JFs_u24lambda_u2417.toLocalIndex(offset)));
    }

    public final Rect getCursorRect(int offset) {
        int paragraphIndex;
        requireIndexInRangeInclusiveEnd(offset);
        if (offset == getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getCursorRect_u24lambda_u2418 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getCursorRect_u24lambda_u2418.toGlobal($this$getCursorRect_u24lambda_u2418.getParagraph().getCursorRect($this$getCursorRect_u24lambda_u2418.toLocalIndex(offset)));
    }

    public final int getLineForOffset(int offset) {
        int paragraphIndex;
        if (offset >= getAnnotatedString().length()) {
            paragraphIndex = CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else if (offset < 0) {
            paragraphIndex = 0;
        } else {
            paragraphIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset);
        }
        ParagraphInfo $this$getLineForOffset_u24lambda_u2419 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineForOffset_u24lambda_u2419.toGlobalLineIndex($this$getLineForOffset_u24lambda_u2419.getParagraph().getLineForOffset($this$getLineForOffset_u24lambda_u2419.toLocalIndex(offset)));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineLeft_u24lambda_u2420 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineLeft_u24lambda_u2420.getParagraph().getLineLeft($this$getLineLeft_u24lambda_u2420.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineRight_u24lambda_u2421 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineRight_u24lambda_u2421.getParagraph().getLineRight($this$getLineRight_u24lambda_u2421.toLocalLineIndex(lineIndex));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineTop_u24lambda_u2422 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineTop_u24lambda_u2422.toGlobalYPosition($this$getLineTop_u24lambda_u2422.getParagraph().getLineTop($this$getLineTop_u24lambda_u2422.toLocalLineIndex(lineIndex)));
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineBottom_u24lambda_u2423 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineBottom_u24lambda_u2423.toGlobalYPosition($this$getLineBottom_u24lambda_u2423.getParagraph().getLineBottom($this$getLineBottom_u24lambda_u2423.toLocalLineIndex(lineIndex)));
    }

    public final float getLineHeight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineHeight_u24lambda_u2424 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineHeight_u24lambda_u2424.getParagraph().getLineHeight($this$getLineHeight_u24lambda_u2424.toLocalLineIndex(lineIndex));
    }

    public final float getLineWidth(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineWidth_u24lambda_u2425 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineWidth_u24lambda_u2425.getParagraph().getLineWidth($this$getLineWidth_u24lambda_u2425.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineStart_u24lambda_u2426 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineStart_u24lambda_u2426.toGlobalIndex($this$getLineStart_u24lambda_u2426.getParagraph().getLineStart($this$getLineStart_u24lambda_u2426.toLocalLineIndex(lineIndex)));
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return multiParagraph.getLineEnd(i, z);
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$getLineEnd_u24lambda_u2427 = this.paragraphInfoList.get(paragraphIndex);
        return $this$getLineEnd_u24lambda_u2427.toGlobalIndex($this$getLineEnd_u24lambda_u2427.getParagraph().getLineEnd($this$getLineEnd_u24lambda_u2427.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final boolean isLineEllipsized(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        int paragraphIndex = MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex);
        ParagraphInfo $this$isLineEllipsized_u24lambda_u2428 = this.paragraphInfoList.get(paragraphIndex);
        return $this$isLineEllipsized_u24lambda_u2428.getParagraph().isLineEllipsized(lineIndex);
    }

    private final void requireIndexInRange(int offset) {
        boolean z = false;
        if (offset >= 0 && offset < getAnnotatedString().getText().length()) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        boolean z = false;
        if (offset >= 0 && offset <= getAnnotatedString().getText().length()) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ']').toString());
        }
    }

    private final void requireLineIndexInRange(int lineIndex) {
        boolean z = false;
        if (lineIndex >= 0 && lineIndex < this.lineCount) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException(("lineIndex(" + lineIndex + ") is out of bounds [0, " + this.lineCount + ')').toString());
        }
    }
}
