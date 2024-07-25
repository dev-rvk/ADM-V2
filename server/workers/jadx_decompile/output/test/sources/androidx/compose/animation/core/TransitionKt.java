package androidx.compose.animation.core;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0088\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0085\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0085\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020!0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020#0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0085\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020%0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0088\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020'0\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a©\u0001\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010-\u001a_\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010/\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0000¢\u0006\u0002\u00101\u001aA\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u00103\u001a\u0002H\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\u0006\u00104\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00105\u001aa\u00106\u001a\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)07R\b\u0012\u0004\u0012\u0002H\u000f0\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u00108\u001am\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u0010:\u001a\u0002H\u00042\u0006\u0010;\u001a\u0002H\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006>"}, d2 = {"AnimationDebugDurationScale", "", "updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    public static final <T> Transition<T> updateTransition(T t, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(2029166765);
        ComposerKt.sourceInformation($composer, "C(updateTransition)P(1)71@2945L51,72@3012L22,73@3068L195,73@3039L224:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:67)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Transition(t, label);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Transition transition = (Transition) value$iv$iv;
        transition.animateTo$animation_core_release(t, $composer, ($changed & 8) | 48 | ($changed & 14));
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transition);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.onTransitionEnd$animation_core_release();
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition;
    }

    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> transitionState, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(transitionState, "transitionState");
        $composer.startReplaceableGroup(882913843);
        ComposerKt.sourceInformation($composer, "C(updateTransition)P(1)154@6617L94,157@6727L38,158@6799L195,158@6770L224:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:150)");
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transitionState);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Transition((MutableTransitionState) transitionState, label);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Transition transition = (Transition) value$iv$iv;
        transition.animateTo$animation_core_release(transitionState.getTargetState(), $composer, 0);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(transition);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.onTransitionEnd$animation_core_release();
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> transition, TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-1714122528);
        ComposerKt.sourceInformation($composer, "C(createDeferredAnimation)P(1)753@29670L58,754@29733L102:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, $changed, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:749)");
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transition);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Transition.DeferredAnimation(transition, typeConverter, label);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Transition.DeferredAnimation lazyAnim = (Transition.DeferredAnimation) value$iv$iv;
        EffectsKt.DisposableEffect(lazyAnim, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final Transition<S> transition2 = transition;
                final Transition<S>.DeferredAnimation<T, V> deferredAnimation = lazyAnim;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        Transition.this.removeAnimation$animation_core_release(deferredAnimation);
                    }
                };
            }
        }, $composer, 0);
        if (transition.isSeeking()) {
            lazyAnim.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazyAnim;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> transformToChildState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(transformToChildState, "transformToChildState");
        $composer.startReplaceableGroup(1215497572);
        ComposerKt.sourceInformation($composer, "CC(createChildTransition)786@31174L36,787@31234L74,788@31331L39,789@31382L63:Transition.kt#pdpnli");
        if ((i & 1) != 0) {
            label = "ChildTransition";
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transition);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = transition.getCurrentState();
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Object initialParentState = value$iv$iv;
        Object initialState = transformToChildState.invoke(transition.isSeeking() ? transition.getCurrentState() : initialParentState, $composer, Integer.valueOf(($changed >> 3) & 112));
        Object targetState = transformToChildState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed >> 3) & 112));
        Transition<T> createChildTransitionInternal = createChildTransitionInternal(transition, initialState, targetState, label, $composer, ($changed & 14) | (($changed << 6) & 7168));
        $composer.endReplaceableGroup();
        return createChildTransitionInternal;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> transition, T t, T t2, String childLabel, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(childLabel, "childLabel");
        $composer.startReplaceableGroup(-198307638);
        ComposerKt.sourceInformation($composer, "C(createChildTransitionInternal)P(1,2)799@31645L110,803@31790L112,803@31761L141,817@32124L25:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, $changed, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:794)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transition);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Transition(new MutableTransitionState(t), transition.getLabel() + " > " + childLabel);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Transition transition2 = (Transition) value$iv$iv;
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(transition) | $composer.changed(transition2);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv2, $composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t, t2, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t2, $composer, (($changed >> 3) & 8) | (($changed >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> typeConverter, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 2) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<T>>() { // from class: androidx.compose.animation.core.TransitionKt$animateValue$1
            public final SpringSpec<T> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-895531546);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-895531546, $changed2, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:852)");
                }
                SpringSpec<T> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 4) == 0) {
            label2 = label;
        } else {
            label2 = "ValueAnimation";
        }
        Object initialValue = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed >> 9) & 112));
        Object targetValue = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed >> 9) & 112));
        FiniteAnimationSpec<T> animationSpec = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed >> 3) & 112));
        State<T> createTransitionAnimation = createTransitionAnimation(transition, initialValue, targetValue, animationSpec, typeConverter, label2, $composer, ($changed & 14) | (57344 & ($changed << 9)) | (($changed << 6) & 458752));
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(final Transition<S> transition, T t, T t2, FiniteAnimationSpec<T> animationSpec, TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(label, "label");
        $composer.startReplaceableGroup(-304821198);
        ComposerKt.sourceInformation($composer, "C(createTransitionAnimation)P(1,3!1,4)873@34678L499,896@35561L128,896@35523L166:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, $changed, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:866)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(transition);
        Object value$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new Transition.TransitionAnimationState(transition, t, AnimationStateKt.createZeroVectorFrom(typeConverter, t2), typeConverter, label);
            $composer.updateRememberedValue(value$iv$iv2);
        }
        $composer.endReplaceableGroup();
        final Transition.TransitionAnimationState transitionAnimation = (Transition.TransitionAnimationState) value$iv$iv2;
        if (transition.isSeeking()) {
            transitionAnimation.updateInitialAndTargetValue$animation_core_release(t, t2, animationSpec);
        } else {
            transitionAnimation.updateTargetValue$animation_core_release(t2, animationSpec);
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed(transition) | $composer.changed(transitionAnimation);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    transition.addAnimation$animation_core_release(transitionAnimation);
                    final Transition<S> transition2 = transition;
                    final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState = transitionAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Transition.this.removeAnimation$animation_core_release(transitionAnimationState);
                        }
                    };
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transitionAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transitionAnimation;
    }

    public static final <S> State<Float> animateFloat(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Float> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation($composer, "CC(animateFloat)P(2)939@37552L78:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Float>>() { // from class: androidx.compose.animation.core.TransitionKt$animateFloat$1
            public final SpringSpec<Float> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-522164544);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-522164544, $changed2, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:935)");
                }
                SpringSpec<Float> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "FloatAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Float> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Float> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Dp> animateDp(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Dp> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(184732935);
        ComposerKt.sourceInformation($composer, "CC(animateDp)P(2)970@39266L75:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Dp>>() { // from class: androidx.compose.animation.core.TransitionKt$animateDp$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Dp> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Dp> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-575880366);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-575880366, $changed2, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:964)");
                }
                SpringSpec<Dp> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m5216boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "DpAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Dp> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Dp> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Offset> animateOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Offset> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(2078477582);
        ComposerKt.sourceInformation($composer, "CC(animateOffset)P(2)1001@41006L79:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Offset>>() { // from class: androidx.compose.animation.core.TransitionKt$animateOffset$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Offset> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Offset> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(1623385561);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1623385561, $changed2, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:995)");
                }
                SpringSpec<Offset> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m2699boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "OffsetAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(Offset.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Offset> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Offset> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Size> animateSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Size> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(-802210820);
        ComposerKt.sourceInformation($composer, "CC(animateSize)P(2)1032@42735L77:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Size>>() { // from class: androidx.compose.animation.core.TransitionKt$animateSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Size> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Size> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-1607152761);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1607152761, $changed2, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:1026)");
                }
                SpringSpec<Size> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m2767boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "SizeAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(Size.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Size> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Size> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, IntOffset> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(776131825);
        ComposerKt.sourceInformation($composer, "CC(animateIntOffset)P(2)1063@44483L82:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntOffset>>() { // from class: androidx.compose.animation.core.TransitionKt$animateIntOffset$1
            public final SpringSpec<IntOffset> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-1953479610);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1953479610, $changed2, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:1059)");
                }
                SpringSpec<IntOffset> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m5327boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<IntOffset> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "IntOffsetAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<IntOffset> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<IntOffset> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Integer> animateInt(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Integer> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(1318902782);
        ComposerKt.sourceInformation($composer, "CC(animateInt)P(2)1094@46186L76:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Integer>>() { // from class: androidx.compose.animation.core.TransitionKt$animateInt$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Integer> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }

            public final SpringSpec<Integer> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-785273069);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-785273069, $changed2, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:1088)");
                }
                SpringSpec<Integer> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "IntAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Integer> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Integer> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, IntSize> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(-2104123233);
        ComposerKt.sourceInformation($composer, "CC(animateIntSize)P(2)1124@47915L80:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.core.TransitionKt$animateIntSize$1
            public final SpringSpec<IntSize> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(967893300);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(967893300, $changed2, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:1120)");
                }
                SpringSpec<IntSize> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5370boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "IntSizeAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<IntSize> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<IntSize> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Rect> animateRect(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Rect> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(1496278239);
        ComposerKt.sourceInformation($composer, "CC(animateRect)P(2)1154@49641L77:Transition.kt#pdpnli");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Rect>>() { // from class: androidx.compose.animation.core.TransitionKt$animateRect$1
            public final SpringSpec<Rect> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(691336298);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(691336298, $changed2, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:1150)");
                }
                SpringSpec<Rect> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Rect> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "RectAnimation";
        }
        TwoWayConverter typeConverter$iv = VectorConvertersKt.getVectorConverter(Rect.INSTANCE);
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Rect> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Rect> createTransitionAnimation = createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }
}
