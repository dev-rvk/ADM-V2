package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J#\u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010)J#\u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010)J#\u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float aspectRatio, boolean matchHeightConstraintsFirst) {
        this.aspectRatio = aspectRatio;
        this.matchHeightConstraintsFirst = matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        long j;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long size = m412findSizeToXhtMw(constraints);
        if (!IntSize.m5376equalsimpl0(size, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m5182fixedJhjzzOo(IntSize.m5378getWidthimpl(size), IntSize.m5377getHeightimpl(size));
        } else {
            j = constraints;
        }
        long wrappedConstraints = j;
        final Placeable placeable = measurable.mo4186measureBRTryo0(wrappedConstraints);
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (height != Integer.MAX_VALUE) {
            return MathKt.roundToInt(height * this.aspectRatio);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (height != Integer.MAX_VALUE) {
            return MathKt.roundToInt(height * this.aspectRatio);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (width != Integer.MAX_VALUE) {
            return MathKt.roundToInt(width / this.aspectRatio);
        }
        return measurable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (width != Integer.MAX_VALUE) {
            return MathKt.roundToInt(width / this.aspectRatio);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m412findSizeToXhtMw(long $this$findSize_u2dToXhtMw) {
        if (this.matchHeightConstraintsFirst) {
            long it = m414tryMaxHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it;
            }
            long it2 = m416tryMaxWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it2, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it2;
            }
            long it3 = m418tryMinHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it3, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it3;
            }
            long it4 = m420tryMinWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it4, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it4;
            }
            long it5 = m413tryMaxHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it5, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it5;
            }
            long it6 = m415tryMaxWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it6, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it6;
            }
            long it7 = m417tryMinHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it7, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it7;
            }
            long it8 = m419tryMinWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it8, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it8;
            }
        } else {
            long it9 = m416tryMaxWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it9, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it9;
            }
            long it10 = m414tryMaxHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it10, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it10;
            }
            long it11 = m420tryMinWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it11, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it11;
            }
            long it12 = m418tryMinHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, null);
            if (!IntSize.m5376equalsimpl0(it12, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it12;
            }
            long it13 = m415tryMaxWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it13, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it13;
            }
            long it14 = m413tryMaxHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it14, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it14;
            }
            long it15 = m419tryMinWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it15, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it15;
            }
            long it16 = m417tryMinHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m5376equalsimpl0(it16, IntSize.INSTANCE.m5383getZeroYbymL2g())) {
                return it16;
            }
        }
        return IntSize.INSTANCE.m5383getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m416tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m415tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m415tryMaxWidthJN0ABg(long $this$tryMaxWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int height;
        int maxWidth = Constraints.m5174getMaxWidthimpl($this$tryMaxWidth_u2dJN_u2d0ABg);
        if (maxWidth != Integer.MAX_VALUE && (height = MathKt.roundToInt(maxWidth / this.aspectRatio)) > 0) {
            long size = IntSizeKt.IntSize(maxWidth, height);
            if (!enforceConstraints || ConstraintsKt.m5189isSatisfiedBy4WqzIAM($this$tryMaxWidth_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.INSTANCE.m5383getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m414tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m413tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m413tryMaxHeightJN0ABg(long $this$tryMaxHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int width;
        int maxHeight = Constraints.m5173getMaxHeightimpl($this$tryMaxHeight_u2dJN_u2d0ABg);
        if (maxHeight != Integer.MAX_VALUE && (width = MathKt.roundToInt(maxHeight * this.aspectRatio)) > 0) {
            long size = IntSizeKt.IntSize(width, maxHeight);
            if (!enforceConstraints || ConstraintsKt.m5189isSatisfiedBy4WqzIAM($this$tryMaxHeight_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.INSTANCE.m5383getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m420tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m419tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m419tryMinWidthJN0ABg(long $this$tryMinWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int minWidth = Constraints.m5176getMinWidthimpl($this$tryMinWidth_u2dJN_u2d0ABg);
        int height = MathKt.roundToInt(minWidth / this.aspectRatio);
        if (height > 0) {
            long size = IntSizeKt.IntSize(minWidth, height);
            if (!enforceConstraints || ConstraintsKt.m5189isSatisfiedBy4WqzIAM($this$tryMinWidth_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.INSTANCE.m5383getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m418tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m417tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m417tryMinHeightJN0ABg(long $this$tryMinHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int minHeight = Constraints.m5175getMinHeightimpl($this$tryMinHeight_u2dJN_u2d0ABg);
        int width = MathKt.roundToInt(minHeight * this.aspectRatio);
        if (width > 0) {
            long size = IntSizeKt.IntSize(width, minHeight);
            if (!enforceConstraints || ConstraintsKt.m5189isSatisfiedBy4WqzIAM($this$tryMinHeight_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.INSTANCE.m5383getZeroYbymL2g();
    }
}
