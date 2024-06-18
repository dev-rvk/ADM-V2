package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoDimensionalFocusSearch.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u001a5\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000f\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0016H\u0002\u001a\f\u0010\u0017\u001a\u00020\t*\u00020\tH\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0002\u001a1\u0010\u001d\u001a\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010!\u001a\u00020\u0007*\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a=\u0010&\u001a\u00020\u0007*\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\u0007*\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010)\u001a\f\u0010,\u001a\u00020\t*\u00020\tH\u0002\u001a7\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: TwoDimensionalFocusSearch.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getInvalidFocusDirection$annotations() {
    }

    private static /* synthetic */ void getNoActiveChild$annotations() {
    }

    /* renamed from: twoDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final Boolean m2675twoDimensionalFocusSearchOMvw8(FocusTargetNode twoDimensionalFocusSearch, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(twoDimensionalFocusSearch, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalFocusSearch.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild(twoDimensionalFocusSearch);
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                        Boolean found = m2675twoDimensionalFocusSearchOMvw8(focusedChild, direction, onFound);
                        return !Intrinsics.areEqual((Object) found, (Object) false) ? found : Boolean.valueOf(m2672generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, activeNode(focusedChild), direction, onFound));
                    case 2:
                    case 3:
                        return Boolean.valueOf(m2672generateAndSearchChildren4C6V_qg(twoDimensionalFocusSearch, focusedChild, direction, onFound));
                    case 4:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 2:
            case 3:
                return Boolean.valueOf(m2671findChildCorrespondingToFocusEnterOMvw8(twoDimensionalFocusSearch, direction, onFound));
            case 4:
                if (twoDimensionalFocusSearch.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke(twoDimensionalFocusSearch);
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m2671findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode findChildCorrespondingToFocusEnter, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        int requestedDirection;
        Rect initialFocusRect;
        Intrinsics.checkNotNullParameter(findChildCorrespondingToFocusEnter, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        MutableVector focusableChildren = new MutableVector(new FocusTargetNode[16], 0);
        collectAccessibleChildren(findChildCorrespondingToFocusEnter, focusableChildren);
        if (focusableChildren.getSize() <= 1) {
            FocusTargetNode it = (FocusTargetNode) (focusableChildren.isEmpty() ? null : focusableChildren.getContent()[0]);
            if (it != null) {
                return onFound.invoke(it).booleanValue();
            }
            return false;
        }
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2638getEnterdhqQ8s())) {
            requestedDirection = FocusDirection.INSTANCE.m2645getRightdhqQ8s();
        } else {
            requestedDirection = direction;
        }
        if (FocusDirection.m2629equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m2645getRightdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            initialFocusRect = topLeft(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
        } else {
            if (!(FocusDirection.m2629equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m2641getLeftdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(requestedDirection, FocusDirection.INSTANCE.m2646getUpdhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            initialFocusRect = bottomRight(FocusTraversalKt.focusRect(findChildCorrespondingToFocusEnter));
        }
        FocusTargetNode nextCandidate = m2670findBestCandidate4WY_MpI(focusableChildren, initialFocusRect, requestedDirection);
        if (nextCandidate != null) {
            return onFound.invoke(nextCandidate).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m2672generateAndSearchChildren4C6V_qg(final FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, final FocusTargetNode focusedItem, final int direction, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m2674searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2625searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m2674searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m2674searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m2674searchChildren4C6V_qg(FocusTargetNode.this, focusedItem, direction, function1);
                Boolean valueOf = Boolean.valueOf(m2674searchChildren4C6V_qg);
                boolean found = valueOf.booleanValue();
                if (found || !searchBeyondBounds.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m2674searchChildren4C6V_qg(FocusTargetNode $this$searchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode nextItem;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u243;
        MutableVector branches$iv$iv;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2432;
        MutableVector branches$iv$iv2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector branches$iv$iv3;
        MutableVector children = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2433 = children;
        FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$searchChildren_u2d4C6V_qg;
        int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
        if (!$this$visitChildren_u2d6rFNWt0$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector branches$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv3.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, $this$visitChildren_u2d6rFNWt0$iv3.getNode());
        } else {
            branches$iv$iv4.add(child$iv$iv);
        }
        while (branches$iv$iv4.isNotEmpty()) {
            MutableVector this_$iv$iv$iv = branches$iv$iv4;
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv4.removeAt(this_$iv$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (true) {
                    if (node$iv$iv == null) {
                        break;
                    }
                    if ((node$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                $this$searchChildren_4C6V_qg_u24lambda_u2433.add(it);
                                $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                branches$iv$iv = branches$iv$iv4;
                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                            } else {
                                Modifier.Node this_$iv$iv$iv2 = node;
                                if (!((this_$iv$iv$iv2.getKindSet() & m4400constructorimpl) != 0) || !(node instanceof DelegatingNode)) {
                                    $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                    branches$iv$iv = branches$iv$iv4;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                } else {
                                    int count$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & m4400constructorimpl) != 0)) {
                                            $this$searchChildren_4C6V_qg_u24lambda_u2432 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                            branches$iv$iv2 = branches$iv$iv4;
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                        } else {
                                            count$iv$iv++;
                                            $this$searchChildren_4C6V_qg_u24lambda_u2432 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                            if (count$iv$iv == 1) {
                                                node = next$iv$iv;
                                                branches$iv$iv2 = branches$iv$iv4;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            } else {
                                                if (mutableVector == null) {
                                                    branches$iv$iv2 = branches$iv$iv4;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    branches$iv$iv2 = branches$iv$iv4;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    branches$iv$iv3 = mutableVector;
                                                }
                                                MutableVector mutableVector2 = branches$iv$iv3;
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
                                                mutableVector = mutableVector2;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u2432;
                                        branches$iv$iv4 = branches$iv$iv2;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                    }
                                    $this$searchChildren_4C6V_qg_u24lambda_u243 = $this$searchChildren_4C6V_qg_u24lambda_u2433;
                                    branches$iv$iv = branches$iv$iv4;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    if (count$iv$iv == 1) {
                                        $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u243;
                                        branches$iv$iv4 = branches$iv$iv;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                            $this$searchChildren_4C6V_qg_u24lambda_u2433 = $this$searchChildren_4C6V_qg_u24lambda_u243;
                            branches$iv$iv4 = branches$iv$iv;
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                        }
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                    }
                }
            }
        }
        while (children.isNotEmpty() && (nextItem = m2670findBestCandidate4WY_MpI(children, FocusTraversalKt.focusRect(focusedItem), direction)) != null) {
            if (nextItem.fetchFocusProperties$ui_release().getCanFocus()) {
                return function1.invoke(nextItem).booleanValue();
            }
            if (m2672generateAndSearchChildren4C6V_qg(nextItem, focusedItem, direction, function1)) {
                return true;
            }
            children.remove(nextItem);
        }
        return false;
    }

    private static final void collectAccessibleChildren(DelegatableNode $this$collectAccessibleChildren, MutableVector<FocusTargetNode> mutableVector) {
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        int type$iv;
        boolean z;
        int type$iv2;
        int count$iv$iv;
        MutableVector mutableVector2;
        MutableVector<FocusTargetNode> mutableVector3 = mutableVector;
        int type$iv3 = NodeKind.m4400constructorimpl(1024);
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2 = $this$collectAccessibleChildren;
        if (!$this$visitChildren_u2d6rFNWt0$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitChildren_u2d6rFNWt0$iv2.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv2.getNode());
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
                        mutableVector3 = mutableVector;
                        break;
                    }
                    if ((node$iv$iv.getKindSet() & type$iv3) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector4 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                if (!it.getIsAttached()) {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                } else if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                    mutableVector3.add(it);
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                } else {
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                    collectAccessibleChildren(it, mutableVector3);
                                }
                                type$iv = type$iv3;
                                z = true;
                            } else {
                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv2;
                                Modifier.Node this_$iv$iv$iv = node;
                                if (!((this_$iv$iv$iv.getKindSet() & type$iv3) != 0) || !(node instanceof DelegatingNode)) {
                                    type$iv = type$iv3;
                                    z = true;
                                } else {
                                    int count$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & type$iv3) != 0)) {
                                            type$iv2 = type$iv3;
                                        } else {
                                            count$iv$iv2++;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                type$iv2 = type$iv3;
                                            } else {
                                                if (mutableVector4 == null) {
                                                    type$iv2 = type$iv3;
                                                    count$iv$iv = count$iv$iv2;
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    type$iv2 = type$iv3;
                                                    count$iv$iv = count$iv$iv2;
                                                    mutableVector2 = mutableVector4;
                                                }
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
                                                mutableVector4 = mutableVector2;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        type$iv3 = type$iv2;
                                    }
                                    type$iv = type$iv3;
                                    z = true;
                                    if (count$iv$iv2 == 1) {
                                        $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                                        type$iv3 = type$iv;
                                        mutableVector3 = mutableVector;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector4);
                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv;
                            type$iv3 = type$iv;
                            mutableVector3 = mutableVector;
                        }
                        mutableVector3 = mutableVector;
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                        mutableVector3 = mutableVector;
                    }
                }
            }
        }
    }

    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusTargetNode m2670findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> mutableVector, Rect focusRect, int direction) {
        Rect translate;
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            translate = focusRect.translate(focusRect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            translate = focusRect.translate(-(focusRect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            translate = focusRect.translate(0.0f, focusRect.getHeight() + 1);
        } else {
            if (!FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            translate = focusRect.translate(0.0f, -(focusRect.getHeight() + 1));
        }
        Rect rect = translate;
        FocusTargetNode focusTargetNode = null;
        int size$iv = mutableVector.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = mutableVector.getContent();
            do {
                FocusTargetNode candidateNode = (FocusTargetNode) content$iv[i$iv];
                if (FocusTraversalKt.isEligibleForFocusSearch(candidateNode)) {
                    Rect candidateRect = FocusTraversalKt.focusRect(candidateNode);
                    if (m2673isBetterCandidateI7lrPNg(candidateRect, rect, focusRect, direction)) {
                        rect = candidateRect;
                        focusTargetNode = candidateNode;
                    }
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        return focusTargetNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect $this$isBetterCandidate_I7lrPNg_u24isCandidate, int $direction, Rect $focusedRect) {
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            return ($focusedRect.getRight() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight() || $focusedRect.getLeft() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) && $focusedRect.getLeft() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            return ($focusedRect.getLeft() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft() || $focusedRect.getRight() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft()) && $focusedRect.getRight() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            return ($focusedRect.getBottom() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom() || $focusedRect.getTop() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) && $focusedRect.getTop() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            return ($focusedRect.getTop() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop() || $focusedRect.getBottom() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) && $focusedRect.getBottom() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance, int $direction, Rect $focusedRect) {
        float majorAxisDistance;
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            majorAxisDistance = $focusedRect.getLeft() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getRight();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getLeft() - $focusedRect.getRight();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            majorAxisDistance = $focusedRect.getTop() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getBottom();
        } else {
            if (!FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getTop() - $focusedRect.getBottom();
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24minorAxisDistance, int $direction, Rect $focusedRect) {
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            float f = 2;
            return ($focusedRect.getTop() + ($focusedRect.getHeight() / f)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getTop() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getHeight() / f));
        }
        if (!(FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s()))) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        float f2 = 2;
        return ($focusedRect.getLeft() + ($focusedRect.getWidth() / f2)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getLeft() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getWidth() / f2));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int $direction, Rect $focusedRect, Rect candidate) {
        long majorAxisDistance = Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(candidate, $direction, $focusedRect));
        long minorAxisDistance = Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(candidate, $direction, $focusedRect));
        return (13 * majorAxisDistance * majorAxisDistance) + (minorAxisDistance * minorAxisDistance);
    }

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    private static final boolean m2673isBetterCandidateI7lrPNg(Rect proposedCandidate, Rect currentCandidate, Rect focusedRect, int direction) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(proposedCandidate, direction, focusedRect)) {
            return false;
        }
        if (isBetterCandidate_I7lrPNg$isCandidate(currentCandidate, direction, focusedRect) && !m2669beamBeatsI7lrPNg(focusedRect, proposedCandidate, currentCandidate, direction)) {
            return !m2669beamBeatsI7lrPNg(focusedRect, currentCandidate, proposedCandidate, direction) && isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, proposedCandidate) < isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, currentCandidate);
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect $this$beamBeats_I7lrPNg_u24inSourceBeam, int $direction, Rect $source) {
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getBottom() > $source.getTop() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getTop() < $source.getBottom();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getRight() > $source.getLeft() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getLeft() < $source.getRight();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch, int $direction, Rect $source) {
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            return $source.getLeft() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getRight();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            return $source.getRight() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getLeft();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            return $source.getTop() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getBottom();
        }
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
            return $source.getBottom() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getTop();
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getRight();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getLeft() - $source.getRight();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getBottom();
        } else {
            if (!FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u246.getTop() - $source.getBottom();
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getLeft();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getRight() - $source.getRight();
        } else if (FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2646getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getTop();
        } else {
            if (!FocusDirection.m2629equalsimpl0($direction, FocusDirection.INSTANCE.m2637getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getBottom() - $source.getBottom();
        }
        return Math.max(1.0f, majorAxisDistance);
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m2669beamBeatsI7lrPNg(Rect source, Rect rect1, Rect rect2, int direction) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect2, direction, source) || !beamBeats_I7lrPNg$inSourceBeam(rect1, direction, source)) {
            return false;
        }
        if (!beamBeats_I7lrPNg$isInDirectionOfSearch(rect2, direction, source)) {
            return true;
        }
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2641getLeftdhqQ8s()) || FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2645getRightdhqQ8s())) {
            return true;
        }
        return beamBeats_I7lrPNg$majorAxisDistance$6(rect1, direction, source) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect2, direction, source);
    }

    private static final Rect topLeft(Rect $this$topLeft) {
        return new Rect($this$topLeft.getLeft(), $this$topLeft.getTop(), $this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final Rect bottomRight(Rect $this$bottomRight) {
        return new Rect($this$bottomRight.getRight(), $this$bottomRight.getBottom(), $this$bottomRight.getRight(), $this$bottomRight.getBottom());
    }

    private static final FocusTargetNode activeNode(FocusTargetNode $this$activeNode) {
        if (!($this$activeNode.getFocusState() == FocusStateImpl.ActiveParent)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode($this$activeNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }
}
