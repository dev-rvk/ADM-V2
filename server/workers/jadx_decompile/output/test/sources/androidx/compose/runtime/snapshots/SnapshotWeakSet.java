package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotWeakSet.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\u0086\bø\u0001\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "T", "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "[Landroidx/compose/runtime/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotWeakSet<T> {
    private int size;
    private int[] hashes = new int[16];
    private WeakReference<T>[] values = new WeakReference[16];

    /* renamed from: getSize$runtime_release, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    /* renamed from: getHashes$runtime_release, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    public final void setHashes$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(WeakReference<T>[] weakReferenceArr) {
        Intrinsics.checkNotNullParameter(weakReferenceArr, "<set-?>");
        this.values = weakReferenceArr;
    }

    public final boolean add(T value) {
        int index;
        Intrinsics.checkNotNullParameter(value, "value");
        int size = this.size;
        int hash = ActualJvm_jvmKt.identityHashCode(value);
        if (size > 0) {
            index = find(value, hash);
            if (index >= 0) {
                return false;
            }
        } else {
            index = -1;
        }
        int insertIndex = -(index + 1);
        int capacity = this.values.length;
        if (size == capacity) {
            int newCapacity = capacity * 2;
            WeakReference[] newValues = new WeakReference[newCapacity];
            int[] newHashes = new int[newCapacity];
            ArraysKt.copyInto(this.values, newValues, insertIndex + 1, insertIndex, size);
            ArraysKt.copyInto$default(this.values, newValues, 0, 0, insertIndex, 6, (Object) null);
            ArraysKt.copyInto(this.hashes, newHashes, insertIndex + 1, insertIndex, size);
            ArraysKt.copyInto$default(this.hashes, newHashes, 0, 0, insertIndex, 6, (Object) null);
            this.values = newValues;
            this.hashes = newHashes;
        } else {
            ArraysKt.copyInto(this.values, this.values, insertIndex + 1, insertIndex, size);
            ArraysKt.copyInto(this.hashes, this.hashes, insertIndex + 1, insertIndex, size);
        }
        this.values[insertIndex] = new WeakReference<>(value);
        this.hashes[insertIndex] = hash;
        this.size++;
        return true;
    }

    public final void removeIf(Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size = getSize();
        int currentUsed = 0;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            WeakReference entry = getValues$runtime_release()[i];
            Object value = entry != null ? entry.get() : null;
            if (value != null && !block.invoke(value).booleanValue()) {
                if (currentUsed != i) {
                    getValues$runtime_release()[currentUsed] = entry;
                    getHashes()[currentUsed] = getHashes()[i];
                }
                currentUsed++;
            }
            i++;
        }
        for (int i2 = currentUsed; i2 < size; i2++) {
            getValues$runtime_release()[i2] = null;
            getHashes()[i2] = 0;
        }
        if (currentUsed != size) {
            setSize$runtime_release(currentUsed);
        }
    }

    private final int find(T value, int hash) {
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midHash = this.hashes[mid];
            if (midHash < hash) {
                low = mid + 1;
            } else {
                if (midHash <= hash) {
                    WeakReference<T> weakReference = this.values[mid];
                    Object midVal = weakReference != null ? weakReference.get() : null;
                    return value == midVal ? mid : findExactIndex(mid, value, hash);
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, T value, int valueHash) {
        int i = midIndex - 1;
        while (true) {
            if (-1 >= i || this.hashes[i] != valueHash) {
                break;
            }
            WeakReference<T> weakReference = this.values[i];
            Object v = weakReference != null ? weakReference.get() : null;
            if (v == value) {
                return i;
            }
            i--;
        }
        int i2 = this.size;
        for (int i3 = midIndex + 1; i3 < i2; i3++) {
            if (this.hashes[i3] != valueHash) {
                return -(i3 + 1);
            }
            WeakReference<T> weakReference2 = this.values[i3];
            Object v2 = weakReference2 != null ? weakReference2.get() : null;
            if (v2 == value) {
                return i3;
            }
        }
        int i4 = this.size;
        return -(i4 + 1);
    }

    public final boolean isValid$runtime_release() {
        WeakReference entry;
        int size = this.size;
        WeakReference[] values = this.values;
        int[] hashes = this.hashes;
        int capacity = values.length;
        if (size > capacity) {
            return false;
        }
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int hash = hashes[i];
            if (hash < previous || (entry = values[i]) == null) {
                return false;
            }
            Object value = entry.get();
            if (value != null && hash != ActualJvm_jvmKt.identityHashCode(value)) {
                return false;
            }
            previous = hash;
        }
        for (int i2 = size; i2 < capacity; i2++) {
            if (hashes[i2] != 0 || values[i2] != null) {
                return false;
            }
        }
        return true;
    }
}
