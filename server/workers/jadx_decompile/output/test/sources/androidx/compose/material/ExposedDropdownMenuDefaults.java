package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    public final void TrailingIcon(final boolean expanded, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(876077373);
        ComposerKt.sourceInformation($composer2, "C(TrailingIcon)299@11590L394:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expanded) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                Function0 onIconClick = new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }
                };
                function0 = onIconClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876077373, $dirty2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:291)");
            }
            IconButtonKt.IconButton(function0, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                    Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                }
            }), false, null, ComposableLambdaKt.composableLambda($composer2, 726122713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
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

                public final void invoke(Composer $composer3, int $changed2) {
                    float f;
                    ComposerKt.sourceInformation($composer3, "C300@11684L290:ExposedDropdownMenu.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(726122713, $changed2, -1, "androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.<anonymous> (ExposedDropdownMenu.kt:299)");
                        }
                        ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        if (expanded) {
                            f = 180.0f;
                        } else {
                            f = 360.0f;
                        }
                        IconKt.m1117Iconww6aTOc(arrowDropDown, "Trailing icon for exposed dropdown menu", RotateKt.rotate(companion, f), 0L, $composer3, 48, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty2 >> 3) & 14) | 24576, 12);
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
        final Function0<Unit> function02 = function0;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
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

            public final void invoke(Composer composer, int i3) {
                ExposedDropdownMenuDefaults.this.TrailingIcon(expanded, function02, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1098textFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
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
        long m2947copywmQWz5c9;
        long m2947copywmQWz5c10;
        long m2947copywmQWz5c11;
        long m2947copywmQWz5c12;
        long m2947copywmQWz5c13;
        long m2947copywmQWz5c14;
        long m2947copywmQWz5c15;
        $composer.startReplaceableGroup(1208167904);
        ComposerKt.sourceInformation($composer, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)358@14663L7,358@14694L7,359@14767L8,361@14837L6,362@14948L6,363@15012L6,365@15091L6,365@15132L4,367@15206L6,370@15406L8,371@15468L6,373@15542L6,374@15689L8,377@15818L6,379@15948L6,379@15989L4,380@16083L8,381@16148L6,383@16223L6,383@16264L4,384@16322L6,384@16357L6,385@16440L8,386@16498L6,387@16560L6,387@16595L6,388@16681L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2959unboximpl = ((Color) consume).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            m2947copywmQWz5c15 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(textColor2) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c15;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c14 = Color.m2947copywmQWz5c(r14, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r14) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r14) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r14) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            backgroundColor2 = m2947copywmQWz5c14;
        } else {
            backgroundColor2 = backgroundColor;
        }
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m2947copywmQWz5c13 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedIndicatorColor2 = m2947copywmQWz5c13;
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c12 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.42f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            unfocusedIndicatorColor2 = m2947copywmQWz5c12;
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c11 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(unfocusedIndicatorColor2) : 0.0f);
            disabledIndicatorColor2 = m2947copywmQWz5c11;
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        long errorIndicatorColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorIndicatorColor;
        if ((i & 512) != 0) {
            m2947copywmQWz5c10 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m2947copywmQWz5c10;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c9;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m2947copywmQWz5c8;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedTrailingIconColor2 = m2947copywmQWz5c7;
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m2947copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m2947copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m2947copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1208167904, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:357)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1097outlinedTextFieldColorsDlUQjxs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long trailingIconColor2;
        long focusedTrailingIconColor2;
        long disabledTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
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
        long m2947copywmQWz5c9;
        long m2947copywmQWz5c10;
        long m2947copywmQWz5c11;
        long m2947copywmQWz5c12;
        long m2947copywmQWz5c13;
        long m2947copywmQWz5c14;
        $composer.startReplaceableGroup(1162641182);
        ComposerKt.sourceInformation($composer, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)461@20648L7,461@20679L7,462@20752L8,464@20858L6,465@20922L6,467@20998L6,467@21039L4,469@21110L6,469@21153L8,470@21248L8,471@21307L6,473@21381L6,474@21528L8,477@21657L6,479@21787L6,479@21828L4,480@21922L8,481@21987L6,483@22062L6,483@22103L4,484@22161L6,484@22196L6,485@22279L8,486@22337L6,487@22399L6,487@22434L6,488@22520L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2959unboximpl = ((Color) consume).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
        } else {
            textColor2 = textColor;
        }
        if ((i & 2) != 0) {
            m2947copywmQWz5c14 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(textColor2) : 0.0f);
            disabledTextColor2 = m2947copywmQWz5c14;
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        long backgroundColor2 = (i & 4) != 0 ? Color.INSTANCE.m2984getTransparent0d7_KjU() : backgroundColor;
        long cursorColor2 = (i & 8) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU() : cursorColor;
        long errorCursorColor2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorCursorColor;
        if ((i & 32) != 0) {
            m2947copywmQWz5c13 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedBorderColor2 = m2947copywmQWz5c13;
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c12 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            unfocusedBorderColor2 = m2947copywmQWz5c12;
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c11 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(unfocusedBorderColor2) : 0.0f);
            disabledBorderColor2 = m2947copywmQWz5c11;
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long errorBorderColor2 = (i & 256) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorBorderColor;
        if ((i & 512) != 0) {
            m2947copywmQWz5c10 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            leadingIconColor2 = m2947copywmQWz5c10;
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i & 1024) != 0) {
            m2947copywmQWz5c9 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(leadingIconColor2) : 0.0f);
            disabledLeadingIconColor2 = m2947copywmQWz5c9;
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        long errorLeadingIconColor2 = (i & 2048) != 0 ? leadingIconColor2 : errorLeadingIconColor;
        if ((i & 4096) != 0) {
            m2947copywmQWz5c8 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : 0.54f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            trailingIconColor2 = m2947copywmQWz5c8;
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i & 8192) != 0) {
            m2947copywmQWz5c7 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedTrailingIconColor2 = m2947copywmQWz5c7;
        } else {
            focusedTrailingIconColor2 = focusedTrailingIconColor;
        }
        if ((i & 16384) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(trailingIconColor2) : 0.0f);
            disabledTrailingIconColor2 = m2947copywmQWz5c6;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        long errorTrailingIconColor2 = (32768 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorTrailingIconColor;
        if ((65536 & i) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getHigh($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1036getPrimary0d7_KjU()) : 0.0f);
            focusedLabelColor2 = m2947copywmQWz5c5;
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((131072 & i) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            unfocusedLabelColor2 = m2947copywmQWz5c4;
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((262144 & i) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(unfocusedLabelColor2) : 0.0f);
            disabledLabelColor2 = m2947copywmQWz5c3;
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        long errorLabelColor2 = (524288 & i) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1030getError0d7_KjU() : errorLabelColor;
        if ((1048576 & i) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r5, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r5) : ContentAlpha.INSTANCE.getMedium($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r5) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r5) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
            placeholderColor2 = m2947copywmQWz5c2;
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i & 2097152) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r94, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r94) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r94) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r94) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(placeholderColor2) : 0.0f);
            disabledPlaceholderColor2 = m2947copywmQWz5c;
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1162641182, $changed, $changed1, "androidx.compose.material.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:460)");
        }
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, focusedTrailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
