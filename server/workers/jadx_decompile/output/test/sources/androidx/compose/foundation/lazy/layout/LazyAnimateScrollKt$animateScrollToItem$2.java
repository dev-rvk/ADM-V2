package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyAnimateScroll.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {137, 237}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* loaded from: classes.dex */
public final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyAnimateScrollKt$animateScrollToItem$2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$this_animateScrollToItem = lazyAnimateScrollScope;
        this.$scrollOffset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e1 A[Catch: ItemFoundInScroll -> 0x01ed, TryCatch #4 {ItemFoundInScroll -> 0x01ed, blocks: (B:18:0x00dd, B:20:0x00e1, B:22:0x00e9, B:28:0x0111), top: B:17:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x026a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0240  */
    /* JADX WARN: Type inference failed for: r13v1, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Type inference failed for: r4v11, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01ba -> B:14:0x01c2). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean forward, LazyAnimateScrollScope $this_animateScrollToItem, int $index, int $scrollOffset) {
        if (forward) {
            if ($this_animateScrollToItem.getFirstVisibleItemIndex() > $index) {
                return true;
            }
            return $this_animateScrollToItem.getFirstVisibleItemIndex() == $index && $this_animateScrollToItem.getFirstVisibleItemScrollOffset() > $scrollOffset;
        }
        if ($this_animateScrollToItem.getFirstVisibleItemIndex() < $index) {
            return true;
        }
        return $this_animateScrollToItem.getFirstVisibleItemIndex() == $index && $this_animateScrollToItem.getFirstVisibleItemScrollOffset() < $scrollOffset;
    }
}
