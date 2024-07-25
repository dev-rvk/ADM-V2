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

/* compiled from: Call.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_call", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Call", "Landroidx/compose/material/icons/Icons$Rounded;", "getCall", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CallKt {
    private static ImageVector _call;

    public static final ImageVector getCall(Icons.Rounded $this$Call) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Call, "<this>");
        if (_call != null) {
            ImageVector imageVector = _call;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Call__u24lambda_u241 = new ImageVector.Builder("Rounded.Call", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.23f, 15.26f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-2.54f, -0.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.61f, -0.07f, -1.21f, 0.14f, -1.64f, 0.57f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-1.84f, 1.84f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.83f, -1.44f, -5.15f, -3.75f, -6.59f, -6.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(1.85f, -1.85f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.43f, -0.43f, 0.64f, -1.03f, 0.57f, -1.64f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.29f, -2.52f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.12f, -1.01f, -0.97f, -1.77f, -1.99f, -1.77f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(5.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.13f, 0.0f, -2.07f, 0.94f, -2.0f, 2.07f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.53f, 8.54f, 7.36f, 15.36f, 15.89f, 15.89f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.13f, 0.07f, 2.07f, -0.87f, 2.07f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(-1.73f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.01f, -1.01f, -0.75f, -1.86f, -1.76f, -1.98f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Call__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _call = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _call;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
