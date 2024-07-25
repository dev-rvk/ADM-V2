package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0011\u0010\u0014\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0015\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0016\u001a\u00020\u0017*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u0018*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001e\u001a\u00020\u0018*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010\u001e\u001a\u00020\u0018*\u00020\u0017H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010#J\u001a\u0010$\u001a\u00020%*\u00020&H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010)\u001a\u00020\u0005*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010\"J\u001a\u0010)\u001a\u00020\u0005*\u00020\u001bH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00020-*\u00020.H\u0097\u0001J\u001a\u0010/\u001a\u00020&*\u00020%H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010(J\u001a\u00101\u001a\u00020\u001b*\u00020\u0018H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001d\u00101\u001a\u00020\u001b*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00103J\u001d\u00101\u001a\u00020\u001b*\u00020\u0017H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "(Landroidx/compose/ui/unit/Density;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "isCanceled", "", "isReleased", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "reset", "tryAwaitRelease", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class PressGestureScopeImpl implements PressGestureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex;

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public int mo322roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo322roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int mo323roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo323roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float mo324toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo324toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo325toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo325toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo326toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo326toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long mo327toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo327toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public float mo328toPxR2X_6o(long j) {
        return this.$$delegate_0.mo328toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public float mo329toPx0680j_4(float f) {
        return this.$$delegate_0.mo329toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long mo330toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo330toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public long mo331toSp0xMU5do(float f) {
        return this.$$delegate_0.mo331toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo332toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo332toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo333toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo333toSpkPz2Gy4(i);
    }

    public PressGestureScopeImpl(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.$$delegate_0 = density;
        this.mutex = MutexKt.Mutex(false);
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reset(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$reset$1
            r0.<init>(r6, r7)
        L19:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            switch(r2) {
                case 0: goto L35;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L2d:
            java.lang.Object r1 = r7.L$0
            androidx.compose.foundation.gestures.PressGestureScopeImpl r1 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L49
        L35:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            kotlinx.coroutines.sync.Mutex r3 = r2.mutex
            r7.L$0 = r2
            r4 = 1
            r7.label = r4
            r5 = 0
            java.lang.Object r3 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r3, r5, r7, r4, r5)
            if (r3 != r1) goto L48
            return r1
        L48:
            r1 = r2
        L49:
            r2 = 0
            r1.isReleased = r2
            r1.isCanceled = r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.reset(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitRelease(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1
            if (r0 == 0) goto L14
            r0 = r5
            androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$awaitRelease$1
            r0.<init>(r4, r5)
        L19:
            r5 = r0
            java.lang.Object r0 = r5.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            switch(r2) {
                case 0: goto L32;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r0
            goto L40
        L32:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r4
            r3 = 1
            r5.label = r3
            java.lang.Object r2 = r2.tryAwaitRelease(r5)
            if (r2 != r1) goto L40
            return r1
        L40:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r1 = r2.booleanValue()
            if (r1 == 0) goto L4b
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L4b:
            androidx.compose.foundation.gestures.GestureCancellationException r1 = new androidx.compose.foundation.gestures.GestureCancellationException
            java.lang.String r2 = "The press gesture was canceled."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.awaitRelease(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object tryAwaitRelease(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = (androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1 r0 = new androidx.compose.foundation.gestures.PressGestureScopeImpl$tryAwaitRelease$1
            r0.<init>(r6, r7)
        L19:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L37;
                case 1: goto L2f;
                default: goto L27;
            }
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L2f:
            java.lang.Object r1 = r7.L$0
            androidx.compose.foundation.gestures.PressGestureScopeImpl r1 = (androidx.compose.foundation.gestures.PressGestureScopeImpl) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L51
        L37:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            boolean r5 = r2.isReleased
            if (r5 != 0) goto L57
            boolean r5 = r2.isCanceled
            if (r5 != 0) goto L57
            kotlinx.coroutines.sync.Mutex r5 = r2.mutex
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r5 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r5, r4, r7, r3, r4)
            if (r5 != r1) goto L50
            return r1
        L50:
            r1 = r2
        L51:
            kotlinx.coroutines.sync.Mutex r2 = r1.mutex
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r2, r4, r3, r4)
            r2 = r1
        L57:
            boolean r1 = r2.isReleased
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.PressGestureScopeImpl.tryAwaitRelease(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
