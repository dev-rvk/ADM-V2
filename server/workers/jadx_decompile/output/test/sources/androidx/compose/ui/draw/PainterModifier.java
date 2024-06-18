package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001d\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0019\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J)\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.ui.draw.PainterNode, reason: from toString */
/* loaded from: classes.dex */
final class PainterModifier extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public /* synthetic */ PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterModifier(Painter painter, boolean sizeToIntrinsics, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = sizeToIntrinsics;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = alpha;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        if (!this.sizeToIntrinsics) {
            return false;
        }
        long $this$isSpecified$iv = this.painter.getIntrinsicSize();
        return (($this$isSpecified$iv > Size.INSTANCE.m2787getUnspecifiedNHjbRc() ? 1 : ($this$isSpecified$iv == Size.INSTANCE.m2787getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? 1 : 0) != 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo241measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.mo4186measureBRTryo0(m2620modifyConstraintsZezNO4M(constraints));
        return MeasureScope.layout$default(measure, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (getUseIntrinsicSize()) {
            long constraints = m2620modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.minIntrinsicWidth(height);
            return Math.max(Constraints.m5176getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m2620modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
            int layoutWidth = measurable.maxIntrinsicWidth(height);
            return Math.max(Constraints.m5176getMinWidthimpl(constraints), layoutWidth);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m2620modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.minIntrinsicHeight(width);
            return Math.max(Constraints.m5175getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long constraints = m2620modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
            int layoutHeight = measurable.maxIntrinsicHeight(width);
            return Math.max(Constraints.m5175getMinHeightimpl(constraints), layoutHeight);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m2617calculateScaledSizeE7KxVPU(long dstSize) {
        float srcWidth;
        float srcHeight;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m2619hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            srcWidth = Size.m2779getWidthimpl(dstSize);
        } else {
            srcWidth = Size.m2779getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m2618hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            srcHeight = Size.m2776getHeightimpl(dstSize);
        } else {
            srcHeight = Size.m2776getHeightimpl(this.painter.getIntrinsicSize());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        if (!(Size.m2779getWidthimpl(dstSize) == 0.0f)) {
            if (!(Size.m2776getHeightimpl(dstSize) == 0.0f)) {
                return ScaleFactorKt.m4277timesUQTWf7w(srcSize, this.contentScale.mo4177computeScaleFactorH7hwNQA(srcSize, dstSize));
            }
        }
        return Size.INSTANCE.m2788getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m2620modifyConstraintsZezNO4M(long constraints) {
        int m5176getMinWidthimpl;
        int m5175getMinHeightimpl;
        long m5164copyZbe2FdA;
        long m5164copyZbe2FdA2;
        boolean hasBoundedDimens = Constraints.m5170getHasBoundedWidthimpl(constraints) && Constraints.m5169getHasBoundedHeightimpl(constraints);
        boolean hasFixedDimens = Constraints.m5172getHasFixedWidthimpl(constraints) && Constraints.m5171getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && hasBoundedDimens) || hasFixedDimens) {
            m5164copyZbe2FdA2 = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : Constraints.m5174getMaxWidthimpl(constraints), (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : Constraints.m5173getMaxHeightimpl(constraints), (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
            return m5164copyZbe2FdA2;
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m2619hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            m5176getMinWidthimpl = MathKt.roundToInt(Size.m2779getWidthimpl(intrinsicSize));
        } else {
            m5176getMinWidthimpl = Constraints.m5176getMinWidthimpl(constraints);
        }
        int intrinsicWidth = m5176getMinWidthimpl;
        if (m2618hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            m5175getMinHeightimpl = MathKt.roundToInt(Size.m2776getHeightimpl(intrinsicSize));
        } else {
            m5175getMinHeightimpl = Constraints.m5175getMinHeightimpl(constraints);
        }
        int intrinsicHeight = m5175getMinHeightimpl;
        int constrainedWidth = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, intrinsicWidth);
        int constrainedHeight = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, intrinsicHeight);
        long scaledSize = m2617calculateScaledSizeE7KxVPU(SizeKt.Size(constrainedWidth, constrainedHeight));
        int minWidth = ConstraintsKt.m5188constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m2779getWidthimpl(scaledSize)));
        int minHeight = ConstraintsKt.m5187constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m2776getHeightimpl(scaledSize)));
        m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : minWidth, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : minHeight, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        return m5164copyZbe2FdA;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) {
        float srcWidth;
        float srcHeight;
        long scaledSize;
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m2619hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            srcWidth = Size.m2779getWidthimpl(intrinsicSize);
        } else {
            srcWidth = Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc());
        }
        if (m2618hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            srcHeight = Size.m2776getHeightimpl(intrinsicSize);
        } else {
            srcHeight = Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc());
        }
        long srcSize = SizeKt.Size(srcWidth, srcHeight);
        if (!(Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc()) == 0.0f)) {
                scaledSize = ScaleFactorKt.m4277timesUQTWf7w(srcSize, this.contentScale.mo4177computeScaleFactorH7hwNQA(srcSize, $this$draw.mo3492getSizeNHjbRc()));
                long alignedPosition = this.alignment.mo2600alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2779getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m2776getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc())), MathKt.roundToInt(Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc()))), $this$draw.getLayoutDirection());
                float dx = IntOffset.m5336getXimpl(alignedPosition);
                float dy = IntOffset.m5337getYimpl(alignedPosition);
                ContentDrawScope $this$translate$iv = $this$draw;
                $this$translate$iv.getDrawContext().getTransform().translate(dx, dy);
                this.painter.m3567drawx_KDEd0($this$translate$iv, scaledSize, this.alpha, this.colorFilter);
                $this$translate$iv.getDrawContext().getTransform().translate(-dx, -dy);
                $this$draw.drawContent();
            }
        }
        scaledSize = Size.INSTANCE.m2788getZeroNHjbRc();
        long alignedPosition2 = this.alignment.mo2600alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2779getWidthimpl(scaledSize)), MathKt.roundToInt(Size.m2776getHeightimpl(scaledSize))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2779getWidthimpl($this$draw.mo3492getSizeNHjbRc())), MathKt.roundToInt(Size.m2776getHeightimpl($this$draw.mo3492getSizeNHjbRc()))), $this$draw.getLayoutDirection());
        float dx2 = IntOffset.m5336getXimpl(alignedPosition2);
        float dy2 = IntOffset.m5337getYimpl(alignedPosition2);
        ContentDrawScope $this$translate$iv2 = $this$draw;
        $this$translate$iv2.getDrawContext().getTransform().translate(dx2, dy2);
        this.painter.m3567drawx_KDEd0($this$translate$iv2, scaledSize, this.alpha, this.colorFilter);
        $this$translate$iv2.getDrawContext().getTransform().translate(-dx2, -dy2);
        $this$draw.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m2619hasSpecifiedAndFiniteWidthuvyYCjk(long $this$hasSpecifiedAndFiniteWidth_u2duvyYCjk) {
        if (Size.m2775equalsimpl0($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk, Size.INSTANCE.m2787getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2779getWidthimpl = Size.m2779getWidthimpl($this$hasSpecifiedAndFiniteWidth_u2duvyYCjk);
        return !Float.isInfinite(m2779getWidthimpl) && !Float.isNaN(m2779getWidthimpl);
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m2618hasSpecifiedAndFiniteHeightuvyYCjk(long $this$hasSpecifiedAndFiniteHeight_u2duvyYCjk) {
        if (Size.m2775equalsimpl0($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk, Size.INSTANCE.m2787getUnspecifiedNHjbRc())) {
            return false;
        }
        float m2776getHeightimpl = Size.m2776getHeightimpl($this$hasSpecifiedAndFiniteHeight_u2duvyYCjk);
        return !Float.isInfinite(m2776getHeightimpl) && !Float.isNaN(m2776getHeightimpl);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
