package androidx.compose.foundation.gestures;

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
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1", f = "Scrollable.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class MouseWheelScrollNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollNode$pointerInputNode$1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super MouseWheelScrollNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this.this$0, continuation);
        mouseWheelScrollNode$pointerInputNode$1.L$0 = obj;
        return mouseWheelScrollNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scrollable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1", f = "Scrollable.kt", i = {0}, l = {338}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MouseWheelScrollNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MouseWheelScrollNode mouseWheelScrollNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mouseWheelScrollNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x003b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x003c -> B:7:0x0042). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                r1 = r18
                int r2 = r1.label
                r3 = 1
                switch(r2) {
                    case 0: goto L22;
                    case 1: goto L14;
                    default: goto Lc;
                }
            Lc:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L14:
                r2 = r18
                r4 = r19
                java.lang.Object r5 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r4)
                r6 = r5
                r5 = r4
                goto L42
            L22:
                kotlin.ResultKt.throwOnFailure(r19)
                r2 = r18
                r4 = r19
                java.lang.Object r5 = r2.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            L2d:
                r6 = r2
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r2.L$0 = r5
                r2.label = r3
                java.lang.Object r6 = androidx.compose.foundation.gestures.ScrollableKt.access$awaitScrollEvent(r5, r6)
                if (r6 != r0) goto L3c
                return r0
            L3c:
                r17 = r5
                r5 = r4
                r4 = r6
                r6 = r17
            L42:
                androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
                java.util.List r7 = r4.getChanges()
                r8 = 0
                r9 = 0
                r10 = 0
                int r11 = r7.size()
            L52:
                r12 = 0
                if (r10 >= r11) goto L6f
                java.lang.Object r13 = r7.get(r10)
                r14 = 0
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                r15 = 0
                boolean r16 = r13.isConsumed()
                if (r16 != 0) goto L66
                r13 = r3
                goto L67
            L66:
                r13 = r12
            L67:
                if (r13 != 0) goto L6b
                r7 = r12
                goto L71
            L6b:
                int r10 = r10 + 1
                goto L52
            L6f:
                r7 = r3
            L71:
                if (r7 == 0) goto Lcc
                androidx.compose.foundation.gestures.MouseWheelScrollNode r7 = r2.this$0
                androidx.compose.foundation.gestures.ScrollConfig r7 = r7.getMouseWheelScrollConfig()
                androidx.compose.foundation.gestures.MouseWheelScrollNode r8 = r2.this$0
                r9 = 0
                r10 = r6
                androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
                long r13 = r6.mo3982getSizeYbymL2g()
                long r10 = r7.mo247calculateMouseWheelScroll8xgXZGE(r10, r4, r13)
                androidx.compose.runtime.State r7 = r8.getScrollingLogicState()
                java.lang.Object r7 = r7.getValue()
                androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
                r8 = 0
                float r13 = r7.m347toFloatk4lQ0M(r10)
                float r10 = r7.reverseIfNeeded(r13)
                androidx.compose.foundation.gestures.ScrollableState r11 = r7.getScrollableState()
                float r7 = r11.dispatchRawDelta(r10)
                r10 = 0
                int r10 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
                if (r10 != 0) goto La9
                r12 = r3
            La9:
                if (r12 != 0) goto Lc8
                java.util.List r4 = r4.getChanges()
                r7 = 0
                r10 = 0
                int r11 = r4.size()
            Lb6:
                if (r10 >= r11) goto Lc7
                java.lang.Object r12 = r4.get(r10)
                r13 = r12
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                r14 = 0
                r13.consume()
                int r10 = r10 + 1
                goto Lb6
            Lc7:
            Lc8:
            Lcc:
                r4 = r5
                r5 = r6
                goto L2d
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollNode$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                this.label = 1;
                if ($this$SuspendingPointerInputModifierNode.awaitPointerEventScope(new AnonymousClass1(this.this$0, null), this) != coroutine_suspended) {
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
