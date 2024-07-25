package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Divider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DividerKt {
    /* renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public static final void m1496Divider9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        long j;
        Modifier.Companion modifier3;
        float thickness2;
        long color2;
        float targetThickness;
        Modifier modifier4;
        float thickness3;
        long color3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(1562471785);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)46@1862L5,53@2019L131:Divider.kt#uh7d8r");
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
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            f = thickness;
        } else if (($changed & 112) == 0) {
            f = thickness;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = thickness;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j = color;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            color3 = j;
            modifier4 = modifier2;
            thickness3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                thickness2 = i4 != 0 ? DividerDefaults.INSTANCE.m1495getThicknessD9Ej5fM() : f;
                if ((i & 4) != 0) {
                    color2 = DividerDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color2 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                thickness2 = f;
                color2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562471785, $changed, -1, "androidx.compose.material3.Divider (Divider.kt:43)");
            }
            $composer2.startReplaceableGroup(1232935509);
            ComposerKt.sourceInformation($composer2, "*49@1958L7");
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
            BoxKt.Box(BackgroundKt.m163backgroundbw27NRU$default(SizeKt.m517height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), targetThickness), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            thickness3 = thickness2;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final float f2 = thickness3;
        final long j2 = color3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DividerKt$Divider$1
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
                DividerKt.m1496Divider9IZ8Weo(Modifier.this, f2, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
