package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeChain.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002mnB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002JE\u0010,\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001901H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b2\u00103J@\u00104\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00108\u001a\u00020\u0019H\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J!\u0010<\u001a\u00020\u00192\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b=\u0010>J\u0015\u0010<\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J.\u0010\u0011\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\u0080\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000¢\u0006\u0002\bEJC\u0010C\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bF\u0010GJ-\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000¢\u0006\u0002\bEJ%\u0010H\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000¢\u0006\u0002\bIJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010L\u001a\u00020DJ\r\u0010M\u001a\u00020DH\u0000¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\r\u0010T\u001a\u00020DH\u0000¢\u0006\u0002\bUJ\u0006\u0010V\u001a\u00020DJ\r\u0010W\u001a\u00020DH\u0000¢\u0006\u0002\bXJ<\u0010Y\u001a\u00020D2\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0019H\u0002J\b\u0010Z\u001a\u00020DH\u0002J\u0006\u0010[\u001a\u00020DJ.\u0010#\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\u0080\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\\\u0010BJ%\u0010]\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000¢\u0006\u0002\b^JC\u0010]\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b_\u0010GJ-\u0010]\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\u0080\bø\u0001\u0000¢\u0006\u0002\b^J\b\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0010H\u0002J\u0015\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ \u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0017\u0010k\u001a\u00020D2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\blR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006o"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "createAndInsertNodeAsChild", "element", "parent", "createAndInsertNodeAsParent", "child", "detachAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "offset", "before", "after", "shouldAttachOnInsert", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertChild", "insertParent", "markAsAttached", "markAsDetached", "markAsDetached$ui_release", "padChain", "propagateCoordinator", "start", "coordinator", "removeNode", "resetState", "resetState$ui_release", "runAttachLifecycle", "runDetachLifecycle", "runDetachLifecycle$ui_release", "structuralUpdate", "syncAggregateChildKindSet", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "paddedHead", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNode", "prev", "next", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public interface Logger {
        void linearDiffAborted(int index, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeInserted(int atIndex, int newIndex, Modifier.Element element, Modifier.Node child, Modifier.Node inserted);

        void nodeRemoved(int oldIndex, Modifier.Element element, Modifier.Node node);

        void nodeReused(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeUpdated(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);
    }

    public NodeChain(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.innerCoordinator = new InnerNodeCoordinator(this.layoutNode);
        this.outerCoordinator = this.innerCoordinator;
        this.tail = this.innerCoordinator.getTail();
        this.head = this.tail;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* renamed from: getInnerCoordinator$ui_release, reason: from getter */
    public final InnerNodeCoordinator getInnerCoordinator() {
        return this.innerCoordinator;
    }

    /* renamed from: getOuterCoordinator$ui_release, reason: from getter */
    public final NodeCoordinator getOuterCoordinator() {
        return this.outerCoordinator;
    }

    /* renamed from: getTail$ui_release, reason: from getter */
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* renamed from: getHead$ui_release, reason: from getter */
    public final Modifier.Node getHead() {
        return this.head;
    }

    private final boolean isUpdating() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        return node == nodeChainKt$SentinelHead$1;
    }

    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet();
    }

    public final void useLogger$ui_release(Logger logger) {
        this.logger = logger;
    }

    private final Modifier.Node padChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node != nodeChainKt$SentinelHead$1)) {
            throw new IllegalStateException("padChain called on already padded chain".toString());
        }
        Modifier.Node currentHead = this.head;
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        currentHead.setParent$ui_release(nodeChainKt$SentinelHead$12);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(currentHead);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        return nodeChainKt$SentinelHead$14;
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$15;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$16;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(paddedHead == nodeChainKt$SentinelHead$1)) {
            throw new IllegalStateException("trimChain called on already trimmed chain".toString());
        }
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        Modifier.Node result = nodeChainKt$SentinelHead$12.getChild();
        if (result == null) {
            result = this.tail;
        }
        result.setParent$ui_release(null);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(null);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$14.setAggregateChildKindSet$ui_release(-1);
        nodeChainKt$SentinelHead$15 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$15.updateCoordinator$ui_release(null);
        nodeChainKt$SentinelHead$16 = NodeChainKt.SentinelHead;
        if (result != nodeChainKt$SentinelHead$16) {
            return result;
        }
        throw new IllegalStateException("trimChain did not update the head".toString());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x005c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r21) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void resetState$ui_release() {
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if (it.getIsAttached()) {
                it.reset$ui_release();
            }
        }
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator c;
        NodeCoordinator coordinator = this.innerCoordinator;
        for (Modifier.Node node = this.tail.getParent(); node != null; node = node.getParent()) {
            LayoutModifierNode layoutmod = DelegatableNodeKt.asLayoutModifierNode(node);
            if (layoutmod != null) {
                if (node.getCoordinator() != null) {
                    NodeCoordinator coordinator2 = node.getCoordinator();
                    Intrinsics.checkNotNull(coordinator2, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    c = (LayoutModifierNodeCoordinator) coordinator2;
                    LayoutModifierNode prevNode = c.getLayoutModifierNode();
                    c.setLayoutModifierNode$ui_release(layoutmod);
                    if (prevNode != node) {
                        c.onLayoutModifierNodeChanged();
                    }
                } else {
                    c = new LayoutModifierNodeCoordinator(this.layoutNode, layoutmod);
                    node.updateCoordinator$ui_release(c);
                }
                coordinator.setWrappedBy$ui_release(c);
                c.setWrapped$ui_release(coordinator);
                NodeCoordinator coordinator3 = c;
                coordinator = coordinator3;
            } else {
                node.updateCoordinator$ui_release(coordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = coordinator;
    }

    private final void syncAggregateChildKindSet() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        int aggregateChildKindSet = 0;
        for (Modifier.Node node = this.tail.getParent(); node != null; node = node.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (node != nodeChainKt$SentinelHead$1) {
                aggregateChildKindSet |= node.getKindSet();
                node.setAggregateChildKindSet$ui_release(aggregateChildKindSet);
            } else {
                return;
            }
        }
    }

    public final void markAsAttached() {
        for (Modifier.Node node$iv = getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.markAsAttached$ui_release();
        }
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node node$iv = getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.runAttachLifecycle$ui_release();
            if (it.getInsertedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateInsertedNode(it);
            }
            if (it.getUpdatedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateUpdatedNode(it);
            }
            it.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            it.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        NodeChain nodeChain = this;
        MutableVector current = nodeChain.current;
        if (current == null) {
            return CollectionsKt.emptyList();
        }
        int capacity$iv = current.getSize();
        MutableVector infoList = new MutableVector(new ModifierInfo[capacity$iv], 0);
        int i = 0;
        Modifier.Node node$iv = getHead();
        while (node$iv != null && node$iv != getTail()) {
            Modifier.Node node = node$iv;
            NodeCoordinator coordinator = node.getCoordinator();
            if (coordinator == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            OwnedLayer currentNodeLayer = coordinator.getLayer();
            OwnedLayer layer = nodeChain.innerCoordinator.getLayer();
            Modifier.Node localChild = node.getChild();
            if (!(localChild == nodeChain.tail && node.getCoordinator() != localChild.getCoordinator())) {
                layer = null;
            }
            OwnedLayer innerNodeLayer = layer;
            OwnedLayer layer2 = currentNodeLayer == null ? innerNodeLayer : currentNodeLayer;
            infoList.add(new ModifierInfo(current.getContent()[i], coordinator, layer2));
            node$iv = node$iv.getChild();
            nodeChain = this;
            i++;
        }
        return infoList.asMutableList();
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if (it.getIsAttached()) {
                it.markAsDetached$ui_release();
            }
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if (it.getIsAttached()) {
                it.runDetachLifecycle$ui_release();
            }
        }
    }

    private final Differ getDiffer(Modifier.Node head, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        Differ current = this.cachedDiffer;
        if (current == null) {
            Differ it = new Differ(this, head, offset, before, after, shouldAttachOnInsert);
            this.cachedDiffer = it;
            return it;
        }
        current.setNode(head);
        current.setOffset(offset);
        current.setBefore(before);
        current.setAfter(after);
        current.setShouldAttachOnInsert(shouldAttachOnInsert);
        return current;
    }

    public final void propagateCoordinator(Modifier.Node start, NodeCoordinator coordinator) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        for (Modifier.Node node = start.getParent(); node != null; node = node.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (node == nodeChainKt$SentinelHead$1) {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = coordinator;
                return;
            } else {
                Modifier.Node this_$iv = node;
                if (!((this_$iv.getKindSet() & NodeKind.m4400constructorimpl(2)) != 0)) {
                    node.updateCoordinator$ui_release(coordinator);
                } else {
                    return;
                }
            }
        }
    }

    /* compiled from: NodeChain.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "offset", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;
        final /* synthetic */ NodeChain this$0;

        public Differ(NodeChain this$0, Modifier.Node node, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(before, "before");
            Intrinsics.checkNotNullParameter(after, "after");
            this.this$0 = this$0;
            this.node = node;
            this.offset = offset;
            this.before = before;
            this.after = after;
            this.shouldAttachOnInsert = shouldAttachOnInsert;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node) {
            Intrinsics.checkNotNullParameter(node, "<set-?>");
            this.node = node;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.after = mutableVector;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public final void setShouldAttachOnInsert(boolean z) {
            this.shouldAttachOnInsert = z;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            MutableVector this_$iv = this.before;
            int index$iv = this.offset + oldIndex;
            Modifier.Element element = this_$iv.getContent()[index$iv];
            MutableVector this_$iv2 = this.after;
            int index$iv2 = this.offset + newIndex;
            return NodeChainKt.actionForModifiers(element, this_$iv2.getContent()[index$iv2]) != 0;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int newIndex) {
            int index = this.offset + newIndex;
            Modifier.Node parent = this.node;
            NodeChain nodeChain = this.this$0;
            MutableVector this_$iv = this.after;
            this.node = nodeChain.createAndInsertNodeAsChild(this_$iv.getContent()[index], parent);
            Logger logger = this.this$0.logger;
            if (logger != null) {
                MutableVector this_$iv2 = this.after;
                logger.nodeInserted(index, index, this_$iv2.getContent()[index], parent, this.node);
            }
            if (this.shouldAttachOnInsert) {
                Modifier.Node child = this.node.getChild();
                Intrinsics.checkNotNull(child);
                NodeCoordinator childCoordinator = child.getCoordinator();
                Intrinsics.checkNotNull(childCoordinator);
                LayoutModifierNode layoutmod = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (layoutmod != null) {
                    LayoutModifierNodeCoordinator thisCoordinator = new LayoutModifierNodeCoordinator(this.this$0.getLayoutNode(), layoutmod);
                    this.node.updateCoordinator$ui_release(thisCoordinator);
                    this.this$0.propagateCoordinator(this.node, thisCoordinator);
                    thisCoordinator.setWrappedBy$ui_release(childCoordinator.getWrappedBy());
                    thisCoordinator.setWrapped$ui_release(childCoordinator);
                    childCoordinator.setWrappedBy$ui_release(thisCoordinator);
                } else {
                    this.node.updateCoordinator$ui_release(childCoordinator);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int atIndex, int oldIndex) {
            Modifier.Node toRemove = this.node.getChild();
            Intrinsics.checkNotNull(toRemove);
            Logger logger = this.this$0.logger;
            if (logger != null) {
                MutableVector this_$iv = this.before;
                int index$iv = this.offset + oldIndex;
                logger.nodeRemoved(oldIndex, this_$iv.getContent()[index$iv], toRemove);
            }
            if ((toRemove.getKindSet() & NodeKind.m4400constructorimpl(2)) != 0) {
                NodeCoordinator removedCoordinator = toRemove.getCoordinator();
                Intrinsics.checkNotNull(removedCoordinator);
                NodeCoordinator parentCoordinator = removedCoordinator.getWrappedBy();
                NodeCoordinator childCoordinator = removedCoordinator.getWrapped();
                Intrinsics.checkNotNull(childCoordinator);
                if (parentCoordinator != null) {
                    parentCoordinator.setWrapped$ui_release(childCoordinator);
                }
                childCoordinator.setWrappedBy$ui_release(parentCoordinator);
                this.this$0.propagateCoordinator(this.node, childCoordinator);
            }
            this.node = this.this$0.detachAndRemoveNode(toRemove);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            this.node = child;
            MutableVector this_$iv = this.before;
            int index$iv = this.offset + oldIndex;
            Modifier.Element prev = this_$iv.getContent()[index$iv];
            MutableVector this_$iv2 = this.after;
            int index$iv2 = this.offset + newIndex;
            Modifier.Element next = this_$iv2.getContent()[index$iv2];
            if (!Intrinsics.areEqual(prev, next)) {
                this.this$0.updateNode(prev, next, this.node);
                Logger logger = this.this$0.logger;
                if (logger != null) {
                    logger.nodeUpdated(this.offset + oldIndex, this.offset + newIndex, prev, next, this.node);
                    return;
                }
                return;
            }
            Logger logger2 = this.this$0.logger;
            if (logger2 != null) {
                logger2.nodeReused(this.offset + oldIndex, this.offset + newIndex, prev, next, this.node);
            }
        }
    }

    private final void structuralUpdate(int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail, boolean shouldAttachOnInsert) {
        Differ differ = getDiffer(tail, offset, before, after, shouldAttachOnInsert);
        MyersDiffKt.executeDiff(before.getSize() - offset, after.getSize() - offset, differ);
        syncAggregateChildKindSet();
    }

    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild();
        Modifier.Node parent = node.getParent();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release(null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    private final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node child) {
        BackwardsCompatNode it;
        if (element instanceof ModifierNodeElement) {
            it = ((ModifierNodeElement) element).create();
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(it));
        } else {
            it = new BackwardsCompatNode(element);
        }
        if (!(!it.getIsAttached())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        it.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return insertParent(it, child);
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node child) {
        Modifier.Node theParent = child.getParent();
        if (theParent != null) {
            theParent.setChild$ui_release(node);
            node.setParent$ui_release(theParent);
        }
        child.setParent$ui_release(node);
        node.setChild$ui_release(child);
        return node;
    }

    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        BackwardsCompatNode it;
        if (element instanceof ModifierNodeElement) {
            it = ((ModifierNodeElement) element).create();
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(it));
        } else {
            it = new BackwardsCompatNode(element);
        }
        if (!(!it.getIsAttached())) {
            throw new IllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ".toString());
        }
        it.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return insertChild(it, parent);
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        Modifier.Node theChild = parent.getChild();
        if (theChild != null) {
            theChild.setParent$ui_release(node);
            node.setChild$ui_release(theChild);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    public final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(next);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        throw new IllegalStateException("Unknown Modifier.Node type".toString());
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Object] */
    /* renamed from: firstFromHead-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> T m4362firstFromHeadaLcG6gQ$ui_release(int type, Function1<? super T, Boolean> block) {
        int i;
        NodeChain nodeChain;
        int i2;
        NodeChain nodeChain2;
        int i3;
        NodeChain nodeChain3;
        int i4;
        DelegatingNode delegatingNode;
        NodeChain nodeChain4;
        int i5;
        int i6;
        Function1<? super T, Boolean> block2 = block;
        Intrinsics.checkNotNullParameter(block2, "block");
        int i7 = 0;
        NodeChain nodeChain5 = this;
        int i8 = 0;
        NodeChain nodeChain6 = nodeChain5;
        int i9 = 0;
        if ((nodeChain6.getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        Modifier.Node head = nodeChain6.getHead();
        while (head != null) {
            Modifier.Node node = head;
            if ((node.getKindSet() & type) == 0) {
                i = i7;
                nodeChain = nodeChain5;
                i2 = i8;
                nodeChain2 = nodeChain6;
                i3 = i9;
            } else {
                Object obj = null;
                i = i7;
                Object obj2 = node;
                while (obj2 != null) {
                    NodeChain nodeChain7 = nodeChain5;
                    int i10 = i8;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (obj2 instanceof Object) {
                        ?? r2 = (Object) obj2;
                        if (block2.invoke(r2).booleanValue()) {
                            return r2;
                        }
                        nodeChain3 = nodeChain6;
                        i4 = i9;
                    } else {
                        if (!((((Modifier.Node) obj2).getKindSet() & type) != 0) || !(obj2 instanceof DelegatingNode)) {
                            nodeChain3 = nodeChain6;
                            i4 = i9;
                        } else {
                            int i11 = 0;
                            DelegatingNode delegatingNode2 = (DelegatingNode) obj2;
                            Modifier.Node delegate = delegatingNode2.getDelegate();
                            while (delegate != null) {
                                Modifier.Node node2 = delegate;
                                if (!((node2.getKindSet() & type) != 0)) {
                                    delegatingNode = delegatingNode2;
                                    nodeChain4 = nodeChain6;
                                    i5 = i9;
                                } else {
                                    i11++;
                                    delegatingNode = delegatingNode2;
                                    if (i11 == 1) {
                                        obj2 = node2;
                                        nodeChain4 = nodeChain6;
                                        i5 = i9;
                                    } else {
                                        MutableVector mutableVector = (MutableVector) obj;
                                        if (mutableVector != null) {
                                            i6 = i11;
                                            nodeChain4 = nodeChain6;
                                            i5 = i9;
                                        } else {
                                            i6 = i11;
                                            nodeChain4 = nodeChain6;
                                            i5 = i9;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        obj = mutableVector;
                                        Modifier.Node node3 = (Modifier.Node) obj2;
                                        if (node3 != null) {
                                            MutableVector mutableVector2 = (MutableVector) obj;
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(node3);
                                            }
                                            obj2 = null;
                                        }
                                        MutableVector mutableVector3 = (MutableVector) obj;
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(node2);
                                        }
                                        i11 = i6;
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNode2 = delegatingNode;
                                nodeChain6 = nodeChain4;
                                i9 = i5;
                            }
                            nodeChain3 = nodeChain6;
                            i4 = i9;
                            if (i11 == 1) {
                                block2 = block;
                                nodeChain5 = nodeChain7;
                                i8 = i10;
                                nodeChain6 = nodeChain3;
                                i9 = i4;
                            }
                        }
                    }
                    obj2 = DelegatableNodeKt.pop((MutableVector) obj);
                    block2 = block;
                    nodeChain5 = nodeChain7;
                    i8 = i10;
                    nodeChain6 = nodeChain3;
                    i9 = i4;
                }
                nodeChain = nodeChain5;
                i2 = i8;
                nodeChain2 = nodeChain6;
                i3 = i9;
            }
            if ((node.getAggregateChildKindSet() & type) == 0) {
                return null;
            }
            head = head.getChild();
            block2 = block;
            i7 = i;
            nodeChain5 = nodeChain;
            i8 = i2;
            nodeChain6 = nodeChain2;
            i9 = i3;
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> void m4365headToTailaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        int i;
        NodeChain this_$iv;
        int $i$f$headToTail$ui_release;
        NodeChain this_$iv$iv;
        int $i$f$headToTail$ui_release2;
        NodeChain this_$iv$iv2;
        DelegatingNode this_$iv$iv3;
        int $i$f$headToTail$ui_release3;
        NodeChain this_$iv$iv4;
        int count$iv;
        Function1<? super T, Unit> block2 = block;
        Intrinsics.checkNotNullParameter(block2, "block");
        int count$iv2 = 0;
        NodeChain this_$iv2 = this;
        int $i$f$headToTail$ui_release4 = 0;
        if ((this_$iv2.getAggregateChildKindSet() & type) == 0) {
            return;
        }
        NodeChain this_$iv$iv5 = this_$iv2;
        Modifier.Node node$iv$iv = this_$iv$iv5.getHead();
        while (node$iv$iv != null) {
            Modifier.Node it$iv = node$iv$iv;
            if ((it$iv.getKindSet() & type) == 0) {
                i = count$iv2;
                this_$iv = this_$iv2;
                $i$f$headToTail$ui_release = $i$f$headToTail$ui_release4;
                this_$iv$iv = this_$iv$iv5;
            } else {
                Modifier.Node it = it$iv;
                Object stack$iv = null;
                Object node$iv = it;
                while (node$iv != null) {
                    int i2 = count$iv2;
                    NodeChain this_$iv3 = this_$iv2;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object) {
                        block2.invoke(node$iv);
                        $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release4;
                        this_$iv$iv2 = this_$iv$iv5;
                    } else {
                        if (!((((Modifier.Node) node$iv).getKindSet() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                            $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release4;
                            this_$iv$iv2 = this_$iv$iv5;
                        } else {
                            int count$iv3 = 0;
                            DelegatingNode this_$iv$iv6 = (DelegatingNode) node$iv;
                            Modifier.Node node$iv$iv2 = this_$iv$iv6.getDelegate();
                            while (node$iv$iv2 != null) {
                                Modifier.Node next$iv = node$iv$iv2;
                                if (!((next$iv.getKindSet() & type) != 0)) {
                                    this_$iv$iv3 = this_$iv$iv6;
                                    $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release4;
                                    this_$iv$iv4 = this_$iv$iv5;
                                } else {
                                    count$iv3++;
                                    this_$iv$iv3 = this_$iv$iv6;
                                    if (count$iv3 == 1) {
                                        node$iv = next$iv;
                                        $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release4;
                                        this_$iv$iv4 = this_$iv$iv5;
                                    } else {
                                        Object obj = (MutableVector) stack$iv;
                                        if (obj != null) {
                                            count$iv = count$iv3;
                                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release4;
                                            this_$iv$iv4 = this_$iv$iv5;
                                        } else {
                                            count$iv = count$iv3;
                                            $i$f$headToTail$ui_release3 = $i$f$headToTail$ui_release4;
                                            this_$iv$iv4 = this_$iv$iv5;
                                            obj = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        stack$iv = obj;
                                        Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                        if (theNode$iv != null) {
                                            MutableVector mutableVector = (MutableVector) stack$iv;
                                            if (mutableVector != null) {
                                                mutableVector.add(theNode$iv);
                                            }
                                            node$iv = null;
                                        }
                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(next$iv);
                                        }
                                        count$iv3 = count$iv;
                                    }
                                }
                                node$iv$iv2 = node$iv$iv2.getChild();
                                this_$iv$iv6 = this_$iv$iv3;
                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release3;
                                this_$iv$iv5 = this_$iv$iv4;
                            }
                            $i$f$headToTail$ui_release2 = $i$f$headToTail$ui_release4;
                            this_$iv$iv2 = this_$iv$iv5;
                            if (count$iv3 == 1) {
                                block2 = block;
                                count$iv2 = i2;
                                this_$iv2 = this_$iv3;
                                $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release2;
                                this_$iv$iv5 = this_$iv$iv2;
                            }
                        }
                    }
                    node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
                    block2 = block;
                    count$iv2 = i2;
                    this_$iv2 = this_$iv3;
                    $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release2;
                    this_$iv$iv5 = this_$iv$iv2;
                }
                i = count$iv2;
                this_$iv = this_$iv2;
                $i$f$headToTail$ui_release = $i$f$headToTail$ui_release4;
                this_$iv$iv = this_$iv$iv5;
            }
            if ((it$iv.getAggregateChildKindSet() & type) == 0) {
                return;
            }
            node$iv$iv = node$iv$iv.getChild();
            block2 = block;
            count$iv2 = i;
            this_$iv2 = this_$iv;
            $i$f$headToTail$ui_release4 = $i$f$headToTail$ui_release;
            this_$iv$iv5 = this_$iv$iv;
        }
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node node$iv = getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            if ((it.getKindSet() & mask) != 0) {
                block.invoke(it);
            }
            if ((it.getAggregateChildKindSet() & mask) == 0) {
                return;
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead(); node != null; node = node.getChild()) {
            block.invoke(node);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead(); node != null && node != getTail(); node = node.getChild()) {
            block.invoke(node);
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release */
    public final /* synthetic */ <T> void m4367tailToHeadaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        NodeChain this_$iv;
        int $i$f$tailToHead$ui_release;
        DelegatingNode this_$iv$iv;
        NodeChain this_$iv2;
        int $i$f$tailToHead$ui_release2;
        int count$iv;
        Function1<? super T, Unit> block2 = block;
        Intrinsics.checkNotNullParameter(block2, "block");
        int count$iv2 = 0;
        int mask$iv = type;
        NodeChain this_$iv3 = this;
        int $i$f$tailToHead$ui_release3 = 0;
        if ((this_$iv3.getAggregateChildKindSet() & mask$iv) == 0) {
            return;
        }
        Modifier.Node node$iv$iv = this_$iv3.getTail();
        while (node$iv$iv != null) {
            Modifier.Node it$iv = node$iv$iv;
            if ((it$iv.getKindSet() & mask$iv) != 0) {
                Modifier.Node it = it$iv;
                Object stack$iv = null;
                Object node$iv = it;
                while (node$iv != null) {
                    int i = count$iv2;
                    int mask$iv2 = mask$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (node$iv instanceof Object) {
                        block2.invoke(node$iv);
                        this_$iv = this_$iv3;
                        $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release3;
                    } else {
                        if (!((((Modifier.Node) node$iv).getKindSet() & type) != 0) || !(node$iv instanceof DelegatingNode)) {
                            this_$iv = this_$iv3;
                            $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release3;
                        } else {
                            int count$iv3 = 0;
                            DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv;
                            Modifier.Node node$iv$iv2 = this_$iv$iv2.getDelegate();
                            while (node$iv$iv2 != null) {
                                Modifier.Node next$iv = node$iv$iv2;
                                if (!((next$iv.getKindSet() & type) != 0)) {
                                    this_$iv$iv = this_$iv$iv2;
                                    this_$iv2 = this_$iv3;
                                    $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release3;
                                } else {
                                    count$iv3++;
                                    this_$iv$iv = this_$iv$iv2;
                                    if (count$iv3 == 1) {
                                        node$iv = next$iv;
                                        this_$iv2 = this_$iv3;
                                        $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release3;
                                    } else {
                                        Object obj = (MutableVector) stack$iv;
                                        if (obj != null) {
                                            count$iv = count$iv3;
                                            this_$iv2 = this_$iv3;
                                            $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release3;
                                        } else {
                                            count$iv = count$iv3;
                                            this_$iv2 = this_$iv3;
                                            $i$f$tailToHead$ui_release2 = $i$f$tailToHead$ui_release3;
                                            obj = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        stack$iv = obj;
                                        Modifier.Node theNode$iv = (Modifier.Node) node$iv;
                                        if (theNode$iv != null) {
                                            MutableVector mutableVector = (MutableVector) stack$iv;
                                            if (mutableVector != null) {
                                                mutableVector.add(theNode$iv);
                                            }
                                            node$iv = null;
                                        }
                                        MutableVector mutableVector2 = (MutableVector) stack$iv;
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(next$iv);
                                        }
                                        count$iv3 = count$iv;
                                    }
                                }
                                node$iv$iv2 = node$iv$iv2.getChild();
                                this_$iv$iv2 = this_$iv$iv;
                                this_$iv3 = this_$iv2;
                                $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release2;
                            }
                            this_$iv = this_$iv3;
                            $i$f$tailToHead$ui_release = $i$f$tailToHead$ui_release3;
                            if (count$iv3 == 1) {
                                block2 = block;
                                count$iv2 = i;
                                mask$iv = mask$iv2;
                                this_$iv3 = this_$iv;
                                $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                            }
                        }
                    }
                    node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
                    block2 = block;
                    count$iv2 = i;
                    mask$iv = mask$iv2;
                    this_$iv3 = this_$iv;
                    $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release;
                }
            }
            node$iv$iv = node$iv$iv.getParent();
            block2 = block;
            count$iv2 = count$iv2;
            mask$iv = mask$iv;
            this_$iv3 = this_$iv3;
            $i$f$tailToHead$ui_release3 = $i$f$tailToHead$ui_release3;
        }
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if ((it.getKindSet() & mask) != 0) {
                block.invoke(it);
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getTail(); node != null; node = node.getParent()) {
            block.invoke(node);
        }
    }

    /* renamed from: tail-H91voCI$ui_release */
    public final /* synthetic */ <T> T m4366tailH91voCI$ui_release(int type) {
        int i;
        int i2;
        NodeChain nodeChain;
        int i3;
        int i4;
        NodeChain nodeChain2;
        int i5;
        int i6;
        int i7 = 0;
        NodeChain nodeChain3 = this;
        int i8 = 0;
        int i9 = type;
        NodeChain nodeChain4 = nodeChain3;
        int i10 = 0;
        if ((nodeChain4.getAggregateChildKindSet() & i9) == 0) {
            return null;
        }
        Modifier.Node tail = nodeChain4.getTail();
        while (tail != null) {
            Modifier.Node node = tail;
            if ((node.getKindSet() & i9) == 0) {
                i = i7;
            } else {
                Object obj = null;
                i = i7;
                Object obj2 = node;
                while (obj2 != null) {
                    NodeChain nodeChain5 = nodeChain3;
                    int i11 = i8;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (obj2 instanceof Object) {
                        return (T) obj2;
                    }
                    if (((((Modifier.Node) obj2).getKindSet() & type) != 0 ? 1 : 0) == 0 || !(obj2 instanceof DelegatingNode)) {
                        i2 = i9;
                        nodeChain = nodeChain4;
                        i3 = i10;
                    } else {
                        int i12 = 0;
                        Modifier.Node delegate = ((DelegatingNode) obj2).getDelegate();
                        while (delegate != null) {
                            Modifier.Node node2 = delegate;
                            if (!((node2.getKindSet() & type) != 0)) {
                                i4 = i9;
                                nodeChain2 = nodeChain4;
                                i5 = i10;
                            } else {
                                i12++;
                                i4 = i9;
                                if (i12 == 1) {
                                    obj2 = node2;
                                    nodeChain2 = nodeChain4;
                                    i5 = i10;
                                } else {
                                    MutableVector mutableVector = (MutableVector) obj;
                                    if (mutableVector != null) {
                                        i6 = i12;
                                        nodeChain2 = nodeChain4;
                                        i5 = i10;
                                    } else {
                                        i6 = i12;
                                        nodeChain2 = nodeChain4;
                                        i5 = i10;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    obj = mutableVector;
                                    Modifier.Node node3 = (Modifier.Node) obj2;
                                    if (node3 != null) {
                                        MutableVector mutableVector2 = (MutableVector) obj;
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(node3);
                                        }
                                        obj2 = null;
                                    }
                                    MutableVector mutableVector3 = (MutableVector) obj;
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node2);
                                    }
                                    i12 = i6;
                                }
                            }
                            delegate = delegate.getChild();
                            i9 = i4;
                            nodeChain4 = nodeChain2;
                            i10 = i5;
                        }
                        i2 = i9;
                        nodeChain = nodeChain4;
                        i3 = i10;
                        if (i12 == 1) {
                            nodeChain3 = nodeChain5;
                            i8 = i11;
                            i9 = i2;
                            nodeChain4 = nodeChain;
                            i10 = i3;
                        }
                    }
                    obj2 = DelegatableNodeKt.pop((MutableVector) obj);
                    nodeChain3 = nodeChain5;
                    i8 = i11;
                    i9 = i2;
                    nodeChain4 = nodeChain;
                    i10 = i3;
                }
            }
            tail = tail.getParent();
            i7 = i;
            nodeChain3 = nodeChain3;
            i8 = i8;
            i9 = i9;
            nodeChain4 = nodeChain4;
            i10 = i10;
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release */
    public final /* synthetic */ <T> T m4364headH91voCI$ui_release(int type) {
        int i;
        NodeChain nodeChain;
        int i2;
        NodeChain nodeChain2;
        int i3;
        NodeChain nodeChain3;
        NodeChain nodeChain4;
        int i4;
        NodeChain nodeChain5;
        NodeChain nodeChain6;
        int i5;
        NodeChain nodeChain7;
        int i6;
        int i7 = 0;
        NodeChain nodeChain8 = this;
        int i8 = 0;
        NodeChain nodeChain9 = nodeChain8;
        int i9 = 0;
        if ((nodeChain9.getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        NodeChain nodeChain10 = nodeChain9;
        Modifier.Node head = nodeChain10.getHead();
        while (head != null) {
            Modifier.Node node = head;
            if ((node.getKindSet() & type) == 0) {
                i = i7;
                nodeChain = nodeChain8;
                i2 = i8;
                nodeChain2 = nodeChain9;
                i3 = i9;
                nodeChain3 = nodeChain10;
            } else {
                Object obj = null;
                i = i7;
                Object obj2 = node;
                while (obj2 != null) {
                    NodeChain nodeChain11 = nodeChain8;
                    int i10 = i8;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (obj2 instanceof Object) {
                        return (T) obj2;
                    }
                    if (((((Modifier.Node) obj2).getKindSet() & type) != 0 ? 1 : 0) == 0 || !(obj2 instanceof DelegatingNode)) {
                        nodeChain4 = nodeChain9;
                        i4 = i9;
                        nodeChain5 = nodeChain10;
                    } else {
                        int i11 = 0;
                        Modifier.Node delegate = ((DelegatingNode) obj2).getDelegate();
                        while (delegate != null) {
                            Modifier.Node node2 = delegate;
                            if (!((node2.getKindSet() & type) != 0)) {
                                nodeChain6 = nodeChain9;
                                i5 = i9;
                                nodeChain7 = nodeChain10;
                            } else {
                                i11++;
                                nodeChain6 = nodeChain9;
                                if (i11 == 1) {
                                    obj2 = node2;
                                    i5 = i9;
                                    nodeChain7 = nodeChain10;
                                } else {
                                    MutableVector mutableVector = (MutableVector) obj;
                                    if (mutableVector != null) {
                                        i6 = i11;
                                        i5 = i9;
                                        nodeChain7 = nodeChain10;
                                    } else {
                                        i6 = i11;
                                        i5 = i9;
                                        nodeChain7 = nodeChain10;
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    obj = mutableVector;
                                    Modifier.Node node3 = (Modifier.Node) obj2;
                                    if (node3 != null) {
                                        MutableVector mutableVector2 = (MutableVector) obj;
                                        if (mutableVector2 != null) {
                                            mutableVector2.add(node3);
                                        }
                                        obj2 = null;
                                    }
                                    MutableVector mutableVector3 = (MutableVector) obj;
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(node2);
                                    }
                                    i11 = i6;
                                }
                            }
                            delegate = delegate.getChild();
                            nodeChain9 = nodeChain6;
                            i9 = i5;
                            nodeChain10 = nodeChain7;
                        }
                        nodeChain4 = nodeChain9;
                        i4 = i9;
                        nodeChain5 = nodeChain10;
                        if (i11 == 1) {
                            nodeChain8 = nodeChain11;
                            i8 = i10;
                            nodeChain9 = nodeChain4;
                            i9 = i4;
                            nodeChain10 = nodeChain5;
                        }
                    }
                    obj2 = DelegatableNodeKt.pop((MutableVector) obj);
                    nodeChain8 = nodeChain11;
                    i8 = i10;
                    nodeChain9 = nodeChain4;
                    i9 = i4;
                    nodeChain10 = nodeChain5;
                }
                nodeChain = nodeChain8;
                i2 = i8;
                nodeChain2 = nodeChain9;
                i3 = i9;
                nodeChain3 = nodeChain10;
            }
            if ((node.getAggregateChildKindSet() & type) == 0) {
                return null;
            }
            head = head.getChild();
            i7 = i;
            nodeChain8 = nodeChain;
            i8 = i2;
            nodeChain9 = nodeChain2;
            i9 = i3;
            nodeChain10 = nodeChain3;
        }
        return null;
    }

    /* renamed from: has-H91voCI$ui_release */
    public final boolean m4363hasH91voCI$ui_release(int type) {
        return (getAggregateChildKindSet() & type) != 0;
    }

    public final boolean has$ui_release(int mask) {
        return (getAggregateChildKindSet() & mask) != 0;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u2428 = new StringBuilder();
        $this$toString_u24lambda_u2428.append("[");
        if (this.head == this.tail) {
            $this$toString_u24lambda_u2428.append("]");
        } else {
            Modifier.Node node$iv = getHead();
            while (true) {
                if (node$iv == null || node$iv == getTail()) {
                    break;
                }
                Modifier.Node it = node$iv;
                $this$toString_u24lambda_u2428.append(String.valueOf(it));
                if (it.getChild() == this.tail) {
                    $this$toString_u24lambda_u2428.append("]");
                    break;
                }
                $this$toString_u24lambda_u2428.append(",");
                node$iv = node$iv.getChild();
            }
        }
        String sb = $this$toString_u24lambda_u2428.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
