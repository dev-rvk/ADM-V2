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

/* compiled from: CheckCircle.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_checkCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "CheckCircle", "Landroidx/compose/material/icons/Icons$Rounded;", "getCheckCircle", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckCircleKt {
    private static ImageVector _checkCircle;

    public static final ImageVector getCheckCircle(Icons.Rounded $this$CheckCircle) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$CheckCircle, "<this>");
        if (_checkCircle != null) {
            ImageVector imageVector = _checkCircle;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_CheckCircle__u24lambda_u241 = new ImageVector.Builder("Rounded.CheckCircle", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(9.29f, 16.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.7f, 12.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0.0f, -1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.0f, 14.17f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.88f, -6.88f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0.0f, 1.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-7.59f, 7.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.38f, 0.39f, -1.02f, 0.39f, -1.41f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_CheckCircle__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _checkCircle = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _checkCircle;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
