package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
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
import kotlinx.coroutines.Job;

/* compiled from: Tooltip.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1", f = "Tooltip.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Job> $onLongPress;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(Function0<? extends Job> function0, Continuation<? super TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1> continuation) {
        super(2, continuation);
        this.$onLongPress = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1 = new TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1(this.$onLongPress, continuation);
        tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.L$0 = obj;
        return tooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Tooltip.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1", f = "Tooltip.kt", i = {0, 0, 0, 1, 1}, l = {217, 221, 229}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "pass", "longPressTimeout", "$this$awaitEachGesture", "pass"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Job> $onLongPress;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends Job> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onLongPress = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onLongPress, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Tooltip.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @DebugMetadata(c = "androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1", f = "Tooltip.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00601 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
            final /* synthetic */ PointerEventPass $pass;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00601(PointerEventPass pointerEventPass, Continuation<? super C00601> continuation) {
                super(2, continuation);
                this.$pass = pointerEventPass;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00601 c00601 = new C00601(this.$pass, continuation);
                c00601.L$0 = obj;
                return c00601;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                return ((C00601) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                        this.label = 1;
                        Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, this.$pass, this);
                        return waitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : waitForUpOrCancellation;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x00b0 A[LOOP:0: B:8:0x00aa->B:10:0x00b0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0099 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$tooltipAnchor$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
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
                if (ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(this.$onLongPress, null), this) != coroutine_suspended) {
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
