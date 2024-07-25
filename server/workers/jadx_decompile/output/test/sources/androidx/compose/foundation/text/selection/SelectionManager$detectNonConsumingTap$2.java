package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", i = {}, l = {627}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class SelectionManager$detectNonConsumingTap$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectionManager$detectNonConsumingTap$2(Function1<? super Offset, Unit> function1, Continuation<? super SelectionManager$detectNonConsumingTap$2> continuation) {
        super(2, continuation);
        this.$onTap = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionManager$detectNonConsumingTap$2 selectionManager$detectNonConsumingTap$2 = new SelectionManager$detectNonConsumingTap$2(this.$onTap, continuation);
        selectionManager$detectNonConsumingTap$2.L$0 = obj;
        return selectionManager$detectNonConsumingTap$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((SelectionManager$detectNonConsumingTap$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        SelectionManager$detectNonConsumingTap$2 selectionManager$detectNonConsumingTap$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                selectionManager$detectNonConsumingTap$2 = this;
                AwaitPointerEventScope $this$awaitEachGesture = (AwaitPointerEventScope) selectionManager$detectNonConsumingTap$2.L$0;
                selectionManager$detectNonConsumingTap$2.label = 1;
                Object waitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default($this$awaitEachGesture, null, selectionManager$detectNonConsumingTap$2, 1, null);
                if (waitForUpOrCancellation$default != coroutine_suspended) {
                    $result = waitForUpOrCancellation$default;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                selectionManager$detectNonConsumingTap$2 = this;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerInputChange it = (PointerInputChange) $result;
        if (it != null) {
            selectionManager$detectNonConsumingTap$2.$onTap.invoke(Offset.m2699boximpl(it.getPosition()));
        }
        return Unit.INSTANCE;
    }
}
