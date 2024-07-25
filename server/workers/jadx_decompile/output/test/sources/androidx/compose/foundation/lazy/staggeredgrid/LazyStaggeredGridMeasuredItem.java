package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u001e\u0010>\u001a\u0002092\u0006\u00103\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\b\u0010@\u001a\u00020AH\u0016J.\u0010B\u001a\u00020&*\u00020&2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030DH\u0082\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001a\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@RX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u001f\u0010-\u001a\u00020.X\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b/\u0010)R\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0016R\u001b\u00103\u001a\u00020\u0003*\u00020&8BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b4\u00105R\u0019\u0010!\u001a\u00020\u0003*\u00020\b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u00106\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "()I", "crossAxisSize", "getCrossAxisSize", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "maxMainAxisOffset", "minMainAxisOffset", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "sizeWithSpacings", "getSizeWithSpacings", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int sizeWithSpacings;
    private final int span;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridMeasuredItem(int index, Object key, List<? extends Placeable> placeables, boolean isVertical, int spacing, int lane, int span, int beforeContentPadding, int afterContentPadding, Object contentType) {
        Integer valueOf;
        Integer valueOf2;
        long IntSize;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        this.index = index;
        this.key = key;
        this.placeables = placeables;
        this.isVertical = isVertical;
        this.lane = lane;
        this.span = span;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.contentType = contentType;
        this.isVisible = true;
        List $this$fastMaxOfOrNull$iv = this.placeables;
        if ($this$fastMaxOfOrNull$iv.isEmpty()) {
            valueOf = null;
        } else {
            Placeable placeable = $this$fastMaxOfOrNull$iv.get(0);
            valueOf = Integer.valueOf(this.isVertical ? placeable.getHeight() : placeable.getWidth());
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Placeable placeable2 = $this$fastMaxOfOrNull$iv.get(i$iv);
                    Integer valueOf3 = Integer.valueOf(this.isVertical ? placeable2.getHeight() : placeable2.getWidth());
                    valueOf = valueOf3.compareTo(valueOf) > 0 ? valueOf3 : valueOf;
                    if (i$iv == lastIndex) {
                        break;
                    } else {
                        i$iv++;
                    }
                }
            }
        }
        Integer num = valueOf;
        this.mainAxisSize = num != null ? num.intValue() : 0;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(this.mainAxisSize + spacing, 0);
        List $this$fastMaxOfOrNull$iv2 = this.placeables;
        if ($this$fastMaxOfOrNull$iv2.isEmpty()) {
            valueOf2 = null;
        } else {
            Placeable it = $this$fastMaxOfOrNull$iv2.get(0);
            valueOf2 = Integer.valueOf(this.isVertical ? it.getWidth() : it.getHeight());
            int i$iv2 = 1;
            int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable it2 = $this$fastMaxOfOrNull$iv2.get(i$iv2);
                    Integer valueOf4 = Integer.valueOf(this.isVertical ? it2.getWidth() : it2.getHeight());
                    valueOf2 = valueOf4.compareTo(valueOf2) > 0 ? valueOf4 : valueOf2;
                    if (i$iv2 == lastIndex2) {
                        break;
                    } else {
                        i$iv2++;
                    }
                }
            }
        }
        Integer num2 = valueOf2;
        this.crossAxisSize = num2 != null ? num2.intValue() : 0;
        this.mainAxisLayoutSize = -1;
        if (this.isVertical) {
            IntSize = IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize);
        } else {
            IntSize = IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize);
        }
        this.size = IntSize;
        this.offset = IntOffset.INSTANCE.m5346getZeronOccac();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getKey() {
        return this.key;
    }

    /* renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    /* renamed from: isVisible, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getSize-YbymL2g, reason: from getter */
    public long getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* renamed from: getOffset-nOcc-ac, reason: from getter */
    public long getOffset() {
        return this.offset;
    }

    public final void position(int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        long IntOffset;
        this.mainAxisLayoutSize = mainAxisLayoutSize;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.afterContentPadding + mainAxisLayoutSize;
        if (this.isVertical) {
            IntOffset = IntOffsetKt.IntOffset(crossAxis, mainAxis);
        } else {
            IntOffset = IntOffsetKt.IntOffset(mainAxis, crossAxis);
        }
        this.offset = IntOffset;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m5336getXimpl(getOffset()) : IntOffset.m5337getYimpl(getOffset());
    }

    public final void place(Placeable.PlacementScope scope, LazyStaggeredGridMeasureContext context) {
        int i;
        int maxOffset;
        int minOffset;
        int height;
        int m5337getYimpl;
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = this;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(lazyStaggeredGridMeasuredItem.mainAxisLayoutSize != -1)) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        List $this$fastForEachIndexed$iv = lazyStaggeredGridMeasuredItem.placeables;
        int index$iv = 0;
        for (int size = $this$fastForEachIndexed$iv.size(); index$iv < size; size = i) {
            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            int minOffset2 = lazyStaggeredGridMeasuredItem.minMainAxisOffset - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
            int maxOffset2 = lazyStaggeredGridMeasuredItem.maxMainAxisOffset;
            long offset = getOffset();
            int index$iv2 = index$iv;
            Object parentData = lazyStaggeredGridMeasuredItem.getParentData(index);
            LazyLayoutAnimateItemModifierNode animateNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (animateNode != null) {
                long other$iv = animateNode.m629getPlacementDeltanOccac();
                i = size;
                long animatedOffset = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(offset) + IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(offset) + IntOffset.m5337getYimpl(other$iv));
                if ((lazyStaggeredGridMeasuredItem.m674getMainAxisgyyYBs(offset) <= minOffset2 && lazyStaggeredGridMeasuredItem.m674getMainAxisgyyYBs(animatedOffset) <= minOffset2) || (lazyStaggeredGridMeasuredItem.m674getMainAxisgyyYBs(offset) >= maxOffset2 && lazyStaggeredGridMeasuredItem.m674getMainAxisgyyYBs(animatedOffset) >= maxOffset2)) {
                    animateNode.cancelAnimation();
                }
                offset = animatedOffset;
            } else {
                i = size;
            }
            if (context.getReverseLayout()) {
                long $this$copy_u2d4Tuh3kE$iv = offset;
                maxOffset = maxOffset2;
                if (this.isVertical) {
                    height = IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE$iv);
                    minOffset = minOffset2;
                } else {
                    int mainAxisOffset = IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE$iv);
                    minOffset = minOffset2;
                    height = (lazyStaggeredGridMeasuredItem.mainAxisLayoutSize - mainAxisOffset) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                }
                if (this.isVertical) {
                    int mainAxisOffset2 = IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE$iv);
                    m5337getYimpl = (lazyStaggeredGridMeasuredItem.mainAxisLayoutSize - mainAxisOffset2) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                } else {
                    m5337getYimpl = IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE$iv);
                }
                offset = IntOffsetKt.IntOffset(height, m5337getYimpl);
            } else {
                maxOffset = maxOffset2;
                minOffset = minOffset2;
            }
            long other$iv2 = context.getContentOffset();
            Placeable.PlacementScope.m4245placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(offset) + IntOffset.m5336getXimpl(other$iv2), IntOffset.m5337getYimpl(offset) + IntOffset.m5337getYimpl(other$iv2)), 0.0f, null, 6, null);
            index$iv = index$iv2 + 1;
            lazyStaggeredGridMeasuredItem = this;
        }
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m674getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m5337getYimpl($this$mainAxis) : IntOffset.m5336getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m673copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> function1) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE) : function1.invoke(Integer.valueOf(IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? function1.invoke(Integer.valueOf(IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE));
    }

    public String toString() {
        return super.toString();
    }
}
