package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", i = {0}, l = {603}, m = "invokeSuspend", n = {"velocityLeft"}, s = {"L$0"})
/* loaded from: classes.dex */
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ ScrollScope $this_performFling;
    Object L$0;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFlingBehavior$performFling$2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        float f;
        DecayAnimationSpec decayAnimationSpec;
        DefaultFlingBehavior$performFling$2 defaultFlingBehavior$performFling$2;
        Object $result2;
        Ref.FloatRef velocityLeft;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Math.abs(this.$initialVelocity) > 1.0f) {
                    final Ref.FloatRef velocityLeft2 = new Ref.FloatRef();
                    velocityLeft2.element = this.$initialVelocity;
                    final Ref.FloatRef lastValue = new Ref.FloatRef();
                    AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(0.0f, this.$initialVelocity, 0L, 0L, false, 28, null);
                    decayAnimationSpec = this.this$0.flingDecay;
                    final ScrollScope scrollScope = this.$this_performFling;
                    final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                    this.L$0 = velocityLeft2;
                    this.label = 1;
                    if (SuspendAnimationKt.animateDecay$default(AnimationState$default, decayAnimationSpec, false, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animateDecay) {
                            Intrinsics.checkNotNullParameter(animateDecay, "$this$animateDecay");
                            float delta = animateDecay.getValue().floatValue() - Ref.FloatRef.this.element;
                            float consumed = scrollScope.scrollBy(delta);
                            Ref.FloatRef.this.element = animateDecay.getValue().floatValue();
                            velocityLeft2.element = animateDecay.getVelocity().floatValue();
                            if (Math.abs(delta - consumed) > 0.5f) {
                                animateDecay.cancelAnimation();
                            }
                            DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                            defaultFlingBehavior2.setLastAnimationCycleCount(defaultFlingBehavior2.getLastAnimationCycleCount() + 1);
                        }
                    }, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    defaultFlingBehavior$performFling$2 = this;
                    $result2 = $result;
                    velocityLeft = velocityLeft2;
                    f = velocityLeft.element;
                    return Boxing.boxFloat(f);
                }
                f = this.$initialVelocity;
                return Boxing.boxFloat(f);
            case 1:
                defaultFlingBehavior$performFling$2 = this;
                $result2 = $result;
                velocityLeft = (Ref.FloatRef) defaultFlingBehavior$performFling$2.L$0;
                ResultKt.throwOnFailure($result2);
                f = velocityLeft.element;
                return Boxing.boxFloat(f);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
