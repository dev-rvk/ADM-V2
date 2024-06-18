package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1", f = "Transformable.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TransformableKt$transformable$3$block$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<TransformEvent> $channel;
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<Function0<Boolean>> $updatedCanPan;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformableKt$transformable$3$block$1$1(State<Boolean> state, Channel<TransformEvent> channel, State<? extends Function0<Boolean>> state2, Continuation<? super TransformableKt$transformable$3$block$1$1> continuation) {
        super(2, continuation);
        this.$updatePanZoomLock = state;
        this.$channel = channel;
        this.$updatedCanPan = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableKt$transformable$3$block$1$1 transformableKt$transformable$3$block$1$1 = new TransformableKt$transformable$3$block$1$1(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, continuation);
        transformableKt$transformable$3$block$1$1.L$0 = obj;
        return transformableKt$transformable$3$block$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformableKt$transformable$3$block$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1", f = "Transformable.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$null;
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ State<Boolean> $updatePanZoomLock;
        final /* synthetic */ State<Function0<Boolean>> $updatedCanPan;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(PointerInputScope pointerInputScope, State<Boolean> state, Channel<TransformEvent> channel, State<? extends Function0<Boolean>> state2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$null = pointerInputScope;
            this.$updatePanZoomLock = state;
            this.$channel = channel;
            this.$updatedCanPan = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$null, this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1$1", f = "Transformable.kt", i = {}, l = {WorkQueueKt.MASK}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00101 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Channel<TransformEvent> $channel;
            final /* synthetic */ State<Boolean> $updatePanZoomLock;
            final /* synthetic */ State<Function0<Boolean>> $updatedCanPan;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00101(State<Boolean> state, Channel<TransformEvent> channel, State<? extends Function0<Boolean>> state2, CoroutineScope coroutineScope, Continuation<? super C00101> continuation) {
                super(2, continuation);
                this.$updatePanZoomLock = state;
                this.$channel = channel;
                this.$updatedCanPan = state2;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00101 c00101 = new C00101(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, this.$$this$coroutineScope, continuation);
                c00101.L$0 = obj;
                return c00101;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00101) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: all -> 0x0016, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0016, blocks: (B:9:0x0012, B:15:0x0048, B:17:0x0054), top: B:2:0x0006 }] */
            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r0v3 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r9.label
                    switch(r1) {
                        case 0: goto L1a;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L11:
                    r0 = r9
                    kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L16 java.util.concurrent.CancellationException -> L18
                    goto L37
                L16:
                    r1 = move-exception
                    goto L55
                L18:
                    r1 = move-exception
                    goto L48
                L1a:
                    kotlin.ResultKt.throwOnFailure(r10)
                    r1 = r9
                    java.lang.Object r2 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                    androidx.compose.runtime.State<java.lang.Boolean> r3 = r1.$updatePanZoomLock     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r4 = r1.$channel     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r5 = r1.$updatedCanPan     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    r7 = 1
                    r1.label = r7     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    java.lang.Object r3 = androidx.compose.foundation.gestures.TransformableKt.access$detectZoom(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3f java.util.concurrent.CancellationException -> L44
                    if (r3 != r0) goto L36
                    return r0
                L36:
                    r0 = r1
                L37:
                    kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r1 = r0.$channel
                    androidx.compose.foundation.gestures.TransformEvent$TransformStopped r2 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
                    r1.mo7116trySendJP2dKIU(r2)
                    goto L51
                L3f:
                    r0 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                    goto L55
                L44:
                    r0 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                L48:
                    kotlinx.coroutines.CoroutineScope r2 = r0.$$this$coroutineScope     // Catch: java.lang.Throwable -> L16
                    boolean r2 = kotlinx.coroutines.CoroutineScopeKt.isActive(r2)     // Catch: java.lang.Throwable -> L16
                    if (r2 == 0) goto L54
                    goto L37
                L51:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                L54:
                    throw r1     // Catch: java.lang.Throwable -> L16
                L55:
                    kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r2 = r0.$channel
                    androidx.compose.foundation.gestures.TransformEvent$TransformStopped r3 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
                    r2.mo7116trySendJP2dKIU(r3)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$transformable$3$block$1$1.AnonymousClass1.C00101.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(this.$$this$null, new C00101(this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, $this$coroutineScope, null), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$null = (PointerInputScope) this.L$0;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$null, this.$updatePanZoomLock, this.$channel, this.$updatedCanPan, null), this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
