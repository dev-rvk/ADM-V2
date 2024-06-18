package androidx.compose.ui.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Inspectable.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/tooling/CompositionDataRecordImpl;", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "()V", "store", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getStore", "()Ljava/util/Set;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CompositionDataRecordImpl implements CompositionDataRecord {
    private final Set<CompositionData> store;

    public CompositionDataRecordImpl() {
        Set<CompositionData> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.store = newSetFromMap;
    }

    @Override // androidx.compose.ui.tooling.CompositionDataRecord
    public Set<CompositionData> getStore() {
        return this.store;
    }
}
