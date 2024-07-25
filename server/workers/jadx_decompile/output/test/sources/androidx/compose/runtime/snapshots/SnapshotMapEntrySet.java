package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SnapshotStateMap.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0096\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object element) {
        return ((Boolean) add((Map.Entry) element)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection elements) {
        return ((Boolean) addAll(elements)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (TypeIntrinsics.isMutableMapEntry(element)) {
            return contains((Map.Entry) element);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object element) {
        if (TypeIntrinsics.isMutableMapEntry(element)) {
            return remove((Map.Entry) element);
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public Void add(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection
    public Void addAll(Collection<? extends Map.Entry<K, V>> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public boolean remove(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return getMap().remove(element.getKey()) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean removed = false;
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            Map.Entry element = (Map.Entry) it.next();
            removed = getMap().remove(element.getKey()) != null || removed;
        }
        return removed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Object lock$iv$iv$iv;
        PersistentMap<K, V> map$runtime_release;
        int currentModification$iv$iv;
        boolean z;
        Object lock$iv$iv$iv2;
        SnapshotStateMap this_$iv;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> $this$associate$iv = elements;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Pair pair = TuplesKt.to(it.getKey(), it.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Map entries = linkedHashMap;
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
            Iterator<Map.Entry<K, V>> it2 = this_$iv2.entrySet().iterator();
            while (true) {
                z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry$iv = it2.next();
                if ((entries.containsKey(entry$iv.getKey()) && Intrinsics.areEqual(entries.get(entry$iv.getKey()), entry$iv.getValue())) ? false : true) {
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
                        Map entries2 = entries;
                        try {
                            SnapshotStateMap.StateMapStateRecord $this$mutate_u24lambda_u2411$iv$iv = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv$iv$iv, this_$iv2, current);
                            lock$iv$iv$iv2 = SnapshotStateMapKt.sync;
                            synchronized (lock$iv$iv$iv2) {
                                try {
                                    if ($this$mutate_u24lambda_u2411$iv$iv.getModification() == currentModification$iv$iv) {
                                        this_$iv = this_$iv2;
                                        try {
                                            $this$mutate_u24lambda_u2411$iv$iv.setMap$runtime_release(newMap$iv$iv);
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
                                        entries = entries2;
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

    public boolean contains(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(getMap().get(element.getKey()), element.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> $this$all$iv = elements;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            if (!contains((Object) it)) {
                return false;
            }
        }
        return true;
    }
}
