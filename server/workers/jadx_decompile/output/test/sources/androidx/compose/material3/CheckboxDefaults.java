package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* renamed from: colors-5tl4gsc, reason: not valid java name */
    public final CheckboxColors m1340colors5tl4gsc(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledCheckedColor, long disabledUncheckedColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i) {
        long uncheckedColor2;
        long checkmarkColor2;
        long disabledCheckedColor2;
        long disabledUncheckedColor2;
        long disabledIndeterminateColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        $composer.startReplaceableGroup(-89536160);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)199@8691L11,201@8811L11,203@8931L11,205@9052L11,209@9284L11:Checkbox.kt#uh7d8r");
        long checkedColor2 = (i & 1) != 0 ? ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), CheckboxTokens.INSTANCE.getSelectedContainerColor()) : checkedColor;
        if ((i & 2) == 0) {
            uncheckedColor2 = uncheckedColor;
        } else {
            uncheckedColor2 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), CheckboxTokens.INSTANCE.getUnselectedOutlineColor());
        }
        if ((i & 4) == 0) {
            checkmarkColor2 = checkmarkColor;
        } else {
            checkmarkColor2 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), CheckboxTokens.INSTANCE.getSelectedIconColor());
        }
        if ((i & 8) == 0) {
            disabledCheckedColor2 = disabledCheckedColor;
        } else {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor())) : 0.0f);
            disabledCheckedColor2 = m2947copywmQWz5c4;
        }
        if ((i & 16) == 0) {
            disabledUncheckedColor2 = disabledUncheckedColor;
        } else {
            disabledUncheckedColor2 = Color.m2947copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r2) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor())) : 0.0f);
        }
        if ((i & 32) == 0) {
            disabledIndeterminateColor2 = disabledIndeterminateColor;
        } else {
            disabledIndeterminateColor2 = disabledCheckedColor2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, $changed, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:197)");
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r39, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r39) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r39) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r39) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(checkmarkColor2) : 0.0f);
        m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r39, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r39) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r39) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r39) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(checkedColor2) : 0.0f);
        m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r39, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r39) : 0.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r39) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r39) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(disabledUncheckedColor2) : 0.0f);
        CheckboxColors checkboxColors = new CheckboxColors(checkmarkColor2, m2947copywmQWz5c, checkedColor2, m2947copywmQWz5c2, disabledCheckedColor2, m2947copywmQWz5c3, disabledIndeterminateColor2, checkedColor2, uncheckedColor2, disabledCheckedColor2, disabledIndeterminateColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return checkboxColors;
    }
}
