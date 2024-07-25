package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.internal.ExposedDropdownMenuPopupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0017¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface ExposedDropdownMenuBoxScope {
    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    /* compiled from: ExposedDropdownMenu.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void ExposedDropdownMenu(ExposedDropdownMenuBoxScope $this, boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
            Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
            Intrinsics.checkNotNullParameter(content, "content");
            ExposedDropdownMenuBoxScope.super.ExposedDropdownMenu(expanded, onDismissRequest, modifier, scrollState, content, $composer, $changed, i);
        }
    }

    static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
    }

    default void ExposedDropdownMenu(final boolean expanded, final Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ScrollState scrollState2;
        int $dirty;
        Modifier modifier3;
        ScrollState scrollState3;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        int i2;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1081438217);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenu)P(1,3,2,4)236@9131L21,248@9631L42,252@9833L51,253@9924L7,257@10071L139,261@10224L491:ExposedDropdownMenu.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onDismissRequest) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 7168) == 0) {
            if ((i & 8) == 0) {
                scrollState2 = scrollState;
                if ($composer2.changed(scrollState2)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                scrollState2 = scrollState;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            scrollState2 = scrollState;
        }
        if ((i & 16) != 0) {
            $dirty2 |= 24576;
        } else if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((458752 & $changed) == 0) {
            $dirty2 |= $composer2.changed(this) ? 131072 : 65536;
        }
        if ((374491 & $dirty2) == 74898 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            scrollState3 = scrollState2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier4 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 8) != 0) {
                    $dirty = $dirty2 & (-7169);
                    modifier3 = modifier4;
                    scrollState3 = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
                } else {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    scrollState3 = scrollState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier3 = modifier2;
                scrollState3 = scrollState2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1081438217, $dirty, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:232)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new MutableTransitionState(false);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final MutableTransitionState expandedStates = (MutableTransitionState) value$iv$iv;
            expandedStates.setTargetState(Boolean.valueOf(expanded));
            if (((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                Object it$iv$iv2 = $composer2.rememberedValue();
                if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m3320boximpl(TransformOrigin.INSTANCE.m3333getCenterSzJe1aQ()), null, 2, null);
                    $composer2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                final MutableState transformOriginState = (MutableState) value$iv$iv2;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density = (Density) consume;
                long m5289getZeroRKDOV3M = DpOffset.INSTANCE.m5289getZeroRKDOV3M();
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(transformOriginState);
                Object it$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv && it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = it$iv$iv3;
                    $composer2.endReplaceableGroup();
                    DropdownMenuPositionProvider popupPositionProvider = new DropdownMenuPositionProvider(m5289getZeroRKDOV3M, density, (Function2) value$iv$iv3, null);
                    final ScrollState scrollState4 = scrollState3;
                    final Modifier modifier5 = modifier3;
                    final int $dirty3 = $dirty;
                    ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, popupPositionProvider, ComposableLambdaKt.composableLambda($composer2, -1167205969, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                            ComposerKt.sourceInformation($composer3, "C265@10397L304:ExposedDropdownMenu.kt#jmzs0o");
                            if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1167205969, $changed2, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:264)");
                                }
                                MenuKt.DropdownMenuContent(expandedStates, transformOriginState, scrollState4, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(this, modifier5, false, 1, null), content, $composer3, MutableTransitionState.$stable | 48 | (($dirty3 >> 3) & 896) | (57344 & $dirty3), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }), $composer2, (($dirty3 >> 3) & 14) | 384, 0);
                }
                value$iv$iv3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                        invoke2(intRect, intRect2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(IntRect parentBounds, IntRect menuBounds) {
                        Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                        Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                        transformOriginState.setValue(TransformOrigin.m3320boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                DropdownMenuPositionProvider popupPositionProvider2 = new DropdownMenuPositionProvider(m5289getZeroRKDOV3M, density, (Function2) value$iv$iv3, null);
                final ScrollState scrollState42 = scrollState3;
                final Modifier modifier52 = modifier3;
                final int $dirty32 = $dirty;
                ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(onDismissRequest, popupPositionProvider2, ComposableLambdaKt.composableLambda($composer2, -1167205969, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
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
                        ComposerKt.sourceInformation($composer3, "C265@10397L304:ExposedDropdownMenu.kt#jmzs0o");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1167205969, $changed2, -1, "androidx.compose.material.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:264)");
                            }
                            MenuKt.DropdownMenuContent(expandedStates, transformOriginState, scrollState42, ExposedDropdownMenuBoxScope.exposedDropdownSize$default(this, modifier52, false, 1, null), content, $composer3, MutableTransitionState.$stable | 48 | (($dirty32 >> 3) & 896) | (57344 & $dirty32), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, (($dirty32 >> 3) & 14) | 384, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        final ScrollState scrollState5 = scrollState3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
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
                ExposedDropdownMenuBoxScope.this.ExposedDropdownMenu(expanded, onDismissRequest, modifier6, scrollState5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }
}
