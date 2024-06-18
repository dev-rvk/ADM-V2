package androidx.compose.runtime;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DerivedState.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes.dex */
public final class DerivedState<T> implements StateObject, androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first;
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> calculation, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        this.calculation = calculation;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* compiled from: DerivedState.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 /*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001/B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u001a\u0010(\u001a\u00020)2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-J\u001a\u0010.\u001a\u00020\b2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030+2\u0006\u0010,\u001a\u00020-R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u00060"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "_dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "get_dependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "set_dependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "result", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    /* loaded from: classes.dex */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private IdentityArrayMap<StateObject, Integer> _dependencies;
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        /* compiled from: DerivedState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public final IdentityArrayMap<StateObject, Integer> get_dependencies() {
            return this._dependencies;
        }

        public final void set_dependencies(IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this._dependencies = identityArrayMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ResultRecord other = (ResultRecord) value;
            this._dependencies = other._dependencies;
            this.result = other.result;
            this.resultHash = other.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        public final boolean isValid(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            int i;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                z = false;
                if (this.validSnapshotId == snapshot.getId()) {
                    if (this.validSnapshotWriteCount == snapshot.getWriteCount()) {
                        i = 0;
                    }
                }
                i = 1;
            }
            int $i$f$sync = i;
            if (this.result != Unset && ($i$f$sync == 0 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            boolean isValid = z;
            if (isValid && $i$f$sync != 0) {
                Object lock$iv$iv2 = SnapshotKt.getLock();
                synchronized (lock$iv$iv2) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return isValid;
        }

        public final int readableHash(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            IdentityArrayMap dependencies;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            int hash = 7;
            Object lock$iv$iv = SnapshotKt.getLock();
            synchronized (lock$iv$iv) {
                dependencies = this._dependencies;
            }
            if (dependencies != null) {
                MutableVector observers$iv = SnapshotStateKt.derivedStateObservers();
                int size$iv$iv = observers$iv.getSize();
                int i = 1;
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = observers$iv.getContent();
                    do {
                        DerivedStateObserver it$iv = (DerivedStateObserver) content$iv$iv[i$iv$iv];
                        it$iv.start(derivedState);
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                int index$iv = 0;
                try {
                    int size = dependencies.getSize();
                    while (index$iv < size) {
                        Object obj = dependencies.getKeys()[index$iv];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        int readLevel = ((Number) dependencies.getValues()[index$iv]).intValue();
                        StateObject stateObject = (StateObject) obj;
                        if (readLevel == i) {
                            StateRecord record = stateObject instanceof DerivedState ? ((DerivedState) stateObject).current(snapshot) : SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            hash = (((hash * 31) + ActualJvm_jvmKt.identityHashCode(record)) * 31) + record.getSnapshotId();
                        }
                        index$iv++;
                        i = 1;
                    }
                    Unit unit = Unit.INSTANCE;
                    int size$iv$iv2 = observers$iv.getSize();
                    if (size$iv$iv2 > 0) {
                        int i$iv$iv2 = 0;
                        Object[] content$iv$iv2 = observers$iv.getContent();
                        do {
                            DerivedStateObserver it$iv2 = (DerivedStateObserver) content$iv$iv2[i$iv$iv2];
                            it$iv2.done(derivedState);
                            i$iv$iv2++;
                        } while (i$iv$iv2 < size$iv$iv2);
                    }
                } catch (Throwable th) {
                    int size$iv$iv3 = observers$iv.getSize();
                    if (size$iv$iv3 > 0) {
                        int i$iv$iv3 = 0;
                        Object[] content$iv$iv3 = observers$iv.getContent();
                        do {
                            DerivedStateObserver it$iv3 = (DerivedStateObserver) content$iv$iv3[i$iv$iv3];
                            it$iv3.done(derivedState);
                            i$iv$iv3++;
                        } while (i$iv$iv3 < size$iv$iv3);
                    }
                    throw th;
                }
            }
            return hash;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object[] getDependencies() {
            Object[] keys;
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this._dependencies;
            if (identityArrayMap != null && (keys = identityArrayMap.getKeys()) != null) {
                return keys;
            }
            return new Object[0];
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        SnapshotThreadLocal snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2;
        SnapshotThreadLocal snapshotThreadLocal3;
        ResultRecord<T> resultRecord;
        SnapshotThreadLocal snapshotThreadLocal4;
        SnapshotThreadLocal snapshotThreadLocal5;
        SnapshotThreadLocal snapshotThreadLocal6;
        if (readable.isValid(this, snapshot)) {
            if (forceDependencyReads) {
                MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = derivedStateObservers.getSize();
                if (size > 0) {
                    int i = 0;
                    DerivedStateObserver[] content = derivedStateObservers.getContent();
                    do {
                        content[i].start(this);
                        i++;
                    } while (i < size);
                }
                int i2 = 0;
                try {
                    IdentityArrayMap<StateObject, Integer> identityArrayMap = readable.get_dependencies();
                    snapshotThreadLocal4 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    Integer num = (Integer) snapshotThreadLocal4.get();
                    int intValue = num != null ? num.intValue() : 0;
                    if (identityArrayMap != null) {
                        int i3 = 0;
                        int size2 = identityArrayMap.getSize();
                        while (i3 < size2) {
                            Object obj = identityArrayMap.getKeys()[i3];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            int intValue2 = ((Number) identityArrayMap.getValues()[i3]).intValue();
                            StateObject stateObject = (StateObject) obj;
                            snapshotThreadLocal6 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                            int i4 = i2;
                            snapshotThreadLocal6.set(Integer.valueOf(intValue2 + intValue));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                            i3++;
                            i2 = i4;
                        }
                    }
                    snapshotThreadLocal5 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    snapshotThreadLocal5.set(Integer.valueOf(intValue));
                    Unit unit = Unit.INSTANCE;
                    int size3 = derivedStateObservers.getSize();
                    if (size3 > 0) {
                        int i5 = 0;
                        DerivedStateObserver[] content2 = derivedStateObservers.getContent();
                        do {
                            content2[i5].done(this);
                            i5++;
                        } while (i5 < size3);
                    }
                } finally {
                    int size4 = derivedStateObservers.getSize();
                    if (size4 > 0) {
                        int i6 = 0;
                        DerivedStateObserver[] content3 = derivedStateObservers.getContent();
                        do {
                            content3[i6].done(this);
                            i6++;
                        } while (i6 < size4);
                    }
                }
            }
            return readable;
        }
        snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        Integer num2 = (Integer) snapshotThreadLocal.get();
        final int intValue3 = num2 != null ? num2.intValue() : 0;
        final IdentityArrayMap<StateObject, Integer> identityArrayMap2 = new IdentityArrayMap<>(0, 1, null);
        MutableVector<DerivedStateObserver> derivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
        int size5 = derivedStateObservers2.getSize();
        if (size5 > 0) {
            int i7 = 0;
            DerivedStateObserver[] content4 = derivedStateObservers2.getContent();
            do {
                content4[i7].start(this);
                i7++;
            } while (i7 < size5);
        }
        try {
            snapshotThreadLocal2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            snapshotThreadLocal2.set(Integer.valueOf(intValue3 + 1));
            try {
                Object observe = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$result$1
                    final /* synthetic */ DerivedState<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                        invoke2(p1);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object it) {
                        SnapshotThreadLocal snapshotThreadLocal7;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it == this.this$0) {
                            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
                        }
                        if (it instanceof StateObject) {
                            snapshotThreadLocal7 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                            Object obj2 = snapshotThreadLocal7.get();
                            Intrinsics.checkNotNull(obj2);
                            int readNestedLevel = ((Number) obj2).intValue();
                            IdentityArrayMap<StateObject, Integer> identityArrayMap3 = identityArrayMap2;
                            int i8 = readNestedLevel - intValue3;
                            Integer num3 = identityArrayMap2.get(it);
                            identityArrayMap3.set(it, Integer.valueOf(Math.min(i8, num3 != null ? num3.intValue() : Integer.MAX_VALUE)));
                        }
                    }
                }, null, calculation);
                snapshotThreadLocal3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                snapshotThreadLocal3.set(Integer.valueOf(intValue3));
                MutableVector<DerivedStateObserver> mutableVector = derivedStateObservers2;
                int size6 = mutableVector.getSize();
                if (size6 > 0) {
                    int i8 = 0;
                    DerivedStateObserver[] content5 = mutableVector.getContent();
                    while (true) {
                        MutableVector<DerivedStateObserver> mutableVector2 = mutableVector;
                        content5[i8].done(this);
                        i8++;
                        if (i8 >= size6) {
                            break;
                        }
                        mutableVector = mutableVector2;
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                    Snapshot current = Snapshot.INSTANCE.getCurrent();
                    if (readable.getResult() != ResultRecord.INSTANCE.getUnset()) {
                        SnapshotMutationPolicy<T> policy = getPolicy();
                        if (policy != 0 ? policy.equivalent(observe, readable.getResult()) : false) {
                            readable.set_dependencies(identityArrayMap2);
                            readable.setResultHash(readable.readableHash(this, current));
                            readable.setValidSnapshotId(snapshot.getId());
                            readable.setValidSnapshotWriteCount(snapshot.getWriteCount());
                            resultRecord = readable;
                        }
                    }
                    resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                    resultRecord.set_dependencies(identityArrayMap2);
                    resultRecord.setResultHash(resultRecord.readableHash(this, current));
                    resultRecord.setValidSnapshotId(snapshot.getId());
                    resultRecord.setValidSnapshotWriteCount(snapshot.getWriteCount());
                    resultRecord.setResult(observe);
                }
                ResultRecord<T> resultRecord2 = resultRecord;
                if (intValue3 == 0) {
                    Snapshot.INSTANCE.notifyObjectsInitialized();
                }
                return resultRecord2;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.INSTANCE.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.INSTANCE.getCurrent(), true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        StateRecord $this$withCurrent$iv = this.first;
        ResultRecord<T> it = (ResultRecord) SnapshotKt.current($this$withCurrent$iv);
        return currentRecord(it, Snapshot.INSTANCE.getCurrent(), false, this.calculation);
    }

    public String toString() {
        StateRecord $this$withCurrent$iv = this.first;
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        StateRecord $this$withCurrent$iv = this.first;
        ResultRecord it = (ResultRecord) SnapshotKt.current($this$withCurrent$iv);
        if (it.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return String.valueOf(it.getResult());
        }
        return "<Not calculated>";
    }
}
