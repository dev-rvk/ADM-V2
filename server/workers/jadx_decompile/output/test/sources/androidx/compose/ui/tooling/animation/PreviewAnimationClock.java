package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.clock.AnimateXAsStateClock;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import androidx.compose.ui.tooling.animation.clock.TransitionClock;
import androidx.compose.ui.tooling.animation.clock.UtilsKt;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewAnimationClock.kt */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u00105\u001a\u00020\u0004J\u001a\u00106\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u00107\u001a\u000208H\u0002J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000b2\u0006\u00107\u001a\u000208J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000208ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b>\u0010?J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u000b2\u0006\u00107\u001a\u0002082\u0006\u0010E\u001a\u00020AJ\u0010\u0010F\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u0010\u0010G\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0015J\u000e\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020AJ\u001a\u0010J\u001a\u00020\u00042\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020A0KJ\u000e\u0010L\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0001J\u0016\u0010M\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030NJ\u0012\u0010O\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030PJ\"\u0010Q\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030P2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J$\u0010S\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040UH\u0002J\u0016\u0010V\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030WJ\u000e\u0010X\u001a\u00020\u00042\u0006\u00107\u001a\u00020YJ\u0016\u0010Z\u001a\u00020\u00042\u000e\u00107\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030[J\u0012\u0010\\\u001a\u00020\u00042\n\u00107\u001a\u0006\u0012\u0002\b\u00030PJ\u0018\u0010]\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\tH\u0002J\u0016\u0010_\u001a\u00020\u00042\u0006\u0010=\u001a\u0002082\u0006\u0010`\u001a\u00020\u0001J\u001e\u0010a\u001a\u00020\u00042\u0006\u0010=\u001a\u0002082\u0006\u0010b\u001a\u00020\u00012\u0006\u0010c\u001a\u00020\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR8\u0010\u0011\u001a\u001e\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00140\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R(\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00010*j\b\u0012\u0004\u0012\u00020\u0001`+X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010,\u001a\u0012\u0012\u0004\u0012\u00020-0*j\b\u0012\u0004\u0012\u00020-`+8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u00100R0\u00101\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u000302\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u00128\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006d"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "DEBUG", "", "TAG", "", "allClocks", "", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "getAllClocks", "()Ljava/util/List;", "allClocksExceptInfinite", "getAllClocksExceptInfinite", "animateXAsStateClocks", "", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimateXAsStateClock;", "getAnimateXAsStateClocks$ui_tooling_release$annotations", "()V", "getAnimateXAsStateClocks$ui_tooling_release", "()Ljava/util/Map;", "animatedContentClocks", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "getAnimatedContentClocks$ui_tooling_release$annotations", "getAnimatedContentClocks$ui_tooling_release", "animatedVisibilityClocks", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "getAnimatedVisibilityClocks$ui_tooling_release$annotations", "getAnimatedVisibilityClocks$ui_tooling_release", "infiniteTransitionClocks", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/InfiniteTransitionClock;", "getInfiniteTransitionClocks$ui_tooling_release$annotations", "getInfiniteTransitionClocks$ui_tooling_release", "lock", "trackedAnimations", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "trackedUnsupportedAnimations", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "getTrackedUnsupportedAnimations$annotations", "getTrackedUnsupportedAnimations", "()Ljava/util/LinkedHashSet;", "transitionClocks", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "getTransitionClocks$ui_tooling_release$annotations", "getTransitionClocks$ui_tooling_release", "dispose", "findClock", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "getAnimatedProperties", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getAnimatedVisibilityState", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "composeAnimation", "getAnimatedVisibilityState-cc2g1to", "(Landroidx/compose/animation/tooling/ComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "notifySubscribe", "notifyUnsubscribe", "setClockTime", "animationTimeMillis", "setClockTimes", "", "trackAnimateContentSize", "trackAnimateXAsState", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimatedContent", "Landroidx/compose/animation/core/Transition;", "trackAnimatedVisibility", "onSeek", "trackAnimation", "createClockAndSubscribe", "Lkotlin/Function1;", "trackDecayAnimations", "Landroidx/compose/animation/core/DecayAnimation;", "trackInfiniteTransition", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackTargetBasedAnimations", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackTransition", "trackUnsupported", "label", "updateAnimatedVisibilityState", "state", "updateFromAndToStates", "fromState", "toState", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class PreviewAnimationClock {
    private final boolean DEBUG;
    private final String TAG;
    private final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> animateXAsStateClocks;
    private final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> animatedContentClocks;
    private final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks;
    private final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> infiniteTransitionClocks;
    private final Object lock;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final LinkedHashSet<Object> trackedAnimations;
    private final LinkedHashSet<UnsupportedComposeAnimation> trackedUnsupportedAnimations;
    private final Map<TransitionComposeAnimation<?>, TransitionClock<?>> transitionClocks;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewAnimationClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getAnimateXAsStateClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getAnimatedContentClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getAnimatedVisibilityClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getInfiniteTransitionClocks$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedUnsupportedAnimations$annotations() {
    }

    public static /* synthetic */ void getTransitionClocks$ui_tooling_release$annotations() {
    }

    public PreviewAnimationClock(Function0<Unit> setAnimationsTimeCallback) {
        Intrinsics.checkNotNullParameter(setAnimationsTimeCallback, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = setAnimationsTimeCallback;
        this.TAG = "PreviewAnimationClock";
        this.transitionClocks = new LinkedHashMap();
        this.animatedVisibilityClocks = new LinkedHashMap();
        this.animateXAsStateClocks = new LinkedHashMap();
        this.infiniteTransitionClocks = new LinkedHashMap();
        this.animatedContentClocks = new LinkedHashMap();
        this.trackedUnsupportedAnimations = new LinkedHashSet<>();
        this.trackedAnimations = new LinkedHashSet<>();
        this.lock = new Object();
    }

    public /* synthetic */ PreviewAnimationClock(AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0<Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : anonymousClass1);
    }

    public final Map<TransitionComposeAnimation<?>, TransitionClock<?>> getTransitionClocks$ui_tooling_release() {
        return this.transitionClocks;
    }

    public final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> getAnimatedVisibilityClocks$ui_tooling_release() {
        return this.animatedVisibilityClocks;
    }

    public final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> getAnimateXAsStateClocks$ui_tooling_release() {
        return this.animateXAsStateClocks;
    }

    public final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> getInfiniteTransitionClocks$ui_tooling_release() {
        return this.infiniteTransitionClocks;
    }

    public final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> getAnimatedContentClocks$ui_tooling_release() {
        return this.animatedContentClocks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ComposeAnimationClock<?, ?>> getAllClocksExceptInfinite() {
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) this.transitionClocks.values(), (Iterable) this.animatedVisibilityClocks.values()), (Iterable) this.animateXAsStateClocks.values()), (Iterable) this.animatedContentClocks.values());
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocks() {
        return CollectionsKt.plus((Collection) getAllClocksExceptInfinite(), (Iterable) this.infiniteTransitionClocks.values());
    }

    private final ComposeAnimationClock<?, ?> findClock(ComposeAnimation animation) {
        InfiniteTransitionClock infiniteTransitionClock = (TransitionClock) this.transitionClocks.get(animation);
        return (infiniteTransitionClock == null && (infiniteTransitionClock = this.animatedVisibilityClocks.get(animation)) == null && (infiniteTransitionClock = (AnimateXAsStateClock) this.animateXAsStateClocks.get(animation)) == null && (infiniteTransitionClock = this.infiniteTransitionClocks.get(animation)) == null) ? this.animatedContentClocks.get(animation) : infiniteTransitionClock;
    }

    public final void trackTransition(final Transition<?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackTransition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TransitionComposeAnimation it2 = TransitionComposeAnimationKt.parse(animation);
                if (it2 != null) {
                    PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.getTransitionClocks$ui_tooling_release().put(it2, new TransitionClock<>(it2));
                    previewAnimationClock.notifySubscribe(it2);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedVisibility$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            };
        }
        previewAnimationClock.trackAnimatedVisibility(transition, function0);
    }

    public final void trackAnimatedVisibility(final Transition<?> animation, final Function0<Unit> onSeek) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(onSeek, "onSeek");
        if (animation.getCurrentState() instanceof Boolean) {
            trackAnimation(animation, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedVisibility$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                    invoke2(p1);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Intrinsics.checkNotNull(animation, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
                    AnimatedVisibilityComposeAnimation composeAnimation = AnimatedVisibilityComposeAnimationKt.parseAnimatedVisibility(animation);
                    onSeek.invoke();
                    Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks$ui_tooling_release = this.getAnimatedVisibilityClocks$ui_tooling_release();
                    AnimatedVisibilityClock $this$invoke_u24lambda_u240 = new AnimatedVisibilityClock(composeAnimation);
                    $this$invoke_u24lambda_u240.setClockTime(0L);
                    animatedVisibilityClocks$ui_tooling_release.put(composeAnimation, $this$invoke_u24lambda_u240);
                    this.notifySubscribe(composeAnimation);
                }
            });
        }
    }

    public final void trackAnimateXAsState(final AnimationSearch.AnimateXAsStateSearchInfo<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation.getAnimatable(), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimateXAsState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AnimateXAsStateComposeAnimation it2 = AnimateXAsStateComposeAnimation.INSTANCE.parse$ui_tooling_release(animation);
                if (it2 != null) {
                    PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.getAnimateXAsStateClocks$ui_tooling_release().put(it2, new AnimateXAsStateClock<>(it2));
                    previewAnimationClock.notifySubscribe(it2);
                }
            }
        });
    }

    public final void trackAnimateContentSize(Object animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "animateContentSize");
    }

    public final void trackTargetBasedAnimations(TargetBasedAnimation<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "TargetBasedAnimation");
    }

    public final void trackDecayAnimations(DecayAnimation<?, ?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackUnsupported(animation, "DecayAnimation");
    }

    public final void trackAnimatedContent(final Transition<?> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackAnimatedContent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AnimatedContentComposeAnimation it2 = AnimatedContentComposeAnimation.INSTANCE.parseAnimatedContent(animation);
                if (it2 != null) {
                    PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.getAnimatedContentClocks$ui_tooling_release().put(it2, new TransitionClock<>(it2));
                    previewAnimationClock.notifySubscribe(it2);
                }
            }
        });
    }

    public final void trackInfiniteTransition(final AnimationSearch.InfiniteTransitionSearchInfo animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        trackAnimation(animation.getInfiniteTransition(), new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackInfiniteTransition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                InfiniteTransitionComposeAnimation it2 = InfiniteTransitionComposeAnimation.INSTANCE.parse$ui_tooling_release(AnimationSearch.InfiniteTransitionSearchInfo.this);
                if (it2 != null) {
                    final PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.getInfiniteTransitionClocks$ui_tooling_release().put(it2, new InfiniteTransitionClock(it2, new Function0<Long>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackInfiniteTransition$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Long invoke() {
                            List allClocksExceptInfinite;
                            Long valueOf;
                            allClocksExceptInfinite = PreviewAnimationClock.this.getAllClocksExceptInfinite();
                            Iterator it3 = allClocksExceptInfinite.iterator();
                            Long l = null;
                            if (it3.hasNext()) {
                                ComposeAnimationClock clock = (ComposeAnimationClock) it3.next();
                                valueOf = Long.valueOf(clock.getMaxDuration());
                                while (it3.hasNext()) {
                                    ComposeAnimationClock clock2 = (ComposeAnimationClock) it3.next();
                                    Long valueOf2 = Long.valueOf(clock2.getMaxDuration());
                                    if (valueOf.compareTo(valueOf2) < 0) {
                                        valueOf = valueOf2;
                                    }
                                }
                            } else {
                                valueOf = null;
                            }
                            Long l2 = valueOf;
                            long otherClockMaxDuration = l2 != null ? l2.longValue() : 0L;
                            Iterator<T> it4 = PreviewAnimationClock.this.getInfiniteTransitionClocks$ui_tooling_release().values().iterator();
                            if (it4.hasNext()) {
                                InfiniteTransitionClock clock3 = (InfiniteTransitionClock) it4.next();
                                l = Long.valueOf(clock3.getMaxDurationPerIteration());
                                while (it4.hasNext()) {
                                    InfiniteTransitionClock clock4 = (InfiniteTransitionClock) it4.next();
                                    Long valueOf3 = Long.valueOf(clock4.getMaxDurationPerIteration());
                                    if (l.compareTo(valueOf3) < 0) {
                                        l = valueOf3;
                                    }
                                }
                            }
                            Long l3 = l;
                            long infiniteMaxDurationPerIteration = l3 != null ? l3.longValue() : 0L;
                            return Long.valueOf(Math.max(otherClockMaxDuration, infiniteMaxDurationPerIteration));
                        }
                    }));
                    previewAnimationClock.notifySubscribe(it2);
                }
            }
        });
    }

    public final LinkedHashSet<UnsupportedComposeAnimation> getTrackedUnsupportedAnimations() {
        return this.trackedUnsupportedAnimations;
    }

    private final void trackUnsupported(Object animation, final String label) {
        trackAnimation(animation, new Function1<Object, Unit>() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$trackUnsupported$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                UnsupportedComposeAnimation it2 = UnsupportedComposeAnimation.INSTANCE.create(label);
                if (it2 != null) {
                    PreviewAnimationClock previewAnimationClock = this;
                    previewAnimationClock.getTrackedUnsupportedAnimations().add(it2);
                    previewAnimationClock.notifySubscribe(it2);
                }
            }
        });
    }

    private final boolean trackAnimation(Object animation, Function1<Object, Unit> createClockAndSubscribe) {
        synchronized (this.lock) {
            if (this.trackedAnimations.contains(animation)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "Animation " + animation + " is already being tracked");
                }
                return false;
            }
            this.trackedAnimations.add(animation);
            createClockAndSubscribe.invoke(animation);
            if (this.DEBUG) {
                Log.d(this.TAG, "Animation " + animation + " is now tracked");
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    protected void notifyUnsubscribe(ComposeAnimation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object fromState, Object toState) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        Intrinsics.checkNotNullParameter(toState, "toState");
        ComposeAnimationClock<?, ?> findClock = findClock(composeAnimation);
        if (findClock != null) {
            findClock.setStateParameters(fromState, toState);
        }
    }

    public final void updateAnimatedVisibilityState(ComposeAnimation composeAnimation, Object state) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(state, "state");
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        if (animatedVisibilityClock != null) {
            ComposeAnimationClock.setStateParameters$default(animatedVisibilityClock, state, null, 2, null);
        }
    }

    /* renamed from: getAnimatedVisibilityState-cc2g1to, reason: not valid java name */
    public final String m5148getAnimatedVisibilityStatecc2g1to(ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        return animatedVisibilityClock != null ? animatedVisibilityClock.getState() : AnimatedVisibilityState.INSTANCE.m5160getEnterjXw82LU();
    }

    public final long getMaxDuration() {
        Long l;
        Iterator<T> it = getAllClocks().iterator();
        if (it.hasNext()) {
            ComposeAnimationClock it2 = (ComposeAnimationClock) it.next();
            Long valueOf = Long.valueOf(it2.getMaxDuration());
            while (it.hasNext()) {
                ComposeAnimationClock it3 = (ComposeAnimationClock) it.next();
                Long valueOf2 = Long.valueOf(it3.getMaxDuration());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            l = valueOf;
        } else {
            l = null;
        }
        Long l2 = l;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0L;
    }

    public final long getMaxDurationPerIteration() {
        Long l;
        Iterator<T> it = getAllClocks().iterator();
        if (it.hasNext()) {
            ComposeAnimationClock it2 = (ComposeAnimationClock) it.next();
            Long valueOf = Long.valueOf(it2.getMaxDurationPerIteration());
            while (it.hasNext()) {
                ComposeAnimationClock it3 = (ComposeAnimationClock) it.next();
                Long valueOf2 = Long.valueOf(it3.getMaxDurationPerIteration());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            l = valueOf;
        } else {
            l = null;
        }
        Long l2 = l;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0L;
    }

    public final List<ComposeAnimatedProperty> getAnimatedProperties(ComposeAnimation animation) {
        List<ComposeAnimatedProperty> animatedProperties;
        Intrinsics.checkNotNullParameter(animation, "animation");
        ComposeAnimationClock<?, ?> findClock = findClock(animation);
        return (findClock == null || (animatedProperties = findClock.getAnimatedProperties()) == null) ? CollectionsKt.emptyList() : animatedProperties;
    }

    public final List<TransitionInfo> getTransitions(ComposeAnimation animation, long stepMillis) {
        List<TransitionInfo> transitions;
        Intrinsics.checkNotNullParameter(animation, "animation");
        ComposeAnimationClock<?, ?> findClock = findClock(animation);
        return (findClock == null || (transitions = findClock.getTransitions(stepMillis)) == null) ? CollectionsKt.emptyList() : transitions;
    }

    public final void setClockTime(long animationTimeMillis) {
        long timeNanos = UtilsKt.millisToNanos(animationTimeMillis);
        Iterable $this$forEach$iv = getAllClocks();
        for (Object element$iv : $this$forEach$iv) {
            ComposeAnimationClock it = (ComposeAnimationClock) element$iv;
            it.setClockTime(timeNanos);
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> animationTimeMillis) {
        Intrinsics.checkNotNullParameter(animationTimeMillis, "animationTimeMillis");
        for (Map.Entry element$iv : animationTimeMillis.entrySet()) {
            ComposeAnimation composeAnimation = element$iv.getKey();
            long millis = element$iv.getValue().longValue();
            ComposeAnimationClock<?, ?> findClock = findClock(composeAnimation);
            if (findClock != null) {
                findClock.setClockTime(UtilsKt.millisToNanos(millis));
            }
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void dispose() {
        Iterable $this$forEach$iv = getAllClocks();
        for (Object element$iv : $this$forEach$iv) {
            ComposeAnimationClock it = (ComposeAnimationClock) element$iv;
            notifyUnsubscribe(it.getAnimation());
        }
        Iterable $this$forEach$iv2 = this.trackedUnsupportedAnimations;
        for (Object element$iv2 : $this$forEach$iv2) {
            UnsupportedComposeAnimation it2 = (UnsupportedComposeAnimation) element$iv2;
            notifyUnsubscribe(it2);
        }
        this.trackedUnsupportedAnimations.clear();
        this.transitionClocks.clear();
        this.animatedVisibilityClocks.clear();
        this.trackedAnimations.clear();
    }
}
