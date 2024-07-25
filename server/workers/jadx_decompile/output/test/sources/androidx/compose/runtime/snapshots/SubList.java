package androidx.compose.runtime.snapshots;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapshotStateList.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0012H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00060"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", "T", "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "modification", "offset", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SubList<T> implements List<T>, KMutableList {
    private int modification;
    private final int offset;
    private final SnapshotStateList<T> parentList;
    private int size;

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public SubList(SnapshotStateList<T> parentList, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(parentList, "parentList");
        this.parentList = parentList;
        this.offset = fromIndex;
        this.modification = this.parentList.getModification$runtime_release();
        this.size = toIndex - fromIndex;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int index) {
        return removeAt(index);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override // java.util.List, java.util.Collection
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

    @Override // java.util.List
    public T get(int index) {
        validateModification();
        SnapshotStateListKt.validateRange(index, size());
        return this.parentList.get(this.offset + index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        validateModification();
        Iterable $this$forEach$iv = RangesKt.until(this.offset, this.offset + size());
        Iterator<Integer> it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            int element$iv = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(element, this.parentList.get(element$iv))) {
                return element$iv - this.offset;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        validateModification();
        int index = this.offset + size();
        do {
            index--;
            if (index < this.offset) {
                return -1;
            }
        } while (!Intrinsics.areEqual(element, this.parentList.get(index)));
        return index - this.offset;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        validateModification();
        this.parentList.add(this.offset + size(), element);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
        return true;
    }

    @Override // java.util.List
    public void add(int index, T element) {
        validateModification();
        this.parentList.add(this.offset + index, element);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        validateModification();
        boolean result = this.parentList.addAll(this.offset + index, elements);
        if (result) {
            this.size = size() + elements.size();
            this.modification = this.parentList.getModification$runtime_release();
        }
        return result;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll(size(), elements);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            validateModification();
            this.parentList.removeRange(this.offset, this.offset + size());
            this.size = 0;
            this.modification = this.parentList.getModification$runtime_release();
        }
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        validateModification();
        Ref.IntRef current = new Ref.IntRef();
        current.element = index - 1;
        return new SubList$listIterator$1(current, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean removed = false;
        for (Object element : elements) {
            removed = remove(element) || removed;
        }
        return removed;
    }

    public T removeAt(int index) {
        validateModification();
        T remove = this.parentList.remove(this.offset + index);
        this.size = size() - 1;
        this.modification = this.parentList.getModification$runtime_release();
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        validateModification();
        int removed = this.parentList.retainAllInRange$runtime_release(elements, this.offset, this.offset + size());
        if (removed > 0) {
            this.modification = this.parentList.getModification$runtime_release();
            this.size = size() - removed;
        }
        return removed > 0;
    }

    @Override // java.util.List
    public T set(int index, T element) {
        SnapshotStateListKt.validateRange(index, size());
        validateModification();
        T t = this.parentList.set(this.offset + index, element);
        this.modification = this.parentList.getModification$runtime_release();
        return t;
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!((fromIndex >= 0 && fromIndex <= toIndex) && toIndex <= size())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        validateModification();
        return new SubList(this.parentList, this.offset + fromIndex, this.offset + toIndex);
    }

    private final void validateModification() {
        if (this.parentList.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }
}
