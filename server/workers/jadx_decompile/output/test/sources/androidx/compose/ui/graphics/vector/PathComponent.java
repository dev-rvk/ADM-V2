package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010P\u001a\u00020\u0014H\u0016J\b\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020RH\u0002J\f\u0010T\u001a\u00020R*\u00020UH\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R/\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020#@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u000e\u00100\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u00101\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR$\u00104\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR/\u00108\u001a\u0002072\u0006\u0010\u0003\u001a\u000207@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R/\u0010<\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020;@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R$\u0010?\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\r\"\u0004\bA\u0010\u000fR$\u0010B\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010G\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000fR$\u0010J\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR$\u0010M\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006V"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "value", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "", HintConstants.AUTOFILL_HINT_NAME, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "path", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "renderPath", "stroke", "getStroke", "setStroke", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "toString", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PathComponent extends VNode {
    private Brush fill;
    private float fillAlpha;
    private boolean isPathDirty;
    private boolean isStrokeDirty;
    private boolean isTrimPathDirty;
    private String name;
    private final Path path;
    private List<? extends PathNode> pathData;
    private int pathFillType;

    /* renamed from: pathMeasure$delegate, reason: from kotlin metadata */
    private final Lazy pathMeasure;
    private Path renderPath;
    private Brush stroke;
    private float strokeAlpha;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter;
    private float strokeLineWidth;
    private Stroke strokeStyle;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    public PathComponent() {
        super(null);
        this.name = "";
        this.fillAlpha = 1.0f;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        this.path = AndroidPath_androidKt.Path();
        this.renderPath = this.path;
        this.pathMeasure = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<PathMeasure>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PathMeasure invoke() {
                return AndroidPathMeasure_androidKt.PathMeasure();
            }
        });
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = value;
        invalidate();
    }

    public final Brush getFill() {
        return this.fill;
    }

    public final void setFill(Brush value) {
        this.fill = value;
        invalidate();
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    public final void setFillAlpha(float value) {
        this.fillAlpha = value;
        invalidate();
    }

    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    public final void setPathData(List<? extends PathNode> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pathData = value;
        this.isPathDirty = true;
        invalidate();
    }

    /* renamed from: getPathFillType-Rg-k1Os, reason: not valid java name and from getter */
    public final int getPathFillType() {
        return this.pathFillType;
    }

    /* renamed from: setPathFillType-oQ8Xj4U, reason: not valid java name */
    public final void m3580setPathFillTypeoQ8Xj4U(int value) {
        this.pathFillType = value;
        this.renderPath.mo2844setFillTypeoQ8Xj4U(value);
        invalidate();
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public final void setStrokeAlpha(float value) {
        this.strokeAlpha = value;
        invalidate();
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final void setStrokeLineWidth(float value) {
        this.strokeLineWidth = value;
        invalidate();
    }

    public final Brush getStroke() {
        return this.stroke;
    }

    public final void setStroke(Brush value) {
        this.stroke = value;
        invalidate();
    }

    /* renamed from: getStrokeLineCap-KaPHkGw, reason: not valid java name and from getter */
    public final int getStrokeLineCap() {
        return this.strokeLineCap;
    }

    /* renamed from: setStrokeLineCap-BeK7IIE, reason: not valid java name */
    public final void m3581setStrokeLineCapBeK7IIE(int value) {
        this.strokeLineCap = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name and from getter */
    public final int getStrokeLineJoin() {
        return this.strokeLineJoin;
    }

    /* renamed from: setStrokeLineJoin-Ww9F2mQ, reason: not valid java name */
    public final void m3582setStrokeLineJoinWw9F2mQ(int value) {
        this.strokeLineJoin = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final void setStrokeLineMiter(float value) {
        this.strokeLineMiter = value;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public final void setTrimPathStart(float value) {
        if (!(this.trimPathStart == value)) {
            this.trimPathStart = value;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final void setTrimPathEnd(float value) {
        if (!(this.trimPathEnd == value)) {
            this.trimPathEnd = value;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final void setTrimPathOffset(float value) {
        if (!(this.trimPathOffset == value)) {
            this.trimPathOffset = value;
            this.isTrimPathDirty = true;
            invalidate();
        }
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure) this.pathMeasure.getValue();
    }

    private final void updatePath() {
        PathParserKt.toPath(this.pathData, this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        if (this.trimPathStart == 0.0f) {
            if (this.trimPathEnd == 1.0f) {
                this.renderPath = this.path;
                return;
            }
        }
        if (Intrinsics.areEqual(this.renderPath, this.path)) {
            this.renderPath = AndroidPath_androidKt.Path();
        } else {
            int fillType = this.renderPath.mo2842getFillTypeRgk1Os();
            this.renderPath.rewind();
            this.renderPath.mo2844setFillTypeoQ8Xj4U(fillType);
        }
        getPathMeasure().setPath(this.path, false);
        float length = getPathMeasure().getLength();
        float start = ((this.trimPathStart + this.trimPathOffset) % 1.0f) * length;
        float end = ((this.trimPathEnd + this.trimPathOffset) % 1.0f) * length;
        if (start > end) {
            getPathMeasure().getSegment(start, length, this.renderPath, true);
            getPathMeasure().getSegment(0.0f, end, this.renderPath, true);
        } else {
            getPathMeasure().getSegment(start, end, this.renderPath, true);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope $this$draw) {
        Stroke targetStroke;
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        if (this.isPathDirty) {
            updatePath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush it = this.fill;
        if (it != null) {
            DrawScope.m3482drawPathGBMwjPU$default($this$draw, this.renderPath, it, this.fillAlpha, null, null, 0, 56, null);
        }
        Brush it2 = this.stroke;
        if (it2 != null) {
            Stroke targetStroke2 = this.strokeStyle;
            if (this.isStrokeDirty || targetStroke2 == null) {
                Stroke targetStroke3 = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, null, 16, null);
                this.strokeStyle = targetStroke3;
                this.isStrokeDirty = false;
                targetStroke = targetStroke3;
            } else {
                targetStroke = targetStroke2;
            }
            DrawScope.m3482drawPathGBMwjPU$default($this$draw, this.renderPath, it2, this.strokeAlpha, targetStroke, null, 0, 48, null);
        }
    }

    public String toString() {
        return this.path.toString();
    }
}
