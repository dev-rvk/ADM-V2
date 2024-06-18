package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraphIntrinsics.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001fR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "hasStaleResolvedFonts", "", "getHasStaleResolvedFonts", "()Z", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text_release", "()Ljava/util/List;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "Lkotlin/Lazy;", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "getPlaceholders", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    public static final int $stable = 8;
    private final AnnotatedString annotatedString;
    private final List<ParagraphIntrinsicInfo> infoList;

    /* renamed from: maxIntrinsicWidth$delegate, reason: from kotlin metadata */
    private final Lazy maxIntrinsicWidth;

    /* renamed from: minIntrinsicWidth$delegate, reason: from kotlin metadata */
    private final Lazy minIntrinsicWidth;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        List localPlaceholders;
        TextStyle style2 = style;
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style2, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.annotatedString = annotatedString;
        this.placeholders = placeholders;
        this.minIntrinsicWidth = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object maxElem$iv;
                ParagraphIntrinsics intrinsics;
                List $this$fastMaxBy$iv = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if ($this$fastMaxBy$iv.isEmpty()) {
                    maxElem$iv = null;
                } else {
                    maxElem$iv = $this$fastMaxBy$iv.get(0);
                    ParagraphIntrinsicInfo it = (ParagraphIntrinsicInfo) maxElem$iv;
                    float maxValue$iv = it.getIntrinsics().getMinIntrinsicWidth();
                    int i$iv = 1;
                    int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                    if (1 <= lastIndex) {
                        while (true) {
                            Object e$iv = $this$fastMaxBy$iv.get(i$iv);
                            ParagraphIntrinsicInfo it2 = (ParagraphIntrinsicInfo) e$iv;
                            float v$iv = it2.getIntrinsics().getMinIntrinsicWidth();
                            if (Float.compare(maxValue$iv, v$iv) < 0) {
                                maxElem$iv = e$iv;
                                maxValue$iv = v$iv;
                            }
                            if (i$iv == lastIndex) {
                                break;
                            }
                            i$iv++;
                        }
                    }
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) maxElem$iv;
                return Float.valueOf((paragraphIntrinsicInfo == null || (intrinsics = paragraphIntrinsicInfo.getIntrinsics()) == null) ? 0.0f : intrinsics.getMinIntrinsicWidth());
            }
        });
        this.maxIntrinsicWidth = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object maxElem$iv;
                ParagraphIntrinsics intrinsics;
                List $this$fastMaxBy$iv = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if ($this$fastMaxBy$iv.isEmpty()) {
                    maxElem$iv = null;
                } else {
                    maxElem$iv = $this$fastMaxBy$iv.get(0);
                    ParagraphIntrinsicInfo it = (ParagraphIntrinsicInfo) maxElem$iv;
                    float maxValue$iv = it.getIntrinsics().getMaxIntrinsicWidth();
                    int i$iv = 1;
                    int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
                    if (1 <= lastIndex) {
                        while (true) {
                            Object e$iv = $this$fastMaxBy$iv.get(i$iv);
                            ParagraphIntrinsicInfo it2 = (ParagraphIntrinsicInfo) e$iv;
                            float v$iv = it2.getIntrinsics().getMaxIntrinsicWidth();
                            if (Float.compare(maxValue$iv, v$iv) < 0) {
                                maxElem$iv = e$iv;
                                maxValue$iv = v$iv;
                            }
                            if (i$iv == lastIndex) {
                                break;
                            }
                            i$iv++;
                        }
                    }
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) maxElem$iv;
                return Float.valueOf((paragraphIntrinsicInfo == null || (intrinsics = paragraphIntrinsicInfo.getIntrinsics()) == null) ? 0.0f : intrinsics.getMaxIntrinsicWidth());
            }
        });
        ParagraphStyle paragraphStyle = style.toParagraphStyle();
        AnnotatedString $this$mapEachParagraphStyle$iv = this.annotatedString;
        List $this$fastMap$iv$iv = AnnotatedStringKt.normalizedParagraphStyles($this$mapEachParagraphStyle$iv, paragraphStyle);
        ArrayList target$iv$iv = new ArrayList($this$fastMap$iv$iv.size());
        List $this$fastForEach$iv$iv$iv = $this$fastMap$iv$iv;
        int size = $this$fastForEach$iv$iv$iv.size();
        int index$iv$iv$iv = 0;
        while (index$iv$iv$iv < size) {
            Object item$iv$iv$iv = $this$fastForEach$iv$iv$iv.get(index$iv$iv$iv);
            AnnotatedString.Range paragraphStyleRange$iv = (AnnotatedString.Range) item$iv$iv$iv;
            AnnotatedString annotatedString$iv = AnnotatedStringKt.substringWithoutParagraphStyles($this$mapEachParagraphStyle$iv, paragraphStyleRange$iv.getStart(), paragraphStyleRange$iv.getEnd());
            ParagraphStyle currentParagraphStyle = resolveTextDirection(paragraphStyleRange$iv.getItem(), paragraphStyle);
            String text = annotatedString$iv.getText();
            TextStyle merge = style2.merge(currentParagraphStyle);
            List $this$fastForEach$iv$iv$iv2 = annotatedString$iv.getSpanStyles();
            localPlaceholders = MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), paragraphStyleRange$iv.getStart(), paragraphStyleRange$iv.getEnd());
            target$iv$iv.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(text, merge, (List<AnnotatedString.Range<SpanStyle>>) $this$fastForEach$iv$iv$iv2, (List<AnnotatedString.Range<Placeholder>>) localPlaceholders, density, fontFamilyResolver), paragraphStyleRange$iv.getStart(), paragraphStyleRange$iv.getEnd()));
            index$iv$iv$iv++;
            style2 = style;
            size = size;
            $this$fastForEach$iv$iv$iv = $this$fastForEach$iv$iv$iv;
        }
        this.infoList = target$iv$iv;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Font.ResourceLoader is deprecated, call with fontFamilyResolver", replaceWith = @ReplaceWith(expression = "MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver)", imports = {}))
    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, Density density, Font.ResourceLoader resourceLoader) {
        this(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth.getValue()).floatValue();
    }

    public final List<ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        List $this$fastAny$iv = this.infoList;
        int size = $this$fastAny$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
            ParagraphIntrinsicInfo it = (ParagraphIntrinsicInfo) item$iv$iv;
            if (it.getIntrinsics().getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle style, ParagraphStyle defaultStyle) {
        ParagraphStyle m4633copyNH1kkwU;
        TextDirection textDirection = style.getTextDirection();
        if (textDirection != null) {
            textDirection.getValue();
            if (style != null) {
                return style;
            }
        }
        m4633copyNH1kkwU = style.m4633copyNH1kkwU((r22 & 1) != 0 ? style.textAlign : null, (r22 & 2) != 0 ? style.textDirection : defaultStyle.getTextDirection(), (r22 & 4) != 0 ? style.lineHeight : 0L, (r22 & 8) != 0 ? style.textIndent : null, (r22 & 16) != 0 ? style.platformStyle : null, (r22 & 32) != 0 ? style.lineHeightStyle : null, (r22 & 64) != 0 ? style.lineBreak : null, (r22 & 128) != 0 ? style.hyphens : null, (r22 & 256) != 0 ? style.textMotion : null);
        return m4633copyNH1kkwU;
    }
}
