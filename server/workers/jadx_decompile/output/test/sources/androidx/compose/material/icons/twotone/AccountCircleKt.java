package androidx.compose.material.icons.twotone;

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

/* compiled from: AccountCircle.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountCircle", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountCircle", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountCircle", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AccountCircleKt {
    private static ImageVector _accountCircle;

    public static final ImageVector getAccountCircle(Icons.TwoTone $this$AccountCircle) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$AccountCircle, "<this>");
        if (_accountCircle != null) {
            ImageVector imageVector = _accountCircle;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_AccountCircle__u24lambda_u243 = new ImageVector.Builder("TwoTone.AccountCircle", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-4.42f, 0.0f, -8.0f, 3.58f, -8.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.95f, 0.7f, 3.73f, 1.86f, 5.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.55f, 15.8f, 9.68f, 15.0f, 12.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(4.45f, 0.8f, 6.14f, 2.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(19.3f, 15.73f, 20.0f, 13.95f, 20.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(20.0f, 7.58f, 16.42f, 4.0f, 12.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.93f, 0.0f, -3.5f, -1.57f, -3.5f, -3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(8.5f, 7.57f, 10.07f, 6.0f, 12.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveToRelative(3.5f, 1.57f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(15.5f, 11.43f, 13.93f, 13.0f, 12.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$_get_AccountCircle__u24lambda_u243.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, 5.52f, 4.48f, 10.0f, 10.0f, 10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(22.0f, 6.48f, 17.52f, 2.0f, 12.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(12.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-1.74f, 0.0f, -3.34f, -0.56f, -4.65f, -1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(8.66f, 17.56f, 10.26f, 17.0f, 12.0f, 17.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(3.34f, 0.56f, 4.65f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(15.34f, 19.44f, 13.74f, 20.0f, 12.0f, 20.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(18.14f, 17.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(16.45f, 15.8f, 14.32f, 15.0f, 12.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-4.45f, 0.8f, -6.14f, 2.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(4.7f, 15.73f, 4.0f, 13.95f, 4.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.0f, -4.42f, 3.58f, -8.0f, 8.0f, -8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(20.0f, 13.95f, 19.3f, 15.73f, 18.14f, 17.12f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$_get_AccountCircle__u24lambda_u243.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(12.0f, 5.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(-1.93f, 0.0f, -3.5f, 1.57f, -3.5f, 3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(0.0f, 1.93f, 1.57f, 3.5f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(3.5f, -1.57f, 3.5f, -3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveTo(15.5f, 7.5f, 13.93f, 5.93f, 12.0f, 5.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.close();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(12.0f, 10.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(0.67f, -1.5f, 1.5f, -1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.reflectiveCurveTo(12.83f, 10.93f, 12.0f, 10.93f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.close();
        m3574addPathoIyEayM = $this$_get_AccountCircle__u24lambda_u243.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _accountCircle = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _accountCircle;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
