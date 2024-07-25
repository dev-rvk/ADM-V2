package androidx.compose.material3;

import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\u001e\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J=\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010 R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "extendedFabShape", "Landroidx/compose/ui/graphics/Shape;", "getExtendedFabShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "largeShape", "getLargeShape", "shape", "getShape", "smallShape", "getSmallShape", "bottomAppBarFabElevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "elevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();
    private static final float LargeIconSize = FabPrimaryLargeTokens.INSTANCE.m2156getIconSizeD9Ej5fM();

    private FloatingActionButtonDefaults() {
    }

    /* renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1539getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-53247565);
        ComposerKt.sourceInformation($composer, "C396@19452L9:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53247565, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:396)");
        }
        Shape shape = ShapesKt.toShape(FabPrimaryTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getSmallShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(394933381);
        ComposerKt.sourceInformation($composer, "C399@19607L9:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394933381, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:399)");
        }
        Shape shape = ShapesKt.toShape(FabPrimarySmallTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getLargeShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1835912187);
        ComposerKt.sourceInformation($composer, "C402@19762L9:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1835912187, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:402)");
        }
        Shape shape = ShapesKt.toShape(FabPrimaryLargeTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getExtendedFabShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-536021915);
        ComposerKt.sourceInformation($composer, "C406@19938L9:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-536021915, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:405)");
        }
        Shape shape = ShapesKt.toShape(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1855656391);
        ComposerKt.sourceInformation($composer, "C409@20096L9:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855656391, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:409)");
        }
        long color = ColorSchemeKt.toColor(FabPrimaryTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1538elevationxZ9QkE(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-241106249);
        ComposerKt.sourceInformation($composer, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i & 1) != 0) {
            defaultElevation = FabPrimaryTokens.INSTANCE.m2173getContainerElevationD9Ej5fM();
        }
        if ((i & 2) != 0) {
            pressedElevation = FabPrimaryTokens.INSTANCE.m2183getPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) != 0) {
            focusedElevation = FabPrimaryTokens.INSTANCE.m2176getFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) != 0) {
            hoveredElevation = FabPrimaryTokens.INSTANCE.m2177getHoverContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241106249, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:423)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return floatingActionButtonElevation;
    }

    /* renamed from: loweredElevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m1540loweredElevationxZ9QkE(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-285065125);
        ComposerKt.sourceInformation($composer, "C(loweredElevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i & 1) != 0) {
            defaultElevation = FabPrimaryTokens.INSTANCE.m2179getLoweredContainerElevationD9Ej5fM();
        }
        if ((i & 2) != 0) {
            pressedElevation = FabPrimaryTokens.INSTANCE.m2182getLoweredPressedContainerElevationD9Ej5fM();
        }
        if ((i & 4) != 0) {
            focusedElevation = FabPrimaryTokens.INSTANCE.m2180getLoweredFocusContainerElevationD9Ej5fM();
        }
        if ((i & 8) != 0) {
            hoveredElevation = FabPrimaryTokens.INSTANCE.m2181getLoweredHoverContainerElevationD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285065125, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:446)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return floatingActionButtonElevation;
    }

    /* renamed from: bottomAppBarFabElevation-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ FloatingActionButtonElevation m1536bottomAppBarFabElevationa9UjIt4$default(FloatingActionButtonDefaults floatingActionButtonDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp = i & 2;
        if ($i$f$getDp != 0) {
            f2 = Dp.m5218constructorimpl(0);
        }
        int $i$f$getDp2 = i & 4;
        if ($i$f$getDp2 != 0) {
            f3 = Dp.m5218constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m5218constructorimpl(0);
        }
        return floatingActionButtonDefaults.m1537bottomAppBarFabElevationa9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: bottomAppBarFabElevation-a9UjIt4, reason: not valid java name */
    public final FloatingActionButtonElevation m1537bottomAppBarFabElevationa9UjIt4(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation) {
        return new FloatingActionButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, null);
    }
}
