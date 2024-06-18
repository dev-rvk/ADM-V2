package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"lowestBitOf", "", "bits", "", "binarySearch", "", "value", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotIdSetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int lowestBitOf(long bits) {
        long b = bits;
        int base = 0;
        if ((4294967295L & b) == 0) {
            base = 0 + 32;
            b >>= 32;
        }
        if ((65535 & b) == 0) {
            base += 16;
            b >>= 16;
        }
        if ((255 & b) == 0) {
            base += 8;
            b >>= 8;
        }
        if ((15 & b) == 0) {
            base += 4;
            b >>= 4;
        }
        if ((1 & b) != 0) {
            return base;
        }
        if ((2 & b) != 0) {
            return base + 1;
        }
        if ((4 & b) != 0) {
            return base + 2;
        }
        if ((8 & b) != 0) {
            return base + 3;
        }
        return -1;
    }

    public static final int binarySearch(int[] $this$binarySearch, int value) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        int low = 0;
        int high = $this$binarySearch.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = $this$binarySearch[mid];
            if (value > midVal) {
                low = mid + 1;
            } else if (value < midVal) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
