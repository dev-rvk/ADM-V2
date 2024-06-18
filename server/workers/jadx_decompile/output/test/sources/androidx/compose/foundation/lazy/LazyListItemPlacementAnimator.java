package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: LazyListItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J<\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u001bJ\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002JE\u0010(\u001a\u00020\u001b*\u00020\u000e26\u0010)\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001b0*H\u0082\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "()V", "activeKeys", "", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "placeableIndex", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Set<Object> activeKeys = new LinkedHashSet();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:94:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x029b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasured(int r36, int r37, int r38, java.util.List<androidx.compose.foundation.lazy.LazyListMeasuredItem> r39, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.onMeasured(int, int, int, java.util.List, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, boolean):void");
    }

    public final void reset() {
        this.activeKeys.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyListMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        long targetFirstPlaceableOffset2;
        LazyListMeasuredItem $this$forEachNode$iv;
        LazyListMeasuredItem lazyListMeasuredItem = item;
        int i = 0;
        long firstPlaceableOffset = lazyListMeasuredItem.m594getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, null);
        }
        LazyListMeasuredItem $this$forEachNode$iv2 = item;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        while (i < placeablesCount) {
            int index$iv = i;
            LazyLayoutAnimateItemModifierNode it$iv = getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (it$iv != null) {
                long arg0$iv = lazyListMeasuredItem.m594getOffsetBjo55l4(index$iv);
                $this$forEachNode$iv = $this$forEachNode$iv2;
                long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv) - IntOffset.m5336getXimpl(firstPlaceableOffset), IntOffset.m5337getYimpl(arg0$iv) - IntOffset.m5337getYimpl(firstPlaceableOffset));
                targetFirstPlaceableOffset2 = targetFirstPlaceableOffset;
                long targetFirstPlaceableOffset3 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(targetFirstPlaceableOffset) + IntOffset.m5336getXimpl(arg0$iv2), IntOffset.m5337getYimpl(targetFirstPlaceableOffset) + IntOffset.m5337getYimpl(arg0$iv2));
                it$iv.m631setRawOffsetgyyYBs(targetFirstPlaceableOffset3);
            } else {
                targetFirstPlaceableOffset2 = targetFirstPlaceableOffset;
                $this$forEachNode$iv = $this$forEachNode$iv2;
            }
            i++;
            lazyListMeasuredItem = item;
            targetFirstPlaceableOffset = targetFirstPlaceableOffset2;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
        }
    }

    private final void startAnimationsIfNeeded(LazyListMeasuredItem item) {
        LazyListMeasuredItem $this$forEachNode$iv;
        LazyListItemPlacementAnimator this_$iv;
        int $i$f$forEachNode;
        int i;
        LazyListMeasuredItem $this$forEachNode$iv2 = item;
        LazyListItemPlacementAnimator this_$iv2 = this;
        int $i$f$forEachNode2 = 0;
        int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
        int i2 = 0;
        while (i2 < placeablesCount) {
            int index$iv = i2;
            LazyLayoutAnimateItemModifierNode it$iv = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv));
            if (it$iv != null) {
                long newTarget = item.m594getOffsetBjo55l4(index$iv);
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                long currentTarget = it$iv.getRawOffset();
                $i$f$forEachNode = $i$f$forEachNode2;
                i = placeablesCount;
                if (!IntOffset.m5335equalsimpl0(currentTarget, LazyLayoutAnimateItemModifierNode.INSTANCE.m632getNotInitializednOccac()) && !IntOffset.m5335equalsimpl0(currentTarget, newTarget)) {
                    it$iv.m628animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(newTarget) - IntOffset.m5336getXimpl(currentTarget), IntOffset.m5337getYimpl(newTarget) - IntOffset.m5337getYimpl(currentTarget)));
                }
                it$iv.m631setRawOffsetgyyYBs(newTarget);
            } else {
                $this$forEachNode$iv = $this$forEachNode$iv2;
                this_$iv = this_$iv2;
                $i$f$forEachNode = $i$f$forEachNode2;
                i = placeablesCount;
            }
            i2++;
            this_$iv2 = this_$iv;
            $this$forEachNode$iv2 = $this$forEachNode$iv;
            $i$f$forEachNode2 = $i$f$forEachNode;
            placeablesCount = i;
        }
    }

    private final LazyLayoutAnimateItemModifierNode getNode(Object $this$node) {
        if ($this$node instanceof LazyLayoutAnimateItemModifierNode) {
            return (LazyLayoutAnimateItemModifierNode) $this$node;
        }
        return null;
    }

    private final boolean getHasAnimations(LazyListMeasuredItem $this$hasAnimations) {
        int placeablesCount = $this$hasAnimations.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index$iv = i;
            if (getNode($this$hasAnimations.getParentData(index$iv)) != null) {
                return true;
            }
        }
        return false;
    }

    private final void forEachNode(LazyListMeasuredItem $this$forEachNode, Function2<? super Integer, ? super LazyLayoutAnimateItemModifierNode, Unit> function2) {
        int placeablesCount = $this$forEachNode.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index = i;
            LazyLayoutAnimateItemModifierNode it = getNode($this$forEachNode.getParentData(index));
            if (it != null) {
                function2.invoke(Integer.valueOf(index), it);
            }
        }
    }
}
