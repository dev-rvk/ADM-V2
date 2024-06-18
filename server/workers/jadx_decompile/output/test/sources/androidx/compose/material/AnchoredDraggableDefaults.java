package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Landroidx/compose/material/AnchoredDraggableDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec$annotations", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "getPositionalThreshold$annotations", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "velocityThreshold", "Lkotlin/Function0;", "getVelocityThreshold$annotations", "getVelocityThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "ReconcileAnimationOnAnchorChangedCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "T", "state", "Landroidx/compose/material/AnchoredDraggableState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ReconcileAnimationOnAnchorChangedCallback$material_release", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnchoredDraggableDefaults {
    public static final AnchoredDraggableDefaults INSTANCE = new AnchoredDraggableDefaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, null, 7, null);

    public static /* synthetic */ void getAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getPositionalThreshold$annotations() {
    }

    public static /* synthetic */ void getVelocityThreshold$annotations() {
    }

    private AnchoredDraggableDefaults() {
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    public final Function0<Float> getVelocityThreshold(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(2030704141);
        ComposerKt.sourceInformation($composer, "C*654@26591L7,654@26602L17:AnchoredDraggable.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030704141, $changed, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-velocityThreshold> (AnchoredDraggable.kt:654)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density $this$_get_velocityThreshold__u24lambda_u241 = (Density) consume;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed($this$_get_velocityThreshold__u24lambda_u241);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function0<Float>() { // from class: androidx.compose.material.AnchoredDraggableDefaults$velocityThreshold$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(Density.this.mo329toPx0680j_4(Dp.m5218constructorimpl(125)));
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function0<Float> function0 = (Function0) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function0;
    }

    public final Function1<Float, Float> getPositionalThreshold(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(82866976);
        ComposerKt.sourceInformation($composer, "C*663@26944L7,664@26967L16:AnchoredDraggable.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(82866976, $changed, -1, "androidx.compose.material.AnchoredDraggableDefaults.<get-positionalThreshold> (AnchoredDraggable.kt:663)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density $this$_get_positionalThreshold__u24lambda_u243 = (Density) consume;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed($this$_get_positionalThreshold__u24lambda_u243);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function1<Float, Float>() { // from class: androidx.compose.material.AnchoredDraggableDefaults$positionalThreshold$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final Float invoke(float it) {
                    return Float.valueOf(Density.this.mo329toPx0680j_4(Dp.m5218constructorimpl(56)));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Float f) {
                    return invoke(f.floatValue());
                }
            };
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function1<Float, Float> function1 = (Function1) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function1;
    }

    public final <T> AnchoredDraggableState.AnchorChangedCallback<T> ReconcileAnimationOnAnchorChangedCallback$material_release(final AnchoredDraggableState<T> state, final CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new AnchoredDraggableState.AnchorChangedCallback<T>() { // from class: androidx.compose.material.AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1
            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(T t, Map<T, Float> previousAnchors, Map<T, Float> newAnchors) {
                Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = previousAnchors.get(t);
                Float newTargetOffset = newAnchors.get(t);
                if (Intrinsics.areEqual(previousTargetOffset, newTargetOffset)) {
                    return;
                }
                if (newTargetOffset != null) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$1(state, t, null), 3, null);
                } else {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnchoredDraggableDefaults$ReconcileAnimationOnAnchorChangedCallback$1$onAnchorsChanged$2(state, newAnchors, null), 3, null);
                }
            }
        };
    }
}
