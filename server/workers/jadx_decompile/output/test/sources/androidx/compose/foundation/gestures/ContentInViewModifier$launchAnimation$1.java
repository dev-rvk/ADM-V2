package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentInViewModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1", f = "ContentInViewModifier.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class ContentInViewModifier$launchAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$launchAnimation$1(ContentInViewModifier contentInViewModifier, Continuation<? super ContentInViewModifier$launchAnimation$1> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1 = new ContentInViewModifier$launchAnimation$1(this.this$0, continuation);
        contentInViewModifier$launchAnimation$1.L$0 = obj;
        return contentInViewModifier$launchAnimation$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$launchAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        ContentInViewModifier$launchAnimation$1 contentInViewModifier$launchAnimation$1;
        CancellationException cancellationException;
        ScrollableState scrollableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                Job animationJob = JobKt.getJob($this$launch.getCoroutineContext());
                try {
                    this.this$0.isAnimationRunning = true;
                    scrollableState = this.this$0.scrollState;
                    this.label = 1;
                    if (ScrollableState.scroll$default(scrollableState, null, new AnonymousClass1(this.this$0, animationJob, null), this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    contentInViewModifier$launchAnimation$1 = this;
                    cancellationException = null;
                    contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                    contentInViewModifier$launchAnimation$1.this$0.isAnimationRunning = false;
                    contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                    contentInViewModifier$launchAnimation$1.this$0.trackingFocusedChild = false;
                    return Unit.INSTANCE;
                } catch (CancellationException e) {
                    e = e;
                    contentInViewModifier$launchAnimation$1 = this;
                    cancellationException = e;
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    contentInViewModifier$launchAnimation$1 = this;
                    cancellationException = null;
                    contentInViewModifier$launchAnimation$1.this$0.isAnimationRunning = false;
                    contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                    contentInViewModifier$launchAnimation$1.this$0.trackingFocusedChild = false;
                    throw e;
                }
            case 1:
                contentInViewModifier$launchAnimation$1 = this;
                cancellationException = null;
                try {
                    try {
                        ResultKt.throwOnFailure($result);
                        contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.resumeAndRemoveAll();
                        contentInViewModifier$launchAnimation$1.this$0.isAnimationRunning = false;
                        contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                        contentInViewModifier$launchAnimation$1.this$0.trackingFocusedChild = false;
                        return Unit.INSTANCE;
                    } catch (CancellationException e2) {
                        e = e2;
                        cancellationException = e;
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    contentInViewModifier$launchAnimation$1.this$0.isAnimationRunning = false;
                    contentInViewModifier$launchAnimation$1.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                    contentInViewModifier$launchAnimation$1.this$0.trackingFocusedChild = false;
                    throw e;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContentInViewModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1", f = "ContentInViewModifier.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $animationJob;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewModifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContentInViewModifier contentInViewModifier, Job job, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = contentInViewModifier;
            this.$animationJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            UpdatableAnimationState updatableAnimationState;
            float calculateScrollDelta;
            UpdatableAnimationState updatableAnimationState2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final ScrollScope $this$scroll = (ScrollScope) this.L$0;
                    updatableAnimationState = this.this$0.animationState;
                    calculateScrollDelta = this.this$0.calculateScrollDelta();
                    updatableAnimationState.setValue(calculateScrollDelta);
                    updatableAnimationState2 = this.this$0.animationState;
                    final ContentInViewModifier contentInViewModifier = this.this$0;
                    final Job job = this.$animationJob;
                    Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                            invoke(f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float delta) {
                            boolean z;
                            z = ContentInViewModifier.this.reverseDirection;
                            float scrollMultiplier = z ? 1.0f : -1.0f;
                            float adjustedDelta = scrollMultiplier * delta;
                            float consumedScroll = $this$scroll.scrollBy(adjustedDelta) * scrollMultiplier;
                            if (consumedScroll < delta) {
                                JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + consumedScroll + " < " + delta + ')', null, 2, null);
                            }
                        }
                    };
                    final ContentInViewModifier contentInViewModifier2 = this.this$0;
                    this.label = 1;
                    if (updatableAnimationState2.animateToZero(function1, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier.launchAnimation.1.1.2
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
                            boolean z;
                            UpdatableAnimationState updatableAnimationState3;
                            float calculateScrollDelta2;
                            Rect focusedChildBounds;
                            BringIntoViewRequestPriorityQueue this_$iv = ContentInViewModifier.this.bringIntoViewRequests;
                            ContentInViewModifier contentInViewModifier3 = ContentInViewModifier.this;
                            while (true) {
                                if (!this_$iv.requests.isNotEmpty()) {
                                    break;
                                }
                                Rect bounds = ((ContentInViewModifier.Request) this_$iv.requests.last()).getCurrentBounds().invoke();
                                if (!(bounds == null ? true : ContentInViewModifier.m252isMaxVisibleO0kMr_c$default(contentInViewModifier3, bounds, 0L, 1, null))) {
                                    break;
                                }
                                MutableVector mutableVector = this_$iv.requests;
                                MutableVector this_$iv$iv = this_$iv.requests;
                                CancellableContinuation<Unit> continuation = ((ContentInViewModifier.Request) mutableVector.removeAt(this_$iv$iv.getSize() - 1)).getContinuation();
                                Unit unit = Unit.INSTANCE;
                                Result.Companion companion = Result.INSTANCE;
                                continuation.resumeWith(Result.m5615constructorimpl(unit));
                            }
                            z = ContentInViewModifier.this.trackingFocusedChild;
                            if (z) {
                                focusedChildBounds = ContentInViewModifier.this.getFocusedChildBounds();
                                if (focusedChildBounds != null && ContentInViewModifier.m252isMaxVisibleO0kMr_c$default(ContentInViewModifier.this, focusedChildBounds, 0L, 1, null)) {
                                    ContentInViewModifier.this.trackingFocusedChild = false;
                                }
                            }
                            updatableAnimationState3 = ContentInViewModifier.this.animationState;
                            calculateScrollDelta2 = ContentInViewModifier.this.calculateScrollDelta();
                            updatableAnimationState3.setValue(calculateScrollDelta2);
                        }
                    }, this) != coroutine_suspended) {
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
}
