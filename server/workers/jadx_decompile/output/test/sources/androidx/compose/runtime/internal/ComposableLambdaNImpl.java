package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* compiled from: ComposableLambdaN.jvm.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0013\"\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "key", "", "tracked", "", "arity", "(IZI)V", "_block", "", "getArity", "()I", "getKey", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "realParamCount", "params", "trackRead", "", "composer", "Landroidx/compose/runtime/Composer;", "trackWrite", "update", "block", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaNImpl(int key, boolean tracked, int arity) {
        this.key = key;
        this.tracked = tracked;
        this.arity = arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Override // kotlin.jvm.functions.FunctionN, kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope scope = this.scope;
            if (scope != null) {
                scope.invalidate();
                this.scope = null;
            }
            List scopes = this.scopes;
            if (scopes != null) {
                int size = scopes.size();
                for (int index = 0; index < size; index++) {
                    RecomposeScope item = scopes.get(index);
                    item.invalidate();
                }
                scopes.clear();
            }
        }
    }

    private final void trackRead(Composer composer) {
        RecomposeScope scope;
        if (this.tracked && (scope = composer.getRecomposeScope()) != null) {
            composer.recordUsed(scope);
            RecomposeScope lastScope = this.scope;
            if (ComposableLambdaKt.replacableWith(lastScope, scope)) {
                this.scope = scope;
                return;
            }
            List lastScopes = this.scopes;
            if (lastScopes == null) {
                List newScopes = new ArrayList();
                this.scopes = newScopes;
                newScopes.add(scope);
                return;
            }
            int size = lastScopes.size();
            for (int index = 0; index < size; index++) {
                RecomposeScope scopeAtIndex = lastScopes.get(index);
                if (ComposableLambdaKt.replacableWith(scopeAtIndex, scope)) {
                    lastScopes.set(index, scope);
                    return;
                }
            }
            lastScopes.add(scope);
        }
    }

    public final void update(Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!Intrinsics.areEqual(block, this._block)) {
            boolean oldBlockNull = this._block == null;
            this._block = (FunctionN) block;
            if (!oldBlockNull) {
                trackWrite();
            }
        }
    }

    private final int realParamCount(int params) {
        int realParams = params - 1;
        int realParams2 = realParams - 1;
        for (int changedParams = 1; changedParams * 10 < realParams2; changedParams++) {
            realParams2--;
        }
        return realParams2;
    }

    @Override // kotlin.jvm.functions.FunctionN
    public Object invoke(final Object... args) {
        int sameBits;
        Intrinsics.checkNotNullParameter(args, "args");
        final int realParams = realParamCount(args.length);
        Object obj = args[realParams];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Collection $this$toTypedArray$iv = ArraysKt.slice(args, RangesKt.until(0, args.length - 1));
        Object[] allArgsButLast = $this$toTypedArray$iv.toArray(new Object[0]);
        Object obj2 = args[args.length - 1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int lastChanged = ((Integer) obj2).intValue();
        Composer c = ((Composer) obj).startRestartGroup(this.key);
        trackRead(c);
        if (c.changed(this)) {
            sameBits = ComposableLambdaKt.differentBits(realParams);
        } else {
            sameBits = ComposableLambdaKt.sameBits(realParams);
        }
        int dirty = sameBits | lastChanged;
        Object obj3 = this._block;
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(allArgsButLast);
        spreadBuilder.add(Integer.valueOf(dirty));
        Object result = ((FunctionN) obj3).invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        ScopeUpdateScope endRestartGroup = c.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaNImpl$invoke$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer nc, int i) {
                    Intrinsics.checkNotNullParameter(nc, "nc");
                    Collection $this$toTypedArray$iv2 = ArraysKt.slice(args, RangesKt.until(0, realParams));
                    Object[] params = $this$toTypedArray$iv2.toArray(new Object[0]);
                    Object obj4 = args[realParams + 1];
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    int changed = RecomposeScopeImplKt.updateChangedFlags(((Integer) obj4).intValue());
                    int length = (args.length - realParams) - 2;
                    Object[] changedN = new Object[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj5 = args[realParams + 2 + i2];
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                        changedN[i2] = Integer.valueOf(RecomposeScopeImplKt.updateChangedFlags(((Integer) obj5).intValue()));
                    }
                    ComposableLambdaNImpl composableLambdaNImpl = this;
                    SpreadBuilder spreadBuilder2 = new SpreadBuilder(4);
                    spreadBuilder2.addSpread(params);
                    spreadBuilder2.add(nc);
                    spreadBuilder2.add(Integer.valueOf(changed | 1));
                    spreadBuilder2.addSpread(changedN);
                    composableLambdaNImpl.invoke(spreadBuilder2.toArray(new Object[spreadBuilder2.size()]));
                }
            });
        }
        return result;
    }
}
