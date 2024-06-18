package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Surface.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0186  */
    /* renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1198SurfaceFjzlyU(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, androidx.compose.foundation.BorderStroke r31, float r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1198SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01cd  */
    /* renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1199SurfaceLPr_se0(final kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.foundation.BorderStroke r36, float r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1199SurfaceLPr_se0(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1200SurfaceNy5ogXk(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        int i2;
        int $dirty;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        BorderStroke border3;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        int $dirty2;
        long contentColor3;
        boolean enabled2;
        long color3;
        Shape shape2;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)330@16547L6,331@16589L22,334@16723L39,*337@16855L7,338@16879L1024:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(selected) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(shape) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                i2 = i6;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i6;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i6;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(border) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color3 = color;
            contentColor3 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource2 = interactionSource;
            $composer2 = $composer3;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i2 != 0 ? true : z;
                Shape shape3 = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1040getSurface0d7_KjU();
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(color2, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i8 != 0 ? null : border;
                if (i9 != 0) {
                    border2 = border4;
                    elevation2 = Dp.m5218constructorimpl(0);
                } else {
                    border2 = border4;
                    elevation2 = elevation;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    float elevation4 = elevation2;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    elevation3 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                } else {
                    border3 = border2;
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:324)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((Dp) consume).m5232unboximpl();
            final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + elevation3);
            final Modifier modifier4 = modifier2;
            final int $dirty12 = $dirty1;
            final Shape shape4 = shape2;
            final long j = color3;
            final int i11 = $dirty2;
            final BorderStroke borderStroke = border3;
            final float f = elevation3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -1391199439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
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

                /* JADX WARN: Removed duplicated region for block: B:24:0x01c9  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 461
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$7.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final boolean z3 = enabled2;
        final Shape shape5 = shape2;
        final long j2 = color3;
        final long j3 = contentColor3;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
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

            public final void invoke(Composer composer, int i12) {
                SurfaceKt.m1200SurfaceNy5ogXk(selected, onClick, modifier5, z3, shape5, j2, j3, borderStroke2, f2, mutableInteractionSource2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m1201SurfaceNy5ogXk(final boolean checked, final Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        boolean z;
        int i2;
        int $dirty;
        long color2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        BorderStroke border3;
        float elevation3;
        MutableInteractionSource interactionSource2;
        Modifier modifier2;
        int $dirty2;
        long contentColor3;
        boolean enabled2;
        long color3;
        Shape shape2;
        Object value$iv$iv;
        Composer $composer2;
        int $dirty3;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)445@22417L6,446@22459L22,449@22593L39,*452@22725L7,453@22749L1034:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty4 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty4 |= $composer3.changed(checked) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty4 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(onCheckedChange) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty4 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if (($changed & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty4 |= $composer3.changed(shape) ? 16384 : 8192;
        }
        if (($changed & 458752) == 0) {
            if ((i & 32) == 0) {
                i2 = i6;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i6;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i6;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(border) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? 536870912 : 268435456;
        }
        if ((i & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color3 = color;
            contentColor3 = contentColor;
            border3 = border;
            elevation3 = elevation;
            interactionSource2 = interactionSource;
            $composer2 = $composer3;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier;
                boolean enabled3 = i2 != 0 ? true : z;
                Shape shape3 = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1040getSurface0d7_KjU();
                } else {
                    color2 = color;
                }
                if ((i & 64) != 0) {
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(color2, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i8 != 0 ? null : border;
                if (i9 != 0) {
                    border2 = border4;
                    elevation2 = Dp.m5218constructorimpl(0);
                } else {
                    border2 = border4;
                    elevation2 = elevation;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    float elevation4 = elevation2;
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    border3 = border2;
                    elevation3 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                } else {
                    border3 = border2;
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor3 = contentColor2;
                    enabled2 = enabled3;
                    color3 = color2;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & (-3670017);
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color3 = color;
                    contentColor3 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:439)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((Dp) consume).m5232unboximpl();
            final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + elevation3);
            final Modifier modifier4 = modifier2;
            final int $dirty12 = $dirty1;
            final Shape shape4 = shape2;
            final long j = color3;
            final int i11 = $dirty2;
            final BorderStroke borderStroke = border3;
            final float f = elevation3;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            final boolean z2 = enabled2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor3)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, -311657392, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
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

                /* JADX WARN: Removed duplicated region for block: B:24:0x01c9  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                    /*
                        Method dump skipped, instructions count: 461
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$10.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier2;
        final boolean z3 = enabled2;
        final Shape shape5 = shape2;
        final long j2 = color3;
        final long j3 = contentColor3;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation3;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$11
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

            public final void invoke(Composer composer, int i12) {
                SurfaceKt.m1201SurfaceNy5ogXk(checked, onCheckedChange, modifier5, z3, shape5, j2, j3, borderStroke2, f2, mutableInteractionSource2, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Surface-9VG74zQ, reason: not valid java name */
    public static final void m1197Surface9VG74zQ(final Function0<Unit> onClick, Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        Modifier modifier2;
        long color2;
        long contentColor2;
        long color3;
        float elevation2;
        float elevation3;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource interactionSource3;
        Indication indication2;
        MutableInteractionSource interactionSource4;
        float elevation4;
        Role role2;
        Indication indication3;
        boolean enabled2;
        String onClickLabel2;
        BorderStroke border2;
        long color4;
        Modifier modifier3;
        Shape shape2;
        int $dirty2;
        Object value$iv$iv;
        Composer $composer2;
        Role role3;
        String onClickLabel3;
        boolean enabled3;
        Indication indication4;
        MutableInteractionSource interactionSource5;
        float elevation5;
        BorderStroke border3;
        long color5;
        Modifier modifier4;
        Shape shape3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1585925488);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)573@28985L6,574@29027L22,577@29161L39,578@29248L7,*584@29435L7,585@29459L1128:Surface.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(onClick) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(shape) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0 && $composer3.changed(color)) {
                i4 = 2048;
                $dirty3 |= i4;
            }
            i4 = 1024;
            $dirty3 |= i4;
        }
        if (($changed & 57344) == 0) {
            if ((i & 16) == 0 && $composer3.changed(contentColor)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(border) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer3.changed(elevation) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty3 |= $composer3.changed(interactionSource) ? 8388608 : 4194304;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0 && $composer3.changed(indication)) {
                i2 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                $dirty3 |= i2;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(onClickLabel) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(role) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changedInstance(content) ? 256 : 128;
        }
        final int $dirty12 = $dirty1;
        if ((1533916891 & $dirty3) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier4 = modifier;
            shape3 = shape;
            color5 = color;
            contentColor2 = contentColor;
            border3 = border;
            elevation5 = elevation;
            interactionSource5 = interactionSource;
            indication4 = indication;
            enabled3 = enabled;
            onClickLabel3 = onClickLabel;
            role3 = role;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i5 != 0 ? Modifier.INSTANCE : modifier;
                Shape shape4 = i6 != 0 ? RectangleShapeKt.getRectangleShape() : shape;
                if ((i & 8) != 0) {
                    $dirty = $dirty3 & (-7169);
                    modifier2 = modifier5;
                    color2 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1040getSurface0d7_KjU();
                } else {
                    $dirty = $dirty3;
                    modifier2 = modifier5;
                    color2 = color;
                }
                if ((i & 16) != 0) {
                    contentColor2 = ColorsKt.m1054contentColorForek8zF_U(color2, $composer3, ($dirty >> 9) & 14);
                    $dirty &= -57345;
                } else {
                    contentColor2 = contentColor;
                }
                BorderStroke border4 = i7 != 0 ? null : border;
                if (i8 != 0) {
                    color3 = color2;
                    elevation2 = Dp.m5218constructorimpl(0);
                } else {
                    color3 = color2;
                    elevation2 = elevation;
                }
                if (i9 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    elevation3 = elevation2;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                } else {
                    elevation3 = elevation2;
                    interactionSource2 = interactionSource;
                }
                if ((i & 256) != 0) {
                    ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                    interactionSource3 = interactionSource2;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(localIndication);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    indication2 = (Indication) consume;
                    $dirty &= -234881025;
                } else {
                    interactionSource3 = interactionSource2;
                    indication2 = indication;
                }
                boolean enabled4 = i10 != 0 ? true : enabled;
                String onClickLabel4 = i11 != 0 ? null : onClickLabel;
                if (i12 != 0) {
                    interactionSource4 = interactionSource3;
                    elevation4 = elevation3;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    role2 = null;
                    border2 = border4;
                    color4 = color3;
                    modifier3 = modifier2;
                    shape2 = shape4;
                    $dirty2 = $dirty;
                } else {
                    interactionSource4 = interactionSource3;
                    elevation4 = elevation3;
                    role2 = role;
                    indication3 = indication2;
                    enabled2 = enabled4;
                    onClickLabel2 = onClickLabel4;
                    border2 = border4;
                    color4 = color3;
                    modifier3 = modifier2;
                    shape2 = shape4;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 256) != 0) {
                    modifier3 = modifier;
                    shape2 = shape;
                    color4 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation4 = elevation;
                    interactionSource4 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    $dirty2 = $dirty3 & (-234881025);
                } else {
                    modifier3 = modifier;
                    shape2 = shape;
                    color4 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation4 = elevation;
                    interactionSource4 = interactionSource;
                    indication3 = indication;
                    enabled2 = enabled;
                    onClickLabel2 = onClickLabel;
                    role2 = role;
                    $dirty2 = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585925488, $dirty2, $dirty12, "androidx.compose.material.Surface (Surface.kt:569)");
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float arg0$iv = ((Dp) consume2).m5232unboximpl();
            final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + elevation4);
            final Modifier modifier6 = modifier3;
            final Shape shape5 = shape2;
            final long j = color4;
            final int i13 = $dirty2;
            final BorderStroke borderStroke = border2;
            final float f = elevation4;
            final MutableInteractionSource mutableInteractionSource = interactionSource4;
            final Indication indication5 = indication3;
            final boolean z = enabled2;
            final String str = onClickLabel2;
            final Role role4 = role2;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer2, 149594672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                /* JADX WARN: Removed duplicated region for block: B:24:0x01bc  */
                /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.runtime.Composer r28, int r29) {
                    /*
                        Method dump skipped, instructions count: 448
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt$Surface$13.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            role3 = role2;
            onClickLabel3 = onClickLabel2;
            enabled3 = enabled2;
            indication4 = indication3;
            interactionSource5 = interactionSource4;
            elevation5 = elevation4;
            border3 = border2;
            color5 = color4;
            modifier4 = modifier3;
            shape3 = shape2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        final Shape shape6 = shape3;
        final long j2 = color5;
        final long j3 = contentColor2;
        final BorderStroke borderStroke2 = border3;
        final float f2 = elevation5;
        final MutableInteractionSource mutableInteractionSource2 = interactionSource5;
        final Indication indication6 = indication4;
        final boolean z2 = enabled3;
        final String str2 = onClickLabel3;
        final Role role5 = role3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$14
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

            public final void invoke(Composer composer, int i14) {
                SurfaceKt.m1197Surface9VG74zQ(onClick, modifier7, shape6, j2, j3, borderStroke2, f2, mutableInteractionSource2, indication6, z2, str2, role5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1204surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier m2621shadows4CzXII;
        m2621shadows4CzXII = ShadowKt.m2621shadows4CzXII($this$surface_u2d8ww4TTg, elevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (r15 & 4) != 0 ? Dp.m5217compareTo0680j_4(r8, Dp.m5218constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
        Modifier.Companion companion = Modifier.INSTANCE;
        if (border != null) {
            companion = BorderKt.border(companion, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m162backgroundbw27NRU(m2621shadows4CzXII.then(companion), backgroundColor, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1205surfaceColorAtElevationcq6XJ1M(long color, ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)635@31093L6,636@31164L31:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, $changed, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:630)");
        }
        if (Color.m2950equalsimpl0(color, MaterialTheme.INSTANCE.getColors($composer, 6).m1040getSurface0d7_KjU()) && elevationOverlay != null) {
            j = elevationOverlay.mo1070apply7g2Lkgo(color, absoluteElevation, $composer, ($changed & 14) | (($changed >> 3) & 112) | (($changed << 3) & 896));
        } else {
            j = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return j;
    }
}
