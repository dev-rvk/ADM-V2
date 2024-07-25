package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: BackdropScaffold.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\f\u001a\u00020\r8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/material/BackdropScaffoldDefaults;", "", "()V", "FrontLayerElevation", "Landroidx/compose/ui/unit/Dp;", "getFrontLayerElevation-D9Ej5fM", "()F", "F", "HeaderHeight", "getHeaderHeight-D9Ej5fM", "PeekHeight", "getPeekHeight-D9Ej5fM", "frontLayerScrimColor", "Landroidx/compose/ui/graphics/Color;", "getFrontLayerScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "getFrontLayerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BackdropScaffoldDefaults {
    public static final int $stable = 0;
    public static final BackdropScaffoldDefaults INSTANCE = new BackdropScaffoldDefaults();
    private static final float PeekHeight = Dp.m5218constructorimpl(56);
    private static final float HeaderHeight = Dp.m5218constructorimpl(48);
    private static final float FrontLayerElevation = Dp.m5218constructorimpl(1);

    private BackdropScaffoldDefaults() {
    }

    /* renamed from: getPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m972getPeekHeightD9Ej5fM() {
        return PeekHeight;
    }

    /* renamed from: getHeaderHeight-D9Ej5fM, reason: not valid java name */
    public final float m971getHeaderHeightD9Ej5fM() {
        return HeaderHeight;
    }

    public final Shape getFrontLayerShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1580588700);
        ComposerKt.sourceInformation($composer, "C505@20342L6:BackdropScaffold.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1580588700, $changed, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerShape> (BackdropScaffold.kt:505)");
        }
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getLarge(), CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl(16)), CornerSizeKt.m729CornerSize0680j_4(Dp.m5218constructorimpl(16)), null, null, 12, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return copy$default;
    }

    /* renamed from: getFrontLayerElevation-D9Ej5fM, reason: not valid java name */
    public final float m970getFrontLayerElevationD9Ej5fM() {
        return FrontLayerElevation;
    }

    public final long getFrontLayerScrimColor(Composer $composer, int $changed) {
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(1806270648);
        ComposerKt.sourceInformation($composer, "C517@20693L6:BackdropScaffold.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1806270648, $changed, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerScrimColor> (BackdropScaffold.kt:517)");
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r1, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r1) : 0.6f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r1) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r1) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU()) : 0.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m2947copywmQWz5c;
    }
}
