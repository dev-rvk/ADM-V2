package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001eJÓ\u0001\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\"2\b\b\u0002\u0010(\u001a\u00020\"2\b\b\u0002\u0010)\u001a\u00020\"2\b\b\u0002\u0010*\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020\"2\b\b\u0002\u0010,\u001a\u00020\"2\b\b\u0002\u0010-\u001a\u00020\"2\b\b\u0002\u0010.\u001a\u00020\"2\b\b\u0002\u0010/\u001a\u00020\"2\b\b\u0002\u00100\u001a\u00020\"2\b\b\u0002\u00101\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020\"2\b\b\u0002\u00103\u001a\u00020\"2\b\b\u0002\u00104\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J'\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0001¢\u0006\u0004\b>\u0010?R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "DatePickerHeadline", "", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "yearContentColor", "currentYearContentColor", "selectedYearContentColor", "selectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "colors-1m2Cg-Y", "(JJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/DatePickerColors;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final IntRange YearRange = new IntRange(1900, 2100);
    private static final float TonalElevation = DatePickerModalTokens.INSTANCE.m2101getContainerElevationD9Ej5fM();

    private DatePickerDefaults() {
    }

    /* renamed from: colors-1m2Cg-Y, reason: not valid java name */
    public final DatePickerColors m1461colors1m2CgY(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long yearContentColor, long currentYearContentColor, long selectedYearContentColor, long selectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContentColor, long dayInSelectionRangeContainerColor, Composer $composer, int $changed, int $changed1, int i) {
        long titleContentColor2;
        long headlineContentColor2;
        long weekdayContentColor2;
        long subheadContentColor2;
        long yearContentColor2;
        long currentYearContentColor2;
        long selectedYearContentColor2;
        long selectedYearContainerColor2;
        long dayContentColor2;
        long disabledDayContentColor2;
        long selectedDayContentColor2;
        long disabledSelectedDayContentColor2;
        long selectedDayContainerColor2;
        long disabledSelectedDayContainerColor2;
        long todayContentColor2;
        long todayDateBorderColor2;
        long dayInSelectionRangeContentColor2;
        long dayInSelectionRangeContainerColor2;
        long m2947copywmQWz5c;
        long m2947copywmQWz5c2;
        long m2947copywmQWz5c3;
        $composer.startReplaceableGroup(543433842);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,14:c#ui.graphics.Color,8:c#ui.graphics.Color,17:c#ui.graphics.Color,13:c#ui.graphics.Color,18:c#ui.graphics.Color,1:c#ui.graphics.Color,12:c#ui.graphics.Color,11:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,7:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.graphics.Color,15:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.Color)359@16109L9,360@16203L9,361@16294L9,362@16387L9,364@16501L9,366@16618L9,367@16716L9,369@16839L9,371@16964L9,372@17059L9,375@17301L9,379@17573L9,382@17826L9,384@17940L9,386@18069L9,388@18209L9:DatePicker.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getContainerColor(), $composer, 6) : containerColor;
        if ((i & 2) == 0) {
            titleContentColor2 = titleContentColor;
        } else {
            titleContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            headlineContentColor2 = headlineContentColor;
        } else {
            headlineContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            weekdayContentColor2 = weekdayContentColor;
        } else {
            weekdayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            subheadContentColor2 = subheadContentColor;
        } else {
            subheadContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            yearContentColor2 = yearContentColor;
        } else {
            yearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            currentYearContentColor2 = currentYearContentColor;
        } else {
            currentYearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            selectedYearContentColor2 = selectedYearContentColor;
        } else {
            selectedYearContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 256) == 0) {
            selectedYearContainerColor2 = selectedYearContainerColor;
        } else {
            selectedYearContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            dayContentColor2 = dayContentColor;
        } else {
            dayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 1024) != 0) {
            m2947copywmQWz5c3 = Color.m2947copywmQWz5c(r82, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r82) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r82) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r82) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(dayContentColor2) : 0.0f);
            disabledDayContentColor2 = m2947copywmQWz5c3;
        } else {
            disabledDayContentColor2 = disabledDayContentColor;
        }
        if ((i & 2048) == 0) {
            selectedDayContentColor2 = selectedDayContentColor;
        } else {
            selectedDayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 4096) != 0) {
            m2947copywmQWz5c2 = Color.m2947copywmQWz5c(r82, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r82) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r82) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r82) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectedDayContentColor2) : 0.0f);
            disabledSelectedDayContentColor2 = m2947copywmQWz5c2;
        } else {
            disabledSelectedDayContentColor2 = disabledSelectedDayContentColor;
        }
        if ((i & 8192) == 0) {
            selectedDayContainerColor2 = selectedDayContainerColor;
        } else {
            selectedDayContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor(), $composer, 6);
        }
        if ((i & 16384) != 0) {
            m2947copywmQWz5c = Color.m2947copywmQWz5c(r82, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(r82) : 0.38f, (r12 & 2) != 0 ? Color.m2955getRedimpl(r82) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(r82) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(selectedDayContainerColor2) : 0.0f);
            disabledSelectedDayContainerColor2 = m2947copywmQWz5c;
        } else {
            disabledSelectedDayContainerColor2 = disabledSelectedDayContainerColor;
        }
        if ((32768 & i) == 0) {
            todayContentColor2 = todayContentColor;
        } else {
            todayContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), $composer, 6);
        }
        if ((65536 & i) == 0) {
            todayDateBorderColor2 = todayDateBorderColor;
        } else {
            todayDateBorderColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor(), $composer, 6);
        }
        if ((131072 & i) == 0) {
            dayInSelectionRangeContentColor2 = dayInSelectionRangeContentColor;
        } else {
            dayInSelectionRangeContentColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor(), $composer, 6);
        }
        if ((i & 262144) == 0) {
            dayInSelectionRangeContainerColor2 = dayInSelectionRangeContainerColor;
        } else {
            dayInSelectionRangeContainerColor2 = ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(543433842, $changed, $changed1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:358)");
        }
        DatePickerColors datePickerColors = new DatePickerColors(containerColor2, titleContentColor2, headlineContentColor2, weekdayContentColor2, subheadContentColor2, yearContentColor2, currentYearContentColor2, selectedYearContentColor2, selectedYearContainerColor2, dayContentColor2, disabledDayContentColor2, selectedDayContentColor2, disabledSelectedDayContentColor2, selectedDayContainerColor2, disabledSelectedDayContainerColor2, todayContentColor2, todayDateBorderColor2, dayInSelectionRangeContainerColor2, dayInSelectionRangeContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return datePickerColors;
    }

    public final void DatePickerTitle(final DatePickerState state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-1157401173);
        ComposerKt.sourceInformation($composer2, "C(DatePickerTitle)P(1):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer2.getSkipping()) {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1157401173, $dirty2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:419)");
            }
            int m1470getDisplayModejFl4v0 = state.m1470getDisplayModejFl4v0();
            if (DisplayMode.m1489equalsimpl0(m1470getDisplayModejFl4v0, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                $composer2.startReplaceableGroup(-2065111000);
                ComposerKt.sourceInformation($composer2, "422@19876L43,421@19847L123");
                TextKt.m1872Text4IGK_g(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1749getDatePickerTitleadMyvUU(), $composer2, 6), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else if (DisplayMode.m1489equalsimpl0(m1470getDisplayModejFl4v0, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                $composer2.startReplaceableGroup(-2065110842);
                ComposerKt.sourceInformation($composer2, "427@20034L42,426@20005L122");
                TextKt.m1872Text4IGK_g(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1736getDateInputTitleadMyvUU(), $composer2, 6), modifier4, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, $dirty2 & 112, 0, 131068);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(-2065110710);
                $composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1
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

            public final void invoke(Composer composer, int i3) {
                DatePickerDefaults.this.DatePickerTitle(state, modifier5, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public final void DatePickerHeadline(final DatePickerState state, final DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String headlineText;
        Object value$iv$iv;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Composer $composer3 = $composer.startRestartGroup(-1893194407);
        ComposerKt.sourceInformation($composer3, "C(DatePickerHeadline)P(2)*448@20771L15,479@22178L135,477@22089L268:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(dateFormatter) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893194407, $changed, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:442)");
            }
            StateData $this$DatePickerHeadline_u24lambda_u241 = state.getStateData();
            Locale defaultLocale = CalendarModel_androidKt.defaultLocale($composer3, 0);
            String formattedDate = DatePickerFormatter.formatDate$material3_release$default(dateFormatter, $this$DatePickerHeadline_u24lambda_u241.getSelectedStartDate().getValue(), $this$DatePickerHeadline_u24lambda_u241.getCalendarModel(), defaultLocale, false, 8, null);
            String verboseDateDescription = dateFormatter.formatDate$material3_release($this$DatePickerHeadline_u24lambda_u241.getSelectedStartDate().getValue(), $this$DatePickerHeadline_u24lambda_u241.getCalendarModel(), defaultLocale, true);
            $composer3.startReplaceableGroup(729783869);
            String str = "";
            ComposerKt.sourceInformation($composer3, "");
            if (verboseDateDescription == null) {
                int value = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().getValue();
                if (DisplayMode.m1489equalsimpl0(value, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                    $composer3.startReplaceableGroup(933108990);
                    ComposerKt.sourceInformation($composer3, "460@21322L51");
                    verboseDateDescription = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1740getDatePickerNoSelectionDescriptionadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                } else if (DisplayMode.m1489equalsimpl0(value, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                    $composer3.startReplaceableGroup(933109079);
                    ComposerKt.sourceInformation($composer3, "461@21411L46");
                    verboseDateDescription = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1735getDateInputNoInputDescriptionadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                } else {
                    $composer3.startReplaceableGroup(-1138387422);
                    $composer3.endReplaceableGroup();
                    verboseDateDescription = "";
                }
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(729784366);
            ComposerKt.sourceInformation($composer3, "");
            if (formattedDate == null) {
                int value2 = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().getValue();
                if (DisplayMode.m1489equalsimpl0(value2, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                    $composer3.startReplaceableGroup(933109281);
                    ComposerKt.sourceInformation($composer3, "466@21613L37");
                    String m1785getStringNWtq28 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1737getDatePickerHeadlineadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                    headlineText = m1785getStringNWtq28;
                } else if (DisplayMode.m1489equalsimpl0(value2, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                    $composer3.startReplaceableGroup(933109356);
                    ComposerKt.sourceInformation($composer3, "467@21688L36");
                    String m1785getStringNWtq282 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1729getDateInputHeadlineadMyvUU(), $composer3, 6);
                    $composer3.endReplaceableGroup();
                    headlineText = m1785getStringNWtq282;
                } else {
                    $composer3.startReplaceableGroup(-1138379145);
                    $composer3.endReplaceableGroup();
                    headlineText = "";
                }
            } else {
                headlineText = formattedDate;
            }
            $composer3.endReplaceableGroup();
            int value3 = $this$DatePickerHeadline_u24lambda_u241.getDisplayMode().getValue().getValue();
            if (DisplayMode.m1489equalsimpl0(value3, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                $composer3.startReplaceableGroup(933109538);
                ComposerKt.sourceInformation($composer3, "472@21870L48");
                str = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1738getDatePickerHeadlineDescriptionadMyvUU(), $composer3, 6);
                $composer3.endReplaceableGroup();
            } else if (DisplayMode.m1489equalsimpl0(value3, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                $composer3.startReplaceableGroup(933109624);
                ComposerKt.sourceInformation($composer3, "473@21956L47");
                str = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1730getDateInputHeadlineDescriptionadMyvUU(), $composer3, 6);
                $composer3.endReplaceableGroup();
            } else {
                $composer3.startReplaceableGroup(-1138370496);
                $composer3.endReplaceableGroup();
            }
            final String headlineDescription = String.format(str, Arrays.copyOf(new Object[]{verboseDateDescription}, 1));
            Intrinsics.checkNotNullExpressionValue(headlineDescription, "format(this, *args)");
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(headlineDescription);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$1$1$1
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
                        SemanticsPropertiesKt.m4581setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m4560getPolite0phEisY());
                        SemanticsPropertiesKt.setContentDescription(semantics, headlineDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            Modifier modifier5 = modifier4;
            $composer2 = $composer3;
            TextKt.m1872Text4IGK_g(headlineText, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) value$iv$iv, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 3072, 122876);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier6 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2
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

            public final void invoke(Composer composer, int i3) {
                DatePickerDefaults.this.DatePickerHeadline(state, dateFormatter, modifier6, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        $composer.startReplaceableGroup(-2036003494);
        ComposerKt.sourceInformation($composer, "C(rememberSnapFlingBehavior)P(1)500@22875L7,501@22898L295:DatePicker.kt#uh7d8r");
        DecayAnimationSpec decayAnimationSpec2 = (i & 2) != 0 ? DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, $changed, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:496)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(density);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new SnapFlingBehavior(lazyListState, decayAnimationSpec2, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), density);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    public final IntRange getYearRange() {
        return YearRange;
    }

    /* renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m1462getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(700927667);
        ComposerKt.sourceInformation($composer, "C518@23583L9:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, $changed, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:518)");
        }
        Shape shape = ShapesKt.toShape(DatePickerModalTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}
