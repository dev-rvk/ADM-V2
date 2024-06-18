package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a@\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bH\u0002\u001a\u0017\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082\b\u001a\u008c\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002\u001am\u0010\n\u001a\u00020\u0004*\u00020\u00152\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u001aä\u0001\u00104\u001a\u000205*\u00020\u00152\u0006\u00106\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032/\u0010?\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\bB\u0012\u0004\u0012\u00020C0@H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"DEBUG", "", "createPagesAfterList", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisiblePage", "firstVisiblePageOffset", "scrollToBeConsumed", "", "constraints", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-ntgEbfI", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIFJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;

    /* renamed from: measurePager-ntgEbfI, reason: not valid java name */
    public static final PagerMeasureResult m701measurePagerntgEbfI(final LazyLayoutMeasureScope measurePager, int pageCount, final PagerLazyLayoutItemProvider pagerItemProvider, int mainAxisAvailableSize, int beforeContentPadding, int afterContentPadding, int spaceBetweenPages, int firstVisiblePage, int firstVisiblePageOffset, float scrollToBeConsumed, long constraints, final Orientation orientation, final Alignment.Vertical verticalAlignment, final Alignment.Horizontal horizontalAlignment, final boolean reverseLayout, final long visualPageOffset, final int pageAvailableSize, int beyondBoundsPageCount, List<Integer> pinnedPages, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int scrollDelta;
        int minOffset;
        int maxCrossAxis;
        int maxOffset;
        int maxOffset2;
        ArrayDeque visiblePages;
        int index;
        int maxOffset3;
        ArrayDeque visiblePages2;
        int index2;
        int minOffset2;
        int index3;
        int minOffset3;
        int scrollDelta2;
        int currentFirstPageScrollOffset;
        int currentFirstPage;
        int currentFirstPageScrollOffset2;
        MeasuredPage firstPage;
        List visiblePagesInfo;
        boolean z;
        Object maxElem$iv;
        boolean z2;
        int currentFirstPageScrollOffset3;
        int index4;
        ArrayDeque visiblePages3;
        Intrinsics.checkNotNullParameter(measurePager, "$this$measurePager");
        Intrinsics.checkNotNullParameter(pagerItemProvider, "pagerItemProvider");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(pinnedPages, "pinnedPages");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int i = 0;
        if (!(beforeContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(afterContentPadding >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int pageSizeWithSpacing = RangesKt.coerceAtLeast(pageAvailableSize + spaceBetweenPages, 0);
        if (pageCount <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), 0, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, -beforeContentPadding, mainAxisAvailableSize + afterContentPadding, false, 0.0f, null, null, 0, false, layout.invoke(Integer.valueOf(Constraints.m5176getMinWidthimpl(constraints)), Integer.valueOf(Constraints.m5175getMinHeightimpl(constraints)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }
            }));
        }
        final long childConstraints = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.m5174getMaxWidthimpl(constraints) : pageAvailableSize, 0, orientation != Orientation.Vertical ? Constraints.m5173getMaxHeightimpl(constraints) : pageAvailableSize, 5, null);
        int currentFirstPage2 = firstVisiblePage;
        int currentFirstPageScrollOffset4 = firstVisiblePageOffset;
        if (currentFirstPage2 >= pageCount) {
            currentFirstPage2 = pageCount - 1;
            currentFirstPageScrollOffset4 = 0;
        }
        int scrollDelta3 = MathKt.roundToInt(scrollToBeConsumed);
        int currentFirstPageScrollOffset5 = currentFirstPageScrollOffset4 - scrollDelta3;
        if (currentFirstPage2 != 0 || currentFirstPageScrollOffset5 >= 0) {
            scrollDelta = scrollDelta3;
        } else {
            int scrollDelta4 = scrollDelta3 + currentFirstPageScrollOffset5;
            currentFirstPageScrollOffset5 = 0;
            scrollDelta = scrollDelta4;
        }
        ArrayDeque visiblePages4 = new ArrayDeque();
        int currentFirstPageScrollOffset6 = (-beforeContentPadding) + (spaceBetweenPages < 0 ? spaceBetweenPages : 0);
        int maxOffset4 = mainAxisAvailableSize;
        int maxCrossAxis2 = currentFirstPageScrollOffset5 + currentFirstPageScrollOffset6;
        int currentFirstPage3 = currentFirstPage2;
        int currentFirstPage4 = 0;
        while (maxCrossAxis2 < 0 && currentFirstPage3 > 0) {
            int previous = currentFirstPage3 - 1;
            int maxCrossAxis3 = currentFirstPage4;
            int currentFirstPageScrollOffset7 = maxCrossAxis2;
            ArrayDeque visiblePages5 = visiblePages4;
            int currentFirstPageScrollOffset8 = i;
            MeasuredPage measuredPage = m700getAndMeasureSGf7dI0(measurePager, previous, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, measurePager.getLayoutDirection(), reverseLayout, pageAvailableSize);
            visiblePages5.add(currentFirstPageScrollOffset8, measuredPage);
            currentFirstPage3 = previous;
            currentFirstPage4 = Math.max(maxCrossAxis3, measuredPage.getCrossAxisSize());
            maxCrossAxis2 = currentFirstPageScrollOffset7 + pageSizeWithSpacing;
            i = currentFirstPageScrollOffset8;
            visiblePages4 = visiblePages5;
            currentFirstPageScrollOffset6 = currentFirstPageScrollOffset6;
            maxOffset4 = maxOffset4;
        }
        int maxCrossAxis4 = currentFirstPage4;
        int currentFirstPageScrollOffset9 = maxCrossAxis2;
        int maxOffset5 = maxOffset4;
        ArrayDeque visiblePages6 = visiblePages4;
        int i2 = i;
        int minOffset4 = currentFirstPageScrollOffset6;
        int currentFirstPageScrollOffset10 = currentFirstPageScrollOffset9;
        if (currentFirstPageScrollOffset10 < minOffset4) {
            scrollDelta += currentFirstPageScrollOffset10;
            currentFirstPageScrollOffset10 = minOffset4;
        }
        int currentFirstPageScrollOffset11 = currentFirstPageScrollOffset10 - minOffset4;
        int index5 = currentFirstPage3;
        int index6 = maxOffset5;
        int maxMainAxis = RangesKt.coerceAtLeast(index6 + afterContentPadding, i2);
        int currentMainAxisOffset = -currentFirstPageScrollOffset11;
        ArrayDeque $this$fastForEach$iv = visiblePages6;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            index5++;
            currentMainAxisOffset += pageSizeWithSpacing;
        }
        int currentMainAxisOffset2 = currentMainAxisOffset;
        int maxCrossAxis5 = maxCrossAxis4;
        int currentFirstPage5 = currentFirstPage3;
        int maxCrossAxis6 = index5;
        int currentFirstPageScrollOffset12 = currentFirstPageScrollOffset11;
        while (true) {
            int minOffset5 = minOffset4;
            if (maxCrossAxis6 >= pageCount) {
                minOffset = minOffset5;
                maxCrossAxis = maxCrossAxis5;
                maxOffset = index6;
                maxOffset2 = maxCrossAxis6;
                visiblePages = visiblePages6;
                index = currentMainAxisOffset2;
                break;
            }
            if (currentMainAxisOffset2 >= maxMainAxis && currentMainAxisOffset2 > 0 && !visiblePages6.isEmpty()) {
                minOffset = minOffset5;
                maxCrossAxis = maxCrossAxis5;
                maxOffset = index6;
                maxOffset2 = maxCrossAxis6;
                visiblePages = visiblePages6;
                index = currentMainAxisOffset2;
                break;
            }
            int i3 = maxCrossAxis6;
            ArrayDeque visiblePages7 = visiblePages6;
            int index7 = maxCrossAxis6;
            int index8 = currentMainAxisOffset2;
            int maxCrossAxis7 = maxCrossAxis5;
            int maxMainAxis2 = maxMainAxis;
            int maxOffset6 = index6;
            MeasuredPage measuredPage2 = m700getAndMeasureSGf7dI0(measurePager, i3, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, measurePager.getLayoutDirection(), reverseLayout, pageAvailableSize);
            currentMainAxisOffset2 = index8 + pageSizeWithSpacing;
            if (currentMainAxisOffset2 <= minOffset5) {
                index4 = index7;
                if (index4 != pageCount - 1) {
                    currentFirstPageScrollOffset12 -= pageSizeWithSpacing;
                    currentFirstPage5 = index4 + 1;
                    visiblePages3 = visiblePages7;
                    maxCrossAxis5 = maxCrossAxis7;
                    maxCrossAxis6 = index4 + 1;
                    visiblePages6 = visiblePages3;
                    minOffset4 = minOffset5;
                    maxMainAxis = maxMainAxis2;
                    index6 = maxOffset6;
                }
            } else {
                index4 = index7;
            }
            int maxCrossAxis8 = Math.max(maxCrossAxis7, measuredPage2.getCrossAxisSize());
            visiblePages3 = visiblePages7;
            visiblePages3.add(measuredPage2);
            maxCrossAxis5 = maxCrossAxis8;
            maxCrossAxis6 = index4 + 1;
            visiblePages6 = visiblePages3;
            minOffset4 = minOffset5;
            maxMainAxis = maxMainAxis2;
            index6 = maxOffset6;
        }
        int maxOffset7 = maxOffset;
        if (index < maxOffset7) {
            int toScrollBack = maxOffset7 - index;
            index += toScrollBack;
            int maxCrossAxis9 = maxCrossAxis;
            int currentFirstPageScrollOffset13 = currentFirstPageScrollOffset12 - toScrollBack;
            while (true) {
                if (currentFirstPageScrollOffset13 >= beforeContentPadding) {
                    currentFirstPageScrollOffset3 = currentFirstPageScrollOffset13;
                    maxOffset3 = maxOffset7;
                    visiblePages2 = visiblePages;
                    index2 = maxOffset2;
                    minOffset2 = minOffset;
                    index3 = 0;
                    minOffset3 = maxCrossAxis9;
                    break;
                }
                if (currentFirstPage5 <= 0) {
                    currentFirstPageScrollOffset3 = currentFirstPageScrollOffset13;
                    maxOffset3 = maxOffset7;
                    visiblePages2 = visiblePages;
                    index2 = maxOffset2;
                    minOffset2 = minOffset;
                    index3 = 0;
                    minOffset3 = maxCrossAxis9;
                    break;
                }
                int previousIndex = currentFirstPage5 - 1;
                ArrayDeque visiblePages8 = visiblePages;
                int index9 = maxOffset2;
                MeasuredPage measuredPage3 = m700getAndMeasureSGf7dI0(measurePager, previousIndex, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, measurePager.getLayoutDirection(), reverseLayout, pageAvailableSize);
                visiblePages8.add(0, measuredPage3);
                maxCrossAxis9 = Math.max(maxCrossAxis9, measuredPage3.getCrossAxisSize());
                currentFirstPageScrollOffset13 += pageSizeWithSpacing;
                currentFirstPage5 = previousIndex;
                visiblePages = visiblePages8;
                minOffset = minOffset;
                maxOffset7 = maxOffset7;
                maxOffset2 = index9;
            }
            int scrollDelta5 = scrollDelta + toScrollBack;
            if (currentFirstPageScrollOffset3 < 0) {
                int currentMainAxisOffset3 = index + currentFirstPageScrollOffset3;
                index = currentMainAxisOffset3;
                scrollDelta2 = scrollDelta5 + currentFirstPageScrollOffset3;
                currentFirstPageScrollOffset = 0;
                currentFirstPage = currentFirstPage5;
            } else {
                scrollDelta2 = scrollDelta5;
                currentFirstPage = currentFirstPage5;
                currentFirstPageScrollOffset = currentFirstPageScrollOffset3;
            }
        } else {
            maxOffset3 = maxOffset7;
            visiblePages2 = visiblePages;
            index2 = maxOffset2;
            minOffset2 = minOffset;
            index3 = 0;
            minOffset3 = maxCrossAxis;
            scrollDelta2 = scrollDelta;
            currentFirstPageScrollOffset = currentFirstPageScrollOffset12;
            currentFirstPage = currentFirstPage5;
        }
        float consumedScroll = (MathKt.getSign(MathKt.roundToInt(scrollToBeConsumed)) != MathKt.getSign(scrollDelta2) || Math.abs(MathKt.roundToInt(scrollToBeConsumed)) < Math.abs(scrollDelta2)) ? scrollToBeConsumed : scrollDelta2;
        if ((currentFirstPageScrollOffset >= 0 ? 1 : index3) == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int visiblePagesScrollOffset = -currentFirstPageScrollOffset;
        MeasuredPage firstPage2 = (MeasuredPage) visiblePages2.first();
        if (beforeContentPadding > 0 || spaceBetweenPages < 0) {
            int size2 = visiblePages2.size();
            for (int i4 = 0; i4 < size2 && currentFirstPageScrollOffset != 0 && pageSizeWithSpacing <= currentFirstPageScrollOffset && i4 != CollectionsKt.getLastIndex(visiblePages2); i4++) {
                currentFirstPageScrollOffset -= pageSizeWithSpacing;
                firstPage2 = (MeasuredPage) visiblePages2.get(i4 + 1);
            }
            currentFirstPageScrollOffset2 = currentFirstPageScrollOffset;
            firstPage = firstPage2;
        } else {
            currentFirstPageScrollOffset2 = currentFirstPageScrollOffset;
            firstPage = firstPage2;
        }
        int maxCrossAxis10 = minOffset3;
        MeasuredPage firstPage3 = firstPage;
        List extraPagesBefore = createPagesBeforeList(currentFirstPage, beyondBoundsPageCount, pinnedPages, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                MeasuredPage m700getAndMeasureSGf7dI0;
                m700getAndMeasureSGf7dI0 = PagerMeasureKt.m700getAndMeasureSGf7dI0(LazyLayoutMeasureScope.this, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, LazyLayoutMeasureScope.this.getLayoutDirection(), reverseLayout, pageAvailableSize);
                return m700getAndMeasureSGf7dI0;
            }
        });
        int size3 = extraPagesBefore.size();
        int maxCrossAxis11 = maxCrossAxis10;
        for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
            Object item$iv2 = extraPagesBefore.get(index$iv2);
            maxCrossAxis11 = Math.max(maxCrossAxis11, ((MeasuredPage) item$iv2).getCrossAxisSize());
        }
        ArrayDeque visiblePages9 = visiblePages2;
        int currentMainAxisOffset4 = index;
        List extraPagesAfter = createPagesAfterList(((MeasuredPage) visiblePages2.last()).getIndex(), pageCount, beyondBoundsPageCount, pinnedPages, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int it) {
                MeasuredPage m700getAndMeasureSGf7dI0;
                m700getAndMeasureSGf7dI0 = PagerMeasureKt.m700getAndMeasureSGf7dI0(LazyLayoutMeasureScope.this, it, childConstraints, pagerItemProvider, visualPageOffset, orientation, horizontalAlignment, verticalAlignment, LazyLayoutMeasureScope.this.getLayoutDirection(), reverseLayout, pageAvailableSize);
                return m700getAndMeasureSGf7dI0;
            }
        });
        int size4 = extraPagesAfter.size();
        int maxCrossAxis12 = maxCrossAxis11;
        for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
            Object item$iv3 = extraPagesAfter.get(index$iv3);
            maxCrossAxis12 = Math.max(maxCrossAxis12, ((MeasuredPage) item$iv3).getCrossAxisSize());
        }
        boolean noExtraPages = Intrinsics.areEqual(firstPage3, visiblePages9.first()) && extraPagesBefore.isEmpty() && extraPagesAfter.isEmpty();
        int layoutWidth = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, orientation == Orientation.Vertical ? maxCrossAxis12 : currentMainAxisOffset4);
        int layoutHeight = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, orientation == Orientation.Vertical ? currentMainAxisOffset4 : maxCrossAxis12);
        final List positionedPages = calculatePagesOffsets(measurePager, visiblePages9, extraPagesBefore, extraPagesAfter, layoutWidth, layoutHeight, currentMainAxisOffset4, maxOffset3, visiblePagesScrollOffset, orientation, reverseLayout, measurePager, spaceBetweenPages, pageAvailableSize);
        if (noExtraPages) {
            visiblePagesInfo = positionedPages;
        } else {
            List $this$fastFilter$iv = positionedPages;
            ArrayList target$iv = new ArrayList($this$fastFilter$iv.size());
            int index$iv$iv = 0;
            int size5 = $this$fastFilter$iv.size();
            while (index$iv$iv < size5) {
                MeasuredPage measuredPage4 = $this$fastFilter$iv.get(index$iv$iv);
                MeasuredPage it = measuredPage4;
                List $this$fastFilter$iv2 = $this$fastFilter$iv;
                if (it.getIndex() >= ((MeasuredPage) visiblePages9.first()).getIndex() && it.getIndex() <= ((MeasuredPage) visiblePages9.last()).getIndex()) {
                    target$iv.add(measuredPage4);
                }
                index$iv$iv++;
                $this$fastFilter$iv = $this$fastFilter$iv2;
            }
            visiblePagesInfo = target$iv;
        }
        int viewPortSize = orientation == Orientation.Vertical ? layoutHeight : layoutWidth;
        List $this$fastMaxBy$iv = visiblePagesInfo;
        if ($this$fastMaxBy$iv.isEmpty()) {
            maxElem$iv = null;
            z = false;
        } else {
            z = false;
            maxElem$iv = $this$fastMaxBy$iv.get(0);
            MeasuredPage it2 = (MeasuredPage) maxElem$iv;
            float maxValue$iv = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(measurePager, viewPortSize, beforeContentPadding, afterContentPadding, pageAvailableSize, it2.getOffset(), it2.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Object e$iv = $this$fastMaxBy$iv.get(i$iv);
                    MeasuredPage it3 = (MeasuredPage) e$iv;
                    float v$iv = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(measurePager, viewPortSize, beforeContentPadding, afterContentPadding, pageAvailableSize, it3.getOffset(), it3.getIndex(), PagerStateKt.getSnapAlignmentStartToStart()));
                    if (Float.compare(maxValue$iv, v$iv) < 0) {
                        maxValue$iv = v$iv;
                        maxElem$iv = e$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        MeasuredPage closestPageToSnapPosition = (MeasuredPage) maxElem$iv;
        MeasureResult invoke = layout.invoke(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$6
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
                List $this$fastForEach$iv2 = positionedPages;
                int size6 = $this$fastForEach$iv2.size();
                for (int index$iv4 = 0; index$iv4 < size6; index$iv4++) {
                    Object item$iv4 = $this$fastForEach$iv2.get(index$iv4);
                    MeasuredPage it4 = (MeasuredPage) item$iv4;
                    it4.place(invoke2);
                }
            }
        });
        int i5 = -beforeContentPadding;
        int maxOffset8 = maxOffset3;
        int i6 = maxOffset8 + afterContentPadding;
        if (index2 >= pageCount && currentMainAxisOffset4 <= maxOffset8) {
            z2 = z;
            return new PagerMeasureResult(visiblePagesInfo, pageCount, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, i5, i6, reverseLayout, consumedScroll, firstPage3, closestPageToSnapPosition, currentFirstPageScrollOffset2, z2, invoke);
        }
        z2 = true;
        return new PagerMeasureResult(visiblePagesInfo, pageCount, pageAvailableSize, spaceBetweenPages, afterContentPadding, orientation, i5, i6, reverseLayout, consumedScroll, firstPage3, closestPageToSnapPosition, currentFirstPageScrollOffset2, z2, invoke);
    }

    private static final List<MeasuredPage> createPagesAfterList(int currentLastPage, int pagesCount, int beyondBoundsPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int end = Math.min(currentLastPage + beyondBoundsPageCount, pagesCount - 1);
        int i = currentLastPage + 1;
        if (i <= end) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == end) {
                    break;
                }
                i++;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            boolean z = false;
            if (end + 1 <= pageIndex && pageIndex < pagesCount) {
                z = true;
            }
            if (z) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int currentFirstPage, int beyondBoundsPageCount, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        ArrayList arrayList = null;
        int start = Math.max(0, currentFirstPage - beyondBoundsPageCount);
        int i = currentFirstPage - 1;
        if (start <= i) {
            while (true) {
                if (arrayList == null) {
                    Object list2 = new ArrayList();
                    arrayList = (List) list2;
                }
                arrayList.add(function1.invoke(Integer.valueOf(i)));
                if (i == start) {
                    break;
                }
                i--;
            }
        }
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            int pageIndex = ((Number) item$iv).intValue();
            if (pageIndex < start) {
                if (arrayList == null) {
                    Object list3 = new ArrayList();
                    arrayList = (List) list3;
                }
                arrayList.add(function1.invoke(Integer.valueOf(pageIndex)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m700getAndMeasureSGf7dI0(LazyLayoutMeasureScope $this$getAndMeasure_u2dSGf7dI0, int index, long childConstraints, PagerLazyLayoutItemProvider pagerItemProvider, long visualPageOffset, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int pageAvailableSize) {
        Object key = pagerItemProvider.getKey(index);
        List placeable = $this$getAndMeasure_u2dSGf7dI0.mo642measure0kLqBqw(index, childConstraints);
        return new MeasuredPage(index, pageAvailableSize, placeable, visualPageOffset, key, orientation, horizontalAlignment, verticalAlignment, layoutDirection, reverseLayout, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope $this$calculatePagesOffsets, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int pagesScrollOffset, Orientation orientation, boolean reverseLayout, Density density, int spaceBetweenPages, int pageAvailableSize) {
        ArrayList positionedPages;
        int[] offsets;
        int pagesCount;
        int i;
        int pageSizeWithSpacing = pageAvailableSize + spaceBetweenPages;
        int mainAxisLayoutSize = orientation == Orientation.Vertical ? layoutHeight : layoutWidth;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(pagesScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList positionedPages2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (hasSpareSpace) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int pagesCount2 = list.size();
            int[] sizes = new int[pagesCount2];
            for (int i2 = 0; i2 < pagesCount2; i2++) {
                sizes[i2] = pageAvailableSize;
            }
            int[] offsets2 = new int[pagesCount2];
            for (int i3 = 0; i3 < pagesCount2; i3++) {
                offsets2[i3] = 0;
            }
            Arrangement.HorizontalOrVertical arrangement = Arrangement.Absolute.INSTANCE.m398spacedBy0680j_4($this$calculatePagesOffsets.mo326toDpu2uoSUM(pageAvailableSize));
            if (orientation != Orientation.Vertical) {
                offsets = offsets2;
                pagesCount = pagesCount2;
                positionedPages = positionedPages2;
                arrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
            } else {
                arrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                offsets = offsets2;
                positionedPages = positionedPages2;
                pagesCount = pagesCount2;
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
                    int pagesCount3 = pagesCount;
                    MeasuredPage page = list.get(calculatePagesOffsets$reverseAware(index, reverseLayout, pagesCount));
                    if (reverseLayout) {
                        i = (mainAxisLayoutSize - absoluteOffset) - page.getSize();
                    } else {
                        i = absoluteOffset;
                    }
                    int relativeOffset = i;
                    page.position(relativeOffset, layoutWidth, layoutHeight);
                    positionedPages.add(page);
                    if (index == last) {
                        break;
                    }
                    index += step;
                    pagesCount = pagesCount3;
                }
            }
        } else {
            positionedPages = positionedPages2;
            int currentMainAxis = pagesScrollOffset;
            int size = list2.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = list2.get(index$iv);
                MeasuredPage it = (MeasuredPage) item$iv;
                currentMainAxis -= pageSizeWithSpacing;
                it.position(currentMainAxis, layoutWidth, layoutHeight);
                positionedPages.add(it);
            }
            int currentMainAxis2 = pagesScrollOffset;
            int size2 = list.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = list.get(index$iv2);
                MeasuredPage it2 = (MeasuredPage) item$iv2;
                it2.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it2);
                currentMainAxis2 += pageSizeWithSpacing;
            }
            int size3 = list3.size();
            for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                Object item$iv3 = list3.get(index$iv3);
                MeasuredPage it3 = (MeasuredPage) item$iv3;
                it3.position(currentMainAxis2, layoutWidth, layoutHeight);
                positionedPages.add(it3);
                currentMainAxis2 += pageSizeWithSpacing;
            }
        }
        return positionedPages;
    }

    private static final int calculatePagesOffsets$reverseAware(int $this$calculatePagesOffsets_u24reverseAware, boolean $reverseLayout, int pagesCount) {
        return !$reverseLayout ? $this$calculatePagesOffsets_u24reverseAware : (pagesCount - $this$calculatePagesOffsets_u24reverseAware) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
