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

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_share", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Share", "Landroidx/compose/material/icons/Icons$TwoTone;", "getShare", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShareKt {
    private static ImageVector _share;

    public static final ImageVector getShare(Icons.TwoTone $this$Share) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Share, "<this>");
        if (_share != null) {
            ImageVector imageVector = _share;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Share__u24lambda_u244 = new ImageVector.Builder("TwoTone.Share", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(18.0f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.moveToRelative(-1.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f);
        $this$_get_Share__u24lambda_u244.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(6.0f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveToRelative(-1.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f);
        $this$_get_Share__u24lambda_u244.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv3 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv3 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv3 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv3 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv3 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveTo(18.0f, 19.02f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.moveToRelative(-1.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.arcToRelative(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv3.arcToRelative(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f);
        $this$_get_Share__u24lambda_u244.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv3.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv3, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv3, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv3, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv3, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv4 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv4 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv4 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv4 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv4 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv4.moveTo(18.0f, 16.08f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(-0.76f, 0.0f, -1.44f, 0.3f, -1.96f, 0.77f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.lineTo(8.91f, 12.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.05f, -0.23f, 0.09f, -0.46f, 0.09f, -0.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-0.04f, -0.47f, -0.09f, -0.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.lineToRelative(7.05f, -4.11f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.54f, 0.5f, 1.25f, 0.81f, 2.04f, 0.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(1.66f, 0.0f, 3.0f, -1.34f, 3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-3.0f, 1.34f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.0f, 0.24f, 0.04f, 0.47f, 0.09f, 0.7f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.lineTo(8.04f, 9.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveTo(7.5f, 9.31f, 6.79f, 9.0f, 6.0f, 9.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.79f, 0.0f, 1.5f, -0.31f, 2.04f, -0.81f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.lineToRelative(7.12f, 4.16f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.0f, 1.61f, 1.31f, 2.92f, 2.92f, 2.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(2.92f, -1.31f, 2.92f, -2.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.0f, -1.61f, -1.31f, -2.92f, -2.92f, -2.92f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.close();
        $this$PathData_u24lambda_u240$iv$iv$iv4.moveTo(18.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.close();
        $this$PathData_u24lambda_u240$iv$iv$iv4.moveTo(6.0f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.close();
        $this$PathData_u24lambda_u240$iv$iv$iv4.moveTo(18.0f, 20.02f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv4.close();
        m3574addPathoIyEayM = $this$_get_Share__u24lambda_u244.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv4.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv4, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv4, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv4, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv4, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _share = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _share;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
