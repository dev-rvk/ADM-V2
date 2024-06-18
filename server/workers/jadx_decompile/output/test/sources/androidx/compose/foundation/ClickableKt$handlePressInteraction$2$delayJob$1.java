package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", i = {1}, l = {293, 296}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
/* loaded from: classes.dex */
final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $delayPressInteraction;
    final /* synthetic */ AbstractClickableNode.InteractionData $interactionData;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $pressPoint;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2$delayJob$1(Function0<Boolean> function0, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode.InteractionData interactionData, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.$delayPressInteraction = function0;
        this.$pressPoint = j;
        this.$interactionSource = mutableInteractionSource;
        this.$interactionData = interactionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.$delayPressInteraction, this.$pressPoint, this.$interactionSource, this.$interactionData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            switch(r1) {
                case 0: goto L1f;
                case 1: goto L1a;
                case 2: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L11:
            r0 = r7
            java.lang.Object r1 = r0.L$0
            androidx.compose.foundation.interaction.PressInteraction$Press r1 = (androidx.compose.foundation.interaction.PressInteraction.Press) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L1a:
            r1 = r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L42
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            kotlin.jvm.functions.Function0<java.lang.Boolean> r2 = r1.$delayPressInteraction
            java.lang.Object r2 = r2.invoke()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L43
            long r2 = androidx.compose.foundation.Clickable_androidKt.getTapIndicationDelay()
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 1
            r1.label = r5
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r2, r4)
            if (r2 != r0) goto L42
            return r0
        L42:
        L43:
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r3 = r1.$pressPoint
            r5 = 0
            r2.<init>(r3, r5)
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = r1.$interactionSource
            r4 = r2
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.L$0 = r2
            r6 = 2
            r1.label = r6
            java.lang.Object r3 = r3.emit(r4, r5)
            if (r3 != r0) goto L5f
            return r0
        L5f:
            r0 = r1
            r1 = r2
        L61:
            androidx.compose.foundation.AbstractClickableNode$InteractionData r2 = r0.$interactionData
            r2.setPressInteraction(r1)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
