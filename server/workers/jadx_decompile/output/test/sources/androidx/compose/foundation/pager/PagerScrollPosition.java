package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerScrollPosition.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000b¨\u0006$"}, d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "initialPage", "", "initialScrollOffset", "(II)V", "<set-?>", "currentPage", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "firstVisiblePage", "getFirstVisiblePage", "setFirstVisiblePage", "firstVisiblePage$delegate", "hadFirstNotEmptyLayout", "", "lastKnownFirstPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "index", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerScrollPosition {

    /* renamed from: currentPage$delegate, reason: from kotlin metadata */
    private final MutableIntState currentPage;

    /* renamed from: firstVisiblePage$delegate, reason: from kotlin metadata */
    private final MutableIntState firstVisiblePage;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownFirstPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;

    /* renamed from: scrollOffset$delegate, reason: from kotlin metadata */
    private final MutableIntState scrollOffset;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PagerScrollPosition() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerScrollPosition.<init>():void");
    }

    public PagerScrollPosition(int initialPage, int initialScrollOffset) {
        this.firstVisiblePage = SnapshotIntStateKt.mutableIntStateOf(initialPage);
        this.currentPage = SnapshotIntStateKt.mutableIntStateOf(initialPage);
        this.scrollOffset = SnapshotIntStateKt.mutableIntStateOf(initialScrollOffset);
        this.nearestRangeState = new LazyLayoutNearestRangeState(initialPage, 30, 100);
    }

    public /* synthetic */ PagerScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisiblePage() {
        IntState $this$getValue$iv = this.firstVisiblePage;
        return $this$getValue$iv.getIntValue();
    }

    public final void setFirstVisiblePage(int i) {
        MutableIntState $this$setValue$iv = this.firstVisiblePage;
        $this$setValue$iv.setIntValue(i);
    }

    public final int getCurrentPage() {
        IntState $this$getValue$iv = this.currentPage;
        return $this$getValue$iv.getIntValue();
    }

    public final void setCurrentPage(int i) {
        MutableIntState $this$setValue$iv = this.currentPage;
        $this$setValue$iv.setIntValue(i);
    }

    private final void setScrollOffset(int i) {
        MutableIntState $this$setValue$iv = this.scrollOffset;
        $this$setValue$iv.setIntValue(i);
    }

    public final int getScrollOffset() {
        IntState $this$getValue$iv = this.scrollOffset;
        return $this$getValue$iv.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(PagerMeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        MeasuredPage firstVisiblePage = measureResult.getFirstVisiblePage();
        this.lastKnownFirstPageKey = firstVisiblePage != null ? firstVisiblePage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || measureResult.getPagesCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int scrollOffset = measureResult.getFirstVisiblePageOffset();
            if (!(((float) scrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + scrollOffset + ')').toString());
            }
            MeasuredPage firstVisiblePage2 = measureResult.getFirstVisiblePage();
            update(firstVisiblePage2 != null ? firstVisiblePage2.getIndex() : 0, scrollOffset);
            PageInfo closestPageToSnapPosition = measureResult.getClosestPageToSnapPosition();
            if (closestPageToSnapPosition != null) {
                int it = closestPageToSnapPosition.getIndex();
                setCurrentPage(it);
            }
        }
    }

    public final void requestPosition(int index, int scrollOffset) {
        update(index, scrollOffset);
        this.lastKnownFirstPageKey = null;
    }

    private final void update(int index, int scrollOffset) {
        if (!(((float) index) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
        }
        setFirstVisiblePage(index);
        this.nearestRangeState.update(index);
        setScrollOffset(scrollOffset);
    }
}
