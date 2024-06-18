package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: SnapshotStateList.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\u0082\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J)\u0010J\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ3\u0010K\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\u0082\b¢\u0006\u0002\u00107J3\u0010M\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\u0082\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0080\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006O"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int index) {
        return removeAt(index);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    public final int getModification$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$withCurrent$iv$iv = (StateListStateRecord) firstStateRecord;
        StateListStateRecord $this$_get_modification__u24lambda_u240 = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv);
        return $this$_get_modification__u24lambda_u240.getModification();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, this);
    }

    /* compiled from: SnapshotStateList.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        /* renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Object lock$iv;
            Intrinsics.checkNotNullParameter(value, "value");
            lock$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int index) {
        return (T) getReadable$runtime_release().getList$runtime_release().get(index);
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new StateListIterator(this, index);
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!((fromIndex >= 0 && fromIndex <= toIndex) && toIndex <= size())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new SubList(this, fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Object lock$iv$iv2;
        SnapshotStateList this_$iv;
        boolean z;
        SnapshotStateList this_$iv2 = this;
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv = this_$iv2;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                try {
                    StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                    currentModification$iv = current$iv.getModification();
                    list$runtime_release = current$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList it = list$runtime_release.add((PersistentList<T>) element);
            if (Intrinsics.areEqual(it, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv, current);
                    lock$iv$iv2 = SnapshotStateListKt.sync;
                    synchronized (lock$iv$iv2) {
                        try {
                            if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() == currentModification$iv) {
                                this_$iv = this_$iv2;
                                try {
                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setList$runtime_release(it);
                                    z = true;
                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() + 1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                this_$iv = this_$iv2;
                                z = false;
                            }
                            try {
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv);
                    if (z) {
                        return true;
                    }
                    this_$iv2 = this_$iv;
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
    }

    @Override // java.util.List
    public void add(int index, T element) {
        Object lock$iv$iv$iv;
        int currentModification$iv$iv;
        PersistentList<T> list$runtime_release;
        Object lock$iv$iv$iv2;
        int $i$f$update;
        boolean z;
        SnapshotStateList this_$iv = this;
        int $i$f$update2 = 0;
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv$iv = this_$iv;
        while (true) {
            lock$iv$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv$iv) {
                try {
                    StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv$iv);
                    currentModification$iv$iv = current$iv$iv.getModification();
                    list$runtime_release = current$iv$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList it = list$runtime_release.add(index, (int) element);
            if (Intrinsics.areEqual(it, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    try {
                        SnapshotStateList this_$iv2 = this_$iv;
                        try {
                            StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv$iv, current);
                            lock$iv$iv$iv2 = SnapshotStateListKt.sync;
                            synchronized (lock$iv$iv$iv2) {
                                try {
                                    if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() == currentModification$iv$iv) {
                                        $i$f$update = $i$f$update2;
                                        try {
                                            $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setList$runtime_release(it);
                                            z = true;
                                            $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() + 1);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } else {
                                        $i$f$update = $i$f$update2;
                                        z = false;
                                    }
                                    try {
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                            SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv$iv);
                            if (z) {
                                return;
                            }
                            this_$iv = this_$iv2;
                            $i$f$update2 = $i$f$update;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }
    }

    @Override // java.util.List
    public boolean addAll(final int index, final Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.addAll(index, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object lock$iv$iv2;
        boolean z;
        Collection<? extends T> elements2 = elements;
        Intrinsics.checkNotNullParameter(elements2, "elements");
        SnapshotStateList<T> $this$conditionalUpdate_u24lambda_u2423$iv = this;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                currentModification$iv = current$iv.getModification();
                list$runtime_release = current$iv.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList it = list$runtime_release.addAll(elements2);
            if (Intrinsics.areEqual(it, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv, current);
                lock$iv$iv2 = SnapshotStateListKt.sync;
                synchronized (lock$iv$iv2) {
                    try {
                        if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() == currentModification$iv) {
                            try {
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setList$runtime_release(it);
                                z = true;
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() + 1);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            }
            SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv);
            if (z) {
                return true;
            }
            elements2 = elements;
        }
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        Object lock$iv;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$writable$iv$iv = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        Object lock$iv$iv$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv$iv$iv) {
            current = Snapshot.INSTANCE.getCurrent();
            StateListStateRecord $this$clear_u24lambda_u245 = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv, this, current);
            lock$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv) {
                $this$clear_u24lambda_u245.setList$runtime_release(ExtensionsKt.persistentListOf());
                $this$clear_u24lambda_u245.setModification$runtime_release($this$clear_u24lambda_u245.getModification() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Object lock$iv$iv2;
        SnapshotStateList this_$iv;
        boolean z;
        SnapshotStateList this_$iv2 = this;
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv = this_$iv2;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                try {
                    StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                    currentModification$iv = current$iv.getModification();
                    list$runtime_release = current$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList it = list$runtime_release.remove((PersistentList<T>) element);
            if (Intrinsics.areEqual(it, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv, current);
                    lock$iv$iv2 = SnapshotStateListKt.sync;
                    synchronized (lock$iv$iv2) {
                        try {
                            if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() == currentModification$iv) {
                                this_$iv = this_$iv2;
                                try {
                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setList$runtime_release(it);
                                    z = true;
                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() + 1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                this_$iv = this_$iv2;
                                z = false;
                            }
                            try {
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv);
                    if (z) {
                        return true;
                    }
                    this_$iv2 = this_$iv;
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList list$runtime_release;
        Snapshot current;
        Object lock$iv$iv2;
        boolean z;
        Collection<? extends Object> elements2 = elements;
        Intrinsics.checkNotNullParameter(elements2, "elements");
        SnapshotStateList<T> $this$conditionalUpdate_u24lambda_u2423$iv = this;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                currentModification$iv = current$iv.getModification();
                list$runtime_release = current$iv.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList it = list$runtime_release.removeAll((Collection) elements2);
            if (Intrinsics.areEqual(it, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = $this$conditionalUpdate_u24lambda_u2423$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv, current);
                lock$iv$iv2 = SnapshotStateListKt.sync;
                synchronized (lock$iv$iv2) {
                    try {
                        if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() == currentModification$iv) {
                            try {
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setList$runtime_release(it);
                                z = true;
                                $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv.getModification() + 1);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            z = false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            }
            SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv);
            if (z) {
                return true;
            }
            elements2 = elements;
        }
    }

    public T removeAt(int index) {
        Object lock$iv$iv$iv;
        StateRecord it;
        int i;
        Object lock$iv$iv$iv2;
        boolean z;
        T t = get(index);
        Object it2 = t;
        int i2 = 0;
        SnapshotStateList this_$iv = this;
        int $i$f$update = 0;
        SnapshotStateList this_$iv$iv = this_$iv;
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv$iv = this_$iv$iv;
        while (true) {
            lock$iv$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv$iv) {
                Object it3 = it2;
                try {
                    it = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
                    i = i2;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Intrinsics.checkNotNull(it, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv$iv = (StateListStateRecord) it;
                    StateListStateRecord current$iv$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv$iv);
                    int currentModification$iv$iv = current$iv$iv.getModification();
                    PersistentList<T> list$runtime_release = current$iv$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    Intrinsics.checkNotNull(list$runtime_release);
                    PersistentList it4 = list$runtime_release.removeAt(index);
                    if (Intrinsics.areEqual(it4, list$runtime_release)) {
                        break;
                    }
                    StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$writable$iv$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    SnapshotKt.getSnapshotInitializer();
                    Object lock$iv$iv$iv$iv$iv$iv = SnapshotKt.getLock();
                    synchronized (lock$iv$iv$iv$iv$iv$iv) {
                        try {
                            Snapshot current = Snapshot.INSTANCE.getCurrent();
                            SnapshotStateList this_$iv2 = this_$iv;
                            try {
                                int $i$f$update2 = $i$f$update;
                                try {
                                    StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv$iv, current);
                                    lock$iv$iv$iv2 = SnapshotStateListKt.sync;
                                    synchronized (lock$iv$iv$iv2) {
                                        SnapshotStateList this_$iv$iv2 = this_$iv$iv;
                                        try {
                                            if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() == currentModification$iv$iv) {
                                                try {
                                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setList$runtime_release(it4);
                                                    z = true;
                                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() + 1);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        throw th;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        throw th;
                                                    }
                                                }
                                            } else {
                                                z = false;
                                            }
                                            try {
                                                SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv$iv);
                                                if (z) {
                                                    break;
                                                }
                                                it2 = it3;
                                                i2 = i;
                                                this_$iv = this_$iv2;
                                                $i$f$update = $i$f$update2;
                                                this_$iv$iv = this_$iv$iv2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    throw th;
                }
            }
        }
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.retainAll(elements));
            }
        });
    }

    @Override // java.util.List
    public T set(int index, T element) {
        Object lock$iv$iv$iv;
        StateRecord it;
        int i;
        Object lock$iv$iv$iv2;
        boolean z;
        T t = get(index);
        Object it2 = t;
        int i2 = 0;
        SnapshotStateList this_$iv = this;
        int $i$f$update = 0;
        SnapshotStateList this_$iv$iv = this_$iv;
        SnapshotStateList $this$conditionalUpdate_u24lambda_u2423$iv$iv = this_$iv$iv;
        while (true) {
            lock$iv$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv$iv) {
                Object it3 = it2;
                try {
                    it = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
                    i = i2;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Intrinsics.checkNotNull(it, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv$iv = (StateListStateRecord) it;
                    StateListStateRecord current$iv$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv$iv);
                    int currentModification$iv$iv = current$iv$iv.getModification();
                    PersistentList<T> list$runtime_release = current$iv$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    Intrinsics.checkNotNull(list$runtime_release);
                    PersistentList it4 = list$runtime_release.set(index, (int) element);
                    if (Intrinsics.areEqual(it4, list$runtime_release)) {
                        break;
                    }
                    StateRecord firstStateRecord = $this$conditionalUpdate_u24lambda_u2423$iv$iv.getFirstStateRecord();
                    SnapshotStateList this_$iv2 = this_$iv;
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$writable$iv$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    SnapshotKt.getSnapshotInitializer();
                    Object lock$iv$iv$iv$iv$iv$iv = SnapshotKt.getLock();
                    synchronized (lock$iv$iv$iv$iv$iv$iv) {
                        try {
                            Snapshot current = Snapshot.INSTANCE.getCurrent();
                            int $i$f$update2 = $i$f$update;
                            try {
                                SnapshotStateList this_$iv$iv2 = this_$iv$iv;
                                try {
                                    StateListStateRecord $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, $this$conditionalUpdate_u24lambda_u2423$iv$iv, current);
                                    lock$iv$iv$iv2 = SnapshotStateListKt.sync;
                                    synchronized (lock$iv$iv$iv2) {
                                        try {
                                            if ($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() == currentModification$iv$iv) {
                                                try {
                                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setList$runtime_release(it4);
                                                    z = true;
                                                    $this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.setModification$runtime_release($this$conditionalUpdate_u24lambda_u2423_u24lambda_u2422$iv$iv.getModification() + 1);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        throw th;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        throw th;
                                                    }
                                                }
                                            } else {
                                                z = false;
                                            }
                                            try {
                                                SnapshotKt.notifyWrite(current, $this$conditionalUpdate_u24lambda_u2423$iv$iv);
                                                if (z) {
                                                    break;
                                                }
                                                this_$iv = this_$iv2;
                                                it2 = it3;
                                                i2 = i;
                                                $i$f$update = $i$f$update2;
                                                this_$iv$iv = this_$iv$iv2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    throw th;
                }
            }
        }
        return t;
    }

    public final void removeRange(int fromIndex, int toIndex) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Object lock$iv$iv2;
        SnapshotStateList this_$iv;
        boolean z;
        SnapshotStateList this_$iv2 = this;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                try {
                    StateRecord firstStateRecord = this_$iv2.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                    currentModification$iv = current$iv.getModification();
                    list$runtime_release = current$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder$iv = list$runtime_release.builder();
            PersistentList.Builder it = builder$iv;
            it.subList(fromIndex, toIndex).clear();
            Unit unit2 = Unit.INSTANCE;
            PersistentList newList$iv = builder$iv.build();
            if (Intrinsics.areEqual(newList$iv, list$runtime_release)) {
                return;
            }
            SnapshotStateList this_$iv$iv = this_$iv2;
            StateRecord firstStateRecord2 = this_$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord $this$mutate_u24lambda_u2418$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this_$iv$iv, current);
                    lock$iv$iv2 = SnapshotStateListKt.sync;
                    synchronized (lock$iv$iv2) {
                        try {
                            if ($this$mutate_u24lambda_u2418$iv.getModification() == currentModification$iv) {
                                this_$iv = this_$iv2;
                                try {
                                    $this$mutate_u24lambda_u2418$iv.setList$runtime_release(newList$iv);
                                    z = true;
                                    $this$mutate_u24lambda_u2418$iv.setModification$runtime_release($this$mutate_u24lambda_u2418$iv.getModification() + 1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                this_$iv = this_$iv2;
                                z = false;
                            }
                            try {
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    SnapshotKt.notifyWrite(current, this_$iv$iv);
                    if (z) {
                        return;
                    } else {
                        this_$iv2 = this_$iv;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> elements, int start, int end) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Object lock$iv$iv2;
        SnapshotStateList this_$iv;
        boolean z;
        Collection<? extends T> elements2 = elements;
        Intrinsics.checkNotNullParameter(elements2, "elements");
        int startSize = size();
        SnapshotStateList this_$iv2 = this;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                try {
                    StateRecord firstStateRecord = this_$iv2.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                    currentModification$iv = current$iv.getModification();
                    list$runtime_release = current$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder$iv = list$runtime_release.builder();
            PersistentList.Builder it = builder$iv;
            it.subList(start, end).retainAll(elements2);
            Unit unit2 = Unit.INSTANCE;
            PersistentList newList$iv = builder$iv.build();
            if (Intrinsics.areEqual(newList$iv, list$runtime_release)) {
                break;
            }
            SnapshotStateList this_$iv$iv = this_$iv2;
            StateRecord firstStateRecord2 = this_$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    try {
                        try {
                            StateListStateRecord $this$mutate_u24lambda_u2418$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this_$iv$iv, current);
                            lock$iv$iv2 = SnapshotStateListKt.sync;
                            synchronized (lock$iv$iv2) {
                                try {
                                    if ($this$mutate_u24lambda_u2418$iv.getModification() == currentModification$iv) {
                                        this_$iv = this_$iv2;
                                        try {
                                            $this$mutate_u24lambda_u2418$iv.setList$runtime_release(newList$iv);
                                            z = true;
                                            $this$mutate_u24lambda_u2418$iv.setModification$runtime_release($this$mutate_u24lambda_u2418$iv.getModification() + 1);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } else {
                                        this_$iv = this_$iv2;
                                        z = false;
                                    }
                                    try {
                                        SnapshotKt.notifyWrite(current, this_$iv$iv);
                                        if (z) {
                                            break;
                                        }
                                        elements2 = elements;
                                        this_$iv2 = this_$iv;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }
        return startSize - size();
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$withCurrent$iv$iv = (StateListStateRecord) firstStateRecord;
        StateListStateRecord $this$_get_debuggerDisplayValue__u24lambda_u2414 = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv);
        return $this$_get_debuggerDisplayValue__u24lambda_u2414.getList$runtime_release();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$writable$iv = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        Object lock$iv$iv$iv = SnapshotKt.getLock();
        synchronized (lock$iv$iv$iv) {
            try {
                current = Snapshot.INSTANCE.getCurrent();
                invoke = block.invoke(SnapshotKt.writableRecord($this$writable$iv, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$withCurrent$iv = (StateListStateRecord) firstStateRecord;
        return block.invoke(SnapshotKt.current($this$withCurrent$iv));
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        Object lock$iv$iv;
        int currentModification$iv;
        PersistentList<T> list$runtime_release;
        Object result$iv;
        Object lock$iv$iv2;
        SnapshotStateList this_$iv;
        boolean z;
        SnapshotStateList this_$iv2 = this;
        while (true) {
            lock$iv$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv$iv) {
                try {
                    StateRecord firstStateRecord = this_$iv2.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current$iv = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv);
                    currentModification$iv = current$iv.getModification();
                    list$runtime_release = current$iv.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder$iv = list$runtime_release.builder();
            result$iv = block.invoke(builder$iv);
            PersistentList newList$iv = builder$iv.build();
            if (Intrinsics.areEqual(newList$iv, list$runtime_release)) {
                break;
            }
            SnapshotStateList this_$iv$iv = this_$iv2;
            StateRecord firstStateRecord2 = this_$iv$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord $this$mutate_u24lambda_u2418$iv = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv, this_$iv$iv, current);
                    lock$iv$iv2 = SnapshotStateListKt.sync;
                    synchronized (lock$iv$iv2) {
                        try {
                            if ($this$mutate_u24lambda_u2418$iv.getModification() == currentModification$iv) {
                                this_$iv = this_$iv2;
                                try {
                                    $this$mutate_u24lambda_u2418$iv.setList$runtime_release(newList$iv);
                                    z = true;
                                    $this$mutate_u24lambda_u2418$iv.setModification$runtime_release($this$mutate_u24lambda_u2418$iv.getModification() + 1);
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                this_$iv = this_$iv2;
                                z = false;
                            }
                            try {
                                SnapshotKt.notifyWrite(current, this_$iv$iv);
                                if (z) {
                                    break;
                                }
                                this_$iv2 = this_$iv;
                            } catch (Throwable th3) {
                                th = th3;
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
        }
        return ((Boolean) result$iv).booleanValue();
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> block) {
        Object lock$iv;
        int currentModification;
        PersistentList<T> list$runtime_release;
        R invoke;
        Snapshot current;
        Object lock$iv2;
        int i;
        do {
            lock$iv = SnapshotStateListKt.sync;
            synchronized (lock$iv) {
                try {
                    StateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateRecord $this$withCurrent$iv$iv = (StateListStateRecord) firstStateRecord;
                    StateListStateRecord current2 = (StateListStateRecord) SnapshotKt.current($this$withCurrent$iv$iv);
                    currentModification = current2.getModification();
                    list$runtime_release = current2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = block.invoke(builder);
            PersistentList newList = builder.build();
            if (Intrinsics.areEqual(newList, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv) {
                try {
                    current = Snapshot.INSTANCE.getCurrent();
                    StateListStateRecord $this$mutate_u24lambda_u2418 = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv, this, current);
                    lock$iv2 = SnapshotStateListKt.sync;
                    synchronized (lock$iv2) {
                        try {
                            if ($this$mutate_u24lambda_u2418.getModification() == currentModification) {
                                try {
                                    $this$mutate_u24lambda_u2418.setList$runtime_release(newList);
                                    $this$mutate_u24lambda_u2418.setModification$runtime_release($this$mutate_u24lambda_u2418.getModification() + 1);
                                    i = 1;
                                } catch (Throwable th2) {
                                    th = th2;
                                    InlineMarker.finallyStart(1);
                                    InlineMarker.finallyEnd(1);
                                    throw th;
                                }
                            } else {
                                i = 0;
                            }
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                } catch (Throwable th4) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th4;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (i == 0);
        return invoke;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cf, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        if (r0 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r27) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update(kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c7, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        r19 = r1;
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00dd, code lost:
    
        if (r0 == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00df, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean conditionalUpdate(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r26) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(kotlin.jvm.functions.Function1):boolean");
    }
}
