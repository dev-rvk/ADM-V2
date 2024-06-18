package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaterialTheme.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MaterialThemeKt {
    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Colors colors2;
        final Typography typography2;
        Shapes shapes2;
        int $dirty;
        Shapes shapes3;
        Object value$iv$iv;
        Shapes shapes4;
        Colors colors3;
        Typography typography3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-891417079);
        ComposerKt.sourceInformation($composer2, "C(MaterialTheme)P(!1,3,2)59@2947L6,60@2998L10,61@3045L6,*64@3120L184,69@3367L16,70@3410L45,73@3581L4,71@3460L492:MaterialTheme.kt#jmzs0o");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            if ((i & 1) == 0) {
                colors2 = colors;
                if ($composer2.changed(colors2)) {
                    i4 = 4;
                    $dirty2 |= i4;
                }
            } else {
                colors2 = colors;
            }
            i4 = 2;
            $dirty2 |= i4;
        } else {
            colors2 = colors;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                typography2 = typography;
                if ($composer2.changed(typography2)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                typography2 = typography;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            typography2 = typography;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                shapes2 = shapes;
                if ($composer2.changed(shapes2)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                shapes2 = shapes;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            shapes2 = shapes;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            typography3 = typography2;
            shapes4 = shapes2;
            colors3 = colors2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors($composer2, 6);
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    shapes3 = MaterialTheme.INSTANCE.getShapes($composer2, 6);
                } else {
                    $dirty = $dirty2;
                    shapes3 = shapes2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    shapes3 = shapes2;
                } else {
                    $dirty = $dirty2;
                    shapes3 = shapes2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891417079, $dirty, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = r16.m1028copypvPzIIM((r43 & 1) != 0 ? r16.m1036getPrimary0d7_KjU() : 0L, (r43 & 2) != 0 ? r16.m1037getPrimaryVariant0d7_KjU() : 0L, (r43 & 4) != 0 ? r16.m1038getSecondary0d7_KjU() : 0L, (r43 & 8) != 0 ? r16.m1039getSecondaryVariant0d7_KjU() : 0L, (r43 & 16) != 0 ? r16.m1029getBackground0d7_KjU() : 0L, (r43 & 32) != 0 ? r16.m1040getSurface0d7_KjU() : 0L, (r43 & 64) != 0 ? r16.m1030getError0d7_KjU() : 0L, (r43 & 128) != 0 ? r16.m1033getOnPrimary0d7_KjU() : 0L, (r43 & 256) != 0 ? r16.m1034getOnSecondary0d7_KjU() : 0L, (r43 & 512) != 0 ? r16.m1031getOnBackground0d7_KjU() : 0L, (r43 & 1024) != 0 ? r16.m1035getOnSurface0d7_KjU() : 0L, (r43 & 2048) != 0 ? r16.m1032getOnError0d7_KjU() : 0L, (r43 & 4096) != 0 ? colors2.isLight() : false);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Colors $this$MaterialTheme_u24lambda_u241 = (Colors) value$iv$iv;
            ColorsKt.updateColorsFrom($this$MaterialTheme_u24lambda_u241, colors2);
            Colors rememberedColors = (Colors) value$iv$iv;
            final int $dirty3 = $dirty;
            Indication rippleIndication = RippleKt.m1286rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7);
            SelectionColors selectionColors = MaterialTextSelectionColorsKt.rememberTextSelectionColors(rememberedColors, $composer2, 0);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(rememberedColors), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer2, 6))), IndicationKt.getLocalIndication().provides(rippleIndication), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes3), TextSelectionColorsKt.getLocalTextSelectionColors().provides(selectionColors), TypographyKt.getLocalTypography().provides(typography2)}, ComposableLambdaKt.composableLambda($composer2, -1740102967, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$1
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
                    ComposerKt.sourceInformation($composer3, "C80@3849L97:MaterialTheme.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1740102967, $changed2, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)");
                        }
                        TextStyle body1 = Typography.this.getBody1();
                        final Function2<Composer, Integer, Unit> function2 = content;
                        final int i5 = $dirty3;
                        TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda($composer3, 181426554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$1.1
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

                            public final void invoke(Composer $composer4, int $changed3) {
                                ComposerKt.sourceInformation($composer4, "C81@3906L30:MaterialTheme.kt#jmzs0o");
                                if (($changed3 & 11) == 2 && $composer4.getSkipping()) {
                                    $composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(181426554, $changed3, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)");
                                }
                                MaterialTheme_androidKt.PlatformMaterialTheme(function2, $composer4, (i5 >> 9) & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), $composer3, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shapes4 = shapes3;
            colors3 = colors2;
            typography3 = typography2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Colors colors4 = colors3;
        final Typography typography4 = typography3;
        final Shapes shapes5 = shapes4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$2
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

            public final void invoke(Composer composer, int i5) {
                MaterialThemeKt.MaterialTheme(Colors.this, typography4, shapes5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
