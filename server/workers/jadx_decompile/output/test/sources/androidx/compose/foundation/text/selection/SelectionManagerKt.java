package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SelectionManager.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0000\u001a!\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0018H\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getCurrentSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "merge", "lhs", "rhs", "containsInclusive", "", "Landroidx/compose/ui/geometry/Rect;", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "visibleBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionManagerKt {

    /* compiled from: SelectionManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Selection merge(Selection lhs, Selection rhs) {
        Selection merge;
        return (lhs == null || (merge = lhs.merge(rhs)) == null) ? rhs : merge;
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager $manager, long $magnifierSize, Selection.AnchorInfo anchor, boolean isStartHandle) {
        LayoutCoordinates containerCoordinates;
        LayoutCoordinates selectableCoordinates;
        Selectable selectable = $manager.getAnchorSelectable$foundation_release(anchor);
        if (selectable != null && (containerCoordinates = $manager.getContainerLayoutCoordinates()) != null && (selectableCoordinates = selectable.getLayoutCoordinates()) != null) {
            int offset = anchor.getOffset();
            if (!isStartHandle) {
                offset--;
            }
            if (offset > selectable.getLastVisibleOffset()) {
                return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
            }
            Offset m919getCurrentDragPosition_m7T9E = $manager.m919getCurrentDragPosition_m7T9E();
            Intrinsics.checkNotNull(m919getCurrentDragPosition_m7T9E);
            long localDragPosition = selectableCoordinates.mo4194localPositionOfR5De75A(containerCoordinates, m919getCurrentDragPosition_m7T9E.getPackedValue());
            float dragX = Offset.m2710getXimpl(localDragPosition);
            long line = selectable.mo880getRangeOfLineContainingjx7JFs(offset);
            Rect lineMin = selectable.getBoundingBox(TextRange.m4724getMinimpl(line));
            Rect lineMax = selectable.getBoundingBox(RangesKt.coerceAtLeast(TextRange.m4723getMaximpl(line) - 1, TextRange.m4724getMinimpl(line)));
            float minX = Math.min(lineMin.getLeft(), lineMax.getLeft());
            float maxX = RangesKt.coerceIn(dragX, minX, Math.max(lineMin.getRight(), lineMax.getRight()));
            if (Math.abs(dragX - maxX) > IntSize.m5378getWidthimpl($magnifierSize) / 2) {
                return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
            }
            Rect anchorBounds = selectable.getBoundingBox(offset);
            float centerY = Offset.m2711getYimpl(anchorBounds.m2740getCenterF1C5BW0());
            return containerCoordinates.mo4194localPositionOfR5De75A(selectableCoordinates, OffsetKt.Offset(maxX, centerY));
        }
        return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m930calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager manager, long magnifierSize) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Selection selection = manager.getSelection();
        if (selection == null) {
            return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
            case -1:
                return Offset.INSTANCE.m2725getUnspecifiedF1C5BW0();
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, magnifierSize, selection.getStart(), true);
            case 2:
                return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, magnifierSize, selection.getEnd(), false);
            case 3:
                throw new IllegalStateException("SelectionContainer does not support cursor".toString());
        }
    }

    public static final AnnotatedString getCurrentSelectedText(Selectable selectable, Selection selection) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selection, "selection");
        AnnotatedString currentText = selectable.getText();
        if (selectable.getSelectableId() != selection.getStart().getSelectableId() && selectable.getSelectableId() != selection.getEnd().getSelectableId()) {
            return currentText;
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return currentText.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
            }
            return currentText.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return currentText.subSequence(0, selection.getStart().getOffset());
            }
            return currentText.subSequence(selection.getStart().getOffset(), currentText.length());
        }
        if (selection.getHandlesCrossed()) {
            return currentText.subSequence(selection.getEnd().getOffset(), currentText.length());
        }
        return currentText.subSequence(0, selection.getEnd().getOffset());
    }

    public static final Rect visibleBounds(LayoutCoordinates $this$visibleBounds) {
        Intrinsics.checkNotNullParameter($this$visibleBounds, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow($this$visibleBounds);
        return RectKt.m2748Rect0a9Yr6o($this$visibleBounds.mo4198windowToLocalMKHz9U(boundsInWindow.m2745getTopLeftF1C5BW0()), $this$visibleBounds.mo4198windowToLocalMKHz9U(boundsInWindow.m2739getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m931containsInclusiveUv8p0NA(Rect containsInclusive, long offset) {
        Intrinsics.checkNotNullParameter(containsInclusive, "$this$containsInclusive");
        float left = containsInclusive.getLeft();
        float right = containsInclusive.getRight();
        float m2710getXimpl = Offset.m2710getXimpl(offset);
        if (left <= m2710getXimpl && m2710getXimpl <= right) {
            float top = containsInclusive.getTop();
            float bottom = containsInclusive.getBottom();
            float m2711getYimpl = Offset.m2711getYimpl(offset);
            if (top <= m2711getYimpl && m2711getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }
}
