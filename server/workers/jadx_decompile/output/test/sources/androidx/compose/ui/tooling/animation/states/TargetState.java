package androidx.compose.ui.tooling.animation.states;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TargetState.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J(\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/tooling/animation/states/TargetState;", "T", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "initial", "target", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitial", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTarget", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/ui/tooling/animation/states/TargetState;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TargetState<T> implements ComposeAnimationState {
    private final T initial;
    private final T target;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TargetState copy$default(TargetState targetState, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = targetState.initial;
        }
        if ((i & 2) != 0) {
            obj2 = targetState.target;
        }
        return targetState.copy(obj, obj2);
    }

    public final T component1() {
        return this.initial;
    }

    public final T component2() {
        return this.target;
    }

    public final TargetState<T> copy(T initial, T target) {
        return new TargetState<>(initial, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TargetState)) {
            return false;
        }
        TargetState targetState = (TargetState) other;
        return Intrinsics.areEqual(this.initial, targetState.initial) && Intrinsics.areEqual(this.target, targetState.target);
    }

    public int hashCode() {
        return ((this.initial == null ? 0 : this.initial.hashCode()) * 31) + (this.target != null ? this.target.hashCode() : 0);
    }

    public String toString() {
        return "TargetState(initial=" + this.initial + ", target=" + this.target + ')';
    }

    public TargetState(T t, T t2) {
        this.initial = t;
        this.target = t2;
    }

    public final T getInitial() {
        return this.initial;
    }

    public final T getTarget() {
        return this.target;
    }
}
