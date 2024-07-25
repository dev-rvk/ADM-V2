package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/TooltipSync;", "", "()V", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "getMutatorMutex", "()Landroidx/compose/foundation/MutatorMutex;", "mutexOwner", "Landroidx/compose/material3/TooltipState;", "getMutexOwner", "()Landroidx/compose/material3/TooltipState;", "setMutexOwner", "(Landroidx/compose/material3/TooltipState;)V", "dismissCurrentTooltip", "", "state", "(Landroidx/compose/material3/TooltipState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "persistent", "", "(Landroidx/compose/material3/TooltipState;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TooltipSync {
    public static final TooltipSync INSTANCE = new TooltipSync();
    private static final MutatorMutex mutatorMutex = new MutatorMutex();
    private static TooltipState mutexOwner;

    private TooltipSync() {
    }

    public final MutatorMutex getMutatorMutex() {
        return mutatorMutex;
    }

    public final TooltipState getMutexOwner() {
        return mutexOwner;
    }

    public final void setMutexOwner(TooltipState tooltipState) {
        mutexOwner = tooltipState;
    }

    public final Object show(final TooltipState state, boolean persistent, Continuation<? super Unit> continuation) {
        Function1 runBlock;
        Function0 cleanUp;
        if (state instanceof PlainTooltipState) {
            Function1 runBlock2 = new TooltipSync$show$2(state, null);
            runBlock = runBlock2;
            Function0 cleanUp2 = new Function0<Unit>() { // from class: androidx.compose.material3.TooltipSync$show$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((PlainTooltipState) TooltipState.this).setVisible$material3_release(false);
                }
            };
            cleanUp = cleanUp2;
        } else if (state instanceof RichTooltipState) {
            Function1 runBlock3 = new TooltipSync$show$4(persistent, state, null);
            runBlock = runBlock3;
            Function0 cleanUp3 = new Function0<Unit>() { // from class: androidx.compose.material3.TooltipSync$show$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((RichTooltipState) TooltipState.this).setVisible$material3_release(false);
                }
            };
            cleanUp = cleanUp3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object mutate = mutatorMutex.mutate(MutatePriority.Default, new TooltipSync$show$6(state, runBlock, cleanUp, null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    public final Object dismissCurrentTooltip(TooltipState state, Continuation<? super Unit> continuation) {
        Object mutate;
        return (Intrinsics.areEqual(state, mutexOwner) && (mutate = mutatorMutex.mutate(MutatePriority.UserInput, new TooltipSync$dismissCurrentTooltip$2(null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? mutate : Unit.INSTANCE;
    }
}
