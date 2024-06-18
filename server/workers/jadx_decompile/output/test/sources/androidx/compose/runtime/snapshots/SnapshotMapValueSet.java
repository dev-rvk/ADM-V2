package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotStateMap.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapValueSet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableValuesIterator;", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class SnapshotMapValueSet<K, V> extends SnapshotMapSet<K, V, V> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add((SnapshotMapValueSet<K, V>) obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection elements) {
        return ((Boolean) addAll(elements)).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapValueSet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    @Override // java.util.Set, java.util.Collection
    public Void add(V element) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection
    public Void addAll(Collection<? extends V> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public StateMapMutableValuesIterator<K, V> iterator() {
        return new StateMapMutableValuesIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        return getMap().removeValue$runtime_release(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Object lock$iv$iv$iv;
        PersistentMap<K, V> map$runtime_release;
        int currentModification$iv$iv;
        Object lock$iv$iv$iv2;
        SnapshotStateMap this_$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Set set = CollectionsKt.toSet(elements);
        SnapshotStateMap this_$iv2 = getMap();
        boolean removed$iv = false;
        while (true) {
            lock$iv$iv$iv = SnapshotStateMapKt.sync;
            synchronized (lock$iv$iv$iv) {
                try {
                    StateRecord firstStateRecord = this_$iv2.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateRecord $this$withCurrent$iv$iv$iv$iv = (SnapshotStateMap.StateMapStateRecord) firstStateRecord;
                    SnapshotStateMap.StateMapStateRecord current$iv$iv = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv$iv);
                    map$runtime_release = current$iv$iv.getMap$runtime_release();
                    currentModification$iv$iv = current$iv$iv.getModification();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder$iv$iv = map$runtime_release.builder2();
            PersistentMap.Builder it$iv = builder$iv$iv;
            for (Map.Entry entry$iv : this_$iv2.entrySet()) {
                if (set.contains(entry$iv.getValue())) {
                    it$iv.remove(entry$iv.getKey());
                    removed$iv = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap newMap$iv$iv = builder$iv$iv.build2();
            if (Intrinsics.areEqual(newMap$iv$iv, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = this_$iv2.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateRecord $this$writable$iv$iv$iv$iv = (SnapshotStateMap.StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    try {
                        Set set2 = set;
                        try {
                            SnapshotStateMap.StateMapStateRecord $this$mutate_u24lambda_u2411$iv$iv = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, this_$iv2, current);
                            lock$iv$iv$iv2 = SnapshotStateMapKt.sync;
                            synchronized (lock$iv$iv$iv2) {
                                try {
                                    if ($this$mutate_u24lambda_u2411$iv$iv.getModification() == currentModification$iv$iv) {
                                        this_$iv = this_$iv2;
                                        try {
                                            $this$mutate_u24lambda_u2411$iv$iv.setMap$runtime_release(newMap$iv$iv);
                                            z = true;
                                            $this$mutate_u24lambda_u2411$iv$iv.setModification$runtime_release($this$mutate_u24lambda_u2411$iv$iv.getModification() + 1);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } else {
                                        this_$iv = this_$iv2;
                                        z = false;
                                    }
                                    try {
                                        SnapshotKt.notifyWrite(current, this_$iv2);
                                        if (z) {
                                            break;
                                        }
                                        set = set2;
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
        return removed$iv;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Object lock$iv$iv$iv;
        PersistentMap<K, V> map$runtime_release;
        int currentModification$iv$iv;
        Object lock$iv$iv$iv2;
        Set set;
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Set set2 = CollectionsKt.toSet(elements);
        SnapshotStateMap this_$iv = getMap();
        boolean removed$iv = false;
        while (true) {
            lock$iv$iv$iv = SnapshotStateMapKt.sync;
            synchronized (lock$iv$iv$iv) {
                try {
                    StateRecord firstStateRecord = this_$iv.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateRecord $this$withCurrent$iv$iv$iv$iv = (SnapshotStateMap.StateMapStateRecord) firstStateRecord;
                    SnapshotStateMap.StateMapStateRecord current$iv$iv = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current($this$withCurrent$iv$iv$iv$iv);
                    map$runtime_release = current$iv$iv.getMap$runtime_release();
                    currentModification$iv$iv = current$iv$iv.getModification();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder$iv$iv = map$runtime_release.builder2();
            PersistentMap.Builder it$iv = builder$iv$iv;
            for (Map.Entry entry$iv : this_$iv.entrySet()) {
                if (!set2.contains(entry$iv.getValue())) {
                    it$iv.remove(entry$iv.getKey());
                    removed$iv = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap newMap$iv$iv = builder$iv$iv.build2();
            if (Intrinsics.areEqual(newMap$iv$iv, map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = this_$iv.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateRecord $this$writable$iv$iv$iv$iv = (SnapshotStateMap.StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            Object lock$iv$iv$iv$iv$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv$iv$iv$iv$iv) {
                try {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    try {
                        try {
                            SnapshotStateMap.StateMapStateRecord $this$mutate_u24lambda_u2411$iv$iv = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, this_$iv, current);
                            lock$iv$iv$iv2 = SnapshotStateMapKt.sync;
                            synchronized (lock$iv$iv$iv2) {
                                try {
                                    if ($this$mutate_u24lambda_u2411$iv$iv.getModification() == currentModification$iv$iv) {
                                        set = set2;
                                        try {
                                            $this$mutate_u24lambda_u2411$iv$iv.setMap$runtime_release(newMap$iv$iv);
                                            $this$mutate_u24lambda_u2411$iv$iv.setModification$runtime_release($this$mutate_u24lambda_u2411$iv$iv.getModification() + 1);
                                            z = true;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            throw th;
                                        }
                                    } else {
                                        set = set2;
                                        z = false;
                                    }
                                    try {
                                        SnapshotKt.notifyWrite(current, this_$iv);
                                        if (z) {
                                            break;
                                        }
                                        set2 = set;
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
        return removed$iv;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return getMap().containsValue(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> $this$all$iv = elements;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!getMap().containsValue(element$iv)) {
                return false;
            }
        }
        return true;
    }
}
