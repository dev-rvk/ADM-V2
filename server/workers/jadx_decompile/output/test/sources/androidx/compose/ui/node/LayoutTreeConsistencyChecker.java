package androidx.compose.ui.node;

import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutTreeConsistencyChecker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSetsForDifferentPasses;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutTreeConsistencyChecker {
    private final List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSetsForDifferentPasses relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode root, DepthSortedSetsForDifferentPasses relayoutNodes, List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(relayoutNodes, "relayoutNodes");
        Intrinsics.checkNotNullParameter(postponedMeasureRequests, "postponedMeasureRequests");
        this.root = root;
        this.relayoutNodes = relayoutNodes;
        this.postponedMeasureRequests = postponedMeasureRequests;
    }

    public final void assertConsistent() {
        boolean inconsistencyFound = !isTreeConsistent(this.root);
        if (inconsistencyFound) {
            System.out.println((Object) logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode node) {
        if (!consistentLayoutState(node)) {
            return false;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            if (!isTreeConsistent(it)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if ((r2 != null && r2.isPlaced()) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final String nodeToString(LayoutNode node) {
        StringBuilder $this$nodeToString_u24lambda_u243 = new StringBuilder();
        $this$nodeToString_u24lambda_u243.append(node);
        $this$nodeToString_u24lambda_u243.append(new StringBuilder().append('[').append(node.getLayoutState$ui_release()).append(']').toString());
        if (!node.isPlaced()) {
            $this$nodeToString_u24lambda_u243.append("[!isPlaced]");
        }
        $this$nodeToString_u24lambda_u243.append("[measuredByParent=" + node.getMeasuredByParent$ui_release() + ']');
        if (!consistentLayoutState(node)) {
            $this$nodeToString_u24lambda_u243.append("[INCONSISTENT]");
        }
        String sb = $this$nodeToString_u24lambda_u243.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb;
    }

    private final String logTree() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        logTree$printSubTree(this, stringBuilder, this.root, 0);
        String sb = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "stringBuilder.toString()");
        return sb;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker this$0, StringBuilder stringBuilder, LayoutNode node, int depth) {
        int childrenDepth = depth;
        String nodeRepresentation = this$0.nodeToString(node);
        if (nodeRepresentation.length() > 0) {
            for (int i = 0; i < depth; i++) {
                stringBuilder.append("..");
            }
            StringBuilder append = stringBuilder.append(nodeRepresentation);
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            childrenDepth++;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            LayoutNode it = (LayoutNode) item$iv;
            logTree$printSubTree(this$0, stringBuilder, it, childrenDepth);
        }
    }
}
