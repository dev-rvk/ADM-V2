package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PointerMoveDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class PointerMoveDetectorKt$detectMoves$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onMove;
    final /* synthetic */ PointerEventPass $pointerEventPass;
    final /* synthetic */ PointerInputScope $this_detectMoves;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PointerMoveDetectorKt$detectMoves$2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super PointerMoveDetectorKt$detectMoves$2> continuation) {
        super(2, continuation);
        this.$this_detectMoves = pointerInputScope;
        this.$pointerEventPass = pointerEventPass;
        this.$onMove = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointerMoveDetectorKt$detectMoves$2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PointerMoveDetectorKt$detectMoves$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineContext currentContext = getContext();
                this.label = 1;
                if (this.$this_detectMoves.awaitPointerEventScope(new AnonymousClass1(currentContext, this.$pointerEventPass, this.$onMove, null), this) != coroutine_suspended) {
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
    /* compiled from: PointerMoveDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {44}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ Function1<Offset, Unit> $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(CoroutineContext coroutineContext, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$pointerEventPass = pointerEventPass;
            this.$onMove = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$pointerEventPass, this.$onMove, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
        /* JADX WARN: Type inference failed for: r9v1, types: [T, androidx.compose.ui.geometry.Offset] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x004e -> B:7:0x0055). Please report as a decompilation issue!!! */
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
                r2 = 1
                switch(r1) {
                    case 0: goto L24;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L12:
                r1 = r11
                java.lang.Object r3 = r1.L$1
                kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                java.lang.Object r4 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                kotlin.ResultKt.throwOnFailure(r12)
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r12
                goto L55
            L24:
                kotlin.ResultKt.throwOnFailure(r12)
                r1 = r11
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
                r4.<init>()
                r10 = r4
                r4 = r3
                r3 = r10
            L34:
                kotlin.coroutines.CoroutineContext r5 = r1.$currentContext
                boolean r5 = kotlinx.coroutines.JobKt.isActive(r5)
                if (r5 == 0) goto Lc5
                androidx.compose.ui.input.pointer.PointerEventPass r5 = r1.$pointerEventPass
                r6 = r1
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r1.L$0 = r4
                r1.L$1 = r3
                r1.label = r2
                java.lang.Object r5 = r4.awaitPointerEvent(r5, r6)
                if (r5 != r0) goto L4e
                return r0
            L4e:
                r10 = r0
                r0 = r12
                r12 = r5
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r10
            L55:
                androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                int r6 = r12.getType()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                int r7 = r7.m4024getMove7fucELk()
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m4018equalsimpl0(r6, r7)
                if (r7 == 0) goto L69
                r7 = r2
                goto L73
            L69:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                int r7 = r7.m4022getEnter7fucELk()
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m4018equalsimpl0(r6, r7)
            L73:
                if (r7 == 0) goto L77
                r6 = r2
                goto L81
            L77:
                androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                int r7 = r7.m4023getExit7fucELk()
                boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m4018equalsimpl0(r6, r7)
            L81:
                if (r6 == 0) goto Lbe
            L84:
                java.util.List r6 = r12.getChanges()
                java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                long r6 = r6.getPosition()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m2699boximpl(r6)
                long r7 = r6.getPackedValue()
                r12 = 0
                T r9 = r4.element
                boolean r12 = androidx.compose.ui.geometry.Offset.m2706equalsimpl(r7, r9)
                if (r12 != 0) goto La4
                goto La5
            La4:
                r6 = 0
            La5:
                if (r6 == 0) goto Lbd
            La8:
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r12 = r3.$onMove
                long r6 = r6.getPackedValue()
                r8 = 0
                androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m2699boximpl(r6)
                r4.element = r9
                androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m2699boximpl(r6)
                r12.invoke(r9)
            Lbd:
            Lbe:
                r12 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r4 = r5
                goto L34
            Lc5:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
