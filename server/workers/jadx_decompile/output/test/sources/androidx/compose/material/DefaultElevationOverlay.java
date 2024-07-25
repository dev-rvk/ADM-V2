package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ElevationOverlay.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo1070apply7g2Lkgo(long color, float elevation, Composer $composer, int $changed) {
        long foregroundColor;
        long foregroundColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1687113661, "C(apply)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)69@2742L6,71@2841L42:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, $changed, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors($composer, 6);
        int $this$dp$iv = Dp.m5217compareTo0680j_4(elevation, Dp.m5218constructorimpl(0));
        if ($this$dp$iv > 0 && !colors.isLight()) {
            foregroundColor2 = ElevationOverlayKt.m1095calculateForegroundColorCLU3JFs(color, elevation, $composer, ($changed & 14) | ($changed & 112));
            foregroundColor = ColorKt.m2994compositeOverOWjLjI(foregroundColor2, color);
        } else {
            foregroundColor = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return foregroundColor;
    }
}
