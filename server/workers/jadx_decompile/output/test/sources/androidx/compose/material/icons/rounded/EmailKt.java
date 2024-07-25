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

/* compiled from: Email.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_email", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Email", "Landroidx/compose/material/icons/Icons$Rounded;", "getEmail", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EmailKt {
    private static ImageVector _email;

    public static final ImageVector getEmail(Icons.Rounded $this$Email) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Email, "<this>");
        if (_email != null) {
            ImageVector imageVector = _email;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Email__u24lambda_u241 = new ImageVector.Builder("Rounded.Email", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(20.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.0f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(2.0f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(16.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(22.0f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.6f, 8.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-7.07f, 4.42f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.32f, 0.2f, -0.74f, 0.2f, -1.06f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(4.4f, 8.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.25f, -0.16f, -0.4f, -0.43f, -0.4f, -0.72f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, -0.67f, 0.73f, -1.07f, 1.3f, -0.72f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(12.0f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(6.7f, -4.19f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.57f, -0.35f, 1.3f, 0.05f, 1.3f, 0.72f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 0.29f, -0.15f, 0.56f, -0.4f, 0.72f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Email__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _email = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _email;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
