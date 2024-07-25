package androidx.compose.animation.core;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendAnimation.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001as\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001av\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010$\u001ap\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(\u001az\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*\u001aZ\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a\u0085\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0085\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4;
        AnimationSpec animationSpec2;
        if ((i & 4) == 0) {
            f4 = f3;
        } else {
            f4 = 0.0f;
        }
        if ((i & 8) == 0) {
            animationSpec2 = animationSpec;
        } else {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(f, f2, f4, animationSpec2, function2, continuation);
    }

    public static final Object animate(float initialValue, float targetValue, float initialVelocity, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(initialValue), Boxing.boxFloat(targetValue), Boxing.boxFloat(initialVelocity), animationSpec, function2, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float initialValue, float initialVelocity, FloatDecayAnimationSpec animationSpec, final Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        DecayAnimation anim = AnimationKt.DecayAnimation(animationSpec, initialValue, initialVelocity);
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(initialValue, initialVelocity, 0L, 0L, false, 28, null), anim, 0L, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                invoke2(animationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimationScope<Float, AnimationVector1D> animate) {
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                function2.invoke(animate.getValue(), Float.valueOf(animate.getVelocityVector().getValue()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        Object obj5;
        AnimationSpec animationSpec2;
        if ((i & 8) == 0) {
            obj5 = obj3;
        } else {
            obj5 = null;
        }
        if ((i & 16) == 0) {
            animationSpec2 = animationSpec;
        } else {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animate(twoWayConverter, obj, obj2, obj5, animationSpec2, function2, continuation);
    }

    public static final <T, V extends AnimationVector> Object animate(final TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3, AnimationSpec<T> animationSpec, final Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        V invoke;
        AnimationVector initialVelocityVector = (t3 == null || (invoke = twoWayConverter.getConvertToVector().invoke(t3)) == null) ? AnimationVectorsKt.newInstance(twoWayConverter.getConvertToVector().invoke(t)) : invoke;
        TargetBasedAnimation anim = new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, initialVelocityVector);
        Object animate$default = animate$default(new AnimationState(twoWayConverter, t, initialVelocityVector, 0L, 0L, false, 56, null), anim, 0L, new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke((AnimationScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(AnimationScope<T, V> animate) {
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                function2.invoke(animate.getValue(), twoWayConverter.getConvertFromVector().invoke(animate.getVelocityVector()));
            }
        }, continuation, 2, null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        return animateTo(animationState, obj, (i & 2) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null) : animationSpec, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke((AnimationScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(AnimationScope<T, V> animationScope) {
                Intrinsics.checkNotNullParameter(animationScope, "$this$null");
            }
        } : function1, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> animationState, T t, AnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        TargetBasedAnimation anim = new TargetBasedAnimation(animationSpec, animationState.getTypeConverter(), animationState.getValue(), t, animationState.getVelocityVector());
        Object animate = animate(animationState, anim, sequentialAnimation ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                    invoke((AnimationScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        DecayAnimation anim = new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter) animationState.getTypeConverter(), (Object) animationState.getValue(), (AnimationVector) animationState.getVelocityVector());
        Object animate = animate(animationState, anim, sequentialAnimation ? animationState.getLastFrameTimeNanos() : Long.MIN_VALUE, function1, continuation);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|82|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005c, code lost:
    
        r21 = true;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0024. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129 A[Catch: CancellationException -> 0x015a, TRY_LEAVE, TryCatch #5 {CancellationException -> 0x015a, blocks: (B:17:0x011c, B:19:0x0129), top: B:16:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, androidx.compose.animation.core.AnimationScope] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.AnimationState<T, V> r22, final androidx.compose.animation.core.Animation<T, V> r23, long r24, final kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        long j2;
        Function1 function12;
        if ((i & 2) == 0) {
            j2 = j;
        } else {
            j2 = Long.MIN_VALUE;
        }
        if ((i & 4) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                    invoke((AnimationScope) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<T, V> animationScope) {
                    Intrinsics.checkNotNullParameter(animationScope, "$this$null");
                }
            };
        }
        return animate(animationState, animation, j2, function12, continuation);
    }

    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> animation, final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        if (animation.getIsInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(function1, continuation);
        }
        return MonotonicFrameClockKt.withFrameNanos(new Function1<Long, R>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Long l) {
                return invoke(l.longValue());
            }

            public final R invoke(long it) {
                return function1.invoke(Long.valueOf(it / 1));
            }
        }, continuation);
    }

    public static final float getDurationScale(CoroutineContext $this$durationScale) {
        Intrinsics.checkNotNullParameter($this$durationScale, "<this>");
        MotionDurationScale motionDurationScale = (MotionDurationScale) $this$durationScale.get(MotionDurationScale.INSTANCE);
        float scale = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (!(scale >= 0.0f)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return scale;
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> state) {
        Intrinsics.checkNotNullParameter(animationScope, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        state.setValue$animation_core_release(animationScope.getValue());
        AnimationVectorsKt.copyFrom(state.getVelocityVector(), animationScope.getVelocityVector());
        state.setFinishedTimeNanos$animation_core_release(animationScope.getFinishedTimeNanos());
        state.setLastFrameTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
        state.setRunning$animation_core_release(animationScope.isRunning());
    }

    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long frameTimeNanos, float durationScale, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        long playTimeNanos;
        if (durationScale == 0.0f) {
            playTimeNanos = animation.getDurationNanos();
        } else {
            playTimeNanos = ((float) (frameTimeNanos - animationScope.getStartTimeNanos())) / durationScale;
        }
        doAnimationFrame(animationScope, frameTimeNanos, playTimeNanos, animation, animationState, function1);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> animationScope, long frameTimeNanos, long playTimeNanos, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        animationScope.setLastFrameTimeNanos$animation_core_release(frameTimeNanos);
        animationScope.setValue$animation_core_release(animation.getValueFromNanos(playTimeNanos));
        animationScope.setVelocityVector$animation_core_release(animation.getVelocityVectorFromNanos(playTimeNanos));
        boolean isLastFrame = animation.isFinishedFromNanos(playTimeNanos);
        if (isLastFrame) {
            animationScope.setFinishedTimeNanos$animation_core_release(animationScope.getLastFrameTimeNanos());
            animationScope.setRunning$animation_core_release(false);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }
}
