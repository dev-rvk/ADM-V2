package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfiniteTransition.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000e\u001aY\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0007\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0011*\u00020\u0012*\u00020\u00012\u0006\u0010\t\u001a\u0002H\u00102\u0006\u0010\n\u001a\u0002H\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00100\fH\u0007¢\u0006\u0002\u0010\u0015\u001ac\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0007\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0011*\u00020\u0012*\u00020\u00012\u0006\u0010\t\u001a\u0002H\u00102\u0006\u0010\n\u001a\u0002H\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "animateFloat", "Landroidx/compose/runtime/State;", "", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InfiniteTransitionKt {
    public static final InfiniteTransition rememberInfiniteTransition(String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1013651573);
        ComposerKt.sourceInformation($composer, "C(rememberInfiniteTransition)45@1981L38,46@2043L5:InfiniteTransition.kt#pdpnli");
        if ((i & 1) != 0) {
            label = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013651573, $changed, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new InfiniteTransition(label);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) value$iv$iv;
        infiniteTransition.run$animation_core_release($composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return infiniteTransition;
    }

    public static final <T, V extends AnimationVector> State<T> animateValue(final InfiniteTransition $this$animateValue, final T t, final T t2, TwoWayConverter<T, V> typeConverter, final InfiniteRepeatableSpec<T> animationSpec, String label, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter($this$animateValue, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(-1062847727);
        ComposerKt.sourceInformation($composer, "C(animateValue)P(1,3,4)262@10743L151,268@10900L357,280@11263L166:InfiniteTransition.kt#pdpnli");
        String label2 = (i & 16) != 0 ? "ValueAnimation" : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062847727, $changed, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:254)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object value$iv$iv = $composer.rememberedValue();
        if (value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new InfiniteTransition.TransitionAnimationState($this$animateValue, t, t2, typeConverter, animationSpec, label2);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        final InfiniteTransition.TransitionAnimationState transitionAnimation = (InfiniteTransition.TransitionAnimationState) value$iv$iv;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (!Intrinsics.areEqual(t, transitionAnimation.getInitialValue$animation_core_release()) || !Intrinsics.areEqual(t2, transitionAnimation.getTargetValue$animation_core_release())) {
                    transitionAnimation.updateValues$animation_core_release(t, t2, animationSpec);
                }
            }
        }, $composer, 0);
        EffectsKt.DisposableEffect(transitionAnimation, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                InfiniteTransition.this.addAnimation$animation_core_release(transitionAnimation);
                final InfiniteTransition infiniteTransition = InfiniteTransition.this;
                final InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState = transitionAnimation;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        InfiniteTransition.this.removeAnimation$animation_core_release(transitionAnimationState);
                    }
                };
            }
        }, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transitionAnimation;
    }

    public static final State<Float> animateFloat(InfiniteTransition $this$animateFloat, float initialValue, float targetValue, InfiniteRepeatableSpec<Float> animationSpec, String label, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter($this$animateFloat, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(-644770905);
        ComposerKt.sourceInformation($composer, "C(animateFloat)P(1,3)316@12588L84:InfiniteTransition.kt#pdpnli");
        String label2 = (i & 8) != 0 ? "FloatAnimation" : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-644770905, $changed, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:310)");
        }
        State<Float> animateValue = animateValue($this$animateFloat, Float.valueOf(initialValue), Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec, label2, $composer, ($changed & 112) | 8 | ($changed & 896) | (($changed << 3) & 57344) | (458752 & ($changed << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "rememberInfiniteTransition APIs now have a new label parameter added.")
    public static final /* synthetic */ InfiniteTransition rememberInfiniteTransition(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-840193660);
        ComposerKt.sourceInformation($composer, "C(rememberInfiniteTransition)324@12880L48:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-840193660, $changed, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:323)");
        }
        InfiniteTransition rememberInfiniteTransition = rememberInfiniteTransition("InfiniteTransition", $composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberInfiniteTransition;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateValue APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValue(InfiniteTransition $this$animateValue, Object initialValue, Object targetValue, TwoWayConverter typeConverter, InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$animateValue, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(-1695411770);
        ComposerKt.sourceInformation($composer, "C(animateValue)P(1,2,3)338@13274L202:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695411770, $changed, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:332)");
        }
        State animateValue = animateValue($this$animateValue, initialValue, targetValue, typeConverter, animationSpec, "ValueAnimation", $composer, ((($changed >> 3) & 8) << 3) | 196616 | ($changed & 112) | ((($changed >> 3) & 8) << 6) | ($changed & 896) | ($changed & 7168) | (57344 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateFloat APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloat(InfiniteTransition $this$animateFloat, float initialValue, float targetValue, InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$animateFloat, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(469472752);
        ComposerKt.sourceInformation($composer, "C(animateFloat)P(1,2)357@13770L155:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469472752, $changed, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:352)");
        }
        State<Float> animateFloat = animateFloat($this$animateFloat, initialValue, targetValue, animationSpec, "FloatAnimation", $composer, ($changed & 112) | 24584 | ($changed & 896) | ($changed & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateFloat;
    }
}
