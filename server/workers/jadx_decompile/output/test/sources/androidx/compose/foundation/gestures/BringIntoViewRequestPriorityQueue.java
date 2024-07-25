package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: BringIntoViewRequestPriorityQueue.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J<\u0010\u0011\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010\u0019\u001a\u00020\u000bJ<\u0010\u001a\u001a\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/gestures/BringIntoViewRequestPriorityQueue;", "", "()V", "requests", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/gestures/ContentInViewModifier$Request;", "size", "", "getSize", "()I", "cancelAndRemoveAll", "", "cause", "", "enqueue", "", "request", "forEachFromSmallest", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "bounds", "isEmpty", "resumeAndRemoveAll", "resumeAndRemoveWhile", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    private final MutableVector<ContentInViewModifier.Request> requests = new MutableVector<>(new ContentInViewModifier.Request[16], 0);

    public final int getSize() {
        return this.requests.getSize();
    }

    public final boolean isEmpty() {
        return this.requests.isEmpty();
    }

    public final boolean enqueue(final ContentInViewModifier.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Rect requestBounds = request.getCurrentBounds().invoke();
        if (requestBounds == null) {
            CancellableContinuation<Unit> continuation = request.getContinuation();
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
            return false;
        }
        request.getContinuation().invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                BringIntoViewRequestPriorityQueue.this.requests.remove(request);
            }
        });
        MutableVector this_$iv = this.requests;
        IntRange intRange = new IntRange(0, this_$iv.getSize() - 1);
        int first = intRange.getFirst();
        int i = intRange.getLast();
        if (first <= i) {
            while (true) {
                MutableVector this_$iv2 = this.requests;
                ContentInViewModifier.Request r = this_$iv2.getContent()[i];
                Rect rBounds = r.getCurrentBounds().invoke();
                if (rBounds != null) {
                    Rect intersection = requestBounds.intersect(rBounds);
                    if (Intrinsics.areEqual(intersection, requestBounds)) {
                        this.requests.add(i + 1, request);
                        return true;
                    }
                    if (!Intrinsics.areEqual(intersection, rBounds)) {
                        CancellationException cause = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int j = this.requests.getSize() - 1;
                        if (j <= i) {
                            while (true) {
                                MutableVector this_$iv3 = this.requests;
                                this_$iv3.getContent()[i].getContinuation().cancel(cause);
                                if (j == i) {
                                    break;
                                }
                                j++;
                            }
                        }
                    }
                }
                if (i == first) {
                    break;
                }
                i--;
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void forEachFromSmallest(Function1<? super Rect, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = this.requests;
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = size$iv - 1;
        Object[] content$iv = this_$iv.getContent();
        do {
            ContentInViewModifier.Request it = (ContentInViewModifier.Request) content$iv[i$iv];
            block.invoke(it.getCurrentBounds().invoke());
            i$iv--;
        } while (i$iv >= 0);
    }

    public final void resumeAndRemoveAll() {
        MutableVector this_$iv = this.requests;
        IntRange intRange = new IntRange(0, this_$iv.getSize() - 1);
        int i = intRange.getFirst();
        int last = intRange.getLast();
        if (i <= last) {
            while (true) {
                MutableVector this_$iv2 = this.requests;
                CancellableContinuation<Unit> continuation = this_$iv2.getContent()[i].getContinuation();
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m5615constructorimpl(unit));
                if (i == last) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.requests.clear();
    }

    public final void resumeAndRemoveWhile(Function1<? super Rect, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        while (this.requests.isNotEmpty() && block.invoke(((ContentInViewModifier.Request) this.requests.last()).getCurrentBounds().invoke()).booleanValue()) {
            MutableVector mutableVector = this.requests;
            MutableVector this_$iv = this.requests;
            CancellableContinuation<Unit> continuation = ((ContentInViewModifier.Request) mutableVector.removeAt(this_$iv.getSize() - 1)).getContinuation();
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m5615constructorimpl(unit));
        }
    }

    public final void cancelAndRemoveAll(Throwable cause) {
        MutableVector this_$iv = this.requests;
        int size = this_$iv.getSize();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[size];
        for (int i = 0; i < size; i++) {
            ContentInViewModifier.Request it = this_$iv.getContent()[i];
            cancellableContinuationArr[i] = it.getContinuation();
        }
        for (CancellableContinuation cancellableContinuation : cancellableContinuationArr) {
            cancellableContinuation.cancel(cause);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
