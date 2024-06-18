package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Box.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001aM\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\f2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0000\u001a\u001d\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0001¢\u0006\u0002\u0010 \u001a<\u0010!\u001a\u00020\u0010*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "boxChildDataNode", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "Landroidx/compose/ui/layout/Measurable;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "matchesParentSize", "", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "boxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BoxKt {
    private static final MeasurePolicy DefaultBoxMeasurePolicy = boxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
    private static final MeasurePolicy EmptyBoxMeasurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public final MeasureResult mo15measure3p2s80s(MeasureScope MeasurePolicy, List<? extends Measurable> list, long constraints) {
            Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
            Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
            return MeasureScope.layout$default(MeasurePolicy, Constraints.m5176getMinWidthimpl(constraints), Constraints.m5175getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1$measure$1
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

    public static final void Box(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Alignment contentAlignment2;
        boolean propagateMinConstraints2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            contentAlignment2 = contentAlignment;
        } else {
            contentAlignment2 = Alignment.INSTANCE.getTopStart();
        }
        if ((i & 4) == 0) {
            propagateMinConstraints2 = propagateMinConstraints;
        } else {
            propagateMinConstraints2 = false;
        }
        MeasurePolicy measurePolicy = rememberBoxMeasurePolicy(contentAlignment2, propagateMinConstraints2, $composer, (($changed >> 3) & 14) | (($changed >> 3) & 112));
        int $changed$iv = ($changed << 3) & 112;
        $composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap localMap$iv = $composer.getCurrentCompositionLocalMap();
        Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
        Function3 skippableUpdate$iv$iv = LayoutKt.modifierMaterializerOf(modifier2);
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
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!$this$Layout_u24lambda_u240$iv.getInserting() && Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
            content.invoke(BoxScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
        }
        $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
        $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        $composer.startReplaceableGroup(2058660585);
        int i22 = ($changed$iv$iv >> 9) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
        content.invoke(BoxScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints, Composer $composer, int $changed) {
        Object value$iv$iv;
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        $composer.startReplaceableGroup(56522820);
        ComposerKt.sourceInformation($composer, "C(rememberBoxMeasurePolicy)85@3660L113:Box.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56522820, $changed, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:79)");
        }
        if (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopStart()) && !propagateMinConstraints) {
            measurePolicy = DefaultBoxMeasurePolicy;
        } else {
            Object key2$iv = Boolean.valueOf(propagateMinConstraints);
            int i = ($changed & 14) | ($changed & 112);
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(alignment) | $composer.changed(key2$iv);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = boxMeasurePolicy(alignment, propagateMinConstraints);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Object key2$iv2 = value$iv$iv;
            measurePolicy = (MeasurePolicy) key2$iv2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final MeasurePolicy getDefaultBoxMeasurePolicy() {
        return DefaultBoxMeasurePolicy;
    }

    public static final MeasurePolicy boxMeasurePolicy(final Alignment alignment, final boolean propagateMinConstraints) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo15measure3p2s80s(final MeasureScope MeasurePolicy, final List<? extends Measurable> measurables, long constraints) {
                long m5164copyZbe2FdA;
                boolean matchesParentSize;
                boolean matchesParentSize2;
                boolean matchesParentSize3;
                int boxWidth;
                int boxHeight;
                Placeable placeable;
                Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (measurables.isEmpty()) {
                    return MeasureScope.layout$default(MeasurePolicy, Constraints.m5176getMinWidthimpl(constraints), Constraints.m5175getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$1
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
                if (propagateMinConstraints) {
                    m5164copyZbe2FdA = constraints;
                } else {
                    m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                }
                long contentConstraints = m5164copyZbe2FdA;
                if (measurables.size() == 1) {
                    final Measurable measurable = measurables.get(0);
                    matchesParentSize3 = BoxKt.getMatchesParentSize(measurable);
                    if (!matchesParentSize3) {
                        placeable = measurable.mo4186measureBRTryo0(contentConstraints);
                        boxWidth = Math.max(Constraints.m5176getMinWidthimpl(constraints), placeable.getWidth());
                        boxHeight = Math.max(Constraints.m5175getMinHeightimpl(constraints), placeable.getHeight());
                    } else {
                        boxWidth = Constraints.m5176getMinWidthimpl(constraints);
                        boxHeight = Constraints.m5175getMinHeightimpl(constraints);
                        placeable = measurable.mo4186measureBRTryo0(Constraints.INSTANCE.m5182fixedJhjzzOo(Constraints.m5176getMinWidthimpl(constraints), Constraints.m5175getMinHeightimpl(constraints)));
                    }
                    final Alignment alignment2 = alignment;
                    final Placeable placeable2 = placeable;
                    final int i = boxWidth;
                    final int i2 = boxHeight;
                    return MeasureScope.layout$default(MeasurePolicy, boxWidth, boxHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            BoxKt.placeInBox(layout, Placeable.this, measurable, MeasurePolicy.getLayoutDirection(), i, i2, alignment2);
                        }
                    }, 4, null);
                }
                final Placeable[] placeables = new Placeable[measurables.size()];
                final Ref.IntRef boxWidth2 = new Ref.IntRef();
                boxWidth2.element = Constraints.m5176getMinWidthimpl(constraints);
                final Ref.IntRef boxHeight2 = new Ref.IntRef();
                boxHeight2.element = Constraints.m5175getMinHeightimpl(constraints);
                int size = measurables.size();
                boolean hasMatchParentSizeChildren = false;
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = measurables.get(index$iv);
                    Measurable measurable2 = (Measurable) item$iv;
                    int index = index$iv;
                    matchesParentSize2 = BoxKt.getMatchesParentSize(measurable2);
                    if (matchesParentSize2) {
                        hasMatchParentSizeChildren = true;
                    } else {
                        Placeable placeable3 = measurable2.mo4186measureBRTryo0(contentConstraints);
                        placeables[index] = placeable3;
                        boxWidth2.element = Math.max(boxWidth2.element, placeable3.getWidth());
                        boxHeight2.element = Math.max(boxHeight2.element, placeable3.getHeight());
                    }
                }
                if (hasMatchParentSizeChildren) {
                    long matchParentSizeConstraints = ConstraintsKt.Constraints(boxWidth2.element != Integer.MAX_VALUE ? boxWidth2.element : 0, boxWidth2.element, boxHeight2.element != Integer.MAX_VALUE ? boxHeight2.element : 0, boxHeight2.element);
                    int size2 = measurables.size();
                    for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                        Object item$iv2 = measurables.get(index$iv2);
                        Measurable measurable3 = (Measurable) item$iv2;
                        int index2 = index$iv2;
                        matchesParentSize = BoxKt.getMatchesParentSize(measurable3);
                        if (matchesParentSize) {
                            placeables[index2] = measurable3.mo4186measureBRTryo0(matchParentSizeConstraints);
                        }
                    }
                }
                int i3 = boxWidth2.element;
                int i4 = boxHeight2.element;
                final Alignment alignment3 = alignment;
                return MeasureScope.layout$default(MeasurePolicy, i3, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout) {
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        Placeable[] placeableArr = placeables;
                        List<Measurable> list = measurables;
                        MeasureScope measureScope = MeasurePolicy;
                        Ref.IntRef intRef = boxWidth2;
                        Ref.IntRef intRef2 = boxHeight2;
                        Alignment alignment4 = alignment3;
                        int index$iv3 = 0;
                        int i5 = 0;
                        for (int length = placeableArr.length; i5 < length; length = length) {
                            Placeable placeable4 = placeableArr[i5];
                            int index3 = index$iv3;
                            Intrinsics.checkNotNull(placeable4, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                            Measurable measurable4 = list.get(index3);
                            BoxKt.placeInBox(layout, placeable4, measurable4, measureScope.getLayoutDirection(), intRef.element, intRef2.element, alignment4);
                            i5++;
                            index$iv3++;
                        }
                    }
                }, 4, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeInBox(Placeable.PlacementScope $this$placeInBox, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int boxWidth, int boxHeight, Alignment alignment) {
        Alignment alignment2;
        BoxChildDataNode boxChildDataNode = getBoxChildDataNode(measurable);
        Alignment childAlignment = (boxChildDataNode == null || (alignment2 = boxChildDataNode.getAlignment()) == null) ? alignment : alignment2;
        long position = childAlignment.mo2600alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(boxWidth, boxHeight), layoutDirection);
        Placeable.PlacementScope.m4243place70tqf50$default($this$placeInBox, placeable, position, 0.0f, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Box(final androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxKt.Box(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):void");
    }

    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    private static final BoxChildDataNode getBoxChildDataNode(Measurable $this$boxChildDataNode) {
        Object parentData = $this$boxChildDataNode.getParentData();
        if (parentData instanceof BoxChildDataNode) {
            return (BoxChildDataNode) parentData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable $this$matchesParentSize) {
        BoxChildDataNode boxChildDataNode = getBoxChildDataNode($this$matchesParentSize);
        if (boxChildDataNode != null) {
            return boxChildDataNode.getMatchParentSize();
        }
        return false;
    }
}
