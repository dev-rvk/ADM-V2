package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tab.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0083\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u008b\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a{\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\b\u0016¢\u0006\u0002\b(H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0002\u0010,\u001a@\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m2414getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m5218constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m5218constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m5218constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m5218constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m5218constructorimpl(8);

    /* renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m1821TabwqdebIU(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Function2 function23;
        long unselectedContentColor2;
        Modifier modifier2;
        long selectedContentColor2;
        Modifier modifier3;
        MutableInteractionSource interactionSource2;
        boolean enabled2;
        long unselectedContentColor3;
        long selectedContentColor3;
        final int $dirty;
        final Function2 text;
        final Function2 icon;
        Object value$iv$iv;
        Function2 icon2;
        Function2 text2;
        Composer $composer2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-350627181);
        ComposerKt.sourceInformation($composer3, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4497L7,101@4614L39,111@4981L234:Tab.kt#uh7d8r");
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
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
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
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer3.changed(selectedContentColor)) {
                i3 = 1048576;
                $dirty2 |= i3;
            }
            i3 = 524288;
            $dirty2 |= i3;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0) {
                unselectedContentColor2 = unselectedContentColor;
                if ($composer3.changed(unselectedContentColor2)) {
                    i2 = 8388608;
                    $dirty2 |= i2;
                }
            } else {
                unselectedContentColor2 = unselectedContentColor;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            unselectedContentColor2 = unselectedContentColor;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty2 |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty2 & 191739611) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier;
            enabled2 = enabled;
            text2 = function2;
            selectedContentColor3 = selectedContentColor;
            interactionSource2 = interactionSource;
            unselectedContentColor3 = unselectedContentColor2;
            icon2 = function23;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i4 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i5 != 0 ? true : enabled;
                Function2 text3 = i6 != 0 ? null : function2;
                Function2 icon3 = i7 != 0 ? null : function23;
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    modifier2 = modifier4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    selectedContentColor2 = ((Color) consume).m2959unboximpl();
                    $dirty2 &= -3670017;
                } else {
                    modifier2 = modifier4;
                    selectedContentColor2 = selectedContentColor;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty2 &= -29360129;
                }
                if (i8 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    modifier3 = modifier2;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    enabled2 = enabled3;
                    unselectedContentColor3 = unselectedContentColor2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty = $dirty3;
                    text = text3;
                    icon = icon3;
                } else {
                    modifier3 = modifier2;
                    interactionSource2 = interactionSource;
                    enabled2 = enabled3;
                    unselectedContentColor3 = unselectedContentColor2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty = $dirty2;
                    text = text3;
                    icon = icon3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                if ((i & 128) != 0) {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    selectedContentColor3 = selectedContentColor;
                    interactionSource2 = interactionSource;
                    unselectedContentColor3 = unselectedContentColor2;
                    icon = function23;
                    text = function2;
                    $dirty = $dirty2 & (-29360129);
                } else {
                    modifier3 = modifier;
                    enabled2 = enabled;
                    selectedContentColor3 = selectedContentColor;
                    interactionSource2 = interactionSource;
                    unselectedContentColor3 = unselectedContentColor2;
                    icon = function23;
                    text = function2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350627181, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:92)");
            }
            final Function2 styledText = text != null ? ComposableLambdaKt.composableLambda($composer3, 708874428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$styledText$1$1
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
                    ComposerKt.sourceInformation($composer4, "C106@4794L10,108@4921L39:Tab.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(708874428, $changed2, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:104)");
                        }
                        TextStyle style = TextStyle.m4734copyCXVQc50$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer4, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m5083boximpl(TextAlign.INSTANCE.m5090getCentere0LSkKk()), null, 0L, null, null, null, null, null, 4177919, null);
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
            m1820TabbogVsAg(selected, onClick, modifier3, enabled2, selectedContentColor3, unselectedContentColor3, interactionSource2, ComposableLambdaKt.composableLambda($composer3, 1540996038, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$2
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
                    ComposerKt.sourceInformation($composer4, "C120@5160L49:Tab.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1540996038, $changed2, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:119)");
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
        final Modifier modifier5 = modifier3;
        final boolean z = enabled2;
        final Function2 function24 = text2;
        final Function2 function25 = icon2;
        final long j = selectedContentColor3;
        final long j2 = unselectedContentColor3;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$Tab$3
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
                TabKt.m1821TabwqdebIU(selected, onClick, modifier5, z, function24, function25, j, j2, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m1819LeadingIconTabwqdebIU(final boolean selected, final Function0<Unit> onClick, final Function2<? super Composer, ? super Integer, Unit> text, final Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean enabled2;
        long selectedContentColor2;
        int $dirty;
        long unselectedContentColor2;
        long unselectedContentColor3;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        long selectedContentColor3;
        final int $dirty2;
        Modifier modifier3;
        Object value$iv$iv;
        int $dirty3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer $composer2 = $composer.startRestartGroup(-777316544);
        ComposerKt.sourceInformation($composer2, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)161@6997L7,163@7114L39,168@7394L60,170@7460L991:Tab.kt#uh7d8r");
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
        if ((3670016 & $changed) == 0) {
            if ((i & 64) == 0) {
                selectedContentColor2 = selectedContentColor;
                if ($composer2.changed(selectedContentColor2)) {
                    i3 = 1048576;
                    $dirty4 |= i3;
                }
            } else {
                selectedContentColor2 = selectedContentColor;
            }
            i3 = 524288;
            $dirty4 |= i3;
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((29360128 & $changed) == 0) {
            if ((i & 128) == 0) {
                $dirty3 = $dirty4;
                if ($composer2.changed(unselectedContentColor)) {
                    i2 = 8388608;
                    $dirty = $dirty3 | i2;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i2 = 4194304;
            $dirty = $dirty3 | i2;
        } else {
            $dirty = $dirty4;
        }
        int i6 = i & 256;
        if (i6 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            unselectedContentColor3 = unselectedContentColor;
            interactionSource2 = interactionSource;
            enabled3 = enabled2;
            selectedContentColor3 = selectedContentColor2;
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
                if ((i & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(localContentColor);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -3670017;
                    selectedContentColor2 = ((Color) consume).m2959unboximpl();
                }
                if ((i & 128) != 0) {
                    unselectedContentColor2 = selectedContentColor2;
                    $dirty &= -29360129;
                } else {
                    unselectedContentColor2 = unselectedContentColor;
                }
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    long unselectedContentColor4 = unselectedContentColor2;
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    unselectedContentColor3 = unselectedContentColor4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                } else {
                    unselectedContentColor3 = unselectedContentColor2;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                if ((i & 128) != 0) {
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-29360129);
                    modifier3 = modifier2;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                } else {
                    unselectedContentColor3 = unselectedContentColor;
                    interactionSource2 = interactionSource;
                    enabled3 = enabled2;
                    selectedContentColor3 = selectedContentColor2;
                    $dirty2 = $dirty;
                    modifier3 = modifier2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-777316544, $dirty2, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:154)");
            }
            final Indication ripple = RippleKt.m1286rememberRipple9IZ8Weo(true, 0.0f, selectedContentColor3, $composer2, (($dirty2 >> 12) & 896) | 6, 2);
            final Modifier modifier4 = modifier3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z = enabled3;
            int $dirty5 = $dirty2;
            m1822TabTransitionKlgxPg(selectedContentColor3, unselectedContentColor3, selected, ComposableLambdaKt.composableLambda($composer2, -429037564, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$2
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

                public final void invoke(Composer $composer3, int $changed2) {
                    float f;
                    float f2;
                    float f3;
                    ComposerKt.sourceInformation($composer3, "C171@7540L905:Tab.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-429037564, $changed2, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:170)");
                        }
                        Modifier modifier5 = Modifier.this;
                        f = TabKt.SmallTabHeight;
                        Modifier m708selectableO2vRcR0 = SelectableKt.m708selectableO2vRcR0(SizeKt.m517height3ABfNKs(modifier5, f), selected, mutableInteractionSource, ripple, z, Role.m4561boximpl(Role.INSTANCE.m4574getTabo7Vup1c()), onClick);
                        f2 = TabKt.HorizontalTextPadding;
                        Modifier modifier$iv = SizeKt.fillMaxWidth$default(PaddingKt.m486paddingVpY3zN4$default(m708selectableO2vRcR0, f2, 0.0f, 2, null), 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function2 = icon;
                        int i7 = $dirty2;
                        Function2<Composer, Integer, Unit> function22 = text;
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                        int $changed$iv$iv = (432 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume2;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i8 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i9 = ((432 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 757417377, "C187@8152L6,188@8171L59,189@8269L10,191@8396L39:Tab.kt#uh7d8r");
                        function2.invoke($composer3, Integer.valueOf((i7 >> 9) & 14));
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f3 = TabKt.TextDistanceFromLeadingIcon;
                        SpacerKt.Spacer(SizeKt.m528requiredWidth3ABfNKs(companion, f3), $composer3, 6);
                        TextStyle style = TextStyle.m4734copyCXVQc50$default(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, TextAlign.m5083boximpl(TextAlign.INSTANCE.m5090getCentere0LSkKk()), null, 0L, null, null, null, null, null, 4177919, null);
                        TextKt.ProvideTextStyle(style, function22, $composer3, (i7 >> 3) & 112);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty5 >> 18) & 14) | 3072 | (($dirty5 >> 18) & 112) | (($dirty5 << 6) & 896));
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
        final long j = selectedContentColor3;
        final long j2 = unselectedContentColor3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$LeadingIconTab$3
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
                TabKt.m1819LeadingIconTabwqdebIU(selected, onClick, text, icon, modifier5, z2, j, j2, mutableInteractionSource2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016d  */
    /* renamed from: Tab-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1820TabbogVsAg(final boolean r26, final kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, long r30, long r32, androidx.compose.foundation.interaction.MutableInteractionSource r34, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m1820TabbogVsAg(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, long, long, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0183  */
    /* renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1822TabTransitionKlgxPg(final long r30, final long r32, final boolean r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabKt.m1822TabTransitionKlgxPg(long, long, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(514131524);
        ComposerKt.sourceInformation($composer3, "C(TabBaselineLayout)P(1)307@12887L2151:Tab.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514131524, $dirty, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:303)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    Placeable placeable;
                    Placeable placeable2;
                    long j;
                    long m5164copyZbe2FdA;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    if (function2 == null) {
                        placeable = null;
                    } else {
                        List<? extends Measurable> $this$first$iv = measurables;
                        for (Object element$iv : $this$first$iv) {
                            Measurable it = (Measurable) element$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "text")) {
                                m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                                placeable = ((Measurable) element$iv).mo4186measureBRTryo0(m5164copyZbe2FdA);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    final Placeable textPlaceable = placeable;
                    if (function22 != null) {
                        List<? extends Measurable> $this$first$iv2 = measurables;
                        for (Object element$iv2 : $this$first$iv2) {
                            Measurable it2 = (Measurable) element$iv2;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "icon")) {
                                placeable2 = ((Measurable) element$iv2).mo4186measureBRTryo0(constraints);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    placeable2 = null;
                    final Placeable iconPlaceable = placeable2;
                    final int tabWidth = Math.max(textPlaceable != null ? textPlaceable.getWidth() : 0, iconPlaceable != null ? iconPlaceable.getWidth() : 0);
                    int specHeight = Layout.mo323roundToPx0680j_4((textPlaceable == null || iconPlaceable == null) ? TabKt.SmallTabHeight : TabKt.LargeTabHeight);
                    int height = iconPlaceable != null ? iconPlaceable.getHeight() : 0;
                    int height2 = textPlaceable != null ? textPlaceable.getHeight() : 0;
                    j = TabKt.IconDistanceFromBaseline;
                    final int tabHeight = Math.max(specHeight, height + height2 + Layout.mo322roundToPxR2X_6o(j));
                    final Integer firstBaseline = textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getFirstBaseline())) : null;
                    final Integer lastBaseline = textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getLastBaseline())) : null;
                    return MeasureScope.layout$default(Layout, tabWidth, tabHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$2$measure$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            if (Placeable.this != null && iconPlaceable != null) {
                                MeasureScope measureScope = Layout;
                                Placeable placeable3 = Placeable.this;
                                Placeable placeable4 = iconPlaceable;
                                int i = tabWidth;
                                int i2 = tabHeight;
                                Integer num = firstBaseline;
                                Intrinsics.checkNotNull(num);
                                int intValue = num.intValue();
                                Integer num2 = lastBaseline;
                                Intrinsics.checkNotNull(num2);
                                TabKt.placeTextAndIcon(layout, measureScope, placeable3, placeable4, i, i2, intValue, num2.intValue());
                                return;
                            }
                            if (Placeable.this != null) {
                                TabKt.placeTextOrIcon(layout, Placeable.this, tabHeight);
                            } else if (iconPlaceable != null) {
                                TabKt.placeTextOrIcon(layout, iconPlaceable, tabHeight);
                            }
                        }
                    }, 4, null);
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.INSTANCE;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 720851189, "C:Tab.kt#uh7d8r");
            $composer3.startReplaceableGroup(720851189);
            ComposerKt.sourceInformation($composer3, "310@12953L173");
            if (function2 == null) {
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv2 = PaddingKt.m486paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                int $i$f$Box = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, $i$f$Box);
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer3.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer3.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                $composer2 = $composer3;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i2 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i3 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -978021409, "C314@13118L6:Tab.kt#uh7d8r");
                function2.invoke($composer3, Integer.valueOf($dirty & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(150513216);
            ComposerKt.sourceInformation($composer3, "317@13189L41");
            if (function22 != null) {
                Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
                $composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density density$iv$iv2 = (Density) consume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer3.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer3.consume(localViewConfiguration3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv3);
                int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    $composer3.useNode();
                }
                $composer3.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer3);
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer3.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer3.startReplaceableGroup(2058660585);
                int i4 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -978021305, "C317@13222L6:Tab.kt#uh7d8r");
                function22.invoke($composer3, Integer.valueOf(($dirty >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceableGroup();
                $composer3.endNode();
                $composer3.endReplaceableGroup();
                $composer3.endReplaceableGroup();
            }
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabKt$TabBaselineLayout$3
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

            public final void invoke(Composer composer, int i6) {
                TabKt.TabBaselineLayout(function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
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
        int textOffset = density.mo323roundToPx0680j_4(baselineOffset) + density.mo323roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m2412getActiveIndicatorHeightD9Ej5fM());
        int iconOffset = (iconPlaceable.getHeight() + density.mo322roundToPxR2X_6o(IconDistanceFromBaseline)) - firstBaseline;
        int textPlaceableX = (tabWidth - textPlaceable.getWidth()) / 2;
        int textPlaceableY = (tabHeight - lastBaseline) - textOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, textPlaceableX, textPlaceableY, 0.0f, 4, null);
        int iconPlaceableX = (tabWidth - iconPlaceable.getWidth()) / 2;
        int iconPlaceableY = textPlaceableY - iconOffset;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, iconPlaceableX, iconPlaceableY, 0.0f, 4, null);
    }
}
