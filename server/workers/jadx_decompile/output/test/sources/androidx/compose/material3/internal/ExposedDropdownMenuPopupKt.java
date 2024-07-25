package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenuPopup.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0083\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0<String>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);

    public static final void ExposedDropdownMenuPopup(Function0<Unit> function0, final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        String str;
        final Function0<Unit> function03;
        int i3;
        Composer composer2;
        final State state;
        CompositionContext compositionContext;
        final LayoutDirection layoutDirection;
        Object obj;
        Composer composer3;
        Intrinsics.checkNotNullParameter(popupPositionProvider, "popupPositionProvider");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(187306684);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuPopup)P(1,2)85@3437L7,86@3476L7,87@3520L7,88@3575L7,89@3611L28,90@3666L29,91@3714L38,92@3775L907,119@4688L380,133@5074L192,141@5272L166,150@5616L647:ExposedDropdownMenuPopup.kt#mqatfk");
        int i4 = i;
        int i5 = i2 & 1;
        if (i5 != 0) {
            i4 |= 6;
            function02 = function0;
        } else if ((i & 14) == 0) {
            function02 = function0;
            i4 |= startRestartGroup.changedInstance(function02) ? 4 : 2;
        } else {
            function02 = function0;
        }
        if ((i2 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(popupPositionProvider) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        int i6 = i4;
        if ((i6 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function03 = function02;
            composer3 = startRestartGroup;
        } else {
            Function0<Unit> function04 = i5 != 0 ? null : function02;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(187306684, i6, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.kt:80)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ProvidableCompositionLocal<String> providableCompositionLocal = LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            String str2 = (String) consume3;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, startRestartGroup, (i6 >> 6) & 14);
            UUID popupId = (UUID) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, startRestartGroup, 3080, 6);
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(popupId, "popupId");
                layoutDirection = layoutDirection2;
                str = str2;
                function03 = function04;
                i3 = i6;
                composer2 = startRestartGroup;
                final PopupLayout popupLayout = new PopupLayout(function04, str2, view, density, popupPositionProvider, popupId);
                state = rememberUpdatedState;
                compositionContext = rememberCompositionContext;
                popupLayout.setContent(compositionContext, ComposableLambdaKt.composableLambdaInstance(686046343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C102@4119L533:ExposedDropdownMenuPopup.kt#mqatfk");
                        if (($changed & 11) != 2 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(686046343, $changed, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:101)");
                            }
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.popup(semantics);
                                }
                            }, 1, null);
                            final PopupLayout popupLayout2 = PopupLayout.this;
                            Modifier modifier$iv = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m1998invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m1998invokeozmzZPI(long it) {
                                    PopupLayout.this.m2000setPopupContentSizefhxjrPA(IntSize.m5370boximpl(it));
                                    PopupLayout.this.updatePosition();
                                }
                            }), PopupLayout.this.getCanCalculatePosition() ? 1.0f : 0.0f);
                            final State<Function2<Composer, Integer, Unit>> state2 = state;
                            Function2 content$iv = ComposableLambdaKt.composableLambda($composer, 588819933, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer2, int $changed2) {
                                    Function2 ExposedDropdownMenuPopup$lambda$0;
                                    ComposerKt.sourceInformation($composer2, "C113@4618L16:ExposedDropdownMenuPopup.kt#mqatfk");
                                    if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(588819933, $changed2, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.kt:112)");
                                        }
                                        ExposedDropdownMenuPopup$lambda$0 = ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup$lambda$0(state2);
                                        ExposedDropdownMenuPopup$lambda$0.invoke($composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            });
                            $composer.startReplaceableGroup(-483170785);
                            ComposerKt.sourceInformation($composer, "CC(SimpleStack)P(1)179@6807L979:ExposedDropdownMenuPopup.kt#mqatfk");
                            MeasurePolicy measurePolicy$iv$iv = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
                            int $changed$iv$iv = ((48 >> 3) & 14) | ((48 << 3) & 112);
                            $composer.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume5 = $composer.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            Density density$iv$iv = (Density) consume5;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume6 = $composer.consume(localLayoutDirection2);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume6;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume7 = $composer.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume7;
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                $composer.createNode(factory$iv$iv$iv);
                            } else {
                                $composer.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m2583constructorimpl($composer);
                            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer.startReplaceableGroup(2058660585);
                            content$iv.invoke($composer, Integer.valueOf(($changed$iv$iv$iv >> 9) & 14));
                            $composer.endReplaceableGroup();
                            $composer.endNode();
                            $composer.endReplaceableGroup();
                            $composer.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }
                }));
                startRestartGroup.updateRememberedValue(popupLayout);
                obj = popupLayout;
            } else {
                str = str2;
                function03 = function04;
                i3 = i6;
                composer2 = startRestartGroup;
                state = rememberUpdatedState;
                compositionContext = rememberCompositionContext;
                layoutDirection = layoutDirection2;
                obj = rememberedValue;
            }
            composer2.endReplaceableGroup();
            final PopupLayout popupLayout2 = (PopupLayout) obj;
            final String str3 = str;
            Composer composer4 = composer2;
            EffectsKt.DisposableEffect(popupLayout2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    PopupLayout.this.show();
                    PopupLayout.this.updateParameters(function03, str3, layoutDirection);
                    final PopupLayout popupLayout3 = PopupLayout.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            PopupLayout.this.disposeComposition();
                            PopupLayout.this.dismiss();
                        }
                    };
                }
            }, composer4, 8);
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2
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
                    PopupLayout.this.updateParameters(function03, str3, layoutDirection);
                }
            }, composer4, 0);
            EffectsKt.DisposableEffect(popupPositionProvider, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    PopupLayout.this.setPositionProvider(popupPositionProvider);
                    PopupLayout.this.updatePosition();
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            }, composer4, (i3 >> 3) & 14);
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates childCoordinates) {
                    Intrinsics.checkNotNullParameter(childCoordinates, "childCoordinates");
                    LayoutCoordinates coordinates = childCoordinates.getParentLayoutCoordinates();
                    Intrinsics.checkNotNull(coordinates);
                    long layoutSize = coordinates.mo4193getSizeYbymL2g();
                    long position = LayoutCoordinatesKt.positionInWindow(coordinates);
                    long layoutPosition = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2710getXimpl(position)), MathKt.roundToInt(Offset.m2711getYimpl(position)));
                    PopupLayout.this.setParentBounds(IntRectKt.m5368IntRectVbeCjmY(layoutPosition, layoutSize));
                    PopupLayout.this.updatePosition();
                }
            });
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(MeasureScope Layout, List<? extends Measurable> list, long j) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                    PopupLayout.this.setParentLayoutDirection(layoutDirection);
                    return MeasureScope.layout$default(Layout, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        }
                    }, 4, null);
                }
            };
            composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume5 = composer4.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Density density2 = (Density) consume5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume6 = composer4.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            LayoutDirection layoutDirection3 = (LayoutDirection) consume6;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume7 = composer4.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume7;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(onGloballyPositioned);
            int i7 = ((0 << 9) & 7168) | 6;
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor);
            } else {
                composer4.useNode();
            }
            Composer m2583constructorimpl = Updater.m2583constructorimpl(composer4);
            Updater.m2590setimpl(m2583constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl(m2583constructorimpl, density2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl(m2583constructorimpl, layoutDirection3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl(m2583constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl(composer4)), composer4, Integer.valueOf((i7 >> 3) & 112));
            composer4.startReplaceableGroup(2058660585);
            int i8 = (i7 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart(composer4, 571475810, "C:ExposedDropdownMenuPopup.kt#mqatfk");
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endReplaceableGroup();
            composer4.endNode();
            composer4.endReplaceableGroup();
            composer3 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                composer3 = composer4;
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function0<Unit> function05 = function03;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                invoke(composer5, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer5, int i9) {
                ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(function05, popupPositionProvider, content, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-483170785);
        ComposerKt.sourceInformation($composer, "CC(SimpleStack)P(1)179@6807L979:ExposedDropdownMenuPopup.kt#mqatfk");
        MeasurePolicy measurePolicy$iv = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
        int $changed$iv = (($changed >> 3) & 14) | (($changed << 3) & 112);
        $composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density$iv = (Density) consume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier);
        int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2583constructorimpl($composer);
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        $composer.startReplaceableGroup(2058660585);
        function2.invoke($composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }
}
