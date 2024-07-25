package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release", "focused"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m1247animateBorderStrokeAsStateNuRrP5Q(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        State animatedThickness;
        $composer.startReplaceableGroup(1097899920);
        ComposerKt.sourceInformation($composer, "C(animateBorderStrokeAsState)P(1,4,3!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)843@38095L25,844@38153L51,851@38510L107:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1097899920, $changed, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:835)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer, ($changed >> 6) & 14);
        State indicatorColor = colors.indicatorColor(enabled, isError, interactionSource, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168));
        float targetThickness = animateBorderStrokeAsState_NuRrP5Q$lambda$0(focused$delegate) ? focusedBorderThickness : unfocusedBorderThickness;
        if (enabled) {
            $composer.startReplaceableGroup(1685712066);
            ComposerKt.sourceInformation($composer, "847@38348L76");
            animatedThickness = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(targetThickness, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, $composer, 48, 12);
            $composer.endReplaceableGroup();
        } else {
            $composer.startReplaceableGroup(1685712164);
            ComposerKt.sourceInformation($composer, "849@38446L46");
            animatedThickness = SnapshotStateKt.rememberUpdatedState(Dp.m5216boximpl(unfocusedBorderThickness), $composer, ($changed >> 15) & 14);
            $composer.endReplaceableGroup();
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new BorderStroke(animatedThickness.getValue().m5232unboximpl(), new SolidColor(indicatorColor.getValue().m2959unboximpl(), null), null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    private static final boolean animateBorderStrokeAsState_NuRrP5Q$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }
}
