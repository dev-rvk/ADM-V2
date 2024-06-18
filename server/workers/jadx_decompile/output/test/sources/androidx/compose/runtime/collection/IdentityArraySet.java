package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: IdentityArraySet.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J+\u0010\u001e\u001a\u00020\u00142\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140 H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0016\u0010%\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0010H\u0016J\u0006\u0010(\u001a\u00020\u0010J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0096\u0002J\u0013\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J \u0010,\u001a\u00020\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100 H\u0086\bø\u0001\u0000J\b\u0010.\u001a\u00020/H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR0\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArraySet;", "T", "", "", "()V", "<set-?>", "", "size", "getSize", "()I", "", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "(Ljava/lang/Object;)Z", "addAll", "", "collection", "", "checkIndexBounds", "index", "clear", "contains", "element", "containsAll", "elements", "fastForEach", "block", "Lkotlin/Function1;", "find", "findExactIndex", "midIndex", "valueHash", "get", "(I)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "iterator", "", "remove", "removeValueIf", "predicate", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IdentityArraySet<T> implements Set<T>, KMappedMarker {
    private int size;
    private Object[] values = new Object[16];

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return element != null && find(element) >= 0;
    }

    public final T get(int index) {
        checkIndexBounds(index);
        T t = (T) this.values[index];
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return t;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T value) {
        int index;
        Intrinsics.checkNotNullParameter(value, "value");
        int size = size();
        Object[] values = this.values;
        if (size > 0) {
            index = find(value);
            if (index >= 0) {
                return false;
            }
        } else {
            index = -1;
        }
        int insertIndex = -(index + 1);
        if (size == values.length) {
            Object[] newSorted = new Object[values.length * 2];
            ArraysKt.copyInto(values, newSorted, insertIndex + 1, insertIndex, size);
            ArraysKt.copyInto$default(values, newSorted, 0, 0, insertIndex, 6, (Object) null);
            this.values = newSorted;
        } else {
            ArraysKt.copyInto(values, values, insertIndex + 1, insertIndex, size);
        }
        this.values[insertIndex] = value;
        this.size = size() + 1;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
        this.size = 0;
    }

    public final void fastForEach(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Object[] values = getValues();
        int size = size();
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            block.invoke(obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void addAll(Collection<? extends T> collection) {
        Object[] newArray;
        int thisIndex;
        Object obj;
        Object[] thisValues;
        IdentityArraySet identityArraySet = this;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return;
        }
        if (!(collection instanceof IdentityArraySet)) {
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                identityArraySet.add(it.next());
            }
            return;
        }
        Object[] thisValues2 = identityArraySet.values;
        Object[] otherValues = ((IdentityArraySet) collection).values;
        int thisSize = size();
        int otherSize = ((IdentityArraySet) collection).size();
        int combinedSize = thisSize + otherSize;
        int thisHash = 0;
        boolean elementsInOrder = true;
        boolean needsResize = identityArraySet.values.length < combinedSize;
        if (thisSize != 0 && ActualJvm_jvmKt.identityHashCode(thisValues2[thisSize - 1]) >= ActualJvm_jvmKt.identityHashCode(otherValues[0])) {
            elementsInOrder = false;
        }
        if (!needsResize && elementsInOrder) {
            ArraysKt.copyInto(otherValues, thisValues2, thisSize, 0, otherSize);
            identityArraySet.size = size() + otherSize;
            return;
        }
        if (needsResize) {
            newArray = new Object[thisSize > otherSize ? thisSize * 2 : otherSize * 2];
        } else {
            newArray = thisValues2;
        }
        int thisIndex2 = thisSize - 1;
        int otherIndex = otherSize - 1;
        int nextInsertIndex = combinedSize - 1;
        while (true) {
            if (thisIndex2 < 0 && otherIndex < 0) {
                break;
            }
            if (thisIndex2 < 0) {
                thisIndex = otherIndex - 1;
                obj = otherValues[otherIndex];
                thisValues = thisValues2;
            } else if (otherIndex < 0) {
                thisValues = thisValues2;
                int i = otherIndex;
                obj = thisValues2[thisIndex2];
                thisIndex2--;
                thisIndex = i;
            } else {
                Object thisValue = thisValues2[thisIndex2];
                Object otherValue = otherValues[otherIndex];
                int thisHash2 = ActualJvm_jvmKt.identityHashCode(thisValue);
                int otherHash = ActualJvm_jvmKt.identityHashCode(otherValue);
                if (thisHash2 > otherHash) {
                    thisIndex2--;
                    thisValues = thisValues2;
                    thisIndex = otherIndex;
                    obj = thisValue;
                } else if (thisHash2 < otherHash) {
                    thisValues = thisValues2;
                    thisIndex = otherIndex - 1;
                    obj = otherValue;
                } else if (thisValue == otherValue) {
                    thisIndex2--;
                    thisValues = thisValues2;
                    thisIndex = otherIndex - 1;
                    obj = thisValue;
                } else {
                    int i2 = thisIndex2 - 1;
                    boolean foundDuplicate = false;
                    while (true) {
                        if (i2 < 0) {
                            thisValues = thisValues2;
                            break;
                        }
                        int i3 = i2 - 1;
                        Object value = thisValues2[i2];
                        thisValues = thisValues2;
                        if (ActualJvm_jvmKt.identityHashCode(value) != otherHash) {
                            break;
                        }
                        if (otherValue == value) {
                            foundDuplicate = true;
                            break;
                        } else {
                            i2 = i3;
                            thisValues2 = thisValues;
                        }
                    }
                    if (foundDuplicate) {
                        otherIndex--;
                        identityArraySet = this;
                        thisValues2 = thisValues;
                        thisHash = 0;
                    } else {
                        thisIndex = otherIndex - 1;
                        obj = otherValue;
                    }
                }
            }
            Object nextValue = obj;
            newArray[nextInsertIndex] = nextValue;
            identityArraySet = this;
            nextInsertIndex--;
            otherIndex = thisIndex;
            thisValues2 = thisValues;
            thisHash = 0;
        }
        if (nextInsertIndex >= 0) {
            ArraysKt.copyInto(newArray, newArray, thisHash, nextInsertIndex + 1, combinedSize);
        }
        int newSize = combinedSize - (nextInsertIndex + 1);
        ArraysKt.fill(newArray, (Object) null, newSize, combinedSize);
        identityArraySet.values = newArray;
        identityArraySet.size = newSize;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T value) {
        if (value == null) {
            return false;
        }
        int index = find(value);
        Object[] values = this.values;
        int size = size();
        if (index < 0) {
            return false;
        }
        if (index < size - 1) {
            ArraysKt.copyInto(values, values, index, index + 1, size);
        }
        values[size - 1] = null;
        this.size = size() - 1;
        return true;
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] values = getValues();
        int size = size();
        int destinationIndex = 0;
        for (int i = 0; i < size; i++) {
            Object item = values[i];
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (!predicate.invoke(item).booleanValue()) {
                if (destinationIndex != i) {
                    values[destinationIndex] = item;
                }
                destinationIndex++;
            }
        }
        for (int i2 = destinationIndex; i2 < size; i2++) {
            values[i2] = null;
        }
        this.size = destinationIndex;
    }

    private final int find(Object value) {
        int low = 0;
        int high = size() - 1;
        int valueIdentity = ActualJvm_jvmKt.identityHashCode(value);
        Object[] values = this.values;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midVal = values[mid];
            int midIdentity = ActualJvm_jvmKt.identityHashCode(midVal);
            if (midIdentity < valueIdentity) {
                low = mid + 1;
            } else {
                if (midIdentity <= valueIdentity) {
                    return midVal == value ? mid : findExactIndex(mid, value, valueIdentity);
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        Object[] values = this.values;
        int size = size();
        for (int i = midIndex - 1; -1 < i; i--) {
            Object v = values[i];
            if (v == value) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(v) != valueHash) {
                break;
            }
        }
        for (int i2 = midIndex + 1; i2 < size; i2++) {
            Object v2 = values[i2];
            if (v2 == value) {
                return i2;
            }
            if (ActualJvm_jvmKt.identityHashCode(v2) != valueHash) {
                return -(i2 + 1);
            }
        }
        int i3 = size + 1;
        return -i3;
    }

    private final void checkIndexBounds(int index) {
        boolean z = false;
        if (index >= 0 && index < size()) {
            z = true;
        }
        if (!z) {
            throw new IndexOutOfBoundsException("Index " + index + ", size " + size());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> $this$all$iv = elements;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!contains(element$iv)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new IdentityArraySet$iterator$1(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, null, "[", "]", 0, null, new Function1<T, CharSequence>() { // from class: androidx.compose.runtime.collection.IdentityArraySet$toString$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(T it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((IdentityArraySet$toString$1<T>) obj);
            }
        }, 25, null);
    }
}
