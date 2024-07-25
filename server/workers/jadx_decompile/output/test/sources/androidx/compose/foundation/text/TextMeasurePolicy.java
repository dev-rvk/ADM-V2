package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: BasicText.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J/\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "placements", "Lkotlin/Function0;", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<? extends List<Rect>> placements) {
        Intrinsics.checkNotNullParameter(placements, "placements");
        this.placements = placements;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo15measure3p2s80s(MeasureScope measure, List<? extends Measurable> list, long constraints) {
        ArrayList arrayList;
        List $this$fastMapIndexedNotNull$iv;
        List $this$fastForEachIndexed$iv$iv;
        int $i$f$fastForEachIndexed;
        Pair pair;
        List<? extends Measurable> measurables = list;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMapIndexedNotNull$iv2 = this.placements.invoke();
        if ($this$fastMapIndexedNotNull$iv2 == null) {
            arrayList = null;
        } else {
            ArrayList target$iv = new ArrayList($this$fastMapIndexedNotNull$iv2.size());
            List $this$fastForEachIndexed$iv$iv2 = $this$fastMapIndexedNotNull$iv2;
            int $i$f$fastForEachIndexed2 = 0;
            int index$iv$iv = 0;
            int size = $this$fastForEachIndexed$iv$iv2.size();
            while (index$iv$iv < size) {
                Object item$iv$iv = $this$fastForEachIndexed$iv$iv2.get(index$iv$iv);
                int index$iv = index$iv$iv;
                Rect rect = (Rect) item$iv$iv;
                if (rect != null) {
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $this$fastForEachIndexed$iv$iv = $this$fastForEachIndexed$iv$iv2;
                    $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                    pair = new Pair(measurables.get(index$iv).mo4186measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m5327boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
                } else {
                    $this$fastMapIndexedNotNull$iv = $this$fastMapIndexedNotNull$iv2;
                    $this$fastForEachIndexed$iv$iv = $this$fastForEachIndexed$iv$iv2;
                    $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                    pair = null;
                }
                if (pair != null) {
                    target$iv.add(pair);
                }
                index$iv$iv++;
                measurables = list;
                $this$fastMapIndexedNotNull$iv2 = $this$fastMapIndexedNotNull$iv;
                $this$fastForEachIndexed$iv$iv2 = $this$fastForEachIndexed$iv$iv;
                $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed;
            }
            arrayList = target$iv;
        }
        final List toPlace = arrayList;
        return MeasureScope.layout$default(measure, Constraints.m5174getMaxWidthimpl(constraints), Constraints.m5173getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
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
                List $this$fastForEach$iv = toPlace;
                if ($this$fastForEach$iv == null) {
                    return;
                }
                int size2 = $this$fastForEach$iv.size();
                for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv2);
                    Pair<Placeable, IntOffset> pair2 = (Pair) item$iv;
                    Placeable placeable = pair2.component1();
                    long position = pair2.component2().getPackedValue();
                    Placeable.PlacementScope.m4243place70tqf50$default(layout, placeable, position, 0.0f, 2, null);
                }
            }
        }, 4, null);
    }
}
