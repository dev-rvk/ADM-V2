package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: SnapFlingBehavior.kt */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0014\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0019H\u0002J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016JK\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102JS\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u00105J\u0014\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0002J(\u00108\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J(\u0010=\u001a\u0002H9\"\u000e\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:*\b\u0012\u0004\u0012\u0002H90;H\u0082\u0002¢\u0006\u0002\u0010<J)\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@J)\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001d\u0010B\u001a\u00020\u0006*\u00020.2\u0006\u0010?\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJ)\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-0,*\u00020.2\u0006\u0010)\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010@R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\u00020\u000eX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/material3/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;)V", "DefaultScrollMotionDurationScaleFactor", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "F", "itemSize", "getItemSize", "()F", "motionScaleDuration", "androidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1", "Landroidx/compose/material3/SnapFlingBehavior$motionScaleDuration$1;", "velocityThreshold", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "calculateDistanceToDesiredSnapPosition", "layoutInfo", "item", "equals", "", "other", "", "findClosestOffset", "velocity", "hashCode", "animateDecay", "Landroidx/compose/material3/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "fling", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longSnap", "performFling", "runApproach", "initialTargetOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapFlingBehavior implements FlingBehavior {
    private final float DefaultScrollMotionDurationScaleFactor;
    private final float MinFlingVelocityDp;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final Density density;
    private final LazyListState lazyListState;
    private SnapFlingBehavior$motionScaleDuration$1 motionScaleDuration;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final float velocityThreshold;

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1] */
    public SnapFlingBehavior(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec, Density density) {
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "decayAnimationSpec");
        Intrinsics.checkNotNullParameter(snapAnimationSpec, "snapAnimationSpec");
        Intrinsics.checkNotNullParameter(density, "density");
        this.lazyListState = lazyListState;
        this.decayAnimationSpec = decayAnimationSpec;
        this.snapAnimationSpec = snapAnimationSpec;
        this.density = density;
        Density $this$velocityThreshold_u24lambda_u241 = this.density;
        this.velocityThreshold = $this$velocityThreshold_u24lambda_u241.mo329toPx0680j_4(this.MinFlingVelocityDp);
        this.motionScaleDuration = new MotionDurationScale() { // from class: androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1
            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
                return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
                return (E) MotionDurationScale.DefaultImpls.get(this, key);
            }

            @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
            public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
                return MotionDurationScale.DefaultImpls.minusKey(this, key);
            }

            @Override // kotlin.coroutines.CoroutineContext
            public CoroutineContext plus(CoroutineContext context) {
                return MotionDurationScale.DefaultImpls.plus(this, context);
            }

            @Override // androidx.compose.ui.MotionDurationScale
            public float getScaleFactor() {
                float f;
                f = SnapFlingBehavior.this.DefaultScrollMotionDurationScaleFactor;
                return f;
            }
        };
        this.DefaultScrollMotionDurationScaleFactor = 1.0f;
        this.MinFlingVelocityDp = Dp.m5218constructorimpl(400);
    }

    private final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.lazyListState.getLayoutInfo().getVisibleItemsInfo();
    }

    private final float getItemSize() {
        if (!getVisibleItemsInfo().isEmpty()) {
            List $this$fastSumBy$iv = getVisibleItemsInfo();
            int sum$iv = 0;
            int size = $this$fastSumBy$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                Object item$iv$iv = $this$fastSumBy$iv.get(index$iv$iv);
                LazyListItemInfo it = (LazyListItemInfo) item$iv$iv;
                sum$iv += it.getSize();
            }
            return sum$iv / getVisibleItemsInfo().size();
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material3.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$performFling$1
            r0.<init>(r4, r7)
        L19:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            switch(r2) {
                case 0: goto L33;
                case 1: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2e:
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r0
            goto L40
        L33:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r4
            r7.label = r3
            java.lang.Object r5 = r2.fling(r5, r6, r7)
            if (r5 != r1) goto L40
            return r1
        L40:
            androidx.compose.material3.AnimationResult r5 = (androidx.compose.material3.AnimationResult) r5
            java.lang.Object r6 = r5.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.animation.core.AnimationState r5 = r5.component2()
            r1 = 0
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 != 0) goto L56
            goto L57
        L56:
            r3 = 0
        L57:
            if (r3 == 0) goto L5a
            goto L64
        L5a:
            java.lang.Object r6 = r5.getVelocity()
            java.lang.Number r6 = (java.lang.Number) r6
            float r1 = r6.floatValue()
        L64:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollScope r7, float r8, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = (androidx.compose.material3.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$fling$1 r0 = new androidx.compose.material3.SnapFlingBehavior$fling$1
            r0.<init>(r6, r9)
        L19:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L32;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2d:
            kotlin.ResultKt.throwOnFailure(r0)
            r7 = r0
            goto L4c
        L32:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            androidx.compose.material3.SnapFlingBehavior$motionScaleDuration$1 r3 = r2.motionScaleDuration
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            androidx.compose.material3.SnapFlingBehavior$fling$result$1 r4 = new androidx.compose.material3.SnapFlingBehavior$fling$result$1
            r5 = 0
            r4.<init>(r8, r2, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = 1
            r9.label = r5
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r9)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.material3.AnimationResult r7 = (androidx.compose.material3.AnimationResult) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object shortSnap(ScrollScope $this$shortSnap, float velocity, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        float closestOffset = findClosestOffset(0.0f, this.lazyListState);
        AnimationState animationState = AnimationStateKt.AnimationState$default(0.0f, velocity, 0L, 0L, false, 28, null);
        return animateSnap($this$shortSnap, closestOffset, closestOffset, animationState, this.snapAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object longSnap(androidx.compose.foundation.gestures.ScrollScope r22, float r23, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r24) {
        /*
            r21 = this;
            r0 = r24
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$longSnap$1
            if (r1 == 0) goto L19
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r1 = (androidx.compose.material3.SnapFlingBehavior$longSnap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L19
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r21
            goto L21
        L19:
            androidx.compose.material3.SnapFlingBehavior$longSnap$1 r1 = new androidx.compose.material3.SnapFlingBehavior$longSnap$1
            r2 = r21
            r1.<init>(r2, r0)
            r0 = r1
        L21:
            java.lang.Object r1 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L49;
                case 1: goto L3a;
                case 2: goto L34;
                default: goto L2c;
            }
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L34:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto Lc2
        L3a:
            java.lang.Object r3 = r0.L$1
            androidx.compose.foundation.gestures.ScrollScope r3 = (androidx.compose.foundation.gestures.ScrollScope) r3
            java.lang.Object r4 = r0.L$0
            androidx.compose.material3.SnapFlingBehavior r4 = (androidx.compose.material3.SnapFlingBehavior) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r5 = r3
            r3 = r4
            r4 = r1
            goto L8a
        L49:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r21
            r4 = r23
            r5 = r22
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r6 = r3.decayAnimationSpec
            r7 = 0
            float r6 = androidx.compose.animation.core.DecayAnimationSpecKt.calculateTargetValue(r6, r7, r4)
            float r6 = java.lang.Math.abs(r6)
            float r8 = r3.getItemSize()
            float r8 = r6 - r8
            float r6 = kotlin.ranges.RangesKt.coerceAtLeast(r8, r7)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r8 = 1
            if (r7 != 0) goto L6f
            r7 = r8
            goto L70
        L6f:
            r7 = 0
        L70:
            if (r7 == 0) goto L73
            goto L79
        L73:
            float r7 = java.lang.Math.signum(r4)
            float r6 = r6 * r7
        L79:
            r0.L$0 = r3
            r0.L$1 = r5
            r0.label = r8
            java.lang.Object r4 = r3.runApproach(r5, r6, r4, r0)
            if (r4 != r10) goto L8a
            return r10
        L8a:
            androidx.compose.material3.AnimationResult r4 = (androidx.compose.material3.AnimationResult) r4
            java.lang.Object r6 = r4.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.animation.core.AnimationState r4 = r4.component2()
            r19 = 30
            r20 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r11 = r4
            androidx.compose.animation.core.AnimationState r7 = androidx.compose.animation.core.AnimationStateKt.copy$default(r11, r12, r13, r14, r16, r18, r19, r20)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r8 = r3.snapAnimationSpec
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r4 = 2
            r0.label = r4
            r4 = r5
            r5 = r6
            r9 = r0
            java.lang.Object r3 = r3.animateSnap(r4, r5, r6, r7, r8, r9)
            if (r3 != r10) goto Lc2
            return r10
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.longSnap(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runApproach(androidx.compose.foundation.gestures.ScrollScope r21, float r22, float r23, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r24) {
        /*
            r20 = this;
            r0 = r24
            boolean r1 = r0 instanceof androidx.compose.material3.SnapFlingBehavior$runApproach$1
            if (r1 == 0) goto L19
            r1 = r0
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = (androidx.compose.material3.SnapFlingBehavior$runApproach$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L19
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r20
            goto L21
        L19:
            androidx.compose.material3.SnapFlingBehavior$runApproach$1 r1 = new androidx.compose.material3.SnapFlingBehavior$runApproach$1
            r2 = r20
            r1.<init>(r2, r0)
            r0 = r1
        L21:
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L3f;
                case 1: goto L34;
                default: goto L2c;
            }
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L34:
            r3 = 0
            java.lang.Object r4 = r0.L$0
            androidx.compose.material3.SnapFlingBehavior r4 = (androidx.compose.material3.SnapFlingBehavior) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r4
            r4 = r1
            goto L6e
        L3f:
            kotlin.ResultKt.throwOnFailure(r1)
            r10 = r20
            r5 = r22
            r4 = r21
            r12 = r23
            r18 = 28
            r19 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            androidx.compose.animation.core.AnimationState r11 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r11, r12, r13, r15, r17, r18, r19)
            r12 = 0
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r7 = r10.decayAnimationSpec
            r0.L$0 = r10
            r3 = 1
            r0.label = r3
            r3 = r10
            r6 = r11
            r8 = r0
            java.lang.Object r3 = r3.animateDecay(r4, r5, r6, r7, r8)
            if (r3 != r9) goto L6c
            return r9
        L6c:
            r4 = r3
            r3 = r12
        L6e:
            androidx.compose.material3.AnimationResult r4 = (androidx.compose.material3.AnimationResult) r4
            androidx.compose.animation.core.AnimationState r3 = r4.component2()
            java.lang.Object r4 = r3.getVelocity()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            androidx.compose.foundation.lazy.LazyListState r5 = r10.lazyListState
            float r4 = r10.findClosestOffset(r4, r5)
            androidx.compose.material3.AnimationResult r5 = new androidx.compose.material3.AnimationResult
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r5.<init>(r6, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.runApproach(androidx.compose.foundation.gestures.ScrollScope, float, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object other) {
        return (other instanceof SnapFlingBehavior) && Intrinsics.areEqual(((SnapFlingBehavior) other).snapAnimationSpec, this.snapAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).decayAnimationSpec, this.decayAnimationSpec) && Intrinsics.areEqual(((SnapFlingBehavior) other).lazyListState, this.lazyListState) && Intrinsics.areEqual(((SnapFlingBehavior) other).density, this.density);
    }

    public int hashCode() {
        int it = (0 * 31) + this.snapAnimationSpec.hashCode();
        return (((((it * 31) + this.decayAnimationSpec.hashCode()) * 31) + this.lazyListState.hashCode()) * 31) + this.density.hashCode();
    }

    private final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getStart();
    }

    private final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "<this>");
        return closedFloatingPointRange.getEndInclusive();
    }

    private static final boolean findClosestOffset$isValidDistance(float $this$findClosestOffset_u24isValidDistance) {
        if (!($this$findClosestOffset_u24isValidDistance == Float.POSITIVE_INFINITY)) {
            if (!($this$findClosestOffset_u24isValidDistance == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    private static final ClosedFloatingPointRange<Float> findClosestOffset$calculateSnappingOffsetBounds(LazyListState $lazyListState, SnapFlingBehavior this$0) {
        float lowerBoundOffset = Float.NEGATIVE_INFINITY;
        float upperBoundOffset = Float.POSITIVE_INFINITY;
        LazyListLayoutInfo $this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248 = $lazyListState.getLayoutInfo();
        List $this$fastForEach$iv = $this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248.getVisibleItemsInfo();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LazyListItemInfo item = (LazyListItemInfo) item$iv;
            float offset = this$0.calculateDistanceToDesiredSnapPosition($this$findClosestOffset_u24calculateSnappingOffsetBounds_u24lambda_u248, item);
            if (offset <= 0.0f && offset > lowerBoundOffset) {
                lowerBoundOffset = offset;
            }
            if (offset >= 0.0f && offset < upperBoundOffset) {
                upperBoundOffset = offset;
            }
        }
        return RangesKt.rangeTo(lowerBoundOffset, upperBoundOffset);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
    
        if (java.lang.Math.abs(r0) <= java.lang.Math.abs(r1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final float findClosestOffset(float r8, androidx.compose.foundation.lazy.LazyListState r9) {
        /*
            r7 = this;
            kotlin.ranges.ClosedFloatingPointRange r0 = findClosestOffset$calculateSnappingOffsetBounds(r9, r7)
            java.lang.Comparable r1 = r7.component1(r0)
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Comparable r0 = r7.component2(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r2 = java.lang.Math.signum(r8)
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L25
            r4 = r5
            goto L26
        L25:
            r4 = r6
        L26:
            if (r4 == 0) goto L36
            float r2 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r1)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L35
            goto L41
        L35:
            goto L4d
        L36:
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L3e
            r4 = r5
            goto L3f
        L3e:
            r4 = r6
        L3f:
            if (r4 == 0) goto L43
        L41:
            r2 = r0
            goto L50
        L43:
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L4a
            goto L4b
        L4a:
            r5 = r6
        L4b:
            if (r5 == 0) goto L4f
        L4d:
            r2 = r1
            goto L50
        L4f:
            r2 = r3
        L50:
            boolean r4 = findClosestOffset$isValidDistance(r2)
            if (r4 == 0) goto L59
            r3 = r2
            goto L5a
        L59:
        L5a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.findClosestOffset(float, androidx.compose.foundation.lazy.LazyListState):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateDecay(final androidx.compose.foundation.gestures.ScrollScope r8, final float r9, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r10, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r11, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = (androidx.compose.material3.SnapFlingBehavior$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SnapFlingBehavior$animateDecay$1 r0 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$1
            r0.<init>(r7, r12)
        L19:
            r12 = r0
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            switch(r2) {
                case 0: goto L3b;
                case 1: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2d:
            float r8 = r12.F$0
            java.lang.Object r9 = r12.L$1
            kotlin.jvm.internal.Ref$FloatRef r9 = (kotlin.jvm.internal.Ref.FloatRef) r9
            java.lang.Object r10 = r12.L$0
            androidx.compose.animation.core.AnimationState r10 = (androidx.compose.animation.core.AnimationState) r10
            kotlin.ResultKt.throwOnFailure(r0)
            goto L72
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r7
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            java.lang.Object r4 = r10.getVelocity()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r5 = 1
            if (r4 != 0) goto L58
            r4 = r5
            goto L59
        L58:
            r4 = 0
        L59:
            r4 = r4 ^ r5
            androidx.compose.material3.SnapFlingBehavior$animateDecay$2 r6 = new androidx.compose.material3.SnapFlingBehavior$animateDecay$2
            r6.<init>()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r12.L$0 = r10
            r12.L$1 = r3
            r12.F$0 = r9
            r12.label = r5
            java.lang.Object r8 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay(r10, r11, r4, r6, r12)
            if (r8 != r1) goto L70
            return r1
        L70:
            r8 = r9
            r9 = r3
        L72:
            androidx.compose.material3.AnimationResult r11 = new androidx.compose.material3.AnimationResult
            float r1 = r9.element
            float r1 = r8 - r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            r11.<init>(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> animationScope, ScrollScope $this_animateDecay, float delta) {
        float consumed = $this_animateDecay.scrollBy(delta);
        if (Math.abs(delta - consumed) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateSnap(final androidx.compose.foundation.gestures.ScrollScope r24, float r25, final float r26, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r27, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r28, kotlin.coroutines.Continuation<? super androidx.compose.material3.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r29) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnapFlingBehavior.animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float coerceToTarget(float $this$coerceToTarget, float target) {
        if (target == 0.0f) {
            return 0.0f;
        }
        return target > 0.0f ? RangesKt.coerceAtMost($this$coerceToTarget, target) : RangesKt.coerceAtLeast($this$coerceToTarget, target);
    }

    private final float calculateDistanceToDesiredSnapPosition(LazyListLayoutInfo layoutInfo, LazyListItemInfo item) {
        int containerSize = (getSingleAxisViewportSize(layoutInfo) - layoutInfo.getBeforeContentPadding()) - layoutInfo.getAfterContentPadding();
        float f = containerSize;
        float f2 = 2;
        float desiredDistance = (f / f2) - (item.getSize() / f2);
        int itemCurrentPosition = item.getOffset();
        return itemCurrentPosition - desiredDistance;
    }

    private final int getSingleAxisViewportSize(LazyListLayoutInfo $this$singleAxisViewportSize) {
        return $this$singleAxisViewportSize.getOrientation() == Orientation.Vertical ? IntSize.m5377getHeightimpl($this$singleAxisViewportSize.mo587getViewportSizeYbymL2g()) : IntSize.m5378getWidthimpl($this$singleAxisViewportSize.mo587getViewportSizeYbymL2g());
    }
}
