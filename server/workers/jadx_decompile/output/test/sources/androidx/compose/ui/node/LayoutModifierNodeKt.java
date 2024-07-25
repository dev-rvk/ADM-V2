package androidx.compose.ui.node;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNode.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0007"}, d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateMeasurement", "invalidatePlacement", "remeasureSync", "requestRemeasure", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutModifierNodeKt {
    public static final void remeasureSync(LayoutModifierNode $this$remeasureSync) {
        Intrinsics.checkNotNullParameter($this$remeasureSync, "<this>");
        DelegatableNodeKt.requireLayoutNode($this$remeasureSync).forceRemeasure();
    }

    public static final void invalidateLayer(LayoutModifierNode $this$invalidateLayer) {
        Intrinsics.checkNotNullParameter($this$invalidateLayer, "<this>");
        DelegatableNodeKt.m4299requireCoordinator64DMado($this$invalidateLayer, NodeKind.m4400constructorimpl(2)).invalidateLayer();
    }

    public static final void invalidatePlacement(LayoutModifierNode $this$invalidatePlacement) {
        Intrinsics.checkNotNullParameter($this$invalidatePlacement, "<this>");
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$invalidatePlacement), false, 1, null);
    }

    public static final void invalidateMeasurement(LayoutModifierNode $this$invalidateMeasurement) {
        Intrinsics.checkNotNullParameter($this$invalidateMeasurement, "<this>");
        DelegatableNodeKt.requireLayoutNode($this$invalidateMeasurement).invalidateMeasurements$ui_release();
    }

    public static final void requestRemeasure(LayoutModifierNode $this$requestRemeasure) {
        Intrinsics.checkNotNullParameter($this$requestRemeasure, "<this>");
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$requestRemeasure), false, false, 3, null);
    }
}
