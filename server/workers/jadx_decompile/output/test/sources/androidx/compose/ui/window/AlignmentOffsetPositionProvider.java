package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Popup.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J5\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, j);
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long offset) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.alignment = alignment;
        this.offset = offset;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo878calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        long popupPosition = IntOffsetKt.IntOffset(0, 0);
        long parentAlignmentPoint = this.alignment.mo2600alignKFBX0sM(IntSize.INSTANCE.m5383getZeroYbymL2g(), IntSizeKt.IntSize(anchorBounds.getWidth(), anchorBounds.getHeight()), layoutDirection);
        long relativePopupPos = this.alignment.mo2600alignKFBX0sM(IntSize.INSTANCE.m5383getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m5378getWidthimpl(popupContentSize), IntSize.m5377getHeightimpl(popupContentSize)), layoutDirection);
        long other$iv = IntOffsetKt.IntOffset(anchorBounds.getLeft(), anchorBounds.getTop());
        long other$iv2 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(popupPosition) + IntOffset.m5336getXimpl(other$iv), IntOffset.m5337getYimpl(popupPosition) + IntOffset.m5337getYimpl(other$iv));
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(other$iv2) + IntOffset.m5336getXimpl(parentAlignmentPoint), IntOffset.m5337getYimpl(other$iv2) + IntOffset.m5337getYimpl(parentAlignmentPoint));
        long other$iv3 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(relativePopupPos), IntOffset.m5337getYimpl(relativePopupPos));
        long other$iv4 = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(IntOffset) - IntOffset.m5336getXimpl(other$iv3), IntOffset.m5337getYimpl(IntOffset) - IntOffset.m5337getYimpl(other$iv3));
        long resolvedOffset = IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m5337getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m5336getXimpl(other$iv4) + IntOffset.m5336getXimpl(resolvedOffset), IntOffset.m5337getYimpl(other$iv4) + IntOffset.m5337getYimpl(resolvedOffset));
    }
}
