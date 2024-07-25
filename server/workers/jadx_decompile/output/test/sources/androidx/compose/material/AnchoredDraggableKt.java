package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$draggable$1;
import androidx.compose.foundation.gestures.DraggableKt$draggable$2;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0001¢\u0006\u0002\u0010\u000e\u001aH\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0001\u001a3\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u0002H\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0007H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a7\u0010\u001d\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\rH\u0002¢\u0006\u0002\u0010!\u001a%\u0010\"\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001eH\u0002¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u001eH\u0002¢\u0006\u0002\u0010#\u001a)\u0010%\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001a\u001a\u0002H\u0002H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"rememberAnchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/AnchoredDraggableState;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "animateTo", "", "targetValue", "velocity", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closestAnchor", "", "offset", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "snapTo", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {
    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource) {
        Modifier draggable;
        Intrinsics.checkNotNullParameter($this$anchoredDraggable, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        draggable = DraggableKt.draggable($this$anchoredDraggable, state.getDraggableState(), orientation, (r20 & 4) != 0 ? true : enabled, (r20 & 8) != 0 ? null : interactionSource, (r20 & 16) != 0 ? false : state.isAnimationRunning(), (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : new AnchoredDraggableKt$anchoredDraggable$1(state, null), (r20 & 128) != 0 ? false : reverseDirection);
        return draggable;
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnchoredDraggableKt$snapTo$2(t, null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, continuation);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, float velocity, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnchoredDraggableKt$animateTo$2(t, anchoredDraggableState, velocity, null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    public static final <T> AnchoredDraggableState<T> rememberAnchoredDraggableState(final T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1812391462);
        ComposerKt.sourceInformation($composer, "C(rememberAnchoredDraggableState)P(2)611@25092L19,612@25166L17,613@25195L670:AnchoredDraggable.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmValueChange = new Function1<T, Boolean>() { // from class: androidx.compose.material.AnchoredDraggableKt$rememberAnchoredDraggableState$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(T it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                    return invoke((AnchoredDraggableKt$rememberAnchoredDraggableState$1<T>) obj);
                }
            };
            function1 = confirmValueChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1812391462, $changed, -1, "androidx.compose.material.rememberAnchoredDraggableState (AnchoredDraggable.kt:606)");
        }
        final Function1 positionalThreshold = AnchoredDraggableDefaults.INSTANCE.getPositionalThreshold($composer, 6);
        final Function0 velocityThreshold = AnchoredDraggableDefaults.INSTANCE.getVelocityThreshold($composer, 6);
        final AnimationSpec<Float> animationSpec3 = animationSpec;
        final Function1<? super T, Boolean> function12 = function1;
        AnchoredDraggableState<T> anchoredDraggableState = (AnchoredDraggableState) RememberSaveableKt.m2596rememberSaveable(new Object[]{initialValue, animationSpec, function1, positionalThreshold, velocityThreshold}, (Saver) AnchoredDraggableState.INSTANCE.Saver(animationSpec, function1, positionalThreshold, velocityThreshold), (String) null, (Function0) new Function0<AnchoredDraggableState<T>>() { // from class: androidx.compose.material.AnchoredDraggableKt$rememberAnchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AnchoredDraggableState<T> invoke() {
                return new AnchoredDraggableState<>(initialValue, positionalThreshold, velocityThreshold, animationSpec3, function12);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return anchoredDraggableState;
    }

    public static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    public static final <T> T closestAnchor(Map<T, Float> map, float f, boolean z) {
        if (!(!map.isEmpty())) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float floatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? floatValue - f : f - floatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                T next2 = it.next();
                float floatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? floatValue2 - f : f - floatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
        }
        return (T) ((Map.Entry) next).getKey();
    }

    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }
}
