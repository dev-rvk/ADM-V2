package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b3\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0085\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0087\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\u009b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J\u0085\u0002\u0010@\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010)J\u0087\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010:J\u009b\u0003\u0010@\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020\u000f2\b\b\u0002\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010A\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020\u000f2\b\b\u0002\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010D\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000f2\b\b\u0002\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u000f2\b\b\u0002\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u000f2\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010?R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006H"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "unfocusedTextColor", "errorTextColor", "errorContainerColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "outlinedTextFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "outlinedTextFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "textFieldColors-tN0la-I", "textFieldColors-FD9MK7s", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    private static final PaddingValues ItemContentPadding;

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean expanded, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1803742020);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)301@12373L129:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803742020, $changed, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:300)");
            }
            IconKt.m1556Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), (String) null, RotateKt.rotate(Modifier.INSTANCE, expanded ? 180.0f : 0.0f), 0L, $composer2, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$TrailingIcon$1
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

            public final void invoke(Composer composer, int i) {
                ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* renamed from: textFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m1514textFieldColorsFD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long focusedContainerColor2;
        long unfocusedContainerColor2;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        $composer.startReplaceableGroup(-375683630);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,29,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)358@16485L9,359@16577L9,360@16676L9,362@16851L9,363@16950L9,364@17051L9,365@17151L9,366@17248L9,367@17333L9,368@17433L9,369@17516L7,371@17636L9,373@17755L9,375@17881L9,378@18097L9,380@18217L9,382@18334L9,384@18458L9,387@18668L9,389@18790L9,391@18909L9,393@19035L9,396@19248L9,397@19344L9,398@19437L9,399@19537L9,400@19631L9,402@19745L9,404@19861L9,406@19984L9,408@20175L9,409@20272L9,410@20371L9,412@20490L9,413@20659L9,414@20756L9,415@20855L9,417@20974L9,418@21143L9,420@21205L2230:ExposedDropdownMenu.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c7;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            focusedContainerColor2 = focusedContainerColor;
        } else {
            focusedContainerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            unfocusedContainerColor2 = unfocusedContainerColor;
        } else {
            unfocusedContainerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 2048) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 4096) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c6;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 16384) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((65536 & i) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((262144 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((1048576 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c4;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((4194304 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((8388608 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((16777216 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            disabledLabelColor2 = disabledLabelColor;
        } else {
            disabledLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
        }
        if ((67108864 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((134217728 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((536870912 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 1) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 4) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 8) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 16) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 32) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 64) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 128) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-375683630, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:357)");
        }
        TextFieldColors m1842colors0hiis_0 = TextFieldDefaults.INSTANCE.m1842colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, 0L, 0L, 0L, 0L, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | ($changed & 458752) | ($changed & 3670016) | ($changed & 29360128) | ($changed & 234881024) | ($changed & 1879048192), ($changed1 & 14) | ($changed1 & 112) | ($changed1 & 896) | ($changed1 & 7168) | ($changed1 & 57344) | ($changed1 & 458752) | ($changed1 & 3670016) | ($changed1 & 29360128) | ($changed1 & 234881024) | ($changed1 & 1879048192), ($changed2 & 14) | ($changed2 & 112) | ($changed2 & 896) | ($changed2 & 7168) | (57344 & $changed2) | ($changed2 & 458752) | ($changed2 & 3670016) | ($changed2 & 29360128) | ($changed2 & 234881024) | ($changed2 & 1879048192), ($changed3 & 14) | (($changed3 << 12) & 458752) | (($changed3 << 12) & 3670016) | (($changed3 << 12) & 29360128) | (($changed3 << 12) & 234881024) | (($changed3 << 12) & 1879048192), (($changed3 >> 18) & 14) | 3072 | (($changed3 >> 18) & 112) | (($changed3 >> 18) & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1842colors0hiis_0;
    }

    /* renamed from: outlinedTextFieldColors-FD9MK7s, reason: not valid java name */
    public final TextFieldColors m1511outlinedTextFieldColorsFD9MK7s(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long focusedContainerColor2;
        long unfocusedContainerColor2;
        long disabledContainerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        $composer.startReplaceableGroup(-325161132);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(27:c#ui.graphics.Color,37:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,21:c#ui.graphics.Color,31:c#ui.graphics.Color,2:c#ui.graphics.Color,11:c#ui.graphics.Color,0:c#ui.graphics.Color,12:c#ui.graphics.Color,29,20:c#ui.graphics.Color,30:c#ui.graphics.Color,1:c#ui.graphics.Color,10:c#ui.graphics.Color,23:c#ui.graphics.Color,33:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,28:c#ui.graphics.Color,38:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,22:c#ui.graphics.Color,32:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,24:c#ui.graphics.Color,34:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,25:c#ui.graphics.Color,35:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,26:c#ui.graphics.Color,36:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)511@27400L9,512@27494L9,513@27595L9,515@27774L9,520@28094L9,522@28208L9,523@28291L7,524@28390L9,525@28488L9,527@28605L9,529@28794L9,531@28916L9,533@29035L9,535@29161L9,538@29375L9,540@29499L9,542@29620L9,544@29748L9,547@29965L9,548@30063L9,549@30158L9,550@30260L9,552@30440L9,554@30556L9,556@30674L9,558@30799L9,561@31006L9,562@31105L9,563@31206L9,565@31327L9,566@31500L9,567@31599L9,568@31700L9,570@31821L9,571@31994L9,573@32064L2206:ExposedDropdownMenu.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c8;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            focusedContainerColor2 = focusedContainerColor;
        } else {
            focusedContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 32) == 0) {
            unfocusedContainerColor2 = unfocusedContainerColor;
        } else {
            unfocusedContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 64) == 0) {
            disabledContainerColor2 = disabledContainerColor;
        } else {
            disabledContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 128) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 256) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 2048) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 4096) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6);
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c7;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 16384) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((65536 & i) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((262144 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((1048576 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((4194304 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((8388608 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((16777216 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((33554432 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c4;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((67108864 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((134217728 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((268435456 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((536870912 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 1) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 2) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 4) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 8) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 16) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 32) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 64) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 128) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-325161132, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:510)");
        }
        TextFieldColors m1637colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1637colors0hiis_0(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, focusedContainerColor2, unfocusedContainerColor2, disabledContainerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, 0L, 0L, 0L, 0L, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | ($changed & 458752) | ($changed & 3670016) | ($changed & 29360128) | ($changed & 234881024) | ($changed & 1879048192), ($changed1 & 14) | ($changed1 & 112) | ($changed1 & 896) | ($changed1 & 7168) | ($changed1 & 57344) | ($changed1 & 458752) | ($changed1 & 3670016) | ($changed1 & 29360128) | ($changed1 & 234881024) | ($changed1 & 1879048192), ($changed2 & 14) | ($changed2 & 112) | ($changed2 & 896) | ($changed2 & 7168) | (57344 & $changed2) | ($changed2 & 458752) | ($changed2 & 3670016) | ($changed2 & 29360128) | ($changed2 & 234881024) | ($changed2 & 1879048192), ($changed3 & 14) | (($changed3 << 12) & 458752) | (($changed3 << 12) & 3670016) | (($changed3 << 12) & 29360128) | (($changed3 << 12) & 234881024) | (($changed3 << 12) & 1879048192), (($changed3 >> 18) & 14) | 3072 | (($changed3 >> 18) & 112) | (($changed3 >> 18) & 896), 0, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1637colors0hiis_0;
    }

    static {
        float f;
        f = ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding;
        ItemContentPadding = PaddingKt.m478PaddingValuesYgX7TsA(f, Dp.m5218constructorimpl(0));
    }

    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1516textFieldColorstN0laI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long containerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        $composer.startReplaceableGroup(1357676928);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,10:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)627@34809L9,628@34901L9,629@35000L9,631@35175L9,632@35267L9,633@35364L9,634@35449L9,635@35549L9,636@35632L7,638@35752L9,640@35871L9,642@35997L9,645@36213L9,647@36333L9,649@36450L9,651@36574L9,654@36784L9,656@36906L9,658@37025L9,660@37151L9,663@37364L9,664@37460L9,665@37553L9,666@37653L9,667@37747L9,669@37861L9,671@37977L9,673@38100L9,675@38291L9,676@38388L9,677@38487L9,679@38606L9,680@38775L9,681@38872L9,682@38971L9,684@39090L9,685@39259L9,687@39303L2215:ExposedDropdownMenu.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c7;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 512) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 1024) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 2048) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c6;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 4096) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 8192) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((32768 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((65536 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((524288 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c4;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((1048576 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((8388608 & i) == 0) {
            disabledLabelColor2 = disabledLabelColor;
        } else {
            disabledLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
        }
        if ((16777216 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((67108864 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((134217728 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((268435456 & i) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 1) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 2) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 8) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 16) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 32) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1357676928, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:626)");
        }
        TextFieldColors m1514textFieldColorsFD9MK7s = m1514textFieldColorsFD9MK7s(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1514textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-tN0la-I, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1513outlinedTextFieldColorstN0laI(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long containerColor, long errorContainerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor, Composer $composer, int $changed, int $changed1, int $changed2, int $changed3, int i, int i2) {
        long unfocusedTextColor2;
        long disabledTextColor2;
        long errorTextColor2;
        long containerColor2;
        long errorContainerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long focusedPlaceholderColor2;
        long unfocusedPlaceholderColor2;
        long disabledPlaceholderColor2;
        long errorPlaceholderColor2;
        long focusedPrefixColor2;
        long unfocusedPrefixColor2;
        long disabledPrefixColor2;
        long errorPrefixColor2;
        long focusedSuffixColor2;
        long unfocusedSuffixColor2;
        long disabledSuffixColor2;
        long errorSuffixColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        $composer.startReplaceableGroup(-907010558);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(26:c#ui.graphics.Color,35:c#ui.graphics.Color,8:c#ui.graphics.Color,18:c#ui.graphics.Color,0:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,28,20:c#ui.graphics.Color,29:c#ui.graphics.Color,2:c#ui.graphics.Color,10:c#ui.graphics.Color,22:c#ui.graphics.Color,31:c#ui.graphics.Color,4:c#ui.graphics.Color,14:c#ui.graphics.Color,27:c#ui.graphics.Color,36:c#ui.graphics.Color,9:c#ui.graphics.Color,19:c#ui.graphics.Color,21:c#ui.graphics.Color,30:c#ui.graphics.Color,3:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,32:c#ui.graphics.Color,5:c#ui.graphics.Color,15:c#ui.graphics.Color,24:c#ui.graphics.Color,33:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,25:c#ui.graphics.Color,34:c#ui.graphics.Color,7:c#ui.graphics.Color,17:c#ui.graphics.Color)732@41743L9,733@41837L9,734@41938L9,736@42117L9,739@42311L9,741@42425L9,742@42508L7,743@42607L9,744@42705L9,746@42822L9,748@43011L9,750@43133L9,752@43252L9,754@43378L9,757@43592L9,759@43716L9,761@43837L9,763@43965L9,766@44182L9,767@44280L9,768@44375L9,769@44477L9,771@44657L9,773@44773L9,775@44891L9,777@45016L9,780@45223L9,781@45322L9,782@45423L9,784@45544L9,785@45717L9,786@45816L9,787@45917L9,789@46038L9,790@46211L9,792@46255L2199:ExposedDropdownMenu.kt#uh7d8r");
        long focusedTextColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), $composer, 6) : focusedTextColor;
        if ((i & 2) == 0) {
            unfocusedTextColor2 = unfocusedTextColor;
        } else {
            unfocusedTextColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c8;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 8) == 0) {
            errorTextColor2 = errorTextColor;
        } else {
            errorTextColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 32) == 0) {
            errorContainerColor2 = errorContainerColor;
        } else {
            errorContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 64) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 512) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 1024) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6);
        }
        if ((i & 2048) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c7;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 4096) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6);
        }
        if ((i & 8192) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((32768 & i) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((65536 & i) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((131072 & i) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((524288 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((1048576 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((2097152 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((8388608 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c4;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((16777216 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((33554432 & i) == 0) {
            focusedPlaceholderColor2 = focusedPlaceholderColor;
        } else {
            focusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((67108864 & i) == 0) {
            unfocusedPlaceholderColor2 = unfocusedPlaceholderColor;
        } else {
            unfocusedPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((134217728 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if ((268435456 & i) == 0) {
            errorPlaceholderColor2 = errorPlaceholderColor;
        } else {
            errorPlaceholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((536870912 & i) == 0) {
            focusedPrefixColor2 = focusedPrefixColor;
        } else {
            focusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i & BasicMeasure.EXACTLY) == 0) {
            unfocusedPrefixColor2 = unfocusedPrefixColor;
        } else {
            unfocusedPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 1) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledPrefixColor2 = m2947copywmQWz5c2;
        } else {
            disabledPrefixColor2 = disabledPrefixColor;
        }
        if ((i2 & 2) == 0) {
            errorPrefixColor2 = errorPrefixColor;
        } else {
            errorPrefixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 4) == 0) {
            focusedSuffixColor2 = focusedSuffixColor;
        } else {
            focusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 8) == 0) {
            unfocusedSuffixColor2 = unfocusedSuffixColor;
        } else {
            unfocusedSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i2 & 16) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
            disabledSuffixColor2 = m2947copywmQWz5c;
        } else {
            disabledSuffixColor2 = disabledSuffixColor;
        }
        if ((i2 & 32) == 0) {
            errorSuffixColor2 = errorSuffixColor;
        } else {
            errorSuffixColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-907010558, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:731)");
        }
        TextFieldColors m1511outlinedTextFieldColorsFD9MK7s = m1511outlinedTextFieldColorsFD9MK7s(focusedTextColor2, unfocusedTextColor2, disabledTextColor2, errorTextColor2, containerColor2, containerColor2, containerColor2, errorContainerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, focusedPlaceholderColor2, unfocusedPlaceholderColor2, disabledPlaceholderColor2, errorPlaceholderColor2, focusedPrefixColor2, unfocusedPrefixColor2, disabledPrefixColor2, errorPrefixColor2, focusedSuffixColor2, unfocusedSuffixColor2, disabledSuffixColor2, errorSuffixColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | ($changed & 57344) | (($changed << 3) & 458752) | (($changed << 6) & 3670016) | (($changed << 6) & 29360128) | (($changed << 6) & 234881024) | (($changed << 6) & 1879048192), (($changed >> 24) & 14) | (($changed >> 24) & 112) | (($changed1 << 6) & 896) | (($changed1 << 6) & 7168) | (($changed1 << 6) & 57344) | (($changed1 << 6) & 458752) | (($changed1 << 6) & 3670016) | (($changed1 << 6) & 29360128) | (($changed1 << 6) & 234881024) | (($changed1 << 6) & 1879048192), (($changed1 >> 24) & 14) | (($changed1 >> 24) & 112) | (($changed2 << 6) & 896) | (($changed2 << 6) & 7168) | (($changed2 << 6) & 57344) | (($changed2 << 6) & 458752) | (($changed2 << 6) & 3670016) | (($changed2 << 6) & 29360128) | (($changed2 << 6) & 234881024) | (($changed2 << 6) & 1879048192), (($changed2 >> 24) & 14) | (($changed2 >> 24) & 112) | (($changed3 << 6) & 896) | (($changed3 << 6) & 7168) | (57344 & ($changed3 << 6)) | (($changed3 << 6) & 458752) | (($changed3 << 6) & 3670016) | (($changed3 << 6) & 29360128) | (($changed3 << 6) & 234881024) | (($changed3 << 6) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1511outlinedTextFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: textFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1515textFieldColorsStqZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long disabledTextColor2;
        long containerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        $composer.startReplaceableGroup(-2013303349);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)837@48657L9,838@48756L9,840@48930L9,841@49015L9,842@49115L9,843@49198L7,845@49318L9,847@49437L9,849@49563L9,852@49779L9,854@49899L9,856@50016L9,858@50140L9,861@50350L9,863@50472L9,865@50591L9,867@50717L9,870@50930L9,871@51026L9,872@51119L9,873@51219L9,874@51313L9,875@51408L9,877@51526L9,911@53335L9,912@53429L9,913@53530L9,915@53709L9,916@53801L9,917@53895L9,918@53996L9,920@54175L9,879@51647L2544:ExposedDropdownMenu.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c7;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 64) != 0) {
            focusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), $composer, 6);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 128) == 0) {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        } else {
            unfocusedIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), $composer, 6)) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c6;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i & 512) == 0) {
            errorIndicatorColor2 = errorIndicatorColor;
        } else {
            errorIndicatorColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((i & 4096) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 8192) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((65536 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c4;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((131072 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((1048576 & i) == 0) {
            disabledLabelColor2 = disabledLabelColor;
        } else {
            disabledLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6);
        }
        if ((2097152 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            placeholderColor2 = placeholderColor;
        } else {
            placeholderColor2 = ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i & 8388608) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013303349, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:836)");
        }
        long color = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r0) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
        long color3 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color4 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color5 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r0) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
        TextFieldColors m1514textFieldColorsFD9MK7s = m1514textFieldColorsFD9MK7s(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedIndicatorColor2, unfocusedIndicatorColor2, disabledIndicatorColor2, errorIndicatorColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, color, color2, m2947copywmQWz5c, color3, color4, color5, m2947copywmQWz5c2, ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6), $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 << 15) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1514textFieldColorsFD9MK7s;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: outlinedTextFieldColors-St-qZLY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m1512outlinedTextFieldColorsStqZLY(long textColor, long disabledTextColor, long containerColor, long cursorColor, long errorCursorColor, SelectionColors selectionColors, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long disabledTextColor2;
        long containerColor2;
        long cursorColor2;
        long errorCursorColor2;
        SelectionColors selectionColors2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long focusedLeadingIconColor2;
        long unfocusedLeadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long focusedTrailingIconColor2;
        long unfocusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        long m2947copywmQWz5c7;
        long m2947copywmQWz5c8;
        $composer.startReplaceableGroup(-83147315);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(19:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,18,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,22:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,16:c#ui.graphics.Color,23:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)926@54404L9,927@54505L9,930@54727L9,932@54841L9,933@54924L7,934@55023L9,935@55121L9,937@55238L9,939@55427L9,941@55549L9,943@55668L9,945@55794L9,948@56008L9,950@56132L9,952@56253L9,954@56381L9,957@56598L9,958@56696L9,959@56791L9,960@56893L9,962@57073L9,963@57170L9,965@57290L9,999@59085L9,1000@59179L9,1001@59280L9,1003@59459L9,1004@59551L9,1005@59645L9,1006@59746L9,1008@59925L9,967@57413L2528:ExposedDropdownMenu.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), $composer, 6) : textColor;
        if ((i & 2) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c8;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 8) == 0) {
            cursorColor2 = cursorColor;
        } else {
            cursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            errorCursorColor2 = errorCursorColor;
        } else {
            errorCursorColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            selectionColors2 = selectionColors;
        } else {
            ProvidableCompositionLocal<SelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd($composer);
            selectionColors2 = (SelectionColors) consume;
        }
        if ((i & 64) != 0) {
            focusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), $composer, 6);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 128) == 0) {
            unfocusedBorderColor2 = unfocusedBorderColor;
        } else {
            unfocusedBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), $composer, 6);
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), $composer, 6)) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c7;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 512) == 0) {
            errorBorderColor2 = errorBorderColor;
        } else {
            errorBorderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            focusedLeadingIconColor2 = focusedLeadingIconColor;
        } else {
            focusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            unfocusedLeadingIconColor2 = unfocusedLeadingIconColor;
        } else {
            unfocusedLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), $composer, 6);
        }
        if ((i & 4096) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), $composer, 6)) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 8192) == 0) {
            errorLeadingIconColor2 = errorLeadingIconColor;
        } else {
            errorLeadingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), $composer, 6);
        }
        if ((i & 16384) == 0) {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        } else {
            focusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), $composer, 6);
        }
        if ((32768 & i) == 0) {
            unfocusedTrailingIconColor2 = unfocusedTrailingIconColor;
        } else {
            unfocusedTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), $composer, 6);
        }
        if ((65536 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), $composer, 6)) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c5;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((131072 & i) == 0) {
            errorTrailingIconColor2 = errorTrailingIconColor;
        } else {
            errorTrailingIconColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), $composer, 6);
        }
        if ((262144 & i) == 0) {
            focusedLabelColor2 = focusedLabelColor;
        } else {
            focusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), $composer, 6);
        }
        if ((524288 & i) == 0) {
            unfocusedLabelColor2 = unfocusedLabelColor;
        } else {
            unfocusedLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), $composer, 6);
        }
        if ((1048576 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), $composer, 6)) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c4;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((2097152 & i) == 0) {
            errorLabelColor2 = errorLabelColor;
        } else {
            errorLabelColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), $composer, 6);
        }
        if ((4194304 & i) == 0) {
            placeholderColor2 = placeholderColor;
        } else {
            placeholderColor2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        }
        if ((i & 8388608) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r4) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), $composer, 6)) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c3;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-83147315, $changed, $changed1, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:925)");
        }
        long color = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color2 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r0) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
        long color3 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color4 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        long color5 = ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6);
        m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r0, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r0) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r0) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r0) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), $composer, 6)) : 0.0f);
        TextFieldColors m1511outlinedTextFieldColorsFD9MK7s = m1511outlinedTextFieldColorsFD9MK7s(textColor2, textColor2, disabledTextColor2, textColor2, containerColor2, containerColor2, containerColor2, containerColor2, cursorColor2, errorCursorColor2, selectionColors2, focusedBorderColor2, unfocusedBorderColor2, disabledBorderColor2, errorBorderColor2, focusedLeadingIconColor2, unfocusedLeadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, focusedTrailingIconColor2, unfocusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, placeholderColor2, disabledPlaceholderColor2, placeholderColor2, color, color2, m2947copywmQWz5c, color3, color4, color5, m2947copywmQWz5c2, ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), $composer, 6), $composer, ($changed & 14) | (($changed << 3) & 112) | (($changed << 3) & 896) | (($changed << 9) & 7168) | (($changed << 6) & 57344) | (($changed << 9) & 458752) | (($changed << 12) & 3670016) | (($changed << 15) & 29360128) | (($changed << 15) & 234881024) | (($changed << 15) & 1879048192), (($changed >> 15) & 14) | (($changed >> 15) & 112) | (($changed >> 15) & 896) | (($changed >> 15) & 7168) | (($changed >> 15) & 57344) | (($changed1 << 15) & 458752) | (($changed1 << 15) & 3670016) | (($changed1 << 15) & 29360128) | (($changed1 << 15) & 234881024) | (($changed1 << 15) & 1879048192), (($changed1 >> 15) & 14) | (($changed1 >> 15) & 112) | (($changed1 >> 15) & 896) | (($changed1 >> 15) & 7168) | (($changed1 >> 15) & 57344) | (($changed2 << 15) & 458752) | (($changed2 << 15) & 3670016) | (($changed2 << 15) & 29360128) | (($changed2 << 18) & 234881024) | (($changed2 << 18) & 1879048192), (($changed2 >> 6) & 14) | (($changed2 << 15) & 1879048192), 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m1511outlinedTextFieldColorsFD9MK7s;
    }
}
