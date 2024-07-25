package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Swipeable.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182#\b\u0002\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001aH\u0001¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010!\u001a\u0002H\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020#0\u001a2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0001¢\u0006\u0002\u0010$\u001a-\u0010%\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010'\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010(\u001a¹\u0001\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002*\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010028\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002030\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0011\u001a\u000206H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108\"*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00069"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/material3/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material3/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material3/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeableState;", "getOffset", "", "state", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material3/ThresholdConfig;", "resistance", "Landroidx/compose/material3/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwipeableKt {
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    public static final <T> SwipeableState<T> rememberSwipeableState(final T initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(102743774);
        ComposerKt.sourceInformation($composer, "C(rememberSwipeableState)P(2)472@19247L344:Swipeable.kt#uh7d8r");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec$material3_release();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmStateChange = new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableKt$rememberSwipeableState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((SwipeableKt$rememberSwipeableState$1<T>) obj);
                }
            };
            function1 = confirmStateChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(102743774, $changed, -1, "androidx.compose.material3.rememberSwipeableState (Swipeable.kt:467)");
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) SwipeableState.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<SwipeableState<T>>() { // from class: androidx.compose.material3.SwipeableKt$rememberSwipeableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SwipeableState<T> invoke() {
                return new SwipeableState<>(initialValue, animationSpec, function1);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableState;
    }

    public static final <T> SwipeableState<T> rememberSwipeableStateFor(final T value, final Function1<? super T, Unit> onValueChange, AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        $composer.startReplaceableGroup(1306709399);
        ComposerKt.sourceInformation($composer, "C(rememberSwipeableStateFor)P(2,1)501@20415L169,508@20615L34,509@20654L162,514@20821L259:Swipeable.kt#uh7d8r");
        AnimationSpec animationSpec2 = (i & 4) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec$material3_release() : animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1306709399, $changed, -1, "androidx.compose.material3.rememberSwipeableStateFor (Swipeable.kt:496)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new SwipeableState(value, animationSpec2, new Function1<T, Boolean>() { // from class: androidx.compose.material3.SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1<T>) obj);
                }
            });
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final SwipeableState swipeableState = (SwipeableState) value$iv$iv;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv2 = $composer.rememberedValue();
        if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        final MutableState forceAnimationCheck = (MutableState) value$iv$iv2;
        EffectsKt.LaunchedEffect(value, forceAnimationCheck.getValue(), new SwipeableKt$rememberSwipeableStateFor$1(value, swipeableState, null), $composer, ($changed & 8) | 512 | ($changed & 14));
        EffectsKt.DisposableEffect(swipeableState.getCurrentValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwipeableKt$rememberSwipeableStateFor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                if (!Intrinsics.areEqual(value, swipeableState.getCurrentValue())) {
                    onValueChange.invoke(swipeableState.getCurrentValue());
                    forceAnimationCheck.setValue(Boolean.valueOf(!forceAnimationCheck.getValue().booleanValue()));
                }
                return new DisposableEffectResult() { // from class: androidx.compose.material3.SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, $composer, $changed & 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableState;
    }

    /* renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m1806swipeablepPrIpRY(Modifier swipeable, final SwipeableState<T> state, final Map<Float, ? extends T> anchors, final Orientation orientation, final boolean enabled, final boolean reverseDirection, final MutableInteractionSource interactionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> thresholds, final ResistanceConfig resistance, final float velocityThreshold) {
        Intrinsics.checkNotNullParameter(swipeable, "$this$swipeable");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(thresholds, "thresholds");
        return ComposedModifierKt.composed(swipeable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("swipeable");
                $this$null.getProperties().set("state", SwipeableState.this);
                $this$null.getProperties().set("anchors", anchors);
                $this$null.getProperties().set("orientation", orientation);
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("reverseDirection", Boolean.valueOf(reverseDirection));
                $this$null.getProperties().set("interactionSource", interactionSource);
                $this$null.getProperties().set("thresholds", thresholds);
                $this$null.getProperties().set("resistance", resistance);
                $this$null.getProperties().set("velocityThreshold", Dp.m5216boximpl(velocityThreshold));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.SwipeableKt$swipeable$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0107  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r23, androidx.compose.runtime.Composer r24, int r25) {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwipeableKt$swipeable$3.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Swipeable.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.SwipeableKt$swipeable$3$3", f = "Swipeable.kt", i = {}, l = {603}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SwipeableKt$swipeable$3$3, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Map<Float, T> $anchors;
                final /* synthetic */ Density $density;
                final /* synthetic */ ResistanceConfig $resistance;
                final /* synthetic */ SwipeableState<T> $state;
                final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
                final /* synthetic */ float $velocityThreshold;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(SwipeableState<T> swipeableState, Map<Float, ? extends T> map, ResistanceConfig resistanceConfig, Density density, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$state = swipeableState;
                    this.$anchors = map;
                    this.$resistance = resistanceConfig;
                    this.$density = density;
                    this.$thresholds = function2;
                    this.$velocityThreshold = f;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Map oldAnchors = this.$state.getAnchors$material3_release();
                            this.$state.setAnchors$material3_release(this.$anchors);
                            this.$state.setResistance$material3_release(this.$resistance);
                            SwipeableState<T> swipeableState = this.$state;
                            final Map<Float, T> map = this.$anchors;
                            final Function2<T, T, ThresholdConfig> function2 = this.$thresholds;
                            final Density density = this.$density;
                            swipeableState.setThresholds$material3_release(new Function2<Float, Float, Float>() { // from class: androidx.compose.material3.SwipeableKt.swipeable.3.3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Float invoke(Float f, Float f2) {
                                    return invoke(f.floatValue(), f2.floatValue());
                                }

                                public final Float invoke(float a, float b) {
                                    Object from = MapsKt.getValue(map, Float.valueOf(a));
                                    Object to = MapsKt.getValue(map, Float.valueOf(b));
                                    ThresholdConfig $this$invoke_u24lambda_u240 = function2.invoke(from, to);
                                    return Float.valueOf($this$invoke_u24lambda_u240.computeThreshold(density, a, b));
                                }
                            });
                            Density $this$invokeSuspend_u24lambda_u240 = this.$density;
                            this.$state.setVelocityThreshold$material3_release($this$invokeSuspend_u24lambda_u240.mo329toPx0680j_4(this.$velocityThreshold));
                            this.label = 1;
                            if (this.$state.processNewAnchors$material3_release(oldAnchors, this.$anchors, this) != coroutine_suspended) {
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> findBounds(float offset, Set<Float> $this$filter$iv) {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            float it = ((Number) element$iv$iv).floatValue();
            if (((double) it) <= ((double) offset) + 0.001d) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Float a = CollectionsKt.maxOrNull(destination$iv$iv);
        Set<Float> $this$filter$iv2 = $this$filter$iv;
        int $i$f$filter = 0;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            float it2 = ((Number) element$iv$iv2).floatValue();
            Iterable $this$filter$iv3 = $this$filter$iv2;
            int $i$f$filter2 = $i$f$filter;
            if (((double) it2) >= ((double) offset) - 0.001d) {
                destination$iv$iv2.add(element$iv$iv2);
            }
            $this$filter$iv2 = $this$filter$iv3;
            $i$f$filter = $i$f$filter2;
        }
        Float b = CollectionsKt.minOrNull(destination$iv$iv2);
        if (a == null) {
            return CollectionsKt.listOfNotNull(b);
        }
        if (b == null) {
            return CollectionsKt.listOf(a);
        }
        return Intrinsics.areEqual(a, b) ? CollectionsKt.listOf(a) : CollectionsKt.listOf((Object[]) new Float[]{a, b});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeTarget(float offset, float lastValue, Set<Float> set, Function2<? super Float, ? super Float, Float> function2, float velocity, float velocityThreshold) {
        List bounds = findBounds(offset, set);
        switch (bounds.size()) {
            case 0:
                return lastValue;
            case 1:
                return bounds.get(0).floatValue();
            default:
                float lower = bounds.get(0).floatValue();
                float upper = bounds.get(1).floatValue();
                if (lastValue <= offset) {
                    if (velocity >= velocityThreshold) {
                        return upper;
                    }
                    float threshold = function2.invoke(Float.valueOf(lower), Float.valueOf(upper)).floatValue();
                    if (offset < threshold) {
                        return lower;
                    }
                } else {
                    if (velocity <= (-velocityThreshold)) {
                        return lower;
                    }
                    float threshold2 = function2.invoke(Float.valueOf(upper), Float.valueOf(lower)).floatValue();
                    if (offset <= threshold2) {
                        return lower;
                    }
                }
                return upper;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        Object element$iv;
        Iterable $this$firstOrNull$iv = map.entrySet();
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                Map.Entry it2 = (Map.Entry) element$iv;
                if (Intrinsics.areEqual(it2.getValue(), t)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Map.Entry entry = (Map.Entry) element$iv;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> swipeableState) {
        Intrinsics.checkNotNullParameter(swipeableState, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }
}
