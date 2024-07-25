package androidx.compose.material;

import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialTextSelectionColors.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final SelectionColors rememberTextSelectionColors(Colors colors, Composer $composer, int $changed) {
        long m2959unboximpl;
        long textColorWithLowestAlpha;
        Intrinsics.checkNotNullParameter(colors, "colors");
        $composer.startReplaceableGroup(-721696685);
        ComposerKt.sourceInformation($composer, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, $changed, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long primaryColor = colors.m1036getPrimary0d7_KjU();
        long backgroundColor = colors.m1029getBackground0d7_KjU();
        $composer.startReplaceableGroup(35572910);
        ComposerKt.sourceInformation($composer, "*43@1845L7");
        long $this$takeOrElse_u2dDxMtmZc$iv = ColorsKt.m1053contentColorFor4WTKRHQ(colors, backgroundColor);
        if ($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
            m2959unboximpl = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            m2959unboximpl = ((Color) consume).m2959unboximpl();
        }
        $composer.endReplaceableGroup();
        textColorWithLowestAlpha = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
        Object key1$iv = Color.m2939boximpl(primaryColor);
        Object key2$iv = Color.m2939boximpl(backgroundColor);
        Object key3$iv = Color.m2939boximpl(textColorWithLowestAlpha);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv) | $composer.changed(key2$iv) | $composer.changed(key3$iv);
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new SelectionColors(colors.m1036getPrimary0d7_KjU(), m1125calculateSelectionBackgroundColorysEtTa8(primaryColor, textColorWithLowestAlpha, backgroundColor), null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        SelectionColors selectionColors = (SelectionColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectionColors;
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1125calculateSelectionBackgroundColorysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float alpha;
        long m2947copywmQWz5c;
        float maximumContrastRatio = m1124calculateContrastRationb2GgbA(selectionColor, 0.4f, textColor, backgroundColor);
        float minimumContrastRatio = m1124calculateContrastRationb2GgbA(selectionColor, 0.2f, textColor, backgroundColor);
        if (maximumContrastRatio >= DesiredContrastRatio) {
            alpha = 0.4f;
        } else {
            alpha = minimumContrastRatio < DesiredContrastRatio ? 0.2f : m1122binarySearchForAccessibleSelectionColorAlphaysEtTa8(selectionColor, textColor, backgroundColor);
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c(selectionColor, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(selectionColor) : alpha, (r12 & 2) != 0 ? Color.m2955getRedimpl(selectionColor) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(selectionColor) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectionColor) : 0.0f);
        return m2947copywmQWz5c;
    }

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1122binarySearchForAccessibleSelectionColorAlphaysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float lowAlpha = 0.2f;
        float alpha = 0.4f;
        float highAlpha = 0.4f;
        for (int attempts = 0; attempts < 7; attempts++) {
            float contrastRatio = m1124calculateContrastRationb2GgbA(selectionColor, alpha, textColor, backgroundColor);
            float percentageError = (contrastRatio / DesiredContrastRatio) - 1.0f;
            boolean z = false;
            if (0.0f <= percentageError && percentageError <= 0.01f) {
                z = true;
            }
            if (z) {
                break;
            }
            if (percentageError < 0.0f) {
                highAlpha = alpha;
            } else {
                lowAlpha = alpha;
            }
            alpha = (highAlpha + lowAlpha) / 2.0f;
        }
        return alpha;
    }

    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1124calculateContrastRationb2GgbA(long selectionColor, float selectionColorAlpha, long textColor, long backgroundColor) {
        long m2947copywmQWz5c;
        m2947copywmQWz5c = Color.m2947copywmQWz5c(selectionColor, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(selectionColor) : selectionColorAlpha, (r12 & 2) != 0 ? Color.m2955getRedimpl(selectionColor) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(selectionColor) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectionColor) : 0.0f);
        long compositeBackground = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c, backgroundColor);
        long compositeTextColor = ColorKt.m2994compositeOverOWjLjI(textColor, compositeBackground);
        return m1123calculateContrastRatioOWjLjI(compositeTextColor, compositeBackground);
    }

    /* renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1123calculateContrastRatioOWjLjI(long foreground, long background) {
        float foregroundLuminance = ColorKt.m3001luminance8_81llA(foreground) + 0.05f;
        float backgroundLuminance = ColorKt.m3001luminance8_81llA(background) + 0.05f;
        return Math.max(foregroundLuminance, backgroundLuminance) / Math.min(foregroundLuminance, backgroundLuminance);
    }
}
