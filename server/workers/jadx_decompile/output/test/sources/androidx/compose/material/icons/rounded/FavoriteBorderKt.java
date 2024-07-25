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

/* compiled from: FavoriteBorder.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_favoriteBorder", "Landroidx/compose/ui/graphics/vector/ImageVector;", "FavoriteBorder", "Landroidx/compose/material/icons/Icons$Rounded;", "getFavoriteBorder", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FavoriteBorderKt {
    private static ImageVector _favoriteBorder;

    public static final ImageVector getFavoriteBorder(Icons.Rounded $this$FavoriteBorder) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$FavoriteBorder, "<this>");
        if (_favoriteBorder != null) {
            ImageVector imageVector = _favoriteBorder;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_FavoriteBorder__u24lambda_u241 = new ImageVector.Builder("Rounded.FavoriteBorder", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(19.66f, 3.99f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-2.64f, -1.8f, -5.9f, -0.96f, -7.66f, 1.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.76f, -2.06f, -5.02f, -2.91f, -7.66f, -1.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-1.4f, 0.96f, -2.28f, 2.58f, -2.34f, 4.29f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.14f, 3.88f, 3.3f, 6.99f, 8.55f, 11.76f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.1f, 0.09f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.76f, 0.69f, 1.93f, 0.69f, 2.69f, -0.01f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.11f, -0.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(5.25f, -4.76f, 8.68f, -7.87f, 8.55f, -11.75f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.06f, -1.7f, -0.94f, -3.32f, -2.34f, -4.28f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(12.1f, 18.55f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.1f, 0.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.1f, -0.1f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.14f, 14.24f, 4.0f, 11.39f, 4.0f, 8.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(4.0f, 6.5f, 5.5f, 5.0f, 7.5f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.54f, 0.0f, 3.04f, 0.99f, 3.57f, 2.36f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(1.87f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(13.46f, 5.99f, 14.96f, 5.0f, 16.5f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(2.0f, 0.0f, 3.5f, 1.5f, 3.5f, 3.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.0f, 2.89f, -3.14f, 5.74f, -7.9f, 10.05f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_FavoriteBorder__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _favoriteBorder = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _favoriteBorder;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
