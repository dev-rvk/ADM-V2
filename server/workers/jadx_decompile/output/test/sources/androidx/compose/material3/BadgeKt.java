package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Badge.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0019\u0010\t\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"BadgeOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeOffset", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class BadgeKt {
    private static final float BadgeOffset;
    private static final float BadgeWithContentHorizontalOffset;
    private static final float BadgeWithContentHorizontalPadding = Dp.m5218constructorimpl(4);
    private static final float BadgeWithContentVerticalOffset;

    public static final void BadgedBox(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> badge, Modifier modifier, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(badge, "badge");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer3 = $composer.startRestartGroup(1404022535);
        ComposerKt.sourceInformation($composer3, "C(BadgedBox)P(!1,2)66@2566L2114:Badge.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changedInstance(badge) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(content) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404022535, $dirty2, -1, "androidx.compose.material3.BadgedBox (Badge.kt:61)");
            }
            MeasurePolicy measurePolicy$iv = new MeasurePolicy() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo15measure3p2s80s(final MeasureScope Layout, List<? extends Measurable> measurables, long constraints) {
                    long m5164copyZbe2FdA;
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                    List<? extends Measurable> $this$first$iv = measurables;
                    for (Object element$iv : $this$first$iv) {
                        Measurable it = (Measurable) element$iv;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "badge")) {
                            m5164copyZbe2FdA = Constraints.m5164copyZbe2FdA(constraints, (r12 & 1) != 0 ? Constraints.m5176getMinWidthimpl(constraints) : 0, (r12 & 2) != 0 ? Constraints.m5174getMaxWidthimpl(constraints) : 0, (r12 & 4) != 0 ? Constraints.m5175getMinHeightimpl(constraints) : 0, (r12 & 8) != 0 ? Constraints.m5173getMaxHeightimpl(constraints) : 0);
                            final Placeable badgePlaceable = ((Measurable) element$iv).mo4186measureBRTryo0(m5164copyZbe2FdA);
                            List<? extends Measurable> $this$first$iv2 = measurables;
                            for (Object element$iv2 : $this$first$iv2) {
                                Measurable it2 = (Measurable) element$iv2;
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "anchor")) {
                                    final Placeable anchorPlaceable = ((Measurable) element$iv2).mo4186measureBRTryo0(constraints);
                                    int firstBaseline = anchorPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                    int lastBaseline = anchorPlaceable.get(AlignmentLineKt.getLastBaseline());
                                    int totalWidth = anchorPlaceable.getWidth();
                                    int totalHeight = anchorPlaceable.getHeight();
                                    return Layout.layout(totalWidth, totalHeight, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(firstBaseline)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(lastBaseline))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$2$measure$1
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
                                            boolean hasContent = Placeable.this.getWidth() > Layout.mo323roundToPx0680j_4(BadgeTokens.INSTANCE.m2013getSizeD9Ej5fM());
                                            float badgeHorizontalOffset = hasContent ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
                                            float badgeVerticalOffset = hasContent ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
                                            Placeable.PlacementScope.placeRelative$default(layout, anchorPlaceable, 0, 0, 0.0f, 4, null);
                                            int badgeX = anchorPlaceable.getWidth() + Layout.mo323roundToPx0680j_4(badgeHorizontalOffset);
                                            int badgeY = ((-Placeable.this.getHeight()) / 2) + Layout.mo323roundToPx0680j_4(badgeVerticalOffset);
                                            Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, badgeX, badgeY, 0.0f, 4, null);
                                        }
                                    });
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            };
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier4);
            int $changed$iv$iv = ((($dirty2 & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2583constructorimpl($composer3);
            modifier3 = modifier4;
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1541063998, "C68@2596L161,73@2770L105:Badge.kt#uh7d8r");
            Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.INSTANCE, "anchor");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            int $i$f$Layout = $dirty2 << 3;
            int $changed$iv = ($i$f$Layout & 7168) | 54;
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume4;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(localViewConfiguration2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (((($changed$iv << 3) & 112) << 9) & 7168) | 6;
            $composer2 = $composer3;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            content.invoke(BoxScopeInstance.INSTANCE, $composer3, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "badge");
            int $changed$iv2 = (($dirty2 << 9) & 7168) | 6;
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer3.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv2 = (Density) consume7;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer3.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer3.consume(localViewConfiguration3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
            int $changed$iv$iv$iv2 = (((($changed$iv2 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer3);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            badge.invoke(BoxScopeInstance.INSTANCE, $composer3, Integer.valueOf((($changed$iv2 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$BadgedBox$3
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

            public final void invoke(Composer composer, int i6) {
                BadgeKt.BadgedBox(badge, modifier5, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: Badge-eopBjH0, reason: not valid java name */
    public static final void m1310BadgeeopBjH0(Modifier modifier, long containerColor, long contentColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        final Function3 content;
        Modifier.Companion modifier3;
        long containerColor2;
        Shape shape;
        Modifier modifier4;
        long contentColor3;
        Function3 content2;
        long containerColor3;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(1298144073);
        ComposerKt.sourceInformation($composer2, "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)141@5648L14,142@5690L31,153@6032L1119:Badge.kt#uh7d8r");
        final int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 112) == 0) {
            if ((i & 2) == 0) {
                j = containerColor;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = containerColor;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = containerColor;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            content = function3;
        } else if (($changed & 7168) == 0) {
            content = function3;
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        } else {
            content = function3;
        }
        if (($dirty & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            contentColor3 = contentColor2;
            content2 = content;
            containerColor3 = j;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 2) != 0) {
                    containerColor2 = BadgeDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    containerColor2 = j;
                }
                if ((i & 4) != 0) {
                    long contentColor4 = ColorSchemeKt.m1414contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 3) & 14);
                    $dirty &= -897;
                    contentColor2 = contentColor4;
                }
                if (i5 != 0) {
                    content = null;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                containerColor2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298144073, $dirty, -1, "androidx.compose.material3.Badge (Badge.kt:139)");
            }
            BadgeTokens badgeTokens = BadgeTokens.INSTANCE;
            float size = content != null ? badgeTokens.m2012getLargeSizeD9Ej5fM() : badgeTokens.m2013getSizeD9Ej5fM();
            if (content != null) {
                $composer2.startReplaceableGroup(1947275116);
                ComposerKt.sourceInformation($composer2, "147@5933L9");
                shape = ShapesKt.toShape(BadgeTokens.INSTANCE.getLargeShape(), $composer2, 6);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(1947275170);
                ComposerKt.sourceInformation($composer2, "149@5982L9");
                shape = ShapesKt.toShape(BadgeTokens.INSTANCE.getShape(), $composer2, 6);
                $composer2.endReplaceableGroup();
            }
            Modifier then = ClipKt.clip(BackgroundKt.m162backgroundbw27NRU(SizeKt.m515defaultMinSizeVpY3zN4(modifier3, size, size), containerColor2, shape), shape).then(content != null ? PaddingKt.m486paddingVpY3zN4$default(Modifier.INSTANCE, BadgeWithContentHorizontalPadding, 0.0f, 2, null) : Modifier.INSTANCE);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(center, centerVertically, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            modifier4 = modifier3;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            long containerColor4 = containerColor2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(then);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
            int i6 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            final int $changed2 = ((432 >> 6) & 112) | 6;
            final RowScope $this$Badge_eopBjH0_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -193559524, "C:Badge.kt#uh7d8r");
            $composer2.startReplaceableGroup(1947275771);
            ComposerKt.sourceInformation($composer2, "170@6681L454");
            if (content != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2))}, ComposableLambdaKt.composableLambda($composer2, 5609066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$1$1
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

                    public final void invoke(Composer $composer3, int $changed3) {
                        ComposerKt.sourceInformation($composer3, "C174@6872L10,177@7007L114:Badge.kt#uh7d8r");
                        if (($changed3 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(5609066, $changed3, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:172)");
                            }
                            TextStyle style = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), BadgeTokens.INSTANCE.getLargeLabelTextFont()), false);
                            final Function3<RowScope, Composer, Integer, Unit> function32 = content;
                            final RowScope rowScope = $this$Badge_eopBjH0_u24lambda_u241;
                            final int i7 = $changed2;
                            final int i8 = $dirty;
                            TextKt.ProvideTextStyle(style, ComposableLambdaKt.composableLambda($composer3, -1175098791, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$1$1.1
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

                                public final void invoke(Composer $composer4, int $changed4) {
                                    ComposerKt.sourceInformation($composer4, "C179@7092L9:Badge.kt#uh7d8r");
                                    if (($changed4 & 11) == 2 && $composer4.getSkipping()) {
                                        $composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1175098791, $changed4, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous>.<anonymous> (Badge.kt:179)");
                                    }
                                    function32.invoke(rowScope, $composer4, Integer.valueOf((i7 & 14) | ((i8 >> 6) & 112)));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), $composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, 56);
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentColor3 = contentColor2;
            content2 = content;
            containerColor3 = containerColor4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final long j2 = containerColor3;
        final long j3 = contentColor3;
        final Function3 function32 = content2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BadgeKt$Badge$2
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
                BadgeKt.m1310BadgeeopBjH0(Modifier.this, j2, j3, function32, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    static {
        float arg0$iv = Dp.m5218constructorimpl(4);
        BadgeWithContentHorizontalOffset = Dp.m5218constructorimpl(-arg0$iv);
        float arg0$iv2 = Dp.m5218constructorimpl(4);
        BadgeWithContentVerticalOffset = Dp.m5218constructorimpl(-arg0$iv2);
        BadgeOffset = Dp.m5218constructorimpl(0);
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }
}
