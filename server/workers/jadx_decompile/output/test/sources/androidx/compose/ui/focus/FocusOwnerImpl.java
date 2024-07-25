package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010!J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001d\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000202H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0014H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\u001d\u00104\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010-J\u000e\u00106\u001a\u0004\u0018\u000107*\u000208H\u0002J\\\u00109\u001a\u00020\u0005\"\n\b\u0000\u0010:\u0018\u0001*\u000208*\u0002082\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "dispatchKeyEvent-ZmokQxo", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetNode rootFocusNode;

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.rootFocusNode = new FocusTargetNode();
        this.focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener);
        this.modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusTargetNode create() {
                return FocusOwnerImpl.this.getRootFocusNode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(FocusTargetNode node) {
                Intrinsics.checkNotNullParameter(node, "node");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
                Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
                $this$inspectableProperties.setName("RootFocusTarget");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return FocusOwnerImpl.this.getRootFocusNode().hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object other) {
                return other == this;
            }
        };
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<set-?>");
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        clearFocus(force, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearFocus(boolean force, boolean refreshFocusEvents) {
        FocusStateImpl focusStateImpl;
        if (!force) {
            switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m2658performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.INSTANCE.m2639getExitdhqQ8s()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return;
            }
        }
        FocusStateImpl rootInitialState = this.rootFocusNode.getFocusState();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents)) {
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            switch (WhenMappings.$EnumSwitchMapping$1[rootInitialState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            focusTargetNode.setFocusState(focusStateImpl);
        }
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo2647moveFocus3ESFkO8(final int focusDirection) {
        final FocusTargetNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source == null) {
            return false;
        }
        FocusRequester it = FocusTraversalKt.m2662customFocusSearchOMvw8(source, focusDirection, getLayoutDirection());
        if (it != FocusRequester.INSTANCE.getDefault()) {
            return it != FocusRequester.INSTANCE.getCancel() && it.focus$ui_release();
        }
        final Ref.BooleanRef isCancelled = new Ref.BooleanRef();
        boolean foundNextItem = FocusTraversalKt.m2663focusSearchsMXa3k8(this.rootFocusNode, focusDirection, getLayoutDirection(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1

            /* compiled from: FocusOwnerImpl.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CustomDestinationResult.values().length];
                    try {
                        iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[CustomDestinationResult.None.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode destination) {
                Modifier.Node node;
                boolean z;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
                int type$iv;
                int type$iv2;
                NodeChain nodes;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
                int type$iv3;
                int type$iv4;
                DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
                int type$iv5;
                int count$iv$iv$iv;
                MutableVector mutableVector;
                Intrinsics.checkNotNullParameter(destination, "destination");
                int count$iv$iv$iv2 = 0;
                if (Intrinsics.areEqual(destination, FocusTargetNode.this)) {
                    return false;
                }
                FocusTargetNode $this$nearestAncestor_u2d64DMado$iv4 = destination;
                int type$iv6 = NodeKind.m4400constructorimpl(1024);
                if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
                loop0: while (true) {
                    int i = 1;
                    if (layout$iv$iv$iv == null) {
                        node = null;
                        break;
                    }
                    Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                    if ((head$iv$iv$iv.getAggregateChildKindSet() & type$iv6) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet() & type$iv6) != 0) {
                                Modifier.Node it$iv$iv = node$iv$iv$iv;
                                MutableVector mutableVector2 = null;
                                node = it$iv$iv;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    Modifier.Node this_$iv$iv$iv$iv = node;
                                    if (((this_$iv$iv$iv$iv.getKindSet() & type$iv6) != 0 ? i : 0) == 0 || !(node instanceof DelegatingNode)) {
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv6;
                                        type$iv4 = 0;
                                    } else {
                                        int count$iv$iv$iv3 = 0;
                                        DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) node;
                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if (((next$iv$iv$iv.getKindSet() & type$iv6) != 0 ? i : 0) != 0) {
                                                count$iv$iv$iv3++;
                                                if (count$iv$iv$iv3 == i) {
                                                    node = next$iv$iv$iv;
                                                    $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                    type$iv5 = type$iv6;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        count$iv$iv$iv = count$iv$iv$iv3;
                                                        type$iv5 = type$iv6;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                        count$iv$iv$iv = count$iv$iv$iv3;
                                                        type$iv5 = type$iv6;
                                                        mutableVector = mutableVector2;
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
                                            } else {
                                                $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                                type$iv5 = type$iv6;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                            type$iv6 = type$iv5;
                                            i = 1;
                                        }
                                        $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                        type$iv3 = type$iv6;
                                        type$iv4 = 0;
                                        if (count$iv$iv$iv3 == 1) {
                                            count$iv$iv$iv2 = 0;
                                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                            type$iv6 = type$iv3;
                                            i = 1;
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector2);
                                    count$iv$iv$iv2 = type$iv4;
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                    type$iv6 = type$iv3;
                                    i = 1;
                                }
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent();
                            count$iv$iv$iv2 = count$iv$iv$iv2;
                            $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                            type$iv6 = type$iv6;
                            i = 1;
                        }
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        type$iv = type$iv6;
                        type$iv2 = count$iv$iv$iv2;
                    } else {
                        $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                        type$iv = type$iv6;
                        type$iv2 = count$iv$iv$iv2;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
                    count$iv$iv$iv2 = type$iv2;
                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
                    type$iv6 = type$iv;
                }
                if (node == null) {
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
                switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m2661performCustomRequestFocusMxy_nc0(destination, focusDirection).ordinal()]) {
                    case 1:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        isCancelled.element = true;
                        z = true;
                        break;
                    case 4:
                        z = FocusTransactionsKt.performRequestFocus(destination);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return Boolean.valueOf(z);
            }
        });
        if (isCancelled.element) {
            return false;
        }
        return foundNextItem || m2651wrapAroundFocus3ESFkO8(focusDirection);
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x02fa, code lost:
    
        if (r6 >= 0) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02fc, code lost:
    
        r7 = r6;
        r6 = r6 - 1;
        r8 = r0.get(r7);
        r9 = (androidx.compose.ui.input.key.KeyInputModifierNode) r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x030b, code lost:
    
        if (r9.mo147onPreKeyEventZmokQxo(r41) == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0310, code lost:
    
        if (r6 >= 0) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x030d, code lost:
    
        return true;
     */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo2649dispatchKeyEventZmokQxo(android.view.KeyEvent r41) {
        /*
            Method dump skipped, instructions count: 1251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo2649dispatchKeyEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x02e4, code lost:
    
        if (r6 >= 0) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02e6, code lost:
    
        r7 = r6;
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f5, code lost:
    
        if (((androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode) r1.get(r7)).mo3623onPreInterceptKeyBeforeSoftKeyboardZmokQxo(r40) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02fa, code lost:
    
        if (r6 >= 0) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02f7, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo2648dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent r40) {
        /*
            Method dump skipped, instructions count: 1213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo2648dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x02e3, code lost:
    
        if (r6 >= 0) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02e5, code lost:
    
        r7 = r6;
        r6 = r6 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02f4, code lost:
    
        if (((androidx.compose.ui.input.rotary.RotaryInputModifierNode) r1.get(r7)).onPreRotaryScrollEvent(r40) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02f9, code lost:
    
        if (r6 >= 0) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02f6, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent r40) {
        /*
            Method dump skipped, instructions count: 1212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent):boolean");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a1, code lost:
    
        if (r5 >= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a3, code lost:
    
        r6 = r5;
        r5 = r5 - 1;
        r7 = r2.get(r6);
        r0.invoke(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ad, code lost:
    
        if (r5 >= 0) goto L191;
     */
    /* renamed from: traverseAncestors-Y-YKmho, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final /* synthetic */ <T extends androidx.compose.ui.node.DelegatableNode> void m2650traverseAncestorsYYKmho(androidx.compose.ui.node.DelegatableNode r37, int r38, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r40) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.m2650traverseAncestorsYYKmho(androidx.compose.ui.node.DelegatableNode, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int mask$iv = NodeKind.m4400constructorimpl(1024) | NodeKind.m4400constructorimpl(8192);
        if (!$this$lastLocalKeyInputNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        Modifier.Node self$iv = $this$lastLocalKeyInputNode.getNode();
        if ((self$iv.getAggregateChildKindSet() & mask$iv) != 0) {
            for (Modifier.Node next$iv = self$iv.getChild(); next$iv != null; next$iv = next$iv.getChild()) {
                if ((next$iv.getKindSet() & mask$iv) != 0) {
                    Modifier.Node modifierNode = next$iv;
                    if ((modifierNode.getKindSet() & NodeKind.m4400constructorimpl(1024)) != 0) {
                        return node;
                    }
                    node = modifierNode;
                }
            }
        }
        return node;
    }

    /* renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m2651wrapAroundFocus3ESFkO8(int focusDirection) {
        if (!this.rootFocusNode.getFocusState().getHasFocus() || this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        if (!(FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2642getNextdhqQ8s()) ? true : FocusDirection.m2629equalsimpl0(focusDirection, FocusDirection.INSTANCE.m2644getPreviousdhqQ8s()))) {
            return false;
        }
        clearFocus(false);
        if (this.rootFocusNode.getFocusState().isFocused()) {
            return mo2647moveFocus3ESFkO8(focusDirection);
        }
        return false;
    }
}
