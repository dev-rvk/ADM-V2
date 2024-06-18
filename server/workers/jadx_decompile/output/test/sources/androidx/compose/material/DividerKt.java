package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Divider.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* renamed from: Divider-oMI9zvI, reason: not valid java name */
    public static final void m1071DivideroMI9zvI(Modifier modifier, long color, float thickness, float startIndent, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        float f;
        float f2;
        Modifier.Companion modifier3;
        long color2;
        float thickness2;
        float startIndent2;
        float targetThickness;
        Modifier modifier4;
        long color3;
        float thickness3;
        float startIndent3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 32;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 16;
            $dirty |= i2;
        } else {
            j = color;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            f = thickness;
        } else if (($changed & 896) == 0) {
            f = thickness;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = thickness;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            f2 = startIndent;
        } else if (($changed & 7168) == 0) {
            f2 = startIndent;
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = startIndent;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            thickness3 = f;
            startIndent3 = f2;
            color3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    color2 = Color.m2947copywmQWz5c(r12, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r12) : 0.12f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r12) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r12) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(MaterialTheme.INSTANCE.getColors($composer2, 6).m1035getOnSurface0d7_KjU()) : 0.0f);
                    $dirty &= -113;
                } else {
                    color2 = j;
                }
                thickness2 = i4 != 0 ? Dp.m5218constructorimpl(1) : f;
                startIndent2 = i5 != 0 ? Dp.m5218constructorimpl(0) : f2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier3 = modifier2;
                color2 = j;
                thickness2 = f;
                startIndent2 = f2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, $changed, -1, "androidx.compose.material.Divider (Divider.kt:43)");
            }
            Modifier.Companion indentMod = !((startIndent2 > 0.0f ? 1 : (startIndent2 == 0.0f ? 0 : -1)) == 0) ? PaddingKt.m488paddingqDBjuR0$default(Modifier.INSTANCE, startIndent2, 0.0f, 0.0f, 0.0f, 14, null) : Modifier.INSTANCE;
            $composer2.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation($composer2, "*55@2139L7");
            if (Dp.m5223equalsimpl0(thickness2, Dp.INSTANCE.m5236getHairlineD9Ej5fM())) {
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                float $this$dp$iv = 1.0f / ((Density) consume).getDensity();
                targetThickness = Dp.m5218constructorimpl($this$dp$iv);
            } else {
                targetThickness = thickness2;
            }
            $composer2.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m163backgroundbw27NRU$default(SizeKt.m517height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3.then(indentMod), 0.0f, 1, null), targetThickness), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            color3 = color2;
            thickness3 = thickness2;
            startIndent3 = startIndent2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j2 = color3;
        final float f3 = thickness3;
        final float f4 = startIndent3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
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
                DividerKt.m1071DivideroMI9zvI(Modifier.this, j2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
