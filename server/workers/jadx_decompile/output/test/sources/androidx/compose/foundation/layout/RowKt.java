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

/* compiled from: Row.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowKt {
    private static final MeasurePolicy DefaultRowMeasurePolicy;

    public static /* synthetic */ void getDefaultRowMeasurePolicy$annotations() {
    }

    public static final void Row(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation($composer, "CC(Row)P(2,1,3)76@3779L58,77@3842L130:Row.kt#2w3rfo");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            horizontalArrangement2 = horizontalArrangement;
        } else {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        }
        if ((i & 4) == 0) {
            verticalAlignment2 = verticalAlignment;
        } else {
            verticalAlignment2 = Alignment.INSTANCE.getTop();
        }
        MeasurePolicy measurePolicy = rowMeasurePolicy(horizontalArrangement2, verticalAlignment2, $composer, (($changed >> 3) & 14) | (($changed >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, -326682417, "C78@3887L9:Row.kt#2w3rfo");
            content.invoke(RowScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
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
        ComposerKt.sourceInformationMarkerStart($composer, -326682417, "C78@3887L9:Row.kt#2w3rfo");
        content.invoke(RowScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 6) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
        float spacing = Arrangement.INSTANCE.getStart().getSpacing();
        CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.INSTANCE.vertical$foundation_layout_release(Alignment.INSTANCE.getTop());
        DefaultRowMeasurePolicy = RowColumnImplKt.m509rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.RowKt$DefaultRowMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
                invoke(num.intValue(), iArr, layoutDirection, density, iArr2);
                return Unit.INSTANCE;
            }

            public final void invoke(int totalSize, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                Intrinsics.checkNotNullParameter(density, "density");
                Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                Arrangement.Horizontal $this$invoke_u24lambda_u240 = Arrangement.INSTANCE.getStart();
                $this$invoke_u24lambda_u240.arrange(density, totalSize, size, layoutDirection, outPosition);
            }
        }, spacing, SizeMode.Wrap, vertical$foundation_layout_release);
    }

    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return DefaultRowMeasurePolicy;
    }

    public static final MeasurePolicy rowMeasurePolicy(final Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Composer $composer, int $changed) {
        Object value$iv$iv;
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        $composer.startReplaceableGroup(-837807694);
        ComposerKt.sourceInformation($composer, "C(rowMeasurePolicy)106@4837L639:Row.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-837807694, $changed, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:100)");
        }
        if (Intrinsics.areEqual(horizontalArrangement, Arrangement.INSTANCE.getStart()) && Intrinsics.areEqual(verticalAlignment, Alignment.INSTANCE.getTop())) {
            measurePolicy = DefaultRowMeasurePolicy;
        } else {
            int i = ($changed & 14) | ($changed & 112);
            $composer.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(horizontalArrangement) | $composer.changed(verticalAlignment);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                float spacing = horizontalArrangement.getSpacing();
                CrossAxisAlignment vertical$foundation_layout_release = CrossAxisAlignment.INSTANCE.vertical$foundation_layout_release(verticalAlignment);
                value$iv$iv = RowColumnImplKt.m509rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.RowKt$rowMeasurePolicy$1$1
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
                        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                        Intrinsics.checkNotNullParameter(density, "density");
                        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                        Arrangement.Horizontal $this$invoke_u24lambda_u240 = Arrangement.Horizontal.this;
                        $this$invoke_u24lambda_u240.arrange(density, totalSize, size, layoutDirection, outPosition);
                    }
                }, spacing, SizeMode.Wrap, vertical$foundation_layout_release);
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
