package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutPrefetcher.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"LazyLayoutPrefetcher", "", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutPrefetcher_androidKt {
    public static final void LazyLayoutPrefetcher(final LazyLayoutPrefetchState prefetchState, final LazyLayoutItemContentFactory itemContentFactory, final SubcomposeLayoutState subcomposeLayoutState, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(prefetchState, "prefetchState");
        Intrinsics.checkNotNullParameter(itemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "subcomposeLayoutState");
        Composer $composer2 = $composer.startRestartGroup(1113453182);
        ComposerKt.sourceInformation($composer2, "C(LazyLayoutPrefetcher)P(1)40@1563L7,41@1575L211:LazyLayoutPrefetcher.android.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1113453182, $changed, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher (LazyLayoutPrefetcher.android.kt:35)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localView);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        View view = (View) consume;
        int i = SubcomposeLayoutState.$stable | 512 | (($changed >> 6) & 14) | (($changed << 3) & 112);
        $composer2.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(subcomposeLayoutState) | $composer2.changed(prefetchState) | $composer2.changed(view);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            Object value$iv$iv = new LazyLayoutPrefetcher(prefetchState, subcomposeLayoutState, itemContentFactory, view);
            $composer2.updateRememberedValue(value$iv$iv);
        }
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2
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

            public final void invoke(Composer composer, int i2) {
                LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(LazyLayoutPrefetchState.this, itemContentFactory, subcomposeLayoutState, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
