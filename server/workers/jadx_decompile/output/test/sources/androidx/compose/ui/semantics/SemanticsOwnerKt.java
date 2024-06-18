package androidx.compose.ui.semantics;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsOwner.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007*\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005H\u0000¨\u0006\n"}, d2 = {"getAllSemanticsNodes", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "mergingEnabled", "", "getAllSemanticsNodesToMap", "", "", "useUnmergedTree", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SemanticsOwnerKt {
    public static final List<SemanticsNode> getAllSemanticsNodes(SemanticsOwner $this$getAllSemanticsNodes, boolean mergingEnabled) {
        Intrinsics.checkNotNullParameter($this$getAllSemanticsNodes, "<this>");
        return CollectionsKt.toList(getAllSemanticsNodesToMap($this$getAllSemanticsNodes, !mergingEnabled).values());
    }

    public static /* synthetic */ Map getAllSemanticsNodesToMap$default(SemanticsOwner semanticsOwner, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return getAllSemanticsNodesToMap(semanticsOwner, z);
    }

    public static final Map<Integer, SemanticsNode> getAllSemanticsNodesToMap(SemanticsOwner $this$getAllSemanticsNodesToMap, boolean useUnmergedTree) {
        Intrinsics.checkNotNullParameter($this$getAllSemanticsNodesToMap, "<this>");
        Map nodes = new LinkedHashMap();
        SemanticsNode root = useUnmergedTree ? $this$getAllSemanticsNodesToMap.getUnmergedRootSemanticsNode() : $this$getAllSemanticsNodesToMap.getRootSemanticsNode();
        getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(nodes, root);
        return nodes;
    }

    private static final void getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(Map<Integer, SemanticsNode> map, SemanticsNode currentNode) {
        map.put(Integer.valueOf(currentNode.getId()), currentNode);
        List $this$fastForEach$iv = currentNode.getChildren();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            getAllSemanticsNodesToMap$findAllSemanticNodesRecursive(map, child);
        }
    }
}
