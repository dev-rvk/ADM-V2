package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: FlowLayout.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aW\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aW\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\u001a\u001a\u009d\u0001\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2*\u0010\u001e\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012*\u0010(\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b*\u0010+\u001a4\u0010,\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a4\u0010-\u001a&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0080\u0001\u0010.\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112#\u0010%\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aF\u0010.\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020 2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001aS\u00109\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a\u0080\u0001\u0010;\u001a\u00020\f2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002#\u00102\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112#\u0010%\u001a\u001f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f03¢\u0006\u0002\b\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0002\u001a%\u0010<\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010=\u001a9\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u0019\u001a\u00020\fH\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bE\u0010F\u001a\u001c\u0010G\u001a\u00020\f*\u00020H2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\fH\u0000\u001a\u0014\u0010%\u001a\u00020\f*\u00020I2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\u001c\u0010J\u001a\u00020\f*\u00020H2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\fH\u0000\u001a\u0014\u00102\u001a\u00020\f*\u00020I2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a?\u0010K\u001a\u00020\f*\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010L\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010I\u0012\u0004\u0012\u00020\u00040\u000eH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bM\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006O"}, d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "flowMeasurePolicy", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "mainAxisArrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "mainAxisArrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "crossAxisArrangement", "crossAxisArrangementSpacing", "flowMeasurePolicy-bs7tm-s", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Lkotlin/jvm/functions/Function5;FI)Landroidx/compose/ui/layout/MeasurePolicy;", "getHorizontalArrangement", "getVerticalArrangement", "intrinsicCrossAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "mainAxisSizes", "crossAxisSizes", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measureHelper", "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;Landroidx/compose/foundation/layout/LayoutOrientation;JI)Landroidx/compose/foundation/layout/FlowResult;", "crossAxisMin", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "mainAxisMin", "measureAndCache", "storePlaceable", "measureAndCache-6m2dt9o", "(Landroidx/compose/ui/layout/Measurable;JLandroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function1;)I", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout_release(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout_release(Alignment.INSTANCE.getStart());

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Horizontal horizontalArrangement2;
        Arrangement.Vertical verticalArrangement2;
        int maxItemsInEachRow2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(1098475987);
        ComposerKt.sourceInformation($composer, "CC(FlowRow)P(3,1,4,2)61@2468L113,66@2586L134:FlowLayout.kt#2w3rfo");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            horizontalArrangement2 = horizontalArrangement;
        } else {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        }
        if ((i & 4) == 0) {
            verticalArrangement2 = verticalArrangement;
        } else {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        }
        if ((i & 8) == 0) {
            maxItemsInEachRow2 = maxItemsInEachRow;
        } else {
            maxItemsInEachRow2 = Integer.MAX_VALUE;
        }
        MeasurePolicy measurePolicy = rowMeasurementHelper(horizontalArrangement2, verticalArrangement2, maxItemsInEachRow2, $composer, (($changed >> 3) & 14) | (($changed >> 3) & 112) | (($changed >> 3) & 896));
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
            ComposerKt.sourceInformationMarkerStart($composer, 483375157, "C67@2635L9:FlowLayout.kt#2w3rfo");
            content.invoke(FlowRowScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 9) & 112) | 6));
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
        ComposerKt.sourceInformationMarkerStart($composer, 483375157, "C67@2635L9:FlowLayout.kt#2w3rfo");
        content.invoke(FlowRowScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInEachColumn, Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Arrangement.Vertical verticalArrangement2;
        Arrangement.Horizontal horizontalArrangement2;
        int maxItemsInEachColumn2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-310290901);
        ComposerKt.sourceInformation($composer, "CC(FlowColumn)P(3,4,1,2)111@4318L119,116@4442L137:FlowLayout.kt#2w3rfo");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            verticalArrangement2 = verticalArrangement;
        } else {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        }
        if ((i & 4) == 0) {
            horizontalArrangement2 = horizontalArrangement;
        } else {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        }
        if ((i & 8) == 0) {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        } else {
            maxItemsInEachColumn2 = Integer.MAX_VALUE;
        }
        MeasurePolicy measurePolicy = columnMeasurementHelper(verticalArrangement2, horizontalArrangement2, maxItemsInEachColumn2, $composer, (($changed >> 3) & 14) | (($changed >> 3) & 112) | (($changed >> 3) & 896));
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
            ComposerKt.sourceInformationMarkerStart($composer, -681937527, "C117@4494L9:FlowLayout.kt#2w3rfo");
            content.invoke(FlowColumnScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 9) & 112) | 6));
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
        ComposerKt.sourceInformationMarkerStart($composer, -681937527, "C117@4494L9:FlowLayout.kt#2w3rfo");
        content.invoke(FlowColumnScopeInstance.INSTANCE, $composer, Integer.valueOf((($changed >> 9) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getVerticalArrangement(final Arrangement.Vertical verticalArrangement) {
        return new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$getVerticalArrangement$1
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
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getHorizontalArrangement(final Arrangement.Horizontal horizontalArrangement) {
        return new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$getHorizontalArrangement$1
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
        };
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        $composer.startReplaceableGroup(1479255111);
        ComposerKt.sourceInformation($composer, "C(rowMeasurementHelper)P(!1,2)168@6017L633:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, $changed, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:163)");
        }
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(horizontalArrangement) | $composer.changed(verticalArrangement) | $composer.changed(key3$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = m432flowMeasurePolicybs7tms(LayoutOrientation.Horizontal, getHorizontalArrangement(horizontalArrangement), horizontalArrangement.getSpacing(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_TOP, getVerticalArrangement(verticalArrangement), verticalArrangement.getSpacing(), maxItemsInMainAxis);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        $composer.startReplaceableGroup(-2013098357);
        ComposerKt.sourceInformation($composer, "C(columnMeasurementHelper)P(2)189@6875L634:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, $changed, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:184)");
        }
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i = ($changed & 14) | ($changed & 112) | ($changed & 896);
        $composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(verticalArrangement) | $composer.changed(horizontalArrangement) | $composer.changed(key3$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = m432flowMeasurePolicybs7tms(LayoutOrientation.Vertical, getVerticalArrangement(verticalArrangement), verticalArrangement.getSpacing(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_START, getHorizontalArrangement(horizontalArrangement), horizontalArrangement.getSpacing(), maxItemsInMainAxis);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flowMeasurePolicy-bs7tm-s, reason: not valid java name */
    public static final MeasurePolicy m432flowMeasurePolicybs7tms(final LayoutOrientation orientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, final float mainAxisArrangementSpacing, final SizeMode crossAxisSize, final CrossAxisAlignment crossAxisAlignment, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function52, final float crossAxisArrangementSpacing, final int maxItemsInMainAxis) {
        return new MeasurePolicy(function5, mainAxisArrangementSpacing, crossAxisSize, crossAxisAlignment, maxItemsInMainAxis, crossAxisArrangementSpacing, function52) { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1
            final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
            final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $crossAxisArrangement;
            final /* synthetic */ float $crossAxisArrangementSpacing;
            final /* synthetic */ SizeMode $crossAxisSize;
            final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $mainAxisArrangement;
            final /* synthetic */ float $mainAxisArrangementSpacing;
            final /* synthetic */ int $maxItemsInMainAxis;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$mainAxisArrangement = function5;
                this.$mainAxisArrangementSpacing = mainAxisArrangementSpacing;
                this.$crossAxisSize = crossAxisSize;
                this.$crossAxisAlignment = crossAxisAlignment;
                this.$maxItemsInMainAxis = maxItemsInMainAxis;
                this.$crossAxisArrangementSpacing = crossAxisArrangementSpacing;
                this.$crossAxisArrangement = function52;
                this.maxMainAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.maxIntrinsicWidth(h));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.maxIntrinsicHeight(w));
                    }
                };
                this.maxCrossAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.maxIntrinsicHeight(w));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.maxIntrinsicWidth(h));
                    }
                };
                this.minCrossAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.minIntrinsicHeight(w));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.minIntrinsicWidth(h));
                    }
                };
                this.minMainAxisIntrinsicItemSize = LayoutOrientation.this == LayoutOrientation.Horizontal ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.minIntrinsicWidth(h));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                        return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
                    }

                    public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        return Integer.valueOf($this$null.minIntrinsicHeight(w));
                    }
                };
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo15measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
                int layoutWidth;
                int layoutHeight;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (measurables.isEmpty()) {
                    return MeasureScope.layout$default(measure, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$measure$1
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
                Placeable[] placeables = new Placeable[measurables.size()];
                final RowColumnMeasurementHelper measureHelper = new RowColumnMeasurementHelper(LayoutOrientation.this, this.$mainAxisArrangement, this.$mainAxisArrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, measurables, placeables, null);
                long orientationIndependentConstraints = OrientationIndependentConstraints.m453constructorimpl(constraints, LayoutOrientation.this);
                final FlowResult flowResult = FlowLayoutKt.m431breakDownItemsw1Onq5I(measure, measureHelper, LayoutOrientation.this, orientationIndependentConstraints, this.$maxItemsInMainAxis);
                MutableVector items = flowResult.getItems();
                int size = items.getSize();
                int[] crossAxisSizes = new int[size];
                for (int i = 0; i < size; i++) {
                    crossAxisSizes[i] = items.getContent()[i].getCrossAxisSize();
                }
                final int[] outPosition = new int[crossAxisSizes.length];
                int totalCrossAxisSize = flowResult.getCrossAxisTotalSize();
                int totalCrossAxisSpacing = measure.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing) * (items.getSize() - 1);
                int totalCrossAxisSize2 = totalCrossAxisSize + totalCrossAxisSpacing;
                this.$crossAxisArrangement.invoke(Integer.valueOf(totalCrossAxisSize2), crossAxisSizes, measure.getLayoutDirection(), measure, outPosition);
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    layoutWidth = flowResult.getMainAxisTotalSize();
                    layoutHeight = totalCrossAxisSize2;
                } else {
                    layoutWidth = totalCrossAxisSize2;
                    layoutHeight = flowResult.getMainAxisTotalSize();
                }
                return MeasureScope.layout$default(measure, ConstraintsKt.m5188constrainWidthK40F9xA(constraints, layoutWidth), ConstraintsKt.m5187constrainHeightK40F9xA(constraints, layoutHeight), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$measure$2
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
                        MutableVector this_$iv = FlowResult.this.getItems();
                        RowColumnMeasurementHelper rowColumnMeasurementHelper = measureHelper;
                        int[] iArr = outPosition;
                        MeasureScope measureScope = measure;
                        int size$iv = this_$iv.getSize();
                        if (size$iv <= 0) {
                            return;
                        }
                        int i$iv = 0;
                        Object[] content$iv = this_$iv.getContent();
                        do {
                            RowColumnMeasureHelperResult measureResult = (RowColumnMeasureHelperResult) content$iv[i$iv];
                            int currentRowOrColumnIndex = i$iv;
                            rowColumnMeasurementHelper.placeHelper(layout, measureResult, iArr[currentRowOrColumnIndex], measureScope.getLayoutDirection());
                            i$iv++;
                        } while (i$iv < size$iv);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return minIntrinsicMainAxisSize(measurables, height, $this$minIntrinsicWidth.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicWidth.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
                }
                return intrinsicCrossAxisSize(measurables, height, $this$minIntrinsicWidth.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicWidth.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return intrinsicCrossAxisSize(measurables, width, $this$minIntrinsicHeight.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicHeight.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
                }
                return minIntrinsicMainAxisSize(measurables, width, $this$minIntrinsicHeight.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$minIntrinsicHeight.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return intrinsicCrossAxisSize(measurables, width, $this$maxIntrinsicHeight.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$maxIntrinsicHeight.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
                }
                return maxIntrinsicMainAxisSize(measurables, width, $this$maxIntrinsicHeight.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
                Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    return maxIntrinsicMainAxisSize(measurables, height, $this$maxIntrinsicWidth.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing));
                }
                return intrinsicCrossAxisSize(measurables, height, $this$maxIntrinsicWidth.mo323roundToPx0680j_4(this.$mainAxisArrangementSpacing), $this$maxIntrinsicWidth.mo323roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }

            public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing) {
                int minIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                minIntrinsicMainAxisSize = FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, this.$maxItemsInMainAxis);
                return minIntrinsicMainAxisSize;
            }

            public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
                int maxIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                maxIntrinsicMainAxisSize = FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.$maxItemsInMainAxis);
                return maxIntrinsicMainAxisSize;
            }

            public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing) {
                int intrinsicCrossAxisSize;
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                intrinsicCrossAxisSize = FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) measurables, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, this.$maxItemsInMainAxis);
                return intrinsicCrossAxisSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
                return this.maxMainAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
                return this.maxCrossAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
                return this.minCrossAxisIntrinsicItemSize;
            }

            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
                return this.minMainAxisIntrinsicItemSize;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int fixedSpace = 0;
        int currentFixedSpace = 0;
        int lastBreak = 0;
        int size = list.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = list.get(index$iv);
            IntrinsicMeasurable child = (IntrinsicMeasurable) item$iv;
            int index = index$iv;
            int size2 = function3.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue() + mainAxisSpacing;
            if ((index + 1) - lastBreak == maxItemsInMainAxis || index + 1 == list.size()) {
                lastBreak = index;
                fixedSpace = Math.max(fixedSpace, (currentFixedSpace + size2) - mainAxisSpacing);
                currentFixedSpace = 0;
            } else {
                currentFixedSpace += size2;
            }
        }
        return fixedSpace;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlin.collections.IntIterator] */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        int size = list.size();
        int[] mainAxisSizes = new int[size];
        for (int i = 0; i < size; i++) {
            mainAxisSizes[i] = 0;
        }
        int size2 = list.size();
        int[] crossAxisSizes = new int[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            crossAxisSizes[i2] = 0;
        }
        int size3 = list.size();
        for (int index = 0; index < size3; index++) {
            IntrinsicMeasurable child = list.get(index);
            int mainAxisItemSize = function3.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue();
            mainAxisSizes[index] = mainAxisItemSize;
            crossAxisSizes[index] = function32.invoke(child, Integer.valueOf(index), Integer.valueOf(mainAxisItemSize)).intValue();
        }
        int maxMainAxisSize = ArraysKt.sum(mainAxisSizes);
        int mainAxisUsed = maxMainAxisSize;
        if (crossAxisSizes.length == 0) {
            throw new NoSuchElementException();
        }
        int crossAxisUsed = crossAxisSizes[0];
        ?? it = new IntRange(1, ArraysKt.getLastIndex(crossAxisSizes)).iterator();
        while (it.hasNext()) {
            int it2 = crossAxisSizes[it.nextInt()];
            if (crossAxisUsed < it2) {
                crossAxisUsed = it2;
            }
        }
        if (mainAxisSizes.length == 0) {
            throw new NoSuchElementException();
        }
        int minimumItemSize = mainAxisSizes[0];
        ?? it3 = new IntRange(1, ArraysKt.getLastIndex(mainAxisSizes)).iterator();
        while (it3.hasNext()) {
            int it4 = mainAxisSizes[it3.nextInt()];
            if (minimumItemSize < it4) {
                minimumItemSize = it4;
            }
        }
        int low = minimumItemSize;
        int crossAxisUsed2 = crossAxisUsed;
        int low2 = low;
        int high = maxMainAxisSize;
        while (low2 < high) {
            if (crossAxisUsed2 == crossAxisAvailable) {
                return mainAxisUsed;
            }
            int mid = (low2 + high) / 2;
            int high2 = high;
            int low3 = low2;
            crossAxisUsed2 = intrinsicCrossAxisSize(list, mainAxisSizes, crossAxisSizes, mid, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis);
            if (crossAxisUsed2 == crossAxisAvailable) {
                return mid;
            }
            if (crossAxisUsed2 > crossAxisAvailable) {
                low2 = mid + 1;
                mainAxisUsed = mid;
                high = high2;
            } else {
                high = mid - 1;
                mainAxisUsed = mid;
                low2 = low3;
            }
        }
        return mainAxisUsed;
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] mainAxisSizes, final int[] crossAxisSizes, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicCrossAxisSize, int index, int i) {
                Intrinsics.checkNotNullParameter(intrinsicCrossAxisSize, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(mainAxisSizes[index]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicCrossAxisSize, int index, int i) {
                Intrinsics.checkNotNullParameter(intrinsicCrossAxisSize, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(crossAxisSizes[index]);
            }
        }, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis) {
        List<? extends IntrinsicMeasurable> list2 = list;
        if (list.isEmpty()) {
            return 0;
        }
        Object nextChild = CollectionsKt.getOrNull(list2, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) nextChild;
        int nextCrossAxisSize = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(mainAxisAvailable)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) nextChild;
        int nextMainAxisSize = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, 0, Integer.valueOf(nextCrossAxisSize)).intValue() : 0;
        int remaining = mainAxisAvailable;
        int currentCrossAxisSize = 0;
        int totalCrossAxisSize = 0;
        int lastBreak = 0;
        int index$iv = 0;
        int size = list.size();
        while (index$iv < size) {
            Object item$iv = list.get(index$iv);
            int index = index$iv;
            Intrinsics.checkNotNull(nextChild);
            int childCrossAxisSize = nextCrossAxisSize;
            int childMainAxisSize = nextMainAxisSize;
            remaining -= childMainAxisSize;
            currentCrossAxisSize = Math.max(currentCrossAxisSize, childCrossAxisSize);
            nextChild = CollectionsKt.getOrNull(list2, index + 1);
            IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) nextChild;
            nextCrossAxisSize = intrinsicMeasurable3 != null ? function32.invoke(intrinsicMeasurable3, Integer.valueOf(index + 1), Integer.valueOf(mainAxisAvailable)).intValue() : 0;
            IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) nextChild;
            int nextMainAxisSize2 = intrinsicMeasurable4 != null ? function3.invoke(intrinsicMeasurable4, Integer.valueOf(index + 1), Integer.valueOf(nextCrossAxisSize)).intValue() + mainAxisSpacing : 0;
            if (remaining >= 0 && index + 1 != list.size()) {
                if ((index + 1) - lastBreak != maxItemsInMainAxis && remaining - nextMainAxisSize2 >= 0) {
                    index$iv++;
                    nextMainAxisSize = nextMainAxisSize2;
                    list2 = list;
                }
            }
            totalCrossAxisSize += currentCrossAxisSize + crossAxisSpacing;
            remaining = mainAxisAvailable;
            int lastBreak2 = index + 1;
            nextMainAxisSize2 -= mainAxisSpacing;
            lastBreak = lastBreak2;
            currentCrossAxisSize = 0;
            index$iv++;
            nextMainAxisSize = nextMainAxisSize2;
            list2 = list;
        }
        return totalCrossAxisSize - crossAxisSpacing;
    }

    /* renamed from: breakDownItems-w1Onq5I, reason: not valid java name */
    public static final FlowResult m431breakDownItemsw1Onq5I(MeasureScope breakDownItems, RowColumnMeasurementHelper measureHelper, LayoutOrientation orientation, long constraints, int maxItemsInMainAxis) {
        long m454copyyUG9Ft0;
        int mainAxisMin;
        Integer nextSize;
        Intrinsics.checkNotNullParameter(breakDownItems, "$this$breakDownItems");
        Intrinsics.checkNotNullParameter(measureHelper, "measureHelper");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        MutableVector items = new MutableVector(new RowColumnMeasureHelperResult[16], 0);
        int m5174getMaxWidthimpl = Constraints.m5174getMaxWidthimpl(constraints);
        int mainAxisMin2 = Constraints.m5176getMinWidthimpl(constraints);
        int crossAxisMax = Constraints.m5173getMaxHeightimpl(constraints);
        List measurables = measureHelper.getMeasurables();
        final Placeable[] placeables = measureHelper.getPlaceables();
        int spacing = (int) Math.ceil(breakDownItems.mo329toPx0680j_4(measureHelper.getArrangementSpacing()));
        long subsetConstraints = OrientationIndependentConstraints.m451constructorimpl(mainAxisMin2, m5174getMaxWidthimpl, 0, crossAxisMax);
        Measurable measurable = (Measurable) CollectionsKt.getOrNull(measurables, 0);
        Integer nextSize2 = measurable != null ? Integer.valueOf(m433measureAndCache6m2dt9o(measurable, subsetConstraints, orientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                invoke2(placeable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable placeable) {
                placeables[0] = placeable;
            }
        })) : null;
        int startBreakLineIndex = 0;
        Integer[] endBreakLineList = new Integer[measurables.size()];
        int size = measurables.size();
        Integer nextSize3 = nextSize2;
        int endBreakLineIndex = 0;
        int leftOver = m5174getMaxWidthimpl;
        int mainAxisTotalSize = mainAxisMin2;
        int currentLineMainAxisSize = 0;
        final int index = 0;
        while (index < size) {
            Intrinsics.checkNotNull(nextSize3);
            int itemMainAxisSize = nextSize3.intValue();
            int i = size;
            int currentLineMainAxisSize2 = currentLineMainAxisSize + itemMainAxisSize;
            leftOver -= itemMainAxisSize;
            Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(measurables, index + 1);
            if (measurable2 != null) {
                mainAxisMin = mainAxisMin2;
                nextSize = Integer.valueOf(m433measureAndCache6m2dt9o(measurable2, subsetConstraints, orientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                        invoke2(placeable);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable placeable) {
                        placeables[index + 1] = placeable;
                    }
                }) + spacing);
            } else {
                mainAxisMin = mainAxisMin2;
                nextSize = null;
            }
            int crossAxisMax2 = crossAxisMax;
            if (index + 1 < measurables.size() && (index + 1) - startBreakLineIndex < maxItemsInMainAxis) {
                if (leftOver - (nextSize != null ? nextSize.intValue() : 0) >= 0) {
                    currentLineMainAxisSize = currentLineMainAxisSize2;
                    nextSize3 = nextSize;
                    index++;
                    size = i;
                    mainAxisMin2 = mainAxisMin;
                    crossAxisMax = crossAxisMax2;
                }
            }
            mainAxisTotalSize = Math.min(Math.max(mainAxisTotalSize, currentLineMainAxisSize2), m5174getMaxWidthimpl);
            startBreakLineIndex = index + 1;
            endBreakLineList[endBreakLineIndex] = Integer.valueOf(index + 1);
            endBreakLineIndex++;
            currentLineMainAxisSize = 0;
            nextSize3 = nextSize != null ? Integer.valueOf(nextSize.intValue() - spacing) : null;
            leftOver = m5174getMaxWidthimpl;
            index++;
            size = i;
            mainAxisMin2 = mainAxisMin;
            crossAxisMax = crossAxisMax2;
        }
        m454copyyUG9Ft0 = OrientationIndependentConstraints.m454copyyUG9Ft0(subsetConstraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(subsetConstraints) : mainAxisTotalSize, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(subsetConstraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(subsetConstraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(subsetConstraints) : 0);
        long subsetBoxConstraints = OrientationIndependentConstraints.m466toBoxConstraintsOenEA2s(m454copyyUG9Ft0, orientation);
        int crossAxisTotalSize = 0;
        int endBreakLineIndex2 = 0;
        Integer endIndex = (Integer) ArraysKt.getOrNull(endBreakLineList, 0);
        int mainAxisTotalSize2 = mainAxisTotalSize;
        int startBreakLineIndex2 = 0;
        while (endIndex != null) {
            long subsetConstraints2 = subsetConstraints;
            RowColumnMeasureHelperResult result = measureHelper.m511measureWithoutPlacing_EkL_Y(breakDownItems, subsetBoxConstraints, startBreakLineIndex2, endIndex.intValue());
            crossAxisTotalSize += result.getCrossAxisSize();
            mainAxisTotalSize2 = Math.max(mainAxisTotalSize2, result.getMainAxisSize());
            items.add(result);
            startBreakLineIndex2 = endIndex.intValue();
            int endBreakLineIndex3 = endBreakLineIndex2 + 1;
            endIndex = (Integer) ArraysKt.getOrNull(endBreakLineList, endBreakLineIndex3);
            endBreakLineIndex2 = endBreakLineIndex3;
            subsetConstraints = subsetConstraints2;
        }
        return new FlowResult(Math.max(mainAxisTotalSize2, Constraints.m5176getMinWidthimpl(constraints)), Math.max(crossAxisTotalSize, Constraints.m5175getMinHeightimpl(constraints)), items);
    }

    public static final int mainAxisMin(Measurable $this$mainAxisMin, LayoutOrientation orientation, int crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$mainAxisMin.minIntrinsicWidth(crossAxisSize);
        }
        return $this$mainAxisMin.minIntrinsicHeight(crossAxisSize);
    }

    public static final int crossAxisMin(Measurable $this$crossAxisMin, LayoutOrientation orientation, int mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$crossAxisMin.minIntrinsicHeight(mainAxisSize);
        }
        return $this$crossAxisMin.minIntrinsicWidth(mainAxisSize);
    }

    public static final int mainAxisSize(Placeable $this$mainAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public static final int crossAxisSize(Placeable $this$crossAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* renamed from: measureAndCache-6m2dt9o, reason: not valid java name */
    private static final int m433measureAndCache6m2dt9o(Measurable $this$measureAndCache_u2d6m2dt9o, long constraints, LayoutOrientation orientation, Function1<? super Placeable, Unit> function1) {
        long m454copyyUG9Ft0;
        if (!(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData($this$measureAndCache_u2d6m2dt9o)) == 0.0f)) {
            int itemSize = mainAxisMin($this$measureAndCache_u2d6m2dt9o, orientation, Integer.MAX_VALUE);
            return itemSize;
        }
        m454copyyUG9Ft0 = OrientationIndependentConstraints.m454copyyUG9Ft0(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
        Placeable placeable = $this$measureAndCache_u2d6m2dt9o.mo4186measureBRTryo0(OrientationIndependentConstraints.m466toBoxConstraintsOenEA2s(m454copyyUG9Ft0, orientation));
        function1.invoke(placeable);
        int itemSize2 = mainAxisSize(placeable, orientation);
        return itemSize2;
    }
}
