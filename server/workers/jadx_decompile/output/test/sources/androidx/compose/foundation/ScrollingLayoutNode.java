package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Scroll.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010!\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\"\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\f\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006#"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "setReversed", "(Z)V", "setVertical", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "setScrollerState", "(Landroidx/compose/foundation/ScrollState;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {
    private boolean isReversed;
    private boolean isVertical;
    private ScrollState scrollerState;

    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    public final void setScrollerState(ScrollState scrollState) {
        Intrinsics.checkNotNullParameter(scrollState, "<set-?>");
        this.scrollerState = scrollState;
    }

    /* renamed from: isReversed, reason: from getter */
    public final boolean getIsReversed() {
        return this.isReversed;
    }

    public final void setReversed(boolean z) {
        this.isReversed = z;
    }

    /* renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }

    public ScrollingLayoutNode(ScrollState scrollerState, boolean isReversed, boolean isVertical) {
        Intrinsics.checkNotNullParameter(scrollerState, "scrollerState");
        this.scrollerState = scrollerState;
        this.isReversed = isReversed;
        this.isVertical = isVertical;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        long childConstraints;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        CheckScrollableContainerConstraintsKt.m191checkScrollableContainerConstraintsK40F9xA(constraints, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        childConstraints = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : this.isVertical ? Constraints.m5174getMaxWidthimpl(constraints) : Integer.MAX_VALUE, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : this.isVertical ? Integer.MAX_VALUE : Constraints.m5173getMaxHeightimpl(constraints));
        final Placeable placeable = measurable.mo4186measureBRTryo0(childConstraints);
        int width = RangesKt.coerceAtMost(placeable.getWidth(), Constraints.m5174getMaxWidthimpl(constraints));
        int height = RangesKt.coerceAtMost(placeable.getHeight(), Constraints.m5173getMaxHeightimpl(constraints));
        int scrollHeight = placeable.getHeight() - height;
        int scrollWidth = placeable.getWidth() - width;
        final int side = this.isVertical ? scrollHeight : scrollWidth;
        this.scrollerState.setMaxValue$foundation_release(side);
        this.scrollerState.setViewportSize$foundation_release(this.isVertical ? height : width);
        return MeasureScope.layout$default(measure, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollingLayoutNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                int scroll = RangesKt.coerceIn(ScrollingLayoutNode.this.getScrollerState().getValue(), 0, side);
                int absScroll = ScrollingLayoutNode.this.getIsReversed() ? scroll - side : -scroll;
                int xOffset = ScrollingLayoutNode.this.getIsVertical() ? 0 : absScroll;
                int yOffset = ScrollingLayoutNode.this.getIsVertical() ? absScroll : 0;
                Placeable.PlacementScope.placeRelativeWithLayer$default(layout, placeable, xOffset, yOffset, 0.0f, null, 12, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.minIntrinsicWidth(Integer.MAX_VALUE);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.minIntrinsicHeight(width);
        }
        return measurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (this.isVertical) {
            return measurable.maxIntrinsicHeight(width);
        }
        return measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }
}
