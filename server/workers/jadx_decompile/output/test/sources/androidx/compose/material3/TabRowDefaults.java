package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\f*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "Landroidx/compose/ui/unit/Dp;", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();

    private TabRowDefaults() {
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-2026555673);
        ComposerKt.sourceInformation($composer, "C367@16033L9:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:366)");
        }
        long color = ColorSchemeKt.toColor(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return color;
    }

    public final long getContentColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1163072359);
        ComposerKt.sourceInformation($composer, "C371@16195L9:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:370)");
        }
        long color = ColorSchemeKt.toColor(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m1827Indicator9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f;
        long color2;
        Modifier.Companion modifier3;
        float height2;
        Modifier modifier4;
        float height3;
        long color3;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(1454716052);
        ComposerKt.sourceInformation($composer2, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)386@16682L11,388@16769L142:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            f = height;
        } else if (($changed & 112) == 0) {
            f = height;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = height;
        }
        if (($changed & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                color2 = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            color2 = color;
        }
        if (($dirty & 731) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
            height3 = f;
            color3 = color2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                height2 = i4 != 0 ? PrimaryNavigationTabTokens.INSTANCE.m2412getActiveIndicatorHeightD9Ej5fM() : f;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    color2 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme($composer2, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
                height2 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1454716052, $changed, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:382)");
            }
            BoxKt.Box(BackgroundKt.m163backgroundbw27NRU$default(SizeKt.m517height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), height2), color2, null, 2, null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            height3 = height2;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier4;
        final float f2 = height3;
        final long j = color3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$Indicator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                TabRowDefaults.this.m1827Indicator9IZ8Weo(modifier5, f2, j, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public final Modifier tabIndicatorOffset(Modifier $this$tabIndicatorOffset, final TabPosition currentTabPosition) {
        Intrinsics.checkNotNullParameter($this$tabIndicatorOffset, "<this>");
        Intrinsics.checkNotNullParameter(currentTabPosition, "currentTabPosition");
        return ComposedModifierKt.composed($this$tabIndicatorOffset, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("tabIndicatorOffset");
                $this$null.setValue(TabPosition.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            private static final float invoke$lambda$0(State<Dp> state) {
                Object thisObj$iv = state.getValue();
                return ((Dp) thisObj$iv).m5232unboximpl();
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-1541271084);
                ComposerKt.sourceInformation($composer, "C411@17597L165,415@17794L164:TabRow.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1541271084, $changed, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:410)");
                }
                State currentTabWidth$delegate = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(TabPosition.this.getWidth(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, $composer, 0, 12);
                State indicatorOffset$delegate = AnimateAsStateKt.m84animateDpAsStateAjpBEmI(TabPosition.this.getLeft(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, $composer, 0, 12);
                Modifier m536width3ABfNKs = SizeKt.m536width3ABfNKs(OffsetKt.m445offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(composed, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null), invoke$lambda$1(indicatorOffset$delegate), 0.0f, 2, null), invoke$lambda$0(currentTabWidth$delegate));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return m536width3ABfNKs;
            }

            private static final float invoke$lambda$1(State<Dp> state) {
                Object thisObj$iv = state.getValue();
                return ((Dp) thisObj$iv).m5232unboximpl();
            }
        });
    }
}
