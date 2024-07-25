package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    private LimitInsets(WindowInsets insets, int sides) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        this.insets = insets;
        this.sides = sides;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    /* renamed from: getSides-JoeWqyM, reason: not valid java name and from getter */
    public final int getSides() {
        return this.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        int layoutDirectionSide;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            layoutDirectionSide = WindowInsetsSides.INSTANCE.m572getAllowLeftInLtrJoeWqyM$foundation_layout_release();
        } else {
            layoutDirectionSide = WindowInsetsSides.INSTANCE.m573getAllowLeftInRtlJoeWqyM$foundation_layout_release();
        }
        boolean allowLeft = WindowInsetsSides.m566hasAnybkgdKaI$foundation_layout_release(this.sides, layoutDirectionSide);
        if (allowLeft) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (WindowInsetsSides.m566hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.INSTANCE.m582getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        int layoutDirectionSide;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            layoutDirectionSide = WindowInsetsSides.INSTANCE.m574getAllowRightInLtrJoeWqyM$foundation_layout_release();
        } else {
            layoutDirectionSide = WindowInsetsSides.INSTANCE.m575getAllowRightInRtlJoeWqyM$foundation_layout_release();
        }
        boolean allowRight = WindowInsetsSides.m566hasAnybkgdKaI$foundation_layout_release(this.sides, layoutDirectionSide);
        if (allowRight) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (WindowInsetsSides.m566hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.INSTANCE.m576getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LimitInsets) {
            return Intrinsics.areEqual(this.insets, ((LimitInsets) other).insets) && WindowInsetsSides.m565equalsimpl0(this.sides, ((LimitInsets) other).sides);
        }
        return false;
    }

    public int hashCode() {
        int result = this.insets.hashCode();
        return (result * 31) + WindowInsetsSides.m567hashCodeimpl(this.sides);
    }

    public String toString() {
        return '(' + this.insets + " only " + ((Object) WindowInsetsSides.m569toStringimpl(this.sides)) + ')';
    }
}
