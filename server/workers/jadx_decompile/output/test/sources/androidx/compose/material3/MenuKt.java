package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Menu.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aT\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0080\u0001\u0010\u001d\u001a\u00020\u000e2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u000e0\u001f¢\u0006\u0002\b\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001f¢\u0006\u0002\b\u001a2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\u0010*\u001a \u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000ø\u0001\u0000¢\u0006\u0002\u0010/\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\n\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\"\u000e\u0010\f\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MenuKt {
    public static final int InTransitionDuration = 120;
    public static final int OutTransitionDuration = 75;
    private static final float MenuVerticalMargin = Dp.m5218constructorimpl(48);
    private static final float DropdownMenuItemHorizontalPadding = Dp.m5218constructorimpl(12);
    private static final float DropdownMenuVerticalPadding = Dp.m5218constructorimpl(8);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m5218constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m5218constructorimpl(280);

    public static final void DropdownMenuContent(final MutableTransitionState<Boolean> expandedStates, final MutableState<TransformOrigin> transformOriginState, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String str2;
        Modifier modifier3;
        Object value$iv$iv;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(expandedStates, "expandedStates");
        Intrinsics.checkNotNullParameter(transformOriginState, "transformOriginState");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-159754260);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenuContent)P(1,3,2)72@3078L48,74@3156L666,100@3852L477,120@4385L153,126@4582L9,127@4623L11,119@4334L715:Menu.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(expandedStates) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(transformOriginState) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
        } else {
            Modifier.Companion modifier5 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-159754260, $dirty2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:65)");
            }
            Transition transition = TransitionKt.updateTransition((MutableTransitionState) expandedStates, "DropDownMenu", $composer2, MutableTransitionState.$stable | 48 | ($dirty2 & 14), 0);
            Function3 transitionSpec$iv = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer $composer3, int $changed2) {
                    TweenSpec tween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(839979861);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(839979861, $changed2, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:75)");
                    }
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                    } else {
                        tween$default = AnimationSpecKt.tween$default(1, 74, null, 4, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter typeConverter$iv$iv = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            boolean it = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer2.startReplaceableGroup(1808111696);
            ComposerKt.sourceInformation($composer2, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808111696, $changed2, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
            }
            float f = it ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv = Float.valueOf(f);
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            boolean it2 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceableGroup(1808111696);
            ComposerKt.sourceInformation($composer2, "C:Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#uh7d8r";
                ComposerKt.traceEventStart(1808111696, $changed3, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:90)");
            } else {
                str = "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli";
                str2 = "C:Menu.kt#uh7d8r";
            }
            float f2 = it2 ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object targetValue$iv$iv = Float.valueOf(f2);
            FiniteAnimationSpec<Float> animationSpec$iv$iv = transitionSpec$iv.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            String str3 = str2;
            final State scale$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv, targetValue$iv$iv, animationSpec$iv$iv, typeConverter$iv$iv, "FloatAnimation", $composer2, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Function3 transitionSpec$iv2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                    return invoke(segment, composer, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> animateFloat, Composer $composer3, int $changed4) {
                    TweenSpec tween$default;
                    Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
                    $composer3.startReplaceableGroup(896631233);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(896631233, $changed4, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:101)");
                    }
                    if (animateFloat.isTransitioningTo(false, true)) {
                        tween$default = AnimationSpecKt.tween$default(30, 0, null, 6, null);
                    } else {
                        tween$default = AnimationSpecKt.tween$default(75, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer3.endReplaceableGroup();
                    return tween$default;
                }
            };
            $composer2.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation($composer2, str);
            TwoWayConverter typeConverter$iv$iv2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv2 = ((0 << 3) & 57344) | (0 & 14) | ((0 << 3) & 896) | ((0 << 3) & 7168);
            $composer2.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation($composer2, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            int $changed4 = ($changed$iv$iv2 >> 9) & 112;
            boolean it3 = ((Boolean) transition.getCurrentState()).booleanValue();
            $composer2.startReplaceableGroup(1864763068);
            ComposerKt.sourceInformation($composer2, str3);
            if (ComposerKt.isTraceInProgress()) {
                modifier3 = modifier5;
                ComposerKt.traceEventStart(1864763068, $changed4, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
            } else {
                modifier3 = modifier5;
            }
            float f3 = it3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv2 = Float.valueOf(f3);
            int $changed5 = ($changed$iv$iv2 >> 9) & 112;
            boolean it4 = ((Boolean) transition.getTargetState()).booleanValue();
            $composer2.startReplaceableGroup(1864763068);
            ComposerKt.sourceInformation($composer2, str3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1864763068, $changed5, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:110)");
            }
            float f4 = it4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object targetValue$iv$iv2 = Float.valueOf(f4);
            FiniteAnimationSpec<Float> animationSpec$iv$iv2 = transitionSpec$iv2.invoke(transition.getSegment(), $composer2, Integer.valueOf(($changed$iv$iv2 >> 3) & 112));
            final State alpha$delegate = TransitionKt.createTransitionAnimation(transition, initialValue$iv$iv2, targetValue$iv$iv2, animationSpec$iv$iv2, typeConverter$iv$iv2, "FloatAnimation", $composer2, ($changed$iv$iv2 & 14) | (($changed$iv$iv2 << 9) & 57344) | (($changed$iv$iv2 << 6) & 458752));
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            int i3 = ($dirty2 << 3) & 896;
            $composer2.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(scale$delegate) | $composer2.changed(alpha$delegate) | $composer2.changed(transformOriginState);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                        invoke2(graphicsLayerScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GraphicsLayerScope graphicsLayer) {
                        float DropdownMenuContent$lambda$1;
                        float DropdownMenuContent$lambda$12;
                        float DropdownMenuContent$lambda$3;
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        DropdownMenuContent$lambda$1 = MenuKt.DropdownMenuContent$lambda$1(scale$delegate);
                        graphicsLayer.setScaleX(DropdownMenuContent$lambda$1);
                        DropdownMenuContent$lambda$12 = MenuKt.DropdownMenuContent$lambda$1(scale$delegate);
                        graphicsLayer.setScaleY(DropdownMenuContent$lambda$12);
                        DropdownMenuContent$lambda$3 = MenuKt.DropdownMenuContent$lambda$3(alpha$delegate);
                        graphicsLayer.setAlpha(DropdownMenuContent$lambda$3);
                        graphicsLayer.mo3138setTransformOrigin__ExYCQ(transformOriginState.getValue().getPackedValue());
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final Modifier modifier6 = modifier3;
            SurfaceKt.m1794SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) value$iv$iv), ShapesKt.toShape(MenuTokens.INSTANCE.getContainerShape(), $composer2, 6), ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer2, 6), MenuTokens.INSTANCE.getContainerColor()), 0L, MenuTokens.INSTANCE.m2279getContainerElevationD9Ej5fM(), MenuTokens.INSTANCE.m2279getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda($composer2, -1651673913, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
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

                public final void invoke(Composer $composer3, int $changed6) {
                    ComposerKt.sourceInformation($composer3, "C135@4980L21,131@4801L242:Menu.kt#uh7d8r");
                    if (($changed6 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1651673913, $changed6, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:130)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m486paddingVpY3zN4$default(Modifier.this, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, null), IntrinsicSize.Max), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
                        Function3 content$iv = content;
                        int $changed$iv = $dirty2 & 7168;
                        $composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
                        int $changed$iv$iv3 = ($changed$iv << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv3 << 9) & 7168) | 6;
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
                        int i4 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                        content$iv.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
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
            }), $composer2, 12804096, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier6;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier7 = modifier4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$3
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

            public final void invoke(Composer composer, int i4) {
                MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier7, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final void DropdownMenuItemContent(final Function2<? super Composer, ? super Integer, Unit> text, final Function0<Unit> onClick, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final boolean enabled, final MenuItemColors colors, final PaddingValues contentPadding, final MutableInteractionSource interactionSource, Composer $composer, final int $changed) {
        Composer $composer2;
        Modifier m193clickableO2vRcR0;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Composer $composer3 = $composer.startRestartGroup(-1564716777);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)159@5627L20,153@5416L2336:Menu.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(text) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer3.changed(enabled) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer3.changed(colors) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer3.changed(contentPadding) ? 8388608 : 4194304;
        }
        if ((234881024 & $changed) == 0) {
            $dirty |= $composer3.changed(interactionSource) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        final int $dirty2 = $dirty;
        if ((191739611 & $dirty2) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564716777, $dirty2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:142)");
            }
            $composer2 = $composer3;
            m193clickableO2vRcR0 = ClickableKt.m193clickableO2vRcR0(modifier, interactionSource, RippleKt.m1286rememberRipple9IZ8Weo(true, 0.0f, 0L, $composer3, 6, 6), (r14 & 4) != 0 ? true : enabled, (r14 & 8) != 0 ? null : null, (r14 & 16) != 0 ? null : null, onClick);
            Modifier modifier$iv = PaddingKt.padding(SizeKt.m535sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(m193clickableO2vRcR0, 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, MenuTokens.INSTANCE.m2280getListItemContainerHeightD9Ej5fM(), DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), contentPadding);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer2);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            final RowScope $this$DropdownMenuItemContent_u24lambda_u245 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1557318497, "C171@6130L10,171@6099L1647:Menu.kt#uh7d8r");
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), MenuTokens.INSTANCE.getListItemLabelTextFont()), ComposableLambdaKt.composableLambda($composer2, 1065051884, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1
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
                    ComposerKt.sourceInformation($composer4, "C181@6637L18,181@6578L777,203@7492L26,202@7412L310:Menu.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1065051884, $changed2, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:171)");
                        }
                        $composer4.startReplaceableGroup(1426254055);
                        ComposerKt.sourceInformation($composer4, "174@6323L25,173@6243L308");
                        if (function2 != null) {
                            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(colors.leadingIconColor$material3_release(enabled, $composer4, (($dirty2 >> 15) & 14) | (($dirty2 >> 15) & 112)).getValue())};
                            final Function2<Composer, Integer, Unit> function23 = function2;
                            final int i3 = $dirty2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer4, 2035552199, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.1
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

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C176@6396L137:Menu.kt#uh7d8r");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2035552199, $changed3, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:175)");
                                        }
                                        Modifier modifier$iv2 = SizeKt.m516defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m2281getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function24 = function23;
                                        int i4 = i3;
                                        $composer5.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                        int $changed$iv$iv2 = (6 << 3) & 112;
                                        $composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume4 = $composer5.consume(localDensity2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        Density density$iv$iv2 = (Density) consume4;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer5.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer5.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer5.startReusableNode();
                                        if ($composer5.getInserting()) {
                                            $composer5.createNode(factory$iv$iv$iv2);
                                        } else {
                                            $composer5.useNode();
                                        }
                                        $composer5.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer5);
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer5.enableReusing();
                                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                        $composer5.startReplaceableGroup(2058660585);
                                        int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i6 = ((6 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 116811731, "C177@6498L13:Menu.kt#uh7d8r");
                                        function24.invoke($composer5, Integer.valueOf((i4 >> 9) & 14));
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        $composer5.endReplaceableGroup();
                                        $composer5.endNode();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }), $composer4, 56);
                        }
                        $composer4.endReplaceableGroup();
                        ProvidedValue[] providedValueArr2 = {ContentColorKt.getLocalContentColor().provides(colors.textColor$material3_release(enabled, $composer4, (($dirty2 >> 15) & 14) | (($dirty2 >> 15) & 112)).getValue())};
                        final RowScope rowScope = $this$DropdownMenuItemContent_u24lambda_u245;
                        final Function2<Composer, Integer, Unit> function24 = function2;
                        final Function2<Composer, Integer, Unit> function25 = function22;
                        final Function2<Composer, Integer, Unit> function26 = text;
                        final int i4 = $dirty2;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, ComposableLambdaKt.composableLambda($composer4, -1728894036, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.2
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

                            public final void invoke(Composer $composer5, int $changed3) {
                                float m5218constructorimpl;
                                float m5218constructorimpl2;
                                float f;
                                float f2;
                                ComposerKt.sourceInformation($composer5, "C182@6681L660:Menu.kt#uh7d8r");
                                if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1728894036, $changed3, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:181)");
                                    }
                                    Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    if (function24 != null) {
                                        f2 = MenuKt.DropdownMenuItemHorizontalPadding;
                                        m5218constructorimpl = f2;
                                    } else {
                                        m5218constructorimpl = Dp.m5218constructorimpl(0);
                                    }
                                    if (function25 != null) {
                                        f = MenuKt.DropdownMenuItemHorizontalPadding;
                                        m5218constructorimpl2 = f;
                                    } else {
                                        m5218constructorimpl2 = Dp.m5218constructorimpl(0);
                                    }
                                    Modifier modifier$iv2 = PaddingKt.m488paddingqDBjuR0$default(weight$default, m5218constructorimpl, 0.0f, m5218constructorimpl2, 0.0f, 10, null);
                                    Function2<Composer, Integer, Unit> function27 = function26;
                                    int i5 = i4;
                                    $composer5.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv2 = (0 << 3) & 112;
                                    $composer5.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume4 = $composer5.consume(localDensity2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    Density density$iv$iv2 = (Density) consume4;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume5 = $composer5.consume(localLayoutDirection2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                    ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume6 = $composer5.consume(localViewConfiguration2);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(factory$iv$iv$iv2);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    $composer5.disableReusing();
                                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer5);
                                    Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                    Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                    Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                    $composer5.enableReusing();
                                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                    $composer5.startReplaceableGroup(2058660585);
                                    int i6 = ($changed$iv$iv$iv2 >> 9) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i7 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 116812550, "C198@7317L6:Menu.kt#uh7d8r");
                                    function27.invoke($composer5, Integer.valueOf(i5 & 14));
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endReplaceableGroup();
                                    $composer5.endNode();
                                    $composer5.endReplaceableGroup();
                                    $composer5.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }), $composer4, 56);
                        if (function22 != null) {
                            ProvidedValue[] providedValueArr3 = {ContentColorKt.getLocalContentColor().provides(colors.trailingIconColor$material3_release(enabled, $composer4, (($dirty2 >> 15) & 14) | (($dirty2 >> 15) & 112)).getValue())};
                            final Function2<Composer, Integer, Unit> function27 = function22;
                            final int i5 = $dirty2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr3, ComposableLambdaKt.composableLambda($composer4, 580312062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.3
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

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C205@7565L139:Menu.kt#uh7d8r");
                                    if (($changed3 & 11) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(580312062, $changed3, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:204)");
                                        }
                                        Modifier modifier$iv2 = SizeKt.m516defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, MenuTokens.INSTANCE.m2282getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function28 = function27;
                                        int i6 = i5;
                                        $composer5.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                        int $changed$iv$iv2 = (6 << 3) & 112;
                                        $composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume4 = $composer5.consume(localDensity2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        Density density$iv$iv2 = (Density) consume4;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer5.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer5.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer5.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer5.startReusableNode();
                                        if ($composer5.getInserting()) {
                                            $composer5.createNode(factory$iv$iv$iv2);
                                        } else {
                                            $composer5.useNode();
                                        }
                                        $composer5.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer5);
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer5.enableReusing();
                                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                        $composer5.startReplaceableGroup(2058660585);
                                        int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer5, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i8 = ((6 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer5, 116812901, "C206@7668L14:Menu.kt#uh7d8r");
                                        function28.invoke($composer5, Integer.valueOf((i6 >> 12) & 14));
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        $composer5.endReplaceableGroup();
                                        $composer5.endNode();
                                        $composer5.endReplaceableGroup();
                                        $composer5.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }), $composer4, 56);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }), $composer2, 48);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$2
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

            public final void invoke(Composer composer, int i3) {
                MenuKt.DropdownMenuItemContent(text, onClick, modifier, function2, function22, enabled, colors, contentPadding, interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final long calculateTransformOrigin(IntRect parentBounds, IntRect menuBounds) {
        float left;
        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
        float f = 1.0f;
        if (menuBounds.getLeft() >= parentBounds.getRight()) {
            left = 0.0f;
        } else if (menuBounds.getRight() <= parentBounds.getLeft()) {
            left = 1.0f;
        } else if (menuBounds.getWidth() == 0) {
            left = 0.0f;
        } else {
            int intersectionCenter = (Math.max(parentBounds.getLeft(), menuBounds.getLeft()) + Math.min(parentBounds.getRight(), menuBounds.getRight())) / 2;
            left = (intersectionCenter - menuBounds.getLeft()) / menuBounds.getWidth();
        }
        float pivotX = left;
        if (menuBounds.getTop() >= parentBounds.getBottom()) {
            f = 0.0f;
        } else if (menuBounds.getBottom() > parentBounds.getTop()) {
            if (menuBounds.getHeight() == 0) {
                f = 0.0f;
            } else {
                int intersectionCenter2 = (Math.max(parentBounds.getTop(), menuBounds.getTop()) + Math.min(parentBounds.getBottom(), menuBounds.getBottom())) / 2;
                f = (intersectionCenter2 - menuBounds.getTop()) / menuBounds.getHeight();
            }
        }
        float pivotY = f;
        return TransformOriginKt.TransformOrigin(pivotX, pivotY);
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }
}
