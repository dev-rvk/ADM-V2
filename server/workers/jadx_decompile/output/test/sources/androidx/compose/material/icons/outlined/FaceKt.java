package androidx.compose.material.icons.outlined;

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

/* compiled from: Face.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$Outlined;", "getFace", "(Landroidx/compose/material/icons/Icons$Outlined;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FaceKt {
    private static ImageVector _face;

    public static final ImageVector getFace(Icons.Outlined $this$Face) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Face, "<this>");
        if (_face != null) {
            ImageVector imageVector = _face;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Face__u24lambda_u241 = new ImageVector.Builder("Outlined.Face", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(10.25f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.69f, -0.56f, 1.25f, -1.25f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(7.75f, 13.69f, 7.75f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(0.56f, -1.25f, 1.25f, -1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.25f, 0.56f, 1.25f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.0f, 11.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.69f, 0.0f, -1.25f, 0.56f, -1.25f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(0.56f, 1.25f, 1.25f, 1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(1.25f, -0.56f, 1.25f, -1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(-0.56f, -1.25f, -1.25f, -1.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(22.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 5.52f, -4.48f, 10.0f, -10.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(2.0f, 17.52f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(6.48f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(10.0f, 4.48f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(10.66f, 4.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.46f, 0.0f, 0.91f, -0.05f, 1.34f, -0.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.46f, 0.0f, -0.91f, 0.05f, -1.34f, 0.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(4.42f, 9.47f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(20.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.78f, -0.12f, -1.53f, -0.33f, -2.24f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.7f, 0.15f, -1.42f, 0.24f, -2.17f, 0.24f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-3.13f, 0.0f, -5.92f, -1.44f, -7.76f, -3.69f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(8.69f, 8.87f, 6.6f, 10.88f, 4.0f, 11.86f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.01f, 0.04f, 0.0f, 0.09f, 0.0f, 0.14f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 4.41f, 3.59f, 8.0f, 8.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(8.0f, -3.59f, 8.0f, -8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Face__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _face = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _face;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
