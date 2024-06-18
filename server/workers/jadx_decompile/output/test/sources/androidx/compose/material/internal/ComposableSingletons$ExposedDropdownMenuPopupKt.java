package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ExposedDropdownMenuPopup.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$ExposedDropdownMenuPopupKt {
    public static final ComposableSingletons$ExposedDropdownMenuPopupKt INSTANCE = new ComposableSingletons$ExposedDropdownMenuPopupKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f15lambda1 = ComposableLambdaKt.composableLambdaInstance(-1627646060, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.internal.ComposableSingletons$ExposedDropdownMenuPopupKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:ExposedDropdownMenuPopup.kt#mnwmf7");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1627646060, $changed, -1, "androidx.compose.material.internal.ComposableSingletons$ExposedDropdownMenuPopupKt.lambda-1.<anonymous> (ExposedDropdownMenuPopup.kt:285)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1264getLambda1$material_release() {
        return f15lambda1;
    }
}
