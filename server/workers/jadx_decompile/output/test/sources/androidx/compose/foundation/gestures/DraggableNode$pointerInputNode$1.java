package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1", f = "Draggable.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class DraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DraggableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$pointerInputNode$1(DraggableNode draggableNode, Continuation<? super DraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this.this$0, continuation);
        draggableNode$pointerInputNode$1.L$0 = obj;
        return draggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                z = this.this$0.enabled;
                if (!z) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$SuspendingPointerInputModifierNode, this.this$0, null), this) != coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {326}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, DraggableNode draggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = draggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {305, 307, 309, 316, 318, 321}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00041(DraggableNode draggableNode, Continuation<? super C00041> continuation) {
                super(2, continuation);
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00041 c00041 = new C00041(this.this$0, continuation);
                c00041.L$0 = obj;
                return c00041;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00e4 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x00eb A[Catch: CancellationException -> 0x0041, TryCatch #1 {CancellationException -> 0x0041, blocks: (B:20:0x00c3, B:23:0x00e5, B:25:0x00eb, B:30:0x010b, B:32:0x0111, B:53:0x003c), top: B:52:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x010b A[Catch: CancellationException -> 0x0041, TryCatch #1 {CancellationException -> 0x0041, blocks: (B:20:0x00c3, B:23:0x00e5, B:25:0x00eb, B:30:0x010b, B:32:0x0111, B:53:0x003c), top: B:52:0x003c }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x013c A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x013f  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0145  */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1] */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0124 -> B:8:0x0071). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0127 -> B:8:0x0071). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013a -> B:8:0x0071). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x013f -> B:8:0x0071). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    Method dump skipped, instructions count: 346
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00041.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Draggable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1", f = "Draggable.kt", i = {0}, l = {312}, m = "invokeSuspend", n = {"$this$drag"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C00051 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ DraggableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00051(Ref.ObjectRef<DragEvent> objectRef, DraggableNode draggableNode, Continuation<? super C00051> continuation) {
                    super(2, continuation);
                    this.$event = objectRef;
                    this.this$0 = draggableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00051 c00051 = new C00051(this.$event, this.this$0, continuation);
                    c00051.L$0 = obj;
                    return c00051;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                    return ((C00051) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0075 -> B:7:0x007c). Please report as a decompilation issue!!! */
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
                            case 0: goto L23;
                            case 1: goto L11;
                            default: goto L9;
                        }
                    L9:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r0)
                        throw r10
                    L11:
                        r1 = r9
                        java.lang.Object r2 = r1.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                        java.lang.Object r3 = r1.L$0
                        androidx.compose.foundation.gestures.DragScope r3 = (androidx.compose.foundation.gestures.DragScope) r3
                        kotlin.ResultKt.throwOnFailure(r10)
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r0
                        r0 = r10
                        goto L7c
                    L23:
                        kotlin.ResultKt.throwOnFailure(r10)
                        r1 = r9
                        java.lang.Object r2 = r1.L$0
                        androidx.compose.foundation.gestures.DragScope r2 = (androidx.compose.foundation.gestures.DragScope) r2
                        r3 = r2
                    L2c:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                        T r2 = r2.element
                        boolean r2 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                        if (r2 != 0) goto L83
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                        T r2 = r2.element
                        boolean r2 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                        if (r2 != 0) goto L83
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                        T r2 = r2.element
                        boolean r4 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                        if (r4 == 0) goto L47
                        androidx.compose.foundation.gestures.DragEvent$DragDelta r2 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r2
                        goto L48
                    L47:
                        r2 = 0
                    L48:
                        if (r2 == 0) goto L5c
                        androidx.compose.foundation.gestures.DraggableNode r4 = r1.this$0
                        r5 = 0
                        long r6 = r2.getDelta()
                        androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.DraggableNode.access$getOrientation$p(r4)
                        float r4 = androidx.compose.foundation.gestures.DraggableKt.m289access$toFloat3MmeM6k(r6, r4)
                        r3.dragBy(r4)
                    L5c:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                        androidx.compose.foundation.gestures.DraggableNode r4 = r1.this$0
                        kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.DraggableNode.access$getChannel$p(r4)
                        r5 = r1
                        kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                        r1.L$0 = r3
                        r1.L$1 = r2
                        r6 = 1
                        r1.label = r6
                        java.lang.Object r4 = r4.receive(r5)
                        if (r4 != r0) goto L75
                        return r0
                    L75:
                        r8 = r0
                        r0 = r10
                        r10 = r4
                        r4 = r3
                        r3 = r2
                        r2 = r1
                        r1 = r8
                    L7c:
                        r3.element = r10
                        r10 = r0
                        r0 = r1
                        r1 = r2
                        r3 = r4
                        goto L2c
                    L83:
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.C00041.C00051.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                switch(r1) {
                    case 0: goto L1c;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L11:
                r0 = r11
                java.lang.Object r1 = r0.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> L1a
                goto L55
            L1a:
                r2 = move-exception
                goto L5b
            L1c:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r11
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1 r3 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$1
                androidx.compose.foundation.gestures.DraggableNode r4 = r1.this$0
                r9 = 0
                r3.<init>(r4, r9)
                r6 = r3
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r7 = 1
                r8 = 0
                r4 = 0
                r3 = r2
                kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                androidx.compose.ui.input.pointer.PointerInputScope r3 = r1.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2 r4 = new androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2     // Catch: java.util.concurrent.CancellationException -> L56
                androidx.compose.foundation.gestures.DraggableNode r5 = r1.this$0     // Catch: java.util.concurrent.CancellationException -> L56
                r4.<init>(r2, r5, r9)     // Catch: java.util.concurrent.CancellationException -> L56
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.util.concurrent.CancellationException -> L56
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.util.concurrent.CancellationException -> L56
                r1.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L56
                r6 = 1
                r1.label = r6     // Catch: java.util.concurrent.CancellationException -> L56
                java.lang.Object r3 = r3.awaitPointerEventScope(r4, r5)     // Catch: java.util.concurrent.CancellationException -> L56
                if (r3 != r0) goto L53
                return r0
            L53:
                r0 = r1
                r1 = r2
            L55:
                goto L61
            L56:
                r0 = move-exception
                r10 = r2
                r2 = r0
                r0 = r1
                r1 = r10
            L5b:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r3 == 0) goto L64
            L61:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L64:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2", f = "Draggable.kt", i = {0, 1, 1}, l = {328, 336}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "isDragSuccessful"}, s = {"L$0", "L$0", "I$0"})
        /* renamed from: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ DraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CoroutineScope coroutineScope, DraggableNode draggableNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = draggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$$this$coroutineScope, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
            /* JADX WARN: Removed duplicated region for block: B:13:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x014d  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0160 A[Catch: all -> 0x0039, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0039, blocks: (B:8:0x002e, B:36:0x0146, B:39:0x0160), top: B:7:0x002e }] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0163  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0186  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x0193  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0198  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0114  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00dd -> B:10:0x00e7). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x014d -> B:18:0x005c). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0193 -> B:18:0x005c). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r26) {
                /*
                    Method dump skipped, instructions count: 422
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }
}
