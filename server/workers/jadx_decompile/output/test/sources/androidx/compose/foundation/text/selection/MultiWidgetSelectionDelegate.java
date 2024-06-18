package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MultiWidgetSelectionDelegate.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b \u0010!J\n\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010#\u001a\u00020$H\u0016J_\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001a0&2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0018H\u0016ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b.\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "updateSelection", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "containerLayoutCoordinates", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "updateSelection-qCDeeow", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;)Lkotlin/Pair;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {
    private int _previousLastVisibleOffset;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiWidgetSelectionDelegate(long selectableId, Function0<? extends LayoutCoordinates> coordinatesCallback, Function0<TextLayoutResult> layoutResultCallback) {
        Intrinsics.checkNotNullParameter(coordinatesCallback, "coordinatesCallback");
        Intrinsics.checkNotNullParameter(layoutResultCallback, "layoutResultCallback");
        this.selectableId = selectableId;
        this.coordinatesCallback = coordinatesCallback;
        this.layoutResultCallback = layoutResultCallback;
        this._previousLastVisibleOffset = -1;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    private final synchronized int getLastVisibleOffset(TextLayoutResult $this$lastVisibleOffset) {
        int lastVisibleLine;
        int finalVisibleLine;
        if (this._previousTextLayoutResult != $this$lastVisibleOffset) {
            if ($this$lastVisibleOffset.getDidOverflowHeight() && !$this$lastVisibleOffset.getMultiParagraph().getDidExceedMaxLines()) {
                finalVisibleLine = RangesKt.coerceAtMost($this$lastVisibleOffset.getLineForVerticalPosition(IntSize.m5377getHeightimpl($this$lastVisibleOffset.getSize())), $this$lastVisibleOffset.getLineCount() - 1);
                while ($this$lastVisibleOffset.getLineTop(finalVisibleLine) >= IntSize.m5377getHeightimpl($this$lastVisibleOffset.getSize())) {
                    finalVisibleLine--;
                }
                this._previousLastVisibleOffset = $this$lastVisibleOffset.getLineEnd(finalVisibleLine, true);
                this._previousTextLayoutResult = $this$lastVisibleOffset;
            }
            int finalVisibleLine2 = $this$lastVisibleOffset.getLineCount();
            finalVisibleLine = finalVisibleLine2 - 1;
            this._previousLastVisibleOffset = $this$lastVisibleOffset.getLineEnd(finalVisibleLine, true);
            this._previousTextLayoutResult = $this$lastVisibleOffset;
        }
        lastVisibleLine = this._previousLastVisibleOffset;
        return lastVisibleLine;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: updateSelection-qCDeeow, reason: not valid java name */
    public Pair<Selection, Boolean> mo881updateSelectionqCDeeow(long startHandlePosition, long endHandlePosition, Offset previousHandlePosition, boolean isStartHandle, LayoutCoordinates containerLayoutCoordinates, SelectionAdjustment adjustment, Selection previousSelection) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(containerLayoutCoordinates, "containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        boolean z = false;
        if (previousSelection == null || (getSelectableId() == previousSelection.getStart().getSelectableId() && getSelectableId() == previousSelection.getEnd().getSelectableId())) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
        }
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        Offset offset = null;
        if (layoutCoordinates != null && (textLayoutResult = this.layoutResultCallback.invoke()) != null) {
            long relativePosition = containerLayoutCoordinates.mo4194localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m2726getZeroF1C5BW0());
            long localStartPosition = Offset.m2714minusMKHz9U(startHandlePosition, relativePosition);
            long localEndPosition = Offset.m2714minusMKHz9U(endHandlePosition, relativePosition);
            if (previousHandlePosition != null) {
                long it = previousHandlePosition.getPackedValue();
                offset = Offset.m2699boximpl(Offset.m2714minusMKHz9U(it, relativePosition));
            }
            Offset localPreviousHandlePosition = offset;
            return MultiWidgetSelectionDelegateKt.m885getTextSelectionInfoyM0VcXU(textLayoutResult, localStartPosition, localEndPosition, localPreviousHandlePosition, getSelectableId(), adjustment, previousSelection, isStartHandle);
        }
        return new Pair<>(null, false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection getSelectAllSelection() {
        Selection m883getAssembledSelectionInfovJH6DeI;
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return null;
        }
        long newSelectionRange = TextRangeKt.TextRange(0, textLayoutResult.getLayoutInput().getText().length());
        m883getAssembledSelectionInfovJH6DeI = MultiWidgetSelectionDelegateKt.m883getAssembledSelectionInfovJH6DeI(newSelectionRange, false, getSelectableId(), textLayoutResult);
        return m883getAssembledSelectionInfovJH6DeI;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo879getHandlePositiondBAh8RU(Selection selection, boolean isStartHandle) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(selection, "selection");
        if ((isStartHandle && selection.getStart().getSelectableId() != getSelectableId()) || (!isStartHandle && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.INSTANCE.m2726getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (textLayoutResult = this.layoutResultCallback.invoke()) != null) {
            int offset = (isStartHandle ? selection.getStart() : selection.getEnd()).getOffset();
            int coercedOffset = RangesKt.coerceIn(offset, 0, getLastVisibleOffset(textLayoutResult));
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResult, coercedOffset, isStartHandle, selection.getHandlesCrossed());
        }
        return Offset.INSTANCE.m2726getZeroF1C5BW0();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.coordinatesCallback.invoke();
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        return textLayoutResult == null ? new AnnotatedString("", null, null, 6, null) : textLayoutResult.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int offset) {
        int textLength;
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult != null && (textLength = textLayoutResult.getLayoutInput().getText().length()) >= 1) {
            return textLayoutResult.getBoundingBox(RangesKt.coerceIn(offset, 0, textLength - 1));
        }
        return Rect.INSTANCE.getZero();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo880getRangeOfLineContainingjx7JFs(int offset) {
        int visibleTextLength;
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult != null && (visibleTextLength = getLastVisibleOffset(textLayoutResult)) >= 1) {
            int line = textLayoutResult.getLineForOffset(RangesKt.coerceIn(offset, 0, visibleTextLength - 1));
            return TextRangeKt.TextRange(textLayoutResult.getLineStart(line), textLayoutResult.getLineEnd(line, true));
        }
        return TextRange.INSTANCE.m4731getZerod9O1mEE();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return 0;
        }
        return getLastVisibleOffset(textLayoutResult);
    }
}
