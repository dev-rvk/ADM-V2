package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsOwner.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        this.rootNode = rootNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        Object obj;
        NodeChain this_$iv;
        int type$iv;
        int i;
        int type$iv2;
        int i2;
        int type$iv3;
        int i3;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        NodeChain this_$iv2 = this.rootNode.getNodes();
        int type$iv4 = NodeKind.m4400constructorimpl(8);
        int i4 = 0;
        if ((NodeChain.access$getAggregateChildKindSet(this_$iv2) & type$iv4) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv2.getHead();
            loop0: while (node$iv$iv$iv$iv != null) {
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv2;
                    type$iv = type$iv4;
                    i = i4;
                } else {
                    MutableVector mutableVector2 = null;
                    Modifier.Node node = it$iv$iv$iv;
                    while (node != null) {
                        NodeChain this_$iv3 = this_$iv2;
                        if (node instanceof SemanticsModifierNode) {
                            obj = node;
                            break loop0;
                        }
                        Modifier.Node this_$iv$iv$iv$iv = node;
                        if (((this_$iv$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                            type$iv2 = type$iv4;
                            i2 = i4;
                        } else {
                            int count$iv$iv$iv2 = 0;
                            DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv2.getDelegate();
                            while (node$iv$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv2;
                                if (!((next$iv$iv$iv.getKindSet() & type$iv4) != 0)) {
                                    type$iv3 = type$iv4;
                                    i3 = i4;
                                } else {
                                    count$iv$iv$iv2++;
                                    type$iv3 = type$iv4;
                                    if (count$iv$iv$iv2 == 1) {
                                        node = next$iv$iv$iv;
                                        i3 = i4;
                                    } else {
                                        if (mutableVector2 != null) {
                                            count$iv$iv$iv = count$iv$iv$iv2;
                                            i3 = i4;
                                            mutableVector = mutableVector2;
                                        } else {
                                            count$iv$iv$iv = count$iv$iv$iv2;
                                            i3 = i4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        MutableVector mutableVector3 = mutableVector;
                                        Modifier.Node theNode$iv$iv$iv = node;
                                        if (theNode$iv$iv$iv != null) {
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(theNode$iv$iv$iv);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(next$iv$iv$iv);
                                        }
                                        mutableVector2 = mutableVector3;
                                        count$iv$iv$iv2 = count$iv$iv$iv;
                                    }
                                }
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild();
                                type$iv4 = type$iv3;
                                i4 = i3;
                            }
                            type$iv2 = type$iv4;
                            i2 = i4;
                            if (count$iv$iv$iv2 == 1) {
                                this_$iv2 = this_$iv3;
                                type$iv4 = type$iv2;
                                i4 = i2;
                            }
                        }
                        node = DelegatableNodeKt.access$pop(mutableVector2);
                        this_$iv2 = this_$iv3;
                        type$iv4 = type$iv2;
                        i4 = i2;
                    }
                    this_$iv = this_$iv2;
                    type$iv = type$iv4;
                    i = i4;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                this_$iv2 = this_$iv;
                type$iv4 = type$iv;
                i4 = i;
            }
        }
        obj = null;
        Intrinsics.checkNotNull(obj);
        return new SemanticsNode(((SemanticsModifierNode) obj).getNode(), false, this.rootNode, new SemanticsConfiguration());
    }
}
