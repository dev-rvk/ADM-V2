package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AwaitFirstLayoutModifier.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u000b\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0022. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object waitForFirstLayout(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = new androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            r0.<init>(r7, r8)
        L19:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            switch(r2) {
                case 0: goto L39;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2d:
            java.lang.Object r1 = r8.L$1
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r2 = r8.L$0
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r2 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L70
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            boolean r3 = r2.wasPositioned
            if (r3 != 0) goto L7e
            kotlin.coroutines.Continuation<? super kotlin.Unit> r3 = r2.continuation
            r8.L$0 = r2
            r8.L$1 = r3
            r4 = 1
            r8.label = r4
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.coroutines.SafeContinuation r5 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r4)
            r5.<init>(r4)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6 = 0
            r2.continuation = r4
            java.lang.Object r2 = r5.getOrThrow()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r4) goto L6c
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)
        L6c:
            if (r2 != r1) goto L6f
            return r1
        L6f:
            r1 = r3
        L70:
            if (r1 == 0) goto L7e
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            java.lang.Object r2 = kotlin.Result.m5615constructorimpl(r2)
            r1.resumeWith(r2)
        L7e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.waitForFirstLayout(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (!this.wasPositioned) {
            this.wasPositioned = true;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
            }
            this.continuation = null;
        }
    }
}
