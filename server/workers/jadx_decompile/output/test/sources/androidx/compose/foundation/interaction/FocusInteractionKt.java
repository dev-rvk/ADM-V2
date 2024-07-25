package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FocusInteraction.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"collectIsFocusedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusInteractionKt {
    public static final State<Boolean> collectIsFocusedAsState(InteractionSource $this$collectIsFocusedAsState, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter($this$collectIsFocusedAsState, "<this>");
        $composer.startReplaceableGroup(-1805515472);
        ComposerKt.sourceInformation($composer, "C(collectIsFocusedAsState)65@2219L34,66@2279L414,66@2258L435:FocusInteraction.kt#ywyzhk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1805515472, $changed, -1, "androidx.compose.foundation.interaction.collectIsFocusedAsState (FocusInteraction.kt:64)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState isFocused = (MutableState) value$iv$iv;
        int i = ($changed & 14) | 48;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed($this$collectIsFocusedAsState) | $composer.changed(isFocused);
        Object it$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv$iv2 = new FocusInteractionKt$collectIsFocusedAsState$1$1($this$collectIsFocusedAsState, isFocused, null);
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect($this$collectIsFocusedAsState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer, ($changed & 14) | 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return isFocused;
    }
}
