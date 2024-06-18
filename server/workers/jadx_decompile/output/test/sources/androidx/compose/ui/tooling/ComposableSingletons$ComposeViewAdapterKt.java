package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ComposeViewAdapter.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$ComposeViewAdapterKt {
    public static final ComposableSingletons$ComposeViewAdapterKt INSTANCE = new ComposableSingletons$ComposeViewAdapterKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f53lambda1 = ComposableLambdaKt.composableLambdaInstance(1432133447, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:ComposeViewAdapter.kt#hevd2p");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1432133447, $changed, -1, "androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt.lambda-1.<anonymous> (ComposeViewAdapter.kt:79)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f54lambda2 = ComposableLambdaKt.composableLambdaInstance(5797419, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:ComposeViewAdapter.kt#hevd2p");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5797419, $changed, -1, "androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt.lambda-2.<anonymous> (ComposeViewAdapter.kt:171)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f55lambda3 = ComposableLambdaKt.composableLambdaInstance(-804738851, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:ComposeViewAdapter.kt#hevd2p");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-804738851, $changed, -1, "androidx.compose.ui.tooling.ComposableSingletons$ComposeViewAdapterKt.lambda-3.<anonymous> (ComposeViewAdapter.kt:392)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$ui_tooling_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5140getLambda1$ui_tooling_release() {
        return f53lambda1;
    }

    /* renamed from: getLambda-2$ui_tooling_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5141getLambda2$ui_tooling_release() {
        return f54lambda2;
    }

    /* renamed from: getLambda-3$ui_tooling_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m5142getLambda3$ui_tooling_release() {
        return f55lambda3;
    }
}
