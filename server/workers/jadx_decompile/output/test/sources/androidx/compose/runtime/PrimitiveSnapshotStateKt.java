package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* compiled from: SnapshotFloatState.kt */
@Metadata(d1 = {"androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt"}, k = 4, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(FloatState $this$getValue, Object thisObj, KProperty<?> kProperty) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue($this$getValue, thisObj, kProperty);
    }

    public static final MutableFloatState mutableFloatStateOf(float value) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(value);
    }

    public static final void setValue(MutableFloatState $this$setValue, Object thisObj, KProperty<?> kProperty, float value) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue($this$setValue, thisObj, kProperty, value);
    }
}
