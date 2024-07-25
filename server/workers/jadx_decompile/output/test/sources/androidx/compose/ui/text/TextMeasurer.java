package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: TextMeasurer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008d\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#Jw\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020$2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "fallbackFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fallbackDensity", "Landroidx/compose/ui/unit/Density;", "fallbackLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextMeasurer {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int cacheSize;
    private final Density fallbackDensity;
    private final FontFamily.Resolver fallbackFontFamilyResolver;
    private final LayoutDirection fallbackLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    public TextMeasurer(FontFamily.Resolver fallbackFontFamilyResolver, Density fallbackDensity, LayoutDirection fallbackLayoutDirection, int cacheSize) {
        TextLayoutCache textLayoutCache;
        Intrinsics.checkNotNullParameter(fallbackFontFamilyResolver, "fallbackFontFamilyResolver");
        Intrinsics.checkNotNullParameter(fallbackDensity, "fallbackDensity");
        Intrinsics.checkNotNullParameter(fallbackLayoutDirection, "fallbackLayoutDirection");
        this.fallbackFontFamilyResolver = fallbackFontFamilyResolver;
        this.fallbackDensity = fallbackDensity;
        this.fallbackLayoutDirection = fallbackLayoutDirection;
        this.cacheSize = cacheSize;
        if (this.cacheSize > 0) {
            textLayoutCache = new TextLayoutCache(this.cacheSize);
        } else {
            textLayoutCache = null;
        }
        this.textLayoutCache = textLayoutCache;
    }

    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i2 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i);
    }

    /* renamed from: measure-xDpz5zY$default, reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m4702measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i, boolean z, int i2, List list, long j, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z2, int i3, Object obj) {
        return textMeasurer.m4704measurexDpz5zY(annotatedString, (i3 & 2) != 0 ? TextStyle.INSTANCE.getDefault() : textStyle, (i3 & 4) != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list, (i3 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : j, (i3 & 128) != 0 ? textMeasurer.fallbackLayoutDirection : layoutDirection, (i3 & 256) != 0 ? textMeasurer.fallbackDensity : density, (i3 & 512) != 0 ? textMeasurer.fallbackFontFamilyResolver : resolver, (i3 & 1024) != 0 ? false : z2);
    }

    /* renamed from: measure-xDpz5zY, reason: not valid java name */
    public final TextLayoutResult m4704measurexDpz5zY(AnnotatedString text, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        TextLayoutResult cacheResult;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        TextLayoutInput requestedTextLayoutInput = new TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints, (DefaultConstructorMarker) null);
        if (!skipCache && this.textLayoutCache != null) {
            cacheResult = this.textLayoutCache.get(requestedTextLayoutInput);
        } else {
            cacheResult = null;
        }
        if (cacheResult != null) {
            return cacheResult.m4697copyO0kMr_c(requestedTextLayoutInput, ConstraintsKt.m5185constrain4WqzIAM(constraints, IntSizeKt.IntSize(ParagraphKt.ceilToInt(cacheResult.getMultiParagraph().getWidth()), ParagraphKt.ceilToInt(cacheResult.getMultiParagraph().getHeight()))));
        }
        TextLayoutResult it = INSTANCE.layout(requestedTextLayoutInput);
        TextLayoutCache textLayoutCache = this.textLayoutCache;
        if (textLayoutCache != null) {
            textLayoutCache.put(requestedTextLayoutInput, it);
            return it;
        }
        return it;
    }

    /* renamed from: measure-wNUYSr0, reason: not valid java name */
    public final TextLayoutResult m4703measurewNUYSr0(String text, TextStyle style, int overflow, boolean softWrap, int maxLines, long constraints, LayoutDirection layoutDirection, Density density, FontFamily.Resolver fontFamilyResolver, boolean skipCache) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        return m4702measurexDpz5zY$default(this, new AnnotatedString(text, null, null, 6, null), style, overflow, softWrap, maxLines, null, constraints, layoutDirection, density, fontFamilyResolver, skipCache, 32, null);
    }

    /* compiled from: TextMeasurer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            int maxWidth;
            int width;
            MultiParagraphIntrinsics nonNullIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int minWidth = Constraints.m5176getMinWidthimpl(textLayoutInput.getConstraints());
            boolean overwriteMaxLines = false;
            boolean widthMatters = textLayoutInput.getSoftWrap() || TextOverflow.m5130equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8());
            if (widthMatters && Constraints.m5170getHasBoundedWidthimpl(textLayoutInput.getConstraints())) {
                maxWidth = Constraints.m5174getMaxWidthimpl(textLayoutInput.getConstraints());
            } else {
                maxWidth = Integer.MAX_VALUE;
            }
            if (!textLayoutInput.getSoftWrap() && TextOverflow.m5130equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8())) {
                overwriteMaxLines = true;
            }
            int finalMaxLines = overwriteMaxLines ? 1 : textLayoutInput.getMaxLines();
            if (minWidth == maxWidth) {
                width = maxWidth;
            } else {
                width = RangesKt.coerceIn(ParagraphKt.ceilToInt(nonNullIntrinsics.getMaxIntrinsicWidth()), minWidth, maxWidth);
            }
            MultiParagraph multiParagraph = new MultiParagraph(nonNullIntrinsics, ConstraintsKt.Constraints$default(0, width, 0, Constraints.m5173getMaxHeightimpl(textLayoutInput.getConstraints()), 5, null), finalMaxLines, TextOverflow.m5130equalsimpl0(textLayoutInput.getOverflow(), TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8()), null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m5185constrain4WqzIAM(textLayoutInput.getConstraints(), IntSizeKt.IntSize((int) Math.ceil(multiParagraph.getWidth()), (int) Math.ceil(multiParagraph.getHeight()))), null);
        }
    }
}
