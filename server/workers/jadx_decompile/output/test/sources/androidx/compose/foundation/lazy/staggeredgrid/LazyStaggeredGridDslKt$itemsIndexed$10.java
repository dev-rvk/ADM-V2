package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* loaded from: classes.dex */
public final class LazyStaggeredGridDslKt$itemsIndexed$10 extends Lambda implements Function4<LazyStaggeredGridItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function5<LazyStaggeredGridItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
    final /* synthetic */ T[] $items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$itemsIndexed$10(Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5, T[] tArr) {
        super(4);
        this.$itemContent = function5;
        this.$items = tArr;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(LazyStaggeredGridItemScope lazyStaggeredGridItemScope, Integer num, Composer composer, Integer num2) {
        invoke(lazyStaggeredGridItemScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyStaggeredGridItemScope items, int index, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(items, "$this$items");
        ComposerKt.sourceInformation($composer, "C453@20356L32:LazyStaggeredGridDsl.kt#fzvcnm");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed(items) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        if (($dirty & 731) == 146 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-804487775, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed.<anonymous> (LazyStaggeredGridDsl.kt:453)");
        }
        this.$itemContent.invoke(items, Integer.valueOf(index), this.$items[index], $composer, Integer.valueOf(($dirty & 14) | ($dirty & 112)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
