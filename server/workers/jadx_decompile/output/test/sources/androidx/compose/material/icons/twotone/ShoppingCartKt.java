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

/* compiled from: ShoppingCart.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_shoppingCart", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ShoppingCart", "Landroidx/compose/material/icons/Icons$TwoTone;", "getShoppingCart", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ShoppingCartKt {
    private static ImageVector _shoppingCart;

    public static final ImageVector getShoppingCart(Icons.TwoTone $this$ShoppingCart) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$ShoppingCart, "<this>");
        if (_shoppingCart != null) {
            ImageVector imageVector = _shoppingCart;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_ShoppingCart__u24lambda_u242 = new ImageVector.Builder("TwoTone.ShoppingCart", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.55f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.76f, -5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineTo(6.16f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(2.37f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$_get_ShoppingCart__u24lambda_u242.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        int pathFillType$iv2 = VectorKt.getDefaultFillType();
        Brush fill$iv$iv2 = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv2 = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv2 = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv2 = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(15.55f, 13.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.75f, 0.0f, 1.41f, -0.41f, 1.75f, -1.03f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(3.58f, -6.49f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(0.37f, -0.66f, -0.11f, -1.48f, -0.87f, -1.48f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(5.21f, 4.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-0.94f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(1.0f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(3.6f, 7.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-1.35f, 2.44f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveTo(4.52f, 15.37f, 5.48f, 17.0f, 7.0f, 17.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(12.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.verticalLineToRelative(-2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(7.0f, 15.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(1.1f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(7.45f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(6.16f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.horizontalLineToRelative(12.15f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineToRelative(-2.76f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(8.53f, 11.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.lineTo(6.16f, 6.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(7.0f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveTo(5.9f, 22.0f, 7.0f, 22.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        $this$PathData_u24lambda_u240$iv$iv$iv2.moveTo(17.0f, 18.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(0.89f, 2.0f, 1.99f, 2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(2.0f, -0.9f, 2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.reflectiveCurveToRelative(-0.9f, -2.0f, -2.0f, -2.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv2.close();
        m3574addPathoIyEayM = $this$_get_ShoppingCart__u24lambda_u242.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv2, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv2, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _shoppingCart = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _shoppingCart;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
