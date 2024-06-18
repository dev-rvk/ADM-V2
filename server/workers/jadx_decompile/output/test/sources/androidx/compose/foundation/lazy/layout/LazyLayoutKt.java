package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayout.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001aM\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    public static final void LazyLayout(final LazyLayoutItemProvider itemProvider, Modifier modifier, LazyLayoutPrefetchState prefetchState, final Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState;
        Modifier modifier3;
        LazyLayoutPrefetchState prefetchState2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(852831187);
        ComposerKt.sourceInformation($composer2, "C(LazyLayout)P(!1,2,3)47@1918L16,47@1907L68:LazyLayout.kt#wow0x6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(itemProvider) ? 4 : 2;
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
            lazyLayoutPrefetchState = prefetchState;
        } else if (($changed & 896) == 0) {
            lazyLayoutPrefetchState = prefetchState;
            $dirty |= $composer2.changed(lazyLayoutPrefetchState) ? 256 : 128;
        } else {
            lazyLayoutPrefetchState = prefetchState;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            prefetchState2 = lazyLayoutPrefetchState;
        } else {
            modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            prefetchState2 = i3 != 0 ? null : lazyLayoutPrefetchState;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(852831187, $dirty2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:41)");
            }
            int i4 = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(itemProvider);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LazyLayoutItemProvider invoke() {
                        return LazyLayoutItemProvider.this;
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LazyLayout((Function0<? extends LazyLayoutItemProvider>) value$iv$iv, modifier3, prefetchState2, measurePolicy, $composer2, ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = prefetchState2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
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
                LazyLayoutKt.LazyLayout(LazyLayoutItemProvider.this, modifier4, lazyLayoutPrefetchState2, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final void LazyLayout(final Function0<? extends LazyLayoutItemProvider> itemProvider, Modifier modifier, LazyLayoutPrefetchState prefetchState, final Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        LazyLayoutPrefetchState lazyLayoutPrefetchState;
        LazyLayoutPrefetchState prefetchState2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(2002163445);
        ComposerKt.sourceInformation($composer2, "C(LazyLayout)P(!1,2,3)58@2285L34,60@2325L1039:LazyLayout.kt#wow0x6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(itemProvider) ? 4 : 2;
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
            lazyLayoutPrefetchState = prefetchState;
        } else if (($changed & 896) == 0) {
            lazyLayoutPrefetchState = prefetchState;
            $dirty |= $composer2.changed(lazyLayoutPrefetchState) ? 256 : 128;
        } else {
            lazyLayoutPrefetchState = prefetchState;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(measurePolicy) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            prefetchState2 = lazyLayoutPrefetchState;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            LazyLayoutPrefetchState prefetchState3 = i3 != 0 ? null : lazyLayoutPrefetchState;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2002163445, $dirty2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            final State currentItemProvider = SnapshotStateKt.rememberUpdatedState(itemProvider, $composer2, $dirty2 & 14);
            final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = prefetchState3;
            final Modifier modifier5 = modifier4;
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda($composer2, -1488997347, true, new Function3<SaveableStateHolder, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SaveableStateHolder saveableStateHolder, Composer composer, Integer num) {
                    invoke(saveableStateHolder, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SaveableStateHolder saveableStateHolder, Composer $composer3, int $changed2) {
                    Object value$iv$iv;
                    Object value$iv$iv2;
                    Object value$iv$iv3;
                    Intrinsics.checkNotNullParameter(saveableStateHolder, "saveableStateHolder");
                    ComposerKt.sourceInformation($composer3, "C61@2415L114,64@2566L101,78@2956L392,75@2869L489:LazyLayout.kt#wow0x6");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1488997347, $changed2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:60)");
                    }
                    final State<Function0<LazyLayoutItemProvider>> state = currentItemProvider;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer3.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new LazyLayoutItemContentFactory(saveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final LazyLayoutItemProvider invoke() {
                                return state.getValue().invoke();
                            }
                        });
                        $composer3.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    final LazyLayoutItemContentFactory itemContentFactory = (LazyLayoutItemContentFactory) value$iv$iv;
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv2 = $composer3.rememberedValue();
                    if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(itemContentFactory));
                        $composer3.updateRememberedValue(value$iv$iv2);
                    } else {
                        value$iv$iv2 = it$iv$iv2;
                    }
                    $composer3.endReplaceableGroup();
                    SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) value$iv$iv2;
                    LazyLayoutPrefetchState lazyLayoutPrefetchState3 = LazyLayoutPrefetchState.this;
                    $composer3.startReplaceableGroup(-1523808190);
                    ComposerKt.sourceInformation($composer3, "*68@2709L140");
                    if (lazyLayoutPrefetchState3 != null) {
                        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(LazyLayoutPrefetchState.this, itemContentFactory, subcomposeLayoutState, $composer3, (($dirty2 >> 6) & 14) | 64 | (SubcomposeLayoutState.$stable << 6));
                        Unit unit = Unit.INSTANCE;
                    }
                    $composer3.endReplaceableGroup();
                    Modifier modifier6 = modifier5;
                    Object key2$iv = measurePolicy;
                    final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = measurePolicy;
                    int i4 = (($dirty2 >> 6) & 112) | 8;
                    $composer3.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer3.changed(itemContentFactory) | $composer3.changed(key2$iv);
                    Object it$iv$iv3 = $composer3.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m641invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m641invoke0kLqBqw(SubcomposeMeasureScope $this$null, long constraints) {
                                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                                LazyLayoutMeasureScopeImpl $this$invoke_0kLqBqw_u24lambda_u240 = new LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory.this, $this$null);
                                return function2.invoke($this$invoke_0kLqBqw_u24lambda_u240, Constraints.m5162boximpl(constraints));
                            }
                        };
                        $composer3.updateRememberedValue(value$iv$iv3);
                    } else {
                        value$iv$iv3 = it$iv$iv3;
                    }
                    $composer3.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, modifier6, (Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>) value$iv$iv3, $composer3, SubcomposeLayoutState.$stable | ($dirty2 & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            prefetchState2 = prefetchState3;
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState3 = prefetchState2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$4
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
                LazyLayoutKt.LazyLayout(itemProvider, modifier6, lazyLayoutPrefetchState3, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
