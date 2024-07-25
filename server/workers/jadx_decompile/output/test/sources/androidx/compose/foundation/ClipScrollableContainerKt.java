package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipScrollableContainer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"HorizontalScrollableClipModifier", "Landroidx/compose/ui/Modifier;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "getMaxSupportedElevation", "()F", "F", "VerticalScrollableClipModifier", "clipScrollableContainer", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ClipScrollableContainerKt {
    private static final float MaxSupportedElevation = Dp.m5218constructorimpl(30);
    private static final Modifier HorizontalScrollableClipModifier = ClipKt.clip(Modifier.INSTANCE, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$HorizontalScrollableClipModifier$1
        @Override // androidx.compose.ui.graphics.Shape
        /* renamed from: createOutline-Pq9zytI, reason: not valid java name */
        public Outline mo212createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(density, "density");
            float inflateSize = density.mo323roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            return new Outline.Rectangle(new Rect(0.0f, -inflateSize, Size.m2779getWidthimpl(size), Size.m2776getHeightimpl(size) + inflateSize));
        }
    });
    private static final Modifier VerticalScrollableClipModifier = ClipKt.clip(Modifier.INSTANCE, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$VerticalScrollableClipModifier$1
        @Override // androidx.compose.ui.graphics.Shape
        /* renamed from: createOutline-Pq9zytI */
        public Outline mo212createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(density, "density");
            float inflateSize = density.mo323roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            return new Outline.Rectangle(new Rect(-inflateSize, 0.0f, Size.m2779getWidthimpl(size) + inflateSize, Size.m2776getHeightimpl(size)));
        }
    });

    public static final Modifier clipScrollableContainer(Modifier $this$clipScrollableContainer, Orientation orientation) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$clipScrollableContainer, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            modifier = VerticalScrollableClipModifier;
        } else {
            modifier = HorizontalScrollableClipModifier;
        }
        return $this$clipScrollableContainer.then(modifier);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }
}
