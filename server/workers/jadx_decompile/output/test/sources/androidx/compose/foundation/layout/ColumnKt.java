package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Column.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"DefaultColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy$annotations", "()V", "getDefaultColumnMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Column", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ColumnKt {
    private static final MeasurePolicy DefaultColumnMeasurePolicy;

    public static /* synthetic */ void getDefaultColumnMeasurePolicy$annotations() {
    }

    public static final void Column(Modifier modifier, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-483455358);
        ComposerKt.sourceInformation($composer, "CC(Column)P(2,3,1)75@3779L61,76@3845L133:Column.kt#2w3rfo");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            verticalArrangement2 = verticalArrangement;
        } else {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        }
        if ((i & 4) == 0) {
            horizontalAlignment2 = horizontalAlignment;
        } else {
            horizontalAlignment2 = Alignment.INSTANCE.getStart();
        }
        MeasurePolicy measurePolicy = columnMeasurePolicy(verticalArrangement2, horizontalAlignment2, $composer, (($changed >> 3) & 14) | (($changed >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, 276693570, "C77@3893L9:Column.kt#2w3rfo");
            content.invoke(ColumnScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
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
        ComposerKt.sourceInformationMarkerStart($composer, 276693570, "C77@3893L9:Column.kt#2w3rfo");
        content.invoke(ColumnScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
        float spacing = Arrangement.INSTANCE.getTop().getSpacing();
        CrossAxisAlignment horizontal$foundation_layout_release = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout_release(Alignment.INSTANCE.getStart());
        DefaultColumnMeasurePolicy = RowColumnImplKt.m509rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.ColumnKt$DefaultColumnMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
                invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
                return Unit.INSTANCE;
            }

            public final void invoke(int totalSize, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(density, "density");
                Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                Arrangement.Vertical $this$invoke_u24lambda_u240 = Arrangement.INSTANCE.getTop();
                $this$invoke_u24lambda_u240.arrange(density, totalSize, size, outPosition);
            }
        }, spacing, SizeMode.Wrap, horizontal$foundation_layout_release);
    }

    public static final MeasurePolicy getDefaultColumnMeasurePolicy() {
        return DefaultColumnMeasurePolicy;
    }

    public static final MeasurePolicy columnMeasurePolicy(final Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, Composer $composer, int $changed) {
        Object value$iv$iv;
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        $composer.startReplaceableGroup(1089876336);
        ComposerKt.sourceInformation($composer, "C(columnMeasurePolicy)P(1)102@4720L562:Column.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1089876336, $changed, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:96)");
        }
        if (Intrinsics.areEqual(verticalArrangement, Arrangement.INSTANCE.getTop()) && Intrinsics.areEqual(horizontalAlignment, Alignment.INSTANCE.getStart())) {
            measurePolicy = DefaultColumnMeasurePolicy;
        } else {
            int i = ($changed & 14) | ($changed & 112);
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(verticalArrangement) | $composer.changed(horizontalAlignment);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
                float spacing = verticalArrangement.getSpacing();
                CrossAxisAlignment horizontal$foundation_layout_release = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout_release(horizontalAlignment);
                value$iv$iv = RowColumnImplKt.m509rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.ColumnKt$columnMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(5);
                    }

                    @Override // kotlin.jvm.functions.Function5
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
                        invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int totalSize, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
                        Intrinsics.checkNotNullParameter(size, "size");
                        Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                        Intrinsics.checkNotNullParameter(density, "density");
                        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                        Arrangement.Vertical $this$invoke_u24lambda_u240 = Arrangement.Vertical.this;
                        $this$invoke_u24lambda_u240.arrange(density, totalSize, size, outPosition);
                    }
                }, spacing, SizeMode.Wrap, horizontal$foundation_layout_release);
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) value$iv$iv;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }
}
