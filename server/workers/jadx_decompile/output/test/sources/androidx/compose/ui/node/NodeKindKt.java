package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a&\u0010\u001c\u001a\u00020\t*\u00020\u00012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\nH\u0080\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a&\u0010 \u001a\u00020\u0001*\u00020\u00012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\nH\u0080\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\f\u0010$\u001a\u00020\u000e*\u00020%H\u0002\u001a\f\u0010&\u001a\u00020\t*\u00020%H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u001f\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\n8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", "value", "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* renamed from: or-64DMado, reason: not valid java name */
    public static final int m4410or64DMado(int $this$or_u2d64DMado, int other) {
        return $this$or_u2d64DMado | other;
    }

    /* renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m4408contains64DMado(int $this$contains_u2d64DMado, int value) {
        return ($this$contains_u2d64DMado & value) != 0;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m4409getIncludeSelfInTraversalH91voCI(int $this$includeSelfInTraversal) {
        return (NodeKind.m4400constructorimpl(128) & $this$includeSelfInTraversal) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int mask = NodeKind.m4400constructorimpl(1);
        if (element instanceof LayoutModifier) {
            int other$iv = NodeKind.m4400constructorimpl(2) | mask;
            mask = other$iv;
        }
        if (element instanceof DrawModifier) {
            int $this$or_u2d64DMado$iv = mask;
            int other$iv2 = NodeKind.m4400constructorimpl(4) | $this$or_u2d64DMado$iv;
            mask = other$iv2;
        }
        if (element instanceof SemanticsModifier) {
            int $this$or_u2d64DMado$iv2 = mask;
            int other$iv3 = NodeKind.m4400constructorimpl(8) | $this$or_u2d64DMado$iv2;
            mask = other$iv3;
        }
        if (element instanceof PointerInputModifier) {
            int $this$or_u2d64DMado$iv3 = mask;
            int other$iv4 = NodeKind.m4400constructorimpl(16) | $this$or_u2d64DMado$iv3;
            mask = other$iv4;
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            int $this$or_u2d64DMado$iv4 = mask;
            int other$iv5 = NodeKind.m4400constructorimpl(32) | $this$or_u2d64DMado$iv4;
            mask = other$iv5;
        }
        if (element instanceof FocusEventModifier) {
            int $this$or_u2d64DMado$iv5 = mask;
            int other$iv6 = NodeKind.m4400constructorimpl(4096) | $this$or_u2d64DMado$iv5;
            mask = other$iv6;
        }
        if (element instanceof FocusOrderModifier) {
            int $this$or_u2d64DMado$iv6 = mask;
            int other$iv7 = NodeKind.m4400constructorimpl(2048) | $this$or_u2d64DMado$iv6;
            mask = other$iv7;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            int $this$or_u2d64DMado$iv7 = mask;
            int other$iv8 = NodeKind.m4400constructorimpl(256) | $this$or_u2d64DMado$iv7;
            mask = other$iv8;
        }
        if (element instanceof ParentDataModifier) {
            int $this$or_u2d64DMado$iv8 = mask;
            int other$iv9 = NodeKind.m4400constructorimpl(64) | $this$or_u2d64DMado$iv8;
            mask = other$iv9;
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) {
            int $this$or_u2d64DMado$iv9 = mask;
            int other$iv10 = NodeKind.m4400constructorimpl(128) | $this$or_u2d64DMado$iv9;
            return other$iv10;
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        int mask = NodeKind.m4400constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            int other$iv = NodeKind.m4400constructorimpl(2) | mask;
            mask = other$iv;
        }
        if (node instanceof DrawModifierNode) {
            int $this$or_u2d64DMado$iv = mask;
            int other$iv2 = NodeKind.m4400constructorimpl(4) | $this$or_u2d64DMado$iv;
            mask = other$iv2;
        }
        if (node instanceof SemanticsModifierNode) {
            int $this$or_u2d64DMado$iv2 = mask;
            int other$iv3 = NodeKind.m4400constructorimpl(8) | $this$or_u2d64DMado$iv2;
            mask = other$iv3;
        }
        if (node instanceof PointerInputModifierNode) {
            int $this$or_u2d64DMado$iv3 = mask;
            int other$iv4 = NodeKind.m4400constructorimpl(16) | $this$or_u2d64DMado$iv3;
            mask = other$iv4;
        }
        if (node instanceof ModifierLocalModifierNode) {
            int $this$or_u2d64DMado$iv4 = mask;
            int other$iv5 = NodeKind.m4400constructorimpl(32) | $this$or_u2d64DMado$iv4;
            mask = other$iv5;
        }
        if (node instanceof ParentDataModifierNode) {
            int $this$or_u2d64DMado$iv5 = mask;
            int other$iv6 = NodeKind.m4400constructorimpl(64) | $this$or_u2d64DMado$iv5;
            mask = other$iv6;
        }
        if (node instanceof LayoutAwareModifierNode) {
            int $this$or_u2d64DMado$iv6 = mask;
            int other$iv7 = NodeKind.m4400constructorimpl(128) | $this$or_u2d64DMado$iv6;
            mask = other$iv7;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            int $this$or_u2d64DMado$iv7 = mask;
            int other$iv8 = NodeKind.m4400constructorimpl(256) | $this$or_u2d64DMado$iv7;
            mask = other$iv8;
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            int $this$or_u2d64DMado$iv8 = mask;
            int other$iv9 = NodeKind.m4400constructorimpl(512) | $this$or_u2d64DMado$iv8;
            mask = other$iv9;
        }
        if (node instanceof FocusTargetNode) {
            int $this$or_u2d64DMado$iv9 = mask;
            int other$iv10 = NodeKind.m4400constructorimpl(1024) | $this$or_u2d64DMado$iv9;
            mask = other$iv10;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            int $this$or_u2d64DMado$iv10 = mask;
            int other$iv11 = NodeKind.m4400constructorimpl(2048) | $this$or_u2d64DMado$iv10;
            mask = other$iv11;
        }
        if (node instanceof FocusEventModifierNode) {
            int $this$or_u2d64DMado$iv11 = mask;
            int other$iv12 = NodeKind.m4400constructorimpl(4096) | $this$or_u2d64DMado$iv11;
            mask = other$iv12;
        }
        if (node instanceof KeyInputModifierNode) {
            int $this$or_u2d64DMado$iv12 = mask;
            int other$iv13 = NodeKind.m4400constructorimpl(8192) | $this$or_u2d64DMado$iv12;
            mask = other$iv13;
        }
        if (node instanceof RotaryInputModifierNode) {
            int $this$or_u2d64DMado$iv13 = mask;
            int other$iv14 = NodeKind.m4400constructorimpl(16384) | $this$or_u2d64DMado$iv13;
            mask = other$iv14;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            int $this$or_u2d64DMado$iv14 = mask;
            int other$iv15 = NodeKind.m4400constructorimpl(32768) | $this$or_u2d64DMado$iv14;
            mask = other$iv15;
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            int $this$or_u2d64DMado$iv15 = mask;
            int other$iv16 = NodeKind.m4400constructorimpl(131072) | $this$or_u2d64DMado$iv15;
            return other$iv16;
        }
        return mask;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int remainingSet, int phase) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            autoInvalidateNodeSelf(node, ((DelegatingNode) node).getSelfKindSet() & remainingSet, phase);
            int newRemaining = (~((DelegatingNode) node).getSelfKindSet()) & remainingSet;
            DelegatingNode this_$iv = (DelegatingNode) node;
            for (Modifier.Node node$iv = this_$iv.getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
                Modifier.Node it = node$iv;
                autoInvalidateNodeIncludingDelegates(it, newRemaining, phase);
            }
            return;
        }
        autoInvalidateNodeSelf(node, node.getKindSet() & remainingSet, phase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int selfKindSet, int phase) {
        if (phase != 0 || node.getShouldAutoInvalidate()) {
            int value$iv = (selfKindSet & NodeKind.m4400constructorimpl(2)) != 0 ? 1 : 0;
            if (value$iv != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (phase == 2) {
                    NodeCoordinator coordinator = DelegatableNodeKt.m4299requireCoordinator64DMado(node, NodeKind.m4400constructorimpl(2));
                    coordinator.onRelease();
                }
            }
            int value$iv2 = (selfKindSet & NodeKind.m4400constructorimpl(256)) != 0 ? 1 : 0;
            if (value$iv2 != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            int value$iv3 = (selfKindSet & NodeKind.m4400constructorimpl(4)) != 0 ? 1 : 0;
            if (value$iv3 != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            int value$iv4 = (selfKindSet & NodeKind.m4400constructorimpl(8)) != 0 ? 1 : 0;
            if (value$iv4 != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            int value$iv5 = (selfKindSet & NodeKind.m4400constructorimpl(64)) != 0 ? 1 : 0;
            if (value$iv5 != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            int value$iv6 = (selfKindSet & NodeKind.m4400constructorimpl(1024)) != 0 ? 1 : 0;
            if (value$iv6 != 0 && (node instanceof FocusTargetNode)) {
                if (phase == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            int value$iv7 = (selfKindSet & NodeKind.m4400constructorimpl(2048)) != 0 ? 1 : 0;
            if (value$iv7 != 0 && (node instanceof FocusPropertiesModifierNode) && specifiesCanFocusProperty((FocusPropertiesModifierNode) node)) {
                if (phase == 2) {
                    scheduleInvalidationOfAssociatedFocusTargets((FocusPropertiesModifierNode) node);
                } else {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties((FocusPropertiesModifierNode) node);
                }
            }
            if (((selfKindSet & NodeKind.m4400constructorimpl(4096)) != 0) && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
            }
        }
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode $this$scheduleInvalidationOfAssociatedFocusTargets) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv;
        int i;
        boolean z;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        int i2;
        MutableVector mutableVector;
        FocusPropertiesModifierNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$scheduleInvalidationOfAssociatedFocusTargets;
        int type$iv3 = NodeKind.m4400constructorimpl(1024);
        int i3 = 0;
        if (!$this$visitChildren_u2d6rFNWt0$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv3.getNode());
        } else {
            branches$iv$iv.add(child$iv$iv);
        }
        while (branches$iv$iv.isNotEmpty()) {
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & type$iv3) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (true) {
                    if (node$iv$iv == null) {
                        break;
                    }
                    if ((node$iv$iv.getKindSet() & type$iv3) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                FocusTargetNodeKt.invalidateFocusTarget(it);
                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                type$iv = type$iv3;
                                i = i3;
                                z = true;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                if (!((this_$iv$iv$iv.getKindSet() & type$iv3) != 0) || !(node instanceof DelegatingNode)) {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv3;
                                    i = i3;
                                    z = true;
                                } else {
                                    int count$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & type$iv3) != 0)) {
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv2 = type$iv3;
                                            i2 = i3;
                                        } else {
                                            count$iv$iv++;
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            if (count$iv$iv == 1) {
                                                node = next$iv$iv;
                                                type$iv2 = type$iv3;
                                                i2 = i3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    type$iv2 = type$iv3;
                                                    i2 = i3;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    type$iv2 = type$iv3;
                                                    i2 = i3;
                                                    mutableVector = mutableVector2;
                                                }
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                        type$iv3 = type$iv2;
                                        i3 = i2;
                                    }
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv3;
                                    i = i3;
                                    z = true;
                                    if (count$iv$iv == 1) {
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        type$iv3 = type$iv;
                                        i3 = i;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                            type$iv3 = type$iv;
                            i3 = i;
                        }
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv3;
                    }
                }
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode $this$specifiesCanFocusProperty) {
        CanFocusChecker.INSTANCE.reset();
        $this$specifiesCanFocusProperty.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            int mask = ((DelegatingNode) node).getSelfKindSet();
            DelegatingNode this_$iv = (DelegatingNode) node;
            for (Modifier.Node node$iv = this_$iv.getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
                Modifier.Node it = node$iv;
                mask |= calculateNodeKindSetFromIncludingDelegates(it);
            }
            return mask;
        }
        return calculateNodeKindSetFrom(node);
    }
}
