package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\b¢\u0006\u0002\u0010\u000b\u001a>\u0010\u0000\u001a\u00020\u00012\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\u0087\b¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0013\u001a6\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a6\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u001a\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutKt {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0094, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r11.rememberedValue(), java.lang.Integer.valueOf(r5)) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Layout(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.layout.MeasurePolicy r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            java.lang.String r3 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r23 & 2
            if (r4 == 0) goto L26
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.INSTANCE
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L28
        L26:
            r4 = r19
        L28:
            r5 = 0
            int r5 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r2, r5)
            androidx.compose.runtime.CompositionLocalMap r6 = r21.getCurrentCompositionLocalMap()
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r8 = modifierMaterializerOf(r4)
            int r9 = r22 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r10 = 0
            androidx.compose.runtime.Applier r11 = r21.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L4f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L4f:
            r21.startReusableNode()
            boolean r11 = r21.getInserting()
            if (r11 == 0) goto L5c
            r2.createNode(r7)
            goto L5f
        L5c:
            r21.useNode()
        L5f:
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2583constructorimpl(r21)
            r12 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2590setimpl(r11, r1, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetResolvedCompositionLocals()
            androidx.compose.runtime.Updater.m2590setimpl(r11, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.getSetCompositeKeyHash()
            r14 = 0
            r15 = r11
            r16 = 0
            boolean r17 = r15.getInserting()
            if (r17 != 0) goto L97
            java.lang.Object r1 = r15.rememberedValue()
            r17 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto La7
            goto L99
        L97:
            r17 = r3
        L99:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.updateRememberedValue(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r11.apply(r1, r13)
        La7:
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2575constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2574boximpl(r1)
            int r3 = r9 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r8.invoke(r1, r2, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r9 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r2, r1)
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        $composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        Modifier materialized = ComposedModifierKt.materializeModifier($composer, modifier2);
        CompositionLocalMap localMap = $composer.getCurrentCompositionLocalMap();
        final Function0 factory$iv = ComposeUiNode.INSTANCE.getConstructor();
        $composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation($composer, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.ui.layout.LayoutKt$Layout$$inlined$ReusableComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final ComposeUiNode invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u241 = Updater.m2583constructorimpl($composer);
        Updater.m2590setimpl($this$Layout_u24lambda_u241, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2590setimpl($this$Layout_u24lambda_u241, localMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m2590setimpl($this$Layout_u24lambda_u241, materialized, ComposeUiNode.INSTANCE.getSetModifier());
        Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if ($this$Layout_u24lambda_u241.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u241.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
            $this$Layout_u24lambda_u241.updateRememberedValue(Integer.valueOf(compositeKeyHash));
            $this$Layout_u24lambda_u241.apply(Integer.valueOf(compositeKeyHash), block$iv);
        }
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents, Modifier modifier, MultiContentMeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(contents, "contents");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        $composer.startReplaceableGroup(1399185516);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
        Modifier.Companion modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        Function2 content$iv = combineAsVirtualLayouts(contents);
        int i2 = ($changed >> 6) & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(measurePolicy);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv$iv;
        int $changed$iv = $changed & 112;
        $composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv = modifierMaterializerOf(modifier2);
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
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!$this$Layout_u24lambda_u240$iv.getInserting() && Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer.startReplaceableGroup(2058660585);
            content$iv.invoke($composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
        }
        $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        $composer.startReplaceableGroup(2058660585);
        content$iv.invoke($composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(final List<? extends Function2<? super Composer, ? super Integer, Unit>> contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$combineAsVirtualLayouts$1
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

            public final void invoke(Composer $composer, int $changed) {
                List $this$fastForEach$iv;
                ComposerKt.sourceInformation($composer, "C*180@7168L23,181@7200L298:Layout.kt#80mrfh");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953651383, $changed, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:178)");
                    }
                    List $this$fastForEach$iv2 = contents;
                    int index$iv = 0;
                    int size = $this$fastForEach$iv2.size();
                    while (index$iv < size) {
                        Object item$iv = $this$fastForEach$iv2.get(index$iv);
                        Function2 content = (Function2) item$iv;
                        int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        Function0 factory$iv = ComposeUiNode.INSTANCE.getVirtualConstructor();
                        $composer.startReplaceableGroup(-692256719);
                        ComposerKt.sourceInformation($composer, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(factory$iv);
                        } else {
                            $composer.useNode();
                        }
                        Composer $this$invoke_u24lambda_u241_u24lambda_u240 = Updater.m2583constructorimpl($composer);
                        Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$invoke_u24lambda_u241_u24lambda_u240.getInserting()) {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                        } else {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            if (Intrinsics.areEqual($this$invoke_u24lambda_u241_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                                content.invoke($composer, Integer.valueOf((6 >> 6) & 14));
                                $composer.endNode();
                                $composer.endReplaceableGroup();
                                index$iv++;
                                $this$fastForEach$iv2 = $this$fastForEach$iv;
                            }
                        }
                        $this$invoke_u24lambda_u241_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                        $this$invoke_u24lambda_u241_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                        content.invoke($composer, Integer.valueOf((6 >> 6) & 14));
                        $composer.endNode();
                        $composer.endReplaceableGroup();
                        index$iv++;
                        $this$fastForEach$iv2 = $this$fastForEach$iv;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        });
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                m4200invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m4200invokeDeg8D_g(Composer $this$null, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                ComposerKt.sourceInformation($composer, "C202@7952L23:Layout.kt#80mrfh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1586257396, $changed, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:201)");
                }
                int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                Modifier materialized = ComposedModifierKt.materializeModifier($composer, Modifier.this);
                $this$null.startReplaceableGroup(509942095);
                Composer $this$invoke_Deg8D_g_u24lambda_u240 = Updater.m2583constructorimpl($this$null);
                Updater.m2590setimpl($this$invoke_Deg8D_g_u24lambda_u240, materialized, ComposeUiNode.INSTANCE.getSetModifier());
                Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$invoke_Deg8D_g_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$invoke_Deg8D_g_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                    $this$invoke_Deg8D_g_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                    $this$invoke_Deg8D_g_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                }
                $this$null.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOfWithCompositionLocalInjection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                m4201invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m4201invokeDeg8D_g(Composer $this$null, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                ComposerKt.sourceInformation($composer, "C225@8792L23:Layout.kt#80mrfh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55743822, $changed, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:224)");
                }
                int compositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                Modifier materialized = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal($composer, Modifier.this);
                $this$null.startReplaceableGroup(509942095);
                Composer $this$invoke_Deg8D_g_u24lambda_u240 = Updater.m2583constructorimpl($this$null);
                Updater.m2590setimpl($this$invoke_Deg8D_g_u24lambda_u240, materialized, ComposeUiNode.INSTANCE.getSetModifier());
                Function2 block$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$invoke_Deg8D_g_u24lambda_u240.getInserting() || !Intrinsics.areEqual($this$invoke_Deg8D_g_u24lambda_u240.rememberedValue(), Integer.valueOf(compositeKeyHash))) {
                    $this$invoke_Deg8D_g_u24lambda_u240.updateRememberedValue(Integer.valueOf(compositeKeyHash));
                    $this$invoke_Deg8D_g_u24lambda_u240.apply(Integer.valueOf(compositeKeyHash), block$iv);
                }
                $this$null.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0155  */
    @kotlin.Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MultiMeasureLayout(androidx.compose.ui.Modifier r18, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, final androidx.compose.ui.layout.MeasurePolicy r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }
}
