package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposableLambdaN.jvm.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"composableLambdaN", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "composer", "Landroidx/compose/runtime/Composer;", "key", "", "tracked", "", "arity", "block", "", "composableLambdaNInstance", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableLambdaN_jvmKt {
    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaN(Composer composer, int key, boolean tracked, int arity, Object block) {
        ComposableLambdaNImpl value;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(key);
        Object slot = composer.rememberedValue();
        if (slot == Composer.INSTANCE.getEmpty()) {
            value = new ComposableLambdaNImpl(key, tracked, arity);
            composer.updateRememberedValue(value);
        } else {
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
            value = (ComposableLambdaNImpl) slot;
        }
        value.update(block);
        composer.endReplaceableGroup();
        return value;
    }

    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaNInstance(int key, boolean tracked, int arity, Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ComposableLambdaNImpl $this$composableLambdaNInstance_u24lambda_u240 = new ComposableLambdaNImpl(key, tracked, arity);
        $this$composableLambdaNInstance_u24lambda_u240.update(block);
        return $this$composableLambdaNInstance_u24lambda_u240;
    }
}
