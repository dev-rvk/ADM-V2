package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0083\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?²\u0006\n\u0010@\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release", "color"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = Dp.m5218constructorimpl(48);
    private static final float LargeTabHeight = Dp.m5218constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m5218constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5218constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5218constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m5218constructorimpl(8);

    /* renamed from: Tab-0nD-MI0, reason: not valid java name */
    public static final void m1215Tab0nDMI0(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function2 function23;
        long j;
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        long selectedContentColor2;
        boolean enabled3;
        MutableInteractionSource interactionSource3;
        long selectedContentColor3;
        final Function2 text;
        final Function2 icon;
        long unselectedContentColor2;
        final int $dirty;
        long unselectedContentColor3;
        Object value$iv$iv;
        Function2 icon2;
        Function2 text2;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4350L39,97@4443L7,98@4535L6,106@4792L234:Tab.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty2 |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function23 = function22;
        } else if (($changed & 458752) == 0) {
            function23 = function22;
            $dirty2 |= $composer3.changedInstance(function23) ? 131072 : 65536;
        } else {
            function23 = function22;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(selectedContentColor)) {
                i3 = 8388608;
                $dirty2 |= i3;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        }
        if ((234881024 & $changed) == 0) {
            if ((i & 256) == 0) {
                j = unselectedContentColor;
                if ($composer3.changed(j)) {
                    i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty2 |= i2;
                }
            } else {
                j = unselectedContentColor;
            }
            i2 = 33554432;
            $dirty2 |= i2;
        } else {
            j = unselectedContentColor;
        }
        if ((191739611 & $dirty2) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            text2 = function2;
            interactionSource3 = interactionSource;
            selectedContentColor3 = selectedContentColor;
            enabled3 = z;
            unselectedContentColor2 = j;
            icon2 = function23;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled4 = i5 != 0 ? true : z;
                Function2 text3 = i6 != 0 ? null : function2;
                Function2 icon3 = i7 != 0 ? null : function23;
                if (i8 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        enabled2 = enabled4;
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        enabled2 = enabled4;
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                    enabled2 = enabled4;
                    interactionSource2 = interactionSource;
                }
                if ((i & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor2 = ((Color) consume).m2959unboximpl();
                    $dirty2 &= -29360129;
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 256) != 0) {
                    unselectedContentColor3 = Color.m2947copywmQWz5c(r25, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r25) : ContentAlpha.INSTANCE.getMedium($composer3, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r25) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r25) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectedContentColor2) : 0.0f);
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    selectedContentColor3 = selectedContentColor2;
                    text = text3;
                    icon = icon3;
                    unselectedContentColor2 = unselectedContentColor3;
                    $dirty = $dirty2 & (-234881025);
                } else {
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    selectedContentColor3 = selectedContentColor2;
                    text = text3;
                    icon = icon3;
                    unselectedContentColor2 = j;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier;
                    interactionSource3 = interactionSource;
                    selectedContentColor3 = selectedContentColor;
                    enabled3 = z;
                    unselectedContentColor2 = j;
                    icon = function23;
                    text = function2;
                    $dirty = $dirty2 & (-234881025);
                } else {
                    modifier2 = modifier;
                    interactionSource3 = interactionSource;
                    selectedContentColor3 = selectedContentColor;
                    enabled3 = z;
                    unselectedContentColor2 = j;
                    icon = function23;
                    text = function2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1486097588, $dirty, -1, "androidx.compose.material.Tab (Tab.kt:89)");
            }
            final Function2 styledText = text != null ? ComposableLambdaKt.composableLambda($composer3, -1729014781, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$styledText$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C102@4667L10,103@4732L39:Tab.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1729014781, $changed2, -1, "androidx.compose.material.Tab.<anonymous>.<anonymous> (Tab.kt:101)");
                        }
                        TextStyle style = TextStyle.m4738copyv2rsoow$default(MaterialTheme.INSTANCE.getTypography($composer4, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.m5083boximpl(TextAlign.INSTANCE.m5090getCentere0LSkKk()), null, 0L, null, null, null, null, null, null, 16744447, null);
                        TextKt.ProvideTextStyle(style, text, $composer4, ($dirty >> 9) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }) : null;
            icon2 = icon;
            text2 = text;
            $composer2 = $composer3;
            m1216TabEVJuX4I(selected, onClick, modifier2, enabled3, interactionSource3, selectedContentColor3, unselectedContentColor2, ComposableLambdaKt.composableLambda($composer3, -178151495, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Tab, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(Tab, "$this$Tab");
                    ComposerKt.sourceInformation($composer4, "C115@4971L49:Tab.kt#jmzs0o");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-178151495, $changed2, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:114)");
                        }
                        TabKt.TabBaselineLayout(styledText, icon, $composer4, ($dirty >> 12) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer3, 12582912 | ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 6) & 57344) | (($dirty >> 6) & 458752) | (($dirty >> 6) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final boolean z2 = enabled3;
        final Function2 function24 = text2;
        final Function2 function25 = icon2;
        final MutableInteractionSource mutableInteractionSource = interactionSource3;
        final long j2 = selectedContentColor3;
        final long j3 = unselectedContentColor2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$Tab$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i9) {
                TabKt.m1215Tab0nDMI0(selected, onClick, modifier4, z2, function24, function25, mutableInteractionSource, j2, j3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    public static final void m1214LeadingIconTab0nDMI0(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> text, final Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        MutableInteractionSource interactionSource2;
        int $dirty;
        long selectedContentColor2;
        long unselectedContentColor2;
        long selectedContentColor3;
        boolean enabled3;
        MutableInteractionSource interactionSource3;
        final int $dirty2;
        Modifier modifier3;
        long unselectedContentColor3;
        Object value$iv$iv;
        int i2;
        int $dirty3;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer $composer2 = $composer.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation($composer2, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6914L39,159@7007L7,160@7099L6,165@7347L60,167@7413L929:Tab.kt#jmzs0o");
        int $dirty4 = $changed;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer2.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer2.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer2.changedInstance(text) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty4 |= $composer2.changedInstance(icon) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty4 |= 24576;
            modifier2 = modifier;
        } else if ((57344 & $changed) == 0) {
            modifier2 = modifier;
            $dirty4 |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            enabled2 = enabled;
        } else if ((458752 & $changed) == 0) {
            enabled2 = enabled;
            $dirty4 |= $composer2.changed(enabled2) ? 131072 : 65536;
        } else {
            enabled2 = enabled;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty4 |= 1572864;
            interactionSource2 = interactionSource;
        } else if ((3670016 & $changed) == 0) {
            interactionSource2 = interactionSource;
            $dirty4 |= $composer2.changed(interactionSource2) ? 1048576 : 524288;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer2.changed(selectedContentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 4194304;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer2.changed(unselectedContentColor)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            selectedContentColor3 = selectedContentColor;
            unselectedContentColor2 = unselectedContentColor;
            enabled3 = enabled2;
            interactionSource3 = interactionSource2;
            modifier3 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    enabled2 = true;
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                }
                if ((i & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    selectedContentColor2 = ((Color) consume).m2959unboximpl();
                    $dirty &= -29360129;
                } else {
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 256) != 0) {
                    unselectedContentColor3 = Color.m2947copywmQWz5c(r20, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r20) : ContentAlpha.INSTANCE.getMedium($composer2, 6), (r12 & 2) != 0 ? Color.m2955getRedimpl(r20) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r20) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectedContentColor2) : 0.0f);
                    $dirty2 = $dirty & (-234881025);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    unselectedContentColor2 = unselectedContentColor3;
                    selectedContentColor3 = selectedContentColor2;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                    selectedContentColor3 = selectedContentColor2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if ((i & 256) != 0) {
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    $dirty2 = $dirty & (-234881025);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                } else {
                    selectedContentColor3 = selectedContentColor;
                    unselectedContentColor2 = unselectedContentColor;
                    enabled3 = enabled2;
                    interactionSource3 = interactionSource2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1499861761, $dirty2, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:151)");
            }
            final Indication ripple = RippleKt.m1286rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor3, $composer2, (($dirty2 >> 15) & 896) | 6, 2);
            final Modifier modifier4 = modifier3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final boolean z = enabled3;
            int $dirty5 = $dirty2;
            m1217TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor2, selected, ComposableLambdaKt.composableLambda($composer2, 866677691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:24:0x020e  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r61, int r62) {
                    /*
                        Method dump skipped, instructions count: 530
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt$LeadingIconTab$2.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, (($dirty5 >> 21) & 14) | 3072 | (($dirty5 >> 21) & 112) | (($dirty5 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource3;
        final long j = selectedContentColor3;
        final long j2 = unselectedContentColor2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$LeadingIconTab$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i7) {
                TabKt.m1214LeadingIconTab0nDMI0(selected, onClick, text, icon, modifier5, z2, mutableInteractionSource2, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01fc  */
    /* renamed from: Tab-EVJuX4I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1216TabEVJuX4I(final boolean r29, final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, long r34, long r36, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.m1216TabEVJuX4I(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1217TabTransitionKlgxPg(final long activeColor, final long inactiveColor, final boolean selected, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        long j;
        long j2;
        Object value$iv$iv$iv;
        long m2947copywmQWz5c;
        Composer $composer2 = $composer.startRestartGroup(-405571117);
        ComposerKt.sourceInformation($composer2, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)268@11677L26,269@11732L550,287@12287L164:Tab.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            j = activeColor;
            $dirty |= $composer2.changed(j) ? 4 : 2;
        } else {
            j = activeColor;
        }
        if (($changed & 112) == 0) {
            j2 = inactiveColor;
            $dirty |= $composer2.changed(j2) ? 32 : 16;
        } else {
            j2 = inactiveColor;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(selected) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-405571117, $dirty, -1, "androidx.compose.material.TabTransition (Tab.kt:262)");
            }
            Transition transition = TransitionKt.updateTransition(Boolean.valueOf(selected), (String) null, $composer2, ($dirty >> 6) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material.TabKt$TabTransition$color$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> animateColor, Composer $composer3, int $changed2) {
                    TweenSpec tween$default;
                    Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
                    $composer3.startReplaceableGroup(-2120892502);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2120892502, $changed2, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:270)");
                    }
                    if (animateColor.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
                    } else {
                        tween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            $composer2.startReplaceableGroup(-1939694975);
            ComposerKt.sourceInformation($composer2, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
            int $changed2 = (0 >> 6) & 112;
            boolean it = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed2, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j3 = it ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            ColorSpace colorSpace$iv = Color.m2953getColorSpaceimpl(j3);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv$iv = $composer2.changed(colorSpace$iv);
            Object it$iv$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv$iv = ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace$iv);
                $composer2.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer2.endReplaceableGroup();
            TwoWayConverter typeConverter$iv = (TwoWayConverter) value$iv$iv$iv;
            int $changed$iv$iv = (0 & 14) | 64 | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer2.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed3, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j4 = it2 ? activeColor : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv = Color.m2939boximpl(j4);
            int $changed4 = ($changed$iv$iv >> 9) & 112;
            boolean it3 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceableGroup(1445938070);
            ComposerKt.sourceInformation($composer2, "C:Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445938070, $changed4, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)");
            }
            long j5 = it3 ? activeColor : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object targetValue$iv$iv = Color.m2939boximpl(j5);
            FiniteAnimationSpec<Color> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            State color$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv, "ColorAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r9, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r9) : 1.0f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r9) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r9) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(TabTransition_Klgx_Pg$lambda$5(color$delegate)) : 0.0f);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localContentColor.provides(Color.m2939boximpl(m2947copywmQWz5c)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2951getAlphaimpl(TabTransition_Klgx_Pg$lambda$5(color$delegate))))}, function2, $composer2, (($dirty >> 6) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabKt$TabTransition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                TabKt.m1217TabTransitionKlgxPg(activeColor, inactiveColor, selected, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0292  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TabBaselineLayout(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabKt.TabBaselineLayout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        int contentY = (tabHeight - textOrIconPlaceable.getHeight()) / 2;
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, contentY, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float baselineOffset;
        if (firstBaseline == lastBaseline) {
            baselineOffset = SingleLineTextBaselineWithIcon;
        } else {
            baselineOffset = DoubleLineTextBaselineWithIcon;
        }
        int textOffset = density.mo323roundToPx0680j_4(baselineOffset) + density.mo323roundToPx0680j_4(TabRowDefaults.INSTANCE.m1225getIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.mo322roundToPxR2X_6o(IconDistanceFromBaseline)) - firstBaseline;
        int textPlaceableX = (tabWidth - textPlaceable.getWidth()) / 2;
        int textPlaceableY = (tabHeight - lastBaseline) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, textPlaceableX, textPlaceableY, 0.0f, 4, null);
        int iconPlaceableX = (tabWidth - iconPlaceable.getWidth()) / 2;
        int iconPlaceableY = textPlaceableY - iconOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, iconPlaceableX, iconPlaceableY, 0.0f, 4, null);
    }
}
