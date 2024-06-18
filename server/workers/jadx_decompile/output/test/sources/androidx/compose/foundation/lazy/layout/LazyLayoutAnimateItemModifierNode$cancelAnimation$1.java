package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.unit.IntOffset;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$cancelAnimation$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode$cancelAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutAnimateItemModifierNode$cancelAnimation$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, Continuation<? super LazyLayoutAnimateItemModifierNode$cancelAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimateItemModifierNode$cancelAnimation$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimateItemModifierNode$cancelAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Animatable animatable;
        LazyLayoutAnimateItemModifierNode$cancelAnimation$1 lazyLayoutAnimateItemModifierNode$cancelAnimation$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                animatable = this.this$0.placementDeltaAnimation;
                this.label = 1;
                if (animatable.snapTo(IntOffset.m5327boximpl(IntOffset.INSTANCE.m5346getZeronOccac()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lazyLayoutAnimateItemModifierNode$cancelAnimation$1 = this;
                break;
            case 1:
                lazyLayoutAnimateItemModifierNode$cancelAnimation$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lazyLayoutAnimateItemModifierNode$cancelAnimation$1.this$0.m627setPlacementDeltagyyYBs(IntOffset.INSTANCE.m5346getZeronOccac());
        lazyLayoutAnimateItemModifierNode$cancelAnimation$1.this$0.setAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
