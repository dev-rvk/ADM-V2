package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* compiled from: SnapshotDoubleState.kt */
@Metadata(d1 = {"androidx/compose/runtime/SnapshotDoubleStateKt__SnapshotDoubleStateKt"}, k = 4, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotDoubleStateKt {
    public static final double getValue(DoubleState $this$getValue, Object thisObj, KProperty<?> kProperty) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.getValue($this$getValue, thisObj, kProperty);
    }

    public static final MutableDoubleState mutableDoubleStateOf(double value) {
        return SnapshotDoubleStateKt__SnapshotDoubleStateKt.mutableDoubleStateOf(value);
    }

    public static final void setValue(MutableDoubleState $this$setValue, Object thisObj, KProperty<?> kProperty, double value) {
        SnapshotDoubleStateKt__SnapshotDoubleStateKt.setValue($this$setValue, thisObj, kProperty, value);
    }
}
