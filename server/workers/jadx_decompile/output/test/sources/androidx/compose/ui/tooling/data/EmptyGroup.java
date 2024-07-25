package androidx.compose.ui.tooling.data;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/tooling/data/EmptyGroup;", "Landroidx/compose/ui/tooling/data/Group;", "()V", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class EmptyGroup extends Group {
    public static final EmptyGroup INSTANCE = new EmptyGroup();

    private EmptyGroup() {
        super(null, null, null, null, SlotTreeKt.getEmptyBox(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, null);
    }
}
