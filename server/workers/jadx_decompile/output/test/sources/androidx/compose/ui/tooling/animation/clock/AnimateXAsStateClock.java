package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation;
import androidx.compose.ui.tooling.animation.states.TargetState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimateXAsStateClock.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060\u0004B\u0019\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0002J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001c2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\fH\u0016J\u001a\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000@BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u0015\"\u0004\b\u0013\u0010\u0014R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Landroidx/compose/ui/tooling/animation/clock/AnimateXAsStateClock;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "animation", "(Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "value", "", "clockTimeNanos", "setClockTimeNanos", "(J)V", "currAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "currentValue", "setCurrentValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/TargetState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/TargetState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getCurrentAnimation", "getMaxDuration", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "", "par2", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AnimateXAsStateClock<T, V extends AnimationVector> implements ComposeAnimationClock<AnimateXAsStateComposeAnimation<T, V>, TargetState<T>> {
    private final AnimateXAsStateComposeAnimation<T, V> animation;
    private long clockTimeNanos;
    private TargetBasedAnimation<T, V> currAnimation;
    private T currentValue;
    private TargetState<T> state;

    public AnimateXAsStateClock(AnimateXAsStateComposeAnimation<T, V> animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.animation = animation;
        this.state = new TargetState<>(getAnimation().m5144getAnimationObject().getValue(), getAnimation().m5144getAnimationObject().getValue());
        this.currentValue = getAnimation().getToolingState().getValue();
        this.currAnimation = getCurrentAnimation();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public AnimateXAsStateComposeAnimation<T, V> getAnimation() {
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
        this.currAnimation = getCurrentAnimation();
        setClockTime(0L);
    }

    private final void setCurrentValue(T t) {
        this.currentValue = t;
        getAnimation().getToolingState().setValue(t);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
        Intrinsics.checkNotNullParameter(par1, "par1");
        TargetState it = UtilsKt.parseParametersToValue(this.currentValue, par1, par2);
        if (it != null) {
            setState(it);
        }
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        String label = getAnimation().getLabel();
        T t = this.currentValue;
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
        return CollectionsKt.listOf(new ComposeAnimatedProperty(label, t));
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        return UtilsKt.nanosToMillis(this.currAnimation.getDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        return UtilsKt.nanosToMillis(this.currAnimation.getDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<TransitionInfo> getTransitions(long stepMillis) {
        return CollectionsKt.listOf(UtilsKt.createTransitionInfo(this.currAnimation, getAnimation().getLabel(), getAnimation().getAnimationSpec(), stepMillis));
    }

    private final void setClockTimeNanos(long value) {
        this.clockTimeNanos = value;
        setCurrentValue(this.currAnimation.getValueFromNanos(value));
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        setClockTimeNanos(animationTimeNanos);
    }

    private final TargetBasedAnimation<T, V> getCurrentAnimation() {
        return AnimationKt.TargetBasedAnimation(getAnimation().getAnimationSpec(), getAnimation().m5144getAnimationObject().getTypeConverter(), getState().getInitial(), getState().getTarget(), getAnimation().m5144getAnimationObject().getVelocity());
    }
}
