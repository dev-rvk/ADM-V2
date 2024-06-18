package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* compiled from: SnapshotDoubleIndexHeap.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    private int[] handles;
    private int size;
    private int[] values = new int[16];
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        this.handles = iArr;
    }

    public final int getSize() {
        return this.size;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i);
    }

    public final int lowestOrDefault(int r3) {
        return this.size > 0 ? this.values[0] : r3;
    }

    public final int add(int value) {
        ensure(this.size + 1);
        int i = this.size;
        this.size = i + 1;
        int handle = allocateHandle();
        this.values[i] = value;
        this.index[i] = handle;
        this.handles[handle] = i;
        shiftUp(i);
        return handle;
    }

    public final void remove(int handle) {
        int i = this.handles[handle];
        swap(i, this.size - 1);
        this.size--;
        shiftUp(i);
        shiftDown(i);
        freeHandle(handle);
    }

    public final void validate() {
        int i = this.size;
        for (int index = 1; index < i; index++) {
            int parent = ((index + 1) >> 1) - 1;
            if (this.values[parent] > this.values[index]) {
                throw new IllegalStateException(("Index " + index + " is out of place").toString());
            }
        }
    }

    public final void validateHandle(int handle, int value) {
        int i = this.handles[handle];
        if (this.index[i] != handle) {
            throw new IllegalStateException(("Index for handle " + handle + " is corrupted").toString());
        }
        if (this.values[i] != value) {
            throw new IllegalStateException(("Value for handle " + handle + " was " + this.values[i] + " but was supposed to be " + value).toString());
        }
    }

    private final void shiftUp(int index) {
        int[] values = this.values;
        int value = values[index];
        int current = index;
        while (current > 0) {
            int parent = ((current + 1) >> 1) - 1;
            if (values[parent] > value) {
                swap(parent, current);
                current = parent;
            } else {
                return;
            }
        }
    }

    private final void shiftDown(int index) {
        int[] values = this.values;
        int half = this.size >> 1;
        int current = index;
        while (current < half) {
            int right = (current + 1) << 1;
            int left = right - 1;
            if (right < this.size && values[right] < values[left]) {
                if (values[right] < values[current]) {
                    swap(right, current);
                    current = right;
                } else {
                    return;
                }
            } else if (values[left] < values[current]) {
                swap(left, current);
                current = left;
            } else {
                return;
            }
        }
    }

    private final void swap(int a, int b) {
        int[] values = this.values;
        int[] index = this.index;
        int[] handles = this.handles;
        int t = values[a];
        values[a] = values[b];
        values[b] = t;
        int t2 = index[a];
        index[a] = index[b];
        index[b] = t2;
        handles[index[a]] = a;
        handles[index[b]] = b;
    }

    private final void ensure(int atLeast) {
        int capacity = this.values.length;
        if (atLeast <= capacity) {
            return;
        }
        int newCapacity = capacity * 2;
        int[] newValues = new int[newCapacity];
        int[] newIndex = new int[newCapacity];
        ArraysKt.copyInto$default(this.values, newValues, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(this.index, newIndex, 0, 0, 0, 14, (Object) null);
        this.values = newValues;
        this.index = newIndex;
    }

    private final int allocateHandle() {
        int capacity = this.handles.length;
        if (this.firstFreeHandle >= capacity) {
            int i = capacity * 2;
            int[] newHandles = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                newHandles[i2] = i3;
                i2 = i3;
            }
            ArraysKt.copyInto$default(this.handles, newHandles, 0, 0, 0, 14, (Object) null);
            this.handles = newHandles;
        }
        int handle = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[this.firstFreeHandle];
        return handle;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }
}
