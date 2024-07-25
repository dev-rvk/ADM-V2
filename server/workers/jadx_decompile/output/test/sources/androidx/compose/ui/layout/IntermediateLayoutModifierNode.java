package androidx.compose.ui.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IntermediateLayoutModifierNode.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u000289BK\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010 \u001a\u00020!H\u0016J7\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b-J!\u0010.\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b0J)\u00101\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b5J!\u00106\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b7R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000RX\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u0080\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "closestLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "intermediateMeasurable", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "intermediateMeasureScope", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "isIntermediateChangeActive", "", "()Z", "setIntermediateChangeActive", "(Z)V", "localLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScopeImpl;", "lookaheadConstraints", "getMeasureBlock$ui_release", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock$ui_release", "onAttach", "", "intermediateMeasure", "Landroidx/compose/ui/layout/MeasureScope;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "intermediateMeasure-Te-uZzU", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;JJJ)Landroidx/compose/ui/layout/MeasureResult;", "maxIntermediateIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntermediateIntrinsicHeight$ui_release", "maxIntermediateIntrinsicWidth", "height", "maxIntermediateIntrinsicWidth$ui_release", "measure", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntermediateIntrinsicHeight", "minIntermediateIntrinsicHeight$ui_release", "minIntermediateIntrinsicWidth", "minIntermediateIntrinsicWidth$ui_release", "IntermediateMeasurablePlaceable", "IntermediateMeasureScopeImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IntermediateLayoutModifierNode extends Modifier.Node implements LayoutModifierNode {
    private LookaheadScope closestLookaheadScope;
    private IntermediateMeasurablePlaceable intermediateMeasurable;
    private final IntermediateMeasureScopeImpl intermediateMeasureScope;
    private boolean isIntermediateChangeActive;
    private final LookaheadScopeImpl localLookaheadScope;
    private Constraints lookaheadConstraints;
    private Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock;

    public final Function3<IntermediateMeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock$ui_release() {
        return this.measureBlock;
    }

    public final void setMeasureBlock$ui_release(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.measureBlock = function3;
    }

    public IntermediateLayoutModifierNode(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock) {
        Intrinsics.checkNotNullParameter(measureBlock, "measureBlock");
        this.measureBlock = measureBlock;
        this.intermediateMeasureScope = new IntermediateMeasureScopeImpl();
        this.localLookaheadScope = new LookaheadScopeImpl(new Function0<LayoutCoordinates>() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$localLookaheadScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutCoordinates invoke() {
                NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator();
                Intrinsics.checkNotNull(coordinator$ui_release);
                return coordinator$ui_release;
            }
        });
        this.closestLookaheadScope = this.localLookaheadScope;
        this.isIntermediateChangeActive = true;
    }

    /* renamed from: isIntermediateChangeActive, reason: from getter */
    public final boolean getIsIntermediateChangeActive() {
        return this.isIntermediateChangeActive;
    }

    public final void setIntermediateChangeActive(boolean z) {
        this.isIntermediateChangeActive = z;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        LookaheadScopeImpl lookaheadScopeImpl;
        LookaheadScopeImpl lookaheadScopeImpl2;
        LayoutNode layoutNode;
        LookaheadLayoutCoordinatesImpl coordinates;
        int i;
        NodeChain nodes;
        LayoutNode layoutNode2;
        LookaheadLayoutCoordinatesImpl coordinates2;
        int i2;
        LayoutNode layoutNode3;
        LookaheadLayoutCoordinatesImpl coordinates3;
        MutableVector mutableVector;
        NodeCoordinator coordinator$ui_release = getCoordinator();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LayoutNode layoutNode4 = coordinator$ui_release.getLayoutNode();
        NodeCoordinator coordinator$ui_release2 = getCoordinator();
        Intrinsics.checkNotNull(coordinator$ui_release2);
        LookaheadDelegate lookaheadDelegate = coordinator$ui_release2.getLookaheadDelegate();
        LookaheadLayoutCoordinatesImpl coordinates4 = lookaheadDelegate != null ? lookaheadDelegate.getLookaheadLayoutCoordinates() : null;
        int i3 = 1;
        if (!(coordinates4 != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        final LayoutNode closestLookaheadRoot = layoutNode4.getLookaheadRoot();
        if (closestLookaheadRoot != null && closestLookaheadRoot.getIsVirtualLookaheadRoot()) {
            lookaheadScopeImpl2 = new LookaheadScopeImpl(new Function0<LayoutCoordinates>() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$onAttach$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutCoordinates invoke() {
                    LayoutNode parent$ui_release = LayoutNode.this.getParent$ui_release();
                    Intrinsics.checkNotNull(parent$ui_release);
                    return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
                }
            });
        } else {
            IntermediateLayoutModifierNode intermediateLayoutModifierNode = null;
            IntermediateLayoutModifierNode $this$visitAncestors_u2dY_u2dYKmho_u24default$iv = this;
            int m4400constructorimpl = NodeKind.m4400constructorimpl(512);
            if (!$this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node$iv$iv = $this$visitAncestors_u2dY_u2dYKmho_u24default$iv.getNode().getParent();
            LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors_u2dY_u2dYKmho_u24default$iv);
            while (layout$iv$iv != null) {
                Modifier.Node head$iv$iv = layout$iv$iv.getNodes().getHead();
                if ((head$iv$iv.getAggregateChildKindSet() & m4400constructorimpl) == 0) {
                    layoutNode = layoutNode4;
                    coordinates = coordinates4;
                    i = i3;
                } else {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet() & m4400constructorimpl) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            MutableVector mutableVector2 = null;
                            Modifier.Node node = it$iv;
                            while (node != null) {
                                if (node instanceof IntermediateLayoutModifierNode) {
                                    IntermediateLayoutModifierNode it = (IntermediateLayoutModifierNode) node;
                                    intermediateLayoutModifierNode = it;
                                    layoutNode2 = layoutNode4;
                                    coordinates2 = coordinates4;
                                    i2 = i3;
                                } else {
                                    Modifier.Node this_$iv$iv$iv = node;
                                    if (((this_$iv$iv$iv.getKindSet() & m4400constructorimpl) != 0 ? i3 : 0) == 0 || !(node instanceof DelegatingNode)) {
                                        layoutNode2 = layoutNode4;
                                        coordinates2 = coordinates4;
                                        i2 = i3;
                                    } else {
                                        int count$iv$iv = 0;
                                        DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) node;
                                        Modifier.Node node$iv$iv$iv = this_$iv$iv$iv2.getDelegate();
                                        while (node$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv = node$iv$iv$iv;
                                            if (((next$iv$iv.getKindSet() & m4400constructorimpl) != 0 ? i3 : 0) == 0) {
                                                layoutNode3 = layoutNode4;
                                                coordinates3 = coordinates4;
                                            } else {
                                                count$iv$iv++;
                                                if (count$iv$iv == i3) {
                                                    node = next$iv$iv;
                                                    layoutNode3 = layoutNode4;
                                                    coordinates3 = coordinates4;
                                                } else {
                                                    if (mutableVector2 != null) {
                                                        layoutNode3 = layoutNode4;
                                                        coordinates3 = coordinates4;
                                                        mutableVector = mutableVector2;
                                                    } else {
                                                        layoutNode3 = layoutNode4;
                                                        coordinates3 = coordinates4;
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
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
                                            layoutNode4 = layoutNode3;
                                            coordinates4 = coordinates3;
                                            i3 = 1;
                                        }
                                        layoutNode2 = layoutNode4;
                                        coordinates2 = coordinates4;
                                        i2 = 1;
                                        if (count$iv$iv == 1) {
                                            i3 = 1;
                                            layoutNode4 = layoutNode2;
                                            coordinates4 = coordinates2;
                                        }
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                                i3 = i2;
                                layoutNode4 = layoutNode2;
                                coordinates4 = coordinates2;
                            }
                        }
                        node$iv$iv = node$iv$iv.getParent();
                        i3 = i3;
                        layoutNode4 = layoutNode4;
                        coordinates4 = coordinates4;
                    }
                    layoutNode = layoutNode4;
                    coordinates = coordinates4;
                    i = i3;
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                node$iv$iv = (layout$iv$iv == null || (nodes = layout$iv$iv.getNodes()) == null) ? null : nodes.getTail();
                i3 = i;
                layoutNode4 = layoutNode;
                coordinates4 = coordinates;
            }
            if (intermediateLayoutModifierNode == null || (lookaheadScopeImpl = intermediateLayoutModifierNode.localLookaheadScope) == null) {
                lookaheadScopeImpl = this.localLookaheadScope;
            }
            lookaheadScopeImpl2 = lookaheadScopeImpl;
        }
        this.closestLookaheadScope = lookaheadScopeImpl2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable $this$measure_3p2s80s_u24lambda_u241 = measurable.mo4186measureBRTryo0(constraints);
        return MeasureScope.layout$default(measure, $this$measure_3p2s80s_u24lambda_u241.getWidth(), $this$measure_3p2s80s_u24lambda_u241.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$measure$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* renamed from: intermediateMeasure-Te-uZzU, reason: not valid java name */
    public final MeasureResult m4188intermediateMeasureTeuZzU(MeasureScope intermediateMeasure, Measurable measurable, long constraints, long lookaheadSize, long lookaheadConstraints) {
        Intrinsics.checkNotNullParameter(intermediateMeasure, "$this$intermediateMeasure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        this.intermediateMeasureScope.m4190setLookaheadSizeozmzZPI(lookaheadSize);
        this.lookaheadConstraints = Constraints.m5162boximpl(lookaheadConstraints);
        IntermediateMeasurablePlaceable wrappedMeasurable = this.intermediateMeasurable;
        if (wrappedMeasurable == null) {
            wrappedMeasurable = new IntermediateMeasurablePlaceable(this, measurable);
        }
        IntermediateMeasurablePlaceable $this$intermediateMeasure_Te_uZzU_u24lambda_u242 = wrappedMeasurable;
        this.intermediateMeasurable = $this$intermediateMeasure_Te_uZzU_u24lambda_u242;
        $this$intermediateMeasure_Te_uZzU_u24lambda_u242.setWrappedMeasurable(measurable);
        return this.measureBlock.invoke(this.intermediateMeasureScope, wrappedMeasurable, Constraints.m5162boximpl(constraints));
    }

    public final int minIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope $this$minIntermediateIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntermediateIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo4191measure3p2s80s(MeasureScope minWidth, Measurable intrinsicMeasurable, long constraints) {
                Intrinsics.checkNotNullParameter(minWidth, "$this$minWidth");
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return IntermediateLayoutModifierNode.this.getMeasureBlock$ui_release().invoke(IntermediateLayoutModifierNode.this.intermediateMeasureScope, intrinsicMeasurable, Constraints.m5162boximpl(constraints));
            }
        }, $this$minIntermediateIntrinsicWidth, measurable, height);
    }

    public final int minIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope $this$minIntermediateIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntermediateIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo4191measure3p2s80s(MeasureScope minHeight, Measurable intrinsicMeasurable, long constraints) {
                Intrinsics.checkNotNullParameter(minHeight, "$this$minHeight");
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return IntermediateLayoutModifierNode.this.getMeasureBlock$ui_release().invoke(IntermediateLayoutModifierNode.this.intermediateMeasureScope, intrinsicMeasurable, Constraints.m5162boximpl(constraints));
            }
        }, $this$minIntermediateIntrinsicHeight, measurable, width);
    }

    public final int maxIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope $this$maxIntermediateIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntermediateIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$maxIntermediateIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo4191measure3p2s80s(MeasureScope maxWidth, Measurable intrinsicMeasurable, long constraints) {
                Intrinsics.checkNotNullParameter(maxWidth, "$this$maxWidth");
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return IntermediateLayoutModifierNode.this.getMeasureBlock$ui_release().invoke(IntermediateLayoutModifierNode.this.intermediateMeasureScope, intrinsicMeasurable, Constraints.m5162boximpl(constraints));
            }
        }, $this$maxIntermediateIntrinsicWidth, measurable, height);
    }

    public final int maxIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope $this$maxIntermediateIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntermediateIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$maxIntermediateIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult mo4191measure3p2s80s(MeasureScope maxHeight, Measurable intrinsicMeasurable, long constraints) {
                Intrinsics.checkNotNullParameter(maxHeight, "$this$maxHeight");
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
                return IntermediateLayoutModifierNode.this.getMeasureBlock$ui_release().invoke(IntermediateLayoutModifierNode.this.intermediateMeasureScope, intrinsicMeasurable, Constraints.m5162boximpl(constraints));
            }
        }, $this$maxIntermediateIntrinsicHeight, measurable, width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntermediateLayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J@\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"\u0018\u00010(¢\u0006\u0002\b*H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "wrappedMeasurable", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;Landroidx/compose/ui/layout/Measurable;)V", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWrappedMeasurable", "()Landroidx/compose/ui/layout/Measurable;", "setWrappedMeasurable", "(Landroidx/compose/ui/layout/Measurable;)V", "wrappedPlaceable", "getWrappedPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "setWrappedPlaceable", "(Landroidx/compose/ui/layout/Placeable;)V", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class IntermediateMeasurablePlaceable extends Placeable implements Measurable {
        final /* synthetic */ IntermediateLayoutModifierNode this$0;
        private Measurable wrappedMeasurable;
        private Placeable wrappedPlaceable;

        public IntermediateMeasurablePlaceable(IntermediateLayoutModifierNode this$0, Measurable wrappedMeasurable) {
            Intrinsics.checkNotNullParameter(wrappedMeasurable, "wrappedMeasurable");
            this.this$0 = this$0;
            this.wrappedMeasurable = wrappedMeasurable;
        }

        public final Measurable getWrappedMeasurable() {
            return this.wrappedMeasurable;
        }

        public final void setWrappedMeasurable(Measurable measurable) {
            Intrinsics.checkNotNullParameter(measurable, "<set-?>");
            this.wrappedMeasurable = measurable;
        }

        public final Placeable getWrappedPlaceable() {
            return this.wrappedPlaceable;
        }

        public final void setWrappedPlaceable(Placeable placeable) {
            this.wrappedPlaceable = placeable;
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo4186measureBRTryo0(long constraints) {
            Placeable it;
            long lookaheadSize;
            if (this.this$0.getIsIntermediateChangeActive()) {
                it = this.wrappedMeasurable.mo4186measureBRTryo0(constraints);
                m4242setMeasurementConstraintsBRTryo0(constraints);
                m4241setMeasuredSizeozmzZPI(IntSizeKt.IntSize(it.getWidth(), it.getHeight()));
            } else {
                Measurable measurable = this.wrappedMeasurable;
                Constraints constraints2 = this.this$0.lookaheadConstraints;
                Intrinsics.checkNotNull(constraints2);
                it = measurable.mo4186measureBRTryo0(constraints2.getValue());
                IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.this$0;
                Constraints constraints3 = intermediateLayoutModifierNode.lookaheadConstraints;
                Intrinsics.checkNotNull(constraints3);
                m4242setMeasurementConstraintsBRTryo0(constraints3.getValue());
                if (!intermediateLayoutModifierNode.getIsIntermediateChangeActive()) {
                    lookaheadSize = intermediateLayoutModifierNode.intermediateMeasureScope.getLookaheadSize();
                } else {
                    lookaheadSize = IntSizeKt.IntSize(it.getWidth(), it.getHeight());
                }
                m4241setMeasuredSizeozmzZPI(lookaheadSize);
            }
            this.wrappedPlaceable = it;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo4187placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            Unit unit;
            long offset = this.this$0.getIsIntermediateChangeActive() ? position : IntOffset.INSTANCE.m5346getZeronOccac();
            if (layerBlock != null) {
                Placeable placeable = this.wrappedPlaceable;
                if (placeable != null) {
                    Placeable.PlacementScope.INSTANCE.m4252placeWithLayeraW9wM(placeable, offset, zIndex, layerBlock);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            Placeable placeable2 = this.wrappedPlaceable;
            if (placeable2 != null) {
                Placeable.PlacementScope.INSTANCE.m4247place70tqf50(placeable2, offset, zIndex);
                Unit unit2 = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.wrappedMeasurable.getParentData();
        }

        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Placeable placeable = this.wrappedPlaceable;
            Intrinsics.checkNotNull(placeable);
            return placeable.get(alignmentLine);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            return this.wrappedMeasurable.minIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            return this.wrappedMeasurable.maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            return this.wrappedMeasurable.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            return this.wrappedMeasurable.maxIntrinsicHeight(width);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IntermediateLayoutModifierNode.kt */
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JE\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020$0'2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0016JD\u0010-\u001a\u00020.*\u00020.26\u0010-\u001a2\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u001100¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020+0/H\u0017J\f\u00104\u001a\u00020\u001d*\u00020\u001dH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\u00020\u0016X\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "()J", "setLookaheadSize-ozmzZPI", "(J)V", "J", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "onPlaced", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "layoutCoordinates", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class IntermediateMeasureScopeImpl implements IntermediateMeasureScope, CoroutineScope {
        private long lookaheadSize = IntSize.INSTANCE.m5383getZeroYbymL2g();

        public IntermediateMeasureScopeImpl() {
        }

        @Override // androidx.compose.ui.layout.IntermediateMeasureScope
        /* renamed from: getLookaheadSize-YbymL2g, reason: not valid java name and from getter */
        public long getLookaheadSize() {
            return this.lookaheadSize;
        }

        /* renamed from: setLookaheadSize-ozmzZPI, reason: not valid java name */
        public void m4190setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates $this$toLookaheadCoordinates) {
            Intrinsics.checkNotNullParameter($this$toLookaheadCoordinates, "<this>");
            LookaheadScope $this$toLookaheadCoordinates_u24lambda_u240 = IntermediateLayoutModifierNode.this.closestLookaheadScope;
            return $this$toLookaheadCoordinates_u24lambda_u240.toLookaheadCoordinates($this$toLookaheadCoordinates);
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope $this$lookaheadScopeCoordinates) {
            Intrinsics.checkNotNullParameter($this$lookaheadScopeCoordinates, "<this>");
            LookaheadScope $this$_get_lookaheadScopeCoordinates__u24lambda_u241 = IntermediateLayoutModifierNode.this.closestLookaheadScope;
            return $this$_get_lookaheadScopeCoordinates__u24lambda_u241.getLookaheadScopeCoordinates($this$lookaheadScopeCoordinates);
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        @Deprecated(message = "onPlaced in LookaheadLayoutScope has been deprecated. It's replaced with reading LookaheadLayoutCoordinates directly during placement inIntermediateMeasureScope")
        public Modifier onPlaced(Modifier $this$onPlaced, Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> onPlaced) {
            Intrinsics.checkNotNullParameter($this$onPlaced, "<this>");
            Intrinsics.checkNotNullParameter(onPlaced, "onPlaced");
            LookaheadScope $this$onPlaced_u24lambda_u242 = IntermediateLayoutModifierNode.this.closestLookaheadScope;
            return $this$onPlaced_u24lambda_u242.onPlaced($this$onPlaced, onPlaced);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            final IntermediateLayoutModifierNode intermediateLayoutModifierNode = IntermediateLayoutModifierNode.this;
            return new MeasureResult(width, height, alignmentLines, this, intermediateLayoutModifierNode, placementBlock) { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1
                final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
                final /* synthetic */ int $width;
                private final Map<AlignmentLine, Integer> alignmentLines;
                private final int height;
                final /* synthetic */ IntermediateLayoutModifierNode.IntermediateMeasureScopeImpl this$0;
                final /* synthetic */ IntermediateLayoutModifierNode this$1;
                private final int width;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$width = width;
                    this.this$0 = this;
                    this.this$1 = intermediateLayoutModifierNode;
                    this.$placementBlock = placementBlock;
                    this.width = width;
                    this.height = height;
                    this.alignmentLines = alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.INSTANCE;
                    int parentWidth$iv = this.$width;
                    LayoutDirection parentLayoutDirection$iv = this.this$0.getLayoutDirection();
                    LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = this.this$1.getCoordinator();
                    Function1 block$iv = this.$placementBlock;
                    LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
                    int previousParentWidth$iv = Placeable.PlacementScope.INSTANCE.getParentWidth();
                    LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.INSTANCE.getParentLayoutDirection();
                    LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
                    Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
                    Placeable.PlacementScope.parentWidth = parentWidth$iv;
                    Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.INSTANCE;
                    Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
                    boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
                    block$iv.invoke(this_$iv);
                    if (lookaheadCapablePlaceable$iv != null) {
                        lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
                    }
                    Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.INSTANCE;
                    Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
                    Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.INSTANCE;
                    Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
                    Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
                    Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
                }
            };
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return false;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getLayoutDirection();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getFontScale();
        }

        @Override // kotlinx.coroutines.CoroutineScope
        public CoroutineContext getCoroutineContext() {
            return IntermediateLayoutModifierNode.this.getCoroutineScope().getCoroutineContext();
        }
    }
}
