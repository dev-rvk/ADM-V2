package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyStaggeredGridScrollPosition.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\fJ\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007J\u0018\u0010(\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014¨\u0006/"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "initialIndices", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "targetIndex", "laneCount", "([I[ILkotlin/jvm/functions/Function2;)V", "hadFirstNotEmptyLayout", "", "<set-?>", "indices", "getIndices", "()[I", "setIndices", "([I)V", "indices$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "offsets", "getOffsets", "setOffsets", "offsets$delegate", "equivalent", "a", "b", "requestPosition", "", "index", "scrollOffset", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridScrollPosition implements SnapshotMutationPolicy<int[]> {
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;

    /* renamed from: indices$delegate, reason: from kotlin metadata */
    private final MutableState indices;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;

    /* renamed from: offsets$delegate, reason: from kotlin metadata */
    private final MutableState offsets;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridScrollPosition(int[] initialIndices, int[] initialOffsets, Function2<? super Integer, ? super Integer, int[]> fillIndices) {
        Intrinsics.checkNotNullParameter(initialIndices, "initialIndices");
        Intrinsics.checkNotNullParameter(initialOffsets, "initialOffsets");
        Intrinsics.checkNotNullParameter(fillIndices, "fillIndices");
        this.fillIndices = fillIndices;
        this.indices = SnapshotStateKt.mutableStateOf(initialIndices, this);
        this.offsets = SnapshotStateKt.mutableStateOf(initialOffsets, this);
        Integer minOrNull = ArraysKt.minOrNull(initialIndices);
        this.nearestRangeState = new LazyLayoutNearestRangeState(minOrNull != null ? minOrNull.intValue() : 0, 90, 200);
    }

    private final void setIndices(int[] iArr) {
        MutableState $this$setValue$iv = this.indices;
        $this$setValue$iv.setValue(iArr);
    }

    public final int[] getIndices() {
        State $this$getValue$iv = this.indices;
        return (int[]) $this$getValue$iv.getValue();
    }

    private final void setOffsets(int[] iArr) {
        MutableState $this$setValue$iv = this.offsets;
        $this$setValue$iv.setValue(iArr);
    }

    public final int[] getOffsets() {
        State $this$getValue$iv = this.offsets;
        return (int[]) $this$getValue$iv.getValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [kotlin.collections.IntIterator] */
    public final void updateFromMeasureResult(LazyStaggeredGridMeasureResult measureResult) {
        Object it$iv;
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        int[] $this$minBy$iv = measureResult.getFirstVisibleItemIndices();
        if ($this$minBy$iv.length == 0) {
            throw new NoSuchElementException();
        }
        int minElem$iv = $this$minBy$iv[0];
        int lastIndex$iv = ArraysKt.getLastIndex($this$minBy$iv);
        if (lastIndex$iv != 0) {
            int it = minElem$iv;
            if (it == -1) {
                it = Integer.MAX_VALUE;
            }
            ?? it2 = new IntRange(1, lastIndex$iv).iterator();
            while (it2.hasNext()) {
                int i$iv = it2.nextInt();
                int e$iv = $this$minBy$iv[i$iv];
                int it3 = e$iv;
                if (it3 == -1) {
                    it3 = Integer.MAX_VALUE;
                }
                if (it > it3) {
                    minElem$iv = e$iv;
                    it = it3;
                }
            }
        }
        int it4 = minElem$iv;
        if (it4 == Integer.MAX_VALUE) {
            it4 = 0;
        }
        int i = it4;
        List $this$fastFirstOrNull$iv = measureResult.getVisibleItemsInfo();
        int index$iv$iv = 0;
        int size = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                if (((LazyStaggeredGridItemInfo) it$iv).getIndex() == i) {
                    break;
                } else {
                    index$iv$iv++;
                }
            } else {
                it$iv = null;
                break;
            }
        }
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) it$iv;
        this.lastKnownFirstItemKey = lazyStaggeredGridItemInfo != null ? lazyStaggeredGridItemInfo.getKey() : null;
        this.nearestRangeState.update(i);
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            Snapshot.Companion this_$iv = Snapshot.INSTANCE;
            Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    update(measureResult.getFirstVisibleItemIndices(), measureResult.getFirstVisibleItemScrollOffsets());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    snapshot$iv.restoreCurrent(previous$iv$iv);
                }
            } finally {
                snapshot$iv.dispose();
            }
        }
    }

    public final void requestPosition(int index, int scrollOffset) {
        int[] newIndices = this.fillIndices.invoke(Integer.valueOf(index), Integer.valueOf(getIndices().length));
        int length = newIndices.length;
        int[] newOffsets = new int[length];
        for (int i = 0; i < length; i++) {
            newOffsets[i] = scrollOffset;
        }
        update(newIndices, newOffsets);
        this.nearestRangeState.update(index);
        this.lastKnownFirstItemKey = null;
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider itemProvider, int[] indices) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(indices, "indices");
        Object obj = this.lastKnownFirstItemKey;
        Integer orNull = ArraysKt.getOrNull(indices, 0);
        int newIndex = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, obj, orNull != null ? orNull.intValue() : 0);
        if (!ArraysKt.contains(indices, newIndex)) {
            this.nearestRangeState.update(newIndex);
            int[] newIndices = this.fillIndices.invoke(Integer.valueOf(newIndex), Integer.valueOf(indices.length));
            setIndices(newIndices);
            return newIndices;
        }
        return indices;
    }

    private final void update(int[] indices, int[] offsets) {
        setIndices(indices);
        setOffsets(offsets);
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(int[] a, int[] b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return Arrays.equals(a, b);
    }
}
