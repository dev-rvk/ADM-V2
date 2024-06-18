package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001aå\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u000204H\u0002\u001aÛ\u0001\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001aå\u0001\u00106\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020!21\u0010\"\u001a-\u0012\u0004\u0012\u00020$\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b0#¢\u0006\u0002\b&¢\u0006\u0002\b'H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a\u0017\u0010=\u001a\u00020\b2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0082\b\u001a\f\u0010A\u001a\u000204*\u00020\nH\u0002\u001a\f\u0010B\u001a\u00020\u0004*\u00020\nH\u0002\u001a!\u0010C\u001a\u00020\f*\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010E\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006F"}, d2 = {"ConsumeHorizontalFlingNestedScrollConnection", "Landroidx/compose/foundation/pager/ConsumeAllFlingOnDirection;", "ConsumeVerticalFlingNestedScrollConnection", "DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "pageCount", "HorizontalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-AlbwjTQ", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerKt {
    private static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);
    private static final ConsumeAllFlingOnDirection ConsumeVerticalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Vertical);
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;

    /* renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    public static final void m695HorizontalPagerxYaah8o(final PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PageSize pageSize2;
        int i2;
        Alignment.Vertical vertical;
        int i3;
        int i4;
        int $dirty;
        PaddingValues contentPadding2;
        int $dirty1;
        Composer $composer2;
        int i5;
        int i6;
        int i7;
        int i8;
        SnapFlingBehavior flingBehavior2;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        Function1 key;
        int beyondBoundsPageCount2;
        Alignment.Vertical verticalAlignment2;
        int $dirty2;
        int $dirty12;
        NestedScrollConnection pageNestedScrollConnection2;
        boolean reverseLayout2;
        Modifier modifier3;
        float pageSpacing2;
        PageSize pageSize3;
        int i9;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(1491175841);
        ComposerKt.sourceInformation($composer3, "C(HorizontalPager)P(10,4,1,7!1,8:c#ui.unit.Dp,12!1,11,9!1,6)113@6091L28,122@6441L620:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(state) ? 4 : 2;
        }
        int i10 = i & 2;
        if (i10 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty3 |= 3072;
            pageSize2 = pageSize;
        } else if (($changed & 7168) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer3.changed(pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i13 = i & 16;
        if (i13 != 0) {
            $dirty3 |= 24576;
            i2 = beyondBoundsPageCount;
        } else if (($changed & 57344) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i14 = i & 32;
        if (i14 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(pageSpacing) ? 131072 : 65536;
        }
        int i15 = i & 64;
        if (i15 != 0) {
            $dirty3 |= 1572864;
            vertical = verticalAlignment;
        } else if (($changed & 3670016) == 0) {
            vertical = verticalAlignment;
            $dirty3 |= $composer3.changed(vertical) ? 1048576 : 524288;
        } else {
            vertical = verticalAlignment;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(flingBehavior)) {
                i9 = 8388608;
                $dirty3 |= i9;
            }
            i9 = 4194304;
            $dirty3 |= i9;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty3 |= 100663296;
            i3 = i16;
        } else if (($changed & 234881024) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i17;
        } else {
            if (($changed & 1879048192) == 0) {
                i4 = i17;
                $dirty3 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            } else {
                i4 = i17;
            }
            $dirty = $dirty3;
        }
        int $dirty4 = i & 1024;
        if ($dirty4 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty13 |= 16;
        }
        if ((i & 4096) != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(pageContent) ? 256 : 128;
        }
        if (i18 == 2048 && ($dirty & 1533916891) == 306783378 && ($dirty13 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            pageSpacing2 = pageSpacing;
            flingBehavior3 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            key = function1;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            verticalAlignment2 = vertical;
            modifier3 = modifier2;
            pageSize3 = pageSize2;
            beyondBoundsPageCount2 = i2;
            $composer2 = $composer3;
            reverseLayout2 = reverseLayout;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                contentPadding2 = i11 != 0 ? PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0)) : contentPadding;
                PageSize pageSize4 = i12 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                int beyondBoundsPageCount3 = i13 != 0 ? 0 : i2;
                float pageSpacing3 = i14 != 0 ? Dp.m5218constructorimpl(0) : pageSpacing;
                Alignment.Vertical verticalAlignment3 = i15 != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
                if ((i & 128) != 0) {
                    $dirty1 = $dirty13;
                    $composer2 = $composer3;
                    i5 = i3;
                    i6 = i4;
                    i7 = 1491175841;
                    i8 = i18;
                    flingBehavior2 = PagerDefaults.INSTANCE.m693flingBehaviorPfoAEA0(state, null, null, null, null, 0.0f, 0.0f, $composer3, ($dirty & 14) | 12582912, 126);
                    $dirty &= -29360129;
                } else {
                    $dirty1 = $dirty13;
                    $composer2 = $composer3;
                    i5 = i3;
                    i6 = i4;
                    i7 = 1491175841;
                    i8 = i18;
                    flingBehavior2 = flingBehavior;
                }
                boolean userScrollEnabled3 = i5 != 0 ? true : userScrollEnabled;
                boolean reverseLayout3 = i6 != 0 ? false : reverseLayout;
                Function1 key2 = $dirty4 != 0 ? null : function1;
                if (i8 != 0) {
                    int i19 = $dirty1 & (-113);
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    key = key2;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Horizontal);
                    $dirty12 = i19;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                } else {
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    key = key2;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    verticalAlignment2 = verticalAlignment3;
                    $dirty2 = $dirty;
                    $dirty12 = $dirty1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if (i18 != 0) {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key = function1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty12 = $dirty13 & (-113);
                    verticalAlignment2 = vertical;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i7 = 1491175841;
                    reverseLayout2 = reverseLayout;
                } else {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key = function1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty12 = $dirty13;
                    verticalAlignment2 = vertical;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i7 = 1491175841;
                    reverseLayout2 = reverseLayout;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i7, $dirty2, $dirty12, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:105)");
            }
            LazyLayoutPagerKt.m689Pagerfs30GE4(modifier3, state, contentPadding2, reverseLayout2, Orientation.Horizontal, flingBehavior3, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key, Alignment.INSTANCE.getCenterHorizontally(), verticalAlignment2, pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 << 3) & 112) | ($dirty2 & 896) | (($dirty2 >> 18) & 7168) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016) | (($dirty2 << 9) & 29360128) | (($dirty2 << 9) & 234881024) | (($dirty2 << 18) & 1879048192), (($dirty12 << 3) & 112) | 392 | (($dirty2 >> 9) & 7168) | (($dirty12 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final PaddingValues paddingValues = contentPadding2;
        final PageSize pageSize5 = pageSize3;
        final int i20 = beyondBoundsPageCount2;
        final float f = pageSpacing2;
        final Alignment.Vertical vertical2 = verticalAlignment2;
        final SnapFlingBehavior snapFlingBehavior = flingBehavior3;
        final boolean z = userScrollEnabled2;
        final boolean z2 = reverseLayout2;
        final Function1 function12 = key;
        final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$1
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

            public final void invoke(Composer composer, int i21) {
                PagerKt.m695HorizontalPagerxYaah8o(PagerState.this, modifier5, paddingValues, pageSize5, i20, f, vertical2, snapFlingBehavior, z, z2, function12, nestedScrollConnection, pageContent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @ReplaceWith(expression = "HorizontalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* renamed from: HorizontalPager-AlbwjTQ, reason: not valid java name */
    public static final void m694HorizontalPagerAlbwjTQ(final int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Vertical verticalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PagerState state2;
        PageSize pageSize2;
        int i2;
        SnapFlingBehavior snapFlingBehavior;
        int i3;
        int i4;
        int i5;
        int $dirty;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        PagerState state3;
        PaddingValues contentPadding2;
        PageSize.Fill pageSize3;
        int beyondBoundsPageCount2;
        float pageSpacing2;
        Alignment.Vertical verticalAlignment2;
        SnapFlingBehavior flingBehavior2;
        int $dirty2;
        NestedScrollConnection pageNestedScrollConnection2;
        int $dirty1;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        boolean reverseLayout2;
        Function1 key;
        Object value$iv$iv;
        SnapFlingBehavior flingBehavior4;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        PaddingValues contentPadding3;
        PageSize pageSize4;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Vertical verticalAlignment3;
        Modifier modifier3;
        PagerState state4;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer $composer2 = $composer.startRestartGroup(1817327312);
        ComposerKt.sourceInformation($composer2, "C(HorizontalPager)P(6,4,11,1,8!1,9:c#ui.unit.Dp,13!1,12,10!1,7)215@11194L13,215@11175L32,221@11495L28,230@11845L620:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(pageCount) ? 4 : 2;
        }
        int i13 = i & 2;
        if (i13 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                state2 = state;
                if ($composer2.changed(state2)) {
                    i12 = 256;
                    $dirty3 |= i12;
                }
            } else {
                state2 = state;
            }
            i12 = 128;
            $dirty3 |= i12;
        } else {
            state2 = state;
        }
        int i14 = i & 8;
        if (i14 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        int i15 = i & 16;
        if (i15 != 0) {
            $dirty3 |= 24576;
            pageSize2 = pageSize;
        } else if (($changed & 57344) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer2.changed(pageSize2) ? 16384 : 8192;
        } else {
            pageSize2 = pageSize;
        }
        int i16 = i & 32;
        if (i16 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer2.changed(beyondBoundsPageCount) ? 131072 : 65536;
        }
        int i17 = i & 64;
        if (i17 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changed(pageSpacing) ? 1048576 : 524288;
        }
        int i18 = i & 128;
        if (i18 != 0) {
            $dirty3 |= 12582912;
            i2 = i18;
        } else if (($changed & 29360128) == 0) {
            i2 = i18;
            $dirty3 |= $composer2.changed(verticalAlignment) ? 8388608 : 4194304;
        } else {
            i2 = i18;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                snapFlingBehavior = flingBehavior;
                if ($composer2.changed(snapFlingBehavior)) {
                    i11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty3 |= i11;
                }
            } else {
                snapFlingBehavior = flingBehavior;
            }
            i11 = 33554432;
            $dirty3 |= i11;
        } else {
            snapFlingBehavior = flingBehavior;
        }
        int i19 = i & 512;
        if (i19 != 0) {
            $dirty3 |= 805306368;
            i3 = i19;
        } else if (($changed & 1879048192) == 0) {
            i3 = i19;
            $dirty3 |= $composer2.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i19;
        }
        int i20 = i & 1024;
        if (i20 != 0) {
            $dirty12 |= 6;
            i4 = i20;
        } else if (($changed1 & 14) == 0) {
            i4 = i20;
            $dirty12 |= $composer2.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i20;
        }
        int i21 = i & 2048;
        if (i21 != 0) {
            $dirty12 |= 48;
            i5 = i21;
        } else if (($changed1 & 112) == 0) {
            i5 = i21;
            $dirty12 |= $composer2.changedInstance(function1) ? 32 : 16;
        } else {
            i5 = i21;
        }
        int i22 = i & 4096;
        if (i22 != 0) {
            $dirty12 |= 128;
        }
        if ((i & 8192) != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changedInstance(pageContent) ? 2048 : 1024;
        }
        int $dirty13 = $dirty12;
        if (i22 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty13 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentPadding3 = contentPadding;
            beyondBoundsPageCount3 = beyondBoundsPageCount;
            pageSpacing3 = pageSpacing;
            verticalAlignment3 = verticalAlignment;
            userScrollEnabled3 = userScrollEnabled;
            reverseLayout3 = reverseLayout;
            key = function1;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            flingBehavior4 = snapFlingBehavior;
            pageSize4 = pageSize2;
            modifier3 = modifier2;
            state4 = state2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    Object key1$iv = Integer.valueOf(pageCount);
                    int i23 = $dirty3 & 14;
                    int $dirty4 = $dirty3;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(key1$iv);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = it$iv$iv;
                        $composer2.endReplaceableGroup();
                        i6 = i22;
                        i7 = i2;
                        i8 = i5;
                        i9 = i4;
                        i10 = i3;
                        state3 = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) value$iv$iv, $composer2, 0, 3);
                        $dirty = $dirty4 & (-897);
                    }
                    value$iv$iv = (Function0) new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            return Integer.valueOf(pageCount);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv);
                    $composer2.endReplaceableGroup();
                    i6 = i22;
                    i7 = i2;
                    i8 = i5;
                    i9 = i4;
                    i10 = i3;
                    state3 = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) value$iv$iv, $composer2, 0, 3);
                    $dirty = $dirty4 & (-897);
                } else {
                    $dirty = $dirty3;
                    i6 = i22;
                    i7 = i2;
                    i8 = i5;
                    i9 = i4;
                    i10 = i3;
                    state3 = state2;
                }
                contentPadding2 = i14 != 0 ? PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0)) : contentPadding;
                pageSize3 = i15 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                beyondBoundsPageCount2 = i16 != 0 ? 0 : beyondBoundsPageCount;
                pageSpacing2 = i17 != 0 ? Dp.m5218constructorimpl(0) : pageSpacing;
                verticalAlignment2 = i7 != 0 ? Alignment.INSTANCE.getCenterVertically() : verticalAlignment;
                if ((i & 256) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.m693flingBehaviorPfoAEA0(state3, null, null, null, null, 0.0f, 0.0f, $composer2, (($dirty >> 6) & 14) | 12582912, 126);
                    $dirty &= -234881025;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                boolean userScrollEnabled4 = i10 != 0 ? true : userScrollEnabled;
                boolean reverseLayout4 = i9 != 0 ? false : reverseLayout;
                Function1 key2 = i8 != 0 ? null : function1;
                if (i6 != 0) {
                    PagerState state5 = state3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty13 & (-897);
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Horizontal);
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled4;
                    reverseLayout2 = reverseLayout4;
                    key = key2;
                    state2 = state5;
                } else {
                    PagerState state6 = state3;
                    $dirty2 = $dirty;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled4;
                    reverseLayout2 = reverseLayout4;
                    key = key2;
                    state2 = state6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i22 != 0) {
                    $dirty13 &= -897;
                }
                contentPadding2 = contentPadding;
                pageSpacing2 = pageSpacing;
                reverseLayout2 = reverseLayout;
                key = function1;
                pageNestedScrollConnection2 = pageNestedScrollConnection;
                $dirty1 = $dirty13;
                $dirty2 = $dirty3;
                flingBehavior3 = snapFlingBehavior;
                pageSize3 = pageSize2;
                beyondBoundsPageCount2 = beyondBoundsPageCount;
                verticalAlignment2 = verticalAlignment;
                userScrollEnabled2 = userScrollEnabled;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1817327312, $dirty2, $dirty1, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:212)");
            }
            LazyLayoutPagerKt.m689Pagerfs30GE4(modifier2, state2, contentPadding2, reverseLayout2, Orientation.Horizontal, flingBehavior3, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key, Alignment.INSTANCE.getCenterHorizontally(), verticalAlignment2, pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty1 << 9) & 7168) | (($dirty2 >> 9) & 458752) | (($dirty2 >> 9) & 3670016) | (($dirty2 << 6) & 29360128) | (($dirty2 << 6) & 234881024) | (($dirty2 << 15) & 1879048192), ($dirty1 & 112) | 392 | (($dirty2 >> 12) & 7168) | (($dirty1 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            flingBehavior4 = flingBehavior3;
            userScrollEnabled3 = userScrollEnabled2;
            reverseLayout3 = reverseLayout2;
            contentPadding3 = contentPadding2;
            pageSize4 = pageSize3;
            beyondBoundsPageCount3 = beyondBoundsPageCount2;
            pageSpacing3 = pageSpacing2;
            verticalAlignment3 = verticalAlignment2;
            modifier3 = modifier2;
            state4 = state2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final PagerState pagerState = state4;
        final PaddingValues paddingValues = contentPadding3;
        final PageSize pageSize5 = pageSize4;
        final int i24 = beyondBoundsPageCount3;
        final float f = pageSpacing3;
        final Alignment.Vertical vertical = verticalAlignment3;
        final SnapFlingBehavior snapFlingBehavior2 = flingBehavior4;
        final boolean z = userScrollEnabled3;
        final boolean z2 = reverseLayout3;
        final Function1 function12 = key;
        final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$3
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

            public final void invoke(Composer composer, int i25) {
                PagerKt.m694HorizontalPagerAlbwjTQ(pageCount, modifier4, pagerState, paddingValues, pageSize5, i24, f, vertical, snapFlingBehavior2, z, z2, function12, nestedScrollConnection, pageContent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* renamed from: VerticalPager-xYaah8o, reason: not valid java name */
    public static final void m697VerticalPagerxYaah8o(final PagerState state, Modifier modifier, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PageSize pageSize2;
        int i2;
        Alignment.Horizontal horizontal;
        int i3;
        int i4;
        int $dirty;
        PaddingValues contentPadding2;
        int $dirty1;
        Composer $composer2;
        int i5;
        int i6;
        int i7;
        int i8;
        SnapFlingBehavior flingBehavior2;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        Function1 key;
        int beyondBoundsPageCount2;
        Alignment.Horizontal horizontalAlignment2;
        int $dirty2;
        int $dirty12;
        NestedScrollConnection pageNestedScrollConnection2;
        boolean reverseLayout2;
        Modifier modifier3;
        float pageSpacing2;
        PageSize pageSize3;
        int i9;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer $composer3 = $composer.startRestartGroup(-1457068767);
        ComposerKt.sourceInformation($composer3, "C(VerticalPager)P(11,5,1,8!1,9:c#ui.unit.Dp,3!1,12,10!1,7)299@15710L28,308@16058L618:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty13 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer3.changed(state) ? 4 : 2;
        }
        int i10 = i & 2;
        if (i10 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i11 = i & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 896) == 0) {
            $dirty3 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        int i12 = i & 8;
        if (i12 != 0) {
            $dirty3 |= 3072;
            pageSize2 = pageSize;
        } else if (($changed & 7168) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer3.changed(pageSize2) ? 2048 : 1024;
        } else {
            pageSize2 = pageSize;
        }
        int i13 = i & 16;
        if (i13 != 0) {
            $dirty3 |= 24576;
            i2 = beyondBoundsPageCount;
        } else if (($changed & 57344) == 0) {
            i2 = beyondBoundsPageCount;
            $dirty3 |= $composer3.changed(i2) ? 16384 : 8192;
        } else {
            i2 = beyondBoundsPageCount;
        }
        int i14 = i & 32;
        if (i14 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer3.changed(pageSpacing) ? 131072 : 65536;
        }
        int i15 = i & 64;
        if (i15 != 0) {
            $dirty3 |= 1572864;
            horizontal = horizontalAlignment;
        } else if (($changed & 3670016) == 0) {
            horizontal = horizontalAlignment;
            $dirty3 |= $composer3.changed(horizontal) ? 1048576 : 524288;
        } else {
            horizontal = horizontalAlignment;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer3.changed(flingBehavior)) {
                i9 = 8388608;
                $dirty3 |= i9;
            }
            i9 = 4194304;
            $dirty3 |= i9;
        }
        int i16 = i & 256;
        if (i16 != 0) {
            $dirty3 |= 100663296;
            i3 = i16;
        } else if (($changed & 234881024) == 0) {
            i3 = i16;
            $dirty3 |= $composer3.changed(userScrollEnabled) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            i3 = i16;
        }
        int i17 = i & 512;
        if (i17 != 0) {
            $dirty = $dirty3 | 805306368;
            i4 = i17;
        } else {
            if (($changed & 1879048192) == 0) {
                i4 = i17;
                $dirty3 |= $composer3.changed(reverseLayout) ? 536870912 : 268435456;
            } else {
                i4 = i17;
            }
            $dirty = $dirty3;
        }
        int $dirty4 = i & 1024;
        if ($dirty4 != 0) {
            $dirty13 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty13 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        int i18 = i & 2048;
        if (i18 != 0) {
            $dirty13 |= 16;
        }
        if ((i & 4096) != 0) {
            $dirty13 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty13 |= $composer3.changedInstance(pageContent) ? 256 : 128;
        }
        if (i18 == 2048 && ($dirty & 1533916891) == 306783378 && ($dirty13 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            contentPadding2 = contentPadding;
            pageSpacing2 = pageSpacing;
            flingBehavior3 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            key = function1;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            horizontalAlignment2 = horizontal;
            modifier3 = modifier2;
            pageSize3 = pageSize2;
            beyondBoundsPageCount2 = i2;
            $composer2 = $composer3;
            reverseLayout2 = reverseLayout;
        } else {
            $composer3.startDefaults();
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                contentPadding2 = i11 != 0 ? PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0)) : contentPadding;
                PageSize pageSize4 = i12 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                int beyondBoundsPageCount3 = i13 != 0 ? 0 : i2;
                float pageSpacing3 = i14 != 0 ? Dp.m5218constructorimpl(0) : pageSpacing;
                Alignment.Horizontal horizontalAlignment3 = i15 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontal;
                if ((i & 128) != 0) {
                    $dirty1 = $dirty13;
                    $composer2 = $composer3;
                    i5 = i3;
                    i6 = i4;
                    i7 = -1457068767;
                    i8 = i18;
                    flingBehavior2 = PagerDefaults.INSTANCE.m693flingBehaviorPfoAEA0(state, null, null, null, null, 0.0f, 0.0f, $composer3, ($dirty & 14) | 12582912, 126);
                    $dirty &= -29360129;
                } else {
                    $dirty1 = $dirty13;
                    $composer2 = $composer3;
                    i5 = i3;
                    i6 = i4;
                    i7 = -1457068767;
                    i8 = i18;
                    flingBehavior2 = flingBehavior;
                }
                boolean userScrollEnabled3 = i5 != 0 ? true : userScrollEnabled;
                boolean reverseLayout3 = i6 != 0 ? false : reverseLayout;
                Function1 key2 = $dirty4 != 0 ? null : function1;
                if (i8 != 0) {
                    int i19 = $dirty1 & (-113);
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    key = key2;
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Vertical);
                    $dirty12 = i19;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                } else {
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled3;
                    key = key2;
                    beyondBoundsPageCount2 = beyondBoundsPageCount3;
                    horizontalAlignment2 = horizontalAlignment3;
                    $dirty2 = $dirty;
                    $dirty12 = $dirty1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    reverseLayout2 = reverseLayout3;
                    modifier3 = modifier4;
                    pageSpacing2 = pageSpacing3;
                    pageSize3 = pageSize4;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty &= -29360129;
                }
                if (i18 != 0) {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key = function1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty12 = $dirty13 & (-113);
                    horizontalAlignment2 = horizontal;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i7 = -1457068767;
                    reverseLayout2 = reverseLayout;
                } else {
                    contentPadding2 = contentPadding;
                    pageSpacing2 = pageSpacing;
                    flingBehavior3 = flingBehavior;
                    userScrollEnabled2 = userScrollEnabled;
                    key = function1;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty12 = $dirty13;
                    horizontalAlignment2 = horizontal;
                    modifier3 = modifier2;
                    pageSize3 = pageSize2;
                    beyondBoundsPageCount2 = i2;
                    $composer2 = $composer3;
                    $dirty2 = $dirty;
                    i7 = -1457068767;
                    reverseLayout2 = reverseLayout;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i7, $dirty2, $dirty12, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:291)");
            }
            LazyLayoutPagerKt.m689Pagerfs30GE4(modifier3, state, contentPadding2, reverseLayout2, Orientation.Vertical, flingBehavior3, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key, horizontalAlignment2, Alignment.INSTANCE.getCenterVertically(), pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 << 3) & 112) | ($dirty2 & 896) | (($dirty2 >> 18) & 7168) | (($dirty2 >> 6) & 458752) | (($dirty2 >> 6) & 3670016) | (($dirty2 << 9) & 29360128) | (($dirty2 << 9) & 234881024) | (($dirty2 << 18) & 1879048192), (($dirty12 << 3) & 112) | 3080 | (($dirty2 >> 12) & 896) | (($dirty12 << 6) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        final PaddingValues paddingValues = contentPadding2;
        final PageSize pageSize5 = pageSize3;
        final int i20 = beyondBoundsPageCount2;
        final float f = pageSpacing2;
        final Alignment.Horizontal horizontal2 = horizontalAlignment2;
        final SnapFlingBehavior snapFlingBehavior = flingBehavior3;
        final boolean z = userScrollEnabled2;
        final boolean z2 = reverseLayout2;
        final Function1 function12 = key;
        final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$1
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

            public final void invoke(Composer composer, int i21) {
                PagerKt.m697VerticalPagerxYaah8o(PagerState.this, modifier5, paddingValues, pageSize5, i20, f, horizontal2, snapFlingBehavior, z, z2, function12, nestedScrollConnection, pageContent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use the overload without pageCount. pageCount should be provided through PagerState.", replaceWith = @ReplaceWith(expression = "VerticalPager(\n            modifier = modifier,\n            state = state,\n            pageSpacing = pageSpacing,\n            horizontalAlignment = horizontalAlignment,\n            userScrollEnabled = userScrollEnabled,\n            reverseLayout = reverseLayout,\n            contentPadding = contentPadding,\n            beyondBoundsPageCount = beyondBoundsPageCount,\n            pageSize = pageSize,\n            flingBehavior = flingBehavior,\n            key = key,\n            pageNestedScrollConnection = pageNestedScrollConnection,\n            pageContent = pageContent\n        )", imports = {"androidx.compose.foundation.gestures.Orientation", "androidx.compose.foundation.layout.PaddingValues", "androidx.compose.foundation.pager.PageSize", "androidx.compose.foundation.pager.PagerDefaults"}))
    /* renamed from: VerticalPager-AlbwjTQ, reason: not valid java name */
    public static final void m696VerticalPagerAlbwjTQ(final int pageCount, Modifier modifier, PagerState state, PaddingValues contentPadding, PageSize pageSize, int beyondBoundsPageCount, float pageSpacing, Alignment.Horizontal horizontalAlignment, SnapFlingBehavior flingBehavior, boolean userScrollEnabled, boolean reverseLayout, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection pageNestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer $composer, final int $changed, final int $changed1, final int i) {
        Modifier modifier2;
        PagerState state2;
        PageSize pageSize2;
        int i2;
        SnapFlingBehavior snapFlingBehavior;
        int i3;
        int i4;
        int i5;
        int $dirty;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        PagerState state3;
        PaddingValues contentPadding2;
        PageSize.Fill pageSize3;
        int beyondBoundsPageCount2;
        float pageSpacing2;
        Alignment.Horizontal horizontalAlignment2;
        SnapFlingBehavior flingBehavior2;
        int $dirty2;
        NestedScrollConnection pageNestedScrollConnection2;
        int $dirty1;
        SnapFlingBehavior flingBehavior3;
        boolean userScrollEnabled2;
        boolean reverseLayout2;
        Function1 key;
        Object value$iv$iv;
        SnapFlingBehavior flingBehavior4;
        boolean userScrollEnabled3;
        boolean reverseLayout3;
        PaddingValues contentPadding3;
        PageSize pageSize4;
        int beyondBoundsPageCount3;
        float pageSpacing3;
        Alignment.Horizontal horizontalAlignment3;
        Modifier modifier3;
        PagerState state4;
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer $composer2 = $composer.startRestartGroup(-1904588400);
        ComposerKt.sourceInformation($composer2, "C(VerticalPager)P(7,5,12,1,9!1,10:c#ui.unit.Dp,3!1,13,11!1,8)400@20798L13,400@20779L32,406@21105L28,415@21453L618:Pager.kt#g6yjnt");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty3 |= $composer2.changed(pageCount) ? 4 : 2;
        }
        int i13 = i & 2;
        if (i13 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                state2 = state;
                if ($composer2.changed(state2)) {
                    i12 = 256;
                    $dirty3 |= i12;
                }
            } else {
                state2 = state;
            }
            i12 = 128;
            $dirty3 |= i12;
        } else {
            state2 = state;
        }
        int i14 = i & 8;
        if (i14 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty3 |= $composer2.changed(contentPadding) ? 2048 : 1024;
        }
        int i15 = i & 16;
        if (i15 != 0) {
            $dirty3 |= 24576;
            pageSize2 = pageSize;
        } else if (($changed & 57344) == 0) {
            pageSize2 = pageSize;
            $dirty3 |= $composer2.changed(pageSize2) ? 16384 : 8192;
        } else {
            pageSize2 = pageSize;
        }
        int i16 = i & 32;
        if (i16 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty3 |= $composer2.changed(beyondBoundsPageCount) ? 131072 : 65536;
        }
        int i17 = i & 64;
        if (i17 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty3 |= $composer2.changed(pageSpacing) ? 1048576 : 524288;
        }
        int i18 = i & 128;
        if (i18 != 0) {
            $dirty3 |= 12582912;
            i2 = i18;
        } else if (($changed & 29360128) == 0) {
            i2 = i18;
            $dirty3 |= $composer2.changed(horizontalAlignment) ? 8388608 : 4194304;
        } else {
            i2 = i18;
        }
        if (($changed & 234881024) == 0) {
            if ((i & 256) == 0) {
                snapFlingBehavior = flingBehavior;
                if ($composer2.changed(snapFlingBehavior)) {
                    i11 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    $dirty3 |= i11;
                }
            } else {
                snapFlingBehavior = flingBehavior;
            }
            i11 = 33554432;
            $dirty3 |= i11;
        } else {
            snapFlingBehavior = flingBehavior;
        }
        int i19 = i & 512;
        if (i19 != 0) {
            $dirty3 |= 805306368;
            i3 = i19;
        } else if (($changed & 1879048192) == 0) {
            i3 = i19;
            $dirty3 |= $composer2.changed(userScrollEnabled) ? 536870912 : 268435456;
        } else {
            i3 = i19;
        }
        int i20 = i & 1024;
        if (i20 != 0) {
            $dirty12 |= 6;
            i4 = i20;
        } else if (($changed1 & 14) == 0) {
            i4 = i20;
            $dirty12 |= $composer2.changed(reverseLayout) ? 4 : 2;
        } else {
            i4 = i20;
        }
        int i21 = i & 2048;
        if (i21 != 0) {
            $dirty12 |= 48;
            i5 = i21;
        } else if (($changed1 & 112) == 0) {
            i5 = i21;
            $dirty12 |= $composer2.changedInstance(function1) ? 32 : 16;
        } else {
            i5 = i21;
        }
        int i22 = i & 4096;
        if (i22 != 0) {
            $dirty12 |= 128;
        }
        if ((i & 8192) != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty12 |= $composer2.changedInstance(pageContent) ? 2048 : 1024;
        }
        int $dirty13 = $dirty12;
        if (i22 == 4096 && (1533916891 & $dirty3) == 306783378 && ($dirty13 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            contentPadding3 = contentPadding;
            beyondBoundsPageCount3 = beyondBoundsPageCount;
            pageSpacing3 = pageSpacing;
            horizontalAlignment3 = horizontalAlignment;
            userScrollEnabled3 = userScrollEnabled;
            reverseLayout3 = reverseLayout;
            key = function1;
            pageNestedScrollConnection2 = pageNestedScrollConnection;
            flingBehavior4 = snapFlingBehavior;
            pageSize4 = pageSize2;
            modifier3 = modifier2;
            state4 = state2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i & 4) != 0) {
                    Object key1$iv = Integer.valueOf(pageCount);
                    int i23 = $dirty3 & 14;
                    int $dirty4 = $dirty3;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(key1$iv);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (!invalid$iv$iv && it$iv$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = it$iv$iv;
                        $composer2.endReplaceableGroup();
                        i6 = i22;
                        i7 = i2;
                        i8 = i5;
                        i9 = i4;
                        i10 = i3;
                        state3 = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) value$iv$iv, $composer2, 0, 3);
                        $dirty = $dirty4 & (-897);
                    }
                    value$iv$iv = (Function0) new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            return Integer.valueOf(pageCount);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv);
                    $composer2.endReplaceableGroup();
                    i6 = i22;
                    i7 = i2;
                    i8 = i5;
                    i9 = i4;
                    i10 = i3;
                    state3 = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) value$iv$iv, $composer2, 0, 3);
                    $dirty = $dirty4 & (-897);
                } else {
                    $dirty = $dirty3;
                    i6 = i22;
                    i7 = i2;
                    i8 = i5;
                    i9 = i4;
                    i10 = i3;
                    state3 = state2;
                }
                contentPadding2 = i14 != 0 ? PaddingKt.m477PaddingValues0680j_4(Dp.m5218constructorimpl(0)) : contentPadding;
                pageSize3 = i15 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                beyondBoundsPageCount2 = i16 != 0 ? 0 : beyondBoundsPageCount;
                pageSpacing2 = i17 != 0 ? Dp.m5218constructorimpl(0) : pageSpacing;
                horizontalAlignment2 = i7 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontalAlignment;
                if ((i & 256) != 0) {
                    flingBehavior2 = PagerDefaults.INSTANCE.m693flingBehaviorPfoAEA0(state3, null, null, null, null, 0.0f, 0.0f, $composer2, (($dirty >> 6) & 14) | 12582912, 126);
                    $dirty &= -234881025;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                boolean userScrollEnabled4 = i10 != 0 ? true : userScrollEnabled;
                boolean reverseLayout4 = i9 != 0 ? false : reverseLayout;
                Function1 key2 = i8 != 0 ? null : function1;
                if (i6 != 0) {
                    PagerState state5 = state3;
                    $dirty2 = $dirty;
                    $dirty1 = $dirty13 & (-897);
                    pageNestedScrollConnection2 = PagerDefaults.INSTANCE.pageNestedScrollConnection(Orientation.Vertical);
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled4;
                    reverseLayout2 = reverseLayout4;
                    key = key2;
                    state2 = state5;
                } else {
                    PagerState state6 = state3;
                    $dirty2 = $dirty;
                    pageNestedScrollConnection2 = pageNestedScrollConnection;
                    $dirty1 = $dirty13;
                    flingBehavior3 = flingBehavior2;
                    userScrollEnabled2 = userScrollEnabled4;
                    reverseLayout2 = reverseLayout4;
                    key = key2;
                    state2 = state6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if (i22 != 0) {
                    $dirty13 &= -897;
                }
                contentPadding2 = contentPadding;
                pageSpacing2 = pageSpacing;
                reverseLayout2 = reverseLayout;
                key = function1;
                pageNestedScrollConnection2 = pageNestedScrollConnection;
                $dirty1 = $dirty13;
                $dirty2 = $dirty3;
                flingBehavior3 = snapFlingBehavior;
                pageSize3 = pageSize2;
                beyondBoundsPageCount2 = beyondBoundsPageCount;
                horizontalAlignment2 = horizontalAlignment;
                userScrollEnabled2 = userScrollEnabled;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904588400, $dirty2, $dirty1, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:397)");
            }
            LazyLayoutPagerKt.m689Pagerfs30GE4(modifier2, state2, contentPadding2, reverseLayout2, Orientation.Vertical, flingBehavior3, userScrollEnabled2, beyondBoundsPageCount2, pageSpacing2, pageSize3, pageNestedScrollConnection2, key, horizontalAlignment2, Alignment.INSTANCE.getCenterVertically(), pageContent, $composer2, (($dirty2 >> 3) & 14) | 24576 | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896) | (($dirty1 << 9) & 7168) | (($dirty2 >> 9) & 458752) | (($dirty2 >> 9) & 3670016) | (($dirty2 << 6) & 29360128) | (($dirty2 << 6) & 234881024) | (($dirty2 << 15) & 1879048192), ($dirty1 & 112) | 3080 | (($dirty2 >> 15) & 896) | (($dirty1 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            flingBehavior4 = flingBehavior3;
            userScrollEnabled3 = userScrollEnabled2;
            reverseLayout3 = reverseLayout2;
            contentPadding3 = contentPadding2;
            pageSize4 = pageSize3;
            beyondBoundsPageCount3 = beyondBoundsPageCount2;
            pageSpacing3 = pageSpacing2;
            horizontalAlignment3 = horizontalAlignment2;
            modifier3 = modifier2;
            state4 = state2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final PagerState pagerState = state4;
        final PaddingValues paddingValues = contentPadding3;
        final PageSize pageSize5 = pageSize4;
        final int i24 = beyondBoundsPageCount3;
        final float f = pageSpacing3;
        final Alignment.Horizontal horizontal = horizontalAlignment3;
        final SnapFlingBehavior snapFlingBehavior2 = flingBehavior4;
        final boolean z = userScrollEnabled3;
        final boolean z2 = reverseLayout3;
        final Function1 function12 = key;
        final NestedScrollConnection nestedScrollConnection = pageNestedScrollConnection2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$3
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

            public final void invoke(Composer composer, int i25) {
                PagerKt.m696VerticalPagerAlbwjTQ(pageCount, modifier4, pagerState, paddingValues, pageSize5, i24, f, horizontal, snapFlingBehavior2, z, z2, function12, nestedScrollConnection, pageContent, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final DecayAnimationSpec<Float> decayAnimationSpec, final float snapPositionalThreshold) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1
            public final PagerLayoutInfo getLayoutInfo() {
                return PagerState.this.getLayoutInfo$foundation_release();
            }

            public final boolean isValidDistance(float $this$isValidDistance) {
                if (!($this$isValidDistance == Float.POSITIVE_INFINITY)) {
                    if (!($this$isValidDistance == Float.NEGATIVE_INFINITY)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(Density $this$calculateSnappingOffset, float currentVelocity) {
                boolean isForward;
                float dragGestureDelta;
                float finalDistance;
                Intrinsics.checkNotNullParameter($this$calculateSnappingOffset, "<this>");
                float lowerBoundOffset = Float.NEGATIVE_INFINITY;
                List $this$fastForEach$iv = getLayoutInfo().getVisiblePagesInfo();
                int size = $this$fastForEach$iv.size();
                float upperBoundOffset = Float.POSITIVE_INFINITY;
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Object item$iv = $this$fastForEach$iv.get(index$iv);
                    PageInfo page = (PageInfo) item$iv;
                    float offset = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffset, PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), page.getOffset(), page.getIndex(), PagerStateKt.getSnapAlignmentStartToStart());
                    if (offset <= 0.0f && offset > lowerBoundOffset) {
                        lowerBoundOffset = offset;
                    }
                    if (offset >= 0.0f && offset < upperBoundOffset) {
                        upperBoundOffset = offset;
                    }
                }
                isForward = PagerKt.isScrollingForward(PagerState.this);
                dragGestureDelta = PagerKt.dragGestureDelta(PagerState.this);
                float offsetFromSnappedPosition = dragGestureDelta / getLayoutInfo().getPageSize();
                float offsetFromSnappedPositionOverflow = offsetFromSnappedPosition - ((int) offsetFromSnappedPosition);
                float signum = Math.signum(currentVelocity);
                if (signum == 0.0f) {
                    finalDistance = Math.abs(offsetFromSnappedPositionOverflow) <= snapPositionalThreshold ? upperBoundOffset : upperBoundOffset;
                } else if (!(signum == 1.0f)) {
                    if (!(signum == -1.0f)) {
                        finalDistance = 0.0f;
                    }
                    finalDistance = lowerBoundOffset;
                }
                if (isValidDistance(finalDistance)) {
                    return finalDistance;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
                Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
                return getLayoutInfo().getPageSize();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
                int firstVisiblePage$foundation_release;
                Object it$iv;
                float floor;
                float signum;
                Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
                int effectivePageSizePx = PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release();
                float animationOffsetPx = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, initialVelocity);
                if (initialVelocity < 0.0f) {
                    firstVisiblePage$foundation_release = PagerState.this.getFirstVisiblePage$foundation_release() + 1;
                } else {
                    firstVisiblePage$foundation_release = PagerState.this.getFirstVisiblePage$foundation_release();
                }
                int startPage = firstVisiblePage$foundation_release;
                List $this$fastFirstOrNull$iv = getLayoutInfo().getVisiblePagesInfo();
                int index$iv$iv = 0;
                int size = $this$fastFirstOrNull$iv.size();
                while (true) {
                    if (index$iv$iv < size) {
                        Object item$iv$iv = $this$fastFirstOrNull$iv.get(index$iv$iv);
                        it$iv = item$iv$iv;
                        PageInfo it = (PageInfo) it$iv;
                        if (it.getIndex() == startPage) {
                            break;
                        }
                        index$iv$iv++;
                    } else {
                        it$iv = null;
                        break;
                    }
                }
                PageInfo pageInfo = (PageInfo) it$iv;
                int scrollOffset = pageInfo != null ? pageInfo.getOffset() : 0;
                int $i$f$debugLog = startPage * effectivePageSizePx;
                float targetOffsetPx = $i$f$debugLog + animationOffsetPx;
                float targetPageValue = targetOffsetPx / effectivePageSizePx;
                if (initialVelocity > 0.0f) {
                    floor = (float) Math.ceil(targetPageValue);
                } else {
                    floor = (float) Math.floor(targetPageValue);
                }
                int targetPage = RangesKt.coerceIn((int) floor, 0, PagerState.this.getPageCount());
                int correctedTargetPage = RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(startPage, targetPage, initialVelocity, PagerState.this.getPageSize$foundation_release(), PagerState.this.getPageSpacing$foundation_release()), 0, PagerState.this.getPageCount());
                int $i$f$debugLog2 = correctedTargetPage - startPage;
                int proposedFlingOffset = $i$f$debugLog2 * effectivePageSizePx;
                int $i$f$debugLog3 = Math.abs(proposedFlingOffset);
                int flingApproachOffsetPx = RangesKt.coerceAtLeast($i$f$debugLog3 - Math.abs(scrollOffset), 0);
                if (flingApproachOffsetPx == 0) {
                    signum = flingApproachOffsetPx;
                } else {
                    signum = flingApproachOffsetPx * Math.signum(initialVelocity);
                }
                return signum;
            }
        };
    }

    public static final Modifier pagerSemantics(Modifier $this$pagerSemantics, final PagerState state, final boolean isVertical, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$pagerSemantics, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        $composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation($composer, "C(pagerSemantics)P(1)843@38529L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, $changed, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:842)");
        }
        $composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv$iv = $composer.rememberedValue();
        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
            $composer.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
        final CoroutineScope scope = wrapper$iv.getCoroutineScope();
        $composer.endReplaceableGroup();
        Modifier then = $this$pagerSemantics.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1
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
                if (isVertical) {
                    final PagerState pagerState = state;
                    final CoroutineScope coroutineScope = scope;
                    SemanticsPropertiesKt.pageUp$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performBackwardPaging;
                            pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope);
                            return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                        }
                    }, 1, null);
                    final PagerState pagerState2 = state;
                    final CoroutineScope coroutineScope2 = scope;
                    SemanticsPropertiesKt.pageDown$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performForwardPaging;
                            pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope2);
                            return Boolean.valueOf(pagerSemantics$performForwardPaging);
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState3 = state;
                final CoroutineScope coroutineScope3 = scope;
                SemanticsPropertiesKt.pageLeft$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performBackwardPaging;
                        pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope3);
                        return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                    }
                }, 1, null);
                final PagerState pagerState4 = state;
                final CoroutineScope coroutineScope4 = scope;
                SemanticsPropertiesKt.pageRight$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performForwardPaging;
                        pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope4);
                        return Boolean.valueOf(pagerSemantics$performForwardPaging);
                    }
                }, 1, null);
            }
        }, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState $state, CoroutineScope scope) {
        if ($state.getCanScrollForward()) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1($state, null), 3, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState $state, CoroutineScope scope) {
        if ($state.getCanScrollBackward()) {
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1($state, null), 3, null);
            return true;
        }
        return false;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState $this$isScrollingForward) {
        return dragGestureDelta($this$isScrollingForward) < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState $this$dragGestureDelta) {
        if ($this$dragGestureDelta.getLayoutInfo$foundation_release().getOrientation() == Orientation.Horizontal) {
            return Offset.m2710getXimpl($this$dragGestureDelta.m705getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m2711getYimpl($this$dragGestureDelta.m705getUpDownDifferenceF1C5BW0$foundation_release());
    }
}
