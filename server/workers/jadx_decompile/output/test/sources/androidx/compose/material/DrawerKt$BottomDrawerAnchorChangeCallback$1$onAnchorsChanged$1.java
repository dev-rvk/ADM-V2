package androidx.compose.material;

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

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1", f = "Drawer.kt", i = {}, l = {949}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomDrawerValue $newTarget;
    final /* synthetic */ BottomDrawerState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1(BottomDrawerState bottomDrawerState, BottomDrawerValue bottomDrawerValue, Continuation<? super DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1> continuation) {
        super(2, continuation);
        this.$state = bottomDrawerState;
        this.$newTarget = bottomDrawerValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1(this.$state, this.$newTarget, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DrawerKt$BottomDrawerAnchorChangeCallback$1$onAnchorsChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$state.animateTo$material_release(this.$newTarget, this.$state.getLastVelocity$material_release(), this) != coroutine_suspended) {
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
