package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnPositionedDispatcher.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "()V", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "dispatch", "", "dispatchHierarchy", "layoutNode", "isNotEmpty", "", "onNodePositioned", "node", "onRootNodePositioned", "rootNode", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OnPositionedDispatcher {
    private final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16], 0);

    public final boolean isNotEmpty() {
        return this.layoutNodes.isNotEmpty();
    }

    public final void onNodePositioned(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        MutableVector this_$iv = this.layoutNodes;
        this_$iv.add(node);
        node.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void onRootNodePositioned(LayoutNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        this.layoutNodes.clear();
        MutableVector this_$iv = this.layoutNodes;
        this_$iv.add(rootNode);
        rootNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void dispatch() {
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        MutableVector this_$iv = this.layoutNodes;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = size$iv - 1;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content$iv[i$iv];
                if (layoutNode.getNeedsOnPositionedDispatch()) {
                    dispatchHierarchy(layoutNode);
                }
                i$iv--;
            } while (i$iv >= 0);
        }
        this.layoutNodes.clear();
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector this_$iv$iv = layoutNode.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        do {
            LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
            dispatchHierarchy(child);
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }
}
