package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: NodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NodeCoordinatorKt {
    /* renamed from: access$nextUntil-hw7D004, reason: not valid java name */
    public static final /* synthetic */ Modifier.Node m4397access$nextUntilhw7D004(DelegatableNode $receiver, int type, int stopType) {
        return m4398nextUntilhw7D004($receiver, type, stopType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m4398nextUntilhw7D004(DelegatableNode $this$nextUntil_u2dhw7D004, int type, int stopType) {
        Modifier.Node child = $this$nextUntil_u2dhw7D004.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null; next = next.getChild()) {
            int kindSet = next.getKindSet();
            if ((kindSet & stopType) != 0) {
                return null;
            }
            if ((kindSet & type) != 0) {
                return next;
            }
        }
        return null;
    }
}
