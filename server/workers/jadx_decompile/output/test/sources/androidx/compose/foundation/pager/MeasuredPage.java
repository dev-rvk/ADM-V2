package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
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

/* compiled from: MeasuredPage.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bb\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J \u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001e\u0010/\u001a\u00020,2\u0006\u0010 \u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0003J.\u00102\u001a\u00020\t*\u00020\t2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000304H\u0082\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\tX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010%R\u0018\u0010&\u001a\u00020\u0003*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "isVertical", "getKey", "()Ljava/lang/Object;", "mainAxisLayoutSize", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "getSize", "J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "getOffset-Bjo55l4", "(I)J", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MeasuredPage implements PageInfo {
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, list, j, obj, orientation, horizontal, vertical, layoutDirection, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MeasuredPage(int index, int size, List<? extends Placeable> placeables, long visualOffset, Object key, Orientation orientation, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, LayoutDirection layoutDirection, boolean reverseLayout) {
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.index = index;
        this.size = size;
        this.placeables = placeables;
        this.visualOffset = visualOffset;
        this.key = key;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = reverseLayout;
        this.isVertical = orientation == Orientation.Vertical;
        int maxCrossAxis = 0;
        List $this$fastForEach$iv = this.placeables;
        int index$iv = 0;
        int size2 = $this$fastForEach$iv.size();
        while (index$iv < size2) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Placeable it = (Placeable) item$iv;
            int i = size2;
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            size2 = i;
        }
        this.crossAxisSize = maxCrossAxis;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public int getOffset() {
        return this.offset;
    }

    public final void position(int offset, int layoutWidth, int layoutHeight) {
        MeasuredPage measuredPage = this;
        measuredPage.offset = offset;
        measuredPage.mainAxisLayoutSize = measuredPage.isVertical ? layoutHeight : layoutWidth;
        int mainAxisOffset = offset;
        List $this$fastForEachIndexed$iv = measuredPage.placeables;
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv.size();
        while (index$iv < size) {
            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            int indexInArray = index * 2;
            if (measuredPage.isVertical) {
                int[] iArr = measuredPage.placeableOffsets;
                Alignment.Horizontal horizontal = measuredPage.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr[indexInArray] = horizontal.align(placeable.getWidth(), layoutWidth, measuredPage.layoutDirection);
                measuredPage.placeableOffsets[indexInArray + 1] = mainAxisOffset;
                mainAxisOffset += placeable.getHeight();
            } else {
                measuredPage.placeableOffsets[indexInArray] = mainAxisOffset;
                int[] iArr2 = measuredPage.placeableOffsets;
                int i = indexInArray + 1;
                Alignment.Vertical vertical = measuredPage.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr2[i] = vertical.align(placeable.getHeight(), layoutHeight);
                mainAxisOffset += placeable.getWidth();
            }
            index$iv++;
            measuredPage = this;
        }
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
        int size = this.placeables.size();
        int i3 = 0;
        while (i3 < size) {
            int index = i3;
            Placeable placeable = this.placeables.get(index);
            long offset = m691getOffsetBjo55l4(index);
            if (!this.reverseLayout) {
                i = i2;
            } else {
                if (this.isVertical) {
                    mainAxisOffset = IntOffset.m5336getXimpl(offset);
                    i = i2;
                } else {
                    int mainAxisOffset2 = IntOffset.m5336getXimpl(offset);
                    i = i2;
                    mainAxisOffset = (this.mainAxisLayoutSize - mainAxisOffset2) - getMainAxisSize(placeable);
                }
                if (this.isVertical) {
                    int mainAxisOffset3 = IntOffset.m5337getYimpl(offset);
                    m5337getYimpl = (this.mainAxisLayoutSize - mainAxisOffset3) - getMainAxisSize(placeable);
                } else {
                    m5337getYimpl = IntOffset.m5337getYimpl(offset);
                }
                offset = IntOffsetKt.IntOffset(mainAxisOffset, m5337getYimpl);
            }
            long other$iv = this.visualOffset;
            long other$iv2 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(offset) + IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(offset) + IntOffset.m5337getYimpl(other$iv));
            if (this.isVertical) {
                Placeable.PlacementScope.m4246placeWithLayeraW9wM$default(scope, placeable, other$iv2, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m4245placeRelativeWithLayeraW9wM$default(scope, placeable, other$iv2, 0.0f, null, 6, null);
            }
            i3++;
            i2 = i;
        }
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    private final long m691getOffsetBjo55l4(int index) {
        return IntOffsetKt.IntOffset(this.placeableOffsets[index * 2], this.placeableOffsets[(index * 2) + 1]);
    }

    private final int getMainAxisSize(Placeable $this$mainAxisSize) {
        return this.isVertical ? $this$mainAxisSize.getHeight() : $this$mainAxisSize.getWidth();
    }

    /* renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m690copy4Tuh3kE(long $this$copy_u2d4Tuh3kE, Function1<? super Integer, Integer> function1) {
        return IntOffsetKt.IntOffset(this.isVertical ? IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE) : function1.invoke(Integer.valueOf(IntOffset.m5336getXimpl($this$copy_u2d4Tuh3kE))).intValue(), this.isVertical ? function1.invoke(Integer.valueOf(IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE))).intValue() : IntOffset.m5337getYimpl($this$copy_u2d4Tuh3kE));
    }
}
