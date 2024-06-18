package androidx.compose.ui.tooling.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ToolingState.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R+\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Landroidx/compose/ui/tooling/animation/ToolingState;", "T", "Landroidx/compose/runtime/State;", "default", "(Ljava/lang/Object;)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableState;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ToolingState<T> implements State<T> {
    public static final int $stable = 0;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    public ToolingState(T t) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.value = mutableStateOf$default;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        State $this$getValue$iv = this.value;
        return $this$getValue$iv.getValue();
    }

    public void setValue(T t) {
        MutableState $this$setValue$iv = this.value;
        $this$setValue$iv.setValue(t);
    }
}
