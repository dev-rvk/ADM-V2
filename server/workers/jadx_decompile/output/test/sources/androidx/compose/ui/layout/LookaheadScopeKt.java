package androidx.compose.ui.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadScope.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001aR\u0010\u000f\u001a\u00020\t*\u00020\t2A\u0010\u0010\u001a=\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\u0002\b\u0007H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"LookaheadLayout", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "LookaheadScope", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "intermediateLayout", "measure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LookaheadScopeKt {
    @Deprecated(message = "LookaheadLayout has been replaced with LookaheadScope that does not require a Modifier or a MeasurePolicy.", replaceWith = @ReplaceWith(expression = "LookaheadScope { Layout(content = { content() }, \n modifier = modifier, measurePolicy = measurePolicy) }", imports = {}))
    public static final void LookaheadLayout(final Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> content, final Modifier modifier, final MeasurePolicy measurePolicy, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(1551346597);
        ComposerKt.sourceInformation($composer2, "C(LookaheadLayout)P(!1,2)51@1893L160:LookaheadScope.kt#80mrfh");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(measurePolicy) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1551346597, $dirty, -1, "androidx.compose.ui.layout.LookaheadLayout (LookaheadScope.kt:46)");
            }
            LookaheadScope(ComposableLambdaKt.composableLambda($composer2, 1705879204, true, new Function3<LookaheadScope, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadLayout$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LookaheadScope lookaheadScope, Composer composer, Integer num) {
                    invoke(lookaheadScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:31:0x013d  */
                /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void invoke(androidx.compose.ui.layout.LookaheadScope r24, androidx.compose.runtime.Composer r25, int r26) {
                    /*
                        Method dump skipped, instructions count: 321
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadLayout$1.invoke(androidx.compose.ui.layout.LookaheadScope, androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier2 = modifier;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadLayout$2
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
                LookaheadScopeKt.LookaheadLayout(content, modifier2, measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void LookaheadScope(final Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1078066484);
        ComposerKt.sourceInformation(startRestartGroup, "C(LookaheadScope)111@4255L33,112@4293L484:LookaheadScope.kt#80mrfh");
        int i2 = i;
        if ((i & 14) == 0) {
            i2 |= startRestartGroup.changedInstance(content) ? 4 : 2;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1078066484, i2, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:110)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new LookaheadScopeImpl(null, 1, 0 == true ? 1 : 0);
                startRestartGroup.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            startRestartGroup.endReplaceableGroup();
            LookaheadScopeImpl lookaheadScopeImpl = (LookaheadScopeImpl) obj;
            LookaheadScopeKt$LookaheadScope$1 lookaheadScopeKt$LookaheadScope$1 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final LayoutNode invoke() {
                    return new LayoutNode(true, 0, 2, null);
                }
            };
            startRestartGroup.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(lookaheadScopeKt$LookaheadScope$1);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2583constructorimpl = Updater.m2583constructorimpl(startRestartGroup);
            Updater.m2587initimpl(m2583constructorimpl, new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
                    invoke2(layoutNode);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode init) {
                    Intrinsics.checkNotNullParameter(init, "$this$init");
                    init.setVirtualLookaheadRoot$ui_release(true);
                }
            });
            Updater.m2590setimpl(m2583constructorimpl, lookaheadScopeImpl, new Function2<LayoutNode, LookaheadScopeImpl, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LookaheadScopeImpl lookaheadScopeImpl2) {
                    invoke2(layoutNode, lookaheadScopeImpl2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final LayoutNode set, LookaheadScopeImpl scope) {
                    Intrinsics.checkNotNullParameter(set, "$this$set");
                    Intrinsics.checkNotNullParameter(scope, "scope");
                    scope.setScopeCoordinates(new Function0<LayoutCoordinates>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$2$2.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LayoutCoordinates invoke() {
                            LayoutNode parent$ui_release = LayoutNode.this.getParent$ui_release();
                            Intrinsics.checkNotNull(parent$ui_release);
                            return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
                        }
                    });
                }
            });
            int i3 = (6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1223115506, "C124@4752L9:LookaheadScope.kt#80mrfh");
            content.invoke(lookaheadScopeImpl, startRestartGroup, Integer.valueOf(((i2 << 3) & 112) | 8));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadScopeKt$LookaheadScope$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                LookaheadScopeKt.LookaheadScope(content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final Modifier intermediateLayout(Modifier $this$intermediateLayout, Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measure) {
        Intrinsics.checkNotNullParameter($this$intermediateLayout, "<this>");
        Intrinsics.checkNotNullParameter(measure, "measure");
        return $this$intermediateLayout.then(new IntermediateLayoutElement(measure));
    }
}
