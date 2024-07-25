package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: LruCache.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\b\u001a\u00020\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010)J\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010)J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,J'\u0010-\u001a\u0002H.\"\u0004\b\u0002\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "keySet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "missCount", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "putCount", "<set-?>", "size", "()I", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "synchronizedValue", "R", "block", "Lkotlin/Function0;", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toString", "", "trimToSize", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public final int size() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.size;
        }
        return i;
    }

    public LruCache(int maxSize) {
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.maxSize = maxSize;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    public void resize(int maxSize) {
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            this.maxSize = maxSize;
            Unit unit = Unit.INSTANCE;
        }
        trimToSize(maxSize);
    }

    public final V get(K key) {
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            V v = this.map.get(key);
            if (v != null) {
                this.keySet.remove(key);
                this.keySet.add(key);
                this.hitCount++;
                return v;
            }
            this.missCount++;
            V create = create(key);
            if (create == null) {
                return null;
            }
            SynchronizedObject lock$iv2 = this.monitor;
            synchronized (lock$iv2) {
                this.createCount++;
                V put = this.map.put(key, create);
                this.keySet.remove(key);
                this.keySet.add(key);
                if (put != null) {
                    this.map.put(key, put);
                    v = put;
                } else {
                    this.size = size() + safeSizeOf(key, create);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (v != null) {
                entryRemoved(false, key, create, v);
                return v;
            }
            trimToSize(this.maxSize);
            return create;
        }
    }

    public final V put(K key, V value) {
        V put;
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            this.putCount++;
            this.size = size() + safeSizeOf(key, value);
            put = this.map.put(key, value);
            if (put != null) {
                this.size = size() - safeSizeOf(key, put);
            }
            if (this.keySet.contains(key)) {
                this.keySet.remove(key);
            }
            this.keySet.add(key);
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void trimToSize(int maxSize) {
        while (true) {
            K k = null;
            V v = null;
            SynchronizedObject lock$iv = this.monitor;
            synchronized (lock$iv) {
                if (size() < 0 || ((this.map.isEmpty() && size() != 0) || this.map.isEmpty() != this.keySet.isEmpty())) {
                    break;
                }
                if (size() > maxSize && !this.map.isEmpty()) {
                    k = CollectionsKt.first(this.keySet);
                    V v2 = this.map.get(k);
                    if (v2 == null) {
                        throw new IllegalStateException("inconsistent state");
                    }
                    v = v2;
                    TypeIntrinsics.asMutableMap(this.map).remove(k);
                    TypeIntrinsics.asMutableCollection(this.keySet).remove(k);
                    int size = size();
                    Intrinsics.checkNotNull(k);
                    Intrinsics.checkNotNull(v);
                    this.size = size - safeSizeOf(k, v);
                    this.evictionCount++;
                }
                Unit unit = Unit.INSTANCE;
            }
            if (k != null || v != null) {
                Intrinsics.checkNotNull(k);
                Intrinsics.checkNotNull(v);
                entryRemoved(true, k, v, null);
            } else {
                return;
            }
        }
        throw new IllegalStateException("map/keySet size inconsistency");
    }

    public final V remove(K key) {
        V remove;
        if (key == null) {
            throw new NullPointerException();
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            remove = this.map.remove(key);
            this.keySet.remove(key);
            if (remove != null) {
                this.size = size() - safeSizeOf(key, remove);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (remove != null) {
            entryRemoved(false, key, remove, null);
        }
        return remove;
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    protected V create(K key) {
        return null;
    }

    private final int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (!(result >= 0)) {
            throw new IllegalStateException(("Negative size: " + key + '=' + value).toString());
        }
        return result;
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int maxSize() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator<K> it = this.keySet.iterator();
            while (it.hasNext()) {
                K next = it.next();
                V v = this.map.get(next);
                Intrinsics.checkNotNull(v);
                linkedHashMap2.put(next, v);
            }
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            int accesses = this.hitCount + this.missCount;
            int hitPercent = accesses != 0 ? (this.hitCount * 100) / accesses : 0;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + hitPercent + "%]";
        }
        return str;
    }

    public final <R> R synchronizedValue$ui_text_release(Function0<? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(block, "block");
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            try {
                invoke = block.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}
