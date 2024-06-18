package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapPositionInLayout.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"calculateDistanceToDesiredSnapPosition", "", "Landroidx/compose/ui/unit/Density;", "mainAxisViewPortSize", "", "beforeContentPadding", "afterContentPadding", "itemSize", "itemOffset", "itemIndex", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapPositionInLayoutKt {
    public static final float calculateDistanceToDesiredSnapPosition(Density $this$calculateDistanceToDesiredSnapPosition, int mainAxisViewPortSize, int beforeContentPadding, int afterContentPadding, int itemSize, int itemOffset, int itemIndex, SnapPositionInLayout snapPositionInLayout) {
        Intrinsics.checkNotNullParameter($this$calculateDistanceToDesiredSnapPosition, "<this>");
        Intrinsics.checkNotNullParameter(snapPositionInLayout, "snapPositionInLayout");
        int containerSize = (mainAxisViewPortSize - beforeContentPadding) - afterContentPadding;
        float desiredDistance = snapPositionInLayout.position($this$calculateDistanceToDesiredSnapPosition, containerSize, itemSize, itemIndex);
        return itemOffset - desiredDistance;
    }
}
