package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0014Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/SliderColors;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    /* renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m1702colorsq0g_0yA(long thumbColor, long activeTrackColor, long activeTickColor, long inactiveTrackColor, long inactiveTickColor, long disabledThumbColor, long disabledActiveTrackColor, long disabledActiveTickColor, long disabledInactiveTrackColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        long activeTrackColor2;
        long activeTickColor2;
        long inactiveTrackColor2;
        long inactiveTickColor2;
        long disabledThumbColor2;
        long disabledActiveTrackColor2;
        long disabledActiveTickColor2;
        long disabledInactiveTrackColor2;
        long disabledInactiveTickColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        long m2947copywmQWz5c4;
        long m2947copywmQWz5c5;
        long m2947copywmQWz5c6;
        $composer.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation($composer, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)897@37512L9,898@37587L9,900@37687L9,902@37838L9,903@37929L9,906@38096L9,908@38209L11,911@38340L9,914@38521L9,918@38719L9,921@38892L9:Slider.kt#uh7d8r");
        long thumbColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(SliderTokens.INSTANCE.getHandleColor(), $composer, 6) : thumbColor;
        if ((i & 2) == 0) {
            activeTrackColor2 = activeTrackColor;
        } else {
            activeTrackColor2 = ColorSchemeKt.toColor(SliderTokens.INSTANCE.getActiveTrackColor(), $composer, 6);
        }
        if ((i & 4) != 0) {
            m2947copywmQWz5c6 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksActiveContainerColor(), $composer, 6)) : 0.0f);
            activeTickColor2 = m2947copywmQWz5c6;
        } else {
            activeTickColor2 = activeTickColor;
        }
        if ((i & 8) == 0) {
            inactiveTrackColor2 = inactiveTrackColor;
        } else {
            inactiveTrackColor2 = ColorSchemeKt.toColor(SliderTokens.INSTANCE.getInactiveTrackColor(), $composer, 6);
        }
        if ((i & 16) != 0) {
            m2947copywmQWz5c5 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksInactiveContainerColor(), $composer, 6)) : 0.0f);
            inactiveTickColor2 = m2947copywmQWz5c5;
        } else {
            inactiveTickColor2 = inactiveTickColor;
        }
        if ((i & 32) != 0) {
            m2947copywmQWz5c4 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledHandleColor(), $composer, 6)) : 0.0f);
            disabledThumbColor2 = ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c4, MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU());
        } else {
            disabledThumbColor2 = disabledThumbColor;
        }
        if ((i & 64) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledActiveTrackColor(), $composer, 6)) : 0.0f);
            disabledActiveTrackColor2 = m2947copywmQWz5c3;
        } else {
            disabledActiveTrackColor2 = disabledActiveTrackColor;
        }
        if ((i & 128) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), $composer, 6)) : 0.0f);
            disabledActiveTickColor2 = m2947copywmQWz5c2;
        } else {
            disabledActiveTickColor2 = disabledActiveTickColor;
        }
        if ((i & 256) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r7, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r7) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r7) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r7) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getDisabledInactiveTrackColor(), $composer, 6)) : 0.0f);
            disabledInactiveTrackColor2 = m2947copywmQWz5c;
        } else {
            disabledInactiveTrackColor2 = disabledInactiveTrackColor;
        }
        if ((i & 512) != 0) {
            disabledInactiveTickColor2 = Color.m2947copywmQWz5c(r3, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r3) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r3) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r3) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SliderTokens.INSTANCE.getTickMarksDisabledContainerColor(), $composer, 6)) : 0.0f);
        } else {
            disabledInactiveTickColor2 = disabledInactiveTickColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, $changed, $changed1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:896)");
        }
        SliderColors sliderColors = new SliderColors(thumbColor2, activeTrackColor2, activeTickColor2, inactiveTrackColor2, inactiveTickColor2, disabledThumbColor2, disabledActiveTrackColor2, disabledActiveTickColor2, disabledInactiveTrackColor2, disabledInactiveTickColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sliderColors;
    }

    /* renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m1701Thumb9LiSoMs(final MutableInteractionSource interactionSource, Modifier modifier, SliderColors colors, boolean enabled, long thumbSize, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean enabled2;
        long j;
        SliderColors colors2;
        long thumbSize2;
        int $dirty;
        Modifier modifier3;
        SliderColors colors3;
        boolean enabled3;
        long j2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Modifier m2621shadows4CzXII;
        long thumbSize3;
        boolean enabled4;
        SliderColors colors4;
        Modifier modifier4;
        int i2;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer $composer2 = $composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation($composer2, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)953@40405L8,957@40521L46,958@40610L658,958@40576L692,976@41467L9,983@41669L143,990@42011L19,978@41486L568:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(interactionSource) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                if ($composer2.changed(sliderColors)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if (($changed & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer2.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            j = thumbSize;
        } else if ((57344 & $changed) == 0) {
            j = thumbSize;
            $dirty2 |= $composer2.changed(j) ? 16384 : 8192;
        } else {
            j = thumbSize;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty2 |= $composer2.changed(this) ? 131072 : 65536;
        }
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            enabled4 = enabled2;
            thumbSize3 = j;
            modifier4 = modifier2;
            colors4 = sliderColors;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, ($dirty2 >> 15) & 14, 1023);
                    $dirty2 &= -897;
                } else {
                    colors2 = sliderColors;
                }
                if (i4 != 0) {
                    enabled2 = true;
                }
                if (i5 != 0) {
                    j2 = SliderKt.ThumbSize;
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    colors3 = colors2;
                    thumbSize2 = j2;
                    enabled3 = enabled2;
                } else {
                    thumbSize2 = thumbSize;
                    $dirty = $dirty2;
                    modifier3 = modifier5;
                    colors3 = colors2;
                    enabled3 = enabled2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                thumbSize2 = j;
                colors3 = sliderColors;
                enabled3 = enabled2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290277409, $dirty, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:950)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt.mutableStateListOf();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SnapshotStateList interactions = (SnapshotStateList) value$iv$iv;
            int i6 = ($dirty & 14) | 48;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(interactionSource) | $composer2.changed(interactions);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = (Function2) new SliderDefaults$Thumb$1$1(interactionSource, interactions, null);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv2, $composer2, ($dirty & 14) | 64);
            float elevation = interactions.isEmpty() ^ true ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
            Shape shape = ShapesKt.toShape(SliderTokens.INSTANCE.getHandleShape(), $composer2, 6);
            float arg0$iv = SliderTokens.INSTANCE.m2440getStateLayerSizeD9Ej5fM();
            int $dirty3 = $dirty;
            m2621shadows4CzXII = ShadowKt.m2621shadows4CzXII(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m532size6HolHcs(modifier3, thumbSize2), interactionSource, RippleKt.m1286rememberRipple9IZ8Weo(false, Dp.m5218constructorimpl(arg0$iv / 2), 0L, $composer2, 54, 4)), interactionSource, false, 2, null), enabled3 ? elevation : Dp.m5218constructorimpl(0), (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (r15 & 4) != 0 ? Dp.m5217compareTo0680j_4(r8, Dp.m5218constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
            SpacerKt.Spacer(BackgroundKt.m162backgroundbw27NRU(m2621shadows4CzXII, colors3.thumbColor$material3_release(enabled3, $composer2, (($dirty3 >> 9) & 14) | (($dirty3 >> 3) & 112)).getValue().m2959unboximpl(), shape), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            thumbSize3 = thumbSize2;
            enabled4 = enabled3;
            colors4 = colors3;
            modifier4 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier4;
        final SliderColors sliderColors2 = colors4;
        final boolean z = enabled4;
        final long j3 = thumbSize3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
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

            public final void invoke(Composer composer, int i7) {
                SliderDefaults.this.m1701Thumb9LiSoMs(interactionSource, modifier6, sliderColors2, z, j3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors colors, boolean enabled, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        SliderColors sliderColors;
        boolean z;
        SliderColors colors2;
        int $dirty;
        SliderColors colors3;
        boolean enabled2;
        Modifier modifier3;
        Modifier modifier4;
        Modifier modifier5;
        int i2;
        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
        Composer $composer2 = $composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation($composer2, "C(Track)P(3,2)1010@42874L8,1013@42965L35,1014@43039L34,1015@43113L34,1016@43185L33,1020@43314L1884,1017@43227L1971:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(sliderPositions) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                sliderColors = colors;
                if ($composer2.changed(sliderColors)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                sliderColors = colors;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            sliderColors = colors;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changed(this) ? 16384 : 8192;
        }
        if ((46811 & $dirty2) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            colors3 = sliderColors;
            enabled2 = z;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier6 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = m1702colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, ($dirty2 >> 12) & 14, 1023);
                    $dirty2 &= -897;
                } else {
                    colors2 = sliderColors;
                }
                if (i4 != 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier6;
                    colors3 = colors2;
                    enabled2 = true;
                } else {
                    $dirty = $dirty2;
                    colors3 = colors2;
                    enabled2 = z;
                    modifier3 = modifier6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                colors3 = sliderColors;
                enabled2 = z;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1546713545, $dirty, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1007)");
            }
            final State inactiveTrackColor = colors3.trackColor$material3_release(enabled2, false, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            final State activeTrackColor = colors3.trackColor$material3_release(enabled2, true, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            final State inactiveTickColor = colors3.tickColor$material3_release(enabled2, false, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            final State activeTickColor = colors3.tickColor$material3_release(enabled2, true, $composer2, (($dirty >> 9) & 14) | 48 | ($dirty & 896));
            Modifier m517height3ABfNKs = SizeKt.m517height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), SliderKt.getTrackHeight());
            Object[] keys$iv = {inactiveTrackColor, sliderPositions, activeTrackColor, inactiveTickColor, activeTickColor};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
                modifier4 = modifier3;
                modifier5 = m517height3ABfNKs;
                value$iv$iv = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                        float f;
                        Object answer$iv$iv$iv;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        boolean isRtl = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
                        long sliderLeft = OffsetKt.Offset(0.0f, Offset.m2711getYimpl(Canvas.mo3491getCenterF1C5BW0()));
                        long sliderRight = OffsetKt.Offset(Size.m2779getWidthimpl(Canvas.mo3492getSizeNHjbRc()), Offset.m2711getYimpl(Canvas.mo3491getCenterF1C5BW0()));
                        long sliderStart = isRtl ? sliderRight : sliderLeft;
                        long sliderEnd = isRtl ? sliderLeft : sliderRight;
                        f = SliderKt.TickSize;
                        float tickSize = Canvas.mo329toPx0680j_4(f);
                        float trackStrokeWidth = Canvas.mo329toPx0680j_4(SliderKt.getTrackHeight());
                        long sliderEnd2 = sliderEnd;
                        long sliderStart2 = sliderStart;
                        DrawScope.m3479drawLineNGM6Ib0$default(Canvas, inactiveTrackColor.getValue().m2959unboximpl(), sliderStart, sliderEnd, trackStrokeWidth, StrokeCap.INSTANCE.m3296getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        long sliderValueEnd = OffsetKt.Offset(Offset.m2710getXimpl(sliderStart2) + ((Offset.m2710getXimpl(sliderEnd2) - Offset.m2710getXimpl(sliderStart2)) * sliderPositions.getActiveRange().getEndInclusive().floatValue()), Offset.m2711getYimpl(Canvas.mo3491getCenterF1C5BW0()));
                        long sliderValueStart = OffsetKt.Offset(Offset.m2710getXimpl(sliderStart2) + ((Offset.m2710getXimpl(sliderEnd2) - Offset.m2710getXimpl(sliderStart2)) * sliderPositions.getActiveRange().getStart().floatValue()), Offset.m2711getYimpl(Canvas.mo3491getCenterF1C5BW0()));
                        DrawScope.m3479drawLineNGM6Ib0$default(Canvas, activeTrackColor.getValue().m2959unboximpl(), sliderValueStart, sliderValueEnd, trackStrokeWidth, StrokeCap.INSTANCE.m3296getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        float[] $this$groupBy$iv = sliderPositions.getTickFractions();
                        SliderPositions sliderPositions2 = sliderPositions;
                        Map destination$iv$iv = new LinkedHashMap();
                        int length = $this$groupBy$iv.length;
                        for (int i5 = 0; i5 < length; i5++) {
                            float element$iv$iv = $this$groupBy$iv[i5];
                            Boolean valueOf = Boolean.valueOf(element$iv$iv > sliderPositions2.getActiveRange().getEndInclusive().floatValue() || element$iv$iv < sliderPositions2.getActiveRange().getStart().floatValue());
                            Object value$iv$iv$iv = destination$iv$iv.get(valueOf);
                            if (value$iv$iv$iv == null) {
                                answer$iv$iv$iv = new ArrayList();
                                destination$iv$iv.put(valueOf, answer$iv$iv$iv);
                            } else {
                                answer$iv$iv$iv = value$iv$iv$iv;
                            }
                            List list$iv$iv = (List) answer$iv$iv$iv;
                            list$iv$iv.add(Float.valueOf(element$iv$iv));
                        }
                        State<Color> state = inactiveTickColor;
                        State<Color> state2 = activeTickColor;
                        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
                            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
                            Iterable list = (List) element$iv.getValue();
                            Iterable $this$map$iv = list;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                float it = ((Number) item$iv$iv).floatValue();
                                long sliderStart3 = sliderStart2;
                                long sliderEnd3 = sliderEnd2;
                                destination$iv$iv2.add(Offset.m2699boximpl(OffsetKt.Offset(Offset.m2710getXimpl(OffsetKt.m2733lerpWko1d7g(sliderStart3, sliderEnd3, it)), Offset.m2711getYimpl(Canvas.mo3491getCenterF1C5BW0()))));
                                sliderStart2 = sliderStart3;
                                $this$map$iv = $this$map$iv;
                                sliderEnd2 = sliderEnd3;
                            }
                            long sliderStart4 = sliderStart2;
                            long sliderEnd4 = sliderEnd2;
                            DrawScope.m3484drawPointsF8ZwMP8$default(Canvas, (List) destination$iv$iv2, PointMode.INSTANCE.m3248getPointsr_lszbg(), (outsideFraction ? state : state2).getValue().m2959unboximpl(), tickSize, StrokeCap.INSTANCE.m3296getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            sliderStart2 = sliderStart4;
                            sliderEnd2 = sliderEnd4;
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                modifier4 = modifier3;
                modifier5 = m517height3ABfNKs;
            }
            $composer2.endReplaceableGroup();
            CanvasKt.Canvas(modifier5, (Function1) value$iv$iv, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final SliderColors sliderColors2 = colors3;
        final boolean z2 = enabled2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$2
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

            public final void invoke(Composer composer, int i5) {
                SliderDefaults.this.Track(sliderPositions, modifier7, sliderColors2, z2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
