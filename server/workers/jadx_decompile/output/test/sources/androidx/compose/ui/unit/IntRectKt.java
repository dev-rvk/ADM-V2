package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: IntRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "offset", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "roundToIntRect", "Landroidx/compose/ui/geometry/Rect;", "toRect", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IntRectKt {
    /* renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m5368IntRectVbeCjmY(long offset, long size) {
        return new IntRect(IntOffset.m5336getXimpl(offset), IntOffset.m5337getYimpl(offset), IntOffset.m5336getXimpl(offset) + IntSize.m5378getWidthimpl(size), IntOffset.m5337getYimpl(offset) + IntSize.m5377getHeightimpl(size));
    }

    /* renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m5367IntRectE1MhUcY(long topLeft, long bottomRight) {
        return new IntRect(IntOffset.m5336getXimpl(topLeft), IntOffset.m5337getYimpl(topLeft), IntOffset.m5336getXimpl(bottomRight), IntOffset.m5337getYimpl(bottomRight));
    }

    /* renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m5369IntRectar5cAso(long center, int radius) {
        return new IntRect(IntOffset.m5336getXimpl(center) - radius, IntOffset.m5337getYimpl(center) - radius, IntOffset.m5336getXimpl(center) + radius, IntOffset.m5337getYimpl(center) + radius);
    }

    public static final IntRect lerp(IntRect start, IntRect stop, float fraction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new IntRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction));
    }

    public static final Rect toRect(IntRect $this$toRect) {
        Intrinsics.checkNotNullParameter($this$toRect, "<this>");
        return new Rect($this$toRect.getLeft(), $this$toRect.getTop(), $this$toRect.getRight(), $this$toRect.getBottom());
    }

    public static final IntRect roundToIntRect(Rect $this$roundToIntRect) {
        Intrinsics.checkNotNullParameter($this$roundToIntRect, "<this>");
        return new IntRect(MathKt.roundToInt($this$roundToIntRect.getLeft()), MathKt.roundToInt($this$roundToIntRect.getTop()), MathKt.roundToInt($this$roundToIntRect.getRight()), MathKt.roundToInt($this$roundToIntRect.getBottom()));
    }
}
