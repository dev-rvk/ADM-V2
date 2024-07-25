package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\bH\u0002\u001aE\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuDescription", "", "expandedDescription", "collapsedDescription", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m5218constructorimpl(16);

    public static final void ExposedDropdownMenuBox(final boolean expanded, final Function1<? super Boolean, Unit> onExpandedChange, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        Object value$iv$iv4;
        FocusRequester focusRequester;
        Ref coordinates;
        final int verticalMarginInPx;
        View view;
        MutableState menuHeight$delegate;
        int i2;
        int $dirty;
        Object value$iv$iv5;
        Intrinsics.checkNotNullParameter(onExpandedChange, "onExpandedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1990697039);
        ComposerKt.sourceInformation($composer2, "C(ExposedDropdownMenuBox)P(1,3,2)106@5045L7,107@5078L7,108@5103L30,109@5156L30,111@5287L37,113@5351L29,115@5398L1392,149@6796L45,153@6858L59,153@6847L70,157@6923L379:ExposedDropdownMenu.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changedInstance(onExpandedChange) ? 32 : 16;
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
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        final int $dirty3 = $dirty2;
        if (($dirty3 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1990697039, $dirty3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:100)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) consume;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final View view2 = (View) consume2;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final MutableState width$delegate = (MutableState) value$iv$iv;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                $composer2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            final MutableState menuHeight$delegate2 = (MutableState) value$iv$iv2;
            int verticalMarginInPx2 = density.mo323roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv3 = $composer2.rememberedValue();
            if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv3 = new Ref();
                $composer2.updateRememberedValue(value$iv$iv3);
            } else {
                value$iv$iv3 = it$iv$iv3;
            }
            $composer2.endReplaceableGroup();
            final Ref coordinates2 = (Ref) value$iv$iv3;
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv4 = $composer2.rememberedValue();
            if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv4 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv$iv4);
            } else {
                value$iv$iv4 = it$iv$iv4;
            }
            $composer2.endReplaceableGroup();
            final FocusRequester focusRequester2 = (FocusRequester) value$iv$iv4;
            Object[] keys$iv = {Boolean.valueOf(expanded), onExpandedChange, density, Integer.valueOf(ExposedDropdownMenuBox$lambda$4(menuHeight$delegate2)), Integer.valueOf(ExposedDropdownMenuBox$lambda$1(width$delegate))};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Object value$iv$iv6 = $composer2.rememberedValue();
            if (invalid$iv || value$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                focusRequester = focusRequester2;
                coordinates = coordinates2;
                verticalMarginInPx = verticalMarginInPx2;
                view = view2;
                menuHeight$delegate = menuHeight$delegate2;
                i2 = 2023513938;
                $dirty = $dirty3;
                value$iv$iv6 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier menuAnchor(Modifier $this$menuAnchor) {
                        Intrinsics.checkNotNullParameter($this$menuAnchor, "<this>");
                        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                                invoke2(inspectorInfo);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InspectorInfo $this$null) {
                                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                                $this$null.setName("menuAnchor");
                            }
                        } : InspectableValueKt.getNoInspectorInfo();
                        final boolean z = expanded;
                        final Function1<Boolean, Unit> function1 = onExpandedChange;
                        final int i4 = $dirty3;
                        final FocusRequester focusRequester3 = focusRequester2;
                        final Ref<LayoutCoordinates> ref = coordinates2;
                        final View view3 = view2;
                        final int i5 = verticalMarginInPx;
                        final MutableState<Integer> mutableState = width$delegate;
                        final MutableState<Integer> mutableState2 = menuHeight$delegate2;
                        return ComposedModifierKt.composed($this$menuAnchor, noInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier4, Composer composer, Integer num) {
                                return invoke(modifier4, composer, num.intValue());
                            }

                            public final Modifier invoke(Modifier composed, Composer $composer3, int $changed2) {
                                Object value$iv$iv7;
                                Modifier expandable;
                                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                                $composer3.startReplaceableGroup(1714866713);
                                ComposerKt.sourceInformation($composer3, "C131@6216L31,129@6116L154:ExposedDropdownMenu.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1714866713, $changed2, -1, "androidx.compose.material3.ExposedDropdownMenuBox.<anonymous>.<no name provided>.menuAnchor.<anonymous> (ExposedDropdownMenu.kt:118)");
                                }
                                final Ref<LayoutCoordinates> ref2 = ref;
                                final View view4 = view3;
                                final int i6 = i5;
                                final MutableState<Integer> mutableState3 = mutableState;
                                final MutableState<Integer> mutableState4 = mutableState2;
                                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(composed, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                        invoke2(layoutCoordinates);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(LayoutCoordinates it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$2(mutableState3, IntSize.m5378getWidthimpl(it.mo4193getSizeYbymL2g()));
                                        ref2.setValue(it);
                                        View rootView = view4.getRootView();
                                        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                                        LayoutCoordinates value = ref2.getValue();
                                        int i7 = i6;
                                        final MutableState<Integer> mutableState5 = mutableState4;
                                        ExposedDropdownMenuKt.updateHeight(rootView, value, i7, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox.scope.1.1.menuAnchor.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                                invoke(num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(int newHeight) {
                                                ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableState5, newHeight);
                                            }
                                        });
                                    }
                                });
                                boolean z2 = z;
                                Object key1$iv = function1;
                                Object key2$iv = Boolean.valueOf(z);
                                final Function1<Boolean, Unit> function12 = function1;
                                final boolean z3 = z;
                                int i7 = ((i4 >> 3) & 14) | ((i4 << 3) & 112);
                                $composer3.startReplaceableGroup(511388516);
                                ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                boolean invalid$iv$iv = $composer3.changed(key1$iv) | $composer3.changed(key2$iv);
                                Object it$iv$iv5 = $composer3.rememberedValue();
                                if (invalid$iv$iv || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                                    value$iv$iv7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            function12.invoke(Boolean.valueOf(!z3));
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv$iv7);
                                } else {
                                    value$iv$iv7 = it$iv$iv5;
                                }
                                $composer3.endReplaceableGroup();
                                Object key1$iv2 = value$iv$iv7;
                                expandable = ExposedDropdownMenuKt.expandable(onGloballyPositioned, z2, (Function0) key1$iv2, null, null, null, $composer3, (i4 << 3) & 112, 28);
                                Modifier focusRequester4 = FocusRequesterModifierKt.focusRequester(expandable, focusRequester3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                $composer3.endReplaceableGroup();
                                return focusRequester4;
                            }
                        });
                    }

                    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier $this$exposedDropdownSize, boolean matchTextFieldWidth) {
                        int ExposedDropdownMenuBox$lambda$4;
                        int ExposedDropdownMenuBox$lambda$1;
                        Intrinsics.checkNotNullParameter($this$exposedDropdownSize, "<this>");
                        Density $this$exposedDropdownSize_u24lambda_u242 = density;
                        MutableState<Integer> mutableState = menuHeight$delegate2;
                        MutableState<Integer> mutableState2 = width$delegate;
                        ExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$4(mutableState);
                        Modifier it = SizeKt.m519heightInVpY3zN4$default($this$exposedDropdownSize, 0.0f, $this$exposedDropdownSize_u24lambda_u242.mo326toDpu2uoSUM(ExposedDropdownMenuBox$lambda$4), 1, null);
                        if (matchTextFieldWidth) {
                            ExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$1(mutableState2);
                            return SizeKt.m536width3ABfNKs(it, $this$exposedDropdownSize_u24lambda_u242.mo326toDpu2uoSUM(ExposedDropdownMenuBox$lambda$1));
                        }
                        return it;
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv6);
            } else {
                focusRequester = focusRequester2;
                coordinates = coordinates2;
                verticalMarginInPx = verticalMarginInPx2;
                view = view2;
                menuHeight$delegate = menuHeight$delegate2;
                $dirty = $dirty3;
                i2 = 2023513938;
            }
            $composer2.endReplaceableGroup();
            ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 scope = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) value$iv$iv6;
            int $changed$iv = ($dirty >> 6) & 14;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume3;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume4;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume5;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier3);
            int $i$f$Box = $changed$iv$iv << 9;
            int $changed$iv$iv$iv = ($i$f$Box & 7168) | 6;
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
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i5 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1004941959, "C150@6826L9:ExposedDropdownMenu.kt#uh7d8r");
            content.invoke(scope, $composer2, Integer.valueOf(($dirty >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            Object key1$iv = Boolean.valueOf(expanded);
            int i6 = ($dirty & 14) | 48;
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            final FocusRequester focusRequester3 = focusRequester;
            boolean invalid$iv$iv = $composer2.changed(key1$iv) | $composer2.changed(focusRequester3);
            Object it$iv$iv5 = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv5 = new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
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
                        if (expanded) {
                            focusRequester3.requestFocus();
                        }
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv5);
            } else {
                value$iv$iv5 = it$iv$iv5;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv5, $composer2, 0);
            final Ref coordinates3 = coordinates;
            final int verticalMarginInPx3 = verticalMarginInPx;
            final View view3 = view;
            final MutableState menuHeight$delegate3 = menuHeight$delegate;
            EffectsKt.DisposableEffect(view3, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    View view4 = view3;
                    final View view5 = view3;
                    final Ref<LayoutCoordinates> ref = coordinates3;
                    final int i7 = verticalMarginInPx3;
                    final MutableState<Integer> mutableState = menuHeight$delegate3;
                    final OnGlobalLayoutListener listener = new OnGlobalLayoutListener(view4, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1
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
                            View rootView = view5.getRootView();
                            Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
                            LayoutCoordinates value = ref.getValue();
                            int i8 = i7;
                            final MutableState<Integer> mutableState2 = mutableState;
                            ExposedDropdownMenuKt.updateHeight(rootView, value, i8, new Function1<Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int newHeight) {
                                    ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$5(mutableState2, newHeight);
                                }
                            });
                        }
                    });
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            OnGlobalLayoutListener.this.dispose();
                        }
                    };
                }
            }, $composer2, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
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

            public final void invoke(Composer composer, int i7) {
                ExposedDropdownMenuKt.ExposedDropdownMenuBox(expanded, onExpandedChange, modifier4, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableState<Integer> mutableState, int value) {
        mutableState.setValue(Integer.valueOf(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier expandable(Modifier $this$expandable, final boolean expanded, final Function0<Unit> function0, String menuDescription, String expandedDescription, String collapsedDescription, Composer $composer, int $changed, int i) {
        String expandedDescription2;
        String collapsedDescription2;
        ExposedDropdownMenuKt$expandable$1$1 value$iv$iv;
        boolean z;
        $composer.startReplaceableGroup(1006563320);
        ComposerKt.sourceInformation($composer, "C(expandable)P(1,4,3,2)1017@60116L38,1018@60190L31,1019@60258L32,1020@60315L365,1030@60691L187:ExposedDropdownMenu.kt#uh7d8r");
        String menuDescription2 = (i & 4) != 0 ? Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1762getExposedDropdownMenuadMyvUU(), $composer, 6) : menuDescription;
        if ((i & 8) == 0) {
            expandedDescription2 = expandedDescription;
        } else {
            expandedDescription2 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1764getMenuExpandedadMyvUU(), $composer, 6);
        }
        if ((i & 16) == 0) {
            collapsedDescription2 = collapsedDescription;
        } else {
            collapsedDescription2 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1763getMenuCollapsedadMyvUU(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006563320, $changed, -1, "androidx.compose.material3.expandable (ExposedDropdownMenu.kt:1014)");
        }
        Unit unit = Unit.INSTANCE;
        int i2 = ($changed >> 6) & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(function0);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new ExposedDropdownMenuKt$expandable$1$1(function0, null);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$expandable, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
        Object[] keys$iv = {Boolean.valueOf(expanded), expandedDescription2, collapsedDescription2, menuDescription2, function0};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv2 = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
            final String str = expandedDescription2;
            final String str2 = collapsedDescription2;
            final String str3 = menuDescription2;
            z = false;
            value$iv$iv2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1
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
                    SemanticsPropertiesKt.setStateDescription(semantics, expanded ? str : str2);
                    SemanticsPropertiesKt.setContentDescription(semantics, str3);
                    final Function0<Unit> function02 = function0;
                    SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            function02.invoke();
                            return true;
                        }
                    }, 1, null);
                }
            };
            $composer.updateRememberedValue(value$iv$iv2);
        } else {
            z = false;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(pointerInput, z, (Function1) value$iv$iv2, 1, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> function1) {
        if (coordinates == null) {
            return;
        }
        Rect it = new Rect();
        view.getWindowVisibleDisplayFrame(it);
        float heightAbove = LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - it.top;
        float heightBelow = (it.bottom - it.top) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom();
        function1.invoke(Integer.valueOf(((int) Math.max(heightAbove, heightBelow)) - verticalMarginInPx));
    }
}
