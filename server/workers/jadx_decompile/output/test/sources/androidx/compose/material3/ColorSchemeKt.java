package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorScheme.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aµ\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001aµ\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a)\u0010.\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\b*\u00020\u00042\u0006\u00106\u001a\u000207H\u0000ø\u0001\u0001¢\u0006\u0002\u00108\u001a\u001f\u00109\u001a\u00020\b*\u00020\u00042\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\b*\u000207H\u0001ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006A"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "contentColorFor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme", "lightColorScheme-G1PFc-w", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-Hht5A8o", "(Landroidx/compose/material3/ColorScheme;JF)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "toColor", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "updateColorSchemeFrom", "", "other", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<ColorScheme>() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ColorScheme invoke() {
            return ColorSchemeKt.m1418lightColorSchemeG1PFcw$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 536870911, null);
        }
    });

    /* compiled from: ColorScheme.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1418lightColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m2086getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2086getPrimary0d7_KjU() : j;
        return m1417lightColorSchemeG1PFcw(m2086getPrimary0d7_KjU, (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2076getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2087getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2077getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2071getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2089getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2078getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2090getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2079getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2094getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2082getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2095getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2083getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2067getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2073getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2091getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2080getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2093getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2081getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? m2086getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2072getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2070getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2068getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2074getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2069getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2075getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m2084getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m2085getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2088getScrim0d7_KjU() : j29);
    }

    /* renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1417lightColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1416darkColorSchemeG1PFcw$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, int i, Object obj) {
        long m2057getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2057getPrimary0d7_KjU() : j;
        return m1415darkColorSchemeG1PFcw(m2057getPrimary0d7_KjU, (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2047getOnPrimary0d7_KjU() : j2, (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2058getPrimaryContainer0d7_KjU() : j3, (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2048getOnPrimaryContainer0d7_KjU() : j4, (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2042getInversePrimary0d7_KjU() : j5, (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2060getSecondary0d7_KjU() : j6, (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2049getOnSecondary0d7_KjU() : j7, (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2061getSecondaryContainer0d7_KjU() : j8, (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2050getOnSecondaryContainer0d7_KjU() : j9, (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2065getTertiary0d7_KjU() : j10, (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2053getOnTertiary0d7_KjU() : j11, (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2066getTertiaryContainer0d7_KjU() : j12, (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2054getOnTertiaryContainer0d7_KjU() : j13, (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2038getBackground0d7_KjU() : j14, (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2044getOnBackground0d7_KjU() : j15, (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2062getSurface0d7_KjU() : j16, (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2051getOnSurface0d7_KjU() : j17, (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2064getSurfaceVariant0d7_KjU() : j18, (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2052getOnSurfaceVariant0d7_KjU() : j19, (i & 524288) != 0 ? m2057getPrimary0d7_KjU : j20, (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2043getInverseSurface0d7_KjU() : j21, (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2041getInverseOnSurface0d7_KjU() : j22, (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2039getError0d7_KjU() : j23, (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2045getOnError0d7_KjU() : j24, (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2040getErrorContainer0d7_KjU() : j25, (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2046getOnErrorContainer0d7_KjU() : j26, (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m2055getOutline0d7_KjU() : j27, (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m2056getOutlineVariant0d7_KjU() : j28, (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2059getScrim0d7_KjU() : j29);
    }

    /* renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final ColorScheme m1415darkColorSchemeG1PFcw(long primary, long onPrimary, long primaryContainer, long onPrimaryContainer, long inversePrimary, long secondary, long onSecondary, long secondaryContainer, long onSecondaryContainer, long tertiary, long onTertiary, long tertiaryContainer, long onTertiaryContainer, long background, long onBackground, long surface, long onSurface, long surfaceVariant, long onSurfaceVariant, long surfaceTint, long inverseSurface, long inverseOnSurface, long error, long onError, long errorContainer, long onErrorContainer, long outline, long outlineVariant, long scrim) {
        return new ColorScheme(primary, onPrimary, primaryContainer, onPrimaryContainer, inversePrimary, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, surfaceTint, inverseSurface, inverseOnSurface, error, onError, errorContainer, onErrorContainer, outline, outlineVariant, scrim, null);
    }

    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1413contentColorFor4WTKRHQ(ColorScheme contentColorFor, long backgroundColor) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        return Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1373getPrimary0d7_KjU()) ? contentColorFor.m1363getOnPrimary0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1376getSecondary0d7_KjU()) ? contentColorFor.m1365getOnSecondary0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1381getTertiary0d7_KjU()) ? contentColorFor.m1369getOnTertiary0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1354getBackground0d7_KjU()) ? contentColorFor.m1360getOnBackground0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1355getError0d7_KjU()) ? contentColorFor.m1361getOnError0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1378getSurface0d7_KjU()) ? contentColorFor.m1367getOnSurface0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1380getSurfaceVariant0d7_KjU()) ? contentColorFor.m1368getOnSurfaceVariant0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1374getPrimaryContainer0d7_KjU()) ? contentColorFor.m1364getOnPrimaryContainer0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1377getSecondaryContainer0d7_KjU()) ? contentColorFor.m1366getOnSecondaryContainer0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1382getTertiaryContainer0d7_KjU()) ? contentColorFor.m1370getOnTertiaryContainer0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1356getErrorContainer0d7_KjU()) ? contentColorFor.m1362getOnErrorContainer0d7_KjU() : Color.m2950equalsimpl0(backgroundColor, contentColorFor.m1359getInverseSurface0d7_KjU()) ? contentColorFor.m1357getInverseOnSurface0d7_KjU() : Color.INSTANCE.m2985getUnspecified0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1414contentColorForek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 509589638, "C(contentColorFor)P(0:c#ui.graphics.Color)*474@21497L11,475@21581L7:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, $changed, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:473)");
        }
        long $this$takeOrElse_u2dDxMtmZc$iv = m1413contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme($composer, 6), backgroundColor);
        if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU())) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $this$takeOrElse_u2dDxMtmZc$iv = ((Color) consume).m2959unboximpl();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    /* renamed from: applyTonalElevation-Hht5A8o, reason: not valid java name */
    public static final long m1412applyTonalElevationHht5A8o(ColorScheme applyTonalElevation, long backgroundColor, float elevation) {
        Intrinsics.checkNotNullParameter(applyTonalElevation, "$this$applyTonalElevation");
        if (Color.m2950equalsimpl0(backgroundColor, applyTonalElevation.m1378getSurface0d7_KjU())) {
            return m1419surfaceColorAtElevation3ABfNKs(applyTonalElevation, elevation);
        }
        return backgroundColor;
    }

    /* renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m1419surfaceColorAtElevation3ABfNKs(ColorScheme surfaceColorAtElevation, float elevation) {
        long m2947copywmQWz5c;
        Intrinsics.checkNotNullParameter(surfaceColorAtElevation, "$this$surfaceColorAtElevation");
        if (Dp.m5223equalsimpl0(elevation, Dp.m5218constructorimpl(0))) {
            return surfaceColorAtElevation.m1378getSurface0d7_KjU();
        }
        float alpha = ((((float) Math.log(1 + elevation)) * 4.5f) + 2.0f) / 100.0f;
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r2) : alpha, (r12 & 2) != 0 ? Color.m2955getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(surfaceColorAtElevation.m1379getSurfaceTint0d7_KjU()) : 0.0f);
        return ColorKt.m2994compositeOverOWjLjI(m2947copywmQWz5c, surfaceColorAtElevation.m1378getSurface0d7_KjU());
    }

    public static final void updateColorSchemeFrom(ColorScheme $this$updateColorSchemeFrom, ColorScheme other) {
        Intrinsics.checkNotNullParameter($this$updateColorSchemeFrom, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        $this$updateColorSchemeFrom.m1402setPrimary8_81llA$material3_release(other.m1373getPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1392setOnPrimary8_81llA$material3_release(other.m1363getOnPrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1403setPrimaryContainer8_81llA$material3_release(other.m1374getPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1393setOnPrimaryContainer8_81llA$material3_release(other.m1364getOnPrimaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1387setInversePrimary8_81llA$material3_release(other.m1358getInversePrimary0d7_KjU());
        $this$updateColorSchemeFrom.m1405setSecondary8_81llA$material3_release(other.m1376getSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m1394setOnSecondary8_81llA$material3_release(other.m1365getOnSecondary0d7_KjU());
        $this$updateColorSchemeFrom.m1406setSecondaryContainer8_81llA$material3_release(other.m1377getSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1395setOnSecondaryContainer8_81llA$material3_release(other.m1366getOnSecondaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1410setTertiary8_81llA$material3_release(other.m1381getTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m1398setOnTertiary8_81llA$material3_release(other.m1369getOnTertiary0d7_KjU());
        $this$updateColorSchemeFrom.m1411setTertiaryContainer8_81llA$material3_release(other.m1382getTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1399setOnTertiaryContainer8_81llA$material3_release(other.m1370getOnTertiaryContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1383setBackground8_81llA$material3_release(other.m1354getBackground0d7_KjU());
        $this$updateColorSchemeFrom.m1389setOnBackground8_81llA$material3_release(other.m1360getOnBackground0d7_KjU());
        $this$updateColorSchemeFrom.m1407setSurface8_81llA$material3_release(other.m1378getSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1396setOnSurface8_81llA$material3_release(other.m1367getOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1409setSurfaceVariant8_81llA$material3_release(other.m1380getSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1397setOnSurfaceVariant8_81llA$material3_release(other.m1368getOnSurfaceVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1408setSurfaceTint8_81llA$material3_release(other.m1379getSurfaceTint0d7_KjU());
        $this$updateColorSchemeFrom.m1388setInverseSurface8_81llA$material3_release(other.m1359getInverseSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1386setInverseOnSurface8_81llA$material3_release(other.m1357getInverseOnSurface0d7_KjU());
        $this$updateColorSchemeFrom.m1384setError8_81llA$material3_release(other.m1355getError0d7_KjU());
        $this$updateColorSchemeFrom.m1390setOnError8_81llA$material3_release(other.m1361getOnError0d7_KjU());
        $this$updateColorSchemeFrom.m1385setErrorContainer8_81llA$material3_release(other.m1356getErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1391setOnErrorContainer8_81llA$material3_release(other.m1362getOnErrorContainer0d7_KjU());
        $this$updateColorSchemeFrom.m1400setOutline8_81llA$material3_release(other.m1371getOutline0d7_KjU());
        $this$updateColorSchemeFrom.m1401setOutlineVariant8_81llA$material3_release(other.m1372getOutlineVariant0d7_KjU());
        $this$updateColorSchemeFrom.m1404setScrim8_81llA$material3_release(other.m1375getScrim0d7_KjU());
    }

    public static final long fromToken(ColorScheme $this$fromToken, ColorSchemeKeyTokens value) {
        Intrinsics.checkNotNullParameter($this$fromToken, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return $this$fromToken.m1354getBackground0d7_KjU();
            case 2:
                return $this$fromToken.m1355getError0d7_KjU();
            case 3:
                return $this$fromToken.m1356getErrorContainer0d7_KjU();
            case 4:
                return $this$fromToken.m1357getInverseOnSurface0d7_KjU();
            case 5:
                return $this$fromToken.m1358getInversePrimary0d7_KjU();
            case 6:
                return $this$fromToken.m1359getInverseSurface0d7_KjU();
            case 7:
                return $this$fromToken.m1360getOnBackground0d7_KjU();
            case 8:
                return $this$fromToken.m1361getOnError0d7_KjU();
            case 9:
                return $this$fromToken.m1362getOnErrorContainer0d7_KjU();
            case 10:
                return $this$fromToken.m1363getOnPrimary0d7_KjU();
            case 11:
                return $this$fromToken.m1364getOnPrimaryContainer0d7_KjU();
            case 12:
                return $this$fromToken.m1365getOnSecondary0d7_KjU();
            case 13:
                return $this$fromToken.m1366getOnSecondaryContainer0d7_KjU();
            case 14:
                return $this$fromToken.m1367getOnSurface0d7_KjU();
            case 15:
                return $this$fromToken.m1368getOnSurfaceVariant0d7_KjU();
            case 16:
                return $this$fromToken.m1379getSurfaceTint0d7_KjU();
            case 17:
                return $this$fromToken.m1369getOnTertiary0d7_KjU();
            case 18:
                return $this$fromToken.m1370getOnTertiaryContainer0d7_KjU();
            case 19:
                return $this$fromToken.m1371getOutline0d7_KjU();
            case 20:
                return $this$fromToken.m1372getOutlineVariant0d7_KjU();
            case 21:
                return $this$fromToken.m1373getPrimary0d7_KjU();
            case 22:
                return $this$fromToken.m1374getPrimaryContainer0d7_KjU();
            case 23:
                return $this$fromToken.m1375getScrim0d7_KjU();
            case 24:
                return $this$fromToken.m1376getSecondary0d7_KjU();
            case 25:
                return $this$fromToken.m1377getSecondaryContainer0d7_KjU();
            case 26:
                return $this$fromToken.m1378getSurface0d7_KjU();
            case 27:
                return $this$fromToken.m1380getSurfaceVariant0d7_KjU();
            case 28:
                return $this$fromToken.m1381getTertiary0d7_KjU();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                return $this$fromToken.m1382getTertiaryContainer0d7_KjU();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long toColor(ColorSchemeKeyTokens $this$toColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$toColor, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1330949347, "C(toColor)612@27498L11:ColorScheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330949347, $changed, -1, "androidx.compose.material3.toColor (ColorScheme.kt:611)");
        }
        long fromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $this$toColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return fromToken;
    }
}
