package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material3.tokens.TypographyTokensKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aé\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aÓ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material3.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    /* renamed from: Text--4IGK_g, reason: not valid java name */
    public static final void m1872Text4IGK_g(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextAlign textAlign2;
        long lineHeight2;
        boolean softWrap2;
        int maxLines2;
        int minLines2;
        Function1 onTextLayout;
        int overflow2;
        TextStyle style2;
        Modifier modifier2;
        int $dirty1;
        TextDecoration textDecoration2;
        int minLines3;
        long color3;
        long textColor;
        int minLines4;
        Modifier modifier3;
        TextDecoration textDecoration3;
        int overflow3;
        TextStyle style3;
        TextAlign textAlign3;
        boolean softWrap3;
        int maxLines3;
        FontStyle fontStyle3;
        Function1 onTextLayout2;
        long fontSize3;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        long letterSpacing3;
        long lineHeight3;
        long lineHeight4;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(-2055108902);
        ComposerKt.sourceInformation($composer2, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12)108@5583L7,131@6301L162:Text.kt#uh7d8r");
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
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i12 = i & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int i13 = i & 1024;
        if (i13 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
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
            i2 = i17;
        } else if (($changed1 & 57344) == 0) {
            i2 = i17;
            $dirty12 |= $composer2.changed(minLines) ? 16384 : 8192;
        } else {
            i2 = i17;
        }
        int i18 = i & 32768;
        if (i18 != 0) {
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
        if (($dirty & 1533916891) == 306783378 && (2995931 & $dirty12) == 599186 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            lineHeight4 = color;
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
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i5 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                fontSize2 = i6 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i7 != 0 ? null : fontStyle;
                fontWeight2 = i8 != 0 ? null : fontWeight;
                fontFamily2 = i9 != 0 ? null : fontFamily;
                letterSpacing2 = i10 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration4 = i11 != 0 ? null : textDecoration;
                textAlign2 = i12 != 0 ? null : textAlign;
                lineHeight2 = i13 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                int overflow4 = i14 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                softWrap2 = i15 != 0 ? true : softWrap;
                maxLines2 = i16 != 0 ? Integer.MAX_VALUE : maxLines;
                minLines2 = i2 != 0 ? 1 : minLines;
                onTextLayout = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
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
                if ((i & 65536) != 0) {
                    TextDecoration textDecoration5 = textDecoration4;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    Modifier modifier5 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextStyle style4 = (TextStyle) consume;
                    overflow2 = overflow4;
                    style2 = style4;
                    $dirty1 = $dirty12 & (-3670017);
                    textDecoration2 = textDecoration5;
                    modifier2 = modifier5;
                } else {
                    TextDecoration textDecoration6 = textDecoration4;
                    Modifier modifier6 = modifier4;
                    overflow2 = overflow4;
                    style2 = style;
                    modifier2 = modifier6;
                    $dirty1 = $dirty12;
                    textDecoration2 = textDecoration6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 65536) != 0) {
                    int i19 = (-3670017) & $dirty12;
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
                    style2 = style;
                    $dirty1 = i19;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = $dirty12;
                    textDecoration2 = textDecoration;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                minLines3 = minLines2;
                ComposerKt.traceEventStart(-2055108902, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:91)");
            } else {
                minLines3 = minLines2;
            }
            $composer2.startReplaceableGroup(79582822);
            ComposerKt.sourceInformation($composer2, "*113@5698L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color2;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                color3 = color2;
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style2.m4747getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                    color3 = color2;
                } else {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    color3 = color2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = ((Color) consume2).m2959unboximpl();
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            TextStyle mergedStyle = style2.merge(new TextStyle(textColor, fontSize2, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, letterSpacing2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, lineHeight2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4108112, (DefaultConstructorMarker) null));
            BasicTextKt.m742BasicText4YKlhWE(text, modifier2, mergedStyle, onTextLayout, overflow2, softWrap2, maxLines2, minLines3, $composer2, ($dirty & 14) | ($dirty & 112) | (($dirty1 >> 6) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (29360128 & ($dirty1 << 9)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            minLines4 = minLines3;
            modifier3 = modifier2;
            textDecoration3 = textDecoration2;
            overflow3 = overflow2;
            style3 = style2;
            textAlign3 = textAlign2;
            softWrap3 = softWrap2;
            maxLines3 = maxLines2;
            fontStyle3 = fontStyle2;
            onTextLayout2 = onTextLayout;
            fontSize3 = fontSize2;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            letterSpacing3 = letterSpacing2;
            lineHeight3 = lineHeight2;
            lineHeight4 = color3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier3;
        final long j = lineHeight4;
        final long j2 = fontSize3;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration7 = textDecoration3;
        final TextAlign textAlign4 = textAlign3;
        final long j4 = lineHeight3;
        final int i20 = overflow3;
        final boolean z = softWrap3;
        final int i21 = maxLines3;
        final int i22 = minLines4;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$2
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

            public final void invoke(Composer composer, int i23) {
                TextKt.m1872Text4IGK_g(text, modifier7, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration7, textAlign4, j4, i20, z, i21, i22, function12, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    public static final /* synthetic */ void m1874TextfLXpl1I(final String text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(1968784669);
        ComposerKt.sourceInformation($composer3, "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)164@7243L7,166@7259L322:Text.kt#uh7d8r");
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
                TextKt$Text$3 onTextLayout3 = i2 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$3
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
                ComposerKt.traceEventStart(1968784669, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:148)");
            }
            $composer2 = $composer3;
            m1872Text4IGK_g(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | ($dirty & 3670016) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), ($dirty1 & 14) | 24576 | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 458752) | (($dirty1 << 3) & 3670016), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$4
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
                TextKt.m1874TextfLXpl1I(text, modifier4, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign4, j4, i18, z, i19, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    public static final void m1873TextIbK3jfQ(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, int minLines, Map<String, InlineTextContent> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
        int i2;
        int i3;
        long color2;
        long fontSize2;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long letterSpacing2;
        TextAlign textAlign2;
        long lineHeight2;
        boolean softWrap2;
        int maxLines2;
        int minLines2;
        Map inlineContent;
        Function1 onTextLayout;
        int overflow2;
        TextStyle style2;
        Modifier modifier2;
        int $dirty1;
        TextDecoration textDecoration2;
        Map inlineContent2;
        int minLines3;
        long textColor;
        Map inlineContent3;
        int minLines4;
        TextDecoration textDecoration3;
        int overflow3;
        TextStyle style3;
        TextAlign textAlign3;
        boolean softWrap3;
        int maxLines3;
        FontWeight fontWeight3;
        FontFamily fontFamily3;
        Function1 onTextLayout2;
        long letterSpacing3;
        long lineHeight3;
        Modifier modifier3;
        FontStyle fontStyle3;
        long color3;
        long fontSize3;
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer2 = $composer.startRestartGroup(2027001676);
        ComposerKt.sourceInformation($composer2, "C(Text)P(15,10,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,17,16:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,12:c#ui.text.style.TextOverflow,13,8,9)258@11733L7,280@12450L286:Text.kt#uh7d8r");
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
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(textDecoration) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i & 512;
        if (i13 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer2.changed(textAlign) ? 536870912 : 268435456;
        }
        int i14 = i & 1024;
        if (i14 != 0) {
            $dirty12 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty12 |= $composer2.changed(lineHeight) ? 4 : 2;
        }
        int i15 = i & 2048;
        if (i15 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty12 |= $composer2.changed(overflow) ? 32 : 16;
        }
        int i16 = i & 4096;
        if (i16 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty12 |= $composer2.changed(softWrap) ? 256 : 128;
        }
        int i17 = i & 8192;
        if (i17 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changed(maxLines) ? 2048 : 1024;
        }
        int i18 = i & 16384;
        if (i18 != 0) {
            $dirty12 |= 24576;
            i2 = i18;
        } else if (($changed1 & 57344) == 0) {
            i2 = i18;
            $dirty12 |= $composer2.changed(minLines) ? 16384 : 8192;
        } else {
            i2 = i18;
        }
        int i19 = i & 32768;
        if (i19 != 0) {
            $dirty12 |= 65536;
        }
        int i20 = i & 65536;
        if (i20 != 0) {
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
        if (i19 == 32768 && (1533916891 & $dirty) == 306783378 && (23967451 & $dirty12) == 4793490 && $composer2.getSkipping()) {
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
            inlineContent3 = map;
            onTextLayout2 = function1;
            style3 = style;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i5 != 0 ? Modifier.INSTANCE : modifier;
                color2 = i6 != 0 ? Color.INSTANCE.m2985getUnspecified0d7_KjU() : color;
                fontSize2 = i7 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : fontSize;
                fontStyle2 = i8 != 0 ? null : fontStyle;
                fontWeight2 = i9 != 0 ? null : fontWeight;
                fontFamily2 = i10 != 0 ? null : fontFamily;
                letterSpacing2 = i11 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : letterSpacing;
                TextDecoration textDecoration4 = i12 != 0 ? null : textDecoration;
                textAlign2 = i13 != 0 ? null : textAlign;
                lineHeight2 = i14 != 0 ? TextUnit.INSTANCE.m5410getUnspecifiedXSAIIZE() : lineHeight;
                int overflow4 = i15 != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : overflow;
                softWrap2 = i16 != 0 ? true : softWrap;
                maxLines2 = i3 != 0 ? Integer.MAX_VALUE : maxLines;
                minLines2 = i2 != 0 ? 1 : minLines;
                inlineContent = i19 != 0 ? MapsKt.emptyMap() : map;
                onTextLayout = i20 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$5
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
                    TextDecoration textDecoration5 = textDecoration4;
                    ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
                    Modifier modifier5 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextStyle style4 = (TextStyle) consume;
                    overflow2 = overflow4;
                    style2 = style4;
                    $dirty1 = $dirty12 & (-29360129);
                    textDecoration2 = textDecoration5;
                    modifier2 = modifier5;
                } else {
                    TextDecoration textDecoration6 = textDecoration4;
                    Modifier modifier6 = modifier4;
                    overflow2 = overflow4;
                    style2 = style;
                    modifier2 = modifier6;
                    $dirty1 = $dirty12;
                    textDecoration2 = textDecoration6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 131072) != 0) {
                    int i21 = (-29360129) & $dirty12;
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
                    style2 = style;
                    $dirty1 = i21;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    color2 = color;
                    fontSize2 = fontSize;
                    fontStyle2 = fontStyle;
                    fontWeight2 = fontWeight;
                    fontFamily2 = fontFamily;
                    letterSpacing2 = letterSpacing;
                    textAlign2 = textAlign;
                    lineHeight2 = lineHeight;
                    overflow2 = overflow;
                    softWrap2 = softWrap;
                    maxLines2 = maxLines;
                    minLines2 = minLines;
                    inlineContent = map;
                    onTextLayout = function1;
                    style2 = style;
                    $dirty1 = $dirty12;
                    textDecoration2 = textDecoration;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                inlineContent2 = inlineContent;
                ComposerKt.traceEventStart(2027001676, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:240)");
            } else {
                inlineContent2 = inlineContent;
            }
            $composer2.startReplaceableGroup(79588971);
            ComposerKt.sourceInformation($composer2, "*262@11847L7");
            long $this$takeOrElse_u2dDxMtmZc$iv = color2;
            if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                minLines3 = minLines2;
                textColor = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = style2.m4747getColor0d7_KjU();
                if ($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                    minLines3 = minLines2;
                } else {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    minLines3 = minLines2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $this$takeOrElse_u2dDxMtmZc$iv2 = ((Color) consume2).m2959unboximpl();
                }
                textColor = $this$takeOrElse_u2dDxMtmZc$iv2;
            }
            $composer2.endReplaceableGroup();
            TextStyle mergedStyle = style2.merge(new TextStyle(textColor, fontSize2, fontWeight2, fontStyle2, (FontSynthesis) null, fontFamily2, (String) null, letterSpacing2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, textDecoration2, (Shadow) null, textAlign2, (TextDirection) null, lineHeight2, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 4108112, (DefaultConstructorMarker) null));
            BasicTextKt.m745BasicTextVhcvRP8(text, modifier2, mergedStyle, onTextLayout, overflow2, softWrap2, maxLines2, minLines3, inlineContent2, $composer2, 134217728 | ($dirty & 14) | ($dirty & 112) | (($dirty1 >> 9) & 7168) | (($dirty1 << 9) & 57344) | (($dirty1 << 9) & 458752) | (($dirty1 << 9) & 3670016) | (($dirty1 << 9) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            inlineContent3 = inlineContent2;
            minLines4 = minLines3;
            textDecoration3 = textDecoration2;
            overflow3 = overflow2;
            style3 = style2;
            textAlign3 = textAlign2;
            softWrap3 = softWrap2;
            maxLines3 = maxLines2;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            onTextLayout2 = onTextLayout;
            letterSpacing3 = letterSpacing2;
            lineHeight3 = lineHeight2;
            modifier3 = modifier2;
            fontStyle3 = fontStyle2;
            color3 = color2;
            fontSize3 = fontSize2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier3;
        final long j = color3;
        final long j2 = fontSize3;
        final FontStyle fontStyle4 = fontStyle3;
        final FontWeight fontWeight4 = fontWeight3;
        final FontFamily fontFamily4 = fontFamily3;
        final long j3 = letterSpacing3;
        final TextDecoration textDecoration7 = textDecoration3;
        final TextAlign textAlign4 = textAlign3;
        final long j4 = lineHeight3;
        final int i22 = overflow3;
        final boolean z = softWrap3;
        final int i23 = maxLines3;
        final int i24 = minLines4;
        final Map map2 = inlineContent3;
        final Function1 function12 = onTextLayout2;
        final TextStyle textStyle = style3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$6
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

            public final void invoke(Composer composer, int i25) {
                TextKt.m1873TextIbK3jfQ(AnnotatedString.this, modifier7, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration7, textAlign4, j4, i22, z, i23, i24, map2, function12, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    public static final /* synthetic */ void m1871Text4IGK_g(final AnnotatedString text, Modifier modifier, long color, long fontSize, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long letterSpacing, TextDecoration textDecoration, TextAlign textAlign, long lineHeight, int overflow, boolean softWrap, int maxLines, Map inlineContent, Function1 onTextLayout, TextStyle style, Composer $composer, final int $changed, final int $changed1, final int i) {
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
        Composer $composer3 = $composer.startRestartGroup(224529679);
        ComposerKt.sourceInformation($composer3, "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)315@13586L7,317@13602L345:Text.kt#uh7d8r");
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
                TextKt$Text$7 onTextLayout3 = i18 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$7
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
                ComposerKt.traceEventStart(224529679, $dirty, $dirty1, "androidx.compose.material3.Text (Text.kt:298)");
            }
            $composer2 = $composer3;
            m1873TextIbK3jfQ(text, modifier2, color2, fontSize2, fontStyle2, fontWeight2, fontFamily2, letterSpacing2, textDecoration2, textAlign2, lineHeight2, overflow2, softWrap2, maxLines2, 1, inlineContent2, onTextLayout2, style2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128) | (234881024 & $dirty) | (1879048192 & $dirty), 286720 | ($dirty1 & 14) | ($dirty1 & 112) | ($dirty1 & 896) | ($dirty1 & 7168) | (($dirty1 << 3) & 3670016) | (($dirty1 << 3) & 29360128), 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$8
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
                TextKt.m1871Text4IGK_g(AnnotatedString.this, modifier5, j, j2, fontStyle4, fontWeight4, fontFamily4, j3, textDecoration5, textAlign4, j4, i19, z, i20, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle value, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-460300127);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyle)P(1)358@14903L7,359@14928L80:Text.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(value) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460300127, $dirty, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:357)");
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$ProvideTextStyle$1
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
