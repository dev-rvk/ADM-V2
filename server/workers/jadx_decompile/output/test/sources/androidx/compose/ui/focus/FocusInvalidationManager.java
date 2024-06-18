package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusInvalidationManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\rJ%\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0010\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", "", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusEventNodes", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "invalidateNodes", "scheduleInvalidation", "node", "T", "(Ljava/util/Set;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    private Set<FocusEventModifierNode> focusEventNodes;
    private Set<FocusPropertiesModifierNode> focusPropertiesNodes;
    private Set<FocusTargetNode> focusTargetNodes;
    private final Function0<Unit> invalidateNodes;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.onRequestApplyChangesListener = onRequestApplyChangesListener;
        this.focusTargetNodes = new LinkedHashSet();
        this.focusEventNodes = new LinkedHashSet();
        this.focusPropertiesNodes = new LinkedHashSet();
        this.invalidateNodes = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
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
                Iterable iterable;
                Set set;
                Iterable iterable2;
                Set set2;
                Iterable $this$forEach$iv;
                Set set3;
                Set set4;
                Set set5;
                Set set6;
                Iterable $this$forEach$iv2;
                int $i$f$forEach;
                Iterator it;
                FocusInvalidationManager focusInvalidationManager;
                FocusStateImpl focusStateImpl;
                FocusStateImpl focusStateImpl2;
                MutableVector branches$iv$iv;
                Set set7;
                FocusInvalidationManager focusInvalidationManager2;
                FocusInvalidationManager focusInvalidationManager3;
                DelegatingNode this_$iv$iv$iv;
                int count$iv$iv;
                MutableVector mutableVector;
                int $i$f$forEach2;
                Set set8;
                Iterator it2;
                DelegatingNode this_$iv$iv$iv2;
                Iterator it3;
                int count$iv$iv2;
                MutableVector mutableVector2;
                Iterable $this$forEach$iv3;
                FocusInvalidationManager focusInvalidationManager4;
                int $i$f$forEach3;
                Iterator it4;
                MutableVector branches$iv$iv2;
                Set set9;
                FocusInvalidationManager focusInvalidationManager5;
                FocusInvalidationManager focusInvalidationManager6;
                DelegatingNode this_$iv$iv$iv3;
                int count$iv$iv3;
                MutableVector mutableVector3;
                Iterable $this$forEach$iv4;
                Set set10;
                int $i$f$forEach4;
                Iterator it5;
                int $i$f$forEach5;
                Iterator it6;
                int count$iv$iv4;
                MutableVector mutableVector4;
                iterable = FocusInvalidationManager.this.focusPropertiesNodes;
                Iterable $this$forEach$iv5 = iterable;
                FocusInvalidationManager focusInvalidationManager7 = FocusInvalidationManager.this;
                int $i$f$forEach6 = 0;
                Iterator it7 = $this$forEach$iv5.iterator();
                while (true) {
                    int i = 1024;
                    if (!it7.hasNext()) {
                        set = FocusInvalidationManager.this.focusPropertiesNodes;
                        set.clear();
                        Set focusTargetsWithInvalidatedFocusEvents = new LinkedHashSet();
                        iterable2 = FocusInvalidationManager.this.focusEventNodes;
                        Iterable $this$forEach$iv6 = iterable2;
                        FocusInvalidationManager focusInvalidationManager8 = FocusInvalidationManager.this;
                        int $i$f$forEach7 = 0;
                        Iterator it8 = $this$forEach$iv6.iterator();
                        while (it8.hasNext()) {
                            Object element$iv = it8.next();
                            FocusEventModifierNode focusEventNode = (FocusEventModifierNode) element$iv;
                            if (focusEventNode.getNode().getIsAttached()) {
                                boolean requiresUpdate = true;
                                boolean aggregatedNode = false;
                                FocusTargetNode focusTargetNode = null;
                                FocusEventModifierNode $this$visitSelfAndChildren_u2d6rFNWt0$iv = focusEventNode;
                                int m4400constructorimpl = NodeKind.m4400constructorimpl(i);
                                Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv.getNode();
                                MutableVector mutableVector5 = null;
                                Modifier.Node node = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                                while (node != null) {
                                    Iterable $this$forEach$iv7 = $this$forEach$iv6;
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode it9 = (FocusTargetNode) node;
                                        if (focusTargetNode != null) {
                                            aggregatedNode = true;
                                        }
                                        focusTargetNode = it9;
                                        $i$f$forEach2 = $i$f$forEach7;
                                        set8 = focusInvalidationManager8.focusTargetNodes;
                                        if (set8.contains(it9)) {
                                            requiresUpdate = false;
                                            focusTargetsWithInvalidatedFocusEvents.add(it9);
                                        }
                                        it2 = it8;
                                    } else {
                                        $i$f$forEach2 = $i$f$forEach7;
                                        Modifier.Node this_$iv$iv$iv4 = node;
                                        if (((this_$iv$iv$iv4.getKindSet() & m4400constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                            int count$iv$iv5 = 0;
                                            DelegatingNode this_$iv$iv$iv5 = (DelegatingNode) node;
                                            Modifier.Node node$iv$iv$iv = this_$iv$iv$iv5.getDelegate();
                                            while (node$iv$iv$iv != null) {
                                                Modifier.Node next$iv$iv = node$iv$iv$iv;
                                                if ((next$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                                                    count$iv$iv5++;
                                                    this_$iv$iv$iv2 = this_$iv$iv$iv5;
                                                    if (count$iv$iv5 == 1) {
                                                        node = next$iv$iv;
                                                        it3 = it8;
                                                    } else {
                                                        if (mutableVector5 == null) {
                                                            count$iv$iv2 = count$iv$iv5;
                                                            it3 = it8;
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            count$iv$iv2 = count$iv$iv5;
                                                            it3 = it8;
                                                            mutableVector2 = mutableVector5;
                                                        }
                                                        MutableVector mutableVector6 = mutableVector2;
                                                        Modifier.Node theNode$iv$iv = node;
                                                        if (theNode$iv$iv != null) {
                                                            if (mutableVector6 != null) {
                                                                Boolean.valueOf(mutableVector6.add(theNode$iv$iv));
                                                            }
                                                            node = null;
                                                        }
                                                        if (mutableVector6 != null) {
                                                            Boolean.valueOf(mutableVector6.add(next$iv$iv));
                                                        }
                                                        mutableVector5 = mutableVector6;
                                                        count$iv$iv5 = count$iv$iv2;
                                                    }
                                                } else {
                                                    this_$iv$iv$iv2 = this_$iv$iv$iv5;
                                                    it3 = it8;
                                                }
                                                node$iv$iv$iv = node$iv$iv$iv.getChild();
                                                this_$iv$iv$iv5 = this_$iv$iv$iv2;
                                                it8 = it3;
                                            }
                                            it2 = it8;
                                            if (count$iv$iv5 == 1) {
                                                $this$forEach$iv6 = $this$forEach$iv7;
                                                $i$f$forEach7 = $i$f$forEach2;
                                                it8 = it2;
                                            }
                                        } else {
                                            it2 = it8;
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector5);
                                    $this$forEach$iv6 = $this$forEach$iv7;
                                    $i$f$forEach7 = $i$f$forEach2;
                                    it8 = it2;
                                }
                                $this$forEach$iv2 = $this$forEach$iv6;
                                $i$f$forEach = $i$f$forEach7;
                                it = it8;
                                int mask$iv$iv = m4400constructorimpl;
                                DelegatableNode $this$visitChildren$iv$iv = $this$visitSelfAndChildren_u2d6rFNWt0$iv;
                                if (!$this$visitChildren$iv$iv.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                                }
                                MutableVector branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild();
                                if (child$iv$iv == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, $this$visitChildren$iv$iv.getNode());
                                } else {
                                    branches$iv$iv3.add(child$iv$iv);
                                }
                                while (branches$iv$iv3.isNotEmpty()) {
                                    MutableVector this_$iv$iv$iv6 = branches$iv$iv3;
                                    Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv3.removeAt(this_$iv$iv$iv6.getSize() - 1);
                                    if ((branch$iv$iv.getAggregateChildKindSet() & mask$iv$iv) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, branch$iv$iv);
                                    } else {
                                        Modifier.Node node$iv$iv = branch$iv$iv;
                                        while (node$iv$iv != null) {
                                            if ((node$iv$iv.getKindSet() & mask$iv$iv) != 0) {
                                                Modifier.Node it$iv = node$iv$iv;
                                                MutableVector mutableVector7 = null;
                                                int mask$iv$iv2 = mask$iv$iv;
                                                Modifier.Node node2 = it$iv;
                                                while (node2 != null) {
                                                    DelegatableNode $this$visitChildren$iv$iv2 = $this$visitChildren$iv$iv;
                                                    if (node2 instanceof FocusTargetNode) {
                                                        FocusTargetNode it10 = (FocusTargetNode) node2;
                                                        if (focusTargetNode != null) {
                                                            aggregatedNode = true;
                                                        }
                                                        focusTargetNode = it10;
                                                        branches$iv$iv = branches$iv$iv3;
                                                        set7 = focusInvalidationManager8.focusTargetNodes;
                                                        if (set7.contains(it10)) {
                                                            requiresUpdate = false;
                                                            focusTargetsWithInvalidatedFocusEvents.add(it10);
                                                        }
                                                        focusInvalidationManager2 = focusInvalidationManager8;
                                                    } else {
                                                        branches$iv$iv = branches$iv$iv3;
                                                        Modifier.Node this_$iv$iv$iv7 = node2;
                                                        if (((this_$iv$iv$iv7.getKindSet() & m4400constructorimpl) != 0) && (node2 instanceof DelegatingNode)) {
                                                            int count$iv$iv6 = 0;
                                                            DelegatingNode this_$iv$iv$iv8 = (DelegatingNode) node2;
                                                            Modifier.Node node$iv$iv$iv2 = this_$iv$iv$iv8.getDelegate();
                                                            while (node$iv$iv$iv2 != null) {
                                                                Modifier.Node next$iv$iv2 = node$iv$iv$iv2;
                                                                if ((next$iv$iv2.getKindSet() & m4400constructorimpl) != 0) {
                                                                    count$iv$iv6++;
                                                                    focusInvalidationManager3 = focusInvalidationManager8;
                                                                    if (count$iv$iv6 == 1) {
                                                                        node2 = next$iv$iv2;
                                                                        this_$iv$iv$iv = this_$iv$iv$iv8;
                                                                    } else {
                                                                        if (mutableVector7 == null) {
                                                                            count$iv$iv = count$iv$iv6;
                                                                            this_$iv$iv$iv = this_$iv$iv$iv8;
                                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                                        } else {
                                                                            count$iv$iv = count$iv$iv6;
                                                                            this_$iv$iv$iv = this_$iv$iv$iv8;
                                                                            mutableVector = mutableVector7;
                                                                        }
                                                                        Modifier.Node theNode$iv$iv2 = node2;
                                                                        if (theNode$iv$iv2 != null) {
                                                                            if (mutableVector != null) {
                                                                                Boolean.valueOf(mutableVector.add(theNode$iv$iv2));
                                                                            }
                                                                            node2 = null;
                                                                        }
                                                                        if (mutableVector != null) {
                                                                            Boolean.valueOf(mutableVector.add(next$iv$iv2));
                                                                        }
                                                                        mutableVector7 = mutableVector;
                                                                        count$iv$iv6 = count$iv$iv;
                                                                    }
                                                                } else {
                                                                    focusInvalidationManager3 = focusInvalidationManager8;
                                                                    this_$iv$iv$iv = this_$iv$iv$iv8;
                                                                }
                                                                node$iv$iv$iv2 = node$iv$iv$iv2.getChild();
                                                                focusInvalidationManager8 = focusInvalidationManager3;
                                                                this_$iv$iv$iv8 = this_$iv$iv$iv;
                                                            }
                                                            focusInvalidationManager2 = focusInvalidationManager8;
                                                            if (count$iv$iv6 == 1) {
                                                                $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                                                branches$iv$iv3 = branches$iv$iv;
                                                                focusInvalidationManager8 = focusInvalidationManager2;
                                                            }
                                                        } else {
                                                            focusInvalidationManager2 = focusInvalidationManager8;
                                                        }
                                                    }
                                                    node2 = DelegatableNodeKt.pop(mutableVector7);
                                                    $this$visitChildren$iv$iv = $this$visitChildren$iv$iv2;
                                                    branches$iv$iv3 = branches$iv$iv;
                                                    focusInvalidationManager8 = focusInvalidationManager2;
                                                }
                                                mask$iv$iv = mask$iv$iv2;
                                                focusInvalidationManager8 = focusInvalidationManager8;
                                            } else {
                                                node$iv$iv = node$iv$iv.getChild();
                                                focusInvalidationManager8 = focusInvalidationManager8;
                                            }
                                        }
                                    }
                                    mask$iv$iv = mask$iv$iv;
                                    $this$visitChildren$iv$iv = $this$visitChildren$iv$iv;
                                    branches$iv$iv3 = branches$iv$iv3;
                                    focusInvalidationManager8 = focusInvalidationManager8;
                                }
                                focusInvalidationManager = focusInvalidationManager8;
                                if (requiresUpdate) {
                                    if (aggregatedNode) {
                                        focusStateImpl2 = FocusEventModifierNodeKt.getFocusState(focusEventNode);
                                    } else {
                                        if (focusTargetNode == null || (focusStateImpl = focusTargetNode.getFocusState()) == null) {
                                            focusStateImpl = FocusStateImpl.Inactive;
                                        }
                                        focusStateImpl2 = focusStateImpl;
                                    }
                                    focusEventNode.onFocusEvent(focusStateImpl2);
                                }
                            } else {
                                focusEventNode.onFocusEvent(FocusStateImpl.Inactive);
                                $this$forEach$iv2 = $this$forEach$iv6;
                                focusInvalidationManager = focusInvalidationManager8;
                                $i$f$forEach = $i$f$forEach7;
                                it = it8;
                            }
                            $this$forEach$iv6 = $this$forEach$iv2;
                            $i$f$forEach7 = $i$f$forEach;
                            it8 = it;
                            focusInvalidationManager8 = focusInvalidationManager;
                            i = 1024;
                        }
                        set2 = FocusInvalidationManager.this.focusEventNodes;
                        set2.clear();
                        $this$forEach$iv = FocusInvalidationManager.this.focusTargetNodes;
                        for (Object element$iv2 : $this$forEach$iv) {
                            FocusTargetNode it11 = (FocusTargetNode) element$iv2;
                            if (it11.getIsAttached()) {
                                FocusStateImpl preInvalidationState = it11.getFocusState();
                                it11.invalidateFocus$ui_release();
                                if (preInvalidationState != it11.getFocusState() || focusTargetsWithInvalidatedFocusEvents.contains(it11)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(it11);
                                }
                            }
                        }
                        set3 = FocusInvalidationManager.this.focusTargetNodes;
                        set3.clear();
                        focusTargetsWithInvalidatedFocusEvents.clear();
                        set4 = FocusInvalidationManager.this.focusPropertiesNodes;
                        if (!set4.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                        }
                        set5 = FocusInvalidationManager.this.focusEventNodes;
                        if (!set5.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                        }
                        set6 = FocusInvalidationManager.this.focusTargetNodes;
                        if (!set6.isEmpty()) {
                            throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                        }
                        return;
                    }
                    Object element$iv3 = it7.next();
                    DelegatableNode it12 = (FocusPropertiesModifierNode) element$iv3;
                    if (it12.getNode().getIsAttached()) {
                        DelegatableNode $this$visitSelfAndChildren_u2d6rFNWt0$iv2 = it12;
                        int type$iv = NodeKind.m4400constructorimpl(1024);
                        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2.getNode();
                        MutableVector mutableVector8 = null;
                        Modifier.Node node3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                FocusTargetNode focusTarget = (FocusTargetNode) node3;
                                $this$forEach$iv4 = $this$forEach$iv5;
                                set10 = focusInvalidationManager7.focusTargetNodes;
                                set10.add(focusTarget);
                                $i$f$forEach4 = $i$f$forEach6;
                                it5 = it7;
                            } else {
                                $this$forEach$iv4 = $this$forEach$iv5;
                                Modifier.Node this_$iv$iv$iv9 = node3;
                                if (((this_$iv$iv$iv9.getKindSet() & type$iv) != 0) && (node3 instanceof DelegatingNode)) {
                                    int count$iv$iv7 = 0;
                                    DelegatingNode this_$iv$iv$iv10 = (DelegatingNode) node3;
                                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv10.getDelegate();
                                    while (node$iv$iv$iv3 != null) {
                                        Modifier.Node next$iv$iv3 = node$iv$iv$iv3;
                                        if ((next$iv$iv3.getKindSet() & type$iv) != 0) {
                                            count$iv$iv7++;
                                            $i$f$forEach5 = $i$f$forEach6;
                                            if (count$iv$iv7 == 1) {
                                                node3 = next$iv$iv3;
                                                it6 = it7;
                                            } else {
                                                if (mutableVector8 == null) {
                                                    count$iv$iv4 = count$iv$iv7;
                                                    it6 = it7;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv4 = count$iv$iv7;
                                                    it6 = it7;
                                                    mutableVector4 = mutableVector8;
                                                }
                                                MutableVector mutableVector9 = mutableVector4;
                                                Modifier.Node theNode$iv$iv3 = node3;
                                                if (theNode$iv$iv3 != null) {
                                                    if (mutableVector9 != null) {
                                                        Boolean.valueOf(mutableVector9.add(theNode$iv$iv3));
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector9 != null) {
                                                    Boolean.valueOf(mutableVector9.add(next$iv$iv3));
                                                }
                                                mutableVector8 = mutableVector9;
                                                count$iv$iv7 = count$iv$iv4;
                                            }
                                        } else {
                                            $i$f$forEach5 = $i$f$forEach6;
                                            it6 = it7;
                                        }
                                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                                        $i$f$forEach6 = $i$f$forEach5;
                                        it7 = it6;
                                    }
                                    $i$f$forEach4 = $i$f$forEach6;
                                    it5 = it7;
                                    if (count$iv$iv7 == 1) {
                                        $this$forEach$iv5 = $this$forEach$iv4;
                                        $i$f$forEach6 = $i$f$forEach4;
                                        it7 = it5;
                                    }
                                } else {
                                    $i$f$forEach4 = $i$f$forEach6;
                                    it5 = it7;
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector8);
                            $this$forEach$iv5 = $this$forEach$iv4;
                            $i$f$forEach6 = $i$f$forEach4;
                            it7 = it5;
                        }
                        $this$forEach$iv3 = $this$forEach$iv5;
                        $i$f$forEach3 = $i$f$forEach6;
                        it4 = it7;
                        int mask$iv$iv3 = type$iv;
                        DelegatableNode $this$visitChildren$iv$iv3 = $this$visitSelfAndChildren_u2d6rFNWt0$iv2;
                        if (!$this$visitChildren$iv$iv3.getNode().getIsAttached()) {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                        MutableVector branches$iv$iv4 = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$iv$iv2 = $this$visitChildren$iv$iv3.getNode().getChild();
                        if (child$iv$iv2 == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, $this$visitChildren$iv$iv3.getNode());
                        } else {
                            branches$iv$iv4.add(child$iv$iv2);
                        }
                        while (branches$iv$iv4.isNotEmpty()) {
                            MutableVector this_$iv$iv$iv11 = branches$iv$iv4;
                            Modifier.Node branch$iv$iv2 = (Modifier.Node) branches$iv$iv4.removeAt(this_$iv$iv$iv11.getSize() - 1);
                            if ((branch$iv$iv2.getAggregateChildKindSet() & mask$iv$iv3) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv4, branch$iv$iv2);
                            } else {
                                Modifier.Node node$iv$iv2 = branch$iv$iv2;
                                while (true) {
                                    if (node$iv$iv2 == null) {
                                        break;
                                    }
                                    if ((node$iv$iv2.getKindSet() & mask$iv$iv3) != 0) {
                                        Modifier.Node it$iv2 = node$iv$iv2;
                                        MutableVector mutableVector10 = null;
                                        int mask$iv$iv4 = mask$iv$iv3;
                                        Modifier.Node node4 = it$iv2;
                                        while (node4 != null) {
                                            DelegatableNode $this$visitChildren$iv$iv4 = $this$visitChildren$iv$iv3;
                                            if (node4 instanceof FocusTargetNode) {
                                                FocusTargetNode focusTarget2 = (FocusTargetNode) node4;
                                                branches$iv$iv2 = branches$iv$iv4;
                                                set9 = focusInvalidationManager7.focusTargetNodes;
                                                set9.add(focusTarget2);
                                                focusInvalidationManager5 = focusInvalidationManager7;
                                            } else {
                                                branches$iv$iv2 = branches$iv$iv4;
                                                Modifier.Node this_$iv$iv$iv12 = node4;
                                                if (((this_$iv$iv$iv12.getKindSet() & type$iv) != 0) && (node4 instanceof DelegatingNode)) {
                                                    int count$iv$iv8 = 0;
                                                    DelegatingNode this_$iv$iv$iv13 = (DelegatingNode) node4;
                                                    Modifier.Node node$iv$iv$iv4 = this_$iv$iv$iv13.getDelegate();
                                                    while (node$iv$iv$iv4 != null) {
                                                        Modifier.Node next$iv$iv4 = node$iv$iv$iv4;
                                                        if ((next$iv$iv4.getKindSet() & type$iv) != 0) {
                                                            count$iv$iv8++;
                                                            focusInvalidationManager6 = focusInvalidationManager7;
                                                            if (count$iv$iv8 == 1) {
                                                                node4 = next$iv$iv4;
                                                                this_$iv$iv$iv3 = this_$iv$iv$iv13;
                                                            } else {
                                                                if (mutableVector10 == null) {
                                                                    count$iv$iv3 = count$iv$iv8;
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv13;
                                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                                } else {
                                                                    count$iv$iv3 = count$iv$iv8;
                                                                    this_$iv$iv$iv3 = this_$iv$iv$iv13;
                                                                    mutableVector3 = mutableVector10;
                                                                }
                                                                MutableVector mutableVector11 = mutableVector3;
                                                                Modifier.Node theNode$iv$iv4 = node4;
                                                                if (theNode$iv$iv4 != null) {
                                                                    if (mutableVector11 != null) {
                                                                        Boolean.valueOf(mutableVector11.add(theNode$iv$iv4));
                                                                    }
                                                                    node4 = null;
                                                                }
                                                                if (mutableVector11 != null) {
                                                                    Boolean.valueOf(mutableVector11.add(next$iv$iv4));
                                                                }
                                                                mutableVector10 = mutableVector11;
                                                                count$iv$iv8 = count$iv$iv3;
                                                            }
                                                        } else {
                                                            focusInvalidationManager6 = focusInvalidationManager7;
                                                            this_$iv$iv$iv3 = this_$iv$iv$iv13;
                                                        }
                                                        node$iv$iv$iv4 = node$iv$iv$iv4.getChild();
                                                        focusInvalidationManager7 = focusInvalidationManager6;
                                                        this_$iv$iv$iv13 = this_$iv$iv$iv3;
                                                    }
                                                    focusInvalidationManager5 = focusInvalidationManager7;
                                                    if (count$iv$iv8 == 1) {
                                                        $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv4;
                                                        branches$iv$iv4 = branches$iv$iv2;
                                                        focusInvalidationManager7 = focusInvalidationManager5;
                                                    }
                                                } else {
                                                    focusInvalidationManager5 = focusInvalidationManager7;
                                                }
                                            }
                                            node4 = DelegatableNodeKt.pop(mutableVector10);
                                            $this$visitChildren$iv$iv3 = $this$visitChildren$iv$iv4;
                                            branches$iv$iv4 = branches$iv$iv2;
                                            focusInvalidationManager7 = focusInvalidationManager5;
                                        }
                                        mask$iv$iv3 = mask$iv$iv4;
                                    } else {
                                        node$iv$iv2 = node$iv$iv2.getChild();
                                    }
                                }
                            }
                        }
                        focusInvalidationManager4 = focusInvalidationManager7;
                    } else {
                        $this$forEach$iv3 = $this$forEach$iv5;
                        focusInvalidationManager4 = focusInvalidationManager7;
                        $i$f$forEach3 = $i$f$forEach6;
                        it4 = it7;
                    }
                    $this$forEach$iv5 = $this$forEach$iv3;
                    $i$f$forEach6 = $i$f$forEach3;
                    it7 = it4;
                    focusInvalidationManager7 = focusInvalidationManager4;
                }
            }
        };
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.add(t) && this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
