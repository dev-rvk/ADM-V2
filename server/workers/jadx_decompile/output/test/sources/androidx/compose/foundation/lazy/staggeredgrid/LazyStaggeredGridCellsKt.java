package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: LazyStaggeredGridCells.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyStaggeredGridCellsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int gridSizeWithoutSpacing = gridSize - ((slotCount - 1) * spacing);
        int slotSize = gridSizeWithoutSpacing / slotCount;
        int remainingPixels = gridSizeWithoutSpacing % slotCount;
        int[] iArr = new int[slotCount];
        int i = 0;
        while (i < slotCount) {
            iArr[i] = (i < remainingPixels ? 1 : 0) + slotSize;
            i++;
        }
        return iArr;
    }
}
