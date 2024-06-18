package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewResponder.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "completelyOverlaps", "", "Landroidx/compose/ui/geometry/Rect;", "other", "localRectOf", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BringIntoViewResponderKt {
    public static final /* synthetic */ Rect access$localRectOf(LayoutCoordinates $receiver, LayoutCoordinates sourceCoordinates, Rect rect) {
        return localRectOf($receiver, sourceCoordinates, rect);
    }

    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, BringIntoViewResponder responder) {
        Intrinsics.checkNotNullParameter($this$bringIntoViewResponder, "<this>");
        Intrinsics.checkNotNullParameter(responder, "responder");
        return $this$bringIntoViewResponder.then(new BringIntoViewResponderElement(responder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf(LayoutCoordinates $this$localRectOf, LayoutCoordinates sourceCoordinates, Rect rect) {
        Rect localRect = $this$localRectOf.localBoundingBoxOf(sourceCoordinates, false);
        return rect.m2747translatek4lQ0M(localRect.m2745getTopLeftF1C5BW0());
    }

    private static final boolean completelyOverlaps(Rect $this$completelyOverlaps, Rect other) {
        return $this$completelyOverlaps.getLeft() <= other.getLeft() && $this$completelyOverlaps.getTop() <= other.getTop() && $this$completelyOverlaps.getRight() >= other.getRight() && $this$completelyOverlaps.getBottom() >= other.getBottom();
    }
}
