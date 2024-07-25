package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2", f = "TransformableState.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class DefaultTransformableState$transform$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TransformScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $transformPriority;
    int label;
    final /* synthetic */ DefaultTransformableState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultTransformableState$transform$2(DefaultTransformableState defaultTransformableState, MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultTransformableState$transform$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultTransformableState;
        this.$transformPriority = mutatePriority;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultTransformableState$transform$2(this.this$0, this.$transformPriority, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultTransformableState$transform$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1", f = "TransformableState.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<TransformScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DefaultTransformableState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(DefaultTransformableState defaultTransformableState, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = defaultTransformableState;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            MutableState mutableState;
            Throwable th;
            AnonymousClass1 anonymousClass1;
            MutableState mutableState2;
            MutableState mutableState3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    TransformScope $this$mutateWith = (TransformScope) this.L$0;
                    mutableState = this.this$0.isTransformingState;
                    mutableState.setValue(Boxing.boxBoolean(true));
                    try {
                        Function2<TransformScope, Continuation<? super Unit>, Object> function2 = this.$block;
                        this.label = 1;
                        if (function2.invoke($this$mutateWith, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1 = this;
                        mutableState3 = anonymousClass1.this$0.isTransformingState;
                        mutableState3.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        anonymousClass1 = this;
                        mutableState2 = anonymousClass1.this$0.isTransformingState;
                        mutableState2.setValue(Boxing.boxBoolean(false));
                        throw th;
                    }
                case 1:
                    anonymousClass1 = this;
                    try {
                        ResultKt.throwOnFailure($result);
                        mutableState3 = anonymousClass1.this$0.isTransformingState;
                        mutableState3.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        mutableState2 = anonymousClass1.this$0.isTransformingState;
                        mutableState2.setValue(Boxing.boxBoolean(false));
                        throw th;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        MutatorMutex mutatorMutex;
        TransformScope transformScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutatorMutex = this.this$0.transformMutex;
                transformScope = this.this$0.transformScope;
                this.label = 1;
                if (mutatorMutex.mutateWith(transformScope, this.$transformPriority, new AnonymousClass1(this.this$0, this.$block, null), this) != coroutine_suspended) {
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
