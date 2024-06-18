package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010*\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0,H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:103:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0347 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r35, int r36, int r37, java.util.List<androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem> r38, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider r39, boolean r40, int r41) {
        /*
            Method dump skipped, instructions count: 1173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider, boolean, int):void");
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyStaggeredGridMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv;
        LazyStaggeredGridItemPlacementAnimator this_$iv;
        long firstPlaceableOffset = item.getOffset();
        if (item.getIsVertical()) {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, null);
        }
        LazyStaggeredGridMeasuredItem $this$forEachNode$iv2 = item;
        LazyStaggeredGridItemPlacementAnimator this_$iv2 = this;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        int i = 0;
        while (i < placeablesCount) {
            int index$iv = i;
            LazyLayoutAnimateItemModifierNode node = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (node != null) {
                long arg0$iv = item.getOffset();
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv) - IntOffset.m5336getXimpl(firstPlaceableOffset), IntOffset.m5337getYimpl(arg0$iv) - IntOffset.m5337getYimpl(firstPlaceableOffset));
                node.m631setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(targetFirstPlaceableOffset) + IntOffset.m5336getXimpl(diffToFirstPlaceableOffset), IntOffset.m5337getYimpl(targetFirstPlaceableOffset) + IntOffset.m5337getYimpl(diffToFirstPlaceableOffset)));
            } else {
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
            }
            i++;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
            this_$iv2 = this_$iv;
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem item) {
        int placeablesCount = item.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index$iv = i;
            LazyLayoutAnimateItemModifierNode node = getNode(item.getParentData(index$iv));
            if (node != null) {
                long newTarget = item.getOffset();
                long currentTarget = node.getRawOffset();
                if (!IntOffset.m5335equalsimpl0(currentTarget, LazyLayoutAnimateItemModifierNode.INSTANCE.m632getNotInitializednOccac()) && !IntOffset.m5335equalsimpl0(currentTarget, newTarget)) {
                    node.m628animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(newTarget) - IntOffset.m5336getXimpl(currentTarget), IntOffset.m5337getYimpl(newTarget) - IntOffset.m5337getYimpl(currentTarget)));
                }
                node.m631setRawOffsetgyyYBs(newTarget);
            }
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object $this$node) {
        if ($this$node instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) $this$node;
        }
        return null;
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem $this$hasAnimations) {
        int placeablesCount = $this$hasAnimations.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index$iv = i;
            if (getNode($this$hasAnimations.getParentData(index$iv)) != null) {
                return true;
            }
        }
        return false;
    }

    private final void forEachNode(LazyStaggeredGridMeasuredItem $this$forEachNode, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> function1) {
        int placeablesCount = $this$forEachNode.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            LazyLayoutAnimateItemModifierNode node = getNode($this$forEachNode.getParentData(index));
            if (node != null) {
                function1.invoke(node);
            }
        }
    }
}
