package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/MinIntrinsicHeightModifier;", "Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "()V", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class MinIntrinsicHeightModifier implements IntrinsicSizeModifier {
    public static final MinIntrinsicHeightModifier INSTANCE = new MinIntrinsicHeightModifier();

    private MinIntrinsicHeightModifier() {
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier
    /* renamed from: calculateContentConstraints-l58MMJ0 */
    public long mo438calculateContentConstraintsl58MMJ0(MeasureScope calculateContentConstraints, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(calculateContentConstraints, "$this$calculateContentConstraints");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int height = measurable.minIntrinsicHeight(Constraints.m5174getMaxWidthimpl(constraints));
        return Constraints.INSTANCE.m5183fixedHeightOenEA2s(height);
    }

    @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return measurable.minIntrinsicHeight(width);
    }
}
