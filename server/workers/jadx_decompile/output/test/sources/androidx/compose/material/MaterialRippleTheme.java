package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: MaterialTheme.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/material/MaterialRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class MaterialRippleTheme implements RippleTheme {
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    private MaterialRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    /* renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long mo1121defaultColorWaAFU9c(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(550536719);
        ComposerKt.sourceInformation($composer, "C(defaultColor)128@5172L7,129@5220L6:MaterialTheme.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(550536719, $changed, -1, "androidx.compose.material.MaterialRippleTheme.defaultColor (MaterialTheme.kt:127)");
        }
        RippleTheme.Companion companion = RippleTheme.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long m1288defaultRippleColor5vOe2sY = companion.m1288defaultRippleColor5vOe2sY(((Color) consume).m2959unboximpl(), MaterialTheme.INSTANCE.getColors($composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1288defaultRippleColor5vOe2sY;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public RippleAlpha rippleAlpha(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1419762518);
        ComposerKt.sourceInformation($composer, "C(rippleAlpha)134@5368L7,135@5412L6:MaterialTheme.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1419762518, $changed, -1, "androidx.compose.material.MaterialRippleTheme.rippleAlpha (MaterialTheme.kt:133)");
        }
        RippleTheme.Companion companion = RippleTheme.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        RippleAlpha m1287defaultRippleAlphaDxMtmZc = companion.m1287defaultRippleAlphaDxMtmZc(((Color) consume).m2959unboximpl(), MaterialTheme.INSTANCE.getColors($composer, 6).isLight());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1287defaultRippleAlphaDxMtmZc;
    }
}
