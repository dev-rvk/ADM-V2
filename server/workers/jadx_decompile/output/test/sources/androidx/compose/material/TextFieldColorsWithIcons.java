package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0017ø\u0001\u0000¢\u0006\u0002\u0010\nø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/material/TextFieldColorsWithIcons;", "Landroidx/compose/material/TextFieldColors;", "leadingIconColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trailingIconColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface TextFieldColorsWithIcons extends TextFieldColors {

    /* compiled from: TextFieldDefaults.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static State<Color> leadingIconColor(TextFieldColorsWithIcons $this, boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
            return TextFieldColorsWithIcons.super.leadingIconColor(enabled, isError, interactionSource, $composer, $changed);
        }

        @Deprecated
        public static State<Color> trailingIconColor(TextFieldColorsWithIcons $this, boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
            return TextFieldColorsWithIcons.super.trailingIconColor(enabled, isError, interactionSource, $composer, $changed);
        }
    }

    default State<Color> leadingIconColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(1279189910);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)P(!1,2)165@6195L34:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1279189910, $changed, -1, "androidx.compose.material.TextFieldColorsWithIcons.leadingIconColor (TextFieldDefaults.kt:160)");
        }
        State<Color> leadingIconColor = leadingIconColor(enabled, isError, $composer, ($changed & 14) | ($changed & 112) | (($changed >> 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return leadingIconColor;
    }

    default State<Color> trailingIconColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        $composer.startReplaceableGroup(-712140408);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)P(!1,2)182@6780L35:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-712140408, $changed, -1, "androidx.compose.material.TextFieldColorsWithIcons.trailingIconColor (TextFieldDefaults.kt:177)");
        }
        State<Color> trailingIconColor = trailingIconColor(enabled, isError, $composer, ($changed & 14) | ($changed & 112) | (($changed >> 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return trailingIconColor;
    }
}
