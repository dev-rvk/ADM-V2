package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecomposeScopeImpl.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00104\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u000eJ\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0010\u0018\u0001082\u0006\u0010:\u001a\u00020\u000fJ\b\u0010;\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020=2\b\u0010\u0016\u001a\u0004\u0018\u00010,J\u0016\u0010>\u001a\u00020\u00122\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010@J\u000e\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020,J\u0006\u0010C\u001a\u00020\u0010J\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010E\u001a\u00020\u0010J\u000e\u0010F\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u000fJ\"\u0010G\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u001aR$\u0010#\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u001aR$\u0010&\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u001aR\"\u0010)\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030+\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010/\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u001aR\u0011\u00102\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b3\u0010\u0014¨\u0006I"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "isConditional", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "Landroidx/compose/runtime/collection/IdentityArraySet;", "recordRead", "instance", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeOwner owner;
    private IdentityArrayMap<DerivedState<?>, Object> trackedDependencies;
    private IdentityArrayIntMap trackedInstances;

    public RecomposeScopeImpl(RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final boolean getValid() {
        if (this.owner == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final void setUsed(boolean value) {
        if (value) {
            this.flags |= 1;
        } else {
            this.flags &= -2;
        }
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final void setDefaultsInScope(boolean value) {
        if (value) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final void setDefaultsInvalid(boolean value) {
        if (value) {
            this.flags |= 4;
        } else {
            this.flags &= -5;
        }
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final void setRequiresRecompose(boolean value) {
        if (value) {
            this.flags |= 8;
        } else {
            this.flags &= -9;
        }
    }

    public final void compose(Composer composer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Function2<? super Composer, ? super Integer, Unit> function2 = this.block;
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final InvalidationResult invalidateForResult(Object value) {
        InvalidationResult invalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidate = recomposeScopeOwner.invalidate(this, value)) == null) ? InvalidationResult.IGNORED : invalidate;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
    }

    public final void adoptedBy(RecomposeScopeOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean value) {
        if (value) {
            this.flags |= 32;
        } else {
            this.flags &= -33;
        }
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    private final void setSkipped(boolean value) {
        if (value) {
            this.flags |= 16;
        } else {
            this.flags &= -17;
        }
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final boolean recordRead(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        int i = 0;
        if (getRereading()) {
            return false;
        }
        IdentityArrayIntMap it = this.trackedInstances;
        if (it == null) {
            it = new IdentityArrayIntMap();
            this.trackedInstances = it;
        }
        int token = it.add(instance, this.currentToken);
        int i2 = 1;
        if (token == this.currentToken) {
            return true;
        }
        if (instance instanceof DerivedState) {
            IdentityArrayMap it2 = this.trackedDependencies;
            if (it2 == null) {
                it2 = new IdentityArrayMap(i, i2, null);
                this.trackedDependencies = it2;
            }
            it2.set(instance, ((DerivedState) instance).getCurrentRecord().getCurrentValue());
        }
        return false;
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[LOOP:0: B:18:0x0028->B:32:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r15) {
        /*
            r14 = this;
            r0 = 1
            if (r15 != 0) goto L4
            return r0
        L4:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r1 = r14.trackedDependencies
            if (r1 != 0) goto L9
            return r0
        L9:
            boolean r2 = r15.isNotEmpty()
            if (r2 == 0) goto L64
            r2 = r15
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            boolean r4 = r2 instanceof java.util.Collection
            r5 = 0
            if (r4 == 0) goto L24
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L24
            r2 = r0
            goto L61
        L24:
            java.util.Iterator r4 = r2.iterator()
        L28:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L60
            java.lang.Object r6 = r4.next()
            r7 = r6
            r8 = 0
            boolean r9 = r7 instanceof androidx.compose.runtime.DerivedState
            if (r9 == 0) goto L5b
            r9 = r7
            androidx.compose.runtime.DerivedState r9 = (androidx.compose.runtime.DerivedState) r9
            r10 = 0
            androidx.compose.runtime.SnapshotMutationPolicy r11 = r9.getPolicy()
            if (r11 != 0) goto L47
            androidx.compose.runtime.SnapshotMutationPolicy r11 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
        L47:
            androidx.compose.runtime.DerivedState$Record r12 = r9.getCurrentRecord()
            java.lang.Object r12 = r12.getCurrentValue()
            java.lang.Object r13 = r1.get(r9)
            boolean r9 = r11.equivalent(r12, r13)
            if (r9 == 0) goto L5b
            r9 = r0
            goto L5c
        L5b:
            r9 = r5
        L5c:
            if (r9 != 0) goto L28
            r2 = r5
            goto L61
        L60:
            r2 = r0
        L61:
            if (r2 == 0) goto L64
            return r5
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(androidx.compose.runtime.collection.IdentityArraySet):boolean");
    }

    public final void rereadTrackedInstances() {
        IdentityArrayIntMap trackedInstances;
        RecomposeScopeOwner owner = this.owner;
        if (owner != null && (trackedInstances = this.trackedInstances) != null) {
            setRereading(true);
            try {
                Object[] keys$iv = trackedInstances.getKeys();
                int[] values$iv = trackedInstances.getValues();
                int size$iv = trackedInstances.getSize();
                for (int i$iv = 0; i$iv < size$iv; i$iv++) {
                    Object value = keys$iv[i$iv];
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
                    int i = values$iv[i$iv];
                    owner.recordReadOf(value);
                }
            } finally {
                setRereading(false);
            }
        }
    }

    public final Function1<Composition, Unit> end(final int token) {
        boolean z;
        final IdentityArrayIntMap instances = this.trackedInstances;
        if (instances == null || getSkipped$runtime_release()) {
            return null;
        }
        Object[] keys$iv = instances.getKeys();
        int[] values$iv = instances.getValues();
        int size$iv = instances.getSize();
        int i$iv = 0;
        while (true) {
            if (i$iv >= size$iv) {
                break;
            }
            Intrinsics.checkNotNull(keys$iv[i$iv], "null cannot be cast to non-null type kotlin.Any");
            int instanceToken = values$iv[i$iv];
            if (instanceToken != token) {
                z = true;
                break;
            }
            i$iv++;
        }
        if (z) {
            return new Function1<Composition, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Composition composition) {
                    invoke2(composition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Composition composition) {
                    int i;
                    IdentityArrayIntMap identityArrayIntMap;
                    int i2;
                    IdentityArrayMap dependencies;
                    Composition composition2 = composition;
                    Intrinsics.checkNotNullParameter(composition2, "composition");
                    i = RecomposeScopeImpl.this.currentToken;
                    if (i == token) {
                        IdentityArrayIntMap identityArrayIntMap2 = instances;
                        identityArrayIntMap = RecomposeScopeImpl.this.trackedInstances;
                        if (Intrinsics.areEqual(identityArrayIntMap2, identityArrayIntMap) && (composition2 instanceof CompositionImpl)) {
                            IdentityArrayIntMap this_$iv = instances;
                            int i3 = token;
                            RecomposeScopeImpl recomposeScopeImpl = RecomposeScopeImpl.this;
                            Object[] keys$iv2 = this_$iv.getKeys();
                            int[] values$iv2 = this_$iv.getValues();
                            int size$iv2 = this_$iv.getSize();
                            int destinationIndex$iv = 0;
                            int i$iv2 = 0;
                            while (i$iv2 < size$iv2) {
                                Object key$iv = keys$iv2[i$iv2];
                                Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type kotlin.Any");
                                int value$iv = values$iv2[i$iv2];
                                boolean z2 = value$iv != i3;
                                boolean remove = z2;
                                if (!remove) {
                                    i2 = i3;
                                } else {
                                    ((CompositionImpl) composition2).removeObservation$runtime_release(key$iv, recomposeScopeImpl);
                                    DerivedState it = key$iv instanceof DerivedState ? (DerivedState) key$iv : null;
                                    if (it == null) {
                                        i2 = i3;
                                    } else {
                                        i2 = i3;
                                        ((CompositionImpl) composition2).removeDerivedStateObservation$runtime_release(it);
                                        dependencies = recomposeScopeImpl.trackedDependencies;
                                        if (dependencies != null) {
                                            dependencies.remove(it);
                                            if (dependencies.getSize() == 0) {
                                                recomposeScopeImpl.trackedDependencies = null;
                                            }
                                        }
                                    }
                                }
                                if (!z2) {
                                    if (destinationIndex$iv != i$iv2) {
                                        keys$iv2[destinationIndex$iv] = key$iv;
                                        values$iv2[destinationIndex$iv] = value$iv;
                                    }
                                    destinationIndex$iv++;
                                }
                                i$iv2++;
                                composition2 = composition;
                                i3 = i2;
                            }
                            for (int i$iv3 = destinationIndex$iv; i$iv3 < size$iv2; i$iv3++) {
                                keys$iv2[i$iv3] = null;
                            }
                            this_$iv.size = destinationIndex$iv;
                            if (instances.getSize() == 0) {
                                RecomposeScopeImpl.this.trackedInstances = null;
                            }
                        }
                    }
                }
            };
        }
        return null;
    }

    /* compiled from: RecomposeScopeImpl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slots, List<Anchor> anchors, RecomposeScopeOwner newOwner) {
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(anchors, "anchors");
            Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            if (!(!anchors.isEmpty())) {
                return;
            }
            int size = anchors.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = anchors.get(index$iv);
                Anchor anchor = (Anchor) item$iv;
                Object slot = slots.slot(anchor, 0);
                RecomposeScopeImpl recomposeScope = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScope != null) {
                    recomposeScope.adoptedBy(newOwner);
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(SlotTable slots, List<Anchor> anchors) {
            List $this$fastAny$iv;
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(anchors, "anchors");
            if (!anchors.isEmpty()) {
                int index$iv$iv = 0;
                int size = anchors.size();
                while (true) {
                    if (index$iv$iv < size) {
                        Object item$iv$iv = anchors.get(index$iv$iv);
                        Anchor it = (Anchor) item$iv$iv;
                        if (((slots.ownsAnchor(it) && (slots.slot$runtime_release(slots.anchorIndex(it), 0) instanceof RecomposeScopeImpl)) ? 1 : null) != null) {
                            $this$fastAny$iv = 1;
                            break;
                        }
                        index$iv$iv++;
                    } else {
                        $this$fastAny$iv = null;
                        break;
                    }
                }
                if ($this$fastAny$iv != null) {
                    return true;
                }
            }
            return false;
        }
    }
}
