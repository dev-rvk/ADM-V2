package androidx.compose.ui.tooling.data;

import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTree.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\rR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/data/NodeGroup;", "Landroidx/compose/ui/tooling/data/Group;", "key", "", "node", "box", "Landroidx/compose/ui/unit/IntRect;", "data", "", "modifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "children", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/unit/IntRect;Ljava/util/Collection;Ljava/util/List;Ljava/util/Collection;)V", "getModifierInfo", "()Ljava/util/List;", "getNode", "()Ljava/lang/Object;", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NodeGroup extends Group {
    public static final int $stable = 8;
    private final List<ModifierInfo> modifierInfo;
    private final Object node;

    public final Object getNode() {
        return this.node;
    }

    @Override // androidx.compose.ui.tooling.data.Group
    public List<ModifierInfo> getModifierInfo() {
        return this.modifierInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NodeGroup(Object key, Object node, IntRect box, Collection<? extends Object> data, List<ModifierInfo> modifierInfo, Collection<? extends Group> children) {
        super(key, null, null, null, box, data, children, false, null);
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(box, "box");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(modifierInfo, "modifierInfo");
        Intrinsics.checkNotNullParameter(children, "children");
        this.node = node;
        this.modifierInfo = modifierInfo;
    }
}
