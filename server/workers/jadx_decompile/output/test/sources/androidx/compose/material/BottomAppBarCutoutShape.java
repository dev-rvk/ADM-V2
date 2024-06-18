package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J4\u0010\"\u001a\u00020 *\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/material/BottomAppBarCutoutShape;", "Landroidx/compose/ui/graphics/Shape;", "cutoutShape", "fabPlacement", "Landroidx/compose/material/FabPlacement;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/FabPlacement;)V", "getCutoutShape", "()Landroidx/compose/ui/graphics/Shape;", "getFabPlacement", "()Landroidx/compose/material/FabPlacement;", "component1", "component2", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "addCutoutShape", "", "Landroidx/compose/ui/graphics/Path;", "addRoundedEdges", "cutoutStartPosition", "", "cutoutEndPosition", "cutoutRadius", "roundedEdgeRadius", "verticalOffset", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class BottomAppBarCutoutShape implements Shape {
    private final Shape cutoutShape;
    private final FabPlacement fabPlacement;

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i & 2) != 0) {
            fabPlacement = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement);
    }

    /* renamed from: component1, reason: from getter */
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    /* renamed from: component2, reason: from getter */
    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public final BottomAppBarCutoutShape copy(Shape cutoutShape, FabPlacement fabPlacement) {
        Intrinsics.checkNotNullParameter(cutoutShape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement, "fabPlacement");
        return new BottomAppBarCutoutShape(cutoutShape, fabPlacement);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) other;
        return Intrinsics.areEqual(this.cutoutShape, bottomAppBarCutoutShape.cutoutShape) && Intrinsics.areEqual(this.fabPlacement, bottomAppBarCutoutShape.fabPlacement);
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }

    public BottomAppBarCutoutShape(Shape cutoutShape, FabPlacement fabPlacement) {
        Intrinsics.checkNotNullParameter(cutoutShape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement, "fabPlacement");
        this.cutoutShape = cutoutShape;
        this.fabPlacement = fabPlacement;
    }

    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo212createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path boundingRectangle = AndroidPath_androidKt.Path();
        boundingRectangle.addRect(new Rect(0.0f, 0.0f, Size.m2779getWidthimpl(size), Size.m2776getHeightimpl(size)));
        Path $this$createOutline_Pq9zytI_u24lambda_u241 = AndroidPath_androidKt.Path();
        addCutoutShape($this$createOutline_Pq9zytI_u24lambda_u241, layoutDirection, density);
        $this$createOutline_Pq9zytI_u24lambda_u241.mo2843opN5in7k0(boundingRectangle, $this$createOutline_Pq9zytI_u24lambda_u241, PathOperation.INSTANCE.m3234getDifferenceb3I0S0c());
        return new Outline.Generic($this$createOutline_Pq9zytI_u24lambda_u241);
    }

    private final void addCutoutShape(Path $this$addCutoutShape, LayoutDirection layoutDirection, Density density) {
        float f;
        float f2;
        f = AppBarKt.BottomAppBarCutoutOffset;
        float cutoutOffset = density.mo329toPx0680j_4(f);
        float f3 = 2;
        long cutoutSize = SizeKt.Size(this.fabPlacement.getWidth() + (cutoutOffset * f3), this.fabPlacement.getHeight() + (f3 * cutoutOffset));
        float cutoutStartX = this.fabPlacement.getLeft() - cutoutOffset;
        float cutoutEndX = cutoutStartX + Size.m2779getWidthimpl(cutoutSize);
        float cutoutRadius = Size.m2776getHeightimpl(cutoutSize) / 2.0f;
        float cutoutStartY = -cutoutRadius;
        OutlineKt.addOutline($this$addCutoutShape, this.cutoutShape.mo212createOutlinePq9zytI(cutoutSize, layoutDirection, density));
        $this$addCutoutShape.mo2846translatek4lQ0M(OffsetKt.Offset(cutoutStartX, cutoutStartY));
        if (Intrinsics.areEqual(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            f2 = AppBarKt.BottomAppBarRoundedEdgeRadius;
            float edgeRadius = density.mo329toPx0680j_4(f2);
            addRoundedEdges($this$addCutoutShape, cutoutStartX, cutoutEndX, cutoutRadius, edgeRadius, 0.0f);
        }
    }

    private final void addRoundedEdges(Path $this$addRoundedEdges, float cutoutStartPosition, float cutoutEndPosition, float cutoutRadius, float roundedEdgeRadius, float verticalOffset) {
        float appBarInterceptOffset = -((float) Math.sqrt((cutoutRadius * cutoutRadius) - (verticalOffset * verticalOffset)));
        float appBarInterceptStartX = cutoutStartPosition + cutoutRadius + appBarInterceptOffset;
        float appBarInterceptEndX = cutoutEndPosition - (cutoutRadius + appBarInterceptOffset);
        float controlPointRadiusOffset = appBarInterceptOffset - 1.0f;
        Pair<Float, Float> calculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(controlPointRadiusOffset, verticalOffset, cutoutRadius);
        float curveInterceptXOffset = calculateRoundedEdgeIntercept.component1().floatValue();
        float curveInterceptYOffset = calculateRoundedEdgeIntercept.component2().floatValue();
        float curveInterceptStartX = cutoutStartPosition + curveInterceptXOffset + cutoutRadius;
        float curveInterceptEndX = cutoutEndPosition - (curveInterceptXOffset + cutoutRadius);
        float curveInterceptY = curveInterceptYOffset - verticalOffset;
        float roundedEdgeStartX = appBarInterceptStartX - roundedEdgeRadius;
        float roundedEdgeEndX = appBarInterceptEndX + roundedEdgeRadius;
        $this$addRoundedEdges.moveTo(roundedEdgeStartX, 0.0f);
        $this$addRoundedEdges.quadraticBezierTo(appBarInterceptStartX - 1.0f, 0.0f, curveInterceptStartX, curveInterceptY);
        $this$addRoundedEdges.lineTo(curveInterceptEndX, curveInterceptY);
        $this$addRoundedEdges.quadraticBezierTo(appBarInterceptEndX + 1.0f, 0.0f, roundedEdgeEndX, 0.0f);
        $this$addRoundedEdges.close();
    }
}
