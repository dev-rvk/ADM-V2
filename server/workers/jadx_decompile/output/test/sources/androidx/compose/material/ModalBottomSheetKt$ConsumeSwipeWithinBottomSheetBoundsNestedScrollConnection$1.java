package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ AnchoredDraggableState<?> $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(AnchoredDraggableState<?> anchoredDraggableState, Orientation $orientation) {
        this.$state = anchoredDraggableState;
        this.$orientation = $orientation;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo338onPreScrollOzD1aCk(long available, int source) {
        float delta = offsetToFloat(available);
        if (delta < 0.0f && NestedScrollSource.m3960equalsimpl0(source, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI())) {
            return toOffset(this.$state.dispatchRawDelta(delta));
        }
        return Offset.INSTANCE.m2726getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo337onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (NestedScrollSource.m3960equalsimpl0(source, NestedScrollSource.INSTANCE.m3965getDragWNlRxjI())) {
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
        }
        return Offset.INSTANCE.m2726getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo561onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L19:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L33;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2d:
            long r7 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r0)
            goto L5e
        L33:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            float r3 = r2.velocityToFloat(r7)
            androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
            float r4 = r4.requireOffset()
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L5f
            androidx.compose.material.AnchoredDraggableState<?> r5 = r2.$state
            float r5 = r5.getMinOffset()
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L5f
            androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
            r9.J$0 = r7
            r5 = 1
            r9.label = r5
            java.lang.Object r2 = r4.settle(r3, r9)
            if (r2 != r1) goto L5e
            return r1
        L5e:
            goto L65
        L5f:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r7 = r7.m5454getZero9UxMQ8M()
        L65:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m5434boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.mo561onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo336onPostFlingRZ2iAVY(long r5, long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L14
            r5 = r9
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r0
            if (r6 == 0) goto L14
            int r6 = r5.label
            int r6 = r6 - r0
            r5.label = r6
            goto L19
        L14:
            androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L19:
            java.lang.Object r6 = r5.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            switch(r0) {
                case 0: goto L32;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2c:
            long r7 = r5.J$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r4
            androidx.compose.material.AnchoredDraggableState<?> r1 = r0.$state
            float r2 = r0.velocityToFloat(r7)
            r5.J$0 = r7
            r3 = 1
            r5.label = r3
            java.lang.Object r0 = r1.settle(r2, r5)
            if (r0 != r9) goto L48
            return r9
        L48:
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m5434boximpl(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1.mo336onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long toOffset(float $this$toOffset) {
        return OffsetKt.Offset(this.$orientation == Orientation.Horizontal ? $this$toOffset : 0.0f, this.$orientation == Orientation.Vertical ? $this$toOffset : 0.0f);
    }

    private final float velocityToFloat(long $this$toFloat) {
        return this.$orientation == Orientation.Horizontal ? Velocity.m5443getXimpl($this$toFloat) : Velocity.m5444getYimpl($this$toFloat);
    }

    private final float offsetToFloat(long $this$toFloat) {
        return this.$orientation == Orientation.Horizontal ? Offset.m2710getXimpl($this$toFloat) : Offset.m2711getYimpl($this$toFloat);
    }
}
