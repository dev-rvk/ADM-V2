package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0003XYZB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u00100\u001a\u0002012\u001d\u00102\u001a\u0019\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\u0016ø\u0001\u0000J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0010H\u0002J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0010J\u0006\u0010:\u001a\u000207J\u0012\u0010;\u001a\u0004\u0018\u00010\u00012\u0006\u00105\u001a\u00020\u0010H\u0002J\u0017\u0010<\u001a\u0002072\f\u00102\u001a\b\u0012\u0004\u0012\u0002070=H\u0082\bJ\u0006\u0010>\u001a\u000207J\"\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\b\b\u0002\u0010B\u001a\u00020\u0010H\u0002J(\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bG¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\"H\u0002J2\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020\u00032\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bGH\u0002¢\u0006\u0002\u0010LJ.\u0010I\u001a\b\u0012\u0004\u0012\u00020N0M2\b\u0010E\u001a\u0004\u0018\u00010\u00012\u0011\u0010F\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bG¢\u0006\u0002\u0010OJ:\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\n2\u0011\u0010U\u001a\r\u0012\u0004\u0012\u0002070=¢\u0006\u0002\bGH\u0002¢\u0006\u0002\u0010VJ\u0014\u0010W\u001a\u0004\u0018\u00010\u00032\b\u0010E\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0011\u001a\u0019\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\u0016X\u0080\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00060)R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030!X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "intermediateMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "getIntermediateMeasurePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "setIntermediateMeasurePolicy$ui_release", "(Lkotlin/jvm/functions/Function2;)V", "intermediateMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl;", "isInLookaheadScope", "", "()Z", "nodeToNodeState", "", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "createNodeAt", "index", "disposeCurrentNodes", "", "disposeOrReuseStartingFromIndex", "startIndex", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "IntermediateMeasureScopeImpl", "NodeState", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutNodeSubcompositionsState {
    private final String NoIntrinsicsMessage;
    private CompositionContext compositionContext;
    private int currentIndex;
    private Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> intermediateMeasurePolicy;
    private final IntermediateMeasureScopeImpl intermediateMeasureScope;
    private final Map<LayoutNode, NodeState> nodeToNodeState;
    private final Map<Object, LayoutNode> precomposeMap;
    private int precomposedCount;
    private int reusableCount;
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet;
    private final LayoutNode root;
    private final Scope scope;
    private final Map<Object, LayoutNode> slotIdToNode;
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public LayoutNodeSubcompositionsState(LayoutNode root, SubcomposeSlotReusePolicy slotReusePolicy) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(slotReusePolicy, "slotReusePolicy");
        this.root = root;
        this.slotReusePolicy = slotReusePolicy;
        this.nodeToNodeState = new LinkedHashMap();
        this.slotIdToNode = new LinkedHashMap();
        this.scope = new Scope();
        this.intermediateMeasureScope = new IntermediateMeasureScopeImpl();
        this.intermediateMeasurePolicy = new Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$intermediateMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Constraints constraints) {
                return m4206invoke0kLqBqw(subcomposeIntermediateMeasureScope, constraints.getValue());
            }

            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final MeasureResult m4206invoke0kLqBqw(SubcomposeIntermediateMeasureScope $this$null, long it) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                return $this$null.getLookaheadMeasurePolicy().invoke($this$null, Constraints.m5162boximpl(it));
            }
        };
        this.precomposeMap = new LinkedHashMap();
        this.reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.slotReusePolicy != value) {
            this.slotReusePolicy = value;
            disposeOrReuseStartingFromIndex(0);
        }
    }

    public final boolean isInLookaheadScope() {
        return this.root.getLookaheadRoot() != null;
    }

    public final Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> getIntermediateMeasurePolicy$ui_release() {
        return this.intermediateMeasurePolicy;
    }

    public final void setIntermediateMeasurePolicy$ui_release(Function2<? super SubcomposeIntermediateMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.intermediateMeasurePolicy = function2;
    }

    public final List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        LayoutNode layoutNode;
        LayoutNode takeNodeFromReusables;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState = this.root.getLayoutState$ui_release();
        if (!(layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut || layoutState == LayoutNode.LayoutState.LookaheadMeasuring || layoutState == LayoutNode.LayoutState.LookaheadLayingOut)) {
            throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
        }
        Map $this$getOrPut$iv = this.slotIdToNode;
        LayoutNode layoutNode2 = $this$getOrPut$iv.get(slotId);
        if (layoutNode2 == null) {
            LayoutNode precomposed = this.precomposeMap.remove(slotId);
            if (precomposed != null) {
                if (!(this.precomposedCount > 0)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                this.precomposedCount--;
                takeNodeFromReusables = precomposed;
            } else {
                takeNodeFromReusables = takeNodeFromReusables(slotId);
                if (takeNodeFromReusables == null) {
                    takeNodeFromReusables = createNodeAt(this.currentIndex);
                }
            }
            layoutNode = takeNodeFromReusables;
            $this$getOrPut$iv.put(slotId, layoutNode);
        } else {
            layoutNode = layoutNode2;
        }
        LayoutNode node = layoutNode;
        int itemIndex = this.root.getFoldedChildren$ui_release().indexOf(node);
        if (!(itemIndex >= this.currentIndex)) {
            throw new IllegalArgumentException(("Key \"" + slotId + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
        }
        if (this.currentIndex != itemIndex) {
            move$default(this, itemIndex, this.currentIndex, 0, 4, null);
        }
        this.currentIndex++;
        subcompose(node, slotId, content);
        if (layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut) {
            return node.getChildMeasurables$ui_release();
        }
        return node.getChildLookaheadMeasurables$ui_release();
    }

    private final void subcompose(LayoutNode node, Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        NodeState nodeState;
        Map $this$getOrPut$iv = this.nodeToNodeState;
        NodeState nodeState2 = $this$getOrPut$iv.get(node);
        if (nodeState2 == null) {
            nodeState = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m4176getLambda1$ui_release(), null, 4, null);
            $this$getOrPut$iv.put(node, nodeState);
        } else {
            nodeState = nodeState2;
        }
        NodeState nodeState3 = nodeState;
        Composition composition = nodeState3.getComposition();
        boolean hasPendingChanges = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState3.getContent() != content || hasPendingChanges || nodeState3.getForceRecompose()) {
            nodeState3.setContent(content);
            subcompose(node, nodeState3);
            nodeState3.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode node, final NodeState nodeState) {
        Snapshot snapshot$iv = Snapshot.INSTANCE.createNonObservableSnapshot();
        try {
            Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
            try {
                try {
                    LayoutNode this_$iv$iv = this.root;
                    this_$iv$iv.ignoreRemeasureRequests = true;
                    final Function2 content = nodeState.getContent();
                    Composition composition = nodeState.getComposition();
                    CompositionContext compositionContext = this.compositionContext;
                    try {
                        if (compositionContext == null) {
                            throw new IllegalStateException("parent composition reference not set".toString());
                        }
                        try {
                            try {
                                nodeState.setComposition(subcomposeInto(composition, node, compositionContext, ComposableLambdaKt.composableLambdaInstance(-34810602, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$3$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer, int $changed) {
                                        ComposerKt.sourceInformation($composer, "C701@32613L46:SubcomposeLayout.kt#80mrfh");
                                        if (($changed & 11) == 2 && $composer.getSkipping()) {
                                            $composer.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-34810602, $changed, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:700)");
                                        }
                                        boolean active$iv = LayoutNodeSubcompositionsState.NodeState.this.getActive();
                                        Function2 content$iv = content;
                                        $composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(active$iv));
                                        boolean activeChanged$iv = $composer.changed(active$iv);
                                        if (active$iv) {
                                            content$iv.invoke($composer, Integer.valueOf((0 >> 3) & 14));
                                        } else {
                                            $composer.deactivateToEndGroup(activeChanged$iv);
                                        }
                                        $composer.endReusableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                })));
                                this_$iv$iv.ignoreRemeasureRequests = false;
                                Unit unit = Unit.INSTANCE;
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                            } catch (Throwable th) {
                                th = th;
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final Composition subcomposeInto(Composition existing, LayoutNode container, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> composable) {
        Composition createSubcomposition;
        if (existing == null || existing.getDisposed()) {
            createSubcomposition = Wrapper_androidKt.createSubcomposition(container, parent);
        } else {
            createSubcomposition = existing;
        }
        Composition $this$subcomposeInto_u24lambda_u246 = createSubcomposition;
        $this$subcomposeInto_u24lambda_u246.setContent(composable);
        return createSubcomposition;
    }

    private final Object getSlotIdAtIndex(int index) {
        LayoutNode node = this.root.getFoldedChildren$ui_release().get(index);
        NodeState nodeState = this.nodeToNodeState.get(node);
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        Throwable th;
        int lastReusableIndex;
        int lastReusableIndex2;
        int i = startIndex;
        this.reusableCount = 0;
        int lastReusableIndex3 = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        boolean needApplyNotification = false;
        if (i <= lastReusableIndex3) {
            this.reusableSlotIdsSet.clear();
            int i2 = startIndex;
            if (i2 <= lastReusableIndex3) {
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i2));
                    if (i2 == lastReusableIndex3) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            int i3 = lastReusableIndex3;
            Snapshot snapshot$iv = Snapshot.INSTANCE.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                while (i3 >= i) {
                    try {
                        try {
                            LayoutNode node = this.root.getFoldedChildren$ui_release().get(i3);
                            NodeState nodeState = this.nodeToNodeState.get(node);
                            Intrinsics.checkNotNull(nodeState);
                            NodeState nodeState2 = nodeState;
                            Object slotId = nodeState2.getSlotId();
                            if (this.reusableSlotIdsSet.contains(slotId)) {
                                try {
                                    node.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                                    LayoutNodeLayoutDelegate.LookaheadPassDelegate it = node.getLookaheadPassDelegate$ui_release();
                                    if (it != null) {
                                        it.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                                    }
                                    this.reusableCount++;
                                    if (nodeState2.getActive()) {
                                        nodeState2.setActive(false);
                                        needApplyNotification = true;
                                        lastReusableIndex = lastReusableIndex3;
                                        lastReusableIndex2 = 1;
                                    } else {
                                        lastReusableIndex = lastReusableIndex3;
                                        lastReusableIndex2 = 1;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    snapshot$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                }
                            } else {
                                LayoutNode this_$iv$iv = this.root;
                                this_$iv$iv.ignoreRemeasureRequests = true;
                                this.nodeToNodeState.remove(node);
                                Composition composition = nodeState2.getComposition();
                                if (composition != null) {
                                    composition.dispose();
                                }
                                lastReusableIndex = lastReusableIndex3;
                                lastReusableIndex2 = 1;
                                try {
                                    this.root.removeAt$ui_release(i3, 1);
                                    this_$iv$iv.ignoreRemeasureRequests = false;
                                } catch (Throwable th3) {
                                    th = th3;
                                    snapshot$iv.restoreCurrent(previous$iv$iv);
                                    throw th;
                                }
                            }
                            this.slotIdToNode.remove(slotId);
                            i3--;
                            i = startIndex;
                            lastReusableIndex3 = lastReusableIndex;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        snapshot$iv.dispose();
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                snapshot$iv.restoreCurrent(previous$iv$iv);
                snapshot$iv.dispose();
            } catch (Throwable th6) {
                th = th6;
            }
        }
        if (needApplyNotification) {
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        if (!(this.nodeToNodeState.size() == this.root.getFoldedChildren$ui_release().size())) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + this.root.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        }
        if (!((this.root.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount >= 0)) {
            throw new IllegalArgumentException(("Incorrect state. Total children " + this.root.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        }
        if (!(this.precomposeMap.size() == this.precomposedCount)) {
            throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
        }
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        if (this.reusableCount == 0) {
            return null;
        }
        int reusableNodesSectionEnd = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int reusableNodesSectionStart = reusableNodesSectionEnd - this.reusableCount;
        int index = reusableNodesSectionEnd - 1;
        int chosenIndex = -1;
        while (true) {
            if (index < reusableNodesSectionStart) {
                break;
            }
            if (Intrinsics.areEqual(getSlotIdAtIndex(index), slotId)) {
                chosenIndex = index;
                break;
            }
            index--;
        }
        if (chosenIndex == -1) {
            index = reusableNodesSectionEnd - 1;
            while (true) {
                if (index < reusableNodesSectionStart) {
                    break;
                }
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    chosenIndex = index;
                    break;
                }
                index--;
            }
        }
        if (chosenIndex == -1) {
            return null;
        }
        if (index != reusableNodesSectionStart) {
            move(index, reusableNodesSectionStart, 1);
        }
        this.reusableCount--;
        LayoutNode node = this.root.getFoldedChildren$ui_release().get(reusableNodesSectionStart);
        NodeState nodeState3 = this.nodeToNodeState.get(node);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActive(true);
        nodeState4.setForceRecompose(true);
        Snapshot.INSTANCE.sendApplyNotifications();
        return node;
    }

    public final MeasurePolicy createMeasurePolicy(final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.intermediateMeasureScope.setLookaheadMeasurePolicy(block);
        final String str = this.NoIntrinsicsMessage;
        return new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo15measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl intermediateMeasureScopeImpl;
                final int indexAfterMeasure;
                LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl intermediateMeasureScopeImpl2;
                LayoutNodeSubcompositionsState.IntermediateMeasureScopeImpl intermediateMeasureScopeImpl3;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                LayoutNodeSubcompositionsState.this.scope.setLayoutDirection(measure.getLayoutDirection());
                LayoutNodeSubcompositionsState.this.scope.setDensity(measure.getDensity());
                LayoutNodeSubcompositionsState.this.scope.setFontScale(measure.getFontScale());
                boolean isIntermediate = (LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) && LayoutNodeSubcompositionsState.this.root.getLookaheadRoot() != null;
                if (!isIntermediate) {
                    LayoutNodeSubcompositionsState.this.currentIndex = 0;
                    intermediateMeasureScopeImpl = LayoutNodeSubcompositionsState.this.intermediateMeasureScope;
                    intermediateMeasureScopeImpl.m4204setLookaheadConstraintsBRTryo0(constraints);
                    final MeasureResult result = block.invoke(LayoutNodeSubcompositionsState.this.scope, Constraints.m5162boximpl(constraints));
                    indexAfterMeasure = LayoutNodeSubcompositionsState.this.currentIndex;
                    intermediateMeasureScopeImpl2 = LayoutNodeSubcompositionsState.this.intermediateMeasureScope;
                    intermediateMeasureScopeImpl2.m4205setLookaheadSizeozmzZPI(IntSizeKt.IntSize(result.getWidth(), result.getHeight()));
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getWidth() {
                            return MeasureResult.this.getWidth();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public int getHeight() {
                            return MeasureResult.this.getHeight();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return MeasureResult.this.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            int i;
                            layoutNodeSubcompositionsState.currentIndex = indexAfterMeasure;
                            MeasureResult.this.placeChildren();
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                            i = layoutNodeSubcompositionsState.currentIndex;
                            layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(i);
                        }
                    };
                }
                Function2<SubcomposeIntermediateMeasureScope, Constraints, MeasureResult> intermediateMeasurePolicy$ui_release = LayoutNodeSubcompositionsState.this.getIntermediateMeasurePolicy$ui_release();
                intermediateMeasureScopeImpl3 = LayoutNodeSubcompositionsState.this.intermediateMeasureScope;
                return intermediateMeasurePolicy$ui_release.invoke(intermediateMeasureScopeImpl3, Constraints.m5162boximpl(constraints));
            }
        };
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(final Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        LayoutNode layoutNode;
        LayoutNode createNodeAt;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(slotId)) {
            Map $this$getOrPut$iv = this.precomposeMap;
            LayoutNode layoutNode2 = $this$getOrPut$iv.get(slotId);
            if (layoutNode2 == null) {
                LayoutNode reusedNode = takeNodeFromReusables(slotId);
                if (reusedNode != null) {
                    int nodeIndex = this.root.getFoldedChildren$ui_release().indexOf(reusedNode);
                    move(nodeIndex, this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                    createNodeAt = reusedNode;
                } else {
                    createNodeAt = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                layoutNode = createNodeAt;
                $this$getOrPut$iv.put(slotId, layoutNode);
            } else {
                layoutNode = layoutNode2;
            }
            LayoutNode node = layoutNode;
            subcompose(node, slotId, content);
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$precompose$1
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                Map map;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                LayoutNodeSubcompositionsState.this.makeSureStateIsConsistent();
                map = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode node2 = (LayoutNode) map.remove(slotId);
                if (node2 != null) {
                    i = LayoutNodeSubcompositionsState.this.precomposedCount;
                    if (i > 0) {
                        int itemIndex = LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().indexOf(node2);
                        int size = LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().size();
                        i2 = LayoutNodeSubcompositionsState.this.precomposedCount;
                        if (!(itemIndex >= size - i2)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                        i3 = layoutNodeSubcompositionsState.reusableCount;
                        layoutNodeSubcompositionsState.reusableCount = i3 + 1;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                        i4 = layoutNodeSubcompositionsState2.precomposedCount;
                        layoutNodeSubcompositionsState2.precomposedCount = i4 - 1;
                        int size2 = LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().size();
                        i5 = LayoutNodeSubcompositionsState.this.precomposedCount;
                        int i7 = size2 - i5;
                        i6 = LayoutNodeSubcompositionsState.this.reusableCount;
                        int reusableStart = i7 - i6;
                        LayoutNodeSubcompositionsState.this.move(itemIndex, reusableStart, 1);
                        LayoutNodeSubcompositionsState.this.disposeOrReuseStartingFromIndex(reusableStart);
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                Map map;
                List<LayoutNode> children$ui_release;
                map = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode layoutNode3 = (LayoutNode) map.get(slotId);
                if (layoutNode3 == null || (children$ui_release = layoutNode3.getChildren$ui_release()) == null) {
                    return 0;
                }
                return children$ui_release.size();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
            public void mo4207premeasure0kLqBqw(int index, long constraints) {
                Map map;
                map = LayoutNodeSubcompositionsState.this.precomposeMap;
                LayoutNode node2 = (LayoutNode) map.get(slotId);
                if (node2 != null && node2.isAttached()) {
                    int size = node2.getChildren$ui_release().size();
                    if (index < 0 || index >= size) {
                        throw new IndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                    }
                    if (!node2.isPlaced()) {
                        LayoutNode this_$iv = LayoutNodeSubcompositionsState.this.root;
                        this_$iv.ignoreRemeasureRequests = true;
                        LayoutNodeKt.requireOwner(node2).mo4455measureAndLayout0kLqBqw(node2.getChildren$ui_release().get(index), constraints);
                        this_$iv.ignoreRemeasureRequests = false;
                        return;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        };
    }

    public final void forceRecomposeChildren() {
        Map $this$forEach$iv = this.nodeToNodeState;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            NodeState nodeState = element$iv.getValue();
            nodeState.setForceRecompose(true);
        }
        if (!this.root.getMeasurePending$ui_release()) {
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, 3, null);
        }
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode node = new LayoutNode(true, 0, 2, null);
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, node);
        this_$iv$iv.ignoreRemeasureRequests = false;
        return node;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void move(int from, int to, int count) {
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        this_$iv$iv.ignoreRemeasureRequests = false;
    }

    private final void ignoreRemeasureRequests(Function0<Unit> block) {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        block.invoke();
        this_$iv.ignoreRemeasureRequests = false;
    }

    public final void disposeCurrentNodes() {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        Iterable $this$forEach$iv = this.nodeToNodeState.values();
        for (Object element$iv : $this$forEach$iv) {
            NodeState it = (NodeState) element$iv;
            Composition composition = it.getComposition();
            if (composition != null) {
                composition.dispose();
            }
        }
        this.root.removeAll$ui_release();
        this_$iv.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Landroidx/compose/runtime/MutableState;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class NodeState {

        /* renamed from: active$delegate, reason: from kotlin metadata */
        private final MutableState active;
        private Composition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private Object slotId;

        public NodeState(Object slotId, Function2<? super Composer, ? super Integer, Unit> content, Composition composition) {
            MutableState mutableStateOf$default;
            Intrinsics.checkNotNullParameter(content, "content");
            this.slotId = slotId;
            this.content = content;
            this.composition = composition;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
            this.active = mutableStateOf$default;
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : composition);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final Composition getComposition() {
            return this.composition;
        }

        public final void setComposition(Composition composition) {
            this.composition = composition;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getActive() {
            State $this$getValue$iv = this.active;
            return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
        }

        public final void setActive(boolean z) {
            MutableState $this$setValue$iv = this.active;
            $this$setValue$iv.setValue(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0016¢\u0006\u0002\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JH\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020'0*2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b\u001cH\u0096\u0001J\u0018\u00100\u001a\b\u0012\u0004\u0012\u000202012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u00020'*\u000206H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001a\u00105\u001a\u00020'*\u000209H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u000206*\u000209H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001d\u0010<\u001a\u000206*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001d\u0010<\u001a\u000206*\u00020'H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010AJ\u001a\u0010B\u001a\u00020C*\u00020DH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001a\u0010G\u001a\u00020\u0005*\u000206H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010@J\u001a\u0010G\u001a\u00020\u0005*\u000209H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010>J\r\u0010J\u001a\u00020K*\u00020LH\u0097\u0001J\u001a\u0010M\u001a\u00020D*\u00020CH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010FJ\u001a\u0010O\u001a\u000209*\u000206H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u001d\u0010O\u001a\u000209*\u00020\u0005H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010QJ\u001d\u0010O\u001a\u000209*\u00020'H\u0097\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SR\u0014\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8WX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u00020\u0012X\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R4\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\b\u001cX\u0096.ø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R%\u0010!\u001a\u00020\"X\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006T"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeIntermediateMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-msEJaDk", "()J", "setLookaheadConstraints-BRTryo0", "(J)V", "J", "lookaheadMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "getLookaheadMeasurePolicy", "()Lkotlin/jvm/functions/Function2;", "setLookaheadMeasurePolicy", "(Lkotlin/jvm/functions/Function2;)V", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "setLookaheadSize-ozmzZPI", "layout", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "measurablesForSlot", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class IntermediateMeasureScopeImpl implements SubcomposeIntermediateMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;
        public Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> lookaheadMeasurePolicy;
        private long lookaheadSize = IntSize.INSTANCE.m5383getZeroYbymL2g();
        private long lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return this.$$delegate_0.layout(width, height, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo322roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo322roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo323roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo323roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-GaN1DYA */
        public float mo324toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo324toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo325toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo325toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo326toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo326toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo327toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo327toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo328toPxR2X_6o(long j) {
            return this.$$delegate_0.mo328toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo329toPx0680j_4(float f) {
            return this.$$delegate_0.mo329toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo330toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo330toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-0xMU5do */
        public long mo331toSp0xMU5do(float f) {
            return this.$$delegate_0.mo331toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo332toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo332toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo333toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo333toSpkPz2Gy4(i);
        }

        public IntermediateMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public List<Measurable> measurablesForSlot(Object slotId) {
            List<Measurable> childMeasurables$ui_release;
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(slotId);
            return (layoutNode == null || (childMeasurables$ui_release = layoutNode.getChildMeasurables$ui_release()) == null) ? CollectionsKt.emptyList() : childMeasurables$ui_release;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        /* renamed from: getLookaheadSize-YbymL2g, reason: not valid java name and from getter */
        public long getLookaheadSize() {
            return this.lookaheadSize;
        }

        /* renamed from: setLookaheadSize-ozmzZPI, reason: not valid java name */
        public void m4205setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        public Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getLookaheadMeasurePolicy() {
            Function2 function2 = this.lookaheadMeasurePolicy;
            if (function2 != null) {
                return function2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lookaheadMeasurePolicy");
            return null;
        }

        public void setLookaheadMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.lookaheadMeasurePolicy = function2;
        }

        @Override // androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope
        /* renamed from: getLookaheadConstraints-msEJaDk, reason: not valid java name and from getter */
        public long getLookaheadConstraints() {
            return this.lookaheadConstraints;
        }

        /* renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
        public void m4204setLookaheadConstraintsBRTryo0(long j) {
            this.lookaheadConstraints = j;
        }
    }
}
