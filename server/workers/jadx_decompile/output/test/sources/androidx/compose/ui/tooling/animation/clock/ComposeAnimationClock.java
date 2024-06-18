package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ComposeAnimationClock.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H&J\u001c\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00028\u0001X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "T", "Landroidx/compose/animation/tooling/ComposeAnimation;", "TState", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "", "animation", "getAnimation", "()Landroidx/compose/animation/tooling/ComposeAnimation;", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "par2", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface ComposeAnimationClock<T extends ComposeAnimation, TState extends ComposeAnimationState> {
    List<ComposeAnimatedProperty> getAnimatedProperties();

    T getAnimation();

    long getMaxDuration();

    long getMaxDurationPerIteration();

    TState getState();

    List<TransitionInfo> getTransitions(long stepMillis);

    void setClockTime(long animationTimeNanos);

    void setState(TState tstate);

    void setStateParameters(Object par1, Object par2);

    static /* synthetic */ void setStateParameters$default(ComposeAnimationClock composeAnimationClock, Object obj, Object obj2, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStateParameters");
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        composeAnimationClock.setStateParameters(obj, obj2);
    }
}
