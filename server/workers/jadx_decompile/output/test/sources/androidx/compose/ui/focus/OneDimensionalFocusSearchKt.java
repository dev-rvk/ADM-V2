package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: OneDimensionalFocusSearch.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001aE\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001aE\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001a \u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a=\u0010\u0014\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0007*\u00020\bH\u0002\u001a5\u0010\u001b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a \u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a \u0010\u001f\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a=\u0010 \u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: OneDimensionalFocusSearch.kt */
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

    /* renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m2666oneDimensionalFocusSearchOMvw8(FocusTargetNode oneDimensionalFocusSearch, int direction, Function1<? super FocusTargetNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter(oneDimensionalFocusSearch, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2642getNextdhqQ8s())) {
            return forwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s())) {
            return backwardFocusSearch(oneDimensionalFocusSearch, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusTargetNode $this$forwardFocusSearch, Function1<? super FocusTargetNode, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$forwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild($this$forwardFocusSearch);
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, function1) || m2665generateAndSearchChildren4C6V_qg($this$forwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m2642getNextdhqQ8s(), function1);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 2:
            case 3:
                return pickChildForForwardSearch($this$forwardFocusSearch, function1);
            case 4:
                if ($this$forwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus()) {
                    return function1.invoke($this$forwardFocusSearch).booleanValue();
                }
                return pickChildForForwardSearch($this$forwardFocusSearch, function1);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode $this$backwardFocusSearch, Function1<? super FocusTargetNode, Boolean> function1) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$backwardFocusSearch.getFocusState().ordinal()]) {
            case 1:
                FocusTargetNode focusedChild = FocusTraversalKt.getActiveChild($this$backwardFocusSearch);
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusState().ordinal()]) {
                    case 1:
                        if (backwardFocusSearch(focusedChild, function1) || m2665generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s(), function1)) {
                            return true;
                        }
                        return focusedChild.fetchFocusProperties$ui_release().getCanFocus() && function1.invoke(focusedChild).booleanValue();
                    case 2:
                    case 3:
                        return m2665generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s(), function1);
                    case 4:
                        throw new IllegalStateException(NoActiveChild.toString());
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            case 2:
            case 3:
                return pickChildForBackwardSearch($this$backwardFocusSearch, function1);
            case 4:
                if (pickChildForBackwardSearch($this$backwardFocusSearch, function1)) {
                    return true;
                }
                return $this$backwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus() ? function1.invoke($this$backwardFocusSearch).booleanValue() : false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m2665generateAndSearchChildren4C6V_qg(final FocusTargetNode $this$generateAndSearchChildren_u2d4C6V_qg, final FocusTargetNode focusedItem, final int direction, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m2667searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2625searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds) {
                boolean m2667searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                m2667searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m2667searchChildren4C6V_qg(FocusTargetNode.this, focusedItem, direction, function1);
                Boolean valueOf = Boolean.valueOf(m2667searchChildren4C6V_qg);
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
    public static final boolean m2667searchChildren4C6V_qg(FocusTargetNode $this$searchChildren_u2d4C6V_qg, FocusTargetNode focusedItem, int direction, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u242;
        Modifier.Node child$iv$iv;
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2422;
        Modifier.Node child$iv$iv2;
        int count$iv$iv;
        MutableVector mutableVector;
        if (!($this$searchChildren_u2d4C6V_qg.getFocusState() == FocusStateImpl.ActiveParent)) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        MutableVector children = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2423 = children;
        FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv = $this$searchChildren_u2d4C6V_qg;
        int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
        if (!$this$visitChildren_u2d6rFNWt0$iv.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv3 = $this$visitChildren_u2d6rFNWt0$iv.getNode().getChild();
        if (child$iv$iv3 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren_u2d6rFNWt0$iv.getNode());
        } else {
            branches$iv$iv.add(child$iv$iv3);
        }
        while (branches$iv$iv.isNotEmpty()) {
            MutableVector this_$iv$iv$iv = branches$iv$iv;
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(this_$iv$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (true) {
                    if (node$iv$iv == null) {
                        break;
                    }
                    if ((node$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            MutableVector branches$iv$iv2 = branches$iv$iv;
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode it = (FocusTargetNode) node;
                                $this$searchChildren_4C6V_qg_u24lambda_u2423.add(it);
                                $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                child$iv$iv = child$iv$iv3;
                            } else {
                                Modifier.Node this_$iv$iv$iv2 = node;
                                if (!((this_$iv$iv$iv2.getKindSet() & m4400constructorimpl) != 0) || !(node instanceof DelegatingNode)) {
                                    $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                    child$iv$iv = child$iv$iv3;
                                } else {
                                    int count$iv$iv2 = 0;
                                    DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & m4400constructorimpl) != 0)) {
                                            $this$searchChildren_4C6V_qg_u24lambda_u2422 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                            child$iv$iv2 = child$iv$iv3;
                                        } else {
                                            count$iv$iv2++;
                                            $this$searchChildren_4C6V_qg_u24lambda_u2422 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                            if (count$iv$iv2 == 1) {
                                                node = next$iv$iv;
                                                child$iv$iv2 = child$iv$iv3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    count$iv$iv = count$iv$iv2;
                                                    child$iv$iv2 = child$iv$iv3;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv = count$iv$iv2;
                                                    child$iv$iv2 = child$iv$iv3;
                                                    mutableVector = mutableVector2;
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                                count$iv$iv2 = count$iv$iv;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u2422;
                                        child$iv$iv3 = child$iv$iv2;
                                    }
                                    $this$searchChildren_4C6V_qg_u24lambda_u242 = $this$searchChildren_4C6V_qg_u24lambda_u2423;
                                    child$iv$iv = child$iv$iv3;
                                    if (count$iv$iv2 == 1) {
                                        branches$iv$iv = branches$iv$iv2;
                                        $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u242;
                                        child$iv$iv3 = child$iv$iv;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            branches$iv$iv = branches$iv$iv2;
                            $this$searchChildren_4C6V_qg_u24lambda_u2423 = $this$searchChildren_4C6V_qg_u24lambda_u242;
                            child$iv$iv3 = child$iv$iv;
                        }
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                    }
                }
            }
        }
        children.sortWith(FocusableChildrenComparator.INSTANCE);
        if (!FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2642getNextdhqQ8s())) {
            if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s())) {
                boolean itemFound$iv = false;
                IntRange intRange = new IntRange(0, children.getSize() - 1);
                int first = intRange.getFirst();
                int index$iv = intRange.getLast();
                if (first <= index$iv) {
                    while (true) {
                        if (itemFound$iv) {
                            FocusTargetNode child = (FocusTargetNode) children.getContent()[index$iv];
                            if (FocusTraversalKt.isEligibleForFocusSearch(child) && backwardFocusSearch(child, function1)) {
                                return true;
                            }
                        }
                        if (Intrinsics.areEqual(children.getContent()[index$iv], focusedItem)) {
                            itemFound$iv = true;
                        }
                        if (index$iv == first) {
                            break;
                        }
                        index$iv--;
                    }
                }
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        } else {
            boolean itemFound$iv2 = false;
            IntRange intRange2 = new IntRange(0, children.getSize() - 1);
            int index$iv2 = intRange2.getFirst();
            int last = intRange2.getLast();
            if (index$iv2 <= last) {
                while (true) {
                    if (itemFound$iv2) {
                        FocusTargetNode child2 = (FocusTargetNode) children.getContent()[index$iv2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(child2) && forwardFocusSearch(child2, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(children.getContent()[index$iv2], focusedItem)) {
                        itemFound$iv2 = true;
                    }
                    if (index$iv2 == last) {
                        break;
                    }
                    index$iv2++;
                }
            }
        }
        if (FocusDirection.m2629equalsimpl0(direction, FocusDirection.INSTANCE.m2642getNextdhqQ8s()) || !$this$searchChildren_u2d4C6V_qg.fetchFocusProperties$ui_release().getCanFocus() || isRoot($this$searchChildren_u2d4C6V_qg)) {
            return false;
        }
        return function1.invoke($this$searchChildren_u2d4C6V_qg).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode r32, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetNode, java.lang.Boolean> r33) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetNode, kotlin.jvm.functions.Function1):boolean");
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode $this$pickChildForBackwardSearch, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u249;
        int i;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv;
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u2492;
        int i2;
        DelegatableNode $this$visitChildren_u2d6rFNWt0$iv2;
        MutableVector mutableVector;
        MutableVector children = new MutableVector(new FocusTargetNode[16], 0);
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u2493 = children;
        int i3 = 0;
        FocusTargetNode $this$visitChildren_u2d6rFNWt0$iv3 = $this$pickChildForBackwardSearch;
        int m4400constructorimpl = NodeKind.m4400constructorimpl(1024);
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
            if ((branch$iv$iv.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
            } else {
                Modifier.Node node$iv$iv = branch$iv$iv;
                while (true) {
                    if (node$iv$iv == null) {
                        break;
                    }
                    if ((node$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        MutableVector mutableVector2 = null;
                        Modifier.Node node = it$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                $this$pickChildForBackwardSearch_u24lambda_u2493.add((FocusTargetNode) node);
                                $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                i = i3;
                                $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                            } else {
                                Modifier.Node this_$iv$iv$iv = node;
                                if (!((this_$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0) || !(node instanceof DelegatingNode)) {
                                    $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                    i = i3;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                } else {
                                    int count$iv$iv = 0;
                                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                    Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv = node$iv$iv$iv;
                                        if (!((next$iv$iv.getKindSet() & m4400constructorimpl) != 0)) {
                                            $this$pickChildForBackwardSearch_u24lambda_u2492 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                            i2 = i3;
                                            $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                        } else {
                                            count$iv$iv++;
                                            $this$pickChildForBackwardSearch_u24lambda_u2492 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                            if (count$iv$iv == 1) {
                                                node = next$iv$iv;
                                                i2 = i3;
                                                $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    i2 = i3;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    i2 = i3;
                                                    $this$visitChildren_u2d6rFNWt0$iv2 = $this$visitChildren_u2d6rFNWt0$iv3;
                                                    mutableVector = mutableVector2;
                                                }
                                                MutableVector mutableVector3 = mutableVector;
                                                Modifier.Node theNode$iv$iv = node;
                                                if (theNode$iv$iv != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(theNode$iv$iv);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv);
                                                }
                                                mutableVector2 = mutableVector3;
                                            }
                                        }
                                        node$iv$iv$iv = node$iv$iv$iv.getChild();
                                        $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u2492;
                                        i3 = i2;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv2;
                                    }
                                    $this$pickChildForBackwardSearch_u24lambda_u249 = $this$pickChildForBackwardSearch_u24lambda_u2493;
                                    i = i3;
                                    $this$visitChildren_u2d6rFNWt0$iv = $this$visitChildren_u2d6rFNWt0$iv3;
                                    if (count$iv$iv == 1) {
                                        $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u249;
                                        i3 = i;
                                        $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                                    }
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            $this$pickChildForBackwardSearch_u24lambda_u2493 = $this$pickChildForBackwardSearch_u24lambda_u249;
                            i3 = i;
                            $this$visitChildren_u2d6rFNWt0$iv3 = $this$visitChildren_u2d6rFNWt0$iv;
                        }
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                    }
                }
            }
        }
        children.sortWith(FocusableChildrenComparator.INSTANCE);
        int size$iv = children.getSize();
        if (size$iv <= 0) {
            return false;
        }
        int i$iv = size$iv - 1;
        Object[] content$iv = children.getContent();
        do {
            FocusTargetNode it = (FocusTargetNode) content$iv[i$iv];
            if (FocusTraversalKt.isEligibleForFocusSearch(it) && backwardFocusSearch(it, function1)) {
                return true;
            }
            i$iv--;
        } while (i$iv >= 0);
        return false;
    }

    private static final boolean isRoot(FocusTargetNode $this$isRoot) {
        boolean z;
        boolean z2;
        Modifier.Node node;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        int type$iv;
        int i;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        int type$iv2;
        int i2;
        boolean z3;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        int type$iv3;
        int i3;
        MutableVector mutableVector;
        FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4 = $this$isRoot;
        int type$iv4 = NodeKind.m4400constructorimpl(1024);
        int i4 = 0;
        if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
        LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
        loop0: while (true) {
            boolean z4 = true;
            if (layout$iv$iv$iv == null) {
                z = true;
                z2 = false;
                node = null;
                break;
            }
            Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv.getAggregateChildKindSet() & type$iv4) == 0) {
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                type$iv = type$iv4;
                i = i4;
            } else {
                while (node$iv$iv$iv != null) {
                    if ((node$iv$iv$iv.getKindSet() & type$iv4) != 0) {
                        Modifier.Node it$iv$iv = node$iv$iv$iv;
                        MutableVector mutableVector2 = null;
                        node = it$iv$iv;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                z = z4;
                                z2 = false;
                                break loop0;
                            }
                            Modifier.Node this_$iv$iv$iv$iv = node;
                            if (!((this_$iv$iv$iv$iv.getKindSet() & type$iv4) != 0 ? z4 : false) || !(node instanceof DelegatingNode)) {
                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                                z3 = z4;
                            } else {
                                int count$iv$iv$iv = 0;
                                DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                                Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                while (node$iv$iv$iv$iv != null) {
                                    Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                    if (!((next$iv$iv$iv.getKindSet() & type$iv4) != 0 ? z4 : false)) {
                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv4;
                                        i3 = i4;
                                    } else {
                                        count$iv$iv$iv++;
                                        if (count$iv$iv$iv == z4) {
                                            node = next$iv$iv$iv;
                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                            type$iv3 = type$iv4;
                                            i3 = i4;
                                        } else {
                                            if (mutableVector2 != null) {
                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
                                                mutableVector = mutableVector2;
                                            } else {
                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv3 = type$iv4;
                                                i3 = i4;
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
                                        }
                                    }
                                    node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                    type$iv4 = type$iv3;
                                    i4 = i3;
                                    z4 = true;
                                }
                                $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                type$iv2 = type$iv4;
                                i2 = i4;
                                z3 = true;
                                if (count$iv$iv$iv == 1) {
                                    z4 = true;
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv4 = type$iv2;
                                    i4 = i2;
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                            z4 = z3;
                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                            type$iv4 = type$iv2;
                            i4 = i2;
                        }
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getParent();
                    z4 = z4;
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                    type$iv4 = type$iv4;
                    i4 = i4;
                }
                $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                type$iv = type$iv4;
                i = i4;
            }
            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
            type$iv4 = type$iv;
            i4 = i;
        }
        return node == null ? z : z2;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int index = intRange.getFirst();
        int last = intRange.getLast();
        if (index > last) {
            return;
        }
        while (true) {
            if (itemFound) {
                function1.invoke(mutableVector.getContent()[index]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[index], t)) {
                itemFound = true;
            }
            if (index == last) {
                return;
            } else {
                index++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int index = intRange.getLast();
        if (first > index) {
            return;
        }
        while (true) {
            if (itemFound) {
                function1.invoke(mutableVector.getContent()[index]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[index], t)) {
                itemFound = true;
            }
            if (index == first) {
                return;
            } else {
                index--;
            }
        }
    }
}
