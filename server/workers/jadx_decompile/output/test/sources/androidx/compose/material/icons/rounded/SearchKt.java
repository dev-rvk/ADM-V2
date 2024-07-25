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

/* compiled from: Search.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_search", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Search", "Landroidx/compose/material/icons/Icons$Rounded;", "getSearch", "(Landroidx/compose/material/icons/Icons$Rounded;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SearchKt {
    private static ImageVector _search;

    public static final ImageVector getSearch(Icons.Rounded $this$Search) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter($this$Search, "<this>");
        if (_search != null) {
            ImageVector imageVector = _search;
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder $this$_get_Search__u24lambda_u241 = new ImageVector.Builder("Rounded.Search", Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null);
        int pathFillType$iv = VectorKt.getDefaultFillType();
        Brush fill$iv$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv$iv = new PathBuilder();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(15.5f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.horizontalLineToRelative(-0.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(-0.28f, -0.27f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(1.2f, -1.4f, 1.82f, -3.31f, 1.48f, -5.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-0.47f, -2.78f, -2.79f, -5.0f, -5.59f, -5.34f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(-4.23f, -0.52f, -7.79f, 3.04f, -7.27f, 7.27f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.34f, 2.8f, 2.56f, 5.12f, 5.34f, 5.59f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(2.03f, 0.34f, 3.94f, -0.28f, 5.34f, -1.48f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(0.27f, 0.28f);
        $this$PathData_u24lambda_u240$iv$iv$iv.verticalLineToRelative(0.79f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineToRelative(4.25f, 4.25f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.41f, 0.41f, 1.08f, 0.41f, 1.49f, 0.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveToRelative(0.41f, -0.41f, 0.41f, -1.08f, 0.0f, -1.49f);
        $this$PathData_u24lambda_u240$iv$iv$iv.lineTo(15.5f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        $this$PathData_u24lambda_u240$iv$iv$iv.moveTo(9.5f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f);
        $this$PathData_u24lambda_u240$iv$iv$iv.reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f);
        $this$PathData_u24lambda_u240$iv$iv$iv.close();
        m3574addPathoIyEayM = $this$_get_Search__u24lambda_u241.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType$iv, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv$iv, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        _search = m3574addPathoIyEayM.build();
        ImageVector imageVector2 = _search;
        Intrinsics.checkNotNull(imageVector2);
        return imageVector2;
    }
}
