package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RootMeasurePolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo15measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (measurables.isEmpty()) {
            return MeasureScope.layout$default(measure, Constraints.m5176getMinWidthimpl(constraints), Constraints.m5175getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope layout) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                }
            }, 4, null);
        }
        if (measurables.size() == 1) {
            final Placeable placeable = measurables.get(0).mo4186measureBRTryo0(constraints);
            return MeasureScope.layout$default(measure, ConstraintsKt.m5188constrainWidthK40F9xA(constraints, placeable.getWidth()), ConstraintsKt.m5187constrainHeightK40F9xA(constraints, placeable.getHeight()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Placeable.PlacementScope.placeRelativeWithLayer$default(layout, Placeable.this, 0, 0, 0.0f, null, 12, null);
                }
            }, 4, null);
        }
        List target$iv = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = measurables.get(index$iv$iv);
            Measurable it = (Measurable) item$iv$iv;
            target$iv.add(it.mo4186measureBRTryo0(constraints));
        }
        final List placeables = target$iv;
        int size2 = placeables.size();
        int maxWidth = 0;
        int maxHeight = 0;
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Object item$iv = placeables.get(index$iv);
            Placeable placeable2 = (Placeable) item$iv;
            maxWidth = Math.max(placeable2.getWidth(), maxWidth);
            maxHeight = Math.max(placeable2.getHeight(), maxHeight);
        }
        return MeasureScope.layout$default(measure, ConstraintsKt.m5188constrainWidthK40F9xA(constraints, maxWidth), ConstraintsKt.m5187constrainHeightK40F9xA(constraints, maxHeight), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List $this$fastForEach$iv = placeables;
                int size3 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                    Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
                    Placeable placeable3 = (Placeable) item$iv2;
                    Placeable.PlacementScope.placeRelativeWithLayer$default(layout, placeable3, 0, 0, 0.0f, null, 12, null);
                }
            }
        }, 4, null);
    }
}
