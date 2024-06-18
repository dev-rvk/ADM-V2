package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemGestureExclusion.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\rR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/ExcludeFromSystemGestureNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;)V", "getExclusion", "()Lkotlin/jvm/functions/Function1;", "setExclusion", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "calcBounds", "layoutCoordinates", "findRoot", "onDetach", "", "onGloballyPositioned", "coordinates", "replaceRect", "newRect", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExcludeFromSystemGestureNode extends Modifier.Node implements GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {
    private Function1<? super LayoutCoordinates, Rect> exclusion;
    private android.graphics.Rect rect;

    public final Function1<LayoutCoordinates, Rect> getExclusion() {
        return this.exclusion;
    }

    public final void setExclusion(Function1<? super LayoutCoordinates, Rect> function1) {
        this.exclusion = function1;
    }

    public ExcludeFromSystemGestureNode(Function1<? super LayoutCoordinates, Rect> function1) {
        this.exclusion = function1;
    }

    public final android.graphics.Rect getRect() {
        return this.rect;
    }

    public final void setRect(android.graphics.Rect rect) {
        this.rect = rect;
    }

    private final View getView() {
        return (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AndroidCompositionLocals_androidKt.getLocalView());
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        android.graphics.Rect calcBounds;
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (this.exclusion == null) {
            Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot(coordinates);
            calcBounds = new android.graphics.Rect(MathKt.roundToInt(boundsInRoot.getLeft()), MathKt.roundToInt(boundsInRoot.getTop()), MathKt.roundToInt(boundsInRoot.getRight()), MathKt.roundToInt(boundsInRoot.getBottom()));
        } else {
            Function1<? super LayoutCoordinates, Rect> function1 = this.exclusion;
            Intrinsics.checkNotNull(function1);
            calcBounds = calcBounds(coordinates, function1.invoke(coordinates));
        }
        android.graphics.Rect newRect = calcBounds;
        replaceRect(newRect);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        replaceRect(null);
    }

    public final void replaceRect(android.graphics.Rect newRect) {
        boolean z = false;
        MutableVector rects = new MutableVector(new android.graphics.Rect[16], 0);
        List elements$iv = getView().getSystemGestureExclusionRects();
        Intrinsics.checkNotNullExpressionValue(elements$iv, "view.systemGestureExclusionRects");
        rects.addAll(rects.getSize(), elements$iv);
        android.graphics.Rect it = this.rect;
        if (it != null) {
            rects.remove(it);
        }
        if (newRect != null && !newRect.isEmpty()) {
            z = true;
        }
        if (z) {
            rects.add(newRect);
        }
        getView().setSystemGestureExclusionRects(rects.asMutableList());
        this.rect = newRect;
    }

    private final android.graphics.Rect calcBounds(LayoutCoordinates layoutCoordinates, Rect rect) {
        LayoutCoordinates root = findRoot(layoutCoordinates);
        long topLeft = root.mo4194localPositionOfR5De75A(layoutCoordinates, rect.m2745getTopLeftF1C5BW0());
        long topRight = root.mo4194localPositionOfR5De75A(layoutCoordinates, rect.m2746getTopRightF1C5BW0());
        long bottomLeft = root.mo4194localPositionOfR5De75A(layoutCoordinates, rect.m2738getBottomLeftF1C5BW0());
        long bottomRight = root.mo4194localPositionOfR5De75A(layoutCoordinates, rect.m2739getBottomRightF1C5BW0());
        float left = ComparisonsKt.minOf(Offset.m2710getXimpl(topLeft), Offset.m2710getXimpl(topRight), Offset.m2710getXimpl(bottomLeft), Offset.m2710getXimpl(bottomRight));
        float top = ComparisonsKt.minOf(Offset.m2711getYimpl(topLeft), Offset.m2711getYimpl(topRight), Offset.m2711getYimpl(bottomLeft), Offset.m2711getYimpl(bottomRight));
        float right = ComparisonsKt.maxOf(Offset.m2710getXimpl(topLeft), Offset.m2710getXimpl(topRight), Offset.m2710getXimpl(bottomLeft), Offset.m2710getXimpl(bottomRight));
        float bottom = ComparisonsKt.maxOf(Offset.m2711getYimpl(topLeft), Offset.m2711getYimpl(topRight), Offset.m2711getYimpl(bottomLeft), Offset.m2711getYimpl(bottomRight));
        return new android.graphics.Rect(MathKt.roundToInt(left), MathKt.roundToInt(top), MathKt.roundToInt(right), MathKt.roundToInt(bottom));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates coordinates = layoutCoordinates;
        LayoutCoordinates parent = layoutCoordinates.getParentLayoutCoordinates();
        while (parent != null) {
            coordinates = parent;
            parent = coordinates.getParentLayoutCoordinates();
        }
        return coordinates;
    }
}
