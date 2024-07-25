package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: MaterialTheme.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/MaterialTheme;", "", "()V", "colors", "Landroidx/compose/material/Colors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Colors;", "shapes", "Landroidx/compose/material/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Shapes;", "typography", "Landroidx/compose/material/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Typography;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MaterialTheme {
    public static final int $stable = 0;
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    private MaterialTheme() {
    }

    public final Colors getColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1462282791, "C102@4462L7:MaterialTheme.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1462282791, $changed, -1, "androidx.compose.material.MaterialTheme.<get-colors> (MaterialTheme.kt:102)");
        }
        ProvidableCompositionLocal<Colors> localColors = ColorsKt.getLocalColors();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localColors);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Colors colors = (Colors) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return colors;
    }

    public final Typography getTypography(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1630198856, "C112@4763L7:MaterialTheme.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1630198856, $changed, -1, "androidx.compose.material.MaterialTheme.<get-typography> (MaterialTheme.kt:112)");
        }
        ProvidableCompositionLocal<Typography> localTypography = TypographyKt.getLocalTypography();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localTypography);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Typography typography = (Typography) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return typography;
    }

    public final Shapes getShapes(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1586253541, "C120@4971L7:MaterialTheme.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1586253541, $changed, -1, "androidx.compose.material.MaterialTheme.<get-shapes> (MaterialTheme.kt:120)");
        }
        ProvidableCompositionLocal<Shapes> localShapes = ShapesKt.getLocalShapes();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localShapes);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Shapes shapes = (Shapes) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return shapes;
    }
}
