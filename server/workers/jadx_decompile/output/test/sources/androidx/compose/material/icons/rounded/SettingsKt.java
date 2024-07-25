package androidx.compose.material.icons.rounded;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_settings", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Settings", "Landroidx/compose/material/icons/Icons$Rounded;", "getSettings", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SettingsKt {
    private static ImageVector _settings;

    public static final ImageVector getSettings(Icons.Rounded $this$Settings) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Settings, "<this>");
        if (_settings != null) {
            ImageVector imageVector = _settings;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Settings__u24lambda_u241 = new ImageVector.Builder("Rounded.Settings", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.5f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.23f, -0.01f, -0.45f, -0.03f, -0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.86f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.4f, -0.3f, 0.51f, -0.86f, 0.26f, -1.3f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.87f, -3.23f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.25f, -0.44f, -0.79f, -0.62f, -1.25f, -0.42f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.15f, 0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.37f, -0.26f, -0.76f, -0.49f, -1.17f, -0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.29f, -2.31f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(14.8f, 2.38f, 14.37f, 2.0f, 13.87f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-3.73f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(9.63f, 2.0f, 9.2f, 2.38f, 9.14f, 2.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(8.85f, 5.19f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.41f, 0.19f, -0.8f, 0.42f, -1.17f, 0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.53f, 4.96f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.46f, -0.2f, -1.0f, -0.02f, -1.25f, 0.42f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.41f, 8.62f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.25f, 0.44f, -0.14f, 0.99f, 0.26f, 1.3f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.86f, 1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.51f, 11.55f, 4.5f, 11.77f, 4.5f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(0.01f, 0.45f, 0.03f, 0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.86f, 1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.4f, 0.3f, -0.51f, 0.86f, -0.26f, 1.3f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.87f, 3.23f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.25f, 0.44f, 0.79f, 0.62f, 1.25f, 0.42f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.15f, -0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.37f, 0.26f, 0.76f, 0.49f, 1.17f, 0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.29f, 2.31f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(9.2f, 21.62f, 9.63f, 22.0f, 10.13f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(3.73f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.5f, 0.0f, 0.93f, -0.38f, 0.99f, -0.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.29f, -2.31f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.41f, -0.19f, 0.8f, -0.42f, 1.17f, -0.68f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.15f, 0.91f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.46f, 0.2f, 1.0f, 0.02f, 1.25f, -0.42f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.87f, -3.23f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.25f, -0.44f, 0.14f, -0.99f, -0.26f, -1.3f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.86f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(19.49f, 12.45f, 19.5f, 12.23f, 19.5f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.04f, 15.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.57f, -3.5f, 3.5f, -3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(13.97f, 15.5f, 12.04f, 15.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Settings__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _settings = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _settings;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
