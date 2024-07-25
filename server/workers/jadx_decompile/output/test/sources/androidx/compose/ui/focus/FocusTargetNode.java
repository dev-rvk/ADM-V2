package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusTargetNode.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001(B\u0005¢\u0006\u0002\u0010\u0005J5\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u0019H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u0019H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u0015H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\r\u0010&\u001a\u00020\u0015H\u0000¢\u0006\u0002\b'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "focusState", "Landroidx/compose/ui/focus/FocusStateImpl;", "getFocusState$annotations", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "isProcessingCustomEnter", "", "isProcessingCustomExit", "fetchCustomEnter", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusRequester;", "fetchCustomEnter-aToIllA$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "fetchCustomExit", "fetchCustomExit-aToIllA$ui_release", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "invalidateFocus", "invalidateFocus$ui_release", "onObservedReadsChanged", "onReset", "scheduleInvalidationForFocusEvents", "scheduleInvalidationForFocusEvents$ui_release", "FocusTargetElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusTargetNode extends Modifier.Node implements FocusTargetModifierNode, ObserverModifierNode, ModifierLocalModifierNode {
    private FocusStateImpl focusState = FocusStateImpl.Inactive;
    private boolean isProcessingCustomEnter;
    private boolean isProcessingCustomExit;

    /* compiled from: FocusTargetNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getFocusState$annotations() {
    }

    @Override // androidx.compose.ui.focus.FocusTargetModifierNode
    public FocusStateImpl getFocusState() {
        return this.focusState;
    }

    public void setFocusState(FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "<set-?>");
        this.focusState = focusStateImpl;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent() {
        return (BeyondBoundsLayout) getCurrent(androidx.compose.ui.layout.BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        FocusStateImpl previousFocusState = getFocusState();
        invalidateFocus$ui_release();
        if (previousFocusState != getFocusState()) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        switch (WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()]) {
            case 1:
            case 2:
                DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
                return;
            case 3:
                scheduleInvalidationForFocusEvents$ui_release();
                setFocusState(FocusStateImpl.Inactive);
                return;
            case 4:
                scheduleInvalidationForFocusEvents$ui_release();
                return;
            default:
                return;
        }
    }

    public final FocusProperties fetchFocusProperties$ui_release() {
        DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv;
        int type$iv;
        int untilType$iv;
        int i;
        NodeChain nodes;
        int untilType$iv2;
        int type$iv2;
        int i2;
        int type$iv3;
        DelegatingNode this_$iv$iv$iv;
        int i3;
        int count$iv$iv;
        MutableVector mutableVector;
        FocusPropertiesImpl properties = new FocusPropertiesImpl();
        FocusTargetNode $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = this;
        int type$iv4 = NodeKind.m4400constructorimpl(2048);
        int untilType$iv3 = NodeKind.m4400constructorimpl(1024);
        int i4 = 0;
        Modifier.Node self$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2.getNode();
        int mask$iv$iv = type$iv4 | untilType$iv3;
        if (!$this$visitSelfAndAncestors_u2d5BbP62I$iv2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2.getNode();
        LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitSelfAndAncestors_u2d5BbP62I$iv2);
        loop0: while (layout$iv$iv != null) {
            Modifier.Node head$iv$iv = layout$iv$iv.getNodes().getHead();
            if ((head$iv$iv.getAggregateChildKindSet() & mask$iv$iv) != 0) {
                while (node$iv$iv != null) {
                    if ((node$iv$iv.getKindSet() & mask$iv$iv) != 0) {
                        Modifier.Node it$iv = node$iv$iv;
                        if (it$iv != self$iv) {
                            if ((it$iv.getKindSet() & untilType$iv3) != 0) {
                                break loop0;
                            }
                        }
                        if ((it$iv.getKindSet() & type$iv4) != 0) {
                            MutableVector mutableVector2 = null;
                            Modifier.Node this_$iv$iv$iv2 = it$iv;
                            while (this_$iv$iv$iv2 != null) {
                                DelegatableNode $this$visitSelfAndAncestors_u2d5BbP62I$iv3 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                                if (this_$iv$iv$iv2 instanceof FocusPropertiesModifierNode) {
                                    FocusPropertiesModifierNode it = (FocusPropertiesModifierNode) this_$iv$iv$iv2;
                                    untilType$iv2 = untilType$iv3;
                                    it.applyFocusProperties(properties);
                                    type$iv2 = type$iv4;
                                    i2 = i4;
                                } else {
                                    untilType$iv2 = untilType$iv3;
                                    if (((this_$iv$iv$iv2.getKindSet() & type$iv4) != 0) && (this_$iv$iv$iv2 instanceof DelegatingNode)) {
                                        int count$iv$iv2 = 0;
                                        DelegatingNode this_$iv$iv$iv3 = (DelegatingNode) this_$iv$iv$iv2;
                                        Modifier.Node node$iv$iv$iv = this_$iv$iv$iv3.getDelegate();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if ((next$iv$iv.getKindSet() & type$iv4) != 0) {
                                                count$iv$iv2++;
                                                type$iv3 = type$iv4;
                                                if (count$iv$iv2 == 1) {
                                                    this_$iv$iv$iv2 = next$iv$iv;
                                                    this_$iv$iv$iv = this_$iv$iv$iv3;
                                                    i3 = i4;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        count$iv$iv = count$iv$iv2;
                                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                                        i3 = i4;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        count$iv$iv = count$iv$iv2;
                                                        this_$iv$iv$iv = this_$iv$iv$iv3;
                                                        i3 = i4;
                                                        mutableVector = mutableVector2;
                                                    }
                                                    MutableVector mutableVector3 = mutableVector;
                                                    Modifier.Node theNode$iv$iv = this_$iv$iv$iv2;
                                                    if (theNode$iv$iv != null) {
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(theNode$iv$iv);
                                                        }
                                                        this_$iv$iv$iv2 = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(next$iv$iv);
                                                    }
                                                    mutableVector2 = mutableVector3;
                                                    count$iv$iv2 = count$iv$iv;
                                                }
                                            } else {
                                                type$iv3 = type$iv4;
                                                this_$iv$iv$iv = this_$iv$iv$iv3;
                                                i3 = i4;
                                            }
                                            node$iv$iv$iv = node$iv$iv$iv.getChild();
                                            type$iv4 = type$iv3;
                                            this_$iv$iv$iv3 = this_$iv$iv$iv;
                                            i4 = i3;
                                        }
                                        type$iv2 = type$iv4;
                                        i2 = i4;
                                        if (count$iv$iv2 == 1) {
                                            $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
                                            untilType$iv3 = untilType$iv2;
                                            type$iv4 = type$iv2;
                                            i4 = i2;
                                        }
                                    } else {
                                        type$iv2 = type$iv4;
                                        i2 = i4;
                                    }
                                }
                                this_$iv$iv$iv2 = DelegatableNodeKt.pop(mutableVector2);
                                $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv3;
                                untilType$iv3 = untilType$iv2;
                                type$iv4 = type$iv2;
                                i4 = i2;
                            }
                        }
                    }
                    node$iv$iv = node$iv$iv.getParent();
                    $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                    untilType$iv3 = untilType$iv3;
                    type$iv4 = type$iv4;
                    i4 = i4;
                }
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                type$iv = type$iv4;
                untilType$iv = untilType$iv3;
                i = i4;
            } else {
                $this$visitSelfAndAncestors_u2d5BbP62I$iv = $this$visitSelfAndAncestors_u2d5BbP62I$iv2;
                type$iv = type$iv4;
                untilType$iv = untilType$iv3;
                i = i4;
            }
            layout$iv$iv = layout$iv$iv.getParent$ui_release();
            node$iv$iv = (layout$iv$iv == null || (nodes = layout$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            $this$visitSelfAndAncestors_u2d5BbP62I$iv2 = $this$visitSelfAndAncestors_u2d5BbP62I$iv;
            untilType$iv3 = untilType$iv;
            type$iv4 = type$iv;
            i4 = i;
        }
        return properties;
    }

    /* renamed from: fetchCustomEnter-aToIllA$ui_release, reason: not valid java name */
    public final void m2656fetchCustomEnteraToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!this.isProcessingCustomEnter) {
            this.isProcessingCustomEnter = true;
            try {
                FocusRequester it = fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2626boximpl(focusDirection));
                if (it != FocusRequester.INSTANCE.getDefault()) {
                    block.invoke(it);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomEnter = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    /* renamed from: fetchCustomExit-aToIllA$ui_release, reason: not valid java name */
    public final void m2657fetchCustomExitaToIllA$ui_release(int focusDirection, Function1<? super FocusRequester, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!this.isProcessingCustomExit) {
            this.isProcessingCustomExit = true;
            try {
                FocusRequester it = fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2626boximpl(focusDirection));
                if (it != FocusRequester.INSTANCE.getDefault()) {
                    block.invoke(it);
                }
            } finally {
                InlineMarker.finallyStart(1);
                this.isProcessingCustomExit = false;
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        switch (WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()]) {
            case 1:
            case 2:
                final Ref.ObjectRef focusProperties2 = new Ref.ObjectRef();
                ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.focus.FocusProperties, T] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        focusProperties2.element = this.fetchFocusProperties$ui_release();
                    }
                });
                if (focusProperties2.element == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                    focusProperties = null;
                } else {
                    focusProperties = (FocusProperties) focusProperties2.element;
                }
                if (!focusProperties.getCanFocus()) {
                    DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    public final void scheduleInvalidationForFocusEvents$ui_release() {
        DelegatableNode $this$visitAncestors_u24default$iv;
        DelegatableNode $this$visitAncestors_u24default$iv2;
        int mask$iv;
        boolean includeSelf$iv;
        DelegatableNode $this$visitAncestors_u24default$iv3;
        NodeChain nodes;
        DelegatableNode $this$visitAncestors_u24default$iv4;
        int mask$iv2;
        boolean includeSelf$iv2;
        DelegatableNode $this$visitAncestors_u24default$iv5;
        DelegatableNode $this$visitAncestors_u24default$iv6;
        int mask$iv3;
        boolean includeSelf$iv3;
        DelegatableNode $this$visitAncestors_u24default$iv7;
        MutableVector mutableVector;
        MutableVector mutableVector2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv = getNode();
        int m4400constructorimpl = NodeKind.m4400constructorimpl(4096);
        MutableVector mutableVector3 = null;
        Modifier.Node node = $this$dispatchForKind_u2d6rFNWt0$iv;
        while (true) {
            $this$visitAncestors_u24default$iv = null;
            int i = 1;
            if (node == null) {
                break;
            }
            if (node instanceof FocusEventModifierNode) {
                FocusEventModifierNode eventNode = (FocusEventModifierNode) node;
                FocusEventModifierNodeKt.invalidateFocusEvent(eventNode);
            } else {
                Modifier.Node this_$iv$iv = node;
                Modifier.Node this_$iv$iv2 = (this_$iv$iv.getKindSet() & m4400constructorimpl) != 0 ? 1 : null;
                if (this_$iv$iv2 != null && (node instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv3 = (DelegatingNode) node;
                    Modifier.Node node$iv$iv = this_$iv$iv3.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if (((next$iv.getKindSet() & m4400constructorimpl) != 0 ? i : 0) != 0) {
                            count$iv++;
                            if (count$iv == i) {
                                node = next$iv;
                            } else {
                                if (mutableVector3 != null) {
                                    mutableVector2 = mutableVector3;
                                } else {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                mutableVector3 = mutableVector2;
                                Modifier.Node theNode$iv = node;
                                if (theNode$iv != null) {
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(theNode$iv);
                                    }
                                    node = null;
                                }
                                if (mutableVector3 != null) {
                                    mutableVector3.add(next$iv);
                                }
                            }
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        i = 1;
                    }
                    if (count$iv == 1) {
                    }
                }
            }
            node = DelegatableNodeKt.pop(mutableVector3);
        }
        FocusTargetNode $this$visitAncestors_u24default$iv8 = this;
        int i2 = 1024;
        int mask$iv4 = NodeKind.m4400constructorimpl(4096) | NodeKind.m4400constructorimpl(1024);
        boolean includeSelf$iv4 = false;
        if (!$this$visitAncestors_u24default$iv8.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv = $this$visitAncestors_u24default$iv8.getNode().getParent();
        LayoutNode layout$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u24default$iv8);
        while (layout$iv != null) {
            Modifier.Node head$iv = layout$iv.getNodes().getHead();
            if ((head$iv.getAggregateChildKindSet() & mask$iv4) == 0) {
                $this$visitAncestors_u24default$iv2 = $this$visitAncestors_u24default$iv8;
                mask$iv = mask$iv4;
                includeSelf$iv = includeSelf$iv4;
                $this$visitAncestors_u24default$iv3 = $this$visitAncestors_u24default$iv;
            } else {
                while (node$iv != null) {
                    if ((node$iv.getKindSet() & mask$iv4) != 0) {
                        Modifier.Node it = node$iv;
                        if (((it.getKindSet() & NodeKind.m4400constructorimpl(i2)) != 0 ? 1 : $this$visitAncestors_u24default$iv) == 0 && it.getIsAttached()) {
                            int m4400constructorimpl2 = NodeKind.m4400constructorimpl(4096);
                            MutableVector mutableVector4 = null;
                            Modifier.Node node2 = it;
                            while (node2 != null) {
                                if (node2 instanceof FocusEventModifierNode) {
                                    FocusEventModifierNode eventNode2 = (FocusEventModifierNode) node2;
                                    FocusEventModifierNodeKt.invalidateFocusEvent(eventNode2);
                                    $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv8;
                                    mask$iv2 = mask$iv4;
                                    includeSelf$iv2 = includeSelf$iv4;
                                    $this$visitAncestors_u24default$iv5 = $this$visitAncestors_u24default$iv;
                                } else {
                                    Modifier.Node this_$iv$iv4 = node2;
                                    if (((this_$iv$iv4.getKindSet() & m4400constructorimpl2) != 0 ? 1 : $this$visitAncestors_u24default$iv) == 0 || !(node2 instanceof DelegatingNode)) {
                                        $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv8;
                                        mask$iv2 = mask$iv4;
                                        includeSelf$iv2 = includeSelf$iv4;
                                        $this$visitAncestors_u24default$iv5 = $this$visitAncestors_u24default$iv;
                                    } else {
                                        int count$iv2 = 0;
                                        DelegatingNode this_$iv$iv5 = (DelegatingNode) node2;
                                        Modifier.Node node$iv$iv2 = this_$iv$iv5.getDelegate();
                                        while (node$iv$iv2 != null) {
                                            Modifier.Node next$iv2 = node$iv$iv2;
                                            if (((next$iv2.getKindSet() & m4400constructorimpl2) != 0 ? 1 : $this$visitAncestors_u24default$iv) == 0) {
                                                $this$visitAncestors_u24default$iv6 = $this$visitAncestors_u24default$iv8;
                                                mask$iv3 = mask$iv4;
                                                includeSelf$iv3 = includeSelf$iv4;
                                                $this$visitAncestors_u24default$iv7 = $this$visitAncestors_u24default$iv;
                                            } else {
                                                count$iv2++;
                                                if (count$iv2 == 1) {
                                                    node2 = next$iv2;
                                                    $this$visitAncestors_u24default$iv6 = $this$visitAncestors_u24default$iv8;
                                                    mask$iv3 = mask$iv4;
                                                    includeSelf$iv3 = includeSelf$iv4;
                                                    $this$visitAncestors_u24default$iv7 = null;
                                                } else {
                                                    if (mutableVector4 != null) {
                                                        $this$visitAncestors_u24default$iv6 = $this$visitAncestors_u24default$iv8;
                                                        mask$iv3 = mask$iv4;
                                                        includeSelf$iv3 = includeSelf$iv4;
                                                        $this$visitAncestors_u24default$iv7 = null;
                                                        mutableVector = mutableVector4;
                                                    } else {
                                                        $this$visitAncestors_u24default$iv6 = $this$visitAncestors_u24default$iv8;
                                                        mask$iv3 = mask$iv4;
                                                        includeSelf$iv3 = includeSelf$iv4;
                                                        $this$visitAncestors_u24default$iv7 = null;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    mutableVector4 = mutableVector;
                                                    Modifier.Node theNode$iv2 = node2;
                                                    if (theNode$iv2 != null) {
                                                        if (mutableVector4 != null) {
                                                            mutableVector4.add(theNode$iv2);
                                                        }
                                                        node2 = null;
                                                    }
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(next$iv2);
                                                    }
                                                }
                                            }
                                            node$iv$iv2 = node$iv$iv2.getChild();
                                            $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv7;
                                            $this$visitAncestors_u24default$iv8 = $this$visitAncestors_u24default$iv6;
                                            mask$iv4 = mask$iv3;
                                            includeSelf$iv4 = includeSelf$iv3;
                                        }
                                        $this$visitAncestors_u24default$iv4 = $this$visitAncestors_u24default$iv8;
                                        mask$iv2 = mask$iv4;
                                        includeSelf$iv2 = includeSelf$iv4;
                                        $this$visitAncestors_u24default$iv5 = $this$visitAncestors_u24default$iv;
                                        if (count$iv2 == 1) {
                                            $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv5;
                                            $this$visitAncestors_u24default$iv8 = $this$visitAncestors_u24default$iv4;
                                            mask$iv4 = mask$iv2;
                                            includeSelf$iv4 = includeSelf$iv2;
                                        }
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector4);
                                $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv5;
                                $this$visitAncestors_u24default$iv8 = $this$visitAncestors_u24default$iv4;
                                mask$iv4 = mask$iv2;
                                includeSelf$iv4 = includeSelf$iv2;
                            }
                        }
                    }
                    node$iv = node$iv.getParent();
                    $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv;
                    $this$visitAncestors_u24default$iv8 = $this$visitAncestors_u24default$iv8;
                    mask$iv4 = mask$iv4;
                    includeSelf$iv4 = includeSelf$iv4;
                    i2 = 1024;
                }
                $this$visitAncestors_u24default$iv2 = $this$visitAncestors_u24default$iv8;
                mask$iv = mask$iv4;
                includeSelf$iv = includeSelf$iv4;
                $this$visitAncestors_u24default$iv3 = $this$visitAncestors_u24default$iv;
            }
            layout$iv = layout$iv.getParent$ui_release();
            node$iv = (layout$iv == null || (nodes = layout$iv.getNodes()) == null) ? null : nodes.getTail();
            $this$visitAncestors_u24default$iv = $this$visitAncestors_u24default$iv3;
            $this$visitAncestors_u24default$iv8 = $this$visitAncestors_u24default$iv2;
            mask$iv4 = mask$iv;
            includeSelf$iv4 = includeSelf$iv;
            i2 = 1024;
        }
    }

    /* compiled from: FocusTargetNode.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode$FocusTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public FocusTargetNode create() {
            return new FocusTargetNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
            $this$inspectableProperties.setName("focusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return "focusTarget".hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }
    }
}
