package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* compiled from: SnapshotIntState.kt */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt"}, k = 4, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotIntStateKt {
    public static final int getValue(IntState $this$getValue, Object thisObj, KProperty<?> kProperty) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue($this$getValue, thisObj, kProperty);
    }

    public static final MutableIntState mutableIntStateOf(int value) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(value);
    }

    public static final void setValue(MutableIntState $this$setValue, Object thisObj, KProperty<?> kProperty, int value) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue($this$setValue, thisObj, kProperty, value);
    }
}
