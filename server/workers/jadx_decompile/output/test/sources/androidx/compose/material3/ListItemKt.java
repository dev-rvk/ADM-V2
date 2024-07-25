package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a¬\u0001\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u007f\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\u001c\u0010!\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\"¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a8\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a<\u0010-\u001a\u00020\t*\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a<\u00102\u001a\u00020\t*\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00101\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"ContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingContentEndPadding", "ListItemHorizontalPadding", "ListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "TrailingHorizontalPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "minHeight", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ListItem-xOgov6c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ProvideTextStyleFromToken", "color", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "LeadingContent", "topAlign", "", "LeadingContent-3IgeMak", "(Landroidx/compose/foundation/layout/RowScope;JZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TrailingContent", "TrailingContent-3IgeMak", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ListItemKt {
    private static final float ListItemVerticalPadding = Dp.m5218constructorimpl(8);
    private static final float ListItemThreeLineVerticalPadding = Dp.m5218constructorimpl(16);
    private static final float ListItemHorizontalPadding = Dp.m5218constructorimpl(16);
    private static final float LeadingContentEndPadding = Dp.m5218constructorimpl(16);
    private static final float ContentEndPadding = Dp.m5218constructorimpl(8);
    private static final float TrailingHorizontalPadding = Dp.m5218constructorimpl(8);

    /* renamed from: ListItem-HXNGIdc, reason: not valid java name */
    public static final void m1577ListItemHXNGIdc(final Function2<? super Composer, ? super Integer, Unit> headlineContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, ListItemColors colors, float tonalElevation, float shadowElevation, Composer $composer, final int $changed, final int i) {
        Function2 function25;
        Function2 function26;
        Modifier.Companion modifier2;
        Function2 overlineContent;
        Function2 supportingContent;
        Function2 leadingContent;
        Function2 trailingContent;
        final ListItemColors colors2;
        float tonalElevation2;
        float shadowElevation2;
        final Function2 it;
        Function2 decoratedSupportingContent;
        Function2 overlineContent2;
        Function2 decoratedOverlineContent;
        Function2 leadingContent2;
        final Function3 decoratedLeadingContent;
        final Function3 decoratedTrailingContent;
        Function2 supportingContent2;
        Function2 overlineContent3;
        Function2 leadingContent3;
        float tonalElevation3;
        Modifier modifier3;
        float shadowElevation3;
        Function2 trailingContent2;
        ListItemColors colors3;
        int i2;
        Intrinsics.checkNotNullParameter(headlineContent, "headlineContent");
        Composer $composer2 = $composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation($composer2, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)80@3784L8,155@6557L16,156@6611L29,153@6486L1021:ListItem.kt#uh7d8r");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(headlineContent) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            function25 = function23;
        } else if (($changed & 57344) == 0) {
            function25 = function23;
            $dirty |= $composer2.changedInstance(function25) ? 16384 : 8192;
        } else {
            function25 = function23;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function26 = function24;
        } else if (($changed & 458752) == 0) {
            function26 = function24;
            $dirty |= $composer2.changedInstance(function26) ? 131072 : 65536;
        } else {
            function26 = function24;
        }
        if (($changed & 3670016) == 0) {
            if ((i & 64) == 0 && $composer2.changed(colors)) {
                i2 = 1048576;
                $dirty |= i2;
            }
            i2 = 524288;
            $dirty |= i2;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(tonalElevation) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer2.changed(shadowElevation) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 191739611) == 38347922 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier;
            overlineContent3 = function2;
            colors3 = colors;
            tonalElevation3 = tonalElevation;
            shadowElevation3 = shadowElevation;
            trailingContent2 = function26;
            leadingContent3 = function25;
            supportingContent2 = function22;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier2 = i3 != 0 ? Modifier.INSTANCE : modifier;
                overlineContent = i4 != 0 ? null : function2;
                supportingContent = i5 != 0 ? null : function22;
                leadingContent = i6 != 0 ? null : function25;
                trailingContent = i7 != 0 ? null : function26;
                if ((i & 64) != 0) {
                    colors2 = ListItemDefaults.INSTANCE.m1574colorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty &= -3670017;
                } else {
                    colors2 = colors;
                }
                tonalElevation2 = i8 != 0 ? ListItemDefaults.INSTANCE.m1575getElevationD9Ej5fM() : tonalElevation;
                shadowElevation2 = i9 != 0 ? ListItemDefaults.INSTANCE.m1575getElevationD9Ej5fM() : shadowElevation;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty &= -3670017;
                }
                modifier2 = modifier;
                overlineContent = function2;
                supportingContent = function22;
                tonalElevation2 = tonalElevation;
                shadowElevation2 = shadowElevation;
                trailingContent = function26;
                leadingContent = function25;
                colors2 = colors;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1647707763, $dirty, -1, "androidx.compose.material3.ListItem (ListItem.kt:73)");
            }
            final Function2 decoratedHeadlineContent = ComposableLambdaKt.composableLambda($composer2, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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
                    ComposerKt.sourceInformation($composer3, "C86@4020L29,85@3974L166:ListItem.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-403249643, $changed2, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:84)");
                        }
                        ListItemKt.m1579ProvideTextStyleFromToken3JVO9M(ListItemColors.this.headlineColor$material3_release(true, $composer3, (($dirty >> 15) & 112) | 6).getValue().m2959unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), headlineContent, $composer3, (($dirty << 6) & 896) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            });
            if (supportingContent != null) {
                it = supportingContent;
                decoratedSupportingContent = ComposableLambdaKt.composableLambda($composer2, -1020860251, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
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
                        ComposerKt.sourceInformation($composer3, "C94@4320L17,93@4270L162:ListItem.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1020860251, $changed2, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:92)");
                            }
                            ListItemKt.m1579ProvideTextStyleFromToken3JVO9M(ListItemColors.this.supportingColor$material3_release($composer3, ($dirty >> 18) & 14).getValue().m2959unboximpl(), ListTokens.INSTANCE.getListItemSupportingTextFont(), it, $composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                it = supportingContent;
                decoratedSupportingContent = null;
            }
            if (overlineContent != null) {
                final Function2 it2 = overlineContent;
                overlineContent2 = overlineContent;
                decoratedOverlineContent = ComposableLambdaKt.composableLambda($composer2, -764441232, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
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
                        ComposerKt.sourceInformation($composer3, "C103@4618L15,102@4568L154:ListItem.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-764441232, $changed2, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:101)");
                            }
                            ListItemKt.m1579ProvideTextStyleFromToken3JVO9M(ListItemColors.this.overlineColor$material3_release($composer3, ($dirty >> 18) & 14).getValue().m2959unboximpl(), ListTokens.INSTANCE.getListItemOverlineFont(), it2, $composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                overlineContent2 = overlineContent;
                decoratedOverlineContent = null;
            }
            final int listItemType = ListItemType.INSTANCE.m1594getListItemType7AlIA9s$material3_release(decoratedOverlineContent != null, decoratedSupportingContent != null);
            if (leadingContent != null) {
                final Function2 it3 = leadingContent;
                leadingContent2 = leadingContent;
                decoratedLeadingContent = ComposableLambdaKt.composableLambda($composer2, 1673725255, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope $this$null, Composer $composer3, int $changed2) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        ComposerKt.sourceInformation($composer3, "C118@5083L32,117@5029L203:ListItem.kt#uh7d8r");
                        int $dirty2 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty2 |= $composer3.changed($this$null) ? 4 : 2;
                        }
                        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1673725255, $dirty2, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:116)");
                            }
                            ListItemKt.m1576LeadingContent3IgeMak($this$null, ListItemColors.this.leadingIconColor$material3_release(true, $composer3, (($dirty >> 15) & 112) | 6).getValue().m2959unboximpl(), ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()), it3, $composer3, $dirty2 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                leadingContent2 = leadingContent;
                decoratedLeadingContent = null;
            }
            if (trailingContent != null) {
                final Function2 it4 = trailingContent;
                decoratedTrailingContent = ComposableLambdaKt.composableLambda($composer2, 1392069445, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope $this$null, Composer $composer3, int $changed2) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        ComposerKt.sourceInformation($composer3, "C128@5421L33,127@5366L205:ListItem.kt#uh7d8r");
                        int $dirty2 = $changed2;
                        if (($changed2 & 14) == 0) {
                            $dirty2 |= $composer3.changed($this$null) ? 4 : 2;
                        }
                        if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1392069445, $dirty2, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:126)");
                            }
                            ListItemKt.m1580TrailingContent3IgeMak($this$null, ListItemColors.this.trailingIconColor$material3_release(true, $composer3, (($dirty >> 15) & 112) | 6).getValue().m2959unboximpl(), ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()), it4, $composer3, $dirty2 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                });
            } else {
                decoratedTrailingContent = null;
            }
            float minHeight = ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1595getOneLineAlXitO8()) ? ListTokens.INSTANCE.m2274getListItemOneLineContainerHeightD9Ej5fM() : ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1597getTwoLineAlXitO8()) ? ListTokens.INSTANCE.m2278getListItemTwoLineContainerHeightD9Ej5fM() : ListTokens.INSTANCE.m2276getListItemThreeLineContainerHeightD9Ej5fM();
            PaddingValues outerPaddingValues = PaddingKt.m478PaddingValuesYgX7TsA(ListItemHorizontalPadding, ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()) ? ListItemThreeLineVerticalPadding : ListItemVerticalPadding);
            final PaddingValues contentPaddingValues = PaddingKt.m481PaddingValuesa9UjIt4$default(0.0f, 0.0f, ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()) ? ContentEndPadding : Dp.m5218constructorimpl(0), 0.0f, 11, null);
            final Arrangement.Vertical columnArrangement = ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()) ? Arrangement.INSTANCE.getTop() : Arrangement.INSTANCE.getCenter();
            final Alignment.Vertical boxAlignment = ListItemType.m1589equalsimpl0(listItemType, ListItemType.INSTANCE.m1596getThreeLineAlXitO8()) ? Alignment.INSTANCE.getTop() : Alignment.INSTANCE.getCenterVertically();
            final Function2 function27 = decoratedOverlineContent;
            final Function2 function28 = decoratedSupportingContent;
            m1578ListItemxOgov6c(modifier2, null, colors2.containerColor$material3_release($composer2, ($dirty >> 18) & 14).getValue().m2959unboximpl(), colors2.headlineColor$material3_release(true, $composer2, (($dirty >> 15) & 112) | 6).getValue().m2959unboximpl(), tonalElevation2, shadowElevation2, minHeight, outerPaddingValues, ComposableLambdaKt.composableLambda($composer2, -1813277157, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope ListItem, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(ListItem, "$this$ListItem");
                    ComposerKt.sourceInformation($composer3, "C165@6917L487,181@7465L26:ListItem.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(ListItem) ? 4 : 2;
                    }
                    int $dirty3 = $dirty2;
                    if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1813277157, $dirty3, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:161)");
                        }
                        $composer3.startReplaceableGroup(1316674963);
                        ComposerKt.sourceInformation($composer3, "163@6873L25");
                        if (decoratedLeadingContent != null) {
                            decoratedLeadingContent.invoke(ListItem, $composer3, Integer.valueOf($dirty3 & 14));
                        }
                        $composer3.endReplaceableGroup();
                        Modifier modifier$iv = ListItem.align(PaddingKt.padding(RowScope.weight$default(ListItem, Modifier.INSTANCE, 1.0f, false, 2, null), contentPaddingValues), boxAlignment);
                        Arrangement.Vertical verticalArrangement$iv = columnArrangement;
                        Function2<Composer, Integer, Unit> function29 = function27;
                        Function2<Composer, Integer, Unit> function210 = decoratedHeadlineContent;
                        Function2<Composer, Integer, Unit> function211 = function28;
                        $composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i10 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i11 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 984343928, "C175@7255L26:ListItem.kt#uh7d8r");
                        $composer3.startReplaceableGroup(984343928);
                        ComposerKt.sourceInformation($composer3, "173@7202L26");
                        if (function29 != null) {
                            function29.invoke($composer3, 0);
                        }
                        $composer3.endReplaceableGroup();
                        function210.invoke($composer3, 6);
                        $composer3.startReplaceableGroup(1316675435);
                        ComposerKt.sourceInformation($composer3, "177@7352L28");
                        if (function211 != null) {
                            function211.invoke($composer3, 0);
                        }
                        $composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (decoratedTrailingContent != null) {
                            decoratedTrailingContent.invoke(ListItem, $composer3, Integer.valueOf($dirty3 & 14));
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 100663296 | (($dirty >> 9) & 57344) | (($dirty >> 9) & 458752), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            supportingContent2 = it;
            overlineContent3 = overlineContent2;
            leadingContent3 = leadingContent2;
            tonalElevation3 = tonalElevation2;
            modifier3 = modifier2;
            shadowElevation3 = shadowElevation2;
            trailingContent2 = trailingContent;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final Function2 function29 = overlineContent3;
        final Function2 function210 = supportingContent2;
        final Function2 function211 = leadingContent3;
        final Function2 function212 = trailingContent2;
        final ListItemColors listItemColors = colors3;
        final float f = tonalElevation3;
        final float f2 = shadowElevation3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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

            public final void invoke(Composer composer, int i10) {
                ListItemKt.m1577ListItemHXNGIdc(headlineContent, modifier4, function29, function210, function211, function212, listItemColors, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0109  */
    /* renamed from: ListItem-xOgov6c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1578ListItemxOgov6c(androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, float r36, final float r37, final androidx.compose.foundation.layout.PaddingValues r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.m1578ListItemxOgov6c(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LeadingContent-3IgeMak, reason: not valid java name */
    public static final void m1576LeadingContent3IgeMak(final RowScope $this$LeadingContent_u2d3IgeMak, final long contentColor, final boolean topAlign, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1383930970);
        ComposerKt.sourceInformation($composer2, "C(LeadingContent)P(1:c#ui.graphics.Color,2)236@9308L274:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$LeadingContent_u2d3IgeMak) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(topAlign) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1383930970, $dirty2, -1, "androidx.compose.material3.LeadingContent (ListItem.kt:232)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor))}, ComposableLambdaKt.composableLambda($composer2, 315166618, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$LeadingContent$1
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
                    float f;
                    ComposerKt.sourceInformation($composer3, "C237@9384L192:ListItem.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(315166618, $changed2, -1, "androidx.compose.material3.LeadingContent.<anonymous> (ListItem.kt:236)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f = ListItemKt.LeadingContentEndPadding;
                        Modifier modifier$iv = PaddingKt.m488paddingqDBjuR0$default(companion, 0.0f, 0.0f, f, 0.0f, 11, null).then(!topAlign ? $this$LeadingContent_u2d3IgeMak.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()) : Modifier.INSTANCE);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        int i = $dirty2;
                        $composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume = $composer3.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv = (Density) consume;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = $composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer3.consume(localViewConfiguration);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                        int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
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
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i2 = ($changed$iv$iv$iv >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i3 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -161018455, "C241@9565L9:ListItem.kt#uh7d8r");
                        function22.invoke($composer3, Integer.valueOf((i >> 9) & 14));
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 56);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$LeadingContent$2
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

            public final void invoke(Composer composer, int i) {
                ListItemKt.m1576LeadingContent3IgeMak(RowScope.this, contentColor, topAlign, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TrailingContent-3IgeMak, reason: not valid java name */
    public static final void m1580TrailingContent3IgeMak(final RowScope $this$TrailingContent_u2d3IgeMak, final long contentColor, final boolean topAlign, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1404787004);
        ComposerKt.sourceInformation($composer2, "C(TrailingContent)P(1:c#ui.graphics.Color,2)249@9723L316:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed($this$TrailingContent_u2d3IgeMak) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(topAlign) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404787004, $dirty2, -1, "androidx.compose.material3.TrailingContent (ListItem.kt:245)");
            }
            Modifier m486paddingVpY3zN4$default = PaddingKt.m486paddingVpY3zN4$default(Modifier.INSTANCE, TrailingHorizontalPadding, 0.0f, 2, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (!topAlign) {
                companion = $this$TrailingContent_u2d3IgeMak.align(companion, Alignment.INSTANCE.getCenterVertically());
            }
            Modifier modifier$iv = m486paddingVpY3zN4$default.then(companion);
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
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
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
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
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1419469451, "C254@9892L141:ListItem.kt#uh7d8r");
            m1579ProvideTextStyleFromToken3JVO9M(contentColor, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function2, $composer2, (($dirty2 >> 3) & 14) | 48 | (($dirty2 >> 3) & 896));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            boolean propagateMinConstraints$iv = ComposerKt.isTraceInProgress();
            if (propagateMinConstraints$iv) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$TrailingContent$2
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
                ListItemKt.m1580TrailingContent3IgeMak(RowScope.this, contentColor, topAlign, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final void m1579ProvideTextStyleFromToken3JVO9M(final long color, final TypographyKeyTokens textToken, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation($composer2, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)394@15546L10,395@15582L111:ListItem.kt#uh7d8r");
        final int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(textToken) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, $dirty, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:389)");
            }
            final TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), textToken);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(color))}, ComposableLambdaKt.composableLambda($composer2, -514310925, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
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
                    ComposerKt.sourceInformation($composer3, "C396@15651L36:ListItem.kt#uh7d8r");
                    if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-514310925, $changed2, -1, "androidx.compose.material3.ProvideTextStyleFromToken.<anonymous> (ListItem.kt:395)");
                    }
                    TextKt.ProvideTextStyle(TextStyle.this, function2, $composer3, ($dirty >> 3) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), $composer2, 56);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$2
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

            public final void invoke(Composer composer, int i) {
                ListItemKt.m1579ProvideTextStyleFromToken3JVO9M(color, textToken, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }
}
