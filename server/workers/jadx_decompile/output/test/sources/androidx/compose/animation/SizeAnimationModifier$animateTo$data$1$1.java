package androidx.compose.animation;

import androidx.compose.animation.SizeAnimationModifier;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnimationModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.animation.SizeAnimationModifier$animateTo$data$1$1", f = "AnimationModifier.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class SizeAnimationModifier$animateTo$data$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $targetSize;
    final /* synthetic */ SizeAnimationModifier.AnimData $this_apply;
    int label;
    final /* synthetic */ SizeAnimationModifier this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SizeAnimationModifier$animateTo$data$1$1(SizeAnimationModifier.AnimData animData, long j, SizeAnimationModifier sizeAnimationModifier, Continuation<? super SizeAnimationModifier$animateTo$data$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = animData;
        this.$targetSize = j;
        this.this$0 = sizeAnimationModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SizeAnimationModifier$animateTo$data$1$1(this.$this_apply, this.$targetSize, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SizeAnimationModifier$animateTo$data$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        SizeAnimationModifier$animateTo$data$1$1 sizeAnimationModifier$animateTo$data$1$1;
        Object animateTo;
        Function2<IntSize, IntSize, Unit> listener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sizeAnimationModifier$animateTo$data$1$1 = this;
                Animatable<IntSize, AnimationVector2D> anim = sizeAnimationModifier$animateTo$data$1$1.$this_apply.getAnim();
                IntSize m5370boximpl = IntSize.m5370boximpl(sizeAnimationModifier$animateTo$data$1$1.$targetSize);
                AnimationSpec<IntSize> animSpec = sizeAnimationModifier$animateTo$data$1$1.this$0.getAnimSpec();
                sizeAnimationModifier$animateTo$data$1$1.label = 1;
                animateTo = anim.animateTo(m5370boximpl, (r12 & 2) != 0 ? anim.defaultSpringSpec : animSpec, (r12 & 4) != 0 ? anim.getVelocity() : null, (r12 & 8) != 0 ? null : null, sizeAnimationModifier$animateTo$data$1$1);
                if (animateTo != coroutine_suspended) {
                    $result = animateTo;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                sizeAnimationModifier$animateTo$data$1$1 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult result = (AnimationResult) $result;
        if (result.getEndReason() == AnimationEndReason.Finished && (listener = sizeAnimationModifier$animateTo$data$1$1.this$0.getListener()) != 0) {
            listener.invoke(IntSize.m5370boximpl(sizeAnimationModifier$animateTo$data$1$1.$this_apply.m77getStartSizeYbymL2g()), result.getEndState().getValue());
        }
        return Unit.INSTANCE;
    }
}
