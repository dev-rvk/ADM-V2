package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTransactions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a!\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001a!\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000e\u001a!\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean requestFocus(FocusTargetNode $this$requestFocus) {
        Intrinsics.checkNotNullParameter($this$requestFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[m2661performCustomRequestFocusMxy_nc0($this$requestFocus, FocusDirection.INSTANCE.m2638getEnterdhqQ8s()).ordinal()]) {
            case 1:
                return performRequestFocus($this$requestFocus);
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean performRequestFocus(FocusTargetNode $this$performRequestFocus) {
        boolean z;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        boolean z2;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        boolean z3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$performRequestFocus, "<this>");
        boolean z4 = true;
        switch (WhenMappings.$EnumSwitchMapping$1[$this$performRequestFocus.getFocusState().ordinal()]) {
            case 1:
            case 2:
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                return true;
            case 3:
                boolean z5 = clearChildFocus$default($this$performRequestFocus, false, false, 3, null) && grantFocus($this$performRequestFocus);
                boolean success = z5;
                if (success) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                }
                return z5;
            case 4:
                FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4 = $this$performRequestFocus;
                int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
                if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
                while (true) {
                    if (layout$iv$iv$iv != null) {
                        Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                        if ((head$iv$iv$iv.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                            z2 = z4;
                        } else {
                            while (node$iv$iv$iv != null) {
                                if ((node$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                                    MutableVector mutableVector2 = null;
                                    node = it$iv$iv;
                                    while (node != null) {
                                        if (node instanceof FocusTargetNode) {
                                            z = z4;
                                        } else {
                                            Modifier.Node this_$iv$iv$iv$iv = node;
                                            if (!((this_$iv$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0 ? z4 : false) || !(node instanceof DelegatingNode)) {
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                z3 = z4;
                                            } else {
                                                int count$iv$iv$iv2 = 0;
                                                DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                                                Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                                while (node$iv$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                    if (!((next$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0 ? z4 : false)) {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                    } else {
                                                        count$iv$iv$iv2++;
                                                        if (count$iv$iv$iv2 == z4) {
                                                            node = next$iv$iv$iv;
                                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        } else {
                                                            if (mutableVector2 != null) {
                                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                                count$iv$iv$iv = count$iv$iv$iv2;
                                                                mutableVector = mutableVector2;
                                                            } else {
                                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                                count$iv$iv$iv = count$iv$iv$iv2;
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
                                                            count$iv$iv$iv2 = count$iv$iv$iv;
                                                        }
                                                    }
                                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                                    z4 = true;
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                z3 = true;
                                                if (count$iv$iv$iv2 == 1) {
                                                    z4 = true;
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                }
                                            }
                                            node = DelegatableNodeKt.pop(mutableVector2);
                                            z4 = z3;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                        }
                                    }
                                }
                                node$iv$iv$iv = node$iv$iv$iv.getParent();
                                z4 = z4;
                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                            }
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                            z2 = z4;
                        }
                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                        node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
                        z4 = z2;
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
                    } else {
                        z = z4;
                        node = null;
                    }
                }
                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                if (focusTargetNode != null) {
                    return requestFocusForChild(focusTargetNode, $this$performRequestFocus);
                }
                boolean z6 = (requestFocusForOwner($this$performRequestFocus) && grantFocus($this$performRequestFocus)) ? z : false;
                boolean success2 = z6;
                if (success2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$performRequestFocus);
                }
                return z6;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean captureFocus(FocusTargetNode $this$captureFocus) {
        Intrinsics.checkNotNullParameter($this$captureFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$captureFocus.getFocusState().ordinal()]) {
            case 1:
                $this$captureFocus.setFocusState(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$captureFocus);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(FocusTargetNode $this$freeFocus) {
        Intrinsics.checkNotNullParameter($this$freeFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$freeFocus.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                $this$freeFocus.setFocusState(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$freeFocus);
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode $this$clearFocus, boolean forced, boolean refreshFocusEvents) {
        Intrinsics.checkNotNullParameter($this$clearFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$clearFocus.getFocusState().ordinal()]) {
            case 1:
                $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                if (!refreshFocusEvents) {
                    return true;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                return true;
            case 2:
                if (forced) {
                    $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                    if (refreshFocusEvents) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                    }
                }
                return forced;
            case 3:
                if (clearChildFocus($this$clearFocus, forced, refreshFocusEvents)) {
                    $this$clearFocus.setFocusState(FocusStateImpl.Inactive);
                    if (!refreshFocusEvents) {
                        return true;
                    }
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                    return true;
                }
                return false;
            case 4:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean grantFocus(final FocusTargetNode $this$grantFocus) {
        ObserverModifierNodeKt.observeReads($this$grantFocus, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
            }
        });
        switch (WhenMappings.$EnumSwitchMapping$1[$this$grantFocus.getFocusState().ordinal()]) {
            case 3:
            case 4:
                $this$grantFocus.setFocusState(FocusStateImpl.Active);
                return true;
            default:
                return true;
        }
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode $this$clearChildFocus, boolean forced, boolean refreshFocusEvents) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild($this$clearChildFocus);
        if (activeChild != null) {
            return clearFocus(activeChild, forced, refreshFocusEvents);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetNode $this$requestFocusForChild, FocusTargetNode childNode) {
        Modifier.Node node;
        int type$iv;
        Object obj;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int type$iv2;
        int i;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv3;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
        int type$iv4;
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3;
        int count$iv$iv$iv;
        MutableVector mutableVector;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int type$iv5;
        int i2;
        NodeChain nodes2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv4;
        int type$iv6;
        int i3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv5;
        int type$iv7;
        int i4;
        MutableVector mutableVector2;
        FocusTargetNode $this$nearestAncestor_u2d64DMado$iv6 = childNode;
        int type$iv8 = NodeKind.m4400constructorimpl(1024);
        int i5 = 0;
        if (!$this$nearestAncestor_u2d64DMado$iv6.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv6.getNode().getParent();
        LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv6);
        loop0: while (true) {
            int i6 = 1;
            if (layout$iv$iv$iv != null) {
                Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                if ((head$iv$iv$iv.getAggregateChildKindSet() & type$iv8) == 0) {
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv6;
                    type$iv5 = type$iv8;
                    i2 = i5;
                } else {
                    while (node$iv$iv$iv != null) {
                        if ((node$iv$iv$iv.getKindSet() & type$iv8) != 0) {
                            Modifier.Node it$iv$iv = node$iv$iv$iv;
                            MutableVector mutableVector3 = null;
                            Modifier.Node node2 = it$iv$iv;
                            while (node2 != null) {
                                if (node2 instanceof FocusTargetNode) {
                                    node = node2;
                                    break loop0;
                                }
                                Modifier.Node this_$iv$iv$iv$iv = node2;
                                if (((this_$iv$iv$iv$iv.getKindSet() & type$iv8) != 0 ? i6 : 0) == 0 || !(node2 instanceof DelegatingNode)) {
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv6;
                                    type$iv6 = type$iv8;
                                    i3 = i5;
                                } else {
                                    int count$iv$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node2;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if (((next$iv$iv$iv.getKindSet() & type$iv8) != 0 ? i6 : 0) == 0) {
                                            $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv6;
                                            type$iv7 = type$iv8;
                                            i4 = i5;
                                        } else {
                                            count$iv$iv$iv2++;
                                            if (count$iv$iv$iv2 == i6) {
                                                node2 = next$iv$iv$iv;
                                                $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv6;
                                                type$iv7 = type$iv8;
                                                i4 = i5;
                                            } else {
                                                if (mutableVector3 != null) {
                                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv6;
                                                    type$iv7 = type$iv8;
                                                    i4 = i5;
                                                    mutableVector2 = mutableVector3;
                                                } else {
                                                    $this$nearestAncestor_u2d64DMado$iv5 = $this$nearestAncestor_u2d64DMado$iv6;
                                                    type$iv7 = type$iv8;
                                                    i4 = i5;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                Modifier.Node theNode$iv$iv$iv = node2;
                                                if (theNode$iv$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv$iv);
                                                }
                                                mutableVector3 = mutableVector2;
                                            }
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv5;
                                        type$iv8 = type$iv7;
                                        i5 = i4;
                                        i6 = 1;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv6;
                                    type$iv6 = type$iv8;
                                    i3 = i5;
                                    if (count$iv$iv$iv2 == 1) {
                                        $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv8 = type$iv6;
                                        i5 = i3;
                                        i6 = 1;
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector3);
                                $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv4;
                                type$iv8 = type$iv6;
                                i5 = i3;
                                i6 = 1;
                            }
                        }
                        node$iv$iv$iv = node$iv$iv$iv.getParent();
                        $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv6;
                        type$iv8 = type$iv8;
                        i5 = i5;
                        i6 = 1;
                    }
                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv6;
                    type$iv5 = type$iv8;
                    i2 = i5;
                }
                layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                $this$nearestAncestor_u2d64DMado$iv6 = $this$nearestAncestor_u2d64DMado$iv3;
                type$iv8 = type$iv5;
                i5 = i2;
            } else {
                node = null;
                break;
            }
        }
        if (!Intrinsics.areEqual(node, $this$requestFocusForChild)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        switch (WhenMappings.$EnumSwitchMapping$1[$this$requestFocusForChild.getFocusState().ordinal()]) {
            case 1:
                boolean success = grantFocus(childNode);
                if (success) {
                    $this$requestFocusForChild.setFocusState(FocusStateImpl.ActiveParent);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                    return success;
                }
                return success;
            case 2:
                return false;
            case 3:
                if (FocusTraversalKt.getActiveChild($this$requestFocusForChild) != null) {
                    boolean success2 = clearChildFocus$default($this$requestFocusForChild, false, false, 3, null) && grantFocus(childNode);
                    if (success2) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                    }
                    return success2;
                }
                throw new IllegalStateException("Required value was null.".toString());
            case 4:
                FocusTargetNode $this$nearestAncestor_u2d64DMado$iv7 = $this$requestFocusForChild;
                int type$iv9 = NodeKind.m4400constructorimpl(1024);
                int count$iv$iv$iv3 = 0;
                DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$nearestAncestor_u2d64DMado$iv7;
                if (!$this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4.getNode().getParent();
                LayoutNode layout$iv$iv$iv2 = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4);
                while (true) {
                    if (layout$iv$iv$iv2 != null) {
                        Modifier.Node head$iv$iv$iv2 = layout$iv$iv$iv2.getNodes().getHead();
                        if ((head$iv$iv$iv2.getAggregateChildKindSet() & type$iv9) == 0) {
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv7;
                            type$iv2 = type$iv9;
                            i = count$iv$iv$iv3;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                        } else {
                            while (node$iv$iv$iv2 != null) {
                                if ((node$iv$iv$iv2.getKindSet() & type$iv9) == 0) {
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv7;
                                } else {
                                    Modifier.Node it$iv$iv2 = node$iv$iv$iv2;
                                    MutableVector mutableVector4 = null;
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv7;
                                    Modifier.Node node3 = it$iv$iv2;
                                    while (node3 != null) {
                                        int i7 = count$iv$iv$iv3;
                                        if (node3 instanceof FocusTargetNode) {
                                            Object it$iv = node3;
                                            obj = it$iv;
                                            type$iv = 1;
                                        } else {
                                            Modifier.Node this_$iv$iv$iv$iv3 = node3;
                                            if (!((this_$iv$iv$iv$iv3.getKindSet() & type$iv9) != 0) || !(node3 instanceof DelegatingNode)) {
                                                type$iv3 = type$iv9;
                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                            } else {
                                                int count$iv$iv$iv4 = 0;
                                                DelegatingNode this_$iv$iv$iv$iv4 = (DelegatingNode) node3;
                                                Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv4.getDelegate();
                                                while (node$iv$iv$iv$iv2 != null) {
                                                    Modifier.Node next$iv$iv$iv2 = node$iv$iv$iv$iv2;
                                                    if (!((next$iv$iv$iv2.getKindSet() & type$iv9) != 0)) {
                                                        type$iv4 = type$iv9;
                                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                    } else {
                                                        count$iv$iv$iv4++;
                                                        type$iv4 = type$iv9;
                                                        if (count$iv$iv$iv4 == 1) {
                                                            node3 = next$iv$iv$iv2;
                                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                        } else {
                                                            if (mutableVector4 != null) {
                                                                count$iv$iv$iv = count$iv$iv$iv4;
                                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                                mutableVector = mutableVector4;
                                                            } else {
                                                                count$iv$iv$iv = count$iv$iv$iv4;
                                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            MutableVector mutableVector5 = mutableVector;
                                                            Modifier.Node theNode$iv$iv$iv2 = node3;
                                                            if (theNode$iv$iv$iv2 != null) {
                                                                if (mutableVector5 != null) {
                                                                    mutableVector5.add(theNode$iv$iv$iv2);
                                                                }
                                                                node3 = null;
                                                            }
                                                            if (mutableVector5 != null) {
                                                                mutableVector5.add(next$iv$iv$iv2);
                                                            }
                                                            mutableVector4 = mutableVector5;
                                                            count$iv$iv$iv4 = count$iv$iv$iv;
                                                        }
                                                    }
                                                    node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild();
                                                    type$iv9 = type$iv4;
                                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv3;
                                                }
                                                type$iv3 = type$iv9;
                                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                                                if (count$iv$iv$iv4 == 1) {
                                                    count$iv$iv$iv3 = i7;
                                                    type$iv9 = type$iv3;
                                                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                                }
                                            }
                                            node3 = DelegatableNodeKt.pop(mutableVector4);
                                            count$iv$iv$iv3 = i7;
                                            type$iv9 = type$iv3;
                                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv2;
                                        }
                                    }
                                }
                                node$iv$iv$iv2 = node$iv$iv$iv2.getParent();
                                $this$nearestAncestor_u2d64DMado$iv7 = $this$nearestAncestor_u2d64DMado$iv2;
                                count$iv$iv$iv3 = count$iv$iv$iv3;
                                type$iv9 = type$iv9;
                                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                            }
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv7;
                            type$iv2 = type$iv9;
                            i = count$iv$iv$iv3;
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4;
                        }
                        layout$iv$iv$iv2 = layout$iv$iv$iv2.getParent$ui_release();
                        node$iv$iv$iv2 = (layout$iv$iv$iv2 == null || (nodes = layout$iv$iv$iv2.getNodes()) == null) ? null : nodes.getTail();
                        $this$nearestAncestor_u2d64DMado$iv7 = $this$nearestAncestor_u2d64DMado$iv;
                        count$iv$iv$iv3 = i;
                        type$iv9 = type$iv2;
                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv4 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv$iv;
                    } else {
                        type$iv = 1;
                        obj = null;
                    }
                }
                FocusTargetNode focusParent = (FocusTargetNode) obj;
                if (focusParent == null && requestFocusForOwner($this$requestFocusForChild)) {
                    $this$requestFocusForChild.setFocusState(FocusStateImpl.Active);
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                    return requestFocusForChild($this$requestFocusForChild, childNode);
                }
                if (focusParent != null && requestFocusForChild(focusParent, $this$requestFocusForChild)) {
                    boolean requestFocusForChild = requestFocusForChild($this$requestFocusForChild, childNode);
                    if (($this$requestFocusForChild.getFocusState() == FocusStateImpl.ActiveParent ? type$iv : 0) != 0) {
                        return requestFocusForChild;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean requestFocusForOwner(FocusTargetNode $this$requestFocusForOwner) {
        LayoutNode layoutNode;
        Owner owner;
        NodeCoordinator coordinator$ui_release = $this$requestFocusForOwner.getCoordinator();
        if (coordinator$ui_release == null || (layoutNode = coordinator$ui_release.getLayoutNode()) == null || (owner = layoutNode.getOwner()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner.requestFocus();
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m2661performCustomRequestFocusMxy_nc0(FocusTargetNode performCustomRequestFocus, int focusDirection) {
        int i;
        int type$iv;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int type$iv2;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv3;
        int i2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int type$iv4;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter(performCustomRequestFocus, "$this$performCustomRequestFocus");
        switch (WhenMappings.$EnumSwitchMapping$1[performCustomRequestFocus.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return CustomDestinationResult.None;
            case 3:
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomRequestFocus);
                if (activeChild != null) {
                    return m2658performCustomClearFocusMxy_nc0(activeChild, focusDirection);
                }
                throw new IllegalStateException("Required value was null.".toString());
            case 4:
                FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4 = performCustomRequestFocus;
                int type$iv5 = NodeKind.m4400constructorimpl(1024);
                if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
                while (true) {
                    int i3 = 1;
                    if (layout$iv$iv$iv == null) {
                        i = 1;
                        type$iv = 0;
                        node = null;
                    } else {
                        Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                        if ((head$iv$iv$iv.getAggregateChildKindSet() & type$iv5) == 0) {
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                            type$iv2 = type$iv5;
                        } else {
                            while (node$iv$iv$iv != null) {
                                if ((node$iv$iv$iv.getKindSet() & type$iv5) != 0) {
                                    Modifier.Node it$iv$iv = node$iv$iv$iv;
                                    MutableVector mutableVector2 = null;
                                    Modifier.Node node2 = it$iv$iv;
                                    while (node2 != null) {
                                        if (node2 instanceof FocusTargetNode) {
                                            node = node2;
                                            i = i3;
                                            type$iv = 0;
                                        } else {
                                            Modifier.Node this_$iv$iv$iv$iv = node2;
                                            if (((this_$iv$iv$iv$iv.getKindSet() & type$iv5) != 0 ? i3 : 0) == 0 || !(node2 instanceof DelegatingNode)) {
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv3 = type$iv5;
                                                i2 = i3;
                                            } else {
                                                int count$iv$iv$iv = 0;
                                                DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node2;
                                                Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                                while (node$iv$iv$iv$iv != null) {
                                                    Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                                    if (((next$iv$iv$iv.getKindSet() & type$iv5) != 0 ? i3 : 0) == 0) {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        type$iv4 = type$iv5;
                                                    } else {
                                                        count$iv$iv$iv++;
                                                        if (count$iv$iv$iv == i3) {
                                                            node2 = next$iv$iv$iv;
                                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                            type$iv4 = type$iv5;
                                                        } else {
                                                            if (mutableVector2 != null) {
                                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                                type$iv4 = type$iv5;
                                                                mutableVector = mutableVector2;
                                                            } else {
                                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                                type$iv4 = type$iv5;
                                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            Modifier.Node theNode$iv$iv$iv = node2;
                                                            if (theNode$iv$iv$iv != null) {
                                                                if (mutableVector != null) {
                                                                    mutableVector.add(theNode$iv$iv$iv);
                                                                }
                                                                node2 = null;
                                                            }
                                                            if (mutableVector != null) {
                                                                mutableVector.add(next$iv$iv$iv);
                                                            }
                                                            mutableVector2 = mutableVector;
                                                        }
                                                    }
                                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                                    type$iv5 = type$iv4;
                                                    i3 = 1;
                                                }
                                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv3 = type$iv5;
                                                i2 = 1;
                                                if (count$iv$iv$iv == 1) {
                                                    i3 = 1;
                                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                                    type$iv5 = type$iv3;
                                                }
                                            }
                                            node2 = DelegatableNodeKt.pop(mutableVector2);
                                            i3 = i2;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv5 = type$iv3;
                                        }
                                    }
                                }
                                node$iv$iv$iv = node$iv$iv$iv.getParent();
                                i3 = i3;
                                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                                type$iv5 = type$iv5;
                            }
                            $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                            type$iv2 = type$iv5;
                        }
                        layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                        node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
                        type$iv5 = type$iv2;
                    }
                }
                FocusTargetNode focusParent = (FocusTargetNode) node;
                if (focusParent == null) {
                    return CustomDestinationResult.None;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[focusParent.getFocusState().ordinal()]) {
                    case 1:
                        return m2659performCustomEnterMxy_nc0(focusParent, focusDirection);
                    case 2:
                        return CustomDestinationResult.Cancelled;
                    case 3:
                        return m2661performCustomRequestFocusMxy_nc0(focusParent, focusDirection);
                    case 4:
                        CustomDestinationResult it = m2661performCustomRequestFocusMxy_nc0(focusParent, focusDirection);
                        CustomDestinationResult customDestinationResult = (it == CustomDestinationResult.None ? i : type$iv) == 0 ? it : null;
                        if (customDestinationResult != null) {
                            return customDestinationResult;
                        }
                        return m2659performCustomEnterMxy_nc0(focusParent, focusDirection);
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m2658performCustomClearFocusMxy_nc0(FocusTargetNode performCustomClearFocus, int focusDirection) {
        Intrinsics.checkNotNullParameter(performCustomClearFocus, "$this$performCustomClearFocus");
        switch (WhenMappings.$EnumSwitchMapping$1[performCustomClearFocus.getFocusState().ordinal()]) {
            case 1:
            case 4:
                return CustomDestinationResult.None;
            case 2:
                return CustomDestinationResult.Cancelled;
            case 3:
                FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomClearFocus);
                if (activeChild != null) {
                    CustomDestinationResult it = m2658performCustomClearFocusMxy_nc0(activeChild, focusDirection);
                    if (it == CustomDestinationResult.None) {
                        it = null;
                    }
                    if (it == null) {
                        return m2660performCustomExitMxy_nc0(performCustomClearFocus, focusDirection);
                    }
                    return it;
                }
                throw new IllegalStateException("Required value was null.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m2659performCustomEnterMxy_nc0(FocusTargetNode $this$performCustomEnter_u2dMxy_nc0, int focusDirection) {
        CustomDestinationResult customDestinationResult;
        if (!$this$performCustomEnter_u2dMxy_nc0.isProcessingCustomEnter) {
            $this$performCustomEnter_u2dMxy_nc0.isProcessingCustomEnter = true;
            try {
                FocusRequester it$iv = $this$performCustomEnter_u2dMxy_nc0.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2626boximpl(focusDirection));
                if (it$iv != FocusRequester.INSTANCE.getDefault()) {
                    if (it$iv == FocusRequester.INSTANCE.getCancel()) {
                        customDestinationResult = CustomDestinationResult.Cancelled;
                    } else {
                        customDestinationResult = it$iv.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    }
                    return customDestinationResult;
                }
            } finally {
                $this$performCustomEnter_u2dMxy_nc0.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m2660performCustomExitMxy_nc0(FocusTargetNode $this$performCustomExit_u2dMxy_nc0, int focusDirection) {
        CustomDestinationResult customDestinationResult;
        if (!$this$performCustomExit_u2dMxy_nc0.isProcessingCustomExit) {
            $this$performCustomExit_u2dMxy_nc0.isProcessingCustomExit = true;
            try {
                FocusRequester it$iv = $this$performCustomExit_u2dMxy_nc0.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2626boximpl(focusDirection));
                if (it$iv != FocusRequester.INSTANCE.getDefault()) {
                    if (it$iv == FocusRequester.INSTANCE.getCancel()) {
                        customDestinationResult = CustomDestinationResult.Cancelled;
                    } else {
                        customDestinationResult = it$iv.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    }
                    return customDestinationResult;
                }
            } finally {
                $this$performCustomExit_u2dMxy_nc0.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
