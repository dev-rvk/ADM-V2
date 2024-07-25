package androidx.compose.material.icons.sharp;

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

/* compiled from: Clear.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_clear", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Clear", "Landroidx/compose/material/icons/Icons$Sharp;", "getClear", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ClearKt {
    private static ImageVector _clear;

    public static final ImageVector getClear(Icons.Sharp $this$Clear) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Clear, "<this>");
        if (_clear != null) {
            ImageVector imageVector = _clear;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Clear__u24lambda_u241 = new ImageVector.Builder("Sharp.Clear", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 10.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.41f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(10.59f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(5.0f, 17.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(6.41f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 13.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(17.59f, 19.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 17.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(13.41f, 12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(19.0f, 6.41f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Clear__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _clear = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _clear;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
