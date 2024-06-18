package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FixedDpInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "leftDp", "Landroidx/compose/ui/unit/Dp;", "topDp", "rightDp", "bottomDp", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.foundation.layout.FixedDpInsets, reason: from toString */
/* loaded from: classes.dex */
final class Insets implements WindowInsets {

    /* renamed from: bottomDp, reason: from kotlin metadata and from toString */
    private final float bottom;

    /* renamed from: leftDp, reason: from kotlin metadata and from toString */
    private final float left;

    /* renamed from: rightDp, reason: from kotlin metadata and from toString */
    private final float right;

    /* renamed from: topDp, reason: from kotlin metadata and from toString */
    private final float top;

    public /* synthetic */ Insets(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    private Insets(float leftDp, float topDp, float rightDp, float bottomDp) {
        this.left = leftDp;
        this.top = topDp;
        this.right = rightDp;
        this.bottom = bottomDp;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo323roundToPx0680j_4(this.left);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo323roundToPx0680j_4(this.top);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo323roundToPx0680j_4(this.right);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo323roundToPx0680j_4(this.bottom);
    }

    public String toString() {
        return "Insets(left=" + ((Object) Dp.m5229toStringimpl(this.left)) + ", top=" + ((Object) Dp.m5229toStringimpl(this.top)) + ", right=" + ((Object) Dp.m5229toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m5229toStringimpl(this.bottom)) + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Insets) {
            return Dp.m5223equalsimpl0(this.left, ((Insets) other).left) && Dp.m5223equalsimpl0(this.top, ((Insets) other).top) && Dp.m5223equalsimpl0(this.right, ((Insets) other).right) && Dp.m5223equalsimpl0(this.bottom, ((Insets) other).bottom);
        }
        return false;
    }

    public int hashCode() {
        int result = Dp.m5224hashCodeimpl(this.left);
        return (((((result * 31) + Dp.m5224hashCodeimpl(this.top)) * 31) + Dp.m5224hashCodeimpl(this.right)) * 31) + Dp.m5224hashCodeimpl(this.bottom);
    }
}
