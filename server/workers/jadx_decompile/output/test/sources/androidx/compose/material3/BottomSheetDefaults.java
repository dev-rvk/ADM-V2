package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetDefaults.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\nR\u0011\u0010\u0016\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "()V", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ExpandedShape", "Landroidx/compose/ui/graphics/Shape;", "getExpandedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "HiddenShape", "getHiddenShape", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m2429getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetPeekHeight = Dp.m5218constructorimpl(56);

    private BottomSheetDefaults() {
    }

    public final Shape getHiddenShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1971658024);
        ComposerKt.sourceInformation($composer, "C289@10707L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:288)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final Shape getExpandedShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1683783414);
        ComposerKt.sourceInformation($composer, "C294@10917L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:293)");
        }
        Shape shape = ShapesKt.toShape(SheetBottomTokens.INSTANCE.getDockedContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(433375448);
        ComposerKt.sourceInformation($composer, "C299@11092L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:298)");
        }
        long color = ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m1313getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        long m2947copywmQWz5c;
        $composer.startReplaceableGroup(-2040719176);
        ComposerKt.sourceInformation($composer, "C307@11388L9:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:306)");
        }
        m2947copywmQWz5c = Color.m2947copywmQWz5c(r2, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r2) : 0.32f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r2) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r2) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(ScrimTokens.INSTANCE.getContainerColor(), $composer, 6)) : 0.0f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m2947copywmQWz5c;
    }

    /* renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m1314getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-511309409);
        ComposerKt.sourceInformation($composer, "C319@11725L29:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, $changed, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:319)");
        }
        WindowInsets m557onlybOOhFvg = WindowInsetsKt.m557onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, $composer, 8), WindowInsetsSides.INSTANCE.m583getVerticalJoeWqyM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m557onlybOOhFvg;
    }

    /* renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public final void m1312DragHandlelgZ2HuY(Modifier modifier, float width, float height, Shape shape, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        final float height2;
        Shape shape2;
        long j;
        Modifier.Companion modifier3;
        final float width2;
        long color2;
        float f2;
        Modifier modifier4;
        Object value$iv$iv;
        Modifier modifier5;
        float width3;
        long color3;
        float height3;
        Shape shape3;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(-1364277227);
        ComposerKt.sourceInformation($composer2, "C(DragHandle)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3,0:c#ui.graphics.Color)329@12138L6,330@12220L9,333@12336L51,337@12527L46,334@12396L437:SheetDefaults.kt#uh7d8r");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            f = width;
        } else if (($changed & 112) == 0) {
            f = width;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = width;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            height2 = height;
        } else if (($changed & 896) == 0) {
            height2 = height;
            $dirty |= $composer2.changed(height2) ? 256 : 128;
        } else {
            height2 = height;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed(shape2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                shape2 = shape;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            shape2 = shape;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            j = color;
        }
        if ((46811 & $dirty) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            height3 = height2;
            shape3 = shape2;
            color3 = j;
            modifier5 = modifier2;
            width3 = f;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                width2 = i5 != 0 ? SheetBottomTokens.INSTANCE.m2428getDockedDragHandleWidthD9Ej5fM() : f;
                if (i6 != 0) {
                    height2 = SheetBottomTokens.INSTANCE.m2427getDockedDragHandleHeightD9Ej5fM();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    shape2 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getExtraLarge();
                }
                if ((i & 16) != 0) {
                    color2 = Color.m2947copywmQWz5c(r16, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r16) : 0.4f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r16) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r16) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(ColorSchemeKt.toColor(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), $composer2, 6)) : 0.0f);
                    $dirty &= -57345;
                } else {
                    color2 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                modifier3 = modifier2;
                width2 = f;
                color2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364277227, $dirty, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:325)");
            }
            final String dragHandleDescription = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1723getBottomSheetDragHandleDescriptionadMyvUU(), $composer2, 6);
            f2 = SheetDefaultsKt.DragHandleVerticalPadding;
            Modifier m486paddingVpY3zN4$default = PaddingKt.m486paddingVpY3zN4$default(modifier3, 0.0f, f2, 1, null);
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(dragHandleDescription);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                modifier4 = modifier3;
                value$iv$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContentDescription(semantics, dragHandleDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                modifier4 = modifier3;
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            SurfaceKt.m1794SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m486paddingVpY3zN4$default, false, (Function1) value$iv$iv, 1, null), shape2, color2, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda($composer2, -1039573072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$2
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
                    ComposerKt.sourceInformation($composer3, "C341@12652L171:SheetDefaults.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1039573072, $changed2, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:340)");
                        }
                        BoxKt.Box(SizeKt.m533sizeVpY3zN4(Modifier.INSTANCE, width2, height2), $composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 6) & 112) | 12582912 | (($dirty >> 6) & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            width3 = width2;
            color3 = color2;
            height3 = height2;
            shape3 = shape2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier5;
        final float f3 = width3;
        final float f4 = height3;
        final Shape shape4 = shape3;
        final long j2 = color3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$3
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
                BottomSheetDefaults.this.m1312DragHandlelgZ2HuY(modifier6, f3, f4, shape4, j2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
