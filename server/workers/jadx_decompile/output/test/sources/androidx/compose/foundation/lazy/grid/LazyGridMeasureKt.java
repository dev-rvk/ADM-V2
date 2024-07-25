package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\u0083\bø\u0001\u0000\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aè\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012/\u00101\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040\b¢\u0006\u0002\b5\u0012\u0004\u0012\u00020602H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-ZRKPzZ8", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Ljava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    /* renamed from: measureLazyGrid-ZRKPzZ8, reason: not valid java name */
    public static final LazyGridMeasureResult m619measureLazyGridZRKPzZ8(int itemsCount, LazyGridMeasuredLineProvider measuredLineProvider, LazyGridMeasuredItemProvider measuredItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenLines, int firstVisibleLineIndex, int firstVisibleLineScrollOffset, float scrollToBeConsumed, long constraints, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density, LazyGridItemPlacementAnimator placementAnimator, LazyGridSpanLayoutProvider spanLayoutProvider, List<Integer> pinnedItems, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int minOffset;
        int currentFirstLineIndex;
        int maxMainAxis;
        int maxMainAxis2;
        int currentMainAxisOffset;
        int currentMainAxisOffset2;
        int scrollDelta;
        ArrayDeque visibleLines;
        LazyGridMeasuredLine firstLine;
        int layoutWidth;
        int layoutHeight;
        List list;
        int index$iv$iv;
        int lastItemIndex;
        int i;
        List $this$fastForEach$iv$iv;
        ArrayList arrayList;
        int visibleLinesScrollOffset;
        int currentFirstLineScrollOffset;
        float consumedScroll;
        int firstItemIndex;
        int index$iv$iv2;
        int maxMainAxis3;
        ArrayDeque visibleLines2;
        int i2;
        List $this$fastForEach$iv$iv2;
        ArrayList arrayList2;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int currentFirstLineIndex2;
        int minOffset2;
        int currentMainAxisOffset3;
        Intrinsics.checkNotNullParameter(measuredLineProvider, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(spanLayoutProvider, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(pinnedItems, "pinnedItems");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (!(beforeContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (itemsCount <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m5176getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m5175getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }
            }), CollectionsKt.emptyList(), -beforeContentPadding, mainAxisAvailableSize + afterContentPadding, 0, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding, spaceBetweenLines);
        }
        int currentFirstLineIndex3 = firstVisibleLineIndex;
        int scrollDelta2 = MathKt.roundToInt(scrollToBeConsumed);
        int currentFirstLineScrollOffset2 = firstVisibleLineScrollOffset - scrollDelta2;
        if (currentFirstLineIndex3 == 0 && currentFirstLineScrollOffset2 < 0) {
            scrollDelta2 += currentFirstLineScrollOffset2;
            currentFirstLineScrollOffset2 = 0;
        }
        ArrayDeque visibleLines3 = new ArrayDeque();
        int minOffset3 = (-beforeContentPadding) + (spaceBetweenLines < 0 ? spaceBetweenLines : 0);
        int currentFirstLineScrollOffset3 = currentFirstLineScrollOffset2 + minOffset3;
        while (currentFirstLineScrollOffset3 < 0 && currentFirstLineIndex3 > 0) {
            int previous = currentFirstLineIndex3 - 1;
            LazyGridMeasuredLine measuredLine = measuredLineProvider.getAndMeasure(previous);
            visibleLines3.add(0, measuredLine);
            currentFirstLineScrollOffset3 += measuredLine.getMainAxisSizeWithSpacings();
            currentFirstLineIndex3 = previous;
        }
        if (currentFirstLineScrollOffset3 < minOffset3) {
            scrollDelta2 += currentFirstLineScrollOffset3;
            currentFirstLineScrollOffset3 = minOffset3;
        }
        int currentFirstLineScrollOffset4 = currentFirstLineScrollOffset3 - minOffset3;
        int index = currentFirstLineIndex3;
        int currentFirstLineIndex4 = currentFirstLineIndex3;
        int maxMainAxis4 = RangesKt.coerceAtLeast(mainAxisAvailableSize + afterContentPadding, 0);
        int currentMainAxisOffset4 = -currentFirstLineScrollOffset4;
        int currentMainAxisOffset5 = currentMainAxisOffset4;
        ArrayDeque $this$fastForEach$iv = visibleLines3;
        int index2 = index;
        int index3 = $this$fastForEach$iv.size();
        for (int currentFirstLineScrollOffset5 = 0; currentFirstLineScrollOffset5 < index3; currentFirstLineScrollOffset5++) {
            Object item$iv = $this$fastForEach$iv.get(currentFirstLineScrollOffset5);
            LazyGridMeasuredLine it = (LazyGridMeasuredLine) item$iv;
            index2++;
            currentMainAxisOffset5 += it.getMainAxisSizeWithSpacings();
        }
        int currentFirstLineIndex5 = currentFirstLineIndex4;
        int currentMainAxisOffset6 = currentMainAxisOffset5;
        int currentFirstLineScrollOffset6 = currentFirstLineScrollOffset4;
        int index4 = index2;
        while (true) {
            if (index4 >= itemsCount) {
                minOffset = minOffset3;
                currentFirstLineIndex = currentFirstLineIndex5;
                break;
            }
            if (currentMainAxisOffset6 >= maxMainAxis4 && currentMainAxisOffset6 > 0 && !visibleLines3.isEmpty()) {
                minOffset = minOffset3;
                currentFirstLineIndex = currentFirstLineIndex5;
                break;
            }
            currentFirstLineIndex = currentFirstLineIndex5;
            LazyGridMeasuredLine measuredLine2 = measuredLineProvider.getAndMeasure(index4);
            if (measuredLine2.isEmpty()) {
                minOffset = minOffset3;
                break;
            }
            int currentMainAxisOffset7 = currentMainAxisOffset6 + measuredLine2.getMainAxisSizeWithSpacings();
            if (currentMainAxisOffset7 > minOffset3) {
                minOffset2 = minOffset3;
                currentMainAxisOffset3 = currentMainAxisOffset7;
            } else {
                minOffset2 = minOffset3;
                currentMainAxisOffset3 = currentMainAxisOffset7;
                int currentMainAxisOffset8 = itemsCount - 1;
                if (((LazyGridMeasuredItem) ArraysKt.last(measuredLine2.getItems())).getIndex() != currentMainAxisOffset8) {
                    currentFirstLineScrollOffset6 -= measuredLine2.getMainAxisSizeWithSpacings();
                    currentFirstLineIndex = index4 + 1;
                    index4++;
                    currentFirstLineIndex5 = currentFirstLineIndex;
                    currentMainAxisOffset6 = currentMainAxisOffset3;
                    minOffset3 = minOffset2;
                }
            }
            visibleLines3.add(measuredLine2);
            index4++;
            currentFirstLineIndex5 = currentFirstLineIndex;
            currentMainAxisOffset6 = currentMainAxisOffset3;
            minOffset3 = minOffset2;
        }
        if (currentMainAxisOffset6 >= mainAxisAvailableSize) {
            maxMainAxis = maxMainAxis4;
            maxMainAxis2 = 0;
            currentMainAxisOffset = currentMainAxisOffset6;
            currentMainAxisOffset2 = currentFirstLineScrollOffset6;
            scrollDelta = scrollDelta2;
        } else {
            int toScrollBack = mainAxisAvailableSize - currentMainAxisOffset6;
            int currentFirstLineScrollOffset7 = currentFirstLineScrollOffset6 - toScrollBack;
            int currentMainAxisOffset9 = currentMainAxisOffset6 + toScrollBack;
            int currentFirstLineIndex6 = currentFirstLineIndex;
            while (true) {
                if (currentFirstLineScrollOffset7 >= beforeContentPadding) {
                    currentFirstLineIndex2 = currentFirstLineIndex6;
                    maxMainAxis = maxMainAxis4;
                    maxMainAxis2 = 0;
                    break;
                }
                if (currentFirstLineIndex6 <= 0) {
                    currentFirstLineIndex2 = currentFirstLineIndex6;
                    maxMainAxis = maxMainAxis4;
                    maxMainAxis2 = 0;
                    break;
                }
                int previousIndex = currentFirstLineIndex6 - 1;
                LazyGridMeasuredLine measuredLine3 = measuredLineProvider.getAndMeasure(previousIndex);
                visibleLines3.add(0, measuredLine3);
                currentFirstLineScrollOffset7 += measuredLine3.getMainAxisSizeWithSpacings();
                currentFirstLineIndex6 = previousIndex;
                maxMainAxis4 = maxMainAxis4;
            }
            int scrollDelta3 = scrollDelta2 + toScrollBack;
            if (currentFirstLineScrollOffset7 >= 0) {
                currentMainAxisOffset = currentMainAxisOffset9;
                currentMainAxisOffset2 = currentFirstLineScrollOffset7;
                scrollDelta = scrollDelta3;
            } else {
                currentMainAxisOffset = currentMainAxisOffset9 + currentFirstLineScrollOffset7;
                currentMainAxisOffset2 = 0;
                scrollDelta = scrollDelta3 + currentFirstLineScrollOffset7;
            }
        }
        float consumedScroll2 = (MathKt.getSign(MathKt.roundToInt(scrollToBeConsumed)) == MathKt.getSign(scrollDelta) && Math.abs(MathKt.roundToInt(scrollToBeConsumed)) >= Math.abs(scrollDelta)) ? scrollDelta : scrollToBeConsumed;
        if ((currentMainAxisOffset2 >= 0 ? 1 : maxMainAxis2) == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int visibleLinesScrollOffset2 = -currentMainAxisOffset2;
        LazyGridMeasuredLine firstLine2 = (LazyGridMeasuredLine) visibleLines3.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(firstLine2.getItems());
        int firstItemIndex2 = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : maxMainAxis2;
        LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) visibleLines3.lastOrNull();
        int lastItemIndex2 = (lazyGridMeasuredLine == null || (items = lazyGridMeasuredLine.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) ? maxMainAxis2 : lazyGridMeasuredItem.getIndex();
        ArrayList arrayList3 = null;
        List $this$fastForEach$iv$iv3 = pinnedItems;
        ArrayDeque visibleLines4 = visibleLines3;
        int size = $this$fastForEach$iv$iv3.size();
        int index$iv$iv3 = 0;
        while (index$iv$iv3 < size) {
            int i3 = size;
            List $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv3;
            Object item$iv$iv = $this$fastForEach$iv$iv4.get(index$iv$iv3);
            int index$iv = ((Number) item$iv$iv).intValue();
            int scrollDelta4 = scrollDelta;
            int it2 = (index$iv < 0 || index$iv >= firstItemIndex2) ? 0 : 1;
            if (it2 != 0) {
                long constraints$iv = measuredLineProvider.m625itemConstraintsOenEA2s(index$iv);
                firstItemIndex = firstItemIndex2;
                consumedScroll = consumedScroll2;
                visibleLinesScrollOffset = visibleLinesScrollOffset2;
                currentFirstLineScrollOffset = currentMainAxisOffset2;
                index$iv$iv2 = index$iv$iv3;
                maxMainAxis3 = maxMainAxis;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv4;
                visibleLines2 = visibleLines4;
                i2 = i3;
                LazyGridMeasuredItem measuredItem$iv = LazyGridMeasuredItemProvider.m622getAndMeasure3p2s80s$default(measuredItemProvider, index$iv, 0, constraints$iv, 2, null);
                if (arrayList3 != null) {
                    arrayList2 = arrayList3;
                } else {
                    Object items$iv = new ArrayList();
                    arrayList2 = (List) items$iv;
                }
                arrayList2.add(measuredItem$iv);
                arrayList3 = arrayList2;
            } else {
                visibleLinesScrollOffset = visibleLinesScrollOffset2;
                currentFirstLineScrollOffset = currentMainAxisOffset2;
                consumedScroll = consumedScroll2;
                firstItemIndex = firstItemIndex2;
                index$iv$iv2 = index$iv$iv3;
                maxMainAxis3 = maxMainAxis;
                visibleLines2 = visibleLines4;
                i2 = i3;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv4;
            }
            index$iv$iv3 = index$iv$iv2 + 1;
            $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
            size = i2;
            scrollDelta = scrollDelta4;
            firstItemIndex2 = firstItemIndex;
            maxMainAxis = maxMainAxis3;
            consumedScroll2 = consumedScroll;
            visibleLinesScrollOffset2 = visibleLinesScrollOffset;
            currentMainAxisOffset2 = currentFirstLineScrollOffset;
            visibleLines4 = visibleLines2;
        }
        int visibleLinesScrollOffset3 = visibleLinesScrollOffset2;
        int currentFirstLineScrollOffset8 = currentMainAxisOffset2;
        float consumedScroll3 = consumedScroll2;
        int firstItemIndex3 = firstItemIndex2;
        ArrayDeque visibleLines5 = visibleLines4;
        List extraItemsBefore = arrayList3 == null ? CollectionsKt.emptyList() : arrayList3;
        List $this$fastForEach$iv$iv5 = pinnedItems;
        int size2 = $this$fastForEach$iv$iv5.size();
        ArrayList arrayList4 = null;
        int index$iv$iv4 = 0;
        while (index$iv$iv4 < size2) {
            Object item$iv$iv2 = $this$fastForEach$iv$iv5.get(index$iv$iv4);
            int index$iv2 = ((Number) item$iv$iv2).intValue();
            int lastItemIndex3 = lastItemIndex2;
            int it3 = (lastItemIndex3 + 1 > index$iv2 || index$iv2 >= itemsCount) ? 0 : 1;
            if (it3 != 0) {
                long constraints$iv2 = measuredLineProvider.m625itemConstraintsOenEA2s(index$iv2);
                lastItemIndex = lastItemIndex3;
                index$iv$iv = index$iv$iv4;
                i = size2;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv5;
                LazyGridMeasuredItem measuredItem$iv2 = LazyGridMeasuredItemProvider.m622getAndMeasure3p2s80s$default(measuredItemProvider, index$iv2, 0, constraints$iv2, 2, null);
                if (arrayList4 != null) {
                    arrayList = arrayList4;
                } else {
                    Object items$iv2 = new ArrayList();
                    arrayList = (List) items$iv2;
                }
                arrayList.add(measuredItem$iv2);
                arrayList4 = arrayList;
            } else {
                index$iv$iv = index$iv$iv4;
                lastItemIndex = lastItemIndex3;
                i = size2;
                $this$fastForEach$iv$iv = $this$fastForEach$iv$iv5;
            }
            index$iv$iv4 = index$iv$iv + 1;
            $this$fastForEach$iv$iv5 = $this$fastForEach$iv$iv;
            size2 = i;
            lastItemIndex2 = lastItemIndex;
        }
        int lastItemIndex4 = lastItemIndex2;
        List extraItemsAfter = arrayList4 == null ? CollectionsKt.emptyList() : arrayList4;
        if (beforeContentPadding > 0 || spaceBetweenLines < 0) {
            int i4 = 0;
            int size3 = visibleLines5.size();
            int currentFirstLineScrollOffset9 = currentFirstLineScrollOffset8;
            while (true) {
                if (i4 >= size3) {
                    visibleLines = visibleLines5;
                    break;
                }
                visibleLines = visibleLines5;
                int size4 = ((LazyGridMeasuredLine) visibleLines.get(i4)).getMainAxisSizeWithSpacings();
                if (currentFirstLineScrollOffset9 == 0 || size4 > currentFirstLineScrollOffset9 || i4 == CollectionsKt.getLastIndex(visibleLines)) {
                    break;
                }
                currentFirstLineScrollOffset9 -= size4;
                firstLine2 = (LazyGridMeasuredLine) visibleLines.get(i4 + 1);
                i4++;
                visibleLines5 = visibleLines;
            }
            currentFirstLineScrollOffset8 = currentFirstLineScrollOffset9;
            firstLine = firstLine2;
        } else {
            firstLine = firstLine2;
            visibleLines = visibleLines5;
        }
        if (isVertical) {
            layoutWidth = Constraints.m5174getMaxWidthimpl(constraints);
        } else {
            layoutWidth = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, currentMainAxisOffset);
        }
        if (isVertical) {
            layoutHeight = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, currentMainAxisOffset);
        } else {
            layoutHeight = Constraints.m5173getMaxHeightimpl(constraints);
        }
        final List positionedItems = calculateItemsOffsets(visibleLines, extraItemsBefore, extraItemsAfter, layoutWidth, layoutHeight, currentMainAxisOffset, mainAxisAvailableSize, visibleLinesScrollOffset3, isVertical, verticalArrangement, horizontalArrangement, reverseLayout, density);
        int currentMainAxisOffset10 = currentMainAxisOffset;
        placementAnimator.onMeasured((int) consumedScroll3, layoutWidth, layoutHeight, positionedItems, measuredItemProvider, spanLayoutProvider, isVertical);
        boolean z = lastItemIndex4 != itemsCount + (-1) || currentMainAxisOffset10 > mainAxisAvailableSize;
        MeasureResult invoke = layout.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
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
            public final void invoke2(Placeable.PlacementScope invoke2) {
                Intrinsics.checkNotNullParameter(invoke2, "$this$invoke");
                List $this$fastForEach$iv2 = positionedItems;
                int size5 = $this$fastForEach$iv2.size();
                for (int index$iv3 = 0; index$iv3 < size5; index$iv3++) {
                    Object item$iv2 = $this$fastForEach$iv2.get(index$iv3);
                    LazyGridMeasuredItem it4 = (LazyGridMeasuredItem) item$iv2;
                    it4.place(invoke2);
                }
            }
        });
        int i5 = -beforeContentPadding;
        int index5 = mainAxisAvailableSize + afterContentPadding;
        if (extraItemsBefore.isEmpty() && extraItemsAfter.isEmpty()) {
            list = positionedItems;
        } else {
            ArrayList target$iv = new ArrayList(positionedItems.size());
            List $this$fastForEach$iv$iv6 = positionedItems;
            int size5 = $this$fastForEach$iv$iv6.size();
            int $i$f$fastFilter = 0;
            while ($i$f$fastFilter < size5) {
                LazyGridMeasuredItem lazyGridMeasuredItem3 = $this$fastForEach$iv$iv6.get($i$f$fastFilter);
                int i6 = size5;
                LazyGridMeasuredItem it4 = lazyGridMeasuredItem3;
                List $this$fastForEach$iv$iv7 = $this$fastForEach$iv$iv6;
                int index6 = it4.getIndex();
                int firstItemIndex4 = firstItemIndex3;
                if (firstItemIndex4 <= index6 && index6 <= lastItemIndex4) {
                    target$iv.add(lazyGridMeasuredItem3);
                }
                $i$f$fastFilter++;
                firstItemIndex3 = firstItemIndex4;
                size5 = i6;
                $this$fastForEach$iv$iv6 = $this$fastForEach$iv$iv7;
            }
            list = target$iv;
        }
        return new LazyGridMeasureResult(firstLine, currentFirstLineScrollOffset8, z, consumedScroll3, invoke, list, i5, index5, itemsCount, reverseLayout, isVertical ? Orientation.Vertical : Orientation.Horizontal, afterContentPadding, spaceBetweenLines);
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider measuredItemProvider, Function1<? super Integer, Constraints> function1, Function1<? super Integer, Boolean> function12) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int index = ((Number) item$iv).intValue();
            if (function12.invoke(Integer.valueOf(index)).booleanValue()) {
                long constraints = function1.invoke(Integer.valueOf(index)).getValue();
                LazyGridMeasuredItem measuredItem = LazyGridMeasuredItemProvider.m622getAndMeasure3p2s80s$default(measuredItemProvider, index, 0, constraints, 2, null);
                if (arrayList == null) {
                    Object items = new ArrayList();
                    arrayList = (List) items;
                }
                arrayList.add(measuredItem);
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int firstLineScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        ArrayList positionedItems;
        int[] offsets;
        int i;
        List<LazyGridMeasuredLine> list4 = list;
        int mainAxisLayoutSize = isVertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(firstLineScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int sum$iv = 0;
        int size = list.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object item$iv$iv = list.get(index$iv$iv);
            sum$iv += ((LazyGridMeasuredLine) item$iv$iv).getItems().length;
        }
        ArrayList positionedItems2 = new ArrayList(sum$iv);
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int linesCount = list.size();
            int[] sizes = new int[linesCount];
            for (int i2 = 0; i2 < linesCount; i2++) {
                sizes[i2] = list4.get(calculateItemsOffsets$reverseAware(i2, reverseLayout, linesCount)).getMainAxisSize();
            }
            int[] offsets2 = new int[linesCount];
            for (int i3 = 0; i3 < linesCount; i3++) {
                offsets2[i3] = 0;
            }
            if (isVertical) {
                if (verticalArrangement == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                offsets = offsets2;
            } else {
                if (horizontalArrangement == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                offsets = offsets2;
                horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets2);
            }
            IntRange reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
            if (reverseLayout) {
                reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
            }
            int index = reverseAwareOffsetIndices.getFirst();
            int last = reverseAwareOffsetIndices.getLast();
            int step = reverseAwareOffsetIndices.getStep();
            if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                while (true) {
                    int absoluteOffset = offsets[index];
                    LazyGridMeasuredLine line = list4.get(calculateItemsOffsets$reverseAware(index, reverseLayout, linesCount));
                    if (reverseLayout) {
                        i = (mainAxisLayoutSize - absoluteOffset) - line.getMainAxisSize();
                    } else {
                        i = absoluteOffset;
                    }
                    int relativeOffset = i;
                    int linesCount2 = linesCount;
                    IntProgression reverseAwareOffsetIndices2 = reverseAwareOffsetIndices;
                    CollectionsKt.addAll(positionedItems2, line.position(relativeOffset, layoutWidth, layoutHeight));
                    if (index == last) {
                        break;
                    }
                    index += step;
                    list4 = list;
                    linesCount = linesCount2;
                    reverseAwareOffsetIndices = reverseAwareOffsetIndices2;
                }
            }
            positionedItems = positionedItems2;
        } else {
            int currentMainAxis = firstLineScrollOffset;
            List $this$fastForEach$iv = list2;
            int size2 = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < size2) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                LazyGridMeasuredItem it = (LazyGridMeasuredItem) item$iv;
                int currentMainAxis2 = currentMainAxis - it.getMainAxisSizeWithSpacings();
                ArrayList positionedItems3 = positionedItems2;
                LazyGridMeasuredItem.position$default(it, currentMainAxis2, 0, layoutWidth, layoutHeight, 0, 0, 48, null);
                positionedItems3.add(it);
                index$iv++;
                positionedItems2 = positionedItems3;
                currentMainAxis = currentMainAxis2;
                size2 = size2;
                $this$fastForEach$iv = $this$fastForEach$iv;
            }
            positionedItems = positionedItems2;
            int currentMainAxis3 = firstLineScrollOffset;
            List $this$fastForEach$iv2 = list;
            int index$iv2 = 0;
            int size3 = $this$fastForEach$iv2.size();
            while (index$iv2 < size3) {
                Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
                LazyGridMeasuredLine it2 = (LazyGridMeasuredLine) item$iv2;
                CollectionsKt.addAll(positionedItems, it2.position(currentMainAxis3, layoutWidth, layoutHeight));
                currentMainAxis3 += it2.getMainAxisSizeWithSpacings();
                index$iv2++;
                $this$fastForEach$iv2 = $this$fastForEach$iv2;
            }
            List $this$fastForEach$iv3 = list3;
            int currentMainAxis4 = currentMainAxis3;
            int index$iv3 = 0;
            for (int size4 = $this$fastForEach$iv3.size(); index$iv3 < size4; size4 = size4) {
                Object item$iv3 = $this$fastForEach$iv3.get(index$iv3);
                LazyGridMeasuredItem it3 = (LazyGridMeasuredItem) item$iv3;
                LazyGridMeasuredItem.position$default(it3, currentMainAxis4, 0, layoutWidth, layoutHeight, 0, 0, 48, null);
                positionedItems.add(it3);
                currentMainAxis4 += it3.getMainAxisSizeWithSpacings();
                index$iv3++;
                $this$fastForEach$iv3 = $this$fastForEach$iv3;
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (linesCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }
}
