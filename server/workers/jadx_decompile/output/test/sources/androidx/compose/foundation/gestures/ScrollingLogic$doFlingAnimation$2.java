package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", i = {}, l = {500}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref.LongRef longRef, long j, Continuation<? super ScrollingLogic$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$result = longRef;
        this.$available = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ScrollingLogic scrollingLogic;
        Ref.LongRef longRef;
        ScrollingLogic scrollingLogic2;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                final ScrollingLogic scrollingLogic3 = this.this$0;
                final Function1 outerScopeScroll = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                        return Offset.m2699boximpl(m351invokeMKHz9U(offset.getPackedValue()));
                    }

                    /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
                    public final long m351invokeMKHz9U(long delta) {
                        return ScrollingLogic.this.m343reverseIfNeededMKHz9U(ScrollingLogic.this.m339dispatchScroll3eAAhYA($this$scroll, ScrollingLogic.this.m343reverseIfNeededMKHz9U(delta), NestedScrollSource.INSTANCE.m3966getFlingWNlRxjI()));
                    }
                };
                final ScrollingLogic scrollingLogic4 = this.this$0;
                ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1
                    @Override // androidx.compose.foundation.gestures.ScrollScope
                    public float scrollBy(float pixels) {
                        return ScrollingLogic.this.m347toFloatk4lQ0M(outerScopeScroll.invoke(Offset.m2699boximpl(ScrollingLogic.this.m348toOffsettuRUvjQ(pixels))).getPackedValue());
                    }
                };
                scrollingLogic = this.this$0;
                longRef = this.$result;
                long j2 = this.$available;
                FlingBehavior $this$invokeSuspend_u24lambda_u241_u24lambda_u240 = scrollingLogic.getFlingBehavior();
                long j3 = longRef.element;
                ScrollScope scrollScope2 = scrollScope;
                float reverseIfNeeded = scrollingLogic.reverseIfNeeded(scrollingLogic.m346toFloatTH1AsA0(j2));
                this.L$0 = scrollingLogic;
                this.L$1 = scrollingLogic;
                this.L$2 = longRef;
                this.J$0 = j3;
                this.label = 1;
                Object performFling = $this$invokeSuspend_u24lambda_u241_u24lambda_u240.performFling(scrollScope2, reverseIfNeeded, this);
                if (performFling != coroutine_suspended) {
                    $result = performFling;
                    scrollingLogic2 = scrollingLogic;
                    j = j3;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                j = this.J$0;
                longRef = (Ref.LongRef) this.L$2;
                scrollingLogic = (ScrollingLogic) this.L$1;
                ScrollingLogic scrollingLogic5 = (ScrollingLogic) this.L$0;
                ResultKt.throwOnFailure($result);
                scrollingLogic2 = scrollingLogic5;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef.element = scrollingLogic.m349updateQWom1Mo(j, scrollingLogic2.reverseIfNeeded(((Number) $result).floatValue()));
        return Unit.INSTANCE;
    }
}
