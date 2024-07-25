package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior $receiver) {
        this.this$0 = $receiver;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo338onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        float prevHeightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2711getYimpl(available));
        if (!(prevHeightOffset == this.this$0.getState().getHeightOffset())) {
            return Offset.m2704copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
        }
        return Offset.INSTANCE.m2726getZeroF1C5BW0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        if ((r5.this$0.getState().getHeightOffset() == r5.this$0.getState().getHeightOffsetLimit()) != false) goto L16;
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo337onPostScrollDzOQY0M(long r6, long r8, int r10) {
        /*
            r5 = this;
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            kotlin.jvm.functions.Function0 r0 = r0.getCanScroll()
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L19
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m2726getZeroF1C5BW0()
            return r0
        L19:
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            float r1 = r0.getContentOffset()
            float r2 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r6)
            float r1 = r1 + r2
            r0.setContentOffset(r1)
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            float r0 = r0.getHeightOffset()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L3e
            r0 = r2
            goto L3f
        L3e:
            r0 = r3
        L3f:
            if (r0 != 0) goto L5e
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            float r0 = r0.getHeightOffset()
            androidx.compose.material3.EnterAlwaysScrollBehavior r4 = r5.this$0
            androidx.compose.material3.TopAppBarState r4 = r4.getState()
            float r4 = r4.getHeightOffsetLimit()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L5b
            r0 = r2
            goto L5c
        L5b:
            r0 = r3
        L5c:
            if (r0 == 0) goto L7b
        L5e:
            float r0 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r6)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L67
            goto L68
        L67:
            r2 = r3
        L68:
            if (r2 == 0) goto L7b
            float r0 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r8)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L7b
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            r0.setContentOffset(r1)
        L7b:
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            androidx.compose.material3.EnterAlwaysScrollBehavior r1 = r5.this$0
            androidx.compose.material3.TopAppBarState r1 = r1.getState()
            float r1 = r1.getHeightOffset()
            float r2 = androidx.compose.ui.geometry.Offset.m2711getYimpl(r6)
            float r1 = r1 + r2
            r0.setHeightOffset(r1)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r0 = r0.m2726getZeroF1C5BW0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.mo337onPostScrollDzOQY0M(long, long, int):long");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo336onPostFlingRZ2iAVY(long r10, long r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r9, r14)
        L19:
            r14 = r0
            java.lang.Object r6 = r14.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r14.label
            switch(r0) {
                case 0: goto L41;
                case 1: goto L35;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L2d:
            long r10 = r14.J$0
            kotlin.ResultKt.throwOnFailure(r6)
            r12 = r10
            r10 = r6
            goto L84
        L35:
            long r10 = r14.J$0
            java.lang.Object r12 = r14.L$0
            androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1 r12 = (androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1) r12
            kotlin.ResultKt.throwOnFailure(r6)
            r8 = r12
            r12 = r6
            goto L58
        L41:
            kotlin.ResultKt.throwOnFailure(r6)
            r8 = r9
            r1 = r10
            r10 = r12
            r14.L$0 = r8
            r14.J$0 = r10
            r12 = 1
            r14.label = r12
            r0 = r8
            r3 = r10
            r5 = r14
            java.lang.Object r12 = super.mo336onPostFlingRZ2iAVY(r1, r3, r5)
            if (r12 != r7) goto L58
            return r7
        L58:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r12 = r12.getPackedValue()
            androidx.compose.material3.EnterAlwaysScrollBehavior r0 = r8.this$0
            androidx.compose.material3.TopAppBarState r0 = r0.getState()
            float r10 = androidx.compose.ui.unit.Velocity.m5444getYimpl(r10)
            androidx.compose.material3.EnterAlwaysScrollBehavior r11 = r8.this$0
            androidx.compose.animation.core.DecayAnimationSpec r11 = r11.getFlingAnimationSpec()
            androidx.compose.material3.EnterAlwaysScrollBehavior r1 = r8.this$0
            androidx.compose.animation.core.AnimationSpec r1 = r1.getSnapAnimationSpec()
            r2 = 0
            r14.L$0 = r2
            r14.J$0 = r12
            r2 = 2
            r14.label = r2
            java.lang.Object r10 = androidx.compose.material3.AppBarKt.access$settleAppBar(r0, r10, r11, r1, r14)
            if (r10 != r7) goto L84
            return r7
        L84:
            androidx.compose.ui.unit.Velocity r10 = (androidx.compose.ui.unit.Velocity) r10
            long r10 = r10.getPackedValue()
            long r10 = androidx.compose.ui.unit.Velocity.m5447plusAH228Gc(r12, r10)
            androidx.compose.ui.unit.Velocity r10 = androidx.compose.ui.unit.Velocity.m5434boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1.mo336onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
