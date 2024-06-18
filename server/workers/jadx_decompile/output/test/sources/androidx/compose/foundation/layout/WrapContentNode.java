package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B2\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bø\u0001\u0000¢\u0006\u0002\u0010\fJ)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!R/\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        this.direction = direction;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.alignmentCallback = function2;
    }

    public WrapContentNode(Direction direction, boolean unbounded, Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(alignmentCallback, "alignmentCallback");
        this.direction = direction;
        this.unbounded = unbounded;
        this.alignmentCallback = alignmentCallback;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(final MeasureScope measure, Measurable measurable, long constraints) {
        int m5174getMaxWidthimpl;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int m5176getMinWidthimpl = this.direction != Direction.Vertical ? 0 : Constraints.m5176getMinWidthimpl(constraints);
        int m5175getMinHeightimpl = this.direction == Direction.Horizontal ? Constraints.m5175getMinHeightimpl(constraints) : 0;
        if (this.direction != Direction.Vertical && this.unbounded) {
            m5174getMaxWidthimpl = Integer.MAX_VALUE;
        } else {
            m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(constraints);
        }
        long wrappedConstraints = ConstraintsKt.Constraints(m5176getMinWidthimpl, m5174getMaxWidthimpl, m5175getMinHeightimpl, (this.direction == Direction.Horizontal || !this.unbounded) ? Constraints.m5173getMaxHeightimpl(constraints) : Integer.MAX_VALUE);
        final Placeable placeable = measurable.mo4186measureBRTryo0(wrappedConstraints);
        final int wrapperWidth = RangesKt.coerceIn(placeable.getWidth(), Constraints.m5176getMinWidthimpl(constraints), Constraints.m5174getMaxWidthimpl(constraints));
        final int wrapperHeight = RangesKt.coerceIn(placeable.getHeight(), Constraints.m5175getMinHeightimpl(constraints), Constraints.m5173getMaxHeightimpl(constraints));
        return MeasureScope.layout$default(measure, wrapperWidth, wrapperHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                long position = WrapContentNode.this.getAlignmentCallback().invoke(IntSize.m5370boximpl(IntSizeKt.IntSize(wrapperWidth - placeable.getWidth(), wrapperHeight - placeable.getHeight())), measure.getLayoutDirection()).getPackedValue();
                Placeable.PlacementScope.m4243place70tqf50$default(layout, placeable, position, 0.0f, 2, null);
            }
        }, 4, null);
    }
}
