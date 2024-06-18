package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextPointerIcon_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionController.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a+\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"makeSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isInTouchMode", "", "outOfBoundary", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "outOfBoundary-2x9bVx0", "(Landroidx/compose/ui/text/TextLayoutResult;JJ)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SelectionControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1, java.lang.Object] */
    public static final Modifier makeSelectionModifier(final SelectionRegistrar $this$makeSelectionModifier, final long selectableId, final Function0<? extends LayoutCoordinates> function0, final Function0<TextLayoutResult> function02, boolean isInTouchMode) {
        if (isInTouchMode) {
            ?? r7 = new TextDragObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1
                private long lastPosition = Offset.INSTANCE.m2726getZeroF1C5BW0();
                private long dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                public final void setLastPosition(long j) {
                    this.lastPosition = j;
                }

                public final long getDragTotalDistance() {
                    return this.dragTotalDistance;
                }

                public final void setDragTotalDistance(long j) {
                    this.dragTotalDistance = j;
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDown-k-4lQ0M */
                public void mo805onDownk4lQ0M(long point) {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onUp() {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onStart-k-4lQ0M */
                public void mo807onStartk4lQ0M(long startPoint) {
                    boolean m865outOfBoundary2x9bVx0;
                    LayoutCoordinates it = function0.invoke();
                    if (it != null) {
                        Function0<TextLayoutResult> function03 = function02;
                        SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                        long j = selectableId;
                        if (!it.isAttached()) {
                            return;
                        }
                        m865outOfBoundary2x9bVx0 = SelectionControllerKt.m865outOfBoundary2x9bVx0(function03.invoke(), startPoint, startPoint);
                        if (m865outOfBoundary2x9bVx0) {
                            selectionRegistrar.notifySelectionUpdateSelectAll(j);
                        } else {
                            selectionRegistrar.mo939notifySelectionUpdateStartd4ec7I(it, startPoint, SelectionAdjustment.INSTANCE.getWord());
                        }
                        this.lastPosition = startPoint;
                    }
                    if (SelectionRegistrarKt.hasSelection($this$makeSelectionModifier, selectableId)) {
                        this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDrag-k-4lQ0M */
                public void mo806onDragk4lQ0M(long delta) {
                    boolean m865outOfBoundary2x9bVx0;
                    LayoutCoordinates it = function0.invoke();
                    if (it != null) {
                        SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                        long j = selectableId;
                        Function0<TextLayoutResult> function03 = function02;
                        if (it.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                            this.dragTotalDistance = Offset.m2715plusMKHz9U(this.dragTotalDistance, delta);
                            long newPosition = Offset.m2715plusMKHz9U(this.lastPosition, this.dragTotalDistance);
                            m865outOfBoundary2x9bVx0 = SelectionControllerKt.m865outOfBoundary2x9bVx0(function03.invoke(), this.lastPosition, newPosition);
                            if (!m865outOfBoundary2x9bVx0) {
                                boolean consumed = selectionRegistrar.mo938notifySelectionUpdate5iVPX68(it, newPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate());
                                if (consumed) {
                                    this.lastPosition = newPosition;
                                    this.dragTotalDistance = Offset.INSTANCE.m2726getZeroF1C5BW0();
                                }
                            }
                        }
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onStop() {
                    if (SelectionRegistrarKt.hasSelection($this$makeSelectionModifier, selectableId)) {
                        $this$makeSelectionModifier.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onCancel() {
                    if (SelectionRegistrarKt.hasSelection($this$makeSelectionModifier, selectableId)) {
                        $this$makeSelectionModifier.notifySelectionUpdateEnd();
                    }
                }
            };
            return SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, (Object) r7, new SelectionControllerKt$makeSelectionModifier$1(r7, null));
        }
        ?? r1 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.modifiers.SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1
            private long lastPosition = Offset.INSTANCE.m2726getZeroF1C5BW0();

            public final long getLastPosition() {
                return this.lastPosition;
            }

            public final void setLastPosition(long j) {
                this.lastPosition = j;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M, reason: not valid java name */
            public boolean mo867onExtendk4lQ0M(long downPosition) {
                LayoutCoordinates layoutCoordinates = function0.invoke();
                if (layoutCoordinates == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                long j = selectableId;
                if (!layoutCoordinates.isAttached()) {
                    return false;
                }
                boolean consumed = selectionRegistrar.mo938notifySelectionUpdate5iVPX68(layoutCoordinates, downPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getNone());
                if (consumed) {
                    this.lastPosition = downPosition;
                }
                return SelectionRegistrarKt.hasSelection(selectionRegistrar, j);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
            public boolean mo868onExtendDragk4lQ0M(long dragPosition) {
                LayoutCoordinates layoutCoordinates = function0.invoke();
                if (layoutCoordinates != null) {
                    SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                    long j = selectableId;
                    if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                        return false;
                    }
                    boolean consumed = selectionRegistrar.mo938notifySelectionUpdate5iVPX68(layoutCoordinates, dragPosition, this.lastPosition, false, SelectionAdjustment.INSTANCE.getNone());
                    if (consumed) {
                        this.lastPosition = dragPosition;
                        return true;
                    }
                    return true;
                }
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k, reason: not valid java name */
            public boolean mo869onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                LayoutCoordinates it = function0.invoke();
                if (it == null) {
                    return false;
                }
                SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                long j = selectableId;
                if (!it.isAttached()) {
                    return false;
                }
                selectionRegistrar.mo939notifySelectionUpdateStartd4ec7I(it, downPosition, adjustment);
                this.lastPosition = downPosition;
                return SelectionRegistrarKt.hasSelection(selectionRegistrar, j);
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k, reason: not valid java name */
            public boolean mo866onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                Intrinsics.checkNotNullParameter(adjustment, "adjustment");
                LayoutCoordinates it = function0.invoke();
                if (it != null) {
                    SelectionRegistrar selectionRegistrar = $this$makeSelectionModifier;
                    long j = selectableId;
                    if (!it.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, j)) {
                        return false;
                    }
                    boolean consumed = selectionRegistrar.mo938notifySelectionUpdate5iVPX68(it, dragPosition, this.lastPosition, false, adjustment);
                    if (consumed) {
                        this.lastPosition = dragPosition;
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
        return PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, (Object) r1, new SelectionControllerKt$makeSelectionModifier$2(r1, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfBoundary-2x9bVx0, reason: not valid java name */
    public static final boolean m865outOfBoundary2x9bVx0(TextLayoutResult $this$outOfBoundary_u2d2x9bVx0, long start, long end) {
        if ($this$outOfBoundary_u2d2x9bVx0 == null) {
            return false;
        }
        int lastOffset = $this$outOfBoundary_u2d2x9bVx0.getLayoutInput().getText().getText().length();
        int rawStartOffset = $this$outOfBoundary_u2d2x9bVx0.m4698getOffsetForPositionk4lQ0M(start);
        int rawEndOffset = $this$outOfBoundary_u2d2x9bVx0.m4698getOffsetForPositionk4lQ0M(end);
        return (rawStartOffset >= lastOffset + (-1) && rawEndOffset >= lastOffset + (-1)) || (rawStartOffset < 0 && rawEndOffset < 0);
    }
}
