package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerSemantics.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"rememberPagerSemanticState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "reverseScrolling", "", "isVertical", "(Landroidx/compose/foundation/pager/PagerState;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerSemanticsKt {
    public static final LazyLayoutSemanticState rememberPagerSemanticState(PagerState state, boolean reverseScrolling, boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(352210115);
        ComposerKt.sourceInformation($composer, "C(rememberPagerSemanticState)P(2,1)30@1089L104:PagerSemantics.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(352210115, $changed, -1, "androidx.compose.foundation.pager.rememberPagerSemanticState (PagerSemantics.kt:25)");
        }
        Object key2$iv = Boolean.valueOf(reverseScrolling);
        Object key3$iv = Boolean.valueOf(isVertical);
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(state) | $composer.changed(key2$iv) | $composer.changed(key3$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = LazyLayoutSemanticStateKt.LazyLayoutSemanticState(state, isVertical);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazyLayoutSemanticState lazyLayoutSemanticState = (LazyLayoutSemanticState) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazyLayoutSemanticState;
    }
}
