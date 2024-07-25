package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.TransitionBasedAnimation;
import androidx.compose.ui.tooling.animation.states.TargetState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransitionClock.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0002B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR0\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "T", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "animation", "(Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "value", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/TargetState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/TargetState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "", "par2", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransitionClock<T> implements ComposeAnimationClock<TransitionBasedAnimation<T>, TargetState<T>> {
    private final TransitionBasedAnimation<T> animation;
    private TargetState<T> state;

    public TransitionClock(TransitionBasedAnimation<T> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.animation = animation;
        this.state = new TargetState<>(getAnimation().m5145getAnimationObject().getCurrentState(), getAnimation().m5145getAnimationObject().getTargetState());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public TransitionBasedAnimation<T> getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public TargetState<T> getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setState(TargetState<T> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state = value;
        setClockTime(0L);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
        Intrinsics.checkNotNullParameter(par1, "par1");
        TargetState it = UtilsKt.parseParametersToValue(getState().getInitial(), par1, par2);
        if (it != null) {
            setState(it);
        }
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        Iterable $this$mapNotNull$iv = UtilsKt.allAnimations(getAnimation().m5145getAnimationObject());
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Transition.TransitionAnimationState it = (Transition.TransitionAnimationState) element$iv$iv$iv;
            Object value = it.getValue();
            ComposeAnimatedProperty composeAnimatedProperty = value == null ? null : new ComposeAnimatedProperty(it.getLabel(), value);
            if (composeAnimatedProperty != null) {
                destination$iv$iv.add(composeAnimatedProperty);
            }
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (T t : $this$filter$iv) {
            if (!UtilsKt.getIGNORE_TRANSITIONS().contains(((ComposeAnimatedProperty) t).getLabel())) {
                destination$iv$iv2.add(t);
            }
        }
        return (List) destination$iv$iv2;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        return UtilsKt.nanosToMillis(getAnimation().m5145getAnimationObject().getTotalDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        return UtilsKt.nanosToMillis(getAnimation().m5145getAnimationObject().getTotalDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<TransitionInfo> getTransitions(long stepMillis) {
        Transition transition = getAnimation().m5145getAnimationObject();
        Iterable $this$map$iv = UtilsKt.allAnimations(transition);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Transition.TransitionAnimationState it = (Transition.TransitionAnimationState) item$iv$iv;
            destination$iv$iv.add(UtilsKt.createTransitionInfo(it, stepMillis));
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (T t : $this$filter$iv) {
            TransitionInfo it2 = (TransitionInfo) t;
            if (!UtilsKt.getIGNORE_TRANSITIONS().contains(it2.getLabel())) {
                destination$iv$iv2.add(t);
            }
        }
        return (List) destination$iv$iv2;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        getAnimation().m5145getAnimationObject().seek(getState().getInitial(), getState().getTarget(), animationTimeNanos);
    }
}
