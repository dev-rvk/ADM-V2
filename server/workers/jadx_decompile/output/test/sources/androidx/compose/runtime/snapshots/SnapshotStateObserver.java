package androidx.compose.runtime.snapshots;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SnapshotStateObserver.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00014B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0001J)\u0010\u001f\u001a\u00020\u00052!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00130\u0003J\b\u0010!\u001a\u00020\u0013H\u0002J&\u0010\"\u001a\u00020\u0011\"\b\b\u0000\u0010#*\u00020\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010%\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001c\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010)\u001a\u00020\rJ?\u0010*\u001a\u00020\u0005\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H#2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0016\u00103\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final MutableVector<ObservedScopeMap> observedScopeMaps;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges;
    private final Function1<Object, Unit> readObserver;
    private boolean sendingNotifications;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> onChangedExecutor) {
        Intrinsics.checkNotNullParameter(onChangedExecutor, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor;
        this.pendingChanges = new AtomicReference<>(null);
        this.applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                invoke2(set, snapshot);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<? extends Object> applied, Snapshot snapshot) {
                boolean drainChanges;
                Intrinsics.checkNotNullParameter(applied, "applied");
                Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                SnapshotStateObserver.this.addChanges(applied);
                drainChanges = SnapshotStateObserver.this.drainChanges();
                if (drainChanges) {
                    SnapshotStateObserver.this.sendNotifications();
                }
            }
        };
        this.readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                invoke2(p1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object state) {
                boolean z;
                MutableVector mutableVector;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap;
                Intrinsics.checkNotNullParameter(state, "state");
                z = SnapshotStateObserver.this.isPaused;
                if (!z) {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        observedScopeMap = snapshotStateObserver.currentMap;
                        Intrinsics.checkNotNull(observedScopeMap);
                        observedScopeMap.recordRead(state);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        };
        this.observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        boolean z2;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean hasValues = false;
        while (true) {
            Set notifications = removeChanges();
            if (notifications == null) {
                return hasValues;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector this_$iv$iv = this.observedScopeMaps;
                int size$iv$iv = this_$iv$iv.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                        if (!scopeMap.recordInvalidation(notifications) && !hasValues) {
                            z2 = false;
                            hasValues = z2;
                            i$iv$iv++;
                        }
                        z2 = true;
                        hasValues = z2;
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableVector mutableVector;
                boolean z;
                boolean drainChanges;
                MutableVector this_$iv;
                do {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        z = snapshotStateObserver.sendingNotifications;
                        if (!z) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                this_$iv = snapshotStateObserver.observedScopeMaps;
                                int size$iv = this_$iv.getSize();
                                if (size$iv > 0) {
                                    int i$iv = 0;
                                    Object[] content$iv = this_$iv.getContent();
                                    do {
                                        SnapshotStateObserver.ObservedScopeMap scopeMap = (SnapshotStateObserver.ObservedScopeMap) content$iv[i$iv];
                                        scopeMap.notifyInvalidatedScopes();
                                        i$iv++;
                                    } while (i$iv < size$iv);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } finally {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    drainChanges = SnapshotStateObserver.this.drainChanges();
                } while (drainChanges);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object old;
        Collection plus;
        do {
            old = this.pendingChanges.get();
            if (old == null) {
                plus = set;
            } else if (old instanceof Set) {
                plus = CollectionsKt.listOf((Object[]) new Set[]{old, set});
            } else {
                if (!(old instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                plus = CollectionsKt.plus((Collection) old, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, old, plus));
    }

    private final Set<Object> removeChanges() {
        Object old;
        Set result;
        Object obj;
        do {
            old = this.pendingChanges.get();
            Object obj2 = null;
            if (old == null) {
                return null;
            }
            if (old instanceof Set) {
                result = (Set) old;
                obj = null;
            } else if (old instanceof List) {
                result = (Set) ((List) old).get(0);
                if (((List) old).size() == 2) {
                    obj2 = ((List) old).get(1);
                } else if (((List) old).size() > 2) {
                    obj2 = ((List) old).subList(1, ((List) old).size());
                }
                obj = obj2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, old, obj));
        return result;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector this_$iv = this.observedScopeMaps;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    do {
                        block.invoke(content$iv[i$iv]);
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap scopeMap;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onValueChangedForScope, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.observedScopeMaps) {
            scopeMap = ensureMap(onValueChangedForScope);
        }
        boolean oldPaused = this.isPaused;
        ObservedScopeMap oldMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = scopeMap;
            scopeMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = oldMap;
            this.isPaused = oldPaused;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean oldPaused = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = oldPaused;
        }
    }

    public final void clear(Object scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ObservedScopeMap it = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                    it.clearScopeObservations(scope);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                    scopeMap.removeScopeIf(predicate);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(changes, snapshot);
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                    scopeMap.clear();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        Object item$iv;
        MutableVector this_$iv = this.observedScopeMaps;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                item$iv = content$iv[i$iv];
                ObservedScopeMap it = (ObservedScopeMap) item$iv;
                if (it.getOnChanged() == onChanged) {
                    break;
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        item$iv = null;
        ObservedScopeMap scopeMap = (ObservedScopeMap) item$iv;
        if (scopeMap == null) {
            Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            ObservedScopeMap map = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
            this.observedScopeMaps.add(map);
            return map;
        }
        return scopeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020\u0004J0\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040'J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010+J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0001J(\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0002J)\u00100\u001a\u00020\u00042!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020)0\u0003J\u0012\u00104\u001a\u00020\u00042\n\u00105\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class ObservedScopeMap {
        private Object currentScope;
        private IdentityArrayIntMap currentScopeReads;
        private int currentToken;
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates;
        private int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver;
        private final IdentityArraySet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues;
        private final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues;
        private final MutableVector<DerivedState<?>> statesToReread;
        private final IdentityScopeMap<Object> valueToScopes;

        public ObservedScopeMap(Function1<Object, Unit> onChanged) {
            Intrinsics.checkNotNullParameter(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.currentToken = -1;
            this.valueToScopes = new IdentityScopeMap<>();
            this.scopeToValues = new IdentityArrayMap<>(0, 1, null);
            this.invalidated = new IdentityArraySet<>();
            this.statesToReread = new MutableVector<>(new DerivedState[16], 0);
            this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
                @Override // androidx.compose.runtime.DerivedStateObserver
                public void start(DerivedState<?> derivedState) {
                    int i;
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i + 1;
                }

                @Override // androidx.compose.runtime.DerivedStateObserver
                public void done(DerivedState<?> derivedState) {
                    int i;
                    Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                    i = observedScopeMap.deriveStateScopeCount;
                    observedScopeMap.deriveStateScopeCount = i - 1;
                }
            };
            this.dependencyToDerivedStates = new IdentityScopeMap<>();
            this.recordedDerivedStateValues = new HashMap<>();
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Object scope = this.currentScope;
            Intrinsics.checkNotNull(scope);
            int i = this.currentToken;
            IdentityArrayIntMap it = this.currentScopeReads;
            if (it == null) {
                it = new IdentityArrayIntMap();
                this.currentScopeReads = it;
                this.scopeToValues.set(scope, it);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, scope, it);
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, IdentityArrayIntMap recordedValues) {
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int previousToken = recordedValues.add(value, currentToken);
            if ((value instanceof DerivedState) && previousToken != currentToken) {
                DerivedState.Record record = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, record.getCurrentValue());
                Object[] dependencies = record.getDependencies();
                IdentityScopeMap dependencyToDerivedStates = this.dependencyToDerivedStates;
                dependencyToDerivedStates.removeScope(value);
                for (Object dependency : dependencies) {
                    if (dependency == null) {
                        break;
                    }
                    dependencyToDerivedStates.add(dependency, value);
                }
            }
            if (previousToken == -1) {
                this.valueToScopes.add(value, currentScope);
            }
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(readObserver, "readObserver");
            Intrinsics.checkNotNullParameter(block, "block");
            Object previousScope = this.currentScope;
            IdentityArrayIntMap previousReads = this.currentScopeReads;
            int previousToken = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver observer$iv = this.derivedStateObserver;
            MutableVector observers$iv = SnapshotStateKt.derivedStateObservers();
            try {
                observers$iv.add(observer$iv);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                observers$iv.removeAt(observers$iv.getSize() - 1);
                Object obj = this.currentScope;
                Intrinsics.checkNotNull(obj);
                clearObsoleteStateReads(obj);
                this.currentScope = previousScope;
                this.currentScopeReads = previousReads;
                this.currentToken = previousToken;
            } catch (Throwable th) {
                observers$iv.removeAt(observers$iv.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int currentToken;
            int currentToken2 = this.currentToken;
            IdentityArrayIntMap this_$iv = this.currentScopeReads;
            if (this_$iv == null) {
                return;
            }
            Object[] keys$iv = this_$iv.getKeys();
            int[] values$iv = this_$iv.getValues();
            int size$iv = this_$iv.getSize();
            int destinationIndex$iv = 0;
            int i$iv = 0;
            while (i$iv < size$iv) {
                Object key$iv = keys$iv[i$iv];
                Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type kotlin.Any");
                int value$iv = values$iv[i$iv];
                boolean z = value$iv != currentToken2;
                boolean willRemove = z;
                if (!willRemove) {
                    currentToken = currentToken2;
                } else {
                    currentToken = currentToken2;
                    removeObservation(scope, key$iv);
                }
                if (!z) {
                    if (destinationIndex$iv != i$iv) {
                        keys$iv[destinationIndex$iv] = key$iv;
                        values$iv[destinationIndex$iv] = value$iv;
                    }
                    destinationIndex$iv++;
                }
                i$iv++;
                currentToken2 = currentToken;
            }
            for (int i$iv2 = destinationIndex$iv; i$iv2 < size$iv; i$iv2++) {
                keys$iv[i$iv2] = null;
            }
            this_$iv.size = destinationIndex$iv;
        }

        public final void clearScopeObservations(Object scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            IdentityArrayIntMap recordedValues = this.scopeToValues.remove(scope);
            if (recordedValues == null) {
                return;
            }
            Object[] keys$iv = recordedValues.getKeys();
            int[] values$iv = recordedValues.getValues();
            int size$iv = recordedValues.getSize();
            for (int i$iv = 0; i$iv < size$iv; i$iv++) {
                Object value = keys$iv[i$iv];
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                int i = values$iv[i$iv];
                removeObservation(scope, value);
            }
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            int $i$f$removeIf;
            int i;
            Function1<Object, Boolean> predicate2 = predicate;
            Intrinsics.checkNotNullParameter(predicate2, "predicate");
            IdentityArrayMap this_$iv = this.scopeToValues;
            int $i$f$removeIf2 = 0;
            int current$iv = 0;
            int index$iv = 0;
            int size = this_$iv.getSize();
            while (index$iv < size) {
                Object key$iv = this_$iv.getKeys()[index$iv];
                Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                Object value$iv = this_$iv.getValues()[index$iv];
                IdentityArrayIntMap valueSet = (IdentityArrayIntMap) value$iv;
                Boolean invoke = predicate2.invoke(key$iv);
                boolean willRemove = invoke.booleanValue();
                if (!willRemove) {
                    $i$f$removeIf = $i$f$removeIf2;
                    i = size;
                } else {
                    Object[] keys$iv = valueSet.getKeys();
                    int[] values$iv = valueSet.getValues();
                    int size$iv = valueSet.getSize();
                    $i$f$removeIf = $i$f$removeIf2;
                    int $i$f$removeIf3 = 0;
                    while ($i$f$removeIf3 < size$iv) {
                        int size$iv2 = size$iv;
                        Object value = keys$iv[$i$f$removeIf3];
                        int i2 = size;
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                        int i3 = values$iv[$i$f$removeIf3];
                        removeObservation(key$iv, value);
                        $i$f$removeIf3++;
                        size$iv = size$iv2;
                        size = i2;
                    }
                    i = size;
                }
                if (!invoke.booleanValue()) {
                    if (current$iv != index$iv) {
                        this_$iv.getKeys()[current$iv] = key$iv;
                        this_$iv.getValues()[current$iv] = this_$iv.getValues()[index$iv];
                    }
                    current$iv++;
                }
                index$iv++;
                predicate2 = predicate;
                $i$f$removeIf2 = $i$f$removeIf;
                size = i;
            }
            if (this_$iv.getSize() <= current$iv) {
                return;
            }
            int size2 = this_$iv.getSize();
            for (int index$iv2 = current$iv; index$iv2 < size2; index$iv2++) {
                this_$iv.getKeys()[index$iv2] = null;
                this_$iv.getValues()[index$iv2] = null;
            }
            this_$iv.size = current$iv;
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if ((value instanceof DerivedState) && !this.valueToScopes.contains(value)) {
                this.dependencyToDerivedStates.removeScope(value);
                this.recordedDerivedStateValues.remove(value);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final boolean recordInvalidation(Set<? extends Object> changes) {
            Iterable $this$forEach$iv$iv;
            IdentityScopeMap dependencyToDerivedStates;
            HashMap recordedDerivedStateValues;
            Set $this$fastForEach$iv;
            int $i$f$fastForEach;
            IdentityArraySet this_$iv$iv;
            int $i$f$fastForEach2;
            Object[] values$iv$iv;
            Intrinsics.checkNotNullParameter(changes, "changes");
            boolean hasValues = false;
            IdentityScopeMap dependencyToDerivedStates2 = this.dependencyToDerivedStates;
            HashMap recordedDerivedStateValues2 = this.recordedDerivedStateValues;
            IdentityScopeMap valueToScopes = this.valueToScopes;
            IdentityArraySet invalidated = this.invalidated;
            Set $this$fastForEach$iv2 = changes;
            int $i$f$fastForEach3 = 0;
            if ($this$fastForEach$iv2 instanceof IdentityArraySet) {
                IdentityArraySet this_$iv$iv2 = (IdentityArraySet) $this$fastForEach$iv2;
                int $i$f$fastForEach4 = 0;
                Object[] values$iv$iv2 = this_$iv$iv2.getValues();
                int i$iv$iv = 0;
                int size = this_$iv$iv2.size();
                while (i$iv$iv < size) {
                    boolean hasValues2 = hasValues;
                    Object value = values$iv$iv2[i$iv$iv];
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (dependencyToDerivedStates2.contains(value)) {
                        $i$f$fastForEach = $i$f$fastForEach3;
                        int index$iv = IdentityScopeMap.access$find(dependencyToDerivedStates2, value);
                        if (index$iv >= 0) {
                            IdentityArraySet this_$iv$iv3 = IdentityScopeMap.access$scopeSetAt(dependencyToDerivedStates2, index$iv);
                            Object[] values$iv$iv3 = this_$iv$iv3.getValues();
                            int size2 = this_$iv$iv3.size();
                            int index$iv2 = 0;
                            while (index$iv2 < size2) {
                                int i = size2;
                                Object obj = values$iv$iv3[index$iv2];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                DerivedState derivedState = (DerivedState) obj;
                                Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                IdentityArraySet this_$iv$iv4 = this_$iv$iv2;
                                Object previousValue = recordedDerivedStateValues2.get(derivedState);
                                SnapshotMutationPolicy policy = derivedState.getPolicy();
                                if (policy == null) {
                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                }
                                SnapshotMutationPolicy policy2 = policy;
                                int $i$f$fastForEach5 = $i$f$fastForEach4;
                                Object[] values$iv$iv4 = values$iv$iv2;
                                if (policy2.equivalent(derivedState.getCurrentRecord().getCurrentValue(), previousValue)) {
                                    this.statesToReread.add(derivedState);
                                } else {
                                    int index$iv3 = IdentityScopeMap.access$find(valueToScopes, derivedState);
                                    if (index$iv3 >= 0) {
                                        IdentityArraySet this_$iv$iv5 = IdentityScopeMap.access$scopeSetAt(valueToScopes, index$iv3);
                                        Object[] values$iv$iv5 = this_$iv$iv5.getValues();
                                        int index$iv4 = this_$iv$iv5.size();
                                        int i$iv$iv2 = 0;
                                        while (i$iv$iv2 < index$iv4) {
                                            int i2 = index$iv4;
                                            Object scope = values$iv$iv5[i$iv$iv2];
                                            Intrinsics.checkNotNull(scope, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                            invalidated.add(scope);
                                            hasValues2 = true;
                                            i$iv$iv2++;
                                            index$iv4 = i2;
                                        }
                                    }
                                }
                                index$iv2++;
                                size2 = i;
                                this_$iv$iv2 = this_$iv$iv4;
                                values$iv$iv2 = values$iv$iv4;
                                $i$f$fastForEach4 = $i$f$fastForEach5;
                            }
                            this_$iv$iv = this_$iv$iv2;
                            $i$f$fastForEach2 = $i$f$fastForEach4;
                            values$iv$iv = values$iv$iv2;
                        } else {
                            this_$iv$iv = this_$iv$iv2;
                            $i$f$fastForEach2 = $i$f$fastForEach4;
                            values$iv$iv = values$iv$iv2;
                        }
                    } else {
                        $i$f$fastForEach = $i$f$fastForEach3;
                        this_$iv$iv = this_$iv$iv2;
                        $i$f$fastForEach2 = $i$f$fastForEach4;
                        values$iv$iv = values$iv$iv2;
                    }
                    int index$iv5 = IdentityScopeMap.access$find(valueToScopes, value);
                    if (index$iv5 >= 0) {
                        IdentityArraySet this_$iv$iv6 = IdentityScopeMap.access$scopeSetAt(valueToScopes, index$iv5);
                        Object[] values$iv$iv6 = this_$iv$iv6.getValues();
                        int size3 = this_$iv$iv6.size();
                        int i$iv$iv3 = 0;
                        while (i$iv$iv3 < size3) {
                            int i3 = size3;
                            Object scope2 = values$iv$iv6[i$iv$iv3];
                            Intrinsics.checkNotNull(scope2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            invalidated.add(scope2);
                            hasValues2 = true;
                            i$iv$iv3++;
                            size3 = i3;
                        }
                    }
                    hasValues = hasValues2;
                    i$iv$iv++;
                    $i$f$fastForEach3 = $i$f$fastForEach;
                    this_$iv$iv2 = this_$iv$iv;
                    values$iv$iv2 = values$iv$iv;
                    $i$f$fastForEach4 = $i$f$fastForEach2;
                }
            } else {
                Set $this$forEach$iv$iv2 = $this$fastForEach$iv2;
                for (Object element$iv$iv : $this$forEach$iv$iv2) {
                    if (dependencyToDerivedStates2.contains(element$iv$iv)) {
                        IdentityScopeMap this_$iv = dependencyToDerivedStates2;
                        boolean hasValues3 = hasValues;
                        int index$iv6 = IdentityScopeMap.access$find(this_$iv, element$iv$iv);
                        if (index$iv6 >= 0) {
                            IdentityArraySet this_$iv$iv7 = IdentityScopeMap.access$scopeSetAt(this_$iv, index$iv6);
                            Object[] values$iv$iv7 = this_$iv$iv7.getValues();
                            int index$iv7 = this_$iv$iv7.size();
                            $this$forEach$iv$iv = $this$forEach$iv$iv2;
                            int i$iv$iv4 = 0;
                            while (i$iv$iv4 < index$iv7) {
                                int i4 = index$iv7;
                                Object obj2 = values$iv$iv7[i$iv$iv4];
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                DerivedState derivedState2 = (DerivedState) obj2;
                                Intrinsics.checkNotNull(derivedState2, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                                IdentityScopeMap dependencyToDerivedStates3 = dependencyToDerivedStates2;
                                Object previousValue2 = recordedDerivedStateValues2.get(derivedState2);
                                SnapshotMutationPolicy policy3 = derivedState2.getPolicy();
                                if (policy3 == null) {
                                    policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                }
                                SnapshotMutationPolicy policy4 = policy3;
                                HashMap recordedDerivedStateValues3 = recordedDerivedStateValues2;
                                Set $this$fastForEach$iv3 = $this$fastForEach$iv2;
                                if (policy4.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), previousValue2)) {
                                    this.statesToReread.add(derivedState2);
                                } else {
                                    int index$iv8 = IdentityScopeMap.access$find(valueToScopes, derivedState2);
                                    if (index$iv8 >= 0) {
                                        IdentityArraySet this_$iv$iv8 = IdentityScopeMap.access$scopeSetAt(valueToScopes, index$iv8);
                                        Object[] values$iv$iv8 = this_$iv$iv8.getValues();
                                        int index$iv9 = this_$iv$iv8.size();
                                        int i$iv$iv5 = 0;
                                        while (i$iv$iv5 < index$iv9) {
                                            int i5 = index$iv9;
                                            Object scope3 = values$iv$iv8[i$iv$iv5];
                                            Intrinsics.checkNotNull(scope3, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                            invalidated.add(scope3);
                                            hasValues3 = true;
                                            i$iv$iv5++;
                                            index$iv9 = i5;
                                        }
                                    }
                                }
                                i$iv$iv4++;
                                index$iv7 = i4;
                                dependencyToDerivedStates2 = dependencyToDerivedStates3;
                                $this$fastForEach$iv2 = $this$fastForEach$iv3;
                                recordedDerivedStateValues2 = recordedDerivedStateValues3;
                            }
                            dependencyToDerivedStates = dependencyToDerivedStates2;
                            recordedDerivedStateValues = recordedDerivedStateValues2;
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            hasValues = hasValues3;
                        } else {
                            $this$forEach$iv$iv = $this$forEach$iv$iv2;
                            dependencyToDerivedStates = dependencyToDerivedStates2;
                            recordedDerivedStateValues = recordedDerivedStateValues2;
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            hasValues = hasValues3;
                        }
                    } else {
                        $this$forEach$iv$iv = $this$forEach$iv$iv2;
                        dependencyToDerivedStates = dependencyToDerivedStates2;
                        recordedDerivedStateValues = recordedDerivedStateValues2;
                        $this$fastForEach$iv = $this$fastForEach$iv2;
                    }
                    int index$iv10 = IdentityScopeMap.access$find(valueToScopes, element$iv$iv);
                    if (index$iv10 >= 0) {
                        IdentityArraySet this_$iv$iv9 = IdentityScopeMap.access$scopeSetAt(valueToScopes, index$iv10);
                        Object[] values$iv$iv9 = this_$iv$iv9.getValues();
                        boolean hasValues4 = hasValues;
                        int size4 = this_$iv$iv9.size();
                        int i$iv$iv6 = 0;
                        while (i$iv$iv6 < size4) {
                            int i6 = size4;
                            Object scope4 = values$iv$iv9[i$iv$iv6];
                            Intrinsics.checkNotNull(scope4, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            invalidated.add(scope4);
                            hasValues4 = true;
                            i$iv$iv6++;
                            size4 = i6;
                        }
                        hasValues = hasValues4;
                    }
                    $this$forEach$iv$iv2 = $this$forEach$iv$iv;
                    dependencyToDerivedStates2 = dependencyToDerivedStates;
                    $this$fastForEach$iv2 = $this$fastForEach$iv;
                    recordedDerivedStateValues2 = recordedDerivedStateValues;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector this_$iv2 = this.statesToReread;
                int size$iv = this_$iv2.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv2.getContent();
                    do {
                        DerivedState it = (DerivedState) content$iv[i$iv];
                        rereadDerivedState(it);
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.statesToReread.clear();
            }
            return hasValues;
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            IdentityArrayMap scopeToValues = this.scopeToValues;
            int token = SnapshotKt.currentSnapshot().getId();
            IdentityScopeMap this_$iv = this.valueToScopes;
            int index$iv = IdentityScopeMap.access$find(this_$iv, derivedState);
            if (index$iv < 0) {
                return;
            }
            IdentityArraySet this_$iv$iv = IdentityScopeMap.access$scopeSetAt(this_$iv, index$iv);
            Object[] values$iv$iv = this_$iv$iv.getValues();
            int size = this_$iv$iv.size();
            for (int i$iv$iv = 0; i$iv$iv < size; i$iv$iv++) {
                Object scope = values$iv$iv[i$iv$iv];
                Intrinsics.checkNotNull(scope, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                IdentityArrayIntMap it = scopeToValues.get(scope);
                if (it == null) {
                    it = new IdentityArrayIntMap();
                    scopeToValues.set(scope, it);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, token, scope, it);
            }
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet invalidated = this.invalidated;
            Function1 block$iv = this.onChanged;
            Object[] values$iv = invalidated.getValues();
            int size = invalidated.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Object obj = values$iv[i$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                block$iv.invoke(obj);
            }
            invalidated.clear();
        }
    }
}
