package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aé\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aÕ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    /* renamed from: Text--4IGK_g */
    public static final void m1258Text4IGK_g(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        Modifier.Companion modifier2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long lineHeight2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        int minLines2;
        Function1 onTextLayout;
        int $dirty1;
        TextStyle style2;
        int minLines3;
        long m4747getColor0d7_KjU;
        TextStyle m4757mergeZ1GrekI;
        int minLines4;
        TextStyle style3;
        TextDecoration textDecoration3;
        TextAlign textAlign3;
        int overflow3;
        boolean softWrap3;
        int maxLines3;
        FontStyle fontStyle3;
        Function1 onTextLayout2;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long letterSpacing3;
        long fontSize3;
        long lineHeight3;
        Modifier modifier3;
        long color3;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(1028090691);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)109@5711L7,128@6923L7,129@6977L7,138@7204L607:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(fontStyle) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(fontWeight) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(fontFamily) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        int $dirty3 = i & 1024;
        if ($dirty3 != 0) {
            $dirty12 |= 6;
            i2 = i12;
        } else if (($changed1 & 14) == 0) {
            i2 = i12;
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        } else {
            i2 = i12;
        }
        int i13 = i & 2048;
        if (i13 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        }
        int i14 = i & 4096;
        if (i14 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        }
        int i15 = i & 8192;
        if (i15 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changed(maxLines) ? 2048 : 1024;
        }
        int i16 = i & 16384;
        if (i16 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer2.changed(minLines) ? 16384 : 8192;
        }
        int i17 = i & 32768;
        if (i17 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed1 & 458752) == 0) {
            $dirty12 |= $composer2.changedInstance(function1) ? 131072 : 65536;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer2.changed(style)) {
                i3 = 1048576;
                $dirty12 |= i3;
            }
            i3 = 524288;
            $dirty12 |= i3;
        }
        if (($dirty2 & 1533916891) == 306783378 && (2995931 & $dirty12) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            fontSize3 = fontSize;
            fontStyle3 = fontStyle;
            fontWeight3 = fontWeight;
            fontFamily3 = fontFamily;
            letterSpacing3 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight3 = lineHeight;
            overflow3 = overflow;
            softWrap3 = softWrap;
            maxLines3 = maxLines;
            minLines4 = minLines;
            onTextLayout2 = function1;
            style3 = style;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i4 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i5 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                fontSize2 = i6 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i7 != 0 ? null : fontStyle;
                fontWeight2 = i8 != 0 ? null : fontWeight;
                fontFamily2 = i9 != 0 ? null : fontFamily;
                letterSpacing2 = i10 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                textDecoration2 = i11 != 0 ? null : textDecoration;
                textAlign2 = i2 != 0 ? null : textAlign;
                lineHeight2 = $dirty3 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                overflow2 = i13 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                softWrap2 = i14 != 0 ? true : softWrap;
                maxLines2 = i15 != 0 ? Integer.MAX_VALUE : maxLines;
                minLines2 = i16 != 0 ? 1 : minLines;
                onTextLayout = i17 != 0 ? null : function1;
                if ((i & 65536) != 0) {
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    int overflow4 = overflow2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty1 = $dirty12 & (-3670017);
                    style2 = (TextStyle) consume;
                    overflow2 = overflow4;
                } else {
                    $dirty1 = $dirty12;
                    style2 = style;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 65536) != 0) {
                    int i18 = (-3670017) & $dirty12;
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = i18;
                    overflow2 = overflow;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    onTextLayout = function1;
                    $dirty1 = $dirty12;
                    style2 = style;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                minLines3 = minLines2;
                ComposerKt.traceEventStart(1028090691, $dirty2, $dirty1, "androidx.compose.material.Text (Text.kt:92)");
            } else {
                minLines3 = minLines2;
            }
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long localContentColor2 = ((Color) consume2).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float localContentAlpha2 = ((Number) consume3).floatValue();
            long $this$isSpecified$iv = color2;
            if ($this$isSpecified$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                m4747getColor0d7_KjU = color2;
            } else {
                long $this$isSpecified$iv2 = style2.m4747getColor0d7_KjU();
                m4747getColor0d7_KjU = $this$isSpecified$iv2 != Color.INSTANCE.m2985getUnspecified0d7_KjU() ? style2.m4747getColor0d7_KjU() : Color.m2947copywmQWz5c(localContentColor2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(localContentColor2) : localContentAlpha2, (r12 & 2) != 0 ? Color.m2955getRedimpl(localContentColor2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(localContentColor2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(localContentColor2) : 0.0f);
            }
            final long overrideColorOrUnspecified = m4747getColor0d7_KjU;
            m4757mergeZ1GrekI = style2.m4757mergeZ1GrekI((r58 & 1) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize2, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? null : textAlign2, (r58 & 65536) != 0 ? null : null, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight2, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? null : null, (r58 & 2097152) != 0 ? null : null, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
            TextDecoration textDecoration4 = textDecoration2;
            TextAlign textAlign4 = textAlign2;
            ColorProducer colorProducer = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* renamed from: invoke-0d7_KjU, reason: not valid java name */
                public final long mo1261invoke0d7_KjU() {
                    return overrideColorOrUnspecified;
                }
            };
            TextStyle style4 = style2;
            BasicTextKt.m746BasicTextVhcvRP8(text, modifier2, m4757mergeZ1GrekI, (Function1<? super TextLayoutResult, Unit>) onTextLayout, overflow2, softWrap2, maxLines2, minLines3, colorProducer, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty1 >> 6) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (($dirty1 << 9) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minLines4 = minLines3;
            style3 = style4;
            textDecoration3 = textDecoration4;
            textAlign3 = textAlign4;
            overflow3 = overflow2;
            softWrap3 = softWrap2;
            maxLines3 = maxLines2;
            fontStyle3 = fontStyle2;
            onTextLayout2 = onTextLayout;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            letterSpacing3 = letterSpacing2;
            fontSize3 = fontSize2;
            lineHeight3 = lineHeight2;
            modifier3 = modifier2;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = color3;
        final long j2 = fontSize3;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration5 = textDecoration3;
        final TextAlign textAlign5 = textAlign3;
        final long j4 = lineHeight3;
        final int i19 = overflow3;
        final boolean z = softWrap3;
        final int i20 = maxLines3;
        final int i21 = minLines4;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i22) {
                TextKt.m1258Text4IGK_g(text, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign5, j4, i19, z, i20, i21, function12, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I */
    public static final /* synthetic */ void m1260TextfLXpl1I(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        TextDecoration textDecoration2;
        TextStyle style2;
        int overflow2;
        TextAlign textAlign2;
        boolean softWrap2;
        int maxLines2;
        Function1 onTextLayout2;
        long color2;
        long fontSize2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        long lineHeight2;
        Modifier modifier2;
        int $dirty1;
        FontStyle fontStyle2;
        Composer $composer2;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-366126944);
        ComposerKt.sourceInformation($composer3, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)181@8591L7,183@8607L322:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(color) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(fontSize) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(fontStyle) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(fontWeight) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(fontFamily) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(textAlign) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(lineHeight) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(softWrap) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer3.changed(maxLines) ? 2048 : 1024;
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty12 |= 24576;
            i2 = i17;
        } else if (($changed1 & 57344) == 0) {
            i2 = i17;
            $dirty12 |= $composer3.changedInstance(onTextLayout) ? 16384 : 8192;
        } else {
            i2 = i17;
        }
        if (($changed1 & 458752) == 0) {
            if ((i & 32768) == 0 && $composer3.changed(style)) {
                i3 = 131072;
                $dirty12 |= i3;
            }
            i3 = 65536;
            $dirty12 |= i3;
        }
        if (($dirty & 1533916891) == 306783378 && (374491 & $dirty12) == 74898 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            fontSize2 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            onTextLayout2 = onTextLayout;
            style2 = style;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                long color3 = i5 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                long fontSize3 = i6 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                FontStyle fontStyle3 = i7 != 0 ? null : fontStyle;
                FontWeight fontWeight3 = i8 != 0 ? null : fontWeight;
                FontFamily fontFamily3 = i9 != 0 ? null : fontFamily;
                long letterSpacing3 = i10 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration3 = i11 != 0 ? null : textDecoration;
                TextAlign textAlign3 = i12 != 0 ? null : textAlign;
                long lineHeight3 = i13 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                int overflow3 = i14 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                boolean softWrap3 = i15 != 0 ? true : softWrap;
                int maxLines3 = i16 != 0 ? Integer.MAX_VALUE : maxLines;
                TextKt$Text$3 onTextLayout3 = i2 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : onTextLayout;
                if ((i & 32768) != 0) {
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    TextDecoration textDecoration4 = textDecoration3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textDecoration2 = textDecoration4;
                    style2 = (TextStyle) consume;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12 & (-458753);
                    fontStyle2 = fontStyle3;
                } else {
                    textDecoration2 = textDecoration3;
                    style2 = style;
                    overflow2 = overflow3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    onTextLayout2 = onTextLayout3;
                    color2 = color3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    modifier2 = modifier3;
                    $dirty1 = $dirty12;
                    fontStyle2 = fontStyle3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32768) != 0) {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = (-458753) & $dirty12;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366126944, $dirty, $dirty1, "androidx.compose.material.Text (Text.kt:165)");
            }
            $composer2 = $composer3;
            m1258Text4IGK_g(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | 24576 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 458752) | (($dirty1 << 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final long j = color2;
        final long j2 = fontSize2;
        final FontStyle fontStyle4 = fontStyle2;
        final FontWeight fontWeight4 = fontWeight2;
        final FontFamily fontFamily4 = fontFamily2;
        final long j3 = letterSpacing2;
        final TextDecoration textDecoration5 = textDecoration2;
        final TextAlign textAlign4 = textAlign2;
        final long j4 = lineHeight2;
        final int i18 = overflow2;
        final boolean z = softWrap2;
        final int i19 = maxLines2;
        final Function1 function1 = onTextLayout2;
        final TextStyle textStyle = style2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i20) {
                TextKt.m1260TextfLXpl1I(text, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign4, j4, i18, z, i19, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* renamed from: Text-IbK3jfQ */
    public static final void m1259TextIbK3jfQ(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        Modifier.Companion modifier2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long lineHeight2;
        int overflow2;
        boolean softWrap2;
        int maxLines2;
        int minLines2;
        Map inlineContent;
        Function1 onTextLayout;
        int $dirty1;
        TextStyle style2;
        Map inlineContent2;
        final long overrideColorOrUnspecified;
        TextStyle m4757mergeZ1GrekI;
        Map inlineContent3;
        TextStyle style3;
        TextDecoration textDecoration3;
        int overflow3;
        TextAlign textAlign3;
        boolean softWrap3;
        int maxLines3;
        FontStyle fontStyle3;
        int minLines3;
        FontWeight fontWeight3;
        Function1 onTextLayout2;
        FontFamily fontFamily3;
        long color3;
        long letterSpacing3;
        long lineHeight3;
        Modifier modifier3;
        long lineHeight4;
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(744129681);
        ComposerKt.sourceInformation($composer2, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)277@13288L7,296@14500L7,297@14554L7,306@14774L646:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(color) ? 256 : 128;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(fontSize) ? 2048 : 1024;
        }
        int i8 = i & 16;
        if (i8 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(fontStyle) ? 16384 : 8192;
        }
        int i9 = i & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(fontWeight) ? 131072 : 65536;
        }
        int i10 = i & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(fontFamily) ? 1048576 : 524288;
        }
        int i11 = i & 128;
        if (i11 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i12 = i & 256;
        if (i12 != 0) {
            $dirty |= 100663296;
        } else if ((234881024 & $changed) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        int $dirty3 = i & 1024;
        if ($dirty3 != 0) {
            $dirty12 |= 6;
            i2 = i13;
        } else if (($changed1 & 14) == 0) {
            i2 = i13;
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        } else {
            i2 = i13;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changed(maxLines) ? 2048 : 1024;
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty12 |= $composer2.changed(minLines) ? 16384 : 8192;
        }
        int i18 = i & 32768;
        if (i18 != 0) {
            $dirty12 |= 65536;
        }
        int i19 = i & 65536;
        if (i19 != 0) {
            $dirty12 |= 1572864;
            i3 = i17;
        } else if (($changed1 & 3670016) == 0) {
            i3 = i17;
            $dirty12 |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        } else {
            i3 = i17;
        }
        if (($changed1 & 29360128) == 0) {
            if ((i & 131072) == 0 && $composer2.changed(style)) {
                i4 = 8388608;
                $dirty12 |= i4;
            }
            i4 = 4194304;
            $dirty12 |= i4;
        }
        if (i18 == 32768 && (1533916891 & $dirty2) == 306783378 && (23967451 & $dirty12) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            color3 = color;
            lineHeight4 = fontSize;
            fontStyle3 = fontStyle;
            fontWeight3 = fontWeight;
            fontFamily3 = fontFamily;
            letterSpacing3 = letterSpacing;
            textDecoration3 = textDecoration;
            textAlign3 = textAlign;
            lineHeight3 = lineHeight;
            overflow3 = overflow;
            softWrap3 = softWrap;
            maxLines3 = maxLines;
            minLines3 = minLines;
            inlineContent3 = map;
            onTextLayout2 = function1;
            style3 = style;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i5 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i6 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                fontSize2 = i7 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i8 != 0 ? null : fontStyle;
                fontWeight2 = i9 != 0 ? null : fontWeight;
                fontFamily2 = i10 != 0 ? null : fontFamily;
                letterSpacing2 = i11 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                textDecoration2 = i12 != 0 ? null : textDecoration;
                textAlign2 = i2 != 0 ? null : textAlign;
                lineHeight2 = $dirty3 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                overflow2 = i14 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                softWrap2 = i15 != 0 ? true : softWrap;
                maxLines2 = i16 != 0 ? Integer.MAX_VALUE : maxLines;
                minLines2 = i3 != 0 ? 1 : minLines;
                inlineContent = i18 != 0 ? MapsKt.emptyMap() : map;
                onTextLayout = i19 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : function1;
                if ((i & 131072) != 0) {
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    int overflow4 = overflow2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty1 = $dirty12 & (-29360129);
                    style2 = (TextStyle) consume;
                    overflow2 = overflow4;
                } else {
                    $dirty1 = $dirty12;
                    style2 = style;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 131072) != 0) {
                    int i20 = (-29360129) & $dirty12;
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    inlineContent = map;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = i20;
                    overflow2 = overflow;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    inlineContent = map;
                    onTextLayout = function1;
                    $dirty1 = $dirty12;
                    style2 = style;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                inlineContent2 = inlineContent;
                ComposerKt.traceEventStart(744129681, $dirty2, $dirty1, "androidx.compose.material.Text (Text.kt:259)");
            } else {
                inlineContent2 = inlineContent;
            }
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long localContentColor2 = ((Color) consume2).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float localContentAlpha2 = ((Number) consume3).floatValue();
            long $this$isSpecified$iv = color2;
            if ($this$isSpecified$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                overrideColorOrUnspecified = color2;
            } else {
                long $this$isSpecified$iv2 = style2.m4747getColor0d7_KjU();
                overrideColorOrUnspecified = $this$isSpecified$iv2 != Color.INSTANCE.m2985getUnspecified0d7_KjU() ? style2.m4747getColor0d7_KjU() : Color.m2947copywmQWz5c(localContentColor2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(localContentColor2) : localContentAlpha2, (r12 & 2) != 0 ? Color.m2955getRedimpl(localContentColor2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(localContentColor2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(localContentColor2) : 0.0f);
            }
            m4757mergeZ1GrekI = style2.m4757mergeZ1GrekI((r58 & 1) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize2, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? null : textAlign2, (r58 & 65536) != 0 ? null : null, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight2, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? null : null, (r58 & 2097152) != 0 ? null : null, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
            TextStyle style4 = style2;
            TextDecoration textDecoration4 = textDecoration2;
            BasicTextKt.m744BasicTextRWo7tUw(text, modifier2, m4757mergeZ1GrekI, onTextLayout, overflow2, softWrap2, maxLines2, minLines2, inlineContent2, new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$6
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* renamed from: invoke-0d7_KjU */
                public final long mo1261invoke0d7_KjU() {
                    return overrideColorOrUnspecified;
                }
            }, $composer2, ($dirty2 & 14) | 134217728 | ($dirty2 & 112) | (($dirty1 >> 9) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (($dirty1 << 9) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            inlineContent3 = inlineContent2;
            style3 = style4;
            textDecoration3 = textDecoration4;
            overflow3 = overflow2;
            textAlign3 = textAlign2;
            softWrap3 = softWrap2;
            maxLines3 = maxLines2;
            fontStyle3 = fontStyle2;
            minLines3 = minLines2;
            fontWeight3 = fontWeight2;
            onTextLayout2 = onTextLayout;
            fontFamily3 = fontFamily2;
            color3 = color2;
            letterSpacing3 = letterSpacing2;
            lineHeight3 = lineHeight2;
            modifier3 = modifier2;
            lineHeight4 = fontSize2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j = color3;
        final long j2 = lineHeight4;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration5 = textDecoration3;
        final TextAlign textAlign4 = textAlign3;
        final long j4 = lineHeight3;
        final int i21 = overflow3;
        final boolean z = softWrap3;
        final int i22 = maxLines3;
        final int i23 = minLines3;
        final Map map2 = inlineContent3;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i24) {
                TextKt.m1259TextIbK3jfQ(AnnotatedString.this, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign4, j4, i21, z, i22, i23, map2, function12, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g */
    public static final /* synthetic */ void m1257Text4IGK_g(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        TextDecoration textDecoration2;
        int overflow2;
        TextStyle style2;
        Modifier modifier2;
        TextAlign textAlign2;
        boolean softWrap2;
        int maxLines2;
        Map inlineContent2;
        long color2;
        FontStyle fontStyle2;
        Function1 onTextLayout2;
        long fontSize2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        long lineHeight2;
        int $dirty1;
        Composer $composer2;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-422393234);
        ComposerKt.sourceInformation($composer3, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)351@16270L7,353@16286L345:Text.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(color) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(fontSize) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changed(fontStyle) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changed(fontWeight) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changed(fontFamily) ? 1048576 : 524288;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changed(letterSpacing) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(textAlign) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer3.changed(lineHeight) ? 4 : 2;
        }
        int i14 = i & 2048;
        if (i14 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer3.changed(overflow) ? 32 : 16;
        }
        int i15 = i & 4096;
        if (i15 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer3.changed(softWrap) ? 256 : 128;
        }
        int i16 = i & 8192;
        if (i16 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer3.changed(maxLines) ? 2048 : 1024;
        }
        int i17 = i & 16384;
        if (i17 != 0) {
            $dirty12 |= 8192;
        }
        int i18 = i & 32768;
        if (i18 != 0) {
            $dirty12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i2 = i16;
        } else if (($changed1 & 458752) == 0) {
            i2 = i16;
            $dirty12 |= $composer3.changedInstance(onTextLayout) ? 131072 : 65536;
        } else {
            i2 = i16;
        }
        if (($changed1 & 3670016) == 0) {
            if ((i & 65536) == 0 && $composer3.changed(style)) {
                i3 = 1048576;
                $dirty12 |= i3;
            }
            i3 = 524288;
            $dirty12 |= i3;
        }
        if (i17 == 16384 && (1533916891 & $dirty) == 306783378 && (2995931 & $dirty12) == 599186 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            color2 = color;
            fontSize2 = fontSize;
            fontStyle2 = fontStyle;
            fontWeight2 = fontWeight;
            fontFamily2 = fontFamily;
            letterSpacing2 = letterSpacing;
            textDecoration2 = textDecoration;
            textAlign2 = textAlign;
            lineHeight2 = lineHeight;
            overflow2 = overflow;
            softWrap2 = softWrap;
            maxLines2 = maxLines;
            inlineContent2 = inlineContent;
            onTextLayout2 = onTextLayout;
            style2 = style;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                long color3 = i5 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                long fontSize3 = i6 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                FontStyle fontStyle3 = i7 != 0 ? null : fontStyle;
                FontWeight fontWeight3 = i8 != 0 ? null : fontWeight;
                FontFamily fontFamily3 = i9 != 0 ? null : fontFamily;
                long letterSpacing3 = i10 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration3 = i11 != 0 ? null : textDecoration;
                TextAlign textAlign3 = i12 != 0 ? null : textAlign;
                long lineHeight3 = i13 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                int overflow3 = i14 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                boolean softWrap3 = i15 != 0 ? true : softWrap;
                int maxLines3 = i2 != 0 ? Integer.MAX_VALUE : maxLines;
                Map inlineContent3 = i17 != 0 ? MapsKt.emptyMap() : inlineContent;
                TextKt$Text$8 onTextLayout3 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$8
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }
                } : onTextLayout;
                if ((i & 65536) != 0) {
                    TextDecoration textDecoration4 = textDecoration3;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    Modifier modifier4 = modifier3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textDecoration2 = textDecoration4;
                    overflow2 = overflow3;
                    modifier2 = modifier4;
                    style2 = (TextStyle) consume;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    inlineContent2 = inlineContent3;
                    color2 = color3;
                    fontStyle2 = fontStyle3;
                    onTextLayout2 = onTextLayout3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    $dirty1 = $dirty12 & (-3670017);
                } else {
                    textDecoration2 = textDecoration3;
                    overflow2 = overflow3;
                    style2 = style;
                    modifier2 = modifier3;
                    textAlign2 = textAlign3;
                    softWrap2 = softWrap3;
                    maxLines2 = maxLines3;
                    inlineContent2 = inlineContent3;
                    color2 = color3;
                    fontStyle2 = fontStyle3;
                    onTextLayout2 = onTextLayout3;
                    fontSize2 = fontSize3;
                    fontWeight2 = fontWeight3;
                    fontFamily2 = fontFamily3;
                    letterSpacing2 = letterSpacing3;
                    lineHeight2 = lineHeight3;
                    $dirty1 = $dirty12;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 65536) != 0) {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    inlineContent2 = inlineContent;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = (-3670017) & $dirty12;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textDecoration2 = textDecoration;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    inlineContent2 = inlineContent;
                    onTextLayout2 = onTextLayout;
                    style2 = style;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-422393234, $dirty, $dirty1, "androidx.compose.material.Text (Text.kt:334)");
            }
            $composer2 = $composer3;
            m1259TextIbK3jfQ(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, inlineContent2, onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128) | (234881024 & $dirty) | (1879048192 & $dirty), 286720 | ($dirty1 & 14) | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 3670016) | (($dirty1 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final long j = color2;
        final long j2 = fontSize2;
        final FontStyle fontStyle4 = fontStyle2;
        final FontWeight fontWeight4 = fontWeight2;
        final FontFamily fontFamily4 = fontFamily2;
        final long j3 = letterSpacing2;
        final TextDecoration textDecoration5 = textDecoration2;
        final TextAlign textAlign4 = textAlign2;
        final long j4 = lineHeight2;
        final int i19 = overflow2;
        final boolean z = softWrap2;
        final int i20 = maxLines2;
        final Map map = inlineContent2;
        final Function1 function1 = onTextLayout2;
        final TextStyle textStyle = style2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$9
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i21) {
                TextKt.m1257Text4IGK_g(AnnotatedString.this, modifier5, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign4, j4, i19, z, i20, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)394@17586L7,395@17611L80:Text.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, $dirty, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle mergedStyle = ((TextStyle) consume).merge(value);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalTextStyle.provides(mergedStyle)}, content, $composer2, ($dirty & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                TextKt.ProvideTextStyle(TextStyle.this, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
