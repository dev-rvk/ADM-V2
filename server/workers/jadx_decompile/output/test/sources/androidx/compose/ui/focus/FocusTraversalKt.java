package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001a=\u0010\u0013\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0015H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m2662customFocusSearchOMvw8(FocusTargetNode customFocusSearch, int focusDirection, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester start;
        Intrinsics.checkNotNullParameter(customFocusSearch, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        FocusProperties focusProperties = customFocusSearch.fetchFocusProperties$ui_release();
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2642getNextdhqQ8s())) {
            return focusProperties.getNext();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s())) {
            return focusProperties.getPrevious();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            return focusProperties.getUp();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            return focusProperties.getDown();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    start = focusProperties.getStart();
                    break;
                case 2:
                    start = focusProperties.getEnd();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusRequester it = start;
            if (it == FocusRequester.INSTANCE.getDefault()) {
                start = null;
            }
            if (start != null) {
                return start;
            }
            return focusProperties.getLeft();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    end = focusProperties.getEnd();
                    break;
                case 2:
                    end = focusProperties.getStart();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusRequester it2 = end;
            if (it2 == FocusRequester.INSTANCE.getDefault()) {
                end = null;
            }
            if (end != null) {
                return end;
            }
            return focusProperties.getRight();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2638getEnterdhqQ8s())) {
            return focusProperties.getEnter().invoke(FocusDirection.m2626boximpl(focusDirection));
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2639getExitdhqQ8s())) {
            return focusProperties.getExit().invoke(FocusDirection.m2626boximpl(focusDirection));
        }
        throw new IllegalStateException("invalid FocusDirection".toString());
    }

    /* renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m2663focusSearchsMXa3k8(FocusTargetNode focusSearch, int focusDirection, LayoutDirection layoutDirection, Function1<? super FocusTargetNode, Boolean> onFound) {
        int direction;
        Boolean m2675twoDimensionalFocusSearchOMvw8;
        Intrinsics.checkNotNullParameter(focusSearch, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2642getNextdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m2666oneDimensionalFocusSearchOMvw8(focusSearch, focusDirection, onFound);
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2641getLeftdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2645getRightdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2646getUpdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            Boolean m2675twoDimensionalFocusSearchOMvw82 = TwoDimensionalFocusSearchKt.m2675twoDimensionalFocusSearchOMvw8(focusSearch, focusDirection, onFound);
            if (m2675twoDimensionalFocusSearchOMvw82 != null) {
                return m2675twoDimensionalFocusSearchOMvw82.booleanValue();
            }
            return false;
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2638getEnterdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    direction = FocusDirection.INSTANCE.m2645getRightdhqQ8s();
                    break;
                case 2:
                    direction = FocusDirection.INSTANCE.m2641getLeftdhqQ8s();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusSearch);
            if (findActiveFocusNode == null || (m2675twoDimensionalFocusSearchOMvw8 = TwoDimensionalFocusSearchKt.m2675twoDimensionalFocusSearchOMvw8(findActiveFocusNode, direction, onFound)) == null) {
                return false;
            }
            return m2675twoDimensionalFocusSearchOMvw8.booleanValue();
        }
        if (FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2639getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusSearch);
            FocusTargetNode it = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            if (it == null || Intrinsics.areEqual(it, focusSearch)) {
                return false;
            }
            return onFound.invoke(it).booleanValue();
        }
        throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m2631toStringimpl(focusDirection))).toString());
    }

    public static final Rect focusRect(FocusTargetNode $this$focusRect) {
        Rect localBoundingBoxOf;
        Intrinsics.checkNotNullParameter($this$focusRect, "<this>");
        NodeCoordinator it = $this$focusRect.getCoordinator();
        return (it == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(it).localBoundingBoxOf(it, false)) == null) ? Rect.INSTANCE.getZero() : localBoundingBoxOf;
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode $this$isEligibleForFocusSearch) {
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        Intrinsics.checkNotNullParameter($this$isEligibleForFocusSearch, "<this>");
        NodeCoordinator coordinator$ui_release = $this$isEligibleForFocusSearch.getCoordinator();
        if ((coordinator$ui_release == null || (layoutNode2 = coordinator$ui_release.getLayoutNode()) == null || !layoutNode2.isPlaced()) ? false : true) {
            NodeCoordinator coordinator$ui_release2 = $this$isEligibleForFocusSearch.getCoordinator();
            if ((coordinator$ui_release2 == null || (layoutNode = coordinator$ui_release2.getLayoutNode()) == null || !layoutNode.isAttached()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode $this$activeChild) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv;
        int i;
        int type$iv2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        int type$iv3;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$activeChild, "<this>");
        if (!$this$activeChild.getNode().getIsAttached()) {
            return null;
        }
        FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$activeChild;
        int type$iv4 = NodeKind.m4400constructorimpl(1024);
        if (!$this$visitChildren_u2d6rFNWt0$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        int count$iv$iv = 0;
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv3.getNode());
        } else {
            branches$iv$iv.add(child$iv$iv);
        }
        while (branches$iv$iv.isNotEmpty()) {
            int i2 = 1;
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (true) {
                    if (node$iv$iv == null) {
                        type$iv4 = type$iv4;
                    } else if ((node$iv$iv.getKindSet() & type$iv4) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                switch (WhenMappings.$EnumSwitchMapping$1[it.getFocusState().ordinal()]) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        return it;
                                    case 4:
                                    default:
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv = type$iv4;
                                        i = i2;
                                        type$iv2 = 0;
                                        break;
                                }
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? i2 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv4;
                                    i = i2;
                                    type$iv2 = 0;
                                } else {
                                    int count$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (((next$iv$iv.getKindSet() & type$iv4) != 0 ? i2 : 0) == 0) {
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv3 = type$iv4;
                                        } else {
                                            count$iv$iv2++;
                                            if (count$iv$iv2 == i2) {
                                                node = next$iv$iv;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                type$iv3 = type$iv4;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    type$iv3 = type$iv4;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    type$iv3 = type$iv4;
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
                                        type$iv4 = type$iv3;
                                        i2 = 1;
                                    }
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    type$iv = type$iv4;
                                    type$iv2 = 0;
                                    i = 1;
                                    if (count$iv$iv2 == 1) {
                                        i2 = 1;
                                        count$iv$iv = 0;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                        type$iv4 = type$iv;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            i2 = i;
                            count$iv$iv = type$iv2;
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                            type$iv4 = type$iv;
                        }
                        type$iv4 = type$iv4;
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                        type$iv4 = type$iv4;
                    }
                }
            }
        }
        return null;
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode $this$findActiveFocusNode) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv;
        int i;
        int i2;
        int i3;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        int type$iv2;
        int i4;
        MutableVector mutableVector;
        Intrinsics.checkNotNullParameter($this$findActiveFocusNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$findActiveFocusNode.getFocusState().ordinal()]) {
            case 1:
            case 3:
                return $this$findActiveFocusNode;
            case 2:
                FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$findActiveFocusNode;
                int type$iv3 = NodeKind.m4400constructorimpl(1024);
                int i5 = 0;
                if (!$this$visitChildren_u2d6rFNWt0$iv3.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                int count$iv$iv = 0;
                MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3.getNode().getChild();
                if (child$iv$iv == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv3.getNode());
                } else {
                    branches$iv$iv.add(child$iv$iv);
                }
                while (branches$iv$iv.isNotEmpty()) {
                    int i6 = 1;
                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                    if ((branch$iv$iv.getAggregateChildKindSet() & type$iv3) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    } else {
                        Modifier.Node node$iv$iv = branch$iv$iv;
                        while (true) {
                            if (node$iv$iv == null) {
                                i5 = i5;
                            } else if ((node$iv$iv.getKindSet() & type$iv3) != 0) {
                                Modifier.Node it$iv = node$iv$iv;
                                MutableVector mutableVector2 = null;
                                Modifier.Node node = it$iv;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode node2 = (FocusTargetNode) node;
                                        FocusTargetNode it = findActiveFocusNode(node2);
                                        if (it != null) {
                                            return it;
                                        }
                                        $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                        type$iv = type$iv3;
                                        i = i5;
                                        i2 = i6;
                                        i3 = 0;
                                    } else {
                                        Modifier.Node this_$iv$iv$iv = node;
                                        if (((this_$iv$iv$iv.getKindSet() & type$iv3) != 0 ? i6 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv = type$iv3;
                                            i = i5;
                                            i2 = i6;
                                            i3 = 0;
                                        } else {
                                            int count$iv$iv2 = 0;
                                            DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if (((next$iv$iv.getKindSet() & type$iv3) != 0 ? i6 : 0) == 0) {
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    type$iv2 = type$iv3;
                                                    i4 = i5;
                                                } else {
                                                    count$iv$iv2++;
                                                    if (count$iv$iv2 == i6) {
                                                        node = next$iv$iv;
                                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                        type$iv2 = type$iv3;
                                                        i4 = i5;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                            type$iv2 = type$iv3;
                                                            i4 = i5;
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                            type$iv2 = type$iv3;
                                                            i4 = i5;
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
                                                i5 = i4;
                                                i6 = 1;
                                            }
                                            $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                            type$iv = type$iv3;
                                            i = i5;
                                            i3 = 0;
                                            i2 = 1;
                                            if (count$iv$iv2 == 1) {
                                                i6 = 1;
                                                count$iv$iv = 0;
                                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                                type$iv3 = type$iv;
                                                i5 = i;
                                            }
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector2);
                                    i6 = i2;
                                    count$iv$iv = i3;
                                    $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                    type$iv3 = type$iv;
                                    i5 = i;
                                }
                                i5 = i5;
                            } else {
                                node$iv$iv = node$iv$iv.getChild();
                                $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv3;
                                i5 = i5;
                            }
                        }
                    }
                }
                return null;
            case 4:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode $this$findNonDeactivatedParent) {
        DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
        int type$iv;
        boolean includeSelf$iv;
        int i;
        NodeChain nodes;
        int type$iv2;
        boolean includeSelf$iv2;
        int i2;
        int type$iv3;
        boolean includeSelf$iv3;
        int i3;
        int count$iv$iv;
        MutableVector mutableVector;
        FocusTargetNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$findNonDeactivatedParent;
        int type$iv4 = NodeKind.m4400constructorimpl(1024);
        boolean includeSelf$iv4 = false;
        int i4 = 0;
        if (!$this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2.getNode().getParent();
        LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u2dY_u2dYKmho_u24default$iv2);
        while (layout$iv$iv != null) {
            Modifier.Node head$iv$iv = layout$iv$iv.getNodes().getHead();
            if ((head$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv = type$iv4;
                includeSelf$iv = includeSelf$iv4;
                i = i4;
            } else {
                while (node$iv$iv != null) {
                    if ((node$iv$iv.getKindSet() & type$iv4) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            DelegatableNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return it;
                                }
                                type$iv2 = type$iv4;
                                includeSelf$iv2 = includeSelf$iv4;
                                i2 = i4;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                if (((this_$iv$iv$iv.getKindSet() & type$iv4) != 0 ? 1 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                    type$iv2 = type$iv4;
                                    includeSelf$iv2 = includeSelf$iv4;
                                    i2 = i4;
                                } else {
                                    int count$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & type$iv4) != 0)) {
                                            type$iv3 = type$iv4;
                                            includeSelf$iv3 = includeSelf$iv4;
                                            i3 = i4;
                                        } else {
                                            count$iv$iv2++;
                                            type$iv3 = type$iv4;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                includeSelf$iv3 = includeSelf$iv4;
                                                i3 = i4;
                                            } else {
                                                if (mutableVector2 != null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    includeSelf$iv3 = includeSelf$iv4;
                                                    i3 = i4;
                                                    mutableVector = mutableVector2;
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    includeSelf$iv3 = includeSelf$iv4;
                                                    i3 = i4;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                mutableVector2 = mutableVector;
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(next$iv$iv);
                                                }
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        type$iv4 = type$iv3;
                                        includeSelf$iv4 = includeSelf$iv3;
                                        i4 = i3;
                                    }
                                    type$iv2 = type$iv4;
                                    includeSelf$iv2 = includeSelf$iv4;
                                    i2 = i4;
                                    if (count$iv$iv2 == 1) {
                                        $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                                        type$iv4 = type$iv2;
                                        includeSelf$iv4 = includeSelf$iv2;
                                        i4 = i2;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv3;
                            type$iv4 = type$iv2;
                            includeSelf$iv4 = includeSelf$iv2;
                            i4 = i2;
                        }
                    }
                    node$iv$iv = node$iv$iv.getParent();
                    $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                    type$iv4 = type$iv4;
                    includeSelf$iv4 = includeSelf$iv4;
                    i4 = i4;
                }
                $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2;
                type$iv = type$iv4;
                includeSelf$iv = includeSelf$iv4;
                i = i4;
            }
            layout$iv$iv = layout$iv$iv.getParent$ui_release();
            node$iv$iv = (layout$iv$iv == null || (nodes = layout$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            $this$visitAncestors_u2dY_u2dYKmho_u24default$iv2 = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv;
            type$iv4 = type$iv;
            includeSelf$iv4 = includeSelf$iv;
            i4 = i;
        }
        return null;
    }
}
