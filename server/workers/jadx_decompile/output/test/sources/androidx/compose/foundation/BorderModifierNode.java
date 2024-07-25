package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Border.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JI\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    private BorderModifierNode(float widthParameter, Brush brushParameter, Shape shapeParameter) {
        Intrinsics.checkNotNullParameter(brushParameter, "brushParameter");
        Intrinsics.checkNotNullParameter(shapeParameter, "shapeParameter");
        this.width = widthParameter;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope CacheDrawModifierNode) {
                DrawResult m177drawRectBorderNsqcLGU;
                DrawResult m180drawRoundRectBorderJqoCqck;
                DrawResult drawGenericBorder;
                DrawResult drawContentWithoutBorder;
                Intrinsics.checkNotNullParameter(CacheDrawModifierNode, "$this$CacheDrawModifierNode");
                boolean hasValidBorderParams = CacheDrawModifierNode.mo329toPx0680j_4(BorderModifierNode.this.getWidth()) >= 0.0f && Size.m2778getMinDimensionimpl(CacheDrawModifierNode.m2616getSizeNHjbRc()) > 0.0f;
                if (!hasValidBorderParams) {
                    drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(CacheDrawModifierNode);
                    return drawContentWithoutBorder;
                }
                float f = 2;
                float strokeWidthPx = Math.min(Dp.m5223equalsimpl0(BorderModifierNode.this.getWidth(), Dp.INSTANCE.m5236getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(CacheDrawModifierNode.mo329toPx0680j_4(BorderModifierNode.this.getWidth())), (float) Math.ceil(Size.m2778getMinDimensionimpl(CacheDrawModifierNode.m2616getSizeNHjbRc()) / f));
                float halfStroke = strokeWidthPx / f;
                long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
                long borderSize = SizeKt.Size(Size.m2779getWidthimpl(CacheDrawModifierNode.m2616getSizeNHjbRc()) - strokeWidthPx, Size.m2776getHeightimpl(CacheDrawModifierNode.m2616getSizeNHjbRc()) - strokeWidthPx);
                boolean fillArea = f * strokeWidthPx > Size.m2778getMinDimensionimpl(CacheDrawModifierNode.m2616getSizeNHjbRc());
                Outline outline = BorderModifierNode.this.getShape().mo212createOutlinePq9zytI(CacheDrawModifierNode.m2616getSizeNHjbRc(), CacheDrawModifierNode.getLayoutDirection(), CacheDrawModifierNode);
                if (outline instanceof Outline.Generic) {
                    drawGenericBorder = BorderModifierNode.this.drawGenericBorder(CacheDrawModifierNode, BorderModifierNode.this.getBrush(), (Outline.Generic) outline, fillArea, strokeWidthPx);
                    return drawGenericBorder;
                }
                if (outline instanceof Outline.Rounded) {
                    m180drawRoundRectBorderJqoCqck = BorderModifierNode.this.m180drawRoundRectBorderJqoCqck(CacheDrawModifierNode, BorderModifierNode.this.getBrush(), (Outline.Rounded) outline, topLeft, borderSize, fillArea, strokeWidthPx);
                    return m180drawRoundRectBorderJqoCqck;
                }
                if (outline instanceof Outline.Rectangle) {
                    m177drawRectBorderNsqcLGU = BorderKt.m177drawRectBorderNsqcLGU(CacheDrawModifierNode, BorderModifierNode.this.getBrush(), topLeft, borderSize, fillArea, strokeWidthPx);
                    return m177drawRectBorderNsqcLGU;
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4, reason: not valid java name */
    public final void m182setWidth0680j_4(float value) {
        if (!Dp.m5223equalsimpl0(this.width, value)) {
            this.width = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.brush, value)) {
            this.brush = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.shape, value)) {
            this.shape = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ed, code lost:
    
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m3160equalsimpl(r13, r2 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.m3158boximpl(r2.mo2818getConfig_sVssgQ()) : null) != false) goto L26;
     */
    /* JADX WARN: Type inference failed for: r38v2, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r64, final androidx.compose.ui.graphics.Brush r65, final androidx.compose.ui.graphics.Outline.Generic r66, boolean r67, float r68) {
        /*
            Method dump skipped, instructions count: 806
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck, reason: not valid java name */
    public final DrawResult m180drawRoundRectBorderJqoCqck(CacheDrawScope $this$drawRoundRectBorder_u2dJqoCqck, final Brush brush, Outline.Rounded outline, final long topLeft, final long borderSize, final boolean fillArea, final float strokeWidth) {
        final Path roundedRectPath;
        if (RoundRectKt.isSimple(outline.getRoundRect())) {
            final long cornerRadius = outline.getRoundRect().m2760getTopLeftCornerRadiuskKHJgLs();
            final float halfStroke = strokeWidth / 2;
            final Stroke borderStroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
            return $this$drawRoundRectBorder_u2dJqoCqck.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope onDrawWithContent) {
                    long m178shrinkKibmq7A;
                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    if (fillArea) {
                        DrawScope.m3488drawRoundRectZuiqVtQ$default(onDrawWithContent, brush, 0L, 0L, cornerRadius, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    if (CornerRadius.m2685getXimpl(cornerRadius) < halfStroke) {
                        ContentDrawScope $this$clipRect_u2drOu3jXo$iv = onDrawWithContent;
                        float left$iv = strokeWidth;
                        float top$iv = strokeWidth;
                        float right$iv = Size.m2779getWidthimpl(onDrawWithContent.mo3492getSizeNHjbRc()) - strokeWidth;
                        float bottom$iv = Size.m2776getHeightimpl(onDrawWithContent.mo3492getSizeNHjbRc()) - strokeWidth;
                        int clipOp$iv = ClipOp.INSTANCE.m2937getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j = cornerRadius;
                        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo$iv.getDrawContext();
                        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                        DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                        $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo3420clipRectN_I0leg(left$iv, top$iv, right$iv, bottom$iv, clipOp$iv);
                        DrawScope.m3488drawRoundRectZuiqVtQ$default($this$clipRect_u2drOu3jXo$iv, brush2, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
                        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                        $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
                        return;
                    }
                    Brush brush3 = brush;
                    long j2 = topLeft;
                    long j3 = borderSize;
                    m178shrinkKibmq7A = BorderKt.m178shrinkKibmq7A(cornerRadius, halfStroke);
                    DrawScope.m3488drawRoundRectZuiqVtQ$default(onDrawWithContent, brush3, j2, j3, m178shrinkKibmq7A, 0.0f, borderStroke, null, 0, 208, null);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        Path path = borderCache.obtainPath();
        roundedRectPath = BorderKt.createRoundRectPath(path, outline.getRoundRect(), strokeWidth, fillArea);
        return $this$drawRoundRectBorder_u2dJqoCqck.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                DrawScope.m3482drawPathGBMwjPU$default(onDrawWithContent, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}
