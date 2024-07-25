package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NestedScrollInteropConnection.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        NestedScrollingChildHelper $this$nestedScrollChildHelper_u24lambda_u240 = new NestedScrollingChildHelper(this.view);
        $this$nestedScrollChildHelper_u24lambda_u240.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = $this$nestedScrollChildHelper_u24lambda_u240;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(this.view, true);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo338onPreScrollOzD1aCk(long available, int source) {
        int m4538getScrollAxesk4lQ0M;
        int m4540toViewTypeGyEprt8;
        int m4540toViewTypeGyEprt82;
        long m4539toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m4538getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m4538getScrollAxesk4lQ0M(available);
        m4540toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m4540toViewTypeGyEprt8(source);
        if (!nestedScrollingChildHelper.startNestedScroll(m4538getScrollAxesk4lQ0M, m4540toViewTypeGyEprt8)) {
            return Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2710getXimpl(available));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2711getYimpl(available));
        int[] iArr = this.consumedScrollCache;
        m4540toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m4540toViewTypeGyEprt8(source);
        nestedScrollingChildHelper2.dispatchNestedPreScroll(composeToViewOffset, composeToViewOffset2, iArr, null, m4540toViewTypeGyEprt82);
        m4539toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m4539toOffsetUv8p0NA(this.consumedScrollCache, available);
        return m4539toOffsetUv8p0NA;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo337onPostScrollDzOQY0M(long consumed, long available, int source) {
        int m4538getScrollAxesk4lQ0M;
        int m4540toViewTypeGyEprt8;
        int m4540toViewTypeGyEprt82;
        long m4539toOffsetUv8p0NA;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        m4538getScrollAxesk4lQ0M = NestedScrollInteropConnectionKt.m4538getScrollAxesk4lQ0M(available);
        m4540toViewTypeGyEprt8 = NestedScrollInteropConnectionKt.m4540toViewTypeGyEprt8(source);
        if (!nestedScrollingChildHelper.startNestedScroll(m4538getScrollAxesk4lQ0M, m4540toViewTypeGyEprt8)) {
            return Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        NestedScrollingChildHelper nestedScrollingChildHelper2 = this.nestedScrollChildHelper;
        int composeToViewOffset = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2710getXimpl(consumed));
        int composeToViewOffset2 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2711getYimpl(consumed));
        int composeToViewOffset3 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2710getXimpl(available));
        int composeToViewOffset4 = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2711getYimpl(available));
        m4540toViewTypeGyEprt82 = NestedScrollInteropConnectionKt.m4540toViewTypeGyEprt8(source);
        nestedScrollingChildHelper2.dispatchNestedScroll(composeToViewOffset, composeToViewOffset2, composeToViewOffset3, composeToViewOffset4, null, m4540toViewTypeGyEprt82, this.consumedScrollCache);
        m4539toOffsetUv8p0NA = NestedScrollInteropConnectionKt.m4539toOffsetUv8p0NA(this.consumedScrollCache, available);
        return m4539toOffsetUv8p0NA;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    public Object mo561onPreFlingQWom1Mo(long available, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        long result;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5443getXimpl(available));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5444getYimpl(available));
        if (nestedScrollingChildHelper.dispatchNestedPreFling(viewVelocity, viewVelocity2)) {
            result = available;
        } else {
            result = Velocity.INSTANCE.m5454getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5434boximpl(result);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo336onPostFlingRZ2iAVY(long consumed, long available, Continuation<? super Velocity> continuation) {
        float viewVelocity;
        float viewVelocity2;
        long result;
        NestedScrollingChildHelper nestedScrollingChildHelper = this.nestedScrollChildHelper;
        viewVelocity = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5443getXimpl(available));
        viewVelocity2 = NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5444getYimpl(available));
        if (nestedScrollingChildHelper.dispatchNestedFling(viewVelocity, viewVelocity2, true)) {
            result = available;
        } else {
            result = Velocity.INSTANCE.m5454getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5434boximpl(result);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
