package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnackbarHost.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\b\u001a\u00020\t2\u0019\b\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*b\b\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\b\f¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\f¨\u0006("}, d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "snackbar", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SnackbarHostKt {
    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis = 0;

    /* compiled from: SnackbarHost.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void SnackbarHost(final SnackbarHostState hostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function3 function32;
        Modifier modifier3;
        Function3 snackbar;
        Intrinsics.checkNotNullParameter(hostState, "hostState");
        Composer $composer2 = $composer.startRestartGroup(464178177);
        ComposerKt.sourceInformation($composer2, "C(SnackbarHost)222@9266L7,223@9278L356,233@9639L134:SnackbarHost.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(hostState) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function32 = function3;
        } else if (($changed & 896) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? 256 : 128;
        } else {
            function32 = function3;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            snackbar = function32;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            Function3 snackbar2 = i3 != 0 ? ComposableSingletons$SnackbarHostKt.INSTANCE.m1445getLambda1$material3_release() : function32;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(464178177, $dirty2, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:216)");
            }
            SnackbarData currentSnackbarData = hostState.getCurrentSnackbarData();
            ProvidableCompositionLocal<AccessibilityManager> localAccessibilityManager = CompositionLocalsKt.getLocalAccessibilityManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localAccessibilityManager);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AccessibilityManager accessibilityManager = (AccessibilityManager) consume;
            EffectsKt.LaunchedEffect(currentSnackbarData, new SnackbarHostKt$SnackbarHost$1(currentSnackbarData, accessibilityManager, null), $composer2, 64);
            FadeInFadeOutWithScale(hostState.getCurrentSnackbarData(), modifier4, snackbar2, $composer2, ($dirty2 & 112) | ($dirty2 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            snackbar = snackbar2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final Function3 function33 = snackbar;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$SnackbarHost$2
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
                SnackbarHostKt.SnackbarHost(SnackbarHostState.this, modifier5, function33, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final long toMillis(SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
        long original;
        Intrinsics.checkNotNullParameter($this$toMillis, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toMillis.ordinal()]) {
            case 1:
                original = Long.MAX_VALUE;
                break;
            case 2:
                original = 10000;
                break;
            case 3:
                original = 4000;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (accessibilityManager == null) {
            return original;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(original, true, true, hasAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FadeInFadeOutWithScale(final SnackbarData current, Modifier modifier, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv$iv;
        Modifier modifier3;
        final SnackbarData snackbarData = current;
        Composer $composer2 = $composer.startRestartGroup(-1316639904);
        ComposerKt.sourceInformation($composer2, "C(FadeInFadeOutWithScale)P(1,2)343@12564L48,397@14811L242:SnackbarHost.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(snackbarData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1316639904, $dirty2, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:338)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new FadeInFadeOutState();
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final FadeInFadeOutState state = (FadeInFadeOutState) value$iv$iv;
            if (!Intrinsics.areEqual(snackbarData, state.getCurrent())) {
                state.setCurrent(snackbarData);
                Iterable $this$map$iv = state.getItems();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    FadeInFadeOutAnimationItem it = (FadeInFadeOutAnimationItem) item$iv$iv;
                    destination$iv$iv.add((SnackbarData) it.getKey());
                }
                final List keys = CollectionsKt.toMutableList(destination$iv$iv);
                if (!keys.contains(snackbarData)) {
                    keys.add(snackbarData);
                }
                state.getItems().clear();
                Iterable $this$mapTo$iv = CollectionsKt.filterNotNull(keys);
                Collection destination$iv = state.getItems();
                for (Object item$iv : $this$mapTo$iv) {
                    final SnackbarData key = (SnackbarData) item$iv;
                    destination$iv.add(new FadeInFadeOutAnimationItem(key, ComposableLambdaKt.composableLambda($composer2, 1365430839, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> children, Composer $composer3, int $changed2) {
                            State opacity;
                            State scale;
                            Object value$iv$iv2;
                            Intrinsics.checkNotNullParameter(children, "children");
                            ComposerKt.sourceInformation($composer3, "C357@13316L618,372@13963L292,387@14557L150,380@14272L504:SnackbarHost.kt#uh7d8r");
                            int $dirty3 = $changed2;
                            if (($changed2 & 14) == 0) {
                                $dirty3 |= $composer3.changedInstance(children) ? 4 : 2;
                            }
                            int $dirty4 = $dirty3;
                            if (($dirty4 & 91) != 18 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1365430839, $dirty4, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:352)");
                                }
                                boolean isVisible = Intrinsics.areEqual(SnackbarData.this, snackbarData);
                                int duration = isVisible ? 150 : 75;
                                int animationDelay = (!isVisible || CollectionsKt.filterNotNull(keys).size() == 1) ? 0 : 75;
                                TweenSpec tween = AnimationSpecKt.tween(duration, animationDelay, EasingKt.getLinearEasing());
                                final SnackbarData snackbarData2 = SnackbarData.this;
                                final FadeInFadeOutState<SnackbarData> fadeInFadeOutState = state;
                                opacity = SnackbarHostKt.animatedOpacity(tween, isVisible, new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        if (!Intrinsics.areEqual(SnackbarData.this, fadeInFadeOutState.getCurrent())) {
                                            List<FadeInFadeOutAnimationItem<SnackbarData>> items = fadeInFadeOutState.getItems();
                                            final SnackbarData snackbarData3 = SnackbarData.this;
                                            CollectionsKt.removeAll((List) items, (Function1) new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(FadeInFadeOutAnimationItem<SnackbarData> it2) {
                                                    Intrinsics.checkNotNullParameter(it2, "it");
                                                    return Boolean.valueOf(Intrinsics.areEqual(it2.getKey(), SnackbarData.this));
                                                }
                                            });
                                            RecomposeScope scope = fadeInFadeOutState.getScope();
                                            if (scope != null) {
                                                scope.invalidate();
                                            }
                                        }
                                    }
                                }, $composer3, 0, 0);
                                scale = SnackbarHostKt.animatedScale(AnimationSpecKt.tween(duration, animationDelay, EasingKt.getFastOutSlowInEasing()), isVisible, $composer3, 0);
                                Modifier m3106graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m3106graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, ((Number) scale.getValue()).floatValue(), ((Number) scale.getValue()).floatValue(), ((Number) opacity.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                                Object key1$iv = SnackbarData.this;
                                final SnackbarData snackbarData3 = SnackbarData.this;
                                $composer3.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean invalid$iv$iv = $composer3.changed(key1$iv);
                                Object it$iv$iv2 = $composer3.rememberedValue();
                                if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
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
                                            SemanticsPropertiesKt.m4581setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m4560getPolite0phEisY());
                                            final SnackbarData snackbarData4 = SnackbarData.this;
                                            SemanticsPropertiesKt.dismiss$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$1$1.1
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    SnackbarData.this.dismiss();
                                                    return true;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv$iv2);
                                } else {
                                    value$iv$iv2 = it$iv$iv2;
                                }
                                $composer3.endReplaceableGroup();
                                Modifier modifier$iv = SemanticsModifierKt.semantics$default(m3106graphicsLayerAp8cVGQ$default, false, (Function1) value$iv$iv2, 1, null);
                                $composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv = (0 << 3) & 112;
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
                                int i3 = ($changed$iv$iv$iv >> 9) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i4 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer3, 1581584297, "C392@14748L10:SnackbarHost.kt#uh7d8r");
                                children.invoke($composer3, Integer.valueOf($dirty4 & 14));
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
                    })));
                    snackbarData = current;
                    $this$mapTo$iv = $this$mapTo$iv;
                    keys = keys;
                }
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier4);
            modifier3 = modifier4;
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
            int $changed$iv2 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1606179266, "C398@14849L21:SnackbarHost.kt#uh7d8r");
            state.setScope(ComposablesKt.getCurrentRecomposeScope($composer2, 0));
            $composer2.startReplaceableGroup(-733277355);
            ComposerKt.sourceInformation($composer2, "");
            Iterable $this$forEach$iv = state.getItems();
            int $i$f$forEach = 0;
            for (Object element$iv : $this$forEach$iv) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) element$iv;
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                final SnackbarData item = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                int $i$f$forEach2 = $i$f$forEach;
                Function3 opacity = fadeInFadeOutAnimationItem.component2();
                $composer2.startMovableGroup(870027328, item);
                ComposerKt.sourceInformation($composer2, "401@14960L63");
                opacity.invoke(ComposableLambdaKt.composableLambda($composer2, -1462081411, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$2$1$1
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
                        ComposerKt.sourceInformation($composer3, "C402@14990L15:SnackbarHost.kt#uh7d8r");
                        if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                            $composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1462081411, $changed2, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:401)");
                        }
                        Function3<SnackbarData, Composer, Integer, Unit> function32 = function3;
                        SnackbarData snackbarData2 = item;
                        Intrinsics.checkNotNull(snackbarData2);
                        function32.invoke(snackbarData2, $composer3, Integer.valueOf(($dirty2 >> 3) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), $composer2, 6);
                $composer2.endMovableGroup();
                $this$forEach$iv = $this$forEach$iv2;
                state = state;
                $i$f$forEach = $i$f$forEach2;
                $changed$iv2 = $changed$iv2;
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$3
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
                SnackbarHostKt.FadeInFadeOutWithScale(SnackbarData.this, modifier5, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean visible, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1431889134);
        ComposerKt.sourceInformation($composer, "C(animatedOpacity)P(!1,2)429@15701L49,430@15755L169:SnackbarHost.kt#uh7d8r");
        Function0 onAnimationFinish = (i & 4) != 0 ? new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarHostKt$animatedOpacity$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        } : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, $changed, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:424)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.0f, 0.0f, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable alpha = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect(Boolean.valueOf(visible), new SnackbarHostKt$animatedOpacity$2(alpha, visible, animationSpec, onAnimationFinish, null), $composer, (($changed >> 3) & 14) | 64);
        State<Float> asState = alpha.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean visible, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1966809761);
        ComposerKt.sourceInformation($composer, "C(animatedScale)442@16076L51,443@16132L143:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, $changed, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:441)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = AnimatableKt.Animatable$default(!visible ? 1.0f : 0.8f, 0.0f, 2, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Animatable scale = (Animatable) value$iv$iv;
        EffectsKt.LaunchedEffect(Boolean.valueOf(visible), new SnackbarHostKt$animatedScale$1(scale, visible, animationSpec, null), $composer, (($changed >> 3) & 14) | 64);
        State<Float> asState = scale.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return asState;
    }
}
