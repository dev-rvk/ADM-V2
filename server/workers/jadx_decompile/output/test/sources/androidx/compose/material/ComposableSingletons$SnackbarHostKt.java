package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackbarHost.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$SnackbarHostKt {
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = new ComposableSingletons$SnackbarHostKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<SnackbarData, Composer, Integer, Unit> f12lambda1 = ComposableLambdaKt.composableLambdaInstance(996639038, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: androidx.compose.material.ComposableSingletons$SnackbarHostKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            invoke(snackbarData, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData it, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(it, "it");
            ComposerKt.sourceInformation($composer, "C153@6325L12:SnackbarHost.kt#jmzs0o");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changed(it) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 91) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(996639038, $dirty2, -1, "androidx.compose.material.ComposableSingletons$SnackbarHostKt.lambda-1.<anonymous> (SnackbarHost.kt:153)");
            }
            SnackbarKt.m1181SnackbarsPrSdHI(it, null, false, null, 0L, 0L, 0L, 0.0f, $composer, $dirty2 & 14, 254);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material_release, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m1066getLambda1$material_release() {
        return f12lambda1;
    }
}
