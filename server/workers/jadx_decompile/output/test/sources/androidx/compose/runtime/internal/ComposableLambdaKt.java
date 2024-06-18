package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposableLambda.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0012\u001a\u00020\f*\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"BITS_PER_SLOT", "", "SLOTS_PER_INT", "bitsForSlot", "bits", "slot", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", "key", "tracked", "", "block", "", "composableLambdaInstance", "differentBits", "sameBits", "replacableWith", "Landroidx/compose/runtime/RecomposeScope;", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;

    public static final int bitsForSlot(int bits, int slot) {
        int realSlot = slot % 10;
        return bits << ((realSlot * 3) + 1);
    }

    public static final int sameBits(int slot) {
        return bitsForSlot(1, slot);
    }

    public static final int differentBits(int slot) {
        return bitsForSlot(2, slot);
    }

    public static final boolean replacableWith(RecomposeScope $this$replacableWith, RecomposeScope other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$replacableWith == null || (($this$replacableWith instanceof RecomposeScopeImpl) && (other instanceof RecomposeScopeImpl) && (!((RecomposeScopeImpl) $this$replacableWith).getValid() || Intrinsics.areEqual($this$replacableWith, other) || Intrinsics.areEqual(((RecomposeScopeImpl) $this$replacableWith).getAnchor(), ((RecomposeScopeImpl) other).getAnchor())));
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambda(Composer composer, int key, boolean tracked, Object block) {
        ComposableLambdaImpl value;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(key);
        Object slot = composer.rememberedValue();
        if (slot == Composer.INSTANCE.getEmpty()) {
            value = new ComposableLambdaImpl(key, tracked);
            composer.updateRememberedValue(value);
        } else {
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            value = (ComposableLambdaImpl) slot;
        }
        value.update(block);
        composer.endReplaceableGroup();
        return value;
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambdaInstance(int key, boolean tracked, Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ComposableLambdaImpl $this$composableLambdaInstance_u24lambda_u240 = new ComposableLambdaImpl(key, tracked);
        $this$composableLambdaInstance_u24lambda_u240.update(block);
        return $this$composableLambdaInstance_u24lambda_u240;
    }
}
