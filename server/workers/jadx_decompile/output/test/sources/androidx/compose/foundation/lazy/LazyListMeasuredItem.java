package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LazyListMeasuredItem.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B~\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010&\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u00020:2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003J.\u0010@\u001a\u00020\u0014*\u00020\u00142\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030BH\u0082\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001fR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\u00020\u0014X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010/R\u001b\u00100\u001a\u00020\u0003*\u00020\u00148BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b1\u00102R\u0018\u00103\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "maxMainAxisOffset", "minMainAxisOffset", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyListMeasuredItem(int index, List<? extends Placeable> placeables, boolean isVertical, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout, int beforeContentPadding, int afterContentPadding, int spacing, long visualOffset, Object key, Object contentType) {
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(key, "key");
        this.index = index;
        this.placeables = placeables;
        this.isVertical = isVertical;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = reverseLayout;
        this.beforeContentPadding = beforeContentPadding;
        this.afterContentPadding = afterContentPadding;
        this.spacing = spacing;
        this.visualOffset = visualOffset;
        this.key = key;
        this.contentType = contentType;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int mainAxisSize = 0;
        List $this$fastForEach$iv = this.placeables;
        int size = $this$fastForEach$iv.size();
        int maxCrossAxis = 0;
        int index$iv = 0;
        while (index$iv < size) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Placeable it = (Placeable) item$iv;
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            mainAxisSize += this.isVertical ? it.getHeight() : it.getWidth();
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
        }
        this.size = mainAxisSize;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = maxCrossAxis;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    /* renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int index) {
        return this.placeables.get(index).getParentData();
    }

    public final void position(int offset, int layoutWidth, int layoutHeight) {
        this.offset = offset;
        this.mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        int mainAxisOffset = offset;
        List $this$fastForEachIndexed$iv = this.placeables;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            int indexInArray = index * 2;
            if (!this.isVertical) {
                this.placeableOffsets[indexInArray] = mainAxisOffset;
                int[] iArr = this.placeableOffsets;
                int i = indexInArray + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr[i] = vertical.align(placeable.getHeight(), layoutHeight);
                mainAxisOffset += placeable.getWidth();
            } else {
                int[] iArr2 = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr2[indexInArray] = horizontal.align(placeable.getWidth(), layoutWidth, this.layoutDirection);
                this.placeableOffsets[indexInArray + 1] = mainAxisOffset;
                mainAxisOffset += placeable.getHeight();
            }
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m594getOffsetBjo55l4(int index) {
        return IntOffsetKt.IntOffset(this.placeableOffsets[index * 2], this.placeableOffsets[(index * 2) + 1]);
    }

    public final void place(Placeable.PlacementScope scope) {
        int i;
        int mainAxisOffset;
        int m5337getYimpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        int i2 = 0;
        if (!(this.mainAxisLayoutSize != Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        int placeablesCount = getPlaceablesCount();
        int i3 = 0;
        while (i3 < placeablesCount) {
            int index = i3;
            Placeable placeable = this.placeables.get(index);
            int minOffset = this.minMainAxisOffset - getMainAxisSize(placeable);
            int maxOffset = this.maxMainAxisOffset;
            long offset = m594getOffsetBjo55l4(index);
            Object parentData = getParentData(index);
            LazyLayoutAnimateItemModifierNode animateNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (animateNode == null) {
                i = i2;
            } else {
                long other$iv = animateNode.m629getPlacementDeltanOccac();
                i = i2;
                long animatedOffset = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(offset) + IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(offset) + IntOffset.m5337getYimpl(other$iv));
                if ((m593getMainAxisgyyYBs(offset) <= minOffset && m593getMainAxisgyyYBs(animatedOffset) <= minOffset) || (m593getMainAxisgyyYBs(offset) >= maxOffset && m593getMainAxisgyyYBs(animatedOffset) >= maxOffset)) {
                    animateNode.cancelAnimation();
                }
                offset = animatedOffset;
            }
            if (this.reverseLayout) {
                long $this$copy_u2d4Tuh3kE$iv = offset;
                if (this.isVertical) {
                    mainAxisOffset = IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE$iv);
                } else {
                    int mainAxisOffset2 = IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE$iv);
                    mainAxisOffset = (this.mainAxisLayoutSize - mainAxisOffset2) - getMainAxisSize(placeable);
                }
                if (this.isVertical) {
                    int mainAxisOffset3 = IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE$iv);
                    m5337getYimpl = (this.mainAxisLayoutSize - mainAxisOffset3) - getMainAxisSize(placeable);
                } else {
                    m5337getYimpl = IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE$iv);
                }
                offset = IntOffsetKt.IntOffset(mainAxisOffset, m5337getYimpl);
            }
            long other$iv2 = this.visualOffset;
            long other$iv3 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(offset) + IntOffset.m5336getXimpl(other$iv2), IntOffset.m5337getYimpl(offset) + IntOffset.m5337getYimpl(other$iv2));
            if (this.isVertical) {
                Placeable.PlacementScope.m4246placeWithLayeraW9wM$default(scope, placeable, other$iv3, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m4245placeRelativeWithLayeraW9wM$default(scope, placeable, other$iv3, 0.0f, null, 6, null);
            }
            i3++;
            i2 = i;
        }
    }

    /* renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m593getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m5337getYimpl($this$mainAxis) : IntOffset.m5336getXimpl($this$mainAxis);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m592copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> function1) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE) : function1.invoke(Integer.valueOf(IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? function1.invoke(Integer.valueOf(IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE));
    }
}
