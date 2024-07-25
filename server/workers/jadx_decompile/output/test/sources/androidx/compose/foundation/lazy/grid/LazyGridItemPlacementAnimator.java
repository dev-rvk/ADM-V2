package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JD\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J!\u0010+\u001a\u00020\u001c*\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001c0-H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "node", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "getNode", "(Ljava/lang/Object;)Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateItemModifierNode;", "initializeNode", "", "item", "mainAxisOffset", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "reset", "startAnimationsIfNeeded", "forEachNode", "block", "Lkotlin/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyGridMeasuredItem> positionedItems, LazyGridMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, boolean isVertical) {
        boolean z;
        long IntOffset;
        int previousLineMainAxisSize;
        long m5183fixedHeightOenEA2s;
        int accumulatedOffset;
        int previousLine;
        int newIndex;
        int previousLineMainAxisSize2;
        int previousFirstVisibleIndex;
        List $this$fastForEach$iv;
        int $i$f$fastForEach;
        int i;
        LazyGridMeasuredItem $this$forEachNode$iv;
        LazyGridItemPlacementAnimator this_$iv;
        int i2;
        Object item$iv;
        LazyGridSpanLayoutProvider spanLayoutProvider2 = spanLayoutProvider;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider2, "spanLayoutProvider");
        int index$iv$iv = 0;
        int size = positionedItems.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = positionedItems.get(index$iv$iv);
                LazyGridMeasuredItem it = (LazyGridMeasuredItem) item$iv$iv;
                if (getHasAnimations(it)) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        if (!z && this.keyToItemInfoMap.isEmpty()) {
            reset();
            return;
        }
        int previousFirstVisibleIndex2 = this.firstVisibleIndex;
        LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) CollectionsKt.firstOrNull((List) positionedItems);
        this.firstVisibleIndex = lazyGridMeasuredItem != null ? lazyGridMeasuredItem.getIndex() : 0;
        final LazyLayoutKeyIndexMap previousKeyToIndexMap = this.keyIndexMap;
        this.keyIndexMap = itemProvider.getKeyIndexMap();
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        if (isVertical) {
            IntOffset = IntOffsetKt.IntOffset(0, consumedScroll);
        } else {
            IntOffset = IntOffsetKt.IntOffset(consumedScroll, 0);
        }
        long scrollOffset = IntOffset;
        this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
        List $this$fastForEach$iv2 = positionedItems;
        int $i$f$fastForEach2 = 0;
        int index$iv = 0;
        int size2 = $this$fastForEach$iv2.size();
        while (index$iv < size2) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv);
            LazyGridMeasuredItem item = (LazyGridMeasuredItem) item$iv2;
            this.movingAwayKeys.remove(item.getKey());
            if (getHasAnimations(item)) {
                ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                if (itemInfo == null) {
                    Map<Object, ItemInfo> map = this.keyToItemInfoMap;
                    Object key = item.getKey();
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    int $i$f$fastForEach3 = item.getCrossAxisSize();
                    i = size2;
                    map.put(key, new ItemInfo($i$f$fastForEach3, item.getCrossAxisOffset()));
                    int previousIndex = previousKeyToIndexMap.getIndex(item.getKey());
                    if (previousIndex != -1 && item.getIndex() != previousIndex) {
                        if (previousIndex < previousFirstVisibleIndex2) {
                            this.movingInFromStartBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        } else {
                            this.movingInFromEndBound.add(item);
                            previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        }
                    } else {
                        long it2 = item.getOffset();
                        initializeNode(item, item.getIsVertical() ? IntOffset.m5337getYimpl(it2) : IntOffset.m5336getXimpl(it2));
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                    }
                } else {
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    i = size2;
                    LazyGridMeasuredItem $this$forEachNode$iv2 = item;
                    LazyGridItemPlacementAnimator this_$iv2 = this;
                    int $i$f$forEachNode = 0;
                    int placeablesCount = $this$forEachNode$iv2.getPlaceablesCount();
                    int i3 = 0;
                    while (i3 < placeablesCount) {
                        int index$iv2 = i3;
                        int previousFirstVisibleIndex3 = previousFirstVisibleIndex2;
                        int index$iv3 = $i$f$forEachNode;
                        LazyLayoutAnimateItemModifierNode it3 = this_$iv2.getNode($this$forEachNode$iv2.getParentData(index$iv2));
                        if (it3 != null) {
                            this_$iv = this_$iv2;
                            i2 = placeablesCount;
                            item$iv = item$iv2;
                            if (IntOffset.m5335equalsimpl0(it3.getRawOffset(), LazyLayoutAnimateItemModifierNode.INSTANCE.m632getNotInitializednOccac())) {
                                $this$forEachNode$iv = $this$forEachNode$iv2;
                            } else {
                                long arg0$iv = it3.getRawOffset();
                                $this$forEachNode$iv = $this$forEachNode$iv2;
                                it3.m631setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(arg0$iv) + IntOffset.m5336getXimpl(scrollOffset), IntOffset.m5337getYimpl(arg0$iv) + IntOffset.m5337getYimpl(scrollOffset)));
                            }
                        } else {
                            $this$forEachNode$iv = $this$forEachNode$iv2;
                            this_$iv = this_$iv2;
                            i2 = placeablesCount;
                            item$iv = item$iv2;
                        }
                        i3++;
                        $i$f$forEachNode = index$iv3;
                        previousFirstVisibleIndex2 = previousFirstVisibleIndex3;
                        this_$iv2 = this_$iv;
                        item$iv2 = item$iv;
                        placeablesCount = i2;
                        $this$forEachNode$iv2 = $this$forEachNode$iv;
                    }
                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                    itemInfo.setCrossAxisSize(item.getCrossAxisSize());
                    itemInfo.setCrossAxisOffset(item.getCrossAxisOffset());
                    startAnimationsIfNeeded(item);
                }
            } else {
                previousFirstVisibleIndex = previousFirstVisibleIndex2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach = $i$f$fastForEach2;
                i = size2;
                this.keyToItemInfoMap.remove(item.getKey());
            }
            index$iv++;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            $i$f$fastForEach2 = $i$f$fastForEach;
            size2 = i;
            previousFirstVisibleIndex2 = previousFirstVisibleIndex;
        }
        int accumulatedOffset2 = 0;
        int previousLine2 = -1;
        int previousLineMainAxisSize3 = 0;
        List $this$sortByDescending$iv = this.movingInFromStartBound;
        if ($this$sortByDescending$iv.size() > 1) {
            CollectionsKt.sortWith($this$sortByDescending$iv, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it4 = (LazyGridMeasuredItem) t2;
                    LazyGridMeasuredItem it5 = (LazyGridMeasuredItem) t;
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(it4.getKey())), Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(it5.getKey())));
                }
            });
        }
        List $this$fastForEach$iv3 = this.movingInFromStartBound;
        int $i$f$fastForEach4 = 0;
        int index$iv4 = 0;
        int size3 = $this$fastForEach$iv3.size();
        while (index$iv4 < size3) {
            Object item$iv3 = $this$fastForEach$iv3.get(index$iv4);
            LazyGridMeasuredItem item2 = (LazyGridMeasuredItem) item$iv3;
            int line = isVertical ? item2.getRow() : item2.getColumn();
            List $this$fastForEach$iv4 = $this$fastForEach$iv3;
            int line2 = $i$f$fastForEach4;
            if (line != -1 && line == previousLine2) {
                previousLineMainAxisSize3 = Math.max(previousLineMainAxisSize3, item2.getMainAxisSize());
            } else {
                accumulatedOffset2 += previousLineMainAxisSize3;
                previousLineMainAxisSize3 = item2.getMainAxisSize();
                previousLine2 = line;
            }
            int mainAxisOffset = (0 - accumulatedOffset2) - item2.getMainAxisSize();
            initializeNode(item2, mainAxisOffset);
            startAnimationsIfNeeded(item2);
            index$iv4++;
            $this$fastForEach$iv3 = $this$fastForEach$iv4;
            $i$f$fastForEach4 = line2;
        }
        int accumulatedOffset3 = 0;
        int previousLine3 = -1;
        List $this$sortBy$iv = this.movingInFromEndBound;
        if ($this$sortBy$iv.size() > 1) {
            CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyGridMeasuredItem it4 = (LazyGridMeasuredItem) t;
                    LazyGridMeasuredItem it5 = (LazyGridMeasuredItem) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(it4.getKey())), Integer.valueOf(LazyLayoutKeyIndexMap.this.getIndex(it5.getKey())));
                }
            });
        }
        List $this$fastForEach$iv5 = this.movingInFromEndBound;
        int index$iv5 = 0;
        int size4 = $this$fastForEach$iv5.size();
        int previousLineMainAxisSize4 = 0;
        while (index$iv5 < size4) {
            Object item$iv4 = $this$fastForEach$iv5.get(index$iv5);
            LazyGridMeasuredItem item3 = (LazyGridMeasuredItem) item$iv4;
            int line3 = isVertical ? item3.getRow() : item3.getColumn();
            List $this$fastForEach$iv6 = $this$fastForEach$iv5;
            if (line3 != -1 && line3 == previousLine3) {
                previousLineMainAxisSize2 = Math.max(previousLineMainAxisSize4, item3.getMainAxisSize());
            } else {
                accumulatedOffset3 += previousLineMainAxisSize4;
                previousLineMainAxisSize2 = item3.getMainAxisSize();
                previousLine3 = line3;
            }
            previousLineMainAxisSize4 = previousLineMainAxisSize2;
            int previousLineMainAxisSize5 = mainAxisLayoutSize + accumulatedOffset3;
            initializeNode(item3, previousLineMainAxisSize5);
            startAnimationsIfNeeded(item3);
            index$iv5++;
            $this$fastForEach$iv5 = $this$fastForEach$iv6;
        }
        Iterable $this$forEach$iv = this.movingAwayKeys;
        for (Object element$iv : $this$forEach$iv) {
            ItemInfo itemInfo2 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, element$iv);
            int newIndex2 = this.keyIndexMap.getIndex(element$iv);
            if (newIndex2 == -1) {
                this.keyToItemInfoMap.remove(element$iv);
                accumulatedOffset = accumulatedOffset3;
                previousLine = previousLine3;
            } else {
                if (isVertical) {
                    m5183fixedHeightOenEA2s = Constraints.INSTANCE.m5184fixedWidthOenEA2s(itemInfo2.getCrossAxisSize());
                } else {
                    m5183fixedHeightOenEA2s = Constraints.INSTANCE.m5183fixedHeightOenEA2s(itemInfo2.getCrossAxisSize());
                }
                long j = m5183fixedHeightOenEA2s;
                accumulatedOffset = accumulatedOffset3;
                previousLine = previousLine3;
                LazyGridMeasuredItem item4 = LazyGridMeasuredItemProvider.m622getAndMeasure3p2s80s$default(itemProvider, newIndex2, 0, j, 2, null);
                boolean inProgress = false;
                int placeablesCount2 = item4.getPlaceablesCount();
                for (int it4 = 0; it4 < placeablesCount2; it4++) {
                    LazyLayoutAnimateItemModifierNode node = getNode(item4.getParentData(it4));
                    if (node != null && node.isAnimationInProgress()) {
                        inProgress = true;
                    }
                }
                if (inProgress) {
                    newIndex = newIndex2;
                } else {
                    newIndex = newIndex2;
                    if (newIndex == previousKeyToIndexMap.getIndex(element$iv)) {
                        this.keyToItemInfoMap.remove(element$iv);
                    }
                }
                if (newIndex < this.firstVisibleIndex) {
                    this.movingAwayToStartBound.add(item4);
                } else {
                    this.movingAwayToEndBound.add(item4);
                }
            }
            accumulatedOffset3 = accumulatedOffset;
            previousLine3 = previousLine;
        }
        int accumulatedOffset4 = 0;
        int previousLine4 = -1;
        int previousLineMainAxisSize6 = 0;
        List $this$sortByDescending$iv2 = this.movingAwayToStartBound;
        if ($this$sortByDescending$iv2.size() > 1) {
            CollectionsKt.sortWith($this$sortByDescending$iv2, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap;
                    LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap2;
                    LazyGridMeasuredItem it5 = (LazyGridMeasuredItem) t2;
                    lazyLayoutKeyIndexMap = LazyGridItemPlacementAnimator.this.keyIndexMap;
                    Integer valueOf = Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(it5.getKey()));
                    LazyGridMeasuredItem it6 = (LazyGridMeasuredItem) t;
                    lazyLayoutKeyIndexMap2 = LazyGridItemPlacementAnimator.this.keyIndexMap;
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(lazyLayoutKeyIndexMap2.getIndex(it6.getKey())));
                }
            });
        }
        List $this$fastForEach$iv7 = this.movingAwayToStartBound;
        int $i$f$fastForEach5 = 0;
        int index$iv6 = 0;
        int size5 = $this$fastForEach$iv7.size();
        while (index$iv6 < size5) {
            Object item$iv5 = $this$fastForEach$iv7.get(index$iv6);
            LazyGridMeasuredItem item5 = (LazyGridMeasuredItem) item$iv5;
            List $this$fastForEach$iv8 = $this$fastForEach$iv7;
            int line4 = spanLayoutProvider2.getLineIndexOfItem(item5.getIndex());
            int $i$f$fastForEach6 = $i$f$fastForEach5;
            if (line4 != -1 && line4 == previousLine4) {
                previousLineMainAxisSize6 = Math.max(previousLineMainAxisSize6, item5.getMainAxisSize());
            } else {
                accumulatedOffset4 += previousLineMainAxisSize6;
                previousLineMainAxisSize6 = item5.getMainAxisSize();
                previousLine4 = line4;
            }
            int mainAxisOffset2 = (0 - accumulatedOffset4) - item5.getMainAxisSize();
            int accumulatedOffset5 = accumulatedOffset4;
            ItemInfo itemInfo3 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item5.getKey());
            LazyGridMeasuredItem.position$default(item5, mainAxisOffset2, itemInfo3.getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, null);
            positionedItems.add(item5);
            startAnimationsIfNeeded(item5);
            index$iv6++;
            $this$fastForEach$iv7 = $this$fastForEach$iv8;
            $i$f$fastForEach5 = $i$f$fastForEach6;
            accumulatedOffset4 = accumulatedOffset5;
            previousLine4 = previousLine4;
        }
        int accumulatedOffset6 = 0;
        int previousLine5 = -1;
        int previousLineMainAxisSize7 = 0;
        List $this$sortBy$iv2 = this.movingAwayToEndBound;
        if ($this$sortBy$iv2.size() > 1) {
            CollectionsKt.sortWith($this$sortBy$iv2, new Comparator() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap;
                    LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap2;
                    LazyGridMeasuredItem it5 = (LazyGridMeasuredItem) t;
                    lazyLayoutKeyIndexMap = LazyGridItemPlacementAnimator.this.keyIndexMap;
                    Integer valueOf = Integer.valueOf(lazyLayoutKeyIndexMap.getIndex(it5.getKey()));
                    LazyGridMeasuredItem it6 = (LazyGridMeasuredItem) t2;
                    lazyLayoutKeyIndexMap2 = LazyGridItemPlacementAnimator.this.keyIndexMap;
                    return ComparisonsKt.compareValues(valueOf, Integer.valueOf(lazyLayoutKeyIndexMap2.getIndex(it6.getKey())));
                }
            });
        }
        List $this$fastForEach$iv9 = this.movingAwayToEndBound;
        int index$iv7 = 0;
        int size6 = $this$fastForEach$iv9.size();
        while (index$iv7 < size6) {
            Object item$iv6 = $this$fastForEach$iv9.get(index$iv7);
            LazyGridMeasuredItem item6 = (LazyGridMeasuredItem) item$iv6;
            List $this$fastForEach$iv10 = $this$fastForEach$iv9;
            int line5 = spanLayoutProvider2.getLineIndexOfItem(item6.getIndex());
            if (line5 != -1 && line5 == previousLine5) {
                previousLineMainAxisSize = Math.max(previousLineMainAxisSize7, item6.getMainAxisSize());
            } else {
                accumulatedOffset6 += previousLineMainAxisSize7;
                previousLineMainAxisSize = item6.getMainAxisSize();
                previousLine5 = line5;
            }
            previousLineMainAxisSize7 = previousLineMainAxisSize;
            int previousLineMainAxisSize8 = mainAxisLayoutSize + accumulatedOffset6;
            int accumulatedOffset7 = accumulatedOffset6;
            ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item6.getKey());
            LazyGridMeasuredItem.position$default(item6, previousLineMainAxisSize8, itemInfo4.getCrossAxisOffset(), layoutWidth, layoutHeight, 0, 0, 48, null);
            positionedItems.add(item6);
            startAnimationsIfNeeded(item6);
            index$iv7++;
            spanLayoutProvider2 = spanLayoutProvider;
            $this$fastForEach$iv9 = $this$fastForEach$iv10;
            accumulatedOffset6 = accumulatedOffset7;
            previousLine5 = previousLine5;
        }
        this.movingInFromStartBound.clear();
        this.movingInFromEndBound.clear();
        this.movingAwayToStartBound.clear();
        this.movingAwayToEndBound.clear();
        this.movingAwayKeys.clear();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    private final void initializeNode(LazyGridMeasuredItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyGridMeasuredItem $this$forEachNode$iv;
        LazyGridItemPlacementAnimator this_$iv;
        long firstPlaceableOffset = item.getOffset();
        if (item.getIsVertical()) {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m5332copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, null);
        }
        LazyGridMeasuredItem $this$forEachNode$iv2 = item;
        LazyGridItemPlacementAnimator this_$iv2 = this;
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

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem item) {
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

    private final boolean getHasAnimations(LazyGridMeasuredItem $this$hasAnimations) {
        int placeablesCount = $this$hasAnimations.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            int index$iv = i;
            if (getNode($this$hasAnimations.getParentData(index$iv)) != null) {
                return true;
            }
        }
        return false;
    }

    private final void forEachNode(LazyGridMeasuredItem $this$forEachNode, Function1<? super LazyLayoutAnimateItemModifierNode, Unit> function1) {
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
