package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RectHelper.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0001¨\u0006\b"}, d2 = {"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/IntRect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeIntRect", "toComposeRect", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RectHelper_androidKt {
    @Deprecated(message = "Converting Rect to android.graphics.Rect is lossy, and requires rounding. The behavior of toAndroidRect() truncates to an integral Rect, but you should choose the method of rounding most suitable for your use case.", replaceWith = @ReplaceWith(expression = "android.graphics.Rect(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())", imports = {}))
    public static final Rect toAndroidRect(androidx.compose.ui.geometry.Rect $this$toAndroidRect) {
        Intrinsics.checkNotNullParameter($this$toAndroidRect, "<this>");
        return new Rect((int) $this$toAndroidRect.getLeft(), (int) $this$toAndroidRect.getTop(), (int) $this$toAndroidRect.getRight(), (int) $this$toAndroidRect.getBottom());
    }

    public static final RectF toAndroidRectF(androidx.compose.ui.geometry.Rect $this$toAndroidRectF) {
        Intrinsics.checkNotNullParameter($this$toAndroidRectF, "<this>");
        return new RectF($this$toAndroidRectF.getLeft(), $this$toAndroidRectF.getTop(), $this$toAndroidRectF.getRight(), $this$toAndroidRectF.getBottom());
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(Rect $this$toComposeRect) {
        Intrinsics.checkNotNullParameter($this$toComposeRect, "<this>");
        return new androidx.compose.ui.geometry.Rect($this$toComposeRect.left, $this$toComposeRect.top, $this$toComposeRect.right, $this$toComposeRect.bottom);
    }

    public static final Rect toAndroidRect(IntRect $this$toAndroidRect) {
        Intrinsics.checkNotNullParameter($this$toAndroidRect, "<this>");
        return new Rect($this$toAndroidRect.getLeft(), $this$toAndroidRect.getTop(), $this$toAndroidRect.getRight(), $this$toAndroidRect.getBottom());
    }

    public static final IntRect toComposeIntRect(Rect $this$toComposeIntRect) {
        Intrinsics.checkNotNullParameter($this$toComposeIntRect, "<this>");
        return new IntRect($this$toComposeIntRect.left, $this$toComposeIntRect.top, $this$toComposeIntRect.right, $this$toComposeIntRect.bottom);
    }
}
