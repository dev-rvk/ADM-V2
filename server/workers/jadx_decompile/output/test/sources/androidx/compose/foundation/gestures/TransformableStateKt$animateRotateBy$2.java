package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
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

/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TransformableStateKt$animateRotateBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ float $degrees;
    final /* synthetic */ Ref.FloatRef $previous;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animateRotateBy$2(Ref.FloatRef floatRef, float f, AnimationSpec<Float> animationSpec, Continuation<? super TransformableStateKt$animateRotateBy$2> continuation) {
        super(2, continuation);
        this.$previous = floatRef;
        this.$degrees = f;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableStateKt$animateRotateBy$2 transformableStateKt$animateRotateBy$2 = new TransformableStateKt$animateRotateBy$2(this.$previous, this.$degrees, this.$animationSpec, continuation);
        transformableStateKt$animateRotateBy$2.L$0 = obj;
        return transformableStateKt$animateRotateBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animateRotateBy$2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object animateTo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final TransformScope $this$transform = (TransformScope) this.L$0;
                AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0L, 0L, false, 30, null);
                Float boxFloat = Boxing.boxFloat(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2.1
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
                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animateTo2) {
                        Intrinsics.checkNotNullParameter(animateTo2, "$this$animateTo");
                        float delta = animateTo2.getValue().floatValue() - Ref.FloatRef.this.element;
                        TransformScope.m356transformByd4ec7I$default($this$transform, 0.0f, 0L, delta, 3, null);
                        Ref.FloatRef.this.element = animateTo2.getValue().floatValue();
                    }
                };
                this.label = 1;
                animateTo = SuspendAnimationKt.animateTo(AnimationState$default, boxFloat, (r12 & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec, (r12 & 4) != 0 ? false : false, (r12 & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                        invoke((AnimationScope) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<T, V> animationScope) {
                        Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                    }
                } : function1, this);
                if (animateTo != coroutine_suspended) {
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
