package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
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

/* compiled from: CommonRipple.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2", f = "CommonRipple.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class CommonRippleIndicationInstance$addRipple$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressInteraction.Press $interaction;
    final /* synthetic */ RippleAnimation $rippleAnimation;
    int label;
    final /* synthetic */ CommonRippleIndicationInstance this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRippleIndicationInstance$addRipple$2(RippleAnimation rippleAnimation, CommonRippleIndicationInstance commonRippleIndicationInstance, PressInteraction.Press press, Continuation<? super CommonRippleIndicationInstance$addRipple$2> continuation) {
        super(2, continuation);
        this.$rippleAnimation = rippleAnimation;
        this.this$0 = commonRippleIndicationInstance;
        this.$interaction = press;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonRippleIndicationInstance$addRipple$2(this.$rippleAnimation, this.this$0, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonRippleIndicationInstance$addRipple$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Throwable th;
        CommonRippleIndicationInstance$addRipple$2 commonRippleIndicationInstance$addRipple$2;
        SnapshotStateMap snapshotStateMap;
        SnapshotStateMap snapshotStateMap2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    this.label = 1;
                    if (this.$rippleAnimation.animate(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    commonRippleIndicationInstance$addRipple$2 = this;
                    snapshotStateMap2 = commonRippleIndicationInstance$addRipple$2.this$0.ripples;
                    snapshotStateMap2.remove(commonRippleIndicationInstance$addRipple$2.$interaction);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    commonRippleIndicationInstance$addRipple$2 = this;
                    snapshotStateMap = commonRippleIndicationInstance$addRipple$2.this$0.ripples;
                    snapshotStateMap.remove(commonRippleIndicationInstance$addRipple$2.$interaction);
                    throw th;
                }
            case 1:
                commonRippleIndicationInstance$addRipple$2 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    snapshotStateMap2 = commonRippleIndicationInstance$addRipple$2.this$0.ripples;
                    snapshotStateMap2.remove(commonRippleIndicationInstance$addRipple$2.$interaction);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    snapshotStateMap = commonRippleIndicationInstance$addRipple$2.this$0.ripples;
                    snapshotStateMap.remove(commonRippleIndicationInstance$addRipple$2.$interaction);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
