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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsNode.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0010*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "SemanticsNode", "layoutNode", "mergingEnabled", "", "outerSemanticsNode", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean mergingEnabled) {
        Object obj;
        NodeChain this_$iv;
        int type$iv;
        int i;
        NodeChain this_$iv$iv;
        int type$iv2;
        NodeChain this_$iv$iv2;
        int type$iv3;
        NodeChain this_$iv$iv3;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        NodeChain this_$iv2 = layoutNode.getNodes();
        int type$iv4 = NodeKind.m4400constructorimpl(8);
        int count$iv$iv$iv2 = 0;
        NodeChain this_$iv$iv4 = this_$iv2;
        if ((this_$iv$iv4.getAggregateChildKindSet() & type$iv4) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv4.getHead();
            loop0: while (node$iv$iv$iv$iv != null) {
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv2;
                    type$iv = type$iv4;
                    i = count$iv$iv$iv2;
                    this_$iv$iv = this_$iv$iv4;
                } else {
                    MutableVector mutableVector2 = null;
                    this_$iv = this_$iv2;
                    Modifier.Node node = it$iv$iv$iv;
                    while (node != null) {
                        int i2 = count$iv$iv$iv2;
                        if (node instanceof SemanticsModifierNode) {
                            obj = node;
                            break loop0;
                        }
                        Modifier.Node this_$iv$iv$iv$iv = node;
                        if (((this_$iv$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                            type$iv2 = type$iv4;
                            this_$iv$iv2 = this_$iv$iv4;
                        } else {
                            int count$iv$iv$iv3 = 0;
                            DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                            Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv2.getDelegate();
                            while (node$iv$iv$iv$iv2 != null) {
                                Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv2;
                                if (!((next$iv$iv$iv.getKindSet() & type$iv4) != 0)) {
                                    type$iv3 = type$iv4;
                                    this_$iv$iv3 = this_$iv$iv4;
                                } else {
                                    count$iv$iv$iv3++;
                                    type$iv3 = type$iv4;
                                    if (count$iv$iv$iv3 == 1) {
                                        node = next$iv$iv$iv;
                                        this_$iv$iv3 = this_$iv$iv4;
                                    } else {
                                        if (mutableVector2 != null) {
                                            count$iv$iv$iv = count$iv$iv$iv3;
                                            this_$iv$iv3 = this_$iv$iv4;
                                            mutableVector = mutableVector2;
                                        } else {
                                            count$iv$iv$iv = count$iv$iv$iv3;
                                            this_$iv$iv3 = this_$iv$iv4;
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        Modifier.Node theNode$iv$iv$iv = node;
                                        if (theNode$iv$iv$iv != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(theNode$iv$iv$iv);
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(next$iv$iv$iv);
                                        }
                                        mutableVector2 = mutableVector;
                                        count$iv$iv$iv3 = count$iv$iv$iv;
                                    }
                                }
                                node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild();
                                type$iv4 = type$iv3;
                                this_$iv$iv4 = this_$iv$iv3;
                            }
                            type$iv2 = type$iv4;
                            this_$iv$iv2 = this_$iv$iv4;
                            if (count$iv$iv$iv3 == 1) {
                                count$iv$iv$iv2 = i2;
                                type$iv4 = type$iv2;
                                this_$iv$iv4 = this_$iv$iv2;
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        count$iv$iv$iv2 = i2;
                        type$iv4 = type$iv2;
                        this_$iv$iv4 = this_$iv$iv2;
                    }
                    type$iv = type$iv4;
                    i = count$iv$iv$iv2;
                    this_$iv$iv = this_$iv$iv4;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                this_$iv2 = this_$iv;
                count$iv$iv$iv2 = i;
                type$iv4 = type$iv;
                this_$iv$iv4 = this_$iv$iv;
            }
        }
        obj = null;
        Intrinsics.checkNotNull(obj);
        Modifier.Node node2 = ((SemanticsModifierNode) obj).getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        return new SemanticsNode(node2, mergingEnabled, layoutNode, collapsedSemantics$ui_release);
    }

    public static /* synthetic */ SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        }
        return SemanticsNode(semanticsModifierNode, z, layoutNode);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode outerSemanticsNode, boolean mergingEnabled, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Modifier.Node node = outerSemanticsNode.getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release == null) {
            collapsedSemantics$ui_release = new SemanticsConfiguration();
        }
        return new SemanticsNode(node, mergingEnabled, layoutNode, collapsedSemantics$ui_release);
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode $this$outerMergingSemantics) {
        Object it$iv;
        NodeChain this_$iv;
        int type$iv;
        int i;
        NodeChain this_$iv$iv;
        int type$iv2;
        int i2;
        NodeChain this_$iv$iv2;
        int type$iv3;
        int i3;
        NodeChain this_$iv$iv3;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$outerMergingSemantics, "<this>");
        NodeChain this_$iv2 = $this$outerMergingSemantics.getNodes();
        int type$iv4 = NodeKind.m4400constructorimpl(8);
        int i4 = 0;
        NodeChain this_$iv$iv4 = this_$iv2;
        if ((this_$iv$iv4.getAggregateChildKindSet() & type$iv4) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv4.getHead();
            loop0: while (node$iv$iv$iv$iv != null) {
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet() & type$iv4) == 0) {
                    this_$iv = this_$iv2;
                    type$iv = type$iv4;
                    i = i4;
                    this_$iv$iv = this_$iv$iv4;
                } else {
                    MutableVector mutableVector2 = null;
                    this_$iv = this_$iv2;
                    Modifier.Node node = it$iv$iv$iv;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            it$iv = node;
                            SemanticsModifierNode it = (SemanticsModifierNode) it$iv;
                            if (it.getShouldMergeDescendantSemantics()) {
                                break loop0;
                            }
                            type$iv2 = type$iv4;
                            i2 = i4;
                            this_$iv$iv2 = this_$iv$iv4;
                        } else {
                            Modifier.Node this_$iv$iv$iv$iv = node;
                            if (((this_$iv$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                type$iv2 = type$iv4;
                                i2 = i4;
                                this_$iv$iv2 = this_$iv$iv4;
                            } else {
                                int count$iv$iv$iv2 = 0;
                                DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv$iv2 != null) {
                                    Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv2;
                                    if (!((next$iv$iv$iv.getKindSet() & type$iv4) != 0)) {
                                        type$iv3 = type$iv4;
                                        i3 = i4;
                                        this_$iv$iv3 = this_$iv$iv4;
                                    } else {
                                        count$iv$iv$iv2++;
                                        type$iv3 = type$iv4;
                                        if (count$iv$iv$iv2 == 1) {
                                            node = next$iv$iv$iv;
                                            i3 = i4;
                                            this_$iv$iv3 = this_$iv$iv4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                count$iv$iv$iv = count$iv$iv$iv2;
                                                i3 = i4;
                                                this_$iv$iv3 = this_$iv$iv4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                count$iv$iv$iv = count$iv$iv$iv2;
                                                i3 = i4;
                                                this_$iv$iv3 = this_$iv$iv4;
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
                                    this_$iv$iv4 = this_$iv$iv3;
                                }
                                type$iv2 = type$iv4;
                                i2 = i4;
                                this_$iv$iv2 = this_$iv$iv4;
                                if (count$iv$iv$iv2 == 1) {
                                    type$iv4 = type$iv2;
                                    i4 = i2;
                                    this_$iv$iv4 = this_$iv$iv2;
                                }
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector2);
                        type$iv4 = type$iv2;
                        i4 = i2;
                        this_$iv$iv4 = this_$iv$iv2;
                    }
                    type$iv = type$iv4;
                    i = i4;
                    this_$iv$iv = this_$iv$iv4;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                this_$iv2 = this_$iv;
                type$iv4 = type$iv;
                i4 = i;
                this_$iv$iv4 = this_$iv$iv;
            }
        }
        it$iv = null;
        return (SemanticsModifierNode) it$iv;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        Intrinsics.checkNotNullParameter($this$findClosestParentNode, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (selector.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Role getRole(SemanticsNode $this$role) {
        return (Role) SemanticsConfigurationKt.getOrNull($this$role.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode $this$contentDescriptionFakeNodeId) {
        return $this$contentDescriptionFakeNodeId.getId() + 2000000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode $this$roleFakeNodeId) {
        return $this$roleFakeNodeId.getId() + 1000000000;
    }
}
