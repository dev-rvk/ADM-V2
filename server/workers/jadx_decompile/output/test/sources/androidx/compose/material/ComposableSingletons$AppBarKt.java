package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBar.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$AppBarKt {
    public static final ComposableSingletons$AppBarKt INSTANCE = new ComposableSingletons$AppBarKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f5lambda1 = ComposableLambdaKt.composableLambdaInstance(-771938130, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$AppBarKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope $this$null, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$null, "$this$null");
            ComposerKt.sourceInformation($composer, "C:AppBar.kt#jmzs0o");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-771938130, $changed, -1, "androidx.compose.material.ComposableSingletons$AppBarKt.lambda-1.<anonymous> (AppBar.kt:80)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m1059getLambda1$material_release() {
        return f5lambda1;
    }
}
