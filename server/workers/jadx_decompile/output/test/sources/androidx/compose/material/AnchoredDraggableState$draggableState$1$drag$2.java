package androidx.compose.material;

import androidx.compose.foundation.gestures.DragScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "it", "", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState$draggableState$1$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AnchoredDraggableState$draggableState$1$drag$2<T> extends SuspendLambda implements Function3<AnchoredDragScope, Map<T, ? extends Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    int label;
    final /* synthetic */ AnchoredDraggableState$draggableState$1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState$draggableState$1$drag$2(AnchoredDraggableState$draggableState$1<T> anchoredDraggableState$draggableState$1, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableState$draggableState$1$drag$2> continuation) {
        super(3, continuation);
        this.this$0 = anchoredDraggableState$draggableState$1;
        this.$block = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(AnchoredDragScope anchoredDragScope, Map<T, Float> map, Continuation<? super Unit> continuation) {
        return new AnchoredDraggableState$draggableState$1$drag$2(this.this$0, this.$block, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AnchoredDraggableState$draggableState$1$dragScope$1 $this$invokeSuspend_u24lambda_u240;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$invokeSuspend_u24lambda_u240 = ((AnchoredDraggableState$draggableState$1) this.this$0).dragScope;
                Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (function2.invoke($this$invokeSuspend_u24lambda_u240, this) != coroutine_suspended) {
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
