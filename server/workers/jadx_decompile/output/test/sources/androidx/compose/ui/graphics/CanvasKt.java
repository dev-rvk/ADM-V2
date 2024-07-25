package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Canvas.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010\n\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a,\u0010\f\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007\u001a\u001e\u0010\u000f\u001a\u00020\u0005*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0086\bø\u0001\u0000\u001a.\u0010\u0012\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Canvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "rotate", "", "degrees", "", "pivotX", "pivotY", "rotateRad", "radians", "scale", "sx", "sy", "withSave", "block", "Lkotlin/Function0;", "withSaveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final Canvas Canvas(ImageBitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return AndroidCanvas_androidKt.ActualCanvas(image);
    }

    public static final void withSave(Canvas $this$withSave, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter($this$withSave, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            $this$withSave.save();
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withSave.restore();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withSaveLayer(Canvas $this$withSaveLayer, Rect bounds, Paint paint, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter($this$withSaveLayer, "<this>");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            $this$withSaveLayer.saveLayer(bounds, paint);
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$withSaveLayer.restore();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void rotate(Canvas $this$rotate, float degrees, float pivotX, float pivotY) {
        Intrinsics.checkNotNullParameter($this$rotate, "<this>");
        if (degrees == 0.0f) {
            return;
        }
        $this$rotate.translate(pivotX, pivotY);
        $this$rotate.rotate(degrees);
        $this$rotate.translate(-pivotX, -pivotY);
    }

    public static /* synthetic */ void rotateRad$default(Canvas canvas, float f, float f2, float f3, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        rotateRad(canvas, f, f2, f3);
    }

    public static final void rotateRad(Canvas $this$rotateRad, float radians, float pivotX, float pivotY) {
        Intrinsics.checkNotNullParameter($this$rotateRad, "<this>");
        rotate($this$rotateRad, DegreesKt.degrees(radians), pivotX, pivotY);
    }

    public static /* synthetic */ void scale$default(Canvas canvas, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        scale(canvas, f, f2, f3, f4);
    }

    public static final void scale(Canvas $this$scale, float sx, float sy, float pivotX, float pivotY) {
        Intrinsics.checkNotNullParameter($this$scale, "<this>");
        if (sx == 1.0f) {
            if (sy == 1.0f) {
                return;
            }
        }
        $this$scale.translate(pivotX, pivotY);
        $this$scale.scale(sx, sy);
        $this$scale.translate(-pivotX, -pivotY);
    }
}
