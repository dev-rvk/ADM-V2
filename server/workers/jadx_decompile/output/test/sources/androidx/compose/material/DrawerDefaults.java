package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/DrawerDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimOpacity", "", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawerDefaults {
    public static final int $stable = 0;
    public static final float ScrimOpacity = 0.32f;
    public static final DrawerDefaults INSTANCE = new DrawerDefaults();
    private static final float Elevation = Dp.m5218constructorimpl(16);

    private DrawerDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1076getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(617225966);
        ComposerKt.sourceInformation($composer, "C787@29568L6:Drawer.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(617225966, $changed, -1, "androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:787)");
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r1, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r1) : 0.32f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r1) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r1) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m2947copywmQWz5c;
    }
}
