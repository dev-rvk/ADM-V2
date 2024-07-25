package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyGridAnimateScrollScope.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001fJ:\u0010 \u001a\u00020!2'\u0010\"\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0%\u0012\u0006\u0012\u0004\u0018\u00010&0#¢\u0006\u0002\b'H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\u00020!*\u00020$2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "numOfItemsForTeleport", "getNumOfItemsForTeleport", "calculateLineAverageMainAxisSize", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "isVertical", "", "expectedDistanceTo", "", "index", "targetScrollOffset", "getTargetItemOffset", "(I)Ljava/lang/Integer;", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyGridAnimateScrollScope implements LazyAnimateScrollScope {
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Density getDensity() {
        return this.state.getDensity();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull((List) this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Integer getTargetItemOffset(int index) {
        Object it$iv;
        int m5336getXimpl;
        List $this$fastFirstOrNull$iv = this.state.getLayoutInfo().getVisibleItemsInfo();
        int index$iv$iv = 0;
        int size = $this$fastFirstOrNull$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                it$iv = item$iv$iv;
                LazyGridItemInfo it = (LazyGridItemInfo) it$iv;
                if (it.getIndex() == index) {
                    break;
                }
                index$iv$iv++;
            } else {
                it$iv = null;
                break;
            }
        }
        LazyGridItemInfo item = (LazyGridItemInfo) it$iv;
        if (item == null) {
            return null;
        }
        if (this.state.getIsVertical()) {
            m5336getXimpl = IntOffset.m5337getYimpl(item.getOffset());
        } else {
            m5336getXimpl = IntOffset.m5336getXimpl(item.getOffset());
        }
        return Integer.valueOf(m5336getXimpl);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public void snapToItem(ScrollScope $this$snapToItem, int index, int scrollOffset) {
        Intrinsics.checkNotNullParameter($this$snapToItem, "<this>");
        this.state.snapToItemIndexInternal$foundation_release(index, scrollOffset);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public float expectedDistanceTo(int index, int targetScrollOffset) {
        int slotsPerLine = this.state.getSlotsPerLine$foundation_release();
        int averageLineMainAxisSize = calculateLineAverageMainAxisSize(this.state.getLayoutInfo(), this.state.getIsVertical());
        boolean before = index < getFirstVisibleItemIndex();
        int linesDiff = ((index - getFirstVisibleItemIndex()) + ((slotsPerLine - 1) * (before ? -1 : 1))) / slotsPerLine;
        int coercedOffset = Math.min(Math.abs(targetScrollOffset), averageLineMainAxisSize);
        if (targetScrollOffset < 0) {
            coercedOffset *= -1;
        }
        return ((averageLineMainAxisSize * linesDiff) + coercedOffset) - getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public int getNumOfItemsForTeleport() {
        return this.state.getSlotsPerLine$foundation_release() * 100;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo layoutInfo, final boolean isVertical) {
        int m5378getWidthimpl;
        final List visibleItems = layoutInfo.getVisibleItemsInfo();
        Function1 lineOf = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Integer invoke(int it) {
                return Integer.valueOf(isVertical ? visibleItems.get(it).getRow() : visibleItems.get(it).getColumn());
            }
        };
        int totalLinesMainAxisSize = 0;
        int linesCount = 0;
        int lineStartIndex = 0;
        while (lineStartIndex < visibleItems.size()) {
            int currentLine = lineOf.invoke(Integer.valueOf(lineStartIndex)).intValue();
            if (currentLine == -1) {
                lineStartIndex++;
            } else {
                int lineMainAxisSize = 0;
                int lineEndIndex = lineStartIndex;
                while (lineEndIndex < visibleItems.size() && lineOf.invoke(Integer.valueOf(lineEndIndex)).intValue() == currentLine) {
                    if (isVertical) {
                        m5378getWidthimpl = IntSize.m5377getHeightimpl(visibleItems.get(lineEndIndex).getSize());
                    } else {
                        m5378getWidthimpl = IntSize.m5378getWidthimpl(visibleItems.get(lineEndIndex).getSize());
                    }
                    lineMainAxisSize = Math.max(lineMainAxisSize, m5378getWidthimpl);
                    lineEndIndex++;
                }
                totalLinesMainAxisSize += lineMainAxisSize;
                linesCount++;
                lineStartIndex = lineEndIndex;
            }
        }
        return (totalLinesMainAxisSize / linesCount) + layoutInfo.getMainAxisItemSpacing();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.scroll$default(this.state, null, function2, continuation, 1, null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }
}
