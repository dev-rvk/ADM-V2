package androidx.compose.foundation.lazy.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {0}, l = {97, 103}, m = "invokeSuspend", n = {"spec"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, Continuation<? super LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            switch(r1) {
                case 0: goto L23;
                case 1: goto L1a;
                case 2: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L11:
            r0 = r14
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.util.concurrent.CancellationException -> L17
            goto Ld0
        L17:
            r1 = move-exception
            goto Ld9
        L1a:
            r1 = r14
            java.lang.Object r2 = r1.L$0
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.util.concurrent.CancellationException -> Ld7
            goto L7a
        L23:
            kotlin.ResultKt.throwOnFailure(r15)
            r1 = r14
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.Animatable r2 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$getPlacementDeltaAnimation$p(r2)     // Catch: java.util.concurrent.CancellationException -> Ld7
            boolean r2 = r2.isRunning()     // Catch: java.util.concurrent.CancellationException -> Ld7
            if (r2 == 0) goto L4c
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch: java.util.concurrent.CancellationException -> Ld7
            boolean r2 = r2 instanceof androidx.compose.animation.core.SpringSpec     // Catch: java.util.concurrent.CancellationException -> Ld7
            if (r2 == 0) goto L45
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch: java.util.concurrent.CancellationException -> Ld7
            goto L52
        L45:
            androidx.compose.animation.core.SpringSpec r2 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNodeKt.access$getInterruptionSpec$p()     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2     // Catch: java.util.concurrent.CancellationException -> Ld7
            goto L52
        L4c:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r2 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.FiniteAnimationSpec r2 = r2.getPlacementAnimationSpec()     // Catch: java.util.concurrent.CancellationException -> Ld7
        L52:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.Animatable r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$getPlacementDeltaAnimation$p(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            boolean r3 = r3.isRunning()     // Catch: java.util.concurrent.CancellationException -> Ld7
            if (r3 != 0) goto L7b
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.Animatable r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$getPlacementDeltaAnimation$p(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            long r4 = r1.$totalDelta     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.m5327boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> Ld7
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.util.concurrent.CancellationException -> Ld7
            r1.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> Ld7
            r6 = 1
            r1.label = r6     // Catch: java.util.concurrent.CancellationException -> Ld7
            java.lang.Object r3 = r3.snapTo(r4, r5)     // Catch: java.util.concurrent.CancellationException -> Ld7
            if (r3 != r0) goto L7a
            return r0
        L7a:
        L7b:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r3 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.Animatable r3 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$getPlacementDeltaAnimation$p(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            java.lang.Object r3 = r3.getValue()     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.ui.unit.IntOffset r3 = (androidx.compose.ui.unit.IntOffset) r3     // Catch: java.util.concurrent.CancellationException -> Ld7
            long r3 = r3.getPackedValue()     // Catch: java.util.concurrent.CancellationException -> Ld7
            long r5 = r1.$totalDelta     // Catch: java.util.concurrent.CancellationException -> Ld7
            r7 = 0
            int r8 = androidx.compose.ui.unit.IntOffset.m5336getXimpl(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            int r9 = androidx.compose.ui.unit.IntOffset.m5336getXimpl(r5)     // Catch: java.util.concurrent.CancellationException -> Ld7
            int r8 = r8 - r9
            int r9 = androidx.compose.ui.unit.IntOffset.m5337getYimpl(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            int r10 = androidx.compose.ui.unit.IntOffset.m5337getYimpl(r5)     // Catch: java.util.concurrent.CancellationException -> Ld7
            int r9 = r9 - r10
            long r8 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r8, r9)     // Catch: java.util.concurrent.CancellationException -> Ld7
            r3 = r8
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r5 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.animation.core.Animatable r6 = androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$getPlacementDeltaAnimation$p(r5)     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.ui.unit.IntOffset r7 = androidx.compose.ui.unit.IntOffset.m5327boximpl(r3)     // Catch: java.util.concurrent.CancellationException -> Ld7
            r8 = r2
            androidx.compose.animation.core.AnimationSpec r8 = (androidx.compose.animation.core.AnimationSpec) r8     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1$1 r5 = new androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1$1     // Catch: java.util.concurrent.CancellationException -> Ld7
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r9 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> Ld7
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> Ld7
            r10 = r5
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10     // Catch: java.util.concurrent.CancellationException -> Ld7
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch: java.util.concurrent.CancellationException -> Ld7
            r5 = 0
            r1.L$0 = r5     // Catch: java.util.concurrent.CancellationException -> Ld7
            r5 = 2
            r1.label = r5     // Catch: java.util.concurrent.CancellationException -> Ld7
            r9 = 0
            r12 = 4
            r13 = 0
            java.lang.Object r5 = androidx.compose.animation.core.Animatable.animateTo$default(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.util.concurrent.CancellationException -> Ld7
            if (r5 != r0) goto Lcf
            return r0
        Lcf:
            r0 = r1
        Ld0:
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode r1 = r0.this$0     // Catch: java.util.concurrent.CancellationException -> L17
            r2 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode.access$setAnimationInProgress(r1, r2)     // Catch: java.util.concurrent.CancellationException -> L17
            goto Ld9
        Ld7:
            r0 = move-exception
            r0 = r1
        Ld9:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
