package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding = Dp.m5218constructorimpl(2);
    private static final float CheckboxSize = Dp.m5218constructorimpl(20);
    private static final float StrokeWidth = Dp.m5218constructorimpl(2);
    private static final float RadiusSize = Dp.m5218constructorimpl(2);

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void Checkbox(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        CheckboxColors colors2;
        MutableInteractionSource interactionSource2;
        Modifier.Companion modifier3;
        boolean enabled2;
        MutableInteractionSource interactionSource3;
        Object value$iv$iv;
        Function0 function0;
        Modifier modifier4;
        boolean enabled3;
        CheckboxColors colors3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation($composer2, "C(Checkbox)P(!1,5,4,2)92@4250L8,93@4310L39,95@4358L328:Checkbox.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                colors2 = colors;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            colors2 = colors;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interactionSource2 = interactionSource;
        } else if (($changed & 458752) == 0) {
            interactionSource2 = interactionSource;
            $dirty |= $composer2.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((374491 & $dirty) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            enabled3 = z;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                enabled2 = i4 != 0 ? true : z;
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    colors2 = CheckboxDefaults.INSTANCE.m1340colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer2, 1572864, 63);
                }
                if (i5 != 0) {
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
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    interactionSource3 = interactionSource;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                enabled2 = z;
                interactionSource3 = interactionSource2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1406741137, $dirty, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:87)");
            }
            ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(checked);
            $composer2.startReplaceableGroup(1557792622);
            ComposerKt.sourceInformation($composer2, "98@4479L29");
            if (function1 != null) {
                Object key2$iv = Boolean.valueOf(checked);
                int i6 = (($dirty >> 3) & 14) | (($dirty << 3) & 112);
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(function1) | $composer2.changed(key2$iv);
                Object value$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv && value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                    $composer2.endReplaceableGroup();
                    function0 = (Function0) value$iv$iv2;
                }
                value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function1.invoke(Boolean.valueOf(!checked));
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                function0 = (Function0) value$iv$iv2;
            } else {
                function0 = null;
            }
            $composer2.endReplaceableGroup();
            TriStateCheckbox(ToggleableState, function0, modifier3, enabled2, colors2, interactionSource3, $composer2, ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            enabled3 = enabled2;
            interactionSource2 = interactionSource3;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final boolean z2 = enabled3;
        final CheckboxColors checkboxColors = colors3;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$3
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
                CheckboxKt.Checkbox(checked, function1, modifier5, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void TriStateCheckbox(final ToggleableState state, final Function0<Unit> function0, Modifier modifier, boolean enabled, CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        CheckboxColors checkboxColors;
        MutableInteractionSource interactionSource2;
        CheckboxColors colors2;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        CheckboxColors colors3;
        Object value$iv$iv;
        int $dirty2;
        Modifier.Companion companion;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation($composer2, "C(TriStateCheckbox)P(5,4,3,1)142@6643L8,143@6703L39,161@7271L412:Checkbox.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty3 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                checkboxColors = colors;
                if ($composer2.changed(checkboxColors)) {
                    i2 = 16384;
                    $dirty3 |= i2;
                }
            } else {
                checkboxColors = colors;
            }
            i2 = 8192;
            $dirty3 |= i2;
        } else {
            checkboxColors = colors;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interactionSource2 = interactionSource;
        } else if ((458752 & $changed) == 0) {
            interactionSource2 = interactionSource;
            $dirty3 |= $composer2.changed(interactionSource2) ? 131072 : 65536;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((374491 & $dirty3) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
            colors3 = checkboxColors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                boolean enabled3 = i4 != 0 ? true : z;
                if ((i & 16) != 0) {
                    colors2 = CheckboxDefaults.INSTANCE.m1340colors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer2, 1572864, 63);
                    $dirty3 &= -57345;
                } else {
                    colors2 = checkboxColors;
                }
                if (i5 != 0) {
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
                    $dirty = $dirty3;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    colors3 = colors2;
                } else {
                    interactionSource2 = interactionSource;
                    $dirty = $dirty3;
                    modifier3 = modifier4;
                    enabled2 = enabled3;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                $dirty = $dirty3;
                modifier3 = modifier2;
                enabled2 = z;
                colors3 = checkboxColors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, $dirty, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:137)");
            }
            $composer2.startReplaceableGroup(1797978260);
            ComposerKt.sourceInformation($composer2, "153@7071L133");
            if (function0 != null) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                int m4569getCheckboxo7Vup1c = Role.INSTANCE.m4569getCheckboxo7Vup1c();
                float arg0$iv = CheckboxTokens.INSTANCE.m2027getStateLayerSizeD9Ej5fM();
                $dirty2 = $dirty;
                companion = ToggleableKt.m716triStateToggleableO2vRcR0(companion2, state, interactionSource2, RippleKt.m1286rememberRipple9IZ8Weo(false, Dp.m5218constructorimpl(arg0$iv / 2), 0L, $composer2, 54, 4), enabled2, Role.m4561boximpl(m4569getCheckboxo7Vup1c), function0);
            } else {
                $dirty2 = $dirty;
                companion = Modifier.INSTANCE;
            }
            $composer2.endReplaceableGroup();
            Modifier toggleableModifier = companion;
            CheckboxImpl(enabled2, state, PaddingKt.m484padding3ABfNKs(modifier3.then(function0 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(toggleableModifier), CheckboxDefaultPadding), colors3, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final boolean z2 = enabled2;
        final CheckboxColors checkboxColors2 = colors3;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$TriStateCheckbox$2
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

            public final void invoke(Composer composer, int i6) {
                CheckboxKt.TriStateCheckbox(ToggleableState.this, function0, modifier5, z2, checkboxColors2, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:81:0x025a. Please report as an issue. */
    public static final void CheckboxImpl(final boolean enabled, final ToggleableState value, final Modifier modifier, final CheckboxColors colors, Composer $composer, final int $changed) {
        String str;
        float f;
        float f2;
        float f3;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(2007131616);
        ComposerKt.sourceInformation($composer2, "C(CheckboxImpl)P(1,3,2)235@10358L23,236@10421L443,252@10923L458,267@11403L32,268@11464L21,269@11512L24,270@11566L27,275@11716L538,271@11598L656:Checkbox.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(value) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, $dirty2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:229)");
            }
            Transition transition = TransitionKt.updateTransition(value, (String) null, $composer2, ($dirty2 >> 3) & 14, 2);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> animateFloat, Composer $composer3, int $changed2) {
                    SpringSpec snap;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(1373301606);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1373301606, $changed2, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:237)");
                    }
                    if (animateFloat.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        snap = animateFloat.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return snap;
                }
            };
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it = (ToggleableState) transition.getCurrentState();
            $composer2.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
                ComposerKt.traceEventStart(1800065638, $changed2, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:244)");
            } else {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
            }
            float f4 = 0.0f;
            switch (WhenMappings.$EnumSwitchMapping$0[it.ordinal()]) {
                case 1:
                    f = 1.0f;
                    break;
                case 2:
                    f = 0.0f;
                    break;
                case 3:
                    f = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            ToggleableState it2 = (ToggleableState) transition.getTargetState();
            $composer2.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, $changed3, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:244)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it2.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    break;
                case 2:
                    f2 = 0.0f;
                    break;
                case 3:
                    f2 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object targetValue$iv$iv = Float.valueOf(f2);
            FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            final State checkDrawFraction = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> animateFloat, Composer $composer3, int $changed4) {
                    TweenSpec snap;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(-1324481169);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1324481169, $changed4, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:253)");
                    }
                    if (animateFloat.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        snap = animateFloat.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return snap;
                }
            };
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, str);
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it3 = (ToggleableState) transition.getCurrentState();
            $composer2.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, $changed4, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it3.ordinal()]) {
                case 1:
                    f3 = 0.0f;
                    break;
                case 2:
                    f3 = 0.0f;
                    break;
                case 3:
                    f3 = 1.0f;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            ToggleableState it4 = (ToggleableState) transition.getTargetState();
            $composer2.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation($composer2, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426969489, $changed5, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:260)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[it4.ordinal()]) {
                case 3:
                    f4 = 1.0f;
                case 1:
                case 2:
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2.endReplaceableGroup();
                    Object targetValue$iv$iv2 = Float.valueOf(f4);
                    FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
                    final State checkCenterGravitationShiftFraction = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new CheckDrawingCache(null, null, null, 7, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    final CheckDrawingCache checkCache = (CheckDrawingCache) value$iv$iv;
                    final State checkColor = colors.checkmarkColor$material3_release(value, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & 112));
                    final State boxColor = colors.boxColor$material3_release(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
                    final State borderColor = colors.borderColor$material3_release(enabled, value, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 896));
                    Modifier m523requiredSize3ABfNKs = SizeKt.m523requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    Object[] keys$iv = {boxColor, borderColor, checkColor, checkDrawFraction, checkCenterGravitationShiftFraction, checkCache};
                    $composer2.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv = false;
                    for (Object key$iv : keys$iv) {
                        invalid$iv |= $composer2.changed(key$iv);
                    }
                    Object value$iv$iv2 = $composer2.rememberedValue();
                    if (invalid$iv || value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope Canvas) {
                                float f5;
                                float f6;
                                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                                f5 = CheckboxKt.StrokeWidth;
                                float strokeWidthPx = (float) Math.floor(Canvas.mo329toPx0680j_4(f5));
                                long m2959unboximpl = boxColor.getValue().m2959unboximpl();
                                long m2959unboximpl2 = borderColor.getValue().m2959unboximpl();
                                f6 = CheckboxKt.RadiusSize;
                                CheckboxKt.m1343drawBox1wkBAMs(Canvas, m2959unboximpl, m2959unboximpl2, Canvas.mo329toPx0680j_4(f6), strokeWidthPx);
                                CheckboxKt.m1344drawCheck3IgeMak(Canvas, checkColor.getValue().m2959unboximpl(), checkDrawFraction.getValue().floatValue(), checkCenterGravitationShiftFraction.getValue().floatValue(), strokeWidthPx, checkCache);
                            }
                        };
                        $composer2.updateRememberedValue(value$iv$iv2);
                    }
                    $composer2.endReplaceableGroup();
                    CanvasKt.Canvas(m523requiredSize3ABfNKs, (Function1) value$iv$iv2, $composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        break;
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$2
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
                CheckboxKt.CheckboxImpl(enabled, value, modifier, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m1343drawBox1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
        float halfStrokeWidth = strokeWidth / 2.0f;
        Stroke stroke = new Stroke(strokeWidth, 0.0f, 0, 0, null, 30, null);
        float checkboxSize = Size.m2779getWidthimpl($this$drawBox_u2d1wkBAMs.mo3492getSizeNHjbRc());
        if (Color.m2950equalsimpl0(boxColor, borderColor)) {
            DrawScope.m3489drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, 0L, androidx.compose.ui.geometry.SizeKt.Size(checkboxSize, checkboxSize), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f = 2;
        DrawScope.m3489drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, OffsetKt.Offset(strokeWidth, strokeWidth), androidx.compose.ui.geometry.SizeKt.Size(checkboxSize - (strokeWidth * f), checkboxSize - (f * strokeWidth)), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, radius - strokeWidth), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        DrawScope.m3489drawRoundRectuAw5IA$default($this$drawBox_u2d1wkBAMs, borderColor, OffsetKt.Offset(halfStrokeWidth, halfStrokeWidth), androidx.compose.ui.geometry.SizeKt.Size(checkboxSize - strokeWidth, checkboxSize - strokeWidth), CornerRadiusKt.CornerRadius$default(radius - halfStrokeWidth, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m1344drawCheck3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, CheckDrawingCache drawingCache) {
        Stroke stroke = new Stroke(strokeWidthPx, 0.0f, StrokeCap.INSTANCE.m3297getSquareKaPHkGw(), 0, null, 26, null);
        float width = Size.m2779getWidthimpl($this$drawCheck_u2d3IgeMak.mo3492getSizeNHjbRc());
        float gravitatedCrossX = MathHelpersKt.lerp(0.4f, 0.5f, crossCenterGravitation);
        float gravitatedCrossY = MathHelpersKt.lerp(0.7f, 0.5f, crossCenterGravitation);
        float gravitatedLeftY = MathHelpersKt.lerp(0.5f, 0.5f, crossCenterGravitation);
        float gravitatedRightY = MathHelpersKt.lerp(0.3f, 0.5f, crossCenterGravitation);
        drawingCache.getCheckPath().reset();
        float checkCrossX = width * gravitatedLeftY;
        drawingCache.getCheckPath().moveTo(width * 0.2f, checkCrossX);
        drawingCache.getCheckPath().lineTo(width * gravitatedCrossX, width * gravitatedCrossY);
        drawingCache.getCheckPath().lineTo(width * 0.8f, width * gravitatedRightY);
        drawingCache.getPathMeasure().setPath(drawingCache.getCheckPath(), false);
        drawingCache.getPathToDraw().reset();
        drawingCache.getPathMeasure().getSegment(0.0f, drawingCache.getPathMeasure().getLength() * checkFraction, drawingCache.getPathToDraw(), true);
        DrawScope.m3483drawPathLG529CI$default($this$drawCheck_u2d3IgeMak, drawingCache.getPathToDraw(), checkColor, 0.0f, stroke, null, 0, 52, null);
    }
}
