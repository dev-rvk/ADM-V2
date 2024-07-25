package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "<set-?>");
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(final MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!(Dp.m5217compareTo0680j_4(this.paddingValues.mo435calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m5218constructorimpl((float) 0)) >= 0 && Dp.m5217compareTo0680j_4(this.paddingValues.getTop(), Dp.m5218constructorimpl((float) 0)) >= 0 && Dp.m5217compareTo0680j_4(this.paddingValues.mo436calculateRightPaddingu2uoSUM(measure.getLayoutDirection()), Dp.m5218constructorimpl((float) 0)) >= 0 && Dp.m5217compareTo0680j_4(this.paddingValues.getBottom(), Dp.m5218constructorimpl((float) 0)) >= 0)) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int horizontal = measure.mo323roundToPx0680j_4(this.paddingValues.mo435calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo323roundToPx0680j_4(this.paddingValues.mo436calculateRightPaddingu2uoSUM(measure.getLayoutDirection()));
        int vertical = measure.mo323roundToPx0680j_4(this.paddingValues.getTop()) + measure.mo323roundToPx0680j_4(this.paddingValues.getBottom());
        final Placeable placeable = measurable.mo4186measureBRTryo0(ConstraintsKt.m5190offsetNN6EwU(constraints, -horizontal, -vertical));
        int width = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, placeable.getWidth() + horizontal);
        int height = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, placeable.getHeight() + vertical);
        return MeasureScope.layout$default(measure, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(layout, Placeable.this, measure.mo323roundToPx0680j_4(this.getPaddingValues().mo435calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())), measure.mo323roundToPx0680j_4(this.getPaddingValues().getTop()), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
