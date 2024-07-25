package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureScopeWithLayoutNodeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiContentMeasurePolicy.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, d2 = {"createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiContentMeasurePolicyKt {
    public static final MeasurePolicy createMeasurePolicy(final MultiContentMeasurePolicy measurePolicy) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        return new MeasurePolicy() { // from class: androidx.compose.ui.layout.MultiContentMeasurePolicyKt$createMeasurePolicy$1$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo15measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return MultiContentMeasurePolicy.this.m4235measure3p2s80s(measure, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren(measure), constraints);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return MultiContentMeasurePolicy.this.minIntrinsicWidth($this$minIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicWidth), height);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return MultiContentMeasurePolicy.this.minIntrinsicHeight($this$minIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicHeight), width);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return MultiContentMeasurePolicy.this.maxIntrinsicWidth($this$maxIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicWidth), height);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return MultiContentMeasurePolicy.this.maxIntrinsicHeight($this$maxIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicHeight), width);
            }
        };
    }
}
