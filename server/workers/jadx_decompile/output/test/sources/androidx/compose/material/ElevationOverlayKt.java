package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ElevationOverlay.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"LocalAbsoluteElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalElevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ElevationOverlayKt {
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0<ElevationOverlay>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalElevationOverlay$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ElevationOverlay invoke() {
            return DefaultElevationOverlay.INSTANCE;
        }
    });
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Dp>() { // from class: androidx.compose.material.ElevationOverlayKt$LocalAbsoluteElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Dp invoke() {
            return Dp.m5216boximpl(m1096invokeD9Ej5fM());
        }

        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m1096invokeD9Ej5fM() {
            return Dp.m5218constructorimpl(0);
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateForegroundColor-CLU3JFs, reason: not valid java name */
    public static final long m1095calculateForegroundColorCLU3JFs(long backgroundColor, float elevation, Composer $composer, int $changed) {
        long m2947copywmQWz5c;
        ComposerKt.sourceInformationMarkerStart($composer, 1613340891, "C(calculateForegroundColor)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)88@3446L32:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613340891, $changed, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)");
        }
        float alpha = ((((float) Math.log(elevation + 1)) * 4.5f) + 2.0f) / 100.0f;
        long baseForegroundColor = ColorsKt.m1054contentColorForek8zF_U(backgroundColor, $composer, $changed & 14);
        m2947copywmQWz5c = Color.m2947copywmQWz5c(baseForegroundColor, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(baseForegroundColor) : alpha, (r12 & 2) != 0 ? Color.m2955getRedimpl(baseForegroundColor) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(baseForegroundColor) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(baseForegroundColor) : 0.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return m2947copywmQWz5c;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }
}
