package androidx.compose.ui.input.pointer;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PointerIcon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1", f = "PointerIcon.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(PointerIconModifierLocal pointerIconModifierLocal, Continuation<? super PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1> continuation) {
        super(2, continuation);
        this.$pointerIconModifierLocal = pointerIconModifierLocal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1 = new PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1(this.$pointerIconModifierLocal, continuation);
        pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.L$0 = obj;
        return pointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PointerIcon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1", f = "PointerIcon.kt", i = {0}, l = {112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerIconModifierLocal $pointerIconModifierLocal;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerIconModifierLocal pointerIconModifierLocal, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pointerIconModifierLocal = pointerIconModifierLocal;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pointerIconModifierLocal, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0038 -> B:7:0x003e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                switch(r1) {
                    case 0: goto L1e;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L11:
                r1 = r7
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r8)
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r8
                goto L3e
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                r1 = r7
                java.lang.Object r2 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            L26:
                androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.L$0 = r2
                r5 = 1
                r1.label = r5
                java.lang.Object r3 = r2.awaitPointerEvent(r3, r4)
                if (r3 != r0) goto L38
                return r0
            L38:
                r6 = r0
                r0 = r8
                r8 = r3
                r3 = r2
                r2 = r1
                r1 = r6
            L3e:
                androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                int r4 = r8.getType()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                int r5 = r5.m4022getEnter7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m4018equalsimpl0(r4, r5)
                if (r4 == 0) goto L56
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r8 = r2.$pointerIconModifierLocal
                r8.enter()
                goto L6b
            L56:
                int r4 = r8.getType()
                androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                int r5 = r5.m4023getExit7fucELk()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m4018equalsimpl0(r4, r5)
                if (r4 == 0) goto L6b
                androidx.compose.ui.input.pointer.PointerIconModifierLocal r8 = r2.$pointerIconModifierLocal
                r8.exit()
            L6b:
                r8 = r0
                r0 = r1
                r1 = r2
                r2 = r3
                goto L26
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$pointerInputModifier$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                this.label = 1;
                if ($this$pointerInput.awaitPointerEventScope(new AnonymousClass1(this.$pointerIconModifierLocal, null), this) != coroutine_suspended) {
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
