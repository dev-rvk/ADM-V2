package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawTransform.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003H\u0086\b\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0086\b\u001a,\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "horizontal", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", "scale", "scale-0AR0LA0", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawTransformKt {
    public static /* synthetic */ void inset$default(DrawTransform $this$inset_u24default, float horizontal, float vertical, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = 0.0f;
        }
        if ((i & 2) != 0) {
            vertical = 0.0f;
        }
        Intrinsics.checkNotNullParameter($this$inset_u24default, "<this>");
        $this$inset_u24default.inset(horizontal, vertical, horizontal, vertical);
    }

    public static final void inset(DrawTransform $this$inset, float horizontal, float vertical) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        $this$inset.inset(horizontal, vertical, horizontal, vertical);
    }

    public static final void inset(DrawTransform $this$inset, float inset) {
        Intrinsics.checkNotNullParameter($this$inset, "<this>");
        $this$inset.inset(inset, inset, inset, inset);
    }

    /* renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m3552rotateRad0AR0LA0$default(DrawTransform rotateRad, float radians, long pivot, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = rotateRad.mo3421getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(rotateRad, "$this$rotateRad");
        rotateRad.mo3423rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
    }

    /* renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m3551rotateRad0AR0LA0(DrawTransform rotateRad, float radians, long pivot) {
        Intrinsics.checkNotNullParameter(rotateRad, "$this$rotateRad");
        rotateRad.mo3423rotateUv8p0NA(DegreesKt.degrees(radians), pivot);
    }

    /* renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m3554scale0AR0LA0$default(DrawTransform scale, float scale2, long pivot, int i, Object obj) {
        if ((i & 2) != 0) {
            pivot = scale.mo3421getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        scale.mo3424scale0AR0LA0(scale2, scale2, pivot);
    }

    /* renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m3553scale0AR0LA0(DrawTransform scale, float scale2, long pivot) {
        Intrinsics.checkNotNullParameter(scale, "$this$scale");
        scale.mo3424scale0AR0LA0(scale2, scale2, pivot);
    }
}
